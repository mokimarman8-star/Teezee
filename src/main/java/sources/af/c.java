package af;

import android.graphics.Bitmap;
import com.google.zxing.BarcodeFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class c {
    protected com.google.zxing.j a;
    protected r b;
    private final int c = 2;

    public c(com.google.zxing.j jVar, r rVar) {
        this.a = jVar;
        this.b = rVar;
    }

    public static List f(List list, r rVar) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(rVar.f((com.google.zxing.k) it.next()));
        }
        return arrayList;
    }

    public BarcodeFormat a() {
        return this.a.b();
    }

    public Bitmap b() {
        return this.b.b(null, 2);
    }

    public byte[] c() {
        return this.a.c();
    }

    public Map d() {
        return this.a.d();
    }

    public String e() {
        return this.a.f();
    }

    public String toString() {
        return this.a.f();
    }
}
