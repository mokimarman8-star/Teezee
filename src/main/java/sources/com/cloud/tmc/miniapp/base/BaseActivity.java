package com.cloud.tmc.miniapp.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.w;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import com.cloud.tmc.integration.utils.MiniBarUtils;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.IMiniAppLifecycleInterface;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniapp.action.ActivityAction;
import com.cloud.tmc.miniapp.action.BundleAction;
import com.cloud.tmc.miniapp.action.ClickAction;
import com.cloud.tmc.miniapp.action.HandlerAction;
import com.cloud.tmc.miniapp.action.KeyboardAction;
import com.cloud.tmc.miniapp.base.BaseActivity;
import com.cloud.tmc.miniapp.dialog.OooO0O0;
import com.cloud.tmc.miniapp.dialog.o000OOo;
import com.cloud.tmc.miniapp.ipc.binderimpl.OooO00o;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class BaseActivity extends AppCompatActivity implements ActivityAction, ClickAction, HandlerAction, KeyboardAction, BundleAction {
    private OooO0O0 dialog;
    private int dialogCount;
    private int initDataChannel;
    private boolean mResumed;
    private Bundle savedInstance;
    private final Lazy activityCallbacks$delegate = LazyKt.b(new Function0<SparseArray<OnActivityCallback>>() { // from class: com.cloud.tmc.miniapp.base.BaseActivity$activityCallbacks$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final SparseArray<BaseActivity.OnActivityCallback> m21invoke() {
            return new SparseArray<>(1);
        }
    });
    private boolean mStarted = true;

    public interface OnActivityCallback {
        void onActivityResult(int i, Intent intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat fitsSystemWindows$lambda$1(View view, WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.h(view, "v");
        Intrinsics.h(windowInsetsCompat, "insets");
        z0.c insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.g(insets, "insets.getInsets(WindowI…Compat.Type.systemBars())");
        view.setPadding(view.getPaddingLeft(), insets.b, view.getPaddingRight(), insets.d);
        return WindowInsetsCompat.CONSUMED;
    }

    private final SparseArray<OnActivityCallback> getActivityCallbacks() {
        return (SparseArray) this.activityCallbacks$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initSoftKeyboard$lambda$2(BaseActivity baseActivity, View view) {
        Intrinsics.h(baseActivity, "this$0");
        baseActivity.hideKeyboard(baseActivity.getCurrentFocus());
    }

    private final boolean isShouldHideInput(View view, MotionEvent motionEvent) {
        if (!(view instanceof EditText) && !(view instanceof WebView)) {
            return false;
        }
        int[] iArr = {0, 0};
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return motionEvent.getX() <= ((float) i) || motionEvent.getX() >= ((float) (view.getWidth() + i)) || motionEvent.getY() <= ((float) i2) || motionEvent.getY() >= ((float) (view.getHeight() + i2));
    }

    public static /* synthetic */ void showLoadingDialog$default(BaseActivity baseActivity, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showLoadingDialog");
        }
        if ((i & 1) != 0) {
            str = "";
        }
        baseActivity.showLoadingDialog(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void showLoadingDialog$lambda$0(BaseActivity baseActivity, String str) {
        TextView textView;
        Intrinsics.h(baseActivity, "this$0");
        if (baseActivity.dialogCount <= 0 || baseActivity.isFinishing() || baseActivity.isDestroyed()) {
            return;
        }
        if (baseActivity.dialog == null) {
            baseActivity.dialog = new o000OOo(baseActivity).setCancelable(false).create();
        }
        if (str == null || str.length() <= 0) {
            OooO0O0 oooO0O0 = baseActivity.dialog;
            textView = oooO0O0 != null ? (TextView) oooO0O0.findViewById(R.id.tv_wait_message) : null;
            if (textView != null) {
                textView.setText(baseActivity.getString(R.string.dialog_loading_tv));
            }
        } else {
            OooO0O0 oooO0O02 = baseActivity.dialog;
            textView = oooO0O02 != null ? (TextView) oooO0O02.findViewById(R.id.tv_wait_message) : null;
            if (textView != null) {
                textView.setText(str);
            }
        }
        w wVar = baseActivity.dialog;
        Intrinsics.e(wVar);
        if (wVar.isShowing()) {
            return;
        }
        w wVar2 = baseActivity.dialog;
        Intrinsics.e(wVar2);
        wVar2.show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Intrinsics.h(motionEvent, "ev");
        if (motionEvent.getActionMasked() == 0) {
            View currentFocus = getCurrentFocus();
            if (isShouldHideInput(currentFocus, motionEvent)) {
                hideKeyboard(currentFocus);
            }
        }
        return super/*android.app.Activity*/.dispatchTouchEvent(motionEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void finish() {
        super/*android.app.Activity*/.finish();
        hideKeyboard(getCurrentFocus());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void fitsSystemWindows() {
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        ViewCompat.setOnApplyWindowInsetsListener(getWindow().getDecorView().findViewById(android.R.id.content), new OnApplyWindowInsetsListener() { // from class: com.cloud.tmc.miniapp.base.a
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                WindowInsetsCompat fitsSystemWindows$lambda$1;
                fitsSystemWindows$lambda$1 = BaseActivity.fitsSystemWindows$lambda$1(view, windowInsetsCompat);
                return fitsSystemWindows$lambda$1;
            }
        });
    }

    @Override // com.cloud.tmc.miniapp.action.ActivityAction
    public Activity getActivity() {
        return ActivityAction.DefaultImpls.getActivity(this);
    }

    @Override // com.cloud.tmc.miniapp.action.BundleAction
    public boolean getBoolean(String str) {
        return BundleAction.DefaultImpls.getBoolean(this, str);
    }

    @Override // com.cloud.tmc.miniapp.action.BundleAction
    public boolean getBoolean(String str, boolean z) {
        return BundleAction.DefaultImpls.getBoolean(this, str, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.cloud.tmc.miniapp.action.BundleAction
    public Bundle getBundle() {
        return getIntent().getExtras();
    }

    public ViewGroup getContentView() {
        return (ViewGroup) findViewById(android.R.id.content);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.cloud.tmc.miniapp.action.ActivityAction
    public final Context getContext() {
        return this;
    }

    @Override // com.cloud.tmc.miniapp.action.BundleAction
    public double getDouble(String str) {
        return BundleAction.DefaultImpls.getDouble(this, str);
    }

    @Override // com.cloud.tmc.miniapp.action.BundleAction
    public double getDouble(String str, double d) {
        return BundleAction.DefaultImpls.getDouble(this, str, d);
    }

    @Override // com.cloud.tmc.miniapp.action.BundleAction
    public float getFloat(String str) {
        return BundleAction.DefaultImpls.getFloat(this, str);
    }

    @Override // com.cloud.tmc.miniapp.action.BundleAction
    public float getFloat(String str, float f) {
        return BundleAction.DefaultImpls.getFloat(this, str, f);
    }

    @Override // com.cloud.tmc.miniapp.action.HandlerAction
    public Handler getHandler() {
        return HandlerAction.DefaultImpls.getHandler(this);
    }

    public final int getInitDataChannel() {
        return this.initDataChannel;
    }

    @Override // com.cloud.tmc.miniapp.action.BundleAction
    public int getInt(String str) {
        return BundleAction.DefaultImpls.getInt(this, str);
    }

    @Override // com.cloud.tmc.miniapp.action.BundleAction
    public int getInt(String str, int i) {
        return BundleAction.DefaultImpls.getInt(this, str, i);
    }

    @Override // com.cloud.tmc.miniapp.action.BundleAction
    public ArrayList<Integer> getIntegerArrayList(String str) {
        return BundleAction.DefaultImpls.getIntegerArrayList(this, str);
    }

    public abstract int getLayoutId();

    @Override // com.cloud.tmc.miniapp.action.BundleAction
    public long getLong(String str) {
        return BundleAction.DefaultImpls.getLong(this, str);
    }

    @Override // com.cloud.tmc.miniapp.action.BundleAction
    public long getLong(String str, long j) {
        return BundleAction.DefaultImpls.getLong(this, str, j);
    }

    public final boolean getMResumed() {
        return this.mResumed;
    }

    public final boolean getMStarted() {
        return this.mStarted;
    }

    @Override // com.cloud.tmc.miniapp.action.BundleAction
    public <P extends Parcelable> P getParcelable(String str) {
        return (P) BundleAction.DefaultImpls.getParcelable(this, str);
    }

    public final Bundle getSavedInstance() {
        return this.savedInstance;
    }

    @Override // com.cloud.tmc.miniapp.action.BundleAction
    public <S extends Serializable> S getSerializable(String str) {
        return (S) BundleAction.DefaultImpls.getSerializable(this, str);
    }

    @Override // com.cloud.tmc.miniapp.action.BundleAction
    public String getString(String str) {
        return BundleAction.DefaultImpls.getString(this, str);
    }

    @Override // com.cloud.tmc.miniapp.action.BundleAction
    public ArrayList<String> getStringArrayList(String str) {
        return BundleAction.DefaultImpls.getStringArrayList(this, str);
    }

    @Override // com.cloud.tmc.miniapp.action.KeyboardAction
    public void hideKeyboard(View view) {
        KeyboardAction.DefaultImpls.hideKeyboard(this, view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void hideLoadingDialog() {
        w wVar;
        OooO0O0 oooO0O0;
        if (isFinishing() || isDestroyed()) {
            return;
        }
        int i = this.dialogCount;
        if (i > 0) {
            this.dialogCount = i - 1;
        }
        if (this.dialogCount != 0 || (wVar = this.dialog) == null) {
            return;
        }
        Intrinsics.e(wVar);
        if (wVar.isShowing() && (oooO0O0 = this.dialog) != null) {
            oooO0O0.dismiss();
        }
    }

    public abstract void hideStatusLoading();

    public void initActivity() {
        initLayout();
        Bundle bundle = getBundle();
        if (!(bundle != null ? bundle.getBoolean(TmcConstants.EXTRA_APP_ENABLE_QUICK_MODE) : false)) {
            showStatusLoading();
        }
        initView();
        this.initDataChannel = 0;
        initData();
    }

    public abstract void initData();

    /* JADX WARN: Multi-variable type inference failed */
    public void initLayout() {
        if (getLayoutId() > 0) {
            setContentView(getLayoutId());
            fitsSystemWindows();
            initSoftKeyboard();
            MiniBarUtils.setStatusBarLightMode(this);
        }
    }

    public void initSoftKeyboard() {
        ViewGroup contentView = getContentView();
        if (contentView != null) {
            contentView.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.base.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseActivity.initSoftKeyboard$lambda$2(BaseActivity.this, view);
                }
            });
        }
    }

    public abstract void initView();

    public boolean isShowDialog() {
        w wVar = this.dialog;
        if (wVar != null) {
            Intrinsics.e(wVar);
            if (wVar.isShowing()) {
                return true;
            }
        }
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        OnActivityCallback onActivityCallback = getActivityCallbacks().get(i);
        OnActivityCallback onActivityCallback2 = onActivityCallback;
        if (onActivityCallback == null) {
            super/*androidx.fragment.app.FragmentActivity*/.onActivityResult(i, i2, intent);
            return;
        }
        if (onActivityCallback2 != null) {
            onActivityCallback2.onActivityResult(i2, intent);
        }
        getActivityCallbacks().remove(i);
    }

    @Override // com.cloud.tmc.miniapp.action.ClickAction, android.view.View.OnClickListener
    public void onClick(View view) {
        ClickAction.DefaultImpls.onClick(this, view);
    }

    public void onCreate(Bundle bundle) {
        this.savedInstance = bundle;
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(bundle);
        try {
            IMiniAppLifecycleInterface iMiniAppLifecycleInterface = OooO00o.OooO0OO;
            if (iMiniAppLifecycleInterface != null) {
                iMiniAppLifecycleInterface.onCreate();
            }
        } catch (Throwable th) {
            TmcLogger.e("globalMiniAppLifcecyclListener callback onCreate fail:" + th);
        }
        initActivity();
    }

    public void onDestroy() {
        super.onDestroy();
        try {
            IMiniAppLifecycleInterface iMiniAppLifecycleInterface = OooO00o.OooO0OO;
            if (iMiniAppLifecycleInterface != null) {
                iMiniAppLifecycleInterface.onDestroy();
            }
        } catch (Throwable th) {
            TmcLogger.e("globalMiniAppLifcecyclListener callback onDestroy fail:" + th);
        }
        removeCallbacks();
        if (isShowDialog()) {
            hideLoadingDialog();
        }
        this.dialog = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onNewIntent(Intent intent) {
        super/*androidx.activity.ComponentActivity*/.onNewIntent(intent);
        setIntent(intent);
    }

    public void onPause() {
        super/*androidx.fragment.app.FragmentActivity*/.onPause();
        try {
            IMiniAppLifecycleInterface iMiniAppLifecycleInterface = OooO00o.OooO0OO;
            if (iMiniAppLifecycleInterface != null) {
                iMiniAppLifecycleInterface.onPause();
            }
        } catch (Throwable th) {
            TmcLogger.e("globalMiniAppLifcecyclListener callback onPause fail:" + th);
        }
        this.mResumed = false;
    }

    public void onResume() {
        try {
            super/*androidx.fragment.app.FragmentActivity*/.onResume();
            try {
                IMiniAppLifecycleInterface iMiniAppLifecycleInterface = OooO00o.OooO0OO;
                if (iMiniAppLifecycleInterface != null) {
                    iMiniAppLifecycleInterface.onResume();
                }
            } catch (Throwable th) {
                TmcLogger.e("globalMiniAppLifcecyclListener callback onResume fail:" + th);
            }
            this.mResumed = true;
        } catch (Throwable th2) {
            TmcLogger.e("BaseActivity", "onResume", th2);
        }
    }

    public void onStart() {
        super.onStart();
        try {
            IMiniAppLifecycleInterface iMiniAppLifecycleInterface = OooO00o.OooO0OO;
            if (iMiniAppLifecycleInterface != null) {
                iMiniAppLifecycleInterface.onStart();
            }
        } catch (Throwable th) {
            TmcLogger.e("globalMiniAppLifcecyclListener callback onStart fail:" + th);
        }
        this.mStarted = true;
    }

    public void onStop() {
        super.onStop();
        try {
            IMiniAppLifecycleInterface iMiniAppLifecycleInterface = OooO00o.OooO0OO;
            if (iMiniAppLifecycleInterface != null) {
                iMiniAppLifecycleInterface.onStop();
            }
        } catch (Throwable th) {
            TmcLogger.e("globalMiniAppLifcecyclListener callback onStop fail:" + th);
        }
        this.mStarted = false;
    }

    @Override // com.cloud.tmc.miniapp.action.HandlerAction
    public boolean post(Runnable runnable) {
        return HandlerAction.DefaultImpls.post(this, runnable);
    }

    @Override // com.cloud.tmc.miniapp.action.HandlerAction
    public boolean postAtTime(Runnable runnable, long j) {
        return HandlerAction.DefaultImpls.postAtTime(this, runnable, j);
    }

    @Override // com.cloud.tmc.miniapp.action.HandlerAction
    public boolean postDelayed(Object obj, long j, Runnable runnable) {
        return HandlerAction.DefaultImpls.postDelayed(this, obj, j, runnable);
    }

    @Override // com.cloud.tmc.miniapp.action.HandlerAction
    public boolean postDelayed(Runnable runnable, long j) {
        return HandlerAction.DefaultImpls.postDelayed(this, runnable, j);
    }

    @Override // com.cloud.tmc.miniapp.action.HandlerAction
    public void removeCallbacks() {
        HandlerAction.DefaultImpls.removeCallbacks(this);
    }

    @Override // com.cloud.tmc.miniapp.action.HandlerAction
    public void removeCallbacks(Runnable runnable) {
        HandlerAction.DefaultImpls.removeCallbacks(this, runnable);
    }

    @Override // com.cloud.tmc.miniapp.action.HandlerAction
    public void removeCallbacksAndMessages(Object obj) {
        HandlerAction.DefaultImpls.removeCallbacksAndMessages(this, obj);
    }

    public final void setInitDataChannel(int i) {
        this.initDataChannel = i;
    }

    public final void setMResumed(boolean z) {
        this.mResumed = z;
    }

    public final void setMStarted(boolean z) {
        this.mStarted = z;
    }

    @Override // com.cloud.tmc.miniapp.action.ClickAction
    public void setOnClickListener(View.OnClickListener onClickListener, int... iArr) {
        ClickAction.DefaultImpls.setOnClickListener(this, onClickListener, iArr);
    }

    @Override // com.cloud.tmc.miniapp.action.ClickAction
    public void setOnClickListener(View.OnClickListener onClickListener, View... viewArr) {
        ClickAction.DefaultImpls.setOnClickListener(this, onClickListener, viewArr);
    }

    @Override // com.cloud.tmc.miniapp.action.ClickAction
    public void setOnClickListener(int... iArr) {
        ClickAction.DefaultImpls.setOnClickListener(this, iArr);
    }

    @Override // com.cloud.tmc.miniapp.action.ClickAction
    public void setOnClickListener(View... viewArr) {
        ClickAction.DefaultImpls.setOnClickListener(this, viewArr);
    }

    public final void setSavedInstance(Bundle bundle) {
        this.savedInstance = bundle;
    }

    @Override // com.cloud.tmc.miniapp.action.KeyboardAction
    public void showKeyboard(View view) {
        KeyboardAction.DefaultImpls.showKeyboard(this, view);
    }

    @JvmOverloads
    public final void showLoadingDialog() {
        showLoadingDialog$default(this, null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public void showLoadingDialog(final String str) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        this.dialogCount++;
        postDelayed(new Runnable() { // from class: com.cloud.tmc.miniapp.base.b
            @Override // java.lang.Runnable
            public final void run() {
                BaseActivity.showLoadingDialog$lambda$0(BaseActivity.this, str);
            }
        }, 300L);
    }

    public abstract void showStatusLoading();

    /* JADX WARN: Multi-variable type inference failed */
    public void startActivity(Intent intent) {
        Intrinsics.h(intent, "intent");
        super/*android.app.Activity*/.startActivity(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        Intrinsics.h(intent, "intent");
        hideKeyboard(getCurrentFocus());
        super/*androidx.activity.ComponentActivity*/.startActivityForResult(intent, i, bundle);
    }

    public void startActivityForResult(Intent intent, Bundle bundle, OnActivityCallback onActivityCallback) {
        Intrinsics.h(intent, "intent");
        int nextInt = new Random().nextInt((int) Math.pow(2.0d, 16.0d));
        getActivityCallbacks().put(nextInt, onActivityCallback);
        startActivityForResult(intent, nextInt, bundle);
    }

    public void startActivityForResult(Intent intent, OnActivityCallback onActivityCallback) {
        Intrinsics.h(intent, "intent");
        startActivityForResult(intent, (Bundle) null, onActivityCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void startActivityForResult(Class<? extends Activity> cls, OnActivityCallback onActivityCallback) {
        Intrinsics.h(cls, "clazz");
        startActivityForResult(new Intent((Context) this, (Class<?>) cls), (Bundle) null, onActivityCallback);
    }

    @Override // com.cloud.tmc.miniapp.action.KeyboardAction
    public void toggleSoftInput(View view) {
        KeyboardAction.DefaultImpls.toggleSoftInput(this, view);
    }

    public final void updateLoadingContent(String str) {
        w wVar = this.dialog;
        if (wVar != null) {
            Intrinsics.e(wVar);
            if (wVar.isShowing()) {
                OooO0O0 oooO0O0 = this.dialog;
                TextView textView = oooO0O0 != null ? (TextView) oooO0O0.findViewById(R.id.tv_wait_message) : null;
                if (textView == null) {
                    return;
                }
                textView.setText(str);
            }
        }
    }
}
