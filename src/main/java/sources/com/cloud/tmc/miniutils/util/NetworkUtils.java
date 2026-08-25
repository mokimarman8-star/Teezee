package com.cloud.tmc.miniutils.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Log;
import androidx.annotation.NonNull;
import com.cloud.tmc.kernel.bridge.extension.BridgeResponse;
import com.cloud.tmc.kernel.constants.LauncherLifecycleType;
import com.cloud.tmc.miniutils.util.Utils;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class NetworkUtils {
    private static final long SCAN_PERIOD_MILLIS = 3000;
    private static WifiScanResults sPreWifiScanResults;
    private static Timer sScanWifiTimer;
    private static int status;
    private static NetworkType mNetworkType = NetworkType.NETWORK_NO;
    private static AtomicBoolean init = new AtomicBoolean(false);
    private static String TAG = "NetworkUtils";
    private static final Set<Utils.Consumer<WifiScanResults>> SCAN_RESULT_CONSUMERS = new CopyOnWriteArraySet();

    public static final class NetworkCallbackImpl extends ConnectivityManager.NetworkCallback {
        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(@NonNull Network network) {
            try {
                super.onAvailable(network);
                NetworkUtils.mNetworkType = NetworkUtils.getNetworkType();
                StringBuilder sb = new StringBuilder();
                sb.append("onAvailable,  networkType:");
                sb.append(NetworkUtils.mNetworkType);
            } catch (Throwable th) {
                Log.e(NetworkUtils.TAG, "onAvailable: ", th);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(@NonNull Network network, @NonNull NetworkCapabilities networkCapabilities) {
            try {
                super.onCapabilitiesChanged(network, networkCapabilities);
                if (networkCapabilities.hasCapability(16)) {
                    NetworkUtils.status = 1;
                } else {
                    NetworkUtils.status = -1;
                }
            } catch (Throwable th) {
                Log.e(NetworkUtils.TAG, "onCapabilitiesChanged: ", th);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(@NonNull Network network) {
            try {
                NetworkUtils.status = -1;
                super.onLost(network);
                NetworkUtils.mNetworkType = NetworkUtils.getNetworkType();
                StringBuilder sb = new StringBuilder();
                sb.append("onLost,  networkType:");
                sb.append(NetworkUtils.mNetworkType);
            } catch (Throwable th) {
                Log.e("onCapabilitiesChanged", "onLost:", th);
            }
        }
    }

    public static final class NetworkChangedReceiver extends BroadcastReceiver {
        private Set<OnNetworkStatusChangedListener> mListeners = new HashSet();
        private NetworkType mType;

        private static class LazyHolder {
            private static final NetworkChangedReceiver INSTANCE = new NetworkChangedReceiver();

            private LazyHolder() {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static NetworkChangedReceiver getInstance() {
            return LazyHolder.INSTANCE;
        }

        boolean isRegistered(OnNetworkStatusChangedListener onNetworkStatusChangedListener) {
            if (onNetworkStatusChangedListener == null) {
                return false;
            }
            return this.mListeners.contains(onNetworkStatusChangedListener);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                UtilsBridge.runOnUiThreadDelayed(new Runnable() { // from class: com.cloud.tmc.miniutils.util.NetworkUtils.NetworkChangedReceiver.3
                    @Override // java.lang.Runnable
                    public void run() {
                        NetworkType networkType = NetworkUtils.getNetworkType();
                        if (NetworkChangedReceiver.this.mType == networkType) {
                            return;
                        }
                        NetworkChangedReceiver.this.mType = networkType;
                        if (networkType == NetworkType.NETWORK_NO) {
                            Iterator it = NetworkChangedReceiver.this.mListeners.iterator();
                            while (it.hasNext()) {
                                ((OnNetworkStatusChangedListener) it.next()).onDisconnected();
                            }
                        } else {
                            Iterator it2 = NetworkChangedReceiver.this.mListeners.iterator();
                            while (it2.hasNext()) {
                                ((OnNetworkStatusChangedListener) it2.next()).onConnected(networkType);
                            }
                        }
                    }
                }, 1000L);
            }
        }

        void registerListener(final OnNetworkStatusChangedListener onNetworkStatusChangedListener) {
            if (onNetworkStatusChangedListener == null) {
                return;
            }
            UtilsBridge.runOnUiThread(new Runnable() { // from class: com.cloud.tmc.miniutils.util.NetworkUtils.NetworkChangedReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    int size = NetworkChangedReceiver.this.mListeners.size();
                    NetworkChangedReceiver.this.mListeners.add(onNetworkStatusChangedListener);
                    if (size == 0 && NetworkChangedReceiver.this.mListeners.size() == 1) {
                        NetworkChangedReceiver.this.mType = NetworkUtils.getNetworkType();
                        Utils.getApp().registerReceiver(NetworkChangedReceiver.getInstance(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    }
                }
            });
        }

        void unregisterListener(final OnNetworkStatusChangedListener onNetworkStatusChangedListener) {
            if (onNetworkStatusChangedListener == null) {
                return;
            }
            UtilsBridge.runOnUiThread(new Runnable() { // from class: com.cloud.tmc.miniutils.util.NetworkUtils.NetworkChangedReceiver.2
                @Override // java.lang.Runnable
                public void run() {
                    int size = NetworkChangedReceiver.this.mListeners.size();
                    NetworkChangedReceiver.this.mListeners.remove(onNetworkStatusChangedListener);
                    if (size == 1 && NetworkChangedReceiver.this.mListeners.size() == 0) {
                        Utils.getApp().unregisterReceiver(NetworkChangedReceiver.getInstance());
                    }
                }
            });
        }
    }

    public enum NetworkType {
        NETWORK_ETHERNET,
        NETWORK_WIFI,
        NETWORK_5G,
        NETWORK_4G,
        NETWORK_3G,
        NETWORK_2G,
        NETWORK_UNKNOWN,
        NETWORK_NO
    }

    public interface OnNetworkStatusChangedListener {
        void onConnected(NetworkType networkType);

        void onDisconnected();
    }

    public static final class WifiScanResults {
        private List<ScanResult> allResults = new ArrayList();
        private List<ScanResult> filterResults = new ArrayList();

        private static List<ScanResult> filterScanResult(List<ScanResult> list) {
            ScanResult scanResult;
            if (list == null || list.isEmpty()) {
                return new ArrayList();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(list.size());
            for (ScanResult scanResult2 : list) {
                if (!TextUtils.isEmpty(scanResult2.SSID) && ((scanResult = (ScanResult) linkedHashMap.get(scanResult2.SSID)) == null || scanResult.level < scanResult2.level)) {
                    linkedHashMap.put(scanResult2.SSID, scanResult2);
                }
            }
            return new ArrayList(linkedHashMap.values());
        }

        public List<ScanResult> getAllResults() {
            return this.allResults;
        }

        public List<ScanResult> getFilterResults() {
            return this.filterResults;
        }

        public void setAllResults(List<ScanResult> list) {
            this.allResults = list;
            this.filterResults = filterScanResult(list);
        }
    }

    private NetworkUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void addOnWifiChangedConsumer(final Utils.Consumer<WifiScanResults> consumer) {
        if (consumer == null) {
            return;
        }
        UtilsBridge.runOnUiThread(new Runnable() { // from class: com.cloud.tmc.miniutils.util.NetworkUtils.1
            @Override // java.lang.Runnable
            public void run() {
                if (NetworkUtils.SCAN_RESULT_CONSUMERS.isEmpty()) {
                    NetworkUtils.SCAN_RESULT_CONSUMERS.add(Utils.Consumer.this);
                    NetworkUtils.startScanWifi();
                } else {
                    Utils.Consumer.this.accept(NetworkUtils.sPreWifiScanResults);
                    NetworkUtils.SCAN_RESULT_CONSUMERS.add(Utils.Consumer.this);
                }
            }
        });
    }

    private static NetworkInfo getActiveNetworkInfo() {
        ConnectivityManager connectivityManager = (ConnectivityManager) Utils.getApp().getSystemService("connectivity");
        if (connectivityManager == null) {
            return null;
        }
        return connectivityManager.getActiveNetworkInfo();
    }

    public static String getBroadcastIpAddress() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (nextElement.isUp() && !nextElement.isLoopback()) {
                    List<InterfaceAddress> interfaceAddresses = nextElement.getInterfaceAddresses();
                    int size = interfaceAddresses.size();
                    for (int i = 0; i < size; i++) {
                        InetAddress broadcast = interfaceAddresses.get(i).getBroadcast();
                        if (broadcast != null) {
                            return broadcast.getHostAddress();
                        }
                    }
                }
            }
            return "";
        } catch (SocketException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getDomainAddress(String str) {
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getGatewayByWifi() {
        WifiManager wifiManager = (WifiManager) Utils.getApp().getSystemService("wifi");
        return wifiManager == null ? "" : Formatter.formatIpAddress(wifiManager.getDhcpInfo().gateway);
    }

    public static String getIPAddress(boolean z) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            LinkedList linkedList = new LinkedList();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (nextElement.isUp() && !nextElement.isLoopback()) {
                    Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        linkedList.addFirst(inetAddresses.nextElement());
                    }
                }
            }
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                InetAddress inetAddress = (InetAddress) it.next();
                if (!inetAddress.isLoopbackAddress()) {
                    String hostAddress = inetAddress.getHostAddress();
                    boolean z2 = hostAddress.indexOf(58) < 0;
                    if (z) {
                        if (z2) {
                            return hostAddress;
                        }
                    } else if (!z2) {
                        int indexOf = hostAddress.indexOf(37);
                        return indexOf < 0 ? hostAddress.toUpperCase() : hostAddress.substring(0, indexOf).toUpperCase();
                    }
                }
            }
            return "";
        } catch (SocketException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getIpAddressByWifi() {
        WifiManager wifiManager = (WifiManager) Utils.getApp().getSystemService("wifi");
        return wifiManager == null ? "" : Formatter.formatIpAddress(wifiManager.getDhcpInfo().ipAddress);
    }

    public static NetworkType getMNetWorkType() {
        return mNetworkType;
    }

    public static String getNetMaskByWifi() {
        WifiManager wifiManager = (WifiManager) Utils.getApp().getSystemService("wifi");
        return wifiManager == null ? "" : Formatter.formatIpAddress(wifiManager.getDhcpInfo().netmask);
    }

    public static String getNetworkOperatorName() {
        TelephonyManager telephonyManager = (TelephonyManager) Utils.getApp().getSystemService("phone");
        return telephonyManager == null ? "" : telephonyManager.getNetworkOperatorName();
    }

    public static int getNetworkStatus() {
        return status;
    }

    public static NetworkType getNetworkType() {
        if (isEthernet()) {
            return NetworkType.NETWORK_ETHERNET;
        }
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return NetworkType.NETWORK_NO;
        }
        if (activeNetworkInfo.getType() == 1) {
            return NetworkType.NETWORK_WIFI;
        }
        if (activeNetworkInfo.getType() != 0) {
            return NetworkType.NETWORK_UNKNOWN;
        }
        switch (activeNetworkInfo.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return NetworkType.NETWORK_2G;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case BridgeResponse.ERROR_CODE_UNAUTHORIZED_USERINFO /* 10 */:
            case 12:
            case 14:
            case 15:
            case LauncherLifecycleType.LAUNCHER_MINIAPP_START /* 17 */:
                return NetworkType.NETWORK_3G;
            case 13:
            case 18:
                return NetworkType.NETWORK_4G;
            case 19:
            default:
                String subtypeName = activeNetworkInfo.getSubtypeName();
                return (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) ? NetworkType.NETWORK_3G : NetworkType.NETWORK_UNKNOWN;
            case 20:
                return NetworkType.NETWORK_5G;
        }
    }

    public static String getSSID() {
        WifiInfo connectionInfo;
        WifiManager wifiManager = (WifiManager) Utils.getApp().getApplicationContext().getSystemService("wifi");
        if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
            return "";
        }
        String ssid = connectionInfo.getSSID();
        return TextUtils.isEmpty(ssid) ? "" : (ssid.length() > 2 && ssid.charAt(0) == '\"' && ssid.charAt(ssid.length() - 1) == '\"') ? ssid.substring(1, ssid.length() - 1) : ssid;
    }

    public static String getServerAddressByWifi() {
        WifiManager wifiManager = (WifiManager) Utils.getApp().getSystemService("wifi");
        return wifiManager == null ? "" : Formatter.formatIpAddress(wifiManager.getDhcpInfo().serverAddress);
    }

    public static boolean getWifiEnabled() {
        WifiManager wifiManager = (WifiManager) Utils.getApp().getSystemService("wifi");
        if (wifiManager == null) {
            return false;
        }
        return wifiManager.isWifiEnabled();
    }

    public static WifiScanResults getWifiScanResult() {
        List<ScanResult> scanResults;
        WifiScanResults wifiScanResults = new WifiScanResults();
        if (getWifiEnabled() && (scanResults = ((WifiManager) Utils.getApp().getSystemService("wifi")).getScanResults()) != null) {
            wifiScanResults.setAllResults(scanResults);
        }
        return wifiScanResults;
    }

    public static boolean is4G() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getSubtype() == 13;
    }

    public static boolean is5G() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getSubtype() == 20;
    }

    public static boolean isAvailableByDns() {
        return isAvailableByDns("");
    }

    public static boolean isAvailableByDns(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "www.baidu.com";
        }
        try {
            return InetAddress.getByName(str) != null;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isConnected() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private static boolean isEthernet() {
        NetworkInfo networkInfo;
        NetworkInfo.State state;
        ConnectivityManager connectivityManager = (ConnectivityManager) Utils.getApp().getSystemService("connectivity");
        if (connectivityManager == null || (networkInfo = connectivityManager.getNetworkInfo(9)) == null || (state = networkInfo.getState()) == null) {
            return false;
        }
        return state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING;
    }

    public static boolean isMobileData() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == 0;
    }

    public static boolean isRegisteredNetworkStatusChangedListener(OnNetworkStatusChangedListener onNetworkStatusChangedListener) {
        return NetworkChangedReceiver.getInstance().isRegistered(onNetworkStatusChangedListener);
    }

    private static boolean isSameScanResultContent(ScanResult scanResult, ScanResult scanResult2) {
        return scanResult != null && scanResult2 != null && UtilsBridge.equals(scanResult.BSSID, scanResult2.BSSID) && UtilsBridge.equals(scanResult.SSID, scanResult2.SSID) && UtilsBridge.equals(scanResult.capabilities, scanResult2.capabilities) && scanResult.level == scanResult2.level;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isSameScanResults(List<ScanResult> list, List<ScanResult> list2) {
        if (list == null && list2 == null) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!isSameScanResultContent(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isWifiConnected() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) Utils.getApp().getSystemService("connectivity");
        return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || activeNetworkInfo.getType() != 1) ? false : true;
    }

    public static void openWirelessSettings() {
        Utils.getApp().startActivity(new Intent("android.settings.WIRELESS_SETTINGS").setFlags(268435456));
    }

    public static void registerNetworkCallback(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (init.compareAndSet(false, true)) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
                if (Build.VERSION.SDK_INT >= 24) {
                    e2.b.a(connectivityManager, new NetworkCallbackImpl());
                }
            }
        } catch (Throwable th) {
            Log.e(TAG, "registerNetworkCallback: ", th);
        }
    }

    public static void registerNetworkStatusChangedListener(OnNetworkStatusChangedListener onNetworkStatusChangedListener) {
        NetworkChangedReceiver.getInstance().registerListener(onNetworkStatusChangedListener);
    }

    public static void removeOnWifiChangedConsumer(final Utils.Consumer<WifiScanResults> consumer) {
        if (consumer == null) {
            return;
        }
        UtilsBridge.runOnUiThread(new Runnable() { // from class: com.cloud.tmc.miniutils.util.NetworkUtils.3
            @Override // java.lang.Runnable
            public void run() {
                NetworkUtils.SCAN_RESULT_CONSUMERS.remove(Utils.Consumer.this);
                if (NetworkUtils.SCAN_RESULT_CONSUMERS.isEmpty()) {
                    NetworkUtils.stopScanWifi();
                }
            }
        });
    }

    public static void setWifiEnabled(boolean z) {
        WifiManager wifiManager = (WifiManager) Utils.getApp().getSystemService("wifi");
        if (wifiManager == null || z == wifiManager.isWifiEnabled()) {
            return;
        }
        wifiManager.setWifiEnabled(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void startScanWifi() {
        sPreWifiScanResults = new WifiScanResults();
        Timer timer = new Timer();
        sScanWifiTimer = timer;
        timer.schedule(new TimerTask() { // from class: com.cloud.tmc.miniutils.util.NetworkUtils.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                NetworkUtils.startScanWifiIfEnabled();
                WifiScanResults wifiScanResult = NetworkUtils.getWifiScanResult();
                if (NetworkUtils.isSameScanResults(NetworkUtils.sPreWifiScanResults.allResults, wifiScanResult.allResults)) {
                    return;
                }
                NetworkUtils.sPreWifiScanResults = wifiScanResult;
                UtilsBridge.runOnUiThread(new Runnable() { // from class: com.cloud.tmc.miniutils.util.NetworkUtils.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it = NetworkUtils.SCAN_RESULT_CONSUMERS.iterator();
                        while (it.hasNext()) {
                            ((Utils.Consumer) it.next()).accept(NetworkUtils.sPreWifiScanResults);
                        }
                    }
                });
            }
        }, 0L, SCAN_PERIOD_MILLIS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void startScanWifiIfEnabled() {
        if (getWifiEnabled()) {
            ((WifiManager) Utils.getApp().getSystemService("wifi")).startScan();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void stopScanWifi() {
        Timer timer = sScanWifiTimer;
        if (timer != null) {
            timer.cancel();
            sScanWifiTimer = null;
        }
    }

    public static void unregisterNetworkStatusChangedListener(OnNetworkStatusChangedListener onNetworkStatusChangedListener) {
        NetworkChangedReceiver.getInstance().unregisterListener(onNetworkStatusChangedListener);
    }
}
