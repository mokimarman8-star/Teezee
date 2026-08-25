package com.cloud.tmc.miniapp.bluetooth;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanResult;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import androidx.core.content.b;
import com.cloud.tmc.kernel.bridge.RenderCallContext;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.bluetooth.listener.OooOO0;
import com.cloud.tmc.miniutils.util.GsonUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class BLEService extends Service implements OooOO0.OooO00o {
    public static final /* synthetic */ int OooOO0O = 0;
    public BluetoothManager OooO00o;
    public BluetoothAdapter OooO0O0;
    public BluetoothLeScanner OooO0OO;
    public OooOO0 OooO0Oo;
    public BluetoothGatt OooO0o;
    public String OooO0oO;
    public AtomicBoolean OooO0o0 = new AtomicBoolean(false);
    public AtomicBoolean OooO0oo = new AtomicBoolean(false);
    public final IBinder OooO = new OooO00o();
    public final BluetoothGattCallback OooOO0 = new OooO0O0();

    public final class OooO00o extends Binder {
        public OooO00o() {
        }
    }

    public static final class OooO0O0 extends BluetoothGattCallback {
        public OooO0O0() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            UUID uuid;
            BluetoothGattService service;
            UUID uuid2;
            byte[] value;
            super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
            List e = (bluetoothGattCharacteristic == null || (value = bluetoothGattCharacteristic.getValue()) == null) ? null : ArraysKt.e(value);
            StringBuilder sb = new StringBuilder();
            sb.append("onCharacteristicChanged:");
            sb.append(e);
            BLEService bLEService = BLEService.this;
            long code = BluetoothCode.OK.getCode();
            Bundle bundle = new Bundle();
            bundle.putString("data_serviceUUID", (bluetoothGattCharacteristic == null || (service = bluetoothGattCharacteristic.getService()) == null || (uuid2 = service.getUuid()) == null) ? null : uuid2.toString());
            bundle.putString("data_characteristicUUID", (bluetoothGattCharacteristic == null || (uuid = bluetoothGattCharacteristic.getUuid()) == null) ? null : uuid.toString());
            bundle.putByteArray("data_characteristic", bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getValue() : null);
            Unit unit = Unit.a;
            int i = BLEService.OooOO0O;
            bLEService.OooO00o("com.cloud.tmc.bluetooth.le.ACTION_NOTIFY_CHARACTERISTIC", code, bundle);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            UUID uuid;
            BluetoothGattService service;
            UUID uuid2;
            super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
            byte[] value = bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getValue() : null;
            if (value == null) {
                value = new byte[0];
            }
            String str = new String(value, Charsets.b);
            StringBuilder sb = new StringBuilder();
            sb.append("onCharacteristicRead:");
            sb.append(str);
            BLEService bLEService = BLEService.this;
            long code = BluetoothCode.OK.getCode();
            Bundle bundle = new Bundle();
            bundle.putString("data_serviceUUID", (bluetoothGattCharacteristic == null || (service = bluetoothGattCharacteristic.getService()) == null || (uuid2 = service.getUuid()) == null) ? null : uuid2.toString());
            bundle.putString("data_characteristicUUID", (bluetoothGattCharacteristic == null || (uuid = bluetoothGattCharacteristic.getUuid()) == null) ? null : uuid.toString());
            bundle.putByteArray("data_characteristic", bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getValue() : null);
            bundle.putInt("data_status", i);
            Unit unit = Unit.a;
            int i2 = BLEService.OooOO0O;
            bLEService.OooO00o("com.cloud.tmc.bluetooth.le.ACTION_READ_CHARACTERISTIC", code, bundle);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            UUID uuid;
            BluetoothGattService service;
            UUID uuid2;
            super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
            byte[] value = bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getValue() : null;
            if (value == null) {
                value = new byte[0];
            }
            String str = new String(value, Charsets.b);
            StringBuilder sb = new StringBuilder();
            sb.append("onCharacteristicWrite:");
            sb.append(str);
            BLEService bLEService = BLEService.this;
            long code = BluetoothCode.OK.getCode();
            Bundle bundle = new Bundle();
            bundle.putString("data_serviceUUID", (bluetoothGattCharacteristic == null || (service = bluetoothGattCharacteristic.getService()) == null || (uuid2 = service.getUuid()) == null) ? null : uuid2.toString());
            bundle.putString("data_characteristicUUID", (bluetoothGattCharacteristic == null || (uuid = bluetoothGattCharacteristic.getUuid()) == null) ? null : uuid.toString());
            bundle.putByteArray("data_characteristic", bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getValue() : null);
            bundle.putInt("data_status", i);
            Unit unit = Unit.a;
            int i2 = BLEService.OooOO0O;
            bLEService.OooO00o("com.cloud.tmc.bluetooth.le.ACTION_WRITE_CHARACTERISTIC", code, bundle);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            Intrinsics.h(bluetoothGatt, "gatt");
            super.onConnectionStateChange(bluetoothGatt, i, i2);
            StringBuilder sb = new StringBuilder();
            sb.append("onConnectionStateChange -> status:");
            sb.append(i);
            sb.append(" , newState:");
            sb.append(i2);
            if (i2 == 0) {
                BLEService.this.OooO0oo.set(false);
            } else if (i2 == 2) {
                BLEService.this.OooO0oo.set(true);
            }
            if (Build.VERSION.SDK_INT <= 31 || b.checkSelfPermission(BLEService.this, "android.permission.BLUETOOTH_SCAN") == 0) {
                BLEService bLEService = BLEService.this;
                long code = BluetoothCode.OK.getCode();
                Bundle bundle = new Bundle();
                bundle.putInt("newState", i2);
                bundle.putInt("status", i);
                bundle.putString("address", bluetoothGatt.getDevice().getAddress());
                Unit unit = Unit.a;
                int i3 = BLEService.OooOO0O;
                bLEService.OooO00o("com.cloud.tmc.bluetooth.le.ACTION_DEVICE_CONNECT_STATE", code, bundle);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            super.onMtuChanged(bluetoothGatt, i, i2);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
            super.onReadRemoteRssi(bluetoothGatt, i, i2);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServiceChanged(BluetoothGatt bluetoothGatt) {
            Intrinsics.h(bluetoothGatt, "gatt");
            super.onServiceChanged(bluetoothGatt);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            Intrinsics.h(bluetoothGatt, "gatt");
            super.onServicesDiscovered(bluetoothGatt, i);
            StringBuilder sb = new StringBuilder();
            sb.append("onServicesDiscovered -> status:");
            sb.append(i);
            if (i == 0) {
                BLEService.OooO00o(BLEService.this, "com.cloud.tmc.bluetooth.le.ACTION_SERVICES_DISCOVERED", BluetoothCode.OK.getCode(), null, 4);
            } else {
                BLEService.OooO00o(BLEService.this, "com.cloud.tmc.bluetooth.le.ACTION_SERVICES_DISCOVERED", i, null, 4);
            }
        }
    }

    public static /* synthetic */ void OooO00o(BLEService bLEService, String str, long j, Bundle bundle, int i) {
        bLEService.OooO00o(str, j, (i & 4) != 0 ? new Bundle() : null);
    }

    public final long OooO00o(String str) {
        BluetoothDevice device;
        Intrinsics.h(str, "address");
        if (!OooO0O0()) {
            return BluetoothCode.NOT_AVALIABLE.getCode();
        }
        if (Build.VERSION.SDK_INT > 31 && b.checkSelfPermission(this, "android.permission.BLUETOOTH_SCAN") != 0) {
            return BluetoothCode.NOT_PERMISSION.getCode();
        }
        BluetoothGatt bluetoothGatt = this.OooO0o;
        if (!Intrinsics.c(str, (bluetoothGatt == null || (device = bluetoothGatt.getDevice()) == null) ? null : device.getAddress())) {
            return BluetoothCode.NO_DEVICE.getCode();
        }
        BluetoothGatt bluetoothGatt2 = this.OooO0o;
        if (bluetoothGatt2 != null) {
            bluetoothGatt2.disconnect();
        }
        this.OooO0o = null;
        this.OooO0oO = null;
        return BluetoothCode.OK.getCode();
    }

    public final List<BluetoothDevice> OooO00o() {
        if (!OooO0O0()) {
            return new ArrayList();
        }
        if (Build.VERSION.SDK_INT > 31 && b.checkSelfPermission(this, "android.permission.BLUETOOTH_SCAN") != 0) {
            return new ArrayList();
        }
        BluetoothManager bluetoothManager = this.OooO00o;
        List<BluetoothDevice> connectedDevices = bluetoothManager != null ? bluetoothManager.getConnectedDevices(8) : null;
        return connectedDevices == null ? new ArrayList() : connectedDevices;
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.listener.OooOO0.OooO00o
    public void OooO00o(int i) {
        TmcLogger.e("TmcBluetooth", "onScanFailed:" + i);
        OooO00o(this, "com.cloud.tmc.bluetooth.le.ACTION_SCAN_RESULT", (long) i, null, 4);
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.listener.OooOO0.OooO00o
    public void OooO00o(int i, ScanResult scanResult) {
        BluetoothDevice device;
        BluetoothDevice device2;
        TmcLogger.i("TmcBluetooth", "onScanResult:" + scanResult);
        long code = BluetoothCode.OK.getCode();
        Bundle bundle = new Bundle();
        if (Build.VERSION.SDK_INT <= 31 || b.checkSelfPermission(this, "android.permission.BLUETOOTH_SCAN") == 0) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String address = (scanResult == null || (device2 = scanResult.getDevice()) == null) ? null : device2.getAddress();
            String str = "";
            if (address == null) {
                address = "";
            } else {
                Intrinsics.g(address, "result?.device?.address ?: \"\"");
            }
            linkedHashMap.put("address", address);
            String name = (scanResult == null || (device = scanResult.getDevice()) == null) ? null : device.getName();
            if (name != null) {
                Intrinsics.g(name, "result?.device?.name ?: \"\"");
                str = name;
            }
            linkedHashMap.put("name", str);
            linkedHashMap.put("RSSI", String.valueOf(scanResult != null ? Integer.valueOf(scanResult.getRssi()) : null));
            bundle.putString("scan_result", GsonUtils.toJson(linkedHashMap));
            Unit unit = Unit.a;
            OooO00o("com.cloud.tmc.bluetooth.le.ACTION_SCAN_RESULT", code, bundle);
        }
    }

    public final void OooO00o(String str, long j, Bundle bundle) {
        Intent intent = new Intent(str);
        Bundle bundle2 = new Bundle();
        bundle2.putLong(TmcConstants.BRIDGE_RESPONSE_ERROR_CODE_KEY, j);
        bundle2.putAll(bundle);
        intent.putExtras(bundle2);
        sendBroadcast(intent);
    }

    @Override // com.cloud.tmc.miniapp.bluetooth.listener.OooOO0.OooO00o
    public void OooO00o(List<ScanResult> list) {
    }

    public final void OooO00o(Function2<? super Boolean, ? super Boolean, Unit> function2) {
        Intrinsics.h(function2, RenderCallContext.TYPE_CALLBACK);
        Boolean valueOf = Boolean.valueOf(this.OooO0o0.get());
        BluetoothAdapter bluetoothAdapter = this.OooO0O0;
        function2.invoke(valueOf, Boolean.valueOf(bluetoothAdapter != null ? bluetoothAdapter.isEnabled() : false));
    }

    public final boolean OooO0O0() {
        BluetoothAdapter bluetoothAdapter = this.OooO0O0;
        return bluetoothAdapter != null && bluetoothAdapter.isEnabled();
    }

    public final void OooO0OO() {
        long code = BluetoothCode.OK.getCode();
        Bundle bundle = new Bundle();
        bundle.putBoolean("scan", this.OooO0o0.get());
        BluetoothAdapter bluetoothAdapter = this.OooO0O0;
        bundle.putBoolean("avaliable", bluetoothAdapter != null ? bluetoothAdapter.isEnabled() : false);
        Unit unit = Unit.a;
        OooO00o("com.cloud.tmc.bluetooth.le.ACTION_NOTIFY_BLUETOOTH_ADAPTER_STATE_CHANGE", code, bundle);
    }

    public final void OooO0Oo() {
        BluetoothLeScanner bluetoothLeScanner;
        this.OooO0o0.set(false);
        if (OooO0O0()) {
            if ((Build.VERSION.SDK_INT <= 31 || b.checkSelfPermission(this, "android.permission.BLUETOOTH_SCAN") == 0) && (bluetoothLeScanner = this.OooO0OO) != null) {
                bluetoothLeScanner.stopScan(this.OooO0Oo);
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.OooO;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
