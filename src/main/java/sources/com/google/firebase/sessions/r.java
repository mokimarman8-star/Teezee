package com.google.firebase.sessions;

import android.util.Base64;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class r {
    public static final r a = new r();
    private static final String b;
    private static final String c;
    private static final String d;

    static {
        String encodeToString = Base64.encodeToString(StringsKt.E(q.a.e()), 10);
        b = encodeToString;
        c = "firebase_session_" + encodeToString + "_data";
        d = "firebase_session_" + encodeToString + "_settings";
    }

    private r() {
    }

    public final String a() {
        return c;
    }

    public final String b() {
        return d;
    }
}
