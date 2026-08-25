package com.cloud.tmc.kernel.utils;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.tmc.kernel.log.TmcLogger;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class BundleUtils {
    private static final String TAG = "TmcKernel:BundleUtils";

    public static Bundle clone(Bundle bundle) {
        return bundle == null ? new Bundle() : (Bundle) bundle.clone();
    }

    public static boolean contains(Bundle bundle, String str) {
        if (bundle == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return bundle.containsKey(str);
    }

    public static boolean getBoolean(Bundle bundle, String str, boolean z) {
        return ((Boolean) getValue(bundle, str, Boolean.valueOf(z))).booleanValue();
    }

    public static byte[] getByteArray(Bundle bundle, @Nullable String str) {
        if (bundle != null && !TextUtils.isEmpty(str)) {
            try {
                return bundle.getByteArray(str);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static int getInt(Bundle bundle, String str) {
        return getInt(bundle, str, 0);
    }

    public static int getInt(Bundle bundle, String str, int i) {
        Integer num;
        if (bundle != null) {
            try {
                return (TextUtils.isEmpty(str) || !bundle.containsKey(str) || (num = (Integer) bundle.get(str)) == null) ? i : num.intValue();
            } catch (Exception e) {
                TmcLogger.e("get json value exception", e);
            }
        }
        return i;
    }

    public static long getLong(Bundle bundle, String str) {
        return getLong(bundle, str, 0L);
    }

    public static long getLong(Bundle bundle, String str, long j) {
        Long l;
        if (bundle != null) {
            try {
                return (TextUtils.isEmpty(str) || !bundle.containsKey(str) || (l = (Long) bundle.get(str)) == null) ? j : l.longValue();
            } catch (Exception e) {
                TmcLogger.e("get json value exception", e);
            }
        }
        return j;
    }

    public static <T extends Parcelable> T getParcelable(Bundle bundle, @Nullable String str) {
        if (bundle != null && !TextUtils.isEmpty(str)) {
            try {
                return (T) bundle.getParcelable(str);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static Object getSerializable(Bundle bundle, @Nullable String str) {
        if (bundle != null && !TextUtils.isEmpty(str)) {
            try {
                return bundle.getSerializable(str);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static String getString(Bundle bundle, String str) {
        return getString(bundle, str, "");
    }

    public static String getString(Bundle bundle, String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        if (bundle != null) {
            try {
                if (TextUtils.isEmpty(str) || !bundle.containsKey(str)) {
                    return str2;
                }
                String str3 = (String) bundle.get(str);
                if (str3 != null) {
                    return str3;
                }
            } catch (Exception e) {
                TmcLogger.e("get json value exception", e);
            }
        }
        return str2;
    }

    public static <T> T getValue(Bundle bundle, String str, T t) {
        T t2;
        if (bundle != null) {
            try {
                return (TextUtils.isEmpty(str) || t == null || !bundle.containsKey(str) || (t2 = (T) bundle.get(str)) == null) ? t : t.getClass().isAssignableFrom(t2.getClass()) ? t2 : t;
            } catch (Exception e) {
                TmcLogger.e("get json value exception", e);
            }
        }
        return t;
    }

    @NonNull
    public static Map<String, Object> toHashMap(@Nullable Bundle bundle) {
        HashMap hashMap = new HashMap();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                hashMap.put(str, bundle.get(str));
            }
        }
        return hashMap;
    }

    public static void tryUnparcel(Bundle bundle) {
        if (bundle != null) {
            try {
                bundle.get("aaa");
            } catch (Throwable th) {
                TmcLogger.e(TAG, "unparcel exception!", th);
            }
        }
    }
}
