package com.transsion.json;

import java.util.Iterator;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class e implements Iterator {
    final Iterator[] a;
    int b = 0;

    public e(Set... setArr) {
        this.a = new Iterator[setArr.length];
        for (int i = 0; i < setArr.length; i++) {
            this.a[i] = setArr[i].iterator();
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.a[this.b].hasNext()) {
            return true;
        }
        int i = this.b + 1;
        this.b = i;
        Iterator[] itArr = this.a;
        return i < itArr.length && itArr[i].hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        return this.a[this.b].next();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.a[this.b].remove();
    }
}
