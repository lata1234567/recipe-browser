package pl.tatarczyk.wojtek.spring.project.service.mapper;

import org.junit.jupiter.api.Test;
import pl.tatarczyk.wojtek.spring.project.repository.entity.UserEntity;
import pl.tatarczyk.wojtek.spring.project.web.model.UserModel;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {

    public static final Long USER_ID = 3L;
    public static final String USER_NICKNAME = "nickname";
    public static final String USER_PASSWORD = "password";

    UserMapper userMapper = new UserMapper();

    @Test
    void from() {
        //Given
        UserModel userModel = new UserModel();

        userModel.setId(USER_ID);
        userModel.setNickname(USER_NICKNAME);
        userModel.setPassword(USER_PASSWORD);
        //When
        UserEntity userEntity = userMapper.from(userModel);
        //Then
        assertAll(
                () -> assertNotNull(userEntity, "userEntity is NULL"),
                () -> assertEquals(userEntity.getId(), USER_ID, "userEntity ID is not equal"),
                () -> assertEquals(userEntity.getNickname(), USER_NICKNAME, "userEntity NICKNAME is not equal"),
                () -> assertEquals(userEntity.getPassword(), USER_PASSWORD, "userEntity PASSWORD is not equal")
        );

    }

    @Test
    void testFrom() {
        //Given
        UserEntity userEntity = new UserEntity();

        userEntity.setId(USER_ID);
        userEntity.setNickname(USER_NICKNAME);
        userEntity.setPassword(USER_PASSWORD);
        //When
        UserModel userModel = userMapper.from(userEntity);
        //Then
        assertAll(
                () -> assertNotNull(userModel, "userModel is NULL"),
                () -> assertEquals(userModel.getId(), USER_ID, "userModel ID is not equal"),
                () -> assertEquals(userModel.getNickname(), USER_NICKNAME, "userModel NICKNAME is not equal"),
                () -> assertEquals(userModel.getPassword(), USER_PASSWORD, "userModel PASSWORD is not equal")
        );
    }

    @Test
    void fromEntities() {
        //Given
        List<UserModel> userModels = new ArrayList<>();
        userModels.add(new UserModel());
        userModels.add(new UserModel());
        //When
        List<UserEntity> userEntities = userMapper.fromEntities(userModels);
        //Then
        assertAll(
                () -> assertNotNull(userEntities, "userEntities is NULL"),
                () -> assertEquals(userEntities.size(), userModels.size(), "entities and models size is not equal")
        );
    }

    @Test
    void fromModels() {
        //Given
        List<UserEntity> userEntities = new ArrayList<>();
        userEntities.add(new UserEntity());
        userEntities.add(new UserEntity());
        //When
        List<UserModel> userModels = userMapper.fromModels(userEntities);
        //Then
        assertAll(
                () -> assertNotNull(userModels, "userModels is NULL"),
                () -> assertEquals(userModels.size(), userEntities.size(), "models and entities size is not equals")
        );
    }
}