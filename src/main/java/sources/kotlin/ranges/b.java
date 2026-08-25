package kotlin.ranges;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class b implements ClosedFloatingPointRange {
    private final float a;
    private final float b;

    public b(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.ClosedFloatingPointRange
    public /* bridge */ /* synthetic */ boolean a(Comparable comparable) {
        return b(((Number) comparable).floatValue());
    }

    public boolean b(float f) {
        return f >= this.a && f <= this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.ClosedFloatingPointRange
    public /* bridge */ /* synthetic */ boolean c(Comparable comparable, Comparable comparable2) {
        return g(((Number) comparable).floatValue(), ((Number) comparable2).floatValue());
    }

    @Override // kotlin.ranges.ClosedRange
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Float e() {
        return Float.valueOf(this.b);
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            if (!isEmpty() || !((b) obj).isEmpty()) {
                b bVar = (b) obj;
                if (this.a != bVar.a || this.b != bVar.b) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.ClosedRange
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Float j() {
        return Float.valueOf(this.a);
    }

    public boolean g(float f, float f2) {
        return f <= f2;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b);
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange
    public boolean isEmpty() {
        return this.a > this.b;
    }

    public String toString() {
        return this.a + ".." + this.b;
    }
}
