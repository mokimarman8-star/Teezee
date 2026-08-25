package im;

import android.content.Context;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
import okio.Okio;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g {
    private final String a = "skulist.json";

    public final String a(Context context) {
        Intrinsics.h(context, "context");
        try {
            InputStream open = context.getResources().getAssets().open(this.a);
            Intrinsics.e(open);
            return Okio.buffer(Okio.source(open)).readUtf8();
        } catch (Exception unused) {
            return null;
        }
    }
}
