package com.transsion.shorttv_pugc.base.image.blurhash;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.LruCache;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class BlurHash {
    private Context a;
    private float b;
    private LruCache c;
    private final n0 d;

    public BlurHash(Context context, int i, float f) {
        Intrinsics.h(context, "context");
        this.a = context;
        this.b = f;
        this.c = new LruCache(i);
        this.d = o0.a(y0.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(String str, BitmapDrawable bitmapDrawable) {
        this.c.put(str, bitmapDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BitmapDrawable g(String str) {
        return (BitmapDrawable) this.c.get(str);
    }

    public final void f(String blurString, int i, int i2, Function1 response) {
        Intrinsics.h(blurString, "blurString");
        Intrinsics.h(response, "response");
        k.d(this.d, null, null, new BlurHash$execute$1(this, blurString, response, i, i2, null), 3, null);
    }
}
