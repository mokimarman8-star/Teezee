package j4;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final String f15892a;

    /* renamed from: b, reason: collision with root package name */
    private final int f15893b;

    /* renamed from: c, reason: collision with root package name */
    public final int f15894c;

    public i(String str, int i5, int i6) {
        Intrinsics.h(str, "workSpecId");
        this.f15892a = str;
        this.f15893b = i5;
        this.f15894c = i6;
    }

    public final int a() {
        return this.f15893b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return Intrinsics.c(this.f15892a, iVar.f15892a) && this.f15893b == iVar.f15893b && this.f15894c == iVar.f15894c;
    }

    public int hashCode() {
        return (((this.f15892a.hashCode() * 31) + this.f15893b) * 31) + this.f15894c;
    }

    public String toString() {
        return "SystemIdInfo(workSpecId=" + this.f15892a + ", generation=" + this.f15893b + ", systemId=" + this.f15894c + ')';
    }
}
