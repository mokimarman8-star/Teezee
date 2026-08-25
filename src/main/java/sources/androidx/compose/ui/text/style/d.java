package androidx.compose.ui.text.style;

import androidx.core.view.inputmethod.EditorInfoCompat;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final a f5358a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final int f5359b = d(1);

    /* renamed from: c, reason: collision with root package name */
    private static final int f5360c = d(2);

    /* renamed from: d, reason: collision with root package name */
    private static final int f5361d = d(EditorInfoCompat.IME_FLAG_FORCE_ASCII);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return d.f5360c;
        }

        public final int b() {
            return d.f5359b;
        }

        public final int c() {
            return d.f5361d;
        }
    }

    private static int d(int i5) {
        return i5;
    }

    public static final boolean e(int i5, int i6) {
        return i5 == i6;
    }

    public static int f(int i5) {
        return i5;
    }

    public static String g(int i5) {
        return e(i5, f5359b) ? "Hyphens.None" : e(i5, f5360c) ? "Hyphens.Auto" : e(i5, f5361d) ? "Hyphens.Unspecified" : "Invalid";
    }
}
