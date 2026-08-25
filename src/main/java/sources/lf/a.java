package lf;

import android.app.Activity;
import android.app.Fragment;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class a implements mf.a {
    @Override // mf.a
    public Object a(String str, Object obj, com.therouter.router.b bVar) {
        View view;
        if (bVar == null || bVar.a() == 0) {
            return null;
        }
        if (obj instanceof View) {
            return ((View) obj).findViewById(bVar.a());
        }
        if (obj instanceof Activity) {
            return ((Activity) obj).findViewById(bVar.a());
        }
        if (obj instanceof Fragment) {
            View view2 = ((Fragment) obj).getView();
            Intrinsics.e(view2);
            return view2.findViewById(bVar.a());
        }
        if (!(obj instanceof androidx.fragment.app.Fragment) || (view = ((androidx.fragment.app.Fragment) obj).getView()) == null) {
            return null;
        }
        return view.findViewById(bVar.a());
    }
}
