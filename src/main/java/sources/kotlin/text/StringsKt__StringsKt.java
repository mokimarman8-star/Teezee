package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CharIterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt__StringsKt$lineSequence$;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
class StringsKt__StringsKt extends s {
    public static String A0(String str, int i, char c) {
        Intrinsics.h(str, "<this>");
        return z0(str, i, c).toString();
    }

    private static final Sequence B0(CharSequence charSequence, char[] cArr, int i, boolean z, int i2) {
        N0(i2);
        return new DelimitedRangesSequence(charSequence, i, i2, new t(cArr, z));
    }

    private static final Sequence C0(CharSequence charSequence, String[] strArr, int i, boolean z, int i2) {
        N0(i2);
        return new DelimitedRangesSequence(charSequence, i, i2, new u(ArraysKt.g(strArr), z));
    }

    static /* synthetic */ Sequence D0(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return B0(charSequence, cArr, i, z, i2);
    }

    static /* synthetic */ Sequence E0(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return C0(charSequence, strArr, i, z, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair F0(char[] cArr, boolean z, CharSequence charSequence, int i) {
        Intrinsics.h(charSequence, "$this$DelimitedRangesSequence");
        int p0 = p0(charSequence, cArr, i, z);
        if (p0 < 0) {
            return null;
        }
        return TuplesKt.a(Integer.valueOf(p0), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair G0(List list, boolean z, CharSequence charSequence, int i) {
        Intrinsics.h(charSequence, "$this$DelimitedRangesSequence");
        Pair h0 = h0(charSequence, list, i, z, false);
        if (h0 != null) {
            return TuplesKt.a(h0.getFirst(), Integer.valueOf(((String) h0.getSecond()).length()));
        }
        return null;
    }

    public static final boolean H0(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        Intrinsics.h(charSequence, "<this>");
        Intrinsics.h(charSequence2, "other");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!c.g(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static String I0(String str, CharSequence charSequence) {
        Intrinsics.h(str, "<this>");
        Intrinsics.h(charSequence, "prefix");
        if (!W0(str, charSequence, false, 2, null)) {
            return str;
        }
        String substring = str.substring(charSequence.length());
        Intrinsics.g(substring, "substring(...)");
        return substring;
    }

    public static String J0(String str, CharSequence charSequence) {
        Intrinsics.h(str, "<this>");
        Intrinsics.h(charSequence, "suffix");
        if (!StringsKt.g0(str, charSequence, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(0, str.length() - charSequence.length());
        Intrinsics.g(substring, "substring(...)");
        return substring;
    }

    public static String K0(String str, CharSequence charSequence) {
        Intrinsics.h(str, "<this>");
        Intrinsics.h(charSequence, "delimiter");
        return L0(str, charSequence, charSequence);
    }

    public static final String L0(String str, CharSequence charSequence, CharSequence charSequence2) {
        Intrinsics.h(str, "<this>");
        Intrinsics.h(charSequence, "prefix");
        Intrinsics.h(charSequence2, "suffix");
        if (str.length() < charSequence.length() + charSequence2.length() || !W0(str, charSequence, false, 2, null) || !StringsKt.g0(str, charSequence2, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(charSequence.length(), str.length() - charSequence2.length());
        Intrinsics.g(substring, "substring(...)");
        return substring;
    }

    public static CharSequence M0(CharSequence charSequence, int i, int i2, CharSequence charSequence2) {
        Intrinsics.h(charSequence, "<this>");
        Intrinsics.h(charSequence2, "replacement");
        if (i2 >= i) {
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence, 0, i);
            Intrinsics.g(sb, "append(...)");
            sb.append(charSequence2);
            sb.append(charSequence, i2, charSequence.length());
            Intrinsics.g(sb, "append(...)");
            return sb;
        }
        throw new IndexOutOfBoundsException("End index (" + i2 + ") is less than start index (" + i + ").");
    }

    public static final void N0(int i) {
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i).toString());
    }

    public static final List O0(CharSequence charSequence, char[] cArr, boolean z, int i) {
        Intrinsics.h(charSequence, "<this>");
        Intrinsics.h(cArr, "delimiters");
        if (cArr.length == 1) {
            return Q0(charSequence, String.valueOf(cArr[0]), z, i);
        }
        Iterable n = SequencesKt.n(D0(charSequence, cArr, 0, z, i, 2, null));
        ArrayList arrayList = new ArrayList(CollectionsKt.v(n, 10));
        Iterator it = n.iterator();
        while (it.hasNext()) {
            arrayList.add(X0(charSequence, (IntRange) it.next()));
        }
        return arrayList;
    }

    public static final List P0(CharSequence charSequence, String[] strArr, boolean z, int i) {
        Intrinsics.h(charSequence, "<this>");
        Intrinsics.h(strArr, "delimiters");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() != 0) {
                return Q0(charSequence, str, z, i);
            }
        }
        Iterable n = SequencesKt.n(E0(charSequence, strArr, 0, z, i, 2, null));
        ArrayList arrayList = new ArrayList(CollectionsKt.v(n, 10));
        Iterator it = n.iterator();
        while (it.hasNext()) {
            arrayList.add(X0(charSequence, (IntRange) it.next()));
        }
        return arrayList;
    }

    private static final List Q0(CharSequence charSequence, String str, boolean z, int i) {
        N0(i);
        int i2 = 0;
        int k0 = StringsKt.k0(charSequence, str, 0, z);
        if (k0 == -1 || i == 1) {
            return CollectionsKt.e(charSequence.toString());
        }
        boolean z2 = i > 0;
        ArrayList arrayList = new ArrayList(z2 ? RangesKt.h(i, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(i2, k0).toString());
            i2 = str.length() + k0;
            if (z2 && arrayList.size() == i - 1) {
                break;
            }
            k0 = StringsKt.k0(charSequence, str, i2, z);
        } while (k0 != -1);
        arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List R0(CharSequence charSequence, char[] cArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return O0(charSequence, cArr, z, i);
    }

    public static /* synthetic */ List S0(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return P0(charSequence, strArr, z, i);
    }

    public static final boolean T0(CharSequence charSequence, char c, boolean z) {
        Intrinsics.h(charSequence, "<this>");
        return charSequence.length() > 0 && c.g(charSequence.charAt(0), c, z);
    }

    public static final boolean U0(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        Intrinsics.h(charSequence, "<this>");
        Intrinsics.h(charSequence2, "prefix");
        return (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) ? StringsKt.W((String) charSequence, (String) charSequence2, false, 2, (Object) null) : H0(charSequence, 0, charSequence2, 0, charSequence2.length(), z);
    }

    public static /* synthetic */ boolean V0(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return T0(charSequence, c, z);
    }

    public static /* synthetic */ boolean W0(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return U0(charSequence, charSequence2, z);
    }

    public static final String X0(CharSequence charSequence, IntRange intRange) {
        Intrinsics.h(charSequence, "<this>");
        Intrinsics.h(intRange, "range");
        return charSequence.subSequence(intRange.q().intValue(), intRange.p().intValue() + 1).toString();
    }

    public static final String Y0(String str, char c, String str2) {
        Intrinsics.h(str, "<this>");
        Intrinsics.h(str2, "missingDelimiterValue");
        int n0 = StringsKt.n0(str, c, 0, false, 6, (Object) null);
        if (n0 == -1) {
            return str2;
        }
        String substring = str.substring(n0 + 1, str.length());
        Intrinsics.g(substring, "substring(...)");
        return substring;
    }

    public static final boolean Z(CharSequence charSequence, char c, boolean z) {
        Intrinsics.h(charSequence, "<this>");
        return StringsKt.n0(charSequence, c, 0, z, 2, (Object) null) >= 0;
    }

    public static final String Z0(String str, String str2, String str3) {
        Intrinsics.h(str, "<this>");
        Intrinsics.h(str2, "delimiter");
        Intrinsics.h(str3, "missingDelimiterValue");
        int o0 = StringsKt.o0(str, str2, 0, false, 6, (Object) null);
        if (o0 == -1) {
            return str3;
        }
        String substring = str.substring(o0 + str2.length(), str.length());
        Intrinsics.g(substring, "substring(...)");
        return substring;
    }

    public static boolean a0(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        Intrinsics.h(charSequence, "<this>");
        Intrinsics.h(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (StringsKt.o0(charSequence, (String) charSequence2, 0, z, 2, (Object) null) < 0) {
                return false;
            }
        } else if (m0(charSequence, charSequence2, 0, charSequence.length(), z, false, 16, null) < 0) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ String a1(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return Y0(str, c, str2);
    }

    public static /* synthetic */ boolean b0(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return Z(charSequence, c, z);
    }

    public static /* synthetic */ String b1(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return Z0(str, str2, str3);
    }

    public static /* synthetic */ boolean c0(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.a0(charSequence, charSequence2, z);
    }

    public static String c1(String str, char c, String str2) {
        Intrinsics.h(str, "<this>");
        Intrinsics.h(str2, "missingDelimiterValue");
        int u0 = StringsKt.u0(str, c, 0, false, 6, (Object) null);
        if (u0 == -1) {
            return str2;
        }
        String substring = str.substring(u0 + 1, str.length());
        Intrinsics.g(substring, "substring(...)");
        return substring;
    }

    public static final boolean d0(CharSequence charSequence, char c, boolean z) {
        Intrinsics.h(charSequence, "<this>");
        return charSequence.length() > 0 && c.g(charSequence.charAt(StringsKt.i0(charSequence)), c, z);
    }

    public static String d1(String str, String str2, String str3) {
        Intrinsics.h(str, "<this>");
        Intrinsics.h(str2, "delimiter");
        Intrinsics.h(str3, "missingDelimiterValue");
        int v0 = StringsKt.v0(str, str2, 0, false, 6, (Object) null);
        if (v0 == -1) {
            return str3;
        }
        String substring = str.substring(v0 + str2.length(), str.length());
        Intrinsics.g(substring, "substring(...)");
        return substring;
    }

    public static final boolean e0(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        Intrinsics.h(charSequence, "<this>");
        Intrinsics.h(charSequence2, "suffix");
        return (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) ? StringsKt.G((String) charSequence, (String) charSequence2, false, 2, (Object) null) : H0(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z);
    }

    public static /* synthetic */ String e1(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return StringsKt.c1(str, c, str2);
    }

    public static /* synthetic */ boolean f0(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return d0(charSequence, c, z);
    }

    public static /* synthetic */ String f1(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return StringsKt.d1(str, str2, str3);
    }

    public static /* synthetic */ boolean g0(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return e0(charSequence, charSequence2, z);
    }

    public static final String g1(String str, String str2, String str3) {
        Intrinsics.h(str, "<this>");
        Intrinsics.h(str2, "delimiter");
        Intrinsics.h(str3, "missingDelimiterValue");
        int o0 = StringsKt.o0(str, str2, 0, false, 6, (Object) null);
        if (o0 == -1) {
            return str3;
        }
        String substring = str.substring(0, o0);
        Intrinsics.g(substring, "substring(...)");
        return substring;
    }

    private static final Pair h0(CharSequence charSequence, Collection collection, int i, boolean z, boolean z2) {
        Object obj;
        Object obj2;
        if (!z && collection.size() == 1) {
            String str = (String) CollectionsKt.E0(collection);
            int o0 = !z2 ? StringsKt.o0(charSequence, str, i, false, 4, (Object) null) : StringsKt.v0(charSequence, str, i, false, 4, (Object) null);
            if (o0 < 0) {
                return null;
            }
            return TuplesKt.a(Integer.valueOf(o0), str);
        }
        IntRange intRange = !z2 ? new IntRange(RangesKt.e(i, 0), charSequence.length()) : RangesKt.o(RangesKt.h(i, StringsKt.i0(charSequence)), 0);
        if (charSequence instanceof String) {
            int f = intRange.f();
            int i2 = intRange.i();
            int l = intRange.l();
            if ((l > 0 && f <= i2) || (l < 0 && i2 <= f)) {
                while (true) {
                    Iterator it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it.next();
                        String str2 = (String) obj2;
                        if (StringsKt.K(str2, 0, (String) charSequence, f, str2.length(), z)) {
                            break;
                        }
                    }
                    String str3 = (String) obj2;
                    if (str3 == null) {
                        if (f == i2) {
                            break;
                        }
                        f += l;
                    } else {
                        return TuplesKt.a(Integer.valueOf(f), str3);
                    }
                }
            }
        } else {
            int f2 = intRange.f();
            int i3 = intRange.i();
            int l2 = intRange.l();
            if ((l2 > 0 && f2 <= i3) || (l2 < 0 && i3 <= f2)) {
                while (true) {
                    Iterator it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it2.next();
                        String str4 = (String) obj;
                        if (H0(str4, 0, charSequence, f2, str4.length(), z)) {
                            break;
                        }
                    }
                    String str5 = (String) obj;
                    if (str5 == null) {
                        if (f2 == i3) {
                            break;
                        }
                        f2 += l2;
                    } else {
                        return TuplesKt.a(Integer.valueOf(f2), str5);
                    }
                }
            }
        }
        return null;
    }

    public static /* synthetic */ String h1(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return g1(str, str2, str3);
    }

    public static int i0(CharSequence charSequence) {
        Intrinsics.h(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final String i1(String str, char c, String str2) {
        Intrinsics.h(str, "<this>");
        Intrinsics.h(str2, "missingDelimiterValue");
        int u0 = StringsKt.u0(str, c, 0, false, 6, (Object) null);
        if (u0 == -1) {
            return str2;
        }
        String substring = str.substring(0, u0);
        Intrinsics.g(substring, "substring(...)");
        return substring;
    }

    public static final int j0(CharSequence charSequence, char c, int i, boolean z) {
        Intrinsics.h(charSequence, "<this>");
        return (z || !(charSequence instanceof String)) ? p0(charSequence, new char[]{c}, i, z) : ((String) charSequence).indexOf(c, i);
    }

    public static String j1(String str, String str2, String str3) {
        Intrinsics.h(str, "<this>");
        Intrinsics.h(str2, "delimiter");
        Intrinsics.h(str3, "missingDelimiterValue");
        int v0 = StringsKt.v0(str, str2, 0, false, 6, (Object) null);
        if (v0 == -1) {
            return str3;
        }
        String substring = str.substring(0, v0);
        Intrinsics.g(substring, "substring(...)");
        return substring;
    }

    public static int k0(CharSequence charSequence, String str, int i, boolean z) {
        Intrinsics.h(charSequence, "<this>");
        Intrinsics.h(str, "string");
        return (z || !(charSequence instanceof String)) ? m0(charSequence, str, i, charSequence.length(), z, false, 16, null) : ((String) charSequence).indexOf(str, i);
    }

    public static /* synthetic */ String k1(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return i1(str, c, str2);
    }

    private static final int l0(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        IntRange intRange = !z2 ? new IntRange(RangesKt.e(i, 0), RangesKt.h(i2, charSequence.length())) : RangesKt.o(RangesKt.h(i, StringsKt.i0(charSequence)), RangesKt.e(i2, 0));
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            int f = intRange.f();
            int i3 = intRange.i();
            int l = intRange.l();
            if ((l <= 0 || f > i3) && (l >= 0 || i3 > f)) {
                return -1;
            }
            while (!H0(charSequence2, 0, charSequence, f, charSequence2.length(), z)) {
                if (f == i3) {
                    return -1;
                }
                f += l;
            }
            return f;
        }
        int f2 = intRange.f();
        int i4 = intRange.i();
        int l2 = intRange.l();
        if ((l2 <= 0 || f2 > i4) && (l2 >= 0 || i4 > f2)) {
            return -1;
        }
        while (true) {
            String str = (String) charSequence2;
            if (StringsKt.K(str, 0, (String) charSequence, f2, str.length(), z)) {
                return f2;
            }
            if (f2 == i4) {
                return -1;
            }
            f2 += l2;
        }
    }

    public static /* synthetic */ String l1(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return StringsKt.j1(str, str2, str3);
    }

    static /* synthetic */ int m0(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            z2 = false;
        }
        return l0(charSequence, charSequence2, i, i2, z, z2);
    }

    public static Boolean m1(String str) {
        Intrinsics.h(str, "<this>");
        if (Intrinsics.c(str, "true")) {
            return Boolean.TRUE;
        }
        if (Intrinsics.c(str, "false")) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static /* synthetic */ int n0(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return j0(charSequence, c, i, z);
    }

    public static CharSequence n1(CharSequence charSequence) {
        Intrinsics.h(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean c = CharsKt.c(charSequence.charAt(!z ? i : length));
            if (z) {
                if (!c) {
                    break;
                }
                length--;
            } else if (c) {
                i++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    public static /* synthetic */ int o0(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.k0(charSequence, str, i, z);
    }

    public static CharSequence o1(CharSequence charSequence, char... cArr) {
        Intrinsics.h(charSequence, "<this>");
        Intrinsics.h(cArr, "chars");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean I = ArraysKt.I(cArr, charSequence.charAt(!z ? i : length));
            if (z) {
                if (!I) {
                    break;
                }
                length--;
            } else if (I) {
                i++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    public static final int p0(CharSequence charSequence, char[] cArr, int i, boolean z) {
        Intrinsics.h(charSequence, "<this>");
        Intrinsics.h(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(ArraysKt.w0(cArr), i);
        }
        int e = RangesKt.e(i, 0);
        int i0 = StringsKt.i0(charSequence);
        if (e > i0) {
            return -1;
        }
        while (true) {
            char charAt = charSequence.charAt(e);
            for (char c : cArr) {
                if (c.g(c, charAt, z)) {
                    return e;
                }
            }
            if (e == i0) {
                return -1;
            }
            e++;
        }
    }

    public static String p1(String str, char... cArr) {
        Intrinsics.h(str, "<this>");
        Intrinsics.h(cArr, "chars");
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean I = ArraysKt.I(cArr, str.charAt(!z ? i : length));
            if (z) {
                if (!I) {
                    break;
                }
                length--;
            } else if (I) {
                i++;
            } else {
                z = true;
            }
        }
        return str.subSequence(i, length + 1).toString();
    }

    public static boolean q0(CharSequence charSequence) {
        Intrinsics.h(charSequence, "<this>");
        for (int i = 0; i < charSequence.length(); i++) {
            if (!CharsKt.c(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static CharSequence q1(CharSequence charSequence, char... cArr) {
        Intrinsics.h(charSequence, "<this>");
        Intrinsics.h(cArr, "chars");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (!ArraysKt.I(cArr, charSequence.charAt(length))) {
                    return charSequence.subSequence(0, length + 1);
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return "";
    }

    public static final CharIterator r0(CharSequence charSequence) {
        Intrinsics.h(charSequence, "<this>");
        return new iterator.1(charSequence);
    }

    public static String r1(String str, char... cArr) {
        CharSequence charSequence;
        Intrinsics.h(str, "<this>");
        Intrinsics.h(cArr, "chars");
        int length = str.length() - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (!ArraysKt.I(cArr, str.charAt(length))) {
                    charSequence = str.subSequence(0, length + 1);
                    break;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
            return charSequence.toString();
        }
        charSequence = "";
        return charSequence.toString();
    }

    public static final int s0(CharSequence charSequence, char c, int i, boolean z) {
        Intrinsics.h(charSequence, "<this>");
        return (z || !(charSequence instanceof String)) ? w0(charSequence, new char[]{c}, i, z) : ((String) charSequence).lastIndexOf(c, i);
    }

    public static String s1(String str, char... cArr) {
        CharSequence charSequence;
        Intrinsics.h(str, "<this>");
        Intrinsics.h(cArr, "chars");
        int length = str.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                charSequence = "";
                break;
            }
            if (!ArraysKt.I(cArr, str.charAt(i))) {
                charSequence = str.subSequence(i, str.length());
                break;
            }
            i++;
        }
        return charSequence.toString();
    }

    public static final int t0(CharSequence charSequence, String str, int i, boolean z) {
        Intrinsics.h(charSequence, "<this>");
        Intrinsics.h(str, "string");
        return (z || !(charSequence instanceof String)) ? l0(charSequence, str, i, 0, z, true) : ((String) charSequence).lastIndexOf(str, i);
    }

    public static /* synthetic */ int u0(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StringsKt.i0(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return s0(charSequence, c, i, z);
    }

    public static /* synthetic */ int v0(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StringsKt.i0(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return t0(charSequence, str, i, z);
    }

    public static final int w0(CharSequence charSequence, char[] cArr, int i, boolean z) {
        Intrinsics.h(charSequence, "<this>");
        Intrinsics.h(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(ArraysKt.w0(cArr), i);
        }
        for (int h = RangesKt.h(i, StringsKt.i0(charSequence)); -1 < h; h--) {
            char charAt = charSequence.charAt(h);
            for (char c : cArr) {
                if (c.g(c, charAt, z)) {
                    return h;
                }
            }
        }
        return -1;
    }

    public static final Sequence x0(CharSequence charSequence) {
        Intrinsics.h(charSequence, "<this>");
        return new StringsKt__StringsKt$lineSequence$.inlined.Sequence.1(charSequence);
    }

    public static List y0(CharSequence charSequence) {
        Intrinsics.h(charSequence, "<this>");
        return SequencesKt.C(x0(charSequence));
    }

    public static final CharSequence z0(CharSequence charSequence, int i, char c) {
        Intrinsics.h(charSequence, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException("Desired length " + i + " is less than zero.");
        }
        if (i <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb = new StringBuilder(i);
        int length = i - charSequence.length();
        int i2 = 1;
        if (1 <= length) {
            while (true) {
                sb.append(c);
                if (i2 == length) {
                    break;
                }
                i2++;
            }
        }
        sb.append(charSequence);
        return sb;
    }
}
