package androidx.core.app;

import android.content.res.Configuration;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f6982a;

    /* renamed from: b, reason: collision with root package name */
    private Configuration f6983b;

    public x(boolean z5) {
        this.f6982a = z5;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public x(boolean z5, Configuration configuration) {
        this(z5);
        Intrinsics.h(configuration, "newConfig");
        this.f6983b = configuration;
    }

    public final boolean a() {
        return this.f6982a;
    }
}
