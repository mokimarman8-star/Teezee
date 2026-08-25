package com.transsion.moviedetail.activity;

import androidx.annotation.Keep;
import com.therouter.TheRouter;
import com.therouter.router.b;
import com.transsion.gslb.BuildConfig;
import java.util.Iterator;
import mf.a;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class MovieDetailActivity__TheRouter__Autowired {
    public static final String TAG = "Created by kymjs, and APT Version is 1.3.0.";
    public static final String THEROUTER_APT_VERSION = "1.3.0";

    public static void autowiredInject(Object obj) {
        if (obj instanceof MovieDetailActivity) {
            MovieDetailActivity movieDetailActivity = (MovieDetailActivity) obj;
            Iterator it = TheRouter.g().iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                try {
                    Boolean bool = (Boolean) aVar.a("boolean", movieDetailActivity, new b("boolean", "autoDownload", 0, BuildConfig.FLAVOR, "com.transsion.moviedetail.activity.MovieDetailActivity", "autoDownload", false, "No desc."));
                    if (bool != null) {
                        movieDetailActivity.autoDownload = bool.booleanValue();
                    }
                } catch (Exception e) {
                    if (TheRouter.m()) {
                        e.printStackTrace();
                    }
                }
                try {
                    Boolean bool2 = (Boolean) aVar.a("boolean", movieDetailActivity, new b("boolean", "autoPlay", 0, BuildConfig.FLAVOR, "com.transsion.moviedetail.activity.MovieDetailActivity", "autoPlay", false, "No desc."));
                    if (bool2 != null) {
                        movieDetailActivity.autoPlay = bool2.booleanValue();
                    }
                } catch (Exception e2) {
                    if (TheRouter.m()) {
                        e2.printStackTrace();
                    }
                }
                try {
                    Integer num = (Integer) aVar.a("int", movieDetailActivity, new b("int", "season", 0, BuildConfig.FLAVOR, "com.transsion.moviedetail.activity.MovieDetailActivity", "curSeason", false, "No desc."));
                    if (num != null) {
                        movieDetailActivity.curSeason = num.intValue();
                    }
                } catch (Exception e3) {
                    if (TheRouter.m()) {
                        e3.printStackTrace();
                    }
                }
                try {
                    Integer num2 = (Integer) aVar.a("int", movieDetailActivity, new b("int", "subject_type", 0, BuildConfig.FLAVOR, "com.transsion.moviedetail.activity.MovieDetailActivity", "subjectYpe", false, "No desc."));
                    if (num2 != null) {
                        movieDetailActivity.subjectYpe = num2.intValue();
                    }
                } catch (Exception e4) {
                    if (TheRouter.m()) {
                        e4.printStackTrace();
                    }
                }
                try {
                    Integer num3 = (Integer) aVar.a("int", movieDetailActivity, new b("int", "yy_preload_id", 0, BuildConfig.FLAVOR, "com.transsion.moviedetail.activity.MovieDetailActivity", "preloadId", false, "No desc."));
                    if (num3 != null) {
                        movieDetailActivity.preloadId = num3.intValue();
                    }
                } catch (Exception e5) {
                    if (TheRouter.m()) {
                        e5.printStackTrace();
                    }
                }
                try {
                    String str = (String) aVar.a("java.lang.String", movieDetailActivity, new b("java.lang.String", "id", 0, BuildConfig.FLAVOR, "com.transsion.moviedetail.activity.MovieDetailActivity", "id", false, "No desc."));
                    if (str != null) {
                        movieDetailActivity.id = str;
                    }
                } catch (Exception e6) {
                    if (TheRouter.m()) {
                        e6.printStackTrace();
                    }
                }
                try {
                    String str2 = (String) aVar.a("java.lang.String", movieDetailActivity, new b("java.lang.String", "module_name", 0, BuildConfig.FLAVOR, "com.transsion.moviedetail.activity.MovieDetailActivity", "moduleName", false, "No desc."));
                    if (str2 != null) {
                        movieDetailActivity.moduleName = str2;
                    }
                } catch (Exception e7) {
                    if (TheRouter.m()) {
                        e7.printStackTrace();
                    }
                }
                try {
                    String str3 = (String) aVar.a("java.lang.String", movieDetailActivity, new b("java.lang.String", "ops", 0, BuildConfig.FLAVOR, "com.transsion.moviedetail.activity.MovieDetailActivity", "ops", false, "No desc."));
                    if (str3 != null) {
                        movieDetailActivity.ops = str3;
                    }
                } catch (Exception e8) {
                    if (TheRouter.m()) {
                        e8.printStackTrace();
                    }
                }
                try {
                    String str4 = (String) aVar.a("java.lang.String", movieDetailActivity, new b("java.lang.String", "resourceId", 0, BuildConfig.FLAVOR, "com.transsion.moviedetail.activity.MovieDetailActivity", "autoPlayResourceId", false, "No desc."));
                    if (str4 != null) {
                        movieDetailActivity.autoPlayResourceId = str4;
                    }
                } catch (Exception e9) {
                    if (TheRouter.m()) {
                        e9.printStackTrace();
                    }
                }
            }
        }
    }
}
