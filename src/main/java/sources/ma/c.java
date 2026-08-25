package ma;

import android.text.TextUtils;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class c {
    private static final Pattern c = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    private static final Pattern d = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");
    private final d0 a = new d0();
    private final StringBuilder b = new StringBuilder();

    private void a(d dVar, String str) {
        if ("".equals(str)) {
            return;
        }
        int indexOf = str.indexOf(91);
        if (indexOf != -1) {
            Matcher matcher = c.matcher(str.substring(indexOf));
            if (matcher.matches()) {
                dVar.z((String) com.google.android.exoplayer2.util.a.e(matcher.group(1)));
            }
            str = str.substring(0, indexOf);
        }
        String[] S0 = p0.S0(str, "\\.");
        String str2 = S0[0];
        int indexOf2 = str2.indexOf(35);
        if (indexOf2 != -1) {
            dVar.y(str2.substring(0, indexOf2));
            dVar.x(str2.substring(indexOf2 + 1));
        } else {
            dVar.y(str2);
        }
        if (S0.length > 1) {
            dVar.w((String[]) p0.H0(S0, 1, S0.length));
        }
    }

    private static boolean b(d0 d0Var) {
        int e = d0Var.e();
        int f = d0Var.f();
        byte[] d2 = d0Var.d();
        if (e + 2 > f) {
            return false;
        }
        int i = e + 1;
        if (d2[e] != 47) {
            return false;
        }
        int i2 = e + 2;
        if (d2[i] != 42) {
            return false;
        }
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= f) {
                d0Var.Q(f - d0Var.e());
                return true;
            }
            if (((char) d2[i2]) == '*' && ((char) d2[i3]) == '/') {
                i2 += 2;
                f = i2;
            } else {
                i2 = i3;
            }
        }
    }

    private static boolean c(d0 d0Var) {
        char k = k(d0Var, d0Var.e());
        if (k != '\t' && k != '\n' && k != '\f' && k != '\r' && k != ' ') {
            return false;
        }
        d0Var.Q(1);
        return true;
    }

    private static void e(String str, d dVar) {
        Matcher matcher = d.matcher(com.google.common.base.a.e(str));
        if (!matcher.matches()) {
            s.i("WebvttCssParser", "Invalid font-size: '" + str + "'.");
            return;
        }
        String str2 = (String) com.google.android.exoplayer2.util.a.e(matcher.group(2));
        str2.hashCode();
        switch (str2) {
            case "%":
                dVar.t(3);
                break;
            case "em":
                dVar.t(2);
                break;
            case "px":
                dVar.t(1);
                break;
            default:
                throw new IllegalStateException();
        }
        dVar.s(Float.parseFloat((String) com.google.android.exoplayer2.util.a.e(matcher.group(1))));
    }

    private static String f(d0 d0Var, StringBuilder sb) {
        boolean z = false;
        sb.setLength(0);
        int e = d0Var.e();
        int f = d0Var.f();
        while (e < f && !z) {
            char c2 = (char) d0Var.d()[e];
            if ((c2 < 'A' || c2 > 'Z') && ((c2 < 'a' || c2 > 'z') && !((c2 >= '0' && c2 <= '9') || c2 == '#' || c2 == '-' || c2 == '.' || c2 == '_'))) {
                z = true;
            } else {
                e++;
                sb.append(c2);
            }
        }
        d0Var.Q(e - d0Var.e());
        return sb.toString();
    }

    static String g(d0 d0Var, StringBuilder sb) {
        n(d0Var);
        if (d0Var.a() == 0) {
            return null;
        }
        String f = f(d0Var, sb);
        if (!"".equals(f)) {
            return f;
        }
        return "" + ((char) d0Var.D());
    }

    private static String h(d0 d0Var, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder();
        boolean z = false;
        while (!z) {
            int e = d0Var.e();
            String g = g(d0Var, sb);
            if (g == null) {
                return null;
            }
            if ("}".equals(g) || ";".equals(g)) {
                d0Var.P(e);
                z = true;
            } else {
                sb2.append(g);
            }
        }
        return sb2.toString();
    }

    private static String i(d0 d0Var, StringBuilder sb) {
        n(d0Var);
        if (d0Var.a() < 5 || !"::cue".equals(d0Var.A(5))) {
            return null;
        }
        int e = d0Var.e();
        String g = g(d0Var, sb);
        if (g == null) {
            return null;
        }
        if ("{".equals(g)) {
            d0Var.P(e);
            return "";
        }
        String l = "(".equals(g) ? l(d0Var) : null;
        if (")".equals(g(d0Var, sb))) {
            return l;
        }
        return null;
    }

    private static void j(d0 d0Var, d dVar, StringBuilder sb) {
        n(d0Var);
        String f = f(d0Var, sb);
        if (!"".equals(f) && ":".equals(g(d0Var, sb))) {
            n(d0Var);
            String h = h(d0Var, sb);
            if (h == null || "".equals(h)) {
                return;
            }
            int e = d0Var.e();
            String g = g(d0Var, sb);
            if (!";".equals(g)) {
                if (!"}".equals(g)) {
                    return;
                } else {
                    d0Var.P(e);
                }
            }
            if ("color".equals(f)) {
                dVar.q(com.google.android.exoplayer2.util.g.b(h));
                return;
            }
            if ("background-color".equals(f)) {
                dVar.n(com.google.android.exoplayer2.util.g.b(h));
                return;
            }
            boolean z = true;
            if ("ruby-position".equals(f)) {
                if ("over".equals(h)) {
                    dVar.v(1);
                    return;
                } else {
                    if ("under".equals(h)) {
                        dVar.v(2);
                        return;
                    }
                    return;
                }
            }
            if ("text-combine-upright".equals(f)) {
                if (!"all".equals(h) && !h.startsWith("digits")) {
                    z = false;
                }
                dVar.p(z);
                return;
            }
            if ("text-decoration".equals(f)) {
                if ("underline".equals(h)) {
                    dVar.A(true);
                    return;
                }
                return;
            }
            if ("font-family".equals(f)) {
                dVar.r(h);
                return;
            }
            if ("font-weight".equals(f)) {
                if ("bold".equals(h)) {
                    dVar.o(true);
                }
            } else if ("font-style".equals(f)) {
                if ("italic".equals(h)) {
                    dVar.u(true);
                }
            } else if ("font-size".equals(f)) {
                e(h, dVar);
            }
        }
    }

    private static char k(d0 d0Var, int i) {
        return (char) d0Var.d()[i];
    }

    private static String l(d0 d0Var) {
        int e = d0Var.e();
        int f = d0Var.f();
        boolean z = false;
        while (e < f && !z) {
            int i = e + 1;
            z = ((char) d0Var.d()[e]) == ')';
            e = i;
        }
        return d0Var.A((e - 1) - d0Var.e()).trim();
    }

    static void m(d0 d0Var) {
        while (!TextUtils.isEmpty(d0Var.p())) {
        }
    }

    static void n(d0 d0Var) {
        while (true) {
            for (boolean z = true; d0Var.a() > 0 && z; z = false) {
                if (!c(d0Var) && !b(d0Var)) {
                }
            }
            return;
        }
    }

    public List d(d0 d0Var) {
        this.b.setLength(0);
        int e = d0Var.e();
        m(d0Var);
        this.a.N(d0Var.d(), d0Var.e());
        this.a.P(e);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String i = i(this.a, this.b);
            if (i == null || !"{".equals(g(this.a, this.b))) {
                return arrayList;
            }
            d dVar = new d();
            a(dVar, i);
            String str = null;
            boolean z = false;
            while (!z) {
                int e2 = this.a.e();
                String g = g(this.a, this.b);
                boolean z2 = g == null || "}".equals(g);
                if (!z2) {
                    this.a.P(e2);
                    j(this.a, dVar, this.b);
                }
                str = g;
                z = z2;
            }
            if ("}".equals(str)) {
                arrayList.add(dVar);
            }
        }
    }
}
