package com.transsion.transfer.androidasync.util;

import java.util.ArrayList;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class TaggedList<T> extends ArrayList<T> {
    private Object tag;

    public synchronized <V> V tag() {
        return (V) this.tag;
    }

    public synchronized <V> void tag(V v) {
        this.tag = v;
    }

    public synchronized <V> void tagNull(V v) {
        if (this.tag == null) {
            this.tag = v;
        }
    }
}
