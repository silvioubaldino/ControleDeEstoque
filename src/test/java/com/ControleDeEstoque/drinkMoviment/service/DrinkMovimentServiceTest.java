package com.ControleDeEstoque.drinkMoviment.service;

import com.ControleDeEstoque.model.entity.drink_type.DrinkType;
import com.ControleDeEstoque.model.entity.inventory.Inventory;
import com.ControleDeEstoque.model.entity.section.Section;
import com.ControleDeEstoque.section.service.SectionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class DrinkMovimentServiceTest {

    @InjectMocks
    DrinkMovimentService drinkMovimentService;
    @Mock
    private SectionService sectionService;

    @Test
    public void getTotalVolByDrinkTypeTest() {
        Long idDrinkType = 1L;
        Inventory inventory = new Inventory();
        DrinkType drinkType = new DrinkType(1L, "alcoolico");
        List<Section> sections = Arrays.asList(new Section(
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
                        drinkType,
                        400.0,
                        150.0)
        );
        Mockito.when(sectionService.findSectionByDrinkTypeIdDrinkType(idDrinkType)).thenReturn(sections);


        Double totalVol = drinkMovimentService.getTotalVolByDrinkType(idDrinkType);

        assertEquals(500.0, totalVol, 0);
    }
}
