package com.transsion.commercialization.gameres.aha;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b {
    private Integer a;
    private String b;
    private Long c;
    private c d;

    public b() {
        this(null, null, null, null, 15, null);
    }

    public b(Integer num, String str, Long l, c cVar) {
        this.a = num;
        this.b = str;
        this.c = l;
        this.d = cVar;
    }

    public /* synthetic */ b(Integer num, String str, Long l, c cVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : cVar);
    }

    public final Integer a() {
        return this.a;
    }

    public final c b() {
        return this.d;
    }

    public final String c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.c(this.a, bVar.a) && Intrinsics.c(this.b, bVar.b) && Intrinsics.c(this.c, bVar.c) && Intrinsics.c(this.d, bVar.d);
    }

    public int hashCode() {
        Integer num = this.a;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l = this.c;
        int hashCode3 = (hashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        c cVar = this.d;
        return hashCode3 + (cVar != null ? cVar.hashCode() : 0);
    }

    public String toString() {
        return "AHAGameResDto(code=" + this.a + ", message=" + this.b + ", timestamp=" + this.c + ", data=" + this.d + ")";
    }
}
