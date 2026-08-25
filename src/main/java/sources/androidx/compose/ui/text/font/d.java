package androidx.compose.ui.text.font;

import androidx.compose.ui.text.font.p;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class d {
    public static final p a(p.a aVar) {
        return aVar.d();
    }

    public static final int b(boolean z5, boolean z6) {
        if (z6 && z5) {
            return 3;
        }
        if (z5) {
            return 1;
        }
        return z6 ? 2 : 0;
    }

    public static final int c(p pVar, int i5) {
        return b(pVar.compareTo(a(p.f5145b)) >= 0, n.f(i5, n.f5135b.a()));
    }
}
