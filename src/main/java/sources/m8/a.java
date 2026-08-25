package m8;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class a {
    private static final Map a;
    private static final Map b;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        HashMap hashMap2 = new HashMap();
        b = hashMap2;
        hashMap.put("FACEBOOK_BIDDER", "facebook");
        hashMap2.put("facebook", "FACEBOOK_BIDDER");
        hashMap.put("APPLOVIN_BIDDER", "applovin");
        hashMap2.put("applovin", "APPLOVIN_BIDDER");
        hashMap.put("TAPJOY_BIDDER", "tapjoy");
        hashMap2.put("tapjoy", "TAPJOY_BIDDER");
    }

    public static boolean a(String str) {
        return "FACEBOOK_BIDDER".equals(str) || "APPLOVIN_BIDDER".equals(str) || "TAPJOY_BIDDER".equals(str) || "CHARTBOOST_BIDDER".equals(str);
    }
}
