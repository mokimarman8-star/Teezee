package com.google.common.base;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class b implements n {

    private static final class a extends e {
        static final b b = new a();

        a() {
            super("CharMatcher.ascii()");
        }

        @Override // com.google.common.base.b
        public boolean g(char c) {
            return c <= 127;
        }
    }

    /* renamed from: com.google.common.base.b$b, reason: collision with other inner class name */
    static abstract class AbstractC0003b extends b {
        AbstractC0003b() {
        }

        @Override // com.google.common.base.n
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.b((Character) obj);
        }
    }

    private static final class c extends AbstractC0003b {
        private final char a;
        private final char b;

        c(char c, char c2) {
            m.d(c2 >= c);
            this.a = c;
            this.b = c2;
        }

        @Override // com.google.common.base.b
        public boolean g(char c) {
            return this.a <= c && c <= this.b;
        }

        public String toString() {
            return "CharMatcher.inRange('" + b.j(this.a) + "', '" + b.j(this.b) + "')";
        }
    }

    private static final class d extends AbstractC0003b {
        private final char a;

        d(char c) {
            this.a = c;
        }

        @Override // com.google.common.base.b
        public boolean g(char c) {
            return c == this.a;
        }

        public String toString() {
            return "CharMatcher.is('" + b.j(this.a) + "')";
        }
    }

    static abstract class e extends AbstractC0003b {
        private final String a;

        e(String str) {
            this.a = (String) m.o(str);
        }

        public final String toString() {
            return this.a;
        }
    }

    private static final class f extends e {
        static final b b = new f();

        private f() {
            super("CharMatcher.none()");
        }

        @Override // com.google.common.base.b
        public int e(CharSequence charSequence, int i) {
            m.r(i, charSequence.length());
            return -1;
        }

        @Override // com.google.common.base.b
        public boolean g(char c) {
            return false;
        }

        @Override // com.google.common.base.b
        public boolean h(CharSequence charSequence) {
            return charSequence.length() == 0;
        }
    }

    static final class g extends e {
        static final int b = Integer.numberOfLeadingZeros(31);
        static final b c = new g();

        g() {
            super("CharMatcher.whitespace()");
        }

        @Override // com.google.common.base.b
        public boolean g(char c2) {
            return "\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001  \f\u2009\u3000\u2004\u3000\u3000\u2028\n \u3000".charAt((48906 * c2) >>> b) == c2;
        }
    }

    protected b() {
    }

    public static b c() {
        return a.b;
    }

    public static b d(char c2, char c3) {
        return new c(c2, c3);
    }

    public static b f(char c2) {
        return new d(c2);
    }

    public static b i() {
        return f.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String j(char c2) {
        char[] cArr = new char[6];
        cArr[0] = '\\';
        cArr[1] = 'u';
        cArr[2] = 0;
        cArr[3] = 0;
        cArr[4] = 0;
        cArr[5] = 0;
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = "0123456789ABCDEF".charAt(c2 & 15);
            c2 = (char) (c2 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    public static b k() {
        return g.c;
    }

    public boolean b(Character ch) {
        return g(ch.charValue());
    }

    public int e(CharSequence charSequence, int i) {
        int length = charSequence.length();
        m.r(i, length);
        while (i < length) {
            if (g(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public abstract boolean g(char c2);

    public boolean h(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!g(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }
}
