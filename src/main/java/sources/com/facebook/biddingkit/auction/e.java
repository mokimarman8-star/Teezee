package com.facebook.biddingkit.auction;

import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
abstract class e extends d {

    static class a implements Callable {
        final /* synthetic */ String a;

        a(p8.b bVar, String str) {
            this.a = str;
        }

        public p8.a a() {
            throw null;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return null;
        }
    }

    protected static List a(String str, p8.b bVar, b bVar2) {
        q8.a.c.submit(new a(bVar, str));
        new com.facebook.biddingkit.logging.e();
        throw null;
    }
}
