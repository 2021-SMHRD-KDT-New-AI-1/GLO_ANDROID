package com.nsg.glo3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<ChatData> dataList;
    private Context context;


    public ChatAdapter(ArrayList<ChatData> dataList) {
        this.dataList = dataList;
    }

//    public ChatAdapter(Context context, ArrayList<ChatData> dataList){
//        this.context = context;
//        this.dataList = dataList;
//    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (viewType == ViewTypeCode.viewtype.CENTER_CONTENT) {
            view = inflater.inflate(R.layout.center_list, parent, false);
            return new CenterViewHolder(view);
        } else if (viewType == ViewTypeCode.viewtype.LEFT_CONTENT) {
            view = inflater.inflate(R.layout.left_list, parent, false);
            return new LeftViewHolder(view);
        } else {
            view = inflater.inflate(R.layout.right_list, parent, false);
            return new RightViewHolder(view);
        }
    }


    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof CenterViewHolder){
            ((CenterViewHolder)holder).textv.setText(dataList.get(position).getSenetence());
        }else if(holder instanceof LeftViewHolder){
            ((LeftViewHolder)holder).textv_nicname.setText(dataList.get(position).getName());
        ((LeftViewHolder)holder).textv_msg.setText(dataList.get(position).getSenetence());
    }else{
        ((RightViewHolder)holder).textv_msg.setText(dataList.get(position).getSenetence());
    }

    }



    @Override
    public int getItemCount() {
        return dataList.size();
    }
    @Override
    public int getItemViewType(int position) {
        return dataList.get(position).getViewtype();
    }

    public class CenterViewHolder extends RecyclerView.ViewHolder{
        TextView textv;

        public CenterViewHolder(@NonNull View itemView) {
            super(itemView);
            textv = (TextView)itemView.findViewById(R.id.textv);
        }
    }

    public class LeftViewHolder extends RecyclerView.ViewHolder{
        ImageView imgv;
        TextView textv_nicname;
        TextView textv_msg;
        TextView textv_time;

        public LeftViewHolder(@NonNull View itemView) {
            super(itemView);
            imgv = itemView.findViewById(R.id.imgv);
            textv_nicname = itemView.findViewById(R.id.textv_nicname);
            textv_msg = itemView.findViewById(R.id.textv_msg);
            textv_time = itemView.findViewById(R.id.textv_time);

        }
    }

    public class RightViewHolder extends RecyclerView.ViewHolder{
        TextView textv_msg;
        TextView textv_time;

        public RightViewHolder(@NonNull View itemView) {
            super(itemView);
            textv_msg = (TextView)itemView.findViewById(R.id.textv_msg);
            textv_time = (TextView)itemView.findViewById(R.id.textv_time);
        }
    }

}