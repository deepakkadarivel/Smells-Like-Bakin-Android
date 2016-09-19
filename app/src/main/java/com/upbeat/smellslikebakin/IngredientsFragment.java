package com.upbeat.smellslikebakin;

public class IngredientsFragment extends CheckboxesFragment {
    @Override
    public String[] getContents(int index) {
        return Recipes.ingredients[index].split("`");
    }
}
