package t8;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class b extends f {
    private final Integer a;

    b(Integer num) {
        this.a = num;
    }

    @Override // t8.f
    public Integer a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        Integer num = this.a;
        Integer a = ((f) obj).a();
        return num == null ? a == null : num.equals(a);
    }

    public int hashCode() {
        Integer num = this.a;
        return (num == null ? 0 : num.hashCode()) ^ 1000003;
    }

    public String toString() {
        return "ProductData{productId=" + this.a + "}";
    }
}
