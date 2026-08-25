package com.transsion.api.gateway.dns;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class b {
    public String a;
    public CopyOnWriteArrayList b = new CopyOnWriteArrayList();

    public b(b bVar) {
        this.a = bVar.a;
        Iterator it = bVar.b.iterator();
        while (it.hasNext()) {
            this.b.add(new d((d) it.next()));
        }
    }

    public b(String str) {
        this.a = str;
    }

    public void a(String str, int i) {
        d dVar;
        synchronized (b.class) {
            try {
                Iterator it = this.b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        dVar = null;
                        break;
                    } else {
                        dVar = (d) it.next();
                        if (dVar.b.equals(str)) {
                        }
                    }
                }
            } finally {
            }
        }
        synchronized (b.class) {
            if (dVar == null) {
                try {
                    this.b.add(new d(str, i));
                } finally {
                }
            }
        }
    }
}
