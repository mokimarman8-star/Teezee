package com.transsion.mbwidget;

import android.app.Application;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.RemoteViews;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.gslb.BuildConfig;
import com.transsion.mbwidget.data.WidgetDataManager;
import com.transsion.mbwidget.utils.BitmapUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/transsion/mbwidget/PlayWidgetProvider;", "Landroid/appwidget/AppWidgetProvider;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/appwidget/AppWidgetManager;", "appWidgetManager", BuildConfig.FLAVOR, "appWidgetIds", BuildConfig.FLAVOR, "onUpdate", "(Landroid/content/Context;Landroid/appwidget/AppWidgetManager;[I)V", "Landroid/content/Intent;", "intent", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "onDisabled", "(Landroid/content/Context;)V", "onEnabled", "a", "Companion", "DeskWidget_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PlayWidgetProvider extends AppWidgetProvider {

    /* renamed from: a, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Can't wrap try/catch for region: R(11:0|1|(2:3|(7:5|6|(1:(1:(14:10|11|12|13|(10:15|(1:17)|18|19|(1:21)|22|23|(1:25)|26|27)|30|18|19|(0)|22|23|(0)|26|27)(2:33|34))(1:35))(2:48|(1:50)(1:51))|36|37|38|(2:40|(1:42)(12:43|13|(0)|30|18|19|(0)|22|23|(0)|26|27))(7:45|(0)|22|23|(0)|26|27)))|52|6|(0)(0)|36|37|38|(0)(0)|(1:(0))) */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x010a, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x010b, code lost:
        
            r1 = r4;
            r4 = r10;
            r3 = r11;
            r10 = r6;
         */
        /* JADX WARN: Removed duplicated region for block: B:15:0x00bd A[Catch: all -> 0x0049, TryCatch #0 {all -> 0x0049, blocks: (B:12:0x0044, B:13:0x00b9, B:15:0x00bd, B:19:0x00cf, B:21:0x0116, B:22:0x0124, B:30:0x00c6), top: B:11:0x0044 }] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0116 A[Catch: all -> 0x0049, TryCatch #0 {all -> 0x0049, blocks: (B:12:0x0044, B:13:0x00b9, B:15:0x00bd, B:19:0x00cf, B:21:0x0116, B:22:0x0124, B:30:0x00c6), top: B:11:0x0044 }] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x013b  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x008a A[Catch: all -> 0x010a, TRY_LEAVE, TryCatch #1 {all -> 0x010a, blocks: (B:38:0x0086, B:40:0x008a), top: B:37:0x0086 }] */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0110  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object b(Context context, RemoteViews remoteViews, int i, Continuation continuation) {
            PlayWidgetProvider$Companion$bindHistory$1 playWidgetProvider$Companion$bindHistory$1;
            int i2;
            Context context2;
            int i3;
            RemoteViews remoteViews2;
            VideoDetailPlayBean videoDetailPlayBean;
            Context context3;
            Ref.ObjectRef objectRef;
            int i4;
            RemoteViews remoteViews3;
            VideoDetailPlayBean videoDetailPlayBean2;
            PendingIntent pendingIntent;
            Bitmap bitmap;
            if (continuation instanceof PlayWidgetProvider$Companion$bindHistory$1) {
                playWidgetProvider$Companion$bindHistory$1 = (PlayWidgetProvider$Companion$bindHistory$1) continuation;
                int i5 = playWidgetProvider$Companion$bindHistory$1.label;
                if ((i5 & Integer.MIN_VALUE) != 0) {
                    playWidgetProvider$Companion$bindHistory$1.label = i5 - Integer.MIN_VALUE;
                    Object obj = playWidgetProvider$Companion$bindHistory$1.result;
                    Object f = IntrinsicsKt.f();
                    i2 = playWidgetProvider$Companion$bindHistory$1.label;
                    if (i2 != 0) {
                        ResultKt.b(obj);
                        WidgetDataManager widgetDataManager = WidgetDataManager.a;
                        context2 = context;
                        playWidgetProvider$Companion$bindHistory$1.L$0 = context2;
                        playWidgetProvider$Companion$bindHistory$1.L$1 = remoteViews;
                        i3 = i;
                        playWidgetProvider$Companion$bindHistory$1.I$0 = i3;
                        playWidgetProvider$Companion$bindHistory$1.label = 1;
                        obj = widgetDataManager.p(playWidgetProvider$Companion$bindHistory$1);
                        if (obj == f) {
                            return f;
                        }
                        remoteViews2 = remoteViews;
                    } else {
                        if (i2 != 1) {
                            if (i2 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            i4 = playWidgetProvider$Companion$bindHistory$1.I$0;
                            objectRef = (Ref.ObjectRef) playWidgetProvider$Companion$bindHistory$1.L$3;
                            videoDetailPlayBean2 = (VideoDetailPlayBean) playWidgetProvider$Companion$bindHistory$1.L$2;
                            remoteViews3 = (RemoteViews) playWidgetProvider$Companion$bindHistory$1.L$1;
                            context3 = (Context) playWidgetProvider$Companion$bindHistory$1.L$0;
                            try {
                                ResultKt.b(obj);
                                bitmap = (Bitmap) obj;
                            } catch (Throwable th2) {
                                th = th2;
                                Result.Companion companion = Result.Companion;
                                Result.constructor-impl(ResultKt.a(th));
                                int i6 = R$id.widget_root;
                                pendingIntent = (PendingIntent) objectRef.element;
                                if (pendingIntent == null) {
                                }
                                remoteViews3.setOnClickPendingIntent(i6, pendingIntent);
                                remoteViews3.setOnClickPendingIntent(R$id.widget_search, WidgetDataManager.a.s(context3, false, Boxing.d(i4)));
                                com.transsion.mbwidget.utils.a.e(com.transsion.mbwidget.utils.a.a, "search", null, 2, null);
                                return Unit.a;
                            }
                            if (bitmap != null) {
                                if (bitmap.getByteCount() != 0) {
                                }
                                remoteViews3.setImageViewBitmap(R$id.widget_img, vf.a.a(Utils.a(), bitmap, lj.a.b(140), lj.a.b(154), false, lj.a.b(16)));
                                objectRef.element = WidgetDataManager.a.v(context3, false, Boxing.d(i4), videoDetailPlayBean2.getSubjectId());
                                com.transsion.mbwidget.utils.a.a.d("subject", videoDetailPlayBean2.getSubjectId());
                                videoDetailPlayBean = videoDetailPlayBean2;
                                if (videoDetailPlayBean == null) {
                                    com.transsion.mbwidget.utils.a.e(com.transsion.mbwidget.utils.a.a, "root", null, 2, null);
                                    remoteViews3.setImageViewResource(R$id.widget_img, R$mipmap.bg_img_widget_small);
                                }
                                Result.constructor-impl(Unit.a);
                                int i62 = R$id.widget_root;
                                pendingIntent = (PendingIntent) objectRef.element;
                                if (pendingIntent == null) {
                                    pendingIntent = WidgetDataManager.a.m(context3, false, Boxing.d(i4));
                                }
                                remoteViews3.setOnClickPendingIntent(i62, pendingIntent);
                                remoteViews3.setOnClickPendingIntent(R$id.widget_search, WidgetDataManager.a.s(context3, false, Boxing.d(i4)));
                                com.transsion.mbwidget.utils.a.e(com.transsion.mbwidget.utils.a.a, "search", null, 2, null);
                                return Unit.a;
                            }
                            bitmap = BitmapUtils.a.b(R$mipmap.bg_img_widget_small);
                            remoteViews3.setImageViewBitmap(R$id.widget_img, vf.a.a(Utils.a(), bitmap, lj.a.b(140), lj.a.b(154), false, lj.a.b(16)));
                            objectRef.element = WidgetDataManager.a.v(context3, false, Boxing.d(i4), videoDetailPlayBean2.getSubjectId());
                            com.transsion.mbwidget.utils.a.a.d("subject", videoDetailPlayBean2.getSubjectId());
                            videoDetailPlayBean = videoDetailPlayBean2;
                            if (videoDetailPlayBean == null) {
                            }
                            Result.constructor-impl(Unit.a);
                            int i622 = R$id.widget_root;
                            pendingIntent = (PendingIntent) objectRef.element;
                            if (pendingIntent == null) {
                            }
                            remoteViews3.setOnClickPendingIntent(i622, pendingIntent);
                            remoteViews3.setOnClickPendingIntent(R$id.widget_search, WidgetDataManager.a.s(context3, false, Boxing.d(i4)));
                            com.transsion.mbwidget.utils.a.e(com.transsion.mbwidget.utils.a.a, "search", null, 2, null);
                            return Unit.a;
                        }
                        int i7 = playWidgetProvider$Companion$bindHistory$1.I$0;
                        remoteViews2 = (RemoteViews) playWidgetProvider$Companion$bindHistory$1.L$1;
                        Context context4 = (Context) playWidgetProvider$Companion$bindHistory$1.L$0;
                        ResultKt.b(obj);
                        i3 = i7;
                        context2 = context4;
                    }
                    videoDetailPlayBean = (VideoDetailPlayBean) obj;
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    Result.Companion companion2 = Result.Companion;
                    if (videoDetailPlayBean != null) {
                        context3 = context2;
                        objectRef = objectRef2;
                        i4 = i3;
                        remoteViews3 = remoteViews2;
                        if (videoDetailPlayBean == null) {
                        }
                        Result.constructor-impl(Unit.a);
                        int i6222 = R$id.widget_root;
                        pendingIntent = (PendingIntent) objectRef.element;
                        if (pendingIntent == null) {
                        }
                        remoteViews3.setOnClickPendingIntent(i6222, pendingIntent);
                        remoteViews3.setOnClickPendingIntent(R$id.widget_search, WidgetDataManager.a.s(context3, false, Boxing.d(i4)));
                        com.transsion.mbwidget.utils.a.e(com.transsion.mbwidget.utils.a.a, "search", null, 2, null);
                        return Unit.a;
                    }
                    BitmapUtils bitmapUtils = BitmapUtils.a;
                    Application a = Utils.a();
                    Intrinsics.g(a, "getApp(...)");
                    String coverUrl = videoDetailPlayBean.getCoverUrl();
                    int b = lj.a.b(154);
                    playWidgetProvider$Companion$bindHistory$1.L$0 = context2;
                    playWidgetProvider$Companion$bindHistory$1.L$1 = remoteViews2;
                    playWidgetProvider$Companion$bindHistory$1.L$2 = videoDetailPlayBean;
                    playWidgetProvider$Companion$bindHistory$1.L$3 = objectRef2;
                    playWidgetProvider$Companion$bindHistory$1.I$0 = i3;
                    playWidgetProvider$Companion$bindHistory$1.label = 2;
                    Object d = bitmapUtils.d(a, coverUrl, b, playWidgetProvider$Companion$bindHistory$1);
                    if (d == f) {
                        return f;
                    }
                    i4 = i3;
                    RemoteViews remoteViews4 = remoteViews2;
                    videoDetailPlayBean2 = videoDetailPlayBean;
                    obj = d;
                    context3 = context2;
                    objectRef = objectRef2;
                    remoteViews3 = remoteViews4;
                    bitmap = (Bitmap) obj;
                    if (bitmap != null) {
                    }
                    bitmap = BitmapUtils.a.b(R$mipmap.bg_img_widget_small);
                    remoteViews3.setImageViewBitmap(R$id.widget_img, vf.a.a(Utils.a(), bitmap, lj.a.b(140), lj.a.b(154), false, lj.a.b(16)));
                    objectRef.element = WidgetDataManager.a.v(context3, false, Boxing.d(i4), videoDetailPlayBean2.getSubjectId());
                    com.transsion.mbwidget.utils.a.a.d("subject", videoDetailPlayBean2.getSubjectId());
                    videoDetailPlayBean = videoDetailPlayBean2;
                    if (videoDetailPlayBean == null) {
                    }
                    Result.constructor-impl(Unit.a);
                    int i62222 = R$id.widget_root;
                    pendingIntent = (PendingIntent) objectRef.element;
                    if (pendingIntent == null) {
                    }
                    remoteViews3.setOnClickPendingIntent(i62222, pendingIntent);
                    remoteViews3.setOnClickPendingIntent(R$id.widget_search, WidgetDataManager.a.s(context3, false, Boxing.d(i4)));
                    com.transsion.mbwidget.utils.a.e(com.transsion.mbwidget.utils.a.a, "search", null, 2, null);
                    return Unit.a;
                }
            }
            playWidgetProvider$Companion$bindHistory$1 = new PlayWidgetProvider$Companion$bindHistory$1(this, continuation);
            Object obj2 = playWidgetProvider$Companion$bindHistory$1.result;
            Object f2 = IntrinsicsKt.f();
            i2 = playWidgetProvider$Companion$bindHistory$1.label;
            if (i2 != 0) {
            }
            videoDetailPlayBean = (VideoDetailPlayBean) obj2;
            Ref.ObjectRef objectRef22 = new Ref.ObjectRef();
            Result.Companion companion22 = Result.Companion;
            if (videoDetailPlayBean != null) {
            }
        }

        public final void c(Context context, AppWidgetManager appWidgetManager, int i) {
            Intrinsics.h(context, "context");
            Intrinsics.h(appWidgetManager, "appWidgetManager");
            i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new PlayWidgetProvider$Companion$updateWidget$1(i, context, appWidgetManager, null), 3, (Object) null);
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDisabled(Context context) {
        super.onDisabled(context);
        com.transsion.mbwidget.utils.a.l(com.transsion.mbwidget.utils.a.a, "history_desk_widget", false, null, 4, null);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onEnabled(Context context) {
        super.onEnabled(context);
        com.transsion.mbwidget.utils.a.l(com.transsion.mbwidget.utils.a.a, "history_desk_widget", true, null, 4, null);
    }

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intrinsics.h(context, "context");
        Intrinsics.h(intent, "intent");
        super.onReceive(context, intent);
        String action = intent.getAction();
        Bundle extras = intent.getExtras();
        StringBuilder sb = new StringBuilder();
        sb.append("Play onReceive:");
        sb.append(action);
        sb.append(", ");
        sb.append(extras);
        if (Intrinsics.c("com.transsion.mbwidget.play.ACTION_CLICK", intent.getAction())) {
            com.transsion.mbwidget.utils.a.a.c(intent);
            String stringExtra = intent.getStringExtra("key_deeplink_widget");
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setFlags(268435456);
            intent2.setData(Uri.parse(stringExtra));
            context.startActivity(intent2);
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appWidgetManager, "appWidgetManager");
        Intrinsics.h(appWidgetIds, "appWidgetIds");
        for (int i : appWidgetIds) {
            StringBuilder sb = new StringBuilder();
            sb.append("appWidgetId:");
            sb.append(i);
            INSTANCE.c(context, appWidgetManager, i);
        }
    }
}
