package com.dev4solutions.decorview;

import java.io.Serializable;

/**
 * Created By: Manoj Singh Rawal
 * Email : manoj.rawal@svam.com
 * Project : DecorView
 * Copyright (c) 2018 North Shore Technologies Pvt. Ltd.
 * on 4/17/18.
 */
public class LaminateData implements Serializable {
    int details;
    String name;
    int img;
    int thumb;

    public LaminateData(String name, int imgRes, int thumb, int details) {
        this.name = name;
        this.img = imgRes;
        this.thumb = thumb;
        this.details = details;
    }
}
