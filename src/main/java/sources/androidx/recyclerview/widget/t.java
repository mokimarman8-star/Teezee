package androidx.recyclerview.widget;

import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class t {

    /* renamed from: a, reason: collision with root package name */
    final b f12995a;

    /* renamed from: b, reason: collision with root package name */
    a f12996b = new a();

    static class a {

        /* renamed from: a, reason: collision with root package name */
        int f12997a = 0;

        /* renamed from: b, reason: collision with root package name */
        int f12998b;

        /* renamed from: c, reason: collision with root package name */
        int f12999c;

        /* renamed from: d, reason: collision with root package name */
        int f13000d;

        /* renamed from: e, reason: collision with root package name */
        int f13001e;

        a() {
        }

        void a(int i5) {
            this.f12997a = i5 | this.f12997a;
        }

        boolean b() {
            int i5 = this.f12997a;
            if ((i5 & 7) != 0 && (i5 & c(this.f13000d, this.f12998b)) == 0) {
                return false;
            }
            int i6 = this.f12997a;
            if ((i6 & 112) != 0 && (i6 & (c(this.f13000d, this.f12999c) << 4)) == 0) {
                return false;
            }
            int i7 = this.f12997a;
            if ((i7 & 1792) != 0 && (i7 & (c(this.f13001e, this.f12998b) << 8)) == 0) {
                return false;
            }
            int i8 = this.f12997a;
            return (i8 & 28672) == 0 || (i8 & (c(this.f13001e, this.f12999c) << 12)) != 0;
        }

        int c(int i5, int i6) {
            if (i5 > i6) {
                return 1;
            }
            return i5 == i6 ? 2 : 4;
        }

        void d() {
            this.f12997a = 0;
        }

        void e(int i5, int i6, int i7, int i8) {
            this.f12998b = i5;
            this.f12999c = i6;
            this.f13000d = i7;
            this.f13001e = i8;
        }
    }

    interface b {
        int a(View view);

        int b();

        int c();

        int d(View view);

        View getChildAt(int i5);
    }

    t(b bVar) {
        this.f12995a = bVar;
    }

    View a(int i5, int i6, int i7, int i8) {
        int b5 = this.f12995a.b();
        int c5 = this.f12995a.c();
        int i9 = i6 > i5 ? 1 : -1;
        View view = null;
        while (i5 != i6) {
            View childAt = this.f12995a.getChildAt(i5);
            this.f12996b.e(b5, c5, this.f12995a.a(childAt), this.f12995a.d(childAt));
            if (i7 != 0) {
                this.f12996b.d();
                this.f12996b.a(i7);
                if (this.f12996b.b()) {
                    return childAt;
                }
            }
            if (i8 != 0) {
                this.f12996b.d();
                this.f12996b.a(i8);
                if (this.f12996b.b()) {
                    view = childAt;
                }
            }
            i5 += i9;
        }
        return view;
    }

    boolean b(View view, int i5) {
        this.f12996b.e(this.f12995a.b(), this.f12995a.c(), this.f12995a.a(view), this.f12995a.d(view));
        if (i5 == 0) {
            return false;
        }
        this.f12996b.d();
        this.f12996b.a(i5);
        return this.f12996b.b();
    }
}
