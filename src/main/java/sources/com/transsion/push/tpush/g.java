package com.transsion.push.tpush;

import android.content.Context;
import android.graphics.Bitmap;
import com.transsion.lib.push.R$layout;
import com.transsion.push.notification.c;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g {
    public static final g a = new g();

    private g() {
    }

    public final Bitmap a(Context context, Bitmap bitmap, boolean z) {
        Bitmap e;
        Intrinsics.h(context, "context");
        Intrinsics.h(bitmap, "contentBitmap");
        return (z && (e = com.transsion.push.utils.a.a.e(context, bitmap, lj.a.b(71), com.transsion.push.helper.e.a.g(), false, lj.a.b(4))) != null) ? e : bitmap;
    }

    public final c.a b(Context context, int i, boolean z) {
        Intrinsics.h(context, "context");
        return z ? new c.a(context, i, R$layout.push_notification_normal_vertical_small, R$layout.push_notification_normal_vertical_big) : new c.a(context, i, R$layout.push_notification_normal_small, R$layout.push_notification_big_picture);
    }

    public final Bitmap c(Context context, Bitmap bitmap, boolean z) {
        Intrinsics.h(context, "context");
        Intrinsics.h(bitmap, "contentBitmap");
        Bitmap e = com.transsion.push.utils.a.a.e(context, bitmap, lj.a.b(z ? 40 : 100), lj.a.b(56), false, lj.a.b(4));
        return e == null ? bitmap : e;
    }
}
