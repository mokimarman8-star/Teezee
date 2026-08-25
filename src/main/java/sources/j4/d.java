package j4;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final String f15886a;

    /* renamed from: b, reason: collision with root package name */
    private final Long f15887b;

    public d(String str, Long l5) {
        Intrinsics.h(str, "key");
        this.f15886a = str;
        this.f15887b = l5;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(String str, boolean z5) {
        this(str, Long.valueOf(z5 ? 1L : 0L));
        Intrinsics.h(str, "key");
    }

    public final String a() {
        return this.f15886a;
    }

    public final Long b() {
        return this.f15887b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return Intrinsics.c(this.f15886a, dVar.f15886a) && Intrinsics.c(this.f15887b, dVar.f15887b);
    }

    public int hashCode() {
        int hashCode = this.f15886a.hashCode() * 31;
        Long l5 = this.f15887b;
        return hashCode + (l5 == null ? 0 : l5.hashCode());
    }

    public String toString() {
        return "Preference(key=" + this.f15886a + ", value=" + this.f15887b + ')';
    }
}
