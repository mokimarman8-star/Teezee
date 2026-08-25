package com.cloud.tmc.miniapp.prestrategy;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.LruCache;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.model.LauncherPreDataModel;
import com.cloud.tmc.integration.utils.AppPrepareUtils;
import com.cloud.tmc.integration.utils.UrlUtil;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.framework.FrameworkConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.network.INetWorkProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.utils.AppDynamicBuildConfig;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.cloud.tmc.launcherlib.LauncherMiniAppConfigHelper;
import com.cloud.tmc.miniutils.util.NetworkUtils;
import com.cloud.tmc.offline.download.utils.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO0OO {
    public static final OooO0OO OooO00o = new OooO0OO();
    public static final LruCache<String, PrefetchData> OooO0O0 = new LruCache<>(1);
    public static final long OooO0OO = TmcConstants.MINI_POPWINDOW_MSG_BUBBLE_INTERVAL;
    public static final int OooO0Oo = 1;
    public static final AtomicInteger OooO0o0 = new AtomicInteger(0);
    public static final Map<String, String> OooO0o = MapsKt.m(new Pair[]{TuplesKt.a("keyZeroRecentData", TmcConstants.KEY_PREFETCH_ZERO_RECENT), TuplesKt.a("keyZeroMinicardData", TmcConstants.KEY_PREFETCH_ZERO_CARD), TuplesKt.a("keyZeroMinicardUpdate", TmcConstants.KEY_PREFETCH_ZERO_CARD), TuplesKt.a("keyFullRecentMiniData", TmcConstants.KEY_PREFETCH_FULL_RECENT), TuplesKt.a("keyFullMinicardData", TmcConstants.KEY_PREFETCH_FULL_CARD), TuplesKt.a("keyAzRecentData", "100007"), TuplesKt.a("keyFullSearchAppData", TmcConstants.KEY_PREFETCH_FULL_MINIAPP), TuplesKt.a("keyZeroBannerData", TmcConstants.KEY_PREFETCH_ZERO_BANNER)});

    public final String OooO00o() {
        return MiniAppConfigHelper.INSTANCE.getConfigTargetStr(LauncherMiniAppConfigHelper.KEY_PREFETCH_CONFIG_URL, AppDynamicBuildConfig.getMINI_APP_STATIC_URL() + "miniapp/platform/consumer-not-login/commonPrefetch/query/getPrefetchStrategyByCdn");
    }

    public final void OooO00o(Context context, String str, ArrayList<LauncherPreDataModel> arrayList) {
        if (arrayList.isEmpty() || str == null || str.length() == 0 || context == null) {
            TmcLogger.e("Prefetch:PrefetchConfigManager", "requestStrategyConfig failed: param is invalid.");
            return;
        }
        Map<String, Bundle> linkedHashMap = new LinkedHashMap<>();
        ArrayList arrayList2 = new ArrayList();
        for (LauncherPreDataModel launcherPreDataModel : arrayList) {
            String appId = launcherPreDataModel.getAppId();
            Bundle bundle = new Bundle();
            if (appId == null || appId.length() == 0) {
                String schemeUrl = launcherPreDataModel.getSchemeUrl();
                if (schemeUrl == null || schemeUrl.length() == 0) {
                    PreStrategyManager preStrategyManager = PreStrategyManager.OooO00o;
                    TmcLogger.e("Prefetch:PreStrategyManager", "preStrategyProcessing schemeUrl is null");
                } else {
                    boolean configTargetBool = MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_FIX_ENCODE_URL, true);
                    UrlUtil urlUtil = UrlUtil.INSTANCE;
                    Uri parse = Uri.parse(urlUtil.fixEncodeUrl(schemeUrl, configTargetBool));
                    String queryParameter = parse.getQueryParameter("appId");
                    if (queryParameter == null || queryParameter.length() == 0) {
                        PreStrategyManager preStrategyManager2 = PreStrategyManager.OooO00o;
                        TmcLogger.e("Prefetch:PreStrategyManager", "preStrategyProcessing appId is null");
                    } else {
                        String queryParameter2 = parse.getQueryParameter("query");
                        if (queryParameter2 != null) {
                            Intrinsics.g(queryParameter2, "it");
                            bundle.putString("query", urlUtil.getFixDecodeUrl(queryParameter2, configTargetBool));
                        }
                        String queryParameter3 = parse.getQueryParameter("h5Path");
                        if (queryParameter3 != null) {
                            Intrinsics.g(queryParameter3, "it");
                            bundle.putString("h5Path", urlUtil.getFixDecodeUrl(queryParameter3, configTargetBool));
                        }
                        String queryParameter4 = parse.getQueryParameter("hybridPath");
                        if (queryParameter4 != null) {
                            String decode = UrlUtils.decode(queryParameter4);
                            if (decode == null) {
                                decode = "";
                            }
                            Intrinsics.g(decode, "UrlUtils.decode(it) ?: \"\"");
                            bundle.putString("hybridPath", urlUtil.getFixDecodeUrl(decode, configTargetBool));
                        }
                        launcherPreDataModel.setAppId(queryParameter);
                        launcherPreDataModel.setBundle(bundle);
                        if (queryParameter != null && queryParameter.length() != 0) {
                            linkedHashMap.put(queryParameter, bundle);
                            appId = queryParameter;
                        }
                    }
                }
            }
            if (appId != null && appId.length() != 0 && !arrayList2.contains(appId)) {
                arrayList2.add(appId);
            }
        }
        OooO00o(context, str, arrayList2, linkedHashMap);
    }

    public final void OooO00o(Context context, String str, List<String> list, Map<String, Bundle> map) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, FrameworkConstants.GLOBAL_DATA_KEY_SCENE);
        Intrinsics.h(list, "appIdList");
        try {
            if (OooO0o0.get() == 1) {
                TmcLogger.e("Prefetch:PrefetchConfigManager", "last request is executing. " + str + " skip.");
                return;
            }
            String str2 = OooO0o.get(str);
            String str3 = str2 == null ? str : str2;
            if (StringsKt.W(str, "key", false, 2, (Object) null)) {
                TmcLogger.e("Prefetch:PrefetchConfigManager", "sceneId:" + str + " is invalid. skip.");
                return;
            }
            Collections.sort(list);
            String str4 = "";
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                str4 = ((Object) str4) + ((String) it.next()) + ",";
            }
            if (str4.length() == 0) {
                TmcLogger.e("Prefetch:PrefetchConfigManager", str + " requestStrategyConfig failed: appId is invalid.");
                return;
            }
            int i = -1;
            int length = str4.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i2 = length - 1;
                    if (str4.charAt(length) == ',') {
                        i = length;
                        break;
                    } else if (i2 < 0) {
                        break;
                    } else {
                        length = i2;
                    }
                }
            }
            Intrinsics.g(str4.substring(i), "this as java.lang.String).substring(startIndex)");
            long j = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getLong(context, "mini_PrefetchData", str3);
            long currentTimeMillis = System.currentTimeMillis();
            PrefetchData prefetchData = new PrefetchData(str3, str4, map);
            if (!NetworkUtils.isConnected()) {
                OooO0O0.put(str3, prefetchData);
                TmcLogger.e("Prefetch:PrefetchConfigManager", str3 + " network is not connected. push wait queue.");
                return;
            }
            long configTargetLong = MiniAppConfigHelper.INSTANCE.getConfigTargetLong(LauncherMiniAppConfigHelper.KEY_PREFETCH_FRESH_TIME, OooO0OO);
            if (currentTimeMillis - j >= configTargetLong) {
                ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putLong(context, "mini_PrefetchData", str3, currentTimeMillis);
                OooO00o(prefetchData);
                return;
            }
            TmcLogger.e("Prefetch:PrefetchConfigManager", "sceneId:" + str3 + " fetch time < " + configTargetLong);
        } catch (Throwable th) {
            TmcLogger.e("Prefetch:PrefetchConfigManager", th);
        }
    }

    public final void OooO00o(PrefetchData prefetchData) {
        String appIds;
        String sceneId = prefetchData.getSceneId();
        if (sceneId == null || sceneId.length() == 0 || (appIds = prefetchData.getAppIds()) == null || appIds.length() == 0) {
            TmcLogger.e("Prefetch:PrefetchConfigManager", "request abort. " + prefetchData.getSceneId() + " or " + prefetchData.getAppIds() + " is invalid.");
            return;
        }
        if (!OooO0o0.compareAndSet(0, OooO0Oo)) {
            TmcLogger.e("Prefetch:PrefetchConfigManager", "(sceneId=" + prefetchData.getSceneId() + ") request abort. last request not finish.");
            return;
        }
        TmcLogger.e("Prefetch:PrefetchConfigManager", "requestStrategyConfig start. sceneId:" + prefetchData.getSceneId() + ", appIds=" + prefetchData.getAppIds());
        ((INetWorkProxy) TmcProxy.get(INetWorkProxy.class)).get(OooO00o(), new LinkedHashMap<>(), MapsKt.m(new Pair[]{TuplesKt.a("sceneId", prefetchData.getSceneId()), TuplesKt.a("miniappIds", prefetchData.getAppIds()), TuplesKt.a("cacheCDNKey", AppPrepareUtils.INSTANCE.urlToSHA256(Utils.INSTANCE.getMcc() + prefetchData.getSceneId() + prefetchData.getAppIds()))}), Boolean.TRUE, new PrefetchConfigManager$requestStrategyConfig$4(prefetchData));
    }

    public final boolean OooO0O0() {
        return MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_PREFETCH_ENABLE, true);
    }
}
