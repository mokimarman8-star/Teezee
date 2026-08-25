package com.bykv.vk.openvk.preload.a.b.b;

import com.bykv.vk.openvk.preload.a.b.d;
import java.lang.reflect.AccessibleObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class b {
    private static final b a;

    static {
        a = d.a() < 9 ? new a() : new c();
    }

    public static b a() {
        return a;
    }

    public abstract void a(AccessibleObject accessibleObject);
}
