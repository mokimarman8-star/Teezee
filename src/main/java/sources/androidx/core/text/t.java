package androidx.core.text;

import java.util.Locale;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class t {

    /* renamed from: a, reason: collision with root package name */
    public static final s f7110a = new e(null, false);

    /* renamed from: b, reason: collision with root package name */
    public static final s f7111b = new e(null, true);

    /* renamed from: c, reason: collision with root package name */
    public static final s f7112c;

    /* renamed from: d, reason: collision with root package name */
    public static final s f7113d;

    /* renamed from: e, reason: collision with root package name */
    public static final s f7114e;

    /* renamed from: f, reason: collision with root package name */
    public static final s f7115f;

    private static class a implements c {

        /* renamed from: b, reason: collision with root package name */
        static final a f7116b = new a(true);

        /* renamed from: a, reason: collision with root package name */
        private final boolean f7117a;

        private a(boolean z5) {
            this.f7117a = z5;
        }

        @Override // androidx.core.text.t.c
        public int a(CharSequence charSequence, int i5, int i6) {
            int i7 = i6 + i5;
            boolean z5 = false;
            while (i5 < i7) {
                int a5 = t.a(Character.getDirectionality(charSequence.charAt(i5)));
                if (a5 != 0) {
                    if (a5 != 1) {
                        continue;
                        i5++;
                        z5 = z5;
                    } else if (!this.f7117a) {
                        return 1;
                    }
                } else if (this.f7117a) {
                    return 0;
                }
                z5 = true;
                i5++;
                z5 = z5;
            }
            if (z5) {
                return this.f7117a ? 1 : 0;
            }
            return 2;
        }
    }

    private static class b implements c {

        /* renamed from: a, reason: collision with root package name */
        static final b f7118a = new b();

        private b() {
        }

        @Override // androidx.core.text.t.c
        public int a(CharSequence charSequence, int i5, int i6) {
            int i7 = i6 + i5;
            int i8 = 2;
            while (i5 < i7 && i8 == 2) {
                i8 = t.b(Character.getDirectionality(charSequence.charAt(i5)));
                i5++;
            }
            return i8;
        }
    }

    private interface c {
        int a(CharSequence charSequence, int i5, int i6);
    }

    private static abstract class d implements s {

        /* renamed from: a, reason: collision with root package name */
        private final c f7119a;

        d(c cVar) {
            this.f7119a = cVar;
        }

        private boolean c(CharSequence charSequence, int i5, int i6) {
            int a5 = this.f7119a.a(charSequence, i5, i6);
            if (a5 == 0) {
                return true;
            }
            if (a5 != 1) {
                return b();
            }
            return false;
        }

        @Override // androidx.core.text.s
        public boolean a(CharSequence charSequence, int i5, int i6) {
            if (charSequence == null || i5 < 0 || i6 < 0 || charSequence.length() - i6 < i5) {
                throw new IllegalArgumentException();
            }
            return this.f7119a == null ? b() : c(charSequence, i5, i6);
        }

        protected abstract boolean b();
    }

    private static class e extends d {

        /* renamed from: b, reason: collision with root package name */
        private final boolean f7120b;

        e(c cVar, boolean z5) {
            super(cVar);
            this.f7120b = z5;
        }

        @Override // androidx.core.text.t.d
        protected boolean b() {
            return this.f7120b;
        }
    }

    private static class f extends d {

        /* renamed from: b, reason: collision with root package name */
        static final f f7121b = new f();

        f() {
            super(null);
        }

        @Override // androidx.core.text.t.d
        protected boolean b() {
            return u.a(Locale.getDefault()) == 1;
        }
    }

    static {
        b bVar = b.f7118a;
        f7112c = new e(bVar, false);
        f7113d = new e(bVar, true);
        f7114e = new e(a.f7116b, false);
        f7115f = f.f7121b;
    }

    static int a(int i5) {
        if (i5 != 0) {
            return (i5 == 1 || i5 == 2) ? 0 : 2;
        }
        return 1;
    }

    static int b(int i5) {
        if (i5 != 0) {
            if (i5 == 1 || i5 == 2) {
                return 0;
            }
            switch (i5) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
