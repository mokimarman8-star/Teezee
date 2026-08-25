package androidx.fragment.app;

import androidx.activity.result.ActivityResultRegistry;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class Fragment$f implements l.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ActivityResultRegistry f8077a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Fragment f8078b;

    Fragment$f(Fragment fragment, ActivityResultRegistry activityResultRegistry) {
        this.f8078b = fragment;
        this.f8077a = activityResultRegistry;
    }

    @Override // l.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ActivityResultRegistry apply(Void r12) {
        return this.f8077a;
    }
}
