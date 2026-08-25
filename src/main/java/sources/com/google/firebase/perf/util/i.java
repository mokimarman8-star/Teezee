package com.google.firebase.perf.util;

import android.content.Context;
import android.content.res.Resources;
import java.net.URI;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class i {
    private static String[] a;

    public static boolean a(URI uri, Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("firebase_performance_whitelisted_domains", "array", context.getPackageName());
        if (identifier == 0) {
            return true;
        }
        uc.a.e().a("Detected domain allowlist, only allowlisted domains will be measured.");
        if (a == null) {
            a = resources.getStringArray(identifier);
        }
        String host = uri.getHost();
        if (host == null) {
            return true;
        }
        for (String str : a) {
            if (host.contains(str)) {
                return true;
            }
        }
        return false;
    }
}
