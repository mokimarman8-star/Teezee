package com.transsion.publish;

import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class n {
    public static final a b = new a(null);
    private static final Lazy c = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.transsion.publish.m
        public final Object invoke() {
            n b2;
            b2 = n.b();
            return b2;
        }
    });
    private List a = new ArrayList();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final n a() {
            return (n) n.c.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n b() {
        return new n();
    }

    public final void d() {
        List list = this.a;
        if (list != null) {
            list.clear();
        }
    }

    public final List e() {
        return this.a;
    }

    public final void f(List list) {
        Intrinsics.h(list, "list");
        this.a = list;
    }
}
