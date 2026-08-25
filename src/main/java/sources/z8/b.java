package z8;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class b {
    public static Object a(int i, Object obj, a aVar, c cVar) {
        Object apply;
        if (i < 1) {
            return aVar.apply(obj);
        }
        do {
            apply = aVar.apply(obj);
            obj = cVar.a(obj, apply);
            if (obj == null) {
                break;
            }
            i--;
        } while (i >= 1);
        return apply;
    }
}
