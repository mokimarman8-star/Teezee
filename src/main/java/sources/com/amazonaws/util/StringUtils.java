package com.amazonaws.util;

import com.bumptech.glide.load.Key;
import java.nio.charset.Charset;
import java.util.Locale;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class StringUtils {
    public static final Charset a = Charset.forName(Key.STRING_CHARSET_NAME);

    public static boolean a(CharSequence charSequence) {
        int length;
        if (charSequence != null && (length = charSequence.length()) != 0) {
            for (int i = 0; i < length; i++) {
                if (!Character.isWhitespace(charSequence.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        return str.isEmpty() ? "" : str.toLowerCase(Locale.ENGLISH);
    }

    public static String c(String str) {
        if (str == null) {
            return null;
        }
        return str.isEmpty() ? "" : str.toUpperCase(Locale.ENGLISH);
    }
}
