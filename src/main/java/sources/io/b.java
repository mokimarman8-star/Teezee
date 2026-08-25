package io;

import android.app.Application;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.therouter.router.RouteItem;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.RoomTabItem;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public interface b {
    void a(RouteItem routeItem, mf.b bVar);

    Fragment b(String str, RoomTabItem roomTabItem, int i);

    Fragment c(String str, RoomTabItem roomTabItem, int i);

    Fragment d(String str, String str2, String str3);

    Fragment e(String str);

    Fragment f(String str, String str2, long j, boolean z, boolean z2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10);

    void g(Fragment fragment, boolean z);

    BaseItemProvider h(String str, String str2, RecyclerView.s sVar);

    void i(PostSubjectItem postSubjectItem);

    void j(Application application);

    Fragment k(String str);

    Fragment l(String str);

    void m(String str);

    void n(Fragment fragment);

    BaseItemProvider o(String str, String str2, RecyclerView.s sVar);
}
