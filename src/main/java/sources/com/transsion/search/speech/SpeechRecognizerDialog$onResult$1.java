package com.transsion.search.speech;

import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.gslb.BuildConfig;
import com.transsion.search_pugc.speech.SpeechRecognizerVolumeCircleView;
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
import kotlinx.coroutines.u0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.search.speech.SpeechRecognizerDialog$onResult$1", f = "SpeechRecognizerDialog.kt", l = {207}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class SpeechRecognizerDialog$onResult$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $resultStr;
    int label;
    final /* synthetic */ SpeechRecognizerDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SpeechRecognizerDialog$onResult$1(SpeechRecognizerDialog speechRecognizerDialog, String str, Continuation<? super SpeechRecognizerDialog$onResult$1> continuation) {
        super(2, continuation);
        this.this$0 = speechRecognizerDialog;
        this.$resultStr = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SpeechRecognizerDialog$onResult$1(this.this$0, this.$resultStr, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        AppCompatTextView appCompatTextView;
        com.transsion.search_pugc.speech.SpeechRecognizerVolumeCircleView speechRecognizerVolumeCircleView;
        Function1 function1;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            vp.b bVar = this.this$0.bind;
            if (bVar != null && (speechRecognizerVolumeCircleView = bVar.g) != null) {
                speechRecognizerVolumeCircleView.setMicState(SpeechRecognizerVolumeCircleView.MicState.LOADING);
            }
            vp.b bVar2 = this.this$0.bind;
            if (bVar2 != null && (appCompatTextView = bVar2.e) != null) {
                appCompatTextView.setText(BuildConfig.FLAVOR);
            }
            this.label = 1;
            if (u0.a(1500L, this) == f) {
                return f;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        function1 = this.this$0.mCallback;
        if (function1 != null) {
        }
        this.this$0.mCallback = null;
        this.this$0.dismissAllowingStateLoss();
        return Unit.a;
    }
}
