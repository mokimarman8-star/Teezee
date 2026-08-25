package com.google.firebase.messaging;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.messaging.e;
import java.util.Map;

@SafeParcelable.Class(creator = "RemoteMessageCreator")
@SafeParcelable.Reserved({1})
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class RemoteMessage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR = new s0();
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_NORMAL = 2;
    public static final int PRIORITY_UNKNOWN = 0;

    @SafeParcelable.Field(id = 2)
    Bundle bundle;
    private Map<String, String> data;
    private b notification;

    public static class b {
        private final String a;
        private final String b;
        private final String[] c;
        private final String d;
        private final String e;
        private final String[] f;
        private final String g;
        private final String h;
        private final String i;
        private final String j;
        private final String k;
        private final String l;
        private final String m;
        private final Uri n;
        private final String o;
        private final Integer p;
        private final Integer q;
        private final Integer r;
        private final int[] s;
        private final Long t;
        private final boolean u;
        private final boolean v;
        private final boolean w;
        private final boolean x;
        private final boolean y;
        private final long[] z;

        private b(k0 k0Var) {
            this.a = k0Var.p("gcm.n.title");
            this.b = k0Var.h("gcm.n.title");
            this.c = a(k0Var, "gcm.n.title");
            this.d = k0Var.p("gcm.n.body");
            this.e = k0Var.h("gcm.n.body");
            this.f = a(k0Var, "gcm.n.body");
            this.g = k0Var.p("gcm.n.icon");
            this.i = k0Var.o();
            this.j = k0Var.p("gcm.n.tag");
            this.k = k0Var.p("gcm.n.color");
            this.l = k0Var.p("gcm.n.click_action");
            this.m = k0Var.p("gcm.n.android_channel_id");
            this.n = k0Var.f();
            this.h = k0Var.p("gcm.n.image");
            this.o = k0Var.p("gcm.n.ticker");
            this.p = k0Var.b("gcm.n.notification_priority");
            this.q = k0Var.b("gcm.n.visibility");
            this.r = k0Var.b("gcm.n.notification_count");
            this.u = k0Var.a("gcm.n.sticky");
            this.v = k0Var.a("gcm.n.local_only");
            this.w = k0Var.a("gcm.n.default_sound");
            this.x = k0Var.a("gcm.n.default_vibrate_timings");
            this.y = k0Var.a("gcm.n.default_light_settings");
            this.t = k0Var.j("gcm.n.event_time");
            this.s = k0Var.e();
            this.z = k0Var.q();
        }

        private static String[] a(k0 k0Var, String str) {
            Object[] g = k0Var.g(str);
            if (g == null) {
                return null;
            }
            String[] strArr = new String[g.length];
            for (int i = 0; i < g.length; i++) {
                strArr[i] = String.valueOf(g[i]);
            }
            return strArr;
        }

        public String b() {
            return this.a;
        }
    }

    @SafeParcelable.Constructor
    public RemoteMessage(@SafeParcelable.Param(id = 2) Bundle bundle) {
        this.bundle = bundle;
    }

    private int getMessagePriority(String str) {
        if ("high".equals(str)) {
            return 1;
        }
        return "normal".equals(str) ? 2 : 0;
    }

    @Nullable
    public String getCollapseKey() {
        return this.bundle.getString("collapse_key");
    }

    @NonNull
    public Map<String, String> getData() {
        if (this.data == null) {
            this.data = e.a.a(this.bundle);
        }
        return this.data;
    }

    @Nullable
    public String getFrom() {
        return this.bundle.getString("from");
    }

    @Nullable
    public String getMessageId() {
        String string = this.bundle.getString("google.message_id");
        return string == null ? this.bundle.getString("message_id") : string;
    }

    @Nullable
    public String getMessageType() {
        return this.bundle.getString("message_type");
    }

    @Nullable
    public b getNotification() {
        if (this.notification == null && k0.t(this.bundle)) {
            this.notification = new b(new k0(this.bundle));
        }
        return this.notification;
    }

    public int getOriginalPriority() {
        String string = this.bundle.getString("google.original_priority");
        if (string == null) {
            string = this.bundle.getString("google.priority");
        }
        return getMessagePriority(string);
    }

    public int getPriority() {
        String string = this.bundle.getString("google.delivered_priority");
        if (string == null) {
            if ("1".equals(this.bundle.getString("google.priority_reduced"))) {
                return 2;
            }
            string = this.bundle.getString("google.priority");
        }
        return getMessagePriority(string);
    }

    @Nullable
    @ShowFirstParty
    public byte[] getRawData() {
        return this.bundle.getByteArray("rawData");
    }

    @Nullable
    public String getSenderId() {
        return this.bundle.getString("google.c.sender.id");
    }

    public long getSentTime() {
        Object obj = this.bundle.get("google.sent_time");
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        if (!(obj instanceof String)) {
            return 0L;
        }
        try {
            return Long.parseLong((String) obj);
        } catch (NumberFormatException unused) {
            Log.w("FirebaseMessaging", "Invalid sent time: " + obj);
            return 0L;
        }
    }

    @Nullable
    @Deprecated
    public String getTo() {
        return this.bundle.getString("google.to");
    }

    public int getTtl() {
        Object obj = this.bundle.get("google.ttl");
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Integer.parseInt((String) obj);
        } catch (NumberFormatException unused) {
            Log.w("FirebaseMessaging", "Invalid TTL: " + obj);
            return 0;
        }
    }

    void populateSendMessageIntent(Intent intent) {
        intent.putExtras(this.bundle);
    }

    @KeepForSdk
    public Intent toIntent() {
        Intent intent = new Intent();
        intent.putExtras(this.bundle);
        return intent;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i) {
        s0.c(this, parcel, i);
    }
}
