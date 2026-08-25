package com.transsion.athena.taaneh;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.Process;
import android.os.RemoteException;
import android.provider.Settings;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.apm.insight.l.o;
import com.transsion.athena.AthenaConfig;
import com.transsion.core.log.ObjectLogUtils;
import com.transsion.core.utils.c;
import com.transsion.gslb.BuildConfig;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class athena {
    private static String a;
    private static WeakReference<Activity> b;

    public static final class aethna {
        private final String a;

        aethna(String str, boolean z) {
            this.a = str;
        }

        public String a() {
            return this.a;
        }
    }

    private static final class anehat implements ServiceConnection {
        boolean a;
        private final LinkedBlockingQueue<IBinder> b;

        private anehat() {
            this.a = false;
            this.b = new LinkedBlockingQueue<>(1);
        }

        public IBinder a() throws InterruptedException {
            if (this.a) {
                throw new IllegalStateException();
            }
            this.a = true;
            return this.b.poll(10L, TimeUnit.SECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                if (this.b.isEmpty()) {
                    this.b.put(iBinder);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    private static final class enatha implements IInterface {
        private IBinder a;

        enatha(IBinder iBinder) {
            this.a = iBinder;
        }

        public String a() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        boolean a(boolean z) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(z ? 1 : 0);
                this.a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.a;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0055, code lost:
    
        if (android.text.TextUtils.isEmpty(r1) == false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(Activity activity) {
        Intent intent;
        ActivityInfo activityInfo;
        Uri uri;
        if (activity == null || (intent = activity.getIntent()) == null) {
            return 0;
        }
        if (intent.getBooleanExtra(AthenaConfig.ATHENA_PUSH_CALL, false)) {
            return 3;
        }
        String callingPackage = activity.getCallingPackage();
        boolean isEmpty = TextUtils.isEmpty(callingPackage);
        ResolveInfo resolveInfo = null;
        String str = BuildConfig.FLAVOR;
        if (isEmpty) {
            Intent intent2 = activity.getIntent();
            if (intent2 == null) {
                uri = null;
            } else {
                uri = (Uri) intent2.getParcelableExtra("android.intent.extra.REFERRER");
                if (uri == null) {
                    String stringExtra = intent2.getStringExtra("android.intent.extra.REFERRER_NAME");
                    uri = !TextUtils.isEmpty(stringExtra) ? Uri.parse(stringExtra) : activity.getReferrer();
                }
            }
            if (uri != null) {
                callingPackage = uri.getHost();
            }
            callingPackage = BuildConfig.FLAVOR;
        }
        String packageName = activity.getPackageName();
        if (!TextUtils.isEmpty(callingPackage) && !callingPackage.equals(packageName)) {
            Intent intent3 = new Intent("android.intent.action.MAIN");
            intent3.addCategory("android.intent.category.HOME");
            PackageManager packageManager = activity.getPackageManager();
            if (packageManager != null) {
                try {
                    resolveInfo = packageManager.resolveActivity(intent3, 0);
                } catch (Exception e) {
                    com.transsion.athena.taaneh.aethna.b(e.getMessage());
                }
                if (resolveInfo != null && (activityInfo = resolveInfo.activityInfo) != null) {
                    String str2 = activityInfo.packageName;
                    if (!"android".equals(str2) && !TextUtils.isEmpty(str2)) {
                        str = str2;
                    }
                }
            }
            if (!TextUtils.isEmpty(str)) {
                return !callingPackage.equals(str) ? 2 : 1;
            }
            if (!b(activity, callingPackage)) {
                return 2;
            }
        }
        return 1;
    }

    public static aethna a(Context context) throws Exception {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
        context.getPackageManager().getPackageInfo("com.android.vending", 0);
        anehat anehatVar = new anehat();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, anehatVar, 1)) {
            try {
                try {
                    IBinder a2 = anehatVar.a();
                    if (a2 != null) {
                        enatha enathaVar = new enatha(a2);
                        return new aethna(enathaVar.a(), enathaVar.a(true));
                    }
                } catch (Exception e) {
                    throw e;
                }
            } finally {
                context.unbindService(anehatVar);
            }
        }
        throw new IOException("Google Play connection failed");
    }

    public static String a(Context context, int i) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
            Class<?> cls = telephonyManager.getClass();
            Class<?> cls2 = Integer.TYPE;
            String str = (String) cls.getMethod("getImei", cls2).invoke(telephonyManager, Integer.valueOf(i));
            if (TextUtils.isEmpty(str)) {
                str = (String) telephonyManager.getClass().getMethod("getDeviceId", cls2).invoke(telephonyManager, Integer.valueOf(i));
            }
            return !TextUtils.isEmpty(str) ? c.a(str) : BuildConfig.FLAVOR;
        } catch (Exception unused) {
            return BuildConfig.FLAVOR;
        }
    }

    public static List<File> a(String str) {
        List<File> a2 = a(str, new ArrayList(), null);
        if (a2 != null && a2.size() > 0) {
            try {
                Collections.sort(a2, new anateh());
            } catch (Exception e) {
                com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
            }
        }
        return a2;
    }

    public static List<File> a(String str, long j) {
        List<File> a2 = a(str, new ArrayList(), String.valueOf(j));
        if (a2 != null && a2.size() > 0) {
            Collections.sort(a2, new ehanat());
        }
        return a2;
    }

    static List<File> a(String str, List<File> list, String str2) {
        File[] listFiles;
        if (str == null) {
            return list;
        }
        File file = new File(str);
        if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
            return list;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                a(file2.getAbsolutePath(), list, str2);
            } else if (str2 == null) {
                list.add(file2);
            } else if (file2.getName().contains(str2)) {
                list.add(file2);
            }
        }
        return list;
    }

    public static void a() {
        WeakReference<Activity> weakReference = b;
        if (weakReference != null) {
            weakReference.clear();
            b = null;
        }
    }

    private static void a(Context context, File file) {
        if (file.exists() && file.isDirectory() && file.listFiles() != null) {
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    b(context, file2);
                } else if (file2.isDirectory()) {
                    a(context, file2);
                }
            }
        }
    }

    public static void a(Context context, String str) {
        File file = new File(str);
        a(context, file);
        if (file.isDirectory()) {
            if (file.listFiles() == null || file.listFiles().length == 0) {
                file.delete();
            }
        }
    }

    private static void a(StringBuilder sb, int i) {
        String num = Integer.toString(i);
        for (int i2 = 0; i2 < 2 - num.length(); i2++) {
            sb.append('0');
        }
        sb.append(num);
    }

    public static String b() {
        char c;
        try {
            int rawOffset = TimeZone.getDefault().getRawOffset() / 60000;
            if (rawOffset < 0) {
                rawOffset = -rawOffset;
                c = '-';
            } else {
                c = '+';
            }
            StringBuilder sb = new StringBuilder(9);
            sb.append("GMT");
            sb.append(c);
            a(sb, rawOffset / 60);
            sb.append(':');
            a(sb, rawOffset % 60);
            return sb.toString();
        } catch (Throwable th2) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(th2));
            return BuildConfig.FLAVOR;
        }
    }

    @SuppressLint({"HardwareIds"})
    public static String b(Context context) {
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (!TextUtils.isEmpty(string)) {
                String trim = string.trim();
                String a2 = TextUtils.isEmpty(trim) ? BuildConfig.FLAVOR : c.a(trim);
                a = a2;
                return a2;
            }
        } catch (Exception e) {
            com.transsion.athena.taaneh.aethna.b(e.getMessage());
        }
        return BuildConfig.FLAVOR;
    }

    public static String b(Context context, int i) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
            String str = (String) telephonyManager.getClass().getMethod("getSubscriberId", Integer.TYPE).invoke(telephonyManager, Integer.valueOf(i));
            return !TextUtils.isEmpty(str) ? c.a(str) : BuildConfig.FLAVOR;
        } catch (Exception e) {
            com.transsion.athena.taaneh.aethna.b(e.getMessage());
            return BuildConfig.FLAVOR;
        }
    }

    public static void b(Activity activity) {
        b = new WeakReference<>(activity);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.nio.channels.FileChannel, java.nio.channels.spi.AbstractInterruptibleChannel] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.nio.channels.spi.AbstractInterruptibleChannel] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.nio.channels.spi.AbstractInterruptibleChannel] */
    public static boolean b(Context context, File file) {
        Throwable th2;
        ?? r7;
        RandomAccessFile randomAccessFile;
        ?? r72;
        FileLock fileLock;
        FileLock fileLock2;
        if (file == null) {
            return true;
        }
        if (file.getParent().contains(context.getFilesDir().getPath())) {
            File file2 = new File(file.getParent() + File.separator + System.currentTimeMillis());
            file.renameTo(file2);
            return file2.delete();
        }
        FileLock fileLock3 = null;
        try {
            randomAccessFile = new RandomAccessFile(file.getPath(), "rw");
            try {
                ?? channel = randomAccessFile.getChannel();
                try {
                    fileLock3 = channel.lock();
                    File file3 = new File(file.getParent() + File.separator + System.currentTimeMillis());
                    file.renameTo(file3);
                    boolean delete = file3.delete();
                    if (fileLock3 != null) {
                        try {
                            fileLock3.release();
                        } catch (IOException unused) {
                        }
                    }
                    try {
                        channel.close();
                    } catch (IOException unused2) {
                    }
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused3) {
                    }
                    return delete;
                } catch (Exception unused4) {
                    fileLock2 = fileLock3;
                    fileLock3 = channel;
                    FileLock fileLock4 = fileLock2;
                    r72 = fileLock3;
                    fileLock3 = fileLock4;
                    if (fileLock3 != null) {
                        try {
                            fileLock3.release();
                        } catch (IOException unused5) {
                        }
                    }
                    if (r72 != 0) {
                        try {
                            r72.close();
                        } catch (IOException unused6) {
                        }
                    }
                    if (randomAccessFile == null) {
                        return false;
                    }
                    try {
                        randomAccessFile.close();
                        return false;
                    } catch (IOException unused7) {
                        return false;
                    }
                } catch (Throwable th3) {
                    fileLock = fileLock3;
                    fileLock3 = channel;
                    th2 = th3;
                    FileLock fileLock5 = fileLock;
                    r7 = fileLock3;
                    fileLock3 = fileLock5;
                    if (fileLock3 != null) {
                        try {
                            fileLock3.release();
                        } catch (IOException unused8) {
                        }
                    }
                    if (r7 != 0) {
                        try {
                            r7.close();
                        } catch (IOException unused9) {
                        }
                    }
                    if (randomAccessFile == null) {
                        throw th2;
                    }
                    try {
                        randomAccessFile.close();
                        throw th2;
                    } catch (IOException unused10) {
                        throw th2;
                    }
                }
            } catch (Exception unused11) {
                fileLock2 = null;
            } catch (Throwable th4) {
                th2 = th4;
                fileLock = null;
            }
        } catch (Exception unused12) {
            r72 = 0;
            randomAccessFile = null;
        } catch (Throwable th5) {
            th2 = th5;
            r7 = 0;
            randomAccessFile = null;
        }
    }

    private static boolean b(Context context, String str) {
        PackageManager packageManager;
        List<ResolveInfo> list;
        if (TextUtils.isEmpty(str) || (packageManager = context.getPackageManager()) == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        try {
            list = packageManager.queryIntentActivities(intent, 65536);
        } catch (Exception e) {
            com.transsion.athena.taaneh.aethna.b(e.getMessage());
            list = null;
        }
        if (list == null) {
            return false;
        }
        Iterator<ResolveInfo> it = list.iterator();
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            if (activityInfo != null && str.equals(activityInfo.packageName)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    @SuppressLint({"MissingPermission", "PrivateApi", "HardwareIds"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c() {
        String str;
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                str = Build.getSerial();
            } catch (Exception unused) {
                str = BuildConfig.FLAVOR;
            }
        } else {
            str = Build.SERIAL;
        }
        try {
        } catch (Exception e) {
            com.transsion.athena.taaneh.aethna.b(e.getMessage());
        }
        if (!TextUtils.isEmpty(str)) {
            if ("unknown".equals(str)) {
            }
            return !TextUtils.isEmpty(str) ? BuildConfig.FLAVOR : c.a(str);
        }
        Class<?> cls = Class.forName("android.os.SystemProperties");
        str = (String) cls.getMethod("get", String.class).invoke(cls, "ro.serialno");
        if (!TextUtils.isEmpty(str)) {
        }
    }

    @SuppressLint({"MissingPermission"})
    public static List<com.transsion.athena.aatnhe.athena> c(Context context) {
        String str;
        String str2;
        TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
        String networkOperator = telephonyManager.getNetworkOperator();
        if (TextUtils.isEmpty(networkOperator)) {
            str = BuildConfig.FLAVOR;
            str2 = BuildConfig.FLAVOR;
        } else {
            str = networkOperator.substring(0, 3);
            str2 = networkOperator.substring(3);
        }
        List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
        ArrayList arrayList = new ArrayList();
        if (allCellInfo != null) {
            com.transsion.athena.aatnhe.athena athenaVar = null;
            for (CellInfo cellInfo : allCellInfo) {
                if (cellInfo instanceof CellInfoGsm) {
                    CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                    CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
                    int asuLevel = cellInfoGsm.getCellSignalStrength().getAsuLevel();
                    if (cellIdentity.getCid() > 0 && cellIdentity.getLac() > 0 && asuLevel != 99) {
                        athenaVar = (cellIdentity.getMcc() == Integer.MAX_VALUE || cellIdentity.getMnc() == Integer.MAX_VALUE) ? new com.transsion.athena.aatnhe.athena(str, str2, cellIdentity.getCid(), cellIdentity.getLac(), asuLevel, cellInfo.isRegistered()) : new com.transsion.athena.aatnhe.athena(com.transsion.athena.taaneh.anehat.a(cellIdentity.getMcc()), com.transsion.athena.taaneh.anehat.a(cellIdentity.getMnc()), cellIdentity.getCid(), cellIdentity.getLac(), asuLevel, cellInfo.isRegistered());
                    }
                } else if (cellInfo instanceof CellInfoWcdma) {
                    CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                    CellIdentityWcdma cellIdentity2 = cellInfoWcdma.getCellIdentity();
                    int asuLevel2 = cellInfoWcdma.getCellSignalStrength().getAsuLevel();
                    if (cellIdentity2.getCid() > 0 && cellIdentity2.getLac() > 0 && asuLevel2 != 99) {
                        athenaVar = (cellIdentity2.getMcc() == Integer.MAX_VALUE || cellIdentity2.getMnc() == Integer.MAX_VALUE) ? new com.transsion.athena.aatnhe.athena(str, str2, cellIdentity2.getCid(), cellIdentity2.getLac(), asuLevel2, cellInfo.isRegistered()) : new com.transsion.athena.aatnhe.athena(com.transsion.athena.taaneh.anehat.a(cellIdentity2.getMcc()), com.transsion.athena.taaneh.anehat.a(cellIdentity2.getMnc()), cellIdentity2.getCid(), cellIdentity2.getLac(), asuLevel2, cellInfo.isRegistered());
                    }
                } else if (cellInfo instanceof CellInfoLte) {
                    CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                    CellIdentityLte cellIdentity3 = cellInfoLte.getCellIdentity();
                    int asuLevel3 = cellInfoLte.getCellSignalStrength().getAsuLevel();
                    if (cellIdentity3.getCi() > 0 && cellIdentity3.getTac() > 0 && asuLevel3 != 99) {
                        athenaVar = (cellIdentity3.getMcc() == Integer.MAX_VALUE || cellIdentity3.getMnc() == Integer.MAX_VALUE) ? new com.transsion.athena.aatnhe.athena(str, str2, cellIdentity3.getCi(), cellIdentity3.getTac(), asuLevel3, cellInfo.isRegistered()) : new com.transsion.athena.aatnhe.athena(com.transsion.athena.taaneh.anehat.a(cellIdentity3.getMcc()), com.transsion.athena.taaneh.anehat.a(cellIdentity3.getMnc()), cellIdentity3.getCi(), cellIdentity3.getTac(), asuLevel3, cellInfo.isRegistered());
                    }
                }
                if (athenaVar != null && !arrayList.contains(athenaVar)) {
                    arrayList.add(athenaVar);
                }
                if (arrayList.size() == 10) {
                    break;
                }
            }
        }
        Collections.sort(arrayList, new com.transsion.athena.taaneh.enatha());
        return arrayList;
    }

    public static Activity d() {
        WeakReference<Activity> weakReference = b;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return b.get();
    }

    public static String d(Context context) {
        String str;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                String a2 = o.a();
                if (!TextUtils.isEmpty(a2)) {
                    return a2;
                }
            }
            try {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo.pid == Process.myPid()) {
                            str = runningAppProcessInfo.processName;
                            break;
                        }
                    }
                }
            } catch (Exception unused) {
            }
            str = null;
            if (TextUtils.isEmpty(str)) {
                try {
                    Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", null);
                    declaredMethod.setAccessible(true);
                    Object invoke = declaredMethod.invoke(null, null);
                    if (!(invoke instanceof String)) {
                        return null;
                    }
                    str = (String) invoke;
                } catch (Throwable unused2) {
                    return null;
                }
            }
            return str;
        } catch (Exception e) {
            ObjectLogUtils objectLogUtils = com.transsion.athena.taaneh.aethna.a;
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
            return null;
        }
    }

    public static String e(Context context) {
        try {
            return context.getPackageManager().getInstallerPackageName(h(context));
        } catch (Exception e) {
            com.transsion.athena.taaneh.aethna.b(e.getMessage());
            return BuildConfig.FLAVOR;
        }
    }

    public static String f(Context context) {
        String str;
        TelephonyManager telephonyManager;
        try {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        } catch (Exception unused) {
        }
        if (telephonyManager == null) {
            str = BuildConfig.FLAVOR;
            return (!TextUtils.isEmpty(str) || str.length() < 3) ? BuildConfig.FLAVOR : str.substring(0, 3);
        }
        str = telephonyManager.getSimOperator();
        if (TextUtils.isEmpty(str)) {
        }
    }

    public static String g(Context context) {
        String str;
        TelephonyManager telephonyManager;
        try {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        } catch (Exception unused) {
        }
        if (telephonyManager == null) {
            str = BuildConfig.FLAVOR;
            return (!TextUtils.isEmpty(str) || str.length() < 3) ? BuildConfig.FLAVOR : str.substring(3);
        }
        str = telephonyManager.getSimOperator();
        if (TextUtils.isEmpty(str)) {
        }
    }

    public static String h(Context context) {
        try {
            return context.getPackageName();
        } catch (Exception e) {
            ObjectLogUtils objectLogUtils = com.transsion.athena.taaneh.aethna.a;
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
            return BuildConfig.FLAVOR;
        }
    }

    public static int i(Context context) {
        try {
            return context.getApplicationContext().getPackageManager().getPackageInfo(h(context), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
            return 0;
        }
    }

    public static String j(Context context) {
        try {
            return context.getApplicationContext().getPackageManager().getPackageInfo(h(context), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            ObjectLogUtils objectLogUtils = com.transsion.athena.taaneh.aethna.a;
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
            return BuildConfig.FLAVOR;
        }
    }
}
