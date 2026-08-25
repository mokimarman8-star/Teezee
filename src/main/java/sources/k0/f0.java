package k0;

import android.text.Layout;
import android.text.TextUtils;
import java.text.Bidi;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class f0 {

    /* renamed from: a, reason: collision with root package name */
    private final Layout f16052a;

    /* renamed from: b, reason: collision with root package name */
    private final List f16053b;

    /* renamed from: c, reason: collision with root package name */
    private final List f16054c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean[] f16055d;

    /* renamed from: e, reason: collision with root package name */
    private char[] f16056e;

    /* renamed from: f, reason: collision with root package name */
    private final int f16057f;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f16058a;

        /* renamed from: b, reason: collision with root package name */
        private final int f16059b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f16060c;

        public a(int i5, int i6, boolean z5) {
            this.f16058a = i5;
            this.f16059b = i6;
            this.f16060c = z5;
        }

        public final int a() {
            return this.f16059b;
        }

        public final int b() {
            return this.f16058a;
        }

        public final boolean c() {
            return this.f16060c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f16058a == aVar.f16058a && this.f16059b == aVar.f16059b && this.f16060c == aVar.f16060c;
        }

        public int hashCode() {
            return (((this.f16058a * 31) + this.f16059b) * 31) + androidx.compose.foundation.e.a(this.f16060c);
        }

        public String toString() {
            return "BidiRun(start=" + this.f16058a + ", end=" + this.f16059b + ", isRtl=" + this.f16060c + ')';
        }
    }

    public f0(Layout layout) {
        this.f16052a = layout;
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        do {
            int n02 = StringsKt.n0(this.f16052a.getText(), '\n', i5, false, 4, (Object) null);
            i5 = n02 < 0 ? this.f16052a.getText().length() : n02 + 1;
            arrayList.add(Integer.valueOf(i5));
        } while (i5 < this.f16052a.getText().length());
        this.f16053b = arrayList;
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        for (int i6 = 0; i6 < size; i6++) {
            arrayList2.add(null);
        }
        this.f16054c = arrayList2;
        this.f16055d = new boolean[this.f16053b.size()];
        this.f16057f = this.f16053b.size();
    }

    private final float b(int i5, boolean z5) {
        int h5 = RangesKt.h(i5, this.f16052a.getLineEnd(this.f16052a.getLineForOffset(i5)));
        return z5 ? this.f16052a.getPrimaryHorizontal(h5) : this.f16052a.getSecondaryHorizontal(h5);
    }

    private final int i(int i5, int i6) {
        while (i5 > i6 && g(this.f16052a.getText().charAt(i5 - 1))) {
            i5--;
        }
        return i5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0060, code lost:
    
        if (r0.getRunCount() == 1) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Bidi a(int i5) {
        Bidi bidi;
        if (this.f16055d[i5]) {
            return (Bidi) this.f16054c.get(i5);
        }
        int intValue = i5 == 0 ? 0 : ((Number) this.f16053b.get(i5 - 1)).intValue();
        int intValue2 = ((Number) this.f16053b.get(i5)).intValue();
        int i6 = intValue2 - intValue;
        char[] cArr = this.f16056e;
        if (cArr == null || cArr.length < i6) {
            cArr = new char[i6];
        }
        char[] cArr2 = cArr;
        TextUtils.getChars(this.f16052a.getText(), intValue, intValue2, cArr2, 0);
        if (Bidi.requiresBidi(cArr2, 0, i6)) {
            bidi = new Bidi(cArr2, 0, null, 0, i6, h(i5) ? 1 : 0);
        }
        bidi = null;
        this.f16054c.set(i5, bidi);
        this.f16055d[i5] = true;
        if (bidi != null) {
            char[] cArr3 = this.f16056e;
            cArr2 = cArr2 == cArr3 ? null : cArr3;
        }
        this.f16056e = cArr2;
        return bidi;
    }

    public final float c(int i5, boolean z5, boolean z6) {
        int i6 = i5;
        if (!z6) {
            return b(i5, z5);
        }
        int a5 = e0.a(this.f16052a, i6, z6);
        int lineStart = this.f16052a.getLineStart(a5);
        int lineEnd = this.f16052a.getLineEnd(a5);
        if (i6 != lineStart && i6 != lineEnd) {
            return b(i5, z5);
        }
        if (i6 == 0 || i6 == this.f16052a.getText().length()) {
            return b(i5, z5);
        }
        int e5 = e(i6, z6);
        boolean h5 = h(e5);
        int i7 = i(lineEnd, lineStart);
        int f5 = f(e5);
        int i8 = lineStart - f5;
        int i9 = i7 - f5;
        Bidi a6 = a(e5);
        Bidi createLineBidi = a6 != null ? a6.createLineBidi(i8, i9) : null;
        boolean z7 = false;
        if (createLineBidi == null || createLineBidi.getRunCount() == 1) {
            boolean isRtlCharAt = this.f16052a.isRtlCharAt(lineStart);
            if (z5 || h5 == isRtlCharAt) {
                h5 = !h5;
            }
            if (i6 == lineStart) {
                z7 = h5;
            } else if (!h5) {
                z7 = true;
            }
            Layout layout = this.f16052a;
            return z7 ? layout.getLineLeft(a5) : layout.getLineRight(a5);
        }
        int runCount = createLineBidi.getRunCount();
        a[] aVarArr = new a[runCount];
        for (int i10 = 0; i10 < runCount; i10++) {
            aVarArr[i10] = new a(createLineBidi.getRunStart(i10) + lineStart, createLineBidi.getRunLimit(i10) + lineStart, createLineBidi.getRunLevel(i10) % 2 == 1);
        }
        int runCount2 = createLineBidi.getRunCount();
        byte[] bArr = new byte[runCount2];
        for (int i11 = 0; i11 < runCount2; i11++) {
            bArr[i11] = (byte) createLineBidi.getRunLevel(i11);
        }
        Bidi.reorderVisually(bArr, 0, aVarArr, 0, runCount);
        int i12 = -1;
        if (i6 == lineStart) {
            int i13 = 0;
            while (true) {
                if (i13 >= runCount) {
                    break;
                }
                if (aVarArr[i13].b() == i6) {
                    i12 = i13;
                    break;
                }
                i13++;
            }
            a aVar = aVarArr[i12];
            if (z5 || h5 == aVar.c()) {
                h5 = !h5;
            }
            return (i12 == 0 && h5) ? this.f16052a.getLineLeft(a5) : (i12 != ArraysKt.Y(aVarArr) || h5) ? h5 ? this.f16052a.getPrimaryHorizontal(aVarArr[i12 - 1].b()) : this.f16052a.getPrimaryHorizontal(aVarArr[i12 + 1].b()) : this.f16052a.getLineRight(a5);
        }
        if (i6 > i7) {
            i6 = i(i6, lineStart);
        }
        int i14 = 0;
        while (true) {
            if (i14 >= runCount) {
                break;
            }
            if (aVarArr[i14].a() == i6) {
                i12 = i14;
                break;
            }
            i14++;
        }
        a aVar2 = aVarArr[i12];
        if (!z5 && h5 != aVar2.c()) {
            h5 = !h5;
        }
        return (i12 == 0 && h5) ? this.f16052a.getLineLeft(a5) : (i12 != ArraysKt.Y(aVarArr) || h5) ? h5 ? this.f16052a.getPrimaryHorizontal(aVarArr[i12 - 1].a()) : this.f16052a.getPrimaryHorizontal(aVarArr[i12 + 1].a()) : this.f16052a.getLineRight(a5);
    }

    public final int d(int i5) {
        return i(this.f16052a.getLineEnd(i5), this.f16052a.getLineStart(i5));
    }

    public final int e(int i5, boolean z5) {
        int k5 = CollectionsKt.k(this.f16053b, Integer.valueOf(i5), 0, 0, 6, (Object) null);
        int i6 = k5 < 0 ? -(k5 + 1) : k5 + 1;
        if (z5 && i6 > 0) {
            int i7 = i6 - 1;
            if (i5 == ((Number) this.f16053b.get(i7)).intValue()) {
                return i7;
            }
        }
        return i6;
    }

    public final int f(int i5) {
        if (i5 == 0) {
            return 0;
        }
        return ((Number) this.f16053b.get(i5 - 1)).intValue();
    }

    public final boolean g(char c5) {
        return c5 == ' ' || c5 == '\n' || c5 == 5760 || (Intrinsics.j(c5, 8192) >= 0 && Intrinsics.j(c5, 8202) <= 0 && c5 != 8199) || c5 == 8287 || c5 == 12288;
    }

    public final boolean h(int i5) {
        return this.f16052a.getParagraphDirection(this.f16052a.getLineForOffset(f(i5))) == -1;
    }
}
