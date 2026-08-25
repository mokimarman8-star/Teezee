package g00;

import java.util.Iterator;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class b implements Iterator {
    int a;
    int b;

    public b(int i) {
        this.b = i;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.a < this.b;
    }

    @Override // java.util.Iterator
    public Object next() {
        int i = this.a;
        this.a = i + 1;
        return Integer.valueOf(i);
    }

    @Override // java.util.Iterator
    public void remove() {
    }
}
