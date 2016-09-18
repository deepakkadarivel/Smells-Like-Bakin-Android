package com.upbeat.smellslikebakin;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdapter extends RecyclerView.Adapter {

    private final ListFragment.onRecipeSelectedInterface mOnRecipeSelectedInterface;

    public ListAdapter(ListFragment.onRecipeSelectedInterface onRecipeSelectedInterface) {
        mOnRecipeSelectedInterface = onRecipeSelectedInterface;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder) holder).onBind(position);
    }

    @Override
    public int getItemCount() {
        return Recipes.names.length;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mImageView;
        private TextView mTextView;
        private int mIndex;

        public ListViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.itemImage);
            mTextView  = (TextView) itemView.findViewById(R.id.itemText);
            itemView.setOnClickListener(this);
        }

        public void onBind(int index) {
            mImageView.setImageResource(Recipes.resourceIds[index]);
            mTextView.setText(Recipes.names[index]);
            mIndex = index;
        }

        @Override
        public void onClick(View view) {
            mOnRecipeSelectedInterface.onListRecipeSelected(mIndex);
        }
    }
}
