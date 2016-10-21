package com.recyclerview_list.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.recyclerview_list.R;
import com.recyclerview_list.model.Response;

import java.util.List;

/**
 * Created by Ramesh on 10/21/16.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private Context context;
    private List<Response> lists;

    public ListAdapter(List<Response> lists, Context context) {
        this.lists = lists;
        this.context = context;
    }

    public void notifyData(List<Response> lists) {
        this.lists = lists;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list, null));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_text.setText(lists.get(position).getText());
        holder.tv_timestamp.setText(lists.get(position).getTimestamp());
        holder.tv_channel.setText(lists.get(position).getChannel());
        holder.tv_type.setText(lists.get(position).getType());

    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_text,tv_timestamp,tv_channel,tv_type;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_text = (TextView) itemView.findViewById(R.id.tv_text);
            tv_timestamp = (TextView) itemView.findViewById(R.id.tv_timestamp);
            tv_channel = (TextView) itemView.findViewById(R.id.tv_channel);
            tv_type = (TextView) itemView.findViewById(R.id.tv_type);

        }
    }
}
