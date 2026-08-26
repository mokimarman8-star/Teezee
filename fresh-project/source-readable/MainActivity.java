package com.transsion.subroom.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.transsion.baseui.activity.BaseActivity;
import com.transsion.home.fragment.home.HomeFragment;
import com.transsion.home.preload.MainXMLPreloadControlImp;
import com.transsion.home.viewmodel.preload.PreloadTrendingData;
import com.transsion.subroom.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Readable reconstruction of Teezee's main activity.
 *
 * <p>The original class is a large Kotlin/Java class spread across several
 * proprietary libraries. This file keeps the lifecycle and startup order
 * visible, while isolating optional ads, permissions, preload and analytics
 * so one unavailable service cannot prevent the main screen from opening.</p>
 */
public final class MainActivity extends BaseActivity<MainScreenBinding> {

    private final List<Fragment> fragments = new ArrayList<>();
    private Fragment currentFragment;
    private HomeFragment homeFragment;
    private MainXMLPreloadControlImp xmlPreload;
    private boolean startupCompleted;
    private long lastBackPress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        // Do not request all-files access before the Activity has a window.
        // PermissionUtils is intentionally not called here; downloads use
        // app-scoped storage unless the user explicitly starts an export.
        super.onCreate(savedInstanceState);

        try {
            if (android.os.Build.VERSION.SDK_INT >= 29) {
                xmlPreload = new MainXMLPreloadControlImp(this);
            }
        } catch (RuntimeException ignored) {
            xmlPreload = null;
        }

        try {
            setContentView(getViewBinding().getRoot());
            initializeMainUi(savedInstanceState);
            startupCompleted = true;
        } catch (Throwable startupFailure) {
            // Keep diagnostics from masking the actual Activity failure. The
            // real app should log this and show a recovery screen instead of
            // remaining on a blank window.
            StartupDiagnostics.record(this, "MainActivity initialization", startupFailure);
            showRecoveryUi(startupFailure);
        }
    }

    private void initializeMainUi(@Nullable Bundle savedInstanceState) {
        initializePlayerSafely();
        initializeFragmentsSafely(savedInstanceState);
        initializeDownloadAndNoticeServicesSafely();
        initializeOptionalConfigurationSafely();
    }

    private void initializePlayerSafely() {
        try {
            PlayerRuntime.initialize(PlayerRuntime.RenderMode.SURFACE_VIEW);
        } catch (RuntimeException failure) {
            StartupDiagnostics.record(this, "player initialization", failure);
        }
    }

    private void initializeFragmentsSafely(@Nullable Bundle state) {
        try {
            HomeTabModel homeTab = PreloadTrendingData.getInstance().getCachedHomeTab();
            if (homeTab == null) {
                homeTab = HomeTabModel.safeDefaults();
            }
            homeFragment = HomeFragment.newInstance(homeTab);
            fragments.clear();
            fragments.add(homeFragment);
            replaceCurrentFragment(homeFragment, "HOME");
        } catch (RuntimeException failure) {
            StartupDiagnostics.record(this, "fragment initialization", failure);
            showRecoveryUi(failure);
        }
    }

    private void initializeDownloadAndNoticeServicesSafely() {
        try {
            DownloadRuntime.initialize(this);
        } catch (RuntimeException failure) {
            StartupDiagnostics.record(this, "download service initialization", failure);
        }
        try {
            NoticeRuntime.initializeIfNeeded(this);
        } catch (RuntimeException failure) {
            StartupDiagnostics.record(this, "notice initialization", failure);
        }
    }

    private void initializeOptionalConfigurationSafely() {
        try {
            FeatureConfigRuntime.loadAsync(this);
        } catch (RuntimeException failure) {
            StartupDiagnostics.record(this, "feature config initialization", failure);
        }
    }

    private void replaceCurrentFragment(Fragment next, String tag) {
        if (next == null || isFinishing() || isDestroyed()) {
            return;
        }
        androidx.fragment.app.FragmentTransaction transaction =
                getSupportFragmentManager().beginTransaction();
        if (currentFragment != null) {
            transaction.hide(currentFragment);
        }
        if (next.isAdded()) {
            transaction.show(next);
        } else {
            transaction.add(R.id.container, next, tag);
        }
        transaction.commitAllowingStateLoss();
        currentFragment = next;
    }

    private void showRecoveryUi(Throwable failure) {
        // A real implementation uses a local layout with Retry and Report
        // actions. It must never depend on network/config/ad initialization.
        RecoveryScreen.show(this, failure == null ? "Startup failed" : failure.getMessage());
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            OptionalMainScreenTasks.run(this);
        } catch (RuntimeException failure) {
            StartupDiagnostics.record(this, "resume tasks", failure);
        }
    }

    @Override
    protected void onDestroy() {
        try {
            if (xmlPreload != null) {
                xmlPreload.reset();
            }
        } catch (RuntimeException failure) {
            StartupDiagnostics.record(this, "preload cleanup", failure);
        }
        super.onDestroy();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (homeFragment != null) {
            homeFragment.onConfigurationChanged(newConfig);
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }

    @Override
    public void onBackPressed() {
        long now = System.currentTimeMillis();
        if (now - lastBackPress < 3_000L) {
            super.onBackPressed();
        } else {
            lastBackPress = now;
            android.widget.Toast.makeText(this, "Press back again to exit", android.widget.Toast.LENGTH_SHORT).show();
        }
    }

    // These facades document the original proprietary integration points. In
    // the recovered APK they are backed by classes in the bundled DEX files.
    private static final class MainScreenBinding {
        android.view.View getRoot() { return new android.view.View(null); }
    }
    private static final class PlayerRuntime {
        enum RenderMode { SURFACE_VIEW }
        static void initialize(RenderMode mode) { }
    }
    private static final class HomeTabModel {
        static HomeTabModel safeDefaults() { return new HomeTabModel(); }
    }
    private static final class DownloadRuntime { static void initialize(MainActivity a) { } }
    private static final class NoticeRuntime { static void initializeIfNeeded(MainActivity a) { } }
    private static final class FeatureConfigRuntime { static void loadAsync(MainActivity a) { } }
    private static final class OptionalMainScreenTasks { static void run(MainActivity a) { } }
    private static final class RecoveryScreen {
        static void show(MainActivity a, String message) {
            android.widget.Toast.makeText(a, message == null ? "Unable to open Teezee" : message, android.widget.Toast.LENGTH_LONG).show();
        }
    }
    private static final class StartupDiagnostics {
        static void record(MainActivity a, String stage, Throwable t) {
            android.util.Log.e("TeezeeStartup", stage, t);
        }
    }
}
