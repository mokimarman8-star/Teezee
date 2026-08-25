package com.transsion.push.helper;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.blankj.utilcode.util.Utils;
import com.transsion.gslb.BuildConfig;
import com.transsion.lib.push.R$dimen;
import com.transsion.lib.push.R$id;
import com.transsion.lib.push.R$layout;
import com.transsion.push.bean.MsgStyle;
import com.transsion.push.bean.MsgType;
import com.transsion.push.bean.PermanentItemBean;
import com.transsion.push.notification.i;
import com.transsion.push.utils.NotificationUtil;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.t1;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PushPermanentShowHelper {
    private static volatile long d;
    private static t1 i;
    public static final PushPermanentShowHelper a = new PushPermanentShowHelper();
    private static String b = BuildConfig.FLAVOR;
    private static int c = 600000;
    private static final Lazy e = LazyKt.b(new Function0() { // from class: com.transsion.push.helper.h
        public final Object invoke() {
            int n;
            n = PushPermanentShowHelper.n();
            return Integer.valueOf(n);
        }
    });
    private static final Lazy f = LazyKt.b(new Function0() { // from class: com.transsion.push.helper.i
        public final Object invoke() {
            int m;
            m = PushPermanentShowHelper.m();
            return Integer.valueOf(m);
        }
    });
    private static final Integer[] g = {Integer.valueOf(R$id.imageIv1), Integer.valueOf(R$id.imageIv2), Integer.valueOf(R$id.imageIv3), Integer.valueOf(R$id.imageIv4), Integer.valueOf(R$id.imageIv5), Integer.valueOf(R$id.imageIv6), Integer.valueOf(R$id.imageIv7), Integer.valueOf(R$id.imageIv8), Integer.valueOf(R$id.imageIv9), Integer.valueOf(R$id.imageIv10)};
    private static final Integer[] h = {Integer.valueOf(R$id.title1), Integer.valueOf(R$id.title2), Integer.valueOf(R$id.title3), Integer.valueOf(R$id.title4)};

    private PushPermanentShowHelper() {
    }

    private final NotificationCompat.m d(Context context, int i2, List list, List list2, com.transsion.push.notification.d dVar) {
        Object obj;
        Unit unit;
        RemoteViews i3;
        int i4 = 0;
        i.a aVar = new i.a(context, i2, R$layout.push_notification_permanent_small_a, R$layout.push_notification_permanent_big_a);
        try {
            Result.Companion companion = Result.Companion;
            PermanentItemBean permanentItemBean = (PermanentItemBean) CollectionsKt.i0(list);
            String s = PushPermanentManager.a.s();
            if (s.length() == 0) {
                String title = permanentItemBean.getTitle();
                if (title == null) {
                    title = BuildConfig.FLAVOR;
                }
                s = title;
            }
            aVar.F(dVar.c());
            aVar.V(R$id.notification_title_tv, StringsKt.s1(s, new char[]{'\n'}));
            aVar.T(R$id.notification_title_tv, StringsKt.s1(s, new char[]{'\n'}));
            aVar.O(System.currentTimeMillis());
            PushPermanentShowHelper pushPermanentShowHelper = a;
            aVar.z(pushPermanentShowHelper.k(context, dVar.d(), i2, 1, null, pushPermanentShowHelper.i()));
            aVar.K(true);
            aVar.y(NotificationUtil.a.I());
            RemoteViews j = aVar.j();
            if (j != null) {
                for (Object obj2 : list2) {
                    int i5 = i4 + 1;
                    if (i4 < 0) {
                        CollectionsKt.u();
                    }
                    Bitmap bitmap = (Bitmap) obj2;
                    if (i4 < 10) {
                        if (bitmap == null) {
                            bitmap = e.a.e();
                        }
                        Bitmap bitmap2 = bitmap;
                        String i6 = i4 == 9 ? a.i() : null;
                        PushPermanentShowHelper pushPermanentShowHelper2 = a;
                        PendingIntent k = pushPermanentShowHelper2.k(context, dVar.d(), i2, 1, (PermanentItemBean) list.get(i4), i6);
                        Bitmap q = pushPermanentShowHelper2.q(context, bitmap2);
                        if (q == null) {
                            q = bitmap2;
                        }
                        Integer[] numArr = g;
                        aVar.S(numArr[i4].intValue(), q);
                        aVar.U(numArr[i4].intValue(), k);
                        if (i4 < 3) {
                            j.setImageViewBitmap(numArr[i4].intValue(), q);
                            aVar.Y(numArr[i4].intValue(), k);
                        }
                    }
                    i4 = i5;
                }
                if (list2.size() < 10 && (i3 = aVar.i()) != null) {
                    i3.setViewVisibility(R$id.content_layout_2, 8);
                }
                unit = Unit.a;
            } else {
                unit = null;
            }
            obj = Result.constructor-impl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        Throwable th3 = Result.exceptionOrNull-impl(obj);
        if (th3 != null) {
            String message = th3.getMessage();
            StringBuilder sb = new StringBuilder();
            sb.append("buildTypeABuilder-error:");
            sb.append(message);
        }
        if (NotificationUtil.a.N()) {
            return aVar.P().a(context);
        }
        aVar.R(System.currentTimeMillis());
        aVar.N(true);
        return aVar.P().a(context);
    }

    private final NotificationCompat.m e(Context context, int i2, List list, List list2, com.transsion.push.notification.d dVar) {
        Object obj;
        i.a aVar = new i.a(context, i2, R$layout.push_notification_permanent_small_b, R$layout.push_notification_permanent_big_b);
        try {
            Result.Companion companion = Result.Companion;
            PermanentItemBean permanentItemBean = (PermanentItemBean) CollectionsKt.i0(list);
            String s = PushPermanentManager.a.s();
            if (s.length() == 0) {
                String title = permanentItemBean.getTitle();
                if (title == null) {
                    title = BuildConfig.FLAVOR;
                }
                s = title;
            }
            aVar.F(dVar.c());
            aVar.V(R$id.notification_title_tv, StringsKt.s1(s, new char[]{'\n'}));
            aVar.T(R$id.notification_title_tv, StringsKt.s1(s, new char[]{'\n'}));
            RemoteViews j = aVar.j();
            if (j != null) {
                int i3 = 0;
                for (Object obj2 : list2) {
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt.u();
                    }
                    Bitmap bitmap = (Bitmap) obj2;
                    if (bitmap == null) {
                        bitmap = e.a.e();
                    }
                    Bitmap bitmap2 = bitmap;
                    PushPermanentShowHelper pushPermanentShowHelper = a;
                    int i5 = i3;
                    PendingIntent l = l(pushPermanentShowHelper, context, dVar.d(), i2, 2, (PermanentItemBean) list.get(i3), null, 32, null);
                    Bitmap q = pushPermanentShowHelper.q(context, bitmap2);
                    if (q == null) {
                        q = bitmap2;
                    }
                    Integer valueOf = bitmap2 != null ? Integer.valueOf(bitmap2.getByteCount()) : null;
                    StringBuilder sb = new StringBuilder();
                    sb.append("bitmap i:");
                    sb.append(i5);
                    sb.append(", bitmap:");
                    sb.append(valueOf);
                    Integer[] numArr = g;
                    aVar.S(numArr[i5].intValue(), q);
                    if (i5 < 4) {
                        aVar.T(h[i5].intValue(), ((PermanentItemBean) list.get(i5)).getTitle());
                        if (i5 == 0) {
                            aVar.z(l);
                        }
                    }
                    j.setImageViewBitmap(numArr[i5].intValue(), q);
                    aVar.U(numArr[i5].intValue(), l);
                    i3 = i4;
                }
            }
            aVar.O(System.currentTimeMillis());
            aVar.K(true);
            aVar.y(NotificationUtil.a.I());
            obj = Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        Throwable th3 = Result.exceptionOrNull-impl(obj);
        if (th3 != null) {
            String message = th3.getMessage();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("error:");
            sb2.append(message);
        }
        if (NotificationUtil.a.N()) {
            return aVar.P().a(context);
        }
        aVar.R(System.currentTimeMillis());
        aVar.N(true);
        return aVar.P().a(context);
    }

    private final int g() {
        return ((Number) f.getValue()).intValue();
    }

    private final int h() {
        return ((Number) e.getValue()).intValue();
    }

    public static /* synthetic */ PendingIntent l(PushPermanentShowHelper pushPermanentShowHelper, Context context, String str, int i2, int i3, PermanentItemBean permanentItemBean, String str2, int i4, Object obj) {
        if ((i4 & 32) != 0) {
            str2 = null;
        }
        return pushPermanentShowHelper.k(context, str, i2, i3, permanentItemBean, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int m() {
        return (int) Utils.a().getResources().getDimension(R$dimen.push_permanent_image_height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int n() {
        return (int) Utils.a().getResources().getDimension(R$dimen.push_permanent_image_width);
    }

    private final Bitmap q(Context context, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return com.transsion.push.utils.a.a.e(context, bitmap, h(), g(), false, lj.a.b(4));
    }

    public final void f() {
        NotificationShowHelper notificationShowHelper = NotificationShowHelper.a;
        notificationShowHelper.g(notificationShowHelper.o());
    }

    public final String i() {
        return "oneroom://com.community.oneroom?type=/main/tab&channel=permanent_push&msgId=111&msg_type=11";
    }

    public final String j(List list) {
        Intrinsics.h(list, "msgList");
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.u();
            }
            PermanentItemBean permanentItemBean = (PermanentItemBean) obj;
            if (i2 <= 9 && permanentItemBean != null) {
                sb.append(permanentItemBean.getSubjectId());
            }
            i2 = i3;
        }
        b bVar = b.a;
        String sb2 = sb.toString();
        Intrinsics.g(sb2, "toString(...)");
        return bVar.a(sb2);
    }

    public final PendingIntent k(Context context, String str, int i2, int i3, PermanentItemBean permanentItemBean, String str2) {
        String valueOf;
        Intrinsics.h(context, "context");
        NotificationUtil notificationUtil = NotificationUtil.a;
        String type = MsgType.PERMANENT.getType();
        String valueOf2 = String.valueOf(i3);
        if (permanentItemBean == null || (valueOf = permanentItemBean.getSubjectId()) == null) {
            valueOf = String.valueOf(i2);
        }
        String str3 = null;
        Intent C = notificationUtil.C(context, str, i2, MsgStyle.SOURCE_PUSH, type, valueOf2, valueOf, permanentItemBean != null ? permanentItemBean.getDeeplink() : null);
        if (C == null) {
            return null;
        }
        if (str2 != null) {
            str3 = str2;
        } else if (permanentItemBean != null) {
            str3 = permanentItemBean.getDeeplink();
        }
        C.setData(Uri.parse(str3));
        return PendingIntent.getActivity(context, i2, C, 201326592);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:34)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:24)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:252)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:55)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:49)
        */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 17 */
    public final void o(android.content.Context r31, java.util.List r32, java.util.List r33, int r34) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.push.helper.PushPermanentShowHelper.o(android.content.Context, java.util.List, java.util.List, int):void");
    }

    /* JADX WARN: Unreachable blocks removed: 10, instructions: 50 */
    public final void p(Context context, List list) {
    }
}
