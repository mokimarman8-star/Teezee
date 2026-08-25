package com.mbridge.msdk.mbbid.common;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class c {
    private String a;
    private String b;
    private String c;

    public c(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public c(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public String getmFloorPrice() {
        return this.c;
    }

    public String getmPlacementId() {
        return this.a;
    }

    public String getmUnitId() {
        return this.b;
    }

    public void setmFloorPrice(String str) {
        this.c = str;
    }

    public void setmPlacementId(String str) {
        this.a = str;
    }

    public void setmUnitId(String str) {
        this.b = str;
    }
}
