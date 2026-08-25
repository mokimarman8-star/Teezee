package com.cloud.tmc.miniapp.utils.toast;

import android.app.Application;
import android.content.res.Resources;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniapp.utils.toast.config.IToastInterceptor;
import com.cloud.tmc.miniapp.utils.toast.config.IToastStrategy;
import com.cloud.tmc.miniapp.utils.toast.config.IToastStyle;
import com.cloud.tmc.miniapp.utils.toast.config.ToastType;
import com.cloud.tmc.miniapp.utils.toast.style.AddHomeSuccessToastStyle;
import com.cloud.tmc.miniapp.utils.toast.style.BlackToastStyle;
import com.cloud.tmc.miniapp.utils.toast.style.StateToastStyle;
import com.cloud.tmc.miniutils.util.StringUtils;
import com.cloud.tmc.offline.download.model.TaskResultKt;
import java.io.File;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class ToastUtils {
    public static final ToastUtils INSTANCE = new ToastUtils();
    private static final String TAG = "ToastUtils";
    private static Application sApplication;
    private static WeakReference<ToastParams> sTempToastParams;
    private static IToastInterceptor sToastInterceptor;
    private static IToastStrategy sToastStrategy;
    private static IToastStyle<?> sToastStyle;

    private ToastUtils() {
    }

    @JvmStatic
    public static final void cancel() {
        hideToast();
        hideLoading();
    }

    @JvmStatic
    public static final void hideLoading() {
        ToastParams toastParams;
        IToastStrategy strategy;
        WeakReference<ToastParams> weakReference = sTempToastParams;
        if (weakReference == null || (toastParams = weakReference.get()) == null) {
            return;
        }
        IToastStyle<?> style = toastParams.getStyle();
        if (!Intrinsics.c(style != null ? style.getToastType() : null, ToastType.LOADING.INSTANCE) || (strategy = toastParams.getStrategy()) == null) {
            return;
        }
        strategy.cancelToast();
    }

    @JvmStatic
    public static final void hideToast() {
        ToastParams toastParams;
        IToastStrategy strategy;
        WeakReference<ToastParams> weakReference = sTempToastParams;
        if (weakReference == null || (toastParams = weakReference.get()) == null) {
            return;
        }
        IToastStyle<?> style = toastParams.getStyle();
        if (Intrinsics.c(style != null ? style.getToastType() : null, ToastType.LOADING.INSTANCE) || (strategy = toastParams.getStrategy()) == null) {
            return;
        }
        strategy.cancelToast();
    }

    @JvmStatic
    @JvmOverloads
    public static final void init(Application application) {
        Intrinsics.h(application, "application");
        init$default(application, null, null, 6, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void init(Application application, IToastStrategy iToastStrategy) {
        Intrinsics.h(application, "application");
        init$default(application, iToastStrategy, null, 4, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void init(Application application, IToastStrategy iToastStrategy, IToastStyle<?> iToastStyle) {
        Intrinsics.h(application, "application");
        sApplication = application;
        if (iToastStrategy == null) {
            iToastStrategy = new ToastStrategy(0, 1, null);
        }
        setStrategy(iToastStrategy);
        if (iToastStyle == null) {
            iToastStyle = new BlackToastStyle();
        }
        setStyle(iToastStyle);
    }

    public static /* synthetic */ void init$default(Application application, IToastStrategy iToastStrategy, IToastStyle iToastStyle, int i, Object obj) {
        if ((i & 2) != 0) {
            iToastStrategy = null;
        }
        if ((i & 4) != 0) {
            iToastStyle = null;
        }
        init(application, iToastStrategy, iToastStyle);
    }

    public static final boolean isInit() {
        return (sApplication == null || sToastStrategy == null || sToastStyle == null) ? false : true;
    }

    @JvmStatic
    public static /* synthetic */ void isInit$annotations() {
    }

    @JvmStatic
    public static final void setInterceptor(IToastInterceptor iToastInterceptor) {
        Intrinsics.h(iToastInterceptor, "interceptor");
        sToastInterceptor = iToastInterceptor;
    }

    @JvmStatic
    public static final void setStrategy(IToastStrategy iToastStrategy) {
        Intrinsics.h(iToastStrategy, "strategy");
        iToastStrategy.registerStrategy(sApplication);
        sToastStrategy = iToastStrategy;
    }

    @JvmStatic
    public static final void setStyle(IToastStyle<?> iToastStyle) {
        Intrinsics.h(iToastStyle, "style");
        sToastStyle = iToastStyle;
    }

    @JvmStatic
    @JvmOverloads
    public static final void showAddhomeSuccessToast() {
        String string = StringUtils.getString(R.string.mini_add_home_successful_toast);
        Intrinsics.g(string, "getString(R.string.mini_add_home_successful_toast)");
        showToast(new ToastParams(string, 0, 0L, false, null, 0, new AddHomeSuccessToastStyle(), null, null, null, 958, null));
    }

    @JvmStatic
    @JvmOverloads
    public static final void showLoading(CharSequence charSequence) {
        Intrinsics.h(charSequence, "text");
        showLoading$default(charSequence, null, 0, 0L, false, null, null, 126, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void showLoading(CharSequence charSequence, ToastType toastType) {
        Intrinsics.h(charSequence, "text");
        Intrinsics.h(toastType, NativeComponentConstants.KEY_COMPONENT_TYPE);
        showLoading$default(charSequence, toastType, 0, 0L, false, null, null, 124, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void showLoading(CharSequence charSequence, ToastType toastType, int i) {
        Intrinsics.h(charSequence, "text");
        Intrinsics.h(toastType, NativeComponentConstants.KEY_COMPONENT_TYPE);
        showLoading$default(charSequence, toastType, i, 0L, false, null, null, 120, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void showLoading(CharSequence charSequence, ToastType toastType, int i, long j) {
        Intrinsics.h(charSequence, "text");
        Intrinsics.h(toastType, NativeComponentConstants.KEY_COMPONENT_TYPE);
        showLoading$default(charSequence, toastType, i, j, false, null, null, TaskResultKt.ERROR_LOAD_REQUEST_FAIL, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void showLoading(CharSequence charSequence, ToastType toastType, int i, long j, boolean z) {
        Intrinsics.h(charSequence, "text");
        Intrinsics.h(toastType, NativeComponentConstants.KEY_COMPONENT_TYPE);
        showLoading$default(charSequence, toastType, i, j, z, null, null, 96, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void showLoading(CharSequence charSequence, ToastType toastType, int i, long j, boolean z, File file) {
        Intrinsics.h(charSequence, "text");
        Intrinsics.h(toastType, NativeComponentConstants.KEY_COMPONENT_TYPE);
        showLoading$default(charSequence, toastType, i, j, z, file, null, 64, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void showLoading(CharSequence charSequence, ToastType toastType, int i, long j, boolean z, File file, Function0<Unit> function0) {
        Intrinsics.h(charSequence, "text");
        Intrinsics.h(toastType, NativeComponentConstants.KEY_COMPONENT_TYPE);
        showToast(new ToastParams(charSequence, i, j, z, file, 0, new StateToastStyle(toastType, false, 2, null), null, null, function0, 416, null));
    }

    public static /* synthetic */ void showLoading$default(CharSequence charSequence, ToastType toastType, int i, long j, boolean z, File file, Function0 function0, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            toastType = ToastType.LOADING.INSTANCE;
        }
        int i3 = (i2 & 4) != 0 ? 0 : i;
        if ((i2 & 8) != 0) {
            j = 0;
        }
        showLoading(charSequence, toastType, i3, j, (i2 & 16) == 0 ? z : false, (i2 & 32) != 0 ? null : file, (i2 & 64) != 0 ? null : function0);
    }

    @JvmStatic
    @JvmOverloads
    public static final void showToast(int i) {
        showToast$default(i, 0, 0L, false, 14, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void showToast(int i, int i2) {
        showToast$default(i, i2, 0L, false, 12, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void showToast(int i, int i2, long j) {
        showToast$default(i, i2, j, false, 8, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void showToast(int i, int i2, long j, boolean z) {
        showToast$default(INSTANCE.stringIdToCharSequence(i), i2, j, z, null, 16, null);
    }

    @JvmStatic
    public static final void showToast(ToastParams toastParams) {
        Intrinsics.h(toastParams, "params");
        if (!isInit()) {
            TmcLogger.d(TAG, "It's not init");
            return;
        }
        if (toastParams.getText().length() == 0) {
            TmcLogger.d(TAG, "It's empty");
            return;
        }
        int i = 1;
        if (toastParams.getStrategy() == null) {
            IToastStrategy iToastStrategy = sToastStrategy;
            if (iToastStrategy == null) {
                iToastStrategy = new ToastStrategy(r1, i, null);
                setStrategy(iToastStrategy);
            }
            toastParams.setStrategy(iToastStrategy);
        }
        if (toastParams.getStyle() == null) {
            IToastStyle<?> iToastStyle = sToastStyle;
            if (iToastStyle == null) {
                iToastStyle = new BlackToastStyle();
                setStyle(iToastStyle);
            }
            toastParams.setStyle(iToastStyle);
        }
        if (toastParams.getInterceptor() == null) {
            IToastInterceptor iToastInterceptor = sToastInterceptor;
            if (iToastInterceptor == null) {
                iToastInterceptor = new ToastLogInterceptor();
                setInterceptor(iToastInterceptor);
            }
            toastParams.setInterceptor(iToastInterceptor);
        }
        IToastInterceptor interceptor = toastParams.getInterceptor();
        if (interceptor == null || !interceptor.intercept(toastParams)) {
            if (toastParams.getDuration() == -1) {
                toastParams.setDuration(toastParams.getText().length() > 20 ? 1 : 0);
            }
            sTempToastParams = new WeakReference<>(toastParams);
            IToastStrategy strategy = toastParams.getStrategy();
            if (strategy != null) {
                strategy.showToast(toastParams);
            }
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void showToast(CharSequence charSequence) {
        Intrinsics.h(charSequence, "text");
        showToast$default(charSequence, 0, 0L, false, null, 30, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void showToast(CharSequence charSequence, int i) {
        Intrinsics.h(charSequence, "text");
        showToast$default(charSequence, i, 0L, false, null, 28, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void showToast(CharSequence charSequence, int i, long j) {
        Intrinsics.h(charSequence, "text");
        showToast$default(charSequence, i, j, false, null, 24, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void showToast(CharSequence charSequence, int i, long j, boolean z) {
        Intrinsics.h(charSequence, "text");
        showToast$default(charSequence, i, j, z, null, 16, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void showToast(CharSequence charSequence, int i, long j, boolean z, Function0<Unit> function0) {
        Intrinsics.h(charSequence, "text");
        showToast(new ToastParams(charSequence, i, j, z, null, 0, null, null, null, function0, 496, null));
    }

    public static /* synthetic */ void showToast$default(int i, int i2, long j, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            j = 0;
        }
        if ((i3 & 8) != 0) {
            z = false;
        }
        showToast(i, i2, j, z);
    }

    public static /* synthetic */ void showToast$default(CharSequence charSequence, int i, long j, boolean z, Function0 function0, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            j = 0;
        }
        if ((i2 & 8) != 0) {
            z = false;
        }
        if ((i2 & 16) != 0) {
            function0 = null;
        }
        showToast(charSequence, i, j, z, function0);
    }

    @JvmStatic
    @JvmOverloads
    public static final void showToastLong(int i) {
        showToastLong$default(i, 0L, 2, (Object) null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void showToastLong(int i, long j) {
        showToastLong(INSTANCE.stringIdToCharSequence(i), j);
    }

    @JvmStatic
    @JvmOverloads
    public static final void showToastLong(CharSequence charSequence) {
        Intrinsics.h(charSequence, "text");
        showToastLong$default(charSequence, 0L, 2, (Object) null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void showToastLong(CharSequence charSequence, long j) {
        Intrinsics.h(charSequence, "text");
        showToast$default(charSequence, 1, j, false, null, 24, null);
    }

    public static /* synthetic */ void showToastLong$default(int i, long j, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = 0;
        }
        showToastLong(i, j);
    }

    public static /* synthetic */ void showToastLong$default(CharSequence charSequence, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        showToastLong(charSequence, j);
    }

    @JvmStatic
    @JvmOverloads
    public static final void showToastShort(int i) {
        showToastShort$default(i, 0L, 2, (Object) null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void showToastShort(int i, long j) {
        showToastShort(INSTANCE.stringIdToCharSequence(i), j);
    }

    @JvmStatic
    @JvmOverloads
    public static final void showToastShort(CharSequence charSequence) {
        Intrinsics.h(charSequence, "text");
        showToastShort$default(charSequence, 0L, 2, (Object) null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void showToastShort(CharSequence charSequence, long j) {
        Intrinsics.h(charSequence, "text");
        showToast$default(charSequence, 0, j, false, null, 24, null);
    }

    public static /* synthetic */ void showToastShort$default(int i, long j, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = 0;
        }
        showToastShort(i, j);
    }

    public static /* synthetic */ void showToastShort$default(CharSequence charSequence, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        showToastShort(charSequence, j);
    }

    private final CharSequence stringIdToCharSequence(int i) {
        Resources resources;
        try {
            Application application = sApplication;
            if (application != null && (resources = application.getResources()) != null) {
                CharSequence text = resources.getText(i);
                if (text != null) {
                    return text;
                }
            }
            return "";
        } catch (Resources.NotFoundException unused) {
            return String.valueOf(i);
        }
    }
}
