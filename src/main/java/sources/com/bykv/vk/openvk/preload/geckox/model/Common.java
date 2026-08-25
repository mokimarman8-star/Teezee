package com.bykv.vk.openvk.preload.geckox.model;

import android.os.Build;
import com.bykv.vk.openvk.preload.a.a.b;
import com.cloud.config.utils.CommonUtils;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Common {

    @b(a = "ac")
    public String ac;

    @b(a = "aid")
    public long aid;

    @b(a = "app_name")
    public String appName;

    @b(a = "app_version")
    public String appVersion;

    @b(a = "device_id")
    public String deviceId;

    @b(a = "device_model")
    public String deviceModel;

    @b(a = "device_platform")
    public String devicePlatform;

    @b(a = "os")
    public int os = 0;

    @b(a = "os_version")
    public String osVersion;

    @b(a = "region")
    public String region;

    @b(a = "sdk_version")
    public String sdkVersion;

    @b(a = CommonUtils.PARAM_UID)
    public String uid;

    public Common(long j, String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.VERSION.SDK_INT);
        this.osVersion = sb.toString();
        this.deviceModel = Build.MODEL;
        this.devicePlatform = "android";
        this.sdkVersion = "2.0.3-rc.9-pangle";
        this.aid = j;
        this.appVersion = str;
        this.deviceId = str2;
        this.appName = str3;
        this.ac = str4;
    }

    public Common(long j, String str, String str2, String str3, String str4, String str5, String str6) {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.VERSION.SDK_INT);
        this.osVersion = sb.toString();
        this.deviceModel = Build.MODEL;
        this.devicePlatform = "android";
        this.sdkVersion = "2.0.3-rc.9-pangle";
        this.aid = j;
        this.appVersion = str;
        this.deviceId = str2;
        this.appName = str3;
        this.ac = str4;
        this.uid = str5;
        this.region = str6;
    }
}
