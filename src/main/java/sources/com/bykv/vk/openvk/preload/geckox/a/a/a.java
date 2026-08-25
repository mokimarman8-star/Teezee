package com.bykv.vk.openvk.preload.geckox.a.a;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class a {
    final int a;
    final c b;
    private final b c;

    /* renamed from: com.bykv.vk.openvk.preload.geckox.a.a.a$a, reason: collision with other inner class name */
    public static final class C0018a {
        private int a;
        private b b = b.a;
        private c c;

        public final C0018a a() {
            this.a = 20;
            return this;
        }

        public final C0018a a(b bVar) {
            if (bVar == null) {
                bVar = b.a;
            }
            this.b = bVar;
            return this;
        }

        public final a b() {
            return new a(this, (byte) 0);
        }
    }

    private a(C0018a c0018a) {
        this.a = c0018a.a;
        this.c = c0018a.b;
        this.b = c0018a.c;
    }

    /* synthetic */ a(C0018a c0018a, byte b) {
        this(c0018a);
    }

    public final b a() {
        return this.c;
    }
}
