package recipe;

import java.util.ArrayList;

public class RecipeList {
    private ArrayList<Recipe> recipe;

    public RecipeList(ArrayList<Recipe> recipe) {
        this.recipe = recipe;}

    public void displayRecipesList(){
        if (recipe.size( ) > 0) {
            System.out.println("ID" + "  " + "Title");
        } else {
            System.out.println("task list is empty" );
        }
        for (Recipe recipe1 : recipe)
            System.out.println(recipe.indexOf(recipe1)+1 +"   " + recipe1.getTitle( ));
    }
}
