package com.iab.omid.library.vungle.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class f {
    private static final Pattern b = Pattern.compile("^[a-zA-Z0-9 ]+$");
    private final List a = new ArrayList();

    public List a() {
        return this.a;
    }

    public void b() {
        this.a.clear();
    }
}
