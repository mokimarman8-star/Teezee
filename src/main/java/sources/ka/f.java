package ka;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import java.util.ArrayDeque;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
abstract class f {
    public static void a(Spannable spannable, int i, int i2, g gVar, d dVar, Map map, int i3) {
        d e;
        g f;
        int i4;
        if (gVar.l() != -1) {
            spannable.setSpan(new StyleSpan(gVar.l()), i, i2, 33);
        }
        if (gVar.s()) {
            spannable.setSpan(new StrikethroughSpan(), i, i2, 33);
        }
        if (gVar.t()) {
            spannable.setSpan(new UnderlineSpan(), i, i2, 33);
        }
        if (gVar.q()) {
            ha.d.a(spannable, new ForegroundColorSpan(gVar.c()), i, i2, 33);
        }
        if (gVar.p()) {
            ha.d.a(spannable, new BackgroundColorSpan(gVar.b()), i, i2, 33);
        }
        if (gVar.d() != null) {
            ha.d.a(spannable, new TypefaceSpan(gVar.d()), i, i2, 33);
        }
        if (gVar.o() != null) {
            b bVar = (b) com.google.android.exoplayer2.util.a.e(gVar.o());
            int i5 = bVar.a;
            if (i5 == -1) {
                i5 = (i3 == 2 || i3 == 1) ? 3 : 1;
                i4 = 1;
            } else {
                i4 = bVar.b;
            }
            int i6 = bVar.c;
            if (i6 == -2) {
                i6 = 1;
            }
            ha.d.a(spannable, new ha.e(i5, i4, i6), i, i2, 33);
        }
        int j = gVar.j();
        if (j == 2) {
            d d = d(dVar, map);
            if (d != null && (e = e(d, map)) != null) {
                if (e.g() != 1 || e.f(0).b == null) {
                    s.f("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
                } else {
                    String str = (String) p0.j(e.f(0).b);
                    g f2 = f(e.f, e.l(), map);
                    int i7 = f2 != null ? f2.i() : -1;
                    if (i7 == -1 && (f = f(d.f, d.l(), map)) != null) {
                        i7 = f.i();
                    }
                    spannable.setSpan(new ha.c(str, i7), i, i2, 33);
                }
            }
        } else if (j == 3 || j == 4) {
            spannable.setSpan(new a(), i, i2, 33);
        }
        if (gVar.n()) {
            ha.d.a(spannable, new ha.a(), i, i2, 33);
        }
        int f3 = gVar.f();
        if (f3 == 1) {
            ha.d.a(spannable, new AbsoluteSizeSpan((int) gVar.e(), true), i, i2, 33);
        } else if (f3 == 2) {
            ha.d.a(spannable, new RelativeSizeSpan(gVar.e()), i, i2, 33);
        } else {
            if (f3 != 3) {
                return;
            }
            ha.d.a(spannable, new RelativeSizeSpan(gVar.e() / 100.0f), i, i2, 33);
        }
    }

    static String b(String str) {
        return str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " ");
    }

    static void c(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length() - 1;
        while (length >= 0 && spannableStringBuilder.charAt(length) == ' ') {
            length--;
        }
        if (length < 0 || spannableStringBuilder.charAt(length) == '\n') {
            return;
        }
        spannableStringBuilder.append('\n');
    }

    private static d d(d dVar, Map map) {
        while (dVar != null) {
            g f = f(dVar.f, dVar.l(), map);
            if (f != null && f.j() == 1) {
                return dVar;
            }
            dVar = dVar.j;
        }
        return null;
    }

    private static d e(d dVar, Map map) {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(dVar);
        while (!arrayDeque.isEmpty()) {
            d dVar2 = (d) arrayDeque.pop();
            g f = f(dVar2.f, dVar2.l(), map);
            if (f != null && f.j() == 3) {
                return dVar2;
            }
            for (int g = dVar2.g() - 1; g >= 0; g--) {
                arrayDeque.push(dVar2.f(g));
            }
        }
        return null;
    }

    public static g f(g gVar, String[] strArr, Map map) {
        int i = 0;
        if (gVar == null) {
            if (strArr == null) {
                return null;
            }
            if (strArr.length == 1) {
                return (g) map.get(strArr[0]);
            }
            if (strArr.length > 1) {
                g gVar2 = new g();
                int length = strArr.length;
                while (i < length) {
                    gVar2.a((g) map.get(strArr[i]));
                    i++;
                }
                return gVar2;
            }
        } else {
            if (strArr != null && strArr.length == 1) {
                return gVar.a((g) map.get(strArr[0]));
            }
            if (strArr != null && strArr.length > 1) {
                int length2 = strArr.length;
                while (i < length2) {
                    gVar.a((g) map.get(strArr[i]));
                    i++;
                }
            }
        }
        return gVar;
    }
}
