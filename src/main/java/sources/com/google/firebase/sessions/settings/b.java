package com.google.firebase.sessions.settings;

import android.content.Context;
import android.os.Bundle;
import com.google.firebase.sessions.settings.d;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class b implements d {
    private static final a b = new a(null);
    private final Bundle a;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public b(Context context) {
        Intrinsics.h(context, "context");
        Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        this.a = bundle == null ? Bundle.EMPTY : bundle;
    }

    @Override // com.google.firebase.sessions.settings.d
    public Boolean a() {
        if (this.a.containsKey("firebase_sessions_enabled")) {
            return Boolean.valueOf(this.a.getBoolean("firebase_sessions_enabled"));
        }
        return null;
    }

    @Override // com.google.firebase.sessions.settings.d
    public Duration b() {
        if (this.a.containsKey("firebase_sessions_sessions_restart_timeout")) {
            return Duration.g(DurationKt.s(this.a.getInt("firebase_sessions_sessions_restart_timeout"), DurationUnit.SECONDS));
        }
        return null;
    }

    @Override // com.google.firebase.sessions.settings.d
    public Double c() {
        if (this.a.containsKey("firebase_sessions_sampling_rate")) {
            return Double.valueOf(this.a.getDouble("firebase_sessions_sampling_rate"));
        }
        return null;
    }

    @Override // com.google.firebase.sessions.settings.d
    public Object d(Continuation continuation) {
        return d.a.a(this, continuation);
    }
}
