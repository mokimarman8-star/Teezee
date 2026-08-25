package com.transsion.baselib.helper;

import com.transsion.gslb.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class l {
    public static final a b = new a(null);
    private static final Lazy c = LazyKt.b(new Function0() { // from class: com.transsion.baselib.helper.k
        public final Object invoke() {
            l c2;
            c2 = l.c();
            return c2;
        }
    });
    private String a = BuildConfig.FLAVOR;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final l a() {
            return (l) l.c.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final l c() {
        return new l();
    }

    public final void d(String str) {
        Intrinsics.h(str, "userPrefer");
        this.a = str;
    }
}
