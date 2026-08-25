package androidx.compose.ui.graphics;

import android.graphics.Canvas;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class p1 {

    /* renamed from: a, reason: collision with root package name */
    public static final p1 f3608a = new p1();

    /* renamed from: b, reason: collision with root package name */
    private static Method f3609b;

    /* renamed from: c, reason: collision with root package name */
    private static Method f3610c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f3611d;

    private p1() {
    }

    public final void a(Canvas canvas, boolean z5) {
        Method method;
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 29) {
            s1.f3633a.a(canvas, z5);
            return;
        }
        if (!f3611d) {
            try {
                if (i5 == 28) {
                    Method declaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, new Class[0].getClass());
                    f3609b = (Method) declaredMethod.invoke(Canvas.class, "insertReorderBarrier", new Class[0]);
                    f3610c = (Method) declaredMethod.invoke(Canvas.class, "insertInorderBarrier", new Class[0]);
                } else {
                    f3609b = Canvas.class.getDeclaredMethod("insertReorderBarrier", null);
                    f3610c = Canvas.class.getDeclaredMethod("insertInorderBarrier", null);
                }
                Method method2 = f3609b;
                if (method2 != null) {
                    method2.setAccessible(true);
                }
                Method method3 = f3610c;
                if (method3 != null) {
                    method3.setAccessible(true);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
            f3611d = true;
        }
        if (z5) {
            try {
                Method method4 = f3609b;
                if (method4 != null) {
                    Intrinsics.e(method4);
                    method4.invoke(canvas, null);
                }
            } catch (IllegalAccessException | InvocationTargetException unused2) {
                return;
            }
        }
        if (z5 || (method = f3610c) == null) {
            return;
        }
        Intrinsics.e(method);
        method.invoke(canvas, null);
    }
}
