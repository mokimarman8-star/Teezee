package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class n0 extends a {
    private final String e;

    public n0(String source) {
        Intrinsics.h(source, "source");
        this.e = source;
    }

    @Override // kotlinx.serialization.json.internal.a
    public int G(int i) {
        if (i < C().length()) {
            return i;
        }
        return -1;
    }

    @Override // kotlinx.serialization.json.internal.a
    public int I() {
        char charAt;
        int i = this.a;
        if (i == -1) {
            return i;
        }
        while (i < C().length() && ((charAt = C().charAt(i)) == ' ' || charAt == '\n' || charAt == '\r' || charAt == '\t')) {
            i++;
        }
        this.a = i;
        return i;
    }

    @Override // kotlinx.serialization.json.internal.a
    public boolean L() {
        int I = I();
        if (I == C().length() || I == -1 || C().charAt(I) != ',') {
            return false;
        }
        this.a++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.json.internal.a
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public String C() {
        return this.e;
    }

    @Override // kotlinx.serialization.json.internal.a
    public boolean f() {
        int i = this.a;
        if (i == -1) {
            return false;
        }
        while (i < C().length()) {
            char charAt = C().charAt(i);
            if (charAt != ' ' && charAt != '\n' && charAt != '\r' && charAt != '\t') {
                this.a = i;
                return D(charAt);
            }
            i++;
        }
        this.a = i;
        return false;
    }

    @Override // kotlinx.serialization.json.internal.a
    public String k() {
        o('\"');
        int i = this.a;
        int n0 = StringsKt.n0(C(), '\"', i, false, 4, null);
        if (n0 == -1) {
            z((byte) 1);
            throw new KotlinNothingValueException();
        }
        for (int i2 = i; i2 < n0; i2++) {
            if (C().charAt(i2) == '\\') {
                return r(C(), this.a, i2);
            }
        }
        this.a = n0 + 1;
        String substring = C().substring(i, n0);
        Intrinsics.g(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @Override // kotlinx.serialization.json.internal.a
    public String l(String keyToMatch, boolean z) {
        Intrinsics.h(keyToMatch, "keyToMatch");
        int i = this.a;
        try {
            if (m() != 6) {
                this.a = i;
                return null;
            }
            if (!Intrinsics.c(z ? k() : t(), keyToMatch)) {
                this.a = i;
                return null;
            }
            if (m() != 5) {
                this.a = i;
                return null;
            }
            String q = z ? q() : t();
            this.a = i;
            return q;
        } catch (Throwable th) {
            this.a = i;
            throw th;
        }
    }

    @Override // kotlinx.serialization.json.internal.a
    public byte m() {
        byte a;
        String C = C();
        do {
            int i = this.a;
            if (i == -1 || i >= C.length()) {
                return (byte) 10;
            }
            int i2 = this.a;
            this.a = i2 + 1;
            a = b.a(C.charAt(i2));
        } while (a == 3);
        return a;
    }

    @Override // kotlinx.serialization.json.internal.a
    public void o(char c) {
        if (this.a == -1) {
            N(c);
        }
        String C = C();
        while (this.a < C.length()) {
            int i = this.a;
            this.a = i + 1;
            char charAt = C.charAt(i);
            if (charAt != ' ' && charAt != '\n' && charAt != '\r' && charAt != '\t') {
                if (charAt == c) {
                    return;
                } else {
                    N(c);
                }
            }
        }
        N(c);
    }
}
