package com.transsion.ad.ps.activate;

import android.os.SystemClock;
import com.transsion.ad.ps.PSReportUtil;
import com.transsion.gslb.BuildConfig;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import mg.b;
import okhttp3.RequestBody;
import org.json.JSONObject;
import rh.f;
import tg.b;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.ps.activate.PSActivateRequest$getPsActivateList$2", f = "PSActivateRequest.kt", l = {86, 107, 124}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class PSActivateRequest$getPsActivateList$2 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    PSActivateRequest$getPsActivateList$2(Continuation<? super PSActivateRequest$getPsActivateList$2> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PSActivateRequest$getPsActivateList$2(continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00f1 A[Catch: all -> 0x001c, TryCatch #0 {all -> 0x001c, blocks: (B:7:0x0017, B:8:0x0167, B:19:0x002b, B:21:0x00e7, B:23:0x00f1, B:25:0x00fb, B:27:0x0101, B:28:0x010b, B:30:0x012c, B:32:0x0132, B:34:0x0138, B:35:0x0145, B:37:0x0156, B:38:0x015c, B:44:0x003f, B:46:0x0070, B:49:0x0080, B:51:0x0086, B:52:0x00b0, B:57:0x004a), top: B:2:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0156 A[Catch: all -> 0x001c, TryCatch #0 {all -> 0x001c, blocks: (B:7:0x0017, B:8:0x0167, B:19:0x002b, B:21:0x00e7, B:23:0x00f1, B:25:0x00fb, B:27:0x0101, B:28:0x010b, B:30:0x012c, B:32:0x0132, B:34:0x0138, B:35:0x0145, B:37:0x0156, B:38:0x015c, B:44:0x003f, B:46:0x0070, B:49:0x0080, B:51:0x0086, B:52:0x00b0, B:57:0x004a), top: B:2:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0166 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x015b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Throwable th2;
        String f;
        AtomicBoolean atomicBoolean;
        JSONObject jSONObject;
        String str;
        Object c;
        JSONObject jSONObject2;
        String str2;
        zh.a h;
        Object a;
        String f2;
        PSActivateManager pSActivateManager;
        List<PsActivateBean> data;
        List<PsActivateBean> data2;
        String f3;
        List<PsActivateBean> data3;
        AtomicBoolean atomicBoolean2;
        Object f4 = IntrinsicsKt.f();
        int i = this.label;
        try {
        } catch (Throwable th3) {
            Result.Companion companion = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.a(th3));
        }
        if (i == 0) {
            ResultKt.b(obj);
            Result.Companion companion2 = Result.Companion;
            jSONObject = new JSONObject();
            jSONObject.put("gaid", b.a.i());
            str = "pkgList";
            PSActivateManager pSActivateManager2 = PSActivateManager.a;
            this.L$0 = jSONObject;
            this.L$1 = "pkgList";
            this.L$2 = jSONObject;
            this.label = 1;
            c = pSActivateManager2.c(this);
            if (c == f4) {
                return f4;
            }
            jSONObject2 = jSONObject;
        } else {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    atomicBoolean2 = PSActivateRequest.c;
                    atomicBoolean2.set(false);
                    obj2 = Result.constructor-impl(Unit.a);
                    th2 = Result.exceptionOrNull-impl(obj2);
                    if (th2 != null) {
                        xh.a aVar = xh.a.a;
                        f = PSActivateRequest.a.f();
                        xh.a.k(aVar, f + " --> getPsActivateList() --> it = " + th2, 6, false, 4, null);
                        atomicBoolean = PSActivateRequest.c;
                        atomicBoolean.set(false);
                        PSActivateRequest.d = SystemClock.elapsedRealtime() - 6900000;
                    }
                    return Unit.a;
                }
                String str3 = (String) this.L$0;
                ResultKt.b(obj);
                str2 = str3;
                a = obj;
                PsActivateDto psActivateDto = (PsActivateDto) a;
                if (f.a.a()) {
                    xh.a aVar2 = xh.a.a;
                    f3 = PSActivateRequest.a.f();
                    xh.a.k(aVar2, f3 + " --> getPsActivateList() --> url = " + str2 + " --> postPsRecommendList = " + ((psActivateDto == null || (data3 = psActivateDto.getData()) == null) ? null : Boxing.d(data3.size())), 0, false, 6, null);
                }
                PSReportUtil.a.d(PSReportUtil.PSRequestState.REQUEST_SUCCESS, (psActivateDto != null || (data2 = psActivateDto.getData()) == null) ? null : Boxing.d(data2.size()), null, BuildConfig.FLAVOR, PSReportUtil.PsDistributeSceneEnum.PS_DISTRIBUTE_SCENE_ACTIVATE.getValue());
                pSActivateManager = PSActivateManager.a;
                data = psActivateDto == null ? psActivateDto.getData() : null;
                this.L$0 = null;
                this.label = 3;
                if (pSActivateManager.f(data, this) == f4) {
                    return f4;
                }
                atomicBoolean2 = PSActivateRequest.c;
                atomicBoolean2.set(false);
                obj2 = Result.constructor-impl(Unit.a);
                th2 = Result.exceptionOrNull-impl(obj2);
                if (th2 != null) {
                }
                return Unit.a;
            }
            jSONObject = (JSONObject) this.L$2;
            String str4 = (String) this.L$1;
            JSONObject jSONObject3 = (JSONObject) this.L$0;
            ResultKt.b(obj);
            jSONObject2 = jSONObject3;
            str = str4;
            c = obj;
        }
        jSONObject.put(str, c);
        f fVar = f.a;
        str2 = fVar.d() ? "https://feature-api.palmplaystore.com" : "https://test-feature-api.palmplaystore.com";
        if (fVar.a()) {
            xh.a aVar3 = xh.a.a;
            f2 = PSActivateRequest.a.f();
            xh.a.k(aVar3, f2 + " --> getPsActivateList() --> url = " + str2 + " --> jsonObject = " + jSONObject2, 0, false, 6, null);
        }
        PSReportUtil.a.d(PSReportUtil.PSRequestState.REQUEST_TRIGGER, null, null, BuildConfig.FLAVOR, PSReportUtil.PsDistributeSceneEnum.PS_DISTRIBUTE_SCENE_ACTIVATE.getValue());
        h = PSActivateRequest.a.h();
        b.a aVar4 = mg.b.a;
        String jSONObject4 = jSONObject2.toString();
        Intrinsics.g(jSONObject4, "toString(...)");
        RequestBody a2 = aVar4.a(jSONObject4);
        this.L$0 = str2;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 2;
        a = h.a(a2, str2, this);
        if (a == f4) {
            return f4;
        }
        PsActivateDto psActivateDto2 = (PsActivateDto) a;
        if (f.a.a()) {
        }
        PSReportUtil.a.d(PSReportUtil.PSRequestState.REQUEST_SUCCESS, (psActivateDto2 != null || (data2 = psActivateDto2.getData()) == null) ? null : Boxing.d(data2.size()), null, BuildConfig.FLAVOR, PSReportUtil.PsDistributeSceneEnum.PS_DISTRIBUTE_SCENE_ACTIVATE.getValue());
        pSActivateManager = PSActivateManager.a;
        if (psActivateDto2 == null) {
        }
        this.L$0 = null;
        this.label = 3;
        if (pSActivateManager.f(data, this) == f4) {
        }
        atomicBoolean2 = PSActivateRequest.c;
        atomicBoolean2.set(false);
        obj2 = Result.constructor-impl(Unit.a);
        th2 = Result.exceptionOrNull-impl(obj2);
        if (th2 != null) {
        }
        return Unit.a;
    }
}
