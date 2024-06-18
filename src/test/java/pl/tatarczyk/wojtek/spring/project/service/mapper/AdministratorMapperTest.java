package pl.tatarczyk.wojtek.spring.project.service.mapper;

import org.junit.jupiter.api.Test;
import pl.tatarczyk.wojtek.spring.project.repository.entity.AdministratorEntity;
import pl.tatarczyk.wojtek.spring.project.web.model.AdministratorModel;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdministratorMapperTest {

    public static final Long ADMINISTRATOR_ID = 2L;
    public static final String ADMINISTRATOR_NICKNAME = "nickname";
    public static final String ADMINISTRATOR_PASSWORD = "password";

    AdministratorMapper administratorMapper = new AdministratorMapper();

    @Test
    void from() {
        //Given
        AdministratorModel administratorModel = new AdministratorModel();

        administratorModel.setId(ADMINISTRATOR_ID);
        administratorModel.setNickname(ADMINISTRATOR_NICKNAME);
        administratorModel.setPassword(ADMINISTRATOR_PASSWORD);
        //When
        AdministratorEntity administratorEntity = administratorMapper.from(administratorModel);
        //Then
        assertAll(
                () -> assertNotNull(administratorEntity, "administratorEntity is NULL"),
                () -> assertEquals(administratorEntity.getId(), ADMINISTRATOR_ID, "administratorEntity ID is not equal"),
                () -> assertEquals(administratorEntity.getNickname(), ADMINISTRATOR_NICKNAME, "administratorEntity NICKNAME is not equal"),
                () -> assertEquals(administratorEntity.getPassword(), ADMINISTRATOR_PASSWORD, "administratorEntity PASSWORD is not equals")
        );

    }

    @Test
    void form() {
        //Given
        AdministratorEntity administratorEntity = new AdministratorEntity();

        administratorEntity.setId(ADMINISTRATOR_ID);
        administratorEntity.setNickname(ADMINISTRATOR_NICKNAME);
        administratorEntity.setPassword(ADMINISTRATOR_PASSWORD);
        //When
        AdministratorModel administratorModel = administratorMapper.form(administratorEntity);
        //Then
        assertAll(
                () -> assertNotNull(administratorModel, "administratorModel is NULL"),
                () -> assertEquals(administratorModel.getId(), ADMINISTRATOR_ID, "administratorModel ID is not equal"),
                () -> assertEquals(administratorModel.getNickname(), ADMINISTRATOR_NICKNAME, "administratorModel NICKNAME is not equal"),
                () -> assertEquals(administratorModel.getPassword(), ADMINISTRATOR_PASSWORD, "administratorModel PASSWORD is not equals")
        );
    }

    @Test
    void fromEntities() {
        //Given
        List<AdministratorEntity> administratorEntities = new ArrayList<>();
        administratorEntities.add(new AdministratorEntity());
        administratorEntities.add(new AdministratorEntity());
        //When
        List<AdministratorModel> administratorModels = administratorMapper.fromModels(administratorEntities);
        //Then
        assertAll(
                () -> assertNotNull(administratorModels, "AdministratorModels is NULL"),
                () -> assertEquals(administratorModels.size(), administratorEntities.size(), "models and entities are not equal")
        );

    }

    @Test
    void fromModels() {
        //Given
        List<AdministratorModel> administratorModels = new ArrayList<>();
        administratorModels.add(new AdministratorModel());
        administratorModels.add(new AdministratorModel());
        //When
        List<AdministratorEntity> administratorEntities = administratorMapper.fromEntities(administratorModels);
        //Then
        assertAll(
                () -> assertNotNull(administratorEntities, "AdministratorEntities is NULL"),
                () -> assertEquals(administratorEntities.size(), administratorModels.size(), "entities and models are not equal")
        );
    }
}