package v0;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class a {

    /* renamed from: v0.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0176a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f18039a;

        static {
            int[] iArr = new int[ConstraintAttribute.AttributeType.values().length];
            f18039a = iArr;
            try {
                iArr[ConstraintAttribute.AttributeType.INT_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18039a[ConstraintAttribute.AttributeType.FLOAT_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18039a[ConstraintAttribute.AttributeType.COLOR_DRAWABLE_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18039a[ConstraintAttribute.AttributeType.COLOR_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18039a[ConstraintAttribute.AttributeType.STRING_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f18039a[ConstraintAttribute.AttributeType.BOOLEAN_TYPE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f18039a[ConstraintAttribute.AttributeType.DIMENSION_TYPE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private static int a(int i5) {
        int i6 = (i5 & (~(i5 >> 31))) - 255;
        return (i6 & (i6 >> 31)) + 255;
    }

    public static void b(ConstraintAttribute constraintAttribute, View view, float[] fArr) {
        Class<?> cls = view.getClass();
        String str = "set" + constraintAttribute.c();
        try {
            try {
                try {
                    switch (C0176a.f18039a[constraintAttribute.d().ordinal()]) {
                        case 1:
                            cls.getMethod(str, Integer.TYPE).invoke(view, Integer.valueOf((int) fArr[0]));
                            return;
                        case 2:
                            cls.getMethod(str, Float.TYPE).invoke(view, Float.valueOf(fArr[0]));
                            return;
                        case 3:
                            Method method = cls.getMethod(str, Drawable.class);
                            int a5 = (a((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (a((int) (fArr[3] * 255.0f)) << 24) | (a((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | a((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f));
                            ColorDrawable colorDrawable = new ColorDrawable();
                            colorDrawable.setColor(a5);
                            method.invoke(view, colorDrawable);
                            return;
                        case 4:
                            try {
                                cls.getMethod(str, Integer.TYPE).invoke(view, Integer.valueOf(a((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f)) | (a((int) (fArr[3] * 255.0f)) << 24) | (a((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (a((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8)));
                                return;
                            } catch (IllegalAccessException e5) {
                                e = e5;
                                Log.e("CustomSupport", "cannot access method " + str + " on View \"" + androidx.constraintlayout.motion.widget.a.d(view) + "\"");
                                e.printStackTrace();
                                return;
                            } catch (NoSuchMethodException e6) {
                                e = e6;
                                Log.e("CustomSupport", "no method " + str + " on View \"" + androidx.constraintlayout.motion.widget.a.d(view) + "\"");
                                e.printStackTrace();
                                return;
                            }
                        case 5:
                            throw new RuntimeException("unable to interpolate strings " + constraintAttribute.c());
                        case 6:
                            cls.getMethod(str, Boolean.TYPE).invoke(view, Boolean.valueOf(fArr[0] > 0.5f));
                            return;
                        case 7:
                            cls.getMethod(str, Float.TYPE).invoke(view, Float.valueOf(fArr[0]));
                            return;
                        default:
                            return;
                    }
                } catch (IllegalAccessException e7) {
                    e = e7;
                } catch (NoSuchMethodException e8) {
                    e = e8;
                }
            } catch (InvocationTargetException e9) {
                e9.printStackTrace();
            }
        } catch (IllegalAccessException e10) {
            e = e10;
        } catch (NoSuchMethodException e11) {
            e = e11;
        }
    }
}
