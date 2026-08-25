package k7;

import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.hardware.camera2.CameraManager;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.view.accessibility.AccessibilityManager;
import androidx.core.content.b;
import com.cloud.sdk.commonutil.util.c;
import com.cloud.sdk.commonutil.util.e;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.mvel2.ast.ASTNode;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class a {
    private static String a0;
    private static String b0;
    private static volatile Boolean c0;
    private static volatile String d0;
    private static final boolean a = Log.isLoggable("anti_fraud_log", 3);
    private static Intent b = null;
    private static BroadcastReceiver c = null;
    private static int d = -1;
    private static int e = -1;
    private static int f = -1;
    private static final String[] g = {"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};
    private static int h = -1;
    private static int i = -1;
    private static int j = -1;
    private static int k = -1;
    private static final String[] l = {"com.bly.dkplat", "com.by.chaos", "com.lbe.parallel", "com.excelliance.dualaid", "com.lody.virtual", "com.qihoo.magic", "com.dual.dualgenius", "com.jiubang.commerce.gomultiple"};
    private static int m = -1;
    private static final String[] n = {"/dev/socket/qemud", "/dev/qemu_pipe"};
    private static final String[] o = {"goldfish"};
    private static final String[] p = {"/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props"};
    private static int q = -1;
    private static int r = -1;
    private static int s = -1;
    private static boolean t = false;
    private static int u = -1;
    private static String v = "bluetooth_name";
    private static String w = "base_band_version";
    private static String x = "boot_time";
    private static String y = "phone_name";
    private static String z = "ssid";
    private static boolean A = false;
    private static String[] B = new String[0];
    private static String C = "screen_brightness";
    private static String D = "battery_percent";
    private static String E = "charge_type";
    private static String F = "rom_name";
    private static String G = "rom_build_time";
    private static String H = "os_api";
    private static String I = "build_id";
    private static String J = "cpu_cores";
    private static String K = "cpu_cores_cnt";
    private static String L = "cpu_abi";
    private static String M = "cpu_kernel";
    private static String N = "board";
    private static String O = "hard_ware";
    private static String P = "finger_print";
    private static int Q = 0;
    private static boolean R = false;
    private static String S = "phone_height";
    private static int T = 0;
    private static boolean U = false;
    private static int V = 0;
    private static int W = 0;
    private static boolean X = false;
    private static final AtomicBoolean Y = new AtomicBoolean(true);
    private static final Bundle Z = new Bundle();

    /* renamed from: k7.a$a, reason: collision with other inner class name */
    class C0007a extends BroadcastReceiver {
        C0007a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            c.Log().d("anti_fraud_log", "batteryBroadcastReceiver receive");
        }
    }

    private static String A() {
        if (!"cpu_abi".equals(L)) {
            return L;
        }
        try {
            L = w0(Build.CPU_ABI);
        } catch (Exception e3) {
            L = "";
            r0(Log.getStackTraceString(e3));
        }
        return L;
    }

    private static String B() {
        if (!"cpu_cores".equals(J)) {
            return J;
        }
        try {
            J = w0(Build.CPU_ABI);
        } catch (Exception e3) {
            J = "";
            r0(Log.getStackTraceString(e3));
        }
        return J;
    }

    private static String C() {
        try {
        } catch (Exception e3) {
            K = "";
            r0(Log.getStackTraceString(e3));
        }
        if (!g0(22)) {
            return "cpu_cores_cnt";
        }
        if (!"cpu_cores_cnt".equals(K)) {
            return K;
        }
        K = Integer.toHexString(g(Runtime.getRuntime().availableProcessors(), E() / 1000));
        return K;
    }

    private static String D() {
        if (!"cpu_kernel".equals(M)) {
            return M;
        }
        try {
            M = w0(Build.CPU_ABI2);
        } catch (Exception e3) {
            M = "";
            r0(Log.getStackTraceString(e3));
        }
        return M;
    }

    private static int E() {
        int i2 = 0;
        try {
            FileReader fileReader = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq");
            try {
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                try {
                    i2 = Integer.parseInt(bufferedReader.readLine().trim());
                    bufferedReader.close();
                    fileReader.close();
                } finally {
                }
            } finally {
            }
        } catch (Exception e3) {
            r0(Log.getStackTraceString(e3));
        }
        return i2;
    }

    private static String F() {
        try {
        } catch (Exception e3) {
            v = "";
            r0(Log.getStackTraceString(e3));
        }
        if (!g0(18)) {
            return "bluetooth_name";
        }
        if (!"bluetooth_name".equals(v)) {
            return v;
        }
        if (Build.VERSION.SDK_INT > 30 && b.checkSelfPermission(e.a().getApplicationContext(), "android.permission.BLUETOOTH_CONNECT") != 0) {
            return v;
        }
        BluetoothAdapter adapter = ((BluetoothManager) e.a().getSystemService("bluetooth")).getAdapter();
        v = adapter != null ? w0(adapter.getName()) : "";
        return v;
    }

    private static void G() {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long blockSizeLong = statFs.getBlockSizeLong();
            if (blockSizeLong == 0) {
                return;
            }
            long blockCountLong = statFs.getBlockCountLong();
            long availableBlocksLong = statFs.getAvailableBlocksLong();
            V = (int) ((blockCountLong * blockSizeLong) / 1048576);
            W = (int) ((availableBlocksLong * blockSizeLong) / 1048576);
        }
    }

    private static String H() {
        if (!"finger_print".equals(P)) {
            return P;
        }
        try {
            P = w0(Build.FINGERPRINT);
        } catch (Exception e3) {
            P = "";
            r0(Log.getStackTraceString(e3));
        }
        return P;
    }

    private static String I() {
        if (!"hard_ware".equals(O)) {
            return O;
        }
        try {
            O = w0(Build.HARDWARE);
        } catch (Exception e3) {
            O = "";
            r0(Log.getStackTraceString(e3));
        }
        return O;
    }

    private static String J() {
        try {
        } catch (Exception e3) {
            r0(Log.getStackTraceString(e3));
        }
        if (!g0(23)) {
            return Integer.toHexString(0);
        }
        if (R) {
            return Integer.toHexString(Q);
        }
        R = true;
        String[] cameraIdList = ((CameraManager) e.a().getSystemService("camera")).getCameraIdList();
        if (cameraIdList.length > 0) {
            Q = cameraIdList.length;
        }
        return Integer.toHexString(Q);
    }

    private static String K() {
        if (!"os_api".equals(H)) {
            return H;
        }
        try {
            H = Integer.toHexString(Build.VERSION.SDK_INT);
        } catch (Exception e3) {
            H = "";
            r0(Log.getStackTraceString(e3));
        }
        return H;
    }

    private static String L() {
        if (!"phone_height".equals(S)) {
            return S;
        }
        try {
            S = Integer.toHexString(g(c.k(), c.j()));
        } catch (Exception e3) {
            S = "";
            r0(Log.getStackTraceString(e3));
        }
        return S;
    }

    private static String M() {
        if (!"phone_name".equals(y)) {
            return y;
        }
        try {
            y = w0(Build.DEVICE);
        } catch (Exception e3) {
            y = "";
            r0(Log.getStackTraceString(e3));
        }
        return y;
    }

    private static String N() {
        if (!"rom_build_time".equals(G)) {
            return G;
        }
        try {
            return Long.toHexString(Build.TIME);
        } catch (Exception e3) {
            G = "";
            r0(Log.getStackTraceString(e3));
            return G;
        }
    }

    private static String O() {
        if (!"rom_name".equals(F)) {
            return F;
        }
        try {
            F = w0(Build.MANUFACTURER);
        } catch (Exception e3) {
            F = "";
            r0(Log.getStackTraceString(e3));
        }
        return F;
    }

    private static String P() {
        return "";
    }

    private static String Q() {
        try {
        } catch (Exception e3) {
            C = "";
            r0(Log.getStackTraceString(e3));
        }
        if (!g0(20)) {
            return "screen_brightness";
        }
        if (!"screen_brightness".equals(C)) {
            return C;
        }
        C = Integer.toHexString(g(Settings.System.getInt(e.a().getContentResolver(), "screen_brightness"), 255));
        return C;
    }

    private static String R() {
        if (!"ssid".equals(z)) {
            return z;
        }
        try {
            WifiInfo connectionInfo = ((WifiManager) e.a().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            z = connectionInfo != null ? w0(connectionInfo.getSSID()) : "";
        } catch (Exception e3) {
            z = "";
            r0(Log.getStackTraceString(e3));
        }
        return z;
    }

    private static String S() {
        try {
            if (!g0(25)) {
                return Integer.toHexString(0);
            }
            if (X) {
                return Integer.toHexString(V);
            }
            X = true;
            G();
            return Integer.toHexString(V);
        } catch (Exception e3) {
            r0(Log.getStackTraceString(e3));
            return "";
        }
    }

    private static String T() {
        if (!g0(24)) {
            return Integer.toHexString(0);
        }
        if (U) {
            return Integer.toHexString(T);
        }
        U = true;
        try {
            FileReader fileReader = new FileReader("/proc/meminfo");
            try {
                BufferedReader bufferedReader = new BufferedReader(fileReader, 8192);
                try {
                    T = Integer.parseInt(bufferedReader.readLine().split("\\s+")[1]) / 1024;
                    bufferedReader.close();
                    fileReader.close();
                } finally {
                }
            } finally {
            }
        } catch (Exception e3) {
            r0(Log.getStackTraceString(e3));
        }
        return Integer.toHexString(T);
    }

    private static String[] U() {
        try {
        } catch (Exception e3) {
            r0(Log.getStackTraceString(e3));
        }
        if (!g0(19)) {
            return new String[0];
        }
        if (A) {
            return B;
        }
        A = true;
        if (b.checkSelfPermission(e.a().getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION") == 0 && b.checkSelfPermission(e.a().getApplicationContext(), "android.permission.ACCESS_WIFI_STATE") == 0) {
            List<ScanResult> scanResults = ((WifiManager) e.a().getApplicationContext().getSystemService("wifi")).getScanResults();
            ArrayList arrayList = new ArrayList();
            if (scanResults != null && !scanResults.isEmpty()) {
                for (int i2 = 0; i2 < scanResults.size(); i2++) {
                    ScanResult scanResult = scanResults.get(i2);
                    if (arrayList.size() > 4) {
                        break;
                    }
                    if (!scanResult.SSID.isEmpty()) {
                        arrayList.add(w0(scanResult.SSID));
                    }
                }
            }
            B = (String[]) arrayList.toArray(new String[0]);
            return B;
        }
        return B;
    }

    private static void V() {
        if (b == null) {
            try {
                c = new C0007a();
                if (Build.VERSION.SDK_INT >= 33) {
                    b = com.bytedance.sdk.openadsdk.core.settings.a.a(e.a(), c, new IntentFilter("android.intent.action.BATTERY_CHANGED"), 2);
                } else {
                    b = e.a().registerReceiver(c, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                }
            } catch (Exception unused) {
            }
        }
    }

    private static int W() {
        int i2;
        try {
            i2 = 0;
        } catch (Exception e3) {
            r0(Log.getStackTraceString(e3));
        }
        if (!g0(9)) {
            return 0;
        }
        int i3 = i;
        if (i3 != -1) {
            return i3;
        }
        i = 0;
        boolean isEnabled = ((AccessibilityManager) e.a().getSystemService("accessibility")).isEnabled();
        boolean l0 = l0();
        if (isEnabled && l0) {
            i2 = ASTNode.THISREF;
        }
        i = i2;
        return i;
    }

    private static boolean X(Context context, String str) {
        TextUtils.SimpleStringSplitter simpleStringSplitter = new TextUtils.SimpleStringSplitter(':');
        String string = Settings.Secure.getString(context.getApplicationContext().getContentResolver(), "enabled_accessibility_services");
        if (string == null) {
            return false;
        }
        simpleStringSplitter.setString(string);
        while (simpleStringSplitter.hasNext()) {
            if (simpleStringSplitter.next().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    private static int Y() {
        try {
        } catch (Exception e3) {
            r0(Log.getStackTraceString(e3));
        }
        if (!g0(8)) {
            return 0;
        }
        int i2 = h;
        if (i2 != -1) {
            return i2;
        }
        h = 0;
        boolean z2 = true;
        boolean z3 = Settings.Secure.getInt(e.a().getContentResolver(), "development_settings_enabled", 0) != 0;
        if (Settings.Secure.getInt(e.a().getContentResolver(), "adb_enabled", 0) == 0) {
            z2 = false;
        }
        h = (z3 || z2) ? ASTNode.COLLECTION : 0;
        return h;
    }

    private static int Z() {
        try {
        } catch (Exception e3) {
            r0(Log.getStackTraceString(e3));
        }
        if (!o0(4)) {
            return 32;
        }
        int i2 = e;
        if (i2 != -1) {
            return i2;
        }
        e = 32;
        PackageManager packageManager = e.a().getPackageManager();
        e = packageManager != null ? packageManager.hasSystemFeature("android.hardware.camera.any") : false ? 16 : 0;
        return e;
    }

    private static int a(int i2, int i3) {
        return i2 | i3;
    }

    private static int a0() {
        g0(7);
        return 0;
    }

    private static boolean b() {
        return "android".equalsIgnoreCase(Build.BRAND) || Build.MODEL.toLowerCase().contains("sdk");
    }

    private static int b0() {
        try {
        } catch (Exception e3) {
            r0(Log.getStackTraceString(e3));
        }
        if (!o0(0)) {
            return 2;
        }
        V();
        Intent intent = b;
        if (intent != null) {
            int intExtra = intent.getIntExtra("status", -1);
            f();
            if (intExtra == 2) {
                return 1;
            }
            return intExtra == 1 ? 2 : 0;
        }
        f();
        return 2;
    }

    private static boolean c() {
        for (String str : p) {
            if (new File(str).exists()) {
                return true;
            }
        }
        return false;
    }

    private static int c0() {
        int i2;
        try {
            i2 = 0;
        } catch (Exception e3) {
            r0(Log.getStackTraceString(e3));
        }
        if (!g0(13)) {
            return 0;
        }
        int i3 = m;
        if (i3 != -1) {
            return i3;
        }
        m = 0;
        if (!b()) {
            if (!c()) {
                if (!e()) {
                    if (d()) {
                    }
                    m = i2;
                    return m;
                }
            }
        }
        i2 = 8192;
        m = i2;
        return m;
    }

    private static boolean d() {
        for (String str : n) {
            if (new File(str).exists()) {
                return true;
            }
        }
        return false;
    }

    private static int d0() {
        int i2;
        try {
            i2 = 0;
        } catch (Exception e3) {
            r0(Log.getStackTraceString(e3));
        }
        if (!g0(10)) {
            return 0;
        }
        int i3 = j;
        if (i3 != -1) {
            return i3;
        }
        j = 0;
        if (!j()) {
            if (!i()) {
                if (k()) {
                }
                j = i2;
                return j;
            }
        }
        i2 = 1024;
        j = i2;
        return j;
    }

    private static boolean e() {
        File file = new File("/proc/tty/drivers");
        if (file.exists() && file.canRead()) {
            byte[] bArr = new byte[1024];
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    if (fileInputStream.read(bArr) > 0) {
                        String str = new String(bArr);
                        for (String str2 : o) {
                            if (str.contains(str2)) {
                                fileInputStream.close();
                                return true;
                            }
                        }
                    }
                    fileInputStream.close();
                } finally {
                }
            } catch (Exception e3) {
                r0(Log.getStackTraceString(e3));
            }
        }
        return false;
    }

    private static int e0() {
        int i2;
        try {
            i2 = 0;
        } catch (Exception e3) {
            r0(Log.getStackTraceString(e3));
        }
        if (!g0(16)) {
            return 0;
        }
        int i3 = s;
        if (i3 != -1) {
            return i3;
        }
        s = 0;
        if (b.checkSelfPermission(e.a(), "android.permission.ACCESS_FINE_LOCATION") == 0 || b.checkSelfPermission(e.a(), "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            ((LocationManager) e.a().getSystemService("location")).setTestProviderEnabled("gps", true);
            i2 = ASTNode.BLOCK_DO;
        } else {
            r0("No location permission is currently available");
        }
        s = i2;
        return s;
    }

    private static void f() {
        b = null;
        if (c != null) {
            e.a().unregisterReceiver(c);
            c = null;
        }
    }

    private static int f0() {
        if (g0(17) && t) {
            return ASTNode.BLOCK_DO_UNTIL;
        }
        return 0;
    }

    public static int g(int i2, int i3) {
        if (i2 > 65535 || i3 > 65535) {
            return -1;
        }
        return (i2 << 16) ^ i3;
    }

    private static boolean g0(int i2) {
        try {
            String o2 = o();
            if (o2.length() < i2 + 1) {
                return true;
            }
            String sb = new StringBuilder(o2).reverse().toString();
            return !(sb.charAt(i2) + "").equals("1");
        } catch (Exception unused) {
            return true;
        }
    }

    private static boolean h(Exception exc) {
        int i2 = 0;
        for (StackTraceElement stackTraceElement : exc.getStackTrace()) {
            if ("com.android.internal.os.ZygoteInit".equals(stackTraceElement.getClassName())) {
                i2++;
                if (i2 == 2) {
                    return true;
                }
            } else {
                if ("com.saurik.substrate.MS$2".equals(stackTraceElement.getClassName()) && "invoked".equals(stackTraceElement.getMethodName())) {
                    return true;
                }
                if ("de.robv.android.xposed.XposedBridge".equals(stackTraceElement.getClassName()) && "main".equals(stackTraceElement.getMethodName())) {
                    return true;
                }
                if ("de.robv.android.xposed.XposedBridge".equals(stackTraceElement.getClassName()) && "handleHookedMethod".equals(stackTraceElement.getMethodName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean h0() {
        if (c0 == null) {
            c0 = Boolean.valueOf(l7.a.e().d("is_open_anti_fraud_sp_key", false));
        }
        return c0.booleanValue();
    }

    private static boolean i() {
        HashSet<String> hashSet = new HashSet();
        try {
            FileReader fileReader = new FileReader("/proc/" + Process.myPid() + "/maps");
            try {
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (!readLine.endsWith(".so") && !readLine.endsWith(".jar")) {
                        }
                        hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
                    } finally {
                    }
                }
                for (String str : hashSet) {
                    if (str.contains("com.saurik.substrate")) {
                        bufferedReader.close();
                        fileReader.close();
                        return true;
                    }
                    if (str.contains("XposedBridge.jar")) {
                        bufferedReader.close();
                        fileReader.close();
                        return true;
                    }
                }
                bufferedReader.close();
                fileReader.close();
                return false;
            } finally {
            }
        } catch (Exception e3) {
            r0(Log.getStackTraceString(e3));
            return false;
        }
    }

    private static int i0() {
        int i2;
        try {
            i2 = 0;
        } catch (Exception e3) {
            r0(Log.getStackTraceString(e3));
        }
        if (!g0(12)) {
            return 0;
        }
        int i3 = k;
        if (i3 != -1) {
            return i3;
        }
        k = 0;
        String path = e.a().getFilesDir().getPath();
        String[] strArr = l;
        int length = strArr.length;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                break;
            }
            if (path.contains(strArr[i4])) {
                i2 = 4096;
                break;
            }
            i4++;
        }
        k = i2;
        return k;
    }

    private static boolean j() {
        return false;
    }

    private static int j0() {
        g0(11);
        return 0;
    }

    private static boolean k() {
        try {
            throw new AndroidRuntimeException("findhook");
        } catch (Exception e3) {
            return h(e3);
        }
    }

    private static int k0() {
        boolean z2;
        try {
        } catch (Exception e3) {
            r0(Log.getStackTraceString(e3));
        }
        if (!g0(6)) {
            return 0;
        }
        int i2 = f;
        if (i2 != -1) {
            return i2;
        }
        f = 0;
        String[] strArr = g;
        int length = strArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                z2 = false;
                break;
            }
            if (new File(strArr[i3]).exists()) {
                z2 = true;
                break;
            }
            i3++;
        }
        String str = Build.TAGS;
        f = ((str != null && str.contains("test-keys")) || z2) ? 64 : 0;
        return f;
    }

    private static void l() {
        Bundle bundle = Z;
        bundle.putString("bbv", r());
        bundle.putString("bt", w());
        bundle.putString("phn", M());
        bundle.putString("si", R());
        bundle.putStringArray("bl", U());
        bundle.putString("sb", Q());
        bundle.putString("bpc", t());
        bundle.putString("ct", y());
        bundle.putString("rn", O());
        bundle.putString("rv", P());
        bundle.putString("rb", N());
        bundle.putString("oa", K());
        bundle.putString("bi", x());
        bundle.putString("cc", B());
        bundle.putString("ccf", C());
        bundle.putString("ca", A());
        bundle.putString("ck", D());
        bundle.putString("bd", v());
        bundle.putString("hw", I());
        bundle.putString("fp", H());
        bundle.putString("noc", J());
        bundle.putString("ps", L());
        bundle.putString("tm", T());
        bundle.putString("td", S());
        bundle.putString("am", q());
        bundle.putString("ad", p());
        bundle.putString("cp", Integer.toHexString(z()));
    }

    private static boolean l0() {
        Intent intent = new Intent("android.accessibilityservice.AccessibilityService");
        intent.addCategory("android.accessibilityservice.category.FEEDBACK_SPOKEN");
        boolean z2 = false;
        List<ResolveInfo> queryIntentServices = e.a().getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices.isEmpty()) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 26) {
            ArrayList arrayList = new ArrayList();
            Iterator<ActivityManager.RunningServiceInfo> it = ((ActivityManager) e.a().getSystemService("activity")).getRunningServices(Integer.MAX_VALUE).iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().service.getPackageName());
            }
            Iterator<ResolveInfo> it2 = queryIntentServices.iterator();
            while (it2.hasNext()) {
                if (arrayList.contains(it2.next().serviceInfo.packageName)) {
                    return true;
                }
            }
            return false;
        }
        for (ResolveInfo resolveInfo : queryIntentServices) {
            z2 |= X(e.a(), resolveInfo.serviceInfo.packageName + "/" + resolveInfo.serviceInfo.name);
        }
        return z2;
    }

    public static String m() {
        if (!TextUtils.isEmpty(b0)) {
            return b0;
        }
        if (!h0()) {
            r0("=========== getAntiFraudLiteString server close ===========");
            return "";
        }
        if (Y.get()) {
            return "";
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("phn", M());
            bundle.putString("bt", w());
            bundle.putString("si", R());
            bundle.putStringArray("bl", U());
            bundle.putString("sb", Q());
            bundle.putString("bpc", t());
            bundle.putString("rn", O());
            bundle.putString("rv", P());
            bundle.putString("rb", N());
            bundle.putString("oa", K());
            bundle.putString("cp", Integer.toHexString(z()));
            b0 = n(bundle);
        } catch (Exception e3) {
            r0(Log.getStackTraceString(e3));
        }
        if (TextUtils.isEmpty(b0)) {
            b0 = "";
        }
        return b0;
    }

    private static int m0() {
        try {
        } catch (Exception e3) {
            r0(Log.getStackTraceString(e3));
        }
        if (!o0(2)) {
            return 8;
        }
        int i2 = d;
        if (i2 != -1) {
            return i2;
        }
        if (b.checkSelfPermission(e.a(), "android.permission.READ_PHONE_STATE") != 0) {
            return 8;
        }
        d = 8;
        TelephonyManager telephonyManager = (TelephonyManager) e.a().getSystemService("phone");
        String subscriberId = telephonyManager != null ? telephonyManager.getSubscriberId() : "";
        if (subscriberId != null && subscriberId.length() > 0) {
            d = 4;
            return d;
        }
        d = 0;
        return d;
    }

    private static String n(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            Set<String> keySet = bundle.keySet();
            sb.append("bn");
            sb.append("\u0002");
            sb.append(F());
            for (String str : keySet) {
                Object obj = bundle.get(str);
                if (obj instanceof String) {
                    if (TextUtils.isEmpty((String) obj)) {
                        obj = "\"\"";
                    }
                    sb.append("\u0001");
                    sb.append(str);
                    sb.append("\u0002");
                    sb.append(obj);
                } else if (obj instanceof Float) {
                    sb.append("\u0001");
                    sb.append(str);
                    sb.append("\u0002");
                    sb.append(obj);
                } else if (obj instanceof float[]) {
                    sb.append("\u0001");
                    sb.append(str);
                    sb.append("\u0002");
                    sb.append(Arrays.toString((float[]) obj));
                } else if (obj instanceof String[]) {
                    sb.append("\u0001");
                    sb.append(str);
                    sb.append("\u0002");
                    sb.append(Arrays.toString((String[]) obj));
                }
            }
        } catch (Exception e3) {
            r0(Log.getStackTraceString(e3));
            sb.append("");
        }
        return com.cloud.sdk.commonutil.util.a.a(sb.toString());
    }

    public static boolean n0() {
        int i2 = u;
        if (i2 >= 0) {
            return i2 == 1;
        }
        if (TextUtils.equals(o(), "0")) {
            u = 1;
        } else {
            u = g0(27) ? 1 : 0;
        }
        return u == 1;
    }

    public static String o() {
        if (TextUtils.isEmpty(d0)) {
            d0 = l7.a.e().k("anti_fraud_sub_function_sp_key", "");
            if (d0.isEmpty()) {
                d0 = "0";
            }
        }
        return d0;
    }

    private static boolean o0(int i2) {
        try {
            String o2 = o();
            if (o2.equals("1")) {
                o2 = "01";
            }
            return !new StringBuilder(o2).reverse().toString().substring(i2, i2 + 2).equals("10");
        } catch (Exception unused) {
            return true;
        }
    }

    private static String p() {
        if (X) {
            return Integer.toHexString(W);
        }
        try {
            return Integer.toHexString(W);
        } catch (Exception e3) {
            r0(Log.getStackTraceString(e3));
            return "";
        }
    }

    private static int p0() {
        int i2;
        try {
            i2 = 0;
        } catch (Exception e3) {
            r0(Log.getStackTraceString(e3));
        }
        if (!g0(15)) {
            return 0;
        }
        int i3 = r;
        if (i3 != -1) {
            return i3;
        }
        r = 0;
        String property = System.getProperty("http.proxyHost");
        String property2 = System.getProperty("http.proxyPort");
        if (property2 == null) {
            property2 = "-1";
        }
        int parseInt = Integer.parseInt(property2);
        if (!TextUtils.isEmpty(property) && parseInt != -1) {
            i2 = ASTNode.BLOCK_WHILE;
        }
        r = i2;
        return r;
    }

    private static String q() {
        try {
            ActivityManager activityManager = (ActivityManager) e.a().getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return Integer.toHexString((int) (memoryInfo.availMem / 1048576));
        } catch (Exception e3) {
            r0(Log.getStackTraceString(e3));
            return "";
        }
    }

    private static int q0() {
        int i2;
        try {
            i2 = 0;
        } catch (Exception e3) {
            r0(Log.getStackTraceString(e3));
        }
        if (!g0(14)) {
            return 0;
        }
        int i3 = q;
        if (i3 != -1) {
            return i3;
        }
        q = 0;
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        if (networkInterfaces != null) {
            Iterator it = Collections.list(networkInterfaces).iterator();
            while (it.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                if (networkInterface.isUp() && !networkInterface.getInterfaceAddresses().isEmpty()) {
                    if (!"tun0".equals(networkInterface.getName()) && !"ppp0".equals(networkInterface.getName())) {
                    }
                    i2 = ASTNode.BLOCK_UNTIL;
                    break;
                }
                r0("The network is disconnected.");
            }
        }
        q = i2;
        return q;
    }

    private static String r() {
        if (!"base_band_version".equals(w)) {
            return w;
        }
        try {
            w = w0(Build.VERSION.INCREMENTAL);
        } catch (Exception e3) {
            w = "";
            r0(Log.getStackTraceString(e3));
        }
        return w;
    }

    public static void r0(String str) {
        if (a) {
            c.Log().w("anti_fraud_log", str);
        }
    }

    private static int s() {
        try {
            return ((BatteryManager) e.a().getSystemService("batterymanager")).getIntProperty(4);
        } catch (Exception e3) {
            r0(Log.getStackTraceString(e3));
            return 0;
        }
    }

    public static void s0() {
        if (!h0()) {
            r0("preloadAntiFraud --> cloud close");
            return;
        }
        try {
            if (!g0(26)) {
                e.q();
            }
            l();
            Y.set(false);
            r0("preloadAntiFraud --> Initialize set tag IS_PRELOAD_LOADING = false");
        } catch (Exception e3) {
            r0(Log.getStackTraceString(e3));
        }
    }

    private static String t() {
        if (!"battery_percent".equals(D)) {
            return D;
        }
        try {
            D = Integer.toHexString(g(s(), u()));
        } catch (Exception e3) {
            D = "";
            r0(Log.getStackTraceString(e3));
        }
        return D;
    }

    public static void t0(String str) {
        r0("cloud antiFraudSubfunctionControl = " + str);
        if (TextUtils.isEmpty(d0) || !d0.equals(str)) {
            d0 = str;
            l7.a.e().r("anti_fraud_sub_function_sp_key", d0);
        }
    }

    private static int u() {
        return 0;
    }

    public static void u0(boolean z2) {
        r0("cloud isOpenAntiFraud = " + z2);
        if (c0 == null || c0.booleanValue() != z2) {
            c0 = Boolean.valueOf(z2);
            if (z2 && Y.get()) {
                r0("saveAntiFraudSwitch --> non preload");
                s0();
            }
            l7.a.e().o("is_open_anti_fraud_sp_key", z2);
        }
    }

    private static String v() {
        if (!"board".equals(N)) {
            return N;
        }
        try {
            N = w0(Build.BOARD);
        } catch (Exception e3) {
            N = "";
            r0(Log.getStackTraceString(e3));
        }
        return N;
    }

    public static void v0(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (!TextUtils.isEmpty(a0)) {
            bundle.putString("fraud_data_set", a0);
            return;
        }
        if (!h0()) {
            r0("======= setAntiFraudFullString serve close =========");
            return;
        }
        try {
            if (Y.get()) {
                bundle.putString("fraud_data_set", "");
            } else {
                boolean m2 = e.e().m();
                Bundle bundle2 = Z;
                bundle2.putAll(e.k());
                String n2 = n(bundle2);
                bundle.putString("fraud_data_set", n2);
                if (m2) {
                    bundle2.clear();
                    a0 = n2;
                }
            }
        } catch (Exception e3) {
            r0(Log.getStackTraceString(e3));
            bundle.putString("fraud_data_set", "");
        }
    }

    private static String w() {
        if (!"boot_time".equals(x)) {
            return x;
        }
        try {
            x = Integer.toHexString((int) ((System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000));
        } catch (Exception e3) {
            x = "";
            r0(Log.getStackTraceString(e3));
        }
        return x;
    }

    private static String w0(String str) {
        return (str == null || str.length() <= 100) ? str : str.substring(0, 100);
    }

    private static String x() {
        if (!"build_id".equals(I)) {
            return I;
        }
        try {
            I = w0(Build.ID);
        } catch (Exception e3) {
            I = "";
            r0(Log.getStackTraceString(e3));
        }
        return I;
    }

    private static String y() {
        try {
        } catch (Exception e3) {
            E = "0";
            r0(Log.getStackTraceString(e3));
        }
        if (!g0(21)) {
            return "charge_type";
        }
        if (!"charge_type".equals(E)) {
            return E;
        }
        V();
        Intent intent = b;
        if (intent != null) {
            int intExtra = intent.getIntExtra("plugged", -1);
            if (intExtra == 1) {
                E = "1";
            } else if (intExtra == 2) {
                E = "2";
            } else if (intExtra == 4) {
                E = "3";
            } else {
                E = "0";
            }
        }
        return E;
    }

    private static int z() {
        return a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(0, b0()), m0()), Z()), k0()), a0()), Y()), W()), d0()), j0()), i0()), c0()), q0()), p0()), e0()), f0());
    }
}
