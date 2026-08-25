package t7;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class b implements d, c {
    @Override // t7.c
    public CharSequence a(long j, int i, String str, String str2) {
        return Long.toString(j) + '|' + s7.c.b(i) + '|' + str + '|' + str2;
    }

    @Override // t7.d
    public CharSequence b(int i, String str, String str2) {
        return a(System.currentTimeMillis(), i, str, str2);
    }
}
