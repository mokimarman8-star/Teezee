package com.facebook.biddingkit.facebook.bidder;

import com.facebook.biddingkit.gen.FBAdBidAuctionType;
import com.facebook.biddingkit.gen.FacebookAdBidFormat;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class b {
    public static String a = "FACEBOOK_BIDDER";

    public static class a {
        private String a;
        private String b;
        private FacebookAdBidFormat c;
        private String d;
        private String e;
        private FBAdBidAuctionType f = FBAdBidAuctionType.FIRST_PRICE;
        private String g;

        public a(String str, String str2, FacebookAdBidFormat facebookAdBidFormat, String str3) {
            this.a = str;
            this.b = str2;
            this.c = facebookAdBidFormat;
            this.e = str3;
            this.g = str;
        }

        protected String a() {
            return this.a;
        }

        protected String b() {
            return this.d;
        }

        protected String c() {
            return this.b;
        }

        public a d(String str) {
            this.d = str;
            return this;
        }
    }

    public static l8.b a(String str) {
        return new FacebookNotifier(str, new c(com.facebook.biddingkit.bridge.a.b()));
    }
}
