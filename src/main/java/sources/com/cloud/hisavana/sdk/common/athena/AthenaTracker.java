package com.cloud.hisavana.sdk.common.athena;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import com.cloud.hisavana.sdk.common.bean.DiskTrackingBean;
import com.cloud.hisavana.sdk.common.bean.ProgressData;
import com.cloud.hisavana.sdk.common.bean.VastData;
import com.cloud.hisavana.sdk.common.constant.Constants;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.util.h0;
import com.cloud.hisavana.sdk.data.bean.request.AdxImpBean;
import com.cloud.hisavana.sdk.data.bean.request.FormBean;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.ext.attr.AttrData;
import com.cloud.hisavana.sdk.p3;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.cloud.sdk.commonutil.util.MitNetUtil;
import com.cloud.sdk.commonutil.util.e;
import com.cloud.sdk.commonutil.util.h;
import com.hisavana.common.constant.ComConstants;
import com.transsion.core.utils.c;
import com.transsion.ga.AthenaAnalytics;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k7.b;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class AthenaTracker {
    private static boolean a = false;
    public static boolean b = true;
    public static SecureRandom c = new SecureRandom();
    private static String d = "";

    /* renamed from: com.cloud.hisavana.sdk.common.athena.AthenaTracker$8, reason: invalid class name */
    class AnonymousClass8 implements Runnable {
        final /* synthetic */ String val$requestId;

        AnonymousClass8(String str) {
            this.val$requestId = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.M(this.val$requestId);
        }
    }

    public static void A(AdsDTO adsDTO) {
        b.c(new 26(adsDTO));
    }

    public static void B(AdsDTO adsDTO, int i, int i2) {
        if (adsDTO == null || adsDTO.getExt() == null || !b.b(adsDTO.getExt().getLogEnable(), "halfScreenLogEnable")) {
            return;
        }
        b.c(new b(adsDTO, i, i2));
    }

    public static void C(String str, String str2, int i) {
        b.c(new 42(str, str2, i));
    }

    public static void D(AdsDTO adsDTO, boolean z) {
        b.c(new 36(adsDTO, z));
    }

    public static void E(AdsDTO adsDTO, String str, String str2, boolean z) {
        b.c(new 34(adsDTO, str, str2, z));
    }

    public static void F(String str, String str2, boolean z) {
        b.c(new 33(str, str2, z));
    }

    public static void G(String str, AdsDTO adsDTO, Boolean bool) {
        if (adsDTO == null || adsDTO.getSource() != 4) {
            if (adsDTO == null || !adsDTO.isFromJs()) {
                b.c(new 19(str, adsDTO, bool));
            }
        }
    }

    public static void H(AttrData attrData) {
        b.c(new f(attrData));
    }

    public static void I(int i, String str) {
        b.c(new 12(i, str));
    }

    public static void J(int i, String str, int i2, int i3, String str2, String str3) {
        b.c(new 13(i, str, i2, i3, str2, str3));
    }

    public static void K(AdsDTO adsDTO, String str, ClickJumpType clickJumpType) {
        b.c(new 10(adsDTO, str, clickJumpType));
    }

    public static void L(final String str) {
        b.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.6
            @Override // java.lang.Runnable
            public void run() {
                a.J(str);
            }
        });
    }

    public static void M(final String str, final int i) {
        b.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.7
            @Override // java.lang.Runnable
            public void run() {
                a.K(str, i);
            }
        });
    }

    public static void N(final AdsDTO adsDTO) {
        b.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.5
            @Override // java.lang.Runnable
            public void run() {
                a.L(adsDTO);
            }
        });
    }

    public static void O(AdsDTO adsDTO, FormBean formBean) {
        b.c(new 18(adsDTO, formBean));
    }

    public static void P(AdsDTO adsDTO, String str, String str2, int i) {
        b.c(new 25(adsDTO, str, str2, i));
    }

    public static void Q(AttrData attrData) {
        b.c(new c(attrData));
    }

    public static void R() {
        b.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.1
            @Override // java.lang.Runnable
            public void run() {
                a.R();
            }
        });
    }

    public static void S(final AdsDTO adsDTO, final int i) {
        b.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.29
            @Override // java.lang.Runnable
            public void run() {
                a.S(adsDTO, i);
            }
        });
    }

    public static void T(p3 p3Var, int i) {
        b.c(new 21(p3Var, i));
    }

    public static void U(AdsDTO adsDTO, int i) {
        b.c(new a(adsDTO, i));
    }

    public static void V(AdsDTO adsDTO, int i) {
        b.c(new g(adsDTO, i));
    }

    public static void W(AdsDTO adsDTO) {
        X(adsDTO, Boolean.FALSE);
    }

    public static void X(AdsDTO adsDTO, Boolean bool) {
        VastData videoInfo;
        ProgressData progressData;
        if (adsDTO == null || adsDTO.isFromJs()) {
            return;
        }
        if (adsDTO.isVastTypeAd() && (videoInfo = adsDTO.getVideoInfo()) != null && (progressData = videoInfo.getProgressData()) != null) {
            progressData.setVideoPlayTimeType(3);
            m0(adsDTO, progressData);
        }
        b.c(new 20(adsDTO, bool));
    }

    public static void Y(String str, int i, int i2) {
        b.c(new 41(str, i, i2));
    }

    public static void Z(AdsDTO adsDTO, boolean z) {
        b.c(new 4(adsDTO, z));
    }

    public static void a0(AdsDTO adsDTO) {
        b.c(new 3(adsDTO));
    }

    public static void b0(AdsDTO adsDTO) {
        if (adsDTO == null || !adsDTO.isFromJs()) {
            b.c(new 2(adsDTO));
        }
    }

    public static void c0(String str, int i, int i2, long j) {
        b.c(new 11(str, i, i2, j));
    }

    public static void d0(AdsDTO adsDTO, int i) {
        b.c(new 28(adsDTO, i));
    }

    public static void e0(AdsDTO adsDTO) {
        f0(adsDTO, null);
    }

    public static void f0(AdsDTO adsDTO, Integer num) {
        b.c(new 23(adsDTO, num));
    }

    public static void g0(AdxImpBean adxImpBean) {
        b.c(new 14(adxImpBean));
    }

    public static void h0(List list, TaErrorCode taErrorCode, AdxImpBean adxImpBean, int i, androidx.collection.b bVar) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add((AdsDTO) it.next());
            }
        }
        b.c(new 15(arrayList, taErrorCode, adxImpBean, i, bVar));
    }

    public static void i0(AdsDTO adsDTO, DiskTrackingBean diskTrackingBean, String str, int i, String str2, Throwable th) {
        if ((adsDTO == null || adsDTO.getExt() == null || !b.b(adsDTO.getExt().getLogEnable(), "showTrackingUrlsLogEnable")) && (diskTrackingBean == null || !diskTrackingBean.getShowTrackingUrlsLogEnable())) {
            return;
        }
        b.c(new e(adsDTO, diskTrackingBean, str, i, str2, th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j(Bundle bundle) {
        bundle.putInt("screen_angular", h.e() - 1);
    }

    public static void j0(String str, int i) {
        b.c(new 40(str, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(AdsDTO adsDTO, Bundle bundle) {
        if (adsDTO == null || bundle == null || adsDTO.getDisplayRule() != Constants.AdDisplayRule.RU) {
            return;
        }
        bundle.putString("compliance", "1");
    }

    public static void k0(AdsDTO adsDTO, TaErrorCode taErrorCode, int i, String str) {
        b.c(new 32(adsDTO, taErrorCode, i, str));
    }

    public static String l(Context context) {
        if (!TextUtils.isEmpty(d)) {
            return d;
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (!TextUtils.isEmpty(string)) {
                String trim = string.trim();
                String a2 = TextUtils.isEmpty(trim) ? "" : c.a(trim);
                d = a2;
                return a2;
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public static void l0(AdsDTO adsDTO, TaErrorCode taErrorCode) {
        b.c(new 31(adsDTO, taErrorCode));
    }

    public static Bundle m(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        PackageInfo c2 = h0.c(e.a());
        if (c2 != null) {
            bundle.putString("ps_version", String.valueOf(c2.versionCode));
        }
        bundle.putInt("net", MitNetUtil.c(e.a()) ? 1 : 0);
        bundle.putString("app_id", c7.b.b);
        return b.a(bundle);
    }

    public static void m0(AdsDTO adsDTO, ProgressData progressData) {
        b.c(new 39(adsDTO, progressData));
    }

    public static boolean n(Context context, int i) {
        if (i == 100) {
            return true;
        }
        String e = DeviceUtil.e();
        if (TextUtils.isEmpty(e)) {
            b = true;
        } else {
            b = false;
        }
        if (TextUtils.isEmpty(e)) {
            e = l(context);
        }
        if (TextUtils.isEmpty(e)) {
            return true;
        }
        int abs = Math.abs(e.hashCode()) % 100;
        return abs >= 0 && abs <= i;
    }

    public static void n0(String str, String str2, String str3, int i, String str4, String str5, int i2, long j) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        b.c(new 38(str, str2, str3, i, str4, str5, i2, j));
    }

    public static void o(boolean z, Context context) {
        if (a) {
            return;
        }
        try {
            AthenaAnalytics.a0(8765, ComConstants.PLATFORM_SSP + k7.c.l());
        } catch (Throwable unused) {
        }
        AthenaAnalytics.Q(context, "SSP", 2411, z, false);
        AthenaAnalytics.Q(context, "SSP", 8765, z, false);
        a = true;
    }

    public static void o0(String str, String str2, String str3, int i, int i2, long j) {
        if (i2 == -1 || !TextUtils.isEmpty(str2)) {
            b.c(new 37(str, str2, str3, i, i2, j));
        }
    }

    public static void p0(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        b.c(new 35(str, str2, str3, str4));
    }

    public static void q0(AdsDTO adsDTO) {
        b.c(new 17(adsDTO));
    }

    public static void w(AdsDTO adsDTO, long j) {
        b.c(new 24(adsDTO, j));
    }

    public static void x(final String str, final String str2, final String str3, final List list, final List list2, final boolean z, final int i) {
        b.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.30
            @Override // java.lang.Runnable
            public void run() {
                a.l(str, str2, str3, list, list2, z, i);
            }
        });
    }

    public static void y(AdsDTO adsDTO, String str) {
        b.c(new 27(adsDTO, str));
    }

    public static void z(int i, Integer num, Integer num2, AdsDTO adsDTO) {
        b.c(new d(i, num, num2, adsDTO));
    }
}
