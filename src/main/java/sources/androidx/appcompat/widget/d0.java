package androidx.appcompat.widget;

import androidx.core.view.inputmethod.EditorInfoCompat;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class d0 {

    /* renamed from: a, reason: collision with root package name */
    private int f981a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f982b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f983c = EditorInfoCompat.IME_FLAG_FORCE_ASCII;

    /* renamed from: d, reason: collision with root package name */
    private int f984d = EditorInfoCompat.IME_FLAG_FORCE_ASCII;

    /* renamed from: e, reason: collision with root package name */
    private int f985e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f986f = 0;

    /* renamed from: g, reason: collision with root package name */
    private boolean f987g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f988h = false;

    d0() {
    }

    public int a() {
        return this.f987g ? this.f981a : this.f982b;
    }

    public int b() {
        return this.f981a;
    }

    public int c() {
        return this.f982b;
    }

    public int d() {
        return this.f987g ? this.f982b : this.f981a;
    }

    public void e(int i5, int i6) {
        this.f988h = false;
        if (i5 != Integer.MIN_VALUE) {
            this.f985e = i5;
            this.f981a = i5;
        }
        if (i6 != Integer.MIN_VALUE) {
            this.f986f = i6;
            this.f982b = i6;
        }
    }

    public void f(boolean z5) {
        if (z5 == this.f987g) {
            return;
        }
        this.f987g = z5;
        if (!this.f988h) {
            this.f981a = this.f985e;
            this.f982b = this.f986f;
            return;
        }
        if (z5) {
            int i5 = this.f984d;
            if (i5 == Integer.MIN_VALUE) {
                i5 = this.f985e;
            }
            this.f981a = i5;
            int i6 = this.f983c;
            if (i6 == Integer.MIN_VALUE) {
                i6 = this.f986f;
            }
            this.f982b = i6;
            return;
        }
        int i7 = this.f983c;
        if (i7 == Integer.MIN_VALUE) {
            i7 = this.f985e;
        }
        this.f981a = i7;
        int i8 = this.f984d;
        if (i8 == Integer.MIN_VALUE) {
            i8 = this.f986f;
        }
        this.f982b = i8;
    }

    public void g(int i5, int i6) {
        this.f983c = i5;
        this.f984d = i6;
        this.f988h = true;
        if (this.f987g) {
            if (i6 != Integer.MIN_VALUE) {
                this.f981a = i6;
            }
            if (i5 != Integer.MIN_VALUE) {
                this.f982b = i5;
                return;
            }
            return;
        }
        if (i5 != Integer.MIN_VALUE) {
            this.f981a = i5;
        }
        if (i6 != Integer.MIN_VALUE) {
            this.f982b = i6;
        }
    }
}
