package androidx.recyclerview.widget;

import androidx.collection.x;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
interface s {

    public static class a implements s {

        /* renamed from: a, reason: collision with root package name */
        long f12988a = 0;

        /* renamed from: androidx.recyclerview.widget.s$a$a, reason: collision with other inner class name */
        class C0094a implements d {

            /* renamed from: a, reason: collision with root package name */
            private final x f12989a = new x();

            C0094a() {
            }

            @Override // androidx.recyclerview.widget.s.d
            public long a(long j5) {
                Long l5 = (Long) this.f12989a.e(j5);
                if (l5 == null) {
                    l5 = Long.valueOf(a.this.b());
                    this.f12989a.k(j5, l5);
                }
                return l5.longValue();
            }
        }

        @Override // androidx.recyclerview.widget.s
        public d a() {
            return new C0094a();
        }

        long b() {
            long j5 = this.f12988a;
            this.f12988a = 1 + j5;
            return j5;
        }
    }

    public static class b implements s {

        /* renamed from: a, reason: collision with root package name */
        private final d f12991a = new a();

        class a implements d {
            a() {
            }

            @Override // androidx.recyclerview.widget.s.d
            public long a(long j5) {
                return -1L;
            }
        }

        @Override // androidx.recyclerview.widget.s
        public d a() {
            return this.f12991a;
        }
    }

    public static class c implements s {

        /* renamed from: a, reason: collision with root package name */
        private final d f12993a = new a();

        class a implements d {
            a() {
            }

            @Override // androidx.recyclerview.widget.s.d
            public long a(long j5) {
                return j5;
            }
        }

        @Override // androidx.recyclerview.widget.s
        public d a() {
            return this.f12993a;
        }
    }

    public interface d {
        long a(long j5);
    }

    d a();
}
