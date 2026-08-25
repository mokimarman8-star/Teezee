package androidx.appcompat.app;

import android.content.res.Configuration;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class AppCompatDelegateImpl$j {
    static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        i5 = configuration.colorMode;
        int i13 = i5 & 3;
        i6 = configuration2.colorMode;
        if (i13 != (i6 & 3)) {
            i11 = configuration3.colorMode;
            i12 = configuration2.colorMode;
            configuration3.colorMode = i11 | (i12 & 3);
        }
        i7 = configuration.colorMode;
        int i14 = i7 & 12;
        i8 = configuration2.colorMode;
        if (i14 != (i8 & 12)) {
            i9 = configuration3.colorMode;
            i10 = configuration2.colorMode;
            configuration3.colorMode = i9 | (i10 & 12);
        }
    }
}
