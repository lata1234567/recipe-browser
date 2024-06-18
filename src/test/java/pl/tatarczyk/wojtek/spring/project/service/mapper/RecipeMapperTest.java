package pl.tatarczyk.wojtek.spring.project.service.mapper;

import org.junit.jupiter.api.Test;
import pl.tatarczyk.wojtek.spring.project.api.model.RecipeDifficulty;
import pl.tatarczyk.wojtek.spring.project.repository.entity.RecipeEntity;
import pl.tatarczyk.wojtek.spring.project.web.model.RecipeModel;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecipeMapperTest {

    public static final Long RECIPE_ID = 1L;
    public static final String RECIPE_TITLE = "title";
    public static final String RECIPE_INGREDIENTS = "ingredients";
    public static final String RECIPE_LIST_OF_ACTIONS = "action";
    public static final RecipeDifficulty RECIPE_DIFFICULTY = RecipeDifficulty.EASY;

    RecipeMapper recipeMapper = new RecipeMapper();

    @Test
    void from() {
        //Given
        RecipeModel recipeModel = new RecipeModel();

        recipeModel.setId(RECIPE_ID);
        recipeModel.setTitle(RECIPE_TITLE);
        recipeModel.setIngredients(RECIPE_INGREDIENTS);
        recipeModel.setListOfActions(RECIPE_LIST_OF_ACTIONS);
        recipeModel.setDifficulty(RECIPE_DIFFICULTY);
        //When
        RecipeEntity recipeEntity = recipeMapper.from(recipeModel);
        //Then
        assertAll(
                () -> assertNotNull(recipeEntity, "recipeEntity is NULL"),
                () -> assertEquals(recipeEntity.getId(), RECIPE_ID, "recipeEntity ID is not Equal"),
                () -> assertEquals(recipeEntity.getTitle(), RECIPE_TITLE, "recipeEntity TITLE is not Equal"),
                () -> assertEquals(recipeEntity.getIngredients(), RECIPE_INGREDIENTS, "recipeEntity INGREDIENTS is not Equal"),
                () -> assertEquals(recipeEntity.getDifficulty(), RECIPE_DIFFICULTY, "recipeEntity DIFFICULTY is not Equal")

        );
    }

    @Test
    void testFrom() {
        //Given
        RecipeEntity recipeEntity = new RecipeEntity();

        recipeEntity.setId(RECIPE_ID);
        recipeEntity.setTitle(RECIPE_TITLE);
        recipeEntity.setIngredients(RECIPE_INGREDIENTS);
        recipeEntity.setListOfActions(RECIPE_LIST_OF_ACTIONS);
        recipeEntity.setDifficulty(RECIPE_DIFFICULTY);
        //When
        RecipeModel recipeModel = recipeMapper.from(recipeEntity);
        //Then
        assertAll(
                () -> assertNotNull(recipeModel, "recipeModel is NULL"),
                () -> assertEquals(recipeModel.getId(), RECIPE_ID, "recipeModel ID is not Equal"),
                () -> assertEquals(recipeModel.getTitle(), RECIPE_TITLE, "recipeModel TITLE is not Equal"),
                () -> assertEquals(recipeModel.getIngredients(), RECIPE_INGREDIENTS, "recipeModel INGREDIENTS is not Equal"),
                () -> assertEquals(recipeModel.getDifficulty(), RECIPE_DIFFICULTY, "recipeModel DIFFICULTY is not Equal")
        );

    }

    @Test
    void fromEntities() {
        //Given
        List<RecipeEntity> recipeEntities = new ArrayList<>();
        recipeEntities.add(new RecipeEntity());
        recipeEntities.add(new RecipeEntity());
        //When
        List<RecipeModel> recipeModels = recipeMapper.fromModels(recipeEntities);
        //Then
        assertAll(
                () -> assertNotNull(recipeModels, "recipeModels is NULL"),
                () -> assertEquals(recipeModels.size(), recipeEntities.size(), "models and entities size is not equals")
        );
    }

    @Test
    void fromModels() {
        //Given
        List<RecipeModel> recipeModels = new ArrayList<>();
        recipeModels.add(new RecipeModel());
        recipeModels.add(new RecipeModel());
        //When
        List<RecipeEntity> recipeEntities = recipeMapper.fromEntities(recipeModels);
        //Then
        assertAll(
                () -> assertNotNull(recipeEntities, "recipeEntities is NULL"),
                () -> assertEquals(recipeEntities.size(), recipeModels.size(), "entities and models size is not equals")
        );
    }
}