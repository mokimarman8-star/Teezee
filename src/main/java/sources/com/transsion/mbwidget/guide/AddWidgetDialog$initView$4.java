package com.transsion.mbwidget.guide;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.transsion.gslb.BuildConfig;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.w0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.t1;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.mbwidget.guide.AddWidgetDialog$initView$4", f = "AddWidgetDialog.kt", l = {61}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class AddWidgetDialog$initView$4 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AddWidgetDialog this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.mbwidget.guide.AddWidgetDialog$initView$4$1", f = "AddWidgetDialog.kt", l = {62}, m = "invokeSuspend")
    /* renamed from: com.transsion.mbwidget.guide.AddWidgetDialog$initView$4$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AddWidgetDialog this$0;

        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", BuildConfig.FLAVOR}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.transsion.mbwidget.guide.AddWidgetDialog$initView$4$1$1", f = "AddWidgetDialog.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.transsion.mbwidget.guide.AddWidgetDialog$initView$4$1$1, reason: invalid class name and collision with other inner class name */
        static final class C00381 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
            /* synthetic */ boolean Z$0;
            int label;
            final /* synthetic */ AddWidgetDialog this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00381(AddWidgetDialog addWidgetDialog, Continuation<? super C00381> continuation) {
                super(2, continuation);
                this.this$0 = addWidgetDialog;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00381 c00381 = new C00381(this.this$0, continuation);
                c00381.Z$0 = ((Boolean) obj).booleanValue();
                return c00381;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) obj2);
            }

            public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
                return create(Boolean.valueOf(z), continuation).invokeSuspend(Unit.a);
            }

            public final Object invokeSuspend(Object obj) {
                t1 t1Var;
                IntrinsicsKt.f();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                if (this.Z$0) {
                    com.transsion.mbwidget.utils.a.a.k("hot_desk_widget", true, "dialog_add");
                    t1Var = this.this$0.addWidgetJob;
                    if (t1Var != null) {
                        t1.a.b(t1Var, (CancellationException) null, 1, (Object) null);
                    }
                    this.this$0.dismiss();
                }
                return Unit.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AddWidgetDialog addWidgetDialog, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = addWidgetDialog;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return create(n0Var, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            Object f = IntrinsicsKt.f();
            int i = this.label;
            if (i == 0) {
                ResultKt.b(obj);
                w0 a = WidgetCallbackReceiver.INSTANCE.a();
                C00381 c00381 = new C00381(this.this$0, null);
                this.label = 1;
                if (kotlinx.coroutines.flow.c.h(a, c00381, this) == f) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AddWidgetDialog$initView$4(AddWidgetDialog addWidgetDialog, Continuation<? super AddWidgetDialog$initView$4> continuation) {
        super(2, continuation);
        this.this$0 = addWidgetDialog;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AddWidgetDialog$initView$4(this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            Lifecycle lifecycle = this.this$0.getLifecycle();
            Intrinsics.g(lifecycle, "<get-lifecycle>(...)");
            Lifecycle.State state = Lifecycle.State.STARTED;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
            this.label = 1;
            if (RepeatOnLifecycleKt.a(lifecycle, state, anonymousClass1, this) == f) {
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
