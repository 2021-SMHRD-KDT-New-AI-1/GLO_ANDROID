package com.nsg.glo3;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewTypeCode {
    public class viewtype extends RecyclerView.ViewHolder {
        public static final int LEFT_CONTENT =1;
        public static final int RIGHT_CONTENT = 2;
        public static final int CENTER_CONTENT =0;

        public viewtype(@NonNull View itemView) {
            super(itemView);
        }
    }
}
