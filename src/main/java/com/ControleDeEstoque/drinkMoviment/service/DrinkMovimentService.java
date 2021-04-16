package com.ControleDeEstoque.drinkMoviment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ControleDeEstoque.drink.service.DrinkService;
import com.ControleDeEstoque.drinkMoviment.DTO.DrinkMovimentDTO;
import com.ControleDeEstoque.drinkMoviment.ennumerator.MovimentType;
import com.ControleDeEstoque.drinkMoviment.exception.DrinkMovimentException;
import com.ControleDeEstoque.drinkMoviment.repository.DrinkMovimentRepository;
import com.ControleDeEstoque.drinkType.service.DrinkTypeService;
import com.ControleDeEstoque.model.entity.drink.Drink;
import com.ControleDeEstoque.model.entity.drink_moviment.DrinkMoviment;
import com.ControleDeEstoque.model.entity.drink_type.DrinkType;
import com.ControleDeEstoque.model.entity.section.Section;
import com.ControleDeEstoque.section.service.SectionService;

@Service
public class DrinkMovimentService {

	@Autowired
	DrinkMovimentRepository drinkMovimentRepository;
	@Autowired
	DrinkService drinkService;
	@Autowired
	SectionService sectionService;
	@Autowired
	DrinkTypeService drinkTypeService;

	public List<DrinkMoviment> findAll() {
		return drinkMovimentRepository.findAll();
	}

	public DrinkMoviment findById(Long idMov) {
		return drinkMovimentRepository.findById(idMov).orElseThrow(DrinkMovimentException::new);
	}

	public List<DrinkMoviment> findByDrink(Long idDrink) {
		Drink drink = drinkService.findById(idDrink);
		return drinkMovimentRepository.findByDrink(drink);
	}

	public List<DrinkMoviment> findBySection(Long idSection) {
		Section section = sectionService.findById(idSection);
		return drinkMovimentRepository.findBySection(section);
	}

	public List<DrinkMoviment> findByDrinkType(Long idDrinkType) {
		List<Drink> drinks = drinkService.findByDrinkType(idDrinkType);
		List<DrinkMoviment> drinkMoviments = new ArrayList<>();
		for (Drink drink : drinks) {
			DrinkMoviment drinkMoviment = drinkMovimentRepository.findOneByDrink(drink);
			if (drinkMoviment != null) {
				drinkMoviments.add(drinkMovimentRepository.findOneByDrink(drink));
			}
		}
		return drinkMoviments;
	}

	public DrinkMoviment validDrinkMoviment(DrinkMovimentDTO drinkMovimentDTO) throws Exception {
		Drink drink = drinkService.findById(drinkMovimentDTO.getIdDrink());
		Section section = sectionService.findById(drinkMovimentDTO.getIdSection());
		DrinkMoviment drinkMoviment = drinkMovimentDTO.mapp(drink, section, drinkMovimentDTO);
		DrinkMoviment savedDrinkMoviment = null;

		if (section.getDrinkType() == null) {
			if (drinkMoviment.getVolumeMov() <= sectionService.getCapacity(drink.getDrinkType())) {
				savedDrinkMoviment = save(drinkMoviment);
				updateSection(section, drink.getDrinkType());

			} else {
				throw new DrinkMovimentException(section.getIdSection(), sectionService.getCapacity(drink.getDrinkType()));
			}

		} else if (section.getDrinkType() == drinkMoviment.getDrink().getDrinkType()) {
			if (drinkMoviment.getVolumeMov() <= sectionService.getFree(section)) {
				savedDrinkMoviment = save(drinkMoviment);

			} else {
				throw new DrinkMovimentException(section.getIdSection(), sectionService.getFree(section));
			}

		} else {
			throw new DrinkMovimentException(MovimentType.ENTRADA);
		}

		return savedDrinkMoviment;
	}

	public DrinkMoviment save(DrinkMoviment drinkMoviment) {
		drinkMoviment.setMovimentType(MovimentType.ENTRADA);
		sectionService.updateBusy(drinkMoviment.getSection(), drinkMoviment.getVolumeMov());
		return drinkMovimentRepository.save(drinkMoviment);
	}

	public void updateSection(Section section, DrinkType drinkType) {
		sectionService.updateDrinkType(section, drinkType);
		sectionService.updateCapacity(section, drinkType);
	}

	public DrinkMoviment deleteByDrink(DrinkMovimentDTO drinkMovimentDTO) throws Exception {
		Drink drink = drinkService.findById(drinkMovimentDTO.getIdDrink());
		Section section = sectionService.findById(drinkMovimentDTO.getIdSection());
		DrinkMoviment drinkMoviment = drinkMovimentDTO.mappDelete(drink, section, drinkMovimentDTO);
		drinkMoviment.setMovimentType(MovimentType.SAIDA);

		if (Double.compare(drinkMoviment.getVolumeMov(), section.getBusy()) < 0) {
			if (drinkMoviment.getVolumeMov() > 0) {
				sectionService.updateBusy(section, drinkMoviment.getVolumeMov() * -1);
			} else {
				sectionService.updateBusy(section, drinkMoviment.getVolumeMov());
			}
			return drinkMovimentRepository.save(drinkMoviment);

		} else if (Double.compare(drinkMoviment.getVolumeMov(), section.getBusy()) == 0) {
			if (drinkMoviment.getVolumeMov() > 0) {
				sectionService.updateBusy(section, drinkMoviment.getVolumeMov() * -1);
			} else {
				sectionService.updateBusy(section, drinkMoviment.getVolumeMov());
			}
			updateSection(section, null);
			return drinkMovimentRepository.save(drinkMoviment);
		} else {
			throw new DrinkMovimentException(section.getIdSection(), section.getBusy());
		}
	}
}
