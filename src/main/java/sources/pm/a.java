package pm;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.therouter.router.RouteItem;
import com.transsion.moviedetail.activity.MovieDetailActivity;
import com.transsion.moviedetail.activity.SubjectListActivity;
import com.transsion.moviedetail.fragment.SubjectListFragment;
import com.transsion.moviedetailapi.g;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mf.b;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class a implements g {
    @Override // com.transsion.moviedetailapi.g
    public void a(RouteItem routeItem, b bVar) {
        Intrinsics.h(routeItem, "routeItem");
        Intrinsics.h(bVar, "callback");
        com.transsion.moviedetail.preload.g.a.a().a(routeItem, bVar);
    }

    @Override // com.transsion.moviedetailapi.g
    public void b(Context context, Bundle bundle, Class cls, String str) {
        Intrinsics.h(context, "context");
        Intrinsics.h(bundle, "params");
        Intrinsics.h(cls, "type");
        SubjectListActivity.m.a(context, bundle, cls, str);
    }

    @Override // com.transsion.moviedetailapi.g
    public void c(Fragment fragment) {
        Intrinsics.h(fragment, "fragment");
        if (fragment instanceof SubjectListFragment) {
            ((SubjectListFragment) fragment).refresh();
        }
    }

    @Override // com.transsion.moviedetailapi.g
    public String d() {
        return String.valueOf(Reflection.b(MovieDetailActivity.class).g());
    }

    @Override // com.transsion.moviedetailapi.g
    public Fragment e(Bundle bundle, Class cls) {
        Intrinsics.h(bundle, "params");
        Intrinsics.h(cls, "type");
        return SubjectListFragment.Companion.a(bundle, cls);
    }
}
