package com.transsion.push.tpush;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.transsion.gslb.BuildConfig;
import com.transsion.upload.log.UploadLoggerManager;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.push.tpush.PushRegisterManager$handleTransData$1$1", f = "PushRegisterManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class PushRegisterManager$handleTransData$1$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $it;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PushRegisterManager$handleTransData$1$1(String str, Continuation<? super PushRegisterManager$handleTransData$1$1> continuation) {
        super(2, continuation);
        this.$it = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PushRegisterManager$handleTransData$1$1(this.$it, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        String asString;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        JsonObject asJsonObject = JsonParser.parseString(this.$it).getAsJsonObject();
        JsonElement jsonElement = asJsonObject != null ? asJsonObject.get("clientLogsRetrieve") : null;
        a.a.f(wf.a.a, "PushRegisterManager", "clientLogsRetrieve=" + jsonElement, false, 4, (Object) null);
        if (jsonElement == null || (asString = jsonElement.getAsString()) == null) {
            str = null;
        } else {
            str = asString.toLowerCase(Locale.ROOT);
            Intrinsics.g(str, "toLowerCase(...)");
        }
        if (Intrinsics.c(str, "true")) {
            UploadLoggerManager.l(UploadLoggerManager.a, (uu.a) null, 1, (Object) null);
        }
        return Unit.a;
    }
}
