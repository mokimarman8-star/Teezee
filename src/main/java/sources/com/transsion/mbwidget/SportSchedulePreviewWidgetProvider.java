package com.transsion.mbwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.SizeF;
import android.widget.RemoteViews;
import com.transsion.gslb.BuildConfig;
import com.transsion.mbwidget.data.SportMatch;
import com.transsion.mbwidget.data.SportType;
import com.transsion.mbwidget.data.SportWidgetDataManager;
import com.transsion.mbwidget.data.WidgetDataManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import wf.a;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/transsion/mbwidget/SportSchedulePreviewWidgetProvider;", "Landroid/appwidget/AppWidgetProvider;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/appwidget/AppWidgetManager;", "appWidgetManager", BuildConfig.FLAVOR, "appWidgetIds", BuildConfig.FLAVOR, "onUpdate", "(Landroid/content/Context;Landroid/appwidget/AppWidgetManager;[I)V", BuildConfig.FLAVOR, "appWidgetId", "Landroid/os/Bundle;", "newOptions", "onAppWidgetOptionsChanged", "(Landroid/content/Context;Landroid/appwidget/AppWidgetManager;ILandroid/os/Bundle;)V", "Landroid/content/Intent;", "intent", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "onDisabled", "(Landroid/content/Context;)V", "onEnabled", "a", "Companion", "DeskWidget_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SportSchedulePreviewWidgetProvider extends AppWidgetProvider {

    /* renamed from: a, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public static final class Companion {

        private static final class a {
            private final String a;
            private final int b;
            private final int c;

            public a(String str, int i, int i2) {
                Intrinsics.h(str, "name");
                this.a = str;
                this.b = i;
                this.c = i2;
            }

            public final int a() {
                return this.c;
            }

            public final String b() {
                return this.a;
            }

            public final int c() {
                return this.b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return Intrinsics.c(this.a, aVar.a) && this.b == aVar.b && this.c == aVar.c;
            }

            public int hashCode() {
                return (((this.a.hashCode() * 31) + this.b) * 31) + this.c;
            }

            public String toString() {
                return "ReferenceSize(name=" + this.a + ", widthDp=" + this.b + ", heightDp=" + this.c + ")";
            }
        }

        public /* synthetic */ class b {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[SportType.values().length];
                try {
                    iArr[SportType.FOOTBALL.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[SportType.BASKETBALL.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[SportType.CRICKET.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                a = iArr;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void e(RemoteViews remoteViews, int i, int i2) {
            if (Build.VERSION.SDK_INT < 31) {
                return;
            }
            float f = i;
            remoteViews.setViewLayoutWidth(R$id.widget_upcoming_container, f, 1);
            float f2 = i2;
            remoteViews.setViewLayoutHeight(R$id.widget_upcoming_container, f2, 1);
            remoteViews.setViewLayoutWidth(R$id.widget_default_container, f, 1);
            remoteViews.setViewLayoutHeight(R$id.widget_default_container, f2, 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0156 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0157  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0030  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object f(Context context, RemoteViews remoteViews, int i, SportMatch sportMatch, Continuation continuation) {
            SportSchedulePreviewWidgetProvider$Companion$bindMatch$1 sportSchedulePreviewWidgetProvider$Companion$bindMatch$1;
            SportSchedulePreviewWidgetProvider$Companion$bindMatch$1 sportSchedulePreviewWidgetProvider$Companion$bindMatch$12;
            Object f;
            int i2;
            String str;
            Context context2;
            int i3;
            int i4;
            String team2Logo;
            int b2;
            SportMatch sportMatch2;
            Context context3;
            String deeplink;
            RemoteViews remoteViews2 = remoteViews;
            SportMatch sportMatch3 = sportMatch;
            if (continuation instanceof SportSchedulePreviewWidgetProvider$Companion$bindMatch$1) {
                sportSchedulePreviewWidgetProvider$Companion$bindMatch$1 = (SportSchedulePreviewWidgetProvider$Companion$bindMatch$1) continuation;
                int i5 = sportSchedulePreviewWidgetProvider$Companion$bindMatch$1.label;
                if ((i5 & Integer.MIN_VALUE) != 0) {
                    sportSchedulePreviewWidgetProvider$Companion$bindMatch$1.label = i5 - Integer.MIN_VALUE;
                    sportSchedulePreviewWidgetProvider$Companion$bindMatch$12 = sportSchedulePreviewWidgetProvider$Companion$bindMatch$1;
                    Object obj = sportSchedulePreviewWidgetProvider$Companion$bindMatch$12.result;
                    f = IntrinsicsKt.f();
                    i2 = sportSchedulePreviewWidgetProvider$Companion$bindMatch$12.label;
                    if (i2 != 0) {
                        ResultKt.b(obj);
                        if (sportMatch3 == null) {
                            p(context, remoteViews, i);
                            return Unit.a;
                        }
                        a.a.f(wf.a.a, "SportWidget_", "The match data is " + sportMatch3 + ", " + sportMatch.getMatchId(), false, 4, (Object) null);
                        SportWidgetDataManager sportWidgetDataManager = SportWidgetDataManager.a;
                        boolean z = (sportWidgetDataManager.m(sportMatch3) || sportWidgetDataManager.l(sportMatch3)) ? false : true;
                        remoteViews2.setViewVisibility(R$id.widget_upcoming_container, 0);
                        remoteViews2.setViewVisibility(R$id.widget_default_container, 8);
                        remoteViews2.setViewVisibility(R$id.widget_upcoming_label, z ? 0 : 8);
                        int i6 = b.a[sportMatch.getSportType().ordinal()];
                        if (i6 == 1) {
                            str = "football";
                        } else if (i6 == 2) {
                            str = "basketball";
                        } else {
                            if (i6 != 3) {
                                throw new NoWhenBranchMatchedException();
                            }
                            str = "cricket";
                        }
                        n(context, remoteViews, R$id.widget_upcoming_container, R$id.widget_bg_layer2, str);
                        remoteViews2.setTextViewText(R$id.widget_match_time, g(sportMatch.getMatchTime()));
                        remoteViews2.setTextViewText(R$id.widget_team1_name, sportMatch.getTeam1Name());
                        remoteViews2.setTextViewText(R$id.widget_team2_name, sportMatch.getTeam2Name());
                        int i7 = R$id.widget_team1_logo;
                        String team1Logo = sportMatch.getTeam1Logo();
                        int b3 = lj.a.b(28);
                        context2 = context;
                        sportSchedulePreviewWidgetProvider$Companion$bindMatch$12.L$0 = context2;
                        sportSchedulePreviewWidgetProvider$Companion$bindMatch$12.L$1 = remoteViews2;
                        sportSchedulePreviewWidgetProvider$Companion$bindMatch$12.L$2 = sportMatch3;
                        i3 = i;
                        sportSchedulePreviewWidgetProvider$Companion$bindMatch$12.I$0 = i3;
                        sportSchedulePreviewWidgetProvider$Companion$bindMatch$12.label = 1;
                        if (m(remoteViews, i7, team1Logo, b3, sportSchedulePreviewWidgetProvider$Companion$bindMatch$12) == f) {
                            return f;
                        }
                    } else {
                        if (i2 != 1) {
                            if (i2 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            int i8 = sportSchedulePreviewWidgetProvider$Companion$bindMatch$12.I$0;
                            sportMatch2 = (SportMatch) sportSchedulePreviewWidgetProvider$Companion$bindMatch$12.L$2;
                            RemoteViews remoteViews3 = (RemoteViews) sportSchedulePreviewWidgetProvider$Companion$bindMatch$12.L$1;
                            Context context4 = (Context) sportSchedulePreviewWidgetProvider$Companion$bindMatch$12.L$0;
                            ResultKt.b(obj);
                            i3 = i8;
                            remoteViews2 = remoteViews3;
                            context3 = context4;
                            deeplink = sportMatch2.getDeeplink();
                            String matchId = sportMatch2.getMatchId();
                            if (deeplink != null || deeplink.length() == 0) {
                                remoteViews2.setOnClickPendingIntent(R$id.widget_root, i(context3, i3));
                            } else {
                                remoteViews2.setOnClickPendingIntent(R$id.widget_root, j(context3, i3, deeplink, matchId, "match"));
                            }
                            return Unit.a;
                        }
                        int i9 = sportSchedulePreviewWidgetProvider$Companion$bindMatch$12.I$0;
                        SportMatch sportMatch4 = (SportMatch) sportSchedulePreviewWidgetProvider$Companion$bindMatch$12.L$2;
                        RemoteViews remoteViews4 = (RemoteViews) sportSchedulePreviewWidgetProvider$Companion$bindMatch$12.L$1;
                        Context context5 = (Context) sportSchedulePreviewWidgetProvider$Companion$bindMatch$12.L$0;
                        ResultKt.b(obj);
                        i3 = i9;
                        sportMatch3 = sportMatch4;
                        remoteViews2 = remoteViews4;
                        context2 = context5;
                    }
                    i4 = R$id.widget_team2_logo;
                    team2Logo = sportMatch3.getTeam2Logo();
                    b2 = lj.a.b(28);
                    sportSchedulePreviewWidgetProvider$Companion$bindMatch$12.L$0 = context2;
                    sportSchedulePreviewWidgetProvider$Companion$bindMatch$12.L$1 = remoteViews2;
                    sportSchedulePreviewWidgetProvider$Companion$bindMatch$12.L$2 = sportMatch3;
                    sportSchedulePreviewWidgetProvider$Companion$bindMatch$12.I$0 = i3;
                    sportSchedulePreviewWidgetProvider$Companion$bindMatch$12.label = 2;
                    if (m(remoteViews2, i4, team2Logo, b2, sportSchedulePreviewWidgetProvider$Companion$bindMatch$12) != f) {
                        return f;
                    }
                    sportMatch2 = sportMatch3;
                    context3 = context2;
                    deeplink = sportMatch2.getDeeplink();
                    String matchId2 = sportMatch2.getMatchId();
                    if (deeplink != null) {
                    }
                    remoteViews2.setOnClickPendingIntent(R$id.widget_root, i(context3, i3));
                    return Unit.a;
                }
            }
            sportSchedulePreviewWidgetProvider$Companion$bindMatch$1 = new SportSchedulePreviewWidgetProvider$Companion$bindMatch$1(this, continuation);
            sportSchedulePreviewWidgetProvider$Companion$bindMatch$12 = sportSchedulePreviewWidgetProvider$Companion$bindMatch$1;
            Object obj2 = sportSchedulePreviewWidgetProvider$Companion$bindMatch$12.result;
            f = IntrinsicsKt.f();
            i2 = sportSchedulePreviewWidgetProvider$Companion$bindMatch$12.label;
            if (i2 != 0) {
            }
            i4 = R$id.widget_team2_logo;
            team2Logo = sportMatch3.getTeam2Logo();
            b2 = lj.a.b(28);
            sportSchedulePreviewWidgetProvider$Companion$bindMatch$12.L$0 = context2;
            sportSchedulePreviewWidgetProvider$Companion$bindMatch$12.L$1 = remoteViews2;
            sportSchedulePreviewWidgetProvider$Companion$bindMatch$12.L$2 = sportMatch3;
            sportSchedulePreviewWidgetProvider$Companion$bindMatch$12.I$0 = i3;
            sportSchedulePreviewWidgetProvider$Companion$bindMatch$12.label = 2;
            if (m(remoteViews2, i4, team2Logo, b2, sportSchedulePreviewWidgetProvider$Companion$bindMatch$12) != f) {
            }
        }

        private final String g(long j) {
            long currentTimeMillis = System.currentTimeMillis();
            Date date = new Date(j);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int i = calendar.get(6);
            calendar.setTime(new Date(currentTimeMillis));
            if (i == calendar.get(6)) {
                String format = new SimpleDateFormat("HH:mm", Locale.ENGLISH).format(date);
                Intrinsics.e(format);
                return format;
            }
            String format2 = new SimpleDateFormat("MM/dd HH:mm", Locale.ENGLISH).format(date);
            Intrinsics.e(format2);
            return format2;
        }

        private final Pair h(Bundle bundle) {
            int i = bundle.getInt("appWidgetMinWidth", 0);
            int i2 = bundle.getInt("appWidgetMinHeight", 0);
            int i3 = bundle.getInt("appWidgetMaxHeight", 0);
            if (i <= 0) {
                i = 138;
            }
            int i4 = i2 > 0 ? i2 : 145;
            if (Build.VERSION.SDK_INT >= 31) {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList("appWidgetSizes");
                if (parcelableArrayList != null && !parcelableArrayList.isEmpty()) {
                    Iterator it = parcelableArrayList.iterator();
                    if (!it.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    Object next = it.next();
                    if (it.hasNext()) {
                        float f = i;
                        float abs = Math.abs(((SizeF) next).getWidth() - f);
                        do {
                            Object next2 = it.next();
                            float abs2 = Math.abs(((SizeF) next2).getWidth() - f);
                            if (Float.compare(abs, abs2) > 0) {
                                next = next2;
                                abs = abs2;
                            }
                        } while (it.hasNext());
                    }
                    SizeF sizeF = (SizeF) next;
                    i = (int) sizeF.getWidth();
                    i3 = (int) sizeF.getHeight();
                } else if (i3 <= 0) {
                    i3 = i4;
                }
            } else {
                if (i3 > 0) {
                    i2 = i3;
                } else if (i2 <= 0) {
                    i2 = 145;
                }
                i3 = i2;
            }
            return TuplesKt.a(Integer.valueOf(i), Integer.valueOf(i3));
        }

        private final PendingIntent i(Context context, int i) {
            return j(context, i, BuildConfig.FLAVOR, null, "root");
        }

        private final PendingIntent j(Context context, int i, String str, String str2, String str3) {
            Intent intent = new Intent(context, (Class<?>) SportSchedulePreviewWidgetProvider.class);
            intent.setAction("com.transsion.mbwidget.sport.ACTION_CLICK");
            intent.putExtra("appWidgetId", i);
            intent.putExtra("key_deeplink_widget", str);
            intent.putExtra("key_module_name", str3);
            if (str2 != null && str2.length() != 0) {
                intent.putExtra("key_match_id_widget", str2);
            }
            PendingIntent broadcast = PendingIntent.getBroadcast(context, (int) System.currentTimeMillis(), intent, Build.VERSION.SDK_INT >= 31 ? 201326592 : 134217728);
            Intrinsics.g(broadcast, "getBroadcast(...)");
            return broadcast;
        }

        private final int k(Context context, String str, String str2) {
            return context.getResources().getIdentifier(str, str2, context.getPackageName());
        }

        static /* synthetic */ int l(Companion companion, Context context, String str, String str2, int i, Object obj) {
            if ((i & 4) != 0) {
                str2 = "mipmap";
            }
            return companion.k(context, str, str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Can't wrap try/catch for region: R(12:0|1|(2:3|(8:5|6|7|(1:(2:10|11)(2:21|22))(2:23|(2:30|31)(2:27|(1:29)))|12|(1:20)(1:16)|17|18))|35|6|7|(0)(0)|12|(1:14)|20|17|18) */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0034, code lost:
        
            r8 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        
            wf.a.a.k(wf.a.a, "SportWidget_", "Error loading team logo (" + r10 + "): " + r8.getMessage(), r8, false, 8, (java.lang.Object) null);
         */
        /* JADX WARN: Removed duplicated region for block: B:23:0x003f  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object m(RemoteViews remoteViews, int i, String str, int i2, Continuation continuation) {
            SportSchedulePreviewWidgetProvider$Companion$loadTeamLogo$1 sportSchedulePreviewWidgetProvider$Companion$loadTeamLogo$1;
            int i3;
            Bitmap bitmap;
            if (continuation instanceof SportSchedulePreviewWidgetProvider$Companion$loadTeamLogo$1) {
                sportSchedulePreviewWidgetProvider$Companion$loadTeamLogo$1 = (SportSchedulePreviewWidgetProvider$Companion$loadTeamLogo$1) continuation;
                int i4 = sportSchedulePreviewWidgetProvider$Companion$loadTeamLogo$1.label;
                if ((i4 & Integer.MIN_VALUE) != 0) {
                    sportSchedulePreviewWidgetProvider$Companion$loadTeamLogo$1.label = i4 - Integer.MIN_VALUE;
                    Object obj = sportSchedulePreviewWidgetProvider$Companion$loadTeamLogo$1.result;
                    Object f = IntrinsicsKt.f();
                    i3 = sportSchedulePreviewWidgetProvider$Companion$loadTeamLogo$1.label;
                    if (i3 != 0) {
                        ResultKt.b(obj);
                        if (str == null || str.length() == 0) {
                            return Unit.a;
                        }
                        WidgetDataManager widgetDataManager = WidgetDataManager.a;
                        sportSchedulePreviewWidgetProvider$Companion$loadTeamLogo$1.L$0 = remoteViews;
                        sportSchedulePreviewWidgetProvider$Companion$loadTeamLogo$1.L$1 = str;
                        sportSchedulePreviewWidgetProvider$Companion$loadTeamLogo$1.I$0 = i;
                        sportSchedulePreviewWidgetProvider$Companion$loadTeamLogo$1.label = 1;
                        obj = widgetDataManager.k(str, i2, sportSchedulePreviewWidgetProvider$Companion$loadTeamLogo$1);
                        if (obj == f) {
                            return f;
                        }
                    } else {
                        if (i3 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        i = sportSchedulePreviewWidgetProvider$Companion$loadTeamLogo$1.I$0;
                        str = (String) sportSchedulePreviewWidgetProvider$Companion$loadTeamLogo$1.L$1;
                        remoteViews = (RemoteViews) sportSchedulePreviewWidgetProvider$Companion$loadTeamLogo$1.L$0;
                        ResultKt.b(obj);
                    }
                    bitmap = (Bitmap) obj;
                    if (bitmap != null || bitmap.isRecycled()) {
                        a.a.l(wf.a.a, "SportWidget_", "Failed to load team logo: " + str, false, 4, (Object) null);
                    } else {
                        remoteViews.setImageViewBitmap(i, bitmap);
                    }
                    return Unit.a;
                }
            }
            sportSchedulePreviewWidgetProvider$Companion$loadTeamLogo$1 = new SportSchedulePreviewWidgetProvider$Companion$loadTeamLogo$1(this, continuation);
            Object obj2 = sportSchedulePreviewWidgetProvider$Companion$loadTeamLogo$1.result;
            Object f2 = IntrinsicsKt.f();
            i3 = sportSchedulePreviewWidgetProvider$Companion$loadTeamLogo$1.label;
            if (i3 != 0) {
            }
            bitmap = (Bitmap) obj2;
            if (bitmap != null) {
            }
            a.a.l(wf.a.a, "SportWidget_", "Failed to load team logo: " + str, false, 4, (Object) null);
            return Unit.a;
        }

        private final void n(Context context, RemoteViews remoteViews, int i, int i2, String str) {
            try {
                int l = l(this, context, "bg_" + str + "_layer1", null, 4, null);
                if (l != 0) {
                    remoteViews.setInt(i, "setBackgroundResource", l);
                }
                int l2 = l(this, context, "bg_" + str + "_layer2", null, 4, null);
                if (l2 != 0) {
                    remoteViews.setImageViewResource(i2, l2);
                }
            } catch (Exception e) {
                a.a.k(wf.a.a, "SportWidget_", "Error in dual layer rendering (" + str + "): " + e.getMessage(), e, false, 8, (Object) null);
            }
        }

        private final a o(int i, int i2) {
            List<a> o = CollectionsKt.o(new a[]{new a("4x6", 138, 145), new a("4x7", 138, 139), new a("5x6", 114, 138), new a("5x9", 176, 174)});
            a aVar = (a) CollectionsKt.i0(o);
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MAX_VALUE;
            for (a aVar2 : o) {
                int abs = Math.abs(aVar2.c() - i);
                int abs2 = Math.abs(aVar2.a() - i2);
                if (abs < i3 || (abs == i3 && abs2 < i4)) {
                    aVar = aVar2;
                    i3 = abs;
                    i4 = abs2;
                }
            }
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void p(Context context, RemoteViews remoteViews, int i) {
            remoteViews.setViewVisibility(R$id.widget_upcoming_container, 8);
            remoteViews.setViewVisibility(R$id.widget_default_container, 0);
            n(context, remoteViews, R$id.widget_default_container, R$id.widget_fallback_layer2, "default");
            PendingIntent i2 = i(context, i);
            remoteViews.setOnClickPendingIntent(R$id.widget_watch_now_btn, i2);
            remoteViews.setOnClickPendingIntent(R$id.widget_root, i2);
        }

        public static /* synthetic */ void r(Companion companion, Context context, AppWidgetManager appWidgetManager, int i, boolean z, int i2, Object obj) {
            if ((i2 & 8) != 0) {
                z = true;
            }
            companion.q(context, appWidgetManager, i, z);
        }

        public final void q(Context context, AppWidgetManager appWidgetManager, int i, boolean z) {
            Intrinsics.h(context, "context");
            Intrinsics.h(appWidgetManager, "appWidgetManager");
            Bundle appWidgetOptions = appWidgetManager.getAppWidgetOptions(i);
            a.a aVar = wf.a.a;
            a.a.f(aVar, "SportWidget_", "=== Widget Size Debug ===", false, 4, (Object) null);
            aVar.c("SportWidget_", "Raw size from system: " + appWidgetOptions.getInt("appWidgetMinWidth", 0) + "dp x " + appWidgetOptions.getInt("appWidgetMinHeight", 0) + "dp", true);
            a.a.f(aVar, "SportWidget_", "Design table standard (4x6): 138dp x 145dp", false, 4, (Object) null);
            a.a.f(aVar, "SportWidget_", "Max size from system: " + appWidgetOptions.getInt("appWidgetMaxWidth", 0) + "dp x " + appWidgetOptions.getInt("appWidgetMaxHeight", 0) + "dp", false, 4, (Object) null);
            if (Build.VERSION.SDK_INT >= 31) {
                a.a.f(aVar, "SportWidget_", "SizeF options: " + appWidgetOptions.getParcelableArrayList("appWidgetSizes"), false, 4, (Object) null);
            }
            Intrinsics.e(appWidgetOptions);
            Pair h = h(appWidgetOptions);
            int intValue = ((Number) h.component1()).intValue();
            int intValue2 = ((Number) h.component2()).intValue();
            a o = o(intValue, intValue2);
            int min = Math.min(intValue, o.c());
            int a2 = (int) (o.a() * 0.75f);
            int l = RangesKt.l(intValue2, a2, o.a());
            a.a.f(aVar, "SportWidget_", "Base size: " + intValue + "dp x " + intValue2 + "dp", false, 4, (Object) null);
            aVar.c("SportWidget_", "Reference size: " + o.b() + " (" + o.c() + "dp x " + o.a() + "dp)", true);
            aVar.c("SportWidget_", "Applied size: " + min + "dp x " + l + "dp (minContentHeight=" + a2 + ")", true);
            a.a.f(aVar, "SportWidget_", "========================", false, 4, (Object) null);
            i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new SportSchedulePreviewWidgetProvider$Companion$updateWidget$1(context, min, l, i, z, appWidgetManager, null), 3, (Object) null);
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int appWidgetId, Bundle newOptions) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appWidgetManager, "appWidgetManager");
        Intrinsics.h(newOptions, "newOptions");
        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions);
        a.a.f(wf.a.a, "SportWidget_", "SportWidgetProvider onAppWidgetOptionsChanged: appWidgetId=" + appWidgetId, false, 4, (Object) null);
        Companion.r(INSTANCE, context, appWidgetManager, appWidgetId, false, 8, null);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDisabled(Context context) {
        super.onDisabled(context);
        com.transsion.mbwidget.utils.a.l(com.transsion.mbwidget.utils.a.a, "sport_desk_widget", false, null, 4, null);
        SportWidgetDataManager.a.o();
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onEnabled(Context context) {
        super.onEnabled(context);
        com.transsion.mbwidget.utils.a.l(com.transsion.mbwidget.utils.a.a, "sport_desk_widget", true, null, 4, null);
    }

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intrinsics.h(context, "context");
        Intrinsics.h(intent, "intent");
        super.onReceive(context, intent);
        if (Intrinsics.c("android.intent.action.LOCALE_CHANGED", intent.getAction())) {
            a.a.f(wf.a.a, "SportWidget_", "Locale changed, refresh all sport widgets", false, 4, (Object) null);
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, (Class<?>) SportSchedulePreviewWidgetProvider.class));
            Intrinsics.e(appWidgetIds);
            for (int i : appWidgetIds) {
                Companion companion = INSTANCE;
                Intrinsics.e(appWidgetManager);
                companion.q(context, appWidgetManager, i, false);
            }
            return;
        }
        if (Intrinsics.c("com.transsion.mbwidget.sport.ACTION_CLICK", intent.getAction())) {
            com.transsion.mbwidget.utils.a.a.f(intent);
            SportWidgetDataManager.a.p();
            String stringExtra = intent.getStringExtra("key_deeplink_widget");
            a.a.f(wf.a.a, "SportWidget_", "Sport widget clicked, deeplink: " + stringExtra, false, 4, (Object) null);
            if (stringExtra != null && stringExtra.length() != 0) {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.setFlags(268435456);
                intent2.setData(Uri.parse(stringExtra));
                context.startActivity(intent2);
                return;
            }
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            if (launchIntentForPackage == null) {
                return;
            }
            launchIntentForPackage.addFlags(268435456);
            context.startActivity(launchIntentForPackage);
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appWidgetManager, "appWidgetManager");
        Intrinsics.h(appWidgetIds, "appWidgetIds");
        int[] appWidgetIds2 = appWidgetManager.getAppWidgetIds(new ComponentName(context, (Class<?>) SportSchedulePreviewWidgetProvider.class));
        Intrinsics.e(appWidgetIds2);
        if (appWidgetIds2.length == 0) {
            return;
        }
        Set K0 = ArraysKt.K0(appWidgetIds);
        if (K0.size() == 1) {
            SportWidgetDataManager.a.e();
        }
        for (int i : appWidgetIds2) {
            boolean contains = K0.contains(Integer.valueOf(i));
            a.a.f(wf.a.a, "SportWidget_", "SportWidgetProvider onUpdate: appWidgetId=" + i + " reportExposure=" + contains, false, 4, (Object) null);
            INSTANCE.q(context, appWidgetManager, i, contains);
        }
    }
}
