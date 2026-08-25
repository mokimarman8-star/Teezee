package com.transsion.athena.data;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class anehat {
    public long a;
    public String b;
    public List<athena> c;
    public long d;
    public long e;
    public int f;
    public int g;
    public boolean h;

    public static class athena {
        public String a;
        public long b;
        public String c;
        public int d;

        public athena(String str, long j, int i, String str2) {
            this.a = str;
            this.b = j;
            this.d = i;
            this.c = str2;
        }

        public String toString() {
            return "TidEvent{event='" + this.a + "', ts=" + this.b + '}';
        }
    }

    public anehat(long j, String str, List<athena> list, long j2, long j3, int i, int i2, boolean z) {
        this.a = j;
        this.c = list;
        this.b = str;
        this.d = j2;
        this.e = j3;
        this.f = i;
        this.g = i2;
        this.h = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof anehat) && this.a == ((anehat) obj).a;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.a), this.c, Long.valueOf(this.d), Long.valueOf(this.e), Integer.valueOf(this.f), Integer.valueOf(this.g), Boolean.valueOf(this.h));
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<athena> it = this.c.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
        }
        return "TidEventSet{tid=" + this.a + ", event='" + this.b + "', eventList=" + ((Object) sb) + ", eventCount=" + this.f + '}';
    }
}
