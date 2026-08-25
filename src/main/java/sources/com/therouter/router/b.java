package com.therouter.router;

import com.hisavana.common.tracking.TrackingKey;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class b {
    private String a;
    private String b;
    private int c;
    private String d;
    private String e;
    private String f;
    private boolean g;
    private String h;

    public b(String str, String str2, int i, String str3, String str4, String str5, boolean z, String str6) {
        Intrinsics.h(str, "type");
        Intrinsics.h(str2, "key");
        Intrinsics.h(str3, "args");
        Intrinsics.h(str4, "className");
        Intrinsics.h(str5, "fieldName");
        Intrinsics.h(str6, TrackingKey.DESCRIPTION);
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = z;
        this.h = str6;
    }

    public final int a() {
        return this.c;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.a;
    }
}
