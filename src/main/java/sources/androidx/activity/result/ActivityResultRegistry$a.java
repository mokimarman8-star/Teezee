package androidx.activity.result;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class ActivityResultRegistry$a {

    /* renamed from: a, reason: collision with root package name */
    private final a f115a;

    /* renamed from: b, reason: collision with root package name */
    private final f.a f116b;

    public ActivityResultRegistry$a(a aVar, f.a aVar2) {
        Intrinsics.h(aVar, "callback");
        Intrinsics.h(aVar2, "contract");
        this.f115a = aVar;
        this.f116b = aVar2;
    }

    public final a a() {
        return this.f115a;
    }

    public final f.a b() {
        return this.f116b;
    }
}
