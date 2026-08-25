package h8;

import java.io.File;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class c implements b {
    private long a;

    public c(long j) {
        this.a = j;
    }

    @Override // h8.b
    public boolean b(File file) {
        return file.length() > this.a;
    }
}
