package mz;

import java.io.File;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class d implements Iterator {
    private File a;
    private String[] b;
    private int c;

    public d() {
        this.c = 0;
    }

    public d(File file) {
        this.c = 0;
        this.a = file;
    }

    public d(File file, String[] strArr) {
        this(file);
        a(strArr);
    }

    public void a(String[] strArr) {
        String[] strArr2 = this.b;
        int length = strArr2 == null ? 0 : strArr2.length;
        String[] strArr3 = new String[strArr.length + length];
        if (length > 0) {
            System.arraycopy(strArr2, 0, strArr3, 0, length);
        }
        this.b = strArr3;
        System.arraycopy(strArr, 0, strArr3, length, strArr.length);
    }

    public c b() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        File file = this.a;
        String[] strArr = this.b;
        int i = this.c;
        this.c = i + 1;
        return new c(file, strArr[i]);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.c < this.b.length;
    }

    @Override // java.util.Iterator
    public Object next() {
        return b();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
