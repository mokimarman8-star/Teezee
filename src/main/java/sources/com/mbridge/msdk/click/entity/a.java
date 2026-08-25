package com.mbridge.msdk.click.entity;

import androidx.annotation.NonNull;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class a {
    public String a;
    public String b;
    public String c;
    public String d;
    public int e;
    public int f;
    public String g;
    public String h;

    public String a() {
        return "statusCode=" + this.f + ", location=" + this.a + ", contentType=" + this.b + ", contentLength=" + this.e + ", contentEncoding=" + this.c + ", referer=" + this.d;
    }

    @NonNull
    public String toString() {
        return "ClickResponseHeader{location='" + this.a + "', contentType='" + this.b + "', contentEncoding='" + this.c + "', referer='" + this.d + "', contentLength=" + this.e + ", statusCode=" + this.f + ", url='" + this.g + "', exception='" + this.h + "'}";
    }
}
