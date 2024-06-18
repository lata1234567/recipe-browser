package pl.tatarczyk.wojtek.spring.project.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.tatarczyk.wojtek.spring.project.repository.entity.RecipeEntity;
import pl.tatarczyk.wojtek.spring.project.web.model.RecipeModel;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class RecipeMapper {
    private static final Logger LOGGER = Logger.getLogger(RecipeMapper.class.getName());

    public RecipeEntity from(RecipeModel recipeModel) {
        LOGGER.info("from(" + recipeModel + ")");

        ModelMapper modelMapper = new ModelMapper();
        RecipeEntity recipeEntity = modelMapper.map(recipeModel, RecipeEntity.class);
        return recipeEntity;
    }

    public RecipeModel from(RecipeEntity recipeEntity) {
        LOGGER.info("from(" + recipeEntity + ")");

        ModelMapper modelMapper = new ModelMapper();
        RecipeModel recipeModel = modelMapper.map(recipeEntity, RecipeModel.class);
        return recipeModel;
    }

    public List<RecipeEntity> fromEntities(List<RecipeModel> recipeModels){
        LOGGER.info("fromEntities("+recipeModels+")");
        return recipeModels.stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    public List<RecipeModel> fromModels(List<RecipeEntity> recipeEntities){
        LOGGER.info("fromEntities("+recipeEntities+")");
        return recipeEntities.stream()
                .map(this::from)
                .collect(Collectors.toList());
    }
}
