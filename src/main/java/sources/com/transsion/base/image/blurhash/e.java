package com.transsion.base.image.blurhash;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e {
    public static final e a = new e();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.base.image.blurhash.d
        public final Object invoke() {
            BlurHash b2;
            b2 = e.b();
            return b2;
        }
    });

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BlurHash b() {
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        return new BlurHash(a2, 10, 0.6f);
    }

    public static /* synthetic */ void d(e eVar, String str, int i, int i2, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 20;
        }
        if ((i3 & 4) != 0) {
            i2 = 20;
        }
        eVar.c(str, i, i2, function1);
    }

    private final BlurHash e() {
        return (BlurHash) b.getValue();
    }

    public final void c(String str, int i, int i2, Function1 function1) {
        Intrinsics.h(str, "blurString");
        Intrinsics.h(function1, "response");
        e().f(str, i, i2, function1);
    }
}
