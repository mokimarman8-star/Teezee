package com.mbridge.msdk.thrid.okhttp;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.thrid.okhttp.internal.publicsuffix.PublicSuffixDatabase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class j {
    private static final Pattern j = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern l = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    private final String a;
    private final String b;
    private final long c;
    private final String d;
    private final String e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private final boolean i;

    private j(String str, String str2, long j2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.a = str;
        this.b = str2;
        this.c = j2;
        this.d = str3;
        this.e = str4;
        this.f = z;
        this.g = z2;
        this.i = z3;
        this.h = z4;
    }

    private static int a(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (((charAt < ' ' && charAt != '\t') || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    private static long a(String str, int i, int i2) {
        int a = a(str, i, i2, false);
        Matcher matcher = m.matcher(str);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        while (a < i2) {
            int a2 = a(str, a + 1, i2, true);
            matcher.region(a, a2);
            if (i4 == -1 && matcher.usePattern(m).matches()) {
                i4 = Integer.parseInt(matcher.group(1));
                i7 = Integer.parseInt(matcher.group(2));
                i8 = Integer.parseInt(matcher.group(3));
            } else if (i5 == -1 && matcher.usePattern(l).matches()) {
                i5 = Integer.parseInt(matcher.group(1));
            } else {
                if (i6 == -1) {
                    Pattern pattern = k;
                    if (matcher.usePattern(pattern).matches()) {
                        i6 = pattern.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                    }
                }
                if (i3 == -1 && matcher.usePattern(j).matches()) {
                    i3 = Integer.parseInt(matcher.group(1));
                }
            }
            a = a(str, a2 + 1, i2, false);
        }
        if (i3 >= 70 && i3 <= 99) {
            i3 += 1900;
        }
        if (i3 >= 0 && i3 <= 69) {
            i3 += 2000;
        }
        if (i3 < 1601) {
            throw new IllegalArgumentException();
        }
        if (i6 == -1) {
            throw new IllegalArgumentException();
        }
        if (i5 < 1 || i5 > 31) {
            throw new IllegalArgumentException();
        }
        if (i4 < 0 || i4 > 23) {
            throw new IllegalArgumentException();
        }
        if (i7 < 0 || i7 > 59) {
            throw new IllegalArgumentException();
        }
        if (i8 < 0 || i8 > 59) {
            throw new IllegalArgumentException();
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(com.mbridge.msdk.thrid.okhttp.internal.c.p);
        gregorianCalendar.setLenient(false);
        gregorianCalendar.set(1, i3);
        gregorianCalendar.set(2, i6 - 1);
        gregorianCalendar.set(5, i5);
        gregorianCalendar.set(11, i4);
        gregorianCalendar.set(12, i7);
        gregorianCalendar.set(13, i8);
        gregorianCalendar.set(14, 0);
        return gregorianCalendar.getTimeInMillis();
    }

    static j a(long j2, q qVar, String str) {
        long j3;
        j jVar;
        String str2;
        String substring;
        int length = str.length();
        char c = ';';
        int a = com.mbridge.msdk.thrid.okhttp.internal.c.a(str, 0, length, ';');
        char c2 = '=';
        int a2 = com.mbridge.msdk.thrid.okhttp.internal.c.a(str, 0, a, '=');
        if (a2 == a) {
            return null;
        }
        String d = com.mbridge.msdk.thrid.okhttp.internal.c.d(str, 0, a2);
        if (d.isEmpty() || com.mbridge.msdk.thrid.okhttp.internal.c.c(d) != -1) {
            return null;
        }
        String d2 = com.mbridge.msdk.thrid.okhttp.internal.c.d(str, a2 + 1, a);
        if (com.mbridge.msdk.thrid.okhttp.internal.c.c(d2) != -1) {
            return null;
        }
        int i = a + 1;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        String str3 = null;
        boolean z4 = true;
        long j4 = -1;
        long j5 = 253402300799999L;
        String str4 = null;
        while (i < length) {
            int a3 = com.mbridge.msdk.thrid.okhttp.internal.c.a(str, i, length, c);
            int a4 = com.mbridge.msdk.thrid.okhttp.internal.c.a(str, i, a3, c2);
            String d3 = com.mbridge.msdk.thrid.okhttp.internal.c.d(str, i, a4);
            String d4 = a4 < a3 ? com.mbridge.msdk.thrid.okhttp.internal.c.d(str, a4 + 1, a3) : TtmlNode.ANONYMOUS_REGION_ID;
            if (d3.equalsIgnoreCase("expires")) {
                try {
                    j5 = a(d4, 0, d4.length());
                } catch (NumberFormatException | IllegalArgumentException unused) {
                }
            } else if (d3.equalsIgnoreCase("max-age")) {
                j4 = b(d4);
            } else {
                if (d3.equalsIgnoreCase("domain")) {
                    str3 = a(d4);
                    z4 = false;
                } else if (d3.equalsIgnoreCase(MBridgeConstans.DYNAMIC_VIEW_WX_PATH)) {
                    str4 = d4;
                } else if (d3.equalsIgnoreCase("secure")) {
                    z = true;
                } else if (d3.equalsIgnoreCase("httponly")) {
                    z2 = true;
                }
                i = a3 + 1;
                c = ';';
                c2 = '=';
            }
            z3 = true;
            i = a3 + 1;
            c = ';';
            c2 = '=';
        }
        if (j4 == Long.MIN_VALUE) {
            j3 = Long.MIN_VALUE;
        } else if (j4 != -1) {
            long j6 = j2 + (j4 <= 9223372036854775L ? j4 * 1000 : Long.MAX_VALUE);
            j3 = (j6 < j2 || j6 > 253402300799999L) ? 253402300799999L : j6;
        } else {
            j3 = j5;
        }
        String g = qVar.g();
        if (str3 == null) {
            str2 = g;
            jVar = null;
        } else {
            if (!a(g, str3)) {
                return null;
            }
            jVar = null;
            str2 = str3;
        }
        if (g.length() != str2.length() && PublicSuffixDatabase.a().a(str2) == null) {
            return jVar;
        }
        if (str4 == null || !str4.startsWith("/")) {
            String c3 = qVar.c();
            int lastIndexOf = c3.lastIndexOf(47);
            substring = lastIndexOf != 0 ? c3.substring(0, lastIndexOf) : "/";
        } else {
            substring = str4;
        }
        return new j(d, d2, j3, str2, substring, z, z2, z4, z3);
    }

    public static j a(q qVar, String str) {
        return a(System.currentTimeMillis(), qVar, str);
    }

    private static String a(String str) {
        if (str.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        String a = com.mbridge.msdk.thrid.okhttp.internal.c.a(str);
        if (a != null) {
            return a;
        }
        throw new IllegalArgumentException();
    }

    public static List<j> a(q qVar, p pVar) {
        List<String> c = pVar.c("Set-Cookie");
        int size = c.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            j a = a(qVar, c.get(i));
            if (a != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(a);
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    private static boolean a(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !com.mbridge.msdk.thrid.okhttp.internal.c.d(str);
    }

    private static long b(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e) {
            if (str.matches("-?\\d+")) {
                return str.startsWith("-") ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            throw e;
        }
    }

    public String a() {
        return this.a;
    }

    String a(boolean z) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.a);
        sb2.append('=');
        sb2.append(this.b);
        if (this.h) {
            if (this.c == Long.MIN_VALUE) {
                sb2.append("; max-age=0");
            } else {
                sb2.append("; expires=");
                sb2.append(com.mbridge.msdk.thrid.okhttp.internal.http.d.a(new Date(this.c)));
            }
        }
        if (!this.i) {
            sb2.append("; domain=");
            if (z) {
                sb2.append(".");
            }
            sb2.append(this.d);
        }
        sb2.append("; path=");
        sb2.append(this.e);
        if (this.f) {
            sb2.append("; secure");
        }
        if (this.g) {
            sb2.append("; httponly");
        }
        return sb2.toString();
    }

    public String b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return jVar.a.equals(this.a) && jVar.b.equals(this.b) && jVar.d.equals(this.d) && jVar.e.equals(this.e) && jVar.c == this.c && jVar.f == this.f && jVar.g == this.g && jVar.h == this.h && jVar.i == this.i;
    }

    public int hashCode() {
        int hashCode = (((((((this.a.hashCode() + 527) * 31) + this.b.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        long j2 = this.c;
        return ((((((((hashCode + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (!this.f ? 1 : 0)) * 31) + (!this.g ? 1 : 0)) * 31) + (!this.h ? 1 : 0)) * 31) + (!this.i ? 1 : 0);
    }

    public String toString() {
        return a(false);
    }
}
