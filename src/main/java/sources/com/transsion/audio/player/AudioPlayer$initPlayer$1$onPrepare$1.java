package com.transsion.audio.player;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.AppDatabase$f1;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.gslb.BuildConfig;
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

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.audio.player.AudioPlayer$initPlayer$1$onPrepare$1", f = "AudioPlayer.kt", l = {234}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class AudioPlayer$initPlayer$1$onPrepare$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AudioPlayer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AudioPlayer$initPlayer$1$onPrepare$1(AudioPlayer audioPlayer, Continuation<? super AudioPlayer$initPlayer$1$onPrepare$1> continuation) {
        super(2, continuation);
        this.this$0 = audioPlayer;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AudioPlayer$initPlayer$1$onPrepare$1(this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        com.transsion.player.orplayer.f v;
        Long readProcess;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            if (this.this$0.t() != null) {
                AppDatabase$f1 appDatabase$f1 = AppDatabase.p;
                Application a = Utils.a();
                Intrinsics.g(a, "getApp(...)");
                si.a n1 = appDatabase$f1.b(a).n1();
                AudioBean t = this.this$0.t();
                Intrinsics.e(t);
                String audioUrl = t.getAudioUrl();
                this.label = 1;
                obj = n1.c(audioUrl, this);
                if (obj == f) {
                    return f;
                }
            }
            return Unit.a;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        AudioBean audioBean = (AudioBean) obj;
        long longValue = (audioBean == null || (readProcess = audioBean.getReadProcess()) == null) ? 0L : readProcess.longValue();
        if ((audioBean == null || audioBean.getStatus() != 6) && longValue > 0 && (v = this.this$0.v()) != null) {
            v.seekTo(longValue);
        }
        return Unit.a;
    }
}
