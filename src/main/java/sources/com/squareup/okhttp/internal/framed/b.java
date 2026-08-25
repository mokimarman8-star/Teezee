package com.squareup.okhttp.internal.framed;

import okio.ByteString;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class b {
    public static final ByteString d = ByteString.encodeUtf8(":status");
    public static final ByteString e = ByteString.encodeUtf8(":method");
    public static final ByteString f = ByteString.encodeUtf8(":path");
    public static final ByteString g = ByteString.encodeUtf8(":scheme");
    public static final ByteString h = ByteString.encodeUtf8(":authority");
    public static final ByteString i = ByteString.encodeUtf8(":host");
    public static final ByteString j = ByteString.encodeUtf8(":version");
    public final ByteString a;
    public final ByteString b;
    final int c;

    public b(String str, String str2) {
        this(ByteString.encodeUtf8(str), ByteString.encodeUtf8(str2));
    }

    public b(ByteString byteString, String str) {
        this(byteString, ByteString.encodeUtf8(str));
    }

    public b(ByteString byteString, ByteString byteString2) {
        this.a = byteString;
        this.b = byteString2;
        this.c = byteString.size() + 32 + byteString2.size();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.a.equals(bVar.a) && this.b.equals(bVar.b);
    }

    public int hashCode() {
        return ((527 + this.a.hashCode()) * 31) + this.b.hashCode();
    }

    public String toString() {
        return String.format("%s: %s", this.a.utf8(), this.b.utf8());
    }
}
