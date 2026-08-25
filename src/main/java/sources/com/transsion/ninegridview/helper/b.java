package com.transsion.ninegridview.helper;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b {
    public static final b a = new b();

    private b() {
    }

    public final void a(Activity activity, int i) {
        Intrinsics.h(activity, "activity");
        String packageName = activity.getPackageName();
        Intrinsics.g(packageName, "getPackageName(...)");
        Intent intent = new Intent("com.android.setting.ACTION_GET_PERMISSION_DETAILS");
        intent.putExtra("packagename", packageName);
        intent.addFlags(268435456);
        try {
            try {
                try {
                    if (i > 0) {
                        activity.startActivityForResult(intent, i);
                    } else {
                        activity.startActivity(intent);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (ActivityNotFoundException unused) {
                Intent intent2 = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
                intent2.addFlags(268435456);
                if (i > 0) {
                    activity.startActivityForResult(intent2, i);
                } else {
                    activity.startActivity(intent2);
                }
            }
        } catch (ActivityNotFoundException unused2) {
            Intent intent3 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent3.setData(Uri.parse("package:" + packageName));
            intent3.addFlags(268435456);
            if (i > 0) {
                activity.startActivityForResult(intent3, i);
            } else {
                activity.startActivity(intent3);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
