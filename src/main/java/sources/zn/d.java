package zn;

import android.view.View;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.postdetail.layer.local.LocalUiType;
import com.transsion.subtitle.VideoSubtitleControl;
import com.transsion.videofloat.bean.FloatActionType;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface d {

    public static final class a {
        public static View a(d dVar) {
            return null;
        }

        public static void b(d dVar, View view, boolean z) {
            Intrinsics.h(view, "rootView");
        }

        public static void c(d dVar, DownloadBean downloadBean) {
            Intrinsics.h(downloadBean, "bean");
        }

        public static void d(d dVar, boolean z) {
        }

        public static void e(d dVar) {
        }

        public static void f(d dVar, LocalUiType localUiType) {
            Intrinsics.h(localUiType, "newConfig");
        }

        public static void g(d dVar) {
        }

        public static void h(d dVar, boolean z, String str) {
            Intrinsics.h(str, "requestKey");
        }

        public static void i(d dVar) {
        }

        public static void j(d dVar, String str, String str2) {
            Intrinsics.h(str, "subjectId");
            Intrinsics.h(str2, "resourceId");
        }

        public static void k(d dVar, boolean z) {
        }

        public static /* synthetic */ void l(d dVar, String str, long j, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showToast");
            }
            if ((i & 2) != 0) {
                j = 3000;
            }
            dVar.i(str, j);
        }

        public static void m(d dVar, PostSubjectItem postSubjectItem) {
        }

        public static void n(d dVar, int i) {
        }

        public static void o(d dVar, float f) {
        }
    }

    void A();

    void B(VideoSubtitleControl videoSubtitleControl);

    void C(int i);

    void D(DownloadBean downloadBean);

    void E(c cVar);

    void a(LocalUiType localUiType);

    void b(boolean z, boolean z2);

    void c();

    void d();

    boolean e(FloatActionType floatActionType);

    void f(boolean z, String str);

    void g();

    void h(String str, String str2);

    void i(String str, long j);

    boolean isVisible();

    void j(boolean z);

    void k(DownloadBean downloadBean, String str, boolean z);

    void l(Map map);

    void m(LocalUiType localUiType);

    void n(b bVar);

    void o();

    void onBackPressed();

    void onViewPause();

    void onViewResume();

    void p(float f);

    void q(String str, String str2, String str3, boolean z, boolean z2);

    void r(int i, int i2);

    void s(View view, LocalUiType localUiType);

    void t();

    void u(boolean z);

    void updateTitle(String str);

    void v(String str, String str2);

    void w(boolean z);

    void x(PostSubjectItem postSubjectItem);

    void y(String str);

    void z(View view, boolean z);
}
