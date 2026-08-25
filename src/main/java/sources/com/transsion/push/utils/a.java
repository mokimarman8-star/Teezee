package com.transsion.push.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.blankj.utilcode.util.ImageUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import com.transsion.lib.push.R$mipmap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    public static final a a = new a();

    private a() {
    }

    public static /* synthetic */ Bitmap c(a aVar, Context context, Bitmap bitmap, int i, int i2, boolean z, int i3, int i4, int i5, Object obj) {
        return aVar.b(context, bitmap, i, i2, z, i3, (i5 & 64) != 0 ? 8 : i4);
    }

    public static /* synthetic */ Bitmap f(a aVar, Context context, Bitmap bitmap, int i, int i2, boolean z, int i3, int i4, Object obj) {
        if ((i4 & 32) != 0) {
            i3 = lj.a.b(8);
        }
        return aVar.e(context, bitmap, i, i2, z, i3);
    }

    public final Bitmap a(Context context, Bitmap bitmap, int i, int i2, boolean z) {
        Intrinsics.h(context, "context");
        return c(this, context, bitmap, i, i2, z, R$mipmap.notification_placeholder, 0, 64, null);
    }

    public final Bitmap b(Context context, Bitmap bitmap, int i, int i2, boolean z, int i3, int i4) {
        Intrinsics.h(context, "context");
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    BitmapPool bitmapPool = Glide.get(context).getBitmapPool();
                    Intrinsics.g(bitmapPool, "getBitmapPool(...)");
                    Bitmap centerCrop = TransformationUtils.centerCrop(bitmapPool, bitmap, i, i2);
                    Bitmap roundedCorners = TransformationUtils.roundedCorners(bitmapPool, centerCrop, i4);
                    d(centerCrop);
                    if (z) {
                        d(bitmap);
                    }
                    return roundedCorners;
                }
            } catch (Throwable unused) {
                return ImageUtils.g(bitmap, i, i2, z);
            }
        }
        return BitmapFactory.decodeResource(context.getResources(), i3);
    }

    public final void d(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
    }

    public final Bitmap e(Context context, Bitmap bitmap, int i, int i2, boolean z, int i3) {
        Intrinsics.h(context, "context");
        return (bitmap == null || bitmap.isRecycled()) ? BitmapFactory.decodeResource(context.getResources(), R$mipmap.notification_placeholder) : b(context, bitmap, i, i2, z, R$mipmap.notification_placeholder, i3);
    }
}
