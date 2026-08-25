package com.transsion.push.utils;

import android.app.Application;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import android.util.Log;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.u;
import com.google.gson.Gson;
import com.tencent.mmkv.MMKV;
import com.transsion.gslb.BuildConfig;
import com.transsion.mbtools.MD5HashProvider;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.push.bean.CalendarData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class CalendarRemindHelper {
    private static HashMap b;
    public static final CalendarRemindHelper a = new CalendarRemindHelper();
    private static final Lazy c = LazyKt.b(new Function0() { // from class: com.transsion.push.utils.d
        public final Object invoke() {
            MMKV u;
            u = CalendarRemindHelper.u();
            return u;
        }
    });
    private static final Lazy d = LazyKt.b(new Function0() { // from class: com.transsion.push.utils.e
        public final Object invoke() {
            String t;
            t = CalendarRemindHelper.t();
            return t;
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

    private CalendarRemindHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(CalendarData calendarData, Function1 function1, Function0 function0) {
        String lastPathSegment;
        CalendarRemindHelper calendarRemindHelper = a;
        if (calendarRemindHelper.r(calendarData)) {
            function1.invoke("Appointment has added");
            return Unit.a;
        }
        Long o = calendarRemindHelper.o();
        StringBuilder sb = new StringBuilder();
        sb.append("calendarId ");
        sb.append(o);
        ContentValues contentValues = new ContentValues();
        String id = TimeZone.getDefault().getID();
        contentValues.put("dtstart", calendarData.getStartTime());
        Long startTime = calendarData.getStartTime();
        Intrinsics.e(startTime);
        contentValues.put("dtend", Long.valueOf(startTime.longValue() + 7200000));
        contentValues.put("title", calendarData.getTitle());
        contentValues.put("description", calendarData.getDes());
        contentValues.put("eventLocation", calendarData.getLocation());
        contentValues.put("calendar_id", o);
        String timeZone = calendarData.getTimeZone();
        if (timeZone == null) {
            timeZone = id;
        }
        contentValues.put("eventTimezone", timeZone);
        String endTimeZone = calendarData.getEndTimeZone();
        if (endTimeZone != null) {
            id = endTimeZone;
        }
        contentValues.put("eventEndTimezone", id);
        contentValues.put("hasAlarm", (Integer) 1);
        Application a2 = Utils.a();
        Uri insert = a2.getContentResolver().insert(CalendarContract.Events.CONTENT_URI, contentValues);
        if (insert != null && (lastPathSegment = insert.getLastPathSegment()) != null) {
            ContentValues contentValues2 = new ContentValues();
            Integer remindTime = calendarData.getRemindTime();
            contentValues2.put("minutes", Integer.valueOf(remindTime != null ? remindTime.intValue() : 0));
            contentValues2.put("event_id", lastPathSegment);
            contentValues2.put("method", (Integer) 1);
            a2.getContentResolver().insert(CalendarContract.Reminders.CONTENT_URI, contentValues2);
        }
        String a3 = MD5HashProvider.a.a(String.valueOf(calendarData.getCalendarId()));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("md5 :");
        sb2.append(a3);
        function0.invoke();
        HashMap hashMap = b;
        if (hashMap != null) {
        }
        calendarRemindHelper.w();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Function1 function1) {
        function1.invoke("checkPermission-onDenied");
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(CalendarData calendarData, String str, Function1 function1, Function0 function0) {
        Uri withAppendedId;
        Application a2 = Utils.a();
        CalendarRemindHelper calendarRemindHelper = a;
        Long o = calendarRemindHelper.o();
        if (o == null) {
            function1.invoke("getDefaultCalendarId failed");
            return Unit.a;
        }
        long longValue = o.longValue();
        StringBuilder sb = new StringBuilder();
        sb.append("calendarId ");
        sb.append(longValue);
        Intrinsics.e(a2);
        List v = calendarRemindHelper.v(a2, calendarData, longValue, str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("eventIds  ");
        sb2.append(v);
        if (v.isEmpty()) {
            function1.invoke("No matched event found");
            return Unit.a;
        }
        Iterator it = v.iterator();
        boolean z = true;
        while (it.hasNext()) {
            long longValue2 = ((Number) it.next()).longValue();
            try {
                a2.getContentResolver().delete(CalendarContract.Reminders.CONTENT_URI, "event_id = ?", new String[]{String.valueOf(longValue2)});
                withAppendedId = ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, longValue2);
                Intrinsics.g(withAppendedId, "withAppendedId(...)");
            } catch (Exception e) {
                Log.e("CalendarRemindHelper", "delete event error:" + e.getMessage(), e);
            }
            if (a2.getContentResolver().delete(withAppendedId, null, null) <= 0) {
                z = false;
            }
        }
        if (z) {
            HashMap hashMap = b;
            if (hashMap != null) {
            }
            a.w();
            function0.invoke();
        } else {
            function1.invoke("Delete event failed");
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Function1 function1) {
        function1.invoke("checkPermission-onDenied");
        return Unit.a;
    }

    private final void n(Function0 function0, Function0 function02) {
        if (PermissionUtils.s(new String[]{"android.permission.WRITE_CALENDAR", "android.permission.READ_CALENDAR", "android.permission.POST_NOTIFICATIONS"})) {
            function0.invoke();
        } else {
            PermissionUtils.x(new String[]{"android.permission.WRITE_CALENDAR", "android.permission.READ_CALENDAR"}).m(new a(function0, function02)).y();
        }
    }

    private final Long o() {
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

    private final String p() {
        return (String) d.getValue();
    }

    private final void s() {
        Object obj;
        if (b == null) {
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.constructor-impl((HashMap) new Gson().fromJson(p(), HashMap.class));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.a(th2));
            }
            if (Result.isFailure-impl(obj)) {
                obj = null;
            }
            HashMap hashMap = (HashMap) obj;
            if (hashMap == null) {
                hashMap = new HashMap();
            }
            b = hashMap;
            String p = p();
            StringBuilder sb = new StringBuilder();
            sb.append("md5Json：");
            sb.append(p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String t() {
        return a.q().getString("calendar_md5_list", BuildConfig.FLAVOR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV u() {
        MMKV I = MMKV.I("kv_calendar");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    private final List v(Context context, CalendarData calendarData, long j, String str) {
        ArrayList arrayList = new ArrayList();
        String[] strArr = {"_id"};
        String Q = StringsKt.Q("description = ? \nAND  dtstart BETWEEN ? AND ? \nAND calendar_id = ?", "\n", BuildConfig.FLAVOR, false, 4, (Object) null);
        HashMap hashMap = b;
        String str2 = hashMap != null ? (String) hashMap.get(str) : null;
        Long startTime = calendarData.getStartTime();
        Intrinsics.e(startTime);
        long j2 = 60000;
        String valueOf = String.valueOf(startTime.longValue() - j2);
        Long startTime2 = calendarData.getStartTime();
        Intrinsics.e(startTime2);
        Cursor query = context.getContentResolver().query(CalendarContract.Events.CONTENT_URI, strArr, Q, new String[]{str2, valueOf, String.valueOf(startTime2.longValue() + j2), String.valueOf(j)}, null);
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    arrayList.add(Long.valueOf(query.getLong(query.getColumnIndexOrThrow("_id"))));
                } finally {
                }
            }
            Unit unit = Unit.a;
            CloseableKt.a(query, (Throwable) null);
        }
        return arrayList;
    }

    private final void w() {
        kotlinx.coroutines.i.d(n1.a, y0.b(), (CoroutineStart) null, new CalendarRemindHelper$saveMd5$1(null), 2, (Object) null);
    }

    public final void h(final CalendarData calendarData, final Function0 function0, final Function1 function1) {
        String title;
        Intrinsics.h(calendarData, "bean");
        Intrinsics.h(function0, "success");
        Intrinsics.h(function1, MediaItem.MUSIC_FLOAT_STATE_ERROR);
        if (calendarData.getStartTime() != null && (title = calendarData.getTitle()) != null && title.length() != 0) {
            n(new Function0() { // from class: com.transsion.push.utils.h
                public final Object invoke() {
                    Unit i;
                    i = CalendarRemindHelper.i(CalendarData.this, function1, function0);
                    return i;
                }
            }, new Function0() { // from class: com.transsion.push.utils.i
                public final Object invoke() {
                    Unit j;
                    j = CalendarRemindHelper.j(function1);
                    return j;
                }
            });
            return;
        }
        function1.invoke("bean is null, startTime:" + calendarData.getStartTime() + ", title:" + calendarData.getTitle());
    }

    public final void k(final CalendarData calendarData, final Function0 function0, final Function1 function1) {
        String title;
        Intrinsics.h(calendarData, "bean");
        Intrinsics.h(function0, "success");
        Intrinsics.h(function1, MediaItem.MUSIC_FLOAT_STATE_ERROR);
        if (calendarData.getStartTime() == null || (title = calendarData.getTitle()) == null || title.length() == 0) {
            function1.invoke("bean is null, startTime:" + calendarData.getStartTime() + ", title:" + calendarData.getTitle());
            return;
        }
        s();
        final String a2 = MD5HashProvider.a.a(String.valueOf(calendarData.getCalendarId()));
        StringBuilder sb = new StringBuilder();
        sb.append("md5 : ");
        sb.append(a2);
        sb.append(" ");
        HashMap hashMap = b;
        Boolean valueOf = hashMap != null ? Boolean.valueOf(hashMap.containsKey(a2)) : null;
        Intrinsics.e(valueOf);
        if (valueOf.booleanValue()) {
            n(new Function0() { // from class: com.transsion.push.utils.f
                public final Object invoke() {
                    Unit l;
                    l = CalendarRemindHelper.l(CalendarData.this, a2, function1, function0);
                    return l;
                }
            }, new Function0() { // from class: com.transsion.push.utils.g
                public final Object invoke() {
                    Unit m;
                    m = CalendarRemindHelper.m(function1);
                    return m;
                }
            });
        } else {
            function1.invoke("Appointment not exists");
        }
    }

    public final MMKV q() {
        return (MMKV) c.getValue();
    }

    public final boolean r(CalendarData calendarData) {
        Intrinsics.h(calendarData, "bean");
        s();
        String a2 = MD5HashProvider.a.a(String.valueOf(calendarData.getCalendarId()));
        HashMap hashMap = b;
        return hashMap != null && hashMap.containsKey(a2);
    }
}
