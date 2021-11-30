package com.ControleDeEstoque.section.service;

import com.ControleDeEstoque.drinkType.service.DrinkTypeService;
import com.ControleDeEstoque.model.entity.drink_type.DrinkType;
import com.ControleDeEstoque.model.entity.inventory.Inventory;
import com.ControleDeEstoque.model.entity.section.Section;
import com.ControleDeEstoque.section.repository.SectionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SectionServiceTest {

    @InjectMocks
    private SectionService sectionService;
    @Mock
    private DrinkTypeService drinkTypeService;
    @Mock
    private SectionRepository sectionRepository;

    public List<Section> getSections() {
        Inventory inventory = new Inventory();
        DrinkType drinkType = new DrinkType(1L, "Alcoolico");
        DrinkType drinkType2 = new DrinkType(2L, "Nao alcoolico");
        return asList(new Section(
                        1L,
                        inventory,
                        drinkType,
                        500.0,
                        150.0),
                new Section(2L,
                        inventory,
                        drinkType,
                        500.0,
                        200.0),
                new Section(3L,
                        inventory,
                        drinkType2,
                        400.0,
                        150.0),
                new Section(4L,
                        inventory,
                        drinkType2,
                        400.0,
                        150.0),
                new Section(5L,
                        inventory,
                        null,
                        0.0,
                        0.0));
    }

    @Test
    public void updateCapacityTest() {
        DrinkType drinkType = new DrinkType(1L, "Alcoolico");
        DrinkType drinkType2 = new DrinkType(2L, "Não Alcoolico");
        Section section = new Section();
        section.setDrinkType(drinkType);

        sectionService.updateCapacity(section, drinkType2);

        assertEquals(400.0, section.getCapacity(),0);
    }

    @Test
    public void findSectionsToInsertTest() {
        List<Section> sections = getSections();
        Long idDrinkType = sections.get(0).getDrinkType().getIdDrinkType();

        when(drinkTypeService.findById(idDrinkType)).thenReturn(sections.get(0).getDrinkType());
        when(sectionRepository.findAll()).thenReturn(sections);

        List<Section> sectionsToInsert = sectionService.findSectionsToInsert(idDrinkType, 200d);

        List<Section> expected = asList(sections.get(0), sections.get(1), sections.get(4));
        assertEquals(expected, sectionsToInsert);
    }
}
