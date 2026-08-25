package androidx.media3.common.util;

import android.net.Uri;
import android.text.TextUtils;
import java.util.List;
import java.util.Objects;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class r0 {
    public static String a(Uri uri, Uri uri2) {
        if (uri.isOpaque() || uri2.isOpaque()) {
            return uri2.toString();
        }
        String scheme = uri.getScheme();
        String scheme2 = uri2.getScheme();
        if (scheme != null ? !(scheme2 == null || !com.google.common.base.a.a(scheme, scheme2)) : scheme2 == null) {
            if (Objects.equals(uri.getAuthority(), uri2.getAuthority())) {
                List<String> pathSegments = uri.getPathSegments();
                List<String> pathSegments2 = uri2.getPathSegments();
                int min = Math.min(pathSegments.size(), pathSegments2.size());
                int i5 = 0;
                for (int i6 = 0; i6 < min && pathSegments.get(i6).equals(pathSegments2.get(i6)); i6++) {
                    i5++;
                }
                StringBuilder sb = new StringBuilder();
                for (int i7 = i5; i7 < pathSegments.size(); i7++) {
                    sb.append("../");
                }
                while (i5 < pathSegments2.size()) {
                    sb.append(pathSegments2.get(i5));
                    if (i5 < pathSegments2.size() - 1) {
                        sb.append("/");
                    }
                    i5++;
                }
                return sb.toString();
            }
        }
        return uri2.toString();
    }

    private static int[] b(String str) {
        int i5;
        int[] iArr = new int[4];
        if (TextUtils.isEmpty(str)) {
            iArr[0] = -1;
            return iArr;
        }
        int length = str.length();
        int indexOf = str.indexOf(35);
        if (indexOf != -1) {
            length = indexOf;
        }
        int indexOf2 = str.indexOf(63);
        if (indexOf2 == -1 || indexOf2 > length) {
            indexOf2 = length;
        }
        int indexOf3 = str.indexOf(47);
        if (indexOf3 == -1 || indexOf3 > indexOf2) {
            indexOf3 = indexOf2;
        }
        int indexOf4 = str.indexOf(58);
        if (indexOf4 > indexOf3) {
            indexOf4 = -1;
        }
        int i6 = indexOf4 + 2;
        if (i6 < indexOf2 && str.charAt(indexOf4 + 1) == '/' && str.charAt(i6) == '/') {
            i5 = str.indexOf(47, indexOf4 + 3);
            if (i5 == -1 || i5 > indexOf2) {
                i5 = indexOf2;
            }
        } else {
            i5 = indexOf4 + 1;
        }
        iArr[0] = indexOf4;
        iArr[1] = i5;
        iArr[2] = indexOf2;
        iArr[3] = length;
        return iArr;
    }

    public static boolean c(String str) {
        return (str == null || b(str)[0] == -1) ? false : true;
    }

    private static String d(StringBuilder sb, int i5, int i6) {
        int i7;
        int i8;
        if (i5 >= i6) {
            return sb.toString();
        }
        if (sb.charAt(i5) == '/') {
            i5++;
        }
        int i9 = i5;
        int i10 = i9;
        while (i9 <= i6) {
            if (i9 == i6) {
                i7 = i9;
            } else if (sb.charAt(i9) == '/') {
                i7 = i9 + 1;
            } else {
                i9++;
            }
            int i11 = i10 + 1;
            if (i9 == i11 && sb.charAt(i10) == '.') {
                sb.delete(i10, i7);
                i6 -= i7 - i10;
            } else {
                if (i9 == i10 + 2 && sb.charAt(i10) == '.' && sb.charAt(i11) == '.') {
                    i8 = sb.lastIndexOf("/", i10 - 2) + 1;
                    int i12 = i8 > i5 ? i8 : i5;
                    sb.delete(i12, i7);
                    i6 -= i7 - i12;
                } else {
                    i8 = i9 + 1;
                }
                i10 = i8;
            }
            i9 = i10;
        }
        return sb.toString();
    }

    public static String e(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        int[] b5 = b(str2);
        if (b5[0] != -1) {
            sb.append(str2);
            d(sb, b5[1], b5[2]);
            return sb.toString();
        }
        int[] b6 = b(str);
        if (b5[3] == 0) {
            sb.append((CharSequence) str, 0, b6[3]);
            sb.append(str2);
            return sb.toString();
        }
        if (b5[2] == 0) {
            sb.append((CharSequence) str, 0, b6[2]);
            sb.append(str2);
            return sb.toString();
        }
        int i5 = b5[1];
        if (i5 != 0) {
            int i6 = b6[0] + 1;
            sb.append((CharSequence) str, 0, i6);
            sb.append(str2);
            return d(sb, b5[1] + i6, i6 + b5[2]);
        }
        if (str2.charAt(i5) == '/') {
            sb.append((CharSequence) str, 0, b6[1]);
            sb.append(str2);
            int i7 = b6[1];
            return d(sb, i7, b5[2] + i7);
        }
        int i8 = b6[0] + 2;
        int i9 = b6[1];
        if (i8 >= i9 || i9 != b6[2]) {
            int lastIndexOf = str.lastIndexOf(47, b6[2] - 1);
            int i10 = lastIndexOf == -1 ? b6[1] : lastIndexOf + 1;
            sb.append((CharSequence) str, 0, i10);
            sb.append(str2);
            return d(sb, b6[1], i10 + b5[2]);
        }
        sb.append((CharSequence) str, 0, i9);
        sb.append('/');
        sb.append(str2);
        int i11 = b6[1];
        return d(sb, i11, b5[2] + i11 + 1);
    }

    public static Uri f(String str, String str2) {
        return Uri.parse(e(str, str2));
    }
}
