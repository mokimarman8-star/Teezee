package com.mbridge.msdk.dycreator.viewobserver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class a extends com.mbridge.msdk.dycreator.observable.a {
    private List<Object> a = new ArrayList();
    protected ConcurrentHashMap<Integer, Object> b = new ConcurrentHashMap<>();

    public synchronized void a() {
        this.b.clear();
    }

    public synchronized void a(Object obj, int i) {
        if (obj != null) {
            ConcurrentHashMap<Integer, Object> concurrentHashMap = this.b;
            if (concurrentHashMap != null && !concurrentHashMap.containsValue(obj)) {
                this.b.put(Integer.valueOf(i), obj);
            }
        }
    }
}
