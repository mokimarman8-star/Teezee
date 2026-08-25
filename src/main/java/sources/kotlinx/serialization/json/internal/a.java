package kotlinx.serialization.json.internal;

import java.util.ArrayList;
import kotlin.KotlinNothingValueException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class a {
    protected int a;
    private String c;
    public final x b = new x();
    private StringBuilder d = new StringBuilder();

    private final int B(CharSequence charSequence, int i) {
        char charAt = charSequence.charAt(i);
        if ('0' <= charAt && charAt < ':') {
            return charAt - '0';
        }
        if ('a' <= charAt && charAt < 'g') {
            return charAt - 'W';
        }
        if ('A' <= charAt && charAt < 'G') {
            return charAt - '7';
        }
        y(this, "Invalid toHexChar char '" + charAt + "' in unicode escape", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private final String K() {
        String str = this.c;
        Intrinsics.e(str);
        this.c = null;
        return str;
    }

    private final boolean O() {
        return C().charAt(this.a - 1) != '\"';
    }

    private final int b(int i) {
        int G = G(i);
        if (G == -1) {
            y(this, "Expected escape sequence to continue, got EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        int i2 = G + 1;
        char charAt = C().charAt(G);
        if (charAt == 'u') {
            return d(C(), i2);
        }
        char b = b.b(charAt);
        if (b != 0) {
            this.d.append(b);
            return i2;
        }
        y(this, "Invalid escaped char '" + charAt + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private final int c(int i, int i2) {
        e(i, i2);
        return b(i2 + 1);
    }

    private final int d(CharSequence charSequence, int i) {
        int i2 = i + 4;
        if (i2 < charSequence.length()) {
            this.d.append((char) ((B(charSequence, i) << 12) + (B(charSequence, i + 1) << 8) + (B(charSequence, i + 2) << 4) + B(charSequence, i + 3)));
            return i2;
        }
        this.a = i;
        v();
        if (this.a + 4 < charSequence.length()) {
            return d(charSequence, this.a);
        }
        y(this, "Unexpected EOF during unicode escape", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private final boolean h(int i) {
        int G = G(i);
        if (G >= C().length() || G == -1) {
            y(this, "EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        int i2 = G + 1;
        int charAt = C().charAt(G) | ' ';
        if (charAt == 102) {
            j("alse", i2);
            return false;
        }
        if (charAt == 116) {
            j("rue", i2);
            return true;
        }
        y(this, "Expected valid boolean literal prefix, but had '" + s() + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private final void j(String str, int i) {
        if (C().length() - i < str.length()) {
            y(this, "Unexpected end of boolean literal", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (str.charAt(i2) != (C().charAt(i + i2) | ' ')) {
                y(this, "Expected valid boolean literal prefix, but had '" + s() + '\'', 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
        }
        this.a = i + str.length();
    }

    private final String u(int i, int i2) {
        e(i, i2);
        String sb = this.d.toString();
        Intrinsics.g(sb, "escapedString.toString()");
        this.d.setLength(0);
        return sb;
    }

    public static /* synthetic */ Void y(a aVar, String str, int i, String str2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
        }
        if ((i2 & 2) != 0) {
            i = aVar.a;
        }
        if ((i2 & 4) != 0) {
            str2 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        return aVar.x(str, i, str2);
    }

    public final void A(String key) {
        Intrinsics.h(key, "key");
        x("Encountered an unknown key '" + key + '\'', StringsKt.v0(J(0, this.a), key, 0, false, 6, null), "Use 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.");
        throw new KotlinNothingValueException();
    }

    protected abstract CharSequence C();

    protected final boolean D(char c) {
        return !(c == '}' || c == ']' || c == ':' || c == ',');
    }

    public final byte E() {
        CharSequence C = C();
        int i = this.a;
        while (true) {
            int G = G(i);
            if (G == -1) {
                this.a = G;
                return (byte) 10;
            }
            char charAt = C.charAt(G);
            if (charAt != ' ' && charAt != '\n' && charAt != '\r' && charAt != '\t') {
                this.a = G;
                return b.a(charAt);
            }
            i = G + 1;
        }
    }

    public final String F(boolean z) {
        String q;
        byte E = E();
        if (z) {
            if (E != 1 && E != 0) {
                return null;
            }
            q = s();
        } else {
            if (E != 1) {
                return null;
            }
            q = q();
        }
        this.c = q;
        return q;
    }

    public abstract int G(int i);

    public final void H(boolean z) {
        ArrayList arrayList = new ArrayList();
        byte E = E();
        if (E != 8 && E != 6) {
            s();
            return;
        }
        while (true) {
            byte E2 = E();
            if (E2 != 1) {
                if (E2 == 8 || E2 == 6) {
                    arrayList.add(Byte.valueOf(E2));
                } else if (E2 == 9) {
                    if (((Number) CollectionsKt.u0(arrayList)).byteValue() != 8) {
                        throw w.f(this.a, "found ] instead of } at path: " + this.b, C());
                    }
                    CollectionsKt.L(arrayList);
                } else if (E2 == 7) {
                    if (((Number) CollectionsKt.u0(arrayList)).byteValue() != 6) {
                        throw w.f(this.a, "found } instead of ] at path: " + this.b, C());
                    }
                    CollectionsKt.L(arrayList);
                } else if (E2 == 10) {
                    y(this, "Unexpected end of input due to malformed JSON during ignoring unknown keys", 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
                m();
                if (arrayList.size() == 0) {
                    return;
                }
            } else if (z) {
                s();
            } else {
                k();
            }
        }
    }

    public int I() {
        int G;
        char charAt;
        int i = this.a;
        while (true) {
            G = G(i);
            if (G == -1 || !((charAt = C().charAt(G)) == ' ' || charAt == '\n' || charAt == '\r' || charAt == '\t')) {
                break;
            }
            i = G + 1;
        }
        this.a = G;
        return G;
    }

    public String J(int i, int i2) {
        return C().subSequence(i, i2).toString();
    }

    public abstract boolean L();

    public final boolean M() {
        int G = G(I());
        int length = C().length() - G;
        if (length < 4 || G == -1) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            if ("null".charAt(i) != C().charAt(G + i)) {
                return true;
            }
        }
        if (length > 4 && b.a(C().charAt(G + 4)) == 0) {
            return true;
        }
        this.a = G + 4;
        return false;
    }

    protected final void N(char c) {
        int i = this.a - 1;
        this.a = i;
        if (i >= 0 && c == '\"' && Intrinsics.c(s(), "null")) {
            x("Expected string literal but 'null' literal was found", this.a - 4, "Use 'coerceInputValues = true' in 'Json {}` builder to coerce nulls to default values.");
            throw new KotlinNothingValueException();
        }
        z(b.a(c));
        throw new KotlinNothingValueException();
    }

    protected void e(int i, int i2) {
        this.d.append(C(), i, i2);
    }

    public abstract boolean f();

    public final boolean g() {
        return h(I());
    }

    public final boolean i() {
        boolean z;
        int I = I();
        if (I == C().length()) {
            y(this, "EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        if (C().charAt(I) == '\"') {
            I++;
            z = true;
        } else {
            z = false;
        }
        boolean h = h(I);
        if (z) {
            if (this.a == C().length()) {
                y(this, "EOF", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
            if (C().charAt(this.a) != '\"') {
                y(this, "Expected closing quotation mark", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
            this.a++;
        }
        return h;
    }

    public abstract String k();

    public abstract String l(String str, boolean z);

    public abstract byte m();

    public final byte n(byte b) {
        byte m = m();
        if (m == b) {
            return m;
        }
        z(b);
        throw new KotlinNothingValueException();
    }

    public void o(char c) {
        v();
        CharSequence C = C();
        int i = this.a;
        while (true) {
            int G = G(i);
            if (G == -1) {
                this.a = G;
                N(c);
                return;
            }
            int i2 = G + 1;
            char charAt = C.charAt(G);
            if (charAt != ' ' && charAt != '\n' && charAt != '\r' && charAt != '\t') {
                this.a = i2;
                if (charAt == c) {
                    return;
                } else {
                    N(c);
                }
            }
            i = i2;
        }
    }

    public final long p() {
        boolean z;
        int G = G(I());
        if (G >= C().length() || G == -1) {
            y(this, "EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        if (C().charAt(G) == '\"') {
            G++;
            if (G == C().length()) {
                y(this, "EOF", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
            z = true;
        } else {
            z = false;
        }
        int i = G;
        long j = 0;
        boolean z2 = true;
        boolean z3 = false;
        while (z2) {
            char charAt = C().charAt(i);
            if (charAt != '-') {
                if (b.a(charAt) != 0) {
                    break;
                }
                i++;
                z2 = i != C().length();
                int i2 = charAt - '0';
                if (i2 < 0 || i2 >= 10) {
                    y(this, "Unexpected symbol '" + charAt + "' in numeric literal", 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
                j = (j * 10) - i2;
                if (j > 0) {
                    y(this, "Numeric value overflow", 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
            } else {
                if (i != G) {
                    y(this, "Unexpected symbol '-' in numeric literal", 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
                i++;
                z3 = true;
            }
        }
        if (G == i || (z3 && G == i - 1)) {
            y(this, "Expected numeric literal", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        if (z) {
            if (!z2) {
                y(this, "EOF", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
            if (C().charAt(i) != '\"') {
                y(this, "Expected closing quotation mark", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
            i++;
        }
        this.a = i;
        if (z3) {
            return j;
        }
        if (j != Long.MIN_VALUE) {
            return -j;
        }
        y(this, "Numeric value overflow", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    public final String q() {
        return this.c != null ? K() : k();
    }

    protected final String r(CharSequence source, int i, int i2) {
        int G;
        Intrinsics.h(source, "source");
        char charAt = source.charAt(i2);
        boolean z = false;
        while (charAt != '\"') {
            if (charAt == '\\') {
                G = G(c(i, i2));
                if (G == -1) {
                    y(this, "EOF", G, null, 4, null);
                    throw new KotlinNothingValueException();
                }
            } else {
                i2++;
                if (i2 >= source.length()) {
                    e(i, i2);
                    G = G(i2);
                    if (G == -1) {
                        y(this, "EOF", G, null, 4, null);
                        throw new KotlinNothingValueException();
                    }
                } else {
                    continue;
                    charAt = source.charAt(i2);
                }
            }
            z = true;
            i = G;
            i2 = i;
            charAt = source.charAt(i2);
        }
        String J = !z ? J(i, i2) : u(i, i2);
        this.a = i2 + 1;
        return J;
    }

    public final String s() {
        if (this.c != null) {
            return K();
        }
        int I = I();
        if (I >= C().length() || I == -1) {
            y(this, "EOF", I, null, 4, null);
            throw new KotlinNothingValueException();
        }
        byte a = b.a(C().charAt(I));
        if (a == 1) {
            return q();
        }
        if (a != 0) {
            y(this, "Expected beginning of the string, but got " + C().charAt(I), 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        boolean z = false;
        while (b.a(C().charAt(I)) == 0) {
            I++;
            if (I >= C().length()) {
                e(this.a, I);
                int G = G(I);
                if (G == -1) {
                    this.a = I;
                    return u(0, 0);
                }
                I = G;
                z = true;
            }
        }
        String J = !z ? J(this.a, I) : u(this.a, I);
        this.a = I;
        return J;
    }

    public final String t() {
        String s = s();
        if (!Intrinsics.c(s, "null") || !O()) {
            return s;
        }
        y(this, "Unexpected 'null' value instead of string literal", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    public String toString() {
        return "JsonReader(source='" + ((Object) C()) + "', currentPosition=" + this.a + ')';
    }

    public void v() {
    }

    public final void w() {
        if (m() == 10) {
            return;
        }
        y(this, "Expected EOF after parsing, but had " + C().charAt(this.a - 1) + " instead", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    public final Void x(String message, int i, String hint) {
        String str;
        Intrinsics.h(message, "message");
        Intrinsics.h(hint, "hint");
        if (hint.length() == 0) {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        } else {
            str = '\n' + hint;
        }
        throw w.f(i, message + " at path: " + this.b.a() + str, C());
    }

    public final Void z(byte b) {
        y(this, "Expected " + (b == 1 ? "quotation mark '\"'" : b == 4 ? "comma ','" : b == 5 ? "colon ':'" : b == 6 ? "start of the object '{'" : b == 7 ? "end of the object '}'" : b == 8 ? "start of the array '['" : b == 9 ? "end of the array ']'" : "valid token") + ", but had '" + ((this.a == C().length() || this.a <= 0) ? "EOF" : String.valueOf(C().charAt(this.a - 1))) + "' instead", this.a - 1, null, 4, null);
        throw new KotlinNothingValueException();
    }
}
