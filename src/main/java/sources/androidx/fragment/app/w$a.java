package androidx.fragment.app;

import androidx.lifecycle.Lifecycle;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class w$a {

    /* renamed from: a, reason: collision with root package name */
    int f8227a;

    /* renamed from: b, reason: collision with root package name */
    Fragment f8228b;

    /* renamed from: c, reason: collision with root package name */
    boolean f8229c;

    /* renamed from: d, reason: collision with root package name */
    int f8230d;

    /* renamed from: e, reason: collision with root package name */
    int f8231e;

    /* renamed from: f, reason: collision with root package name */
    int f8232f;

    /* renamed from: g, reason: collision with root package name */
    int f8233g;

    /* renamed from: h, reason: collision with root package name */
    Lifecycle.State f8234h;

    /* renamed from: i, reason: collision with root package name */
    Lifecycle.State f8235i;

    w$a() {
    }

    w$a(int i5, Fragment fragment) {
        this.f8227a = i5;
        this.f8228b = fragment;
        this.f8229c = false;
        Lifecycle.State state = Lifecycle.State.RESUMED;
        this.f8234h = state;
        this.f8235i = state;
    }

    w$a(int i5, Fragment fragment, Lifecycle.State state) {
        this.f8227a = i5;
        this.f8228b = fragment;
        this.f8229c = false;
        this.f8234h = fragment.mMaxState;
        this.f8235i = state;
    }

    w$a(int i5, Fragment fragment, boolean z5) {
        this.f8227a = i5;
        this.f8228b = fragment;
        this.f8229c = z5;
        Lifecycle.State state = Lifecycle.State.RESUMED;
        this.f8234h = state;
        this.f8235i = state;
    }

    w$a(w$a w_a) {
        this.f8227a = w_a.f8227a;
        this.f8228b = w_a.f8228b;
        this.f8229c = w_a.f8229c;
        this.f8230d = w_a.f8230d;
        this.f8231e = w_a.f8231e;
        this.f8232f = w_a.f8232f;
        this.f8233g = w_a.f8233g;
        this.f8234h = w_a.f8234h;
        this.f8235i = w_a.f8235i;
    }
}
