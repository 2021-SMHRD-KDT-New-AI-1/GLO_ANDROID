package com.nsg.glo3;

import android.text.Editable;

public class ChatData {
    private String name;
    private String senetence;
    private int viewtype;

    public ChatData(String name, String senetence, int viewtype) {
        this.name = name;
        this.senetence = senetence;
        this.viewtype = viewtype;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSenetence() {
        return senetence;
    }

    public void setSenetence(String senetence) {
        this.senetence = senetence;
    }

    public int getViewtype() {
        return viewtype;
    }

    public void setViewtype(int viewtype) {
        this.viewtype = viewtype;
    }
}
