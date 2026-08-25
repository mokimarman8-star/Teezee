package androidx.media;

import android.os.Bundle;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class MediaBrowserServiceCompat$k {

    /* renamed from: a, reason: collision with root package name */
    private final Object f8436a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f8437b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f8438c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f8439d;

    /* renamed from: e, reason: collision with root package name */
    private int f8440e;

    MediaBrowserServiceCompat$k(Object obj) {
        this.f8436a = obj;
    }

    int a() {
        return this.f8440e;
    }

    boolean b() {
        return this.f8437b || this.f8438c || this.f8439d;
    }

    void c(Bundle bundle) {
        throw new UnsupportedOperationException("It is not supported to send an error for " + this.f8436a);
    }

    abstract void d(Object obj);

    public void e(Bundle bundle) {
        if (!this.f8438c && !this.f8439d) {
            this.f8439d = true;
            c(bundle);
        } else {
            throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.f8436a);
        }
    }

    public void f(Object obj) {
        if (!this.f8438c && !this.f8439d) {
            this.f8438c = true;
            d(obj);
        } else {
            throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.f8436a);
        }
    }

    void g(int i5) {
        this.f8440e = i5;
    }
}
