package com.transsion.shorttv.subtitle.manager;

import com.transsion.shorttv.subtitle.manager.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface b {
    public static final a a = a.a;

    public static final class a {
        static final /* synthetic */ a a = new a();
        private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.shorttv.subtitle.manager.a
            public final Object invoke() {
                ShortTvVideoSubtitleManagerImp c;
                c = b.a.c();
                return c;
            }
        });

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ShortTvVideoSubtitleManagerImp c() {
            return new ShortTvVideoSubtitleManagerImp();
        }

        public final b b() {
            return (b) b.getValue();
        }
    }

    /* renamed from: com.transsion.shorttv.subtitle.manager.b$b, reason: collision with other inner class name */
    public static final class C0064b {
        public static /* synthetic */ void a(b bVar, xr.a aVar, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onVideoPageInNet2CheckSubtitle");
            }
            if ((i & 2) != 0) {
                function1 = null;
            }
            bVar.e(aVar, function1);
        }
    }

    Object a(String str, Continuation continuation);

    void b(com.transsion.subtitle_download.a aVar);

    void c(com.transsion.subtitle_download.a aVar);

    void d(xr.b bVar);

    void e(xr.a aVar, Function1 function1);

    void f(zr.a aVar);

    void g(zr.a aVar);

    void init();
}
