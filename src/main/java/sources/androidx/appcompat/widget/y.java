package androidx.appcompat.widget;

import android.R;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class y {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f1130a = {R.attr.state_checked};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f1131b = new int[0];

    /* renamed from: c, reason: collision with root package name */
    public static final Rect f1132c = new Rect();

    static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final boolean f1133a;

        /* renamed from: b, reason: collision with root package name */
        private static final Method f1134b;

        /* renamed from: c, reason: collision with root package name */
        private static final Field f1135c;

        /* renamed from: d, reason: collision with root package name */
        private static final Field f1136d;

        /* renamed from: e, reason: collision with root package name */
        private static final Field f1137e;

        /* renamed from: f, reason: collision with root package name */
        private static final Field f1138f;

        /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0057  */
        static {
            Method method;
            Field field;
            Field field2;
            Field field3;
            Field field4;
            boolean z5;
            Class<?> cls;
            try {
                cls = Class.forName("android.graphics.Insets");
                method = Drawable.class.getMethod("getOpticalInsets", null);
            } catch (ClassNotFoundException unused) {
                method = null;
                field = null;
            } catch (NoSuchFieldException unused2) {
                method = null;
                field = null;
            } catch (NoSuchMethodException unused3) {
                method = null;
                field = null;
            }
            try {
                field = cls.getField("left");
                try {
                    field2 = cls.getField("top");
                    try {
                        field3 = cls.getField("right");
                        try {
                            field4 = cls.getField("bottom");
                            z5 = true;
                        } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException unused4) {
                            field4 = null;
                            z5 = false;
                            if (z5) {
                            }
                        }
                    } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException unused5) {
                        field3 = null;
                    }
                } catch (ClassNotFoundException unused6) {
                    field2 = null;
                    field3 = field2;
                    field4 = null;
                    z5 = false;
                    if (z5) {
                    }
                } catch (NoSuchFieldException unused7) {
                    field2 = null;
                    field3 = field2;
                    field4 = null;
                    z5 = false;
                    if (z5) {
                    }
                } catch (NoSuchMethodException unused8) {
                    field2 = null;
                    field3 = field2;
                    field4 = null;
                    z5 = false;
                    if (z5) {
                    }
                }
            } catch (ClassNotFoundException unused9) {
                field = null;
                field2 = field;
                field3 = field2;
                field4 = null;
                z5 = false;
                if (z5) {
                }
            } catch (NoSuchFieldException unused10) {
                field = null;
                field2 = field;
                field3 = field2;
                field4 = null;
                z5 = false;
                if (z5) {
                }
            } catch (NoSuchMethodException unused11) {
                field = null;
                field2 = field;
                field3 = field2;
                field4 = null;
                z5 = false;
                if (z5) {
                }
            }
            if (z5) {
                f1134b = null;
                f1135c = null;
                f1136d = null;
                f1137e = null;
                f1138f = null;
                f1133a = false;
                return;
            }
            f1134b = method;
            f1135c = field;
            f1136d = field2;
            f1137e = field3;
            f1138f = field4;
            f1133a = true;
        }

        static Rect a(Drawable drawable) {
            if (Build.VERSION.SDK_INT < 29 && f1133a) {
                try {
                    Object invoke = f1134b.invoke(drawable, null);
                    if (invoke != null) {
                        return new Rect(f1135c.getInt(invoke), f1136d.getInt(invoke), f1137e.getInt(invoke), f1138f.getInt(invoke));
                    }
                } catch (IllegalAccessException | InvocationTargetException unused) {
                }
            }
            return y.f1132c;
        }
    }

    static class b {
        static Insets a(Drawable drawable) {
            return drawable.getOpticalInsets();
        }
    }

    public static boolean a(Drawable drawable) {
        return true;
    }

    static void b(Drawable drawable) {
        String name = drawable.getClass().getName();
        int i5 = Build.VERSION.SDK_INT;
        if (i5 < 29 || i5 >= 31 || !"android.graphics.drawable.ColorStateListDrawable".equals(name)) {
            return;
        }
        c(drawable);
    }

    private static void c(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(f1130a);
        } else {
            drawable.setState(f1131b);
        }
        drawable.setState(state);
    }

    public static Rect d(Drawable drawable) {
        int i5;
        int i6;
        int i7;
        int i8;
        if (Build.VERSION.SDK_INT < 29) {
            return a.a(a1.a.q(drawable));
        }
        Insets a5 = b.a(drawable);
        i5 = a5.left;
        i6 = a5.top;
        i7 = a5.right;
        i8 = a5.bottom;
        return new Rect(i5, i6, i7, i8);
    }

    public static PorterDuff.Mode e(int i5, PorterDuff.Mode mode) {
        if (i5 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i5 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i5 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i5) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
