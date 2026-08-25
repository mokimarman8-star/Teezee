package com.transsnet.downloader.manager;

import ax.b;
import com.transsion.baselib.db.download.DownloadBean;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import ui.m0;
import ui.s0;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface g {

    public static final class a {
        public static /* synthetic */ void a(g gVar, DownloadBean downloadBean, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resume");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            gVar.s(downloadBean, z);
        }
    }

    void A();

    Object B(Continuation continuation);

    void C(List list);

    void D();

    void E(s0 s0Var);

    void F(DownloadBean downloadBean);

    void G(b bVar);

    void H();

    Object a(String str, int i, String str2, Continuation continuation);

    void d();

    Object e(String str, Continuation continuation);

    void g(m0 m0Var);

    String h(DownloadBean downloadBean);

    boolean i();

    Object j(String str, Continuation continuation);

    void k(m0 m0Var);

    void l(DownloadBean downloadBean);

    void m(DownloadBean downloadBean, Function1 function1);

    void n();

    void o();

    void p(DownloadBean downloadBean);

    void q();

    void r(String str, Function1 function1);

    void s(DownloadBean downloadBean, boolean z);

    Object t(String str, int i, int i2, Continuation continuation);

    void u(DownloadBean downloadBean);

    void v();

    Long w();

    void x(zw.b bVar);

    void y(List list, Function1 function1);

    boolean z(DownloadBean downloadBean);
}
