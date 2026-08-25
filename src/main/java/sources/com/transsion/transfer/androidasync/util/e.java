package com.transsion.transfer.androidasync.util;

import java.util.Hashtable;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class e {
    private Hashtable a = new Hashtable();

    public Object a(String str) {
        return this.a.get(str);
    }

    public void b(String str, Object obj) {
        this.a.put(str, obj);
    }
}
