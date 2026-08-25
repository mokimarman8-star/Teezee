package com.pgl.ssdk;

import com.pgl.ssdk.z0;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class a1<T extends z0> {
    private int a;
    private BlockingQueue<T> b = new LinkedBlockingQueue();

    private a1(int i) {
        this.a = i;
    }

    public static a1 a(int i) {
        return new a1(i);
    }

    public T a() {
        return this.b.poll();
    }
}
