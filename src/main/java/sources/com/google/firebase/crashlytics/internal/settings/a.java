package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.common.c0;
import com.google.firebase.crashlytics.internal.settings.c;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class a implements g {
    a() {
    }

    static c b(c0 c0Var) {
        return new c(c0Var.a() + 3600000, new c.b(8, 4), new c.a(true, false, false), 0, 3600, 10.0d, 1.2d, 60);
    }

    @Override // com.google.firebase.crashlytics.internal.settings.g
    public c a(c0 c0Var, JSONObject jSONObject) {
        return b(c0Var);
    }
}
