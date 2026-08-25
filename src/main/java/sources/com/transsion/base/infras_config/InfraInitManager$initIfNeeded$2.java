package com.transsion.base.infras_config;

import com.transsion.base.infras_config.model.ConfigInitData;
import com.transsion.base.infras_config.model.ConfigLocalState;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import pi.b;
import wf.a;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/n0;", "Lkotlin/Result;", "Lcom/transsion/base/infras_config/model/ConfigInitData;", "<anonymous>", "(Lkotlinx/coroutines/n0;)Lkotlin/Result;"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.base.infras_config.InfraInitManager$initIfNeeded$2", f = "InfraInitManager.kt", l = {154}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class InfraInitManager$initIfNeeded$2 extends SuspendLambda implements Function2<n0, Continuation<? super Result<? extends ConfigInitData>>, Object> {
    final /* synthetic */ String $baseUrl;
    final /* synthetic */ long $minIntervalMs;
    final /* synthetic */ List<ConfigLocalState> $sourceVersions;
    final /* synthetic */ String $version;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InfraInitManager$initIfNeeded$2(long j, List<ConfigLocalState> list, String str, String str2, Continuation<? super InfraInitManager$initIfNeeded$2> continuation) {
        super(2, continuation);
        this.$minIntervalMs = j;
        this.$sourceVersions = list;
        this.$version = str;
        this.$baseUrl = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InfraInitManager$initIfNeeded$2(this.$minIntervalMs, this.$sourceVersions, this.$version, this.$baseUrl, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Result<ConfigInitData>> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            long currentTimeMillis = System.currentTimeMillis();
            b bVar = b.a;
            long d = bVar.d();
            if (d <= 0 || currentTimeMillis - d >= this.$minIntervalMs) {
                a.a.f(wf.a.a, "InfraInitManager", "initIfNeeded() expired or never initialized, will request from network", false, 4, (Object) null);
            } else {
                ConfigInitData b = bVar.b(this.$sourceVersions);
                if (b != null) {
                    a.a.x(wf.a.a, "InfraInitManager", "initIfNeeded() hit cache, sourceCount=" + this.$sourceVersions.size() + ", version=" + this.$version, false, 4, (Object) null);
                    return Result.box-impl(Result.constructor-impl(b));
                }
                a.a.x(wf.a.a, "InfraInitManager", "initIfNeeded() cache miss, will request from network", false, 4, (Object) null);
            }
            InfraInitManager infraInitManager = InfraInitManager.a;
            List<ConfigLocalState> list = this.$sourceVersions;
            String str = this.$version;
            String str2 = this.$baseUrl;
            this.label = 1;
            Object e = infraInitManager.e(list, str, str2, this);
            if (e == f) {
                return f;
            }
            obj2 = e;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            obj2 = ((Result) obj).unbox-impl();
        }
        return Result.box-impl(obj2);
    }
}
