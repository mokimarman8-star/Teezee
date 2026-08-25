package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.r;
import androidx.lifecycle.u;
import androidx.savedstate.c;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class a implements r {
    public static final a b = new a((DefaultConstructorMarker) null);
    private final e a;

    public a(e eVar) {
        Intrinsics.h(eVar, "owner");
        this.a = eVar;
    }

    private final void a(String str) {
        try {
            Class<? extends U> asSubclass = Class.forName(str, false, a.class.getClassLoader()).asSubclass(c.a.class);
            Intrinsics.g(asSubclass, "{\n                Class.…class.java)\n            }");
            try {
                Constructor declaredConstructor = asSubclass.getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                try {
                    Object newInstance = declaredConstructor.newInstance(null);
                    Intrinsics.g(newInstance, "{\n                constr…wInstance()\n            }");
                    ((c.a) newInstance).a(this.a);
                } catch (Exception e) {
                    throw new RuntimeException("Failed to instantiate " + str, e);
                }
            } catch (NoSuchMethodException e3) {
                throw new IllegalStateException("Class " + asSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e3);
            }
        } catch (ClassNotFoundException e4) {
            throw new RuntimeException("Class " + str + " wasn't found", e4);
        }
    }

    public void onStateChanged(u uVar, Lifecycle.Event event) {
        Intrinsics.h(uVar, "source");
        Intrinsics.h(event, "event");
        if (event != Lifecycle.Event.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        uVar.getLifecycle().d(this);
        Bundle b2 = this.a.getSavedStateRegistry().b("androidx.savedstate.Restarter");
        if (b2 == null) {
            return;
        }
        ArrayList<String> stringArrayList = b2.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        Iterator<String> it = stringArrayList.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }
}
