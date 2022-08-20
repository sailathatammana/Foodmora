package generateWeek;

import recipe.Recipe;

import java.io.Serializable;
import java.util.List;

public class UserWeek implements Serializable {
    private int weekNo;
    private List<Recipe> recipes;

    public UserWeek(int weekNo, List<Recipe> recipes) {
        this.weekNo = weekNo;
        this.recipes = recipes;
    }

    public int getWeekNo() {
        return weekNo;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }
}