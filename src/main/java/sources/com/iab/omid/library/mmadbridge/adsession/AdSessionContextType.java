package com.iab.omid.library.mmadbridge.adsession;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public enum AdSessionContextType {
    HTML("html"),
    NATIVE("native"),
    JAVASCRIPT("javascript");

    private final String typeString;

    AdSessionContextType(String str) {
        this.typeString = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.typeString;
    }
}
