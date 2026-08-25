package p5;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class b implements o7.a {
    private int a;
    private int b;

    public b(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public int a() {
        return (this.b - this.a) + 1;
    }

    public Object getItem(int i) {
        if (i < 0 || i >= a()) {
            return 0;
        }
        return Integer.valueOf(this.a + i);
    }
}
