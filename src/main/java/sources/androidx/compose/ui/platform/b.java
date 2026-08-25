package androidx.compose.ui.platform;

import java.text.BreakIterator;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class b extends androidx.compose.ui.platform.a {

    /* renamed from: d, reason: collision with root package name */
    public static final a f4730d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    public static final int f4731e = 8;

    /* renamed from: f, reason: collision with root package name */
    private static b f4732f;

    /* renamed from: c, reason: collision with root package name */
    private BreakIterator f4733c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final b a(Locale locale) {
            if (b.f4732f == null) {
                b.f4732f = new b(locale, null);
            }
            b bVar = b.f4732f;
            Intrinsics.f(bVar, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.CharacterTextSegmentIterator");
            return bVar;
        }
    }

    private b(Locale locale) {
        i(locale);
    }

    public /* synthetic */ b(Locale locale, DefaultConstructorMarker defaultConstructorMarker) {
        this(locale);
    }

    private final void i(Locale locale) {
        this.f4733c = BreakIterator.getCharacterInstance(locale);
    }

    @Override // androidx.compose.ui.platform.f
    public int[] a(int i5) {
        int length = d().length();
        if (length <= 0 || i5 >= length) {
            return null;
        }
        if (i5 < 0) {
            i5 = 0;
        }
        do {
            BreakIterator breakIterator = this.f4733c;
            if (breakIterator == null) {
                Intrinsics.y("impl");
                breakIterator = null;
            }
            if (breakIterator.isBoundary(i5)) {
                BreakIterator breakIterator2 = this.f4733c;
                if (breakIterator2 == null) {
                    Intrinsics.y("impl");
                    breakIterator2 = null;
                }
                int following = breakIterator2.following(i5);
                if (following == -1) {
                    return null;
                }
                return c(i5, following);
            }
            BreakIterator breakIterator3 = this.f4733c;
            if (breakIterator3 == null) {
                Intrinsics.y("impl");
                breakIterator3 = null;
            }
            i5 = breakIterator3.following(i5);
        } while (i5 != -1);
        return null;
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
        do {
            BreakIterator breakIterator = this.f4733c;
            if (breakIterator == null) {
                Intrinsics.y("impl");
                breakIterator = null;
            }
            if (breakIterator.isBoundary(i5)) {
                BreakIterator breakIterator2 = this.f4733c;
                if (breakIterator2 == null) {
                    Intrinsics.y("impl");
                    breakIterator2 = null;
                }
                int preceding = breakIterator2.preceding(i5);
                if (preceding == -1) {
                    return null;
                }
                return c(preceding, i5);
            }
            BreakIterator breakIterator3 = this.f4733c;
            if (breakIterator3 == null) {
                Intrinsics.y("impl");
                breakIterator3 = null;
            }
            i5 = breakIterator3.preceding(i5);
        } while (i5 != -1);
        return null;
    }

    @Override // androidx.compose.ui.platform.a
    public void e(String str) {
        super.e(str);
        BreakIterator breakIterator = this.f4733c;
        if (breakIterator == null) {
            Intrinsics.y("impl");
            breakIterator = null;
        }
        breakIterator.setText(str);
    }
}
