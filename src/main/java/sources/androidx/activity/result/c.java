package androidx.activity.result;

import androidx.lifecycle.Lifecycle;
import androidx.view.r;
import androidx.view.u;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final /* synthetic */ class c implements r {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityResultRegistry f129a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f130b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f131c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ f.a f132d;

    public /* synthetic */ c(ActivityResultRegistry activityResultRegistry, String str, a aVar, f.a aVar2) {
        this.f129a = activityResultRegistry;
        this.f130b = str;
        this.f131c = aVar;
        this.f132d = aVar2;
    }

    @Override // androidx.view.r
    public final void onStateChanged(u uVar, Lifecycle.Event event) {
        ActivityResultRegistry.a(this.f129a, this.f130b, this.f131c, this.f132d, uVar, event);
    }
}
