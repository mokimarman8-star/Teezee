package androidx.fragment.app;

import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.d;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class Fragment$e implements l.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Fragment f8076a;

    Fragment$e(Fragment fragment) {
        this.f8076a = fragment;
    }

    @Override // l.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ActivityResultRegistry apply(Void r32) {
        Fragment fragment = this.f8076a;
        Object obj = fragment.mHost;
        return obj instanceof d ? ((d) obj).getActivityResultRegistry() : fragment.requireActivity().getActivityResultRegistry();
    }
}
