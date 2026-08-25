package com.cloud.tmc.miniapp.offlineapps.download;

import android.app.Application;
import android.net.Uri;
import android.text.TextUtils;
import com.cloud.tmc.integration.proxy.PathProxy;
import com.cloud.tmc.integration.utils.FilePathUtils;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.network.INetWorkProxy;
import com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.resource.IFileResourceManager;
import com.cloud.tmc.kernel.resource.IImageResourceManager;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.launcherlib.LauncherMiniAppConfigHelper;
import com.cloud.tmc.miniutils.util.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO0O0 {
    public static Application OooO0O0;
    public static com.cloud.tmc.miniapp.offlineapps.download.OooO00o OooO0OO;
    public static final OooO0O0 OooO00o = new OooO0O0();
    public static final ThreadPoolExecutor OooO0Oo = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new OooO0o(), new com.cloud.tmc.miniapp.offlineapps.download.OooO0OO());

    public interface OooO00o {
        void OooO00o(String str, String str2, String str3, boolean z);
    }

    /* renamed from: com.cloud.tmc.miniapp.offlineapps.download.OooO0O0$OooO0O0, reason: collision with other inner class name */
    public static final class C0022OooO0O0 implements OooO00o {
        @Override // com.cloud.tmc.miniapp.offlineapps.download.OooO0O0.OooO00o
        public void OooO00o(String str, String str2, String str3, boolean z) {
            com.cloud.tmc.miniapp.offlineapps.download.OooO00o oooO00o;
            Intrinsics.h(str, "appId");
            Intrinsics.h(str2, "logoUrl");
            Intrinsics.h(str3, TmcConstants.EXTRA_PATH);
            TmcLogger.d("IconDownloadManager", "[downloadIcon] appId:" + str + ", logoUrl:" + str2 + ", path:" + str3 + ", success:" + z);
            if (z && OooO0O0.OooO00o.OooO00o(str, str2, str3) && (oooO00o = OooO0O0.OooO0OO) != null) {
                oooO00o.OooO00o(str, str2, str3);
            }
        }
    }

    public static final class OooO0OO implements PackageDownloadCallback {
        public final /* synthetic */ OooO00o OooO00o;
        public final /* synthetic */ String OooO0O0;
        public final /* synthetic */ String OooO0OO;
        public final /* synthetic */ String OooO0Oo;
        public final /* synthetic */ Ref.ObjectRef<String> OooO0o0;

        public OooO0OO(OooO00o oooO00o, String str, String str2, String str3, Ref.ObjectRef<String> objectRef) {
            this.OooO00o = oooO00o;
            this.OooO0O0 = str;
            this.OooO0OO = str2;
            this.OooO0Oo = str3;
            this.OooO0o0 = objectRef;
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public void onCancel(String str, String str2) {
            this.OooO00o.OooO00o(this.OooO0O0, this.OooO0OO, "", false);
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public void onFailed(String str, String str2, String str3, IOException iOException, String str4) {
            Intrinsics.h(str2, "errorCode");
            Intrinsics.h(str3, "errorMsg");
            Intrinsics.h(iOException, "e");
            this.OooO00o.OooO00o(this.OooO0O0, this.OooO0OO, "", false);
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public void onFinish(String str, String str2) {
            String generateVUrl;
            try {
                if (FilePathUtils.INSTANCE.getDowngradeStatus(this.OooO0O0)) {
                    generateVUrl = ((IImageResourceManager) TmcProxy.get(IImageResourceManager.class)).generateVUrl(this.OooO0Oo, "1000886706715795456", (String) this.OooO0o0.element);
                    Intrinsics.g(generateVUrl, "manager.generateVUrl(downloadPath, MC_APPID, name)");
                } else {
                    generateVUrl = ((IFileResourceManager) TmcProxy.get(IFileResourceManager.class)).generateVUrl(this.OooO0Oo, "1000886706715795456", (String) this.OooO0o0.element, TmcConstants.TEMP_DATA_PATH);
                    Intrinsics.g(generateVUrl, "manager.generateVUrl(dow…Constants.TEMP_DATA_PATH)");
                }
                this.OooO00o.OooO00o(this.OooO0O0, this.OooO0OO, generateVUrl, true);
            } catch (Throwable th) {
                TmcLogger.e("IconDownloadManager", "[downloadIcon] error", th);
                this.OooO00o.OooO00o(this.OooO0O0, this.OooO0OO, "", false);
            }
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public void onPrepare(String str, String str2) {
            Intrinsics.h(str, "url1");
            Intrinsics.h(str2, "callbackId1");
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public void onProgress(String str, int i, String str2) {
            Intrinsics.h(str, "url1");
            Intrinsics.h(str2, "callbackId1");
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public void progressUpdate(String str, int i, String str2, long j, long j2) {
            Intrinsics.h(str, "url1");
            Intrinsics.h(str2, "callbackId1");
        }
    }

    public static final void OooO0O0(String str, String str2) {
        Intrinsics.h(str, "$appId");
        Intrinsics.h(str2, "$logoUrl");
        try {
            OooO0O0 oooO0O0 = OooO00o;
            if (oooO0O0.OooO0Oo(str, str2)) {
                oooO0O0.OooO00o(str, str2, new C0022OooO0O0());
            }
        } catch (Throwable th) {
            TmcLogger.e("IconDownloadManager", "[addTask] error", th);
        }
    }

    public final void OooO00o(final String str, final String str2) {
        Intrinsics.h(str, "appId");
        Intrinsics.h(str2, "logoUrl");
        if (((ConfigService) TmcProxy.get(ConfigService.class)).getConfigBoolean(LauncherMiniAppConfigHelper.KEY_OFFLINE_APPS_ABILITY_SWITCH, true)) {
            OooO0Oo.submit(new Runnable() { // from class: com.cloud.tmc.miniapp.offlineapps.download.a
                @Override // java.lang.Runnable
                public final void run() {
                    OooO0O0.OooO0O0(str, str2);
                }
            });
        } else {
            TmcLogger.d("IconDownloadManager", "[addTask] offlineAppsAbilitySwitch is close");
        }
    }

    public final void OooO00o(String str, String str2, OooO00o oooO00o) {
        List l;
        if (str.length() == 0) {
            TmcLogger.e("IconDownloadManager", "[downloadIcon] appId isEmpty");
            return;
        }
        if (str2.length() == 0) {
            TmcLogger.e("IconDownloadManager", "[downloadIcon] appid:" + str + " logoUrl isEmpty");
            return;
        }
        String path = Uri.parse(str2).getPath();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        if (!TextUtils.isEmpty(path)) {
            if (path == null || (l = StringsKt.S0(path, new String[]{"/"}, false, 0, 6, (Object) null)) == null) {
                l = CollectionsKt.l();
            }
            if (!l.isEmpty()) {
                objectRef.element = l.get(l.size() - 1);
            }
        }
        if (((CharSequence) objectRef.element).length() == 0) {
            TmcLogger.e("IconDownloadManager", "[downloadIcon] name is empty");
            return;
        }
        String appBaseFilePath = ((PathProxy) TmcProxy.get(PathProxy.class)).getAppBaseFilePath("1000886706715795456");
        String str3 = File.separator;
        String str4 = appBaseFilePath + str3 + TmcConstants.TEMP_DATA_PATH + str3 + objectRef.element;
        if (FileUtils.createFileByDeleteOldFile(str4)) {
            ((INetWorkProxy) TmcProxy.get(INetWorkProxy.class)).downloadPackage(str, str2, str4, null, String.valueOf(System.currentTimeMillis()), new OooO0OO(oooO00o, str, str2, str4, objectRef));
        } else {
            TmcLogger.e("IconDownloadManager", "[downloadIcon] createFileByDeleteOldFile fail");
        }
    }

    public final boolean OooO00o(String str, String str2, String str3) {
        boolean z;
        Application application;
        try {
            application = OooO0O0;
        } catch (Throwable th) {
            TmcLogger.e("IconDownloadManager", "[saveDownloadIconCache] error", th);
        }
        if (application != null) {
            ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putString(application, str, str2, str3);
            z = true;
            TmcLogger.d("IconDownloadManager", "[saveDownloadIconCache] appId:" + str + ", logoUrl:" + str2 + ", path:" + str3 + ", ret:" + z);
            return z;
        }
        z = false;
        TmcLogger.d("IconDownloadManager", "[saveDownloadIconCache] appId:" + str + ", logoUrl:" + str2 + ", path:" + str3 + ", ret:" + z);
        return z;
    }

    public final String OooO0OO(String str, String str2) {
        String str3;
        Application application;
        Intrinsics.h(str, "appId");
        Intrinsics.h(str2, "logoUrl");
        try {
            application = OooO0O0;
        } catch (Throwable th) {
            TmcLogger.e("IconDownloadManager", "[getIconPath] error", th);
        }
        if (application != null) {
            str3 = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getString(application, str, str2);
            TmcLogger.d("IconDownloadManager", "[getIconPath] appId:" + str + ", logoUrl:" + str2 + ", path:" + ((Object) str3));
            return str3;
        }
        str3 = null;
        TmcLogger.d("IconDownloadManager", "[getIconPath] appId:" + str + ", logoUrl:" + str2 + ", path:" + ((Object) str3));
        return str3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        if (r2.length() == 0) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean OooO0Oo(String str, String str2) {
        boolean z;
        if (str.length() > 0 && str2.length() > 0) {
            z = true;
            try {
                Application application = OooO0O0;
                if (application != null && (r2 = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getString(application, str, str2)) != null) {
                }
            } catch (Throwable th) {
                TmcLogger.e("IconDownloadManager", "[iconIsNeedDownload] error", th);
            }
            TmcLogger.d("IconDownloadManager", "[iconIsNeedDownload] appId:" + str + ", logoUrl:" + str2 + ", needDownload:" + z);
            return z;
        }
        z = false;
        TmcLogger.d("IconDownloadManager", "[iconIsNeedDownload] appId:" + str + ", logoUrl:" + str2 + ", needDownload:" + z);
        return z;
    }
}
