package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract class a0 {

    /* renamed from: a, reason: collision with root package name */
    private static Field f257a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f258b;

    /* renamed from: c, reason: collision with root package name */
    private static Class f259c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f260d;

    /* renamed from: e, reason: collision with root package name */
    private static Field f261e;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f262f;

    /* renamed from: g, reason: collision with root package name */
    private static Field f263g;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f264h;

    static void a(Resources resources) {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 28) {
            return;
        }
        if (i5 >= 24) {
            c(resources);
        } else {
            b(resources);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void b(Resources resources) {
        Object obj;
        if (!f258b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f257a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e5) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e5);
            }
            f258b = true;
        }
        Field field = f257a;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e6) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e6);
            }
            if (obj != null) {
                return;
            }
            d(obj);
            return;
        }
        obj = null;
        if (obj != null) {
        }
    }

    private static void c(Resources resources) {
        Object obj;
        if (!f264h) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                f263g = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e5) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e5);
            }
            f264h = true;
        }
        Field field = f263g;
        if (field == null) {
            return;
        }
        Object obj2 = null;
        try {
            obj = field.get(resources);
        } catch (IllegalAccessException e6) {
            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e6);
            obj = null;
        }
        if (obj == null) {
            return;
        }
        if (!f258b) {
            try {
                Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                f257a = declaredField2;
                declaredField2.setAccessible(true);
            } catch (NoSuchFieldException e7) {
                Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e7);
            }
            f258b = true;
        }
        Field field2 = f257a;
        if (field2 != null) {
            try {
                obj2 = field2.get(obj);
            } catch (IllegalAccessException e8) {
                Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e8);
            }
        }
        if (obj2 != null) {
            d(obj2);
        }
    }

    private static void d(Object obj) {
        LongSparseArray longSparseArray;
        if (!f260d) {
            try {
                f259c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e5) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e5);
            }
            f260d = true;
        }
        Class cls = f259c;
        if (cls == null) {
            return;
        }
        if (!f262f) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                f261e = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e6) {
                Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e6);
            }
            f262f = true;
        }
        Field field = f261e;
        if (field == null) {
            return;
        }
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException e7) {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e7);
            longSparseArray = null;
        }
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }
}
