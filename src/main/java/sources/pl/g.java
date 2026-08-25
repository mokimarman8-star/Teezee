package pl;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g {
    public static final g a = new g();

    private g() {
    }

    private final boolean b(String str, Context context) {
        try {
            Intent parseUri = Intent.parseUri(str, 1);
            Intrinsics.g(parseUri, "parseUri(...)");
            parseUri.setFlags(268435456);
            if (context == null) {
                return true;
            }
            context.startActivity(parseUri);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final boolean a(String str, Context context) {
        if (str == null || str.length() == 0) {
            return false;
        }
        if (StringsKt.W(str, "https://play.google.com/store/apps/", false, 2, (Object) null) || StringsKt.W(str, "http://play.google.com/store/apps/", false, 2, (Object) null)) {
            return b(str, context);
        }
        if (StringsKt.W(str, "http", false, 2, (Object) null)) {
            return false;
        }
        b(str, context);
        return true;
    }
}
