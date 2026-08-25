package vf;

import android.content.Context;
import android.graphics.Bitmap;
import com.blankj.utilcode.util.ImageUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class a {
    public static Bitmap a(Context context, Bitmap bitmap, int i5, int i6, boolean z5, int i7) {
        if (bitmap == null) {
            return null;
        }
        try {
            if (bitmap.isRecycled()) {
                return null;
            }
            BitmapPool bitmapPool = Glide.get(context).getBitmapPool();
            Bitmap g5 = (bitmap.getWidth() < i5 || bitmap.getHeight() < i6) ? ImageUtils.g(bitmap, i5, i6, z5) : TransformationUtils.centerCrop(bitmapPool, bitmap, i5, i6);
            Bitmap roundedCorners = TransformationUtils.roundedCorners(bitmapPool, g5, i7);
            c(g5);
            if (z5) {
                c(bitmap);
            }
            return roundedCorners;
        } catch (Throwable unused) {
            return ImageUtils.g(bitmap, i5, i6, z5);
        }
    }

    private static boolean b(Bitmap bitmap) {
        return bitmap == null || bitmap.getWidth() == 0 || bitmap.getHeight() == 0;
    }

    public static void c(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
    }

    public static Bitmap d(Bitmap bitmap, int i5, int i6, boolean z5) {
        if (b(bitmap)) {
            return null;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i5, i6, true);
        if (z5 && !bitmap.isRecycled() && createScaledBitmap != bitmap) {
            bitmap.recycle();
        }
        return createScaledBitmap;
    }
}
