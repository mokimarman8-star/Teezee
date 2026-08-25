package androidx.view;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class LiveData$a extends LiveData$c {

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ LiveData f8264e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LiveData$a(final LiveData liveData, final c0 c0Var) {
        new Object(liveData, c0Var) { // from class: androidx.lifecycle.LiveData$c

            /* renamed from: a, reason: collision with root package name */
            final c0 f8265a;

            /* renamed from: b, reason: collision with root package name */
            boolean f8266b;

            /* renamed from: c, reason: collision with root package name */
            int f8267c = -1;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ LiveData f8268d;

            {
                this.f8265a = c0Var;
            }

            void a(boolean z5) {
                if (z5 == this.f8266b) {
                    return;
                }
                this.f8266b = z5;
                this.f8268d.c(z5 ? 1 : -1);
                if (this.f8266b) {
                    this.f8268d.e(this);
                }
            }

            void b() {
            }

            boolean c(u uVar) {
                return false;
            }

            abstract boolean d();
        };
        this.f8264e = liveData;
    }

    @Override // androidx.view.LiveData$c
    boolean d() {
        return true;
    }
}
