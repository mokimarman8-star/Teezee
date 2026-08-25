package kotlinx.coroutines;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class h extends EventLoopImplBase {
    private final Thread a;

    public h(Thread thread) {
        this.a = thread;
    }

    protected Thread getThread() {
        return this.a;
    }
}
