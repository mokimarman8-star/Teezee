package com.google.firebase.perf.config;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import rc.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class ConfigurationConstants$LogSourceName extends u {
    private static ConfigurationConstants$LogSourceName a;
    private static final Map b = Collections.unmodifiableMap(new HashMap<Long, String>() { // from class: com.google.firebase.perf.config.ConfigurationConstants$LogSourceName.1
        {
            put(461L, "FIREPERF_AUTOPUSH");
            put(462L, "FIREPERF");
            put(675L, "FIREPERF_INTERNAL_LOW");
            put(676L, "FIREPERF_INTERNAL_HIGH");
        }
    });

    private ConfigurationConstants$LogSourceName() {
    }

    public static synchronized ConfigurationConstants$LogSourceName e() {
        ConfigurationConstants$LogSourceName configurationConstants$LogSourceName;
        synchronized (ConfigurationConstants$LogSourceName.class) {
            try {
                if (a == null) {
                    a = new ConfigurationConstants$LogSourceName();
                }
                configurationConstants$LogSourceName = a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return configurationConstants$LogSourceName;
    }

    protected static String f(long j) {
        return (String) b.get(Long.valueOf(j));
    }

    protected static boolean g(long j) {
        return b.containsKey(Long.valueOf(j));
    }

    protected String a() {
        return "com.google.firebase.perf.LogSourceName";
    }

    protected String c() {
        return "fpr_log_source";
    }

    protected String d() {
        return a.c;
    }
}
