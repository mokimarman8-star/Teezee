package com.cloud.hisavana.sdk;

import com.cloud.hisavana.sdk.common.bean.DiskTrackingBean;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class i1 {
    public static final a f = new a(null);
    private String a;
    private Long b;
    private Integer c;
    private String d;
    private String e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final i1 a(DiskTrackingBean diskTrackingBean) {
            Intrinsics.h(diskTrackingBean, "bean");
            i1 i1Var = new i1(null, null, null, null, null, 31, null);
            i1Var.h(diskTrackingBean.getUuid());
            i1Var.c(Long.valueOf(diskTrackingBean.getCreateTime()));
            i1Var.b(Integer.valueOf(diskTrackingBean.getRetryTimes().get()));
            i1Var.f(GsonUtil.d(diskTrackingBean));
            i1Var.d(diskTrackingBean.getMd5());
            return i1Var;
        }
    }

    public i1() {
        this(null, null, null, null, null, 31, null);
    }

    public i1(String str, Long l, Integer num, String str2, String str3) {
        Intrinsics.h(str, "uuid");
        this.a = str;
        this.b = l;
        this.c = num;
        this.d = str2;
        this.e = str3;
    }

    public /* synthetic */ i1(String str, Long l, Integer num, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? 0L : l, (i & 4) != 0 ? 0 : num, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3);
    }

    public final Long a() {
        return this.b;
    }

    public final void b(Integer num) {
        this.c = num;
    }

    public final void c(Long l) {
        this.b = l;
    }

    public final void d(String str) {
        this.e = str;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i1)) {
            return false;
        }
        i1 i1Var = (i1) obj;
        return Intrinsics.c(this.a, i1Var.a) && Intrinsics.c(this.b, i1Var.b) && Intrinsics.c(this.c, i1Var.c) && Intrinsics.c(this.d, i1Var.d) && Intrinsics.c(this.e, i1Var.e);
    }

    public final void f(String str) {
        this.d = str;
    }

    public final Integer g() {
        return this.c;
    }

    public final void h(String str) {
        Intrinsics.h(str, "<set-?>");
        this.a = str;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        Long l = this.b;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        Integer num = this.c;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.d;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.e;
        return hashCode4 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String i() {
        return this.d;
    }

    public final String j() {
        return this.a;
    }

    public String toString() {
        return "RetryTrackingEntity(uuid=" + this.a + ", create_time=" + this.b + ", retry_times=" + this.c + ", tracking_data=" + this.d + ", md5=" + this.e + ')';
    }
}
