package ii;

import android.app.Activity;
import com.transsion.audio.player.AudioPlayer;
import com.transsion.audio.view.d;
import com.transsion.baselib.db.audio.AudioBean;
import ep.b;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class c implements b {
    private boolean a;

    @Override // ep.b
    public void a(WeakReference weakReference, AudioBean audioBean) {
        Intrinsics.h(weakReference, "refer");
        Intrinsics.h(audioBean, "audioBean");
        d.k().d((Activity) weakReference.get(), audioBean);
        d.k().f((Activity) weakReference.get());
    }

    @Override // ep.b
    public void b() {
        d.k().s();
    }

    @Override // ep.b
    public void c() {
        AudioPlayer.a aVar = AudioPlayer.i;
        if (aVar.a().J()) {
            aVar.a().G();
            this.a = true;
        }
        hide();
    }

    @Override // ep.b
    public void d(b.a aVar) {
        d.k().v(aVar);
    }

    @Override // ep.b
    public void e() {
        if (this.a) {
            AudioPlayer.i.a().S();
            this.a = false;
            show();
        }
    }

    @Override // ep.b
    public void f(String str) {
        Intrinsics.h(str, "name");
        d.k().x(str);
    }

    @Override // ep.b
    public void g(WeakReference weakReference) {
        Intrinsics.h(weakReference, "refer");
        d.k().f((Activity) weakReference.get());
    }

    @Override // ep.b
    public void h() {
        d.k().r();
    }

    @Override // ep.b
    public void hide() {
        d.k().w(8);
    }

    @Override // ep.b
    public void i(WeakReference weakReference) {
        Intrinsics.h(weakReference, "refer");
        d.k().h((Activity) weakReference.get());
    }

    @Override // ep.b
    public void j(b.a aVar) {
        d.k().u(aVar);
    }

    @Override // ep.b
    public void show() {
        d.k().w(0);
    }
}
