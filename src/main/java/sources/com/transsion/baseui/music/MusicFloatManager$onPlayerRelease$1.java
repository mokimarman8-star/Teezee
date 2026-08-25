package com.transsion.baseui.music;

import com.transsion.gslb.BuildConfig;
import com.transsion.player.mediasession.MediaItem;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.baseui.music.MusicFloatManager$onPlayerRelease$1", f = "MusicFloatManager.kt", l = {}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class MusicFloatManager$onPlayerRelease$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ gn.e $mediaSource;
    int label;
    final /* synthetic */ MusicFloatManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MusicFloatManager$onPlayerRelease$1(MusicFloatManager musicFloatManager, gn.e eVar, Continuation<? super MusicFloatManager$onPlayerRelease$1> continuation) {
        super(2, continuation);
        this.this$0 = musicFloatManager;
        this.$mediaSource = eVar;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MusicFloatManager$onPlayerRelease$1(this.this$0, this.$mediaSource, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        String p;
        com.transsion.player.orplayer.f fVar;
        CopyOnWriteArrayList copyOnWriteArrayList;
        MediaItem h;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        com.transsion.player.mediasession.i iVar = com.transsion.player.mediasession.i.a;
        p = this.this$0.p();
        gn.e eVar = this.$mediaSource;
        iVar.a(p + " --> onPlayerRelease() --> subjectId = " + ((eVar == null || (h = eVar.h()) == null) ? null : h.getSubjectId()));
        fVar = this.this$0.e;
        if (fVar != null) {
            fVar.removePlayerListener(this.this$0);
        }
        this.this$0.e = null;
        copyOnWriteArrayList = this.this$0.d;
        gn.e eVar2 = this.$mediaSource;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onPlayerRelease(eVar2);
        }
        this.this$0.B(null);
        this.this$0.C(null);
        MusicReport.a.c();
        return Unit.a;
    }
}
