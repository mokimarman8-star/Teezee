package com.bykv.vk.openvk.Sj.Sj.sP.sP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class d {
    private static final Set f = new HashSet();
    private static final Set g = new HashSet();
    private final ArrayList a;
    private final int b;
    private int c = -1;
    private int d;
    private final int e;

    public class a {
        final String a;
        int b;

        a(String str) {
            this.a = str;
        }

        void a() {
            d.f.add(this.a);
        }

        void b() {
            d.g.add(this.a);
        }

        public String toString() {
            return this.a;
        }
    }

    d(String str) {
        ArrayList arrayList = new ArrayList(1);
        this.a = arrayList;
        arrayList.add(new a(str));
        this.b = 1;
        this.e = 1;
    }

    d(List list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("urls can't be empty");
        }
        int size = list.size();
        this.b = size;
        this.a = new ArrayList(size);
        Iterator it = list.iterator();
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        while (it.hasNext()) {
            String str = (String) it.next();
            a aVar = new a(str);
            if (f.contains(str)) {
                arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                arrayList2.add(aVar);
            } else if (g.contains(str)) {
                arrayList = arrayList == null ? new ArrayList() : arrayList;
                arrayList.add(aVar);
            } else {
                this.a.add(aVar);
            }
        }
        if (arrayList != null) {
            this.a.addAll(arrayList);
        }
        if (arrayList2 != null) {
            this.a.addAll(arrayList2);
        }
        Integer num = com.bykv.vk.openvk.Sj.Sj.sP.sP.a.h;
        this.e = (num == null || num.intValue() <= 0) ? this.b >= 2 ? 1 : 2 : num.intValue();
    }

    boolean b() {
        return this.d < this.e;
    }

    a d() {
        if (!b()) {
            throw new NoSuchElementException();
        }
        int i = this.c + 1;
        if (i >= this.b - 1) {
            this.c = -1;
            this.d++;
        } else {
            this.c = i;
        }
        a aVar = (a) this.a.get(i);
        aVar.b = (this.d * this.b) + this.c;
        return aVar;
    }
}
