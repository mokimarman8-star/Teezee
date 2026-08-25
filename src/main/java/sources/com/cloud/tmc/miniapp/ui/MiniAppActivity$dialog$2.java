package com.cloud.tmc.miniapp.ui;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.proxy.OfflineAppProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.utils.FastClickUtil;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.launcherlib.LauncherMiniAppConfigHelper;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniapp.base.BaseAdapter;
import com.cloud.tmc.miniapp.dialog.BottomDialog$MenuItem;
import com.cloud.tmc.miniapp.dialog.OooOOO0;
import com.cloud.tmc.miniapp.ui.AppBrandProfileActivity;
import com.cloud.tmc.miniapp.utils.MessageBubbleUtils;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class MiniAppActivity$dialog$2 extends Lambda implements Function0<OooOOO0> {
    public final /* synthetic */ MiniAppActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniAppActivity$dialog$2(MiniAppActivity miniAppActivity) {
        super(0);
        this.this$0 = miniAppActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void invoke$lambda$3$lambda$2(MiniAppActivity miniAppActivity, View view) {
        AppModel appModel;
        OooOOO0 dialog;
        Bundle appBrandBundle;
        OooOOO0 dialog2;
        Intrinsics.h(miniAppActivity, "this$0");
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i = R.id.tv_btn;
        if (valueOf != null && valueOf.intValue() == i) {
            dialog2 = miniAppActivity.getDialog();
            dialog2.dismiss();
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(miniAppActivity.getAppId(), PointAnalyseType.POINT_MORE_EXIT, "");
            return;
        }
        int i2 = R.id.layer_app_brand;
        if (valueOf != null && valueOf.intValue() == i2) {
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(miniAppActivity.getAppId(), PointAnalyseType.POINT_ENTER_DEVELOP, "");
            App app = miniAppActivity.getMActivityHelper().getApp();
            if (app == null || (appModel = app.getAppModel()) == null) {
                return;
            }
            dialog = miniAppActivity.getDialog();
            dialog.dismiss();
            String appId = appModel.getAppId();
            if (appId != null) {
                AppBrandProfileActivity.Companion companion = AppBrandProfileActivity.Companion;
                appBrandBundle = miniAppActivity.getAppBrandBundle(appModel);
                companion.launch(miniAppActivity, appId, appBrandBundle);
            }
        }
    }

    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final OooOOO0 m61invoke() {
        Object obj;
        final OooOOO0 oooOOO0 = new OooOOO0(this.this$0);
        final MiniAppActivity miniAppActivity = this.this$0;
        ArrayList h = CollectionsKt.h(new BottomDialog$MenuItem[]{Intrinsics.c("1000886706715795456", miniAppActivity.getAppId()) ? new BottomDialog$MenuItem("message", R.drawable.mini_ic_message, oooOOO0.getString(R.string.mini_dialog_message), false, false, 24, null) : new BottomDialog$MenuItem("message", R.drawable.mini_icon_bottom_dialog_btn_notification, oooOOO0.getString(R.string.mini_miniapp_center), false, false, 24, null), new BottomDialog$MenuItem(TmcConstants.MENU_KEY_PERMISSION, R.drawable.mini_ic_permission_icon, oooOOO0.getString(R.string.mini_permission_manager_title), false, false, 24, null), new BottomDialog$MenuItem(TmcConstants.MENU_KEY_FEEDBACK, R.drawable.mini_ic_feedback, oooOOO0.getString(R.string.mini_dialog_feedback), false, false, 24, null), new BottomDialog$MenuItem("refreshApp", R.drawable.mini_ic_refresh, oooOOO0.getString(R.string.mini_dialog_reopen), false, false, 24, null)});
        try {
            if (!MessageBubbleUtils.OooO00o.OooO00o()) {
                Iterator it = h.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.c(((BottomDialog$MenuItem) obj).getId(), "message")) {
                        break;
                    }
                }
                BottomDialog$MenuItem bottomDialog$MenuItem = (BottomDialog$MenuItem) obj;
                if (bottomDialog$MenuItem != null) {
                    h.remove(bottomDialog$MenuItem);
                }
            }
        } catch (Throwable th) {
            TmcLogger.e("BottomDialog", th);
        }
        oooOOO0.OooO0o.setData(h);
        oooOOO0.OooO0oo = new BaseAdapter.OnItemClickListener() { // from class: com.cloud.tmc.miniapp.ui.MiniAppActivity$dialog$2$1$1
            @Override // com.cloud.tmc.miniapp.base.BaseAdapter.OnItemClickListener
            public void onItemClick(RecyclerView recyclerView, View view, int i) {
                AppModel appModel;
                OooOOO0 dialog;
                OooOOO0 dialog2;
                AppModel appModel2;
                OooOOO0 dialog3;
                String str = "1000391591855976448";
                if (FastClickUtil.isFastDoubleClick()) {
                    return;
                }
                List<BottomDialog$MenuItem> data = OooOOO0.this.OooO0o.getData();
                if (i >= data.size()) {
                    return;
                }
                String id = data.get(i).getId();
                int hashCode = id.hashCode();
                if (hashCode == -517618225) {
                    if (id.equals(TmcConstants.MENU_KEY_PERMISSION)) {
                        try {
                            if (Intrinsics.c("1000886706715795456", miniAppActivity.getAppId())) {
                                OfflineAppProxy.CreateShortCutsListener createShortCutsListener = miniAppActivity;
                                Bundle bundle = new Bundle();
                                bundle.putString("page", "pages/index/index");
                                bundle.putBoolean("extraMiniClearAllPages", true);
                                Unit unit = Unit.a;
                                ByteAppManager.launchMiniAppForId$default(createShortCutsListener, TmcConstants.SETTING_MINIAPP_ID, null, bundle, 4, null);
                            } else {
                                OfflineAppProxy.CreateShortCutsListener createShortCutsListener2 = miniAppActivity;
                                Bundle bundle2 = new Bundle();
                                MiniAppActivity miniAppActivity2 = miniAppActivity;
                                bundle2.putString("page", "pages/settings/settings");
                                App app = miniAppActivity2.getMActivityHelper().getApp();
                                if (app != null && (appModel = app.getAppModel()) != null) {
                                    r10 = appModel.getAppId();
                                }
                                bundle2.putString("query", "setting_miniappId%3D" + ((String) r10));
                                Unit unit2 = Unit.a;
                                ByteAppManager.launchMiniAppForId$default(createShortCutsListener2, TmcConstants.SETTING_MINIAPP_ID, null, bundle2, 4, null);
                            }
                            dialog = miniAppActivity.getDialog();
                            dialog.dismiss();
                            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(miniAppActivity.getAppId(), PointAnalyseType.POINT_CLICK_AUTH, "");
                            return;
                        } catch (Throwable th2) {
                            TmcLogger.e("MiniAppActivity", th2);
                            return;
                        }
                    }
                    return;
                }
                if (hashCode == -321864378) {
                    if (id.equals("refreshApp")) {
                        try {
                            miniAppActivity.refresh();
                            return;
                        } catch (Throwable th3) {
                            TmcLogger.e("refresh fail!!,msg:" + th3);
                            return;
                        }
                    }
                    return;
                }
                if (hashCode == -191501435) {
                    if (id.equals(TmcConstants.MENU_KEY_FEEDBACK)) {
                        dialog2 = miniAppActivity.getDialog();
                        dialog2.dismiss();
                        ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).recordForCommon(miniAppActivity.getAppId(), TmcConstants.REPORTER_FEEDBACK_ENTER, new Bundle());
                        try {
                            str = ((ConfigService) TmcProxy.get(ConfigService.class)).getConfigString(LauncherMiniAppConfigHelper.KEY_MINI_FEEDBACK_ID, "1000391591855976448");
                        } catch (Throwable unused) {
                        }
                        String str2 = str;
                        OfflineAppProxy.CreateShortCutsListener createShortCutsListener3 = miniAppActivity;
                        Bundle bundle3 = new Bundle();
                        MiniAppActivity miniAppActivity3 = miniAppActivity;
                        App app2 = miniAppActivity3.getMActivityHelper().getApp();
                        bundle3.putString(TmcConstants.EXTRA_CURRENT_MINIAPP_ID, (app2 == null || (appModel2 = app2.getAppModel()) == null) ? null : appModel2.getAppId());
                        MiniAppLaunch miniAppLaunch = MiniAppLaunch.INSTANCE;
                        App app3 = miniAppActivity3.getMActivityHelper().getApp();
                        bundle3.putString(TmcConstants.EXTRA_CURRENT_MINIAPP_VERSION, miniAppLaunch.getMiniAppVersion(app3 != null ? app3.getAppModel() : null));
                        Unit unit3 = Unit.a;
                        ByteAppManager.launchMiniAppForId$default(createShortCutsListener3, str2, null, bundle3, 4, null);
                        return;
                    }
                    return;
                }
                if (hashCode == 954925063 && id.equals("message")) {
                    try {
                        if (MessageBubbleUtils.OooO00o.OooO00o()) {
                            if (Intrinsics.c("1000886706715795456", miniAppActivity.getAppId())) {
                                OfflineAppProxy.CreateShortCutsListener createShortCutsListener4 = miniAppActivity;
                                Bundle bundle4 = new Bundle();
                                bundle4.putString("page", "pages/notification/notification");
                                bundle4.putString("query", "entrance%3Dlayer");
                                Unit unit4 = Unit.a;
                                ByteAppManager.launchMiniAppForId(createShortCutsListener4, "1000886706715795456", "", bundle4);
                                ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(miniAppActivity.getAppId(), PointAnalyseType.POINT_CLICK_MESSAGE, "");
                            } else {
                                ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(miniAppActivity.getAppId(), PointAnalyseType.POINT_CLICK_MC, "");
                                OfflineAppProxy.CreateShortCutsListener createShortCutsListener5 = miniAppActivity;
                                Bundle bundle5 = new Bundle();
                                bundle5.putString("page", "pages/index/index");
                                bundle5.putBoolean("extraMiniClearAllPages", true);
                                Unit unit5 = Unit.a;
                                ByteAppManager.launchMiniAppForId(createShortCutsListener5, "1000886706715795456", "120010", bundle5);
                            }
                            OfflineAppProxy.CreateShortCutsListener createShortCutsListener6 = miniAppActivity;
                            Intrinsics.h(createShortCutsListener6, "context");
                            ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putBoolean(createShortCutsListener6, TmcConstants.KEY_MSG_ID, TmcConstants.KEY_MINI_NEW_MESSAGE_STATUS, false);
                            dialog3 = miniAppActivity.getDialog();
                            dialog3.dismiss();
                        }
                    } catch (Throwable th4) {
                        TmcLogger.e("MiniAppActivity", th4);
                    }
                }
            }
        };
        oooOOO0.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.ui.j0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniAppActivity$dialog$2.invoke$lambda$3$lambda$2(MiniAppActivity.this, view);
            }
        }, R.id.tv_btn, R.id.layer_app_brand);
        return oooOOO0;
    }
}
