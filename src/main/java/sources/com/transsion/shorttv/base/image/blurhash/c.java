package com.transsion.shorttv.base.image.blurhash;

import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.RequestBuilder;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class c {
    public static final void b(final RequestBuilder requestBuilder, String str, int i, int i2, BlurHash blurHash, final Function1 function1) {
        Intrinsics.h(requestBuilder, "<this>");
        Intrinsics.h(str, "blurString");
        Intrinsics.h(blurHash, "blurHash");
        Intrinsics.h(function1, "response");
        if (i == 0 || i2 == 0) {
            return;
        }
        blurHash.f(str, i, i2, new Function1() { // from class: com.transsion.shorttv.base.image.blurhash.b
            public final Object invoke(Object obj) {
                Unit c;
                c = c.c(requestBuilder, function1, (BitmapDrawable) obj);
                return c;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(RequestBuilder requestBuilder, Function1 function1, BitmapDrawable bitmapDrawable) {
        Intrinsics.h(bitmapDrawable, "drawable");
        requestBuilder.placeholder(bitmapDrawable);
        function1.invoke(requestBuilder);
        return Unit.a;
    }
}
