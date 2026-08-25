package androidx.core.app;

import android.content.res.Configuration;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f6941a;

    /* renamed from: b, reason: collision with root package name */
    private Configuration f6942b;

    public m(boolean z5) {
        this.f6941a = z5;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public m(boolean z5, Configuration configuration) {
        this(z5);
        Intrinsics.h(configuration, "newConfig");
        this.f6942b = configuration;
    }

    public final boolean a() {
        return this.f6941a;
    }
}
