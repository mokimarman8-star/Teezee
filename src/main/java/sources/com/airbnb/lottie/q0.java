package com.airbnb.lottie;

import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class q0 {

    /* renamed from: a, reason: collision with root package name */
    private final Object f14533a;

    /* renamed from: b, reason: collision with root package name */
    private final Throwable f14534b;

    public q0(Object obj) {
        this.f14533a = obj;
        this.f14534b = null;
    }

    public q0(Throwable th) {
        this.f14534b = th;
        this.f14533a = null;
    }

    public Throwable a() {
        return this.f14534b;
    }

    public Object b() {
        return this.f14533a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q0)) {
            return false;
        }
        q0 q0Var = (q0) obj;
        if (b() != null && b().equals(q0Var.b())) {
            return true;
        }
        if (a() == null || q0Var.a() == null) {
            return false;
        }
        return a().toString().equals(a().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{b(), a()});
    }
}
