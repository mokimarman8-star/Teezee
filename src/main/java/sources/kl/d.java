package kl;

import com.transsion.player.mediasession.MediaItem;
import java.io.Closeable;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class d {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th2) {
                jl.a.a.d(MediaItem.MUSIC_FLOAT_STATE_ERROR, th2.getMessage());
            }
        }
    }
}
