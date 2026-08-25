package com.cloud.tmc.integration.utils;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.Log;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.integration.proxy.LauncherReportProxy;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.utils.ExecutorUtils;
import com.cloud.tmc.miniutils.util.Utils;
import com.transsion.core.log.LogUtils;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001AB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010&\u001a\u00020\u001c2\b\u0010'\u001a\u0004\u0018\u00010\u00042\u0006\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u0006H\u0007J\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-J\b\u0010.\u001a\u00020\u0004H\u0007J\u0006\u0010/\u001a\u00020\u0006J\b\u00100\u001a\u0004\u0018\u00010\u0004J\u0006\u00101\u001a\u00020\u0004J\u0010\u00101\u001a\u0004\u0018\u00010\u00042\u0006\u00102\u001a\u000203J\u0006\u00104\u001a\u00020\u001cJ\n\u00105\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u00106\u001a\u00020+2\b\u00102\u001a\u0004\u0018\u0001032\u0006\u0010,\u001a\u00020-J\n\u00107\u001a\u0004\u0018\u00010\u0004H\u0007J\n\u00108\u001a\u0004\u0018\u00010\u0004H\u0007J\u0015\u00109\u001a\u00020\u00042\b\u0010:\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010;J\u0010\u0010<\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020\u0004H\u0002J\b\u0010>\u001a\u00020+H\u0002J\u0010\u0010?\u001a\u00020+2\b\u0010@\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006B"}, d2 = {"Lcom/cloud/tmc/integration/utils/DeviceUtil;", "", "()V", "AD_ABILITY_CLOSE_GAID", "", "CLOSE_GAID", "", "GET_GAID_TIME_INTERVAL", "NOT_GAID", "OPEN_GAID", "PREF_GAID", "PREF_IS_LIMIT_AD_TRACKING_ENABLED", "TAG", "cpucores", "getCpucores", "()I", "setCpucores", "(I)V", "cpuhardware", "getCpuhardware", "()Ljava/lang/String;", "setCpuhardware", "(Ljava/lang/String;)V", "gsmInteger", "Ljava/util/concurrent/atomic/AtomicInteger;", "ip", "isLimitStatus", "isNewUser", "", "lastQueryGaidTime", "", "mGAId", "mGsmLocation", "totalMem", "getTotalMem", "()J", "setTotalMem", "(J)V", "checkCanRetryInTimes", "value", "increment", "limit", "getCupInfo", "", "bundle", "Landroid/os/Bundle;", "getGAId", "getGaidStatus", "getGsmCellLocation", "getIp", "context", "Landroid/content/Context;", "getIsNewUserStatus", "getLocalIpAddress", "getMemoryInfo", "getSystemVersion", "getUUID", "intToIp", "ipInt", "(Ljava/lang/Integer;)Ljava/lang/String;", "isValidIp4Address", "hostName", "queryGaid", "updateIsNewUserStatus", "appId", "AdvertisingIdClient", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class DeviceUtil {
    private static final String AD_ABILITY_CLOSE_GAID = "00000000-0000-0000-0000-000000000000";
    private static final int CLOSE_GAID = 1;
    private static final int GET_GAID_TIME_INTERVAL = 600000;
    private static final int NOT_GAID = 0;
    private static final int OPEN_GAID = 2;
    private static final String PREF_IS_LIMIT_AD_TRACKING_ENABLED = "is_limit_ad_tracking_enabled";
    private static final String TAG = "DeviceUtil";
    private static String ip;
    private static int isLimitStatus;
    private static boolean isNewUser;
    public static final DeviceUtil INSTANCE = new DeviceUtil();
    private static String mGsmLocation = "";
    private static String mGAId = "";
    private static final String PREF_GAID = "device_util_ga_id";
    private static long lastQueryGaidTime = System.currentTimeMillis();
    private static final AtomicInteger gsmInteger = new AtomicInteger(0);
    private static long totalMem = -1;
    private static int cpucores = -1;
    private static String cpuhardware = "";

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001:\u0003\u0007\b\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\n"}, d2 = {"Lcom/cloud/tmc/integration/utils/DeviceUtil$AdvertisingIdClient;", "", "()V", "getAdvertisingIdInfo", "Lcom/cloud/tmc/integration/utils/DeviceUtil$AdvertisingIdClient$AdInfo;", "context", "Landroid/content/Context;", "AdInfo", "AdvertisingConnection", "AdvertisingInterface", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class AdvertisingIdClient {
        public static final AdvertisingIdClient INSTANCE = new AdvertisingIdClient();

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t¨\u0006\n"}, d2 = {"Lcom/cloud/tmc/integration/utils/DeviceUtil$AdvertisingIdClient$AdInfo;", "", "id", "", "isLimitAdTrackingEnabled", "", "(Ljava/lang/String;Z)V", "getId", "()Ljava/lang/String;", "()Z", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class AdInfo {
            private final String id;
            private final boolean isLimitAdTrackingEnabled;

            public AdInfo(String str, boolean z) {
                this.id = str;
                this.isLimitAdTrackingEnabled = z;
            }

            public final String getId() {
                return this.id;
            }

            /* renamed from: isLimitAdTrackingEnabled, reason: from getter */
            public final boolean getIsLimitAdTrackingEnabled() {
                return this.isLimitAdTrackingEnabled;
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/cloud/tmc/integration/utils/DeviceUtil$AdvertisingIdClient$AdvertisingConnection;", "Landroid/content/ServiceConnection;", "()V", "binder", "Landroid/os/IBinder;", "getBinder", "()Landroid/os/IBinder;", "queue", "Ljava/util/concurrent/LinkedBlockingQueue;", "retrieved", "", "getRetrieved", "()Z", "setRetrieved", "(Z)V", "onServiceConnected", "", "name", "Landroid/content/ComponentName;", "service", "onServiceDisconnected", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = 48)
        private static final class AdvertisingConnection implements ServiceConnection {
            private final LinkedBlockingQueue<IBinder> queue = new LinkedBlockingQueue<>(1);
            private boolean retrieved;

            public final IBinder getBinder() throws InterruptedException {
                if (this.retrieved) {
                    throw new IllegalStateException();
                }
                this.retrieved = true;
                return this.queue.take();
            }

            public final boolean getRetrieved() {
                return this.retrieved;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName name, IBinder service) {
                Intrinsics.h(name, "name");
                Intrinsics.h(service, "service");
                try {
                    this.queue.put(service);
                } catch (InterruptedException e) {
                    Log.e(DeviceUtil.TAG, "getLocalIpAddress: ", e);
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName name) {
                Intrinsics.h(name, "name");
            }

            public final void setRetrieved(boolean z) {
                this.retrieved = z;
            }
        }

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\u0003H\u0016J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/cloud/tmc/integration/utils/DeviceUtil$AdvertisingIdClient$AdvertisingInterface;", "Landroid/os/IInterface;", "binder", "Landroid/os/IBinder;", "(Landroid/os/IBinder;)V", "id", "", "getId", "()Ljava/lang/String;", "asBinder", "isLimitAdTrackingEnabled", "", "paramBoolean", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = 48)
        private static final class AdvertisingInterface implements IInterface {
            private final IBinder binder;

            public AdvertisingInterface(IBinder iBinder) {
                Intrinsics.h(iBinder, "binder");
                this.binder = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.binder;
            }

            public final String getId() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Intrinsics.g(obtain, "obtain()");
                Parcel obtain2 = Parcel.obtain();
                Intrinsics.g(obtain2, "obtain()");
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    this.binder.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean isLimitAdTrackingEnabled(boolean paramBoolean) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Intrinsics.g(obtain, "obtain()");
                Parcel obtain2 = Parcel.obtain();
                Intrinsics.g(obtain2, "obtain()");
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    obtain.writeInt(paramBoolean ? 1 : 0);
                    this.binder.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        private AdvertisingIdClient() {
        }

        public final AdInfo getAdvertisingIdInfo(Context context) throws Exception {
            Intrinsics.h(context, "context");
            if (Intrinsics.c(Looper.myLooper(), Looper.getMainLooper())) {
                throw new IllegalStateException("Cannot be called from the main thread");
            }
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            AdvertisingConnection advertisingConnection = new AdvertisingConnection();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            if (!context.bindService(intent, advertisingConnection, 1)) {
                throw new IOException("Google Play connection failed");
            }
            AdInfo adInfo = new AdInfo("", false);
            IBinder binder = advertisingConnection.getBinder();
            if (binder == null) {
                return adInfo;
            }
            try {
                try {
                    AdvertisingInterface advertisingInterface = new AdvertisingInterface(binder);
                    return new AdInfo(advertisingInterface.getId(), advertisingInterface.isLimitAdTrackingEnabled(true));
                } catch (Exception e) {
                    throw e;
                }
            } finally {
                context.unbindService(advertisingConnection);
            }
        }
    }

    private DeviceUtil() {
    }

    @JvmStatic
    public static final boolean checkCanRetryInTimes(String value, AtomicInteger increment, int limit) {
        Intrinsics.h(increment, "increment");
        return TextUtils.isEmpty(value) && increment.getAndIncrement() < limit;
    }

    @JvmStatic
    public static final String getGAId() {
        try {
        } catch (Throwable th) {
            TmcLogger.e(TAG, "getGAId", th);
        }
        if (!TextUtils.isEmpty(mGAId)) {
            if (Intrinsics.c(mGAId, AD_ABILITY_CLOSE_GAID) && System.currentTimeMillis() - lastQueryGaidTime > 600000) {
            }
            return mGAId;
        }
        lastQueryGaidTime = System.currentTimeMillis();
        String string = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getString(Utils.getApp(), "minisdk_storage", PREF_GAID);
        if (string == null) {
            string = "";
        }
        mGAId = string;
        if (Intrinsics.c(Looper.myLooper(), Looper.getMainLooper())) {
            ExecutorUtils.execute(ExecutorType.IO, new Runnable() { // from class: com.cloud.tmc.integration.utils.j
                @Override // java.lang.Runnable
                public final void run() {
                    DeviceUtil.getGAId$lambda$0();
                }
            });
        } else {
            INSTANCE.queryGaid();
        }
        return mGAId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getGAId$lambda$0() {
        INSTANCE.queryGaid();
    }

    private final String getLocalIpAddress() {
        String str = "";
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress()) {
                        String hostAddress = nextElement.getHostAddress();
                        Intrinsics.g(hostAddress, "ip.hostAddress");
                        if (isValidIp4Address(hostAddress)) {
                            String hostAddress2 = nextElement.getHostAddress();
                            Intrinsics.g(hostAddress2, "ip.hostAddress");
                            str = hostAddress2;
                        }
                    }
                }
            }
        } catch (SocketException e) {
            Log.e(TAG, "getLocalIpAddress: ", e);
        }
        return str;
    }

    @JvmStatic
    public static final String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    @JvmStatic
    public static final String getUUID() {
        return UUID.randomUUID().toString();
    }

    private final boolean isValidIp4Address(String hostName) {
        try {
            return InetAddress.getByName(hostName) != null;
        } catch (UnknownHostException unused) {
            return false;
        }
    }

    private final void queryGaid() {
        try {
            AdvertisingIdClient advertisingIdClient = AdvertisingIdClient.INSTANCE;
            Context a = yj.a.a();
            Intrinsics.g(a, "getContext()");
            AdvertisingIdClient.AdInfo advertisingIdInfo = advertisingIdClient.getAdvertisingIdInfo(a);
            if (advertisingIdInfo != null) {
                if (!Intrinsics.c(advertisingIdInfo.getId(), mGAId)) {
                    String id = advertisingIdInfo.getId();
                    if (id == null) {
                        id = "";
                    }
                    mGAId = id;
                    boolean isLimitAdTrackingEnabled = advertisingIdInfo.getIsLimitAdTrackingEnabled();
                    ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putString(Utils.getApp(), "minisdk_storage", PREF_GAID, mGAId);
                    AdxPreferencesHelper.INSTANCE.getInstance().n(PREF_IS_LIMIT_AD_TRACKING_ENABLED, isLimitAdTrackingEnabled ? 1 : 2);
                }
                LogUtils.h("gaid is " + mGAId, new Object[0]);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final int getCpucores() {
        return cpucores;
    }

    public final String getCpuhardware() {
        return cpuhardware;
    }

    public final void getCupInfo(Bundle bundle) {
        Intrinsics.h(bundle, "bundle");
        try {
            if (cpucores == -1) {
                cpucores = Runtime.getRuntime().availableProcessors();
            }
            if (TextUtils.isEmpty(cpuhardware)) {
                String str = Build.HARDWARE;
                Intrinsics.g(str, "HARDWARE");
                cpuhardware = str;
            }
            bundle.putInt("cpucores", cpucores);
            bundle.putString("cpuhardware", cpuhardware);
        } catch (Throwable th) {
            Log.e(TAG, "getCupInfo: ", th);
        }
    }

    public final int getGaidStatus() {
        if (isLimitStatus == 0) {
            isLimitStatus = AdxPreferencesHelper.INSTANCE.getInstance().f(PREF_IS_LIMIT_AD_TRACKING_ENABLED, 0);
        }
        return isLimitStatus;
    }

    public final String getGsmCellLocation() {
        int cid;
        int lac;
        if (!checkCanRetryInTimes(mGsmLocation, gsmInteger, 1)) {
            return mGsmLocation;
        }
        try {
            Object systemService = yj.a.a().getSystemService("phone");
            Intrinsics.f(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
            TelephonyManager telephonyManager = (TelephonyManager) systemService;
            CellLocation cellLocation = telephonyManager.getCellLocation();
            if (cellLocation == null) {
                return "";
            }
            if (telephonyManager.getPhoneType() == 2) {
                CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                cid = cdmaCellLocation.getBaseStationId();
                lac = cdmaCellLocation.getNetworkId();
            } else {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                cid = gsmCellLocation.getCid();
                lac = gsmCellLocation.getLac();
            }
            String str = cid + "|" + lac;
            mGsmLocation = str;
            return str;
        } catch (Exception e) {
            Log.e(TAG, "getGsmCellLocation: ", e);
            return "";
        }
    }

    public final String getIp() {
        try {
            Object systemService = yj.a.a().getApplicationContext().getSystemService("connectivity");
            Intrinsics.f(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
            if (networkInfo != null && networkInfo.isConnected()) {
                ip = getLocalIpAddress();
            } else if (networkInfo2 != null && networkInfo2.isConnected()) {
                Object systemService2 = yj.a.a().getApplicationContext().getSystemService("wifi");
                Intrinsics.f(systemService2, "null cannot be cast to non-null type android.net.wifi.WifiManager");
                ip = intToIp(Integer.valueOf(((WifiManager) systemService2).getConnectionInfo().getIpAddress()));
            }
        } catch (Exception e) {
            Log.e(TAG, "getIp: ", e);
        }
        String str = ip;
        return str == null ? "" : str;
    }

    public final String getIp(Context context) {
        Context applicationContext;
        Context applicationContext2;
        Intrinsics.h(context, "context");
        WeakReference weakReference = new WeakReference(context);
        try {
            Context context2 = (Context) weakReference.get();
            Object systemService = (context2 == null || (applicationContext2 = context2.getApplicationContext()) == null) ? null : applicationContext2.getSystemService("connectivity");
            ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
            NetworkInfo networkInfo = connectivityManager != null ? connectivityManager.getNetworkInfo(0) : null;
            NetworkInfo networkInfo2 = connectivityManager != null ? connectivityManager.getNetworkInfo(1) : null;
            if (networkInfo != null && networkInfo.isConnected()) {
                ip = getLocalIpAddress();
            } else if (networkInfo2 != null && networkInfo2.isConnected()) {
                Context context3 = (Context) weakReference.get();
                Object systemService2 = (context3 == null || (applicationContext = context3.getApplicationContext()) == null) ? null : applicationContext.getSystemService("wifi");
                WifiManager wifiManager = systemService2 instanceof WifiManager ? (WifiManager) systemService2 : null;
                WifiInfo connectionInfo = wifiManager != null ? wifiManager.getConnectionInfo() : null;
                ip = intToIp(connectionInfo != null ? Integer.valueOf(connectionInfo.getIpAddress()) : null);
            }
        } catch (Exception e) {
            Log.e(TAG, "getIp: ", e);
        }
        return ip;
    }

    public final boolean getIsNewUserStatus() {
        return isNewUser;
    }

    public final void getMemoryInfo(Context context, Bundle bundle) {
        Intrinsics.h(bundle, "bundle");
        if (context != null) {
            try {
                Object systemService = context.getSystemService("activity");
                Intrinsics.f(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
                if (totalMem == -1) {
                    totalMem = memoryInfo.totalMem / 1048576;
                }
                bundle.putLong("totalMem", totalMem);
            } catch (Throwable th) {
                Log.e(TAG, "getMemoryInfo: ", th);
            }
        }
    }

    public final long getTotalMem() {
        return totalMem;
    }

    public final String intToIp(Integer ipInt) {
        StringBuilder sb = new StringBuilder();
        if (ipInt != null) {
            int intValue = ipInt.intValue();
            sb.append(intValue & 255);
            sb.append(InstructionFileId.DOT);
            sb.append((intValue >> 8) & 255);
            sb.append(InstructionFileId.DOT);
            sb.append((intValue >> 16) & 255);
            sb.append(InstructionFileId.DOT);
            sb.append((intValue >> 24) & 255);
        }
        String sb2 = sb.toString();
        Intrinsics.g(sb2, "sb.toString()");
        return sb2;
    }

    public final void setCpucores(int i) {
        cpucores = i;
    }

    public final void setCpuhardware(String str) {
        Intrinsics.h(str, "<set-?>");
        cpuhardware = str;
    }

    public final void setTotalMem(long j) {
        totalMem = j;
    }

    public final void updateIsNewUserStatus(String appId) {
        if (isNewUser || (appId != null && appId.length() > 0)) {
            isNewUser = false;
            try {
                ((LauncherReportProxy) TmcProxy.get(LauncherReportProxy.class)).reportCacheData(appId);
            } catch (Throwable unused) {
            }
        }
    }
}
