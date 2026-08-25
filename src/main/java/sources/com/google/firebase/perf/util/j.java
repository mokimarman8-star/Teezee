package com.google.firebase.perf.util;

import java.net.URL;
import java.net.URLConnection;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class j {
    private final URL a;

    public j(URL url) {
        this.a = url;
    }

    public URLConnection a() {
        return this.a.openConnection();
    }

    public String toString() {
        return this.a.toString();
    }
}
