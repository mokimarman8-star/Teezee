package com.transsion.push.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import com.transsion.push.R$dimen;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class b {
    private static Bitmap a;

    public static Bitmap a(Context context, Bitmap bitmap) {
        return b(bitmap, c(context.getResources().getDimensionPixelSize(R$dimen.tpush_notification_icon_corner_large), context.getResources().getDimensionPixelSize(R$dimen.tpush_notification_large_icon_size), bitmap.getWidth()));
    }

    private static Bitmap b(Bitmap bitmap, int i) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        float f = i;
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-1);
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        bitmap.recycle();
        return createBitmap;
    }

    private static int c(int i, int i2, int i3) {
        return i2 != i3 ? (i * i3) / i2 : i;
    }

    public static Bitmap d(Context context, Bitmap bitmap) {
        Bitmap bitmap2 = a;
        if (bitmap2 != null) {
            return bitmap2;
        }
        Bitmap b = b(bitmap, c(context.getResources().getDimensionPixelSize(R$dimen.tpush_notification_icon_corner_small), context.getResources().getDimensionPixelSize(R$dimen.tpush_notification_small_icon_size), bitmap.getWidth()));
        a = b;
        return b;
    }
}
