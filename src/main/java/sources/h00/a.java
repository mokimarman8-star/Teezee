package h00;

import g00.c;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class a implements c {
    private StringBuilder a;

    public a(StringBuilder sb) {
        this.a = sb;
    }

    @Override // g00.c
    public c append(CharSequence charSequence) {
        this.a.append(charSequence);
        return this;
    }

    public String toString() {
        return this.a.toString();
    }
}
