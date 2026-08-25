package com.bytedance.sdk.openadsdk.sU;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public enum EjP {
    TYPE_2G("2g"),
    TYPE_3G("3g"),
    TYPE_4G("4g"),
    TYPE_5G("5g"),
    TYPE_WIFI("wifi"),
    TYPE_MOBILE("mobile"),
    TYPE_UNKNOWN("unknown");

    private String Dq;

    EjP(String str) {
        this.Dq = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.Dq;
    }
}
