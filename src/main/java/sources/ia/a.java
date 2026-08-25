package ia;

import android.graphics.PointF;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import da.b;
import da.h;
import da.i;
import ia.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class a extends h {
    private static final Pattern t = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");
    private final boolean o;
    private final b p;
    private Map q;
    private float r;
    private float s;

    public a() {
        this(null);
    }

    public a(List list) {
        super("SsaDecoder");
        this.r = -3.4028235E38f;
        this.s = -3.4028235E38f;
        if (list == null || list.isEmpty()) {
            this.o = false;
            this.p = null;
            return;
        }
        this.o = true;
        String D = p0.D((byte[]) list.get(0));
        com.google.android.exoplayer2.util.a.a(D.startsWith("Format:"));
        this.p = (b) com.google.android.exoplayer2.util.a.e(b.a(D));
        C(new d0((byte[]) list.get(1)));
    }

    private void A(String str, b bVar, List list, List list2) {
        int i;
        com.google.android.exoplayer2.util.a.a(str.startsWith("Dialogue:"));
        String[] split = str.substring(9).split(",", bVar.e);
        if (split.length != bVar.e) {
            s.i("SsaDecoder", "Skipping dialogue line with fewer columns than format: " + str);
            return;
        }
        long F = F(split[bVar.a]);
        if (F == -9223372036854775807L) {
            s.i("SsaDecoder", "Skipping invalid timing: " + str);
            return;
        }
        long F2 = F(split[bVar.b]);
        if (F2 == -9223372036854775807L) {
            s.i("SsaDecoder", "Skipping invalid timing: " + str);
            return;
        }
        Map map = this.q;
        c cVar = (map == null || (i = bVar.c) == -1) ? null : (c) map.get(split[i].trim());
        String str2 = split[bVar.d];
        da.b z = z(c.b.d(str2).replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " "), cVar, c.b.b(str2), this.r, this.s);
        int x = x(F2, list2, list);
        for (int x2 = x(F, list2, list); x2 < x; x2++) {
            ((List) list.get(x2)).add(z);
        }
    }

    private void B(d0 d0Var, List list, List list2) {
        b bVar = this.o ? this.p : null;
        while (true) {
            String p = d0Var.p();
            if (p == null) {
                return;
            }
            if (p.startsWith("Format:")) {
                bVar = b.a(p);
            } else if (p.startsWith("Dialogue:")) {
                if (bVar == null) {
                    s.i("SsaDecoder", "Skipping dialogue line before complete format: " + p);
                } else {
                    A(p, bVar, list, list2);
                }
            }
        }
    }

    private void C(d0 d0Var) {
        while (true) {
            String p = d0Var.p();
            if (p == null) {
                return;
            }
            if ("[Script Info]".equalsIgnoreCase(p)) {
                D(d0Var);
            } else if ("[V4+ Styles]".equalsIgnoreCase(p)) {
                this.q = E(d0Var);
            } else if ("[V4 Styles]".equalsIgnoreCase(p)) {
                s.f("SsaDecoder", "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(p)) {
                return;
            }
        }
    }

    private void D(d0 d0Var) {
        while (true) {
            String p = d0Var.p();
            if (p == null) {
                return;
            }
            if (d0Var.a() != 0 && d0Var.h() == 91) {
                return;
            }
            String[] split = p.split(":");
            if (split.length == 2) {
                String e = com.google.common.base.a.e(split[0].trim());
                e.hashCode();
                if (e.equals("playresx")) {
                    this.r = Float.parseFloat(split[1].trim());
                } else if (e.equals("playresy")) {
                    try {
                        this.s = Float.parseFloat(split[1].trim());
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
    }

    private static Map E(d0 d0Var) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        c.a aVar = null;
        while (true) {
            String p = d0Var.p();
            if (p == null || (d0Var.a() != 0 && d0Var.h() == 91)) {
                break;
            }
            if (p.startsWith("Format:")) {
                aVar = c.a.a(p);
            } else if (p.startsWith("Style:")) {
                if (aVar == null) {
                    s.i("SsaDecoder", "Skipping 'Style:' line before 'Format:' line: " + p);
                } else {
                    c b = c.b(p, aVar);
                    if (b != null) {
                        linkedHashMap.put(b.a, b);
                    }
                }
            }
        }
        return linkedHashMap;
    }

    private static long F(String str) {
        Matcher matcher = t.matcher(str.trim());
        if (matcher.matches()) {
            return (Long.parseLong((String) p0.j(matcher.group(1))) * 3600000000L) + (Long.parseLong((String) p0.j(matcher.group(2))) * 60000000) + (Long.parseLong((String) p0.j(matcher.group(3))) * 1000000) + (Long.parseLong((String) p0.j(matcher.group(4))) * 10000);
        }
        return -9223372036854775807L;
    }

    private static int G(int i) {
        switch (i) {
            case -1:
                break;
            case 0:
            default:
                s.i("SsaDecoder", "Unknown alignment: " + i);
                break;
            case 1:
            case 2:
            case 3:
                break;
            case 4:
            case 5:
            case 6:
                break;
            case 7:
            case 8:
            case 9:
                break;
        }
        return Integer.MIN_VALUE;
    }

    private static int H(int i) {
        switch (i) {
            case -1:
                break;
            case 0:
            default:
                s.i("SsaDecoder", "Unknown alignment: " + i);
                break;
            case 1:
            case 4:
            case 7:
                break;
            case 2:
            case 5:
            case 8:
                break;
            case 3:
            case 6:
            case 9:
                break;
        }
        return Integer.MIN_VALUE;
    }

    private static Layout.Alignment I(int i) {
        switch (i) {
            case -1:
                return null;
            case 0:
            default:
                s.i("SsaDecoder", "Unknown alignment: " + i);
                return null;
            case 1:
            case 4:
            case 7:
                return Layout.Alignment.ALIGN_NORMAL;
            case 2:
            case 5:
            case 8:
                return Layout.Alignment.ALIGN_CENTER;
            case 3:
            case 6:
            case 9:
                return Layout.Alignment.ALIGN_OPPOSITE;
        }
    }

    private static int x(long j, List list, List list2) {
        int i;
        int size = list.size() - 1;
        while (true) {
            if (size < 0) {
                i = 0;
                break;
            }
            if (((Long) list.get(size)).longValue() == j) {
                return size;
            }
            if (((Long) list.get(size)).longValue() < j) {
                i = size + 1;
                break;
            }
            size--;
        }
        list.add(i, Long.valueOf(j));
        list2.add(i, i == 0 ? new ArrayList() : new ArrayList((Collection) list2.get(i - 1)));
        return i;
    }

    private static float y(int i) {
        if (i == 0) {
            return 0.05f;
        }
        if (i != 1) {
            return i != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    private static da.b z(String str, c cVar, c.b bVar, float f, float f2) {
        SpannableString spannableString = new SpannableString(str);
        b.C0042b o = new b.C0042b().o(spannableString);
        if (cVar != null) {
            if (cVar.c != null) {
                spannableString.setSpan(new ForegroundColorSpan(cVar.c.intValue()), 0, spannableString.length(), 33);
            }
            if (cVar.j == 3 && cVar.d != null) {
                spannableString.setSpan(new BackgroundColorSpan(cVar.d.intValue()), 0, spannableString.length(), 33);
            }
            float f3 = cVar.e;
            if (f3 != -3.4028235E38f && f2 != -3.4028235E38f) {
                o.q(f3 / f2, 1);
            }
            boolean z = cVar.f;
            if (z && cVar.g) {
                spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
            } else if (z) {
                spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
            } else if (cVar.g) {
                spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
            }
            if (cVar.h) {
                spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 33);
            }
            if (cVar.i) {
                spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
            }
        }
        int i = bVar.a;
        if (i == -1) {
            i = cVar != null ? cVar.b : -1;
        }
        o.p(I(i)).l(H(i)).i(G(i));
        PointF pointF = bVar.b;
        if (pointF == null || f2 == -3.4028235E38f || f == -3.4028235E38f) {
            o.k(y(o.d()));
            o.h(y(o.c()), 0);
        } else {
            o.k(pointF.x / f);
            o.h(bVar.b.y / f2, 0);
        }
        return o.a();
    }

    @Override // da.h
    protected i w(byte[] bArr, int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        d0 d0Var = new d0(bArr, i);
        if (!this.o) {
            C(d0Var);
        }
        B(d0Var, arrayList, arrayList2);
        return new d(arrayList, arrayList2);
    }
}
