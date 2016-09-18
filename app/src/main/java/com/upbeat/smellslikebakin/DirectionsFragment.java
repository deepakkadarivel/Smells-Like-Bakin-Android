package com.upbeat.smellslikebakin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class DirectionsFragment extends Fragment {
    private CheckBox[] mCheckBoxes;
    public static final String KEY_CHECKBOXES = "key_checkboxes";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int index = getArguments().getInt(ViewPagerFragment.KEY_RECIPE_INDEX);
        View view = inflater.inflate(R.layout.fragment_directions, container, false);

        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.directionsLayout);
        String[] directions = Recipes.directions[index].split("`");
        mCheckBoxes = new CheckBox[directions.length];
        boolean[] checkBoxes = new boolean[directions.length];

        if (savedInstanceState != null && savedInstanceState.getBooleanArray(KEY_CHECKBOXES) != null) {
            checkBoxes = savedInstanceState.getBooleanArray(KEY_CHECKBOXES);
        }
        setupCheckbox(linearLayout, directions, checkBoxes);

        return view;
    }

    private void setupCheckbox(ViewGroup linearLayout, String[] directions, boolean[] checkBoxes) {
        int i = 0;
        for (String direction : directions) {
            mCheckBoxes[i] = new CheckBox(getActivity());
            mCheckBoxes[i].setText(direction);
            mCheckBoxes[i].setTextSize(20f);
            mCheckBoxes[i].setPadding(8, 12, 8, 12);
            linearLayout.addView(mCheckBoxes[i]);
            if (checkBoxes[i]) {
                mCheckBoxes[i].toggle();
            }
            i++;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        int i = 0;
        boolean[] stateOfCheckBoxes = new boolean[mCheckBoxes.length];
        for (CheckBox checkBox : mCheckBoxes) {
            stateOfCheckBoxes[i] = checkBox.isChecked();
            i++;
        }
        outState.putBooleanArray(KEY_CHECKBOXES, stateOfCheckBoxes);
        super.onSaveInstanceState(outState);
    }
}
