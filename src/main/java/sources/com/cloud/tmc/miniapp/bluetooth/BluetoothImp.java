package com.cloud.tmc.miniapp.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ParcelUuid;
import android.text.TextUtils;
import androidx.core.content.b;
import com.bytedance.sdk.openadsdk.core.settings.a;
import com.cloud.tmc.integration.utils.AppPrepareUtils;
import com.cloud.tmc.kernel.bridge.RenderCallContext;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.bluetooth.listener.OooO;
import com.cloud.tmc.miniapp.bluetooth.listener.OooO0O0;
import com.cloud.tmc.miniapp.bluetooth.listener.OooO0OO;
import com.cloud.tmc.miniapp.bluetooth.listener.OooO0o;
import com.cloud.tmc.miniapp.bluetooth.listener.OooOO0;
import com.cloud.tmc.miniapp.bluetooth.listener.OooOO0O;
import com.cloud.tmc.miniapp.bluetooth.listener.OooOOO0;
import com.cloud.tmc.miniutils.util.GsonUtils;
import com.cloud.tmc.miniutils.util.PermissionUtils;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class BluetoothImp implements IBluetooth {
    public com.cloud.tmc.miniapp.bluetooth.listener.OooO0OO OooO;
    public Context OooO0O0;
    public Intent OooO0OO;
    public com.cloud.tmc.miniapp.bluetooth.listener.OooO00o OooO0o;
    public BLEService OooO0o0;
    public OooOO0O OooO0oO;
    public OooOOO0 OooO0oo;
    public com.cloud.tmc.miniapp.bluetooth.listener.OooO0O0 OooOO0;
    public final String OooO00o = "BluetoothImp";
    public AtomicBoolean OooO0Oo = new AtomicBoolean(false);
    public final ConcurrentLinkedDeque<com.cloud.tmc.miniapp.bluetooth.listener.OooO0o> OooOO0O = new ConcurrentLinkedDeque<>();
    public final ConcurrentLinkedDeque<OooO> OooOO0o = new ConcurrentLinkedDeque<>();
    public final ConcurrentLinkedDeque<OooO> OooOOO0 = new ConcurrentLinkedDeque<>();
    public BroadcastReceiver OooOOO = new OooO00o();
    public BroadcastReceiver OooOOOO = new BroadcastReceiver() { // from class: com.cloud.tmc.miniapp.bluetooth.BluetoothImp$mGattUpdateReceiver$1
        /* JADX WARN: Code restructure failed: missing block: B:143:0x032f, code lost:
        
            r0 = r12.OooO00o.OooOO0;
         */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // android.content.BroadcastReceiver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onReceive(Context context, Intent intent) {
            OooO0O0 oooO0O0;
            String str;
            ConcurrentLinkedDeque concurrentLinkedDeque;
            OooO0OO oooO0OO;
            ConcurrentLinkedDeque concurrentLinkedDeque2;
            ConcurrentLinkedDeque concurrentLinkedDeque3;
            ConcurrentLinkedDeque concurrentLinkedDeque4;
            OooOOO0 oooOOO0;
            OooOOO0 oooOOO02;
            String action = intent != null ? intent.getAction() : null;
            if (action != null) {
                switch (action.hashCode()) {
                    case -987019949:
                        if (action.equals("com.cloud.tmc.bluetooth.le.ACTION_NOTIFY_CHARACTERISTIC") && oooO0O0 != null) {
                            String stringExtra = intent.getStringExtra("data_serviceUUID");
                            if (stringExtra == null) {
                                stringExtra = "";
                            }
                            String stringExtra2 = intent.getStringExtra("data_characteristicUUID");
                            str = stringExtra2 != null ? stringExtra2 : "";
                            byte[] byteArrayExtra = intent.getByteArrayExtra("data_characteristic");
                            if (byteArrayExtra == null) {
                                byteArrayExtra = new byte[0];
                            }
                            oooO0O0.OooO00o(stringExtra, str, byteArrayExtra);
                            break;
                        }
                        break;
                    case 251958246:
                        if (action.equals("com.cloud.tmc.bluetooth.le.ACTION_READ_CHARACTERISTIC")) {
                            concurrentLinkedDeque = BluetoothImp.this.OooOO0o;
                            Iterator it = concurrentLinkedDeque.iterator();
                            Intrinsics.g(it, "readListeners.iterator()");
                            while (it.hasNext()) {
                                OooO oooO = (OooO) it.next();
                                String stringExtra3 = intent.getStringExtra("data_serviceUUID");
                                if (stringExtra3 == null) {
                                    stringExtra3 = "";
                                }
                                String stringExtra4 = intent.getStringExtra("data_characteristicUUID");
                                if (stringExtra4 == null) {
                                    stringExtra4 = "";
                                }
                                byte[] byteArrayExtra2 = intent.getByteArrayExtra("data_characteristic");
                                if (byteArrayExtra2 == null) {
                                    byteArrayExtra2 = new byte[0];
                                }
                                oooO.OooO00o(stringExtra3, stringExtra4, byteArrayExtra2, intent.getIntExtra("data_status", -1));
                                it.remove();
                            }
                            break;
                        }
                        break;
                    case 284486225:
                        if (action.equals("com.cloud.tmc.bluetooth.le.ACTION_DEVICE_CONNECT_STATE")) {
                            TmcLogger.i(BluetoothImp.this.OooO00o, "mGattUpdateReceiver -> ACTION_DEVICE_CONNECT_STATE");
                            String stringExtra5 = intent.getStringExtra("address");
                            str = stringExtra5 != null ? stringExtra5 : "";
                            int intExtra = intent.getIntExtra("status", -1);
                            int intExtra2 = intent.getIntExtra("newState", -1);
                            TmcLogger.i(BluetoothImp.this.OooO00o, "mGattUpdateReceiver -> address:" + str + ",status:" + intExtra + ",newState:" + intExtra2);
                            oooO0OO = BluetoothImp.this.OooO;
                            if (oooO0OO != null) {
                                oooO0OO.OooO00o(str, intExtra, intExtra2);
                                break;
                            }
                        }
                        break;
                    case 344915417:
                        if (action.equals("com.cloud.tmc.bluetooth.le.ACTION_WRITE_CHARACTERISTIC")) {
                            concurrentLinkedDeque2 = BluetoothImp.this.OooOOO0;
                            Iterator it2 = concurrentLinkedDeque2.iterator();
                            Intrinsics.g(it2, "writeListeners.iterator()");
                            while (it2.hasNext()) {
                                OooO oooO2 = (OooO) it2.next();
                                String stringExtra6 = intent.getStringExtra("data_serviceUUID");
                                if (stringExtra6 == null) {
                                    stringExtra6 = "";
                                }
                                String stringExtra7 = intent.getStringExtra("data_characteristicUUID");
                                if (stringExtra7 == null) {
                                    stringExtra7 = "";
                                }
                                byte[] byteArrayExtra3 = intent.getByteArrayExtra("data_characteristic");
                                if (byteArrayExtra3 == null) {
                                    byteArrayExtra3 = new byte[0];
                                }
                                oooO2.OooO00o(stringExtra6, stringExtra7, byteArrayExtra3, intent.getIntExtra("data_status", -1));
                                it2.remove();
                            }
                            break;
                        }
                        break;
                    case 655074071:
                        if (action.equals("com.cloud.tmc.bluetooth.le.ACTION_NOTIFY_BLUETOOTH_ADAPTER_STATE_CHANGE")) {
                            TmcLogger.i(BluetoothImp.this.OooO00o, "mGattUpdateReceiver -> ACTION_NOTIFT_BLUETOOTH_ADAPTER_STATE_CHANGE");
                            Bundle extras = intent.getExtras();
                            boolean z = extras != null ? extras.getBoolean("scan") : false;
                            Bundle extras2 = intent.getExtras();
                            boolean z2 = extras2 != null ? extras2.getBoolean("avaliable") : false;
                            TmcLogger.i(BluetoothImp.this.OooO00o, "mGattUpdateReceiver -> getBluetoothAdapterState:" + z + "," + z2);
                            OooOO0O oooOO0O = BluetoothImp.this.OooO0oO;
                            if (oooOO0O != null) {
                                oooOO0O.OooO00o(z, z2);
                                break;
                            }
                        }
                        break;
                    case 709515595:
                        if (action.equals("com.cloud.tmc.bluetooth.le.ACTION_SERVICES_DISCOVERED")) {
                            TmcLogger.i(BluetoothImp.this.OooO00o, "mGattUpdateReceiver -> ACTION_SERVICES_DISCOVERED");
                            Bundle extras3 = intent.getExtras();
                            long j = extras3 != null ? extras3.getLong(TmcConstants.BRIDGE_RESPONSE_ERROR_CODE_KEY) : BluetoothCode.SYSTEM_ERROR.getCode();
                            if (j == BluetoothCode.OK.getCode()) {
                                ArrayList arrayList = new ArrayList();
                                BLEService bLEService = BluetoothImp.this.OooO0o0;
                                if (bLEService != null) {
                                    BluetoothGatt bluetoothGatt = bLEService.OooO0o;
                                    List<BluetoothGattService> services = bluetoothGatt != null ? bluetoothGatt.getServices() : null;
                                    if (services == null) {
                                        services = new ArrayList<>();
                                    }
                                    BluetoothImp bluetoothImp = BluetoothImp.this;
                                    for (BluetoothGattService bluetoothGattService : services) {
                                        String uuid = bluetoothGattService.getUuid().toString();
                                        Intrinsics.g(uuid, "it.uuid.toString()");
                                        boolean z3 = bluetoothGattService.getType() == 0;
                                        TmcLogger.i(bluetoothImp.OooO00o, "mGattUpdateReceiver -> SUCCESS uuid:" + uuid + ",isPrimary:" + z3);
                                        arrayList.add(MapsKt.l(new Pair[]{TuplesKt.a("uuid", uuid), TuplesKt.a("isPrimary", String.valueOf(z3))}));
                                    }
                                }
                                concurrentLinkedDeque4 = BluetoothImp.this.OooOO0O;
                                Iterator it3 = concurrentLinkedDeque4.iterator();
                                Intrinsics.g(it3, "deviceServicesListeners.iterator()");
                                while (it3.hasNext()) {
                                    ((OooO0o) it3.next()).OooO00o(arrayList);
                                    it3.remove();
                                }
                                break;
                            } else {
                                TmcLogger.i(BluetoothImp.this.OooO00o, "mGattUpdateReceiver -> FAIL:" + j);
                                concurrentLinkedDeque3 = BluetoothImp.this.OooOO0O;
                                Iterator it4 = concurrentLinkedDeque3.iterator();
                                Intrinsics.g(it4, "deviceServicesListeners.iterator()");
                                while (it4.hasNext()) {
                                    ((OooO0o) it4.next()).OooO00o(j);
                                    it4.remove();
                                }
                                break;
                            }
                        }
                        break;
                    case 1591015073:
                        if (action.equals("com.cloud.tmc.bluetooth.le.ACTION_SCAN_RESULT")) {
                            TmcLogger.i(BluetoothImp.this.OooO00o, "mGattUpdateReceiver -> ACTION_SCAN_RESULT");
                            Bundle extras4 = intent.getExtras();
                            long j2 = extras4 != null ? extras4.getLong(TmcConstants.BRIDGE_RESPONSE_ERROR_CODE_KEY) : BluetoothCode.SYSTEM_ERROR.getCode();
                            if (j2 != BluetoothCode.OK.getCode()) {
                                TmcLogger.i(BluetoothImp.this.OooO00o, "mGattUpdateReceiver -> SCAN_FAIL:" + j2);
                                oooOOO0 = BluetoothImp.this.OooO0oo;
                                if (oooOOO0 != null) {
                                    oooOOO0.OooO00o(j2);
                                    break;
                                }
                            } else {
                                Bundle extras5 = intent.getExtras();
                                if (extras5 != null && extras5.containsKey("scan_result")) {
                                    Bundle extras6 = intent.getExtras();
                                    Object fromJson = GsonUtils.fromJson(extras6 != null ? extras6.getString("scan_result") : null, new TypeToken<Map<String, ? extends String>>() { // from class: com.cloud.tmc.miniapp.bluetooth.BluetoothImp$mGattUpdateReceiver$1$onReceive$scanRsultData$1
                                    }.getType());
                                    Intrinsics.g(fromJson, "fromJson(\n              …                        )");
                                    Map<String, String> map = (Map) fromJson;
                                    TmcLogger.i(BluetoothImp.this.OooO00o, "mGattUpdateReceiver -> SCAN_SUCCESS:" + map);
                                    oooOOO02 = BluetoothImp.this.OooO0oo;
                                    if (oooOOO02 != null) {
                                        oooOOO02.OooO00o(map);
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                }
            }
        }
    };
    public final OooO0o OooOOOo = new OooO0o();

    public static final class OooO00o extends BroadcastReceiver {

        /* renamed from: com.cloud.tmc.miniapp.bluetooth.BluetoothImp$OooO00o$OooO00o, reason: collision with other inner class name */
        public static final class C0001OooO00o extends Lambda implements Function2<Boolean, Boolean, Unit> {
            public final /* synthetic */ BluetoothImp OooO00o;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0001OooO00o(BluetoothImp bluetoothImp) {
                super(2);
                this.OooO00o = bluetoothImp;
            }

            public final void OooO00o(boolean z, boolean z2) {
                TmcLogger.i(this.OooO00o.OooO00o, "bluetoothSwitchReceiver -> getBluetoothAdapterState:" + z + "," + z2);
                OooOO0O oooOO0O = this.OooO00o.OooO0oO;
                if (oooOO0O != null) {
                    oooOO0O.OooO00o(z, z2);
                }
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                OooO00o(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue());
                return Unit.a;
            }
        }

        public static final class OooO0O0 extends Lambda implements Function2<Boolean, Boolean, Unit> {
            public final /* synthetic */ BluetoothImp OooO00o;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OooO0O0(BluetoothImp bluetoothImp) {
                super(2);
                this.OooO00o = bluetoothImp;
            }

            public final void OooO00o(boolean z, boolean z2) {
                TmcLogger.i(this.OooO00o.OooO00o, "bluetoothSwitchReceiver -> getBluetoothAdapterState:" + z + "," + z2);
                OooOO0O oooOO0O = this.OooO00o.OooO0oO;
                if (oooOO0O != null) {
                    oooOO0O.OooO00o(z, z2);
                }
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                OooO00o(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue());
                return Unit.a;
            }
        }

        public OooO00o() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Integer valueOf = intent != null ? Integer.valueOf(intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE)) : null;
            if ((valueOf != null && valueOf.intValue() == 10) || (valueOf != null && valueOf.intValue() == 13)) {
                TmcLogger.i(BluetoothImp.this.OooO00o, "bluetoothSwitchReceiver -> STATE_OFF | STATE_TURNING_OFF");
                BLEService bLEService = BluetoothImp.this.OooO0o0;
                if (bLEService != null) {
                    bLEService.OooO0Oo();
                }
                BLEService bLEService2 = BluetoothImp.this.OooO0o0;
                if (bLEService2 != null) {
                    bLEService2.OooO00o(new C0001OooO00o(BluetoothImp.this));
                    return;
                }
                return;
            }
            if ((valueOf != null && valueOf.intValue() == 12) || (valueOf != null && valueOf.intValue() == 11)) {
                TmcLogger.i(BluetoothImp.this.OooO00o, "bluetoothSwitchReceiver -> STATE_ON | STATE_TURNING_ON");
                BLEService bLEService3 = BluetoothImp.this.OooO0o0;
                if (bLEService3 != null) {
                    bLEService3.OooO00o(new OooO0O0(BluetoothImp.this));
                }
            }
        }
    }

    public static final class OooO0O0 implements PermissionUtils.SimpleCallback {
        public final /* synthetic */ Context OooO0O0;
        public final /* synthetic */ com.cloud.tmc.miniapp.bluetooth.listener.OooO00o OooO0OO;

        public OooO0O0(Context context, com.cloud.tmc.miniapp.bluetooth.listener.OooO00o oooO00o) {
            this.OooO0O0 = context;
            this.OooO0OO = oooO00o;
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.SimpleCallback
        public void onDenied() {
            TmcLogger.e(BluetoothImp.this.OooO00o, "> Build.VERSION_CODES.S Permission denied");
            this.OooO0OO.OooO00o(BluetoothCode.NOT_PERMISSION.getCode());
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.SimpleCallback
        public void onGranted() {
            BluetoothImp.access$init(BluetoothImp.this, this.OooO0O0, this.OooO0OO);
        }
    }

    public static final class OooO0OO implements PermissionUtils.SimpleCallback {
        public final /* synthetic */ Context OooO0O0;
        public final /* synthetic */ com.cloud.tmc.miniapp.bluetooth.listener.OooO00o OooO0OO;

        public OooO0OO(Context context, com.cloud.tmc.miniapp.bluetooth.listener.OooO00o oooO00o) {
            this.OooO0O0 = context;
            this.OooO0OO = oooO00o;
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.SimpleCallback
        public void onDenied() {
            TmcLogger.e(BluetoothImp.this.OooO00o, "<= Build.VERSION_CODES.S Permission denied");
            this.OooO0OO.OooO00o(BluetoothCode.NOT_PERMISSION.getCode());
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.SimpleCallback
        public void onGranted() {
            BluetoothImp.access$init(BluetoothImp.this, this.OooO0O0, this.OooO0OO);
        }
    }

    public static final class OooO0o implements ServiceConnection {
        public OooO0o() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            long code;
            BluetoothAdapter bluetoothAdapter;
            BluetoothImp bluetoothImp = BluetoothImp.this;
            Intrinsics.f(iBinder, "null cannot be cast to non-null type com.cloud.tmc.miniapp.bluetooth.BLEService.LocalBinder");
            bluetoothImp.OooO0o0 = BLEService.this;
            com.cloud.tmc.miniapp.bluetooth.listener.OooO00o oooO00o = BluetoothImp.this.OooO0o;
            if (oooO00o != null) {
                BLEService bLEService = BluetoothImp.this.OooO0o0;
                if (bLEService != null) {
                    Object systemService = bLEService.getSystemService("bluetooth");
                    BluetoothManager bluetoothManager = systemService instanceof BluetoothManager ? (BluetoothManager) systemService : null;
                    bLEService.OooO00o = bluetoothManager;
                    BluetoothAdapter adapter = bluetoothManager != null ? bluetoothManager.getAdapter() : null;
                    bLEService.OooO0O0 = adapter;
                    bLEService.OooO0OO = adapter != null ? adapter.getBluetoothLeScanner() : null;
                    bLEService.OooO0Oo = new OooOO0(bLEService);
                    if (bLEService.OooO00o == null || (bluetoothAdapter = bLEService.OooO0O0) == null || bLEService.OooO0OO == null) {
                        code = BluetoothCode.NOT_INIT.getCode();
                    } else if (bluetoothAdapter.isEnabled()) {
                        bLEService.OooO0OO();
                        code = BluetoothCode.OK.getCode();
                    } else {
                        code = BluetoothCode.NOT_AVALIABLE.getCode();
                    }
                } else {
                    code = BluetoothCode.FAIL.getCode();
                }
                oooO00o.OooO00o(code);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            BluetoothImp.this.OooO0o0 = null;
        }
    }

    public static final void access$init(BluetoothImp bluetoothImp, Context context, com.cloud.tmc.miniapp.bluetooth.listener.OooO00o oooO00o) {
        if (bluetoothImp.OooO0Oo.get()) {
            TmcLogger.d(bluetoothImp.OooO00o, "BluetoothManager already init");
            oooO00o.OooO00o(BluetoothCode.ALREADY_INIT.getCode());
            return;
        }
        bluetoothImp.OooO0Oo.set(true);
        bluetoothImp.OooO0O0 = context;
        bluetoothImp.OooO0o = oooO00o;
        Intent intent = new Intent(context, (Class<?>) BLEService.class);
        bluetoothImp.OooO0OO = intent;
        AppPrepareUtils.INSTANCE.addCommonIntentParameter(intent, context);
        Intent intent2 = bluetoothImp.OooO0OO;
        if (intent2 != null) {
            context.bindService(intent2, bluetoothImp.OooOOOo, 1);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.cloud.tmc.bluetooth.le.ACTION_NOTIFY_BLUETOOTH_ADAPTER_STATE_CHANGE");
        intentFilter.addAction("com.cloud.tmc.bluetooth.le.ACTION_SCAN_RESULT");
        intentFilter.addAction("com.cloud.tmc.bluetooth.le.ACTION_DEVICE_CONNECT_STATE");
        intentFilter.addAction("com.cloud.tmc.bluetooth.le.ACTION_SERVICES_DISCOVERED");
        intentFilter.addAction("com.cloud.tmc.bluetooth.le.ACTION_READ_CHARACTERISTIC");
        intentFilter.addAction("com.cloud.tmc.bluetooth.le.ACTION_WRITE_CHARACTERISTIC");
        intentFilter.addAction("com.cloud.tmc.bluetooth.le.ACTION_NOTIFY_CHARACTERISTIC");
        if (Build.VERSION.SDK_INT >= 33) {
            a.a(context, bluetoothImp.OooOOOO, intentFilter, 4);
        } else {
            context.registerReceiver(bluetoothImp.OooOOOO, intentFilter);
        }
        context.registerReceiver(bluetoothImp.OooOOO, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public long closeBLEConnection(String str) {
        Intrinsics.h(str, "address");
        if (TextUtils.isEmpty(str)) {
            return BluetoothCode.INVALID_DATA.getCode();
        }
        BLEService bLEService = this.OooO0o0;
        return bLEService != null ? bLEService.OooO00o(str) : BluetoothCode.SYSTEM_ERROR.getCode();
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public void closeBluetoothAdapter() {
        this.OooO0Oo.set(false);
        BLEService bLEService = this.OooO0o0;
        if (bLEService != null && (Build.VERSION.SDK_INT <= 31 || b.checkSelfPermission(bLEService, "android.permission.BLUETOOTH_SCAN") == 0)) {
            String str = bLEService.OooO0oO;
            if (str == null) {
                str = "";
            }
            bLEService.OooO00o(str);
            bLEService.OooO0Oo();
            bLEService.OooO0Oo = null;
            bLEService.OooO0OO = null;
            bLEService.OooO0O0 = null;
            bLEService.OooO00o = null;
            bLEService.OooO0OO();
        }
        Context context = this.OooO0O0;
        if (context != null) {
            context.unbindService(this.OooOOOo);
        }
        Context context2 = this.OooO0O0;
        if (context2 != null) {
            context2.unregisterReceiver(this.OooOOOO);
        }
        Context context3 = this.OooO0O0;
        if (context3 != null) {
            context3.unregisterReceiver(this.OooOOO);
        }
        this.OooO0O0 = null;
        this.OooO0o0 = null;
        this.OooO0o = null;
        this.OooO0oO = null;
        this.OooO0oo = null;
        this.OooO = null;
        this.OooOO0 = null;
        this.OooOO0O.clear();
        this.OooOO0o.clear();
        this.OooOOO0.clear();
        TmcLogger.d(this.OooO00o, "closeBluetoothAdapter  -> ");
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public long createBLEConnection(String str) {
        BluetoothGatt bluetoothGatt;
        Intrinsics.h(str, "address");
        if (TextUtils.isEmpty(str)) {
            return BluetoothCode.INVALID_DATA.getCode();
        }
        BLEService bLEService = this.OooO0o0;
        if (bLEService == null) {
            return BluetoothCode.SYSTEM_ERROR.getCode();
        }
        Intrinsics.h(str, "address");
        if (!bLEService.OooO0O0()) {
            return BluetoothCode.NOT_AVALIABLE.getCode();
        }
        if (bLEService.OooO00o == null) {
            return BluetoothCode.SYSTEM_ERROR.getCode();
        }
        if (bLEService.OooO0oo.get()) {
            return BluetoothCode.ALREADY_CONNECION.getCode();
        }
        if (Build.VERSION.SDK_INT > 31 && b.checkSelfPermission(bLEService, "android.permission.BLUETOOTH_SCAN") != 0) {
            return BluetoothCode.NOT_PERMISSION.getCode();
        }
        if (Intrinsics.c(str, bLEService.OooO0oO) && (bluetoothGatt = bLEService.OooO0o) != null) {
            return bluetoothGatt.connect() ? BluetoothCode.OK.getCode() : BluetoothCode.CONNECTION_FAIL.getCode();
        }
        BluetoothAdapter bluetoothAdapter = bLEService.OooO0O0;
        BluetoothDevice remoteDevice = bluetoothAdapter != null ? bluetoothAdapter.getRemoteDevice(str) : null;
        bLEService.OooO0o = remoteDevice != null ? remoteDevice.connectGatt(bLEService, false, bLEService.OooOO0) : null;
        bLEService.OooO0oO = str;
        return BluetoothCode.OK.getCode();
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public List<BluetoothGattCharacteristic> getBLEDeviceCharacteristics(String str) {
        BLEService bLEService;
        Intrinsics.h(str, "serviceUUID");
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str) && (bLEService = this.OooO0o0) != null) {
            BluetoothGatt bluetoothGatt = bLEService.OooO0o;
            List<BluetoothGattService> services = bluetoothGatt != null ? bluetoothGatt.getServices() : null;
            if (services == null) {
                services = new ArrayList<>();
            }
            for (BluetoothGattService bluetoothGattService : services) {
                if (StringsKt.H(str, bluetoothGattService.getUuid().toString(), true)) {
                    List<BluetoothGattCharacteristic> characteristics = bluetoothGattService.getCharacteristics();
                    Intrinsics.g(characteristics, "it.characteristics");
                    arrayList.addAll(characteristics);
                }
            }
        }
        return arrayList;
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public List<Map<String, String>> getBLEDeviceCharacteristicsMap(String str) {
        Intrinsics.h(str, "serviceUUID");
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : getBLEDeviceCharacteristics(str)) {
            arrayList.add(MapsKt.l(new Pair[]{TuplesKt.a("uuid", bluetoothGattCharacteristic.getUuid().toString()), TuplesKt.a("properties", String.valueOf(bluetoothGattCharacteristic.getProperties()))}));
        }
        return arrayList;
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public void getBLEDeviceServices(com.cloud.tmc.miniapp.bluetooth.listener.OooO0o oooO0o) {
        long code;
        Intrinsics.h(oooO0o, "listener");
        BLEService bLEService = this.OooO0o0;
        if (bLEService == null) {
            code = BluetoothCode.SYSTEM_ERROR.getCode();
        } else if (Build.VERSION.SDK_INT <= 31 || b.checkSelfPermission(bLEService, "android.permission.BLUETOOTH_SCAN") == 0) {
            BluetoothGatt bluetoothGatt = bLEService.OooO0o;
            code = bluetoothGatt != null ? bluetoothGatt.discoverServices() ? BluetoothCode.OK.getCode() : BluetoothCode.FAIL.getCode() : BluetoothCode.SYSTEM_ERROR.getCode();
        } else {
            code = BluetoothCode.NOT_PERMISSION.getCode();
        }
        if (code != BluetoothCode.OK.getCode()) {
            oooO0o.OooO00o(code);
        } else {
            this.OooOO0O.add(oooO0o);
        }
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public long getBluetoothAdapterState(Function2<? super Boolean, ? super Boolean, Unit> function2) {
        Intrinsics.h(function2, RenderCallContext.TYPE_CALLBACK);
        BLEService bLEService = this.OooO0o0;
        if (bLEService == null) {
            return BluetoothCode.SYSTEM_ERROR.getCode();
        }
        bLEService.OooO00o(function2);
        return BluetoothCode.OK.getCode();
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public List<BluetoothDevice> getConnectedBluetoothDevices() {
        BLEService bLEService = this.OooO0o0;
        return bLEService != null ? bLEService.OooO00o() : new ArrayList();
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public List<Map<String, String>> getConnectedBluetoothDevicesMap() {
        BLEService bLEService = this.OooO0o0;
        if (bLEService == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT > 31 && b.checkSelfPermission(bLEService, "android.permission.BLUETOOTH_SCAN") != 0) {
            return arrayList;
        }
        for (BluetoothDevice bluetoothDevice : bLEService.OooO00o()) {
            arrayList.add(MapsKt.l(new Pair[]{TuplesKt.a("name", bluetoothDevice.getName()), TuplesKt.a("address", bluetoothDevice.getAddress())}));
        }
        return arrayList;
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public long notifyBLECharacteristicValueChange(String str, String str2, boolean z) {
        Intrinsics.h(str, "serviceUUID");
        Intrinsics.h(str2, "characteristicUUID");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return BluetoothCode.INVALID_DATA.getCode();
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristic = null;
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic2 : getBLEDeviceCharacteristics(str)) {
            if (StringsKt.H(str2, bluetoothGattCharacteristic2.getUuid().toString(), true)) {
                bluetoothGattCharacteristic = bluetoothGattCharacteristic2;
            }
        }
        if (bluetoothGattCharacteristic == null) {
            return BluetoothCode.N0_CHARACTERISTIC.getCode();
        }
        BLEService bLEService = this.OooO0o0;
        if (bLEService == null) {
            return BluetoothCode.SYSTEM_ERROR.getCode();
        }
        Intrinsics.h(bluetoothGattCharacteristic, "characteristic");
        if (Build.VERSION.SDK_INT > 31 && b.checkSelfPermission(bLEService, "android.permission.BLUETOOTH_SCAN") != 0) {
            return BluetoothCode.NOT_PERMISSION.getCode();
        }
        BluetoothGatt bluetoothGatt = bLEService.OooO0o;
        if (bluetoothGatt == null) {
            return BluetoothCode.SYSTEM_ERROR.getCode();
        }
        if (!bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, z)) {
            return BluetoothCode.FAIL.getCode();
        }
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(UUID.fromString("00002902-0000-1000-8000-00805f9b34fb"));
        if (descriptor == null) {
            return BluetoothCode.N0_CHARACTERISTIC_DESCRIPTOR.getCode();
        }
        Intrinsics.g(descriptor, "getDescriptor(UUID.fromS…T_CHARACTERISTIC_CONFIG))");
        descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        bluetoothGatt.writeDescriptor(descriptor);
        return BluetoothCode.OK.getCode();
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public boolean offBLECharacteristicValueChange(String str) {
        Intrinsics.h(str, "callbackId");
        com.cloud.tmc.miniapp.bluetooth.listener.OooO0O0 oooO0O0 = this.OooOO0;
        if (oooO0O0 != null) {
            oooO0O0.OooO00o(str);
        }
        this.OooOO0 = null;
        return true;
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public boolean offBLEConnectionStateChange(String str) {
        Intrinsics.h(str, "callbackId");
        com.cloud.tmc.miniapp.bluetooth.listener.OooO0OO oooO0OO = this.OooO;
        if (oooO0OO != null) {
            oooO0OO.OooO00o(str);
        }
        this.OooO = null;
        return true;
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public boolean offBluetoothAdapterStateChange(String str) {
        Intrinsics.h(str, "callbackId");
        OooOO0O oooOO0O = this.OooO0oO;
        if (oooOO0O != null) {
            oooOO0O.OooO00o(str);
        }
        this.OooO0oO = null;
        return true;
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public boolean offBluetoothDeviceFound(String str) {
        Intrinsics.h(str, "callbackId");
        OooOOO0 oooOOO0 = this.OooO0oo;
        if (oooOOO0 != null) {
            oooOOO0.OooO00o(str);
        }
        this.OooO0oo = null;
        return true;
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public void onBLECharacteristicValueChange(String str, com.cloud.tmc.miniapp.bluetooth.listener.OooO0O0 oooO0O0) {
        Intrinsics.h(str, "callbackId");
        Intrinsics.h(oooO0O0, "listener");
        this.OooOO0 = oooO0O0;
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public void onBLEConnectionStateChange(String str, com.cloud.tmc.miniapp.bluetooth.listener.OooO0OO oooO0OO) {
        Intrinsics.h(str, "callbackId");
        Intrinsics.h(oooO0OO, "listener");
        this.OooO = oooO0OO;
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public void onBluetoothAdapterStateChange(String str, OooOO0O oooOO0O) {
        Intrinsics.h(str, "callbackId");
        Intrinsics.h(oooOO0O, "bluetoothAdapterStateListener");
        this.OooO0oO = oooOO0O;
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public void onBluetoothDeviceFound(String str, OooOOO0 oooOOO0) {
        Intrinsics.h(str, "callbackId");
        Intrinsics.h(oooOOO0, "listener");
        this.OooO0oo = oooOOO0;
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public void openBluetoothAdapter(Context context, com.cloud.tmc.miniapp.bluetooth.listener.OooO00o oooO00o) {
        Intrinsics.h(context, "context");
        Intrinsics.h(oooO00o, RenderCallContext.TYPE_CALLBACK);
        if (Build.VERSION.SDK_INT >= 31) {
            PermissionUtils.permission("android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.ACCESS_COARSE_LOCATION").callback(new OooO0O0(context, oooO00o)).request();
        } else {
            PermissionUtils.permission("android.permission.ACCESS_COARSE_LOCATION").callback(new OooO0OO(context, oooO00o)).request();
        }
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public long readBLECharacteristicValue(String str, String str2, OooO oooO) {
        Intrinsics.h(str, "serviceUUID");
        Intrinsics.h(str2, "characteristicUUID");
        Intrinsics.h(oooO, "listener");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return BluetoothCode.INVALID_DATA.getCode();
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristic = null;
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic2 : getBLEDeviceCharacteristics(str)) {
            if (StringsKt.H(str2, bluetoothGattCharacteristic2.getUuid().toString(), true)) {
                bluetoothGattCharacteristic = bluetoothGattCharacteristic2;
            }
        }
        if (bluetoothGattCharacteristic == null) {
            return BluetoothCode.N0_CHARACTERISTIC.getCode();
        }
        this.OooOO0o.add(oooO);
        BLEService bLEService = this.OooO0o0;
        if (bLEService == null) {
            return BluetoothCode.SYSTEM_ERROR.getCode();
        }
        Intrinsics.h(bluetoothGattCharacteristic, "characteristic");
        if (Build.VERSION.SDK_INT > 31 && b.checkSelfPermission(bLEService, "android.permission.BLUETOOTH_SCAN") != 0) {
            return BluetoothCode.NOT_PERMISSION.getCode();
        }
        BluetoothGatt bluetoothGatt = bLEService.OooO0o;
        return bluetoothGatt != null ? bluetoothGatt.readCharacteristic(bluetoothGattCharacteristic) ? BluetoothCode.OK.getCode() : BluetoothCode.FAIL.getCode() : BluetoothCode.SYSTEM_ERROR.getCode();
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public long startBluetoothDevicesDiscovery(List<String> list, int i) {
        Intrinsics.h(list, "serviceUUIDS");
        StringBuilder sb = new StringBuilder();
        sb.append("startBluetoothDevicesDiscovery -> serviceUUIDS:");
        sb.append(list);
        sb.append("powerLevel:");
        sb.append(i);
        Context context = this.OooO0O0;
        LocationManager locationManager = (LocationManager) (context != null ? context.getSystemService("location") : null);
        if (!(locationManager == null ? false : locationManager.isProviderEnabled("gps"))) {
            return BluetoothCode.NO_POSITION_FUNCTION.getCode();
        }
        BLEService bLEService = this.OooO0o0;
        if (bLEService == null) {
            return BluetoothCode.SYSTEM_ERROR.getCode();
        }
        Intrinsics.h(list, "serviceUUIDS");
        if (!bLEService.OooO0O0()) {
            return BluetoothCode.NOT_AVALIABLE.getCode();
        }
        if (bLEService.OooO0OO == null) {
            return BluetoothCode.SYSTEM_ERROR.getCode();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ScanFilter build = new ScanFilter.Builder().setServiceUuid(ParcelUuid.fromString((String) it.next())).build();
            Intrinsics.g(build, "Builder().setServiceUuid…d.fromString(it)).build()");
            arrayList.add(build);
        }
        if (Build.VERSION.SDK_INT > 31 && b.checkSelfPermission(bLEService, "android.permission.BLUETOOTH_SCAN") != 0) {
            return BluetoothCode.NOT_PERMISSION.getCode();
        }
        BluetoothLeScanner bluetoothLeScanner = bLEService.OooO0OO;
        if (bluetoothLeScanner == null) {
            return BluetoothCode.SYSTEM_ERROR.getCode();
        }
        bluetoothLeScanner.startScan(arrayList, new ScanSettings.Builder().setScanMode(i).build(), bLEService.OooO0Oo);
        bLEService.OooO0o0.set(true);
        return BluetoothCode.OK.getCode();
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public void stopBluetoothDevicesDiscovery() {
        BLEService bLEService = this.OooO0o0;
        if (bLEService != null) {
            bLEService.OooO0Oo();
        }
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.IBluetooth
    public long writeBLECharacteristicValue(String str, String str2, byte[] bArr, OooO oooO) {
        Intrinsics.h(str, "serviceUUID");
        Intrinsics.h(str2, "characteristicUUID");
        Intrinsics.h(bArr, "value");
        Intrinsics.h(oooO, "listener");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return BluetoothCode.INVALID_DATA.getCode();
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristic = null;
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic2 : getBLEDeviceCharacteristics(str)) {
            if (StringsKt.H(str2, bluetoothGattCharacteristic2.getUuid().toString(), true)) {
                bluetoothGattCharacteristic = bluetoothGattCharacteristic2;
            }
        }
        if (bluetoothGattCharacteristic == null) {
            return BluetoothCode.N0_CHARACTERISTIC.getCode();
        }
        this.OooOOO0.add(oooO);
        BLEService bLEService = this.OooO0o0;
        if (bLEService == null) {
            return BluetoothCode.SYSTEM_ERROR.getCode();
        }
        Intrinsics.h(bluetoothGattCharacteristic, "characteristic");
        Intrinsics.h(bArr, "value");
        bluetoothGattCharacteristic.setValue(bArr);
        if (Build.VERSION.SDK_INT > 31 && b.checkSelfPermission(bLEService, "android.permission.BLUETOOTH_SCAN") != 0) {
            return BluetoothCode.NOT_PERMISSION.getCode();
        }
        BluetoothGatt bluetoothGatt = bLEService.OooO0o;
        return bluetoothGatt != null ? bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic) ? BluetoothCode.OK.getCode() : BluetoothCode.FAIL.getCode() : BluetoothCode.SYSTEM_ERROR.getCode();
    }
}
