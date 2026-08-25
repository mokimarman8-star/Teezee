package com.transsion.baseui.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsetsController;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.z;
import com.gyf.immersionbar.ImmersionBar;
import com.therouter.TheRouter;
import com.tn.lib.view.DefaultView;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$mipmap;
import com.tn.lib.widget.R$string;
import com.transsion.baselib.locale.d;
import com.transsion.baselib.report.g;
import com.transsion.baseui.R$id;
import com.transsion.baseui.R$layout;
import f4.a;
import ij.y;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0010\u0010\u0006J\u000f\u0010\u0011\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0011\u0010\u0006J\u0019\u0010\u0012\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0012\u0010\u000fJ\u000f\u0010\u0013\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0006J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001b\u0010\u0016J\u000f\u0010\u001c\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001c\u0010\u0016J\u000f\u0010\u001d\u001a\u00020\tH\u0014¢\u0006\u0004\b\u001d\u0010\u0006J\u000f\u0010\u001e\u001a\u00020\tH\u0014¢\u0006\u0004\b\u001e\u0010\u0006J\u000f\u0010\u001f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001f\u0010\u0006J\u000f\u0010 \u001a\u00020\u0014H\u0016¢\u0006\u0004\b \u0010\u0016J!\u0010#\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00142\b\b\u0002\u0010\"\u001a\u00020\u0014H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\tH\u0016¢\u0006\u0004\b%\u0010\u0006J\u001d\u0010)\u001a\u00020(2\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0014¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\tH\u0016¢\u0006\u0004\b+\u0010\u0006J\u0017\u0010-\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010(¢\u0006\u0004\b-\u0010.J\u0019\u00101\u001a\u00020\u00142\b\u00100\u001a\u0004\u0018\u00010/H\u0016¢\u0006\u0004\b1\u00102J'\u00108\u001a\u00020\t2\u0006\u00104\u001a\u0002032\u0006\u00106\u001a\u0002052\u0006\u00107\u001a\u000205H\u0016¢\u0006\u0004\b8\u00109J4\u0010?\u001a\u00020\t2#\u0010>\u001a\u001f\u0012\u0013\u0012\u001103¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020\t\u0018\u00010:H\u0016¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020\u0014H\u0016¢\u0006\u0004\bA\u0010\u0016J\u000f\u0010B\u001a\u00020\tH\u0016¢\u0006\u0004\bB\u0010\u0006R\u001d\u0010H\u001a\u0004\u0018\u00010C8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u0016\u0010I\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010K\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010J¨\u0006L"}, d2 = {"Lcom/transsion/baseui/activity/BaseActivity;", "Lf4/a;", "T", "Lcom/transsion/baseui/activity/BaseMusicFloatActivity;", "Lcom/transsion/baselib/report/g;", "<init>", "()V", "Landroid/content/Context;", "newBase", "", "attachBaseContext", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "setView", "onStart", "initView", "setStatusBar", "", "setImmersionStatusBar", "()Z", "isChangeStatusBar", "", "statusColor", "()I", "isStatusDark", "isTranslucent", "onStop", "onDestroy", "onResume", "isAttach", "isWhiteFont", "isHomeFragment", "changeStatusFontColor", "(ZZ)V", "onPause", "context", "showNoNetwork", "Landroid/view/View;", "getEmptyView", "(Landroid/content/Context;Z)Landroid/view/View;", "retryLoadData", "bottomView", "fitAndroidV", "(Landroid/view/View;)V", "Landroid/view/MotionEvent;", "event", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "", "action", "", "distance", "progress", "onAction", "(Ljava/lang/String;FF)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "state", "callback", "setStateCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasAd", "loadTwoLevelAd", "Lqi/b;", "logViewConfig$delegate", "Lkotlin/Lazy;", "getLogViewConfig", "()Lqi/b;", "logViewConfig", "downY", "F", "moveY", "BaseUI_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class BaseActivity<T extends a> extends BaseMusicFloatActivity<T> implements g {
    public static final int $stable = 8;
    private float downY;

    /* renamed from: logViewConfig$delegate, reason: from kotlin metadata */
    private final Lazy logViewConfig = LazyKt.b(new Function0() { // from class: com.transsion.baseui.activity.b
        public final Object invoke() {
            qi.b a0;
            a0 = BaseActivity.a0(BaseActivity.this);
            return a0;
        }
    });
    private float moveY;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final WindowInsetsCompat Y(View view, BaseActivity baseActivity, View view2, WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.h(windowInsetsCompat, "insets");
        int b = windowInsetsCompat.isVisible(WindowInsetsCompat.Type.navigationBars()) ? windowInsetsCompat.getInsets(WindowInsetsCompat.Type.navigationBars()).d : lj.a.b(8);
        if (b > 0) {
            if (view != null) {
                view.getLayoutParams().height = b;
                view.setVisibility(0);
            } else {
                if (view2 != null) {
                    view2.setPadding(0, 0, 0, b);
                }
                if (view2 != null) {
                    view2.setBackgroundColor(androidx.core.content.b.getColor(baseActivity, R$color.bg_01));
                }
            }
        }
        WindowInsetsController a = z.a(baseActivity.getWindow().getDecorView());
        if (a != null) {
            a.setSystemBarsAppearance(0, 16);
        }
        ViewCompat.setOnApplyWindowInsetsListener(baseActivity.getWindow().getDecorView(), null);
        return windowInsetsCompat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(BaseActivity baseActivity, DefaultView defaultView, View view) {
        baseActivity.retryLoadData();
        defaultView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qi.b a0(BaseActivity baseActivity) {
        return baseActivity.newLogViewConfig();
    }

    public static /* synthetic */ void changeStatusFontColor$default(BaseActivity baseActivity, boolean z, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: changeStatusFontColor");
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        baseActivity.changeStatusFontColor(z, z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context newBase) {
        if (newBase == null) {
            super/*androidx.appcompat.app.AppCompatActivity*/.attachBaseContext(newBase);
        } else {
            d.b bVar = d.f;
            super/*androidx.appcompat.app.AppCompatActivity*/.attachBaseContext(bVar.k(newBase, bVar.e().j()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void changeStatusFontColor(boolean isWhiteFont, boolean isHomeFragment) {
        ImmersionBar with = ImmersionBar.with((Activity) this);
        boolean z = false;
        if (!isWhiteFont && !y.a.a()) {
            z = true;
        }
        with.statusBarDarkFont(z);
        with.init();
    }

    public boolean dispatchTouchEvent(MotionEvent event) {
        ep.b bVar;
        Integer valueOf = event != null ? Integer.valueOf(event.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            this.downY = event.getRawY();
        } else if (valueOf != null && valueOf.intValue() == 2) {
            float rawY = event.getRawY();
            this.moveY = rawY;
            if (Math.abs(rawY - this.downY) > 50.0f && (bVar = (ep.b) TheRouter.d(ep.b.class, new Object[0])) != null) {
                bVar.b();
            }
        }
        return super.dispatchTouchEvent(event);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void fitAndroidV(View bottomView) {
        if (Build.VERSION.SDK_INT >= 35) {
            ViewCompat.setOnApplyWindowInsetsListener(getWindow().getDecorView(), new c(bottomView, this));
        }
    }

    public final View getEmptyView(Context context, boolean showNoNetwork) {
        Intrinsics.h(context, "context");
        DefaultView defaultView = new DefaultView(context);
        defaultView.setDefaultImageViewVisibility(0);
        if (showNoNetwork) {
            defaultView.setDefaultImage(R$mipmap.ic_no_network);
            String string = context.getString(R$string.no_network_toast);
            Intrinsics.g(string, "getString(...)");
            defaultView.setDescText(string);
        } else {
            defaultView.setDefaultImage(R$mipmap.ic_no_content);
            String string2 = context.getString(R$string.no_content);
            Intrinsics.g(string2, "getString(...)");
            defaultView.setDescText(string2);
        }
        defaultView.setStyle(DefaultView.DefaultViewStyle.STYLE_IMAGE_DESC_BTN);
        defaultView.setBtnVisibility(0);
        String string3 = context.getString(com.transsion.baseui.R$string.retry_text);
        Intrinsics.g(string3, "getString(...)");
        defaultView.setBtnText(string3);
        defaultView.setBtnClickListener(new a(this, defaultView));
        defaultView.setVisibility(0);
        return defaultView;
    }

    public qi.b getLogViewConfig() {
        return (qi.b) this.logViewConfig.getValue();
    }

    public boolean hasAd() {
        return false;
    }

    public void initView(Bundle savedInstanceState) {
    }

    public boolean isAttach() {
        return true;
    }

    public boolean isChangeStatusBar() {
        return false;
    }

    public boolean isStatusDark() {
        return true;
    }

    public boolean isTranslucent() {
        return false;
    }

    public void loadTwoLevelAd() {
    }

    public qi.b newLogViewConfig() {
        return g.a.a(this);
    }

    public void onAction(String action, float distance, float progress) {
        Intrinsics.h(action, "action");
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super/*com.transsion.baseui.activity.BaseCommonActivity*/.onCreate(savedInstanceState);
        setStatusBar();
        initView(savedInstanceState);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDestroy() {
        super/*com.transsion.baseui.activity.BaseCommonActivity*/.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onPause() {
        super/*com.transsion.baseui.activity.BaseCommonActivity*/.onPause();
        g.a.b(this);
    }

    public void onResume() {
        ep.b bVar;
        super.onResume();
        g.a.c(this);
        if (!isAttach() || (bVar = (ep.b) TheRouter.d(ep.b.class, new Object[0])) == null) {
            return;
        }
        bVar.g(new WeakReference(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onStart() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStart();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onStop() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStop();
        ep.b bVar = (ep.b) TheRouter.d(ep.b.class, new Object[0]);
        if (bVar != null) {
            bVar.i(new WeakReference(this));
        }
    }

    public void retryLoadData() {
    }

    public boolean setImmersionStatusBar() {
        return true;
    }

    public void setStateCallback(Function1<? super String, Unit> callback) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setStatusBar() {
        if (setImmersionStatusBar()) {
            ImmersionBar with = ImmersionBar.with((Activity) this);
            if (isChangeStatusBar()) {
                with.statusBarColor(statusColor());
            }
            if (isTranslucent()) {
                with.statusBarAlpha(0.0f);
            } else {
                with.statusBarAlpha(1.0f);
            }
            if (isStatusDark()) {
                with.statusBarDarkFont(true);
            }
            with.init();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void setView() {
        setContentView(R$layout.base_layout_with_no_network);
        FrameLayout frameLayout = (FrameLayout) findViewById(R$id.llRootView);
        if (frameLayout != null) {
            frameLayout.addView(getMViewBinding().getRoot());
        }
    }

    public int statusColor() {
        return R$color.bg_01;
    }
}
