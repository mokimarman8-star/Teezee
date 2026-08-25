package com.facebook.biddingkit.facebook.bidder;

import android.text.TextUtils;
import com.facebook.biddingkit.bidders.LossCode;
import com.facebook.biddingkit.facebook.bidder.b;
import com.facebook.biddingkit.http.util.HttpStatusCode;
import java.util.HashMap;
import java.util.Map;
import n8.e;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
class FacebookNotifier implements l8.b {
    private final int a;
    private com.facebook.biddingkit.facebook.bidder.a b;
    private final b.a c;
    private final c d;
    private boolean e;
    private String f;
    private String g;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[HttpStatusCode.values().length];
            a = iArr;
            try {
                iArr[HttpStatusCode.NO_BID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[HttpStatusCode.BAD_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[HttpStatusCode.TIMEOUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public FacebookNotifier(b.a aVar, c cVar) {
        this.a = 2000;
        this.f = "";
        this.g = "";
        this.c = aVar;
        this.d = cVar;
    }

    protected FacebookNotifier(String str, c cVar) {
        this(new b.a("", "", null, "").d(str), cVar);
        this.e = true;
    }

    protected static Double c(r8.b bVar, r8.b bVar2) {
        if (bVar == null) {
            return Double.valueOf(0.0d);
        }
        if (b.a.equals(bVar.b())) {
            return Double.valueOf(bVar2 != null ? bVar2.a() : 0.0d);
        }
        return Double.valueOf(bVar.a());
    }

    private String d() {
        return this.d.a();
    }

    protected static String e(r8.b bVar) {
        if (bVar == null) {
            return null;
        }
        return bVar.b();
    }

    private int i() {
        return 2000;
    }

    @Override // l8.b
    public void a(String str, r8.a aVar) {
        r8.b[] b = q8.b.b(aVar);
        r8.b bVar = b[0];
        String e = e(null);
        r8.b bVar2 = b[0];
        r8.b bVar3 = b[1];
        j(str, e, c(null, null), false);
    }

    protected String f() {
        return TextUtils.isEmpty(this.g) ? q8.b.c(com.facebook.biddingkit.bridge.a.a()) : this.g;
    }

    protected LossCode g(String str) {
        return this.e ? LossCode.DID_NOT_PARTICIPATE : b.a.equals(str) ? LossCode.WIN : LossCode.TIMEOUT;
    }

    protected String h() {
        return TextUtils.isEmpty(this.f) ? com.facebook.biddingkit.bridge.a.a().getPackageName() : this.f;
    }

    protected void j(String str, String str2, Double d, boolean z) {
        e a2 = o8.b.a(k(z, str, str2, d), i());
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append("Facebook display winner notified with http status ");
            sb.append(a2 != null ? String.valueOf(a2.a()) : "null");
            com.facebook.biddingkit.logging.b.a("FacebookNotifier", sb.toString());
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Facebook bidder winner notified with http status ");
        sb2.append(a2 != null ? String.valueOf(a2.a()) : "null");
        com.facebook.biddingkit.logging.b.a("FacebookNotifier", sb2.toString());
    }

    protected String k(boolean z, String str, String str2, Double d) {
        String d2 = d();
        try {
            String[] split = this.c.c().split("_", 2);
            for (Map.Entry<String, String> entry : new HashMap<String, String>(split.length >= 2 ? split[1] : "", str, str2, d, z) { // from class: com.facebook.biddingkit.facebook.bidder.FacebookNotifier.1
                final /* synthetic */ Double val$cpmCents;
                final /* synthetic */ String val$entryName;
                final /* synthetic */ boolean val$isDisplay;
                final /* synthetic */ String val$placementFbid;
                final /* synthetic */ String val$segment;

                {
                    this.val$placementFbid = r4;
                    this.val$segment = str;
                    this.val$entryName = str2;
                    this.val$cpmCents = d;
                    this.val$isDisplay = z;
                    put("${PARTNER_FBID}", FacebookNotifier.this.c.a());
                    put("${APP_FBID}", FacebookNotifier.this.c.a());
                    put("${PLACEMENT_FBID}", r4);
                    put("${BUNDLE}", FacebookNotifier.this.h());
                    put("${IDFA}", FacebookNotifier.this.f());
                    put("${AUCTION_ID}", FacebookNotifier.this.c.b());
                    put("${AB_TEST_SEGMENT}", str);
                    put("${AUCTION_LOSS}", FacebookNotifier.this.g(str2).getStringValue());
                    put("${AUCTION_PRICE}", Double.toString(d.doubleValue() / 100.0d));
                    put("${WINNER_NAME}", str2 == null ? "" : str2);
                    put("${WINNER_TYPE}", m8.a.a(str2) ? "bidding" : "waterfall");
                    put("${PHASE}", z ? "display" : "auction");
                }
            }.entrySet()) {
                String value = entry.getValue();
                if (value == null) {
                    value = "";
                }
                d2 = d2.replace(entry.getKey(), value);
            }
        } catch (Throwable th) {
            com.facebook.biddingkit.logging.b.d("FacebookNotifier", "Failed processing the Url", th);
        }
        return d2;
    }
}
