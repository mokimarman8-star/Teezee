package com.transsion.mbwidget;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.widget.RemoteViews;
import com.transsion.gslb.BuildConfig;
import com.transsion.mbwidget.SportSchedulePreviewWidgetProvider;
import com.transsion.mbwidget.data.SportMatch;
import com.transsion.mbwidget.data.SportWidgetDataManager;
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
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.mbwidget.SportSchedulePreviewWidgetProvider$Companion$updateWidget$1", f = "SportSchedulePreviewWidgetProvider.kt", l = {176, 178, 186, 197}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class SportSchedulePreviewWidgetProvider$Companion$updateWidget$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $appWidgetId;
    final /* synthetic */ AppWidgetManager $appWidgetManager;
    final /* synthetic */ Context $context;
    final /* synthetic */ int $hDp;
    final /* synthetic */ boolean $reportExposure;
    final /* synthetic */ int $wDp;
    Object L$0;
    Object L$1;
    int label;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.mbwidget.SportSchedulePreviewWidgetProvider$Companion$updateWidget$1$1", f = "SportSchedulePreviewWidgetProvider.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsion.mbwidget.SportSchedulePreviewWidgetProvider$Companion$updateWidget$1$1, reason: invalid class name */
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

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.mbwidget.SportSchedulePreviewWidgetProvider$Companion$updateWidget$1$2", f = "SportSchedulePreviewWidgetProvider.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsion.mbwidget.SportSchedulePreviewWidgetProvider$Companion$updateWidget$1$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $appWidgetId;
        final /* synthetic */ AppWidgetManager $appWidgetManager;
        final /* synthetic */ RemoteViews $errorViews;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(AppWidgetManager appWidgetManager, int i, RemoteViews remoteViews, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$appWidgetManager = appWidgetManager;
            this.$appWidgetId = i;
            this.$errorViews = remoteViews;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$appWidgetManager, this.$appWidgetId, this.$errorViews, continuation);
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
            this.$appWidgetManager.updateAppWidget(this.$appWidgetId, this.$errorViews);
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SportSchedulePreviewWidgetProvider$Companion$updateWidget$1(Context context, int i, int i2, int i3, boolean z, AppWidgetManager appWidgetManager, Continuation<? super SportSchedulePreviewWidgetProvider$Companion$updateWidget$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$wDp = i;
        this.$hDp = i2;
        this.$appWidgetId = i3;
        this.$reportExposure = z;
        this.$appWidgetManager = appWidgetManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SportSchedulePreviewWidgetProvider$Companion$updateWidget$1(this.$context, this.$wDp, this.$hDp, this.$appWidgetId, this.$reportExposure, this.$appWidgetManager, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x008c A[Catch: Exception -> 0x002b, TryCatch #0 {Exception -> 0x002b, blocks: (B:14:0x0026, B:16:0x0038, B:17:0x0088, B:19:0x008c, B:23:0x0096, B:25:0x009e, B:26:0x00a4, B:30:0x00a7, B:34:0x0040, B:36:0x0063, B:41:0x0049), top: B:2:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c0 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        RemoteViews remoteViews;
        Object k;
        Object f;
        RemoteViews remoteViews2;
        SportMatch sportMatch;
        a2 c;
        AnonymousClass1 anonymousClass1;
        Object f2 = IntrinsicsKt.f();
        int i = this.label;
        try {
        } catch (Exception e) {
            a.a.k(wf.a.a, "SportWidget_", "updateWidget error: " + e.getMessage(), e, false, 8, (Object) null);
            RemoteViews remoteViews3 = new RemoteViews(this.$context.getPackageName(), R$layout.widget_sport);
            SportSchedulePreviewWidgetProvider.Companion companion = SportSchedulePreviewWidgetProvider.INSTANCE;
            companion.e(remoteViews3, this.$wDp, this.$hDp);
            companion.p(this.$context, remoteViews3, this.$appWidgetId);
            if (this.$reportExposure) {
                com.transsion.mbwidget.utils.a.a.g("root", null, null);
            }
            a2 c2 = y0.c();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$appWidgetManager, this.$appWidgetId, remoteViews3, null);
            this.L$0 = null;
            this.L$1 = null;
            this.label = 4;
            if (i.g(c2, anonymousClass2, this) == f2) {
                return f2;
            }
        }
        if (i == 0) {
            ResultKt.b(obj);
            remoteViews = new RemoteViews(this.$context.getPackageName(), R$layout.widget_sport);
            SportWidgetDataManager sportWidgetDataManager = SportWidgetDataManager.a;
            this.L$0 = remoteViews;
            this.label = 1;
            k = sportWidgetDataManager.k(this);
            if (k == f2) {
                return f2;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        ResultKt.b(obj);
                    } else {
                        if (i != 4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                    }
                    return Unit.a;
                }
                sportMatch = (SportMatch) this.L$1;
                remoteViews2 = (RemoteViews) this.L$0;
                ResultKt.b(obj);
                if (this.$reportExposure) {
                    com.transsion.mbwidget.utils.a.a.g(sportMatch != null ? "match" : "root", sportMatch != null ? sportMatch.getMatchId() : null, sportMatch != null ? sportMatch.getDeeplink() : null);
                }
                c = y0.c();
                anonymousClass1 = new AnonymousClass1(this.$appWidgetManager, this.$appWidgetId, remoteViews2, null);
                this.L$0 = null;
                this.L$1 = null;
                this.label = 3;
                if (i.g(c, anonymousClass1, this) == f2) {
                    return f2;
                }
                return Unit.a;
            }
            remoteViews = (RemoteViews) this.L$0;
            ResultKt.b(obj);
            k = obj;
        }
        SportMatch sportMatch2 = (SportMatch) k;
        SportSchedulePreviewWidgetProvider.Companion companion2 = SportSchedulePreviewWidgetProvider.INSTANCE;
        companion2.e(remoteViews, this.$wDp, this.$hDp);
        Context context = this.$context;
        int i2 = this.$appWidgetId;
        this.L$0 = remoteViews;
        this.L$1 = sportMatch2;
        this.label = 2;
        f = companion2.f(context, remoteViews, i2, sportMatch2, this);
        if (f == f2) {
            return f2;
        }
        remoteViews2 = remoteViews;
        sportMatch = sportMatch2;
        if (this.$reportExposure) {
        }
        c = y0.c();
        anonymousClass1 = new AnonymousClass1(this.$appWidgetManager, this.$appWidgetId, remoteViews2, null);
        this.L$0 = null;
        this.L$1 = null;
        this.label = 3;
        if (i.g(c, anonymousClass1, this) == f2) {
        }
        return Unit.a;
    }
}
