package com.therouter.inject;

import android.util.LruCache;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class RecyclerLruCache extends LruCache {
    private Function3 a;

    public RecyclerLruCache(int i) {
        super(i);
        this.a = new Function3<Object, Object, Object, Unit>() { // from class: com.therouter.inject.RecyclerLruCache$mListener$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                m70invoke(obj, obj2, obj3);
                return Unit.a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m70invoke(Object obj, Object obj2, Object obj3) {
            }
        };
    }

    public final void a(Function3 function3) {
        Intrinsics.h(function3, "block");
        this.a = function3;
    }

    @Override // android.util.LruCache
    protected void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
        super.entryRemoved(z, obj, obj2, obj3);
        this.a.invoke(obj, obj2, obj3);
    }
}
