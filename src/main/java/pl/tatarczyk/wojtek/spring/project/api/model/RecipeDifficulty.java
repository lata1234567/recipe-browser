package pl.tatarczyk.wojtek.spring.project.api.model;

public enum RecipeDifficulty {
    EASY("Easy"),
    MEDIUM("Medium"),
    HARD("Hard");

    private String name;

    RecipeDifficulty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
