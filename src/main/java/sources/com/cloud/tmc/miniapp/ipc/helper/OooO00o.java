package com.cloud.tmc.miniapp.ipc.helper;

import android.content.Context;
import android.os.Bundle;
import com.cloud.tmc.component_api_ps.ipc.MiniAppProtocolIpcProcessor;
import com.cloud.tmc.component_api_ps.ipc.callbcak.MiniAppProtocolInvokeCallback;
import com.cloud.tmc.integration.model.MiniAddHomeDataModel;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.utils.AddHomeToScreenUtils;
import com.cloud.tmc.integration.utils.JsonObjectUtils;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.env.IApplicationContextGetter;
import com.cloud.tmc.kernel.utils.ExecutorUtils;
import com.cloud.tmc.kernel.utils.TmcGsonUtils;
import com.cloud.tmc.kernel.utils.TmcGsonUtilsKt;
import com.cloud.tmc.miniapp.GlobalPackageConfig;
import com.cloud.tmc.miniapp.offlineapps.OfflineAppBean;
import com.cloud.tmc.miniapp.protocol.IIpcMiniProtocolMainChannel;
import com.cloud.tmc.offline.download.OfflineManager;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO00o {
    public static final OooO00o OooO00o = new OooO00o();

    /* renamed from: com.cloud.tmc.miniapp.ipc.helper.OooO00o$OooO00o, reason: collision with other inner class name */
    public static final class C0019OooO00o extends Lambda implements Function2<IIpcMiniProtocolMainChannel, String, Unit> {
        public final /* synthetic */ String OooO00o;
        public final /* synthetic */ JsonArray OooO0O0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0019OooO00o(String str, JsonArray jsonArray) {
            super(2);
            this.OooO00o = str;
            this.OooO0O0 = jsonArray;
        }

        public Object invoke(Object obj, Object obj2) {
            IIpcMiniProtocolMainChannel iIpcMiniProtocolMainChannel = (IIpcMiniProtocolMainChannel) obj;
            if (iIpcMiniProtocolMainChannel != null) {
                String str = this.OooO00o;
                Bundle bundle = new Bundle();
                bundle.putString("resultJsonData", TmcGsonUtilsKt.toJson(this.OooO0O0));
                Unit unit = Unit.a;
                iIpcMiniProtocolMainChannel.onMiniAppAbility("typeMiniAppOffline", str, bundle);
            }
            return Unit.a;
        }
    }

    public static final class OooO0O0 extends Lambda implements Function2<IIpcMiniProtocolMainChannel, String, Unit> {
        public final /* synthetic */ String OooO00o;
        public final /* synthetic */ JsonObjectUtils.Builder OooO0O0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO0O0(String str, JsonObjectUtils.Builder builder) {
            super(2);
            this.OooO00o = str;
            this.OooO0O0 = builder;
        }

        public Object invoke(Object obj, Object obj2) {
            IIpcMiniProtocolMainChannel iIpcMiniProtocolMainChannel = (IIpcMiniProtocolMainChannel) obj;
            if (iIpcMiniProtocolMainChannel != null) {
                String str = this.OooO00o;
                Bundle bundle = new Bundle();
                JsonObject build = this.OooO0O0.build();
                Intrinsics.g(build, "resultObj.build()");
                bundle.putString("resultJsonData", TmcGsonUtilsKt.toJson(build));
                Unit unit = Unit.a;
                iIpcMiniProtocolMainChannel.onMiniAppAbility("typeSingleMiniAppOffline", str, bundle);
            }
            return Unit.a;
        }
    }

    public static final void OooO00o(Context context, String str, String str2, String str3) {
        Intrinsics.h(context, "$context");
        Intrinsics.h(str, "$appId");
        Intrinsics.h(str2, "$name");
        Intrinsics.h(str3, "$logoUrl");
        AddHomeToScreenUtils.createShortcutByLogoUrl$default(AddHomeToScreenUtils.INSTANCE, context, new MiniAddHomeDataModel(str, str2, str3), "", false, false, (App) null, 56, (Object) null);
    }

    public static final void OooO0O0(String str, String str2, Bundle bundle) {
        Context applicationContext;
        String string;
        try {
            applicationContext = ((IApplicationContextGetter) TmcProxy.get(IApplicationContextGetter.class)).getApplicationContext();
            Intrinsics.g(applicationContext, "get(IApplicationContextG….java).applicationContext");
        } catch (Throwable th) {
            TmcLogger.e("MiniAppAbilityHelper", "protocolInvoke error:", th);
        }
        if (str != null) {
            switch (str.hashCode()) {
                case -2135366643:
                    if (str.equals("typePreloadOfflineApp")) {
                        OfflineManager.downloadPkgFromPlatform$default(bundle != null ? bundle.getString("queryAppId", "") : null, false, null, 4, null);
                        return;
                    }
                    return;
                case -2039708617:
                    if (str.equals("typeMiniAppAddShortcut")) {
                        OooO00o.OooO00o(applicationContext, bundle);
                        return;
                    }
                    return;
                case -1827174149:
                    if (str.equals("typeSingleMiniAppOffline")) {
                        OooO00o.OooO0O0(applicationContext, str2, bundle);
                        return;
                    }
                    return;
                case -681532909:
                    if (str.equals("typeMiniAppOffline")) {
                        OooO00o.OooO00o(applicationContext, str2, bundle);
                        return;
                    }
                    return;
                case 1218687240:
                    if (str.equals("typeMiniAppVersion")) {
                        if (bundle != null) {
                            try {
                                string = bundle.getString("miniAppPSChannelIpcPkg", "com.transsnet.store");
                            } catch (Throwable th2) {
                                TmcLogger.e("MiniAppAbilityHelper", "querySDKVersion error:", th2);
                                return;
                            }
                        } else {
                            string = null;
                        }
                        MiniAppProtocolIpcProcessor.startIpcMainProcessInvoke$default(MiniAppProtocolIpcProcessor.INSTANCE, applicationContext, string, (MiniAppProtocolInvokeCallback) null, new com.cloud.tmc.miniapp.ipc.helper.OooO0O0(str2, GlobalPackageConfig.Companion.getSDK_DEV_VERSION()), (Bundle) null, 16, (Object) null);
                        return;
                    }
                    return;
                default:
                    return;
            }
            TmcLogger.e("MiniAppAbilityHelper", "protocolInvoke error:", th);
        }
    }

    public final void OooO00o(final Context context, Bundle bundle) {
        final String string;
        final String string2;
        final String string3 = bundle != null ? bundle.getString("queryAppId", "") : null;
        if (string3 == null || (string = bundle.getString("appName", "")) == null || (string2 = bundle.getString("logoUrl", "")) == null) {
            return;
        }
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.cloud.tmc.miniapp.ipc.helper.b
            @Override // java.lang.Runnable
            public final void run() {
                OooO00o.OooO00o(context, string3, string, string2);
            }
        });
    }

    public final void OooO00o(Context context, String str, Bundle bundle) {
        String string;
        ArrayList<String> arrayList;
        if (bundle != null) {
            try {
                string = bundle.getString("miniAppPSChannelIpcPkg", "com.transsnet.store");
            } catch (Throwable th) {
                TmcLogger.e("MiniAppAbilityHelper", "querySDKVersion error:", th);
                return;
            }
        } else {
            string = null;
        }
        String string2 = bundle != null ? bundle.getString("queryAppId", "[]") : null;
        try {
            arrayList = (ArrayList) TmcGsonUtils.fromJson(string2 != null ? string2 : "[]", ArrayList.class);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
        } catch (Throwable unused) {
            arrayList = new ArrayList();
        }
        JsonArray jsonArray = new JsonArray();
        Map<String, OfflineAppBean> map = com.cloud.tmc.miniapp.offlineapps.scan.OooO0O0.OooO0Oo;
        if (arrayList.isEmpty()) {
            Iterator it = ((LinkedHashMap) map).keySet().iterator();
            while (it.hasNext()) {
                arrayList.add((String) it.next());
            }
        }
        for (String str2 : arrayList) {
            OfflineAppBean offlineAppBean = (OfflineAppBean) ((LinkedHashMap) map).get(str2);
            JsonObjectUtils.Builder create = JsonObjectUtils.create();
            Intrinsics.g(create, "create()");
            if (offlineAppBean != null) {
                create.addProperty("appId", offlineAppBean.getAppId());
                create.addProperty("logoUrl", offlineAppBean.getLogoUrl());
                create.addProperty("appName", offlineAppBean.getName());
                create.addProperty(TmcConstants.EXTRA_APP_INFO_VERSION, offlineAppBean.getVersion());
                create.addProperty("status", Boolean.TRUE);
                jsonArray.add(create.build());
            } else {
                create.addProperty("appId", str2);
                create.addProperty("status", Boolean.FALSE);
                jsonArray.add(create.build());
            }
        }
        MiniAppProtocolIpcProcessor.startIpcMainProcessInvoke$default(MiniAppProtocolIpcProcessor.INSTANCE, context, string, (MiniAppProtocolInvokeCallback) null, new C0019OooO00o(str, jsonArray), (Bundle) null, 16, (Object) null);
    }

    public void OooO00o(final String str, final String str2, final Bundle bundle) {
        StringBuilder sb = new StringBuilder();
        sb.append("protocolInvoke: ");
        sb.append(str);
        sb.append(" callbackId ->");
        sb.append(str2);
        try {
            ExecutorUtils.execute(ExecutorType.IO, new Runnable() { // from class: com.cloud.tmc.miniapp.ipc.helper.c
                @Override // java.lang.Runnable
                public final void run() {
                    OooO00o.OooO0O0(str, str2, bundle);
                }
            });
        } catch (Throwable th) {
            TmcLogger.e("MiniAppAbilityHelper", "protocolInvoke error:", th);
        }
    }

    public final void OooO0O0(Context context, String str, Bundle bundle) {
        String string;
        if (bundle != null) {
            try {
                string = bundle.getString("miniAppPSChannelIpcPkg", "com.transsnet.store");
            } catch (Throwable th) {
                TmcLogger.e("MiniAppAbilityHelper", "querySDKVersion error:", th);
                return;
            }
        } else {
            string = null;
        }
        String str2 = "";
        String string2 = bundle != null ? bundle.getString("queryAppId", "") : null;
        if (string2 != null) {
            str2 = string2;
        }
        OfflineAppBean offlineAppBean = (OfflineAppBean) ((LinkedHashMap) com.cloud.tmc.miniapp.offlineapps.scan.OooO0O0.OooO0Oo).get(str2);
        JsonObjectUtils.Builder create = JsonObjectUtils.create();
        Intrinsics.g(create, "create()");
        if (offlineAppBean != null) {
            create.addProperty("appId", offlineAppBean.getAppId());
            create.addProperty("logoUrl", offlineAppBean.getLogoUrl());
            create.addProperty("appName", offlineAppBean.getName());
            create.addProperty(TmcConstants.EXTRA_APP_INFO_VERSION, offlineAppBean.getVersion());
            create.addProperty("status", Boolean.TRUE);
        } else {
            create.addProperty("appId", str2);
            create.addProperty("status", Boolean.FALSE);
        }
        MiniAppProtocolIpcProcessor.startIpcMainProcessInvoke$default(MiniAppProtocolIpcProcessor.INSTANCE, context, string, (MiniAppProtocolInvokeCallback) null, new OooO0O0(str, create), (Bundle) null, 16, (Object) null);
    }
}
