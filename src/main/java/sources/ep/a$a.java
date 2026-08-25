package ep;

import com.transsion.baselib.db.audio.AudioBean;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a$a {
    public static /* synthetic */ void a(a aVar, AudioBean audioBean, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: start");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        aVar.d(audioBean, z);
    }
}
