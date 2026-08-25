package com.cloud.hisavana.sdk;

import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class y3 {
    public static final a i = new a(null);
    private int a;
    private String b;
    private String c;
    private String d;
    private Double e;
    private Integer f;
    private Integer g;
    private String h;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List a(List list) {
            if (list == null) {
                return CollectionsKt.l();
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                AdsDTO adsDTO = (AdsDTO) it.next();
                y3 y3Var = new y3(0, null, null, null, null, null, null, null, 255, null);
                y3Var.b(adsDTO.getTableId());
                y3Var.h(adsDTO.getAdCreativeId());
                y3Var.j(adsDTO.getCodeSeatId());
                y3Var.l(adsDTO.getFilePath());
                y3Var.c(adsDTO.getFirstPrice());
                y3Var.g(Integer.valueOf(adsDTO.isOfflineAd() ? 1 : 0));
                y3Var.d(Integer.valueOf(adsDTO.getAdRequestVer()));
                y3Var.e(GsonUtil.d(adsDTO));
                arrayList.add(y3Var);
            }
            return arrayList;
        }
    }

    public y3() {
        this(0, null, null, null, null, null, null, null, 255, null);
    }

    public y3(int i2, String str, String str2, String str3, Double d, Integer num, Integer num2, String str4) {
        this.a = i2;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = d;
        this.f = num;
        this.g = num2;
        this.h = str4;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ y3(int i2, String str, String str2, String str3, Double d, Integer num, Integer num2, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) == 0 ? i2 : 0, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2, (i3 & 8) != 0 ? null : str3, (i3 & 16) != 0 ? Double.valueOf(0.0d) : d, (i3 & 32) != 0 ? r3 : num, (i3 & 64) == 0 ? num2 : 0, (i3 & 128) == 0 ? str4 : null);
    }

    public final String a() {
        return this.h;
    }

    public final void b(int i2) {
        this.a = i2;
    }

    public final void c(Double d) {
        this.e = d;
    }

    public final void d(Integer num) {
        this.g = num;
    }

    public final void e(String str) {
        this.h = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y3)) {
            return false;
        }
        y3 y3Var = (y3) obj;
        return this.a == y3Var.a && Intrinsics.c(this.b, y3Var.b) && Intrinsics.c(this.c, y3Var.c) && Intrinsics.c(this.d, y3Var.d) && Intrinsics.c(this.e, y3Var.e) && Intrinsics.c(this.f, y3Var.f) && Intrinsics.c(this.g, y3Var.g) && Intrinsics.c(this.h, y3Var.h);
    }

    public final String f() {
        return this.b;
    }

    public final void g(Integer num) {
        this.f = num;
    }

    public final void h(String str) {
        this.b = str;
    }

    public int hashCode() {
        int i2 = this.a * 31;
        String str = this.b;
        int hashCode = (i2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.d;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Double d = this.e;
        int hashCode4 = (hashCode3 + (d == null ? 0 : d.hashCode())) * 31;
        Integer num = this.f;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.g;
        int hashCode6 = (hashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str4 = this.h;
        return hashCode6 + (str4 != null ? str4.hashCode() : 0);
    }

    public final Integer i() {
        return this.g;
    }

    public final void j(String str) {
        this.c = str;
    }

    public final String k() {
        return this.c;
    }

    public final void l(String str) {
        this.d = str;
    }

    public final String m() {
        return this.d;
    }

    public final Double n() {
        return this.e;
    }

    public final int o() {
        return this.a;
    }

    public final Integer p() {
        return this.f;
    }

    public String toString() {
        return "AdListEntity(_id=" + this.a + ", ad_creative_id=" + this.b + ", codeSeatId=" + this.c + ", file_path=" + this.d + ", price=" + this.e + ", is_offline_ad=" + this.f + ", ad_request_ver=" + this.g + ", ad_bean=" + this.h + ')';
    }
}
