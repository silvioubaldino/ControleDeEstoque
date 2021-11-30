package com.ControleDeEstoque.drinkMoviment.service;

import com.ControleDeEstoque.drink.service.DrinkService;
import com.ControleDeEstoque.drinkMoviment.DTO.DrinkMovimentDTO;
import com.ControleDeEstoque.drinkMoviment.ennumerator.MovimentType;
import com.ControleDeEstoque.drinkMoviment.exception.DrinkMovimentException;
import com.ControleDeEstoque.drinkMoviment.exception.MovimentTypeException;
import com.ControleDeEstoque.drinkMoviment.exception.OrderByException;
import com.ControleDeEstoque.drinkMoviment.repository.DrinkMovimentRepository;
import com.ControleDeEstoque.drinkType.service.DrinkTypeService;
import com.ControleDeEstoque.model.entity.drink_moviment.DrinkMoviment;
import com.ControleDeEstoque.model.entity.drink_type.DrinkType;
import com.ControleDeEstoque.model.entity.section.Section;
import com.ControleDeEstoque.section.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkMovimentService {

	@Autowired
	private DrinkMovimentRepository drinkMovimentRepository;
	@Autowired
	private DrinkService drinkService;
	@Autowired
	private SectionService sectionService;
	@Autowired
	private DrinkTypeService drinkTypeService;

	public List<DrinkMoviment> findAll(String params) {
		try {
			return drinkMovimentRepository.findAll(Sort.by(Sort.Direction.ASC, params));
		} catch (Exception e) {
			throw new OrderByException();
		}
	}

	public DrinkMoviment findById(Long idMov) {
		return drinkMovimentRepository.findById(idMov).orElseThrow(DrinkMovimentException::new);
	}

	public List<DrinkMoviment> findByDrink(Long idDrink) {
		return drinkMovimentRepository.findByDrinkIdDrink(idDrink);
	}

	public List<DrinkMoviment> findBySection(Long idSection) {
		return drinkMovimentRepository.findBySectionIdSection(idSection);
	}

	public List<DrinkMoviment> findByDrinkType(Long idDrinkType) {
		return drinkMovimentRepository.findByDrinkTypeIdDrinkType(idDrinkType);
	}

	public List<DrinkMoviment> findByMovimentType(String movimentTypeString) {
		try {
			MovimentType movimentType = MovimentType.valueOf(movimentTypeString.toUpperCase());
			return drinkMovimentRepository.findByMovimentType(movimentType);
		} catch (Exception e) {
			throw new MovimentTypeException();
		}
	}

	public Double getTotalVolByDrinkType(Long idDrinkType) {
		List<Section> sectionList = sectionService.findSectionByDrinkTypeIdDrinkType(idDrinkType);
		return sectionList.stream()
				.mapToDouble(Section::getBusy)
				.sum();
	}

	public DrinkMoviment validDrinkMoviment(DrinkMovimentDTO drinkMovimentDTO) {
		DrinkMoviment drinkMoviment = drinkMovimentDTO.mapp(
				drinkService.findById(drinkMovimentDTO.getIdDrink()),
				drinkTypeService.findById(drinkMovimentDTO.getIdDrinkType()),
				sectionService.findById(drinkMovimentDTO.getIdSection()),
				drinkMovimentDTO);

		Double free = sectionService.calcFree(drinkMoviment.getSection(), drinkMoviment.getDrinkType());
		if (drinkMoviment.getDrink().getDrinkType() != drinkMoviment.getDrinkType()){
			throw new DrinkMovimentException(drinkMoviment.getDrink(), drinkMoviment.getDrinkType());

		} else if (drinkMoviment.getSection().getDrinkType() != null && drinkMoviment.getDrinkType() != drinkMoviment.getSection().getDrinkType()){
			throw new DrinkMovimentException(MovimentType.ENTRADA);

		} else if (drinkMoviment.getVolumeMov() > free) {
			throw new DrinkMovimentException(drinkMoviment.getSection().getIdSection(),
					sectionService.calcCapacity(drinkMoviment.getDrink().getDrinkType()));
		} else {
			return prepareToSave(drinkMoviment);
		}
	}

	public DrinkMoviment prepareToSave(DrinkMoviment drinkMoviment) {
		drinkMoviment.setMovimentType(MovimentType.ENTRADA);
		drinkMoviment.setSection(updateSection(drinkMoviment.getSection(), drinkMoviment.getDrinkType(), drinkMoviment.getVolumeMov()));
		return drinkMoviment;
	}

	public DrinkMoviment save(DrinkMoviment drinkMoviment) {
		return drinkMovimentRepository.save(drinkMoviment);
	}

	public Section updateSection(Section section, DrinkType drinkType, Double volumeMov) {
		section = sectionService.updateBusy(section, volumeMov);
		section = sectionService.updateCapacity(section, drinkType);
		section = sectionService.updateDrinkType(section, drinkType);
		return section;
	}

	public DrinkMoviment removeByDrink(DrinkMovimentDTO drinkMovimentDTO) {
		DrinkMoviment drinkMoviment = drinkMovimentDTO.mapp(
				drinkService.findById(drinkMovimentDTO.getIdDrink()),
				drinkTypeService.findById(drinkMovimentDTO.getIdDrinkType()),
				sectionService.findById(drinkMovimentDTO.getIdSection()),
				drinkMovimentDTO);
		drinkMoviment.setMovimentType(MovimentType.SAIDA);

		if (drinkMoviment.getDrinkType() != drinkMoviment.getSection().getDrinkType()){
			throw new DrinkMovimentException(MovimentType.SAIDA);
		} else if (Double.compare(drinkMoviment.getVolumeMov(), drinkMoviment.getSection().getBusy()) > 0) {
			throw new DrinkMovimentException(drinkMoviment.getSection().getIdSection(), drinkMoviment.getSection().getBusy(), "true");

		} else {
			Double toUpdateBusy;
			if (drinkMoviment.getVolumeMov() > 0) {
				toUpdateBusy = drinkMoviment.getVolumeMov() * -1;
			} else {
				toUpdateBusy = drinkMoviment.getVolumeMov();
				drinkMoviment.setVolumeMov(drinkMoviment.getVolumeMov() * -1);
			}
			if (Double.compare(drinkMoviment.getVolumeMov(), drinkMoviment.getSection().getBusy()) == 0){
				drinkMoviment.setSection(updateSection(drinkMoviment.getSection(), null, toUpdateBusy));
			} else {
				drinkMoviment.setSection(updateSection(drinkMoviment.getSection(), drinkMoviment.getDrinkType(), toUpdateBusy));
			}
			return save(drinkMoviment);
		}
	}
}
