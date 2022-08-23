package recipe;

import java.io.Serializable;
import java.util.List;

public class Recipe implements Serializable {
    private int id;
    private String title;
    private List<List<String>> ingredients;
    private List<String> steps;

    public Recipe(String title, List<List<String>> ingredients, List<String> steps) {
        this.setTitle(title);
        this.setIngredients(ingredients);
        this.setSteps(steps);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().equals(""))
            throw new NullPointerException("Required: Title cannot be empty");
        this.title = title.trim();
    }

    public List<List<String>> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<List<String>> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }
}
