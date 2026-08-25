package androidx.core.view.inputmethod;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import androidx.core.util.i;

@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class EditorInfoCompat {
    private static final String CONTENT_MIME_TYPES_INTEROP_KEY = "android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final String CONTENT_MIME_TYPES_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final String CONTENT_SELECTION_END_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END";
    private static final String CONTENT_SELECTION_HEAD_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD";
    private static final String CONTENT_SURROUNDING_TEXT_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT";
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final int IME_FLAG_FORCE_ASCII = Integer.MIN_VALUE;
    public static final int IME_FLAG_NO_PERSONALIZED_LEARNING = 16777216;
    static final int MAX_INITIAL_SELECTION_LENGTH = 1024;
    static final int MEMORY_EFFICIENT_TEXT_LENGTH = 2048;
    static final String STYLUS_HANDWRITING_ENABLED_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.STYLUS_HANDWRITING_ENABLED";

    private static class a {
        static CharSequence a(EditorInfo editorInfo, int i5) {
            return editorInfo.getInitialSelectedText(i5);
        }

        static CharSequence b(EditorInfo editorInfo, int i5, int i6) {
            return editorInfo.getInitialTextAfterCursor(i5, i6);
        }

        static CharSequence c(EditorInfo editorInfo, int i5, int i6) {
            return editorInfo.getInitialTextBeforeCursor(i5, i6);
        }

        static void d(EditorInfo editorInfo, CharSequence charSequence, int i5) {
            editorInfo.setInitialSurroundingSubText(charSequence, i5);
        }
    }

    private static class b {
        static boolean a(EditorInfo editorInfo) {
            return editorInfo.isStylusHandwritingEnabled();
        }

        static void b(EditorInfo editorInfo, boolean z5) {
            editorInfo.setStylusHandwritingEnabled(z5);
        }
    }

    @Deprecated
    public EditorInfoCompat() {
    }

    public static String[] getContentMimeTypes(EditorInfo editorInfo) {
        String[] strArr;
        if (Build.VERSION.SDK_INT >= 25) {
            strArr = editorInfo.contentMimeTypes;
            return strArr != null ? strArr : EMPTY_STRING_ARRAY;
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null) {
            return EMPTY_STRING_ARRAY;
        }
        String[] stringArray = bundle.getStringArray(CONTENT_MIME_TYPES_KEY);
        if (stringArray == null) {
            stringArray = editorInfo.extras.getStringArray(CONTENT_MIME_TYPES_INTEROP_KEY);
        }
        return stringArray != null ? stringArray : EMPTY_STRING_ARRAY;
    }

    public static CharSequence getInitialSelectedText(EditorInfo editorInfo, int i5) {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT >= 30) {
            return a.a(editorInfo, i5);
        }
        if (editorInfo.extras == null) {
            return null;
        }
        int min = Math.min(editorInfo.initialSelStart, editorInfo.initialSelEnd);
        int max = Math.max(editorInfo.initialSelStart, editorInfo.initialSelEnd);
        int i6 = editorInfo.extras.getInt(CONTENT_SELECTION_HEAD_KEY);
        int i7 = editorInfo.extras.getInt(CONTENT_SELECTION_END_KEY);
        int i8 = max - min;
        if (editorInfo.initialSelStart < 0 || editorInfo.initialSelEnd < 0 || i7 - i6 != i8 || (charSequence = editorInfo.extras.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY)) == null) {
            return null;
        }
        return (i5 & 1) != 0 ? charSequence.subSequence(i6, i7) : TextUtils.substring(charSequence, i6, i7);
    }

    public static CharSequence getInitialTextAfterCursor(EditorInfo editorInfo, int i5, int i6) {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT >= 30) {
            return a.b(editorInfo, i5, i6);
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null || (charSequence = bundle.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY)) == null) {
            return null;
        }
        int i7 = editorInfo.extras.getInt(CONTENT_SELECTION_END_KEY);
        int min = Math.min(i5, charSequence.length() - i7);
        return (i6 & 1) != 0 ? charSequence.subSequence(i7, min + i7) : TextUtils.substring(charSequence, i7, min + i7);
    }

    public static CharSequence getInitialTextBeforeCursor(EditorInfo editorInfo, int i5, int i6) {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT >= 30) {
            return a.c(editorInfo, i5, i6);
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null || (charSequence = bundle.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY)) == null) {
            return null;
        }
        int i7 = editorInfo.extras.getInt(CONTENT_SELECTION_HEAD_KEY);
        int min = Math.min(i5, i7);
        return (i6 & 1) != 0 ? charSequence.subSequence(i7 - min, i7) : TextUtils.substring(charSequence, i7 - min, i7);
    }

    static int getProtocol(EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 25) {
            return 1;
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null) {
            return 0;
        }
        boolean containsKey = bundle.containsKey(CONTENT_MIME_TYPES_KEY);
        boolean containsKey2 = editorInfo.extras.containsKey(CONTENT_MIME_TYPES_INTEROP_KEY);
        if (containsKey && containsKey2) {
            return 4;
        }
        if (containsKey) {
            return 3;
        }
        return containsKey2 ? 2 : 0;
    }

    private static boolean isCutOnSurrogate(CharSequence charSequence, int i5, int i6) {
        if (i6 == 0) {
            return Character.isLowSurrogate(charSequence.charAt(i5));
        }
        if (i6 != 1) {
            return false;
        }
        return Character.isHighSurrogate(charSequence.charAt(i5));
    }

    private static boolean isPasswordInputType(int i5) {
        int i6 = i5 & 4095;
        return i6 == 129 || i6 == 225 || i6 == 18;
    }

    public static boolean isStylusHandwritingEnabled(EditorInfo editorInfo) {
        Bundle bundle = editorInfo.extras;
        if (bundle != null && bundle.containsKey(STYLUS_HANDWRITING_ENABLED_KEY)) {
            return editorInfo.extras.getBoolean(STYLUS_HANDWRITING_ENABLED_KEY);
        }
        if (Build.VERSION.SDK_INT >= 35) {
            return b.a(editorInfo);
        }
        return false;
    }

    public static void setContentMimeTypes(EditorInfo editorInfo, String[] strArr) {
        if (Build.VERSION.SDK_INT >= 25) {
            editorInfo.contentMimeTypes = strArr;
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putStringArray(CONTENT_MIME_TYPES_KEY, strArr);
        editorInfo.extras.putStringArray(CONTENT_MIME_TYPES_INTEROP_KEY, strArr);
    }

    public static void setInitialSurroundingSubText(EditorInfo editorInfo, CharSequence charSequence, int i5) {
        i.g(charSequence);
        if (Build.VERSION.SDK_INT >= 30) {
            a.d(editorInfo, charSequence, i5);
            return;
        }
        int i6 = editorInfo.initialSelStart;
        int i7 = editorInfo.initialSelEnd;
        int i8 = i6 > i7 ? i7 - i5 : i6 - i5;
        int i9 = i6 > i7 ? i6 - i5 : i7 - i5;
        int length = charSequence.length();
        if (i5 < 0 || i8 < 0 || i9 > length) {
            setSurroundingText(editorInfo, null, 0, 0);
            return;
        }
        if (isPasswordInputType(editorInfo.inputType)) {
            setSurroundingText(editorInfo, null, 0, 0);
        } else if (length <= 2048) {
            setSurroundingText(editorInfo, charSequence, i8, i9);
        } else {
            trimLongSurroundingText(editorInfo, charSequence, i8, i9);
        }
    }

    public static void setInitialSurroundingText(EditorInfo editorInfo, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            a.d(editorInfo, charSequence, 0);
        } else {
            setInitialSurroundingSubText(editorInfo, charSequence, 0);
        }
    }

    public static void setStylusHandwritingEnabled(EditorInfo editorInfo, boolean z5) {
        if (Build.VERSION.SDK_INT >= 35) {
            b.b(editorInfo, z5);
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putBoolean(STYLUS_HANDWRITING_ENABLED_KEY, z5);
    }

    private static void setSurroundingText(EditorInfo editorInfo, CharSequence charSequence, int i5, int i6) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putCharSequence(CONTENT_SURROUNDING_TEXT_KEY, charSequence != null ? new SpannableStringBuilder(charSequence) : null);
        editorInfo.extras.putInt(CONTENT_SELECTION_HEAD_KEY, i5);
        editorInfo.extras.putInt(CONTENT_SELECTION_END_KEY, i6);
    }

    private static void trimLongSurroundingText(EditorInfo editorInfo, CharSequence charSequence, int i5, int i6) {
        int i7 = i6 - i5;
        int i8 = i7 > 1024 ? 0 : i7;
        int i9 = 2048 - i8;
        int min = Math.min(charSequence.length() - i6, i9 - Math.min(i5, (int) (i9 * 0.8d)));
        int min2 = Math.min(i5, i9 - min);
        int i10 = i5 - min2;
        if (isCutOnSurrogate(charSequence, i10, 0)) {
            i10++;
            min2--;
        }
        if (isCutOnSurrogate(charSequence, (i6 + min) - 1, 1)) {
            min--;
        }
        setSurroundingText(editorInfo, i8 != i7 ? TextUtils.concat(charSequence.subSequence(i10, i10 + min2), charSequence.subSequence(i6, min + i6)) : charSequence.subSequence(i10, min2 + i8 + min + i10), min2, i8 + min2);
    }
}
