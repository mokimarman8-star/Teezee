package com.cloud.hisavana.protocol.okhttptransport;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class c {

    private static class b {
        private static final c a = new a();

        class a extends c {
            a() {
                super();
            }

            @Override // com.cloud.hisavana.protocol.okhttptransport.c
            boolean b() {
                return true;
            }

            @Override // com.cloud.hisavana.protocol.okhttptransport.c
            int c() {
                return 16;
            }
        }
    }

    private c() {
    }

    public static c a() {
        return b.a;
    }

    abstract boolean b();

    abstract int c();
}
