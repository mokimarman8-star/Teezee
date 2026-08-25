package kotlin.text;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Settings;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
class q extends p {
    /* JADX WARN: Removed duplicated region for block: B:101:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ae A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0125  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final boolean r(String str) {
        boolean z;
        int charAt;
        int i;
        boolean z2;
        int i2;
        boolean z3;
        int length = str.length() - 1;
        int i3 = 0;
        while (i3 <= length && str.charAt(i3) <= ' ') {
            i3++;
        }
        if (i3 > length) {
            return false;
        }
        while (length > i3 && str.charAt(length) <= ' ') {
            length--;
        }
        if (str.charAt(i3) == '+' || str.charAt(i3) == '-') {
            i3++;
        }
        if (i3 > length) {
            return false;
        }
        if (str.charAt(i3) == '0') {
            int i4 = i3 + 1;
            if (i4 > length) {
                return true;
            }
            if ((str.charAt(i4) | ' ') == 120) {
                int i5 = i3 + 2;
                int i6 = i5;
                while (i6 <= length) {
                    if (((str.charAt(i6) - '0') & Settings.DEFAULT_INITIAL_WINDOW_SIZE) >= 10 && (((r15 | ' ') - 97) & Settings.DEFAULT_INITIAL_WINDOW_SIZE) >= 6) {
                        break;
                    }
                    i6++;
                }
                boolean z4 = i5 != i6;
                if (i6 <= length) {
                    if (str.charAt(i6) == '.') {
                        int i7 = i6 + 1;
                        i2 = i7;
                        while (i2 <= length) {
                            if (((str.charAt(i2) - '0') & Settings.DEFAULT_INITIAL_WINDOW_SIZE) >= 10 && (((r15 | ' ') - 97) & Settings.DEFAULT_INITIAL_WINDOW_SIZE) >= 6) {
                                break;
                            }
                            i2++;
                        }
                        if (i7 != i2) {
                            z3 = true;
                            if (!z4 || z3) {
                                i3 = i2;
                                if (i3 != -1 || i3 > length) {
                                    return false;
                                }
                                z = true;
                                if (!z) {
                                    int i8 = i3;
                                    while (i8 <= length && ((str.charAt(i8) - '0') & Settings.DEFAULT_INITIAL_WINDOW_SIZE) < 10) {
                                        i8++;
                                    }
                                    boolean z5 = i3 != i8;
                                    if (i8 > length) {
                                        i3 = i8;
                                    } else {
                                        if (str.charAt(i8) == '.') {
                                            int i9 = i8 + 1;
                                            i = i9;
                                            while (i <= length && ((str.charAt(i) - '0') & Settings.DEFAULT_INITIAL_WINDOW_SIZE) < 10) {
                                                i++;
                                            }
                                            if (i9 != i) {
                                                z2 = true;
                                                if (!z5 || z2) {
                                                    i3 = i;
                                                } else {
                                                    String str2 = length == i + 2 ? "NaN" : length == i + 7 ? "Infinity" : null;
                                                    i3 = (str2 != null && StringsKt.k0(str, str2, i, false) == i) ? length + 1 : -1;
                                                }
                                            }
                                        } else {
                                            i = i8;
                                        }
                                        z2 = false;
                                        if (z5) {
                                        }
                                        i3 = i;
                                    }
                                    if (i3 == -1) {
                                        return false;
                                    }
                                    if (i3 > length) {
                                        return true;
                                    }
                                }
                                int i10 = i3 + 1;
                                charAt = str.charAt(i3) | ' ';
                                if (charAt == (!z ? Sdk$SDKError.Reason.ASSET_REQUEST_ERROR_VALUE : 101)) {
                                    return !z && (charAt == 102 || charAt == 100) && i10 > length;
                                }
                                if (i10 > length) {
                                    return false;
                                }
                                if ((str.charAt(i10) == '+' || str.charAt(i10) == '-') && (i10 = i3 + 2) > length) {
                                    return false;
                                }
                                while (i10 <= length && ((str.charAt(i10) - '0') & Settings.DEFAULT_INITIAL_WINDOW_SIZE) < 10) {
                                    i10++;
                                }
                                if (i10 > length) {
                                    return true;
                                }
                                if (i10 != length) {
                                    return false;
                                }
                                int charAt2 = str.charAt(i10) | ' ';
                                return charAt2 == 102 || charAt2 == 100;
                            }
                        }
                    } else {
                        i2 = i6;
                    }
                    z3 = false;
                    if (!z4) {
                    }
                    i3 = i2;
                    if (i3 != -1) {
                    }
                    return false;
                }
                i3 = -1;
                if (i3 != -1) {
                }
                return false;
            }
        }
        z = false;
        if (!z) {
        }
        int i102 = i3 + 1;
        charAt = str.charAt(i3) | ' ';
        if (charAt == (!z ? Sdk$SDKError.Reason.ASSET_REQUEST_ERROR_VALUE : 101)) {
        }
    }

    public static Double s(String str) {
        Intrinsics.h(str, "<this>");
        try {
            if (r(str)) {
                return Double.valueOf(Double.parseDouble(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Float t(String str) {
        Intrinsics.h(str, "<this>");
        try {
            if (r(str)) {
                return Float.valueOf(Float.parseFloat(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
