package com.transsnet.flow.event;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class d implements c {
    public static final a a = new a(null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.transsnet.flow.event.c
    public void log(String msg) {
        Intrinsics.h(msg, "msg");
    }

    @Override // com.transsnet.flow.event.c
    public void log(String msg, String th) {
        Intrinsics.h(msg, "msg");
        Intrinsics.h(th, "th");
        StringBuilder sb = new StringBuilder();
        sb.append(msg);
        sb.append(",ex:");
        sb.append(th);
    }
}
