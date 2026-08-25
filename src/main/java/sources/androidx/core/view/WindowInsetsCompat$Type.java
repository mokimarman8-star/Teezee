package androidx.core.view;

import android.annotation.SuppressLint;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class WindowInsetsCompat$Type {
    static final int CAPTION_BAR = 4;
    static final int DISPLAY_CUTOUT = 128;
    static final int FIRST = 1;
    static final int IME = 8;
    static final int LAST = 512;
    static final int MANDATORY_SYSTEM_GESTURES = 32;
    static final int NAVIGATION_BARS = 2;
    static final int SIZE = 10;
    static final int STATUS_BARS = 1;
    static final int SYSTEM_GESTURES = 16;
    static final int SYSTEM_OVERLAYS = 512;
    static final int TAPPABLE_ELEMENT = 64;
    static final int WINDOW_DECOR = 256;

    @Retention(RetentionPolicy.SOURCE)
    public @interface InsetsType {
    }

    private WindowInsetsCompat$Type() {
    }

    @SuppressLint({"WrongConstant"})
    static int all() {
        return -1;
    }

    public static int captionBar() {
        return 4;
    }

    public static int displayCutout() {
        return 128;
    }

    public static int ime() {
        return 8;
    }

    static int indexOf(int i5) {
        if (i5 == 1) {
            return 0;
        }
        if (i5 == 2) {
            return 1;
        }
        if (i5 == 4) {
            return 2;
        }
        if (i5 == 8) {
            return 3;
        }
        if (i5 == 16) {
            return 4;
        }
        if (i5 == 32) {
            return 5;
        }
        if (i5 == 64) {
            return 6;
        }
        if (i5 == 128) {
            return 7;
        }
        if (i5 == 256) {
            return 8;
        }
        if (i5 == 512) {
            return 9;
        }
        throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i5);
    }

    public static int mandatorySystemGestures() {
        return 32;
    }

    public static int navigationBars() {
        return 2;
    }

    public static int statusBars() {
        return 1;
    }

    public static int systemBars() {
        return 519;
    }

    public static int systemGestures() {
        return 16;
    }

    public static int systemOverlays() {
        return 512;
    }

    public static int tappableElement() {
        return 64;
    }
}
