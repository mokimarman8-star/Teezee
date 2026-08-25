package a9;

import android.content.Context;
import b9.u;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class i implements w8.b {
    private final iy.a a;
    private final iy.a b;
    private final iy.a c;
    private final iy.a d;

    public i(iy.a aVar, iy.a aVar2, iy.a aVar3, iy.a aVar4) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
    }

    public static i a(iy.a aVar, iy.a aVar2, iy.a aVar3, iy.a aVar4) {
        return new i(aVar, aVar2, aVar3, aVar4);
    }

    public static u c(Context context, c9.d dVar, SchedulerConfig schedulerConfig, e9.a aVar) {
        return (u) w8.d.d(h.a(context, dVar, schedulerConfig, aVar));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public u get() {
        return c((Context) this.a.get(), (c9.d) this.b.get(), (SchedulerConfig) this.c.get(), (e9.a) this.d.get());
    }
}
