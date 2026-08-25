package com.amazonaws.util;

import com.amazonaws.Protocol;
import java.net.URI;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class URIBuilder {
    private static final String h = Protocol.HTTPS.toString();
    private String a;
    private String b;
    private String c;
    private int d;
    private String e;
    private String f;
    private String g;

    private URIBuilder(URI uri) {
        this.a = uri.getScheme();
        this.b = uri.getUserInfo();
        this.c = uri.getHost();
        this.d = uri.getPort();
        this.e = uri.getPath();
        this.f = uri.getQuery();
        this.g = uri.getFragment();
    }

    public static URIBuilder b(URI uri) {
        return new URIBuilder(uri);
    }

    public URI a() {
        return new URI(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
    }

    public URIBuilder c(String str) {
        this.c = str;
        return this;
    }
}
