package q1;

import androidx.view.t0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f17002a = new d();

    private d() {
    }

    public final t0 a(Class cls) {
        Intrinsics.h(cls, "modelClass");
        try {
            Object newInstance = cls.getDeclaredConstructor(null).newInstance(null);
            Intrinsics.g(newInstance, "{\n            modelClass…).newInstance()\n        }");
            return (t0) newInstance;
        } catch (IllegalAccessException e5) {
            throw new RuntimeException("Cannot create an instance of " + cls, e5);
        } catch (InstantiationException e6) {
            throw new RuntimeException("Cannot create an instance of " + cls, e6);
        } catch (NoSuchMethodException e7) {
            throw new RuntimeException("Cannot create an instance of " + cls, e7);
        }
    }
}
