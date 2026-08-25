package com.cloud.tmc.miniapp.utils;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.integration.utils.PopWindowManager;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.kernel.utils.TmcGsonUtils;
import com.cloud.tmc.launcherlib.LauncherMiniAppConfigHelper;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class AddHomeToastUtils {
    public static final AddHomeToastUtils OooO00o = new AddHomeToastUtils();
    public static final Handler OooO0O0 = new Handler(Looper.getMainLooper());
    public static Runnable OooO0OO;

    public static final class OooO00o implements PopWindowManager.IPopWindowManagerController {
        public final Context OooO00o;
        public final String OooO0O0;
        public final long OooO0OO;
        public final Function0<Unit> OooO0Oo;

        public OooO00o(Context context, String str, long j, Function0<Unit> function0) {
            Intrinsics.h(context, "context");
            Intrinsics.h(str, "windowToken");
            this.OooO00o = context;
            this.OooO0O0 = str;
            this.OooO0OO = j;
            this.OooO0Oo = function0;
        }

        public void onRefresh(PopWindowManager.PopWindowData popWindowData) {
            Intrinsics.h(popWindowData, "bean");
            TmcLogger.d("AddHomeToastUtils", "onRefresh:" + (System.currentTimeMillis() - this.OooO0OO));
            AddHomeToastUtils.OooO00o.OooO00o(this.OooO0O0, this.OooO0OO, popWindowData.getDelayTime() - (System.currentTimeMillis() - this.OooO0OO));
        }

        public void show(String str) {
            Function0<Unit> function0;
            Intrinsics.h(str, "appId");
            boolean queryShortcutExist = AppUtils.INSTANCE.queryShortcutExist(this.OooO00o, str);
            TmcLogger.d("AddHomeToastUtils", "查询桌面是否存在 show()，status: " + queryShortcutExist);
            if (queryShortcutExist || (function0 = this.OooO0Oo) == null) {
                return;
            }
            function0.invoke();
        }
    }

    public static final class OooO0O0 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String OooO00o;
        public final /* synthetic */ Function0<Unit> OooO0O0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO0O0(String str, Function0<Unit> function0) {
            super(0);
            this.OooO00o = str;
            this.OooO0O0 = function0;
        }

        public Object invoke() {
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).recordForCommon(this.OooO00o, TmcConstants.REPORTER_SHOW_ADDHOME_POPWINDOW, new Bundle());
            Function0<Unit> function0 = this.OooO0O0;
            if (function0 != null) {
                function0.invoke();
            }
            return Unit.a;
        }
    }

    public static final void OooO00o(String str, long j) {
        Intrinsics.h(str, "$windowToken");
        PopWindowManager.INSTANCE.showPopWindow(str, System.currentTimeMillis() - j);
    }

    public final void OooO00o(Context context, String str, String str2, long j, long j2, Function0<Unit> function0) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str2, "windowToken");
        if (str == null || str.length() == 0) {
            return;
        }
        boolean queryShortcutExist = AppUtils.INSTANCE.queryShortcutExist(context, str);
        TmcLogger.d("AddHomeToastUtils", "查询桌面是否存在，status: " + queryShortcutExist);
        if (!queryShortcutExist && OooO00o(str)) {
            if (j2 <= 0) {
                TmcLogger.d("AddHomeToastUtils", "添加桌面展示延迟时间小于等于 0");
            } else {
                PopWindowManager.INSTANCE.addPopWindow(str2, new PopWindowManager.PopWindowData(str, j2, 10, new OooO00o(context, str2, j, new OooO0O0(str, function0)), false, 16, (DefaultConstructorMarker) null));
            }
        }
    }

    public final void OooO00o(final String str, final long j, long j2) {
        Runnable runnable = OooO0OO;
        if (runnable != null) {
            OooO0O0.removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: com.cloud.tmc.miniapp.utils.a
            @Override // java.lang.Runnable
            public final void run() {
                AddHomeToastUtils.OooO00o(str, j);
            }
        };
        OooO0OO = runnable2;
        OooO0O0.postDelayed(runnable2, j2);
    }

    public final boolean OooO00o(String str) {
        String str2;
        ArrayList arrayList;
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            str2 = ((ConfigService) TmcProxy.get(ConfigService.class)).getConfigString(LauncherMiniAppConfigHelper.KEY_MINI_ADD_HOME_CUSTOM_WHITE_LIST, "[\"1000497027976413184\"]");
        } catch (Throwable th) {
            TmcLogger.e("AddHomeToastUtils", "checkAddHomeCustomWhiteList failed!", th);
            str2 = "[\"1000497027976413184\"]";
        }
        if (str2 != null) {
            try {
                Type type = new TypeToken<ArrayList<String>>() { // from class: com.cloud.tmc.miniapp.utils.AddHomeToastUtils$checkAddHomeCustomWhiteList$whiteList$1
                }.getType();
                Intrinsics.g(type, "object :\n               …ayList<String>>() {}.type");
                arrayList = (ArrayList) TmcGsonUtils.fromJson(str2, type);
            } catch (Throwable th2) {
                TmcLogger.e("AddHomeToastUtils", th2);
                try {
                    Type type2 = new TypeToken<ArrayList<String>>() { // from class: com.cloud.tmc.miniapp.utils.AddHomeToastUtils$checkAddHomeCustomWhiteList$whiteList$2
                    }.getType();
                    Intrinsics.g(type2, "object : TypeToken<ArrayList<String>>() {}.type");
                    arrayList = (ArrayList) TmcGsonUtils.fromJson("[\"1000497027976413184\"]", type2);
                } catch (Throwable th3) {
                    TmcLogger.e("AddHomeToastUtils", "", th3);
                    arrayList = new ArrayList();
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList == null) {
            return false;
        }
        TmcLogger.d("AddHomeToastUtils", "addHomeCustom: " + arrayList.contains(str) + " 白名单：" + arrayList);
        return arrayList.contains(str);
    }
}
