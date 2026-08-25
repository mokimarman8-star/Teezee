package com.transsion.api.gateway.utils;

import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.hisavana.common.constant.ComConstants;
import java.lang.reflect.Method;
import java.util.TimeZone;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class DeviceUtils {
    private static String mAndroidId = "";
    private static String mGAId = "";
    private static String mImei = "";
    private static String osVersion = "";

    private static void appendNumber(StringBuilder sb, int i, int i2) {
        String num = Integer.toString(i2);
        for (int i3 = 0; i3 < i - num.length(); i3++) {
            sb.append('0');
        }
        sb.append(num);
    }

    private static String createGmtOffsetString(boolean z, boolean z2, int i) {
        char c;
        int i2 = i / ComConstants.defScheduleTime;
        if (i2 < 0) {
            i2 = -i2;
            c = '-';
        } else {
            c = '+';
        }
        StringBuilder sb = new StringBuilder(9);
        if (z) {
            sb.append("GMT");
        }
        sb.append(c);
        appendNumber(sb, 2, i2 / 60);
        if (z2) {
            sb.append(':');
        }
        appendNumber(sb, 2, i2 % 60);
        return sb.toString();
    }

    public static String getAndroidID() {
        if (!TextUtils.isEmpty(mAndroidId)) {
            return mAndroidId;
        }
        String string = Settings.Secure.getString(ContextUtils.getContext().getContentResolver(), "android_id");
        if (!TextUtils.isEmpty(string)) {
            string = string.trim();
        }
        String EncoderByAlgorithm = TextUtils.isEmpty(string) ? "" : EncoderUtil.EncoderByAlgorithm(string);
        mAndroidId = EncoderByAlgorithm;
        return EncoderByAlgorithm;
    }

    public static String getBTMAC() {
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            return (PermissionUtils.lacksPermission("android.permission.BLUETOOTH") || defaultAdapter == null) ? "" : defaultAdapter.getAddress();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getBatteryCapacity(Context context) {
        double d;
        try {
            d = ((Double) Class.forName("com.android.internal.os.PowerProfile").getMethod("getBatteryCapacity", null).invoke(Class.forName("com.android.internal.os.PowerProfile").getConstructor(Context.class).newInstance(context), null)).doubleValue();
        } catch (Exception e) {
            e.printStackTrace();
            d = 0.0d;
        }
        return String.valueOf(d + " mAh");
    }

    public static String getCountryZipCode(Context context) {
        return context.getResources().getConfiguration().locale.getCountry();
    }

    public static String getGAId() {
        String str = mGAId;
        if (str == null || str.length() == 0) {
            new Thread(new Runnable() { // from class: com.transsion.api.gateway.utils.DeviceUtils.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String unused = DeviceUtils.mGAId = AdvertisingIdClient.getAdvertisingIdInfo(ContextUtils.getContext()).getId();
                        GatewayUtils.L.d("advertisingId is " + DeviceUtils.mGAId);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        return mGAId;
    }

    public static String getIMEI(int i) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) ContextUtils.getContext().getApplicationContext().getSystemService("phone");
            Class<?> cls = telephonyManager.getClass();
            Class<?> cls2 = Integer.TYPE;
            String str = (String) cls.getMethod("getImei", cls2).invoke(telephonyManager, Integer.valueOf(i));
            if (TextUtils.isEmpty(str)) {
                str = (String) telephonyManager.getClass().getMethod("getDeviceId", cls2).invoke(telephonyManager, Integer.valueOf(i));
            }
            return (TextUtils.isEmpty(str) || str.length() < 15) ? str : EncoderUtil.EncoderByAlgorithm(str);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getIMSI() {
        try {
            Context context = ContextUtils.getContext();
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", context.getApplicationContext().getPackageName()) != 0) {
                return getSimOperator();
            }
            String subscriberId = telephonyManager != null ? telephonyManager.getSubscriberId() : null;
            if (subscriberId != null && subscriberId.length() >= 8) {
                return subscriberId.substring(0, 8);
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getIMSI(int i) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) ContextUtils.getContext().getApplicationContext().getSystemService("phone");
            String str = (String) telephonyManager.getClass().getMethod("getSubscriberId", Integer.TYPE).invoke(telephonyManager, Integer.valueOf(i));
            return !TextUtils.isEmpty(str) ? EncoderUtil.EncoderByAlgorithm(str) : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getMcc() {
        String simOperator = getSimOperator();
        return (TextUtils.isEmpty(simOperator) || simOperator.length() < 3) ? "" : simOperator.substring(0, 3);
    }

    public static String getMnc() {
        String simOperator = getSimOperator();
        return (TextUtils.isEmpty(simOperator) || simOperator.length() < 3) ? "" : simOperator.substring(3);
    }

    public static String getOSVersion() {
        if (TextUtils.isEmpty(osVersion)) {
            try {
                Method method = Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class);
                String str = (String) method.invoke(null, "ro.tranos.version", "");
                osVersion = str;
                if (TextUtils.isEmpty(str)) {
                    osVersion = (String) method.invoke(null, "ro.os_product.version", "");
                }
            } catch (Exception unused) {
            }
        }
        return osVersion;
    }

    public static String getSerialNumber() {
        String str;
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                str = a.a();
            } catch (Exception unused) {
                str = "";
            }
        } else {
            str = Build.SERIAL;
        }
        try {
            if (TextUtils.isEmpty(str) || "unknown".equals(str)) {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                str = (String) cls.getMethod("get", String.class).invoke(cls, "ro.serialno");
            }
        } catch (Exception unused2) {
        }
        return TextUtils.isEmpty(str) ? "" : EncoderUtil.EncoderByAlgorithm(str);
    }

    public static String getSimOperator() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) ContextUtils.getContext().getSystemService("phone");
            return telephonyManager == null ? "" : telephonyManager.getSimOperator();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getTimeZone() {
        try {
            return createGmtOffsetString(true, true, TimeZone.getDefault().getRawOffset());
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static long getTotalRAM(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static long getTotalROM(Context context) {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCountLong() * statFs.getBlockSizeLong();
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static String getVersionName() {
        try {
            Context context = ContextUtils.getContext();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static boolean isCurrentMainThread() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static boolean isPad() {
        Context context = ContextUtils.getContext();
        return context.getResources() != null && (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }
}
