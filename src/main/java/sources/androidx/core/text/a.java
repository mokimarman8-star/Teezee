package androidx.core.text;

import android.text.SpannableStringBuilder;
import java.util.Locale;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    static final s f7093d;

    /* renamed from: e, reason: collision with root package name */
    private static final String f7094e;

    /* renamed from: f, reason: collision with root package name */
    private static final String f7095f;

    /* renamed from: g, reason: collision with root package name */
    static final a f7096g;

    /* renamed from: h, reason: collision with root package name */
    static final a f7097h;

    /* renamed from: a, reason: collision with root package name */
    private final boolean f7098a;

    /* renamed from: b, reason: collision with root package name */
    private final int f7099b;

    /* renamed from: c, reason: collision with root package name */
    private final s f7100c;

    /* renamed from: androidx.core.text.a$a, reason: collision with other inner class name */
    public static final class C0050a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f7101a;

        /* renamed from: b, reason: collision with root package name */
        private int f7102b;

        /* renamed from: c, reason: collision with root package name */
        private s f7103c;

        public C0050a() {
            c(a.g(Locale.getDefault()));
        }

        private static a b(boolean z5) {
            return z5 ? a.f7097h : a.f7096g;
        }

        private void c(boolean z5) {
            this.f7101a = z5;
            this.f7103c = a.f7093d;
            this.f7102b = 2;
        }

        public a a() {
            return (this.f7102b == 2 && this.f7103c == a.f7093d) ? b(this.f7101a) : new a(this.f7101a, this.f7102b, this.f7103c);
        }
    }

    private static class b {

        /* renamed from: f, reason: collision with root package name */
        private static final byte[] f7104f = new byte[1792];

        /* renamed from: a, reason: collision with root package name */
        private final CharSequence f7105a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f7106b;

        /* renamed from: c, reason: collision with root package name */
        private final int f7107c;

        /* renamed from: d, reason: collision with root package name */
        private int f7108d;

        /* renamed from: e, reason: collision with root package name */
        private char f7109e;

        static {
            for (int i5 = 0; i5 < 1792; i5++) {
                f7104f[i5] = Character.getDirectionality(i5);
            }
        }

        b(CharSequence charSequence, boolean z5) {
            this.f7105a = charSequence;
            this.f7106b = z5;
            this.f7107c = charSequence.length();
        }

        private static byte c(char c5) {
            return c5 < 1792 ? f7104f[c5] : Character.getDirectionality(c5);
        }

        private byte f() {
            char charAt;
            int i5 = this.f7108d;
            do {
                int i6 = this.f7108d;
                if (i6 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f7105a;
                int i7 = i6 - 1;
                this.f7108d = i7;
                charAt = charSequence.charAt(i7);
                this.f7109e = charAt;
                if (charAt == '&') {
                    return (byte) 12;
                }
            } while (charAt != ';');
            this.f7108d = i5;
            this.f7109e = ';';
            return (byte) 13;
        }

        private byte g() {
            char charAt;
            do {
                int i5 = this.f7108d;
                if (i5 >= this.f7107c) {
                    return (byte) 12;
                }
                CharSequence charSequence = this.f7105a;
                this.f7108d = i5 + 1;
                charAt = charSequence.charAt(i5);
                this.f7109e = charAt;
            } while (charAt != ';');
            return (byte) 12;
        }

        private byte h() {
            char charAt;
            int i5 = this.f7108d;
            while (true) {
                int i6 = this.f7108d;
                if (i6 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f7105a;
                int i7 = i6 - 1;
                this.f7108d = i7;
                char charAt2 = charSequence.charAt(i7);
                this.f7109e = charAt2;
                if (charAt2 == '<') {
                    return (byte) 12;
                }
                if (charAt2 == '>') {
                    break;
                }
                if (charAt2 == '\"' || charAt2 == '\'') {
                    do {
                        int i8 = this.f7108d;
                        if (i8 > 0) {
                            CharSequence charSequence2 = this.f7105a;
                            int i9 = i8 - 1;
                            this.f7108d = i9;
                            charAt = charSequence2.charAt(i9);
                            this.f7109e = charAt;
                        }
                    } while (charAt != charAt2);
                }
            }
            this.f7108d = i5;
            this.f7109e = '>';
            return (byte) 13;
        }

        private byte i() {
            char charAt;
            int i5 = this.f7108d;
            while (true) {
                int i6 = this.f7108d;
                if (i6 >= this.f7107c) {
                    this.f7108d = i5;
                    this.f7109e = '<';
                    return (byte) 13;
                }
                CharSequence charSequence = this.f7105a;
                this.f7108d = i6 + 1;
                char charAt2 = charSequence.charAt(i6);
                this.f7109e = charAt2;
                if (charAt2 == '>') {
                    return (byte) 12;
                }
                if (charAt2 == '\"' || charAt2 == '\'') {
                    do {
                        int i7 = this.f7108d;
                        if (i7 < this.f7107c) {
                            CharSequence charSequence2 = this.f7105a;
                            this.f7108d = i7 + 1;
                            charAt = charSequence2.charAt(i7);
                            this.f7109e = charAt;
                        }
                    } while (charAt != charAt2);
                }
            }
        }

        byte a() {
            char charAt = this.f7105a.charAt(this.f7108d - 1);
            this.f7109e = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.f7105a, this.f7108d);
                this.f7108d -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.f7108d--;
            byte c5 = c(this.f7109e);
            if (!this.f7106b) {
                return c5;
            }
            char c6 = this.f7109e;
            return c6 == '>' ? h() : c6 == ';' ? f() : c5;
        }

        byte b() {
            char charAt = this.f7105a.charAt(this.f7108d);
            this.f7109e = charAt;
            if (Character.isHighSurrogate(charAt)) {
                int codePointAt = Character.codePointAt(this.f7105a, this.f7108d);
                this.f7108d += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.f7108d++;
            byte c5 = c(this.f7109e);
            if (!this.f7106b) {
                return c5;
            }
            char c6 = this.f7109e;
            return c6 == '<' ? i() : c6 == '&' ? g() : c5;
        }

        int d() {
            this.f7108d = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (this.f7108d < this.f7107c && i5 == 0) {
                byte b5 = b();
                if (b5 != 0) {
                    if (b5 == 1 || b5 == 2) {
                        if (i7 == 0) {
                            return 1;
                        }
                    } else if (b5 != 9) {
                        switch (b5) {
                            case 14:
                            case 15:
                                i7++;
                                i6 = -1;
                                continue;
                            case 16:
                            case 17:
                                i7++;
                                i6 = 1;
                                continue;
                            case 18:
                                i7--;
                                i6 = 0;
                                continue;
                        }
                    }
                } else if (i7 == 0) {
                    return -1;
                }
                i5 = i7;
            }
            if (i5 == 0) {
                return 0;
            }
            if (i6 != 0) {
                return i6;
            }
            while (this.f7108d > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i5 == i7) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i5 == i7) {
                            return 1;
                        }
                        break;
                    case 18:
                        i7++;
                        continue;
                }
                i7--;
            }
            return 0;
        }

        int e() {
            this.f7108d = this.f7107c;
            int i5 = 0;
            while (true) {
                int i6 = i5;
                while (this.f7108d > 0) {
                    byte a5 = a();
                    if (a5 != 0) {
                        if (a5 == 1 || a5 == 2) {
                            if (i5 == 0) {
                                return 1;
                            }
                            if (i6 == 0) {
                                break;
                            }
                        } else if (a5 != 9) {
                            switch (a5) {
                                case 14:
                                case 15:
                                    if (i6 == i5) {
                                        return -1;
                                    }
                                    i5--;
                                    break;
                                case 16:
                                case 17:
                                    if (i6 == i5) {
                                        return 1;
                                    }
                                    i5--;
                                    break;
                                case 18:
                                    i5++;
                                    break;
                                default:
                                    if (i6 != 0) {
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                        } else {
                            continue;
                        }
                    } else {
                        if (i5 == 0) {
                            return -1;
                        }
                        if (i6 == 0) {
                            break;
                        }
                    }
                }
                return 0;
            }
        }
    }

    static {
        s sVar = t.f7112c;
        f7093d = sVar;
        f7094e = Character.toString((char) 8206);
        f7095f = Character.toString((char) 8207);
        f7096g = new a(false, 2, sVar);
        f7097h = new a(true, 2, sVar);
    }

    a(boolean z5, int i5, s sVar) {
        this.f7098a = z5;
        this.f7099b = i5;
        this.f7100c = sVar;
    }

    private static int a(CharSequence charSequence) {
        return new b(charSequence, false).d();
    }

    private static int b(CharSequence charSequence) {
        return new b(charSequence, false).e();
    }

    public static a c() {
        return new C0050a().a();
    }

    static boolean g(Locale locale) {
        return u.a(locale) == 1;
    }

    private String h(CharSequence charSequence, s sVar) {
        boolean a5 = sVar.a(charSequence, 0, charSequence.length());
        return (this.f7098a || !(a5 || b(charSequence) == 1)) ? this.f7098a ? (!a5 || b(charSequence) == -1) ? f7095f : "" : "" : f7094e;
    }

    private String i(CharSequence charSequence, s sVar) {
        boolean a5 = sVar.a(charSequence, 0, charSequence.length());
        return (this.f7098a || !(a5 || a(charSequence) == 1)) ? this.f7098a ? (!a5 || a(charSequence) == -1) ? f7095f : "" : "" : f7094e;
    }

    public boolean d() {
        return (this.f7099b & 2) != 0;
    }

    public boolean e(CharSequence charSequence) {
        return this.f7100c.a(charSequence, 0, charSequence.length());
    }

    public boolean f(String str) {
        return e(str);
    }

    public CharSequence j(CharSequence charSequence) {
        return k(charSequence, this.f7100c, true);
    }

    public CharSequence k(CharSequence charSequence, s sVar, boolean z5) {
        if (charSequence == null) {
            return null;
        }
        boolean a5 = sVar.a(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (d() && z5) {
            spannableStringBuilder.append((CharSequence) i(charSequence, a5 ? t.f7111b : t.f7110a));
        }
        if (a5 != this.f7098a) {
            spannableStringBuilder.append(a5 ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z5) {
            spannableStringBuilder.append((CharSequence) h(charSequence, a5 ? t.f7111b : t.f7110a));
        }
        return spannableStringBuilder;
    }

    public String l(String str) {
        return n(str, this.f7100c, true);
    }

    public String m(String str, s sVar) {
        return n(str, sVar, true);
    }

    public String n(String str, s sVar, boolean z5) {
        if (str == null) {
            return null;
        }
        return k(str, sVar, z5).toString();
    }
}
