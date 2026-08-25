package com.mbridge.msdk.tracker.network;

import com.mbridge.msdk.tracker.network.b;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class v<T> {
    public final T a;
    public final b.a b;
    public final b0 c;
    public boolean d;

    public interface a {
        void a(b0 b0Var);
    }

    public interface b<T> {
        void a(T t);
    }

    private v(b0 b0Var) {
        this.d = false;
        this.a = null;
        this.b = null;
        this.c = b0Var;
    }

    private v(T t, b.a aVar) {
        this.d = false;
        this.a = t;
        this.b = aVar;
        this.c = null;
    }

    public static <T> v<T> a(b0 b0Var) {
        return new v<>(b0Var);
    }

    public static <T> v<T> a(T t, b.a aVar) {
        return new v<>(t, aVar);
    }

    public boolean a() {
        return this.c == null;
    }
}
