package androidx.navigation;

import android.os.Bundle;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final int f12470a;

    /* renamed from: b, reason: collision with root package name */
    private l f12471b;

    /* renamed from: c, reason: collision with root package name */
    private Bundle f12472c;

    public c(int i5, l lVar, Bundle bundle) {
        this.f12470a = i5;
        this.f12471b = lVar;
        this.f12472c = bundle;
    }

    public /* synthetic */ c(int i5, l lVar, Bundle bundle, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(i5, (i6 & 2) != 0 ? null : lVar, (i6 & 4) != 0 ? null : bundle);
    }

    public final Bundle a() {
        return this.f12472c;
    }

    public final int b() {
        return this.f12470a;
    }

    public final l c() {
        return this.f12471b;
    }

    public final void d(Bundle bundle) {
        this.f12472c = bundle;
    }

    public final void e(l lVar) {
        this.f12471b = lVar;
    }
}
