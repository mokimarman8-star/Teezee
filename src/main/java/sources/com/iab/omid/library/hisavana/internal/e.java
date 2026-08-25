package com.iab.omid.library.hisavana.internal;

import android.view.View;
import com.iab.omid.library.hisavana.adsession.FriendlyObstructionPurpose;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class e {
    private final ne.a a;
    private final String b;
    private final FriendlyObstructionPurpose c;
    private final String d;

    public e(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        this.a = new ne.a(view);
        this.b = view.getClass().getCanonicalName();
        this.c = friendlyObstructionPurpose;
        this.d = str;
    }

    public String a() {
        return this.d;
    }

    public FriendlyObstructionPurpose b() {
        return this.c;
    }

    public ne.a c() {
        return this.a;
    }

    public String d() {
        return this.b;
    }
}
