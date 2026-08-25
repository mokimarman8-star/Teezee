package androidx.collection;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    public int[] f1295a;

    /* renamed from: b, reason: collision with root package name */
    public int f1296b;

    private m(int i5) {
        this.f1295a = i5 == 0 ? r.a() : new int[i5];
    }

    public /* synthetic */ m(int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i5);
    }

    public static /* synthetic */ String d(m mVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        }
        if ((i6 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i6 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i6 & 4) == 0 ? charSequence3 : "";
        if ((i6 & 8) != 0) {
            i5 = -1;
        }
        int i7 = i5;
        if ((i6 & 16) != 0) {
            charSequence4 = "...";
        }
        return mVar.c(charSequence, charSequence5, charSequence6, i7, charSequence4);
    }

    public final int a(int i5) {
        if (i5 >= 0 && i5 < this.f1296b) {
            return this.f1295a[i5];
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Index ");
        sb.append(i5);
        sb.append(" must be in 0..");
        sb.append(this.f1296b - 1);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final int b() {
        return this.f1296b;
    }

    public final String c(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4) {
        Intrinsics.h(charSequence, "separator");
        Intrinsics.h(charSequence2, "prefix");
        Intrinsics.h(charSequence3, "postfix");
        Intrinsics.h(charSequence4, "truncated");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        int[] iArr = this.f1295a;
        int i6 = this.f1296b;
        int i7 = 0;
        while (true) {
            if (i7 >= i6) {
                sb.append(charSequence3);
                break;
            }
            int i8 = iArr[i7];
            if (i7 == i5) {
                sb.append(charSequence4);
                break;
            }
            if (i7 != 0) {
                sb.append(charSequence);
            }
            sb.append(i8);
            i7++;
        }
        String sb2 = sb.toString();
        Intrinsics.g(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof m) {
            m mVar = (m) obj;
            int i5 = mVar.f1296b;
            int i6 = this.f1296b;
            if (i5 == i6) {
                int[] iArr = this.f1295a;
                int[] iArr2 = mVar.f1295a;
                IntRange s5 = RangesKt.s(0, i6);
                int f5 = s5.f();
                int i7 = s5.i();
                if (f5 > i7) {
                    return true;
                }
                while (iArr[f5] == iArr2[f5]) {
                    if (f5 == i7) {
                        return true;
                    }
                    f5++;
                }
                return false;
            }
        }
        return false;
    }

    public int hashCode() {
        int[] iArr = this.f1295a;
        int i5 = this.f1296b;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            i6 += iArr[i7] * 31;
        }
        return i6;
    }

    public String toString() {
        return d(this, null, "[", "]", 0, null, 25, null);
    }
}
