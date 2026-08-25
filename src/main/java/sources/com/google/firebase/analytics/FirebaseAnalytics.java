package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdy;
import com.google.android.gms.measurement.internal.zzlb;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.installations.c;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class FirebaseAnalytics {
    private static volatile FirebaseAnalytics c;
    private final zzdy a;
    private ExecutorService b;

    private FirebaseAnalytics(zzdy zzdyVar) {
        Preconditions.checkNotNull(zzdyVar);
        this.a = zzdyVar;
    }

    private final ExecutorService b() {
        ExecutorService executorService;
        synchronized (FirebaseAnalytics.class) {
            try {
                if (this.b == null) {
                    this.b = new a(this, 0, 1, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue(100));
                }
                executorService = this.b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return executorService;
    }

    @NonNull
    @Keep
    public static FirebaseAnalytics getInstance(@NonNull Context context) {
        if (c == null) {
            synchronized (FirebaseAnalytics.class) {
                try {
                    if (c == null) {
                        c = new FirebaseAnalytics(zzdy.zza(context));
                    }
                } finally {
                }
            }
        }
        return c;
    }

    @Nullable
    @Keep
    public static zzlb getScionFrontendApiImplementation(Context context, @Nullable Bundle bundle) {
        zzdy zza = zzdy.zza(context, (String) null, (String) null, (String) null, bundle);
        if (zza == null) {
            return null;
        }
        return new d(zza);
    }

    @NonNull
    public final Task<String> getAppInstanceId() {
        try {
            return Tasks.call(b(), new c(this));
        } catch (RuntimeException e) {
            this.a.zza(5, "Failed to schedule task for getAppInstanceId", (Object) null, (Object) null, (Object) null);
            return Tasks.forException(e);
        }
    }

    @NonNull
    @Keep
    public final String getFirebaseInstanceId() {
        try {
            return (String) Tasks.await(c.p().getId(), 30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        } catch (ExecutionException e3) {
            throw new IllegalStateException(e3.getCause());
        } catch (TimeoutException unused) {
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        }
    }

    @NonNull
    public final Task<Long> getSessionId() {
        try {
            return Tasks.call(b(), new b(this));
        } catch (RuntimeException e) {
            this.a.zza(5, "Failed to schedule task for getSessionId", (Object) null, (Object) null, (Object) null);
            return Tasks.forException(e);
        }
    }

    public final void logEvent(@NonNull String str, @Nullable Bundle bundle) {
        this.a.zza(str, bundle);
    }

    public final void resetAnalyticsData() {
        this.a.zzj();
    }

    public final void setAnalyticsCollectionEnabled(boolean z) {
        this.a.zza(Boolean.valueOf(z));
    }

    public final void setConsent(@NonNull Map<ConsentType, ConsentStatus> map) {
        Bundle bundle = new Bundle();
        ConsentStatus consentStatus = map.get(ConsentType.AD_STORAGE);
        if (consentStatus != null) {
            int ordinal = consentStatus.ordinal();
            if (ordinal == 0) {
                bundle.putString("ad_storage", "granted");
            } else if (ordinal == 1) {
                bundle.putString("ad_storage", "denied");
            }
        }
        ConsentStatus consentStatus2 = map.get(ConsentType.ANALYTICS_STORAGE);
        if (consentStatus2 != null) {
            int ordinal2 = consentStatus2.ordinal();
            if (ordinal2 == 0) {
                bundle.putString("analytics_storage", "granted");
            } else if (ordinal2 == 1) {
                bundle.putString("analytics_storage", "denied");
            }
        }
        ConsentStatus consentStatus3 = map.get(ConsentType.AD_USER_DATA);
        if (consentStatus3 != null) {
            int ordinal3 = consentStatus3.ordinal();
            if (ordinal3 == 0) {
                bundle.putString("ad_user_data", "granted");
            } else if (ordinal3 == 1) {
                bundle.putString("ad_user_data", "denied");
            }
        }
        ConsentStatus consentStatus4 = map.get(ConsentType.AD_PERSONALIZATION);
        if (consentStatus4 != null) {
            int ordinal4 = consentStatus4.ordinal();
            if (ordinal4 == 0) {
                bundle.putString("ad_personalization", "granted");
            } else if (ordinal4 == 1) {
                bundle.putString("ad_personalization", "denied");
            }
        }
        this.a.zzc(bundle);
    }

    @Keep
    @Deprecated
    public final void setCurrentScreen(@NonNull Activity activity, @Nullable String str, @Nullable String str2) {
        this.a.zza(activity, str, str2);
    }

    public final void setDefaultEventParameters(@Nullable Bundle bundle) {
        if (bundle != null) {
            bundle = new Bundle(bundle);
        }
        this.a.zzd(bundle);
    }

    public final void setSessionTimeoutDuration(long j) {
        this.a.zza(j);
    }

    public final void setUserId(@Nullable String str) {
        this.a.zzd(str);
    }

    public final void setUserProperty(@NonNull String str, @Nullable String str2) {
        this.a.zzb(str, str2);
    }
}
