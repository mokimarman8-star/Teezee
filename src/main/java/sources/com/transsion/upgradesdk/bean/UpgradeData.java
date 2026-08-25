package com.transsion.upgradesdk.bean;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.s;
import com.google.gson.JsonObject;
import com.tencent.mmkv.MMKV;
import com.transsion.upgradesdk.R$string;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import nu.d;
import okhttp3.HttpUrl;
import pu.a;
import qu.f;
import tu.g;
import tu.h;
import tu.i;
import tu.n;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\"\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001Bé\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\u0010\u0012\u0006\u0010\u001a\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001b\u001a\u00020\b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u001eJ\u0006\u0010?\u001a\u00020@J\u0006\u0010A\u001a\u00020@J\u0006\u0010B\u001a\u00020@J\u0016\u0010C\u001a\u00020@2\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010J\u0006\u0010D\u001a\u00020@J\u0006\u0010E\u001a\u00020@J\u0006\u0010F\u001a\u00020@J\u000e\u0010G\u001a\u00020@2\u0006\u0010H\u001a\u00020\u0010J\u000e\u0010I\u001a\u00020@2\u0006\u0010H\u001a\u00020\u0010J\u000f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0010HÆ\u0003J\t\u0010L\u001a\u00020\u0010HÆ\u0003J\t\u0010M\u001a\u00020\bHÆ\u0003J\t\u0010N\u001a\u00020\bHÆ\u0003J\t\u0010O\u001a\u00020\bHÆ\u0003J\t\u0010P\u001a\u00020\u0004HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\t\u0010R\u001a\u00020\u0004HÆ\u0003J\t\u0010S\u001a\u00020\u0010HÆ\u0003J\t\u0010T\u001a\u00020\u0010HÆ\u0003J\u000f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010V\u001a\u00020\bHÆ\u0003J\t\u0010W\u001a\u00020\bHÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010Z\u001a\u00020\bHÆ\u0003J\t\u0010[\u001a\u00020\bHÆ\u0003J\u000f\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0011\u0010]\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003HÆ\u0003J\t\u0010^\u001a\u00020\u0004HÆ\u0003J\t\u0010_\u001a\u00020\u0004HÆ\u0003J\u0089\u0002\u0010`\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00102\b\b\u0002\u0010\u001a\u001a\u00020\u00102\b\b\u0002\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010a\u001a\u00020@2\b\u0010b\u001a\u0004\u0018\u00010cHÖ\u0003J\u000e\u0010d\u001a\u00020\u00042\u0006\u0010e\u001a\u00020fJ\u0006\u0010g\u001a\u00020\u0004J\t\u0010h\u001a\u00020\bHÖ\u0001J\u0006\u0010i\u001a\u00020@J\b\u0010j\u001a\u00020\u0004H\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u001a\u0010\u001c\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010 R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010#R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b(\u0010#R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010 R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010 R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b/\u0010.R\u0011\u0010\u000e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010,R\u0011\u0010\u0012\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b1\u0010#R\u0011\u0010\u0013\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b2\u0010#R\u001a\u0010\u001b\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010#\"\u0004\b4\u0010%R\u0011\u0010\u0014\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b5\u0010#R\u0011\u0010\u0015\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010,R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010,\"\u0004\b8\u00109R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0011\u0010\u0018\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010,R\u0011\u0010\u0019\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b=\u0010.R\u0011\u0010\u001a\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b>\u0010.¨\u0006k"}, d2 = {"Lcom/transsion/upgradesdk/bean/UpgradeData;", "Ljava/io/Serializable;", "androidVerList", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "brandList", "countryCodeList", "directDwl", HttpUrl.FRAGMENT_ENCODE_SET, "hoverBtn", "modelList", "oldPkgVersion", "Lcom/transsion/upgradesdk/bean/OldPkgVersion;", "pkg", "pkgVersionName", "pkgVersion", HttpUrl.FRAGMENT_ENCODE_SET, "pkgSize", "popUpCnt", "popUpInterval", "sdkRefreshTime", "taskStatus", "upgradeContent", "Lcom/google/gson/JsonObject;", "upgradeType", "validEndDate", "validStartDate", "reqInterval", "cdnRequestIntervalHours", "updateTime", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;IILjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;JJIIILjava/lang/String;Lcom/google/gson/JsonObject;Ljava/lang/String;JJIILjava/lang/String;)V", "getAndroidVerList", "()Ljava/util/List;", "getBrandList", "getCdnRequestIntervalHours", "()I", "setCdnRequestIntervalHours", "(I)V", "getCountryCodeList", "getDirectDwl", "getHoverBtn", "getModelList", "getOldPkgVersion", "getPkg", "()Ljava/lang/String;", "getPkgSize", "()J", "getPkgVersion", "getPkgVersionName", "getPopUpCnt", "getPopUpInterval", "getReqInterval", "setReqInterval", "getSdkRefreshTime", "getTaskStatus", "getUpdateTime", "setUpdateTime", "(Ljava/lang/String;)V", "getUpgradeContent", "()Lcom/google/gson/JsonObject;", "getUpgradeType", "getValidEndDate", "getValidStartDate", "checkAndroidVersion", HttpUrl.FRAGMENT_ENCODE_SET, "checkBrand", "checkCountry", "checkDateRange", "checkDialogPopInterval", "checkDialogPopTimes", "checkModel", "checkNeedUpgrade", "currentVersion", "checkVersionRange", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", HttpUrl.FRAGMENT_ENCODE_SET, "getCancelButtonText", "context", "Landroid/content/Context;", "getUpgradeMessage", "hashCode", "isForceUpdate", "toString", "upgradesdk_release"}, k = 1, mv = {1, 9, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* data */ class UpgradeData implements Serializable {
    private final List<String> androidVerList;
    private final List<String> brandList;
    private int cdnRequestIntervalHours;
    private final List<String> countryCodeList;
    private final int directDwl;
    private final int hoverBtn;
    private final List<String> modelList;
    private final List<OldPkgVersion> oldPkgVersion;
    private final String pkg;
    private final long pkgSize;
    private final long pkgVersion;
    private final String pkgVersionName;
    private final int popUpCnt;
    private final int popUpInterval;
    private int reqInterval;
    private final int sdkRefreshTime;
    private final String taskStatus;
    private String updateTime;
    private final JsonObject upgradeContent;
    private final String upgradeType;
    private final long validEndDate;
    private final long validStartDate;

    public UpgradeData(List<String> androidVerList, List<String> brandList, List<String> countryCodeList, int i, int i2, List<String> modelList, List<OldPkgVersion> list, String pkg, String pkgVersionName, long j, long j2, int i3, int i4, int i5, String taskStatus, JsonObject jsonObject, String upgradeType, long j3, long j4, int i6, int i7, String str) {
        Intrinsics.h(androidVerList, "androidVerList");
        Intrinsics.h(brandList, "brandList");
        Intrinsics.h(countryCodeList, "countryCodeList");
        Intrinsics.h(modelList, "modelList");
        Intrinsics.h(pkg, "pkg");
        Intrinsics.h(pkgVersionName, "pkgVersionName");
        Intrinsics.h(taskStatus, "taskStatus");
        Intrinsics.h(upgradeType, "upgradeType");
        this.androidVerList = androidVerList;
        this.brandList = brandList;
        this.countryCodeList = countryCodeList;
        this.directDwl = i;
        this.hoverBtn = i2;
        this.modelList = modelList;
        this.oldPkgVersion = list;
        this.pkg = pkg;
        this.pkgVersionName = pkgVersionName;
        this.pkgVersion = j;
        this.pkgSize = j2;
        this.popUpCnt = i3;
        this.popUpInterval = i4;
        this.sdkRefreshTime = i5;
        this.taskStatus = taskStatus;
        this.upgradeContent = jsonObject;
        this.upgradeType = upgradeType;
        this.validEndDate = j3;
        this.validStartDate = j4;
        this.reqInterval = i6;
        this.cdnRequestIntervalHours = i7;
        this.updateTime = str;
    }

    public /* synthetic */ UpgradeData(List list, List list2, List list3, int i, int i2, List list4, List list5, String str, String str2, long j, long j2, int i3, int i4, int i5, String str3, JsonObject jsonObject, String str4, long j3, long j4, int i6, int i7, String str5, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, list3, (i8 & 8) != 0 ? 1 : i, (i8 & 16) != 0 ? 0 : i2, list4, (i8 & 64) != 0 ? null : list5, str, str2, j, j2, i3, i4, (i8 & 8192) != 0 ? 3 : i5, str3, (32768 & i8) != 0 ? null : jsonObject, str4, j3, j4, (524288 & i8) != 0 ? 0 : i6, (1048576 & i8) != 0 ? 0 : i7, (i8 & 2097152) != 0 ? null : str5);
    }

    public final boolean checkAndroidVersion() {
        List<String> list = this.androidVerList;
        if (list == null || list.isEmpty() || this.androidVerList.contains("ALL")) {
            return true;
        }
        return this.androidVerList.contains(n.h());
    }

    public final boolean checkBrand() {
        if (this.brandList.isEmpty()) {
            return true;
        }
        List<String> list = this.brandList;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (String str : list) {
                if (StringsKt.H(str, Build.BRAND, true) | StringsKt.H(str, "all", true)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean checkCountry() {
        String str;
        List<String> list = this.countryCodeList;
        if (list == null || list.isEmpty()) {
            return true;
        }
        Application application = a.a;
        if (application == null) {
            Intrinsics.y("application");
            application = null;
        }
        try {
            Object systemService = application.getSystemService("phone");
            Intrinsics.f(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
            str = ((TelephonyManager) systemService).getSimCountryIso();
            Intrinsics.g(str, "getSimCountryIso(...)");
        } catch (Exception unused) {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        List<String> list2 = this.countryCodeList;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            for (String str2 : list2) {
                if (StringsKt.H(str2, str, true) | StringsKt.H(str2, "all", true)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean checkDateRange(long validStartDate, long validEndDate) {
        if (validEndDate == 0) {
            return true;
        }
        long timeInMillis = Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTimeInMillis();
        long a = d.a("UpgradeSdkManager", "tag", "当前的时间戳： " + timeInMillis + "    服务端： start: " + validStartDate + "  --   end: " + validEndDate, "msg");
        if (!g.a && a - g.b >= 5000) {
            g.b = a;
            if (Log.isLoggable("upgradeSdkLog", 3)) {
                g.a = true;
            }
            boolean z = g.a;
        }
        boolean z2 = f.o.a().d;
        return validStartDate <= timeInMillis && timeInMillis <= validEndDate;
    }

    public final boolean checkDialogPopInterval() {
        if (isForceUpdate()) {
            return true;
        }
        h hVar = i.b;
        Application application = a.a;
        if (application == null) {
            Intrinsics.y("application");
            application = null;
        }
        i a = hVar.a(application);
        Intrinsics.h("KV_UPGRADE_POPUP_LAST_TIME", "key");
        MMKV mmkv = a.a;
        return System.currentTimeMillis() - (mmkv != null ? mmkv.h("KV_UPGRADE_POPUP_LAST_TIME", 0L) : 0L) > ((long) (this.popUpInterval * 86400)) * 1000;
    }

    public final boolean checkDialogPopTimes() {
        if (isForceUpdate()) {
            return true;
        }
        h hVar = i.b;
        Application application = a.a;
        if (application == null) {
            Intrinsics.y("application");
            application = null;
        }
        i a = hVar.a(application);
        Intrinsics.h("KV_UPGRADE_POPUP_TIMES", "key");
        MMKV mmkv = a.a;
        return (mmkv != null ? mmkv.g("KV_UPGRADE_POPUP_TIMES", 0) : 0) < this.popUpCnt;
    }

    public final boolean checkModel() {
        List<String> list = this.modelList;
        if (list == null || list.isEmpty()) {
            return true;
        }
        String str = f.o.a().e().j;
        List<String> list2 = this.modelList;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            for (String str2 : list2) {
                if (StringsKt.H(str2, str, true) | StringsKt.H(str2, "all", true)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean checkNeedUpgrade(long currentVersion) {
        return currentVersion < this.pkgVersion;
    }

    public final boolean checkVersionRange(long currentVersion) {
        List<OldPkgVersion> list = this.oldPkgVersion;
        if (list == null || list.isEmpty()) {
            return true;
        }
        for (OldPkgVersion oldPkgVersion : this.oldPkgVersion) {
            if (currentVersion >= oldPkgVersion.getOldPkgVersionStart() && currentVersion <= oldPkgVersion.getOldPkgVersionEnd()) {
                List<Long> oldPkgVersionExclude = oldPkgVersion.getOldPkgVersionExclude();
                return oldPkgVersionExclude == null || oldPkgVersionExclude.isEmpty() || !oldPkgVersion.getOldPkgVersionExclude().contains(Long.valueOf(currentVersion));
            }
        }
        return false;
    }

    public final List<String> component1() {
        return this.androidVerList;
    }

    /* renamed from: component10, reason: from getter */
    public final long getPkgVersion() {
        return this.pkgVersion;
    }

    /* renamed from: component11, reason: from getter */
    public final long getPkgSize() {
        return this.pkgSize;
    }

    /* renamed from: component12, reason: from getter */
    public final int getPopUpCnt() {
        return this.popUpCnt;
    }

    /* renamed from: component13, reason: from getter */
    public final int getPopUpInterval() {
        return this.popUpInterval;
    }

    /* renamed from: component14, reason: from getter */
    public final int getSdkRefreshTime() {
        return this.sdkRefreshTime;
    }

    /* renamed from: component15, reason: from getter */
    public final String getTaskStatus() {
        return this.taskStatus;
    }

    /* renamed from: component16, reason: from getter */
    public final JsonObject getUpgradeContent() {
        return this.upgradeContent;
    }

    /* renamed from: component17, reason: from getter */
    public final String getUpgradeType() {
        return this.upgradeType;
    }

    /* renamed from: component18, reason: from getter */
    public final long getValidEndDate() {
        return this.validEndDate;
    }

    /* renamed from: component19, reason: from getter */
    public final long getValidStartDate() {
        return this.validStartDate;
    }

    public final List<String> component2() {
        return this.brandList;
    }

    /* renamed from: component20, reason: from getter */
    public final int getReqInterval() {
        return this.reqInterval;
    }

    /* renamed from: component21, reason: from getter */
    public final int getCdnRequestIntervalHours() {
        return this.cdnRequestIntervalHours;
    }

    /* renamed from: component22, reason: from getter */
    public final String getUpdateTime() {
        return this.updateTime;
    }

    public final List<String> component3() {
        return this.countryCodeList;
    }

    /* renamed from: component4, reason: from getter */
    public final int getDirectDwl() {
        return this.directDwl;
    }

    /* renamed from: component5, reason: from getter */
    public final int getHoverBtn() {
        return this.hoverBtn;
    }

    public final List<String> component6() {
        return this.modelList;
    }

    public final List<OldPkgVersion> component7() {
        return this.oldPkgVersion;
    }

    /* renamed from: component8, reason: from getter */
    public final String getPkg() {
        return this.pkg;
    }

    /* renamed from: component9, reason: from getter */
    public final String getPkgVersionName() {
        return this.pkgVersionName;
    }

    public final UpgradeData copy(List<String> androidVerList, List<String> brandList, List<String> countryCodeList, int directDwl, int hoverBtn, List<String> modelList, List<OldPkgVersion> oldPkgVersion, String pkg, String pkgVersionName, long pkgVersion, long pkgSize, int popUpCnt, int popUpInterval, int sdkRefreshTime, String taskStatus, JsonObject upgradeContent, String upgradeType, long validEndDate, long validStartDate, int reqInterval, int cdnRequestIntervalHours, String updateTime) {
        Intrinsics.h(androidVerList, "androidVerList");
        Intrinsics.h(brandList, "brandList");
        Intrinsics.h(countryCodeList, "countryCodeList");
        Intrinsics.h(modelList, "modelList");
        Intrinsics.h(pkg, "pkg");
        Intrinsics.h(pkgVersionName, "pkgVersionName");
        Intrinsics.h(taskStatus, "taskStatus");
        Intrinsics.h(upgradeType, "upgradeType");
        return new UpgradeData(androidVerList, brandList, countryCodeList, directDwl, hoverBtn, modelList, oldPkgVersion, pkg, pkgVersionName, pkgVersion, pkgSize, popUpCnt, popUpInterval, sdkRefreshTime, taskStatus, upgradeContent, upgradeType, validEndDate, validStartDate, reqInterval, cdnRequestIntervalHours, updateTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UpgradeData)) {
            return false;
        }
        UpgradeData upgradeData = (UpgradeData) other;
        return Intrinsics.c(this.androidVerList, upgradeData.androidVerList) && Intrinsics.c(this.brandList, upgradeData.brandList) && Intrinsics.c(this.countryCodeList, upgradeData.countryCodeList) && this.directDwl == upgradeData.directDwl && this.hoverBtn == upgradeData.hoverBtn && Intrinsics.c(this.modelList, upgradeData.modelList) && Intrinsics.c(this.oldPkgVersion, upgradeData.oldPkgVersion) && Intrinsics.c(this.pkg, upgradeData.pkg) && Intrinsics.c(this.pkgVersionName, upgradeData.pkgVersionName) && this.pkgVersion == upgradeData.pkgVersion && this.pkgSize == upgradeData.pkgSize && this.popUpCnt == upgradeData.popUpCnt && this.popUpInterval == upgradeData.popUpInterval && this.sdkRefreshTime == upgradeData.sdkRefreshTime && Intrinsics.c(this.taskStatus, upgradeData.taskStatus) && Intrinsics.c(this.upgradeContent, upgradeData.upgradeContent) && Intrinsics.c(this.upgradeType, upgradeData.upgradeType) && this.validEndDate == upgradeData.validEndDate && this.validStartDate == upgradeData.validStartDate && this.reqInterval == upgradeData.reqInterval && this.cdnRequestIntervalHours == upgradeData.cdnRequestIntervalHours && Intrinsics.c(this.updateTime, upgradeData.updateTime);
    }

    public final List<String> getAndroidVerList() {
        return this.androidVerList;
    }

    public final List<String> getBrandList() {
        return this.brandList;
    }

    public final String getCancelButtonText(Context context) {
        Intrinsics.h(context, "context");
        if (isForceUpdate()) {
            String string = context.getResources().getString(R$string.upgrade_sdk_text_later_force);
            Intrinsics.e(string);
            return string;
        }
        String string2 = context.getResources().getString(R$string.upgrade_sdk_text_later);
        Intrinsics.e(string2);
        return string2;
    }

    public final int getCdnRequestIntervalHours() {
        return this.cdnRequestIntervalHours;
    }

    public final List<String> getCountryCodeList() {
        return this.countryCodeList;
    }

    public final int getDirectDwl() {
        return this.directDwl;
    }

    public final int getHoverBtn() {
        return this.hoverBtn;
    }

    public final List<String> getModelList() {
        return this.modelList;
    }

    public final List<OldPkgVersion> getOldPkgVersion() {
        return this.oldPkgVersion;
    }

    public final String getPkg() {
        return this.pkg;
    }

    public final long getPkgSize() {
        return this.pkgSize;
    }

    public final long getPkgVersion() {
        return this.pkgVersion;
    }

    public final String getPkgVersionName() {
        return this.pkgVersionName;
    }

    public final int getPopUpCnt() {
        return this.popUpCnt;
    }

    public final int getPopUpInterval() {
        return this.popUpInterval;
    }

    public final int getReqInterval() {
        return this.reqInterval;
    }

    public final int getSdkRefreshTime() {
        return this.sdkRefreshTime;
    }

    public final String getTaskStatus() {
        return this.taskStatus;
    }

    public final String getUpdateTime() {
        return this.updateTime;
    }

    public final JsonObject getUpgradeContent() {
        return this.upgradeContent;
    }

    public final String getUpgradeMessage() {
        JsonObject jsonObject = this.upgradeContent;
        if (jsonObject != null && jsonObject.size() != 0) {
            Application application = a.a;
            if (application == null) {
                Intrinsics.y("application");
                application = null;
            }
            String a = n.a(application);
            if (this.upgradeContent.has(a)) {
                String asString = this.upgradeContent.get(a).getAsString();
                Intrinsics.g(asString, "getAsString(...)");
                return asString;
            }
            if (this.upgradeContent.has("EN")) {
                String asString2 = this.upgradeContent.get("EN").getAsString();
                Intrinsics.g(asString2, "getAsString(...)");
                return asString2;
            }
        }
        return HttpUrl.FRAGMENT_ENCODE_SET;
    }

    public final String getUpgradeType() {
        return this.upgradeType;
    }

    public final long getValidEndDate() {
        return this.validEndDate;
    }

    public final long getValidStartDate() {
        return this.validStartDate;
    }

    public int hashCode() {
        int hashCode = (this.modelList.hashCode() + ((this.hoverBtn + ((this.directDwl + ((this.countryCodeList.hashCode() + ((this.brandList.hashCode() + (this.androidVerList.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        List<OldPkgVersion> list = this.oldPkgVersion;
        int a = nu.a.a(this.taskStatus, (this.sdkRefreshTime + ((this.popUpInterval + ((this.popUpCnt + ((s.a(this.pkgSize) + ((s.a(this.pkgVersion) + nu.a.a(this.pkgVersionName, nu.a.a(this.pkg, (hashCode + (list == null ? 0 : list.hashCode())) * 31, 31), 31)) * 31)) * 31)) * 31)) * 31)) * 31, 31);
        JsonObject jsonObject = this.upgradeContent;
        int a2 = (this.cdnRequestIntervalHours + ((this.reqInterval + ((s.a(this.validStartDate) + ((s.a(this.validEndDate) + nu.a.a(this.upgradeType, (a + (jsonObject == null ? 0 : jsonObject.hashCode())) * 31, 31)) * 31)) * 31)) * 31)) * 31;
        String str = this.updateTime;
        return a2 + (str != null ? str.hashCode() : 0);
    }

    public final boolean isForceUpdate() {
        return TextUtils.equals(this.upgradeType, "force");
    }

    public final void setCdnRequestIntervalHours(int i) {
        this.cdnRequestIntervalHours = i;
    }

    public final void setReqInterval(int i) {
        this.reqInterval = i;
    }

    public final void setUpdateTime(String str) {
        this.updateTime = str;
    }

    public String toString() {
        return "UpgradeData(androidVerList=" + this.androidVerList + ", brandList=" + this.brandList + ", countryCodeList=" + this.countryCodeList + ", directDwl=" + this.directDwl + ", hoverBtn=" + this.hoverBtn + ", modelList=" + this.modelList + ", oldPkgVersion=" + this.oldPkgVersion + ", pkg='" + this.pkg + "', pkgVersion='" + this.pkgVersion + "', pkgSize=" + this.pkgSize + ", popUpCnt=" + this.popUpCnt + ", popUpInterval=" + this.popUpInterval + ", sdkRefreshTime=" + this.sdkRefreshTime + ", taskStatus='" + this.taskStatus + "', upgradeContent=" + this.upgradeContent + ", upgradeType='" + this.upgradeType + "', validEndDate='" + this.validEndDate + "', validStartDate='" + this.validStartDate + "')";
    }
}
