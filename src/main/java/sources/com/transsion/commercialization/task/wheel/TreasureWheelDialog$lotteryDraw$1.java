package com.transsion.commercialization.task.wheel;

import android.content.Context;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.JsonObject;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.bean.lottery.LotteryDrawResultEntity;
import com.transsion.bean.lottery.LotteryUserActivityInfoActivityBean;
import com.transsion.bean.lottery.LotteryUserActivityInfoEntity;
import com.transsion.bean.lottery.LotteryUserActivityInfoPriceBean;
import com.transsion.commercialization.task.treasure.b;
import com.transsion.gslb.BuildConfig;
import com.transsion.wrapperad.R;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.u0;
import okhttp3.MediaType;
import okhttp3.RequestBody;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.commercialization.task.wheel.TreasureWheelDialog$lotteryDraw$1", f = "TreasureWheelDialog.kt", l = {166, 168}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class TreasureWheelDialog$lotteryDraw$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ TreasureWheelDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TreasureWheelDialog$lotteryDraw$1(TreasureWheelDialog treasureWheelDialog, Continuation<? super TreasureWheelDialog$lotteryDraw$1> continuation) {
        super(2, continuation);
        this.this$0 = treasureWheelDialog;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TreasureWheelDialog$lotteryDraw$1 treasureWheelDialog$lotteryDraw$1 = new TreasureWheelDialog$lotteryDraw$1(this.this$0, continuation);
        treasureWheelDialog$lotteryDraw$1.L$0 = obj;
        return treasureWheelDialog$lotteryDraw$1;
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00f8 A[Catch: all -> 0x001e, TryCatch #0 {all -> 0x001e, blocks: (B:7:0x0019, B:8:0x00e6, B:10:0x00ec, B:12:0x00f0, B:14:0x00f8, B:15:0x00fc, B:16:0x0101, B:34:0x002d, B:35:0x00a3, B:37:0x00af, B:39:0x00b5, B:41:0x00bb, B:42:0x00c1, B:48:0x003b, B:50:0x0064, B:52:0x006a, B:53:0x0070), top: B:2:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        sj.f fVar;
        LuckyWheelView luckyWheelView;
        LotteryUserActivityInfoEntity lotteryUserActivityInfoEntity;
        com.transsion.commercialization.task.treasure.b x0;
        TreasureWheelDialog treasureWheelDialog;
        LotteryUserActivityInfoActivityBean activity;
        TreasureWheelDialog treasureWheelDialog2;
        BaseDto baseDto;
        LotteryDrawResultEntity.LotteryResultBean result;
        LotteryUserActivityInfoPriceBean price;
        sj.f fVar2;
        LuckyWheelView luckyWheelView2;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
        } catch (Throwable th2) {
            Result.Companion companion = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.a(th2));
        }
        if (i == 0) {
            ResultKt.b(obj);
            TreasureWheelDialog treasureWheelDialog3 = this.this$0;
            Result.Companion companion2 = Result.Companion;
            wj.h.a.a(treasureWheelDialog3.getClassTag() + " --> lotteryDraw() --> 调用服务端抽奖接口");
            JsonObject jsonObject = new JsonObject();
            lotteryUserActivityInfoEntity = treasureWheelDialog3.lotteryUserActivityInfoBean;
            jsonObject.addProperty("activityId", (lotteryUserActivityInfoEntity == null || (activity = lotteryUserActivityInfoEntity.getActivity()) == null) ? null : activity.getId());
            jsonObject.addProperty("idempotentKey", "idempotentKey");
            RequestBody.Companion companion3 = RequestBody.Companion;
            String jsonElement = jsonObject.toString();
            Intrinsics.g(jsonElement, "toString(...)");
            RequestBody create = companion3.create(jsonElement, MediaType.Companion.parse("application/json"));
            x0 = treasureWheelDialog3.x0();
            this.L$0 = treasureWheelDialog3;
            this.label = 1;
            Object c = b.a.c(x0, null, create, this, 1, null);
            if (c == f) {
                return f;
            }
            treasureWheelDialog = treasureWheelDialog3;
            obj = c;
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                baseDto = (BaseDto) this.L$1;
                treasureWheelDialog2 = (TreasureWheelDialog) this.L$0;
                ResultKt.b(obj);
                fVar2 = treasureWheelDialog2.bind;
                if (fVar2 != null && (luckyWheelView2 = fVar2.c) != null) {
                    LotteryDrawResultEntity lotteryDrawResultEntity = (LotteryDrawResultEntity) baseDto.getData();
                    luckyWheelView2.endIndicator(lotteryDrawResultEntity != null ? lotteryDrawResultEntity.getResult() : null);
                    r5 = Unit.a;
                }
                obj2 = Result.constructor-impl(r5);
                TreasureWheelDialog treasureWheelDialog4 = this.this$0;
                if (Result.exceptionOrNull-impl(obj2) != null) {
                    Context context = treasureWheelDialog4.getContext();
                    if (context != null) {
                        ToastUtils.s(androidx.core.content.b.getString(context, R.string.treasure_something_went_wrong_please_retry), new Object[0]);
                    }
                    fVar = treasureWheelDialog4.bind;
                    if (fVar != null && (luckyWheelView = fVar.c) != null) {
                        luckyWheelView.resetIndicator();
                    }
                }
                return Unit.a;
            }
            treasureWheelDialog = (TreasureWheelDialog) this.L$0;
            ResultKt.b(obj);
        }
        BaseDto baseDto2 = (BaseDto) obj;
        com.transsion.commercialization.pslink.a aVar = com.transsion.commercialization.pslink.a.a;
        LotteryDrawResultEntity lotteryDrawResultEntity2 = (LotteryDrawResultEntity) baseDto2.getData();
        aVar.b("中奖了 --> lotteryDraw = " + ((lotteryDrawResultEntity2 == null || (result = lotteryDrawResultEntity2.getResult()) == null || (price = result.getPrice()) == null) ? null : price.getId()));
        this.L$0 = treasureWheelDialog;
        this.L$1 = baseDto2;
        this.label = 2;
        if (u0.a(1000L, this) == f) {
            return f;
        }
        treasureWheelDialog2 = treasureWheelDialog;
        baseDto = baseDto2;
        fVar2 = treasureWheelDialog2.bind;
        if (fVar2 != null) {
            LotteryDrawResultEntity lotteryDrawResultEntity3 = (LotteryDrawResultEntity) baseDto.getData();
            luckyWheelView2.endIndicator(lotteryDrawResultEntity3 != null ? lotteryDrawResultEntity3.getResult() : null);
            r5 = Unit.a;
        }
        obj2 = Result.constructor-impl(r5);
        TreasureWheelDialog treasureWheelDialog42 = this.this$0;
        if (Result.exceptionOrNull-impl(obj2) != null) {
        }
        return Unit.a;
    }
}
