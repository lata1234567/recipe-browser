package pl.tatarczyk.wojtek.spring.project.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.tatarczyk.wojtek.spring.project.web.model.RecipeModel;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RecipeServiceTest {

    @Autowired
    private RecipeService recipeService;

    @Test
    void create() {
        //Given
        RecipeModel recipeModel = new RecipeModel();
        //When
        RecipeModel createdRecipeModel = recipeService.create(recipeModel);
        //Then
        assertNotNull(createdRecipeModel, "createdRecipeModel is NULL");
    }

    @Test
    void update() {
        //Given
        RecipeModel recipeModel = new RecipeModel();
        //When
        RecipeModel updatedRecipeModel = recipeService.update(recipeModel);
        //Then
        assertNotNull(updatedRecipeModel, "updatedRecipeModel is NULL");
    }
}