package com.transsion.subroom.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Reconstructed Teezee launcher activity.
 *
 * <p>The original DEX starts optional splash-ad services before opening the
 * main screen. The important invariant is that an ad/network failure must
 * never leave the launcher activity visible indefinitely.</p>
 */
public final class SplashActivity extends AppCompatActivity {

    private static final long STARTUP_WATCHDOG_MS = 8_000L;

    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private boolean transitionCompleted;
    private boolean adLoadStarted;
    private long startTimeMs;

    private final Runnable startupWatchdog = () -> {
        if (!transitionCompleted) {
            openMainScreen(false, "startup watchdog timeout");
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startTimeMs = System.currentTimeMillis();

        // The launcher must always have a bounded lifetime, including offline
        // devices, missing ad providers, and vendor-specific Android builds.
        mainHandler.postDelayed(startupWatchdog, STARTUP_WATCHDOG_MS);

        if (isTaskRoot() || "deeplink".equals(getIntent().getStringExtra("from"))) {
            beginStartupServices();
        } else {
            finish();
        }
    }

    private void beginStartupServices() {
        boolean skipColdStartAd = StartupPreferences.getInstance()
                .getBoolean("first_start_not_show_cold_ad", false);

        if (!skipColdStartAd) {
            StartupPreferences.getInstance()
                    .putBoolean("first_start_not_show_cold_ad", true);
            openMainScreen(false, "first launch");
            return;
        }

        // Optional ad initialization is deliberately isolated from the main
        // transition. Its callbacks call onAdFinished(), while the watchdog
        // above handles providers that never call back.
        adLoadStarted = true;
        HiSavanaSplashLoader.getInstance().load(
                this,
                this::onAdFinished,
                this::onAdFinished
        );
    }

    private void onAdFinished(@Nullable SplashAdResult result) {
        if (result != null && result.isRenderable()) {
            showSplashAd(result);
        } else {
            openMainScreen(false, "ad unavailable");
        }
    }

    private void showSplashAd(SplashAdResult result) {
        if (transitionCompleted || isFinishing() || isDestroyed()) {
            return;
        }
        // Rendering the optional ad is allowed only after a valid result. Any
        // renderer failure must fall back to the main screen.
        try {
            SplashAdRenderer.show(this, result, () -> openMainScreen(true, "ad shown"));
        } catch (RuntimeException ignored) {
            openMainScreen(false, "ad renderer failure");
        }
    }

    private void openMainScreen(boolean adWasShown, String reason) {
        if (transitionCompleted || isFinishing() || isDestroyed()) {
            return;
        }
        transitionCompleted = true;
        mainHandler.removeCallbacksAndMessages(null);

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("isSplashAdLoaded", adWasShown);
        intent.putExtra("startup_reason", reason);
        startActivity(intent);
        overridePendingTransition(0, 0);
        finish();
    }

    @Override
    public void onBackPressed() {
        // Do not allow Back to strand the app on a half-initialized launcher.
    }

    @Override
    protected void onDestroy() {
        mainHandler.removeCallbacksAndMessages(null);
        HiSavanaSplashLoader.getInstance().cancel(this);
        super.onDestroy();
    }

    /** Minimal readable facade for the proprietary services present in DEX. */
    private static final class StartupPreferences {
        static StartupPreferences getInstance() { return new StartupPreferences(); }
        boolean getBoolean(String key, boolean fallback) { return fallback; }
        void putBoolean(String key, boolean value) { }
    }

    private static final class HiSavanaSplashLoader {
        static HiSavanaSplashLoader getInstance() { return new HiSavanaSplashLoader(); }
        void load(Activity activity, java.util.function.Consumer<SplashAdResult> success,
                  java.util.function.Consumer<SplashAdResult> failure) { }
        void cancel(Activity activity) { }
    }

    private static final class SplashAdRenderer {
        static void show(Activity activity, SplashAdResult result, Runnable finished) {
            finished.run();
        }
    }

    private static final class SplashAdResult {
        boolean isRenderable() { return false; }
    }
}
