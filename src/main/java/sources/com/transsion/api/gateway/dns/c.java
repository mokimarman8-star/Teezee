package com.transsion.api.gateway.dns;

import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class c {
    private static volatile c INSTANCE;
    public static CopyOnWriteArrayList a = new CopyOnWriteArrayList();

    public static c a() {
        if (INSTANCE == null) {
            synchronized (c.class) {
                try {
                    if (INSTANCE == null) {
                        INSTANCE = new c();
                        INSTANCE.b();
                    }
                } finally {
                }
            }
        }
        return INSTANCE;
    }

    public final void b() {
        b bVar = new b("apigateway.tmctool.com");
        b bVar2 = new b("apigateway.tmctool.com");
        for (String str : com.transsion.api.gateway.config.d.a) {
            bVar.a(str, 443);
        }
        for (String str2 : com.transsion.api.gateway.config.c.a) {
            bVar2.a(str2, 443);
        }
        a.add(bVar);
        a.add(bVar2);
    }
}
