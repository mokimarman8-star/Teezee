package com.cloud.tmc.miniapp.defaultimpl;

import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.offline.IOfflineManagerProxy;
import com.cloud.tmc.kernel.utils.TmcGsonUtils;
import com.cloud.tmc.kernel.utils.TmcGsonUtilsKt;
import com.cloud.tmc.offline.download.OfflineManager;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.cloud.tmc.offline.download.model.OffPkgConfigExtParams;
import com.cloud.tmc.offline.download.model.OfflineDownloadBuilder;
import com.cloud.tmc.offline.download.model.OfflinePkgCachePath;
import com.cloud.tmc.offline.download.model.PackageInclude;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class TmcOfflineManagerProxyImpl implements IOfflineManagerProxy {

    public static final class OooO00o extends Lambda implements Function1<OfflinePkgCachePath, Unit> {
        public final /* synthetic */ Function1<JsonObject, Unit> OooO00o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO00o(Function1<? super JsonObject, Unit> function1) {
            super(1);
            this.OooO00o = function1;
        }

        public Object invoke(Object obj) {
            String json;
            JsonElement jsonElement;
            OfflinePkgCachePath offlinePkgCachePath = (OfflinePkgCachePath) obj;
            if (offlinePkgCachePath != null) {
                try {
                    json = TmcGsonUtilsKt.toJson(offlinePkgCachePath);
                } catch (Throwable unused) {
                    jsonElement = null;
                }
            } else {
                json = null;
            }
            jsonElement = JsonParser.parseString(json);
            Function1<JsonObject, Unit> function1 = this.OooO00o;
            if (function1 != null) {
                function1.invoke(jsonElement != null ? jsonElement.getAsJsonObject() : null);
            }
            return Unit.a;
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.offline.IOfflineManagerProxy
    public void downloadPkg(String str, String str2, String str3, String str4, String str5, String str6, Function1<? super JsonObject, Unit> function1) {
        ArrayList arrayList;
        Intrinsics.h(str, OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_APP);
        Intrinsics.h(str2, "group");
        Intrinsics.h(str3, "networkType");
        Intrinsics.h(str4, "pkgEncrypted");
        Intrinsics.h(str5, "pkgUrl");
        Intrinsics.h(str6, "paths");
        try {
            Type type = new TypeToken<ArrayList<String>>() { // from class: com.cloud.tmc.miniapp.defaultimpl.TmcOfflineManagerProxyImpl$downloadPkg$tempPaths$1
            }.getType();
            Intrinsics.g(type, "object : TypeToken<ArrayList<String>>() {}.type");
            arrayList = (ArrayList) TmcGsonUtils.fromJson(str6, type);
        } catch (Throwable th) {
            TmcLogger.e("downloadPkg failed!", th);
            arrayList = null;
        }
        PackageInclude packageInclude = new PackageInclude(str2, arrayList, str5);
        OfflineDownloadBuilder offlineDownloadBuilder = new OfflineDownloadBuilder();
        offlineDownloadBuilder.setApp(str);
        offlineDownloadBuilder.setGroup(str2);
        offlineDownloadBuilder.setNetworkType(str3);
        offlineDownloadBuilder.setPkgEncrypted(str4);
        offlineDownloadBuilder.setPkgUrl(str5);
        offlineDownloadBuilder.setExtParams(new OffPkgConfigExtParams(null, CollectionsKt.e(packageInclude), Boolean.FALSE, null));
        OfflineManager.downloadPkg(offlineDownloadBuilder, new OooO00o(function1));
    }

    @Override // com.cloud.tmc.kernel.proxy.offline.IOfflineManagerProxy
    public void downloadPkgFromPlatform(String str, boolean z) {
        OfflineManager.downloadPkgFromPlatform$default(str, z, null, 4, null);
    }

    @Override // com.cloud.tmc.kernel.proxy.offline.IOfflineManagerProxy
    public boolean enableVerifyServerFile(String str) {
        return OfflineManager.enableVerifyServerFile(str);
    }

    @Override // com.cloud.tmc.kernel.proxy.offline.IOfflineManagerProxy
    public void getOfflinePkgCachePath(String str, String str2, Function1<? super JsonObject, Unit> function1) {
        String json;
        JsonElement jsonElement;
        Intrinsics.h(str, "group");
        Intrinsics.h(str2, "pkgUrl");
        OfflinePkgCachePath offlinePkgCachePath = OfflineManager.getOfflinePkgCachePath(str, str2);
        if (offlinePkgCachePath != null) {
            try {
                json = TmcGsonUtilsKt.toJson(offlinePkgCachePath);
            } catch (Throwable unused) {
                jsonElement = null;
            }
        } else {
            json = null;
        }
        jsonElement = JsonParser.parseString(json);
        if (function1 != null) {
            function1.invoke(jsonElement != null ? jsonElement.getAsJsonObject() : null);
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.offline.IOfflineManagerProxy
    public File getOfflineResources(String str, String str2) {
        return OfflineManager.getOfflineResources(str, str2);
    }

    @Override // com.cloud.tmc.kernel.proxy.offline.IOfflineManagerProxy
    public boolean verifyServerFile(String str, String str2) {
        return OfflineManager.verifyServerFile(str, str2);
    }
}
