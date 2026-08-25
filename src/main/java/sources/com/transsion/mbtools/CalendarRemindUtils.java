package com.transsion.mbtools;

import android.app.Application;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.u;
import com.google.gson.Gson;
import com.tencent.mmkv.MMKV;
import com.transsion.gslb.BuildConfig;
import com.transsion.player.mediasession.MediaItem;
import java.util.HashSet;
import java.util.TimeZone;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class CalendarRemindUtils {
    private static HashSet b;
    public static final CalendarRemindUtils a = new CalendarRemindUtils();
    private static final Lazy c = LazyKt.b(new Function0<MMKV>() { // from class: com.transsion.mbtools.CalendarRemindUtils$mmkv$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final MMKV m21invoke() {
            return MMKV.I("kv_calendar");
        }
    });
    private static final Lazy d = LazyKt.b(new Function0<String>() { // from class: com.transsion.mbtools.CalendarRemindUtils$md5Json$2
        public final String invoke() {
            return CalendarRemindUtils.a.h().getString("calendar_md5_list", BuildConfig.FLAVOR);
        }
    });

    public static final class a implements PermissionUtils.b {
        final /* synthetic */ Function0 a;
        final /* synthetic */ Function0 b;

        a(Function0 function0, Function0 function02) {
            this.a = function0;
            this.b = function02;
        }

        public void onDenied() {
            this.b.invoke();
        }

        public void onGranted() {
            this.a.invoke();
        }
    }

    private CalendarRemindUtils() {
    }

    private final void e(Function0 function0, Function0 function02) {
        if (PermissionUtils.s(new String[]{"android.permission.WRITE_CALENDAR", "android.permission.READ_CALENDAR"})) {
            function0.invoke();
        } else {
            PermissionUtils.x(new String[]{"android.permission.WRITE_CALENDAR", "android.permission.READ_CALENDAR"}).m(new a(function0, function02)).y();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Long f() {
        Cursor query = Utils.a().getContentResolver().query(CalendarContract.Calendars.CONTENT_URI, new String[]{"_id", "calendar_displayName"}, "visible = 1 AND sync_events = 1", null, null);
        if (query != null) {
            long j = -1;
            while (query.moveToNext()) {
                try {
                    long j2 = query.getLong(0);
                    if (u.b(query.getString(1))) {
                        j = j2;
                    }
                } finally {
                }
            }
            if (j > 0) {
                Long valueOf = Long.valueOf(j);
                CloseableKt.a(query, (Throwable) null);
                return valueOf;
            }
            if (query.moveToFirst()) {
                Long valueOf2 = Long.valueOf(query.getLong(0));
                CloseableKt.a(query, (Throwable) null);
                return valueOf2;
            }
            Unit unit = Unit.a;
            CloseableKt.a(query, (Throwable) null);
        }
        return null;
    }

    private final String g() {
        return (String) d.getValue();
    }

    private final void j() {
        Object obj;
        if (b == null) {
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.constructor-impl((HashSet) new Gson().fromJson(a.g(), HashSet.class));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.a(th2));
            }
            if (Result.isFailure-impl(obj)) {
                obj = null;
            }
            HashSet hashSet = (HashSet) obj;
            if (hashSet == null) {
                hashSet = new HashSet();
            }
            b = hashSet;
            String g = g();
            StringBuilder sb = new StringBuilder();
            sb.append("md5Json：");
            sb.append(g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        i.d(n1.a, y0.b(), (CoroutineStart) null, new CalendarRemindUtils$saveMd5$1(null), 2, (Object) null);
    }

    public final void d(final CalendarBean calendarBean, final Function0 function0, final Function1 function1) {
        String title;
        Intrinsics.h(calendarBean, "bean");
        Intrinsics.h(function0, "success");
        Intrinsics.h(function1, MediaItem.MUSIC_FLOAT_STATE_ERROR);
        if (i(calendarBean)) {
            function1.invoke("Appointment has added");
            return;
        }
        if (calendarBean.getStartTime() != null && calendarBean.getEndTime() != null && (title = calendarBean.getTitle()) != null && title.length() != 0) {
            e(new Function0<Unit>() { // from class: com.transsion.mbtools.CalendarRemindUtils$addAppointment$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m18invoke();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m18invoke() {
                    Long f;
                    HashSet hashSet;
                    String lastPathSegment;
                    CalendarRemindUtils calendarRemindUtils = CalendarRemindUtils.a;
                    f = calendarRemindUtils.f();
                    ContentValues contentValues = new ContentValues();
                    CalendarBean calendarBean2 = CalendarBean.this;
                    String id = TimeZone.getDefault().getID();
                    contentValues.put("dtstart", calendarBean2.getStartTime());
                    contentValues.put("dtend", calendarBean2.getEndTime());
                    contentValues.put("title", calendarBean2.getTitle());
                    contentValues.put("description", calendarBean2.getDes());
                    contentValues.put("eventLocation", calendarBean2.getLocation());
                    contentValues.put("calendar_id", f);
                    String timeZone = calendarBean2.getTimeZone();
                    if (timeZone == null) {
                        timeZone = id;
                    }
                    contentValues.put("eventTimezone", timeZone);
                    String endTimeZone = calendarBean2.getEndTimeZone();
                    if (endTimeZone != null) {
                        id = endTimeZone;
                    }
                    contentValues.put("eventEndTimezone", id);
                    contentValues.put("hasAlarm", (Integer) 1);
                    Application a2 = Utils.a();
                    Uri insert = a2.getContentResolver().insert(CalendarContract.Events.CONTENT_URI, contentValues);
                    if (insert != null && (lastPathSegment = insert.getLastPathSegment()) != null) {
                        CalendarBean calendarBean3 = CalendarBean.this;
                        ContentValues contentValues2 = new ContentValues();
                        Integer remindTime = calendarBean3.getRemindTime();
                        contentValues2.put("minutes", Integer.valueOf(remindTime != null ? remindTime.intValue() : 0));
                        contentValues2.put("event_id", lastPathSegment);
                        contentValues2.put("method", (Integer) 1);
                        a2.getContentResolver().insert(CalendarContract.Reminders.CONTENT_URI, contentValues2);
                    }
                    String a3 = MD5HashProvider.a.a(CalendarBean.this.toString());
                    function0.invoke();
                    hashSet = CalendarRemindUtils.b;
                    if (hashSet != null) {
                        hashSet.add(a3);
                    }
                    calendarRemindUtils.k();
                }
            }, new Function0<Unit>() { // from class: com.transsion.mbtools.CalendarRemindUtils$addAppointment$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m19invoke();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m19invoke() {
                    function1.invoke("checkPermission-onDenied");
                }
            });
            return;
        }
        function1.invoke("bean is null, startTime:" + calendarBean.getStartTime() + ",endTime:" + calendarBean.getEndTime() + ", title:" + calendarBean.getTitle());
    }

    public final MMKV h() {
        Object value = c.getValue();
        Intrinsics.g(value, "<get-mmkv>(...)");
        return (MMKV) value;
    }

    public final boolean i(CalendarBean calendarBean) {
        Intrinsics.h(calendarBean, "bean");
        j();
        String a2 = MD5HashProvider.a.a(calendarBean.toString());
        HashSet hashSet = b;
        return hashSet != null && hashSet.contains(a2);
    }
}
