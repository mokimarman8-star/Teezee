package com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class Iterators$f extends r4 {
    final Queue a;

    public Iterators$f(Iterable iterable, final Comparator comparator) {
        this.a = new PriorityQueue(2, new Comparator() { // from class: com.google.common.collect.h3
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int b;
                b = Iterators$f.b(comparator, (q3) obj, (q3) obj2);
                return b;
            }
        });
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Iterator it2 = (Iterator) it.next();
            if (it2.hasNext()) {
                this.a.add(Iterators.s(it2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int b(Comparator comparator, q3 q3Var, q3 q3Var2) {
        return comparator.compare(q3Var.peek(), q3Var2.peek());
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return !this.a.isEmpty();
    }

    @Override // java.util.Iterator
    public Object next() {
        q3 q3Var = (q3) this.a.remove();
        Object next = q3Var.next();
        if (q3Var.hasNext()) {
            this.a.add(q3Var);
        }
        return next;
    }
}
