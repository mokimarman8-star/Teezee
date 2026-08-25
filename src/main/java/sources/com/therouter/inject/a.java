package com.therouter.inject;

import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class a {
    private final Class a;
    private String b;

    public a(Class cls, Object... objArr) {
        Intrinsics.h(cls, "clazz");
        Intrinsics.h(objArr, "params");
        this.a = cls;
        for (Object obj : objArr) {
            if (obj != null) {
                this.b = this.b + obj;
            }
        }
    }

    public final Class a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return super.equals(obj);
        }
        a aVar = (a) obj;
        return Intrinsics.c(a(), aVar.a()) && Intrinsics.c(this.b, aVar.b);
    }

    public int hashCode() {
        int hashCode = a().hashCode();
        String str = this.b;
        if (str == null) {
            str = TtmlNode.ANONYMOUS_REGION_ID;
        }
        int hashCode2 = str.hashCode();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(hashCode);
        sb2.append(hashCode2);
        return sb2.toString().hashCode();
    }
}
