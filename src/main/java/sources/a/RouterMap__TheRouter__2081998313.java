package a;

import androidx.annotation.Keep;
import com.therouter.router.RouteItem;
import com.therouter.router.RouteMapKt;
import com.therouter.router.d;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class RouterMap__TheRouter__2081998313 implements d {
    public static final String COUNT = "1";
    public static final String ROUTERMAP0 = "[{\"path\":\"/ugc_search/search_manager\",\"className\":\"com.transsion.search_pugc.activity.SearchManagerActivity\",\"action\":\"\",\"description\":\"\",\"params\":{}},{\"path\":\"/search/activity/search_manager\",\"className\":\"com.transsion.search.activity.SearchManagerActivity\",\"action\":\"\",\"description\":\"\",\"params\":{}}]";
    public static final String TAG = "Created by kymjs, and APT Version is 1.3.0.";
    public static final String THEROUTER_APT_VERSION = "1.3.0";

    public static void addRoute() {
        RouteMapKt.c(new RouteItem("/ugc_search/search_manager", "com.transsion.search_pugc.activity.SearchManagerActivity", "", ""));
        RouteMapKt.c(new RouteItem("/search/activity/search_manager", "com.transsion.search.activity.SearchManagerActivity", "", ""));
    }

    public void init() {
        addRoute();
    }
}
