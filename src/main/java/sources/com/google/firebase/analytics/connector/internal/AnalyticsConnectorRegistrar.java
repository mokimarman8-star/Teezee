package com.google.firebase.analytics.connector.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.f;
import hc.d;
import java.util.Arrays;
import java.util.List;
import mb.a;
import ob.c;
import ob.r;
import zc.h;

@Keep
@KeepForSdk
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class AnalyticsConnectorRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    @NonNull
    @Keep
    @SuppressLint({"MissingPermission"})
    @KeepForSdk
    public List<c> getComponents() {
        return Arrays.asList(c.c(a.class).b(r.k(f.class)).b(r.k(Context.class)).b(r.k(d.class)).f(new b()).e().d(), h.b("fire-analytics", "22.1.2"));
    }
}
