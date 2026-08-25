package com.transsion.player.longvideo.member;

import android.widget.ImageView;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.player.longvideo.member.LongVodResolutionMemberView$setConfig$1$1", f = "LongVodResolutionMemberView.kt", l = {67, 71}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class LongVodResolutionMemberView$setConfig$1$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ ln.b $config;
    final /* synthetic */ ln.a $longVdPlayerBean;
    int label;
    final /* synthetic */ LongVodResolutionMemberView this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.player.longvideo.member.LongVodResolutionMemberView$setConfig$1$1$1", f = "LongVodResolutionMemberView.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsion.player.longvideo.member.LongVodResolutionMemberView$setConfig$1$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isShow;
        int label;
        final /* synthetic */ LongVodResolutionMemberView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LongVodResolutionMemberView longVodResolutionMemberView, boolean z, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = longVodResolutionMemberView;
            this.$isShow = z;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$isShow, continuation);
        }

        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return create(n0Var, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            ImageView imageView;
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            imageView = this.this$0.ivMember;
            if (imageView != null) {
                uf.c.j(imageView, this.$isShow);
            }
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LongVodResolutionMemberView$setConfig$1$1(ln.a aVar, ln.b bVar, LongVodResolutionMemberView longVodResolutionMemberView, Continuation<? super LongVodResolutionMemberView$setConfig$1$1> continuation) {
        super(2, continuation);
        this.$longVdPlayerBean = aVar;
        this.$config = bVar;
        this.this$0 = longVodResolutionMemberView;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LongVodResolutionMemberView$setConfig$1$1(this.$longVdPlayerBean, this.$config, this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            ResolutionMemberManager resolutionMemberManager = ResolutionMemberManager.a;
            ln.a aVar = this.$longVdPlayerBean;
            this.label = 1;
            obj = resolutionMemberManager.f(aVar, this);
            if (obj == f) {
                return f;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return Unit.a;
            }
            ResultKt.b(obj);
        }
        boolean z = !((Boolean) obj).booleanValue() && r.a.q(this.$config.d());
        a2 c = y0.c();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, z, null);
        this.label = 2;
        if (kotlinx.coroutines.i.g(c, anonymousClass1, this) == f) {
            return f;
        }
        return Unit.a;
    }
}
