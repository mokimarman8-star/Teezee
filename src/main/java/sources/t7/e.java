package t7;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class e implements t7.d, t7.c {
    private static final Pattern c = Pattern.compile("\\{([^{}]*)\\}");
    private String a;
    private List b;

    static class a extends d {
        String c;
        private ThreadLocal d;

        /* renamed from: t7.e$a$a, reason: collision with other inner class name */
        class C0066a extends ThreadLocal {
            C0066a() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SimpleDateFormat initialValue() {
                return new SimpleDateFormat(a.this.c, Locale.US);
            }
        }

        a(String str, String str2, String str3) {
            super(str, str2);
            C0066a c0066a = new C0066a();
            this.d = c0066a;
            this.c = str3;
            try {
                ((SimpleDateFormat) c0066a.get()).format(new Date());
            } catch (Exception e) {
                throw new IllegalArgumentException("Bad date pattern: " + str3, e);
            }
        }

        @Override // t7.e.d
        protected String a(String str, long j, int i, String str2, String str3) {
            return str.replace(this.a, ((SimpleDateFormat) this.d.get()).format(new Date(j)));
        }
    }

    static class b extends d {
        boolean c;

        b(String str, String str2, boolean z) {
            super(str, str2);
            this.c = z;
        }

        @Override // t7.e.d
        protected String a(String str, long j, int i, String str2, String str3) {
            return this.c ? str.replace(this.a, s7.c.a(i)) : str.replace(this.a, s7.c.b(i));
        }
    }

    static class c extends d {
        c(String str, String str2) {
            super(str, str2);
        }

        @Override // t7.e.d
        protected String a(String str, long j, int i, String str2, String str3) {
            return str.replace(this.a, str3);
        }
    }

    static abstract class d {
        String a;
        String b;

        d(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        protected abstract String a(String str, long j, int i, String str2, String str3);
    }

    /* renamed from: t7.e$e, reason: collision with other inner class name */
    static class C0067e extends d {
        C0067e(String str, String str2) {
            super(str, str2);
        }

        @Override // t7.e.d
        protected String a(String str, long j, int i, String str2, String str3) {
            return str.replace(this.a, str2);
        }
    }

    public e(String str) {
        if (str == null) {
            throw new NullPointerException("Pattern should not be null");
        }
        this.a = str;
        List g = g(h(str));
        this.b = g;
        if (g.size() != 0) {
            return;
        }
        throw new IllegalArgumentException("No recognizable parameter found in the pattern " + str);
    }

    static a c(String str, String str2) {
        if (str2.startsWith("d ") && str2.length() > 2) {
            return new a(str, str2, str2.substring(2));
        }
        if (str2.equals("d")) {
            return new a(str, str2, "yyyy-MM-dd HH:mm:ss.SSS");
        }
        return null;
    }

    static b d(String str, String str2) {
        if (str2.equals("l")) {
            return new b(str, str2, false);
        }
        if (str2.equals("L")) {
            return new b(str, str2, true);
        }
        return null;
    }

    static c e(String str, String str2) {
        if (str2.equals("m")) {
            return new c(str, str2);
        }
        return null;
    }

    private static d f(String str) {
        String str2 = "{" + str + "}";
        String trim = str.trim();
        a c2 = c(str2, trim);
        if (c2 != null) {
            return c2;
        }
        b d2 = d(str2, trim);
        if (d2 != null) {
            return d2;
        }
        C0067e i = i(str2, trim);
        if (i != null) {
            return i;
        }
        c e = e(str2, trim);
        if (e != null) {
            return e;
        }
        return null;
    }

    private static List g(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            d f = f((String) it.next());
            if (f != null) {
                arrayList.add(f);
            }
        }
        return arrayList;
    }

    static List h(String str) {
        ArrayList arrayList = new ArrayList(4);
        Matcher matcher = c.matcher(str);
        while (matcher.find()) {
            arrayList.add(matcher.group(1));
        }
        return arrayList;
    }

    static C0067e i(String str, String str2) {
        if (str2.equals("t")) {
            return new C0067e(str, str2);
        }
        return null;
    }

    @Override // t7.c
    public CharSequence a(long j, int i, String str, String str2) {
        String str3 = this.a;
        Iterator it = this.b.iterator();
        String str4 = str3;
        while (it.hasNext()) {
            str4 = ((d) it.next()).a(str4, j, i, str, str2);
        }
        return str4;
    }

    @Override // t7.d
    public CharSequence b(int i, String str, String str2) {
        return a(System.currentTimeMillis(), i, str, str2);
    }
}
