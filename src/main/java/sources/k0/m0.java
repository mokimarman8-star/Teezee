package k0;

import android.text.Spanned;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class m0 {
    public static final boolean a(Spanned spanned, Class cls) {
        return spanned.nextSpanTransition(-1, spanned.length(), cls) != spanned.length();
    }

    public static final boolean b(Spanned spanned, Class cls, int i5, int i6) {
        return spanned.nextSpanTransition(i5 - 1, i6, cls) != i6;
    }
}
