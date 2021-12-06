package com.nsg.glo3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    ArrayList<recomand> items = new ArrayList<recomand>();
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.recyclermenu, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        recomand item = items.get(position);
        holder.setItem(item);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(recomand item){
        items.add(item);
    }
    public void setItems(ArrayList<recomand> items){
        this.items = items;
    }
    public recomand getItem(int position){
        return items.get(position);
    }
    public void setItem(int position, recomand item){
        items.set(position,item);
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView title_mv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title_mv = itemView.findViewById(R.id.title_mv);
        }

        public void setItem(recomand item){
            title_mv.setText(item.getTitle());
        }
    }

}
