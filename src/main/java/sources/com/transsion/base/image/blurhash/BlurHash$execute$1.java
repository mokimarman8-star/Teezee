package com.transsion.base.image.blurhash;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.base.image.blurhash.BlurHash$execute$1", f = "BlurHash.kt", l = {31}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class BlurHash$execute$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $blurString;
    final /* synthetic */ int $height;
    final /* synthetic */ Function1<BitmapDrawable, Unit> $response;
    final /* synthetic */ int $width;
    Object L$0;
    int label;
    final /* synthetic */ BlurHash this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)Ljava/lang/Object;"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.base.image.blurhash.BlurHash$execute$1$1", f = "BlurHash.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsion.base.image.blurhash.BlurHash$execute$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Object>, Object> {
        final /* synthetic */ Ref.ObjectRef<BitmapDrawable> $blurBitmap;
        final /* synthetic */ String $blurString;
        final /* synthetic */ int $height;
        final /* synthetic */ int $width;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ BlurHash this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Ref.ObjectRef<BitmapDrawable> objectRef, String str, int i, int i2, BlurHash blurHash, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$blurBitmap = objectRef;
            this.$blurString = str;
            this.$width = i;
            this.$height = i2;
            this.this$0 = blurHash;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$blurBitmap, this.$blurString, this.$width, this.$height, this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(n0 n0Var, Continuation<Object> continuation) {
            return create(n0Var, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            float f;
            Context context;
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            Ref.ObjectRef<BitmapDrawable> objectRef = this.$blurBitmap;
            BitmapDrawable bitmapDrawable = (BitmapDrawable) objectRef.element;
            if (bitmapDrawable != null) {
                return bitmapDrawable;
            }
            String str = this.$blurString;
            int i = this.$width;
            int i2 = this.$height;
            BlurHash blurHash = this.this$0;
            a aVar = a.a;
            f = blurHash.b;
            Bitmap b = aVar.b(str, i, i2, f, false);
            context = blurHash.a;
            BitmapDrawable bitmapDrawable2 = new BitmapDrawable(context.getResources(), b);
            objectRef.element = bitmapDrawable2;
            Intrinsics.e(bitmapDrawable2);
            blurHash.e(str, bitmapDrawable2);
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    BlurHash$execute$1(BlurHash blurHash, String str, Function1<? super BitmapDrawable, Unit> function1, int i, int i2, Continuation<? super BlurHash$execute$1> continuation) {
        super(2, continuation);
        this.this$0 = blurHash;
        this.$blurString = str;
        this.$response = function1;
        this.$width = i;
        this.$height = i2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BlurHash$execute$1(this.this$0, this.$blurString, this.$response, this.$width, this.$height, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        BitmapDrawable g;
        Ref.ObjectRef objectRef;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            g = this.this$0.g(this.$blurString);
            objectRef2.element = g;
            i0 b = y0.b();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(objectRef2, this.$blurString, this.$width, this.$height, this.this$0, null);
            this.L$0 = objectRef2;
            this.label = 1;
            if (i.g(b, anonymousClass1, this) == f) {
                return f;
            }
            objectRef = objectRef2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (Ref.ObjectRef) this.L$0;
            ResultKt.b(obj);
        }
        Function1<BitmapDrawable, Unit> function1 = this.$response;
        Object obj2 = objectRef.element;
        Intrinsics.e(obj2);
        function1.invoke(obj2);
        return Unit.a;
    }
}
