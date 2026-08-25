package androidx.coroutines;

import androidx.coroutines.C0210d;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u000f\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0014\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/work/ArrayCreatingInputMerger;", "Landroidx/work/g;", "<init>", "()V", "", "array1", "array2", "d", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "array", "obj", "Ljava/lang/Class;", "valueClass", "c", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;", "e", "(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;", "", "Landroidx/work/d;", "inputs", "b", "(Ljava/util/List;)Landroidx/work/d;", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class ArrayCreatingInputMerger extends AbstractC0213g {
    private final Object c(Object array, Object obj, Class valueClass) {
        int length = Array.getLength(array);
        Object newInstance = Array.newInstance((Class<?>) valueClass, length + 1);
        System.arraycopy(array, 0, newInstance, 0, length);
        Array.set(newInstance, length, obj);
        Intrinsics.g(newInstance, "newArray");
        return newInstance;
    }

    private final Object d(Object array1, Object array2) {
        int length = Array.getLength(array1);
        int length2 = Array.getLength(array2);
        Class<?> componentType = array1.getClass().getComponentType();
        Intrinsics.e(componentType);
        Object newInstance = Array.newInstance(componentType, length + length2);
        System.arraycopy(array1, 0, newInstance, 0, length);
        System.arraycopy(array2, 0, newInstance, length, length2);
        Intrinsics.g(newInstance, "newArray");
        return newInstance;
    }

    private final Object e(Object obj, Class valueClass) {
        Object newInstance = Array.newInstance((Class<?>) valueClass, 1);
        Array.set(newInstance, 0, obj);
        Intrinsics.g(newInstance, "newArray");
        return newInstance;
    }

    @Override // androidx.coroutines.AbstractC0213g
    public C0210d b(List inputs) {
        Intrinsics.h(inputs, "inputs");
        C0210d.a aVar = new C0210d.a();
        HashMap hashMap = new HashMap();
        Iterator it = inputs.iterator();
        while (it.hasNext()) {
            Map h5 = ((C0210d) it.next()).h();
            Intrinsics.g(h5, "input.keyValueMap");
            for (Map.Entry entry : h5.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                Class cls = value != null ? value.getClass() : String.class;
                Object obj = hashMap.get(str);
                Intrinsics.g(str, "key");
                if (obj != null) {
                    Class<?> cls2 = obj.getClass();
                    if (Intrinsics.c(cls2, cls)) {
                        Intrinsics.g(value, "value");
                        value = d(obj, value);
                    } else {
                        if (!Intrinsics.c(cls2.getComponentType(), cls)) {
                            throw new IllegalArgumentException();
                        }
                        value = c(obj, value, cls);
                    }
                } else if (!cls.isArray()) {
                    value = e(value, cls);
                }
                Intrinsics.g(value, "if (existingValue == nul…      }\n                }");
                hashMap.put(str, value);
            }
        }
        aVar.d(hashMap);
        C0210d a5 = aVar.a();
        Intrinsics.g(a5, "output.build()");
        return a5;
    }
}
