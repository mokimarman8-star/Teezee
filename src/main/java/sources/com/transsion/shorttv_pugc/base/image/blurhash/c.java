package com.transsion.shorttv_pugc.base.image.blurhash;

import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.RequestBuilder;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class c {
    public static final void b(final RequestBuilder requestBuilder, String blurString, int i, int i2, BlurHash blurHash, final Function1 response) {
        Intrinsics.h(requestBuilder, "<this>");
        Intrinsics.h(blurString, "blurString");
        Intrinsics.h(blurHash, "blurHash");
        Intrinsics.h(response, "response");
        if (i == 0 || i2 == 0) {
            return;
        }
        blurHash.f(blurString, i, i2, new Function1() { // from class: com.transsion.shorttv_pugc.base.image.blurhash.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit c;
                c = c.c(requestBuilder, response, (BitmapDrawable) obj);
                return c;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(RequestBuilder requestBuilder, Function1 function1, BitmapDrawable drawable) {
        Intrinsics.h(drawable, "drawable");
        requestBuilder.placeholder(drawable);
        function1.invoke(requestBuilder);
        return Unit.a;
    }
}
