package com.transsion.subtitle;

import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.subtitle.h;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import lt.c;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public interface h {
    public static final a a = a.a;

    public static final class a {
        static final /* synthetic */ a a = new a();
        private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.subtitle.g
            public final Object invoke() {
                VideoSubtitleManagerImp c;
                c = h.a.c();
                return c;
            }
        });

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final VideoSubtitleManagerImp c() {
            return new VideoSubtitleManagerImp();
        }

        public final h b() {
            return (h) b.getValue();
        }
    }

    Object a(String str, Continuation continuation);

    void b(com.transsion.subtitle_download.a aVar);

    void c(com.transsion.subtitle_download.a aVar);

    void d(c cVar);

    void destroy();

    void e(DownloadBean downloadBean, Function1 function1);

    void f(c cVar);

    void g(ht.a aVar);

    void h(ht.a aVar);

    void i(DownloadBean downloadBean);

    void init();

    void j(ht.a aVar);

    void reset();
}
