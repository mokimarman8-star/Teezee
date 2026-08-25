package g8;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class d implements c {
    private c[] a;

    public d(c... cVarArr) {
        this.a = cVarArr;
    }

    @Override // g8.c
    public void a(int i, String str, String str2) {
        for (c cVar : this.a) {
            cVar.a(i, str, str2);
        }
    }
}
