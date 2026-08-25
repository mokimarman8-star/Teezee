package b00;

import java.util.Iterator;
import java.util.LinkedList;
import org.mvel2.util.k;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class b extends ClassLoader implements k {
    private int a;
    private int b;
    private final LinkedList c;

    public b(ClassLoader classLoader, int i) {
        super(classLoader);
        this.c = new LinkedList();
        this.b = i;
    }

    @Override // org.mvel2.util.k
    public Class a(String str, byte[] bArr, int i, int i2) {
        this.a++;
        return super.defineClass(str, bArr, i, i2);
    }

    public void b() {
        synchronized (this.c) {
            try {
                Iterator it = this.c.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    if (aVar != null) {
                        aVar.a();
                    }
                }
                this.c.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int c() {
        return this.a;
    }

    public boolean d() {
        return this.b < this.a;
    }

    public a e(a aVar) {
        synchronized (this.c) {
            try {
                this.c.add(aVar);
                while (this.c.size() > this.b) {
                    a aVar2 = (a) this.c.removeFirst();
                    if (aVar2 != null) {
                        aVar2.a();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }
}
