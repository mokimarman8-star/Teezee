package com.transsion.push.bean;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class PushPointInfo {
    public String evt;
    public int id;

    public PushPointInfo(int i, String str) {
        this.id = i;
        this.evt = str;
    }

    public String toString() {
        return "PushPointInfo{id=" + this.id + ", evt='" + this.evt + "'}";
    }
}
