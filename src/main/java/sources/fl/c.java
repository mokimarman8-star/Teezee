package fl;

import android.content.Context;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class c {
    private volatile h a;
    private final Context b;

    public c(Context context) {
        this.b = context;
    }

    public h a(long j, long j2) {
        if (this.a == null) {
            synchronized (this) {
                try {
                    if (this.a == null) {
                        this.a = new g(this.b, j, j2).a();
                    }
                } finally {
                }
            }
        }
        return this.a;
    }
}
