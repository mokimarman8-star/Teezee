package ur;

import androidx.fragment.app.FragmentActivity;
import com.transsion.shorttv.bean.DownloadItem;
import com.transsion.shorttv.bean.DownloadListBean;
import com.transsion.shorttv.bean.Subject;
import java.util.List;
import kotlin.coroutines.Continuation;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface d {

    public static final class a {
        public static void a(d dVar, FragmentActivity fragmentActivity, String str, int i) {
        }
    }

    Object a(String str, int i, String str2, Continuation continuation);

    Object b(String str, Continuation continuation);

    void c();

    Object d(String str, int i, long j, Continuation continuation);

    boolean e(long j);

    DownloadItem f(String str);

    void g(DownloadListBean downloadListBean, Subject subject, String str, String str2, String str3, List list);

    void h(FragmentActivity fragmentActivity, DownloadItem downloadItem, int i, String str);

    Object i(String str, Continuation continuation);

    void j(m mVar);

    void k(FragmentActivity fragmentActivity, String str, int i);

    void l(n nVar);
}
