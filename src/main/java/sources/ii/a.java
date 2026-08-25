package ii;

import android.text.TextUtils;
import com.transsion.audio.player.AudioPlayer;
import com.transsion.audio.view.d;
import com.transsion.audio.viewmodel.HistoryListManager;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.player.orplayer.e;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class a implements ep.a {
    @Override // ep.a
    public boolean a(String str) {
        Intrinsics.h(str, "audioUrl");
        return AudioPlayer.i.a().z(str);
    }

    @Override // ep.a
    public void addPlayerListener(e eVar) {
        Intrinsics.h(eVar, "listener");
        AudioPlayer.i.a().m(eVar);
    }

    @Override // ep.a
    public boolean b(AudioBean audioBean) {
        Intrinsics.h(audioBean, "audio");
        return AudioPlayer.i.a().y(audioBean);
    }

    @Override // ep.a
    public boolean c() {
        return AudioPlayer.i.a().p();
    }

    @Override // ep.a
    public void d(AudioBean audioBean, boolean z) {
        Intrinsics.h(audioBean, "audio");
        AudioPlayer.a aVar = AudioPlayer.i;
        AudioBean t = aVar.a().t();
        if (TextUtils.equals(t != null ? t.getAudioUrl() : null, audioBean.getAudioUrl())) {
            if (aVar.a().J()) {
                return;
            }
            aVar.a().K();
            return;
        }
        HistoryListManager.a aVar2 = HistoryListManager.e;
        aVar2.b().w(audioBean);
        aVar.a().L(audioBean);
        d.k().t(audioBean);
        String subjectId = audioBean.getSubjectId();
        String str = subjectId == null ? "" : subjectId;
        String postId = audioBean.getPostId();
        String str2 = postId == null ? "" : postId;
        if (!z || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        HistoryListManager.t(aVar2.b(), str, str2, 0, 4, (Object) null);
    }

    @Override // ep.a
    public long e() {
        return AudioPlayer.i.a().s();
    }

    @Override // ep.a
    public boolean f() {
        return AudioPlayer.i.a().J();
    }

    @Override // ep.a
    public void pause() {
        AudioPlayer.i.a().G();
    }

    @Override // ep.a
    public void prepare() {
        AudioPlayer.i.a().K();
    }

    @Override // ep.a
    public void removePlayerListener(e eVar) {
        Intrinsics.h(eVar, "listener");
        AudioPlayer.i.a().O(eVar);
    }

    @Override // ep.a
    public void seekTo(long j) {
        AudioPlayer.i.a().P(j);
    }

    @Override // ep.a
    public void start() {
        AudioPlayer.i.a().S();
    }

    @Override // ep.a
    public void stop() {
        AudioPlayer.i.a().T();
    }
}
