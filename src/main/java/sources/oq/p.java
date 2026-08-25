package oq;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class p {
    public static final p a = new p();
    private static final String b = "https://play.google.com/store/apps/details?id=com.community.oneroom";

    private p() {
    }

    public final void a(Activity activity, String str, Uri uri, Function1 function1) {
        Intrinsics.h(activity, "activity");
        if (str != null) {
            try {
                if (str.length() != 0) {
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setType("image/*");
                    intent.putExtra("android.intent.extra.STREAM", uri);
                    intent.setPackage(str);
                    activity.startActivity(intent);
                    if (function1 != null) {
                    }
                }
            } catch (Exception unused) {
                if (function1 != null) {
                    return;
                }
                return;
            }
        }
        if (function1 != null) {
        }
    }

    public final void b(Activity activity, Uri uri, Function1 function1) {
        Intrinsics.h(activity, "activity");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/*");
        intent.putExtra("android.intent.extra.STREAM", uri);
        try {
            try {
                intent.setPackage("org.telegram.messenger");
                activity.startActivity(intent);
                if (function1 != null) {
                }
            } catch (Exception unused) {
                if (function1 != null) {
                }
            }
        } catch (ActivityNotFoundException unused2) {
            intent.setPackage("org.thunderdog.challegram");
            activity.startActivity(intent);
            if (function1 != null) {
            }
        }
    }

    public final void c(Activity activity, String str, Function1 function1) {
        Intrinsics.h(activity, "activity");
        Intrinsics.h(str, "shareContent");
        Intent intent = new Intent();
        try {
            try {
                intent.setAction("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.TEXT", str);
                intent.setType("text/plain");
                intent.setPackage("org.telegram.messenger");
                activity.startActivity(intent);
                if (function1 != null) {
                }
            } catch (Exception unused) {
                if (function1 != null) {
                }
            }
        } catch (ActivityNotFoundException unused2) {
            intent.setPackage("org.thunderdog.challegram");
            activity.startActivity(intent);
            if (function1 != null) {
            }
        }
    }

    public final void d(Activity activity, String str, Function1 function1) {
        Intrinsics.h(activity, "activity");
        Intrinsics.h(str, "shareContent");
        try {
            Intent intent = new Intent();
            Uri parse = Uri.parse("whatsapp://send?text=" + Uri.encode(str));
            intent.setAction("android.intent.action.VIEW");
            intent.setData(parse);
            activity.startActivity(intent);
            if (function1 != null) {
            }
        } catch (Exception unused) {
            if (function1 != null) {
            }
        }
    }
}
