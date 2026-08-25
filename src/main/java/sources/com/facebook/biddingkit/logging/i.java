package com.facebook.biddingkit.logging;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
class i {
    private int a;
    private int b;
    private String c;

    public i(String str) {
        this.a = 15000;
        this.b = 60000;
        this.c = "https://www.facebook.com/audiencenetwork/bidding_kit_logging";
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("logging");
            if (optJSONObject != null) {
                if (optJSONObject.has("cycle_separation_ms")) {
                    this.a = optJSONObject.getInt("cycle_separation_ms");
                }
                if (optJSONObject.has("network_wait_on_failure_ms")) {
                    this.b = optJSONObject.getInt("network_wait_on_failure_ms");
                }
                if (optJSONObject.has("dispatcher_url")) {
                    this.c = optJSONObject.getString("dispatcher_url");
                }
            }
        } catch (JSONException e) {
            b.d("LoggingConfig", "Failed to parse configuration.", e);
        }
    }

    public int a() {
        return this.a;
    }

    public String b() {
        return this.c;
    }

    public int c() {
        return this.b;
    }
}
