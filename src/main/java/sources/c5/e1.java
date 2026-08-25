package c5;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class e1 {
    public final e1 a;
    public final Object b;
    public final Object c;
    public final int d;

    public e1(e1 e1Var, Object obj, Object obj2, int i, int i2) {
        this.a = e1Var;
        this.b = obj;
        this.c = obj2;
        this.d = i;
    }

    protected void a(StringBuilder sb) {
        e1 e1Var = this.a;
        if (e1Var == null) {
            sb.append('$');
            return;
        }
        e1Var.a(sb);
        Object obj = this.c;
        if (obj == null) {
            sb.append(".null");
            return;
        }
        if (obj instanceof Integer) {
            sb.append('[');
            sb.append(((Integer) this.c).intValue());
            sb.append(']');
            return;
        }
        sb.append('.');
        String obj2 = this.c.toString();
        for (int i = 0; i < obj2.length(); i++) {
            char charAt = obj2.charAt(i);
            if ((charAt < '0' || charAt > '9') && ((charAt < 'A' || charAt > 'Z') && ((charAt < 'a' || charAt > 'z') && charAt <= 128))) {
                for (int i2 = 0; i2 < obj2.length(); i2++) {
                    char charAt2 = obj2.charAt(i2);
                    if (charAt2 == '\\') {
                        sb.append('\\');
                        sb.append('\\');
                        sb.append('\\');
                    } else if ((charAt2 >= '0' && charAt2 <= '9') || ((charAt2 >= 'A' && charAt2 <= 'Z') || ((charAt2 >= 'a' && charAt2 <= 'z') || charAt2 > 128))) {
                        sb.append(charAt2);
                    } else if (charAt2 == '\"') {
                        sb.append('\\');
                        sb.append('\\');
                        sb.append('\\');
                    } else {
                        sb.append('\\');
                        sb.append('\\');
                    }
                    sb.append(charAt2);
                }
                return;
            }
        }
        sb.append(obj2);
    }

    public String toString() {
        if (this.a == null) {
            return "$";
        }
        StringBuilder sb = new StringBuilder();
        a(sb);
        return sb.toString();
    }
}
