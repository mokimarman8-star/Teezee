package com.transsion.wrapperad;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.ad.MBAd;
import com.transsion.ad.strategy.AdOverridePendingTransitionManager;
import com.transsion.baselib.report.k;
import com.transsion.memberapi.MemberSource;
import com.transsion.wrapperad.h5.H5InterstitialAdProvider;
import com.transsion.wrapperad.h5.H5VideoAdProvider;
import com.transsion.wrapperadapi.H5AdStateEnum;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mf.c;
import org.json.JSONObject;
import rh.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class WrapperAdProvider implements vw.b {
    public static final a a = new a((DefaultConstructorMarker) null);

    public static final class b implements a {
        b() {
        }

        public void a(String str, AdOverridePendingTransitionManager.AdOverridePendingTransitionEnum adOverridePendingTransitionEnum) {
            Pair a = AdOverridePendingTransitionManager.a.a(adOverridePendingTransitionEnum);
            Activity o = k.a.o();
            Navigator K = TheRouter.c("/web/web").K("url", str).K("page_from", "MB_AD");
            if (o == null || o.isFinishing() || o.isDestroyed()) {
                ij.k.p(K);
                return;
            }
            if (a != null) {
                o.overridePendingTransition(((Number) a.getFirst()).intValue(), ((Number) a.getSecond()).intValue());
            }
            Navigator.x(K, o, (c) null, 2, (Object) null);
        }

        public void b(String str) {
            Object m34constructorimpl;
            if (str != null) {
                try {
                    Result.Companion companion = Result.Companion;
                    if (Build.VERSION.SDK_INT < 36) {
                        ql.a.a.d(str);
                    }
                    m34constructorimpl = Result.m34constructorimpl(Unit.a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    m34constructorimpl = Result.m34constructorimpl(ResultKt.a(th));
                }
                Result.m33boximpl(m34constructorimpl);
            }
        }

        public void c(String str) {
            im.b bVar;
            Intrinsics.h(str, "sceneId");
            Activity b = com.blankj.utilcode.util.a.b();
            if (b == null || (bVar = (im.b) TheRouter.d(im.b.class, new Object[0])) == null) {
                return;
            }
            bVar.u(b, MemberSource.SOURCE_AD, null, false, str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00b5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // vw.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(kotlin.coroutines.Continuation r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.transsion.wrapperad.WrapperAdProvider$initAd$1
            if (r0 == 0) goto L13
            r0 = r9
            com.transsion.wrapperad.WrapperAdProvider$initAd$1 r0 = (com.transsion.wrapperad.WrapperAdProvider$initAd$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.wrapperad.WrapperAdProvider$initAd$1 r0 = new com.transsion.wrapperad.WrapperAdProvider$initAd$1
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L41
            if (r2 == r6) goto L3d
            if (r2 == r5) goto L39
            if (r2 != r4) goto L31
            kotlin.ResultKt.b(r9)
            goto Lb6
        L31:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L39:
            kotlin.ResultKt.b(r9)
            goto La4
        L3d:
            kotlin.ResultKt.b(r9)
            goto L56
        L41:
            kotlin.ResultKt.b(r9)
            kotlinx.coroutines.a2 r9 = kotlinx.coroutines.y0.c()
            com.transsion.wrapperad.WrapperAdProvider$initAd$2 r2 = new com.transsion.wrapperad.WrapperAdProvider$initAd$2
            r2.<init>(r3)
            r0.label = r6
            java.lang.Object r9 = kotlinx.coroutines.i.g(r9, r2, r0)
            if (r9 != r1) goto L56
            return r1
        L56:
            com.transsion.ad.MBAd r9 = com.transsion.ad.MBAd.a
            com.transsion.ad.MBAd$b r2 = new com.transsion.ad.MBAd$b
            r2.<init>()
            java.lang.String r7 = "2301069UF9YjuO"
            com.transsion.ad.MBAd$b r2 = r2.f(r7)
            r7 = 0
            com.transsion.ad.MBAd$b r2 = r2.c(r7)
            com.transsion.ad.MBAd$b r2 = r2.h(r7)
            com.transsion.ad.strategy.AppManager$AppEnum r7 = com.transsion.ad.strategy.AppManager.AppEnum.APP_MOVIE_BOX
            com.transsion.ad.MBAd$b r2 = r2.d(r7)
            java.lang.String r7 = "HotStartScene"
            com.transsion.ad.MBAd$b r2 = r2.g(r7)
            java.lang.String r7 = "/wefeed-mobile-bff/ad/config"
            com.transsion.ad.MBAd$b r2 = r2.b(r7)
            com.transsion.ad.MBAd$b r2 = r2.i(r6)
            com.transsion.ad.MBAd$b r2 = r2.j(r6)
            com.transsion.ad.MBAd$b r2 = r2.k(r6)
            com.transsion.ad.MBAd$b r2 = r2.l(r6)
            com.transsion.wrapperad.WrapperAdProvider$b r6 = new com.transsion.wrapperad.WrapperAdProvider$b
            r6.<init>()
            com.transsion.ad.MBAd$b r2 = r2.e(r6)
            com.transsion.ad.MBAd$a r2 = r2.a()
            r0.label = r5
            java.lang.Object r9 = r9.d(r2, r0)
            if (r9 != r1) goto La4
            return r1
        La4:
            kotlinx.coroutines.a2 r9 = kotlinx.coroutines.y0.c()
            com.transsion.wrapperad.WrapperAdProvider$initAd$4 r2 = new com.transsion.wrapperad.WrapperAdProvider$initAd$4
            r2.<init>(r3)
            r0.label = r4
            java.lang.Object r9 = kotlinx.coroutines.i.g(r9, r2, r0)
            if (r9 != r1) goto Lb6
            return r1
        Lb6:
            kotlin.Unit r9 = kotlin.Unit.a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.wrapperad.WrapperAdProvider.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // vw.b
    public void b(String str, vw.a aVar) {
        Object m34constructorimpl;
        JSONObject jSONObject;
        String optString;
        Intrinsics.h(aVar, "callback");
        if (TextUtils.isEmpty(str)) {
            aVar.onAdStateCallback(H5AdStateEnum.MB_H5_AD_STATE_ON_FAIL.getValue(), "adConfig is empty");
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            if (str == null) {
                str = "{}";
            }
            jSONObject = new JSONObject(str);
            optString = jSONObject.optString("sceneId");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m34constructorimpl = Result.m34constructorimpl(ResultKt.a(th));
        }
        if (TextUtils.isEmpty(optString)) {
            aVar.onAdStateCallback(H5AdStateEnum.MB_H5_AD_STATE_ON_FAIL.getValue(), "sceneId is empty");
            return;
        }
        int optInt = jSONObject.optInt("adType");
        if (optInt == 3) {
            H5VideoAdProvider.a.h(optString, aVar);
        } else if (optInt == 4) {
            H5InterstitialAdProvider.a.f(optString, aVar);
        }
        m34constructorimpl = Result.m34constructorimpl(Unit.a);
        Throwable m37exceptionOrNullimpl = Result.m37exceptionOrNullimpl(m34constructorimpl);
        if (m37exceptionOrNullimpl == null) {
            return;
        }
        aVar.onAdStateCallback(H5AdStateEnum.MB_H5_AD_STATE_ON_FAIL.getValue(), m37exceptionOrNullimpl.getMessage());
    }

    @Override // vw.b
    public Object c(Continuation continuation) {
        Object e = MBAd.a.e("/wefeed-mobile-bff/ad/config", continuation);
        return e == IntrinsicsKt.f() ? e : Unit.a;
    }
}
