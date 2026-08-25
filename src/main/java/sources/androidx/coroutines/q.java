package androidx.coroutines;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    private final InvalidationTracker$b f13238a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f13239b;

    /* renamed from: c, reason: collision with root package name */
    private final String[] f13240c;

    /* renamed from: d, reason: collision with root package name */
    private final Set f13241d;

    public q(InvalidationTracker$b invalidationTracker$b, int[] iArr, String[] strArr) {
        Intrinsics.h(invalidationTracker$b, "observer");
        Intrinsics.h(iArr, "tableIds");
        Intrinsics.h(strArr, "tableNames");
        this.f13238a = invalidationTracker$b;
        this.f13239b = iArr;
        this.f13240c = strArr;
        if (iArr.length != strArr.length) {
            throw new IllegalStateException("Check failed.");
        }
        this.f13241d = !(strArr.length == 0) ? SetsKt.d(strArr[0]) : SetsKt.f();
    }

    public final InvalidationTracker$b a() {
        return this.f13238a;
    }

    public final int[] b() {
        return this.f13239b;
    }

    public final void c(Set set) {
        Set f5;
        Intrinsics.h(set, "invalidatedTablesIds");
        int[] iArr = this.f13239b;
        int length = iArr.length;
        if (length != 0) {
            int i5 = 0;
            if (length != 1) {
                Set b5 = SetsKt.b();
                int[] iArr2 = this.f13239b;
                int length2 = iArr2.length;
                int i6 = 0;
                while (i5 < length2) {
                    int i7 = i6 + 1;
                    if (set.contains(Integer.valueOf(iArr2[i5]))) {
                        b5.add(this.f13240c[i6]);
                    }
                    i5++;
                    i6 = i7;
                }
                f5 = SetsKt.a(b5);
            } else {
                f5 = set.contains(Integer.valueOf(iArr[0])) ? this.f13241d : SetsKt.f();
            }
        } else {
            f5 = SetsKt.f();
        }
        if (f5.isEmpty()) {
            return;
        }
        this.f13238a.c(f5);
    }

    public final void d(Set set) {
        Set f5;
        Intrinsics.h(set, "invalidatedTablesNames");
        int length = this.f13240c.length;
        if (length == 0) {
            f5 = SetsKt.f();
        } else if (length != 1) {
            Set b5 = SetsKt.b();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                String[] strArr = this.f13240c;
                int length2 = strArr.length;
                int i5 = 0;
                while (true) {
                    if (i5 < length2) {
                        String str2 = strArr[i5];
                        if (StringsKt.H(str2, str, true)) {
                            b5.add(str2);
                            break;
                        }
                        i5++;
                    }
                }
            }
            f5 = SetsKt.a(b5);
        } else {
            Set set2 = set;
            if (!(set2 instanceof Collection) || !set2.isEmpty()) {
                Iterator it2 = set2.iterator();
                while (it2.hasNext()) {
                    if (StringsKt.H((String) it2.next(), this.f13240c[0], true)) {
                        f5 = this.f13241d;
                        break;
                    }
                }
            }
            f5 = SetsKt.f();
        }
        if (f5.isEmpty()) {
            return;
        }
        this.f13238a.c(f5);
    }
}
