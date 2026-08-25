package com.transsion.ad.monopoly.manager;

import android.text.TextUtils;
import ci.f;
import com.blankj.utilcode.util.o;
import com.tencent.mmkv.MMKV;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.model.MbAdPlansBean;
import com.transsion.ad.monopoly.model.MbAdPlansDto;
import com.transsion.ad.strategy.e;
import com.transsion.gslb.BuildConfig;
import java.util.List;
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
import xh.b;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.monopoly.manager.AdPlansAssetsManager$innerCopy$2", f = "AdPlansAssetsManager.kt", l = {31, 45}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class AdPlansAssetsManager$innerCopy$2 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;

    AdPlansAssetsManager$innerCopy$2(Continuation<? super AdPlansAssetsManager$innerCopy$2> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdPlansAssetsManager$innerCopy$2(continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x008b A[Catch: all -> 0x0016, TryCatch #0 {all -> 0x0016, blocks: (B:7:0x0012, B:8:0x007c, B:10:0x008b, B:11:0x0091, B:13:0x009c, B:15:0x00a2, B:16:0x00ac, B:18:0x00b2, B:19:0x00b6, B:20:0x00e6, B:32:0x0021, B:33:0x0035, B:35:0x003b, B:38:0x0042, B:39:0x0051, B:41:0x005f, B:45:0x00d9, B:47:0x0028), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b2 A[Catch: all -> 0x0016, TryCatch #0 {all -> 0x0016, blocks: (B:7:0x0012, B:8:0x007c, B:10:0x008b, B:11:0x0091, B:13:0x009c, B:15:0x00a2, B:16:0x00ac, B:18:0x00b2, B:19:0x00b6, B:20:0x00e6, B:32:0x0021, B:33:0x0035, B:35:0x003b, B:38:0x0042, B:39:0x0051, B:41:0x005f, B:45:0x00d9, B:47:0x0028), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Throwable th2;
        MbAdPlansDto e;
        Object f;
        MbAdPlansDto mbAdPlansDto;
        List<AdPlans> adPlans;
        Object f2 = IntrinsicsKt.f();
        int i = this.label;
        try {
        } catch (Throwable th3) {
            Result.Companion companion = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.a(th3));
        }
        if (i == 0) {
            ResultKt.b(obj);
            Result.Companion companion2 = Result.Companion;
            AdPlansStorageManager adPlansStorageManager = AdPlansStorageManager.a;
            this.label = 1;
            obj = adPlansStorageManager.g(this);
            if (obj == f2) {
                return f2;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mbAdPlansDto = (MbAdPlansDto) this.L$0;
                ResultKt.b(obj);
                MMKV c = e.a.c();
                MbAdPlansBean data = mbAdPlansDto.getData();
                c.putString("non_ad_plan_version", data == null ? data.getVersion() : null);
                AdPlansAssetsManager adPlansAssetsManager = AdPlansAssetsManager.b;
                MbAdPlansBean data2 = mbAdPlansDto.getData();
                Integer d = (data2 != null || (adPlans = data2.getAdPlans()) == null) ? null : Boxing.d(adPlans.size());
                MbAdPlansBean data3 = mbAdPlansDto.getData();
                b.a.c(adPlansAssetsManager, 4, "innerCopy() --> success --> adPlans?.size -- " + d + " --> adPlans = " + (data3 != null ? data3.getAdPlans() : null), null, false, 12, null);
                obj2 = Result.constructor-impl(Unit.a);
                th2 = Result.exceptionOrNull-impl(obj2);
                if (th2 != null) {
                    b.a.c(AdPlansAssetsManager.b, 6, "innerCopy() --> 保存本地数据异常 -- error error error --> it = " + th2, null, false, 12, null);
                }
                return Unit.a;
            }
            ResultKt.b(obj);
        }
        List list = (List) obj;
        if (list != null && !list.isEmpty()) {
            b.a.c(AdPlansAssetsManager.b, 4, "innerCopy() --> 本地存在非标广告计划，不需要从assets下载", null, false, 12, null);
            obj2 = Result.constructor-impl(Unit.a);
            th2 = Result.exceptionOrNull-impl(obj2);
            if (th2 != null) {
            }
            return Unit.a;
        }
        String b = f.a.b("local_non_ad_plan.json");
        if (TextUtils.isEmpty(b)) {
            b.a.c(AdPlansAssetsManager.b, 6, "innerCopy() --> assets数据 -- 保存数据库失败 -- fail fail fail -- readAssets = null", null, false, 12, null);
            obj2 = Result.constructor-impl(Unit.a);
            th2 = Result.exceptionOrNull-impl(obj2);
            if (th2 != null) {
            }
            return Unit.a;
        }
        MbAdPlansDto mbAdPlansDto2 = (MbAdPlansDto) o.d(b, MbAdPlansDto.class);
        AdPlansAssetsManager adPlansAssetsManager2 = AdPlansAssetsManager.b;
        Intrinsics.e(mbAdPlansDto2);
        e = adPlansAssetsManager2.e(mbAdPlansDto2);
        this.L$0 = e;
        this.label = 2;
        f = adPlansAssetsManager2.f(e, this);
        if (f == f2) {
            return f2;
        }
        mbAdPlansDto = e;
        MMKV c2 = e.a.c();
        MbAdPlansBean data4 = mbAdPlansDto.getData();
        c2.putString("non_ad_plan_version", data4 == null ? data4.getVersion() : null);
        AdPlansAssetsManager adPlansAssetsManager3 = AdPlansAssetsManager.b;
        MbAdPlansBean data22 = mbAdPlansDto.getData();
        if (data22 != null) {
        }
        MbAdPlansBean data32 = mbAdPlansDto.getData();
        if (data32 != null) {
        }
        b.a.c(adPlansAssetsManager3, 4, "innerCopy() --> success --> adPlans?.size -- " + d + " --> adPlans = " + (data32 != null ? data32.getAdPlans() : null), null, false, 12, null);
        obj2 = Result.constructor-impl(Unit.a);
        th2 = Result.exceptionOrNull-impl(obj2);
        if (th2 != null) {
        }
        return Unit.a;
    }
}
