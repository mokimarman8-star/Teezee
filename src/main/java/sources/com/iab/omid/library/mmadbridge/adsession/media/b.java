package com.iab.omid.library.mmadbridge.adsession.media;

import org.json.JSONException;
import org.json.JSONObject;
import re.d;
import re.g;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class b {
    private final boolean a;
    private final Float b;
    private final boolean c;
    private final Position d;

    private b(boolean z, Float f, boolean z2, Position position) {
        this.a = z;
        this.b = f;
        this.c = z2;
        this.d = position;
    }

    public static b b(boolean z, Position position) {
        g.d(position, "Position is null");
        return new b(false, null, z, position);
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("skippable", this.a);
            if (this.a) {
                jSONObject.put("skipOffset", this.b);
            }
            jSONObject.put("autoPlay", this.c);
            jSONObject.put("position", this.d);
        } catch (JSONException e) {
            d.b("VastProperties: JSON error", e);
        }
        return jSONObject;
    }
}
