package com.transsion.postdetail.shorttv.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.appcompat.widget.AppCompatImageView;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.postdetail.shorttv.adapter.ShortTVHeaderViewAdapter$loadBuiltInCover$1", f = "ShortTVHeaderViewAdapter.kt", l = {86}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class ShortTVHeaderViewAdapter$loadBuiltInCover$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Subject $item;
    final /* synthetic */ AppCompatImageView $this_loadBuiltInCover;
    int label;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u0010\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/flow/b;", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/flow/b;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.postdetail.shorttv.adapter.ShortTVHeaderViewAdapter$loadBuiltInCover$1$1", f = "ShortTVHeaderViewAdapter.kt", l = {81}, m = "invokeSuspend")
    /* renamed from: com.transsion.postdetail.shorttv.adapter.ShortTVHeaderViewAdapter$loadBuiltInCover$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.b, Continuation<? super Unit>, Object> {
        final /* synthetic */ Subject $item;
        final /* synthetic */ AppCompatImageView $this_loadBuiltInCover;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Subject subject, AppCompatImageView appCompatImageView, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$item = subject;
            this.$this_loadBuiltInCover = appCompatImageView;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$item, this.$this_loadBuiltInCover, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(kotlinx.coroutines.flow.b bVar, Continuation<? super Unit> continuation) {
            return create(bVar, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            String url;
            Object f = IntrinsicsKt.f();
            int i = this.label;
            if (i == 0) {
                ResultKt.b(obj);
                kotlinx.coroutines.flow.b bVar = (kotlinx.coroutines.flow.b) this.L$0;
                Cover cover = this.$item.getCover();
                if (cover != null && (url = cover.getUrl()) != null) {
                    InputStream open = this.$this_loadBuiltInCover.getContext().getAssets().open(url);
                    Bitmap decodeStream = BitmapFactory.decodeStream(open);
                    this.L$0 = open;
                    this.label = 1;
                    if (bVar.emit(decodeStream, this) == f) {
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

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005*\u0010\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlinx/coroutines/flow/b;", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", BuildConfig.FLAVOR, "it", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/flow/b;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.postdetail.shorttv.adapter.ShortTVHeaderViewAdapter$loadBuiltInCover$1$2", f = "ShortTVHeaderViewAdapter.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsion.postdetail.shorttv.adapter.ShortTVHeaderViewAdapter$loadBuiltInCover$1$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function3<kotlinx.coroutines.flow.b, Throwable, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        public final Object invoke(kotlinx.coroutines.flow.b bVar, Throwable th2, Continuation<? super Unit> continuation) {
            return new AnonymousClass2(continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return Unit.a;
        }
    }

    static final class a implements kotlinx.coroutines.flow.b {
        final /* synthetic */ AppCompatImageView a;

        a(AppCompatImageView appCompatImageView) {
            this.a = appCompatImageView;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(Bitmap bitmap, Continuation continuation) {
            this.a.setImageBitmap(bitmap);
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ShortTVHeaderViewAdapter$loadBuiltInCover$1(Subject subject, AppCompatImageView appCompatImageView, Continuation<? super ShortTVHeaderViewAdapter$loadBuiltInCover$1> continuation) {
        super(2, continuation);
        this.$item = subject;
        this.$this_loadBuiltInCover = appCompatImageView;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTVHeaderViewAdapter$loadBuiltInCover$1(this.$item, this.$this_loadBuiltInCover, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.a e = c.e(c.t(c.r(new AnonymousClass1(this.$item, this.$this_loadBuiltInCover, null)), y0.b()), new AnonymousClass2(null));
            a aVar = new a(this.$this_loadBuiltInCover);
            this.label = 1;
            if (e.a(aVar, this) == f) {
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
