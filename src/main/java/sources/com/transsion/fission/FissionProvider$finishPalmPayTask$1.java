package com.transsion.fission;

import android.app.Activity;
import com.therouter.TheRouter;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.bean.HomePopupEntity;
import com.transsion.bean.HomePopupInfo;
import com.transsion.fission.activity.bean.PalmPayTaskInfo;
import com.transsion.fission.activity.bean.PalmPayTaskResult;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.fission.FissionProvider$finishPalmPayTask$1", f = "FissionProvider.kt", l = {131}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class FissionProvider$finishPalmPayTask$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $subjectType;
    int label;
    final /* synthetic */ FissionProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FissionProvider$finishPalmPayTask$1(int i, FissionProvider fissionProvider, Continuation<? super FissionProvider$finishPalmPayTask$1> continuation) {
        super(2, continuation);
        this.$subjectType = i;
        this.this$0 = fissionProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(HomePopupEntity homePopupEntity) {
        wj.a aVar = (wj.a) TheRouter.d(wj.a.class, new Object[0]);
        if (aVar != null) {
            aVar.b(homePopupEntity, new Function1() { // from class: com.transsion.fission.o
                public final Object invoke(Object obj) {
                    Unit h;
                    h = FissionProvider$finishPalmPayTask$1.h(((Boolean) obj).booleanValue());
                    return h;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(boolean z) {
        return Unit.a;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FissionProvider$finishPalmPayTask$1(this.$subjectType, this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0081 A[Catch: all -> 0x0015, TRY_LEAVE, TryCatch #0 {all -> 0x0015, blocks: (B:5:0x000f, B:7:0x005f, B:9:0x0065, B:10:0x006b, B:12:0x0073, B:14:0x0079, B:16:0x0081, B:19:0x008b, B:21:0x0095, B:22:0x00a8, B:24:0x00b0, B:26:0x00b9, B:28:0x00db, B:30:0x009f, B:32:0x00e3, B:44:0x0027, B:46:0x0050), top: B:2:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b0 A[Catch: all -> 0x0015, TryCatch #0 {all -> 0x0015, blocks: (B:5:0x000f, B:7:0x005f, B:9:0x0065, B:10:0x006b, B:12:0x0073, B:14:0x0079, B:16:0x0081, B:19:0x008b, B:21:0x0095, B:22:0x00a8, B:24:0x00b0, B:26:0x00b9, B:28:0x00db, B:30:0x009f, B:32:0x00e3, B:44:0x0027, B:46:0x0050), top: B:2:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b9 A[Catch: all -> 0x0015, TryCatch #0 {all -> 0x0015, blocks: (B:5:0x000f, B:7:0x005f, B:9:0x0065, B:10:0x006b, B:12:0x0073, B:14:0x0079, B:16:0x0081, B:19:0x008b, B:21:0x0095, B:22:0x00a8, B:24:0x00b0, B:26:0x00b9, B:28:0x00db, B:30:0x009f, B:32:0x00e3, B:44:0x0027, B:46:0x0050), top: B:2:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0065 A[Catch: all -> 0x0015, TryCatch #0 {all -> 0x0015, blocks: (B:5:0x000f, B:7:0x005f, B:9:0x0065, B:10:0x006b, B:12:0x0073, B:14:0x0079, B:16:0x0081, B:19:0x008b, B:21:0x0095, B:22:0x00a8, B:24:0x00b0, B:26:0x00b9, B:28:0x00db, B:30:0x009f, B:32:0x00e3, B:44:0x0027, B:46:0x0050), top: B:2:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Throwable th2;
        BaseDto baseDto;
        Object a;
        PalmPayTaskInfo taskInfo;
        HomePopupInfo popup;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
        } catch (Throwable th3) {
            Result.Companion companion = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.a(th3));
        }
        if (i == 0) {
            ResultKt.b(obj);
            int i2 = this.$subjectType;
            FissionProvider fissionProvider = this.this$0;
            Result.Companion companion2 = Result.Companion;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("subjectType", i2);
            RequestBody.Companion companion3 = RequestBody.Companion;
            String jSONObject2 = jSONObject.toString();
            Intrinsics.g(jSONObject2, "toString(...)");
            RequestBody create = companion3.create(jSONObject2, MediaType.Companion.parse("application/json"));
            gk.b k = FissionProvider.k(fissionProvider);
            if (k == null) {
                baseDto = null;
                if (Intrinsics.c(baseDto == null ? baseDto.getCode() : null, "0") && baseDto.getData() != null) {
                    PalmPayTaskResult palmPayTaskResult = (PalmPayTaskResult) baseDto.getData();
                    taskInfo = palmPayTaskResult == null ? palmPayTaskResult.getTaskInfo() : null;
                    if (taskInfo != null || taskInfo.getProgress() < taskInfo.getTotalProgress()) {
                        c.a.b().putBoolean("kv_task_is_finished", false);
                    } else {
                        c.a.b().putBoolean("kv_task_is_finished", true);
                    }
                    PalmPayTaskResult palmPayTaskResult2 = (PalmPayTaskResult) baseDto.getData();
                    popup = palmPayTaskResult2 == null ? palmPayTaskResult2.getPopup() : null;
                    if (popup != null) {
                        final HomePopupEntity homePopupEntity = new HomePopupEntity(popup, new HomePopupInfo(0L, BuildConfig.FLAVOR, 0, BuildConfig.FLAVOR, 0, BuildConfig.FLAVOR, BuildConfig.FLAVOR), 0, 0L);
                        Activity b = com.blankj.utilcode.util.a.b();
                        if (b != null) {
                            b.runOnUiThread(new Runnable() { // from class: com.transsion.fission.n
                                @Override // java.lang.Runnable
                                public final void run() {
                                    FissionProvider$finishPalmPayTask$1.g(HomePopupEntity.this);
                                }
                            });
                        }
                    }
                }
                obj2 = Result.constructor-impl(Unit.a);
                th2 = Result.exceptionOrNull-impl(obj2);
                if (th2 != null) {
                    a.a.m(wf.a.a, "finishPalmPayTask() ---> getOrElse() --> it = " + th2, false, 2, (Object) null);
                }
                return Unit.a;
            }
            String a2 = gg.a.a.a();
            this.label = 1;
            a = k.a(a2, create, this);
            if (a == f) {
                return f;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            a = obj;
        }
        baseDto = (BaseDto) a;
        if (Intrinsics.c(baseDto == null ? baseDto.getCode() : null, "0")) {
            PalmPayTaskResult palmPayTaskResult3 = (PalmPayTaskResult) baseDto.getData();
            if (palmPayTaskResult3 == null) {
            }
            if (taskInfo != null) {
            }
            c.a.b().putBoolean("kv_task_is_finished", false);
            PalmPayTaskResult palmPayTaskResult22 = (PalmPayTaskResult) baseDto.getData();
            if (palmPayTaskResult22 == null) {
            }
            if (popup != null) {
            }
        }
        obj2 = Result.constructor-impl(Unit.a);
        th2 = Result.exceptionOrNull-impl(obj2);
        if (th2 != null) {
        }
        return Unit.a;
    }
}
