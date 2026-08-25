package com.transsnet.downloader.activity;

import androidx.annotation.Keep;
import com.therouter.TheRouter;
import java.util.Iterator;
import okhttp3.HttpUrl;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class DownloadSeriesListActivity__TheRouter__Autowired {
    public static final String TAG = "Created by kymjs, and APT Version is 1.3.0.";
    public static final String THEROUTER_APT_VERSION = "1.3.0";

    public static void autowiredInject(Object obj) {
        if (obj instanceof DownloadSeriesListActivity) {
            DownloadSeriesListActivity downloadSeriesListActivity = (DownloadSeriesListActivity) obj;
            Iterator it = TheRouter.g().iterator();
            while (it.hasNext()) {
                mf.a aVar = (mf.a) it.next();
                try {
                    Integer num = (Integer) aVar.a("int", downloadSeriesListActivity, new com.therouter.router.b("int", "extra_parent_position", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsnet.downloader.activity.DownloadSeriesListActivity", "parentPosition", false, "No desc."));
                    if (num != null) {
                        downloadSeriesListActivity.parentPosition = num.intValue();
                    }
                } catch (Exception e) {
                    if (TheRouter.m()) {
                        e.printStackTrace();
                    }
                }
                try {
                    String str = (String) aVar.a("java.lang.String", downloadSeriesListActivity, new com.therouter.router.b("java.lang.String", "extra_name", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsnet.downloader.activity.DownloadSeriesListActivity", "name", false, "No desc."));
                    if (str != null) {
                        downloadSeriesListActivity.name = str;
                    }
                } catch (Exception e2) {
                    if (TheRouter.m()) {
                        e2.printStackTrace();
                    }
                }
                try {
                    String str2 = (String) aVar.a("java.lang.String", downloadSeriesListActivity, new com.therouter.router.b("java.lang.String", "extra_subject_id", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsnet.downloader.activity.DownloadSeriesListActivity", "subjectId", false, "No desc."));
                    if (str2 != null) {
                        downloadSeriesListActivity.subjectId = str2;
                    }
                } catch (Exception e3) {
                    if (TheRouter.m()) {
                        e3.printStackTrace();
                    }
                }
            }
        }
    }
}
