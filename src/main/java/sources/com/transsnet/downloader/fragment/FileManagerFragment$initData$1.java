package com.transsnet.downloader.fragment;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", HttpUrl.FRAGMENT_ENCODE_SET, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.fragment.FileManagerFragment$initData$1", f = "FileManagerFragment.kt", l = {182}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class FileManagerFragment$initData$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FileManagerFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FileManagerFragment$initData$1(FileManagerFragment fileManagerFragment, Continuation<? super FileManagerFragment$initData$1> continuation) {
        super(2, continuation);
        this.this$0 = fileManagerFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FileManagerFragment$initData$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return ((FileManagerFragment$initData$1) create(n0Var, continuation)).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            com.transsnet.downloader.manager.g J0 = FileManagerFragment.J0(this.this$0);
            this.label = 1;
            if (J0.B(this) == f) {
                return f;
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
