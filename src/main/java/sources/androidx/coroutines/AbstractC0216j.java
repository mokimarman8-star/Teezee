package androidx.coroutines;

import android.util.Log;

/* renamed from: androidx.work.j, reason: case insensitive filesystem */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class AbstractC0216j {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f14142a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static volatile AbstractC0216j f14143b = null;

    /* renamed from: c, reason: collision with root package name */
    private static final int f14144c = 20;

    /* renamed from: androidx.work.j$a */
    public static class a extends AbstractC0216j {

        /* renamed from: d, reason: collision with root package name */
        private final int f14145d;

        public a(int i5) {
            super(i5);
            this.f14145d = i5;
        }

        @Override // androidx.coroutines.AbstractC0216j
        public void a(String str, String str2) {
        }

        @Override // androidx.coroutines.AbstractC0216j
        public void b(String str, String str2, Throwable th) {
        }

        @Override // androidx.coroutines.AbstractC0216j
        public void c(String str, String str2) {
            if (this.f14145d <= 6) {
                Log.e(str, str2);
            }
        }

        @Override // androidx.coroutines.AbstractC0216j
        public void d(String str, String str2, Throwable th) {
            if (this.f14145d <= 6) {
                Log.e(str, str2, th);
            }
        }

        @Override // androidx.coroutines.AbstractC0216j
        public void f(String str, String str2) {
        }

        @Override // androidx.coroutines.AbstractC0216j
        public void g(String str, String str2, Throwable th) {
        }

        @Override // androidx.coroutines.AbstractC0216j
        public void j(String str, String str2) {
            if (this.f14145d <= 2) {
                Log.v(str, str2);
            }
        }

        @Override // androidx.coroutines.AbstractC0216j
        public void k(String str, String str2) {
            if (this.f14145d <= 5) {
                Log.w(str, str2);
            }
        }

        @Override // androidx.coroutines.AbstractC0216j
        public void l(String str, String str2, Throwable th) {
            if (this.f14145d <= 5) {
                Log.w(str, str2, th);
            }
        }
    }

    public AbstractC0216j(int i5) {
    }

    public static AbstractC0216j e() {
        AbstractC0216j abstractC0216j;
        synchronized (f14142a) {
            try {
                if (f14143b == null) {
                    f14143b = new a(3);
                }
                abstractC0216j = f14143b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return abstractC0216j;
    }

    public static void h(AbstractC0216j abstractC0216j) {
        synchronized (f14142a) {
            f14143b = abstractC0216j;
        }
    }

    public static String i(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(23);
        sb.append("WM-");
        int i5 = f14144c;
        if (length >= i5) {
            sb.append(str.substring(0, i5));
        } else {
            sb.append(str);
        }
        return sb.toString();
    }

    public abstract void a(String str, String str2);

    public abstract void b(String str, String str2, Throwable th);

    public abstract void c(String str, String str2);

    public abstract void d(String str, String str2, Throwable th);

    public abstract void f(String str, String str2);

    public abstract void g(String str, String str2, Throwable th);

    public abstract void j(String str, String str2);

    public abstract void k(String str, String str2);

    public abstract void l(String str, String str2, Throwable th);
}
