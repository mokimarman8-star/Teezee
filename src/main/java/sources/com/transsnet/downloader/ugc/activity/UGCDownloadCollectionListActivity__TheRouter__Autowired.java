package com.transsnet.downloader.ugc.activity;

import androidx.annotation.Keep;
import com.therouter.TheRouter;
import com.therouter.router.b;
import java.util.Iterator;
import mf.a;
import okhttp3.HttpUrl;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class UGCDownloadCollectionListActivity__TheRouter__Autowired {
    public static final String TAG = "Created by kymjs, and APT Version is 1.3.0.";
    public static final String THEROUTER_APT_VERSION = "1.3.0";

    public static void autowiredInject(Object obj) {
        if (obj instanceof UGCDownloadCollectionListActivity) {
            UGCDownloadCollectionListActivity uGCDownloadCollectionListActivity = (UGCDownloadCollectionListActivity) obj;
            Iterator it = TheRouter.g().iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                try {
                    Integer num = (Integer) aVar.a("int", uGCDownloadCollectionListActivity, new b("int", "parent_position", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsnet.downloader.ugc.activity.UGCDownloadCollectionListActivity", "parentPosition", false, "No desc."));
                    if (num != null) {
                        uGCDownloadCollectionListActivity.parentPosition = num.intValue();
                    }
                } catch (Exception e) {
                    if (TheRouter.m()) {
                        e.printStackTrace();
                    }
                }
                try {
                    String str = (String) aVar.a("java.lang.String", uGCDownloadCollectionListActivity, new b("java.lang.String", "collection_id", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsnet.downloader.ugc.activity.UGCDownloadCollectionListActivity", "collectionId", false, "No desc."));
                    if (str != null) {
                        uGCDownloadCollectionListActivity.collectionId = str;
                    }
                } catch (Exception e2) {
                    if (TheRouter.m()) {
                        e2.printStackTrace();
                    }
                }
                try {
                    String str2 = (String) aVar.a("java.lang.String", uGCDownloadCollectionListActivity, new b("java.lang.String", "name", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsnet.downloader.ugc.activity.UGCDownloadCollectionListActivity", "name", false, "No desc."));
                    if (str2 != null) {
                        uGCDownloadCollectionListActivity.name = str2;
                    }
                } catch (Exception e3) {
                    if (TheRouter.m()) {
                        e3.printStackTrace();
                    }
                }
                try {
                    String str3 = (String) aVar.a("java.lang.String", uGCDownloadCollectionListActivity, new b("java.lang.String", "subject_id", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsnet.downloader.ugc.activity.UGCDownloadCollectionListActivity", "subjectId", false, "No desc."));
                    if (str3 != null) {
                        uGCDownloadCollectionListActivity.subjectId = str3;
                    }
                } catch (Exception e4) {
                    if (TheRouter.m()) {
                        e4.printStackTrace();
                    }
                }
            }
        }
    }
}
