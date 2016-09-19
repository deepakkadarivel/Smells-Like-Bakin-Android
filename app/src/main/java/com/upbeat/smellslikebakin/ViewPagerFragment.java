package com.upbeat.smellslikebakin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ViewPagerFragment extends Fragment {
    public static final String KEY_RECIPE_INDEX = "key_recipe_index";
    public static final String KEY_IS_CHOICES = "key_is_choices";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int index = getArguments().getInt(KEY_RECIPE_INDEX);
        View view = inflater.inflate(R.layout.fragment_view, container, false);
        getActivity().setTitle(Recipes.names[index]);

        final CheckboxesFragment ingredientsFragment = new CheckboxesFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_RECIPE_INDEX, index);
        bundle.putBoolean(KEY_IS_CHOICES, true);
        ingredientsFragment.setArguments(bundle);
        final CheckboxesFragment directionsFragment = new CheckboxesFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putInt(KEY_RECIPE_INDEX, index);
        bundle1.putBoolean(KEY_IS_CHOICES, false);
        directionsFragment.setArguments(bundle1);

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return position == 0 ? ingredientsFragment : directionsFragment;
            }

            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return position == 0 ? "Ingredients" : "Directions";
            }
        });

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().setTitle(getResources().getString(R.string.app_name));
    }
}
