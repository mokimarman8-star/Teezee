package com.transsion.mbwidget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.RemoteViews;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.gslb.BuildConfig;
import com.transsion.mbwidget.data.WidgetDataManager;
import com.transsion.mbwidget.utils.BitmapUtils;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import wf.a;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0017\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/transsion/mbwidget/HotSubjectWidgetProvider;", "Landroid/appwidget/AppWidgetProvider;", "<init>", "()V", "Landroid/content/Context;", "context", BuildConfig.FLAVOR, "refreshId", BuildConfig.FLAVOR, "widgetId", BuildConfig.FLAVOR, "e", "(Landroid/content/Context;Ljava/lang/String;I)V", "Landroid/appwidget/AppWidgetManager;", "appWidgetManager", BuildConfig.FLAVOR, "appWidgetIds", "onUpdate", "(Landroid/content/Context;Landroid/appwidget/AppWidgetManager;[I)V", "Landroid/content/Intent;", "intent", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "onDeleted", "(Landroid/content/Context;[I)V", "onDisabled", "(Landroid/content/Context;)V", "onEnabled", "a", "Companion", "DeskWidget_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class HotSubjectWidgetProvider extends AppWidgetProvider {

    /* renamed from: a, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List b = CollectionsKt.o(new Integer[]{Integer.valueOf(R$id.work_title1), Integer.valueOf(R$id.work_title2), Integer.valueOf(R$id.work_title3)});
    private static final List c = CollectionsKt.o(new Integer[]{Integer.valueOf(R$id.work_img1), Integer.valueOf(R$id.work_img2), Integer.valueOf(R$id.work_img3)});
    private static final List d = CollectionsKt.o(new Integer[]{Integer.valueOf(R$id.work_root1), Integer.valueOf(R$id.work_root2), Integer.valueOf(R$id.work_root3)});
    private static final List e = CollectionsKt.o(new Integer[]{Integer.valueOf(R$id.work_tag1), Integer.valueOf(R$id.work_tag2), Integer.valueOf(R$id.work_tag3)});

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0138, code lost:
        
            r14 = r12.b();
            r12 = r12.a();
            r1.setTextViewText(((java.lang.Number) com.transsion.mbwidget.HotSubjectWidgetProvider.b.get(r12)).intValue(), r14.getTitle());
            r1.setTextViewText(((java.lang.Number) com.transsion.mbwidget.HotSubjectWidgetProvider.e.get(r12)).intValue(), r14.getCorner());
            r9 = ((java.lang.Number) com.transsion.mbwidget.HotSubjectWidgetProvider.e.get(r12)).intValue();
            r15 = r14.getCorner();
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x017c, code lost:
        
            if (r15 == null) goto L59;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0182, code lost:
        
            if (r15.length() != 0) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0185, code lost:
        
            r15 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0189, code lost:
        
            r1.setViewVisibility(r9, r15);
            r9 = com.transsion.mbwidget.HotSubjectWidgetProvider.INSTANCE;
            r15 = r14.getCover();
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0192, code lost:
        
            if (r15 == null) goto L63;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0194, code lost:
        
            r13 = r15.getUrl();
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0198, code lost:
        
            r3.L$0 = r11;
            r3.L$1 = r1;
            r3.L$2 = r6;
            r3.L$3 = r2;
            r3.L$4 = r14;
            r3.I$0 = r0;
            r3.I$1 = r12;
            r3.label = 3;
            r9 = r9.d(r13, r12, r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x01ac, code lost:
        
            if (r9 != r5) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x01ae, code lost:
        
            return r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x01af, code lost:
        
            r13 = r1;
            r1 = r0;
            r0 = r12;
            r12 = r6;
            r6 = r14;
            r14 = r11;
            r11 = r2;
            r2 = r9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x0187, code lost:
        
            r15 = 8;
         */
        /* JADX WARN: Removed duplicated region for block: B:17:0x00fa A[Catch: all -> 0x0101, TryCatch #0 {all -> 0x0101, blocks: (B:61:0x0227, B:23:0x0123, B:25:0x012a, B:30:0x0138, B:32:0x017e, B:36:0x0189, B:38:0x0194, B:39:0x0198, B:57:0x0200, B:21:0x011b, B:15:0x00f6, B:17:0x00fa, B:18:0x0104, B:10:0x00da), top: B:9:0x00da }] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x011a A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x012a A[Catch: all -> 0x0101, TryCatch #0 {all -> 0x0101, blocks: (B:61:0x0227, B:23:0x0123, B:25:0x012a, B:30:0x0138, B:32:0x017e, B:36:0x0189, B:38:0x0194, B:39:0x0198, B:57:0x0200, B:21:0x011b, B:15:0x00f6, B:17:0x00fa, B:18:0x0104, B:10:0x00da), top: B:9:0x00da }] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0267  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0200 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:65:0x0030 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:8:0x00ae  */
        /* JADX WARN: Type inference failed for: r6v0, types: [int] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object c(Context context, RemoteViews remoteViews, int i, String str, Continuation continuation) {
            HotSubjectWidgetProvider$Companion$bindList$1 hotSubjectWidgetProvider$Companion$bindList$1;
            Object obj;
            Object f;
            ?? r6;
            int i2;
            int i3;
            Context context2;
            String str2;
            Object obj2;
            VideoDetailPlayBean videoDetailPlayBean;
            Context context3;
            Object obj3;
            Throwable th2;
            Iterator it;
            RemoteViews remoteViews2 = remoteViews;
            if (continuation instanceof HotSubjectWidgetProvider$Companion$bindList$1) {
                hotSubjectWidgetProvider$Companion$bindList$1 = (HotSubjectWidgetProvider$Companion$bindList$1) continuation;
                int i4 = hotSubjectWidgetProvider$Companion$bindList$1.label;
                if ((i4 & Integer.MIN_VALUE) != 0) {
                    hotSubjectWidgetProvider$Companion$bindList$1.label = i4 - Integer.MIN_VALUE;
                    obj = hotSubjectWidgetProvider$Companion$bindList$1.result;
                    f = IntrinsicsKt.f();
                    r6 = hotSubjectWidgetProvider$Companion$bindList$1.label;
                    i2 = 2;
                    if (r6 == 0) {
                        try {
                        } catch (Throwable th3) {
                            th = th3;
                            remoteViews2 = r6;
                        }
                        if (r6 != 1) {
                            if (r6 == 2) {
                                i3 = hotSubjectWidgetProvider$Companion$bindList$1.I$0;
                                VideoDetailPlayBean videoDetailPlayBean2 = (VideoDetailPlayBean) hotSubjectWidgetProvider$Companion$bindList$1.L$2;
                                RemoteViews remoteViews3 = (RemoteViews) hotSubjectWidgetProvider$Companion$bindList$1.L$1;
                                context2 = (Context) hotSubjectWidgetProvider$Companion$bindList$1.L$0;
                                ResultKt.b(obj);
                                videoDetailPlayBean = videoDetailPlayBean2;
                                remoteViews2 = remoteViews3;
                                it = ((List) obj).iterator();
                                while (true) {
                                    String str3 = null;
                                    if (!it.hasNext()) {
                                    }
                                    i2 = 2;
                                }
                                remoteViews2.setImageViewBitmap(R$id.work_img4, (Bitmap) obj);
                                com.transsion.mbwidget.utils.a.j(com.transsion.mbwidget.utils.a.a, "subject", videoDetailPlayBean.getSubjectId(), null, 4, null);
                                remoteViews2.setOnClickPendingIntent(R$id.work_root4, WidgetDataManager.a.v(context3, true, Boxing.d(i3), videoDetailPlayBean.getSubjectId()));
                                obj3 = Result.constructor-impl(Unit.a);
                                th2 = Result.exceptionOrNull-impl(obj3);
                                if (th2 != null) {
                                }
                                remoteViews2.setTextViewText(R$id.widget_search_tv, WidgetDataManager.a.t());
                                com.transsion.mbwidget.utils.a aVar = com.transsion.mbwidget.utils.a.a;
                                com.transsion.mbwidget.utils.a.j(aVar, "search", null, null, 6, null);
                                com.transsion.mbwidget.utils.a.j(aVar, "root", null, null, 6, null);
                                return Unit.a;
                            }
                            if (r6 != 3) {
                                if (r6 != 4) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                i3 = hotSubjectWidgetProvider$Companion$bindList$1.I$0;
                                VideoDetailPlayBean videoDetailPlayBean3 = (VideoDetailPlayBean) hotSubjectWidgetProvider$Companion$bindList$1.L$2;
                                RemoteViews remoteViews4 = (RemoteViews) hotSubjectWidgetProvider$Companion$bindList$1.L$1;
                                context3 = (Context) hotSubjectWidgetProvider$Companion$bindList$1.L$0;
                                try {
                                    ResultKt.b(obj);
                                    videoDetailPlayBean = videoDetailPlayBean3;
                                    remoteViews2 = remoteViews4;
                                    remoteViews2.setImageViewBitmap(R$id.work_img4, (Bitmap) obj);
                                    com.transsion.mbwidget.utils.a.j(com.transsion.mbwidget.utils.a.a, "subject", videoDetailPlayBean.getSubjectId(), null, 4, null);
                                    remoteViews2.setOnClickPendingIntent(R$id.work_root4, WidgetDataManager.a.v(context3, true, Boxing.d(i3), videoDetailPlayBean.getSubjectId()));
                                    obj3 = Result.constructor-impl(Unit.a);
                                } catch (Throwable th4) {
                                    th = th4;
                                    remoteViews2 = remoteViews4;
                                    Result.Companion companion = Result.Companion;
                                    obj3 = Result.constructor-impl(ResultKt.a(th));
                                    th2 = Result.exceptionOrNull-impl(obj3);
                                    if (th2 != null) {
                                    }
                                    remoteViews2.setTextViewText(R$id.widget_search_tv, WidgetDataManager.a.t());
                                    com.transsion.mbwidget.utils.a aVar2 = com.transsion.mbwidget.utils.a.a;
                                    com.transsion.mbwidget.utils.a.j(aVar2, "search", null, null, 6, null);
                                    com.transsion.mbwidget.utils.a.j(aVar2, "root", null, null, 6, null);
                                    return Unit.a;
                                }
                                th2 = Result.exceptionOrNull-impl(obj3);
                                if (th2 != null) {
                                    wf.a.a.c("DeskWidget_", "hot- error:" + th2, true);
                                }
                                remoteViews2.setTextViewText(R$id.widget_search_tv, WidgetDataManager.a.t());
                                com.transsion.mbwidget.utils.a aVar22 = com.transsion.mbwidget.utils.a.a;
                                com.transsion.mbwidget.utils.a.j(aVar22, "search", null, null, 6, null);
                                com.transsion.mbwidget.utils.a.j(aVar22, "root", null, null, 6, null);
                                return Unit.a;
                            }
                            int i5 = hotSubjectWidgetProvider$Companion$bindList$1.I$1;
                            int i6 = hotSubjectWidgetProvider$Companion$bindList$1.I$0;
                            Subject subject = (Subject) hotSubjectWidgetProvider$Companion$bindList$1.L$4;
                            Iterator it2 = (Iterator) hotSubjectWidgetProvider$Companion$bindList$1.L$3;
                            VideoDetailPlayBean videoDetailPlayBean4 = (VideoDetailPlayBean) hotSubjectWidgetProvider$Companion$bindList$1.L$2;
                            RemoteViews remoteViews5 = (RemoteViews) hotSubjectWidgetProvider$Companion$bindList$1.L$1;
                            Context context4 = (Context) hotSubjectWidgetProvider$Companion$bindList$1.L$0;
                            try {
                                ResultKt.b(obj);
                                remoteViews5.setImageViewBitmap(((Number) HotSubjectWidgetProvider.c.get(i5)).intValue(), (Bitmap) obj);
                                remoteViews5.setOnClickPendingIntent(((Number) HotSubjectWidgetProvider.d.get(i5)).intValue(), WidgetDataManager.a.v(context4, true, Boxing.d(i6), subject.getSubjectId()));
                                com.transsion.mbwidget.utils.a.a.i("subject", subject.getSubjectId(), subject.getOps());
                                i3 = i6;
                                it = it2;
                                videoDetailPlayBean = videoDetailPlayBean4;
                                remoteViews2 = remoteViews5;
                                context2 = context4;
                                i2 = 2;
                                while (true) {
                                    String str32 = null;
                                    if (!it.hasNext()) {
                                        com.transsion.mbwidget.data.b bVar = (com.transsion.mbwidget.data.b) it.next();
                                        if (bVar.a() <= i2) {
                                            break;
                                        }
                                        i2 = 2;
                                    } else {
                                        remoteViews2.setTextViewText(R$id.work_title4, videoDetailPlayBean.getTitle());
                                        Companion companion2 = HotSubjectWidgetProvider.INSTANCE;
                                        String coverUrl = videoDetailPlayBean.getCoverUrl();
                                        hotSubjectWidgetProvider$Companion$bindList$1.L$0 = context2;
                                        hotSubjectWidgetProvider$Companion$bindList$1.L$1 = remoteViews2;
                                        hotSubjectWidgetProvider$Companion$bindList$1.L$2 = videoDetailPlayBean;
                                        hotSubjectWidgetProvider$Companion$bindList$1.L$3 = null;
                                        hotSubjectWidgetProvider$Companion$bindList$1.L$4 = null;
                                        hotSubjectWidgetProvider$Companion$bindList$1.I$0 = i3;
                                        hotSubjectWidgetProvider$Companion$bindList$1.label = 4;
                                        obj = companion2.d(coverUrl, 11, hotSubjectWidgetProvider$Companion$bindList$1);
                                        if (obj == f) {
                                            return f;
                                        }
                                        context3 = context2;
                                    }
                                }
                                remoteViews2.setImageViewBitmap(R$id.work_img4, (Bitmap) obj);
                                com.transsion.mbwidget.utils.a.j(com.transsion.mbwidget.utils.a.a, "subject", videoDetailPlayBean.getSubjectId(), null, 4, null);
                                remoteViews2.setOnClickPendingIntent(R$id.work_root4, WidgetDataManager.a.v(context3, true, Boxing.d(i3), videoDetailPlayBean.getSubjectId()));
                                obj3 = Result.constructor-impl(Unit.a);
                            } catch (Throwable th5) {
                                th = th5;
                                remoteViews2 = remoteViews5;
                                Result.Companion companion3 = Result.Companion;
                                obj3 = Result.constructor-impl(ResultKt.a(th));
                                th2 = Result.exceptionOrNull-impl(obj3);
                                if (th2 != null) {
                                }
                                remoteViews2.setTextViewText(R$id.widget_search_tv, WidgetDataManager.a.t());
                                com.transsion.mbwidget.utils.a aVar222 = com.transsion.mbwidget.utils.a.a;
                                com.transsion.mbwidget.utils.a.j(aVar222, "search", null, null, 6, null);
                                com.transsion.mbwidget.utils.a.j(aVar222, "root", null, null, 6, null);
                                return Unit.a;
                            }
                            th2 = Result.exceptionOrNull-impl(obj3);
                            if (th2 != null) {
                            }
                            remoteViews2.setTextViewText(R$id.widget_search_tv, WidgetDataManager.a.t());
                            com.transsion.mbwidget.utils.a aVar2222 = com.transsion.mbwidget.utils.a.a;
                            com.transsion.mbwidget.utils.a.j(aVar2222, "search", null, null, 6, null);
                            com.transsion.mbwidget.utils.a.j(aVar2222, "root", null, null, 6, null);
                            return Unit.a;
                        }
                        i3 = hotSubjectWidgetProvider$Companion$bindList$1.I$0;
                        String str4 = (String) hotSubjectWidgetProvider$Companion$bindList$1.L$2;
                        RemoteViews remoteViews6 = (RemoteViews) hotSubjectWidgetProvider$Companion$bindList$1.L$1;
                        context2 = (Context) hotSubjectWidgetProvider$Companion$bindList$1.L$0;
                        ResultKt.b(obj);
                        str2 = str4;
                        remoteViews2 = remoteViews6;
                        obj2 = obj;
                    } else {
                        ResultKt.b(obj);
                        int i7 = R$id.bg_search;
                        WidgetDataManager widgetDataManager = WidgetDataManager.a;
                        remoteViews2.setOnClickPendingIntent(i7, widgetDataManager.s(context, true, Boxing.d(i)));
                        remoteViews2.setOnClickPendingIntent(R$id.ic_refresh, widgetDataManager.q(context, true, Boxing.d(i)));
                        remoteViews2.setOnClickPendingIntent(R$id.widget_root, widgetDataManager.m(context, true, Boxing.d(i)));
                        try {
                            Result.Companion companion4 = Result.Companion;
                            hotSubjectWidgetProvider$Companion$bindList$1.L$0 = context;
                            hotSubjectWidgetProvider$Companion$bindList$1.L$1 = remoteViews2;
                            str2 = str;
                            hotSubjectWidgetProvider$Companion$bindList$1.L$2 = str2;
                            hotSubjectWidgetProvider$Companion$bindList$1.I$0 = i;
                            hotSubjectWidgetProvider$Companion$bindList$1.label = 1;
                            obj2 = widgetDataManager.p(hotSubjectWidgetProvider$Companion$bindList$1);
                            if (obj2 == f) {
                                return f;
                            }
                            context2 = context;
                            i3 = i;
                        } catch (Throwable th6) {
                            th = th6;
                            Result.Companion companion32 = Result.Companion;
                            obj3 = Result.constructor-impl(ResultKt.a(th));
                            th2 = Result.exceptionOrNull-impl(obj3);
                            if (th2 != null) {
                            }
                            remoteViews2.setTextViewText(R$id.widget_search_tv, WidgetDataManager.a.t());
                            com.transsion.mbwidget.utils.a aVar22222 = com.transsion.mbwidget.utils.a.a;
                            com.transsion.mbwidget.utils.a.j(aVar22222, "search", null, null, 6, null);
                            com.transsion.mbwidget.utils.a.j(aVar22222, "root", null, null, 6, null);
                            return Unit.a;
                        }
                    }
                    videoDetailPlayBean = (VideoDetailPlayBean) obj2;
                    if (videoDetailPlayBean == null) {
                        videoDetailPlayBean = WidgetDataManager.a.j();
                    }
                    WidgetDataManager widgetDataManager2 = WidgetDataManager.a;
                    String subjectId = videoDetailPlayBean.getSubjectId();
                    hotSubjectWidgetProvider$Companion$bindList$1.L$0 = context2;
                    hotSubjectWidgetProvider$Companion$bindList$1.L$1 = remoteViews2;
                    hotSubjectWidgetProvider$Companion$bindList$1.L$2 = videoDetailPlayBean;
                    hotSubjectWidgetProvider$Companion$bindList$1.I$0 = i3;
                    hotSubjectWidgetProvider$Companion$bindList$1.label = 2;
                    obj = widgetDataManager2.u(subjectId, str2, hotSubjectWidgetProvider$Companion$bindList$1);
                    if (obj == f) {
                        return f;
                    }
                    it = ((List) obj).iterator();
                    while (true) {
                        String str322 = null;
                        if (!it.hasNext()) {
                        }
                        i2 = 2;
                    }
                    remoteViews2.setImageViewBitmap(R$id.work_img4, (Bitmap) obj);
                    com.transsion.mbwidget.utils.a.j(com.transsion.mbwidget.utils.a.a, "subject", videoDetailPlayBean.getSubjectId(), null, 4, null);
                    remoteViews2.setOnClickPendingIntent(R$id.work_root4, WidgetDataManager.a.v(context3, true, Boxing.d(i3), videoDetailPlayBean.getSubjectId()));
                    obj3 = Result.constructor-impl(Unit.a);
                    th2 = Result.exceptionOrNull-impl(obj3);
                    if (th2 != null) {
                    }
                    remoteViews2.setTextViewText(R$id.widget_search_tv, WidgetDataManager.a.t());
                    com.transsion.mbwidget.utils.a aVar222222 = com.transsion.mbwidget.utils.a.a;
                    com.transsion.mbwidget.utils.a.j(aVar222222, "search", null, null, 6, null);
                    com.transsion.mbwidget.utils.a.j(aVar222222, "root", null, null, 6, null);
                    return Unit.a;
                }
            }
            hotSubjectWidgetProvider$Companion$bindList$1 = new HotSubjectWidgetProvider$Companion$bindList$1(this, continuation);
            obj = hotSubjectWidgetProvider$Companion$bindList$1.result;
            f = IntrinsicsKt.f();
            r6 = hotSubjectWidgetProvider$Companion$bindList$1.label;
            i2 = 2;
            if (r6 == 0) {
            }
            videoDetailPlayBean = (VideoDetailPlayBean) obj2;
            if (videoDetailPlayBean == null) {
            }
            WidgetDataManager widgetDataManager22 = WidgetDataManager.a;
            String subjectId2 = videoDetailPlayBean.getSubjectId();
            hotSubjectWidgetProvider$Companion$bindList$1.L$0 = context2;
            hotSubjectWidgetProvider$Companion$bindList$1.L$1 = remoteViews2;
            hotSubjectWidgetProvider$Companion$bindList$1.L$2 = videoDetailPlayBean;
            hotSubjectWidgetProvider$Companion$bindList$1.I$0 = i3;
            hotSubjectWidgetProvider$Companion$bindList$1.label = 2;
            obj = widgetDataManager22.u(subjectId2, str2, hotSubjectWidgetProvider$Companion$bindList$1);
            if (obj == f) {
            }
            it = ((List) obj).iterator();
            while (true) {
                String str3222 = null;
                if (!it.hasNext()) {
                }
                i2 = 2;
            }
            remoteViews2.setImageViewBitmap(R$id.work_img4, (Bitmap) obj);
            com.transsion.mbwidget.utils.a.j(com.transsion.mbwidget.utils.a.a, "subject", videoDetailPlayBean.getSubjectId(), null, 4, null);
            remoteViews2.setOnClickPendingIntent(R$id.work_root4, WidgetDataManager.a.v(context3, true, Boxing.d(i3), videoDetailPlayBean.getSubjectId()));
            obj3 = Result.constructor-impl(Unit.a);
            th2 = Result.exceptionOrNull-impl(obj3);
            if (th2 != null) {
            }
            remoteViews2.setTextViewText(R$id.widget_search_tv, WidgetDataManager.a.t());
            com.transsion.mbwidget.utils.a aVar2222222 = com.transsion.mbwidget.utils.a.a;
            com.transsion.mbwidget.utils.a.j(aVar2222222, "search", null, null, 6, null);
            com.transsion.mbwidget.utils.a.j(aVar2222222, "root", null, null, 6, null);
            return Unit.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:12:0x004f  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x00a1  */
        /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0058  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0035  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object d(String str, int i, Continuation continuation) {
            HotSubjectWidgetProvider$Companion$getCoverBitmap$1 hotSubjectWidgetProvider$Companion$getCoverBitmap$1;
            int i2;
            Bitmap bitmap;
            if (continuation instanceof HotSubjectWidgetProvider$Companion$getCoverBitmap$1) {
                hotSubjectWidgetProvider$Companion$getCoverBitmap$1 = (HotSubjectWidgetProvider$Companion$getCoverBitmap$1) continuation;
                int i3 = hotSubjectWidgetProvider$Companion$getCoverBitmap$1.label;
                if ((i3 & Integer.MIN_VALUE) != 0) {
                    hotSubjectWidgetProvider$Companion$getCoverBitmap$1.label = i3 - Integer.MIN_VALUE;
                    Object obj = hotSubjectWidgetProvider$Companion$getCoverBitmap$1.result;
                    Object f = IntrinsicsKt.f();
                    i2 = hotSubjectWidgetProvider$Companion$getCoverBitmap$1.label;
                    if (i2 != 0) {
                        ResultKt.b(obj);
                        WidgetDataManager widgetDataManager = WidgetDataManager.a;
                        int b = lj.a.b(68);
                        hotSubjectWidgetProvider$Companion$getCoverBitmap$1.I$0 = i;
                        hotSubjectWidgetProvider$Companion$getCoverBitmap$1.label = 1;
                        obj = widgetDataManager.k(str, b, hotSubjectWidgetProvider$Companion$getCoverBitmap$1);
                        if (obj == f) {
                            return f;
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        i = hotSubjectWidgetProvider$Companion$getCoverBitmap$1.I$0;
                        ResultKt.b(obj);
                    }
                    bitmap = (Bitmap) obj;
                    wf.a.a.c("DeskWidget_", "bindList, i:" + i + ", bitmap:" + (bitmap == null ? Boxing.d(bitmap.getByteCount()) : null), true);
                    if (bitmap != null || bitmap.getByteCount() == 0) {
                        bitmap = BitmapUtils.a.c();
                    }
                    Bitmap a = vf.a.a(Utils.a(), bitmap, lj.a.b(68), lj.a.b(95), false, lj.a.b(5));
                    return a != null ? bitmap : a;
                }
            }
            hotSubjectWidgetProvider$Companion$getCoverBitmap$1 = new HotSubjectWidgetProvider$Companion$getCoverBitmap$1(this, continuation);
            Object obj2 = hotSubjectWidgetProvider$Companion$getCoverBitmap$1.result;
            Object f2 = IntrinsicsKt.f();
            i2 = hotSubjectWidgetProvider$Companion$getCoverBitmap$1.label;
            if (i2 != 0) {
            }
            bitmap = (Bitmap) obj2;
            if (bitmap == null) {
            }
            wf.a.a.c("DeskWidget_", "bindList, i:" + i + ", bitmap:" + (bitmap == null ? Boxing.d(bitmap.getByteCount()) : null), true);
            if (bitmap != null) {
            }
            bitmap = BitmapUtils.a.c();
            Bitmap a2 = vf.a.a(Utils.a(), bitmap, lj.a.b(68), lj.a.b(95), false, lj.a.b(5));
            if (a2 != null) {
            }
        }

        public static /* synthetic */ void f(Companion companion, Context context, AppWidgetManager appWidgetManager, int i, String str, int i2, Object obj) {
            if ((i2 & 8) != 0) {
                str = null;
            }
            companion.e(context, appWidgetManager, i, str);
        }

        public final void e(Context context, AppWidgetManager appWidgetManager, int i, String str) {
            Intrinsics.h(context, "context");
            Intrinsics.h(appWidgetManager, "appWidgetManager");
            i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new HotSubjectWidgetProvider$Companion$updateWidget$1(i, str, context, appWidgetManager, null), 3, (Object) null);
        }
    }

    private final void e(Context context, String refreshId, int widgetId) {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        if (widgetId == 0) {
            int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, (Class<?>) HotSubjectWidgetProvider.class));
            Intrinsics.g(appWidgetIds, "getAppWidgetIds(...)");
            Integer T = ArraysKt.T(appWidgetIds);
            widgetId = T != null ? T.intValue() : 0;
        }
        Companion companion = INSTANCE;
        Intrinsics.e(appWidgetManager);
        companion.e(context, appWidgetManager, widgetId, refreshId);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
        wf.a.a.c("DeskWidget_", "HotSubjectWidgetProvider_onDeleted: " + appWidgetIds, true);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDisabled(Context context) {
        super.onDisabled(context);
        wf.a.a.c("DeskWidget_", "HotSubjectWidgetProvider-onDisabled: Hot", true);
        com.transsion.mbwidget.utils.a.l(com.transsion.mbwidget.utils.a.a, "hot_desk_widget", false, null, 4, null);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onEnabled(Context context) {
        super.onEnabled(context);
        wf.a.a.c("DeskWidget_", "HotSubjectWidgetProvider-onEnabled: Hot", true);
        com.transsion.mbwidget.utils.a.l(com.transsion.mbwidget.utils.a.a, "hot_desk_widget", true, null, 4, null);
    }

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intrinsics.h(context, "context");
        Intrinsics.h(intent, "intent");
        super.onReceive(context, intent);
        wf.a.a.c("DeskWidget_", "HotSubjectWidgetProvider onReceive:" + intent.getAction() + ", moduleName:" + intent.getStringExtra("key_module_name"), true);
        String action = intent.getAction();
        int intExtra = intent.getIntExtra("appWidgetId", 0);
        if (Intrinsics.c("com.transsion.mbwidget.hot.ACTION_CLICK", action)) {
            e(context, intent.getStringExtra("key_subject_id_widget"), intExtra);
            com.transsion.mbwidget.utils.a.a.h(intent);
            String stringExtra = intent.getStringExtra("key_deeplink_widget");
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setFlags(268435456);
            intent2.setData(Uri.parse(stringExtra));
            context.startActivity(intent2);
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        Object obj;
        Intrinsics.h(context, "context");
        Intrinsics.h(appWidgetManager, "appWidgetManager");
        Intrinsics.h(appWidgetIds, "appWidgetIds");
        for (int i : appWidgetIds) {
            try {
                Result.Companion companion = Result.Companion;
                Companion.f(INSTANCE, context, appWidgetManager, i, null, 8, null);
                obj = Result.constructor-impl(Unit.a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.a(th2));
            }
            Throwable th3 = Result.exceptionOrNull-impl(obj);
            if (th3 != null) {
                a.a.l(wf.a.a, "DeskWidget_", "HotSubjectWidgetProvider,error:" + th3.getMessage(), false, 4, (Object) null);
            }
        }
    }
}
