package com.mbridge.msdk.foundation.controller.authoritycontroller;

import android.text.TextUtils;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class a {
    protected int a;
    protected int b;
    protected int c;
    protected int d;

    protected void a(int i) {
        this.a = i;
        this.b = i;
        this.c = i;
    }

    public void authDeviceIdStatus(int i) {
        this.b = i;
    }

    public void authGenDataStatus(int i) {
        this.a = i;
    }

    public void authOtherDataStatus(int i) {
        this.d = i;
    }

    public void authSerialIdStatus(int i) {
        this.c = i;
    }

    public int getAuthDeviceIdStatus() {
        return this.b;
    }

    public int getAuthGenDataStatus() {
        return this.a;
    }

    public int getAuthSerialIdStatus() {
        return this.c;
    }

    public int getOtherDataStatus() {
        return this.d;
    }

    public int getStatusByKey(String str) {
        if (!TextUtils.isEmpty(str)) {
            str.hashCode();
            switch (str) {
                case "authority_serial_id":
                    return this.c;
                case "authority_device_id":
                    return this.b;
                case "authority_general_data":
                    return this.a;
                case "authority_other":
                    return this.d;
            }
        }
        return 1;
    }
}
