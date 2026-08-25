package kotlinx.serialization.json.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b0 implements h0 {
    private char[] a = h.a.b();
    private int b;

    private final void d(int i, int i2, String str) {
        int i3;
        int length = str.length();
        while (i < length) {
            int f = f(i2, 2);
            char charAt = str.charAt(i);
            if (charAt < o0.a().length) {
                byte b = o0.a()[charAt];
                if (b == 0) {
                    i3 = f + 1;
                    this.a[f] = charAt;
                } else {
                    if (b == 1) {
                        String str2 = o0.b()[charAt];
                        Intrinsics.e(str2);
                        int f2 = f(f, str2.length());
                        str2.getChars(0, str2.length(), this.a, f2);
                        i2 = f2 + str2.length();
                        this.b = i2;
                    } else {
                        char[] cArr = this.a;
                        cArr[f] = '\\';
                        cArr[f + 1] = (char) b;
                        i2 = f + 2;
                        this.b = i2;
                    }
                    i++;
                }
            } else {
                i3 = f + 1;
                this.a[f] = charAt;
            }
            i2 = i3;
            i++;
        }
        int f3 = f(i2, 1);
        this.a[f3] = '\"';
        this.b = f3 + 1;
    }

    private final void e(int i) {
        f(this.b, i);
    }

    private final int f(int i, int i2) {
        int i3 = i2 + i;
        char[] cArr = this.a;
        if (cArr.length <= i3) {
            char[] copyOf = Arrays.copyOf(cArr, RangesKt.e(i3, i * 2));
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.a = copyOf;
        }
        return i;
    }

    @Override // kotlinx.serialization.json.internal.h0
    public void a(char c) {
        e(1);
        char[] cArr = this.a;
        int i = this.b;
        this.b = i + 1;
        cArr[i] = c;
    }

    @Override // kotlinx.serialization.json.internal.h0
    public void b(String text) {
        Intrinsics.h(text, "text");
        e(text.length() + 2);
        char[] cArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        cArr[i] = '\"';
        int length = text.length();
        text.getChars(0, length, cArr, i2);
        int i3 = length + i2;
        for (int i4 = i2; i4 < i3; i4++) {
            char c = cArr[i4];
            if (c < o0.a().length && o0.a()[c] != 0) {
                d(i4 - i2, i4, text);
                return;
            }
        }
        cArr[i3] = '\"';
        this.b = i3 + 1;
    }

    @Override // kotlinx.serialization.json.internal.h0
    public void c(String text) {
        Intrinsics.h(text, "text");
        int length = text.length();
        if (length == 0) {
            return;
        }
        e(length);
        text.getChars(0, text.length(), this.a, this.b);
        this.b += length;
    }

    public void g() {
        h.a.a(this.a);
    }

    public String toString() {
        return new String(this.a, 0, this.b);
    }

    @Override // kotlinx.serialization.json.internal.h0
    public void writeLong(long j) {
        c(String.valueOf(j));
    }
}
