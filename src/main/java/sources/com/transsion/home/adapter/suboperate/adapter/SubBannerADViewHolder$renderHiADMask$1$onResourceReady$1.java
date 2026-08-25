package com.transsion.home.adapter.suboperate.adapter;

import android.graphics.Bitmap;
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
@DebugMetadata(c = "com.transsion.home.adapter.suboperate.adapter.SubBannerADViewHolder$renderHiADMask$1$onResourceReady$1", f = "SubBannerADViewHolder.kt", l = {128}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class SubBannerADViewHolder$renderHiADMask$1$onResourceReady$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $resource;
    int label;
    final /* synthetic */ SubBannerADViewHolder this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.home.adapter.suboperate.adapter.SubBannerADViewHolder$renderHiADMask$1$onResourceReady$1$1", f = "SubBannerADViewHolder.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsion.home.adapter.suboperate.adapter.SubBannerADViewHolder$renderHiADMask$1$onResourceReady$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $averageColor;
        int label;
        final /* synthetic */ SubBannerADViewHolder this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SubBannerADViewHolder subBannerADViewHolder, int i, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = subBannerADViewHolder;
            this.$averageColor = i;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$averageColor, continuation);
        }

        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return create(n0Var, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.this$0.m(this.$averageColor);
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SubBannerADViewHolder$renderHiADMask$1$onResourceReady$1(Bitmap bitmap, SubBannerADViewHolder subBannerADViewHolder, Continuation<? super SubBannerADViewHolder$renderHiADMask$1$onResourceReady$1> continuation) {
        super(2, continuation);
        this.$resource = bitmap;
        this.this$0 = subBannerADViewHolder;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubBannerADViewHolder$renderHiADMask$1$onResourceReady$1(this.$resource, this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            int b = zg.a.b(this.$resource, 0, 0, 6, (Object) null);
            a2 c = y0.c();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, b, null);
            this.label = 1;
            if (kotlinx.coroutines.i.g(c, anonymousClass1, this) == f) {
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
