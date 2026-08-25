package com.transsion.edcation.dialog;

import com.blankj.utilcode.util.Utils;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.widget.R;
import com.tn.lib.widget.toast.core.h;
import com.transsion.edcation.bean.InterestBody;
import com.transsion.edcation.c;
import com.transsion.gslb.BuildConfig;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.edcation.dialog.InterestSelectDialog$initView$1$1$1", f = "InterestSelectDialog.kt", l = {60}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class InterestSelectDialog$initView$1$1$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ InterestSelectDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InterestSelectDialog$initView$1$1$1(InterestSelectDialog interestSelectDialog, Continuation<? super InterestSelectDialog$initView$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = interestSelectDialog;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InterestSelectDialog$initView$1$1$1 interestSelectDialog$initView$1$1$1 = new InterestSelectDialog$initView$1$1$1(this.this$0, continuation);
        interestSelectDialog$initView$1$1$1.L$0 = obj;
        return interestSelectDialog$initView$1$1$1;
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        com.transsion.edcation.c w0;
        List list;
        InterestSelectDialog interestSelectDialog;
        List list2;
        String unused;
        String unused2;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.b(obj);
                InterestSelectDialog interestSelectDialog2 = this.this$0;
                Result.Companion companion = Result.Companion;
                w0 = interestSelectDialog2.w0();
                list = interestSelectDialog2.selectIds;
                InterestBody interestBody = new InterestBody(list);
                this.L$0 = interestSelectDialog2;
                this.label = 1;
                Object c = c.a.c(w0, null, interestBody, this, 1, null);
                if (c == f) {
                    return f;
                }
                interestSelectDialog = interestSelectDialog2;
                obj = c;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                interestSelectDialog = (InterestSelectDialog) this.L$0;
                ResultKt.b(obj);
            }
            BaseDto baseDto = (BaseDto) obj;
            unused = interestSelectDialog.TAG;
            list2 = interestSelectDialog.selectIds;
            StringBuilder sb = new StringBuilder();
            sb.append("res: ");
            sb.append(baseDto);
            sb.append(", ids: ");
            sb.append(list2);
            if (Intrinsics.c(baseDto.getCode(), "0")) {
                interestSelectDialog.a0();
            }
            obj2 = Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.a(th2));
        }
        InterestSelectDialog interestSelectDialog3 = this.this$0;
        Throwable th3 = Result.exceptionOrNull-impl(obj2);
        if (th3 != null && interestSelectDialog3.isAdded() && !interestSelectDialog3.isDetached() && !interestSelectDialog3.isRemoving()) {
            h.a.l(Utils.a().getString(R.string.no_error_content));
            unused2 = interestSelectDialog3.TAG;
            String message = th3.getMessage();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("error: ");
            sb2.append(message);
        }
        return Unit.a;
    }
}
