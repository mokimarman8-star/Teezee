package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.v;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    private static final v f2203a = new e(v.f5273a.a(), 0, 0);

    public static final v b() {
        return f2203a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(int i5, int i6, int i7) {
        if (i5 < 0 || i5 > i6) {
            throw new IllegalStateException(("OffsetMapping.originalToTransformed returned invalid mapping: " + i7 + " -> " + i5 + " is not in range of transformed text [0, " + i6 + ']').toString());
        }
    }
}
