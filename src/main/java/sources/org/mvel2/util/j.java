package org.mvel2.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class j {
    private char[] a;
    private ArrayList b;
    private Set c;

    class a implements b {
        a() {
        }

        @Override // org.mvel2.util.j.b
        public int a(int i) {
            Iterator it = j.this.b.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar.d(i)) {
                    return cVar.b();
                }
            }
            return -1;
        }
    }

    public interface b {
        int a(int i);
    }

    private static class c implements Comparable {
        private int a;
        private int b;
        private int c;

        private c(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        /* synthetic */ c(int i, int i2, int i3, a aVar) {
            this(i, i2, i3);
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            if (cVar.a >= this.b) {
                return 1;
            }
            return cVar.b < this.a ? -1 : 0;
        }

        public int b() {
            return this.c;
        }

        public boolean d(int i) {
            return i >= this.a && i <= this.b;
        }
    }

    public j(char[] cArr) {
        this.a = cArr;
    }

    public b b() {
        a aVar;
        this.b = new ArrayList();
        this.c = new TreeSet();
        int i = 0;
        int i2 = 1;
        int i3 = 0;
        while (true) {
            char[] cArr = this.a;
            aVar = null;
            if (i >= cArr.length) {
                break;
            }
            if (cArr[i] == '\n') {
                this.c.add(Integer.valueOf(i2));
                this.b.add(new c(i3, i, i2, aVar));
                i3 = i + 1;
                i2++;
            }
            i++;
        }
        if (i > i3) {
            this.c.add(Integer.valueOf(i2));
            this.b.add(new c(i3, i, i2, aVar));
        }
        return new a();
    }
}
