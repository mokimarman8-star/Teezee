package com.transsion.publish.viewmodel;

import android.app.Application;
import androidx.lifecycle.b0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d extends androidx.lifecycle.b {
    private final Lazy b;
    private b0 c;
    private final b0 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.b = LazyKt.b(new Function0() { // from class: com.transsion.publish.viewmodel.c
            public final Object invoke() {
                oo.b d;
                d = d.d();
                return d;
            }
        });
        this.c = new b0();
        this.d = new b0(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final oo.b d() {
        return new oo.b();
    }
}
