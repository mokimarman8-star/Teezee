package com.therouter.inject;

import java.util.Arrays;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class RecyclerBin {
    private final ConcurrentHashMap a = new ConcurrentHashMap();
    private final RecyclerLruCache b;
    private final WeakHashMap c;

    public RecyclerBin() {
        RecyclerLruCache recyclerLruCache = new RecyclerLruCache(10);
        recyclerLruCache.a(new Function3<a, Object, Object, Unit>() { // from class: com.therouter.inject.RecyclerBin$mCacher$1$1
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((a) obj, obj2, obj3);
                return Unit.a;
            }

            public final void invoke(a aVar, Object obj, Object obj2) {
                WeakHashMap weakHashMap;
                WeakHashMap weakHashMap2;
                weakHashMap = RecyclerBin.this.c;
                RecyclerBin recyclerBin = RecyclerBin.this;
                synchronized (weakHashMap) {
                    weakHashMap2 = recyclerBin.c;
                    weakHashMap2.put(aVar, obj);
                    Unit unit = Unit.a;
                }
            }
        });
        this.b = recyclerLruCache;
        this.c = new WeakHashMap();
    }

    public final Object b(Class cls, Object... objArr) {
        Object remove;
        Intrinsics.h(cls, "clazz");
        Intrinsics.h(objArr, "params");
        a aVar = new a(cls, Arrays.copyOf(objArr, objArr.length));
        Object obj = this.a.get(aVar);
        if (obj != null) {
            return obj;
        }
        Object obj2 = this.b.get(aVar);
        if (obj2 != null) {
            return obj2;
        }
        synchronized (this.c) {
            remove = this.c.remove(aVar);
            Unit unit = Unit.a;
        }
        if (remove != null) {
            this.b.put(aVar, remove);
        }
        return remove;
    }

    public final void c(Class cls, Object obj, Object... objArr) {
        Intrinsics.h(cls, "clazz");
        Intrinsics.h(objArr, "params");
        a aVar = new a(cls, Arrays.copyOf(objArr, objArr.length));
        if (cls.isAnnotationPresent(e.class)) {
            if (obj != null) {
                this.a.put(aVar, obj);
            }
        } else {
            if (cls.isAnnotationPresent(c.class)) {
                return;
            }
            this.b.put(aVar, obj);
        }
    }
}
