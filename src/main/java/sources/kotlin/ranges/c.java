package kotlin.ranges;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class c implements OpenEndRange {
    private final float a;
    private final float b;

    public c(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.OpenEndRange
    public /* bridge */ /* synthetic */ boolean a(Comparable comparable) {
        return b(((Number) comparable).floatValue());
    }

    public boolean b(float f) {
        return f >= this.a && f < this.b;
    }

    public boolean c() {
        return this.a >= this.b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!c() || !((c) obj).c()) {
                c cVar = (c) obj;
                if (this.a != cVar.a || this.b != cVar.b) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (c()) {
            return -1;
        }
        return (Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b);
    }

    public String toString() {
        return this.a + "..<" + this.b;
    }
}
