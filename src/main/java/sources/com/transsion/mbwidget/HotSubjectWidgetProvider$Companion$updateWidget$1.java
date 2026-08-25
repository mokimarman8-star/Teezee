package com.transsion.mbwidget;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.widget.RemoteViews;
import com.transsion.gslb.BuildConfig;
import com.transsion.mbwidget.HotSubjectWidgetProvider;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.mbwidget.HotSubjectWidgetProvider$Companion$updateWidget$1", f = "HotSubjectWidgetProvider.kt", l = {114, 115}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class HotSubjectWidgetProvider$Companion$updateWidget$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $appWidgetId;
    final /* synthetic */ AppWidgetManager $appWidgetManager;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $refreshId;
    Object L$0;
    int label;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.mbwidget.HotSubjectWidgetProvider$Companion$updateWidget$1$1", f = "HotSubjectWidgetProvider.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsion.mbwidget.HotSubjectWidgetProvider$Companion$updateWidget$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $appWidgetId;
        final /* synthetic */ AppWidgetManager $appWidgetManager;
        final /* synthetic */ RemoteViews $views;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AppWidgetManager appWidgetManager, int i, RemoteViews remoteViews, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$appWidgetManager = appWidgetManager;
            this.$appWidgetId = i;
            this.$views = remoteViews;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$appWidgetManager, this.$appWidgetId, this.$views, continuation);
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
            this.$appWidgetManager.updateAppWidget(this.$appWidgetId, this.$views);
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HotSubjectWidgetProvider$Companion$updateWidget$1(int i, String str, Context context, AppWidgetManager appWidgetManager, Continuation<? super HotSubjectWidgetProvider$Companion$updateWidget$1> continuation) {
        super(2, continuation);
        this.$appWidgetId = i;
        this.$refreshId = str;
        this.$context = context;
        this.$appWidgetManager = appWidgetManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HotSubjectWidgetProvider$Companion$updateWidget$1(this.$appWidgetId, this.$refreshId, this.$context, this.$appWidgetManager, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        RemoteViews remoteViews;
        Object c;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            wf.a.a.c("DeskWidget_", "HotSubjectWidgetProvider-updateWidget: " + this.$appWidgetId + " -refreshId:" + this.$refreshId, true);
            remoteViews = new RemoteViews(this.$context.getPackageName(), R$layout.widget_subject_big);
            HotSubjectWidgetProvider.Companion companion = HotSubjectWidgetProvider.INSTANCE;
            Context context = this.$context;
            int i2 = this.$appWidgetId;
            String str = this.$refreshId;
            this.L$0 = remoteViews;
            this.label = 1;
            c = companion.c(context, remoteViews, i2, str, this);
            if (c == f) {
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
            remoteViews = (RemoteViews) this.L$0;
            ResultKt.b(obj);
        }
        a2 c2 = y0.c();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$appWidgetManager, this.$appWidgetId, remoteViews, null);
        this.L$0 = null;
        this.label = 2;
        if (i.g(c2, anonymousClass1, this) == f) {
            return f;
        }
        return Unit.a;
    }
}
