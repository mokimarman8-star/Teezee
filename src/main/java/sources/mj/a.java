package mj;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a extends LruBitmapPool {
    public a(long j) {
        super(j);
    }

    public Bitmap get(int i, int i2, Bitmap.Config config) {
        Intrinsics.h(config, "config");
        Bitmap bitmap = super.get(i, i2, config);
        Intrinsics.g(bitmap, "get(...)");
        if (!bitmap.isRecycled()) {
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, config);
        Intrinsics.e(createBitmap);
        return createBitmap;
    }

    public Bitmap getDirty(int i, int i2, Bitmap.Config config) {
        Intrinsics.h(config, "config");
        Bitmap dirty = super.getDirty(i, i2, config);
        Intrinsics.g(dirty, "getDirty(...)");
        if (!dirty.isRecycled()) {
            return dirty;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, config);
        Intrinsics.e(createBitmap);
        return createBitmap;
    }

    public void put(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            super.put(bitmap);
            Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }
}
