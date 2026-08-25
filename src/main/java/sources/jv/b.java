package jv;

import androidx.compose.foundation.e;
import com.transsion.usercenter.setting.bean.UserSettingType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b {
    private final int a;
    private final UserSettingType b;
    private String c;
    private Integer d;
    private final int e;
    private String f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;

    public b(int i, UserSettingType userSettingType, String str, Integer num, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        this.a = i;
        this.b = userSettingType;
        this.c = str;
        this.d = num;
        this.e = i2;
        this.f = str2;
        this.g = z;
        this.h = z2;
        this.i = z3;
        this.j = z4;
    }

    public /* synthetic */ b(int i, UserSettingType userSettingType, String str, Integer num, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i3 & 2) != 0 ? null : userSettingType, (i3 & 4) != 0 ? null : str, (i3 & 8) != 0 ? null : num, (i3 & 16) != 0 ? 1 : i2, (i3 & 32) == 0 ? str2 : null, (i3 & 64) != 0 ? false : z, (i3 & 128) != 0 ? false : z2, (i3 & 256) == 0 ? z3 : true, (i3 & 512) == 0 ? z4 : false);
    }

    public final Integer a() {
        return this.d;
    }

    public final String b() {
        return this.c;
    }

    public final boolean c() {
        return this.k;
    }

    public final boolean d() {
        return this.i;
    }

    public final boolean e() {
        return this.j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.a == bVar.a && this.b == bVar.b && Intrinsics.c(this.c, bVar.c) && Intrinsics.c(this.d, bVar.d) && this.e == bVar.e && Intrinsics.c(this.f, bVar.f) && this.g == bVar.g && this.h == bVar.h && this.i == bVar.i && this.j == bVar.j;
    }

    public final boolean f() {
        return this.h;
    }

    public final String g() {
        return this.f;
    }

    public final boolean h() {
        return this.g;
    }

    public int hashCode() {
        int i = this.a * 31;
        UserSettingType userSettingType = this.b;
        int hashCode = (i + (userSettingType == null ? 0 : userSettingType.hashCode())) * 31;
        String str = this.c;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.d;
        int hashCode3 = (((hashCode2 + (num == null ? 0 : num.hashCode())) * 31) + this.e) * 31;
        String str2 = this.f;
        return ((((((((hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31) + e.a(this.g)) * 31) + e.a(this.h)) * 31) + e.a(this.i)) * 31) + e.a(this.j);
    }

    public final int i() {
        return this.a;
    }

    public final UserSettingType j() {
        return this.b;
    }

    public final int k() {
        return this.e;
    }

    public final void l(Integer num) {
        this.d = num;
    }

    public final void m(String str) {
        this.c = str;
    }

    public final void n(boolean z) {
        this.k = z;
    }

    public final void o(boolean z) {
        this.j = z;
    }

    public final void p(boolean z) {
        this.h = z;
    }

    public final void q(String str) {
        this.f = str;
    }

    public String toString() {
        return "UserSettingEntity(titleResId=" + this.a + ", type=" + this.b + ", content=" + this.c + ", bgId=" + this.d + ", uiType=" + this.e + ", tips=" + this.f + ", tipsLinearColor=" + this.g + ", switch=" + this.h + ", showDivider=" + this.i + ", showNewIcon=" + this.j + ")";
    }
}
