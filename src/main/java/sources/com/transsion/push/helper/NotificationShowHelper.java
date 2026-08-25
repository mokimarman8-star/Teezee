package com.transsion.push.helper;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.notification.MsgBean;
import com.transsion.baselib.report.k;
import com.transsion.gslb.BuildConfig;
import com.transsion.lib.push.R$dimen;
import com.transsion.lib.push.R$drawable;
import com.transsion.lib.push.R$id;
import com.transsion.lib.push.R$layout;
import com.transsion.lib.push.R$string;
import com.transsion.lib.push.Receiver.NotificationReceiver;
import com.transsion.push.bean.MsgShowStatus;
import com.transsion.push.bean.MsgStatus;
import com.transsion.push.bean.MsgStyle;
import com.transsion.push.bean.MsgType;
import com.transsion.push.bean.PushConfigHelper;
import com.transsion.push.bean.ServerMatchListItemData;
import com.transsion.push.bean.TeamInfoMatch;
import com.transsion.push.notification.c;
import com.transsion.push.notification.i;
import com.transsion.push.notification.j;
import com.transsion.push.utils.NotificationUtil;
import com.transsion.push.utils.u;
import com.transsion.pushapi.TriggerSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class NotificationShowHelper {
    public static final NotificationShowHelper a = new NotificationShowHelper();

    private NotificationShowHelper() {
    }

    private final NotificationCompat.m a(Context context, int i, MsgBean msgBean, com.transsion.push.notification.d dVar, Bitmap bitmap, PendingIntent pendingIntent) {
        boolean z = false;
        c.a aVar = new c.a(context, i, R$layout.push_notification_normal_small, R$layout.push_notification_big_picture);
        Bitmap e = bitmap == null ? e.a.e() : bitmap;
        int i2 = R$id.notification_title_tv;
        String title = msgBean.getTitle();
        c.a X = aVar.W(i2, title != null ? StringsKt.s1(title, new char[]{'\n'}) : null).X(R$id.iv_icon, 8);
        int i3 = R$id.notification_title_tv;
        String title2 = msgBean.getTitle();
        c.a U = X.U(i3, title2 != null ? StringsKt.s1(title2, new char[]{'\n'}) : null);
        int i4 = R$id.notification_title_tv;
        String title3 = msgBean.getTitle();
        c.a T = U.S(i4, title3 != null ? StringsKt.s1(title3, new char[]{'\n'}) : null).T(R$id.notification_last, 8).T(R$id.notification_next, 8).T(R$id.page_num, 8);
        NotificationUtil notificationUtil = NotificationUtil.a;
        if (!k.a.q() && !msgBean.getIsFloat()) {
            z = true;
        }
        T.x(notificationUtil.x(z)).L(R$drawable.push_small_logo).F(dVar.c()).z(pendingIntent).O(System.currentTimeMillis());
        if (e == null || e.isRecycled()) {
            aVar.V(R$id.notification_content_image, null);
            aVar.R(R$id.notification_content_image, null);
        } else {
            Bitmap e2 = com.transsion.push.utils.a.a.e(context, e, e.a.g(), lj.a.b(56), false, lj.a.b(4));
            RemoteViews j = aVar.j();
            if (j != null) {
                j.setImageViewBitmap(R$id.notification_content_image, e2);
            }
            aVar.R(R$id.notification_content_image, e);
        }
        return aVar.P().a(context);
    }

    private final NotificationCompat.m b(Context context, int i, MsgBean msgBean, com.transsion.push.notification.d dVar, Bitmap bitmap, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        if (NotificationUtil.a.O() || Intrinsics.c(msgBean.getStyle(), MsgStyle.NATIVE_STANDARD)) {
            return f(context, i, msgBean, dVar, bitmap, pendingIntent, pendingIntent2);
        }
        String style = msgBean.getStyle();
        return (Intrinsics.c(style, MsgStyle.STYLE_VERTICAL_TYPE) || Intrinsics.c(style, MsgStyle.STYLE_HOR_TYPE)) ? d(context, i, msgBean, dVar, bitmap, pendingIntent) : PushConfigHelper.INSTANCE.isVerticalType() ? d(context, i, msgBean, dVar, bitmap, pendingIntent) : a(context, i, msgBean, dVar, bitmap, pendingIntent);
    }

    private final NotificationCompat.m d(Context context, int i, MsgBean msgBean, com.transsion.push.notification.d dVar, Bitmap bitmap, PendingIntent pendingIntent) {
        boolean z = !Intrinsics.c(msgBean.getStyle(), MsgStyle.STYLE_HOR_TYPE);
        Bitmap e = bitmap == null ? e.a.e() : bitmap;
        com.transsion.push.tpush.g gVar = com.transsion.push.tpush.g.a;
        c.a b = gVar.b(context, i, z);
        b.G(true);
        String title = msgBean.getTitle();
        String s1 = title != null ? StringsKt.s1(title, new char[]{'\n'}) : null;
        c.a S = b.W(R$id.notification_title_tv, s1).X(R$id.iv_icon, 8).U(R$id.notification_title_tv, s1).S(R$id.notification_title_tv, s1);
        int i2 = R$id.notification_content_tv;
        String desc = msgBean.getDesc();
        S.S(i2, desc != null ? StringsKt.s1(desc, new char[]{'\n'}) : null).T(R$id.notification_last, 8).T(R$id.notification_next, 8).T(R$id.page_num, 8).x(NotificationUtil.a.x(false)).L(R$drawable.push_small_logo).F(dVar.c()).z(pendingIntent).O(System.currentTimeMillis());
        if (e == null || e.isRecycled()) {
            b.V(R$id.notification_content_image, null);
            b.R(R$id.notification_content_image, null);
        } else {
            Bitmap c = gVar.c(context, e, z);
            RemoteViews j = b.j();
            if (j != null) {
                j.setImageViewBitmap(R$id.notification_content_image, c);
            }
            b.R(R$id.notification_content_image, gVar.a(context, e, z));
        }
        return b.P().a(context);
    }

    private final NotificationCompat.m f(Context context, int i, MsgBean msgBean, com.transsion.push.notification.d dVar, Bitmap bitmap, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        if (bitmap == null) {
            bitmap = e.a.e();
        }
        Bitmap bitmap2 = bitmap;
        j.a aVar = new j.a(context, i);
        aVar.x(NotificationUtil.a.x(!k.a.q()));
        aVar.L(R$drawable.push_small_logo);
        aVar.F(dVar.c());
        String title = msgBean.getTitle();
        aVar.B(title != null ? StringsKt.s1(title, new char[]{'\n'}) : null);
        String desc = msgBean.getDesc();
        aVar.A(desc != null ? StringsKt.s1(desc, new char[]{'\n'}) : null);
        aVar.z(pendingIntent);
        aVar.E(pendingIntent2);
        if (bitmap2 == null || bitmap2.isRecycled()) {
            aVar.H(null);
        } else {
            int dimension = (int) context.getResources().getDimension(R$dimen.push_notification_transition_square_img_width);
            aVar.H(com.transsion.push.utils.a.a.a(context, bitmap2, dimension, dimension, false));
        }
        return aVar.P().a(context);
    }

    private final PendingIntent h(Context context, MsgBean msgBean, int i, com.transsion.push.notification.d dVar) {
        return n("com.community.oneroom.notification_delete", context, msgBean, i, dVar);
    }

    private final PendingIntent j(Context context, MsgBean msgBean, int i, com.transsion.push.notification.d dVar) {
        return n("com.community.oneroom.last_permanent_msg", context, msgBean, i, dVar);
    }

    private final PendingIntent k(Context context, MsgBean msgBean, int i, com.transsion.push.notification.d dVar) {
        return n("com.community.oneroom.next_permanent_msg", context, msgBean, i, dVar);
    }

    private final PendingIntent n(String str, Context context, MsgBean msgBean, int i, com.transsion.push.notification.d dVar) {
        int i2 = Build.VERSION.SDK_INT;
        int r = NotificationUtil.a.r(msgBean.getMessageId(), msgBean.getType());
        Intent intent = new Intent(context, (Class<?>) NotificationReceiver.class);
        intent.setPackage(context.getPackageName());
        intent.setAction(str);
        intent.putExtra("extra_notification_id", i);
        intent.putExtra("extra_notification_group_tag", dVar.d());
        intent.putExtra("extra_message_id", msgBean.getMessageId());
        intent.putExtra("MESSAGE_TYPE", msgBean.getType());
        intent.putExtra("extra_source", msgBean.getSource());
        intent.setData(Uri.parse(msgBean.getDeeplink()));
        if (i2 >= 24) {
            intent.addFlags(268435456);
        }
        return PendingIntent.getBroadcast(context, r, intent, 201326592);
    }

    private final void u(Context context, MsgBean msgBean) {
        msgBean.setMsgStatus(MsgStatus.SHOWED.ordinal());
        msgBean.setShowTime(Long.valueOf(System.currentTimeMillis()));
        if (msgBean.getTriggerSource() == TriggerSource.SCREEN_ON.ordinal()) {
            msgBean.setHasScreenOn(true);
        }
        if (msgBean.getTriggerSource() == TriggerSource.UNLOCK.ordinal()) {
            msgBean.setForceShow(true);
        }
        kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new NotificationShowHelper$updateShowTime$1(context, msgBean, null), 3, (Object) null);
    }

    public final NotificationCompat.m c(Context context, MsgBean msgBean, int i, Bitmap bitmap, PendingIntent pendingIntent, com.transsion.push.notification.d dVar) {
        Intrinsics.h(context, "context");
        Intrinsics.h(msgBean, "msgBean");
        Intrinsics.h(dVar, "messageGroup");
        Bitmap e = bitmap == null ? e.a.e() : bitmap;
        PendingIntent j = j(context, msgBean, i, dVar);
        PendingIntent k = k(context, msgBean, i, dVar);
        i.a aVar = new i.a(context, i, R$layout.push_notification_normal_small, R$layout.push_notification_big_picture);
        aVar.F(dVar.c());
        int i2 = R$id.notification_title_tv;
        String title = msgBean.getTitle();
        aVar.V(i2, title != null ? StringsKt.s1(title, new char[]{'\n'}) : null);
        RemoteViews j2 = aVar.j();
        if (j2 != null) {
            j2.setImageViewBitmap(R$id.notification_content_image, e);
        }
        int i3 = R$id.notification_title_tv;
        String title2 = msgBean.getTitle();
        aVar.T(i3, title2 != null ? StringsKt.s1(title2, new char[]{'\n'}) : null);
        int i4 = R$id.page_num;
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String format = String.format("%d/%d", Arrays.copyOf(new Object[]{Integer.valueOf(msgBean.getPermanentMsgPosition()), Integer.valueOf(msgBean.getPermanentMsgSize())}, 2));
        Intrinsics.g(format, "format(...)");
        aVar.T(i4, format);
        aVar.O(System.currentTimeMillis());
        aVar.z(pendingIntent);
        aVar.I(j);
        aVar.J(k);
        aVar.K(true);
        NotificationUtil notificationUtil = NotificationUtil.a;
        aVar.y(notificationUtil.I());
        if (e == null || e.isRecycled()) {
            aVar.W(R$id.notification_content_image, null);
            aVar.S(R$id.notification_content_image, null);
        } else {
            Bitmap e2 = com.transsion.push.utils.a.a.e(context, e, lj.a.b(60), lj.a.b(40), false, lj.a.b(4));
            RemoteViews j3 = aVar.j();
            if (j3 != null) {
                j3.setImageViewBitmap(R$id.notification_content_image, e2);
            }
            aVar.S(R$id.notification_content_image, e);
        }
        if (notificationUtil.N()) {
            return aVar.P().a(context);
        }
        aVar.R(System.currentTimeMillis());
        aVar.N(true);
        return aVar.P().a(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final NotificationCompat.m e(Context context, MsgBean msgBean, int i, Bitmap bitmap, PendingIntent pendingIntent, com.transsion.push.notification.d dVar, ServerMatchListItemData serverMatchListItemData, Map map) {
        String str;
        String str2;
        char c;
        String str3;
        String str4;
        String str5;
        RemoteViews j;
        RemoteViews i2;
        RemoteViews i3;
        String startTime;
        String str6;
        RemoteViews i4;
        RemoteViews i5;
        RemoteViews i6;
        RemoteViews i7;
        RemoteViews i8;
        RemoteViews i9;
        RemoteViews i10;
        NotificationUtil notificationUtil;
        TeamInfoMatch team2;
        TeamInfoMatch team1;
        TeamInfoMatch team22;
        TeamInfoMatch team12;
        Intrinsics.h(context, "context");
        Intrinsics.h(msgBean, "msgBean");
        Intrinsics.h(dVar, "messageGroup");
        Intrinsics.h(map, "matchMapBitmap");
        Bitmap e = bitmap == null ? e.a.e() : bitmap;
        PendingIntent j2 = j(context, msgBean, i, dVar);
        PendingIntent k = k(context, msgBean, i, dVar);
        i.a aVar = new i.a(context, i, R$layout.push_notification_normal_small_match, R$layout.push_notification_match_upcoming);
        String string = context.getString(R$string.match_vs);
        Intrinsics.g(string, "getString(...)");
        String string2 = context.getString(R$string.match_vs_notification1);
        Intrinsics.g(string2, "getString(...)");
        String string3 = context.getString(R$string.match_vs_notification2);
        Intrinsics.g(string3, "getString(...)");
        String name = (serverMatchListItemData == null || (team12 = serverMatchListItemData.getTeam1()) == null) ? null : team12.getName();
        String name2 = (serverMatchListItemData == null || (team22 = serverMatchListItemData.getTeam2()) == null) ? null : team22.getName();
        if (name != null) {
            String str7 = name + " ";
            if (str7 != null) {
                String str8 = str7 + string;
                if (str8 != null) {
                    str = str8 + " ";
                    str2 = string2 + (str + name2) + string3;
                    aVar.F(dVar.c());
                    aVar.O(System.currentTimeMillis());
                    int i11 = R$id.notification_title_tv;
                    if (str2 == null) {
                        c = 0;
                        str3 = StringsKt.s1(str2, new char[]{'\n'});
                    } else {
                        c = 0;
                        str3 = null;
                    }
                    aVar.V(i11, str3);
                    int i12 = R$id.notification_title_tv;
                    if (str2 == null) {
                        char[] cArr = new char[1];
                        cArr[c] = '\n';
                        str4 = StringsKt.s1(str2, cArr);
                    } else {
                        str4 = null;
                    }
                    aVar.X(i12, str4);
                    int i13 = R$id.notification_title_tv;
                    if (str2 == null) {
                        char[] cArr2 = new char[1];
                        cArr2[c] = '\n';
                        str5 = StringsKt.s1(str2, cArr2);
                    } else {
                        str5 = null;
                    }
                    aVar.T(i13, str5);
                    j = aVar.j();
                    if (j != null) {
                        j.setImageViewBitmap(R$id.notification_content_image, e);
                    }
                    aVar.T(R$id.notification_title_tv, str2 == null ? StringsKt.s1(str2, new char[]{'\n'}) : null);
                    int i14 = R$id.page_num;
                    StringCompanionObject stringCompanionObject = StringCompanionObject.a;
                    String format = String.format("%d/%d", Arrays.copyOf(new Object[]{Integer.valueOf(msgBean.getPermanentMsgPosition()), Integer.valueOf(msgBean.getPermanentMsgSize())}, 2));
                    Intrinsics.g(format, "format(...)");
                    aVar.T(i14, format);
                    aVar.O(System.currentTimeMillis());
                    float f = context.getResources().getDisplayMetrics().density;
                    int i15 = (int) (48 * f);
                    NotificationUtil notificationUtil2 = NotificationUtil.a;
                    Object obj = map.get("team1ImgUrl");
                    Intrinsics.e(obj);
                    float f2 = 1 * f;
                    Bitmap s = notificationUtil2.s((Bitmap) obj, i15, f2, -1);
                    Object obj2 = map.get("team2ImgUrl");
                    Intrinsics.e(obj2);
                    Bitmap s2 = notificationUtil2.s((Bitmap) obj2, i15, f2, -1);
                    i2 = aVar.i();
                    if (i2 != null) {
                        i2.setImageViewBitmap(R$id.iv_team1_logo, s);
                    }
                    i3 = aVar.i();
                    if (i3 != null) {
                        i3.setTextViewTextSize(R$id.score_match, 2, 20.0f);
                    }
                    if (serverMatchListItemData == null) {
                        try {
                            startTime = serverMatchListItemData.getStartTime();
                        } catch (Exception e2) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("时间转换出错：");
                            sb.append(e2);
                            str6 = BuildConfig.FLAVOR;
                        }
                    } else {
                        startTime = null;
                    }
                    str6 = notificationUtil2.e0(startTime);
                    i4 = aVar.i();
                    if (i4 != null) {
                        i4.setTextViewText(R$id.tv_top_title, str2);
                    }
                    i5 = aVar.i();
                    if (i5 != null) {
                        i5.setTextViewText(R$id.match_round, serverMatchListItemData != null ? serverMatchListItemData.getMatchRound() : null);
                    }
                    i6 = aVar.i();
                    if (i6 != null) {
                        i6.setTextViewText(R$id.btn_upcoming, str6);
                    }
                    i7 = aVar.i();
                    if (i7 != null) {
                        i7.setInt(R$id.match_push_ly, "setBackgroundResource", R$drawable.push_layer_match_push_bg);
                    }
                    i8 = aVar.i();
                    if (i8 != null) {
                        i8.setTextViewText(R$id.tv_team1_name, (serverMatchListItemData == null || (team1 = serverMatchListItemData.getTeam1()) == null) ? null : team1.getName());
                    }
                    i9 = aVar.i();
                    if (i9 != null) {
                        i9.setImageViewBitmap(R$id.iv_team2_logo, s2);
                    }
                    i10 = aVar.i();
                    if (i10 != null) {
                        i10.setTextViewText(R$id.tv_team2_name, (serverMatchListItemData == null || (team2 = serverMatchListItemData.getTeam2()) == null) ? null : team2.getName());
                    }
                    aVar.z(pendingIntent);
                    aVar.I(j2);
                    aVar.J(k);
                    aVar.K(true);
                    notificationUtil = NotificationUtil.a;
                    aVar.y(notificationUtil.I());
                    if (e != null || e.isRecycled()) {
                        aVar.W(R$id.notification_content_image, null);
                        aVar.S(R$id.notification_content_image, null);
                    } else {
                        Bitmap e3 = com.transsion.push.utils.a.a.e(context, e, lj.a.b(60), lj.a.b(40), false, lj.a.b(4));
                        RemoteViews j3 = aVar.j();
                        if (j3 != null) {
                            j3.setImageViewBitmap(R$id.notification_content_image, e3);
                        }
                        aVar.S(R$id.notification_content_image, e);
                    }
                    if (!notificationUtil.N()) {
                        return aVar.P().a(context);
                    }
                    aVar.R(System.currentTimeMillis());
                    aVar.N(true);
                    return aVar.P().a(context);
                }
            }
        }
        str = null;
        str2 = string2 + (str + name2) + string3;
        aVar.F(dVar.c());
        aVar.O(System.currentTimeMillis());
        int i112 = R$id.notification_title_tv;
        if (str2 == null) {
        }
        aVar.V(i112, str3);
        int i122 = R$id.notification_title_tv;
        if (str2 == null) {
        }
        aVar.X(i122, str4);
        int i132 = R$id.notification_title_tv;
        if (str2 == null) {
        }
        aVar.T(i132, str5);
        j = aVar.j();
        if (j != null) {
        }
        aVar.T(R$id.notification_title_tv, str2 == null ? StringsKt.s1(str2, new char[]{'\n'}) : null);
        int i142 = R$id.page_num;
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.a;
        String format2 = String.format("%d/%d", Arrays.copyOf(new Object[]{Integer.valueOf(msgBean.getPermanentMsgPosition()), Integer.valueOf(msgBean.getPermanentMsgSize())}, 2));
        Intrinsics.g(format2, "format(...)");
        aVar.T(i142, format2);
        aVar.O(System.currentTimeMillis());
        float f3 = context.getResources().getDisplayMetrics().density;
        int i152 = (int) (48 * f3);
        NotificationUtil notificationUtil22 = NotificationUtil.a;
        Object obj3 = map.get("team1ImgUrl");
        Intrinsics.e(obj3);
        float f22 = 1 * f3;
        Bitmap s3 = notificationUtil22.s((Bitmap) obj3, i152, f22, -1);
        Object obj22 = map.get("team2ImgUrl");
        Intrinsics.e(obj22);
        Bitmap s22 = notificationUtil22.s((Bitmap) obj22, i152, f22, -1);
        i2 = aVar.i();
        if (i2 != null) {
        }
        i3 = aVar.i();
        if (i3 != null) {
        }
        if (serverMatchListItemData == null) {
        }
        str6 = notificationUtil22.e0(startTime);
        i4 = aVar.i();
        if (i4 != null) {
        }
        i5 = aVar.i();
        if (i5 != null) {
        }
        i6 = aVar.i();
        if (i6 != null) {
        }
        i7 = aVar.i();
        if (i7 != null) {
        }
        i8 = aVar.i();
        if (i8 != null) {
        }
        i9 = aVar.i();
        if (i9 != null) {
        }
        i10 = aVar.i();
        if (i10 != null) {
        }
        aVar.z(pendingIntent);
        aVar.I(j2);
        aVar.J(k);
        aVar.K(true);
        notificationUtil = NotificationUtil.a;
        aVar.y(notificationUtil.I());
        if (e != null) {
        }
        aVar.W(R$id.notification_content_image, null);
        aVar.S(R$id.notification_content_image, null);
        if (!notificationUtil.N()) {
        }
    }

    public final void g(int i) {
        Object systemService = Utils.a().getSystemService("notification");
        NotificationManager notificationManager = systemService instanceof NotificationManager ? (NotificationManager) systemService : null;
        if (notificationManager == null) {
            return;
        }
        notificationManager.cancel(i);
    }

    public final List i(MsgBean msgBean) {
        Intrinsics.h(msgBean, "msgBean");
        ArrayList arrayList = new ArrayList();
        String imageList = msgBean.getImageList();
        if (imageList != null) {
            arrayList.addAll(StringsKt.S0(imageList, new String[]{","}, false, 0, 6, (Object) null));
        }
        return arrayList;
    }

    public final int l(String str) {
        if (TextUtils.isEmpty(str)) {
            return Math.abs((int) System.currentTimeMillis());
        }
        return Math.abs(str != null ? str.hashCode() : 0);
    }

    public final PendingIntent m(Context context, String str, int i, MsgBean msgBean) {
        Intrinsics.h(context, "context");
        Intrinsics.h(msgBean, "msgBean");
        Intent C = NotificationUtil.a.C(context, str, i, msgBean.getSource(), msgBean.getType(), msgBean.getStyle(), msgBean.getMessageId(), msgBean.getDeeplink());
        if (C == null) {
            return null;
        }
        C.setData(Uri.parse(msgBean.getDeeplink()));
        return PendingIntent.getActivity(context, a.l(msgBean.getMessageId()), C, 201326592);
    }

    public final int o() {
        return 111;
    }

    public final Notification p(Context context, NotificationCompat.m mVar, int i, com.transsion.push.notification.d dVar, boolean z) {
        Intrinsics.h(context, "context");
        Intrinsics.h(mVar, "builder");
        Intrinsics.h(dVar, "messageGroup");
        if (i == 111 || Intrinsics.c(dVar.d(), "oneroom.group.tag.permanent")) {
            return null;
        }
        Object systemService = context.getSystemService("notification");
        NotificationManager notificationManager = systemService instanceof NotificationManager ? (NotificationManager) systemService : null;
        if (notificationManager == null) {
            return null;
        }
        Notification c = mVar.c();
        Intrinsics.g(c, "build(...)");
        if (z && Build.VERSION.SDK_INT < 26) {
            c.visibility = 1;
            c.priority = 1;
            c.vibrate = new long[]{0, 300, 100, 300};
            c.defaults = 3;
            c.flags = 17;
        }
        try {
            Result.Companion companion = Result.Companion;
            notificationManager.notify(i, c);
            Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
        return c;
    }

    public final void q(Context context, MsgBean msgBean) {
        Intrinsics.h(context, "context");
        Intrinsics.h(msgBean, "msgBean");
        Intent intent = new Intent(context.getPackageName());
        intent.setAction("ACTION_NEW_MESSAGE");
        intent.putExtra("newMsg", msgBean);
        r1.a.b(context).d(intent);
    }

    public final void r(Context context, MsgBean msgBean, Bitmap bitmap) {
        Intrinsics.h(context, "context");
        Intrinsics.h(msgBean, "msgBean");
        if (msgBean.getIsPermanent()) {
            return;
        }
        com.transsion.push.notification.d c = com.transsion.push.notification.d.d.c(msgBean.getType());
        NotificationUtil notificationUtil = NotificationUtil.a;
        k kVar = k.a;
        String x = notificationUtil.x(!kVar.q());
        int l = l(msgBean.getMessageId());
        if (l < 0) {
            return;
        }
        NotificationCompat.m b = b(context, l, msgBean, c, bitmap, m(context, x, l, msgBean), h(context, msgBean, l, c));
        boolean z = !kVar.q();
        if (Intrinsics.c(msgBean.getType(), MsgType.SUBJECT_SEEKING.getType())) {
            b.E(true);
            u.a.b().putLong("seeking_msg_show_time", System.currentTimeMillis());
        }
        p(context, b, l, c, z);
        u(context, msgBean);
        if (msgBean.getIsRefresh()) {
            return;
        }
        wf.a.a.c("PUSH_SHOW", "send local push:" + msgBean.getMessageId() + "-" + msgBean.getTitle(), true);
        a aVar = a.a;
        String str = !aVar.e() ? MsgShowStatus.STATUS_NOTIFY_CLOSE : bitmap == null ? MsgShowStatus.STATUS_IMG_ERROR : MsgShowStatus.STATUS_OK;
        if (Intrinsics.c(msgBean.getType(), MsgType.ONLINE_JSON_PUSH.getType())) {
            aVar.g(msgBean.getMessageId(), String.valueOf(msgBean.getDeeplink()), x, msgBean.getStyle(), str, "2");
        } else {
            aVar.c(msgBean, x, str);
        }
        q(context, msgBean);
    }

    public final void s(Context context, MsgBean msgBean, Bitmap bitmap) {
        Intrinsics.h(context, "context");
        Intrinsics.h(msgBean, "msgBean");
        if (msgBean.getIsPermanent()) {
            return;
        }
        com.transsion.push.notification.d c = com.transsion.push.notification.d.d.c(msgBean.getType());
        int o = o();
        String I = NotificationUtil.a.I();
        p(context, c(context, msgBean, o, bitmap, m(context, I, o, msgBean), c), o, c, true);
        if (msgBean.getIsRefresh()) {
            return;
        }
        a aVar = a.a;
        aVar.c(msgBean, I, !aVar.e() ? MsgShowStatus.STATUS_NOTIFY_CLOSE : bitmap == null ? MsgShowStatus.STATUS_IMG_ERROR : MsgShowStatus.STATUS_OK);
        q(context, msgBean);
    }

    public final void t(Context context, MsgBean msgBean, ServerMatchListItemData serverMatchListItemData, Map map) {
        Intrinsics.h(context, "context");
        Intrinsics.h(msgBean, "msgBean");
        Intrinsics.h(map, "matchMapBitmap");
        if (msgBean.getIsPermanent()) {
            return;
        }
        com.transsion.push.notification.d c = com.transsion.push.notification.d.d.c(msgBean.getType());
        int l = l(msgBean.getMessageId());
        String I = NotificationUtil.a.I();
        NotificationCompat.m e = e(context, msgBean, l, null, m(context, I, l, msgBean), c, serverMatchListItemData, map);
        boolean z = !k.a.q();
        StringBuilder sb = new StringBuilder();
        sb.append("isAppForeground  is ");
        sb.append(z);
        sb.append(" ");
        e.E(true);
        u.a.b().putLong("seeking_msg_show_time", System.currentTimeMillis());
        p(context, e, l, c, true);
        u(context, msgBean);
        if (msgBean.getIsRefresh()) {
            return;
        }
        a aVar = a.a;
        aVar.c(msgBean, I, !aVar.e() ? MsgShowStatus.STATUS_NOTIFY_CLOSE : MsgShowStatus.STATUS_IMG_ERROR);
        q(context, msgBean);
    }
}
