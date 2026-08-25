package com.blankj.utilcode.util;

import android.content.Intent;
import android.net.Uri;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class p {
    private static Intent a(Intent intent, boolean z) {
        return z ? intent.addFlags(268435456) : intent;
    }

    public static Intent b(String str, boolean z) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + str));
        return a(intent, z);
    }

    public static boolean c(Intent intent) {
        return Utils.a().getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}
