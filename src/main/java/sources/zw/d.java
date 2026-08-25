package zw;

import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class d extends a {
    public void a(DownloadBean bean, DownloadException downloadException) {
        Intrinsics.h(bean, "bean");
        h(bean, 6);
    }

    public void b(DownloadBean bean) {
        Intrinsics.h(bean, "bean");
        if (bean.getStatus() != 7) {
            bean.setPreStatus(bean.getStatus());
        }
        h(bean, 7);
    }

    public void c(DownloadBean bean, long j, long j2) {
        Intrinsics.h(bean, "bean");
        h(bean, 2);
    }

    public void d(DownloadBean bean) {
        Intrinsics.h(bean, "bean");
        h(bean, 3);
    }

    public void e(DownloadBean bean, String str) {
        Intrinsics.h(bean, "bean");
        h(bean, 5);
    }

    public void f(DownloadBean bean) {
        Intrinsics.h(bean, "bean");
        h(bean, 4);
    }

    public void g(DownloadBean bean) {
        Intrinsics.h(bean, "bean");
        h(bean, 1);
    }

    public abstract void h(DownloadBean downloadBean, int i);
}
