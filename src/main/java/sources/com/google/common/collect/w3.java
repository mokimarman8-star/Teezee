package com.google.common.collect;

import com.google.common.collect.l3;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
abstract class w3 {

    static final class b {
        private final Field a;

        private b(Field field) {
            this.a = field;
            field.setAccessible(true);
        }

        void a(Object obj, int i) {
            try {
                this.a.set(obj, Integer.valueOf(i));
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }

        void b(Object obj, Object obj2) {
            try {
                this.a.set(obj, obj2);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }

    static b a(Class cls, String str) {
        try {
            return new b(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e) {
            throw new AssertionError(e);
        }
    }

    static void b(Map map, ObjectInputStream objectInputStream) {
        c(map, objectInputStream, objectInputStream.readInt());
    }

    static void c(Map map, ObjectInputStream objectInputStream, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            map.put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    static void d(j3 j3Var, ObjectInputStream objectInputStream) {
        e(j3Var, objectInputStream, objectInputStream.readInt());
    }

    static void e(j3 j3Var, ObjectInputStream objectInputStream, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            Collection mo9get = j3Var.mo9get(objectInputStream.readObject());
            int readInt = objectInputStream.readInt();
            for (int i3 = 0; i3 < readInt; i3++) {
                mo9get.add(objectInputStream.readObject());
            }
        }
    }

    static void f(l3 l3Var, ObjectInputStream objectInputStream) {
        g(l3Var, objectInputStream, objectInputStream.readInt());
    }

    static void g(l3 l3Var, ObjectInputStream objectInputStream, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            l3Var.add(objectInputStream.readObject(), objectInputStream.readInt());
        }
    }

    static int h(ObjectInputStream objectInputStream) {
        return objectInputStream.readInt();
    }

    static void i(Map map, ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(map.size());
        for (Map.Entry entry : map.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    static void j(j3 j3Var, ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(j3Var.asMap().size());
        for (Map.Entry entry : j3Var.asMap().entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(((Collection) entry.getValue()).size());
            Iterator it = ((Collection) entry.getValue()).iterator();
            while (it.hasNext()) {
                objectOutputStream.writeObject(it.next());
            }
        }
    }

    static void k(l3 l3Var, ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(l3Var.mo17entrySet().size());
        for (l3.a aVar : l3Var.mo17entrySet()) {
            objectOutputStream.writeObject(aVar.getElement());
            objectOutputStream.writeInt(aVar.getCount());
        }
    }
}
