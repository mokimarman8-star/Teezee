package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.core.os.c;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.u;
import f.a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.SequencesKt;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class ActivityResultRegistry {
    private static final b h = new b((DefaultConstructorMarker) null);
    private final Map a = new LinkedHashMap();
    private final Map b = new LinkedHashMap();
    private final Map c = new LinkedHashMap();
    private final List d = new ArrayList();
    private final transient Map e = new LinkedHashMap();
    private final Map f = new LinkedHashMap();
    private final Bundle g = new Bundle();

    private final void d(int i, String str) {
        this.a.put(Integer.valueOf(i), str);
        this.b.put(str, Integer.valueOf(i));
    }

    private final void g(String str, int i, Intent intent, a aVar) {
        if ((aVar != null ? aVar.a() : null) == null || !this.d.contains(str)) {
            this.f.remove(str);
            this.g.putParcelable(str, new ActivityResult(i, intent));
        } else {
            aVar.a().a(aVar.b().c(i, intent));
            this.d.remove(str);
        }
    }

    private final int h() {
        for (Number number : SequencesKt.i(generateRandomNumber.1.INSTANCE)) {
            if (!this.a.containsKey(Integer.valueOf(number.intValue()))) {
                return number.intValue();
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(ActivityResultRegistry activityResultRegistry, String str, a aVar, a aVar2, u uVar, Lifecycle.Event event) {
        Intrinsics.h(uVar, "<anonymous parameter 0>");
        Intrinsics.h(event, "event");
        if (Lifecycle.Event.ON_START != event) {
            if (Lifecycle.Event.ON_STOP == event) {
                activityResultRegistry.e.remove(str);
                return;
            } else {
                if (Lifecycle.Event.ON_DESTROY == event) {
                    activityResultRegistry.p(str);
                    return;
                }
                return;
            }
        }
        activityResultRegistry.e.put(str, new a(aVar, aVar2));
        if (activityResultRegistry.f.containsKey(str)) {
            Object obj = activityResultRegistry.f.get(str);
            activityResultRegistry.f.remove(str);
            aVar.a(obj);
        }
        ActivityResult activityResult = (ActivityResult) c.a(activityResultRegistry.g, str, ActivityResult.class);
        if (activityResult != null) {
            activityResultRegistry.g.remove(str);
            aVar.a(aVar2.c(activityResult.getResultCode(), activityResult.getData()));
        }
    }

    private final void o(String str) {
        if (((Integer) this.b.get(str)) != null) {
            return;
        }
        d(h(), str);
    }

    public final boolean e(int i, int i2, Intent intent) {
        String str = (String) this.a.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        g(str, i2, intent, (a) this.e.get(str));
        return true;
    }

    public final boolean f(int i, Object obj) {
        String str = (String) this.a.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        a aVar = (a) this.e.get(str);
        if ((aVar != null ? aVar.a() : null) == null) {
            this.g.remove(str);
            this.f.put(str, obj);
            return true;
        }
        a a = aVar.a();
        Intrinsics.f(a, "null cannot be cast to non-null type androidx.activity.result.ActivityResultCallback<O of androidx.activity.result.ActivityResultRegistry.dispatchResult>");
        if (!this.d.remove(str)) {
            return true;
        }
        a.a(obj);
        return true;
    }

    public abstract void i(int i, a aVar, Object obj, androidx.core.app.c cVar);

    public final void j(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
        if (stringArrayList2 != null) {
            this.d.addAll(stringArrayList2);
        }
        Bundle bundle2 = bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
        if (bundle2 != null) {
            this.g.putAll(bundle2);
        }
        int size = stringArrayList.size();
        for (int i = 0; i < size; i++) {
            String str = stringArrayList.get(i);
            if (this.b.containsKey(str)) {
                Integer num = (Integer) this.b.remove(str);
                if (!this.g.containsKey(str)) {
                    TypeIntrinsics.d(this.a).remove(num);
                }
            }
            Integer num2 = integerArrayList.get(i);
            Intrinsics.g(num2, "rcs[i]");
            int intValue = num2.intValue();
            String str2 = stringArrayList.get(i);
            Intrinsics.g(str2, "keys[i]");
            d(intValue, str2);
        }
    }

    public final void k(Bundle bundle) {
        Intrinsics.h(bundle, "outState");
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.b.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.b.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.d));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", new Bundle(this.g));
    }

    public final b l(String str, u uVar, a aVar, a aVar2) {
        Intrinsics.h(str, "key");
        Intrinsics.h(uVar, "lifecycleOwner");
        Intrinsics.h(aVar, "contract");
        Intrinsics.h(aVar2, "callback");
        Lifecycle lifecycle = uVar.getLifecycle();
        if (lifecycle.b().isAtLeast(Lifecycle.State.STARTED)) {
            throw new IllegalStateException(("LifecycleOwner " + uVar + " is attempting to register while current state is " + lifecycle.b() + ". LifecycleOwners must call register before they are STARTED.").toString());
        }
        o(str);
        c cVar = (c) this.c.get(str);
        if (cVar == null) {
            cVar = new c(lifecycle);
        }
        cVar.a(new c(this, str, aVar2, aVar));
        this.c.put(str, cVar);
        return new d(this, str, aVar);
    }

    public final b m(String str, a aVar, a aVar2) {
        Intrinsics.h(str, "key");
        Intrinsics.h(aVar, "contract");
        Intrinsics.h(aVar2, "callback");
        o(str);
        this.e.put(str, new a(aVar2, aVar));
        if (this.f.containsKey(str)) {
            Object obj = this.f.get(str);
            this.f.remove(str);
            aVar2.a(obj);
        }
        ActivityResult activityResult = (ActivityResult) c.a(this.g, str, ActivityResult.class);
        if (activityResult != null) {
            this.g.remove(str);
            aVar2.a(aVar.c(activityResult.getResultCode(), activityResult.getData()));
        }
        return new e(this, str, aVar);
    }

    public final void p(String str) {
        Integer num;
        Intrinsics.h(str, "key");
        if (!this.d.contains(str) && (num = (Integer) this.b.remove(str)) != null) {
            this.a.remove(num);
        }
        this.e.remove(str);
        if (this.f.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f.get(str));
            this.f.remove(str);
        }
        if (this.g.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + ((ActivityResult) c.a(this.g, str, ActivityResult.class)));
            this.g.remove(str);
        }
        c cVar = (c) this.c.get(str);
        if (cVar != null) {
            cVar.b();
            this.c.remove(str);
        }
    }
}
