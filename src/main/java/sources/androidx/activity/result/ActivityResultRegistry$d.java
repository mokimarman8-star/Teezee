package androidx.activity.result;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class ActivityResultRegistry$d extends b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ActivityResultRegistry f119a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f120b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ f.a f121c;

    ActivityResultRegistry$d(ActivityResultRegistry activityResultRegistry, String str, f.a aVar) {
        this.f119a = activityResultRegistry;
        this.f120b = str;
        this.f121c = aVar;
    }

    @Override // androidx.activity.result.b
    public void b(Object obj, androidx.core.app.c cVar) {
        Object obj2 = ActivityResultRegistry.b(this.f119a).get(this.f120b);
        f.a aVar = this.f121c;
        if (obj2 != null) {
            int intValue = ((Number) obj2).intValue();
            ActivityResultRegistry.c(this.f119a).add(this.f120b);
            try {
                this.f119a.i(intValue, this.f121c, obj, cVar);
                return;
            } catch (Exception e5) {
                ActivityResultRegistry.c(this.f119a).remove(this.f120b);
                throw e5;
            }
        }
        throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + aVar + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
    }

    @Override // androidx.activity.result.b
    public void c() {
        this.f119a.p(this.f120b);
    }
}
