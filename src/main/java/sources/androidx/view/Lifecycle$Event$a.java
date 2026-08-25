package androidx.view;

import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class Lifecycle$Event$a {

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8261a;

        static {
            int[] iArr = new int[Lifecycle.State.values().length];
            try {
                iArr[Lifecycle.State.CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.State.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.State.RESUMED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Lifecycle.State.DESTROYED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Lifecycle.State.INITIALIZED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f8261a = iArr;
        }
    }

    private Lifecycle$Event$a() {
    }

    public /* synthetic */ Lifecycle$Event$a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final Lifecycle.Event a(Lifecycle.State state) {
        Intrinsics.h(state, "state");
        int i5 = a.f8261a[state.ordinal()];
        if (i5 == 1) {
            return Lifecycle.Event.ON_DESTROY;
        }
        if (i5 == 2) {
            return Lifecycle.Event.ON_STOP;
        }
        if (i5 != 3) {
            return null;
        }
        return Lifecycle.Event.ON_PAUSE;
    }

    public final Lifecycle.Event b(Lifecycle.State state) {
        Intrinsics.h(state, "state");
        int i5 = a.f8261a[state.ordinal()];
        if (i5 == 1) {
            return Lifecycle.Event.ON_STOP;
        }
        if (i5 == 2) {
            return Lifecycle.Event.ON_PAUSE;
        }
        if (i5 != 4) {
            return null;
        }
        return Lifecycle.Event.ON_DESTROY;
    }

    public final Lifecycle.Event c(Lifecycle.State state) {
        Intrinsics.h(state, "state");
        int i5 = a.f8261a[state.ordinal()];
        if (i5 == 1) {
            return Lifecycle.Event.ON_START;
        }
        if (i5 == 2) {
            return Lifecycle.Event.ON_RESUME;
        }
        if (i5 != 5) {
            return null;
        }
        return Lifecycle.Event.ON_CREATE;
    }

    public final Lifecycle.Event d(Lifecycle.State state) {
        Intrinsics.h(state, "state");
        int i5 = a.f8261a[state.ordinal()];
        if (i5 == 1) {
            return Lifecycle.Event.ON_CREATE;
        }
        if (i5 == 2) {
            return Lifecycle.Event.ON_START;
        }
        if (i5 != 3) {
            return null;
        }
        return Lifecycle.Event.ON_RESUME;
    }
}
