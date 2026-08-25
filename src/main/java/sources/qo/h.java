package qo;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.transsion.gslb.BuildConfig;
import java.io.File;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import wg.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class h {
    public static final a a = new a(null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, String str, b bVar) {
            Intrinsics.h(context, "context");
            Intrinsics.h(bVar, "callback");
            try {
                Bitmap bitmap = (Bitmap) Glide.with(context).asBitmap().load(str).diskCacheStrategy(DiskCacheStrategy.ALL).submit(Integer.MIN_VALUE, Integer.MIN_VALUE).get();
                File cacheDir = context.getCacheDir();
                a.a aVar = wg.a.a;
                if (str == null) {
                    str = BuildConfig.FLAVOR;
                }
                File file = new File(cacheDir, "pic" + aVar.a(str) + ".jpg");
                if (!file.exists()) {
                    qo.a.c(bitmap, file, 100);
                }
                String absolutePath = file.getAbsolutePath();
                Intrinsics.g(absolutePath, "getAbsolutePath(...)");
                bVar.a(absolutePath);
            } catch (Exception unused) {
                bVar.a(BuildConfig.FLAVOR);
            }
        }
    }

    public interface b {
        void a(String str);
    }
}
