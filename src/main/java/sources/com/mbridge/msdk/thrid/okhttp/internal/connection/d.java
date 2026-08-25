package com.mbridge.msdk.thrid.okhttp.internal.connection;

import com.mbridge.msdk.thrid.okhttp.a0;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class d {
    private final Set<a0> a = new LinkedHashSet();

    public synchronized void a(a0 a0Var) {
        this.a.remove(a0Var);
    }

    public synchronized void b(a0 a0Var) {
        this.a.add(a0Var);
    }

    public synchronized boolean c(a0 a0Var) {
        return this.a.contains(a0Var);
    }
}
