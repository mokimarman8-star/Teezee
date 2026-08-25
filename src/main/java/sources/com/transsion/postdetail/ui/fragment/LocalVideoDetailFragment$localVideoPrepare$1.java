package com.transsion.postdetail.ui.fragment;

import android.media.MediaMetadataRetriever;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$localVideoPrepare$1", f = "LocalVideoDetailFragment.kt", l = {942}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class LocalVideoDetailFragment$localVideoPrepare$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $path;
    int label;
    final /* synthetic */ LocalVideoDetailFragment this$0;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/b;", "Lkotlin/Triple;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/flow/b;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$localVideoPrepare$1$1", f = "LocalVideoDetailFragment.kt", l = {939}, m = "invokeSuspend")
    /* renamed from: com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$localVideoPrepare$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.b, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $path;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ LocalVideoDetailFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, LocalVideoDetailFragment localVideoDetailFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$path = str;
            this.this$0 = localVideoDetailFragment;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$path, this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(kotlinx.coroutines.flow.b bVar, Continuation<? super Unit> continuation) {
            return create(bVar, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            Long x;
            Integer v;
            Integer v2;
            Object f = IntrinsicsKt.f();
            int i = this.label;
            if (i == 0) {
                ResultKt.b(obj);
                kotlinx.coroutines.flow.b bVar = (kotlinx.coroutines.flow.b) this.L$0;
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                Ref.IntRef intRef = new Ref.IntRef();
                Ref.IntRef intRef2 = new Ref.IntRef();
                Ref.LongRef longRef = new Ref.LongRef();
                try {
                    try {
                        String str = this.$path;
                        LocalVideoDetailFragment localVideoDetailFragment = this.this$0;
                        mediaMetadataRetriever.setDataSource(str);
                        String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
                        intRef.element = (extractMetadata == null || (v2 = StringsKt.v(extractMetadata)) == null) ? 0 : v2.intValue();
                        String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                        intRef2.element = (extractMetadata2 == null || (v = StringsKt.v(extractMetadata2)) == null) ? 0 : v.intValue();
                        String extractMetadata3 = mediaMetadataRetriever.extractMetadata(9);
                        longRef.element = (extractMetadata3 == null || (x = StringsKt.x(extractMetadata3)) == null) ? 0L : x.longValue();
                        a.a aVar = wf.a.a;
                        a.a.f(aVar, localVideoDetailFragment.TAG, "play width:" + intRef.element + ",height:" + intRef2.element, false, 4, (Object) null);
                        a.a.f(aVar, localVideoDetailFragment.TAG, "play duration:" + longRef.element, false, 4, (Object) null);
                    } catch (Exception e) {
                        e.printStackTrace();
                        intRef.element = 0;
                        intRef2.element = 0;
                        longRef.element = 0L;
                    }
                    mediaMetadataRetriever.release();
                    Triple triple = new Triple(Boxing.d(intRef.element), Boxing.d(intRef2.element), Boxing.e(longRef.element));
                    this.label = 1;
                    if (bVar.emit(triple, this) == f) {
                        return f;
                    }
                } catch (Throwable th2) {
                    mediaMetadataRetriever.release();
                    throw th2;
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

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u0006*\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00010\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lkotlinx/coroutines/flow/b;", "Lkotlin/Triple;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "it", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/flow/b;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$localVideoPrepare$1$2", f = "LocalVideoDetailFragment.kt", l = {941}, m = "invokeSuspend")
    /* renamed from: com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$localVideoPrepare$1$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function3<kotlinx.coroutines.flow.b, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        public final Object invoke(kotlinx.coroutines.flow.b bVar, Throwable th2, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = bVar;
            return anonymousClass2.invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            Object f = IntrinsicsKt.f();
            int i = this.label;
            if (i == 0) {
                ResultKt.b(obj);
                kotlinx.coroutines.flow.b bVar = (kotlinx.coroutines.flow.b) this.L$0;
                Triple triple = new Triple(Boxing.d(0), Boxing.d(0), Boxing.e(0L));
                this.label = 1;
                if (bVar.emit(triple, this) == f) {
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

    static final class a implements kotlinx.coroutines.flow.b {
        final /* synthetic */ LocalVideoDetailFragment a;
        final /* synthetic */ String b;

        a(LocalVideoDetailFragment localVideoDetailFragment, String str) {
            this.a = localVideoDetailFragment;
            this.b = str;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(Triple triple, Continuation continuation) {
            a.a.v(wf.a.a, this.a.TAG, "Prepare success width = " + triple.getFirst() + "， height = " + triple.getSecond() + " ,duration = " + triple.getThird() + ",completed = " + this.a.completed, false, 4, (Object) null);
            this.a.duration = ((Number) triple.getThird()).longValue();
            this.a.videoWidth = ((Number) triple.getFirst()).intValue();
            this.a.videoHeight = ((Number) triple.getSecond()).intValue();
            this.a.b3(((Number) triple.getFirst()).intValue(), ((Number) triple.getSecond()).intValue(), this.b);
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LocalVideoDetailFragment$localVideoPrepare$1(String str, LocalVideoDetailFragment localVideoDetailFragment, Continuation<? super LocalVideoDetailFragment$localVideoPrepare$1> continuation) {
        super(2, continuation);
        this.$path = str;
        this.this$0 = localVideoDetailFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocalVideoDetailFragment$localVideoPrepare$1(this.$path, this.this$0, continuation);
    }

    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.a e = kotlinx.coroutines.flow.c.e(kotlinx.coroutines.flow.c.t(kotlinx.coroutines.flow.c.r(new AnonymousClass1(this.$path, this.this$0, null)), kotlinx.coroutines.y0.b()), new AnonymousClass2(null));
            a aVar = new a(this.this$0, this.$path);
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
