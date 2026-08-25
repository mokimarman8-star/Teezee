package com.transsion.shorttv.base.activity;

import android.R;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import com.gyf.immersionbar.ImmersionBar;
import com.transsion.gslb.BuildConfig;
import com.transsion.shorttv.base.locale.d;
import f4.a;
import hr.e;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ur.j;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0010\u0010\u0006J\u000f\u0010\u0011\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0011\u0010\u0006J\u0019\u0010\u0012\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0012\u0010\u000fJ\u000f\u0010\u0013\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0006J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001b\u0010\u0016J\u000f\u0010\u001c\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001c\u0010\u0016J\u000f\u0010\u001d\u001a\u00020\tH\u0014¢\u0006\u0004\b\u001d\u0010\u0006J\u000f\u0010\u001e\u001a\u00020\tH\u0014¢\u0006\u0004\b\u001e\u0010\u0006J\u000f\u0010\u001f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001f\u0010\u0006J\u000f\u0010 \u001a\u00020\u0014H\u0016¢\u0006\u0004\b \u0010\u0016J\u000f\u0010!\u001a\u00020\tH\u0016¢\u0006\u0004\b!\u0010\u0006J\u0019\u0010$\u001a\u00020\u00142\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b$\u0010%R\u001d\u0010+\u001a\u0004\u0018\u00010&8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010.¨\u00062"}, d2 = {"Lcom/transsion/shorttv/base/activity/BaseActivity;", "Lf4/a;", "T", "Lcom/transsion/shorttv/base/activity/BaseMusicFloatActivity;", "Lhr/e;", "<init>", "()V", "Landroid/content/Context;", "newBase", BuildConfig.FLAVOR, "attachBaseContext", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "setView", "onStart", "initView", "setStatusBar", BuildConfig.FLAVOR, "setImmersionStatusBar", "()Z", "isChangeStatusBar", BuildConfig.FLAVOR, "statusColor", "()I", "isStatusDark", "isTranslucent", "onStop", "onDestroy", "onResume", "isAttach", "onPause", "Landroid/view/MotionEvent;", "event", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "Lqi/b;", "d", "Lkotlin/Lazy;", "getLogViewConfig", "()Lqi/b;", "logViewConfig", BuildConfig.FLAVOR, "e", "F", "downY", "f", "moveY", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class BaseActivity<T extends f4.a> extends BaseMusicFloatActivity<T> implements hr.e {

    /* renamed from: d, reason: from kotlin metadata */
    private final Lazy logViewConfig = LazyKt.b(new Function0() { // from class: com.transsion.shorttv.base.activity.a
        public final Object invoke() {
            qi.b U;
            U = BaseActivity.U(BaseActivity.this);
            return U;
        }
    });

    /* renamed from: e, reason: from kotlin metadata */
    private float downY;

    /* renamed from: f, reason: from kotlin metadata */
    private float moveY;

    /* JADX INFO: Access modifiers changed from: private */
    public static final qi.b U(BaseActivity baseActivity) {
        return baseActivity.newLogViewConfig();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat V(View view, WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.h(view, "v");
        Intrinsics.h(windowInsetsCompat, "insets");
        z0.c insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.g(insets, "getInsets(...)");
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), insets.d);
        return WindowInsetsCompat.CONSUMED;
    }

    protected void attachBaseContext(Context newBase) {
        if (newBase == null) {
            super.attachBaseContext(newBase);
        } else {
            d.b bVar = com.transsion.shorttv.base.locale.d.f;
            super.attachBaseContext(bVar.i(newBase, bVar.e().h()));
        }
    }

    @Override // com.transsion.shorttv.base.activity.BaseMusicFloatActivity
    public boolean dispatchTouchEvent(MotionEvent event) {
        j P;
        Integer valueOf = event != null ? Integer.valueOf(event.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            this.downY = event.getRawY();
        } else if (valueOf != null && valueOf.intValue() == 2) {
            float rawY = event.getRawY();
            this.moveY = rawY;
            if (Math.abs(rawY - this.downY) > 50.0f && (P = P()) != null) {
                P.b();
            }
        }
        return super.dispatchTouchEvent(event);
    }

    @Override // hr.e
    public qi.b getLogViewConfig() {
        return (qi.b) this.logViewConfig.getValue();
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

    public qi.b newLogViewConfig() {
        return e.a.a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.shorttv.base.activity.BaseCommonActivity
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().clearFlags(134217728);
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setNavigationBarColor(-16777216);
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 35) {
            WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
            View findViewById = getWindow().getDecorView().findViewById(R.id.content);
            ViewCompat.setOnApplyWindowInsetsListener(findViewById, new OnApplyWindowInsetsListener() { // from class: com.transsion.shorttv.base.activity.b
                public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    WindowInsetsCompat V;
                    V = BaseActivity.V(view, windowInsetsCompat);
                    return V;
                }
            });
            findViewById.setBackgroundColor(-16777216);
        }
        setStatusBar();
        initView(savedInstanceState);
    }

    @Override // com.transsion.shorttv.base.activity.BaseCommonActivity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // com.transsion.shorttv.base.activity.BaseCommonActivity
    public void onPause() {
        super.onPause();
        e.a.b(this);
    }

    @Override // com.transsion.shorttv.base.activity.BaseCommonActivity
    public void onResume() {
        j P;
        super.onResume();
        e.a.c(this);
        if (!isAttach() || (P = P()) == null) {
            return;
        }
        P.a(new WeakReference(this));
    }

    protected void onStart() {
        super.onStart();
    }

    protected void onStop() {
        j P;
        super.onStop();
        if (!isAttach() || (P = P()) == null) {
            return;
        }
        P.e(new WeakReference(this));
    }

    public boolean setImmersionStatusBar() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setStatusBar() {
        if (setImmersionStatusBar()) {
            ImmersionBar with = ImmersionBar.with(this);
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
            } else {
                with.statusBarDarkFont(false);
            }
            with.init();
        }
    }

    @Override // com.transsion.shorttv.base.activity.BaseCommonActivity
    protected void setView() {
        setContentView(com.transsion.shorttv.R.layout.short_tv_base_layout_with_no_network);
        FrameLayout frameLayout = (FrameLayout) findViewById(com.transsion.shorttv.R.id.llRootView);
        if (frameLayout != null) {
            frameLayout.addView(getMViewBinding().getRoot());
        }
    }

    public int statusColor() {
        return com.transsion.shorttv.R.color.image_skeleton;
    }
}
