package com.transsion.home.adapter.suboperate.adapter;

import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tencent.mmkv.MMKV;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.bean.AppointSubject;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.DownloadManagerApi;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ni.f;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001BA\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u001e\u0010\t\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001f\u0010\u001eJ\u001f\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020 2\u0006\u0010\u0012\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u0004H\u0002¢\u0006\u0004\b%\u0010&J\u0011\u0010(\u001a\u0004\u0018\u00010'H\u0002¢\u0006\u0004\b(\u0010)J\u0017\u0010+\u001a\u00020*2\u0006\u0010\u0012\u001a\u00020\u0002H\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020*2\u0006\u0010\u0012\u001a\u00020\u0002H\u0002¢\u0006\u0004\b-\u0010,J\u001f\u0010.\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b.\u0010/J7\u00103\u001a\u00020\b2\u0006\u00100\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u00101\u001a\u00020*2\u0006\u00102\u001a\u00020\u0007H\u0002¢\u0006\u0004\b3\u00104JK\u00107\u001a\u001e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*05j\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*`62\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u00101\u001a\u00020*2\u0006\u00102\u001a\u00020\u0007H\u0002¢\u0006\u0004\b7\u00108J\u001f\u00109\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0014¢\u0006\u0004\b9\u0010:R,\u0010\t\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0004\u0012\u00020\b0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010C\u001a\u00020A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010B¨\u0006D"}, d2 = {"Lcom/transsion/home/adapter/suboperate/adapter/f;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/home/bean/AppointSubject;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", BuildConfig.FLAVOR, "layoutResId", "Lkotlin/Function1;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "onAppointmentCLick", "tabId", "Lcom/transsion/home/bean/OperateItem;", "operateItem", "<init>", "(ILkotlin/jvm/functions/Function1;ILcom/transsion/home/bean/OperateItem;)V", "Landroid/view/View;", "view", "Lcom/transsion/moviedetailapi/bean/Subject;", "item", "P1", "(Landroid/view/View;Lcom/transsion/moviedetailapi/bean/Subject;)V", "hasAdded", "holder", "position", "Q1", "(ZLcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/home/bean/AppointSubject;I)V", "isAdd", "T1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/home/bean/AppointSubject;Z)V", "F1", "(Lcom/transsion/home/bean/AppointSubject;Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;)V", "K1", "Landroid/widget/TextView;", "textView", "J1", "(Landroid/widget/TextView;Lcom/transsion/home/bean/AppointSubject;)V", "id", "W1", "(I)V", BuildConfig.FLAVOR, "N1", "()Ljava/lang/Long;", BuildConfig.FLAVOR, "M1", "(Lcom/transsion/home/bean/AppointSubject;)Ljava/lang/String;", "L1", "G1", "(ZLcom/chad/library/adapter/base/viewholder/BaseViewHolder;)V", "isBrowse", "eventType", "added", "V1", "(ZLcom/transsion/home/bean/AppointSubject;ILjava/lang/String;Z)V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "O1", "(Lcom/transsion/home/bean/AppointSubject;ILjava/lang/String;Z)Ljava/util/HashMap;", "H1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/home/bean/AppointSubject;)V", "F", "Lkotlin/jvm/functions/Function1;", "G", "I", "H", "Lcom/transsion/home/bean/OperateItem;", "Lcom/tencent/mmkv/MMKV;", "Lcom/tencent/mmkv/MMKV;", "appointMMKV", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f extends BaseQuickAdapter {
    public static final int J = 8;

    /* renamed from: F, reason: from kotlin metadata */
    private final Function1<Function1<? super Boolean, Unit>, Unit> onAppointmentCLick;

    /* renamed from: G, reason: from kotlin metadata */
    private final int tabId;

    /* renamed from: H, reason: from kotlin metadata */
    private final OperateItem operateItem;

    /* renamed from: I, reason: from kotlin metadata */
    private final MMKV appointMMKV;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(int i, Function1<? super Function1<? super Boolean, Unit>, Unit> function1, int i2, OperateItem operateItem) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.h(function1, "onAppointmentCLick");
        Intrinsics.h(operateItem, "operateItem");
        this.onAppointmentCLick = function1;
        this.tabId = i2;
        this.operateItem = operateItem;
        MMKV I = MMKV.I("kv_app_home_appointment");
        Intrinsics.g(I, "mmkvWithID(...)");
        this.appointMMKV = I;
    }

    public /* synthetic */ f(int i, Function1 function1, int i2, OperateItem operateItem, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? R.layout.item_sub_operation_appointment_item : i, function1, i2, operateItem);
    }

    private final void F1(AppointSubject item, BaseViewHolder holder) {
        Date date;
        String lastPathSegment;
        String lastPathSegment2;
        Uri uri = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            String appointmentDate = item.getAppointmentDate();
            if (appointmentDate == null) {
                appointmentDate = BuildConfig.FLAVOR;
            }
            date = simpleDateFormat.parse(appointmentDate);
        } catch (Exception e) {
            e.printStackTrace();
            date = null;
        }
        if (date == null) {
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(11, 18);
        long timeInMillis = calendar.getTimeInMillis();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date);
        calendar2.set(11, 19);
        long timeInMillis2 = calendar2.getTimeInMillis();
        Long N1 = N1();
        ContentValues contentValues = new ContentValues();
        contentValues.put("dtstart", Long.valueOf(timeInMillis));
        contentValues.put("dtend", Long.valueOf(timeInMillis2));
        contentValues.put("title", M1(item));
        contentValues.put("description", L1(item));
        contentValues.put("calendar_id", N1);
        contentValues.put("eventTimezone", TimeZone.getDefault().getID());
        contentValues.put("hasAlarm", (Integer) 1);
        try {
            uri = getContext().getContentResolver().insert(CalendarContract.Events.CONTENT_URI, contentValues);
        } catch (Throwable unused) {
        }
        if (uri != null && (lastPathSegment2 = uri.getLastPathSegment()) != null) {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("minutes", (Integer) 0);
            contentValues2.put("event_id", lastPathSegment2);
            contentValues2.put("method", (Integer) 1);
            try {
                getContext().getContentResolver().insert(CalendarContract.Reminders.CONTENT_URI, contentValues2);
            } catch (Throwable unused2) {
                Unit unit = Unit.a;
            }
        }
        this.appointMMKV.putLong(item.getSubjectId(), (uri == null || (lastPathSegment = uri.getLastPathSegment()) == null) ? -1L : Long.parseLong(lastPathSegment));
        G1(true, holder);
        W1(R.string.appointment_add_success);
        V1(false, item, ij.k.e(getData(), item), "click_appointment_alert_success", true);
    }

    private final void G1(boolean hasAdded, BaseViewHolder holder) {
        View view = holder.getView(R.id.sub_operation_appointment_unchecked);
        View view2 = holder.getView(R.id.sub_operation_appointment_checked);
        if (hasAdded) {
            uf.c.h(view);
            uf.c.k(view2);
        } else {
            uf.c.k(view);
            uf.c.h(view2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I1(f fVar, AppointSubject appointSubject, int i, boolean z, View view) {
        Intrinsics.e(view);
        fVar.P1(view, appointSubject);
        fVar.V1(false, appointSubject, i, "click_appointment_poster", z);
    }

    private final void J1(TextView textView, AppointSubject item) {
        try {
            Locale locale = Locale.ENGLISH;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MMM d", locale);
            String appointmentDate = item.getAppointmentDate();
            if (appointmentDate != null && appointmentDate.length() != 0) {
                Date parse = simpleDateFormat.parse(appointmentDate);
                Intrinsics.e(parse);
                textView.setText(simpleDateFormat2.format(parse));
            }
            uf.c.h(textView);
        } catch (Exception e) {
            e.printStackTrace();
            uf.c.h(textView);
        }
    }

    private final void K1(AppointSubject item, BaseViewHolder holder) {
        Uri withAppendedId = ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, this.appointMMKV.getLong(item.getSubjectId(), -1L));
        Intrinsics.g(withAppendedId, "withAppendedId(...)");
        try {
            Result.Companion companion = Result.Companion;
            Result.constructor-impl(Integer.valueOf(getContext().getContentResolver().delete(withAppendedId, null, null)));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
        this.appointMMKV.remove(item.getSubjectId());
        G1(false, holder);
        W1(R.string.appointment_delete_success);
    }

    private final String L1(AppointSubject item) {
        Integer subjectType = item.getSubjectType();
        int value = SubjectType.MOVIE.getValue();
        if (subjectType != null && subjectType.intValue() == value) {
            String string = Utils.a().getString(R.string.appointment_movie_alert_description, item.getTitle());
            Intrinsics.e(string);
            return string;
        }
        String string2 = Utils.a().getString(R.string.appointment_series_alert_description, item.getTitle());
        Intrinsics.e(string2);
        return string2;
    }

    private final String M1(AppointSubject item) {
        Integer subjectType = item.getSubjectType();
        int value = SubjectType.MOVIE.getValue();
        if (subjectType != null && subjectType.intValue() == value) {
            String string = Utils.a().getString(R.string.appointment_movie_alert_title, item.getTitle());
            Intrinsics.e(string);
            return string;
        }
        String string2 = Utils.a().getString(R.string.appointment_episode_alert_title, item.getTitle());
        Intrinsics.e(string2);
        return string2;
    }

    private final Long N1() {
        try {
            Cursor query = getContext().getContentResolver().query(CalendarContract.Calendars.CONTENT_URI, new String[]{"_id", "calendar_displayName"}, "visible = 1 AND sync_events = 1", null, null);
            if (query != null) {
                long j = -1;
                while (query.moveToNext()) {
                    try {
                        long j2 = query.getLong(0);
                        if (com.blankj.utilcode.util.u.b(query.getString(1))) {
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
        } catch (Throwable unused) {
        }
        return null;
    }

    private final HashMap<String, String> O1(AppointSubject item, int position, String eventType, boolean added) {
        String str;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("event_type", eventType);
        String subjectId = item.getSubjectId();
        String str2 = BuildConfig.FLAVOR;
        if (subjectId == null) {
            subjectId = BuildConfig.FLAVOR;
        }
        hashMap.put("subject_id", subjectId);
        Integer subjectType = item.getSubjectType();
        if (subjectType == null || (str = subjectType.toString()) == null) {
            str = BuildConfig.FLAVOR;
        }
        hashMap.put("subject_type", str);
        hashMap.put("sequence", String.valueOf(position));
        String appointmentDate = item.getAppointmentDate();
        if (appointmentDate == null) {
            appointmentDate = BuildConfig.FLAVOR;
        }
        hashMap.put("appointment_date", appointmentDate);
        String ops = item.getOps();
        if (ops != null) {
            str2 = ops;
        }
        hashMap.put("ops", str2);
        hashMap.put("tabId", String.valueOf(this.tabId));
        hashMap.put("added", String.valueOf(added));
        sk.b.d(item, hashMap);
        sk.b.a(this.operateItem, hashMap);
        return hashMap;
    }

    private final void P1(View view, Subject item) {
        Integer subjectType = item.getSubjectType();
        int value = SubjectType.SHORT_TV.getValue();
        if (subjectType == null || subjectType.intValue() != value) {
            Navigator c = TheRouter.c("/movie/detail");
            Integer subjectType2 = item.getSubjectType();
            Navigator.x(c.F("subject_type", subjectType2 != null ? subjectType2.intValue() : SubjectType.MOVIE.getValue()).K("id", item.getSubjectId()).K("module_name", "opt_sub_appointment").K("ops", item.getOps()), view.getContext(), (mf.c) null, 2, (Object) null);
        } else {
            DownloadManagerApi a = DownloadManagerApi.j.a();
            FragmentActivity context = getContext();
            Intrinsics.f(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            DownloadManagerApi.e0(a, context, SubTabFragment.INSTANCE.a(this.tabId), BuildConfig.FLAVOR, item.getOps(), "opt_sub_appointment", false, item, (String) null, (Boolean) null, 384, (Object) null);
        }
    }

    private final void Q1(final boolean hasAdded, final BaseViewHolder holder, final AppointSubject item, final int position) {
        String subjectId = item.getSubjectId();
        if (subjectId == null || subjectId.length() == 0) {
            return;
        }
        G1(hasAdded, holder);
        int i = R.id.sub_operation_appointment_checked;
        final int i2 = i + position;
        holder.getView(i).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.adapter.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.R1(i2, this, holder, item, position, hasAdded, view);
            }
        });
        holder.getView(R.id.sub_operation_appointment_unchecked).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.adapter.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.S1(i2, this, holder, item, position, hasAdded, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R1(int i, f fVar, BaseViewHolder baseViewHolder, AppointSubject appointSubject, int i2, boolean z, View view) {
        if (com.transsion.baseui.util.c.a.a(i, 2000L)) {
            return;
        }
        fVar.T1(baseViewHolder, appointSubject, false);
        fVar.V1(false, appointSubject, i2, "click_appointment_cancel", z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(int i, f fVar, BaseViewHolder baseViewHolder, AppointSubject appointSubject, int i2, boolean z, View view) {
        if (com.transsion.baseui.util.c.a.a(i, 2000L)) {
            return;
        }
        fVar.T1(baseViewHolder, appointSubject, true);
        fVar.V1(false, appointSubject, i2, "click_appointment_add", z);
    }

    private final void T1(final BaseViewHolder holder, final AppointSubject item, final boolean isAdd) {
        this.onAppointmentCLick.invoke(new Function1() { // from class: com.transsion.home.adapter.suboperate.adapter.b
            public final Object invoke(Object obj) {
                Unit U1;
                U1 = f.U1(isAdd, this, item, holder, ((Boolean) obj).booleanValue());
                return U1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U1(boolean z, f fVar, AppointSubject appointSubject, BaseViewHolder baseViewHolder, boolean z2) {
        if (!z2) {
            fVar.W1(R.string.no_calender_permission);
        } else if (z) {
            fVar.F1(appointSubject, baseViewHolder);
        } else {
            fVar.K1(appointSubject, baseViewHolder);
        }
        return Unit.a;
    }

    private final void V1(boolean isBrowse, AppointSubject item, int position, String eventType, boolean added) {
        HashMap<String, String> O1 = O1(item, position, eventType, added);
        if (isBrowse) {
            com.transsion.baselib.helper.a.a.e(SubTabFragment.INSTANCE.a(this.tabId), O1);
        } else {
            com.transsion.baselib.helper.a.a.f(SubTabFragment.INSTANCE.a(this.tabId), O1);
        }
    }

    private final void W1(int id) {
        if (n0() == null) {
            return;
        }
        Toast.makeText(getContext(), getContext().getString(id), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: H1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, final AppointSubject item) {
        String str;
        String thumbnail;
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        TextView textView = (TextView) holder.getView(R.id.sub_operation_appointment_corner);
        ImageView imageView = (ImageView) holder.getView(R.id.sub_operation_appointment_image);
        TextView textView2 = (TextView) holder.getView(R.id.sub_operation_appointment_item_title);
        TextView textView3 = (TextView) holder.getView(R.id.sub_operation_appointment_booked);
        View view = holder.getView(R.id.sub_operation_appointment_booked_layout);
        View view2 = holder.getView(R.id.sub_operation_appointment_booked_hot);
        J1(textView, item);
        f.b m = ni.f.a.m(getContext());
        Cover cover = item.getCover();
        String str2 = BuildConfig.FLAVOR;
        if (cover == null || (str = cover.getUrl()) == null) {
            str = BuildConfig.FLAVOR;
        }
        f.b g = m.g(str);
        Cover cover2 = item.getCover();
        if (cover2 != null && (thumbnail = cover2.getThumbnail()) != null) {
            str2 = thumbnail;
        }
        g.l(str2).d(imageView);
        textView2.setText(item.getTitle());
        Long appointmentCnt = item.getAppointmentCnt();
        if ((appointmentCnt != null ? appointmentCnt.longValue() : 0L) > 0) {
            NumberFormat numberInstance = NumberFormat.getNumberInstance(Locale.US);
            Long appointmentCnt2 = item.getAppointmentCnt();
            String str3 = numberInstance.format(appointmentCnt2 != null ? appointmentCnt2.longValue() : 0L) + " booked";
            uf.c.k(view);
            textView3.setText(str3);
            Long appointmentCnt3 = item.getAppointmentCnt();
            if ((appointmentCnt3 != null ? appointmentCnt3.longValue() : 0L) > 10000) {
                uf.c.k(view2);
            } else {
                uf.c.g(view2);
            }
        } else {
            uf.c.h(view);
        }
        final boolean z = this.appointMMKV.getLong(item.getSubjectId(), -1L) > -1;
        final int e = ij.k.e(getData(), item);
        Q1(z, holder, item, e);
        V1(true, item, e, "browse_appointment", z);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.adapter.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                f.I1(f.this, item, e, z, view3);
            }
        });
    }
}
