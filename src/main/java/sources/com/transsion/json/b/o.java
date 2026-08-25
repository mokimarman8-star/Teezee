package com.transsion.json.b;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class o extends a {
    protected final n a;

    public o(n nVar) {
        this.a = nVar;
    }

    @Override // com.transsion.json.b.a
    public Boolean a() {
        g gVar = this.a;
        return Boolean.valueOf((gVar instanceof g) && gVar.a().booleanValue());
    }

    @Override // com.transsion.json.b.n
    public void a(Object obj) {
        b().t().addFirst(obj);
        this.a.a(obj);
        b().t().removeFirst();
    }
}
