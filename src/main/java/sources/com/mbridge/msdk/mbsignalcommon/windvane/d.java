package com.mbridge.msdk.mbsignalcommon.windvane;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public enum d {
    JS("js", "application/x-javascript"),
    CSS("css", "text/css"),
    JPG("jpg", "image/jpeg"),
    JPEG("jpep", "image/jpeg"),
    PNG("png", "image/png"),
    WEBP("webp", "image/webp"),
    GIF("gif", "image/gif"),
    HTM("htm", "text/html"),
    HTML("html", "text/html");

    private String a;
    private String b;

    d(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }
}
