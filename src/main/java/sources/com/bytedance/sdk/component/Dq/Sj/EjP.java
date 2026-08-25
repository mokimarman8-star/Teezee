package com.bytedance.sdk.component.Dq.Sj;

import com.bytedance.sdk.component.Dq.Sj.TKC;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class EjP<T extends TKC> {
    private int Sj;
    private BlockingQueue<T> sP = new LinkedBlockingQueue();

    private EjP(int i) {
        this.Sj = i;
    }

    public static EjP Sj(int i) {
        return new EjP(i);
    }

    public T Sj() {
        return this.sP.poll();
    }

    public boolean Sj(T t) {
        if (t == null) {
            return false;
        }
        t.Sj();
        if (this.sP.size() >= this.Sj) {
            return false;
        }
        return this.sP.offer(t);
    }
}
