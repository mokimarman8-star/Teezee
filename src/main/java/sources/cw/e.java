package cw;

import android.app.PictureInPictureParams;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.transsion.player.orplayer.f;
import com.transsion.videofloat.bean.FloatActionType;
import com.transsion.videofloat.manager.VideoPipManagerImp;
import cw.e;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface e {
    public static final a a = a.a;

    public static final class a {
        static final /* synthetic */ a a = new a();
        private static final Lazy b = LazyKt.b(new Function0() { // from class: cw.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoPipManagerImp c;
                c = e.a.c();
                return c;
            }
        });

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final VideoPipManagerImp c() {
            return new VideoPipManagerImp();
        }

        public final e b() {
            return (e) b.getValue();
        }
    }

    public static final class b {
        public static /* synthetic */ void a(e eVar, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: closePip");
            }
            if ((i & 1) != 0) {
                z = true;
            }
            eVar.e(z);
        }

        public static /* synthetic */ void b(e eVar, FragmentActivity fragmentActivity, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unregisterReceiver");
            }
            if ((i & 1) != 0) {
                fragmentActivity = null;
            }
            eVar.j(fragmentActivity);
        }

        public static /* synthetic */ PictureInPictureParams c(e eVar, FragmentActivity fragmentActivity, boolean z, boolean z2, ViewGroup viewGroup, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updatePictureInPictureParams");
            }
            if ((i & 4) != 0) {
                z2 = true;
            }
            if ((i & 8) != 0) {
                viewGroup = null;
            }
            return eVar.a(fragmentActivity, z, z2, viewGroup);
        }
    }

    PictureInPictureParams a(FragmentActivity fragmentActivity, boolean z, boolean z2, ViewGroup viewGroup);

    boolean b(String str);

    boolean c();

    void d(FragmentActivity fragmentActivity, dw.a aVar, FloatActionType floatActionType, boolean z);

    void e(boolean z);

    void f();

    boolean g(f fVar);

    void h(FragmentActivity fragmentActivity, dw.a aVar);

    boolean i();

    boolean isPlaying();

    void j(FragmentActivity fragmentActivity);

    boolean k();

    void onPipModeChanged(boolean z);
}
