package pl.tatarczyk.wojtek.spring.project.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.tatarczyk.wojtek.spring.project.repository.entity.UserEntity;
import pl.tatarczyk.wojtek.spring.project.web.model.UserModel;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    private static final Logger LOGGER = Logger.getLogger(UserMapper.class.getName());

    public UserEntity from(UserModel userModel){
        LOGGER.info("form("+userModel+")");

        ModelMapper modelMapper = new ModelMapper();
        UserEntity userEntity = modelMapper.map(userModel, UserEntity.class);
        return userEntity;
    }

    public UserModel from(UserEntity userEntity){
        LOGGER.info("from("+userEntity+")");

        ModelMapper modelMapper = new ModelMapper();
        UserModel userModel = modelMapper.map(userEntity, UserModel.class);
        return userModel;
    }

    public List<UserEntity> fromEntities(List<UserModel> userModels){
        LOGGER.info("fromEntities("+userModels+")");

        return userModels.stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    public List<UserModel> fromModels(List<UserEntity> userEntities){
        LOGGER.info("fromModels("+userEntities+")");

        return userEntities.stream()
                .map(this::from)
                .collect(Collectors.toList());
    }
}
