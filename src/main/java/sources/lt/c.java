package lt;

import com.transsion.baselib.db.download.DownloadBean;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface c {

    public static final class a {
        public static void a(c cVar, boolean z, DownloadBean bean) {
            Intrinsics.h(bean, "bean");
        }

        public static void b(c cVar, ht.a bean) {
            Intrinsics.h(bean, "bean");
        }
    }

    void K(boolean z, DownloadBean downloadBean);

    void g(ht.a aVar);
}
