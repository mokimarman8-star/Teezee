package com.transsion.push.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.y;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.transsion.baselib.db.notification.MsgBean;
import com.transsion.gslb.BuildConfig;
import com.transsion.lib.push.R$mipmap;
import com.transsion.push.bean.MsgShowStatus;
import com.transsion.push.bean.MsgStyle;
import com.transsion.push.bean.MsgType;
import com.transsion.push.bean.ServerMatchListItemData;
import com.transsion.push.bean.TeamInfoMatch;
import com.transsion.push.utils.NotificationUtil;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e {
    public static final e a = new e();
    private static final int b = lj.a.b(100);
    private static final Lazy c = LazyKt.b(new Function0() { // from class: com.transsion.push.helper.d
        public final Object invoke() {
            int b2;
            b2 = e.b();
            return Integer.valueOf(b2);
        }
    });

    public static final class a extends CustomTarget {
        final /* synthetic */ Map a;
        final /* synthetic */ String b;
        final /* synthetic */ Context c;
        final /* synthetic */ MsgBean d;
        final /* synthetic */ ServerMatchListItemData e;

        a(Map map, String str, Context context, MsgBean msgBean, ServerMatchListItemData serverMatchListItemData) {
            this.a = map;
            this.b = str;
            this.c = context;
            this.d = msgBean;
            this.e = serverMatchListItemData;
        }

        private final void a(Context context, MsgBean msgBean, ServerMatchListItemData serverMatchListItemData, Map map) {
            a.a.f(wf.a.a, "PushImageHelper", "showMatchPush", false, 4, (Object) null);
            NotificationShowHelper.a.t(context, msgBean, serverMatchListItemData, map);
        }

        public void onLoadCleared(Drawable drawable) {
        }

        public void onLoadFailed(Drawable drawable) {
            super.onLoadFailed(drawable);
        }

        public void onResourceReady(Bitmap bitmap, Transition transition) {
            Intrinsics.h(bitmap, "resource");
            this.a.put(this.b, bitmap);
            if (this.a.size() == 2) {
                a(this.c, this.d, this.e, this.a);
            }
        }
    }

    public static final class b extends CustomTarget {
        final /* synthetic */ MsgBean a;
        final /* synthetic */ Context b;

        b(MsgBean msgBean, Context context) {
            this.a = msgBean;
            this.b = context;
        }

        private final void a(Bitmap bitmap) {
            if (this.a.getIsPermanent()) {
                NotificationShowHelper.a.s(this.b, this.a, bitmap);
            } else {
                NotificationShowHelper.a.r(this.b, this.a, bitmap);
            }
        }

        public void onLoadCleared(Drawable drawable) {
            a.a.f(wf.a.a, "PushImageHelper", "onLoadCleared", false, 4, (Object) null);
        }

        public void onLoadFailed(Drawable drawable) {
            super.onLoadFailed(drawable);
            a.a.f(wf.a.a, "PushImageHelper", "onFailure", false, 4, (Object) null);
            a(null);
        }

        public void onResourceReady(Bitmap bitmap, Transition transition) {
            Intrinsics.h(bitmap, "resource");
            a.a.f(wf.a.a, "PushImageHelper", "onSuccess", false, 4, (Object) null);
            a(bitmap);
        }
    }

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int b() {
        return y.a() - lj.a.b(80);
    }

    private final void c(Context context, Map map, MsgBean msgBean, ServerMatchListItemData serverMatchListItemData, Map map2) {
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            Glide.with(context).asBitmap().diskCacheStrategy(DiskCacheStrategy.DATA).load((String) entry.getValue()).into(new a(map2, str, context, msgBean, serverMatchListItemData));
        }
    }

    private final void k(Context context, MsgBean msgBean) {
        if (msgBean.getIsPermanent()) {
            return;
        }
        a.a.f(wf.a.a, "PushImageHelper", "handleRequest", false, 4, (Object) null);
        NotificationShowHelper notificationShowHelper = NotificationShowHelper.a;
        List i = notificationShowHelper.i(msgBean);
        if (i.isEmpty()) {
            return;
        }
        boolean z = false;
        try {
            String str = (String) i.get(0);
            if (msgBean.getBuiltIn()) {
                InputStream open = context.getAssets().open(str);
                notificationShowHelper.r(context, msgBean, BitmapFactory.decodeStream(open));
                Intrinsics.e(open);
            } else {
                if (!msgBean.getIsPermanent() && !Intrinsics.c(msgBean.getStyle(), MsgStyle.STYLE_HOR_TYPE)) {
                    z = true;
                }
                Intrinsics.e(Glide.with(context).asBitmap().diskCacheStrategy(DiskCacheStrategy.DATA).load(NotificationUtil.a.J(str, f(z))).into(new b(msgBean, context)));
            }
        } catch (Exception unused) {
            a.a.f(wf.a.a, "PushImageHelper", "onFailure", false, 4, (Object) null);
            if (msgBean.getIsRefresh()) {
                return;
            }
            if (Intrinsics.c(msgBean.getType(), MsgType.ONLINE_JSON_PUSH.getType())) {
                com.transsion.push.helper.a.a.g(msgBean.getMessageId(), String.valueOf(msgBean.getDeeplink()), BuildConfig.FLAVOR, msgBean.getStyle(), MsgShowStatus.STATUS_APP_ERROR, "2");
            } else {
                com.transsion.push.helper.a.a.c(msgBean, BuildConfig.FLAVOR, MsgShowStatus.STATUS_APP_ERROR);
            }
        }
    }

    private final void l(Context context, MsgBean msgBean, ServerMatchListItemData serverMatchListItemData) {
        TeamInfoMatch team2;
        TeamInfoMatch team1;
        String str = null;
        String valueOf = String.valueOf((serverMatchListItemData == null || (team1 = serverMatchListItemData.getTeam1()) == null) ? null : team1.getAvatar());
        if (serverMatchListItemData != null && (team2 = serverMatchListItemData.getTeam2()) != null) {
            str = team2.getAvatar();
        }
        c(context, MapsKt.m(new Pair[]{TuplesKt.a("team1ImgUrl", valueOf), TuplesKt.a("team2ImgUrl", String.valueOf(str))}), msgBean, serverMatchListItemData, new LinkedHashMap());
    }

    public final int d() {
        return ((Number) c.getValue()).intValue();
    }

    public final Bitmap e() {
        Drawable drawable = Utils.a().getResources().getDrawable(R$mipmap.ic_default_push);
        Intrinsics.g(drawable, "getDrawable(...)");
        return a1.b.c(drawable, 0, 0, (Bitmap.Config) null, 7, (Object) null);
    }

    public final int f(boolean z) {
        return z ? b : d();
    }

    public final int g() {
        return b;
    }

    public final void h(Context context, MsgBean msgBean, ServerMatchListItemData serverMatchListItemData) {
        Intrinsics.h(context, "context");
        Intrinsics.h(msgBean, "permanentMsgBean");
        a.a.f(wf.a.a, "PushImageHelper", "handleHigherMatchMsg data :" + serverMatchListItemData, false, 4, (Object) null);
        l(context, msgBean, serverMatchListItemData);
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 6 */
    public final void i(Context context, MsgBean msgBean) {
    }

    public final void j(Context context, MsgBean msgBean) {
        Intrinsics.h(context, "context");
        Intrinsics.h(msgBean, "msgBean");
        if (msgBean.getIsPermanent()) {
            return;
        }
        k(context, msgBean);
    }
}
