package com.transsion.search;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.style.ImageSpan;
import androidx.fragment.app.FragmentActivity;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.flow.bean.PlayUrl;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.DownloadManagerApi;
import ij.k;
import ij.t;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class f {
    public static final ImageSpan a(Context context, int i) {
        Intrinsics.h(context, "context");
        return Build.VERSION.SDK_INT >= 29 ? new ImageSpan(context, i, 2) : new ImageSpan(context, i, 1);
    }

    public static final ImageSpan b(Context context) {
        Intrinsics.h(context, "context");
        int i = R$drawable.ic_search_result_split;
        return Build.VERSION.SDK_INT >= 29 ? new ImageSpan(context, i, 2) : new ImageSpan(context, i, 1);
    }

    public static final void c(Subject subject, String str) {
        String playUrl;
        String playUrl2;
        Intrinsics.h(str, "playModule");
        if (subject == null) {
            return;
        }
        if (subject.isJumpBrowser()) {
            PlayUrl playUrl3 = subject.getPlayUrl();
            if (playUrl3 == null || (playUrl2 = playUrl3.getPlayUrl()) == null) {
                return;
            }
            k.i(playUrl2);
            return;
        }
        if (!subject.isJumpWebview()) {
            Navigator c = TheRouter.c("/movie/detail");
            Integer subjectType = subject.getSubjectType();
            k.p(c.F("subject_type", subjectType != null ? subjectType.intValue() : SubjectType.MOVIE.getValue()).K("id", subject.getSubjectId()).K("module_name", str).F("season", subject.getSeason()).z("autoPlay", true).K("ops", subject.getOps()));
        } else {
            PlayUrl playUrl4 = subject.getPlayUrl();
            if (playUrl4 == null || (playUrl = playUrl4.getPlayUrl()) == null) {
                return;
            }
            k.h(playUrl, null, 1, null);
        }
    }

    public static final String d(Subject subject, String str, Context context, String str2) {
        String str3;
        ResourceDetectors resourceDetector;
        String subjectId;
        ResourceDetectors resourceDetector2;
        Intrinsics.h(str, "pageName");
        Intrinsics.h(context, "context");
        Intrinsics.h(str2, "playModule");
        if (subject != null) {
            Integer subjectType = subject.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType != null && subjectType.intValue() == value) {
                DownloadManagerApi.e0(DownloadManagerApi.j.a(), (FragmentActivity) context, str, BuildConfig.FLAVOR, subject.getOps(), "download_subject", true, subject, (String) null, (Boolean) null, 384, (Object) null);
                return "download_subject";
            }
        }
        if (t.a.b()) {
            c(subject, str2);
        } else {
            DownloadManagerApi.a aVar = DownloadManagerApi.j;
            if (!DownloadManagerApi.x0(aVar.a(), subject != null ? subject.getSubjectId() : null, (subject == null || (resourceDetector2 = subject.getResourceDetector()) == null) ? null : resourceDetector2.getResourceId(), subject != null && subject.isSeries(), false, 8, (Object) null)) {
                DownloadManagerApi a = aVar.a();
                FragmentActivity fragmentActivity = (FragmentActivity) context;
                String ops = subject != null ? subject.getOps() : null;
                if (subject == null || (resourceDetector = subject.getResourceDetector()) == null || (str3 = resourceDetector.getResourceLink()) == null) {
                    str3 = BuildConfig.FLAVOR;
                }
                DownloadManagerApi.M(a, fragmentActivity, subject, str, (String) null, ops, str3, (String) null, (String) null, (String) null, false, 960, (Object) null);
                return "download_subject";
            }
            if (subject != null && (subjectId = subject.getSubjectId()) != null) {
                DownloadManagerApi.z0(aVar.a(), subjectId, context, str, (String) null, 8, (Object) null);
            }
        }
        return "play_subject";
    }

    public static final boolean e(Resources resources) {
        Intrinsics.h(resources, "resources");
        return (resources.getConfiguration().screenLayout & 15) >= 3;
    }
}
