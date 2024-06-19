package pl.tatarczyk.wojtek.spring.project.service;

import org.springframework.stereotype.Service;
import pl.tatarczyk.wojtek.spring.project.api.exception.RecipeNotFoundException;
import pl.tatarczyk.wojtek.spring.project.repository.RecipeRepository;
import pl.tatarczyk.wojtek.spring.project.repository.entity.RecipeEntity;
import pl.tatarczyk.wojtek.spring.project.service.mapper.RecipeMapper;
import pl.tatarczyk.wojtek.spring.project.web.model.RecipeModel;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class RecipeService {
    private final static Logger LOGGER = Logger.getLogger(RecipeService.class.getName());

    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;

    public RecipeService(RecipeRepository recipeRepository, RecipeMapper recipeMapper) {
        this.recipeRepository = recipeRepository;
        this.recipeMapper = recipeMapper;
    }

    public RecipeModel create(RecipeModel recipeModel) {
        LOGGER.info("create(" + recipeModel + ")");

        RecipeEntity mappedEntity = recipeMapper.from(recipeModel);
        RecipeEntity savedRecipeEntity = recipeRepository.save(mappedEntity);
        RecipeModel mappedRecipeModel = recipeMapper.from(savedRecipeEntity);

        LOGGER.info("create(...) = " + mappedRecipeModel);
        return mappedRecipeModel;
    }

    public RecipeModel read(Long id) throws RecipeNotFoundException {
        LOGGER.info("read(" + id + ")");

        Optional<RecipeEntity> optionalRecipeEntity = recipeRepository.findById(id);
        RecipeEntity recipeEntity = optionalRecipeEntity.orElseThrow(
                () -> new RecipeNotFoundException("Not found recipe with id: " + id)
        );
        RecipeModel recipeModel = recipeMapper.from(recipeEntity);
        LOGGER.info("read(...) = " + recipeModel);
        return recipeModel;
    }

    public RecipeModel update(RecipeModel recipeModel) {
        LOGGER.info("update(" + recipeModel + ")");

        RecipeEntity mappedRecipeEntity = recipeMapper.from(recipeModel);
        RecipeEntity updateRecipeModel = recipeRepository.save(mappedRecipeEntity);
        RecipeModel mappedRecipeModel = recipeMapper.from(updateRecipeModel);

        LOGGER.info("update(...) = " + mappedRecipeModel);
        return mappedRecipeModel;
    }

    public void delete(Long id) {
        LOGGER.info("delete(" + id + ")");
        recipeRepository.deleteById(id);
    }
}
