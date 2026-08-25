package com.transsion.json;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class g {
    private final Class a;
    private Object b;

    public g(Class cls) {
        this.a = cls;
    }

    public synchronized Object a() {
        try {
            if (this.b == null) {
                this.b = this.a.newInstance();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.b;
    }
}
