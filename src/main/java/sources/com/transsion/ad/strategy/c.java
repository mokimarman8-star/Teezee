package com.transsion.ad.strategy;

import android.text.TextUtils;
import com.transsion.ad.monopoly.model.MbAdPlansBean;
import com.transsion.gslb.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c {
    public static final c a = new c();

    private c() {
    }

    private final List c() {
        ArrayList arrayList = new ArrayList();
        try {
            Result.Companion companion = Result.Companion;
            Iterator it = StringsKt.S0(b(), new String[]{","}, false, 0, 6, (Object) null).iterator();
            while (it.hasNext()) {
                String upperCase = ((String) it.next()).toUpperCase(Locale.ROOT);
                Intrinsics.g(upperCase, "toUpperCase(...)");
                arrayList.add(upperCase);
            }
            Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
        return arrayList;
    }

    public final Map a(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("genre", str);
        return linkedHashMap;
    }

    public final String b() {
        String string = e.a.c().getString("ad_plan_genre", BuildConfig.FLAVOR);
        return string == null ? BuildConfig.FLAVOR : string;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0061, code lost:
    
        if (r10 == null) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean d(Map map) {
        Object obj;
        boolean z;
        String str;
        String str2;
        List arrayList;
        try {
            Result.Companion companion = Result.Companion;
            if (map != null) {
                Object obj2 = map.get("genre");
                String str3 = obj2 instanceof String ? (String) obj2 : null;
                if (str3 != null) {
                    String upperCase = str3.toUpperCase(Locale.ROOT);
                    Intrinsics.g(upperCase, "toUpperCase(...)");
                    str = upperCase;
                } else {
                    str = null;
                }
                String Q = str != null ? StringsKt.Q(str, " ", BuildConfig.FLAVOR, false, 4, (Object) null) : null;
                List S0 = Q != null ? StringsKt.S0(Q, new String[]{","}, false, 0, 6, (Object) null) : null;
                Object obj3 = map.get("channelId");
                String str4 = obj3 instanceof String ? (String) obj3 : null;
                if (str4 != null) {
                    str2 = str4.toUpperCase(Locale.ROOT);
                    Intrinsics.g(str2, "toUpperCase(...)");
                }
                str2 = BuildConfig.FLAVOR;
                List U0 = S0 != null ? CollectionsKt.U0(S0) : null;
                if (!TextUtils.isEmpty(str2) && U0 != null) {
                    U0.add(str2);
                }
                ci.k kVar = ci.k.a;
                if (U0 == null || (arrayList = CollectionsKt.U0(U0)) == null) {
                    arrayList = new ArrayList();
                }
                z = kVar.a(arrayList, a.c());
            } else {
                z = false;
            }
            obj = Result.constructor-impl(Boolean.valueOf(z));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = Boolean.FALSE;
        }
        return ((Boolean) obj).booleanValue();
    }

    public final void e(MbAdPlansBean mbAdPlansBean) {
        e.a.c().putString("ad_plan_genre", mbAdPlansBean != null ? mbAdPlansBean.getGenre() : null);
        xh.a.c(xh.a.a, c.class.getSimpleName() + " --> saveGenre() --> genre = " + (mbAdPlansBean != null ? mbAdPlansBean.getGenre() : null), 0, false, 6, null);
    }
}
