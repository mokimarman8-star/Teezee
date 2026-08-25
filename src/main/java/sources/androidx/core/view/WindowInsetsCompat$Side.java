package androidx.core.view;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class WindowInsetsCompat$Side {
    public static final int BOTTOM = 8;
    public static final int LEFT = 1;
    public static final int RIGHT = 4;
    public static final int TOP = 2;

    @Retention(RetentionPolicy.SOURCE)
    public @interface InsetsSide {
    }

    private WindowInsetsCompat$Side() {
    }

    public static int all() {
        return 15;
    }
}
