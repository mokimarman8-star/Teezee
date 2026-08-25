package com.cloud.tmc.miniapp.action;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.b;
import com.cloud.tmc.integration.activity.LoadStepAction;
import com.cloud.tmc.integration.proxy.AnimtionProxy;
import com.cloud.tmc.integration.utils.ext.CommonExtKt;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniapp.ui.extension.OfflineAppExtensionKt;
import com.cloud.tmc.miniapp.widget.LoadingTextView;
import com.cloud.tmc.miniapp.widget.MiniNoNetworkView;
import com.cloud.tmc.miniapp.widget.StatusLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface StatusAction {

    public static final class DefaultImpls {
        public static boolean isLoadStatusLoadingOrError(StatusAction statusAction) {
            StatusLayout statusLayout = statusAction.getStatusLayout();
            if (statusLayout != null) {
                return statusLayout.OooO0OO();
            }
            return true;
        }

        public static void setLoadingProgressConfig(StatusAction statusAction, LoadingTextView.LoadingAnimationModel loadingAnimationModel) {
            Intrinsics.h(loadingAnimationModel, "progressConfig");
            StatusLayout statusLayout = statusAction.getStatusLayout();
            if (statusLayout != null) {
                statusLayout.setLoadingProgressConfig(loadingAnimationModel);
            }
        }

        public static boolean showComplete(StatusAction statusAction) {
            StatusLayout statusLayout = statusAction.getStatusLayout();
            if (statusLayout == null) {
                return true;
            }
            if (!statusLayout.OooO0OO()) {
                return false;
            }
            statusLayout.OooO00o();
            statusLayout.OooO0O0();
            return true;
        }

        public static void showCustomErrorLayout(StatusAction statusAction, String str, String str2, String str3, StatusLayout.OooO0O0 oooO0O0, String str4, StatusLayout.OooO00o oooO00o) {
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            Bundle bundle = new Bundle();
            bundle.putInt(NativeComponentConstants.KEY_COMPONENT_TYPE, 2);
            Unit unit = Unit.a;
            performanceAnalyseProxy.recordForCommon(str4, TmcConstants.REPORTER_NO_NET_WORK_PAGE, bundle);
            StatusLayout statusLayout = statusAction.getStatusLayout();
            if (statusLayout != null) {
                statusLayout.OooO00o();
                statusLayout.OooO0O0(statusAction.getViewThemeMode());
                statusLayout.OooOOOo = true;
                ConstraintLayout constraintLayout = statusLayout.OooO0oO;
                if (constraintLayout != null) {
                    constraintLayout.setVisibility(8);
                }
                LinearLayout linearLayout = statusLayout.OooO0o;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                try {
                    LoadingTextView loadingTextView = statusLayout.OooO0oo;
                    if (loadingTextView != null) {
                        loadingTextView.OooO00o();
                    }
                    MiniNoNetworkView miniNoNetworkView = statusLayout.OooOOO0;
                    if (miniNoNetworkView != null) {
                        miniNoNetworkView.OooO00o(str, str2, str3);
                    }
                } catch (Throwable th) {
                    TmcLogger.e("launcher step error", th);
                }
                statusLayout.setOnCustomNoNetWorkRetryListener(oooO0O0);
            }
        }

        public static void showError(StatusAction statusAction, StatusLayout.OooO0O0 oooO0O0, int i, String str, String str2, StatusLayout.OooO00o oooO00o) {
            Integer viewThemeMode = statusAction.getViewThemeMode();
            statusAction.showErrorLayout((viewThemeMode != null && viewThemeMode.intValue() == 2) ? R.drawable.mini_ic_error_normal_mode : R.drawable.mini_ic_error, i, oooO0O0, str, oooO00o);
        }

        public static /* synthetic */ void showError$default(StatusAction statusAction, StatusLayout.OooO0O0 oooO0O0, int i, String str, String str2, StatusLayout.OooO00o oooO00o, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showError");
            }
            if ((i2 & 2) != 0) {
                i = R.string.loading_error_tv;
            }
            int i3 = i;
            if ((i2 & 4) != 0) {
                str = "";
            }
            String str3 = str;
            if ((i2 & 16) != 0) {
                oooO00o = null;
            }
            statusAction.showError(oooO0O0, i3, str3, str2, oooO00o);
        }

        public static void showErrorLayout(StatusAction statusAction, int i, int i2, int i3, StatusLayout.OooO0O0 oooO0O0, boolean z, boolean z2, StatusLayout.OooO00o oooO00o) {
            StatusLayout statusLayout = statusAction.getStatusLayout();
            if (statusLayout != null) {
                showErrorLayout$default(statusAction, b.getDrawable(statusLayout.getContext(), i), statusLayout.getContext().getString(i2), statusLayout.getContext().getString(i3), oooO0O0, null, z, z2, oooO00o, 16, null);
            }
        }

        public static void showErrorLayout(StatusAction statusAction, int i, int i2, StatusLayout.OooO0O0 oooO0O0, String str, StatusLayout.OooO00o oooO00o) {
            StatusLayout statusLayout = statusAction.getStatusLayout();
            if (statusLayout != null) {
                statusAction.showErrorLayout(b.getDrawable(statusLayout.getContext(), i), statusLayout.getContext().getString(i2), oooO0O0, str, oooO00o);
            }
        }

        public static void showErrorLayout(StatusAction statusAction, Drawable drawable, CharSequence charSequence, StatusLayout.OooO0O0 oooO0O0, String str, StatusLayout.OooO00o oooO00o) {
            if (statusAction.getStatusLayout() != null) {
                showErrorLayout$default(statusAction, drawable, charSequence, null, oooO0O0, str, false, false, oooO00o, 96, null);
            }
        }

        public static void showErrorLayout(StatusAction statusAction, Drawable drawable, CharSequence charSequence, CharSequence charSequence2, StatusLayout.OooO0O0 oooO0O0, String str, boolean z, boolean z2, StatusLayout.OooO00o oooO00o) {
            StatusLayout statusLayout = statusAction.getStatusLayout();
            if (statusLayout != null) {
                statusLayout.OooO00o();
                statusLayout.OooO0O0(statusAction.getViewThemeMode());
                statusLayout.OooO00o(str, z, z2);
                statusLayout.setIcon(drawable);
                statusLayout.setHint(charSequence);
                statusLayout.setTitle(charSequence2);
                statusLayout.setOnRetryListener(oooO0O0);
            }
        }

        public static /* synthetic */ void showErrorLayout$default(StatusAction statusAction, int i, int i2, int i3, StatusLayout.OooO0O0 oooO0O0, boolean z, boolean z2, StatusLayout.OooO00o oooO00o, int i4, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showErrorLayout");
            }
            statusAction.showErrorLayout(i, i2, i3, oooO0O0, (i4 & 16) != 0 ? true : z, (i4 & 32) != 0 ? false : z2, (i4 & 64) != 0 ? null : oooO00o);
        }

        public static /* synthetic */ void showErrorLayout$default(StatusAction statusAction, int i, int i2, StatusLayout.OooO0O0 oooO0O0, String str, StatusLayout.OooO00o oooO00o, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showErrorLayout");
            }
            if ((i3 & 8) != 0) {
                str = "";
            }
            String str2 = str;
            if ((i3 & 16) != 0) {
                oooO00o = null;
            }
            statusAction.showErrorLayout(i, i2, oooO0O0, str2, oooO00o);
        }

        public static /* synthetic */ void showErrorLayout$default(StatusAction statusAction, Drawable drawable, CharSequence charSequence, StatusLayout.OooO0O0 oooO0O0, String str, StatusLayout.OooO00o oooO00o, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showErrorLayout");
            }
            if ((i & 8) != 0) {
                str = "";
            }
            String str2 = str;
            if ((i & 16) != 0) {
                oooO00o = null;
            }
            statusAction.showErrorLayout(drawable, charSequence, oooO0O0, str2, oooO00o);
        }

        public static /* synthetic */ void showErrorLayout$default(StatusAction statusAction, Drawable drawable, CharSequence charSequence, CharSequence charSequence2, StatusLayout.OooO0O0 oooO0O0, String str, boolean z, boolean z2, StatusLayout.OooO00o oooO00o, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showErrorLayout");
            }
            statusAction.showErrorLayout(drawable, charSequence, charSequence2, oooO0O0, (i & 16) != 0 ? "" : str, (i & 32) != 0 ? false : z, (i & 64) != 0 ? false : z2, (i & 128) != 0 ? null : oooO00o);
        }

        public static void showLoading(StatusAction statusAction) {
            StatusLayout statusLayout = statusAction.getStatusLayout();
            if (statusLayout != null) {
                statusLayout.OooO0O0(statusAction.getViewThemeMode());
                statusLayout.OooO0Oo();
                statusLayout.setOnRetryListener(null);
            }
        }

        /* JADX WARN: Type inference failed for: r7v2, types: [android.view.View, com.cloud.tmc.miniapp.widget.MiniappLaunchLoadingView] */
        public static void showLoadingLogo(StatusAction statusAction, String str, String str2) {
            String str3;
            int i;
            Integer num;
            int i2;
            TextView textView;
            Intrinsics.h(str, "appName");
            Intrinsics.h(str2, "logo");
            StatusLayout statusLayout = statusAction.getStatusLayout();
            if (statusLayout != null) {
                Intrinsics.h(str2, "logo");
                Intrinsics.h(str, "appName");
                try {
                    str3 = statusLayout.getContext().getString(R.string.dialog_loading_tv);
                } catch (Throwable unused) {
                    str3 = "Loading...";
                }
                Intrinsics.g(str3, "try {\n            contex…   \"Loading...\"\n        }");
                if (!Intrinsics.c(str, str3) && (textView = statusLayout.OooO) != null) {
                    textView.setText(str);
                }
                ?? r72 = statusLayout.OooOO0;
                if (r72 != 0) {
                    Intrinsics.h(str2, "logo");
                    try {
                        AppCompatImageView appCompatImageView = r72.OooO00o;
                        if (appCompatImageView == null) {
                            Intrinsics.y("mLoadingImg");
                            appCompatImageView = null;
                        }
                        AppCompatImageView appCompatImageView2 = appCompatImageView;
                        if (((AnimtionProxy) TmcProxy.get(AnimtionProxy.class)).enableLoadingAnimation() && !r72.OooO0o) {
                            r72.OooO0oO = true;
                            r72.OooO00o();
                        }
                        if (str2.length() == 0) {
                            return;
                        }
                        ImageLoaderProxy imageLoaderProxy = (ImageLoaderProxy) TmcProxy.get(ImageLoaderProxy.class);
                        Context context = r72.getContext();
                        int dp2px = CommonExtKt.getDp2px(14);
                        Integer num2 = r72.OooO0OO;
                        if (num2 != null && num2.intValue() == 2) {
                            i = R.drawable.drawable_app_icon_place_holder_normal_mode;
                            int i3 = i;
                            num = r72.OooO0OO;
                            if (num != null && num.intValue() == 2) {
                                i2 = R.drawable.drawable_app_icon_place_holder_normal_mode;
                                imageLoaderProxy.loadImgRoundCorners(context, str2, appCompatImageView2, dp2px, i3, i2);
                            }
                            i2 = R.drawable.drawable_app_icon_place_holder;
                            imageLoaderProxy.loadImgRoundCorners(context, str2, appCompatImageView2, dp2px, i3, i2);
                        }
                        i = R.drawable.drawable_app_icon_place_holder;
                        int i32 = i;
                        num = r72.OooO0OO;
                        if (num != null) {
                            i2 = R.drawable.drawable_app_icon_place_holder_normal_mode;
                            imageLoaderProxy.loadImgRoundCorners(context, str2, appCompatImageView2, dp2px, i32, i2);
                        }
                        i2 = R.drawable.drawable_app_icon_place_holder;
                        imageLoaderProxy.loadImgRoundCorners(context, str2, appCompatImageView2, dp2px, i32, i2);
                    } catch (Throwable th) {
                        TmcLogger.e(r72.OooO0Oo, th);
                    }
                }
            }
        }

        public static void showMainLayoutAlpha(StatusAction statusAction, float f) {
            StatusLayout statusLayout = statusAction.getStatusLayout();
            if (statusLayout != null) {
                statusLayout.setMainLayoutAlpha(f);
            }
        }

        public static void showNoNetwork(StatusAction statusAction, StatusLayout.OooO0O0 oooO0O0, int i, String str, String str2, StatusLayout.OooO00o oooO00o) {
            if (statusAction.getStatusLayout() != null) {
                PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
                Bundle bundle = new Bundle();
                bundle.putInt(NativeComponentConstants.KEY_COMPONENT_TYPE, 1);
                Unit unit = Unit.a;
                performanceAnalyseProxy.recordForCommon(str2, TmcConstants.REPORTER_NO_NET_WORK_PAGE, bundle);
                Integer viewThemeMode = statusAction.getViewThemeMode();
                showErrorLayout$default(statusAction, (viewThemeMode != null && viewThemeMode.intValue() == 2) ? R.drawable.mini_ic_no_network_normal_mode : R.drawable.mini_ic_no_network, R.string.mini_no_network_info, R.string.mini_no_network_connection, oooO0O0, false, false, oooO00o, 48, null);
            }
        }

        public static /* synthetic */ void showNoNetwork$default(StatusAction statusAction, StatusLayout.OooO0O0 oooO0O0, int i, String str, String str2, StatusLayout.OooO00o oooO00o, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showNoNetwork");
            }
            if ((i2 & 2) != 0) {
                i = R.string.loading_error_tv;
            }
            int i3 = i;
            if ((i2 & 4) != 0) {
                str = "";
            }
            String str3 = str;
            if ((i2 & 16) != 0) {
                oooO00o = null;
            }
            statusAction.showNoNetwork(oooO0O0, i3, str3, str2, oooO00o);
        }

        public static void showPhotoEmpty(StatusAction statusAction, int i, int i2, StatusLayout.OooO0O0 oooO0O0) {
            StatusLayout statusLayout = statusAction.getStatusLayout();
            if (statusLayout != null) {
                showErrorLayout$default(statusAction, b.getDrawable(statusLayout.getContext(), i), statusLayout.getContext().getString(i2), oooO0O0, (String) null, (StatusLayout.OooO00o) null, 24, (Object) null);
                statusLayout.setHintColor(R.color.mini_color_686c73);
            }
        }

        public static void showUnstableNetwork(StatusAction statusAction, StatusLayout.OooO0O0 oooO0O0, int i, String str, String str2, StatusLayout.OooO00o oooO00o) {
            if (statusAction.getStatusLayout() != null) {
                PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
                Bundle bundle = new Bundle();
                bundle.putInt(NativeComponentConstants.KEY_COMPONENT_TYPE, 3);
                Unit unit = Unit.a;
                performanceAnalyseProxy.recordForCommon(str2, TmcConstants.REPORTER_NO_NET_WORK_PAGE, bundle);
                Integer viewThemeMode = statusAction.getViewThemeMode();
                statusAction.showErrorLayout((viewThemeMode != null && viewThemeMode.intValue() == 2) ? R.drawable.mini_ic_unstable_network_normal_mode : R.drawable.mini_ic_unstable_network, R.string.mini_unstable_network_info, R.string.mini_unstable_network, oooO0O0, true, true, oooO00o);
            }
        }

        public static /* synthetic */ void showUnstableNetwork$default(StatusAction statusAction, StatusLayout.OooO0O0 oooO0O0, int i, String str, String str2, StatusLayout.OooO00o oooO00o, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showUnstableNetwork");
            }
            if ((i2 & 2) != 0) {
                i = R.string.loading_error_tv;
            }
            int i3 = i;
            if ((i2 & 4) != 0) {
                str = "";
            }
            String str3 = str;
            if ((i2 & 16) != 0) {
                oooO00o = null;
            }
            statusAction.showUnstableNetwork(oooO0O0, i3, str3, str2, oooO00o);
        }

        public static void statusLayoutCreateShortCutsSuccess(StatusAction statusAction, String str, Function3<? super String, ? super String, ? super String, Unit> function3) {
            Intrinsics.h(str, "appId");
            if (statusAction.getStatusLayout() != null) {
                Intrinsics.h(str, "appId");
            }
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [android.view.View, com.cloud.tmc.miniapp.widget.MiniNoNetworkView] */
        public static void statusLayoutOnResume(StatusAction statusAction) {
            ?? r1;
            StatusLayout statusLayout = statusAction.getStatusLayout();
            if (statusLayout == null || (r1 = statusLayout.OooOOO0) == 0 || r1.getVisibility() != 0) {
                return;
            }
            OfflineAppExtensionKt.offlineAppOnResume((MiniNoNetworkView) r1, r1.getLlOfflineApps());
        }

        public static void updateStepAnimation(StatusAction statusAction, LoadStepAction loadStepAction) {
            Intrinsics.h(loadStepAction, "step");
            StatusLayout statusLayout = statusAction.getStatusLayout();
            if (statusLayout != null) {
                Intrinsics.h(loadStepAction, "step");
                LoadingTextView loadingTextView = statusLayout.OooO0oo;
                if (loadingTextView != null) {
                    loadingTextView.OooO00o(loadStepAction);
                }
            }
        }
    }

    StatusLayout getStatusLayout();

    Integer getViewThemeMode();

    boolean isLoadStatusLoadingOrError();

    void setLoadingProgressConfig(LoadingTextView.LoadingAnimationModel loadingAnimationModel);

    boolean showComplete();

    void showCustomErrorLayout(String str, String str2, String str3, StatusLayout.OooO0O0 oooO0O0, String str4, StatusLayout.OooO00o oooO00o);

    void showError(StatusLayout.OooO0O0 oooO0O0, int i, String str, String str2, StatusLayout.OooO00o oooO00o);

    void showErrorLayout(int i, int i2, int i3, StatusLayout.OooO0O0 oooO0O0, boolean z, boolean z2, StatusLayout.OooO00o oooO00o);

    void showErrorLayout(int i, int i2, StatusLayout.OooO0O0 oooO0O0, String str, StatusLayout.OooO00o oooO00o);

    void showErrorLayout(Drawable drawable, CharSequence charSequence, StatusLayout.OooO0O0 oooO0O0, String str, StatusLayout.OooO00o oooO00o);

    void showErrorLayout(Drawable drawable, CharSequence charSequence, CharSequence charSequence2, StatusLayout.OooO0O0 oooO0O0, String str, boolean z, boolean z2, StatusLayout.OooO00o oooO00o);

    void showLoading();

    void showLoadingLogo(String str, String str2);

    void showMainLayoutAlpha(float f);

    void showNoNetwork(StatusLayout.OooO0O0 oooO0O0, int i, String str, String str2, StatusLayout.OooO00o oooO00o);

    void showPhotoEmpty(int i, int i2, StatusLayout.OooO0O0 oooO0O0);

    void showUnstableNetwork(StatusLayout.OooO0O0 oooO0O0, int i, String str, String str2, StatusLayout.OooO00o oooO00o);

    void statusLayoutCreateShortCutsSuccess(String str, Function3<? super String, ? super String, ? super String, Unit> function3);

    void statusLayoutOnResume();

    void updateStepAnimation(LoadStepAction loadStepAction);
}
