package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class g implements r {
    private final f a;
    private final r b;

    public g(f fVar, r rVar) {
        Intrinsics.h(fVar, "defaultLifecycleObserver");
        this.a = fVar;
        this.b = rVar;
    }

    public void onStateChanged(u uVar, Lifecycle.Event event) {
        Intrinsics.h(uVar, "source");
        Intrinsics.h(event, "event");
        switch (a.a[event.ordinal()]) {
            case 1:
                this.a.onCreate(uVar);
                break;
            case 2:
                this.a.onStart(uVar);
                break;
            case 3:
                this.a.onResume(uVar);
                break;
            case 4:
                this.a.onPause(uVar);
                break;
            case 5:
                this.a.onStop(uVar);
                break;
            case 6:
                this.a.onDestroy(uVar);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        r rVar = this.b;
        if (rVar != null) {
            rVar.onStateChanged(uVar, event);
        }
    }
}
