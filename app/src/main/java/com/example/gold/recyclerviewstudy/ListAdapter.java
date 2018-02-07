package com.example.gold.recyclerviewstudy;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by gold on 2018. 2. 7..
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    Context mContext;
    int[] datas;
    List<ListData> listData;

    public ListAdapter(Context context, int[] datas) {
        mContext = context;
        this.datas = datas;
    }

    public ListAdapter(Context context, List<ListData> datas) {
        mContext = context;
        this.listData = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (position == 0) {
            ((DisplayLeakConnectorView) holder.itemView.findViewById(R.id.dlc_view)).setType(DisplayLeakConnectorView.Type.START);
        } else if (position == listData.size() - 1) {
            ((DisplayLeakConnectorView) holder.itemView.findViewById(R.id.dlc_view)).setType(DisplayLeakConnectorView.Type.END);
        } else {
            ((DisplayLeakConnectorView) holder.itemView.findViewById(R.id.dlc_view)).setType(DisplayLeakConnectorView.Type.NODE);
        }

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);

        }

    }
}
