package com.transsion.upgradesdk.bean;

import androidx.collection.s;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nu.a;
import okhttp3.HttpUrl;
import okio.internal.Buffer;
import org.apache.tools.zip.UnixStat;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b5\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B»\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0006¢\u0006\u0002\u0010\u001bJ\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0006HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0017HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0006HÆ\u0003J\t\u0010D\u001a\u00020\u0006HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003Jé\u0001\u0010K\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u0006HÆ\u0001J\u0013\u0010L\u001a\u00020M2\b\u0010N\u001a\u0004\u0018\u00010OHÖ\u0003J\t\u0010P\u001a\u00020\u0017HÖ\u0001J\t\u0010Q\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001dR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001dR\u0011\u0010\u001a\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001dR\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001dR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001dR\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0013\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b1\u0010+R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001dR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b3\u0010+R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001d¨\u0006R"}, d2 = {"Lcom/transsion/upgradesdk/bean/RequestBean;", "Ljava/io/Serializable;", "gaid", HttpUrl.FRAGMENT_ENCODE_SET, "pkg", "ver", HttpUrl.FRAGMENT_ENCODE_SET, "vn", "cy", "br", "mod", "androidVer", "appKey", "signMd5", "lan", "defaultLocale", "netType", "ua", "channel", "timestamp", "sign", "deviceNum", "systemVersionCode", HttpUrl.FRAGMENT_ENCODE_SET, "myCPU", "psVersionName", "psVersionCode", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;J)V", "getAndroidVer", "()Ljava/lang/String;", "getAppKey", "getBr", "getChannel", "getCy", "getDefaultLocale", "getDeviceNum", "getGaid", "getLan", "getMod", "getMyCPU", "getNetType", "getPkg", "getPsVersionCode", "()J", "getPsVersionName", "getSign", "getSignMd5", "getSystemVersionCode", "()I", "getTimestamp", "getUa", "getVer", "getVn", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", HttpUrl.FRAGMENT_ENCODE_SET, "hashCode", "toString", "upgradesdk_release"}, k = 1, mv = {1, 9, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* data */ class RequestBean implements Serializable {
    private final String androidVer;
    private final String appKey;
    private final String br;
    private final String channel;
    private final String cy;
    private final String defaultLocale;
    private final String deviceNum;
    private final String gaid;
    private final String lan;
    private final String mod;
    private final String myCPU;
    private final String netType;
    private final String pkg;
    private final long psVersionCode;
    private final String psVersionName;
    private final String sign;
    private final String signMd5;
    private final int systemVersionCode;
    private final long timestamp;
    private final String ua;
    private final long ver;
    private final String vn;

    public RequestBean(String str, String pkg, long j, String vn, String cy2, String br, String mod, String androidVer, String appKey, String signMd5, String lan, String defaultLocale, String netType, String ua, String channel, long j2, String sign, String str2, int i, String myCPU, String psVersionName, long j3) {
        Intrinsics.h(pkg, "pkg");
        Intrinsics.h(vn, "vn");
        Intrinsics.h(cy2, "cy");
        Intrinsics.h(br, "br");
        Intrinsics.h(mod, "mod");
        Intrinsics.h(androidVer, "androidVer");
        Intrinsics.h(appKey, "appKey");
        Intrinsics.h(signMd5, "signMd5");
        Intrinsics.h(lan, "lan");
        Intrinsics.h(defaultLocale, "defaultLocale");
        Intrinsics.h(netType, "netType");
        Intrinsics.h(ua, "ua");
        Intrinsics.h(channel, "channel");
        Intrinsics.h(sign, "sign");
        Intrinsics.h(myCPU, "myCPU");
        Intrinsics.h(psVersionName, "psVersionName");
        this.gaid = str;
        this.pkg = pkg;
        this.ver = j;
        this.vn = vn;
        this.cy = cy2;
        this.br = br;
        this.mod = mod;
        this.androidVer = androidVer;
        this.appKey = appKey;
        this.signMd5 = signMd5;
        this.lan = lan;
        this.defaultLocale = defaultLocale;
        this.netType = netType;
        this.ua = ua;
        this.channel = channel;
        this.timestamp = j2;
        this.sign = sign;
        this.deviceNum = str2;
        this.systemVersionCode = i;
        this.myCPU = myCPU;
        this.psVersionName = psVersionName;
        this.psVersionCode = j3;
    }

    public /* synthetic */ RequestBean(String str, String str2, long j, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, long j2, String str15, String str16, int i, String str17, String str18, long j3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, j2, str15, (i2 & 131072) != 0 ? HttpUrl.FRAGMENT_ENCODE_SET : str16, i, str17, str18, j3);
    }

    public static /* synthetic */ RequestBean copy$default(RequestBean requestBean, String str, String str2, long j, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, long j2, String str15, String str16, int i, String str17, String str18, long j3, int i2, Object obj) {
        String str19 = (i2 & 1) != 0 ? requestBean.gaid : str;
        String str20 = (i2 & 2) != 0 ? requestBean.pkg : str2;
        long j4 = (i2 & 4) != 0 ? requestBean.ver : j;
        String str21 = (i2 & 8) != 0 ? requestBean.vn : str3;
        String str22 = (i2 & 16) != 0 ? requestBean.cy : str4;
        String str23 = (i2 & 32) != 0 ? requestBean.br : str5;
        String str24 = (i2 & 64) != 0 ? requestBean.mod : str6;
        String str25 = (i2 & 128) != 0 ? requestBean.androidVer : str7;
        String str26 = (i2 & 256) != 0 ? requestBean.appKey : str8;
        String str27 = (i2 & 512) != 0 ? requestBean.signMd5 : str9;
        String str28 = (i2 & 1024) != 0 ? requestBean.lan : str10;
        String str29 = (i2 & 2048) != 0 ? requestBean.defaultLocale : str11;
        return requestBean.copy(str19, str20, j4, str21, str22, str23, str24, str25, str26, str27, str28, str29, (i2 & Buffer.SEGMENTING_THRESHOLD) != 0 ? requestBean.netType : str12, (i2 & 8192) != 0 ? requestBean.ua : str13, (i2 & 16384) != 0 ? requestBean.channel : str14, (i2 & UnixStat.FILE_FLAG) != 0 ? requestBean.timestamp : j2, (i2 & 65536) != 0 ? requestBean.sign : str15, (131072 & i2) != 0 ? requestBean.deviceNum : str16, (i2 & 262144) != 0 ? requestBean.systemVersionCode : i, (i2 & 524288) != 0 ? requestBean.myCPU : str17, (i2 & 1048576) != 0 ? requestBean.psVersionName : str18, (i2 & 2097152) != 0 ? requestBean.psVersionCode : j3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getGaid() {
        return this.gaid;
    }

    /* renamed from: component10, reason: from getter */
    public final String getSignMd5() {
        return this.signMd5;
    }

    /* renamed from: component11, reason: from getter */
    public final String getLan() {
        return this.lan;
    }

    /* renamed from: component12, reason: from getter */
    public final String getDefaultLocale() {
        return this.defaultLocale;
    }

    /* renamed from: component13, reason: from getter */
    public final String getNetType() {
        return this.netType;
    }

    /* renamed from: component14, reason: from getter */
    public final String getUa() {
        return this.ua;
    }

    /* renamed from: component15, reason: from getter */
    public final String getChannel() {
        return this.channel;
    }

    /* renamed from: component16, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component17, reason: from getter */
    public final String getSign() {
        return this.sign;
    }

    /* renamed from: component18, reason: from getter */
    public final String getDeviceNum() {
        return this.deviceNum;
    }

    /* renamed from: component19, reason: from getter */
    public final int getSystemVersionCode() {
        return this.systemVersionCode;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPkg() {
        return this.pkg;
    }

    /* renamed from: component20, reason: from getter */
    public final String getMyCPU() {
        return this.myCPU;
    }

    /* renamed from: component21, reason: from getter */
    public final String getPsVersionName() {
        return this.psVersionName;
    }

    /* renamed from: component22, reason: from getter */
    public final long getPsVersionCode() {
        return this.psVersionCode;
    }

    /* renamed from: component3, reason: from getter */
    public final long getVer() {
        return this.ver;
    }

    /* renamed from: component4, reason: from getter */
    public final String getVn() {
        return this.vn;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCy() {
        return this.cy;
    }

    /* renamed from: component6, reason: from getter */
    public final String getBr() {
        return this.br;
    }

    /* renamed from: component7, reason: from getter */
    public final String getMod() {
        return this.mod;
    }

    /* renamed from: component8, reason: from getter */
    public final String getAndroidVer() {
        return this.androidVer;
    }

    /* renamed from: component9, reason: from getter */
    public final String getAppKey() {
        return this.appKey;
    }

    public final RequestBean copy(String gaid, String pkg, long ver, String vn, String cy2, String br, String mod, String androidVer, String appKey, String signMd5, String lan, String defaultLocale, String netType, String ua, String channel, long timestamp, String sign, String deviceNum, int systemVersionCode, String myCPU, String psVersionName, long psVersionCode) {
        Intrinsics.h(pkg, "pkg");
        Intrinsics.h(vn, "vn");
        Intrinsics.h(cy2, "cy");
        Intrinsics.h(br, "br");
        Intrinsics.h(mod, "mod");
        Intrinsics.h(androidVer, "androidVer");
        Intrinsics.h(appKey, "appKey");
        Intrinsics.h(signMd5, "signMd5");
        Intrinsics.h(lan, "lan");
        Intrinsics.h(defaultLocale, "defaultLocale");
        Intrinsics.h(netType, "netType");
        Intrinsics.h(ua, "ua");
        Intrinsics.h(channel, "channel");
        Intrinsics.h(sign, "sign");
        Intrinsics.h(myCPU, "myCPU");
        Intrinsics.h(psVersionName, "psVersionName");
        return new RequestBean(gaid, pkg, ver, vn, cy2, br, mod, androidVer, appKey, signMd5, lan, defaultLocale, netType, ua, channel, timestamp, sign, deviceNum, systemVersionCode, myCPU, psVersionName, psVersionCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RequestBean)) {
            return false;
        }
        RequestBean requestBean = (RequestBean) other;
        return Intrinsics.c(this.gaid, requestBean.gaid) && Intrinsics.c(this.pkg, requestBean.pkg) && this.ver == requestBean.ver && Intrinsics.c(this.vn, requestBean.vn) && Intrinsics.c(this.cy, requestBean.cy) && Intrinsics.c(this.br, requestBean.br) && Intrinsics.c(this.mod, requestBean.mod) && Intrinsics.c(this.androidVer, requestBean.androidVer) && Intrinsics.c(this.appKey, requestBean.appKey) && Intrinsics.c(this.signMd5, requestBean.signMd5) && Intrinsics.c(this.lan, requestBean.lan) && Intrinsics.c(this.defaultLocale, requestBean.defaultLocale) && Intrinsics.c(this.netType, requestBean.netType) && Intrinsics.c(this.ua, requestBean.ua) && Intrinsics.c(this.channel, requestBean.channel) && this.timestamp == requestBean.timestamp && Intrinsics.c(this.sign, requestBean.sign) && Intrinsics.c(this.deviceNum, requestBean.deviceNum) && this.systemVersionCode == requestBean.systemVersionCode && Intrinsics.c(this.myCPU, requestBean.myCPU) && Intrinsics.c(this.psVersionName, requestBean.psVersionName) && this.psVersionCode == requestBean.psVersionCode;
    }

    public final String getAndroidVer() {
        return this.androidVer;
    }

    public final String getAppKey() {
        return this.appKey;
    }

    public final String getBr() {
        return this.br;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final String getCy() {
        return this.cy;
    }

    public final String getDefaultLocale() {
        return this.defaultLocale;
    }

    public final String getDeviceNum() {
        return this.deviceNum;
    }

    public final String getGaid() {
        return this.gaid;
    }

    public final String getLan() {
        return this.lan;
    }

    public final String getMod() {
        return this.mod;
    }

    public final String getMyCPU() {
        return this.myCPU;
    }

    public final String getNetType() {
        return this.netType;
    }

    public final String getPkg() {
        return this.pkg;
    }

    public final long getPsVersionCode() {
        return this.psVersionCode;
    }

    public final String getPsVersionName() {
        return this.psVersionName;
    }

    public final String getSign() {
        return this.sign;
    }

    public final String getSignMd5() {
        return this.signMd5;
    }

    public final int getSystemVersionCode() {
        return this.systemVersionCode;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getUa() {
        return this.ua;
    }

    public final long getVer() {
        return this.ver;
    }

    public final String getVn() {
        return this.vn;
    }

    public int hashCode() {
        String str = this.gaid;
        int a = a.a(this.sign, (s.a(this.timestamp) + a.a(this.channel, a.a(this.ua, a.a(this.netType, a.a(this.defaultLocale, a.a(this.lan, a.a(this.signMd5, a.a(this.appKey, a.a(this.androidVer, a.a(this.mod, a.a(this.br, a.a(this.cy, a.a(this.vn, (s.a(this.ver) + a.a(this.pkg, (str == null ? 0 : str.hashCode()) * 31, 31)) * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31)) * 31, 31);
        String str2 = this.deviceNum;
        return s.a(this.psVersionCode) + a.a(this.psVersionName, a.a(this.myCPU, (this.systemVersionCode + ((a + (str2 != null ? str2.hashCode() : 0)) * 31)) * 31, 31), 31);
    }

    public String toString() {
        return "RequestBean(gaid=" + this.gaid + ", pkg=" + this.pkg + ", ver=" + this.ver + ", vn=" + this.vn + ", cy=" + this.cy + ", br=" + this.br + ", mod=" + this.mod + ", androidVer=" + this.androidVer + ", appKey=" + this.appKey + ", signMd5=" + this.signMd5 + ", lan=" + this.lan + ", defaultLocale=" + this.defaultLocale + ", netType=" + this.netType + ", ua=" + this.ua + ", channel=" + this.channel + ", timestamp=" + this.timestamp + ", sign=" + this.sign + ", deviceNum=" + this.deviceNum + ", systemVersionCode=" + this.systemVersionCode + ", myCPU=" + this.myCPU + ", psVersionName=" + this.psVersionName + ", psVersionCode=" + this.psVersionCode + ')';
    }
}
