package com.upbeat.smellslikebakin;

public class ListAdapter extends RecyclerAdapter {

    private final ListFragment.onRecipeSelectedInterface mOnRecipeSelectedInterface;

    public ListAdapter(ListFragment.onRecipeSelectedInterface onRecipeSelectedInterface) {
        mOnRecipeSelectedInterface = onRecipeSelectedInterface;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.list_item;
    }

    @Override
    protected void onRecipeSelected(int index) {
        mOnRecipeSelectedInterface.onListRecipeSelected(index);
    }
}
