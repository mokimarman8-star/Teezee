package jb;

import android.content.Context;
import com.google.firebase.abt.AbtException;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mb.a;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class b {
    private final kc.b a;
    private final String b;
    private Integer c = null;

    public b(Context context, kc.b bVar, String str) {
        this.a = bVar;
        this.b = str;
    }

    private void a(a.c cVar) {
        ((mb.a) this.a.get()).e(cVar);
    }

    private void b(List list) {
        ArrayDeque arrayDeque = new ArrayDeque(f());
        int i = i();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            while (arrayDeque.size() >= i) {
                k(((a.c) arrayDeque.pollFirst()).b);
            }
            a.c f = aVar.f(this.b);
            a(f);
            arrayDeque.offer(f);
        }
    }

    private static List c(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a.b((Map) it.next()));
        }
        return arrayList;
    }

    private boolean d(List list, a aVar) {
        String c = aVar.c();
        String e = aVar.e();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a aVar2 = (a) it.next();
            if (aVar2.c().equals(c) && aVar2.e().equals(e)) {
                return true;
            }
        }
        return false;
    }

    private List f() {
        return ((mb.a) this.a.get()).g(this.b, TtmlNode.ANONYMOUS_REGION_ID);
    }

    private ArrayList g(List list, List list2) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!d(list2, aVar)) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    private ArrayList h(List list, List list2) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!d(list2, aVar)) {
                arrayList.add(aVar.f(this.b));
            }
        }
        return arrayList;
    }

    private int i() {
        if (this.c == null) {
            this.c = Integer.valueOf(((mb.a) this.a.get()).f(this.b));
        }
        return this.c.intValue();
    }

    private void k(String str) {
        ((mb.a) this.a.get()).clearConditionalUserProperty(str, null, null);
    }

    private void l(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            k(((a.c) it.next()).b);
        }
    }

    private void n(List list) {
        if (list.isEmpty()) {
            j();
            return;
        }
        List e = e();
        l(h(e, list));
        b(g(list, e));
    }

    private void o() {
        if (this.a.get() == null) {
            throw new AbtException("The Analytics SDK is not available. Please check that the Analytics SDK is included in your app dependencies.");
        }
    }

    public List e() {
        o();
        List f = f();
        ArrayList arrayList = new ArrayList();
        Iterator it = f.iterator();
        while (it.hasNext()) {
            arrayList.add(a.a((a.c) it.next()));
        }
        return arrayList;
    }

    public void j() {
        o();
        l(f());
    }

    public void m(List list) {
        o();
        if (list == null) {
            throw new IllegalArgumentException("The replacementExperiments list is null.");
        }
        n(c(list));
    }
}
