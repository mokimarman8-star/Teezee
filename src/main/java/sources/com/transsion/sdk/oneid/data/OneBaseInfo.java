package com.transsion.sdk.oneid.data;

import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.transsion.sdk.oneid.b;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class OneBaseInfo {
    @NonNull
    public String toString() {
        try {
            return new Gson().toJson(this);
        } catch (Exception e) {
            b.m(e);
            return "";
        }
    }
}
