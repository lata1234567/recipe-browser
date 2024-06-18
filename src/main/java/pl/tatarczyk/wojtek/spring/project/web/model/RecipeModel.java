package pl.tatarczyk.wojtek.spring.project.web.model;

import pl.tatarczyk.wojtek.spring.project.api.model.RecipeDifficulty;

public class RecipeModel {
    private Long id;
    private String title;
    private String ingredients;
    private String listOfActions;
    private RecipeDifficulty difficulty;

    public RecipeModel() {
    }

    public RecipeModel(Long id, String title, String ingredients, String listOfActions, RecipeDifficulty difficulty) {
        this.id = id;
        this.title = title;
        this.ingredients = ingredients;
        this.listOfActions = listOfActions;
        this.difficulty = difficulty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getListOfActions() {
        return listOfActions;
    }

    public void setListOfActions(String listOfActions) {
        this.listOfActions = listOfActions;
    }

    public RecipeDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(RecipeDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "RecipeModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", listOfActions='" + listOfActions + '\'' +
                ", difficulty=" + difficulty +
                '}';
    }
}
