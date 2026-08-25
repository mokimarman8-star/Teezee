package com.transsion.player.longvideo.ui.dialog;

import com.therouter.TheRouter;
import com.transsion.gslb.BuildConfig;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.player.longvideo.ui.dialog.LongVdPlayerConfigDialog$onViewCreated$1$1$1", f = "LongVdPlayerConfigDialog.kt", l = {137}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class LongVdPlayerConfigDialog$onViewCreated$1$1$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ ln.b $config;
    int label;
    final /* synthetic */ LongVdPlayerConfigDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LongVdPlayerConfigDialog$onViewCreated$1$1$1(ln.b bVar, LongVdPlayerConfigDialog longVdPlayerConfigDialog, Continuation<? super LongVdPlayerConfigDialog$onViewCreated$1$1$1> continuation) {
        super(2, continuation);
        this.$config = bVar;
        this.this$0 = longVdPlayerConfigDialog;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LongVdPlayerConfigDialog$onViewCreated$1$1$1(this.$config, this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object obj) {
        ln.a aVar;
        String str;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
            int m = bVar != null ? bVar.m() : 0;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("module_name", "clarity");
            linkedHashMap.put("type", this.$config.d());
            aVar = this.this$0.longVdPlayerBean;
            linkedHashMap.put("subject_id", aVar != null ? aVar.o() : null);
            linkedHashMap.put("is_member", String.valueOf(m));
            qi.h hVar = qi.h.a;
            str = this.this$0.pageName;
            if (str == null) {
                str = "vip_resolution";
            }
            hVar.o(str, linkedHashMap);
            LongVdPlayerConfigDialog longVdPlayerConfigDialog = this.this$0;
            ln.b bVar2 = this.$config;
            this.label = 1;
            obj = longVdPlayerConfigDialog.w0(bVar2, this);
            if (obj == f) {
                return f;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        if (((Boolean) obj).booleanValue()) {
            this.this$0.dismissAllowingStateLoss();
        } else {
            this.this$0.A0(this.$config);
        }
        return Unit.a;
    }
}
