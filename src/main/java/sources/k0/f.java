package k0;

import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import kotlin.jvm.JvmStatic;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f16051a = new f();

    private f() {
    }

    @JvmStatic
    public static final BoringLayout a(CharSequence charSequence, TextPaint textPaint, int i5, Layout.Alignment alignment, float f5, float f6, BoringLayout.Metrics metrics, boolean z5, TextUtils.TruncateAt truncateAt, int i6) {
        return new BoringLayout(charSequence, textPaint, i5, alignment, f5, f6, metrics, z5, truncateAt, i6);
    }

    @JvmStatic
    public static final BoringLayout.Metrics b(CharSequence charSequence, TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic) {
        if (textDirectionHeuristic.isRtl(charSequence, 0, charSequence.length())) {
            return null;
        }
        return BoringLayout.isBoring(charSequence, textPaint, null);
    }
}
