package com.gyf.immersionbar;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentActivity;
import com.gyf.immersionbar.g;
import com.transsion.baselib.report.recent_event.ActionEvent;
import java.util.HashMap;
import java.util.Map;
import org.mvel2.ast.ASTNode;
import z0.b;

@TargetApi(ActionEvent.search_cover_expose)
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class ImmersionBar implements ImmersionCallback {
    private int mActionBarHeight;
    private final Activity mActivity;
    private a mBarConfig;
    private b mBarParams;
    private ViewGroup mContentView;
    private ViewGroup mDecorView;
    private Dialog mDialog;
    private f mFitsKeyboard;
    private int mFitsStatusBarType;
    private Fragment mFragment;
    private boolean mInitialized;
    private boolean mIsActionBarBelowLOLLIPOP;
    private boolean mIsDialog;
    private boolean mIsDialogFragment;
    private boolean mIsFragment;
    private boolean mKeyboardTempEnable;
    private int mNavigationBarHeight;
    private int mNavigationBarWidth;
    private int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private ImmersionBar mParentBar;
    private androidx.fragment.app.Fragment mSupportFragment;
    private final Map<String, b> mTagMap;
    private Window mWindow;

    ImmersionBar(Activity activity) {
        this.mIsFragment = false;
        this.mIsDialogFragment = false;
        this.mIsDialog = false;
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mActionBarHeight = 0;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mFitsStatusBarType = 0;
        this.mInitialized = false;
        this.mIsActionBarBelowLOLLIPOP = false;
        this.mKeyboardTempEnable = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mActivity = activity;
        initCommonParameter(activity.getWindow());
    }

    ImmersionBar(Activity activity, Dialog dialog) {
        this.mIsFragment = false;
        this.mIsDialogFragment = false;
        this.mIsDialog = false;
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mActionBarHeight = 0;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mFitsStatusBarType = 0;
        this.mInitialized = false;
        this.mIsActionBarBelowLOLLIPOP = false;
        this.mKeyboardTempEnable = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mIsDialog = true;
        this.mActivity = activity;
        this.mDialog = dialog;
        checkInitWithActivity();
        initCommonParameter(this.mDialog.getWindow());
    }

    ImmersionBar(DialogFragment dialogFragment) {
        this.mIsFragment = false;
        this.mIsDialogFragment = false;
        this.mIsDialog = false;
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mActionBarHeight = 0;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mFitsStatusBarType = 0;
        this.mInitialized = false;
        this.mIsActionBarBelowLOLLIPOP = false;
        this.mKeyboardTempEnable = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mIsDialog = true;
        this.mIsDialogFragment = true;
        this.mActivity = dialogFragment.getActivity();
        this.mFragment = dialogFragment;
        this.mDialog = dialogFragment.getDialog();
        checkInitWithActivity();
        initCommonParameter(this.mDialog.getWindow());
    }

    ImmersionBar(Fragment fragment) {
        this.mIsFragment = false;
        this.mIsDialogFragment = false;
        this.mIsDialog = false;
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mActionBarHeight = 0;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mFitsStatusBarType = 0;
        this.mInitialized = false;
        this.mIsActionBarBelowLOLLIPOP = false;
        this.mKeyboardTempEnable = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mIsFragment = true;
        Activity activity = fragment.getActivity();
        this.mActivity = activity;
        this.mFragment = fragment;
        checkInitWithActivity();
        initCommonParameter(activity.getWindow());
    }

    ImmersionBar(androidx.fragment.app.DialogFragment dialogFragment) {
        this.mIsFragment = false;
        this.mIsDialogFragment = false;
        this.mIsDialog = false;
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mActionBarHeight = 0;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mFitsStatusBarType = 0;
        this.mInitialized = false;
        this.mIsActionBarBelowLOLLIPOP = false;
        this.mKeyboardTempEnable = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mIsDialog = true;
        this.mIsDialogFragment = true;
        this.mActivity = dialogFragment.getActivity();
        this.mSupportFragment = dialogFragment;
        this.mDialog = dialogFragment.getDialog();
        checkInitWithActivity();
        initCommonParameter(this.mDialog.getWindow());
    }

    ImmersionBar(androidx.fragment.app.Fragment fragment) {
        this.mIsFragment = false;
        this.mIsDialogFragment = false;
        this.mIsDialog = false;
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mActionBarHeight = 0;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mFitsStatusBarType = 0;
        this.mInitialized = false;
        this.mIsActionBarBelowLOLLIPOP = false;
        this.mKeyboardTempEnable = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mIsFragment = true;
        FragmentActivity activity = fragment.getActivity();
        this.mActivity = activity;
        this.mSupportFragment = fragment;
        checkInitWithActivity();
        initCommonParameter(activity.getWindow());
    }

    private void adjustDarkModeParams() {
        b bVar = this.mBarParams;
        int d = b.d(bVar.a, bVar.r, bVar.d);
        b bVar2 = this.mBarParams;
        if (bVar2.m && d != 0) {
            statusBarDarkFont(d > -4539718, bVar2.o);
        }
        b bVar3 = this.mBarParams;
        int d2 = b.d(bVar3.b, bVar3.s, bVar3.f);
        b bVar4 = this.mBarParams;
        if (!bVar4.n || d2 == 0) {
            return;
        }
        navigationBarDarkIcon(d2 > -4539718, bVar4.p);
    }

    private void cancelListener() {
        if (this.mActivity != null) {
            f fVar = this.mFitsKeyboard;
            if (fVar != null) {
                fVar.a();
                this.mFitsKeyboard = null;
            }
            e.b().d(this);
            j.b().d(this.mBarParams.L);
        }
    }

    public static boolean checkFitsSystemWindows(View view) {
        if (view == null) {
            return false;
        }
        if (view.getFitsSystemWindows()) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (((childAt instanceof DrawerLayout) && checkFitsSystemWindows(childAt)) || childAt.getFitsSystemWindows()) {
                    return true;
                }
            }
        }
        return false;
    }

    private void checkInitWithActivity() {
        if (this.mParentBar == null) {
            this.mParentBar = with(this.mActivity);
        }
        ImmersionBar immersionBar = this.mParentBar;
        if (immersionBar == null || immersionBar.mInitialized) {
            return;
        }
        immersionBar.init();
    }

    public static void destroy(@NonNull Activity activity, @NonNull Dialog dialog) {
        getRetriever().b(activity, dialog, false);
    }

    public static void destroy(@NonNull Activity activity, @NonNull Dialog dialog, boolean z) {
        getRetriever().b(activity, dialog, z);
    }

    private void fitsKeyboard() {
        if (!this.mIsFragment) {
            if (this.mBarParams.F) {
                if (this.mFitsKeyboard == null) {
                    this.mFitsKeyboard = new f(this);
                }
                this.mFitsKeyboard.c(this.mBarParams.G);
                return;
            } else {
                f fVar = this.mFitsKeyboard;
                if (fVar != null) {
                    fVar.b();
                    return;
                }
                return;
            }
        }
        ImmersionBar immersionBar = this.mParentBar;
        if (immersionBar != null) {
            if (immersionBar.mBarParams.F) {
                if (immersionBar.mFitsKeyboard == null) {
                    immersionBar.mFitsKeyboard = new f(immersionBar);
                }
                ImmersionBar immersionBar2 = this.mParentBar;
                immersionBar2.mFitsKeyboard.c(immersionBar2.mBarParams.G);
                return;
            }
            f fVar2 = immersionBar.mFitsKeyboard;
            if (fVar2 != null) {
                fVar2.b();
            }
        }
    }

    private void fitsLayoutOverlap() {
        int k = this.mBarParams.B ? this.mBarConfig.k() : 0;
        int i = this.mFitsStatusBarType;
        if (i == 1) {
            setTitleBar(this.mActivity, k, this.mBarParams.z);
        } else if (i == 2) {
            setTitleBarMarginTop(this.mActivity, k, this.mBarParams.z);
        } else {
            if (i != 3) {
                return;
            }
            setStatusBarView(this.mActivity, k, this.mBarParams.A);
        }
    }

    private void fitsNotchScreen() {
        if (Build.VERSION.SDK_INT < 28 || this.mInitialized) {
            return;
        }
        try {
            WindowManager.LayoutParams attributes = this.mWindow.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            this.mWindow.setAttributes(attributes);
        } catch (Exception unused) {
        }
    }

    private void fitsWindows() {
        if (OSUtils.isEMUI3_x()) {
            fitsWindowsBelowLOLLIPOP();
        } else {
            fitsWindowsAboveLOLLIPOP();
        }
        fitsLayoutOverlap();
    }

    private void fitsWindowsAboveLOLLIPOP() {
        if (checkFitsSystemWindows(this.mDecorView.findViewById(R.id.content))) {
            setPadding(0, 0, 0, 0);
            return;
        }
        int k = (this.mBarParams.y && this.mFitsStatusBarType == 4) ? this.mBarConfig.k() : 0;
        if (this.mBarParams.E) {
            k = this.mBarConfig.k() + this.mActionBarHeight;
        }
        setPadding(0, k, 0, 0);
    }

    private void fitsWindowsBelowLOLLIPOP() {
        if (this.mBarParams.E) {
            this.mIsActionBarBelowLOLLIPOP = true;
            this.mContentView.post(this);
        } else {
            this.mIsActionBarBelowLOLLIPOP = false;
            postFitsWindowsBelowLOLLIPOP();
        }
    }

    private void fitsWindowsEMUI() {
        View findViewById = this.mDecorView.findViewById(d.b);
        b bVar = this.mBarParams;
        if (!bVar.H || !bVar.I) {
            e.b().d(this);
            findViewById.setVisibility(8);
        } else if (findViewById != null) {
            e.b().a(this);
            e.b().c(this.mActivity.getApplication());
        }
    }

    private void fitsWindowsKITKAT() {
        int i;
        int i2;
        if (checkFitsSystemWindows(this.mDecorView.findViewById(R.id.content))) {
            setPadding(0, 0, 0, 0);
            return;
        }
        int k = (this.mBarParams.y && this.mFitsStatusBarType == 4) ? this.mBarConfig.k() : 0;
        if (this.mBarParams.E) {
            k = this.mBarConfig.k() + this.mActionBarHeight;
        }
        if (this.mBarConfig.m()) {
            b bVar = this.mBarParams;
            if (bVar.H && bVar.I) {
                if (bVar.h) {
                    i = 0;
                    i2 = 0;
                } else if (this.mBarConfig.n()) {
                    i2 = this.mBarConfig.d();
                    i = 0;
                } else {
                    i = this.mBarConfig.g();
                    i2 = 0;
                }
                if (this.mBarParams.i) {
                    if (this.mBarConfig.n()) {
                        i2 = 0;
                    } else {
                        i = 0;
                    }
                } else if (!this.mBarConfig.n()) {
                    i = this.mBarConfig.g();
                }
                setPadding(0, k, i, i2);
            }
        }
        i = 0;
        i2 = 0;
        setPadding(0, k, i, i2);
    }

    @TargetApi(ActionEvent.delete_comment)
    public static int getActionBarHeight(@NonNull Activity activity) {
        return new a(activity).a();
    }

    @TargetApi(ActionEvent.delete_comment)
    public static int getActionBarHeight(@NonNull Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getActionBarHeight(fragment.getActivity());
    }

    @TargetApi(ActionEvent.delete_comment)
    public static int getActionBarHeight(@NonNull androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getActionBarHeight(fragment.getActivity());
    }

    @TargetApi(ActionEvent.delete_comment)
    public static int getNavigationBarHeight(@NonNull Activity activity) {
        return new a(activity).d();
    }

    @TargetApi(ActionEvent.delete_comment)
    public static int getNavigationBarHeight(@NonNull Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getNavigationBarHeight(fragment.getActivity());
    }

    @TargetApi(ActionEvent.delete_comment)
    public static int getNavigationBarHeight(@NonNull Context context) {
        g.a a = g.a(context);
        if (!a.a || a.b) {
            return a.f(context);
        }
        return 0;
    }

    @TargetApi(ActionEvent.delete_comment)
    public static int getNavigationBarHeight(@NonNull androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getNavigationBarHeight((Activity) fragment.getActivity());
    }

    @TargetApi(ActionEvent.delete_comment)
    public static int getNavigationBarWidth(@NonNull Activity activity) {
        return new a(activity).g();
    }

    @TargetApi(ActionEvent.delete_comment)
    public static int getNavigationBarWidth(@NonNull Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getNavigationBarWidth(fragment.getActivity());
    }

    @TargetApi(ActionEvent.delete_comment)
    public static int getNavigationBarWidth(@NonNull Context context) {
        g.a a = g.a(context);
        if (!a.a || a.b) {
            return a.i(context);
        }
        return 0;
    }

    @TargetApi(ActionEvent.delete_comment)
    public static int getNavigationBarWidth(@NonNull androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getNavigationBarWidth((Activity) fragment.getActivity());
    }

    public static int getNotchHeight(@NonNull Activity activity) {
        return NotchUtils.getNotchHeight(activity);
    }

    public static int getNotchHeight(@NonNull Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getNotchHeight(fragment.getActivity());
    }

    public static int getNotchHeight(@NonNull androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getNotchHeight(fragment.getActivity());
    }

    public static void getNotchHeight(@NonNull Activity activity, k kVar) {
        NotchUtils.getNotchHeight(activity, kVar);
    }

    public static void getNotchHeight(@NonNull Fragment fragment, k kVar) {
        if (fragment.getActivity() == null) {
            return;
        }
        getNotchHeight(fragment.getActivity(), kVar);
    }

    public static void getNotchHeight(@NonNull androidx.fragment.app.Fragment fragment, k kVar) {
        if (fragment.getActivity() == null) {
            return;
        }
        getNotchHeight(fragment.getActivity(), kVar);
    }

    private static q getRetriever() {
        return q.i();
    }

    @TargetApi(ActionEvent.delete_comment)
    public static int getStatusBarHeight(@NonNull Activity activity) {
        return new a(activity).k();
    }

    @TargetApi(ActionEvent.delete_comment)
    public static int getStatusBarHeight(@NonNull Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getStatusBarHeight(fragment.getActivity());
    }

    @TargetApi(ActionEvent.delete_comment)
    public static int getStatusBarHeight(@NonNull Context context) {
        return a.c(context, "status_bar_height");
    }

    @TargetApi(ActionEvent.delete_comment)
    public static int getStatusBarHeight(@NonNull androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getStatusBarHeight((Activity) fragment.getActivity());
    }

    @TargetApi(ActionEvent.delete_comment)
    public static boolean hasNavigationBar(@NonNull Activity activity) {
        return new a(activity).m();
    }

    @TargetApi(ActionEvent.delete_comment)
    public static boolean hasNavigationBar(@NonNull Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return hasNavigationBar(fragment.getActivity());
    }

    @TargetApi(ActionEvent.delete_comment)
    public static boolean hasNavigationBar(@NonNull Context context) {
        return getNavigationBarHeight(context) > 0;
    }

    @TargetApi(ActionEvent.delete_comment)
    public static boolean hasNavigationBar(@NonNull androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return hasNavigationBar((Activity) fragment.getActivity());
    }

    public static boolean hasNotchScreen(@NonNull Activity activity) {
        return NotchUtils.hasNotchScreen(activity);
    }

    public static boolean hasNotchScreen(@NonNull Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return hasNotchScreen(fragment.getActivity());
    }

    public static boolean hasNotchScreen(@NonNull View view) {
        return NotchUtils.hasNotchScreen(view);
    }

    public static boolean hasNotchScreen(@NonNull androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return hasNotchScreen(fragment.getActivity());
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0006, code lost:
    
        r0 = r4.mContentView.getWindowInsetsController();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void hideBarAboveR() {
        /*
            r4 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 30
            if (r0 < r1) goto L57
            android.view.ViewGroup r0 = r4.mContentView
            android.view.WindowInsetsController r0 = com.gyf.immersionbar.i.a(r0)
            if (r0 == 0) goto L57
            int[] r1 = com.gyf.immersionbar.ImmersionBar.a.a
            com.gyf.immersionbar.b r2 = r4.mBarParams
            com.gyf.immersionbar.BarHide r2 = r2.j
            int r2 = r2.ordinal()
            r1 = r1[r2]
            r2 = 1
            r3 = 2
            if (r1 == r2) goto L46
            if (r1 == r3) goto L3e
            r2 = 3
            if (r1 == r2) goto L36
            r2 = 4
            if (r1 == r2) goto L27
            goto L54
        L27:
            int r1 = androidx.core.view.j2.a()
            androidx.core.view.b0.a(r0, r1)
            int r1 = androidx.core.view.k2.a()
            androidx.core.view.b0.a(r0, r1)
            goto L54
        L36:
            int r1 = androidx.core.view.k2.a()
            androidx.core.view.e0.a(r0, r1)
            goto L54
        L3e:
            int r1 = androidx.core.view.j2.a()
            androidx.core.view.e0.a(r0, r1)
            goto L54
        L46:
            int r1 = androidx.core.view.j2.a()
            androidx.core.view.e0.a(r0, r1)
            int r1 = androidx.core.view.k2.a()
            androidx.core.view.e0.a(r0, r1)
        L54:
            androidx.core.view.v2.a(r0, r3)
        L57:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gyf.immersionbar.ImmersionBar.hideBarAboveR():void");
    }

    private int hideBarBelowR(int i) {
        if (Build.VERSION.SDK_INT >= 30) {
            return i;
        }
        int i2 = a.a[this.mBarParams.j.ordinal()];
        if (i2 == 1) {
            i |= 518;
        } else if (i2 == 2) {
            i |= 1028;
        } else if (i2 == 3) {
            i |= 514;
        }
        return i | 4096;
    }

    public static void hideStatusBar(@NonNull Window window) {
        window.setFlags(1024, 1024);
    }

    private int initBarAboveLOLLIPOP(int i) {
        if (!this.mInitialized) {
            this.mBarParams.c = this.mWindow.getNavigationBarColor();
        }
        int i2 = i | 1024;
        b bVar = this.mBarParams;
        if (bVar.h && bVar.H) {
            i2 = i | 1536;
        }
        this.mWindow.clearFlags(ASTNode.ARRAY_TYPE_LITERAL);
        if (this.mBarConfig.m()) {
            this.mWindow.clearFlags(ASTNode.NOJIT);
        }
        this.mWindow.addFlags(Integer.MIN_VALUE);
        b bVar2 = this.mBarParams;
        if (bVar2.q) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.mWindow.setStatusBarContrastEnforced(false);
            }
            Window window = this.mWindow;
            b bVar3 = this.mBarParams;
            window.setStatusBarColor(b.d(bVar3.a, bVar3.r, bVar3.d));
        } else {
            this.mWindow.setStatusBarColor(b.d(bVar2.a, 0, bVar2.d));
        }
        b bVar4 = this.mBarParams;
        if (bVar4.H) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.mWindow.setNavigationBarContrastEnforced(false);
            }
            Window window2 = this.mWindow;
            b bVar5 = this.mBarParams;
            window2.setNavigationBarColor(b.d(bVar5.b, bVar5.s, bVar5.f));
        } else {
            this.mWindow.setNavigationBarColor(bVar4.c);
        }
        return i2;
    }

    private void initBarBelowLOLLIPOP() {
        this.mWindow.addFlags(ASTNode.ARRAY_TYPE_LITERAL);
        setupStatusBarView();
        if (this.mBarConfig.m() || OSUtils.isEMUI3_x()) {
            b bVar = this.mBarParams;
            if (bVar.H && bVar.I) {
                this.mWindow.addFlags(ASTNode.NOJIT);
            } else {
                this.mWindow.clearFlags(ASTNode.NOJIT);
            }
            if (this.mNavigationBarHeight == 0) {
                this.mNavigationBarHeight = this.mBarConfig.d();
            }
            if (this.mNavigationBarWidth == 0) {
                this.mNavigationBarWidth = this.mBarConfig.g();
            }
            setupNavBarView();
        }
    }

    private void initCommonParameter(Window window) {
        this.mWindow = window;
        this.mBarParams = new b();
        ViewGroup viewGroup = (ViewGroup) this.mWindow.getDecorView();
        this.mDecorView = viewGroup;
        this.mContentView = (ViewGroup) viewGroup.findViewById(R.id.content);
    }

    private static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isGesture(Fragment fragment) {
        Context context = fragment.getContext();
        if (context == null) {
            return false;
        }
        return isGesture(context);
    }

    public static boolean isGesture(Context context) {
        return g.a(context).a;
    }

    public static boolean isGesture(androidx.fragment.app.Fragment fragment) {
        Context context = fragment.getContext();
        if (context == null) {
            return false;
        }
        return isGesture(context);
    }

    @TargetApi(ActionEvent.delete_comment)
    public static boolean isNavigationAtBottom(@NonNull Activity activity) {
        return new a(activity).n();
    }

    @TargetApi(ActionEvent.delete_comment)
    public static boolean isNavigationAtBottom(@NonNull Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return isNavigationAtBottom(fragment.getActivity());
    }

    @TargetApi(ActionEvent.delete_comment)
    public static boolean isNavigationAtBottom(@NonNull androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return isNavigationAtBottom(fragment.getActivity());
    }

    public static boolean isSupportNavigationIconDark() {
        return OSUtils.isMIUI6Later() || Build.VERSION.SDK_INT >= 26;
    }

    public static boolean isSupportStatusBarDarkFont() {
        if (OSUtils.isMIUI6Later()) {
            return true;
        }
        OSUtils.isFlymeOS4Later();
        return true;
    }

    private void postFitsWindowsBelowLOLLIPOP() {
        fitsWindowsKITKAT();
        if (this.mIsFragment || !OSUtils.isEMUI3_x()) {
            return;
        }
        fitsWindowsEMUI();
    }

    private void setBarDarkFontAboveR() {
        if (Build.VERSION.SDK_INT >= 30) {
            setStatusBarDarkFontAboveR();
            setNavigationIconDarkAboveR();
        }
    }

    public static void setFitsSystemWindows(Activity activity) {
        setFitsSystemWindows(activity, true);
    }

    public static void setFitsSystemWindows(Activity activity, boolean z) {
        if (activity == null) {
            return;
        }
        setFitsSystemWindows(((ViewGroup) activity.findViewById(R.id.content)).getChildAt(0), z);
    }

    public static void setFitsSystemWindows(Fragment fragment) {
        if (fragment == null) {
            return;
        }
        setFitsSystemWindows(fragment.getActivity());
    }

    public static void setFitsSystemWindows(Fragment fragment, boolean z) {
        if (fragment == null) {
            return;
        }
        setFitsSystemWindows(fragment.getActivity(), z);
    }

    private static void setFitsSystemWindows(View view, boolean z) {
        if (view == null) {
            return;
        }
        if (!(view instanceof ViewGroup)) {
            view.setFitsSystemWindows(z);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup instanceof DrawerLayout) {
            setFitsSystemWindows(viewGroup.getChildAt(0), z);
        } else {
            viewGroup.setFitsSystemWindows(z);
            viewGroup.setClipToPadding(true);
        }
    }

    public static void setFitsSystemWindows(androidx.fragment.app.Fragment fragment) {
        if (fragment == null) {
            return;
        }
        setFitsSystemWindows(fragment.getActivity());
    }

    public static void setFitsSystemWindows(androidx.fragment.app.Fragment fragment, boolean z) {
        if (fragment == null) {
            return;
        }
        setFitsSystemWindows(fragment.getActivity(), z);
    }

    private int setNavigationIconDark(int i) {
        return (Build.VERSION.SDK_INT < 26 || !this.mBarParams.l) ? i : i | 16;
    }

    private void setNavigationIconDarkAboveR() {
        WindowInsetsController windowInsetsController;
        windowInsetsController = this.mContentView.getWindowInsetsController();
        if (this.mBarParams.l) {
            windowInsetsController.setSystemBarsAppearance(16, 16);
        } else {
            windowInsetsController.setSystemBarsAppearance(0, 16);
        }
    }

    private void setPadding(int i, int i2, int i3, int i4) {
        ViewGroup viewGroup = this.mContentView;
        if (viewGroup != null) {
            viewGroup.setPadding(i, i2, i3, i4);
        }
        this.mPaddingLeft = i;
        this.mPaddingTop = i2;
        this.mPaddingRight = i3;
        this.mPaddingBottom = i4;
    }

    private void setSpecialBarDarkMode() {
        if (OSUtils.isMIUI6Later()) {
            SpecialBarFontUtils.setMIUIBarDark(this.mWindow, "EXTRA_FLAG_STATUS_BAR_DARK_MODE", this.mBarParams.k);
            b bVar = this.mBarParams;
            if (bVar.H) {
                SpecialBarFontUtils.setMIUIBarDark(this.mWindow, "EXTRA_FLAG_NAVIGATION_BAR_DARK_MODE", bVar.l);
            }
        }
        if (OSUtils.isFlymeOS4Later()) {
            b bVar2 = this.mBarParams;
            int i = bVar2.C;
            if (i != 0) {
                SpecialBarFontUtils.setStatusBarDarkIcon(this.mActivity, i);
            } else {
                SpecialBarFontUtils.setStatusBarDarkIcon(this.mActivity, bVar2.k);
            }
        }
    }

    private int setStatusBarDarkFont(int i) {
        return this.mBarParams.k ? i | 8192 : i;
    }

    private void setStatusBarDarkFontAboveR() {
        WindowInsetsController windowInsetsController;
        windowInsetsController = this.mContentView.getWindowInsetsController();
        if (!this.mBarParams.k) {
            windowInsetsController.setSystemBarsAppearance(0, 8);
            return;
        }
        if (this.mWindow != null) {
            unsetSystemUiFlag(8192);
        }
        windowInsetsController.setSystemBarsAppearance(8, 8);
    }

    public static void setStatusBarView(Activity activity, int i, View... viewArr) {
        if (activity == null) {
            return;
        }
        if (i < 0) {
            i = 0;
        }
        for (View view : viewArr) {
            if (view != null) {
                Integer num = (Integer) view.getTag(R$id.immersion_fits_layout_overlap);
                if (num == null) {
                    num = 0;
                }
                if (num.intValue() != i) {
                    view.setTag(R$id.immersion_fits_layout_overlap, Integer.valueOf(i));
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new ViewGroup.LayoutParams(-1, 0);
                    }
                    layoutParams.height = i;
                    view.setLayoutParams(layoutParams);
                }
            }
        }
    }

    public static void setStatusBarView(Activity activity, View... viewArr) {
        setStatusBarView(activity, getStatusBarHeight(activity), viewArr);
    }

    public static void setStatusBarView(Fragment fragment, int i, View... viewArr) {
        if (fragment == null) {
            return;
        }
        setStatusBarView(fragment.getActivity(), i, viewArr);
    }

    public static void setStatusBarView(Fragment fragment, View... viewArr) {
        if (fragment == null) {
            return;
        }
        setStatusBarView(fragment.getActivity(), viewArr);
    }

    public static void setStatusBarView(androidx.fragment.app.Fragment fragment, int i, View... viewArr) {
        if (fragment == null) {
            return;
        }
        setStatusBarView(fragment.getActivity(), i, viewArr);
    }

    public static void setStatusBarView(androidx.fragment.app.Fragment fragment, View... viewArr) {
        if (fragment == null) {
            return;
        }
        setStatusBarView(fragment.getActivity(), viewArr);
    }

    public static void setTitleBar(Activity activity, int i, View... viewArr) {
        if (activity == null) {
            return;
        }
        if (i < 0) {
            i = 0;
        }
        for (View view : viewArr) {
            if (view != null) {
                Integer num = (Integer) view.getTag(R$id.immersion_fits_layout_overlap);
                if (num == null) {
                    num = 0;
                }
                if (num.intValue() != i) {
                    view.setTag(R$id.immersion_fits_layout_overlap, Integer.valueOf(i));
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new ViewGroup.LayoutParams(-1, -2);
                    }
                    int i2 = layoutParams.height;
                    if (i2 == -2 || i2 == -1) {
                        view.post(new 1(layoutParams, view, i, num));
                    } else {
                        layoutParams.height = i2 + (i - num.intValue());
                        view.setPadding(view.getPaddingLeft(), (view.getPaddingTop() + i) - num.intValue(), view.getPaddingRight(), view.getPaddingBottom());
                        view.setLayoutParams(layoutParams);
                    }
                }
            }
        }
    }

    public static void setTitleBar(Activity activity, View... viewArr) {
        setTitleBar(activity, getStatusBarHeight(activity), viewArr);
    }

    public static void setTitleBar(Fragment fragment, int i, View... viewArr) {
        if (fragment == null) {
            return;
        }
        setTitleBar(fragment.getActivity(), i, viewArr);
    }

    public static void setTitleBar(Fragment fragment, View... viewArr) {
        if (fragment == null) {
            return;
        }
        setTitleBar(fragment.getActivity(), viewArr);
    }

    public static void setTitleBar(androidx.fragment.app.Fragment fragment, int i, View... viewArr) {
        if (fragment == null) {
            return;
        }
        setTitleBar(fragment.getActivity(), i, viewArr);
    }

    public static void setTitleBar(androidx.fragment.app.Fragment fragment, View... viewArr) {
        if (fragment == null) {
            return;
        }
        setTitleBar(fragment.getActivity(), viewArr);
    }

    public static void setTitleBarMarginTop(Activity activity, int i, View... viewArr) {
        if (activity == null) {
            return;
        }
        if (i < 0) {
            i = 0;
        }
        for (View view : viewArr) {
            if (view != null) {
                Integer num = (Integer) view.getTag(R$id.immersion_fits_layout_overlap);
                if (num == null) {
                    num = 0;
                }
                if (num.intValue() != i) {
                    view.setTag(R$id.immersion_fits_layout_overlap, Integer.valueOf(i));
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginLayoutParams.setMargins(marginLayoutParams.leftMargin, (marginLayoutParams.topMargin + i) - num.intValue(), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    view.setLayoutParams(marginLayoutParams);
                }
            }
        }
    }

    public static void setTitleBarMarginTop(Activity activity, View... viewArr) {
        setTitleBarMarginTop(activity, getStatusBarHeight(activity), viewArr);
    }

    public static void setTitleBarMarginTop(Fragment fragment, int i, View... viewArr) {
        if (fragment == null) {
            return;
        }
        setTitleBarMarginTop(fragment.getActivity(), i, viewArr);
    }

    public static void setTitleBarMarginTop(Fragment fragment, View... viewArr) {
        if (fragment == null) {
            return;
        }
        setTitleBarMarginTop(fragment.getActivity(), viewArr);
    }

    public static void setTitleBarMarginTop(androidx.fragment.app.Fragment fragment, int i, View... viewArr) {
        if (fragment == null) {
            return;
        }
        setTitleBarMarginTop(fragment.getActivity(), i, viewArr);
    }

    public static void setTitleBarMarginTop(androidx.fragment.app.Fragment fragment, View... viewArr) {
        if (fragment == null) {
            return;
        }
        setTitleBarMarginTop(fragment.getActivity(), viewArr);
    }

    private void setupNavBarView() {
        FrameLayout.LayoutParams layoutParams;
        ViewGroup viewGroup = this.mDecorView;
        int i = d.b;
        View findViewById = viewGroup.findViewById(i);
        if (findViewById == null) {
            findViewById = new View(this.mActivity);
            findViewById.setId(i);
            this.mDecorView.addView(findViewById);
        }
        if (this.mBarConfig.n()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.mBarConfig.d());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.mBarConfig.g(), -1);
            layoutParams.gravity = GravityCompat.END;
        }
        findViewById.setLayoutParams(layoutParams);
        b bVar = this.mBarParams;
        findViewById.setBackgroundColor(b.d(bVar.b, bVar.s, bVar.f));
        b bVar2 = this.mBarParams;
        if (bVar2.H && bVar2.I && !bVar2.i) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
    }

    private void setupStatusBarView() {
        ViewGroup viewGroup = this.mDecorView;
        int i = d.a;
        View findViewById = viewGroup.findViewById(i);
        if (findViewById == null) {
            findViewById = new View(this.mActivity);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.mBarConfig.k());
            layoutParams.gravity = 48;
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(0);
            findViewById.setId(i);
            this.mDecorView.addView(findViewById);
        }
        b bVar = this.mBarParams;
        if (bVar.q) {
            findViewById.setBackgroundColor(b.d(bVar.a, bVar.r, bVar.d));
        } else {
            findViewById.setBackgroundColor(b.d(bVar.a, 0, bVar.d));
        }
    }

    public static void showStatusBar(@NonNull Window window) {
        window.clearFlags(1024);
    }

    private void transformView() {
        if (this.mBarParams.t.size() != 0) {
            for (Map.Entry entry : this.mBarParams.t.entrySet()) {
                View view = (View) entry.getKey();
                Map map = (Map) entry.getValue();
                Integer valueOf = Integer.valueOf(this.mBarParams.a);
                Integer valueOf2 = Integer.valueOf(this.mBarParams.r);
                for (Map.Entry entry2 : map.entrySet()) {
                    Integer num = (Integer) entry2.getKey();
                    valueOf2 = (Integer) entry2.getValue();
                    valueOf = num;
                }
                if (view != null) {
                    if (Math.abs(this.mBarParams.u - 0.0f) == 0.0f) {
                        view.setBackgroundColor(b.d(valueOf.intValue(), valueOf2.intValue(), this.mBarParams.d));
                    } else {
                        view.setBackgroundColor(b.d(valueOf.intValue(), valueOf2.intValue(), this.mBarParams.u));
                    }
                }
            }
        }
    }

    private void updateBarConfig() {
        a aVar = new a(this.mActivity);
        this.mBarConfig = aVar;
        if (!this.mInitialized || this.mIsActionBarBelowLOLLIPOP) {
            this.mActionBarHeight = aVar.a();
        }
    }

    private void updateBarParams() {
        adjustDarkModeParams();
        if (!this.mInitialized || this.mIsFragment) {
            updateBarConfig();
        }
        ImmersionBar immersionBar = this.mParentBar;
        if (immersionBar != null) {
            if (this.mIsFragment) {
                immersionBar.mBarParams = this.mBarParams;
            }
            if (this.mIsDialog && immersionBar.mKeyboardTempEnable) {
                immersionBar.mBarParams.F = false;
            }
        }
    }

    public static ImmersionBar with(@NonNull Activity activity) {
        return getRetriever().d(activity, false);
    }

    public static ImmersionBar with(@NonNull Activity activity, @NonNull Dialog dialog) {
        return getRetriever().c(activity, dialog, false);
    }

    public static ImmersionBar with(@NonNull Activity activity, @NonNull Dialog dialog, boolean z) {
        return getRetriever().c(activity, dialog, z);
    }

    public static ImmersionBar with(@NonNull Activity activity, boolean z) {
        return getRetriever().d(activity, z);
    }

    public static ImmersionBar with(@NonNull DialogFragment dialogFragment) {
        return getRetriever().e(dialogFragment, false);
    }

    public static ImmersionBar with(@NonNull DialogFragment dialogFragment, boolean z) {
        return getRetriever().e(dialogFragment, z);
    }

    public static ImmersionBar with(@NonNull Fragment fragment) {
        return getRetriever().e(fragment, false);
    }

    public static ImmersionBar with(@NonNull Fragment fragment, boolean z) {
        return getRetriever().e(fragment, z);
    }

    public static ImmersionBar with(@NonNull androidx.fragment.app.DialogFragment dialogFragment) {
        return getRetriever().f(dialogFragment, false);
    }

    public static ImmersionBar with(@NonNull androidx.fragment.app.DialogFragment dialogFragment, boolean z) {
        return getRetriever().f(dialogFragment, z);
    }

    public static ImmersionBar with(@NonNull androidx.fragment.app.Fragment fragment) {
        return getRetriever().f(fragment, false);
    }

    public static ImmersionBar with(@NonNull androidx.fragment.app.Fragment fragment, boolean z) {
        return getRetriever().f(fragment, z);
    }

    public ImmersionBar addTag(String str) {
        if (isEmpty(str)) {
            throw new IllegalArgumentException("tag不能为空");
        }
        this.mTagMap.put(str, this.mBarParams.a());
        return this;
    }

    public ImmersionBar addViewSupportTransformColor(View view) {
        return addViewSupportTransformColorInt(view, this.mBarParams.r);
    }

    public ImmersionBar addViewSupportTransformColor(View view, int i) {
        return addViewSupportTransformColorInt(view, androidx.core.content.b.getColor(this.mActivity, i));
    }

    public ImmersionBar addViewSupportTransformColor(View view, int i, int i2) {
        return addViewSupportTransformColorInt(view, androidx.core.content.b.getColor(this.mActivity, i), androidx.core.content.b.getColor(this.mActivity, i2));
    }

    public ImmersionBar addViewSupportTransformColor(View view, String str) {
        return addViewSupportTransformColorInt(view, Color.parseColor(str));
    }

    public ImmersionBar addViewSupportTransformColor(View view, String str, String str2) {
        return addViewSupportTransformColorInt(view, Color.parseColor(str), Color.parseColor(str2));
    }

    public ImmersionBar addViewSupportTransformColorInt(View view, int i) {
        if (view == null) {
            throw new IllegalArgumentException("View参数不能为空");
        }
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf(this.mBarParams.a), Integer.valueOf(i));
        this.mBarParams.t.put(view, hashMap);
        return this;
    }

    public ImmersionBar addViewSupportTransformColorInt(View view, int i, int i2) {
        if (view == null) {
            throw new IllegalArgumentException("View参数不能为空");
        }
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf(i), Integer.valueOf(i2));
        this.mBarParams.t.put(view, hashMap);
        return this;
    }

    public ImmersionBar applySystemFits(boolean z) {
        this.mBarParams.B = !z;
        setFitsSystemWindows(this.mActivity, z);
        return this;
    }

    public ImmersionBar autoDarkModeEnable(boolean z) {
        return autoDarkModeEnable(z, 0.2f);
    }

    public ImmersionBar autoDarkModeEnable(boolean z, float f) {
        b bVar = this.mBarParams;
        bVar.m = z;
        bVar.o = f;
        bVar.n = z;
        bVar.p = f;
        return this;
    }

    public ImmersionBar autoNavigationBarDarkModeEnable(boolean z) {
        return autoNavigationBarDarkModeEnable(z, 0.2f);
    }

    public ImmersionBar autoNavigationBarDarkModeEnable(boolean z, float f) {
        b bVar = this.mBarParams;
        bVar.n = z;
        bVar.p = f;
        return this;
    }

    public ImmersionBar autoStatusBarDarkModeEnable(boolean z) {
        return autoStatusBarDarkModeEnable(z, 0.2f);
    }

    public ImmersionBar autoStatusBarDarkModeEnable(boolean z, float f) {
        b bVar = this.mBarParams;
        bVar.m = z;
        bVar.o = f;
        return this;
    }

    public ImmersionBar barAlpha(float f) {
        b bVar = this.mBarParams;
        bVar.d = f;
        bVar.e = f;
        bVar.f = f;
        bVar.g = f;
        return this;
    }

    public ImmersionBar barColor(int i) {
        return barColorInt(androidx.core.content.b.getColor(this.mActivity, i));
    }

    public ImmersionBar barColor(int i, float f) {
        return barColorInt(androidx.core.content.b.getColor(this.mActivity, i), i);
    }

    public ImmersionBar barColor(int i, int i2, float f) {
        return barColorInt(androidx.core.content.b.getColor(this.mActivity, i), androidx.core.content.b.getColor(this.mActivity, i2), f);
    }

    public ImmersionBar barColor(String str) {
        return barColorInt(Color.parseColor(str));
    }

    public ImmersionBar barColor(String str, float f) {
        return barColorInt(Color.parseColor(str), f);
    }

    public ImmersionBar barColor(String str, String str2, float f) {
        return barColorInt(Color.parseColor(str), Color.parseColor(str2), f);
    }

    public ImmersionBar barColorInt(int i) {
        b bVar = this.mBarParams;
        bVar.a = i;
        bVar.b = i;
        return this;
    }

    public ImmersionBar barColorInt(int i, float f) {
        b bVar = this.mBarParams;
        bVar.a = i;
        bVar.b = i;
        bVar.d = f;
        bVar.f = f;
        return this;
    }

    public ImmersionBar barColorInt(int i, int i2, float f) {
        b bVar = this.mBarParams;
        bVar.a = i;
        bVar.b = i;
        bVar.r = i2;
        bVar.s = i2;
        bVar.d = f;
        bVar.f = f;
        return this;
    }

    public ImmersionBar barColorTransform(int i) {
        return barColorTransformInt(androidx.core.content.b.getColor(this.mActivity, i));
    }

    public ImmersionBar barColorTransform(String str) {
        return barColorTransformInt(Color.parseColor(str));
    }

    public ImmersionBar barColorTransformInt(int i) {
        b bVar = this.mBarParams;
        bVar.r = i;
        bVar.s = i;
        return this;
    }

    public ImmersionBar barEnable(boolean z) {
        this.mBarParams.K = z;
        return this;
    }

    public ImmersionBar fitsLayoutOverlapEnable(boolean z) {
        this.mBarParams.B = z;
        return this;
    }

    void fitsParentBarKeyboard() {
        f fVar;
        ImmersionBar immersionBar = this.mParentBar;
        if (immersionBar == null || (fVar = immersionBar.mFitsKeyboard) == null) {
            return;
        }
        fVar.b();
        this.mParentBar.mFitsKeyboard.d();
    }

    public ImmersionBar fitsSystemWindows(boolean z) {
        this.mBarParams.y = z;
        if (!z) {
            this.mFitsStatusBarType = 0;
        } else if (this.mFitsStatusBarType == 0) {
            this.mFitsStatusBarType = 4;
        }
        return this;
    }

    public ImmersionBar fitsSystemWindows(boolean z, int i) {
        return fitsSystemWindowsInt(z, androidx.core.content.b.getColor(this.mActivity, i));
    }

    public ImmersionBar fitsSystemWindows(boolean z, int i, int i2, float f) {
        return fitsSystemWindowsInt(z, androidx.core.content.b.getColor(this.mActivity, i), androidx.core.content.b.getColor(this.mActivity, i2), f);
    }

    public ImmersionBar fitsSystemWindowsInt(boolean z, int i) {
        return fitsSystemWindowsInt(z, i, ViewCompat.MEASURED_STATE_MASK, 0.0f);
    }

    public ImmersionBar fitsSystemWindowsInt(boolean z, int i, int i2, float f) {
        b bVar = this.mBarParams;
        bVar.y = z;
        bVar.v = i;
        bVar.w = i2;
        bVar.x = f;
        if (!z) {
            this.mFitsStatusBarType = 0;
        } else if (this.mFitsStatusBarType == 0) {
            this.mFitsStatusBarType = 4;
        }
        this.mContentView.setBackgroundColor(b.d(i, i2, f));
        return this;
    }

    public ImmersionBar flymeOSStatusBarFontColor(int i) {
        this.mBarParams.C = androidx.core.content.b.getColor(this.mActivity, i);
        b bVar = this.mBarParams;
        bVar.D = bVar.C;
        return this;
    }

    public ImmersionBar flymeOSStatusBarFontColor(String str) {
        this.mBarParams.C = Color.parseColor(str);
        b bVar = this.mBarParams;
        bVar.D = bVar.C;
        return this;
    }

    public ImmersionBar flymeOSStatusBarFontColorInt(int i) {
        b bVar = this.mBarParams;
        bVar.C = i;
        bVar.D = i;
        return this;
    }

    public ImmersionBar fullScreen(boolean z) {
        this.mBarParams.h = z;
        return this;
    }

    int getActionBarHeight() {
        return this.mActionBarHeight;
    }

    Activity getActivity() {
        return this.mActivity;
    }

    a getBarConfig() {
        if (this.mBarConfig == null) {
            this.mBarConfig = new a(this.mActivity);
        }
        return this.mBarConfig;
    }

    public b getBarParams() {
        return this.mBarParams;
    }

    Fragment getFragment() {
        return this.mFragment;
    }

    int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    int getPaddingLeft() {
        return this.mPaddingLeft;
    }

    int getPaddingRight() {
        return this.mPaddingRight;
    }

    int getPaddingTop() {
        return this.mPaddingTop;
    }

    androidx.fragment.app.Fragment getSupportFragment() {
        return this.mSupportFragment;
    }

    public ImmersionBar getTag(String str) {
        if (isEmpty(str)) {
            throw new IllegalArgumentException("tag不能为空");
        }
        b bVar = this.mTagMap.get(str);
        if (bVar != null) {
            this.mBarParams = bVar.a();
        }
        return this;
    }

    Window getWindow() {
        return this.mWindow;
    }

    public ImmersionBar hideBar(BarHide barHide) {
        this.mBarParams.j = barHide;
        if (OSUtils.isEMUI3_x()) {
            b bVar = this.mBarParams;
            BarHide barHide2 = bVar.j;
            bVar.i = barHide2 == BarHide.FLAG_HIDE_NAVIGATION_BAR || barHide2 == BarHide.FLAG_HIDE_BAR;
        }
        return this;
    }

    public void init() {
        if (this.mBarParams.K) {
            updateBarParams();
            setBar();
            fitsWindows();
            fitsKeyboard();
            transformView();
            this.mInitialized = true;
        }
    }

    boolean initialized() {
        return this.mInitialized;
    }

    boolean isDialogFragment() {
        return this.mIsDialogFragment;
    }

    boolean isFragment() {
        return this.mIsFragment;
    }

    public ImmersionBar keyboardEnable(boolean z) {
        return keyboardEnable(z, this.mBarParams.G);
    }

    public ImmersionBar keyboardEnable(boolean z, int i) {
        b bVar = this.mBarParams;
        bVar.F = z;
        bVar.G = i;
        this.mKeyboardTempEnable = z;
        return this;
    }

    public ImmersionBar keyboardMode(int i) {
        this.mBarParams.G = i;
        return this;
    }

    public ImmersionBar navigationBarAlpha(float f) {
        b bVar = this.mBarParams;
        bVar.f = f;
        bVar.g = f;
        return this;
    }

    public ImmersionBar navigationBarColor(int i) {
        return navigationBarColorInt(androidx.core.content.b.getColor(this.mActivity, i));
    }

    public ImmersionBar navigationBarColor(int i, float f) {
        return navigationBarColorInt(androidx.core.content.b.getColor(this.mActivity, i), f);
    }

    public ImmersionBar navigationBarColor(int i, int i2, float f) {
        return navigationBarColorInt(androidx.core.content.b.getColor(this.mActivity, i), androidx.core.content.b.getColor(this.mActivity, i2), f);
    }

    public ImmersionBar navigationBarColor(String str) {
        return navigationBarColorInt(Color.parseColor(str));
    }

    public ImmersionBar navigationBarColor(String str, float f) {
        return navigationBarColorInt(Color.parseColor(str), f);
    }

    public ImmersionBar navigationBarColor(String str, String str2, float f) {
        return navigationBarColorInt(Color.parseColor(str), Color.parseColor(str2), f);
    }

    public ImmersionBar navigationBarColorInt(int i) {
        this.mBarParams.b = i;
        return this;
    }

    public ImmersionBar navigationBarColorInt(int i, float f) {
        b bVar = this.mBarParams;
        bVar.b = i;
        bVar.f = f;
        return this;
    }

    public ImmersionBar navigationBarColorInt(int i, int i2, float f) {
        b bVar = this.mBarParams;
        bVar.b = i;
        bVar.s = i2;
        bVar.f = f;
        return this;
    }

    public ImmersionBar navigationBarColorTransform(int i) {
        return navigationBarColorTransformInt(androidx.core.content.b.getColor(this.mActivity, i));
    }

    public ImmersionBar navigationBarColorTransform(String str) {
        return navigationBarColorTransformInt(Color.parseColor(str));
    }

    public ImmersionBar navigationBarColorTransformInt(int i) {
        this.mBarParams.s = i;
        return this;
    }

    public ImmersionBar navigationBarDarkIcon(boolean z) {
        return navigationBarDarkIcon(z, 0.2f);
    }

    public ImmersionBar navigationBarDarkIcon(boolean z, float f) {
        this.mBarParams.l = z;
        if (!z || isSupportNavigationIconDark()) {
            b bVar = this.mBarParams;
            bVar.f = bVar.g;
        } else {
            this.mBarParams.f = f;
        }
        return this;
    }

    public ImmersionBar navigationBarEnable(boolean z) {
        this.mBarParams.H = z;
        return this;
    }

    public ImmersionBar navigationBarWithEMUI3Enable(boolean z) {
        if (OSUtils.isEMUI3_x()) {
            b bVar = this.mBarParams;
            bVar.J = z;
            bVar.I = z;
        }
        return this;
    }

    public ImmersionBar navigationBarWithKitkatEnable(boolean z) {
        this.mBarParams.I = z;
        return this;
    }

    void onConfigurationChanged(Configuration configuration) {
        updateBarConfig();
        if (!OSUtils.isEMUI3_x()) {
            fitsWindows();
        } else if (this.mInitialized && !this.mIsFragment && this.mBarParams.I) {
            init();
        } else {
            fitsWindows();
        }
    }

    void onDestroy() {
        ImmersionBar immersionBar;
        cancelListener();
        if (this.mIsDialog && (immersionBar = this.mParentBar) != null) {
            b bVar = immersionBar.mBarParams;
            bVar.F = immersionBar.mKeyboardTempEnable;
            if (bVar.j != BarHide.FLAG_SHOW_BAR) {
                immersionBar.setBar();
            }
        }
        this.mInitialized = false;
    }

    @Override // com.gyf.immersionbar.ImmersionCallback
    public void onNavigationBarChange(boolean z, NavigationBarType navigationBarType) {
        View findViewById = this.mDecorView.findViewById(d.b);
        if (findViewById != null) {
            this.mBarConfig = new a(this.mActivity);
            int paddingBottom = this.mContentView.getPaddingBottom();
            int paddingRight = this.mContentView.getPaddingRight();
            if (z) {
                findViewById.setVisibility(0);
                if (!checkFitsSystemWindows(this.mDecorView.findViewById(R.id.content))) {
                    if (this.mNavigationBarHeight == 0) {
                        this.mNavigationBarHeight = this.mBarConfig.d();
                    }
                    if (this.mNavigationBarWidth == 0) {
                        this.mNavigationBarWidth = this.mBarConfig.g();
                    }
                    if (!this.mBarParams.i) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) findViewById.getLayoutParams();
                        if (this.mBarConfig.n()) {
                            layoutParams.gravity = 80;
                            paddingBottom = this.mNavigationBarHeight;
                            layoutParams.height = paddingBottom;
                            if (this.mBarParams.h) {
                                paddingBottom = 0;
                            }
                            paddingRight = 0;
                        } else {
                            layoutParams.gravity = GravityCompat.END;
                            int i = this.mNavigationBarWidth;
                            layoutParams.width = i;
                            if (this.mBarParams.h) {
                                i = 0;
                            }
                            paddingRight = i;
                            paddingBottom = 0;
                        }
                        findViewById.setLayoutParams(layoutParams);
                    }
                    setPadding(0, this.mContentView.getPaddingTop(), paddingRight, paddingBottom);
                }
            } else {
                findViewById.setVisibility(8);
            }
            paddingBottom = 0;
            paddingRight = 0;
            setPadding(0, this.mContentView.getPaddingTop(), paddingRight, paddingBottom);
        }
    }

    void onResume() {
        updateBarConfig();
        if (this.mIsFragment || !this.mInitialized || this.mBarParams == null) {
            return;
        }
        if (OSUtils.isEMUI3_x() && this.mBarParams.J) {
            init();
        } else if (this.mBarParams.j != BarHide.FLAG_SHOW_BAR) {
            setBar();
        }
    }

    public ImmersionBar removeSupportAllView() {
        if (this.mBarParams.t.size() != 0) {
            this.mBarParams.t.clear();
        }
        return this;
    }

    public ImmersionBar removeSupportView(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View参数不能为空");
        }
        Map map = (Map) this.mBarParams.t.get(view);
        if (map != null && map.size() != 0) {
            this.mBarParams.t.remove(view);
        }
        return this;
    }

    public ImmersionBar reset() {
        this.mBarParams = new b();
        this.mFitsStatusBarType = 0;
        return this;
    }

    @Override // java.lang.Runnable
    public void run() {
        postFitsWindowsBelowLOLLIPOP();
    }

    void setBar() {
        boolean isEMUI3_x = OSUtils.isEMUI3_x();
        int i = ASTNode.COLLECTION;
        if (isEMUI3_x) {
            initBarBelowLOLLIPOP();
        } else {
            fitsNotchScreen();
            i = setNavigationIconDark(setStatusBarDarkFont(initBarAboveLOLLIPOP(ASTNode.COLLECTION)));
            setBarDarkFontAboveR();
        }
        this.mDecorView.setSystemUiVisibility(hideBarBelowR(i));
        setSpecialBarDarkMode();
        hideBarAboveR();
        if (this.mBarParams.L != null) {
            j.b().c(this.mActivity.getApplication());
        }
    }

    public ImmersionBar setOnBarListener(l lVar) {
        if (lVar != null) {
            this.mBarParams.getClass();
            this.mBarParams.getClass();
        } else {
            this.mBarParams.getClass();
        }
        return this;
    }

    public ImmersionBar setOnKeyboardListener(@Nullable m mVar) {
        this.mBarParams.getClass();
        this.mBarParams.getClass();
        return this;
    }

    public ImmersionBar setOnNavigationBarListener(n nVar) {
        if (nVar != null) {
            b bVar = this.mBarParams;
            if (bVar.L == null) {
                bVar.L = nVar;
                j.b().a(this.mBarParams.L);
            }
        } else if (this.mBarParams.L != null) {
            j.b().d(this.mBarParams.L);
            this.mBarParams.L = null;
        }
        return this;
    }

    public ImmersionBar statusBarAlpha(float f) {
        b bVar = this.mBarParams;
        bVar.d = f;
        bVar.e = f;
        return this;
    }

    public ImmersionBar statusBarColor(int i) {
        return statusBarColorInt(androidx.core.content.b.getColor(this.mActivity, i));
    }

    public ImmersionBar statusBarColor(int i, float f) {
        return statusBarColorInt(androidx.core.content.b.getColor(this.mActivity, i), f);
    }

    public ImmersionBar statusBarColor(int i, int i2, float f) {
        return statusBarColorInt(androidx.core.content.b.getColor(this.mActivity, i), androidx.core.content.b.getColor(this.mActivity, i2), f);
    }

    public ImmersionBar statusBarColor(String str) {
        return statusBarColorInt(Color.parseColor(str));
    }

    public ImmersionBar statusBarColor(String str, float f) {
        return statusBarColorInt(Color.parseColor(str), f);
    }

    public ImmersionBar statusBarColor(String str, String str2, float f) {
        return statusBarColorInt(Color.parseColor(str), Color.parseColor(str2), f);
    }

    public ImmersionBar statusBarColorInt(int i) {
        this.mBarParams.a = i;
        return this;
    }

    public ImmersionBar statusBarColorInt(int i, float f) {
        b bVar = this.mBarParams;
        bVar.a = i;
        bVar.d = f;
        return this;
    }

    public ImmersionBar statusBarColorInt(int i, int i2, float f) {
        b bVar = this.mBarParams;
        bVar.a = i;
        bVar.r = i2;
        bVar.d = f;
        return this;
    }

    public ImmersionBar statusBarColorTransform(int i) {
        return statusBarColorTransformInt(androidx.core.content.b.getColor(this.mActivity, i));
    }

    public ImmersionBar statusBarColorTransform(String str) {
        return statusBarColorTransformInt(Color.parseColor(str));
    }

    public ImmersionBar statusBarColorTransformEnable(boolean z) {
        this.mBarParams.q = z;
        return this;
    }

    public ImmersionBar statusBarColorTransformInt(int i) {
        this.mBarParams.r = i;
        return this;
    }

    public ImmersionBar statusBarDarkFont(boolean z) {
        return statusBarDarkFont(z, 0.2f);
    }

    public ImmersionBar statusBarDarkFont(boolean z, float f) {
        this.mBarParams.k = z;
        if (!z || isSupportStatusBarDarkFont()) {
            b bVar = this.mBarParams;
            bVar.C = bVar.D;
            bVar.d = bVar.e;
        } else {
            this.mBarParams.d = f;
        }
        return this;
    }

    public ImmersionBar statusBarView(int i) {
        return statusBarView(this.mActivity.findViewById(i));
    }

    public ImmersionBar statusBarView(int i, View view) {
        return statusBarView(view.findViewById(i));
    }

    public ImmersionBar statusBarView(View view) {
        if (view == null) {
            return this;
        }
        this.mBarParams.A = view;
        if (this.mFitsStatusBarType == 0) {
            this.mFitsStatusBarType = 3;
        }
        return this;
    }

    public ImmersionBar supportActionBar(boolean z) {
        this.mBarParams.E = z;
        return this;
    }

    public ImmersionBar titleBar(int i) {
        return titleBar(i, true);
    }

    public ImmersionBar titleBar(int i, View view) {
        return titleBar(view.findViewById(i), true);
    }

    public ImmersionBar titleBar(int i, View view, boolean z) {
        return titleBar(view.findViewById(i), z);
    }

    public ImmersionBar titleBar(int i, boolean z) {
        androidx.fragment.app.Fragment fragment = this.mSupportFragment;
        if (fragment != null && fragment.getView() != null) {
            return titleBar(this.mSupportFragment.getView().findViewById(i), z);
        }
        Fragment fragment2 = this.mFragment;
        return (fragment2 == null || fragment2.getView() == null) ? titleBar(this.mActivity.findViewById(i), z) : titleBar(this.mFragment.getView().findViewById(i), z);
    }

    public ImmersionBar titleBar(View view) {
        return view == null ? this : titleBar(view, true);
    }

    public ImmersionBar titleBar(View view, boolean z) {
        if (view == null) {
            return this;
        }
        if (this.mFitsStatusBarType == 0) {
            this.mFitsStatusBarType = 1;
        }
        b bVar = this.mBarParams;
        bVar.z = view;
        bVar.q = z;
        return this;
    }

    public ImmersionBar titleBarMarginTop(int i) {
        androidx.fragment.app.Fragment fragment = this.mSupportFragment;
        if (fragment != null && fragment.getView() != null) {
            return titleBarMarginTop(this.mSupportFragment.getView().findViewById(i));
        }
        Fragment fragment2 = this.mFragment;
        return (fragment2 == null || fragment2.getView() == null) ? titleBarMarginTop(this.mActivity.findViewById(i)) : titleBarMarginTop(this.mFragment.getView().findViewById(i));
    }

    public ImmersionBar titleBarMarginTop(int i, View view) {
        return titleBarMarginTop(view.findViewById(i));
    }

    public ImmersionBar titleBarMarginTop(View view) {
        if (view == null) {
            return this;
        }
        if (this.mFitsStatusBarType == 0) {
            this.mFitsStatusBarType = 2;
        }
        this.mBarParams.z = view;
        return this;
    }

    public ImmersionBar transparentBar() {
        b bVar = this.mBarParams;
        bVar.a = 0;
        bVar.b = 0;
        bVar.h = true;
        return this;
    }

    public ImmersionBar transparentNavigationBar() {
        b bVar = this.mBarParams;
        bVar.b = 0;
        bVar.h = true;
        return this;
    }

    public ImmersionBar transparentStatusBar() {
        this.mBarParams.a = 0;
        return this;
    }

    protected void unsetSystemUiFlag(int i) {
        View decorView = this.mWindow.getDecorView();
        decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
    }

    public ImmersionBar viewAlpha(float f) {
        this.mBarParams.u = f;
        return this;
    }
}
