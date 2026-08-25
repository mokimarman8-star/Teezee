package com.transsion.push.notification;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class j extends b {

    public static final class a extends com.transsion.push.notification.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, int i) {
            super(context, i);
            Intrinsics.h(context, "context");
        }

        public final j P() {
            return new j(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(a aVar) {
        super(aVar);
        Intrinsics.h(aVar, "builder");
    }
}
