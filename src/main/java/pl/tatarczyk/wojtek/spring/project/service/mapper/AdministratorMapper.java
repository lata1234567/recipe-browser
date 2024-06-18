package pl.tatarczyk.wojtek.spring.project.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.tatarczyk.wojtek.spring.project.repository.entity.AdministratorEntity;
import pl.tatarczyk.wojtek.spring.project.web.model.AdministratorModel;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class AdministratorMapper {
    private static final Logger LOGGER = Logger.getLogger(AdministratorMapper.class.getName());

    public AdministratorEntity from(AdministratorModel administratorModel){
        LOGGER.info("from("+administratorModel+")");

        ModelMapper modelMapper = new ModelMapper();
        AdministratorEntity administratorEntity = modelMapper.map(administratorModel, AdministratorEntity.class);
        return administratorEntity;
    }

    public AdministratorModel form(AdministratorEntity administratorEntity){
        LOGGER.info("from("+administratorEntity+")");

        ModelMapper modelMapper = new ModelMapper();
        AdministratorModel administratorModel = modelMapper.map(administratorEntity, AdministratorModel.class);
        return administratorModel;
    }

    public List<AdministratorEntity> fromEntities(List<AdministratorModel> administratorModels){
        LOGGER.info("fromEntities("+administratorModels+")");
        return administratorModels.stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    public List<AdministratorModel> fromModels(List<AdministratorEntity> administratorEntities){
        LOGGER.info("fromModels("+administratorEntities+")");
        return administratorEntities.stream()
                .map(this::form)
                .collect(Collectors.toList());
    }
}
