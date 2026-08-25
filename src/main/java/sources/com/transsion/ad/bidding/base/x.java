package com.transsion.ad.bidding.base;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.hisavana.common.bean.AdditionalInfo;
import com.hisavana.common.interfacz.TAdditionalListener;
import com.transsion.ad.db.pslink.AppInstalledBean;
import com.transsion.ad.ps.installed.AppInstallManager;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class x extends TAdditionalListener {
    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onAdActivate(AdditionalInfo additionalInfo) {
        Intrinsics.h(additionalInfo, "additionalInfo");
        super.onAdActivate(additionalInfo);
        AppInstallManager appInstallManager = AppInstallManager.a;
        String packageName = additionalInfo.getPackageName();
        if (packageName == null) {
            packageName = "ew没有传递过来包名";
        }
        AppInstalledBean a = appInstallManager.a(packageName);
        a.setECPM(additionalInfo.getECPM());
        a.setSource("EW");
        a.setHorizontalImageUrl(additionalInfo.getImageUrl());
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        appInstallManager.e(a2, a);
    }
}
