package com.transsion.http.d;

import java.util.UUID;

/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    public static final a a = new a("FORM", 0, "application/x-www-form-urlencoded");
    public static final a b = new a("JSON", 1, "application/json");
    public static final a c = new a("FILE", 2, "multipart/form-data;boundary=--" + UUID.randomUUID().toString());
    private final String d;

    private a(String str, int i, String str2) {
        this.d = str2;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.d;
    }
}
