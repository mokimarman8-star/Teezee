package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzjf;
import com.google.android.gms.measurement.internal.zzji;
import com.google.android.gms.measurement.internal.zzjj;
import com.google.android.gms.measurement.internal.zzlh;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import mb.a;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class a {
    private static final ImmutableSet a = ImmutableSet.of("_in", "_xa", "_xu", "_aq", "_aa", "_ai", new String[]{"_ac", "campaign_details", "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire"});
    private static final ImmutableList b = ImmutableList.of("_e", "_f", "_iap", "_s", "_au", "_ui", "_cd");
    private static final ImmutableList c = ImmutableList.of("auto", MBridgeConstans.DYNAMIC_VIEW_WX_APP, "am");
    private static final ImmutableList d = ImmutableList.of("_r", "_dbg");
    private static final ImmutableList e = new ImmutableList.a().k(zzjj.zza).k(zzjj.zzb).e();
    private static final ImmutableList f = ImmutableList.of("^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$");

    public static Bundle a(a.c cVar) {
        Bundle bundle = new Bundle();
        String str = cVar.a;
        if (str != null) {
            bundle.putString(TtmlNode.ATTR_TTS_ORIGIN, str);
        }
        String str2 = cVar.b;
        if (str2 != null) {
            bundle.putString(RewardPlus.NAME, str2);
        }
        Object obj = cVar.c;
        if (obj != null) {
            zzjf.zza(bundle, obj);
        }
        String str3 = cVar.d;
        if (str3 != null) {
            bundle.putString("trigger_event_name", str3);
        }
        bundle.putLong("trigger_timeout", cVar.e);
        String str4 = cVar.f;
        if (str4 != null) {
            bundle.putString("timed_out_event_name", str4);
        }
        Bundle bundle2 = cVar.g;
        if (bundle2 != null) {
            bundle.putBundle("timed_out_event_params", bundle2);
        }
        String str5 = cVar.h;
        if (str5 != null) {
            bundle.putString("triggered_event_name", str5);
        }
        Bundle bundle3 = cVar.i;
        if (bundle3 != null) {
            bundle.putBundle("triggered_event_params", bundle3);
        }
        bundle.putLong("time_to_live", cVar.j);
        String str6 = cVar.k;
        if (str6 != null) {
            bundle.putString("expired_event_name", str6);
        }
        Bundle bundle4 = cVar.l;
        if (bundle4 != null) {
            bundle.putBundle("expired_event_params", bundle4);
        }
        bundle.putLong("creation_timestamp", cVar.m);
        bundle.putBoolean("active", cVar.n);
        bundle.putLong("triggered_timestamp", cVar.o);
        return bundle;
    }

    public static String b(String str) {
        String zza = zzji.zza(str);
        return zza != null ? zza : str;
    }

    public static a.c c(Bundle bundle) {
        Preconditions.checkNotNull(bundle);
        a.c cVar = new a.c();
        cVar.a = (String) Preconditions.checkNotNull((String) zzjf.zza(bundle, TtmlNode.ATTR_TTS_ORIGIN, String.class, (Object) null));
        cVar.b = (String) Preconditions.checkNotNull((String) zzjf.zza(bundle, RewardPlus.NAME, String.class, (Object) null));
        cVar.c = zzjf.zza(bundle, "value", Object.class, (Object) null);
        cVar.d = (String) zzjf.zza(bundle, "trigger_event_name", String.class, (Object) null);
        cVar.e = ((Long) zzjf.zza(bundle, "trigger_timeout", Long.class, 0L)).longValue();
        cVar.f = (String) zzjf.zza(bundle, "timed_out_event_name", String.class, (Object) null);
        cVar.g = (Bundle) zzjf.zza(bundle, "timed_out_event_params", Bundle.class, (Object) null);
        cVar.h = (String) zzjf.zza(bundle, "triggered_event_name", String.class, (Object) null);
        cVar.i = (Bundle) zzjf.zza(bundle, "triggered_event_params", Bundle.class, (Object) null);
        cVar.j = ((Long) zzjf.zza(bundle, "time_to_live", Long.class, 0L)).longValue();
        cVar.k = (String) zzjf.zza(bundle, "expired_event_name", String.class, (Object) null);
        cVar.l = (Bundle) zzjf.zza(bundle, "expired_event_params", Bundle.class, (Object) null);
        cVar.n = ((Boolean) zzjf.zza(bundle, "active", Boolean.class, Boolean.FALSE)).booleanValue();
        cVar.m = ((Long) zzjf.zza(bundle, "creation_timestamp", Long.class, 0L)).longValue();
        cVar.o = ((Long) zzjf.zza(bundle, "triggered_timestamp", Long.class, 0L)).longValue();
        return cVar;
    }

    public static void d(String str, String str2, Bundle bundle) {
        if ("clx".equals(str) && "_ae".equals(str2)) {
            bundle.putLong("_r", 1L);
        }
    }

    public static boolean e(String str, Bundle bundle) {
        if (b.contains(str)) {
            return false;
        }
        if (bundle == null) {
            return true;
        }
        ImmutableCollection immutableCollection = d;
        int size = immutableCollection.size();
        int i = 0;
        while (i < size) {
            Object obj = immutableCollection.get(i);
            i++;
            if (bundle.containsKey((String) obj)) {
                return false;
            }
        }
        return true;
    }

    public static boolean f(String str, String str2) {
        if ("_ce1".equals(str2) || "_ce2".equals(str2)) {
            return str.equals("fcm") || str.equals("frc");
        }
        if ("_ln".equals(str2)) {
            return str.equals("fcm") || str.equals("fiam");
        }
        if (e.contains(str2)) {
            return false;
        }
        ImmutableCollection immutableCollection = f;
        int size = immutableCollection.size();
        int i = 0;
        while (i < size) {
            Object obj = immutableCollection.get(i);
            i++;
            if (str2.matches((String) obj)) {
                return false;
            }
        }
        return true;
    }

    public static boolean g(String str, String str2, Bundle bundle) {
        if (!"_cmp".equals(str2)) {
            return true;
        }
        if (!j(str) || bundle == null) {
            return false;
        }
        ImmutableCollection immutableCollection = d;
        int size = immutableCollection.size();
        int i = 0;
        while (i < size) {
            Object obj = immutableCollection.get(i);
            i++;
            if (bundle.containsKey((String) obj)) {
                return false;
            }
        }
        str.hashCode();
        switch (str) {
            case "fcm":
                bundle.putString("_cis", "fcm_integration");
                return true;
            case "fdl":
                bundle.putString("_cis", "fdl_integration");
                return true;
            case "fiam":
                bundle.putString("_cis", "fiam_integration");
                return true;
            default:
                return false;
        }
    }

    public static boolean h(a.c cVar) {
        String str;
        if (cVar == null || (str = cVar.a) == null || str.isEmpty()) {
            return false;
        }
        Object obj = cVar.c;
        if ((obj != null && zzlh.zza(obj) == null) || !j(str) || !f(str, cVar.b)) {
            return false;
        }
        String str2 = cVar.k;
        if (str2 != null && (!e(str2, cVar.l) || !g(str, cVar.k, cVar.l))) {
            return false;
        }
        String str3 = cVar.h;
        if (str3 != null && (!e(str3, cVar.i) || !g(str, cVar.h, cVar.i))) {
            return false;
        }
        String str4 = cVar.f;
        if (str4 != null) {
            return e(str4, cVar.g) && g(str, cVar.f, cVar.g);
        }
        return true;
    }

    public static boolean i(String str) {
        return !a.contains(str);
    }

    public static boolean j(String str) {
        return !c.contains(str);
    }
}
