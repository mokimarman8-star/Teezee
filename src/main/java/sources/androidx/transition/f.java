package androidx.transition;

import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.util.Property;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract class f {

    static class a {
        static <T, V> ObjectAnimator a(T t5, Property<T, V> property, Path path) {
            return ObjectAnimator.ofObject(t5, property, (TypeConverter) null, path);
        }
    }

    static ObjectAnimator a(Object obj, Property property, Path path) {
        return a.a(obj, property, path);
    }
}
