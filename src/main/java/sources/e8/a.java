package e8;

import java.io.File;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class a implements h8.a {
    private h8.b a;

    public a(h8.b bVar) {
        this.a = bVar;
    }

    @Override // h8.a
    public int a() {
        return 1;
    }

    @Override // h8.b
    public boolean b(File file) {
        return this.a.b(file);
    }

    @Override // h8.a
    public String c(String str, int i) {
        return str + ".bak";
    }
}
