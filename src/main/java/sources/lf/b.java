package lf;

import com.therouter.router.NavigatorKt;
import java.lang.ref.SoftReference;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class b implements mf.a {
    @Override // mf.a
    public Object a(String str, Object obj, com.therouter.router.b bVar) {
        SoftReference softReference;
        if (bVar == null || bVar.a() != 0 || !NavigatorKt.j().keySet().contains(bVar.b()) || (softReference = (SoftReference) NavigatorKt.j().remove(bVar.b())) == null) {
            return null;
        }
        return softReference.get();
    }
}
