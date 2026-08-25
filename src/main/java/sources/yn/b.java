package yn;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.therouter.router.RouteItem;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.RoomTabItem;
import com.transsion.player.mediasession.h;
import com.transsion.postdetail.helper.ImmVideoHelper;
import com.transsion.postdetail.shorttv.c;
import com.transsion.postdetail.shorttv.factory.i;
import com.transsion.postdetail.ui.fragment.CommentFragment;
import com.transsion.postdetail.ui.fragment.RoomPostExploreFragment;
import com.transsion.postdetail.ui.fragment.RoomPostNearbyFragment;
import com.transsion.postdetail.ui.fragment.RoomPostNewestFragment;
import com.transsion.postdetail.ui.fragment.RoomPostPopularFragment;
import com.transsion.postdetail.ui.fragment.RoomPostStaggeredFragment;
import com.transsion.postdetail.ui.fragment.RoomPostSubFragment;
import com.transsion.postdetail.ui.interceptor.LocalVideoDetailInterceptor;
import fo.n;
import fo.w;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class b implements io.b {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void q() {
        h.a.p();
    }

    @Override // io.b
    public void a(RouteItem routeItem, mf.b bVar) {
        Intrinsics.h(routeItem, "routeItem");
        Intrinsics.h(bVar, "callback");
        LocalVideoDetailInterceptor.a.a().i(routeItem, bVar);
        c.a.a().d(routeItem, bVar);
    }

    @Override // io.b
    public Fragment b(String str, RoomTabItem roomTabItem, int i) {
        Intrinsics.h(roomTabItem, "item");
        return RoomPostStaggeredFragment.Companion.a(str, roomTabItem, i);
    }

    @Override // io.b
    public Fragment c(String str, RoomTabItem roomTabItem, int i) {
        Intrinsics.h(roomTabItem, "item");
        return RoomPostSubFragment.Companion.a(str, roomTabItem, i);
    }

    @Override // io.b
    public Fragment d(String str, String str2, String str3) {
        return RoomPostExploreFragment.Companion.a(str, str2, str3);
    }

    @Override // io.b
    public Fragment e(String str) {
        return RoomPostNewestFragment.Companion.a(str);
    }

    @Override // io.b
    public Fragment f(String str, String str2, long j, boolean z, boolean z2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        return CommentFragment.O.a(str, str2, j, z, z2, str3 == null ? "" : str3, str4, str5, str6, str7, str8, str9, str10);
    }

    @Override // io.b
    public void g(Fragment fragment, boolean z) {
        if (fragment instanceof RoomPostExploreFragment) {
            ((RoomPostExploreFragment) fragment).loadMoreCacheData(z);
        }
    }

    @Override // io.b
    public BaseItemProvider h(String str, String str2, RecyclerView.s sVar) {
        Intrinsics.h(sVar, "pool");
        return new w(str, str2, sVar);
    }

    @Override // io.b
    public void i(PostSubjectItem postSubjectItem) {
        Intrinsics.h(postSubjectItem, "data");
        ImmVideoHelper.h.a().s(postSubjectItem);
    }

    @Override // io.b
    public void j(Application application) {
        Intrinsics.h(application, "application");
        a.a.f(a.a, "ShortTv", "---------------initShortTv--------------", false, 4, (Object) null);
        pq.c.a.d(application, new i());
        cs.a.a.c(application, new com.transsion.postdetail.shorttv.factory.a());
    }

    @Override // io.b
    public Fragment k(String str) {
        return RoomPostPopularFragment.Companion.a(str);
    }

    @Override // io.b
    public Fragment l(String str) {
        return RoomPostNearbyFragment.Companion.a(str);
    }

    @Override // io.b
    public void m(String str) {
        Intrinsics.h(str, "tag");
        cw.c cVar = cw.c.a;
        if (cVar.b(str)) {
            a.a.f(a.a, "VideoFloat", "资源被删除，移除pip,tag:" + str, false, 4, (Object) null);
            cVar.a();
            new Handler(Looper.getMainLooper()).postDelayed(new a(), 1500L);
        }
    }

    @Override // io.b
    public void n(Fragment fragment) {
        if (fragment instanceof RoomPostExploreFragment) {
            ((RoomPostExploreFragment) fragment).insertRoomCacheData();
        }
    }

    @Override // io.b
    public BaseItemProvider o(String str, String str2, RecyclerView.s sVar) {
        Intrinsics.h(sVar, "pool");
        return new n(str, str2, sVar);
    }
}
