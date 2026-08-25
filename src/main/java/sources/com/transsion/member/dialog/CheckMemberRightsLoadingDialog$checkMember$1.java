package com.transsion.member.dialog;

import com.therouter.TheRouter;
import com.transsion.gslb.BuildConfig;
import com.transsion.memberapi.MemberCheckResult;
import com.transsion.memberapi.MemberSceneType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.member.dialog.CheckMemberRightsLoadingDialog$checkMember$1", f = "CheckMemberRightsLoadingDialog.kt", l = {80}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class CheckMemberRightsLoadingDialog$checkMember$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CheckMemberRightsLoadingDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CheckMemberRightsLoadingDialog$checkMember$1(CheckMemberRightsLoadingDialog checkMemberRightsLoadingDialog, Continuation<? super CheckMemberRightsLoadingDialog$checkMember$1> continuation) {
        super(2, continuation);
        this.this$0 = checkMemberRightsLoadingDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(CheckMemberRightsLoadingDialog checkMemberRightsLoadingDialog, MemberCheckResult memberCheckResult) {
        if (checkMemberRightsLoadingDialog.isDetached() || !checkMemberRightsLoadingDialog.isAdded()) {
            return Unit.a;
        }
        checkMemberRightsLoadingDialog.s0(memberCheckResult);
        return Unit.a;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CheckMemberRightsLoadingDialog$checkMember$1(this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        MemberSceneType memberSceneType;
        Integer num;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
            if (bVar != null) {
                memberSceneType = this.this$0.mSceneType;
                num = this.this$0.mResolution;
                final CheckMemberRightsLoadingDialog checkMemberRightsLoadingDialog = this.this$0;
                Function1 function1 = new Function1() { // from class: com.transsion.member.dialog.a
                    public final Object invoke(Object obj2) {
                        Unit d;
                        d = CheckMemberRightsLoadingDialog$checkMember$1.d(CheckMemberRightsLoadingDialog.this, (MemberCheckResult) obj2);
                        return d;
                    }
                };
                this.label = 1;
                if (bVar.b(memberSceneType, num, function1, this) == f) {
                    return f;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.a;
    }
}
