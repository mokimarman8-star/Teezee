package com.transsion.http.d;

/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class h {
    public static final h a = new h("GET", 0, "GET");
    public static final h b = new h("POST", 1, "POST");
    public static final h c = new h("PUT", 2, "PUT");
    public static final h d = new h("PATCH", 3, "PATCH");
    public static final h e = new h("HEAD", 4, "HEAD");
    public static final h f = new h("MOVE", 5, "MOVE");
    public static final h g = new h("COPY", 6, "COPY");
    public static final h h = new h("DELETE", 7, "DELETE");
    public static final h i = new h("OPTIONS", 8, "OPTIONS");
    public static final h j = new h("TRACE", 9, "TRACE");
    public static final h k = new h("CONNECT", 10, "CONNECT");
    private final String l;

    private h(String str, int i2, String str2) {
        this.l = str2;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.l;
    }
}
