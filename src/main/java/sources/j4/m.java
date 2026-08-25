package j4;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    private final String f15902a;

    /* renamed from: b, reason: collision with root package name */
    private final int f15903b;

    public m(String str, int i5) {
        Intrinsics.h(str, "workSpecId");
        this.f15902a = str;
        this.f15903b = i5;
    }

    public final int a() {
        return this.f15903b;
    }

    public final String b() {
        return this.f15902a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return Intrinsics.c(this.f15902a, mVar.f15902a) && this.f15903b == mVar.f15903b;
    }

    public int hashCode() {
        return (this.f15902a.hashCode() * 31) + this.f15903b;
    }

    public String toString() {
        return "WorkGenerationalId(workSpecId=" + this.f15902a + ", generation=" + this.f15903b + ')';
    }
}
