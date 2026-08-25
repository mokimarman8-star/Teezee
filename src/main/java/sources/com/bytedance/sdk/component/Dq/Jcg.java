package com.bytedance.sdk.component.Dq;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Jcg<V> extends FutureTask<V> implements Comparable<Jcg<V>> {
    private int Sj;
    private int sP;

    public Jcg(Runnable runnable, V v, int i, int i2) {
        super(runnable, v);
        this.Sj = i == -1 ? 5 : i;
        this.sP = i2;
    }

    public Jcg(Callable<V> callable, int i, int i2) {
        super(callable);
        this.Sj = i == -1 ? 5 : i;
        this.sP = i2;
    }

    public int Sj() {
        return this.Sj;
    }

    @Override // java.lang.Comparable
    /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
    public int compareTo(Jcg jcg) {
        if (Sj() < jcg.Sj()) {
            return 1;
        }
        return Sj() > jcg.Sj() ? -1 : 0;
    }
}
