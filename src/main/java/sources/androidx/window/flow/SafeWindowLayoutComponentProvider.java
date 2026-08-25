package androidx.window.flow;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import androidx.window.extensions.WindowExtensionsProvider;
import androidx.window.extensions.layout.WindowLayoutComponent;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class SafeWindowLayoutComponentProvider {
    public static final SafeWindowLayoutComponentProvider a = new SafeWindowLayoutComponentProvider();
    private static final Lazy b = LazyKt.b(new Function0<WindowLayoutComponent>() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider$windowLayoutComponent$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final WindowLayoutComponent m9invoke() {
            boolean i;
            ClassLoader classLoader = SafeWindowLayoutComponentProvider.class.getClassLoader();
            if (classLoader != null) {
                i = SafeWindowLayoutComponentProvider.a.i(classLoader);
                if (i) {
                    try {
                        return WindowExtensionsProvider.getWindowExtensions().getWindowLayoutComponent();
                    } catch (UnsupportedOperationException unused) {
                        return null;
                    }
                }
            }
            return null;
        }
    });

    private SafeWindowLayoutComponentProvider() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean i(ClassLoader classLoader) {
        return Build.VERSION.SDK_INT >= 24 && r(classLoader) && p(classLoader) && q(classLoader) && n(classLoader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j(Method method, Class cls) {
        return method.getReturnType().equals(cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean k(Method method, KClass kClass) {
        return j(method, JvmClassMappingKt.a(kClass));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class l(ClassLoader classLoader) {
        return classLoader.loadClass("androidx.window.extensions.layout.FoldingFeature");
    }

    private final boolean n(final ClassLoader classLoader) {
        return s(new Function0<Boolean>() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider$isFoldingFeatureValid$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Boolean m5invoke() {
                Class l;
                boolean k;
                boolean z;
                boolean o;
                boolean k2;
                boolean o2;
                boolean k3;
                boolean o3;
                SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.a;
                l = safeWindowLayoutComponentProvider.l(classLoader);
                Method method = l.getMethod("getBounds", null);
                Method method2 = l.getMethod("getType", null);
                Method method3 = l.getMethod("getState", null);
                Intrinsics.g(method, "getBoundsMethod");
                k = safeWindowLayoutComponentProvider.k(method, Reflection.b(Rect.class));
                if (k) {
                    o = safeWindowLayoutComponentProvider.o(method);
                    if (o) {
                        Intrinsics.g(method2, "getTypeMethod");
                        Class cls = Integer.TYPE;
                        k2 = safeWindowLayoutComponentProvider.k(method2, Reflection.b(cls));
                        if (k2) {
                            o2 = safeWindowLayoutComponentProvider.o(method2);
                            if (o2) {
                                Intrinsics.g(method3, "getStateMethod");
                                k3 = safeWindowLayoutComponentProvider.k(method3, Reflection.b(cls));
                                if (k3) {
                                    o3 = safeWindowLayoutComponentProvider.o(method3);
                                    if (o3) {
                                        z = true;
                                        return Boolean.valueOf(z);
                                    }
                                }
                            }
                        }
                    }
                }
                z = false;
                return Boolean.valueOf(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean o(Method method) {
        return Modifier.isPublic(method.getModifiers());
    }

    private final boolean p(final ClassLoader classLoader) {
        return s(new Function0<Boolean>() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider$isWindowExtensionsValid$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Boolean m6invoke() {
                Class t;
                Class v;
                boolean o;
                boolean z;
                boolean j;
                SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.a;
                t = safeWindowLayoutComponentProvider.t(classLoader);
                Method method = t.getMethod("getWindowLayoutComponent", null);
                v = safeWindowLayoutComponentProvider.v(classLoader);
                Intrinsics.g(method, "getWindowLayoutComponentMethod");
                o = safeWindowLayoutComponentProvider.o(method);
                if (o) {
                    Intrinsics.g(v, "windowLayoutComponentClass");
                    j = safeWindowLayoutComponentProvider.j(method, v);
                    if (j) {
                        z = true;
                        return Boolean.valueOf(z);
                    }
                }
                z = false;
                return Boolean.valueOf(z);
            }
        });
    }

    private final boolean q(final ClassLoader classLoader) {
        return s(new Function0<Boolean>() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider$isWindowLayoutComponentValid$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Boolean m7invoke() {
                Class v;
                boolean o;
                boolean o2;
                SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.a;
                v = safeWindowLayoutComponentProvider.v(classLoader);
                boolean z = false;
                Method method = v.getMethod("addWindowLayoutInfoListener", Activity.class, s.a());
                Method method2 = v.getMethod("removeWindowLayoutInfoListener", s.a());
                Intrinsics.g(method, "addListenerMethod");
                o = safeWindowLayoutComponentProvider.o(method);
                if (o) {
                    Intrinsics.g(method2, "removeListenerMethod");
                    o2 = safeWindowLayoutComponentProvider.o(method2);
                    if (o2) {
                        z = true;
                    }
                }
                return Boolean.valueOf(z);
            }
        });
    }

    private final boolean r(final ClassLoader classLoader) {
        return s(new Function0<Boolean>() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider$isWindowLayoutProviderValid$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Boolean m8invoke() {
                Class u;
                Class t;
                boolean j;
                boolean z;
                boolean o;
                SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.a;
                u = safeWindowLayoutComponentProvider.u(classLoader);
                Method declaredMethod = u.getDeclaredMethod("getWindowExtensions", null);
                t = safeWindowLayoutComponentProvider.t(classLoader);
                Intrinsics.g(declaredMethod, "getWindowExtensionsMethod");
                Intrinsics.g(t, "windowExtensionsClass");
                j = safeWindowLayoutComponentProvider.j(declaredMethod, t);
                if (j) {
                    o = safeWindowLayoutComponentProvider.o(declaredMethod);
                    if (o) {
                        z = true;
                        return Boolean.valueOf(z);
                    }
                }
                z = false;
                return Boolean.valueOf(z);
            }
        });
    }

    private final boolean s(Function0 function0) {
        try {
            return ((Boolean) function0.invoke()).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class t(ClassLoader classLoader) {
        return classLoader.loadClass("androidx.window.extensions.WindowExtensions");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class u(ClassLoader classLoader) {
        return classLoader.loadClass("androidx.window.extensions.WindowExtensionsProvider");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class v(ClassLoader classLoader) {
        return classLoader.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
    }

    public final WindowLayoutComponent m() {
        return (WindowLayoutComponent) b.getValue();
    }
}
