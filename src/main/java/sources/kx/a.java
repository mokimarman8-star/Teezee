package kx;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class a {
    private Object a;
    private boolean b = false;

    public a(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("null values in Event are not allowed.");
        }
        this.a = obj;
    }

    public Object a() {
        if (this.b) {
            return null;
        }
        this.b = true;
        return this.a;
    }
}
