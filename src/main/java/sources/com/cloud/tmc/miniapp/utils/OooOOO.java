package com.cloud.tmc.miniapp.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.cloud.tmc.integration.callback.ISubpackageLoadCheckCallback;
import com.cloud.tmc.integration.chain.app.AppChainContext;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.PrepareContext;
import com.cloud.tmc.integration.model.PrepareData;
import com.cloud.tmc.integration.model.SubPackageInfo;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppManager;
import com.cloud.tmc.integration.utils.AppPrepareUtils;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.integration.utils.SubpackageAppPrepareUtils;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.utils.ExecutorUtils;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniapp.bridge.MiniAppUpdateBridge;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniapp.proxy.IClientStarter;
import com.cloud.tmc.miniapp.utils.toast.ToastUtils;
import com.cloud.tmc.miniapp.utils.toast.config.ToastType;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooOOO {
    public static final OooOOO OooO00o = new OooOOO();
    public static final Lazy OooO0O0 = LazyKt.b(OooO0O0.OooO00o);

    public static final class OooO00o extends com.cloud.tmc.miniapp.prepare.steps.subpackage.OooO00o {
        public final /* synthetic */ com.cloud.tmc.miniapp.prepare.callback.OooO0O0 OooO00o;
        public final /* synthetic */ String OooO0O0;

        public OooO00o(com.cloud.tmc.miniapp.prepare.callback.OooO0O0 oooO0O0, String str) {
            this.OooO00o = oooO0O0;
            this.OooO0O0 = str;
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x0046, code lost:
        
            if (r5.equals(com.cloud.tmc.miniapp.prepare.steps.PrepareException.ERROR_DOWNLOAD_PACKAGE_URL_EMPTY) == false) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0067, code lost:
        
            r5 = com.cloud.tmc.miniapp.bridge.MiniAppUpdateBridge.ERROR_MSG_100010;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x004f, code lost:
        
            if (r5.equals("7") == false) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x005b, code lost:
        
            r5 = com.cloud.tmc.miniapp.bridge.MiniAppUpdateBridge.ERROR_MSG_100011;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0058, code lost:
        
            if (r5.equals("5") == false) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0064, code lost:
        
            if (r5.equals("4") == false) goto L41;
         */
        @Override // com.cloud.tmc.miniapp.prepare.steps.subpackage.OooO00o, com.cloud.tmc.miniapp.prepare.steps.OooOo
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPackageLoadFailed(PrepareData prepareData, PrepareException prepareException) {
            String str;
            com.cloud.tmc.miniapp.prepare.callback.OooO0O0 oooO0O0 = this.OooO00o;
            OooOOO oooOOO = OooOOO.OooO00o;
            String code = prepareException != null ? prepareException.getCode() : null;
            if (code != null) {
                int hashCode = code.hashCode();
                if (hashCode != 52) {
                    if (hashCode != 53) {
                        if (hashCode != 55) {
                            if (hashCode != 1568) {
                                if (hashCode == 1571 ? code.equals("14") : hashCode == 1572 && code.equals(PrepareException.ERROR_FILE2VURL_MINIAPP_FILE_EXCEPTION)) {
                                    str = MiniAppUpdateBridge.ERROR_MSG_100012;
                                }
                            }
                        }
                    }
                }
                oooO0O0.OooO00o(str);
                oooOOO.OooO00o().remove(this.OooO0O0);
            }
            str = MiniAppUpdateBridge.ERROR_MSG_100013;
            oooO0O0.OooO00o(str);
            oooOOO.OooO00o().remove(this.OooO0O0);
        }

        @Override // com.cloud.tmc.miniapp.prepare.steps.subpackage.OooO00o, com.cloud.tmc.miniapp.prepare.steps.OooOo
        public void onPackageLoadSuccess() {
            this.OooO00o.OooO00o();
            OooOOO.OooO00o.OooO00o().remove(this.OooO0O0);
        }
    }

    public static final class OooO0O0 extends Lambda implements Function0<ConcurrentHashMap<String, String>> {
        public static final OooO0O0 OooO00o = new OooO0O0();

        public OooO0O0() {
            super(0);
        }

        public Object invoke() {
            return new ConcurrentHashMap();
        }
    }

    public static final void OooO00o(String str, AppModel appModel, String str2, Bundle bundle, Bundle bundle2, Context context, ISubpackageLoadCheckCallback iSubpackageLoadCheckCallback) {
        String str3;
        String str4;
        Intrinsics.h(str, "$path");
        Intrinsics.h(appModel, "$appModel");
        Intrinsics.h(str2, "$root");
        Intrinsics.h(bundle, "$startParams");
        Intrinsics.h(bundle2, "$sceneParams");
        Intrinsics.h(context, "$context");
        Intrinsics.h(iSubpackageLoadCheckCallback, "$loadCheckCallback");
        OooOOO oooOOO = OooO00o;
        if (appModel == null) {
            return;
        }
        try {
            String appId = appModel.getAppId();
            if (appId == null) {
                return;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            String format = String.format("%s_%s", Arrays.copyOf(new Object[]{appId, str2}, 2));
            Intrinsics.g(format, "format(format, *args)");
            if (oooOOO.OooO00o().containsKey(format)) {
                return;
            }
            oooOOO.OooO00o().put(format, str2);
            try {
                PrepareContext prepareContext = new PrepareContext(context, appId, bundle, bundle2, false, (AppChainContext) null, (Activity) null, (AtomicBoolean) null, 240, (DefaultConstructorMarker) null);
                prepareContext.setAppModel(appModel);
                String string = context.getString(R.string.dialog_loading_tv);
                Intrinsics.g(string, "context.getString(R.string.dialog_loading_tv)");
                ToastUtils.showLoading$default(string, ToastType.LOADING.INSTANCE, 0, 0L, false, null, null, 124, null);
                try {
                    str4 = format;
                    try {
                        ((IClientStarter) TmcProxy.get(IClientStarter.class)).createSubpackagePrepareController(prepareContext, new com.cloud.tmc.miniapp.defaultimpl.OooO0OO(prepareContext, new OooOOOO(str4, iSubpackageLoadCheckCallback, str)), 1, str2).start();
                    } catch (Throwable th) {
                        th = th;
                        OooO00o.OooO00o().remove(str4);
                        str3 = "";
                        try {
                            TmcLogger.e(str3, th);
                        } catch (Throwable th2) {
                            th = th2;
                            TmcLogger.e(str3, th);
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    str4 = format;
                }
            } catch (Throwable th4) {
                th = th4;
                str3 = "";
            }
        } catch (Throwable th5) {
            th = th5;
            str3 = "";
        }
    }

    @JvmStatic
    public static final void OooO00o(String str, String str2, Bundle bundle, Bundle bundle2, Context context, com.cloud.tmc.miniapp.prepare.callback.OooO0O0 oooO0O0) {
        String str3;
        List subPackagePages;
        boolean z = false;
        Intrinsics.h(str, "appId");
        Intrinsics.h(str2, "openSubpackageRoot");
        Intrinsics.h(bundle, TmcConstants.EXTRA_START_PARAMS);
        Intrinsics.h(bundle2, TmcConstants.EXTRA_SCENE_PARAMS);
        Intrinsics.h(context, "context");
        Intrinsics.h(oooO0O0, "preloadCallback");
        try {
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            String format = String.format("%s_%s", Arrays.copyOf(new Object[]{str, str2}, 2));
            Intrinsics.g(format, "format(format, *args)");
            OooOOO oooOOO = OooO00o;
            if (oooOOO.OooO00o().containsKey(format)) {
                ((MiniAppUpdateBridge.OooOO0) oooO0O0).OooO00o(MiniAppUpdateBridge.ERROR_MSG_10009);
                return;
            }
            oooOOO.OooO00o().put(format, str2);
            try {
                App findApp = ((AppManager) TmcProxy.get(AppManager.class)).findApp(str);
                AppModel appModel = findApp != null ? findApp.getAppModel() : null;
                try {
                    if (appModel != null && (subPackagePages = appModel.getSubPackagePages()) != null && !subPackagePages.isEmpty()) {
                        if (OooO00o(context, appModel)) {
                            ((MiniAppUpdateBridge.OooOO0) oooO0O0).OooO00o(MiniAppUpdateBridge.ERROR_MSG_100013);
                            oooOOO.OooO00o().remove(format);
                            return;
                        }
                        List<SubPackageInfo> subPackagePages2 = appModel.getSubPackagePages();
                        if (subPackagePages2 != null) {
                            for (SubPackageInfo subPackageInfo : subPackagePages2) {
                                if (TextUtils.equals(str2, subPackageInfo.getRoot())) {
                                    String subPackageUrlMD5 = subPackageInfo.getSubPackageUrlMD5();
                                    if (Intrinsics.c(subPackageUrlMD5 != null ? Boolean.valueOf(SubpackageAppPrepareUtils.INSTANCE.checkTarUnCompressStatus(context, str, subPackageUrlMD5)) : null, Boolean.TRUE)) {
                                        ((MiniAppUpdateBridge.OooOO0) oooO0O0).OooO00o();
                                        OooO00o.OooO00o().remove(format);
                                        return;
                                    }
                                    z = true;
                                }
                            }
                        }
                        if (!z) {
                            ((MiniAppUpdateBridge.OooOO0) oooO0O0).OooO00o(MiniAppUpdateBridge.ERROR_MSG_100014);
                            OooO00o.OooO00o().remove(format);
                            return;
                        } else {
                            AppModel appModel2 = appModel;
                            PrepareContext prepareContext = new PrepareContext(context, str, bundle, bundle2, false, (AppChainContext) null, (Activity) null, (AtomicBoolean) null, 240, (DefaultConstructorMarker) null);
                            prepareContext.setAppModel(appModel2);
                            ((IClientStarter) TmcProxy.get(IClientStarter.class)).createSubpackagePrepareController(prepareContext, new com.cloud.tmc.miniapp.defaultimpl.OooO0OO(prepareContext, new OooO00o(oooO0O0, format)), 3, str2).start();
                            return;
                        }
                    }
                    ((MiniAppUpdateBridge.OooOO0) oooO0O0).OooO00o(MiniAppUpdateBridge.ERROR_MSG_100013);
                    oooOOO.OooO00o().remove(format);
                } catch (Throwable th) {
                    th = th;
                    try {
                        OooO00o.OooO00o().remove(format);
                        str3 = "";
                        try {
                            TmcLogger.e(str3, th);
                        } catch (Throwable th2) {
                            th = th2;
                            TmcLogger.e(str3, th);
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        str3 = "";
                    }
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
            str3 = "";
        }
    }

    @JvmStatic
    public static final boolean OooO00o(Context context, AppModel appModel) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appModel, "appModel");
        if (!AppUtils.subpackageIsEnable()) {
            TmcLogger.d(TmcConstants.SUBPACKAGE_COMMON_TAG, "检查是否为全量包：true（云控开关未开）");
            return true;
        }
        String mainPackageUrl = appModel.getMainPackageUrl();
        if (mainPackageUrl == null || mainPackageUrl.length() == 0) {
            TmcLogger.d(TmcConstants.SUBPACKAGE_COMMON_TAG, "检查是否为全量包：true（appInfo主包地址为空），appVersion：" + appModel.getDeployVersion());
            return true;
        }
        if (!AppPrepareUtils.INSTANCE.checkZipDownloadStatus(context, appModel)) {
            return false;
        }
        TmcLogger.d(TmcConstants.SUBPACKAGE_COMMON_TAG, "检查是否为全量包：true（本地已有整包资源下载），appVersion：" + appModel.getDeployVersion());
        return true;
    }

    @JvmStatic
    public static final boolean OooO00o(AppModel appModel) {
        String mainPackageUrl;
        return (!AppUtils.subpackageIsEnable() || appModel == null || (mainPackageUrl = appModel.getMainPackageUrl()) == null || mainPackageUrl.length() == 0) ? false : true;
    }

    @JvmStatic
    public static final boolean OooO00o(final String str, final AppModel appModel, final Context context, final Bundle bundle, final Bundle bundle2, final ISubpackageLoadCheckCallback iSubpackageLoadCheckCallback) {
        List subPackagePages;
        List<SubPackageInfo> subPackagePages2;
        String subPackageUrlMD5;
        Intrinsics.h(str, TmcConstants.EXTRA_PATH);
        Intrinsics.h(appModel, "appModel");
        Intrinsics.h(context, "context");
        Intrinsics.h(bundle, TmcConstants.EXTRA_START_PARAMS);
        Intrinsics.h(bundle2, TmcConstants.EXTRA_SCENE_PARAMS);
        Intrinsics.h(iSubpackageLoadCheckCallback, "loadCheckCallback");
        try {
            if (!OooO00o(context, appModel) && str.length() != 0 && (subPackagePages = appModel.getSubPackagePages()) != null && !subPackagePages.isEmpty() && (subPackagePages2 = appModel.getSubPackagePages()) != null) {
                for (SubPackageInfo subPackageInfo : subPackagePages2) {
                    final String root = subPackageInfo.getRoot();
                    if (root != null && StringsKt.W(str, root, false, 2, (Object) null) && (subPackageUrlMD5 = subPackageInfo.getSubPackageUrlMD5()) != null) {
                        if (!SubpackageAppPrepareUtils.INSTANCE.checkTarUnCompressStatus(context, appModel.getAppId(), subPackageUrlMD5)) {
                            ExecutorUtils.execute(ExecutorType.IO, new Runnable() { // from class: com.cloud.tmc.miniapp.utils.m
                                @Override // java.lang.Runnable
                                public final void run() {
                                    OooOOO.OooO00o(str, appModel, root, bundle, bundle2, context, iSubpackageLoadCheckCallback);
                                }
                            });
                            return true;
                        }
                        return false;
                    }
                }
            }
        } catch (Throwable th) {
            TmcLogger.e("", th);
        }
        return false;
    }

    public final ConcurrentHashMap<String, String> OooO00o() {
        return (ConcurrentHashMap) OooO0O0.getValue();
    }
}
