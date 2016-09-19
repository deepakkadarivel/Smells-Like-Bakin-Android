package com.upbeat.smellslikebakin;

public class GridAdapter extends RecyclerAdapter {

    private final GridFragment.onRecipeSelectedInterface mOnRecipeSelectedInterface;

    public GridAdapter(GridFragment.onRecipeSelectedInterface onRecipeSelectedInterface) {
        mOnRecipeSelectedInterface = onRecipeSelectedInterface;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.grid_item;
    }

    @Override
    protected void onRecipeSelected(int index) {
        mOnRecipeSelectedInterface.onGridRecipeSelected(index);
    }
}
