package com.baseapp.hiepnn.model;

/**
 * Created by hiepnguyennghia on 1/14/19.
 * Copyright © 2018 Vietinterview. All rights reserved.
 */
public class RowItem {
    private String content;
    private boolean cekbox;

    public RowItem(String c, boolean d) {
        this.content = c;
        this.cekbox = d;
    }

    public void setContent(String c) {
        this.content = c;
    }

    public void setCekbox(boolean c) {
        this.cekbox = c;
    }

    public boolean getCekbox() {
        return this.cekbox;
    }

    public String getContent() {
        return this.content;
    }
}
