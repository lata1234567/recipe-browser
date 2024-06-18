package pl.tatarczyk.wojtek.spring.project.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.tatarczyk.wojtek.spring.project.api.model.RecipeDifficulty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeModel {
    private Long id;
    private String title;
    private String ingredients;
    private String listOfActions;
    private RecipeDifficulty difficulty;
}
