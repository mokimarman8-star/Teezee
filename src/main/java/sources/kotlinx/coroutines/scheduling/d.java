package kotlinx.coroutines.scheduling;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class d extends f {
    public static final d a = new d();

    private d() {
    }

    @Override // kotlinx.coroutines.scheduling.f
    public long a() {
        return System.nanoTime();
    }
}
