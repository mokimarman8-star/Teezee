package com.transsion.usercenter.setting.dev;

import androidx.lifecycle.b0;
import androidx.lifecycle.t0;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class f extends t0 {
    private final Lazy a = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.setting.dev.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            b0 c;
            c = f.c();
            return c;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 c() {
        return new b0();
    }

    public final b0 d() {
        return (b0) this.a.getValue();
    }

    public final void e(int i, int i2, String id) {
        Intrinsics.h(id, "id");
        ArrayList arrayList = new ArrayList();
        int i3 = 1;
        if (1 <= i2) {
            while (true) {
                arrayList.add("page = " + i + " --- pageSize = " + i2 + " --- id = " + id);
                if (i3 == i2) {
                    break;
                } else {
                    i3++;
                }
            }
        }
        d().n(arrayList);
    }
}
