package com.nsg.glo3;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
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
        CardView card_list;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title_mv = itemView.findViewById(R.id.title_mv);
            card_list = itemView.findViewById(R.id.card_list);
        }

        public void setItem(recomand item){
            title_mv.setText(item.getTitle());
            card_list.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String find = item.content;
                    Uri uri = Uri.parse(find);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    view.getContext().startActivity(intent);
                }
            });
        }
    }

}
