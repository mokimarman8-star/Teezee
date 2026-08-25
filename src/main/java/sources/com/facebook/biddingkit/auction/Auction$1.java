package com.facebook.biddingkit.auction;

import java.util.Iterator;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
class Auction$1 implements Runnable {
    final /* synthetic */ a this$0;
    final /* synthetic */ c val$listener;
    final /* synthetic */ r8.a val$waterfall;

    /* renamed from: com.facebook.biddingkit.auction.Auction$1$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Auction$1.this.getClass();
            Iterator it = a.b(null).iterator();
            while (it.hasNext()) {
                android.support.v4.media.session.c.a(it.next());
            }
            Auction$1.this.getClass();
            l8.b a = com.facebook.biddingkit.facebook.bidder.b.a(a.a(null));
            Auction$1.this.getClass();
            String d = a.d(null);
            Auction$1.this.getClass();
            a.a(d, null);
        }
    }

    Auction$1(a aVar, r8.a aVar2, c cVar) {
    }

    @Override // java.lang.Runnable
    public void run() {
        System.currentTimeMillis();
        throw null;
    }
}
