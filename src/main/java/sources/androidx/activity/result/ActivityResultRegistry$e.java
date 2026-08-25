package androidx.activity.result;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class ActivityResultRegistry$e extends b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ActivityResultRegistry f122a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f123b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ f.a f124c;

    ActivityResultRegistry$e(ActivityResultRegistry activityResultRegistry, String str, f.a aVar) {
        this.f122a = activityResultRegistry;
        this.f123b = str;
        this.f124c = aVar;
    }

    @Override // androidx.activity.result.b
    public void b(Object obj, androidx.core.app.c cVar) {
        Object obj2 = ActivityResultRegistry.b(this.f122a).get(this.f123b);
        f.a aVar = this.f124c;
        if (obj2 != null) {
            int intValue = ((Number) obj2).intValue();
            ActivityResultRegistry.c(this.f122a).add(this.f123b);
            try {
                this.f122a.i(intValue, this.f124c, obj, cVar);
                return;
            } catch (Exception e5) {
                ActivityResultRegistry.c(this.f122a).remove(this.f123b);
                throw e5;
            }
        }
        throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + aVar + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
    }

    @Override // androidx.activity.result.b
    public void c() {
        this.f122a.p(this.f123b);
    }
}
