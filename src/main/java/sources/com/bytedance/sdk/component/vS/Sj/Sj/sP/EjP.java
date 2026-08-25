package com.bytedance.sdk.component.vS.Sj.Sj.sP;

import com.bytedance.sdk.component.vS.Sj.EjP.Sj;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class EjP<T extends com.bytedance.sdk.component.vS.Sj.EjP.Sj> {
    private String EjP;
    private com.bytedance.sdk.component.vS.Sj.EjP.sP.Sj Sj;
    private Queue<String> TKC;
    private Queue<T> sP = new ConcurrentLinkedQueue();

    public EjP(com.bytedance.sdk.component.vS.Sj.EjP.sP.Sj sj, Queue<String> queue, String str) {
        this.Sj = sj;
        this.TKC = queue;
        this.EjP = str;
    }

    public synchronized List<com.bytedance.sdk.component.vS.Sj.EjP.Sj> Sj(int i, int i2) {
        if (!sP(i, i2)) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.Sj.Sj());
        do {
            T poll = this.sP.poll();
            if (poll == null) {
                break;
            }
            arrayList.add(poll);
        } while (arrayList.size() != this.Sj.sP());
        return arrayList;
    }

    public synchronized void Sj(int i, List<T> list) {
        if (i == -1 || i == 200 || i == 509) {
            this.sP.size();
        } else {
            this.sP.addAll(list);
        }
    }

    public void Sj(T t) {
        Queue<T> queue = this.sP;
        if (queue == null || t == null) {
            return;
        }
        queue.offer(t);
    }

    public synchronized boolean sP(int i, int i2) {
        int size = this.sP.size();
        int Sj = this.Sj.Sj();
        return (i == 2 || i == 1) ? com.bytedance.sdk.component.vS.Sj.TKC.Sj.TKC() ? size > 0 : size >= Sj : size >= Sj;
    }
}
