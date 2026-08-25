package ka;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import da.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class d {
    public final String a;
    public final String b;
    public final boolean c;
    public final long d;
    public final long e;
    public final g f;
    private final String[] g;
    public final String h;
    public final String i;
    public final d j;
    private final HashMap k;
    private final HashMap l;
    private List m;

    private d(String str, String str2, long j, long j2, g gVar, String[] strArr, String str3, String str4, d dVar) {
        this.a = str;
        this.b = str2;
        this.i = str4;
        this.f = gVar;
        this.g = strArr;
        this.c = str2 != null;
        this.d = j;
        this.e = j2;
        this.h = (String) com.google.android.exoplayer2.util.a.e(str3);
        this.j = dVar;
        this.k = new HashMap();
        this.l = new HashMap();
    }

    private void b(Map map, b.C0042b c0042b, int i, int i2, int i3) {
        g f = f.f(this.f, this.g, map);
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) c0042b.e();
        if (spannableStringBuilder == null) {
            spannableStringBuilder = new SpannableStringBuilder();
            c0042b.o(spannableStringBuilder);
        }
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        if (f != null) {
            f.a(spannableStringBuilder2, i, i2, f, this.j, map, i3);
            if ("p".equals(this.a)) {
                if (f.k() != Float.MAX_VALUE) {
                    c0042b.m((f.k() * (-90.0f)) / 100.0f);
                }
                if (f.m() != null) {
                    c0042b.p(f.m());
                }
                if (f.h() != null) {
                    c0042b.j(f.h());
                }
            }
        }
    }

    public static d c(String str, long j, long j2, g gVar, String[] strArr, String str2, String str3, d dVar) {
        return new d(str, null, j, j2, gVar, strArr, str2, str3, dVar);
    }

    public static d d(String str) {
        return new d(null, f.b(str), -9223372036854775807L, -9223372036854775807L, null, null, "", null, null);
    }

    private static void e(SpannableStringBuilder spannableStringBuilder) {
        for (a aVar : (a[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), a.class)) {
            spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(aVar), spannableStringBuilder.getSpanEnd(aVar), "");
        }
        for (int i = 0; i < spannableStringBuilder.length(); i++) {
            if (spannableStringBuilder.charAt(i) == ' ') {
                int i2 = i + 1;
                int i3 = i2;
                while (i3 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i3) == ' ') {
                    i3++;
                }
                int i4 = i3 - i2;
                if (i4 > 0) {
                    spannableStringBuilder.delete(i, i4 + i);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
        }
        for (int i5 = 0; i5 < spannableStringBuilder.length() - 1; i5++) {
            if (spannableStringBuilder.charAt(i5) == '\n') {
                int i6 = i5 + 1;
                if (spannableStringBuilder.charAt(i6) == ' ') {
                    spannableStringBuilder.delete(i6, i5 + 2);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
            spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
        }
        for (int i7 = 0; i7 < spannableStringBuilder.length() - 1; i7++) {
            if (spannableStringBuilder.charAt(i7) == ' ') {
                int i10 = i7 + 1;
                if (spannableStringBuilder.charAt(i10) == '\n') {
                    spannableStringBuilder.delete(i7, i10);
                }
            }
        }
        if (spannableStringBuilder.length() <= 0 || spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) != '\n') {
            return;
        }
        spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
    }

    private void i(TreeSet treeSet, boolean z) {
        boolean equals = "p".equals(this.a);
        boolean equals2 = "div".equals(this.a);
        if (z || equals || (equals2 && this.i != null)) {
            long j = this.d;
            if (j != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j));
            }
            long j2 = this.e;
            if (j2 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j2));
            }
        }
        if (this.m == null) {
            return;
        }
        for (int i = 0; i < this.m.size(); i++) {
            ((d) this.m.get(i)).i(treeSet, z || equals);
        }
    }

    private static SpannableStringBuilder k(String str, Map map) {
        if (!map.containsKey(str)) {
            b.C0042b c0042b = new b.C0042b();
            c0042b.o(new SpannableStringBuilder());
            map.put(str, c0042b);
        }
        return (SpannableStringBuilder) com.google.android.exoplayer2.util.a.e(((b.C0042b) map.get(str)).e());
    }

    private void n(long j, String str, List list) {
        if (!"".equals(this.h)) {
            str = this.h;
        }
        if (m(j) && "div".equals(this.a) && this.i != null) {
            list.add(new Pair(str, this.i));
            return;
        }
        for (int i = 0; i < g(); i++) {
            f(i).n(j, str, list);
        }
    }

    private void o(long j, Map map, Map map2, String str, Map map3) {
        int i;
        if (m(j)) {
            String str2 = "".equals(this.h) ? str : this.h;
            Iterator it = this.l.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                String str3 = (String) entry.getKey();
                int intValue = this.k.containsKey(str3) ? ((Integer) this.k.get(str3)).intValue() : 0;
                int intValue2 = ((Integer) entry.getValue()).intValue();
                if (intValue != intValue2) {
                    b(map, (b.C0042b) com.google.android.exoplayer2.util.a.e((b.C0042b) map3.get(str3)), intValue, intValue2, ((e) com.google.android.exoplayer2.util.a.e((e) map2.get(str2))).j);
                }
            }
            while (i < g()) {
                f(i).o(j, map, map2, str2, map3);
                i++;
            }
        }
    }

    private void p(long j, boolean z, String str, Map map) {
        this.k.clear();
        this.l.clear();
        if ("metadata".equals(this.a)) {
            return;
        }
        if (!"".equals(this.h)) {
            str = this.h;
        }
        if (this.c && z) {
            k(str, map).append((CharSequence) com.google.android.exoplayer2.util.a.e(this.b));
            return;
        }
        if ("br".equals(this.a) && z) {
            k(str, map).append('\n');
            return;
        }
        if (m(j)) {
            for (Map.Entry entry : map.entrySet()) {
                this.k.put((String) entry.getKey(), Integer.valueOf(((CharSequence) com.google.android.exoplayer2.util.a.e(((b.C0042b) entry.getValue()).e())).length()));
            }
            boolean equals = "p".equals(this.a);
            for (int i = 0; i < g(); i++) {
                f(i).p(j, z || equals, str, map);
            }
            if (equals) {
                f.c(k(str, map));
            }
            for (Map.Entry entry2 : map.entrySet()) {
                this.l.put((String) entry2.getKey(), Integer.valueOf(((CharSequence) com.google.android.exoplayer2.util.a.e(((b.C0042b) entry2.getValue()).e())).length()));
            }
        }
    }

    public void a(d dVar) {
        if (this.m == null) {
            this.m = new ArrayList();
        }
        this.m.add(dVar);
    }

    public d f(int i) {
        List list = this.m;
        if (list != null) {
            return (d) list.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public int g() {
        List list = this.m;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List h(long j, Map map, Map map2, Map map3) {
        List<Pair> arrayList = new ArrayList();
        n(j, this.h, arrayList);
        TreeMap treeMap = new TreeMap();
        p(j, false, this.h, treeMap);
        o(j, map, map2, this.h, treeMap);
        ArrayList arrayList2 = new ArrayList();
        for (Pair pair : arrayList) {
            String str = (String) map3.get(pair.second);
            if (str != null) {
                byte[] decode = Base64.decode(str, 0);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                e eVar = (e) com.google.android.exoplayer2.util.a.e((e) map2.get(pair.first));
                arrayList2.add(new b.C0042b().f(decodeByteArray).k(eVar.b).l(0).h(eVar.c, 0).i(eVar.e).n(eVar.f).g(eVar.g).r(eVar.j).a());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            e eVar2 = (e) com.google.android.exoplayer2.util.a.e((e) map2.get(entry.getKey()));
            b.C0042b c0042b = (b.C0042b) entry.getValue();
            e((SpannableStringBuilder) com.google.android.exoplayer2.util.a.e(c0042b.e()));
            c0042b.h(eVar2.c, eVar2.d);
            c0042b.i(eVar2.e);
            c0042b.k(eVar2.b);
            c0042b.n(eVar2.f);
            c0042b.q(eVar2.i, eVar2.h);
            c0042b.r(eVar2.j);
            arrayList2.add(c0042b.a());
        }
        return arrayList2;
    }

    public long[] j() {
        TreeSet treeSet = new TreeSet();
        int i = 0;
        i(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i] = ((Long) it.next()).longValue();
            i++;
        }
        return jArr;
    }

    public String[] l() {
        return this.g;
    }

    public boolean m(long j) {
        long j2 = this.d;
        return (j2 == -9223372036854775807L && this.e == -9223372036854775807L) || (j2 <= j && this.e == -9223372036854775807L) || ((j2 == -9223372036854775807L && j < this.e) || (j2 <= j && j < this.e));
    }
}
