package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.layout.b;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class c {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int b(androidx.compose.runtime.collection.b bVar, int i5) {
        int n5 = bVar.n() - 1;
        int i6 = 0;
        while (i6 < n5) {
            int i7 = ((n5 - i6) / 2) + i6;
            int b5 = ((b.a) bVar.m()[i7]).b();
            if (b5 == i5) {
                return i7;
            }
            if (b5 < i5) {
                i6 = i7 + 1;
                if (i5 < ((b.a) bVar.m()[i6]).b()) {
                    return i7;
                }
            } else {
                n5 = i7 - 1;
            }
        }
        return i6;
    }
}
