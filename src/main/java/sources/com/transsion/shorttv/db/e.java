package com.transsion.shorttv.db;

import com.transsion.gslb.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e {
    private String a;
    private String b;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public e() {
        this(r0, r0, 3, r0);
        String str = null;
    }

    public e(String str, String str2) {
        Intrinsics.h(str, "subjectId");
        Intrinsics.h(str2, "unlockedEps");
        this.a = str;
        this.b = str2;
    }

    public /* synthetic */ e(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? BuildConfig.FLAVOR : str, (i & 2) != 0 ? BuildConfig.FLAVOR : str2);
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final Set c() {
        if (StringsKt.q0(this.b)) {
            return new LinkedHashSet();
        }
        List S0 = StringsKt.S0(this.b, new String[]{","}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        Iterator it = S0.iterator();
        while (it.hasNext()) {
            Integer v = StringsKt.v(StringsKt.n1((String) it.next()).toString());
            if (v != null) {
                arrayList.add(v);
            }
        }
        return CollectionsKt.V0(arrayList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return Intrinsics.c(this.a, eVar.a) && Intrinsics.c(this.b, eVar.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "ShortTvAdUnlockStateBean(subjectId=" + this.a + ", unlockedEps=" + this.b + ")";
    }
}
