package com.cloud.tmc.miniutils.util;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import com.cloud.tmc.miniutils.constant.MemoryConstants;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class BarUtils {
    private static final int KEY_OFFSET = -123;
    private static final String TAG_OFFSET = "TAG_OFFSET";
    private static final String TAG_STATUS_BAR = "TAG_STATUS_BAR";

    private BarUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void addMarginTopEqualStatusBarHeight(@NonNull View view) {
        view.setTag(TAG_OFFSET);
        Object tag = view.getTag(KEY_OFFSET);
        if (tag == null || !((Boolean) tag).booleanValue()) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin + getStatusBarHeight(), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            view.setTag(KEY_OFFSET, Boolean.TRUE);
        }
    }

    private static void addMarginTopEqualStatusBarHeight(@NonNull Window window) {
        View findViewWithTag = window.getDecorView().findViewWithTag(TAG_OFFSET);
        if (findViewWithTag == null) {
            return;
        }
        addMarginTopEqualStatusBarHeight(findViewWithTag);
    }

    private static View applyStatusBarColor(@NonNull Activity activity, int i, boolean z) {
        return applyStatusBarColor(activity.getWindow(), i, z);
    }

    private static View applyStatusBarColor(@NonNull Window window, int i, boolean z) {
        ViewGroup viewGroup = z ? (ViewGroup) window.getDecorView() : (ViewGroup) window.findViewById(R.id.content);
        View findViewWithTag = viewGroup.findViewWithTag(TAG_STATUS_BAR);
        if (findViewWithTag == null) {
            View createStatusBarView = createStatusBarView(window.getContext(), i);
            viewGroup.addView(createStatusBarView);
            return createStatusBarView;
        }
        if (findViewWithTag.getVisibility() == 8) {
            findViewWithTag.setVisibility(0);
        }
        findViewWithTag.setBackgroundColor(i);
        return findViewWithTag;
    }

    private static View createStatusBarView(@NonNull Context context, int i) {
        View view = new View(context);
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, getStatusBarHeight()));
        view.setBackgroundColor(i);
        view.setTag(TAG_STATUS_BAR);
        return view;
    }

    public static int getActionBarHeight() {
        TypedValue typedValue = new TypedValue();
        if (Utils.getApp().getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true)) {
            return TypedValue.complexToDimensionPixelSize(typedValue.data, Utils.getApp().getResources().getDisplayMetrics());
        }
        return 0;
    }

    public static int getNavBarColor(@NonNull Activity activity) {
        return getNavBarColor(activity.getWindow());
    }

    public static int getNavBarColor(@NonNull Window window) {
        return window.getNavigationBarColor();
    }

    public static int getNavBarHeight() {
        Resources resources = Utils.getApp().getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier != 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private static String getResNameById(int i) {
        try {
            return Utils.getApp().getResources().getResourceEntryName(i);
        } catch (Exception unused) {
            return "";
        }
    }

    public static int getStatusBarHeight() {
        Resources resources = Utils.getApp().getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
    }

    private static void hideStatusBarView(@NonNull Activity activity) {
        hideStatusBarView(activity.getWindow());
    }

    private static void hideStatusBarView(@NonNull Window window) {
        View findViewWithTag = ((ViewGroup) window.getDecorView()).findViewWithTag(TAG_STATUS_BAR);
        if (findViewWithTag == null) {
            return;
        }
        findViewWithTag.setVisibility(8);
    }

    public static boolean isNavBarLightMode(@NonNull Activity activity) {
        return isNavBarLightMode(activity.getWindow());
    }

    public static boolean isNavBarLightMode(@NonNull Window window) {
        return Build.VERSION.SDK_INT >= 26 && (window.getDecorView().getSystemUiVisibility() & 16) != 0;
    }

    public static boolean isNavBarVisible(@NonNull Activity activity) {
        return isNavBarVisible(activity.getWindow());
    }

    public static boolean isNavBarVisible(@NonNull Window window) {
        boolean z;
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        int childCount = viewGroup.getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                z = false;
                break;
            }
            View childAt = viewGroup.getChildAt(i);
            int id = childAt.getId();
            if (id != -1 && "navigationBarBackground".equals(getResNameById(id)) && childAt.getVisibility() == 0) {
                z = true;
                break;
            }
            i++;
        }
        if (z) {
            return (viewGroup.getSystemUiVisibility() & 2) == 0;
        }
        return z;
    }

    public static boolean isStatusBarLightMode(@NonNull Activity activity) {
        return isStatusBarLightMode(activity.getWindow());
    }

    public static boolean isStatusBarLightMode(@NonNull Window window) {
        return (window.getDecorView().getSystemUiVisibility() & 8192) != 0;
    }

    public static boolean isStatusBarVisible(@NonNull Activity activity) {
        return (activity.getWindow().getAttributes().flags & MemoryConstants.KB) == 0;
    }

    public static boolean isSupportNavBar() {
        WindowManager windowManager = (WindowManager) Utils.getApp().getSystemService("window");
        if (windowManager == null) {
            return false;
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        Point point = new Point();
        Point point2 = new Point();
        defaultDisplay.getSize(point);
        defaultDisplay.getRealSize(point2);
        return (point2.y == point.y && point2.x == point.x) ? false : true;
    }

    public static void setNavBarColor(@NonNull Activity activity, int i) {
        setNavBarColor(activity.getWindow(), i);
    }

    public static void setNavBarColor(@NonNull Window window, int i) {
        window.addFlags(Integer.MIN_VALUE);
        window.setNavigationBarColor(i);
    }

    public static void setNavBarLightMode(@NonNull Activity activity, boolean z) {
        setNavBarLightMode(activity.getWindow(), z);
    }

    public static void setNavBarLightMode(@NonNull Window window, boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z ? systemUiVisibility | 16 : systemUiVisibility & (-17));
        }
    }

    public static void setNavBarVisibility(@NonNull Activity activity, boolean z) {
        setNavBarVisibility(activity.getWindow(), z);
    }

    public static void setNavBarVisibility(@NonNull Window window, boolean z) {
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            int id = childAt.getId();
            if (id != -1 && "navigationBarBackground".equals(getResNameById(id))) {
                childAt.setVisibility(z ? 0 : 4);
            }
        }
        if (z) {
            viewGroup.setSystemUiVisibility(viewGroup.getSystemUiVisibility() & (-4611));
        } else {
            viewGroup.setSystemUiVisibility(viewGroup.getSystemUiVisibility() | 4610);
        }
    }

    public static View setStatusBarColor(@NonNull Activity activity, int i) {
        return setStatusBarColor(activity, i, false);
    }

    public static View setStatusBarColor(@NonNull Activity activity, int i, boolean z) {
        transparentStatusBar(activity);
        return applyStatusBarColor(activity, i, z);
    }

    public static View setStatusBarColor(@NonNull Window window, int i) {
        return setStatusBarColor(window, i, false);
    }

    public static View setStatusBarColor(@NonNull Window window, int i, boolean z) {
        transparentStatusBar(window);
        return applyStatusBarColor(window, i, z);
    }

    public static void setStatusBarColor(@NonNull View view, int i) {
        Activity activityByContext = UtilsBridge.getActivityByContext(view.getContext());
        if (activityByContext == null) {
            return;
        }
        transparentStatusBar(activityByContext);
        view.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = getStatusBarHeight();
        view.setBackgroundColor(i);
    }

    public static void setStatusBarColor4Drawer(@NonNull DrawerLayout drawerLayout, @NonNull View view, int i) {
        setStatusBarColor4Drawer(drawerLayout, view, i, false);
    }

    public static void setStatusBarColor4Drawer(@NonNull DrawerLayout drawerLayout, @NonNull View view, int i, boolean z) {
        Activity activityByContext = UtilsBridge.getActivityByContext(view.getContext());
        if (activityByContext == null) {
            return;
        }
        transparentStatusBar(activityByContext);
        drawerLayout.setFitsSystemWindows(false);
        setStatusBarColor(view, i);
        int childCount = drawerLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            drawerLayout.getChildAt(i2).setFitsSystemWindows(false);
        }
        if (z) {
            hideStatusBarView(activityByContext);
        } else {
            setStatusBarColor(activityByContext, i, false);
        }
    }

    public static void setStatusBarCustom(@NonNull View view) {
        Activity activityByContext = UtilsBridge.getActivityByContext(view.getContext());
        if (activityByContext == null) {
            return;
        }
        transparentStatusBar(activityByContext);
        view.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, getStatusBarHeight()));
        } else {
            layoutParams.width = -1;
            layoutParams.height = getStatusBarHeight();
        }
    }

    public static void setStatusBarLightMode(@NonNull Activity activity, boolean z) {
        setStatusBarLightMode(activity.getWindow(), z);
    }

    public static void setStatusBarLightMode(@NonNull Window window, boolean z) {
        View decorView = window.getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        decorView.setSystemUiVisibility(z ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
    }

    public static void setStatusBarVisibility(@NonNull Activity activity, boolean z) {
        setStatusBarVisibility(activity.getWindow(), z);
    }

    public static void setStatusBarVisibility(@NonNull Window window, boolean z) {
        if (z) {
            window.clearFlags(MemoryConstants.KB);
            showStatusBarView(window);
            addMarginTopEqualStatusBarHeight(window);
        } else {
            window.addFlags(MemoryConstants.KB);
            hideStatusBarView(window);
            subtractMarginTopEqualStatusBarHeight(window);
        }
    }

    private static void showStatusBarView(@NonNull Window window) {
        View findViewWithTag = ((ViewGroup) window.getDecorView()).findViewWithTag(TAG_STATUS_BAR);
        if (findViewWithTag == null) {
            return;
        }
        findViewWithTag.setVisibility(0);
    }

    public static void subtractMarginTopEqualStatusBarHeight(@NonNull View view) {
        Object tag = view.getTag(KEY_OFFSET);
        if (tag == null || !((Boolean) tag).booleanValue()) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin - getStatusBarHeight(), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        view.setTag(KEY_OFFSET, Boolean.FALSE);
    }

    private static void subtractMarginTopEqualStatusBarHeight(@NonNull Window window) {
        View findViewWithTag = window.getDecorView().findViewWithTag(TAG_OFFSET);
        if (findViewWithTag == null) {
            return;
        }
        subtractMarginTopEqualStatusBarHeight(findViewWithTag);
    }

    public static void transparentStatusBar(@NonNull Activity activity) {
        transparentStatusBar(activity.getWindow());
    }

    public static void transparentStatusBar(@NonNull Window window) {
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 1280);
        window.setStatusBarColor(0);
    }
}
