package com.transsion.json;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class i {
    private final Map a = new HashMap();
    private final Map b = new HashMap();

    private m a() {
        m mVar = new m();
        for (Class cls : this.a.keySet()) {
            mVar.b(cls, (o) this.a.get(cls));
        }
        for (q qVar : this.b.keySet()) {
            mVar.a(qVar, (o) this.b.get(qVar));
        }
        return mVar;
    }

    public Object b(String str, Class cls) {
        return a().j(new l(str).j(), cls);
    }
}
