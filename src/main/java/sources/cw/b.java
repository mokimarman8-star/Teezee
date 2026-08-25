package cw;

import androidx.fragment.app.FragmentActivity;
import com.transsion.player.orplayer.f;
import com.transsion.videofloat.manager.i;
import cw.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface b {
    public static final a a = a.a;

    public static final class a {
        static final /* synthetic */ a a = new a();
        private static final String b = "pip_permission_dialog";
        private static final String c = "key_video_float_permission";
        private static final Lazy d = LazyKt.b(new Function0() { // from class: cw.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                i e;
                e = b.a.e();
                return e;
            }
        });

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final i e() {
            return new i();
        }

        public final String b() {
            return c;
        }

        public final b c() {
            return (b) d.getValue();
        }

        public final String d() {
            return b;
        }
    }

    /* renamed from: cw.b$b, reason: collision with other inner class name */
    public static final class C0053b {
        public static /* synthetic */ void a(b bVar, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stopFloat");
            }
            if ((i & 1) != 0) {
                z = true;
            }
            bVar.g(z);
        }
    }

    boolean b(String str);

    boolean c(f fVar);

    void d();

    void e(FragmentActivity fragmentActivity, dw.a aVar, boolean z, boolean z2, Function1 function1, gw.a aVar2);

    void f(FragmentActivity fragmentActivity, String str, String str2, String str3, String str4);

    void g(boolean z);

    boolean isPlaying();
}
