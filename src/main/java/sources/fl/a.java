package fl;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class a {
    public boolean a(Object obj, File file, long j) {
        try {
            kl.a.e((ByteBuffer) obj, file);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }
}
