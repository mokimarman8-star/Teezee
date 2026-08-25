package com.amazonaws.event;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class ProgressEvent {
    protected long a;
    protected int b;

    public ProgressEvent(long j) {
        this.a = j;
    }

    public long a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public void c(int i) {
        this.b = i;
    }
}
