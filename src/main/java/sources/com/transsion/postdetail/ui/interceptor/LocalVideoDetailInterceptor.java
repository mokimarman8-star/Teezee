package com.transsion.postdetail.ui.interceptor;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import com.blankj.utilcode.util.Utils;
import com.therouter.TheRouter;
import com.therouter.router.RouteItem;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.postdetail.shorttv.factory.i;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.downloader.util.LocalVideoNotExistUtil;
import cw.e;
import ij.k;
import java.io.File;
import java.io.Serializable;
import k1.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import mf.b;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class LocalVideoDetailInterceptor {
    public static final a a = new a((DefaultConstructorMarker) null);
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.interceptor.c
        public final Object invoke() {
            LocalVideoDetailInterceptor g;
            g = LocalVideoDetailInterceptor.g();
            return g;
        }
    });

    private final boolean f(String str, String str2) {
        if (str == null) {
            File file = new File(str2);
            if (file.exists() && file.length() > 0) {
                return true;
            }
        } else {
            if (StringsKt.W(str2, "content", false, 2, (Object) null)) {
                a g = a.g(Utils.a(), Uri.parse(str2));
                if (g != null) {
                    return g.e();
                }
                return true;
            }
            File file2 = new File(str2);
            if (file2.exists() && file2.length() > 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LocalVideoDetailInterceptor g() {
        return new LocalVideoDetailInterceptor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(RouteItem routeItem, b bVar) {
        try {
            if (routeItem.getExtras().getInt("subject_type", -1) == SubjectType.SHORT_TV.getValue()) {
                k.p(k.b(TheRouter.c(pr.a.a.b()), routeItem.getExtras()));
                fj.b.a(bVar);
            } else {
                a.a.l(wf.a.a, "VideoFloat", LocalVideoDetailInterceptor.class.getSimpleName() + " open page ----2", false, 4, (Object) null);
                bVar.a(routeItem);
            }
        } catch (Throwable unused) {
            bVar.a(routeItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final vr.a j() {
        return new i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ws.a k() {
        return new com.transsion.postdetail.shorttv.factory.a();
    }

    public final void i(RouteItem routeItem, b bVar) {
        String path;
        Intrinsics.h(routeItem, "postcard");
        Intrinsics.h(bVar, "callback");
        if (Intrinsics.c(routeItem.getPath(), "/ugc_video/detail") || Intrinsics.c(routeItem.getPath(), "/ugc_video/local_detail") || Intrinsics.c(routeItem.getPath(), "/ugc_shorts/detail")) {
            e.b.a(e.a.b(), false, 1, (Object) null);
        }
        if (!Intrinsics.c(routeItem.getPath(), "/video/detail")) {
            if (!Intrinsics.c(routeItem.getPath(), pr.a.a.b())) {
                bVar.a(routeItem);
                return;
            }
            pq.c.a.a(new a());
            cs.a.a.a(new b());
            e.b.a(e.a.b(), false, 1, (Object) null);
            Bundle extras = routeItem.getExtras();
            Serializable serializable = extras.getSerializable("item_object");
            Subject subject = serializable instanceof Subject ? (Subject) serializable : null;
            String string = subject == null ? extras.getString("id") : subject.getSubjectId();
            int i = extras.getInt("ep");
            int i2 = extras.getInt("extra_series_position", -1);
            if (string == null) {
                bVar.a(routeItem);
                return;
            }
            DownloadBean x = DownloadEsHelper.m.a().x(string, i);
            if ((x != null ? x.getPath() : null) == null || !x.isCompleted()) {
                bVar.a(routeItem);
                return;
            }
            String resourceId = x.getResourceId();
            String path2 = x.getPath();
            Intrinsics.e(path2);
            if (f(resourceId, path2)) {
                bVar.a(routeItem);
                return;
            }
            Activity o = com.transsion.baselib.report.k.a.o();
            if (o == null || o.isDestroyed() || o.isFinishing()) {
                return;
            }
            LocalVideoNotExistUtil.a.v(o, x, i2);
            return;
        }
        e.b.a(e.a.b(), false, 1, (Object) null);
        Bundle extras2 = routeItem.getExtras();
        String string2 = extras2.getString("extra_url");
        String string3 = extras2.getString("extra_subject_id");
        if (string3 == null) {
            string3 = "";
        }
        String string4 = extras2.getString("extra_local_path");
        String string5 = extras2.getString("extra_resource_id");
        boolean z = extras2.getBoolean("extra_is_series");
        int i3 = extras2.getInt("extra_series_position", -1);
        boolean z2 = extras2.getBoolean("extra_completed", true);
        if (extras2.getBoolean("extra_from_deeplink", false)) {
            bVar.a(routeItem);
            return;
        }
        if (string5 != null) {
            DownloadBean q = DownloadEsHelper.m.a().q(string5);
            if (q != null && (path = q.getPath()) != null) {
                string4 = path;
            }
            extras2.putString("extra_local_path", string4);
        }
        a.a aVar = wf.a.a;
        aVar.c("Download_LocalVideoDetailInterceptor", "isDownloadCompleted  = " + z2 + "， path = " + string4, true);
        boolean z3 = (string2 == null || StringsKt.W(string2, "http", false, 2, (Object) null) || string3.length() != 0) ? false : true;
        if (string4 == null || string4.length() <= 0) {
            a.a.f(aVar, "Download_LocalVideoDetailInterceptor", "file is error, show error dialog, ", false, 4, (Object) null);
            Activity o2 = com.transsion.baselib.report.k.a.o();
            if (o2 == null || o2.isDestroyed() || o2.isFinishing()) {
                return;
            }
            LocalVideoNotExistUtil localVideoNotExistUtil = LocalVideoNotExistUtil.a;
            Intrinsics.e(string5);
            localVideoNotExistUtil.w(o2, string5, string4, z, i3);
            return;
        }
        boolean f = f(string5, string4);
        if (!z2) {
            a.a.f(aVar, "Download_LocalVideoDetailInterceptor", "downloading play, open page", false, 4, (Object) null);
            kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new process.1(string5, this, routeItem, bVar, string3, (Continuation) null), 3, (Object) null);
            return;
        }
        if (f) {
            a.a.f(aVar, "Download_LocalVideoDetailInterceptor", "open page", false, 4, (Object) null);
            h(routeItem, bVar);
            return;
        }
        a.a.f(aVar, "Download_LocalVideoDetailInterceptor", "file is error, show error dialog, c, isOutside = " + z3, false, 4, (Object) null);
        if (z3) {
            fh.b.a.d(R$string.download_no_local_file_tips);
            return;
        }
        Activity o3 = com.transsion.baselib.report.k.a.o();
        if (o3 == null || o3.isDestroyed() || o3.isFinishing()) {
            return;
        }
        LocalVideoNotExistUtil localVideoNotExistUtil2 = LocalVideoNotExistUtil.a;
        Intrinsics.e(string5);
        localVideoNotExistUtil2.w(o3, string5, string4, z, i3);
    }
}
