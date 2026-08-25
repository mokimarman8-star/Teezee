package com.transsion.ad.ps.distribute;

import com.transsion.ad.ps.PSReportUtil;
import com.transsion.ad.ps.model.PsLinkDto;
import com.transsion.ad.ps.model.RecommendInfo;
import com.transsion.athena.config.data.model.TidConfigBean;
import com.transsion.gslb.BuildConfig;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
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

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.ps.distribute.PsDistributeRequestManager$getPsLinkListBySlot$2", f = "PsDistributeRequestManager.kt", l = {92, TidConfigBean.REASON_DB_EXCEPTION}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class PsDistributeRequestManager$getPsLinkListBySlot$2 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $nonId;
    final /* synthetic */ int $pageIndex;
    final /* synthetic */ int $pageSize;
    final /* synthetic */ Integer $psScene;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PsDistributeRequestManager$getPsLinkListBySlot$2(int i, int i2, Integer num, String str, Continuation<? super PsDistributeRequestManager$getPsLinkListBySlot$2> continuation) {
        super(2, continuation);
        this.$pageIndex = i;
        this.$pageSize = i2;
        this.$psScene = num;
        this.$nonId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PsDistributeRequestManager$getPsLinkListBySlot$2(this.$pageIndex, this.$pageSize, this.$psScene, this.$nonId, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        String k;
        ConcurrentHashMap concurrentHashMap;
        JSONObject l;
        zh.a o;
        String k2;
        Object h;
        List<RecommendInfo> data;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
            try {
            } catch (Exception e) {
                xh.a aVar = xh.a.a;
                k = PsDistributeRequestManager.a.k();
                xh.a.i(aVar, k + " --> getPsLinkList() --> psScene = " + this.$psScene + " --> it = " + e, 6, false, 4, null);
                PSReportUtil.a.d(PSReportUtil.PSRequestState.REQUEST_FAIL, null, String.valueOf(e.getMessage()), PSReportUtil.PsDistributeSceneEnum.PS_DISTRIBUTE_SCENE_AD_PLAN.getValue(), String.valueOf(this.$psScene));
            }
            if (i == 0) {
                ResultKt.b(obj);
                PsDistributeRequestManager psDistributeRequestManager = PsDistributeRequestManager.a;
                l = psDistributeRequestManager.l(this.$pageIndex, this.$pageSize, this.$psScene);
                f fVar = f.a;
                String str = fVar.d() ? "https://feature-api.palmplaystore.com" : "https://test-feature-api.palmplaystore.com";
                if (fVar.a()) {
                    xh.a aVar2 = xh.a.a;
                    k2 = psDistributeRequestManager.k();
                    xh.a.i(aVar2, k2 + " --> getPsLinkListBySlot() --> psScene = " + this.$psScene + " --> url = " + str + " --> jsonObject = " + l, 0, false, 6, null);
                }
                o = psDistributeRequestManager.o();
                b.a aVar3 = mg.b.a;
                String jSONObject = l.toString();
                Intrinsics.g(jSONObject, "toString(...)");
                RequestBody a = aVar3.a(jSONObject);
                this.label = 1;
                obj = o.b(a, str, this);
                if (obj == f) {
                    return f;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    return Unit.a;
                }
                ResultKt.b(obj);
            }
            PsLinkDto psLinkDto = (PsLinkDto) obj;
            PSReportUtil.a.d(PSReportUtil.PSRequestState.REQUEST_SUCCESS, (psLinkDto == null || (data = psLinkDto.getData()) == null) ? null : Boxing.d(data.size()), BuildConfig.FLAVOR, String.valueOf(this.$psScene), PSReportUtil.PsDistributeSceneEnum.PS_DISTRIBUTE_SCENE_AD_PLAN.getValue());
            PsDistributeRequestManager psDistributeRequestManager2 = PsDistributeRequestManager.a;
            String valueOf = String.valueOf(this.$psScene);
            String str2 = this.$nonId;
            this.label = 2;
            h = psDistributeRequestManager2.h(valueOf, str2, psLinkDto, this);
            if (h == f) {
                return f;
            }
            return Unit.a;
        } finally {
            concurrentHashMap = PsDistributeRequestManager.c;
            concurrentHashMap.remove(this.$psScene);
        }
    }
}
