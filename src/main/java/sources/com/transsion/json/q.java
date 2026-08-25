package com.transsion.json;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class q {
    final LinkedList a = new LinkedList();

    public q a(String str) {
        this.a.add(str);
        return this;
    }

    public List b() {
        return this.a;
    }

    public int c() {
        return this.a.size();
    }

    public String d() {
        return (String) this.a.removeLast();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || q.class != obj.getClass()) {
            return false;
        }
        return this.a.equals(((q) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        Iterator it = this.a.iterator();
        boolean z = false;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (z) {
                sb.append(".");
            }
            sb.append(str);
            z = true;
        }
        sb.append(" ]");
        return sb.toString();
    }
}
