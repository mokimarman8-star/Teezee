package com.transsion.player.mediasession;

import android.app.Application;
import android.content.ComponentName;
import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaControllerCompat;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.player.mediasession.MediaBrowserCompatHelper$init$1$2$2", f = "MediaBrowserCompatHelper.kt", l = {}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class MediaBrowserCompatHelper$init$1$2$2 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<MediaControllerCompat.e, Unit> $callback;
    final /* synthetic */ Application $it;
    final /* synthetic */ MediaBrowserCompatHelper $this_runCatching;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MediaBrowserCompatHelper$init$1$2$2(Function1<? super MediaControllerCompat.e, Unit> function1, MediaBrowserCompatHelper mediaBrowserCompatHelper, Application application, Continuation<? super MediaBrowserCompatHelper$init$1$2$2> continuation) {
        super(2, continuation);
        this.$callback = function1;
        this.$this_runCatching = mediaBrowserCompatHelper;
        this.$it = application;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MediaBrowserCompatHelper$init$1$2$2(this.$callback, this.$this_runCatching, this.$it, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        MediaBrowserCompat.c cVar;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        Function1<MediaControllerCompat.e, Unit> function1 = this.$callback;
        if (function1 != null) {
            Boxing.a(this.$this_runCatching.f.add(function1));
        }
        MediaBrowserCompatHelper mediaBrowserCompatHelper = this.$this_runCatching;
        Application application = this.$it;
        ComponentName componentName = new ComponentName(this.$it, (Class<?>) MediaService.class);
        cVar = this.$this_runCatching.c;
        mediaBrowserCompatHelper.d = new MediaBrowserCompat(application, componentName, cVar, (Bundle) null);
        MediaBrowserCompat mediaBrowserCompat = this.$this_runCatching.d;
        if (mediaBrowserCompat != null) {
            mediaBrowserCompat.a();
        }
        return Unit.a;
    }
}
