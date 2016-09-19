package com.upbeat.smellslikebakin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class CheckboxesFragment extends Fragment {

    private static final String KEY_CHECKBOXES = "key_checkboxes";
    private CheckBox[] mCheckBoxes;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        int index = getArguments().getInt(ViewPagerFragment.KEY_RECIPE_INDEX);
        boolean choice = getArguments().getBoolean(ViewPagerFragment.KEY_IS_CHOICES);
        View view = inflater.inflate(R.layout.fragment_checkboxes, container, false);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ingredientsLayout);

        String[] contents;
        if (choice) {
            contents = Recipes.ingredients[index].split("`");
        } else {
            contents = Recipes.directions[index].split("`");
        }
        mCheckBoxes = new CheckBox[contents.length];
        boolean[] checkBoxes = new boolean[contents.length];
        if (savedInstanceState != null && savedInstanceState.getBooleanArray(KEY_CHECKBOXES) != null) {
            checkBoxes = savedInstanceState.getBooleanArray(KEY_CHECKBOXES);
        }
        setupCheckbox(linearLayout, contents, checkBoxes);
        return view;
    }

    private void setupCheckbox(ViewGroup linearLayout, String[] ingredients, boolean[] checkBoxes) {
        int i = 0;
        for (String ingredient : ingredients) {
            mCheckBoxes[i] = new CheckBox(getActivity());
            mCheckBoxes[i].setPadding(8,12,8,12);
            mCheckBoxes[i].setTextSize(20f);
            mCheckBoxes[i].setText(ingredient);
            linearLayout.addView(mCheckBoxes[i]);
            if (checkBoxes[i]) {
                mCheckBoxes[i].toggle();
            }
            i++;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        boolean[] stateOfCheckboxes = new boolean[mCheckBoxes.length];
        int i = 0;
        for (CheckBox checkBox : mCheckBoxes) {
            stateOfCheckboxes[i] = checkBox.isChecked();
            i++;
        }
        outState.putBooleanArray(KEY_CHECKBOXES, stateOfCheckboxes);
        super.onSaveInstanceState(outState);
    }
}
