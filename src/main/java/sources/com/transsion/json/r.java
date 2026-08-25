package com.transsion.json;

import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class r {
    final String[] a;
    boolean b;
    boolean c;

    public r(String str, boolean z) {
        this.b = false;
        this.c = true;
        this.a = str.split("\\.");
        this.b = str.indexOf(42) >= 0;
        this.c = z;
    }

    public boolean a() {
        return this.c;
    }

    public boolean b(q qVar) {
        int i = 0;
        int i2 = 0;
        while (i < qVar.c()) {
            String str = (String) qVar.b().get(i);
            String[] strArr = this.a;
            if (i2 >= strArr.length || !strArr[i2].equals("*")) {
                String[] strArr2 = this.a;
                if (i2 >= strArr2.length || !strArr2[i2].equals(str)) {
                    int i3 = i2 - 1;
                    if (i3 < 0 || !this.a[i3].equals("*")) {
                        return false;
                    }
                    i++;
                } else {
                    i++;
                }
            }
            i2++;
        }
        return (i2 <= 0 || !this.a[i2 + (-1)].equals("*")) ? i >= qVar.c() && qVar.c() > 0 : i >= qVar.c() && i2 >= this.a.length;
    }

    public boolean c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.a, ((r) obj).a);
    }

    public int hashCode() {
        String[] strArr = this.a;
        if (strArr != null) {
            return Arrays.hashCode(strArr);
        }
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i = 0;
        while (true) {
            String[] strArr = this.a;
            if (i >= strArr.length) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(strArr[i]);
            if (i < this.a.length - 1) {
                sb.append(",");
            }
            i++;
        }
    }
}
