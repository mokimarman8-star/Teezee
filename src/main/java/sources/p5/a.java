package p5;

import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class a implements o7.a {
    private List a;

    public a(List list) {
        this.a = list;
    }

    public int a() {
        return this.a.size();
    }

    public Object getItem(int i) {
        return (i < 0 || i >= this.a.size()) ? "" : this.a.get(i);
    }
}
