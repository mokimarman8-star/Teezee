package a9;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class g implements w8.b {
    private final iy.a a;

    public g(iy.a aVar) {
        this.a = aVar;
    }

    public static SchedulerConfig a(e9.a aVar) {
        return (SchedulerConfig) w8.d.d(f.a(aVar));
    }

    public static g b(iy.a aVar) {
        return new g(aVar);
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public SchedulerConfig get() {
        return a((e9.a) this.a.get());
    }
}
