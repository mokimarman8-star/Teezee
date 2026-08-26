package com.transsion.baseui.activity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * Readable reconstruction of Teezee's shared Activity base class.
 *
 * <p>The original implementation supplies view binding, status-bar styling,
 * no-network fallback UI, two-level-ad gestures and Android 15 insets. The
 * methods below preserve that responsibility without the decompiler's
 * obfuscated names.</p>
 */
public abstract class BaseActivity<Binding extends ViewBinding>
        extends BaseMusicFloatActivity<Binding> {

    private float touchDownY;
    private float touchMoveY;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        configureStatusBar();
        initializeView(savedInstanceState);
    }

    /** Subclasses may initialize their binding and fragments here. */
    protected void initializeView(@Nullable Bundle state) {
    }

    protected void configureStatusBar() {
        if (!useImmersiveStatusBar()) {
            return;
        }
        WindowInsetsController controller = getWindow().getInsetsController();
        if (controller != null) {
            controller.setSystemBarsAppearance(
                    statusBarUsesDarkIcons() ? WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS : 0,
                    WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
            );
        }
    }

    protected boolean useImmersiveStatusBar() {
        return true;
    }

    protected boolean statusBarUsesDarkIcons() {
        return true;
    }

    protected boolean isTranslucentActivity() {
        return false;
    }

    protected int statusBarColor() {
        return 0;
    }

    /**
     * Android 15 introduced edge-to-edge enforcement for many target-SDK-35
     * windows. Apply navigation-bar insets only to the bottom spacer/content
     * view; do not replace the whole root view with a black surface.
     */
    protected final void applyAndroid15Insets(final View bottomSpacer) {
        if (Build.VERSION.SDK_INT < 35) {
            return;
        }
        ViewCompat.setOnApplyWindowInsetsListener(getWindow().getDecorView(), (view, insets) -> {
            WindowInsetsCompat navigation = insets.isVisible(WindowInsetsCompat.Type.navigationBars())
                    ? insets
                    : null;
            int bottom = navigation == null
                    ? 8
                    : navigation.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
            if (bottomSpacer != null) {
                bottomSpacer.getLayoutParams().height = bottom;
                bottomSpacer.setVisibility(View.VISIBLE);
                bottomSpacer.requestLayout();
            }
            return insets;
        });
    }

    protected final void installContentView(View bindingRoot, int rootLayoutId, int rootContainerId) {
        setContentView(rootLayoutId);
        View container = findViewById(rootContainerId);
        if (container instanceof android.view.ViewGroup && bindingRoot != null) {
            ((android.view.ViewGroup) container).addView(bindingRoot);
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event != null) {
            if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                touchDownY = event.getRawY();
            } else if (event.getActionMasked() == MotionEvent.ACTION_MOVE) {
                touchMoveY = event.getRawY();
                if (Math.abs(touchMoveY - touchDownY) > 50f) {
                    onTwoLevelGesture();
                }
            }
        }
        return super.dispatchTouchEvent(event);
    }

    protected void onTwoLevelGesture() {
    }

    protected void retryLoadData() {
    }

    protected boolean hasAdvertisement() {
        return false;
    }

    protected void loadTwoLevelAdvertisement() {
    }

    protected interface ViewBinding {
        View getRoot();
    }

    protected abstract static class BaseMusicFloatActivity<B extends ViewBinding>
            extends AppCompatActivity {
        protected abstract B getViewBinding();
    }
}
