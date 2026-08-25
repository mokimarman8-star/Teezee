package com.cloud.tmc.miniapp.prepare.steps.subpackage;

import android.text.TextUtils;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.PrepareContext;
import com.cloud.tmc.integration.model.SubPackageInfo;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.resource.IPackageResourceManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooOO0 {
    public SubPackageInfo OooO00o;
    public boolean OooO0O0;
    public String OooO0OO;
    public AppModel OooO0Oo;
    public Integer OooO0o0 = 1;

    public final PointAnalyseType OooO00o(PointAnalyseType pointAnalyseType) {
        Intrinsics.h(pointAnalyseType, "bundle");
        if (this.OooO0O0) {
            String str = this.OooO0OO;
            if (str != null && str.length() != 0) {
                pointAnalyseType.putData(TmcConstants.TRACK_MPU_SPECIAL_SUBPKG, TmcConstants.MPU_SPECIAL_SUBPKG_VALUE_SUB_PREFIX + this.OooO0OO);
            }
        } else {
            pointAnalyseType.putData(TmcConstants.TRACK_MPU_SPECIAL_SUBPKG, "mainPkg");
        }
        return pointAnalyseType;
    }

    public final String OooO00o(AppModel appModel) {
        if (this.OooO0O0) {
            SubPackageInfo subPackageInfo = this.OooO00o;
            if (subPackageInfo != null) {
                return subPackageInfo.getSubPackageUrlMD5();
            }
        } else if (appModel != null) {
            return appModel.getMainPackageUrlEncryption();
        }
        return null;
    }

    public final void OooO00o() {
        String appId;
        try {
            AppModel appModel = this.OooO0Oo;
            if (appModel == null || (appId = appModel.getAppId()) == null || appId.length() == 0 || this.OooO0O0) {
                return;
            }
            IPackageResourceManager iPackageResourceManager = (IPackageResourceManager) TmcProxy.get(IPackageResourceManager.class);
            AppModel appModel2 = this.OooO0Oo;
            String vhost = iPackageResourceManager.getVhost(appModel2 != null ? appModel2.getAppId() : null);
            for (Map.Entry<String, String> entry : iPackageResourceManager.getVUrl2FilePathMap().entrySet()) {
                String key = entry.getKey();
                if (key != null && key.length() != 0) {
                    String key2 = entry.getKey();
                    Intrinsics.g(key2, "entry.key");
                    Intrinsics.g(vhost, "vhost");
                    if (StringsKt.W(key2, vhost, false, 2, (Object) null)) {
                        iPackageResourceManager.getVUrl2FilePathMap().remove(entry.getKey());
                        TmcLogger.d("SubpackageStepHelper", "remove vurlPathMap key:" + ((Object) entry.getKey()) + ",value:" + ((Object) entry.getValue()));
                    }
                }
            }
            for (Map.Entry<String, String> entry2 : iPackageResourceManager.getFilePath2VUrlMap().entrySet()) {
                String value = entry2.getValue();
                if (value != null && value.length() != 0) {
                    String value2 = entry2.getValue();
                    Intrinsics.g(value2, "entry.value");
                    Intrinsics.g(vhost, "vhost");
                    if (StringsKt.W(value2, vhost, false, 2, (Object) null)) {
                        iPackageResourceManager.getFilePath2VUrlMap().remove(entry2.getKey());
                        TmcLogger.d("SubpackageStepHelper", "remove vurlMap key:" + ((Object) entry2.getKey()) + ",value:" + ((Object) entry2.getValue()));
                    }
                }
            }
        } catch (Throwable th) {
            TmcLogger.e("SubpackageStepHelper", "", th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x00e1, code lost:
    
        r7 = r7.getSubPackagePages();
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00e5, code lost:
    
        if (r7 == null) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00e7, code lost:
    
        r7 = r7.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00ef, code lost:
    
        if (r7.hasNext() == false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00f1, code lost:
    
        r8 = (com.cloud.tmc.integration.model.SubPackageInfo) r7.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0101, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.c(r6.OooO0OO, r8.getRoot()) == false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0103, code lost:
    
        r6.OooO00o = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:?, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009d A[Catch: all -> 0x004b, TryCatch #0 {all -> 0x004b, blocks: (B:3:0x0005, B:5:0x001a, B:8:0x002c, B:10:0x0032, B:11:0x0037, B:13:0x003d, B:23:0x0053, B:25:0x0059, B:29:0x0065, B:31:0x006b, B:32:0x006f, B:34:0x0075, B:36:0x0081, B:42:0x008d, B:45:0x0093, B:46:0x0097, B:48:0x009d, B:51:0x00c1, B:61:0x00c7, B:64:0x00d1, B:66:0x00d7, B:71:0x00e1, B:73:0x00e7, B:74:0x00eb, B:76:0x00f1, B:79:0x0103), top: B:2:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void OooO00o(AppModel appModel, String str, PrepareContext prepareContext, Integer num) {
        boolean z;
        List subPackagePages;
        boolean z2;
        List<String> pages;
        List subPackagePages2;
        List mainPackagePages;
        Intrinsics.h(prepareContext, "context");
        try {
            this.OooO0Oo = appModel;
            boolean z3 = true;
            this.OooO0O0 = !TextUtils.isEmpty(str);
            this.OooO0OO = str;
            this.OooO0o0 = num;
            if (TextUtils.isEmpty(str)) {
                String string = prepareContext.getStartParams().getString("page");
                if (!TextUtils.isEmpty(string)) {
                    if (appModel == null || (mainPackagePages = appModel.getMainPackagePages()) == null) {
                        z = false;
                    } else {
                        Iterator it = mainPackagePages.iterator();
                        z = false;
                        while (it.hasNext()) {
                            if (TextUtils.equals((String) it.next(), string)) {
                                z = true;
                            }
                        }
                    }
                    if (!z) {
                        if (((appModel == null || (subPackagePages2 = appModel.getSubPackagePages()) == null || !(subPackagePages2.isEmpty() ^ true)) ? false : true) && (subPackagePages = appModel.getSubPackagePages()) != null) {
                            Iterator it2 = subPackagePages.iterator();
                            loop1: while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                SubPackageInfo subPackageInfo = (SubPackageInfo) it2.next();
                                List pages2 = subPackageInfo.getPages();
                                if (pages2 != null && !pages2.isEmpty()) {
                                    z2 = false;
                                    if (!z2 && (pages = subPackageInfo.getPages()) != null) {
                                        for (String str2 : pages) {
                                            if (TextUtils.equals(subPackageInfo.getRoot() + "/" + str2, string)) {
                                                this.OooO0OO = subPackageInfo.getRoot();
                                                break loop1;
                                            }
                                        }
                                    }
                                }
                                z2 = true;
                                if (!z2) {
                                    while (r2.hasNext()) {
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (TextUtils.isEmpty(this.OooO0OO) || appModel == null) {
                return;
            }
            List subPackagePages3 = appModel.getSubPackagePages();
            if (subPackagePages3 != null && !subPackagePages3.isEmpty()) {
                z3 = false;
            }
        } catch (Throwable th) {
            TmcLogger.e("", th);
        }
    }

    public final SubPackageInfo OooO0O0() {
        if (this.OooO0O0) {
            return this.OooO00o;
        }
        return null;
    }
}
