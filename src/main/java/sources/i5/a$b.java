package i5;

import android.content.Context;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class a$b {
    private final Context a;

    private a$b(Context context) {
        this.a = context;
    }

    public a a() {
        Context context = this.a;
        if (context != null) {
            return new b(context);
        }
        throw new IllegalArgumentException("Please provide a valid Context.");
    }
}
