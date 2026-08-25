package com.transsion.push.notification;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.transsion.baseui.R;
import com.transsion.lib.push.R$drawable;
import com.transsion.lib.push.R$id;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class b {
    private a a;

    public b(a aVar) {
        Intrinsics.h(aVar, "parentBuilder");
        this.a = aVar;
    }

    public final NotificationCompat.m a(Context context) {
        RemoteViews i;
        RemoteViews i2;
        RemoteViews i3;
        RemoteViews j;
        Intrinsics.h(context, "context");
        if (this.a.o() <= 0) {
            this.a.M(R$drawable.push_small_logo);
        }
        NotificationCompat.m m = new NotificationCompat.m(context, this.a.d()).P(this.a.r()).I(false).J(this.a.o()).l(this.a.s()).r(this.a.h()).q(this.a.g()).m(1);
        Intrinsics.g(m, "setBadgeIconType(...)");
        if (this.a.e() > 0) {
            m.o(this.a.e());
        }
        if (this.a.j() != null) {
            PendingIntent c = this.a.c();
            if (c != null && (j = this.a.j()) != null) {
                j.setOnClickPendingIntent(R$id.ll_download, c);
            }
            Intrinsics.e(m.t(this.a.j()));
        } else if (this.a.l() != null) {
            m.A(this.a.l());
        }
        if (this.a.i() != null) {
            PendingIntent c2 = this.a.c();
            if (c2 != null && (i3 = this.a.i()) != null) {
                i3.setOnClickPendingIntent(R$id.ll_download, c2);
            }
            PendingIntent m2 = this.a.m();
            if (m2 != null && (i2 = this.a.i()) != null) {
                i2.setOnClickPendingIntent(R$id.notification_last, m2);
            }
            PendingIntent n = this.a.n();
            if (n != null && (i = this.a.i()) != null) {
                i.setOnClickPendingIntent(R$id.notification_next, n);
            }
            m.s(this.a.i());
            if (this.a.p()) {
                m.L(new NotificationCompat.o());
            }
        }
        if (this.a.a() != null) {
            NotificationCompat.j t = new NotificationCompat.j().s(this.a.h()).r(this.a.a()).t(this.a.g());
            Intrinsics.g(t, "setSummaryText(...)");
            m.L(t);
        }
        if (!TextUtils.isEmpty(this.a.b())) {
            NotificationCompat.k s = new NotificationCompat.k().r(this.a.h()).q(this.a.b()).s(context.getString(R.string.base_app_name));
            Intrinsics.g(s, "setSummaryText(...)");
            m.L(s);
        }
        m.p(this.a.f());
        String q = this.a.q();
        if (q == null) {
            q = context.getString(R.string.base_app_name);
            Intrinsics.g(q, "getString(...)");
        }
        m.M(q);
        m.n(this.a.d());
        m.u(this.a.v() ? 1 : -1);
        if (this.a.w()) {
            m.O(1);
        }
        if (this.a.u()) {
            m.E(true).l(false).F(true);
            if (this.a.t()) {
                m.G(2);
                if (Build.VERSION.SDK_INT >= 26) {
                    m.u(0);
                }
            }
        } else {
            m.E(false).l(this.a.s()).F(true);
            if (this.a.t()) {
                m.G(2);
                Intrinsics.e(m.u(1));
            } else {
                m.G(1);
            }
        }
        if (!TextUtils.isEmpty(this.a.k())) {
            m.z(false);
            m.y(this.a.k());
        }
        return m;
    }
}
