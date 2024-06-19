package pl.tatarczyk.wojtek.spring.project.api.exception;

public class RecipeNotFoundException extends Exception{
    public RecipeNotFoundException(String message){
        super(message);
    }
}
