package com.ControleDeEstoque.drinkMoviment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ControleDeEstoque.drink.service.DrinkService;
import com.ControleDeEstoque.drinkMoviment.DTO.DrinkMovimentDTO;
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

	public Iterable<DrinkMoviment> findAll() {
		return drinkMovimentRepository.findAll();
	}

	public DrinkMoviment findById(Long idMov) {
		return drinkMovimentRepository.findById(idMov).get();
	}

	public List<DrinkMoviment> findByInventory(Long idDrink) {
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
			drinkMoviments.add(drinkMovimentRepository.findOneByDrink(drink));
		}
		return drinkMoviments;
	}

	public List<Section> findSectionsToInsert (DrinkType drinkType, Double volumeMov) throws Exception {
		List<Section> allSections = sectionService.findAll();
		List<Section> sectionsToInsert= new ArrayList<>();
		for(Section section: allSections) {
			DrinkType eachDrinkType = section.getDrinkType();
			if(eachDrinkType == null) {
				if (volumeMov <= sectionService.getCapacity(drinkType)) {
					sectionsToInsert.add(section);
				}
			}else if(eachDrinkType == drinkType){				
				if(volumeMov <= sectionService.getFree(section)) {
					sectionsToInsert.add(section);
				}				
			}
		}
		if(sectionsToInsert.size() == 0) {
			throw new Exception("Nenhuma seção tem espaço para " + volumeMov);
		}
		return sectionsToInsert;
	}
	
	public List<Section> findSectionsToRemove (DrinkType drinkType, Double volumeMov) throws Exception {
		List<Section> allSections = sectionService.findAll();
		List<Section> sectionsToRemove= new ArrayList<>();
		for(Section section: allSections) {
			DrinkType eachDrinkType = section.getDrinkType();
			if(eachDrinkType == drinkType){				
				if(volumeMov <= section.getBusy()) {
					sectionsToRemove.add(section);
				}				
			}
		}
		if(sectionsToRemove.size() == 0) {
			throw new Exception("Nenhuma seção tem " + volumeMov + " da bebida '" + drinkType.getDrinkType() + "' para retirar.");
		}
		return sectionsToRemove;
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
				throw new Exception("O espaço disponivel na seção " + section.getIdSection() + " é: "
						+ sectionService.getCapacity(drink.getDrinkType()) + ".");
			}

		} else if (section.getDrinkType() == drinkMoviment.getDrink().getDrinkType()) {
			if (drinkMoviment.getVolumeMov() <= sectionService.getFree(section)) {
				savedDrinkMoviment = save(drinkMoviment);

			} else {
				throw new Exception("O espaço disponivel na seção " + section.getIdSection() + " é: "
						+ sectionService.getFree(section) + ".");
			}

		} else {
			throw new Exception("Não é possivel incluir este tipo de bebida nessa seção.");
		}

		return savedDrinkMoviment;
	}

	public DrinkMoviment save(DrinkMoviment drinkMoviment) {
		drinkMoviment.setMovimentType("Entrada");
		sectionService.updateBusy(drinkMoviment.getSection(), drinkMoviment.getVolumeMov());
		return drinkMovimentRepository.save(drinkMoviment);
	}

	public void updateSection(Section section, DrinkType drinkType) {
		sectionService.updateDrinkType(section, drinkType);
		sectionService.updateCapacity(section, drinkType);
	}

	public void deleteByDrink(DrinkMovimentDTO drinkMovimentDTO) throws Exception {
		Drink drink = drinkService.findById(drinkMovimentDTO.getIdDrink());
		Section section = sectionService.findById(drinkMovimentDTO.getIdSection());
		DrinkMoviment drinkMoviment = drinkMovimentDTO.mappDelete(drink, section, drinkMovimentDTO);
		drinkMoviment.setMovimentType("Saída");

		if (Double.compare(drinkMoviment.getVolumeMov(), section.getBusy()) < 0){
			if (drinkMoviment.getVolumeMov() > 0) {
				sectionService.updateBusy(section, drinkMoviment.getVolumeMov() * -1);
			}else {
				sectionService.updateBusy(section, drinkMoviment.getVolumeMov());
			}
			drinkMovimentRepository.save(drinkMoviment);

		} else if (Double.compare(drinkMoviment.getVolumeMov(), section.getBusy()) == 0) {
			if (drinkMoviment.getVolumeMov() > 0) {
				sectionService.updateBusy(section, drinkMoviment.getVolumeMov() * -1);
			}else {
				sectionService.updateBusy(section, drinkMoviment.getVolumeMov());
			}
			drinkMovimentRepository.save(drinkMoviment);
			updateSection(section, null);
		} else {
			throw new Exception("A quantidade de bebidas na seção " + drinkMoviment.getSection().getIdSection() + " é: "
					+ section.getBusy() + ".");
		}
	}	
}
