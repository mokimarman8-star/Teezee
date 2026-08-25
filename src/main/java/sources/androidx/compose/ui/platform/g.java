package androidx.compose.ui.platform;

import java.text.BreakIterator;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class g extends androidx.compose.ui.platform.a {

    /* renamed from: d, reason: collision with root package name */
    public static final a f4777d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    public static final int f4778e = 8;

    /* renamed from: f, reason: collision with root package name */
    private static g f4779f;

    /* renamed from: c, reason: collision with root package name */
    private BreakIterator f4780c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final g a(Locale locale) {
            if (g.f4779f == null) {
                g.f4779f = new g(locale, null);
            }
            g gVar = g.f4779f;
            Intrinsics.f(gVar, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.WordTextSegmentIterator");
            return gVar;
        }
    }

    private g(Locale locale) {
        l(locale);
    }

    public /* synthetic */ g(Locale locale, DefaultConstructorMarker defaultConstructorMarker) {
        this(locale);
    }

    private final boolean i(int i5) {
        return i5 > 0 && j(i5 + (-1)) && (i5 == d().length() || !j(i5));
    }

    private final boolean j(int i5) {
        if (i5 < 0 || i5 >= d().length()) {
            return false;
        }
        return Character.isLetterOrDigit(d().codePointAt(i5));
    }

    private final boolean k(int i5) {
        return j(i5) && (i5 == 0 || !j(i5 - 1));
    }

    private final void l(Locale locale) {
        this.f4780c = BreakIterator.getWordInstance(locale);
    }

    @Override // androidx.compose.ui.platform.f
    public int[] a(int i5) {
        if (d().length() <= 0 || i5 >= d().length()) {
            return null;
        }
        if (i5 < 0) {
            i5 = 0;
        }
        while (!j(i5) && !k(i5)) {
            BreakIterator breakIterator = this.f4780c;
            if (breakIterator == null) {
                Intrinsics.y("impl");
                breakIterator = null;
            }
            i5 = breakIterator.following(i5);
            if (i5 == -1) {
                return null;
            }
        }
        BreakIterator breakIterator2 = this.f4780c;
        if (breakIterator2 == null) {
            Intrinsics.y("impl");
            breakIterator2 = null;
        }
        int following = breakIterator2.following(i5);
        if (following == -1 || !i(following)) {
            return null;
        }
        return c(i5, following);
    }

    @Override // androidx.compose.ui.platform.f
    public int[] b(int i5) {
        int length = d().length();
        if (length <= 0 || i5 <= 0) {
            return null;
        }
        if (i5 > length) {
            i5 = length;
        }
        while (i5 > 0 && !j(i5 - 1) && !i(i5)) {
            BreakIterator breakIterator = this.f4780c;
            if (breakIterator == null) {
                Intrinsics.y("impl");
                breakIterator = null;
            }
            i5 = breakIterator.preceding(i5);
            if (i5 == -1) {
                return null;
            }
        }
        BreakIterator breakIterator2 = this.f4780c;
        if (breakIterator2 == null) {
            Intrinsics.y("impl");
            breakIterator2 = null;
        }
        int preceding = breakIterator2.preceding(i5);
        if (preceding == -1 || !k(preceding)) {
            return null;
        }
        return c(preceding, i5);
    }

    @Override // androidx.compose.ui.platform.a
    public void e(String str) {
        super.e(str);
        BreakIterator breakIterator = this.f4780c;
        if (breakIterator == null) {
            Intrinsics.y("impl");
            breakIterator = null;
        }
        breakIterator.setText(str);
    }
}
