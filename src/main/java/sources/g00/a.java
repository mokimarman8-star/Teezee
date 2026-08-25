package g00;

import java.util.Iterator;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class a implements Iterator {
    private Object[] a;
    private int b = 0;

    public a(Object[] objArr) {
        this.a = objArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b != this.a.length;
    }

    @Override // java.util.Iterator
    public Object next() {
        Object[] objArr = this.a;
        int i = this.b;
        this.b = i + 1;
        return objArr[i];
    }

    @Override // java.util.Iterator
    public void remove() {
    }
}
