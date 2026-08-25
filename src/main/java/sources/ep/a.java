package ep;

import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.player.orplayer.e;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public interface a {
    boolean a(String str);

    void addPlayerListener(e eVar);

    boolean b(AudioBean audioBean);

    boolean c();

    void d(AudioBean audioBean, boolean z);

    long e();

    boolean f();

    void pause();

    void prepare();

    void removePlayerListener(e eVar);

    void seekTo(long j);

    void start();

    void stop();
}
