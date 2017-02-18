package com.loadersample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by karthikeyan on 18/2/17.
 */

public class LoaderAdapter extends RecyclerView.Adapter<LoaderAdapter.ItemHolder> {

    private ArrayList<String> mDataLst;

    LoaderAdapter(ArrayList<String> dataLst) {

        mDataLst = dataLst;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.loader_item, parent, false);
        ItemHolder holder = new ItemHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {

        holder.tvTitle.setText(mDataLst.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataLst.size();
    }


    static class ItemHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;

        public ItemHolder(View view) {
            super(view);
            tvTitle = (TextView) view.findViewById(R.id.tv_title);
        }
    }


    public void swapData(ArrayList<String> dataLst) {
        mDataLst = dataLst;
        notifyDataSetChanged();
    }
}
