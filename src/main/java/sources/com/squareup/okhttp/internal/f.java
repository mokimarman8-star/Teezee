package com.squareup.okhttp.internal;

import com.squareup.okhttp.Route;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class f {
    private final Set a = new LinkedHashSet();

    public synchronized void a(Route route) {
        this.a.remove(route);
    }

    public synchronized void b(Route route) {
        this.a.add(route);
    }

    public synchronized boolean c(Route route) {
        return this.a.contains(route);
    }
}
