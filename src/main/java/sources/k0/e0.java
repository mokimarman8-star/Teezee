package k0;

import android.text.Layout;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class e0 {
    public static final int a(Layout layout, int i5, boolean z5) {
        if (i5 <= 0) {
            return 0;
        }
        if (i5 >= layout.getText().length()) {
            return layout.getLineCount() - 1;
        }
        int lineForOffset = layout.getLineForOffset(i5);
        int lineStart = layout.getLineStart(lineForOffset);
        return (lineStart == i5 || layout.getLineEnd(lineForOffset) == i5) ? lineStart == i5 ? z5 ? lineForOffset - 1 : lineForOffset : z5 ? lineForOffset : lineForOffset + 1 : lineForOffset;
    }
}
