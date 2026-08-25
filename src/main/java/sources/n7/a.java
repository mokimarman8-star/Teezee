package n7;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;
import pl.droidsonroids.gif.GifDrawable;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class a {
    public static final a a = new a();
    private static boolean b;

    private a() {
    }

    public Drawable a(byte[] bArr) {
        Intrinsics.h(bArr, "bytes");
        if (!b) {
            return null;
        }
        try {
            Drawable gifDrawable = new GifDrawable(bArr);
            com.cloud.sdk.commonutil.util.c.Log().d("HisavanaImageRender", "android-gif-drawable: getGifDrawableFromData succees");
            return gifDrawable;
        } catch (Exception e) {
            com.cloud.sdk.commonutil.util.c.Log().w("HisavanaImageRender", "android-gif-drawable: getGifDrawableFromData failed, error=" + e.getMessage());
            return null;
        }
    }

    public final void b() {
        try {
            Class.forName("pl.droidsonroids.gif.GifDrawable");
            b = true;
            com.cloud.sdk.commonutil.util.c.Log().d("HisavanaImageRender", "init gif-drawable succeed");
        } catch (Throwable th) {
            com.cloud.sdk.commonutil.util.c.Log().w("HisavanaImageRender", "init gif-drawable error=" + th.getMessage());
        }
    }
}
