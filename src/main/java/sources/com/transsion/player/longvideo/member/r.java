package com.transsion.player.longvideo.member;

import com.transsion.gslb.BuildConfig;
import com.transsion.mb.config.manager.ConfigBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class r {
    public static final r a = new r();

    private r() {
    }

    public static /* synthetic */ Integer c(r rVar, List list, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = rVar.i();
        }
        return rVar.b(list, i);
    }

    public static /* synthetic */ Integer e(r rVar, qn.b[] bVarArr, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = rVar.i();
        }
        return rVar.d(bVarArr, i);
    }

    public static /* synthetic */ ln.c g(r rVar, List list, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = rVar.i();
        }
        return rVar.f(list, i);
    }

    public static /* synthetic */ boolean l(r rVar, List list, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = rVar.i();
        }
        return rVar.k(list, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int m(ln.c cVar) {
        Intrinsics.h(cVar, "it");
        return a.r(cVar.e());
    }

    public static /* synthetic */ boolean o(r rVar, qn.b[] bVarArr, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = rVar.i();
        }
        return rVar.n(bVarArr, i);
    }

    public final Integer b(List list, int i) {
        Object next;
        if (list == null) {
            return null;
        }
        Iterator it = list.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                int abs = Math.abs(a.r(((ln.c) next).e()) - i);
                do {
                    Object next2 = it.next();
                    int abs2 = Math.abs(a.r(((ln.c) next2).e()) - i);
                    if (abs > abs2) {
                        next = next2;
                        abs = abs2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        ln.c cVar = (ln.c) next;
        if (cVar != null) {
            return Integer.valueOf(a.r(cVar.e()));
        }
        return null;
    }

    public final Integer d(qn.b[] bVarArr, int i) {
        qn.b bVar;
        Intrinsics.h(bVarArr, "formats");
        if (bVarArr.length == 0) {
            bVar = null;
        } else {
            bVar = bVarArr[0];
            int Y = ArraysKt.Y(bVarArr);
            if (Y != 0) {
                int abs = Math.abs(bVar.c() - i);
                int i2 = 1;
                if (1 <= Y) {
                    while (true) {
                        qn.b bVar2 = bVarArr[i2];
                        int abs2 = Math.abs(bVar2.c() - i);
                        if (abs > abs2) {
                            bVar = bVar2;
                            abs = abs2;
                        }
                        if (i2 == Y) {
                            break;
                        }
                        i2++;
                    }
                }
            }
        }
        if (bVar != null) {
            return Integer.valueOf(bVar.c());
        }
        return null;
    }

    public final ln.c f(List list, int i) {
        Object obj;
        Intrinsics.h(list, "list");
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            if (a.r(((ln.c) obj2).e()) < i) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                int r = a.r(((ln.c) next).e());
                do {
                    Object next2 = it.next();
                    int r2 = a.r(((ln.c) next2).e());
                    if (r < r2) {
                        next = next2;
                        r = r2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        return (ln.c) obj;
    }

    public final ln.b h(List list) {
        Object obj;
        Intrinsics.h(list, "resolutionList");
        Iterator it = list.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                int r = a.r(((ln.b) next).d());
                do {
                    Object next2 = it.next();
                    int r2 = a.r(((ln.b) next2).d());
                    if (r < r2) {
                        next = next2;
                        r = r2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        return (ln.b) obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int i() {
        Object obj;
        ConfigBean c;
        String str;
        try {
            Result.Companion companion = Result.Companion;
            c = cm.f.c.a().c("stream_resolution_ratio", true);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (c != null) {
            str = c.getValue();
            if (str == null) {
            }
            obj = Result.constructor-impl(Integer.valueOf(new JSONObject(str).optInt("vipResolutionRatio")));
            if (Result.exceptionOrNull-impl(obj) != null) {
                obj = 1080;
            }
            return ((Number) obj).intValue();
        }
        str = BuildConfig.FLAVOR;
        obj = Result.constructor-impl(Integer.valueOf(new JSONObject(str).optInt("vipResolutionRatio")));
        if (Result.exceptionOrNull-impl(obj) != null) {
        }
        return ((Number) obj).intValue();
    }

    public final String j() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(s(i()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = String.valueOf(a.i());
        }
        return (String) obj;
    }

    public final boolean k(List list, int i) {
        Sequence Z;
        Sequence y;
        if (list == null || (Z = CollectionsKt.Z(list)) == null || (y = SequencesKt.y(Z, new Function1() { // from class: com.transsion.player.longvideo.member.q
            public final Object invoke(Object obj) {
                int m;
                m = r.m((ln.c) obj);
                return Integer.valueOf(m);
            }
        })) == null) {
            return false;
        }
        Iterator it = y.iterator();
        while (it.hasNext()) {
            if (((Number) it.next()).intValue() >= i) {
                return true;
            }
        }
        return false;
    }

    public final boolean n(qn.b[] bVarArr, int i) {
        Intrinsics.h(bVarArr, "formats");
        for (qn.b bVar : bVarArr) {
            if (bVar.c() >= i) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean p() {
        Object obj;
        ConfigBean c;
        String str;
        try {
            Result.Companion companion = Result.Companion;
            c = cm.f.c.a().c("stream_resolution_ratio", true);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (c != null) {
            str = c.getValue();
            if (str == null) {
            }
            obj = Result.constructor-impl(Boolean.valueOf(new JSONObject(str).optBoolean("isVipIntercept")));
            if (Result.exceptionOrNull-impl(obj) != null) {
                obj = Boolean.FALSE;
            }
            return ((Boolean) obj).booleanValue();
        }
        str = BuildConfig.FLAVOR;
        obj = Result.constructor-impl(Boolean.valueOf(new JSONObject(str).optBoolean("isVipIntercept")));
        if (Result.exceptionOrNull-impl(obj) != null) {
        }
        return ((Boolean) obj).booleanValue();
    }

    public final boolean q(String str) {
        Intrinsics.h(str, "resolution");
        return r(str) >= i();
    }

    public final int r(String str) {
        Integer num;
        if (str == null || StringsKt.q0(str)) {
            return 0;
        }
        String upperCase = StringsKt.n1(str).toString().toUpperCase(Locale.ROOT);
        Intrinsics.g(upperCase, "toUpperCase(...)");
        int hashCode = upperCase.hashCode();
        if (hashCode == 1625) {
            if (upperCase.equals("2K")) {
                num = 1440;
            }
            num = null;
        } else if (hashCode == 1687) {
            if (upperCase.equals("4K")) {
                num = 2160;
            }
            num = null;
        } else if (hashCode != 1718) {
            if (hashCode == 1811 && upperCase.equals("8K")) {
                num = 4320;
            }
            num = null;
        } else {
            if (upperCase.equals("5K")) {
                num = 2880;
            }
            num = null;
        }
        if (num != null) {
            return num.intValue();
        }
        Integer v = StringsKt.v(StringsKt.J0(upperCase, "P"));
        if (v != null) {
            return v.intValue();
        }
        return 0;
    }

    public final String s(int i) {
        if (i >= 4320) {
            return "8K";
        }
        if (i >= 2880) {
            return "5K";
        }
        if (i >= 2160) {
            return "4K";
        }
        if (i >= 1440) {
            return "2K";
        }
        if (i >= 1080) {
            return "1080P";
        }
        if (i >= 720) {
            return "720P";
        }
        if (i >= 576) {
            return "576P";
        }
        if (i >= 480) {
            return "480P";
        }
        if (i >= 360) {
            return "360P";
        }
        if (i >= 240) {
            return "240P";
        }
        return i + "P";
    }
}
