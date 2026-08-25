package androidx.compose.ui.platform;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class e extends androidx.compose.ui.platform.a {

    /* renamed from: c, reason: collision with root package name */
    public static final a f4772c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    private static e f4773d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final e a() {
            if (e.f4773d == null) {
                e.f4773d = new e(null);
            }
            e eVar = e.f4773d;
            Intrinsics.f(eVar, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.ParagraphTextSegmentIterator");
            return eVar;
        }
    }

    private e() {
    }

    public /* synthetic */ e(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final boolean i(int i5) {
        return i5 > 0 && d().charAt(i5 + (-1)) != '\n' && (i5 == d().length() || d().charAt(i5) == '\n');
    }

    private final boolean j(int i5) {
        return d().charAt(i5) != '\n' && (i5 == 0 || d().charAt(i5 - 1) == '\n');
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002b, code lost:
    
        return null;
     */
    @Override // androidx.compose.ui.platform.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int[] a(int i5) {
        int length = d().length();
        if (length <= 0 || i5 >= length) {
            return null;
        }
        if (i5 < 0) {
            i5 = 0;
        }
        while (i5 < length && d().charAt(i5) == '\n' && !j(i5)) {
            i5++;
        }
        int i6 = i5 + 1;
        while (i6 < length && !i(i6)) {
            i6++;
        }
        return c(i5, i6);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
    
        return null;
     */
    @Override // androidx.compose.ui.platform.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int[] b(int i5) {
        int length = d().length();
        if (length <= 0 || i5 <= 0) {
            return null;
        }
        if (i5 > length) {
            i5 = length;
        }
        while (i5 > 0 && d().charAt(i5 - 1) == '\n' && !i(i5)) {
            i5--;
        }
        int i6 = i5 - 1;
        while (i6 > 0 && !j(i6)) {
            i6--;
        }
        return c(i6, i5);
    }
}
