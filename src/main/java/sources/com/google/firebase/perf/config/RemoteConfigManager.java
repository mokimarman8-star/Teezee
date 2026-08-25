package com.google.firebase.perf.config;

import ad.k;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.f;
import com.google.firebase.n;
import com.google.firebase.perf.util.e;
import com.google.firebase.remoteconfig.a;
import com.google.firebase.remoteconfig.c;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kc.b;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class RemoteConfigManager {
    private static final long FETCH_NEVER_HAPPENED_TIMESTAMP_MS = 0;
    private static final String FIREPERF_FRC_NAMESPACE_NAME = "fireperf";
    private static final long MIN_APP_START_CONFIG_FETCH_DELAY_MS = 5000;
    private static final int RANDOM_APP_START_CONFIG_FETCH_DELAY_MS = 25000;
    private final ConcurrentHashMap<String, k> allRcConfigMap;
    private final long appStartConfigFetchDelayInMs;
    private final long appStartTimeInMs;
    private final w cache;
    private final Executor executor;

    @Nullable
    private a firebaseRemoteConfig;
    private long firebaseRemoteConfigLastFetchTimestampMs;

    @Nullable
    private b firebaseRemoteConfigProvider;
    private static final uc.a logger = uc.a.e();
    private static final RemoteConfigManager instance = new RemoteConfigManager();
    private static final long TIME_AFTER_WHICH_A_FETCH_IS_CONSIDERED_STALE_MS = TimeUnit.HOURS.toMillis(12);

    @SuppressLint({"ThreadPoolCreation"})
    private RemoteConfigManager() {
        this(w.e(), new ThreadPoolExecutor(0, 1, FETCH_NEVER_HAPPENED_TIMESTAMP_MS, TimeUnit.SECONDS, new LinkedBlockingQueue()), null, MIN_APP_START_CONFIG_FETCH_DELAY_MS + new Random().nextInt(RANDOM_APP_START_CONFIG_FETCH_DELAY_MS), getInitialStartupMillis());
    }

    RemoteConfigManager(w wVar, Executor executor, a aVar, long j, long j2) {
        this.firebaseRemoteConfigLastFetchTimestampMs = FETCH_NEVER_HAPPENED_TIMESTAMP_MS;
        this.cache = wVar;
        this.executor = executor;
        this.firebaseRemoteConfig = aVar;
        this.allRcConfigMap = aVar == null ? new ConcurrentHashMap<>() : new ConcurrentHashMap<>(aVar.i());
        this.appStartTimeInMs = j2;
        this.appStartConfigFetchDelayInMs = j;
    }

    static long getInitialStartupMillis() {
        n nVar;
        try {
            nVar = (n) f.l().j(n.class);
        } catch (IllegalStateException unused) {
            logger.a("Unable to get StartupTime instance.");
            nVar = null;
        }
        return nVar != null ? nVar.c() : System.currentTimeMillis();
    }

    public static RemoteConfigManager getInstance() {
        return instance;
    }

    private k getRemoteConfigValue(String str) {
        triggerRemoteConfigFetchIfNecessary();
        if (!isFirebaseRemoteConfigAvailable() || !this.allRcConfigMap.containsKey(str)) {
            return null;
        }
        k kVar = this.allRcConfigMap.get(str);
        if (kVar.a() != 2) {
            return null;
        }
        logger.b("Fetched value: '%s' for key: '%s' from Firebase Remote Config.", new Object[]{kVar.b(), str});
        return kVar;
    }

    public static int getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    private boolean hasAppStartConfigFetchDelayElapsed(long j) {
        return j - this.appStartTimeInMs >= this.appStartConfigFetchDelayInMs;
    }

    private boolean hasLastFetchBecomeStale(long j) {
        return j - this.firebaseRemoteConfigLastFetchTimestampMs > TIME_AFTER_WHICH_A_FETCH_IS_CONSIDERED_STALE_MS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch$0(Boolean bool) {
        syncConfigValues(this.firebaseRemoteConfig.i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch$1(Exception exc) {
        logger.k("Call to Remote Config failed: %s. This may cause a degraded experience with Firebase Performance. Please reach out to Firebase Support https://firebase.google.com/support/", new Object[]{exc});
        this.firebaseRemoteConfigLastFetchTimestampMs = FETCH_NEVER_HAPPENED_TIMESTAMP_MS;
    }

    private boolean shouldFetchAndActivateRemoteConfigValues() {
        long currentSystemTimeMillis = getCurrentSystemTimeMillis();
        return hasAppStartConfigFetchDelayElapsed(currentSystemTimeMillis) && hasLastFetchBecomeStale(currentSystemTimeMillis);
    }

    private void triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch() {
        this.firebaseRemoteConfigLastFetchTimestampMs = getCurrentSystemTimeMillis();
        this.firebaseRemoteConfig.h().addOnSuccessListener(this.executor, new OnSuccessListener() { // from class: com.google.firebase.perf.config.x
            public final void onSuccess(Object obj) {
                RemoteConfigManager.this.lambda$triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch$0((Boolean) obj);
            }
        }).addOnFailureListener(this.executor, new OnFailureListener() { // from class: com.google.firebase.perf.config.y
            public final void onFailure(Exception exc) {
                RemoteConfigManager.this.lambda$triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch$1(exc);
            }
        });
    }

    private void triggerRemoteConfigFetchIfNecessary() {
        if (isFirebaseRemoteConfigAvailable()) {
            if (this.allRcConfigMap.isEmpty()) {
                this.allRcConfigMap.putAll(this.firebaseRemoteConfig.i());
            }
            if (shouldFetchAndActivateRemoteConfigValues()) {
                triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch();
            }
        }
    }

    public e getBoolean(String str) {
        if (str == null) {
            logger.a("The key to get Remote Config boolean value is null.");
            return e.a();
        }
        k remoteConfigValue = getRemoteConfigValue(str);
        if (remoteConfigValue != null) {
            try {
                return e.e(Boolean.valueOf(remoteConfigValue.e()));
            } catch (IllegalArgumentException unused) {
                if (!remoteConfigValue.b().isEmpty()) {
                    logger.b("Could not parse value: '%s' for key: '%s'.", new Object[]{remoteConfigValue.b(), str});
                }
            }
        }
        return e.a();
    }

    protected long getCurrentSystemTimeMillis() {
        return System.currentTimeMillis();
    }

    public e getDouble(String str) {
        if (str == null) {
            logger.a("The key to get Remote Config double value is null.");
            return e.a();
        }
        k remoteConfigValue = getRemoteConfigValue(str);
        if (remoteConfigValue != null) {
            try {
                return e.e(Double.valueOf(remoteConfigValue.d()));
            } catch (IllegalArgumentException unused) {
                if (!remoteConfigValue.b().isEmpty()) {
                    logger.b("Could not parse value: '%s' for key: '%s'.", new Object[]{remoteConfigValue.b(), str});
                }
            }
        }
        return e.a();
    }

    public e getLong(String str) {
        if (str == null) {
            logger.a("The key to get Remote Config long value is null.");
            return e.a();
        }
        k remoteConfigValue = getRemoteConfigValue(str);
        if (remoteConfigValue != null) {
            try {
                return e.e(Long.valueOf(remoteConfigValue.c()));
            } catch (IllegalArgumentException unused) {
                if (!remoteConfigValue.b().isEmpty()) {
                    logger.b("Could not parse value: '%s' for key: '%s'.", new Object[]{remoteConfigValue.b(), str});
                }
            }
        }
        return e.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T getRemoteConfigValueOrDefault(String str, T t) {
        Object obj;
        k remoteConfigValue = getRemoteConfigValue(str);
        if (remoteConfigValue == null) {
            return t;
        }
        try {
            if (t instanceof Boolean) {
                obj = Boolean.valueOf(remoteConfigValue.e());
            } else if (t instanceof Double) {
                obj = Double.valueOf(remoteConfigValue.d());
            } else {
                if (!(t instanceof Long) && !(t instanceof Integer)) {
                    if (!(t instanceof String)) {
                        T t2 = (T) remoteConfigValue.b();
                        try {
                            logger.b("No matching type found for the defaultValue: '%s', using String.", new Object[]{t});
                            return t2;
                        } catch (IllegalArgumentException unused) {
                            t = t2;
                            if (remoteConfigValue.b().isEmpty()) {
                                return t;
                            }
                            logger.b("Could not parse value: '%s' for key: '%s'.", new Object[]{remoteConfigValue.b(), str});
                            return t;
                        }
                    }
                    obj = remoteConfigValue.b();
                }
                obj = Long.valueOf(remoteConfigValue.c());
            }
            return obj;
        } catch (IllegalArgumentException unused2) {
        }
    }

    public e getString(String str) {
        if (str == null) {
            logger.a("The key to get Remote Config String value is null.");
            return e.a();
        }
        k remoteConfigValue = getRemoteConfigValue(str);
        return remoteConfigValue != null ? e.e(remoteConfigValue.b()) : e.a();
    }

    public boolean isFirebaseRemoteConfigAvailable() {
        b bVar;
        c cVar;
        if (this.firebaseRemoteConfig == null && (bVar = this.firebaseRemoteConfigProvider) != null && (cVar = (c) bVar.get()) != null) {
            this.firebaseRemoteConfig = cVar.e(FIREPERF_FRC_NAMESPACE_NAME);
        }
        return this.firebaseRemoteConfig != null;
    }

    public boolean isLastFetchFailed() {
        a aVar = this.firebaseRemoteConfig;
        return aVar == null || aVar.j().a() == 1 || this.firebaseRemoteConfig.j().a() == 2;
    }

    public void setFirebaseRemoteConfigProvider(@Nullable b bVar) {
        this.firebaseRemoteConfigProvider = bVar;
    }

    protected void syncConfigValues(Map<String, k> map) {
        this.allRcConfigMap.putAll(map);
        for (String str : this.allRcConfigMap.keySet()) {
            if (!map.containsKey(str)) {
                this.allRcConfigMap.remove(str);
            }
        }
        d e = d.e();
        k kVar = this.allRcConfigMap.get(e.c());
        if (kVar == null) {
            logger.a("ExperimentTTID remote config flag does not exist.");
            return;
        }
        try {
            this.cache.m(e.a(), kVar.e());
        } catch (Exception unused) {
            logger.a("ExperimentTTID remote config flag has invalid value, expected boolean.");
        }
    }
}
