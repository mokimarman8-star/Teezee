package com.facebook.biddingkit.facebook.bidder;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
class c {
    private String a;
    private String b;

    public c(String str) {
        this.a = "https://an.facebook.com/placementbid.ortb";
        this.b = "https://www.facebook.com/audiencenetwork/nurl/?partner=${PARTNER_FBID}&app=${APP_FBID}&placement=${PLACEMENT_FBID}&auction=${AUCTION_ID}&clearing_price=${AUCTION_PRICE}&ortb_loss_code=${AUCTION_LOSS}&ab_test_segment=${AB_TEST_SEGMENT}&winner_name=${WINNER_NAME}&winner_type=${WINNER_TYPE}&bundle=${BUNDLE}&phase=${PHASE}&idfa=${IDFA}";
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("facebook");
            if (optJSONObject != null) {
                if (optJSONObject.has("bid_url")) {
                    this.a = optJSONObject.getString("bid_url");
                }
                if (optJSONObject.has("notify_url")) {
                    this.b = optJSONObject.getString("notify_url");
                }
            }
        } catch (JSONException e) {
            com.facebook.biddingkit.logging.b.d("FacebookConfig", "Failed to parse configuration.", e);
        }
    }

    public String a() {
        return this.b;
    }
}
