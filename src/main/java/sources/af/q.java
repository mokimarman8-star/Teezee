package af;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class q implements Comparable {
    public final int a;
    public final int b;

    public q(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(q qVar) {
        int i = this.b * this.a;
        int i2 = qVar.b * qVar.a;
        if (i2 < i) {
            return 1;
        }
        return i2 > i ? -1 : 0;
    }

    public boolean b(q qVar) {
        return this.a <= qVar.a && this.b <= qVar.b;
    }

    public q d() {
        return new q(this.b, this.a);
    }

    public q e(int i, int i2) {
        return new q((this.a * i) / i2, (this.b * i) / i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        q qVar = (q) obj;
        return this.a == qVar.a && this.b == qVar.b;
    }

    public q f(q qVar) {
        int i = this.a;
        int i2 = qVar.b;
        int i3 = i * i2;
        int i4 = qVar.a;
        int i5 = this.b;
        return i3 <= i4 * i5 ? new q(i4, (i5 * i4) / i) : new q((i * i2) / i5, i2);
    }

    public q g(q qVar) {
        int i = this.a;
        int i2 = qVar.b;
        int i3 = i * i2;
        int i4 = qVar.a;
        int i5 = this.b;
        return i3 >= i4 * i5 ? new q(i4, (i5 * i4) / i) : new q((i * i2) / i5, i2);
    }

    public int hashCode() {
        return (this.a * 31) + this.b;
    }

    public String toString() {
        return this.a + "x" + this.b;
    }
}
