package com.transsion.player.longvideo.ui.dialog;

import android.content.Context;
import android.view.View;
import com.noober.background.view.BLTextView;
import com.transsion.gslb.BuildConfig;
import com.transsion.player.longvideo.R$string;
import com.transsion.player.longvideo.view.LongVodRewardInterceptView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.u0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.player.longvideo.ui.dialog.LongVodPlayerViewAdHelper$startWatchAdCountdown$1", f = "LongVodPlayerViewAdHelper.kt", l = {811}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class LongVodPlayerViewAdHelper$startWatchAdCountdown$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ LongVodPlayerViewAdHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LongVodPlayerViewAdHelper$startWatchAdCountdown$1(LongVodPlayerViewAdHelper longVodPlayerViewAdHelper, Continuation<? super LongVodPlayerViewAdHelper$startWatchAdCountdown$1> continuation) {
        super(2, continuation);
        this.this$0 = longVodPlayerViewAdHelper;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LongVodPlayerViewAdHelper$startWatchAdCountdown$1(this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:5:0x002d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        int i;
        mn.j jVar;
        boolean U0;
        LongVodRewardInterceptView longVodRewardInterceptView;
        mn.g bind;
        BLTextView bLTextView;
        mn.j jVar2;
        View root;
        Context context;
        int i2;
        int i3;
        Object f = IntrinsicsKt.f();
        int i4 = this.label;
        if (i4 == 0) {
            ResultKt.b(obj);
            i = this.this$0.s0;
            if (i > 0) {
            }
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            i2 = this.this$0.s0;
            this.this$0.s0 = i2 - 1;
            i3 = this.this$0.s0;
            if (i3 > 0) {
                this.this$0.R4();
            }
            i = this.this$0.s0;
            if (i > 0) {
                this.label = 1;
                if (u0.a(1000L, this) == f) {
                    return f;
                }
                i2 = this.this$0.s0;
                this.this$0.s0 = i2 - 1;
                i3 = this.this$0.s0;
                if (i3 > 0) {
                }
                i = this.this$0.s0;
                if (i > 0) {
                    jVar = this.this$0.R;
                    if (jVar != null && (longVodRewardInterceptView = jVar.v) != null && (bind = longVodRewardInterceptView.getBind()) != null && (bLTextView = bind.h) != null) {
                        jVar2 = this.this$0.R;
                        bLTextView.setText((jVar2 == null || (root = jVar2.getRoot()) == null || (context = root.getContext()) == null) ? null : context.getString(R$string.long_vod_reward_intercept_watch_ad));
                    }
                    this.this$0.r0 = null;
                    U0 = this.this$0.U0();
                    if (U0) {
                        this.this$0.H4();
                    }
                    return Unit.a;
                }
            }
        }
    }
}
