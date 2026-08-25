package com.google.firebase.perf.util;

import java.util.NoSuchElementException;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class e {
    private final Object a;

    private e() {
        this.a = null;
    }

    private e(Object obj) {
        if (obj == null) {
            throw new NullPointerException("value for optional is empty.");
        }
        this.a = obj;
    }

    public static e a() {
        return new e();
    }

    public static e b(Object obj) {
        return obj == null ? a() : e(obj);
    }

    public static e e(Object obj) {
        return new e(obj);
    }

    public Object c() {
        Object obj = this.a;
        if (obj != null) {
            return obj;
        }
        throw new NoSuchElementException("No value present");
    }

    public boolean d() {
        return this.a != null;
    }
}
