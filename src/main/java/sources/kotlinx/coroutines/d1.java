package kotlinx.coroutines;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class d1 implements p1 {
    private final boolean a;

    public d1(boolean z) {
        this.a = z;
    }

    @Override // kotlinx.coroutines.p1
    public b2 b() {
        return null;
    }

    @Override // kotlinx.coroutines.p1
    public boolean isActive() {
        return this.a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(isActive() ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
