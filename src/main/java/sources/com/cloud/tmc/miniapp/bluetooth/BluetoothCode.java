package com.cloud.tmc.miniapp.bluetooth;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public enum BluetoothCode {
    FAIL(-1, "fail"),
    OK(0, "ok"),
    NOT_INIT(10000, "not init adapter"),
    NOT_AVALIABLE(10001, "not available bluetooth"),
    NO_DEVICE(10002, "no device"),
    CONNECTION_FAIL(10003, "connection fail"),
    ALREADY_CONNECION(10004, "already connected"),
    N0_CHARACTERISTIC(10005, "no characteristic"),
    N0_CHARACTERISTIC_DESCRIPTOR(10006, "no characteristic's descriptor"),
    NO_POSITION_FUNCTION(10007, "needs to open the positioning function"),
    SYSTEM_ERROR(10008, "system error"),
    INVALID_DATA(10013, "invalid_data"),
    NOT_PERMISSION(10014, "no permission"),
    ALREADY_INIT(10015, "already_init");

    private long code;
    private String descript;

    BluetoothCode(long j, String str) {
        this.code = j;
        this.descript = str;
    }

    /* synthetic */ BluetoothCode(long j, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? "" : str);
    }

    public final long getCode() {
        return this.code;
    }

    public final String getDescript() {
        return this.descript;
    }

    public final void setCode(long j) {
        this.code = j;
    }

    public final void setDescript(String str) {
        Intrinsics.h(str, "<set-?>");
        this.descript = str;
    }
}
