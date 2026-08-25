package com.mbridge.msdk.video.dynview.error;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public enum a {
    NOT_FOUND_VIEWOPTION(-1, "ViewOption is null"),
    NOT_FOUND_CONTEXT(-2, "Context is null"),
    NOT_FOUND_LAYOUTNAME(-3, "layout xml name is null"),
    CAMPAIGNEX_IS_NULL(-4, "Campaign size only one"),
    VIEW_CREATE_ERROR(-5, "view create error"),
    NOT_FOUND_ROOTVIEW(-6, "rootview is null");

    private int a;
    private String b;

    a(int i2, String str) {
        this.a = i2;
        this.b = str;
    }

    public int b() {
        return this.a;
    }

    public String c() {
        return this.b;
    }
}
