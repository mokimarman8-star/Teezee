package com.amazonaws.auth;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public enum SignatureVersion {
    V1("1"),
    V2("2");

    private String value;

    SignatureVersion(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }
}
