package com.transsion.room.fragment;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewGroup;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.room.fragment.RoomDetailFragment$showCover$2$onResourceReady$1", f = "RoomDetailFragment.kt", l = {599}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class RoomDetailFragment$showCover$2$onResourceReady$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $resource;
    int label;
    final /* synthetic */ RoomDetailFragment this$0;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/b;", "Landroid/graphics/Bitmap;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/flow/b;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.room.fragment.RoomDetailFragment$showCover$2$onResourceReady$1$1", f = "RoomDetailFragment.kt", l = {594}, m = "invokeSuspend")
    /* renamed from: com.transsion.room.fragment.RoomDetailFragment$showCover$2$onResourceReady$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.b, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bitmap $resource;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Bitmap bitmap, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$resource = bitmap;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$resource, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(kotlinx.coroutines.flow.b bVar, Continuation<? super Unit> continuation) {
            return create(bVar, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            Object f = IntrinsicsKt.f();
            int i = this.label;
            if (i == 0) {
                ResultKt.b(obj);
                kotlinx.coroutines.flow.b bVar = (kotlinx.coroutines.flow.b) this.L$0;
                Bitmap bitmap = this.$resource;
                this.label = 1;
                if (bVar.emit(bitmap, this) == f) {
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

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005*\u0010\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlinx/coroutines/flow/b;", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", BuildConfig.FLAVOR, "it", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/flow/b;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.room.fragment.RoomDetailFragment$showCover$2$onResourceReady$1$3", f = "RoomDetailFragment.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsion.room.fragment.RoomDetailFragment$showCover$2$onResourceReady$1$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function3<kotlinx.coroutines.flow.b, Throwable, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(3, continuation);
        }

        public final Object invoke(kotlinx.coroutines.flow.b bVar, Throwable th2, Continuation<? super Unit> continuation) {
            return new AnonymousClass3(continuation).invokeSuspend(Unit.a);
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
        final /* synthetic */ RoomDetailFragment a;
        final /* synthetic */ Bitmap b;

        a(RoomDetailFragment roomDetailFragment, Bitmap bitmap) {
            this.a = roomDetailFragment;
            this.b = bitmap;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(Bitmap bitmap, Continuation continuation) {
            ShapeableImageView shapeableImageView;
            ShapeableImageView shapeableImageView2;
            ShapeableImageView shapeableImageView3;
            if (!this.a.isAdded() || this.a.isRemoving() || this.a.isDetached()) {
                return Unit.a;
            }
            fp.n nVar = (fp.n) this.a.getMViewBinding();
            if (nVar != null) {
                nVar.d.setBackground(new BitmapDrawable(this.a.getResources(), bitmap));
                ViewGroup.LayoutParams layoutParams = nVar.c.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = nVar.d.getMeasuredHeight();
                }
                nVar.c.setLayoutParams(layoutParams);
            }
            if (this.b.getHeight() < com.blankj.utilcode.util.a0.a(56.0f)) {
                fp.n nVar2 = (fp.n) this.a.getMViewBinding();
                if (nVar2 != null && (shapeableImageView3 = nVar2.i) != null) {
                    shapeableImageView3.setImageBitmap(bitmap);
                }
                fp.n nVar3 = (fp.n) this.a.getMViewBinding();
                if (nVar3 != null && (shapeableImageView2 = nVar3.i) != null) {
                    uf.c.k(shapeableImageView2);
                }
            } else {
                fp.n nVar4 = (fp.n) this.a.getMViewBinding();
                if (nVar4 != null && (shapeableImageView = nVar4.i) != null) {
                    uf.c.g(shapeableImageView);
                }
            }
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RoomDetailFragment$showCover$2$onResourceReady$1(Bitmap bitmap, RoomDetailFragment roomDetailFragment, Continuation<? super RoomDetailFragment$showCover$2$onResourceReady$1> continuation) {
        super(2, continuation);
        this.$resource = bitmap;
        this.this$0 = roomDetailFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RoomDetailFragment$showCover$2$onResourceReady$1(this.$resource, this.this$0, continuation);
    }

    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            final kotlinx.coroutines.flow.a r = kotlinx.coroutines.flow.c.r(new AnonymousClass1(this.$resource, null));
            kotlinx.coroutines.flow.a e = kotlinx.coroutines.flow.c.e(kotlinx.coroutines.flow.c.t(new kotlinx.coroutines.flow.a() { // from class: com.transsion.room.fragment.RoomDetailFragment$showCover$2$onResourceReady$1$invokeSuspend$$inlined$map$1

                /* renamed from: com.transsion.room.fragment.RoomDetailFragment$showCover$2$onResourceReady$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                public static final class AnonymousClass2 implements kotlinx.coroutines.flow.b {
                    final /* synthetic */ kotlinx.coroutines.flow.b a;

                    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                    @DebugMetadata(c = "com.transsion.room.fragment.RoomDetailFragment$showCover$2$onResourceReady$1$invokeSuspend$$inlined$map$1$2", f = "RoomDetailFragment.kt", l = {50}, m = "emit")
                    /* renamed from: com.transsion.room.fragment.RoomDetailFragment$showCover$2$onResourceReady$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        Object L$0;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(kotlinx.coroutines.flow.b bVar) {
                        this.a = bVar;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object emit(Object obj, Continuation continuation) {
                        AnonymousClass1 anonymousClass1;
                        int i;
                        if (continuation instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) continuation;
                            int i2 = anonymousClass1.label;
                            if ((i2 & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.label = i2 - Integer.MIN_VALUE;
                                Object obj2 = anonymousClass1.result;
                                Object f = IntrinsicsKt.f();
                                i = anonymousClass1.label;
                                if (i != 0) {
                                    ResultKt.b(obj2);
                                    kotlinx.coroutines.flow.b bVar = this.a;
                                    Bitmap a = sf.b.a((Bitmap) obj, 50, false);
                                    anonymousClass1.label = 1;
                                    if (bVar.emit(a, anonymousClass1) == f) {
                                        return f;
                                    }
                                } else {
                                    if (i != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.b(obj2);
                                }
                                return Unit.a;
                            }
                        }
                        anonymousClass1 = new AnonymousClass1(continuation);
                        Object obj22 = anonymousClass1.result;
                        Object f2 = IntrinsicsKt.f();
                        i = anonymousClass1.label;
                        if (i != 0) {
                        }
                        return Unit.a;
                    }
                }

                public Object a(kotlinx.coroutines.flow.b bVar, Continuation continuation) {
                    Object a2 = r.a(new AnonymousClass2(bVar), continuation);
                    return a2 == IntrinsicsKt.f() ? a2 : Unit.a;
                }
            }, kotlinx.coroutines.y0.a()), new AnonymousClass3(null));
            a aVar = new a(this.this$0, this.$resource);
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
