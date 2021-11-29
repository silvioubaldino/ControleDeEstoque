package com.ControleDeEstoque.section.service;

import com.ControleDeEstoque.model.entity.drink_type.DrinkType;
import com.ControleDeEstoque.model.entity.section.Section;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class SectionServiceTest {

    @InjectMocks
    private SectionService sectionService;

    @Test
    public void updateCapacityTest() {
        DrinkType drinkType = new DrinkType(1L, "Alcoolico");
        DrinkType drinkType2 = new DrinkType(2L, "Não Alcoolico");
        Section section = new Section();
        section.setDrinkType(drinkType);

        sectionService.updateCapacity(section, drinkType2);

        assertEquals(400.0, section.getCapacity(),0);
    }
}
