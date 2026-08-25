package androidx.core.view;

import android.os.Build;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class HapticFeedbackConstantsCompat {
    public static final int CLOCK_TICK = 4;
    public static final int CONFIRM = 16;
    public static final int CONTEXT_CLICK = 6;
    public static final int DRAG_START = 25;
    static final int FIRST_CONSTANT_INT = 0;
    public static final int FLAG_IGNORE_VIEW_SETTING = 1;
    public static final int GESTURE_END = 13;
    public static final int GESTURE_START = 12;
    public static final int GESTURE_THRESHOLD_ACTIVATE = 23;
    public static final int GESTURE_THRESHOLD_DEACTIVATE = 24;
    public static final int KEYBOARD_PRESS = 3;
    public static final int KEYBOARD_RELEASE = 7;
    public static final int KEYBOARD_TAP = 3;
    static final int LAST_CONSTANT_INT = 27;
    public static final int LONG_PRESS = 0;
    public static final int NO_HAPTICS = -1;
    public static final int REJECT = 17;
    public static final int SEGMENT_FREQUENT_TICK = 27;
    public static final int SEGMENT_TICK = 26;
    public static final int TEXT_HANDLE_MOVE = 9;
    public static final int TOGGLE_OFF = 22;
    public static final int TOGGLE_ON = 21;
    public static final int VIRTUAL_KEY = 1;
    public static final int VIRTUAL_KEY_RELEASE = 8;

    @Retention(RetentionPolicy.SOURCE)
    public @interface HapticFeedbackFlags {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface HapticFeedbackType {
    }

    private HapticFeedbackConstantsCompat() {
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static int getFeedbackConstantOrFallback(int i5) {
        if (i5 == -1) {
            return -1;
        }
        int i6 = Build.VERSION.SDK_INT;
        int i7 = 6;
        if (i6 < 34) {
            switch (i5) {
                case 21:
                case 23:
                case 26:
                    i5 = 6;
                    break;
                case 22:
                case 24:
                case 27:
                    i5 = 4;
                    break;
                case 25:
                    i5 = 0;
                    break;
            }
        }
        if (i6 < 30) {
            if (i5 != 12) {
                if (i5 != 13) {
                    if (i5 != 16) {
                        if (i5 == 17) {
                            i7 = 0;
                        }
                    }
                }
                if (i6 < 27 || !(i7 == 7 || i7 == 8 || i7 == 9)) {
                    return i7;
                }
                return -1;
            }
            i7 = 1;
            if (i6 < 27) {
            }
            return i7;
        }
        i7 = i5;
        if (i6 < 27) {
        }
        return i7;
    }
}
