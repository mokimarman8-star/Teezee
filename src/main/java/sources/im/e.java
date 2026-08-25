package im;

import com.transsion.memberapi.MemberTaskRewardInfo;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e {
    private final int a;
    private final String b;
    private final int c;
    private final int d;
    private final MemberTaskRewardInfo e;

    public e(int i, String str, int i2, int i3, MemberTaskRewardInfo memberTaskRewardInfo) {
        Intrinsics.h(str, "rewardId");
        this.a = i;
        this.b = str;
        this.c = i2;
        this.d = i3;
        this.e = memberTaskRewardInfo;
    }

    public final int a() {
        return this.a;
    }

    public final MemberTaskRewardInfo b() {
        return this.e;
    }

    public final int c() {
        return this.c;
    }

    public final String d() {
        return this.b;
    }

    public final int e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.a == eVar.a && Intrinsics.c(this.b, eVar.b) && this.c == eVar.c && this.d == eVar.d && Intrinsics.c(this.e, eVar.e);
    }

    public int hashCode() {
        int hashCode = ((((((this.a * 31) + this.b.hashCode()) * 31) + this.c) * 31) + this.d) * 31;
        MemberTaskRewardInfo memberTaskRewardInfo = this.e;
        return hashCode + (memberTaskRewardInfo == null ? 0 : memberTaskRewardInfo.hashCode());
    }

    public String toString() {
        return "MemberTaskRewardData(index=" + this.a + ", rewardId=" + this.b + ", rewardAmount=" + this.c + ", rewardType=" + this.d + ", info=" + this.e + ")";
    }
}
