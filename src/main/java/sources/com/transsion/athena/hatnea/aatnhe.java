package com.transsion.athena.hatnea;

import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class aatnhe {
    public int a;
    public String b;
    public List<athena> c;
    public String d;

    public static class athena {
        public int a;
        public int b;
        public long c;

        athena(int i, int i2, long j) {
            this.a = i;
            this.b = i2;
            this.c = j;
        }

        public String a() {
            return this.b + "-" + this.c;
        }

        public String toString() {
            return "{appId=" + this.a + ", type=" + this.b + ", version=" + this.c + '}';
        }
    }

    aatnhe() {
    }

    aatnhe(String str) {
        this.d = str;
    }
}
