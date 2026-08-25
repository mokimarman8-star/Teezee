package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class m0 implements r {
    private final SavedStateHandlesProvider a;

    public m0(SavedStateHandlesProvider savedStateHandlesProvider) {
        Intrinsics.h(savedStateHandlesProvider, "provider");
        this.a = savedStateHandlesProvider;
    }

    public void onStateChanged(u uVar, Lifecycle.Event event) {
        Intrinsics.h(uVar, "source");
        Intrinsics.h(event, "event");
        if (event == Lifecycle.Event.ON_CREATE) {
            uVar.getLifecycle().d(this);
            this.a.c();
        } else {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + event).toString());
        }
    }
}
