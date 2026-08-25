package k0;

import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import kotlin.jvm.JvmStatic;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f16027a = new d();

    private d() {
    }

    @JvmStatic
    public static final BoringLayout a(CharSequence charSequence, TextPaint textPaint, int i5, Layout.Alignment alignment, float f5, float f6, BoringLayout.Metrics metrics, boolean z5, boolean z6, TextUtils.TruncateAt truncateAt, int i6) {
        return a.a(charSequence, textPaint, i5, alignment, f5, f6, metrics, z5, truncateAt, i6, z6);
    }

    @JvmStatic
    public static final BoringLayout.Metrics b(CharSequence charSequence, TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic) {
        BoringLayout.Metrics isBoring;
        isBoring = BoringLayout.isBoring(charSequence, textPaint, textDirectionHeuristic, true, null);
        return isBoring;
    }

    @JvmStatic
    public static final boolean c(BoringLayout boringLayout) {
        boolean isFallbackLineSpacingEnabled;
        isFallbackLineSpacingEnabled = boringLayout.isFallbackLineSpacingEnabled();
        return isFallbackLineSpacingEnabled;
    }
}
