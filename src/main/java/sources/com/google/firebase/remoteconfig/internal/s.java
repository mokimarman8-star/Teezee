package com.google.firebase.remoteconfig.internal;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class s implements ad.i {
    private final long a;
    private final int b;
    private final ad.j c;

    public static class b {
        private long a;
        private int b;
        private ad.j c;

        private b() {
        }

        public s a() {
            return new s(this.a, this.b, this.c);
        }

        b b(ad.j jVar) {
            this.c = jVar;
            return this;
        }

        b c(int i) {
            this.b = i;
            return this;
        }

        public b d(long j) {
            this.a = j;
            return this;
        }
    }

    private s(long j, int i, ad.j jVar) {
        this.a = j;
        this.b = i;
        this.c = jVar;
    }

    static b b() {
        return new b();
    }

    @Override // ad.i
    public int a() {
        return this.b;
    }
}
