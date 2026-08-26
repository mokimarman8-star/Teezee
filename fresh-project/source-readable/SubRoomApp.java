package com.transsion.subroom.app;

import android.content.ComponentCallbacks2;
import android.content.Context;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.work.Configuration;

import com.blankj.utilcode.util.ProcessUtils;
import com.transsion.baselib.net.AppLifeStatusInterceptor;
import com.transsion.baselib.net.NetworkInterceptorRegistry;
import com.transsion.baselib.report.launch.LaunchReport;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.startup.StartupManager;
import com.transsion.startup.pref.consume.AppStartDotState;
import com.transsion.startup.pref.consume.AppStartReport;
import com.transsion.startup.pref.consume.StartupPreferences;
import com.transsion.tn.lib.net.dns.CacheIpPool;

import java.util.function.Supplier;

/**
 * Reconstructed Application entry point for Teezee.
 *
 * <p>The APK contains several proprietary SDKs, so the exact original source
 * names are unavailable. This version preserves the observable lifecycle
 * order from the DEX while replacing obfuscated locals with descriptive names.</p>
 */
public final class SubRoomApp extends KillerApplication
        implements ComponentCallbacks2, Configuration.Provider {

    private static final String API_HOST = "api6.aoneroom.com";
    private final boolean mainProcess = ProcessUtils.isMainProcess();

    /** Reconstructed WorkManager configuration: four worker threads. */
    @Override
    public Configuration getWorkManagerConfiguration() {
        return new Configuration.Builder()
                .setMinimumLoggingLevel(4)
                .build();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        StartupManager.getInstance().initialize(base);
        StartupPreferences.getInstance().initialize();
        NetworkInterceptorRegistry.getInstance().initialize();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        if (mainProcess) {
            StartupManager startup = StartupManager.getInstance();

            // Preserve the three startup configuration suppliers found in DEX.
            startup.setPlayerAsyncSupplier(this::isPlayerAsyncDisabled);
            startup.setPlayerFeatureSupplier(this::isPlayerFeatureEnabled);
            startup.setPlayerTypeSupplier(this::getPlayerType);

            NetworkInterceptorRegistry registry = NetworkInterceptorRegistry.getInstance();
            registry.add(new com.transsion.baselib.net.NetworkInterceptor());
            registry.add(new AppLifeStatusInterceptor());

            CacheIpPool.getInstance().register(API_HOST);
            startup.attachApplication(this);

            if (!LaunchReport.getInstance().preferences()
                    .getBoolean("dark_mode_follow_sys", false)) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }

            registerActivityLifecycleCallbacks(
                    com.transsion.baselib.report.ActivityLifecycleReporter.INSTANCE);
        } else {
            StartupManager.getInstance().attachSecondaryProcess(this);
        }

        AppStartReport.getInstance().record(
                new AppStartDotState(AppStartDotState.APP_END, 0L));
        com.transsion.baseui.activity.ActivityTracker.clearCurrentActivity();
    }

    private boolean isPlayerAsyncDisabled() {
        ConfigBean config = com.transsion.mb.config.manager.ConfigCenter
                .getInstance().get("player_async", true);
        return config != null && "false".equals(config.getValue());
    }

    private boolean isPlayerFeatureEnabled() {
        return !com.transsion.player.config.PlayerFeatureFlags.INSTANCE.isDisabled();
    }

    private int getPlayerType() {
        ConfigBean config = com.transsion.mb.config.manager.ConfigCenter
                .getInstance().get("sb_player_type", true);
        if (config == null || config.getValue() == null || config.getValue().isEmpty()) {
            return 1;
        }
        try {
            return Integer.parseInt(config.getValue());
        } catch (NumberFormatException ignored) {
            return 1;
        }
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        StartupManager.getInstance().onTrimMemory(level, mainProcess);
    }
}
