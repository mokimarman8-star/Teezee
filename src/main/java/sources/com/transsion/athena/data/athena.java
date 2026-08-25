package com.transsion.athena.data;

import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class athena {
    private static int a;
    private static CopyOnWriteArrayList<Integer> b = new CopyOnWriteArrayList<>();

    public static CopyOnWriteArrayList<Integer> a() {
        return b;
    }

    public static boolean a(int i) {
        if (b.contains(Integer.valueOf(i))) {
            return false;
        }
        return b.add(Integer.valueOf(i));
    }

    public static boolean a(long j) {
        return b.contains(Integer.valueOf(com.transsion.athena.taaneh.anehat.a(j)));
    }

    public static int b() {
        return a;
    }

    public static void b(int i) {
        if (a != 0) {
            com.transsion.athena.taaneh.aethna.a("The host appId has been set 2 times");
        }
        a = i;
    }
}
