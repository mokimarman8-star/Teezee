package com.transsion.push.bean;

import java.util.Arrays;
import nl.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class PushRequest {
    public String data;
    public String key;

    public static class ReportContentData {
        public String aid;
        public String androidVersion;
        public String appId;

        @a(name = "appInfos")
        public PushAppInfo[] appInfos;
        public String appKey;
        public String appVersion;
        public int appVersionCode;

        @a(name = "apps")
        public String[] apps;
        public String brand;
        public int cid;
        public String clientId;
        public int confVersion;
        public String country;
        public String gaid;
        public int lac;
        public String language;
        public int mcc;
        public int mnc;
        public String model;
        public String network;
        public int noticeEnable;
        public String osVersion;
        public String pkg;
        public int platVer;
        public String sdkVersion;
        public int sdkVersionCode;
        public String token;
        public String vaid;
        public int whitelistVersion;
        public boolean withDetail;

        public String toString() {
            return "ReportContentData{vaid='" + this.vaid + "', gaid='" + this.gaid + "', pkg='" + this.pkg + "', platVer=" + this.platVer + ", sdkVersion='" + this.sdkVersion + "', sdkVersionCode=" + this.sdkVersionCode + ", confVersion=" + this.confVersion + ", whitelistVersion=" + this.whitelistVersion + ", withDetail=" + this.withDetail + ", token='" + this.token + "', aid='" + this.aid + "', appVersion='" + this.appVersion + "', appVersionCode=" + this.appVersionCode + ", language='" + this.language + "', brand='" + this.brand + "', model='" + this.model + "', androidVersion='" + this.androidVersion + "', osVersion='" + this.osVersion + "', network='" + this.network + "', mcc=" + this.mcc + ", mnc=" + this.mnc + ", lac=" + this.lac + ", cid=" + this.cid + ", country='" + this.country + "', apps=" + Arrays.toString(this.apps) + ", appInfos=" + Arrays.toString(this.appInfos) + ", appId='" + this.appId + "', appKey='" + this.appKey + "', clientId='" + this.clientId + "', noticeEnable=" + this.noticeEnable + '}';
        }
    }

    public String toString() {
        return "PushRequest{key='" + this.key + "', data='" + this.data + "'}";
    }
}
