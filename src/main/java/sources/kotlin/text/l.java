package kotlin.text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
class l extends h {
    private static final Function1 e(String str) {
        return str.length() == 0 ? new i() : new j(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String f(String str) {
        Intrinsics.h(str, "line");
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String g(String str, String str2) {
        Intrinsics.h(str2, "line");
        return str + str2;
    }

    private static final int h(String str) {
        int length = str.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            }
            if (!CharsKt.c(str.charAt(i))) {
                break;
            }
            i++;
        }
        return i == -1 ? str.length() : i;
    }

    public static final String i(String str, String str2) {
        Intrinsics.h(str, "<this>");
        Intrinsics.h(str2, "indent");
        return SequencesKt.w(SequencesKt.y(StringsKt__StringsKt.x0(str), new k(str2)), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public static /* synthetic */ String j(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "    ";
        }
        return i(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String k(String str, String str2) {
        Intrinsics.h(str2, "it");
        if (StringsKt.q0(str2)) {
            return str2.length() < str.length() ? str : str2;
        }
        return str + str2;
    }

    public static final String l(String str, String str2) {
        String str3;
        Intrinsics.h(str, "<this>");
        Intrinsics.h(str2, "newIndent");
        List y0 = StringsKt.y0(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : y0) {
            if (!StringsKt.q0((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.v(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(h((String) it.next())));
        }
        Integer num = (Integer) CollectionsKt.y0(arrayList2);
        int i = 0;
        int intValue = num != null ? num.intValue() : 0;
        int length = str.length() + (str2.length() * y0.size());
        Function1 e = e(str2);
        int n = CollectionsKt.n(y0);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : y0) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.u();
            }
            String str4 = (String) obj2;
            if ((i == 0 || i == n) && StringsKt.q0(str4)) {
                str4 = null;
            } else {
                String t1 = StringsKt.t1(str4, intValue);
                if (t1 != null && (str3 = (String) e.invoke(t1)) != null) {
                    str4 = str3;
                }
            }
            if (str4 != null) {
                arrayList3.add(str4);
            }
            i = i2;
        }
        return ((StringBuilder) CollectionsKt.q0(arrayList3, new StringBuilder(length), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 124, (Object) null)).toString();
    }

    public static final String m(String str, String str2, String str3) {
        int i;
        String str4;
        Intrinsics.h(str, "<this>");
        Intrinsics.h(str2, "newIndent");
        Intrinsics.h(str3, "marginPrefix");
        if (StringsKt.q0(str3)) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.");
        }
        List y0 = StringsKt.y0(str);
        int length = str.length() + (str2.length() * y0.size());
        Function1 e = e(str2);
        int n = CollectionsKt.n(y0);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (Object obj : y0) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.u();
            }
            String str5 = (String) obj;
            String str6 = null;
            if ((i2 == 0 || i2 == n) && StringsKt.q0(str5)) {
                str5 = null;
            } else {
                int length2 = str5.length();
                int i4 = 0;
                while (true) {
                    if (i4 >= length2) {
                        i = -1;
                        break;
                    }
                    if (!CharsKt.c(str5.charAt(i4))) {
                        i = i4;
                        break;
                    }
                    i4++;
                }
                if (i != -1) {
                    int i6 = i;
                    if (StringsKt.V(str5, str3, i, false, 4, (Object) null)) {
                        int length3 = i6 + str3.length();
                        Intrinsics.f(str5, "null cannot be cast to non-null type java.lang.String");
                        str6 = str5.substring(length3);
                        Intrinsics.g(str6, "substring(...)");
                    }
                }
                if (str6 != null && (str4 = (String) e.invoke(str6)) != null) {
                    str5 = str4;
                }
            }
            if (str5 != null) {
                arrayList.add(str5);
            }
            i2 = i3;
        }
        return ((StringBuilder) CollectionsKt.q0(arrayList, new StringBuilder(length), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 124, (Object) null)).toString();
    }

    public static String n(String str) {
        Intrinsics.h(str, "<this>");
        return l(str, "");
    }

    public static final String o(String str, String str2) {
        Intrinsics.h(str, "<this>");
        Intrinsics.h(str2, "marginPrefix");
        return m(str, "", str2);
    }

    public static /* synthetic */ String p(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "|";
        }
        return o(str, str2);
    }
}
