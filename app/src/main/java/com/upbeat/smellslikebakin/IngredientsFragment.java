package com.upbeat.smellslikebakin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class IngredientsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        int index = getArguments().getInt(ViewPagerFragment.KEY_RECIPE_INDEX);
        View view = inflater.inflate(R.layout.fragment_ingredients, container, false);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ingredientsLayout);

        String[] ingredients = Recipes.ingredients[index].split("`");
        setupCheckbox(linearLayout, ingredients);
        return view;
    }

    private void setupCheckbox(ViewGroup linearLayout, String[] ingredients) {
        for (String ingredient : ingredients) {
            CheckBox checkBox = new CheckBox(getActivity());
            checkBox.setPadding(8,12,8,12);
            checkBox.setTextSize(20f);
            checkBox.setText(ingredient);
            linearLayout.addView(checkBox);
        }
    }
}
