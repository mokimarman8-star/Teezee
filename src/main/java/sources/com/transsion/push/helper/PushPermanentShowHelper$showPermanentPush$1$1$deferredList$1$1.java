package com.transsion.push.helper;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.transsion.gslb.BuildConfig;
import com.transsion.push.bean.PermanentItemBean;
import com.transsion.push.utils.NotificationUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/n0;", "Lkotlin/Pair;", "Landroid/graphics/Bitmap;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)Lkotlin/Pair;"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.push.helper.PushPermanentShowHelper$showPermanentPush$1$1$deferredList$1$1", f = "PushPermanentShowHelper.kt", l = {340}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class PushPermanentShowHelper$showPermanentPush$1$1$deferredList$1$1 extends SuspendLambda implements Function2<n0, Continuation<? super Pair<? extends Bitmap, ? extends Integer>>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ int $index;
    final /* synthetic */ List<PermanentItemBean> $msgList;
    int label;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "Landroid/graphics/Bitmap;", "<anonymous>", "(Lkotlinx/coroutines/n0;)Landroid/graphics/Bitmap;"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.push.helper.PushPermanentShowHelper$showPermanentPush$1$1$deferredList$1$1$1", f = "PushPermanentShowHelper.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsion.push.helper.PushPermanentShowHelper$showPermanentPush$1$1$deferredList$1$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Bitmap>, Object> {
        final /* synthetic */ String $bigUrl;
        final /* synthetic */ Context $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Context context, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$bigUrl = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$context, this.$bigUrl, continuation);
        }

        public final Object invoke(n0 n0Var, Continuation<? super Bitmap> continuation) {
            return create(n0Var, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            Object obj2;
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            Context context = this.$context;
            String str = this.$bigUrl;
            try {
                Result.Companion companion = Result.Companion;
                obj2 = Result.constructor-impl((Bitmap) Glide.with(context).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).load(str).submit().get());
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.constructor-impl(ResultKt.a(th2));
            }
            if (Result.isFailure-impl(obj2)) {
                return null;
            }
            return obj2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PushPermanentShowHelper$showPermanentPush$1$1$deferredList$1$1(List<PermanentItemBean> list, int i, Context context, Continuation<? super PushPermanentShowHelper$showPermanentPush$1$1$deferredList$1$1> continuation) {
        super(2, continuation);
        this.$msgList = list;
        this.$index = i;
        this.$context = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PushPermanentShowHelper$showPermanentPush$1$1$deferredList$1$1(this.$msgList, this.$index, this.$context, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Pair<Bitmap, Integer>> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            String image = this.$msgList.get(this.$index).getImage();
            if (image == null) {
                image = BuildConfig.FLAVOR;
            }
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$context, NotificationUtil.a.J(image, e.a.g()), null);
            this.label = 1;
            obj = TimeoutKt.e(5000L, anonymousClass1, this);
            if (obj == f) {
                return f;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return TuplesKt.a(obj, Boxing.d(this.$index));
    }
}
