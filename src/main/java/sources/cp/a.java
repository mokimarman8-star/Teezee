package cp;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;
import ni.f;
import zg.h;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class a {
    public static final void a(ImageView imageView, Uri uri, float f) {
        Intrinsics.h(imageView, "<this>");
        if (uri == null) {
            return;
        }
        f.a aVar = f.a;
        Context context = imageView.getContext();
        Intrinsics.g(context, "getContext(...)");
        f.b g = aVar.m(context).g(uri.toString());
        h hVar = h.a;
        Context context2 = imageView.getContext();
        Intrinsics.g(context2, "getContext(...)");
        g.j(hVar.a(context2, f)).d(imageView);
    }

    public static final void b(ImageView imageView, String str, float f) {
        Intrinsics.h(imageView, "<this>");
        Intrinsics.h(str, "url");
        f.a aVar = f.a;
        Context context = imageView.getContext();
        Intrinsics.g(context, "getContext(...)");
        f.b g = aVar.m(context).g(str);
        h hVar = h.a;
        Context context2 = imageView.getContext();
        Intrinsics.g(context2, "getContext(...)");
        g.j(hVar.a(context2, f)).d(imageView);
    }

    public static /* synthetic */ void c(ImageView imageView, String str, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        b(imageView, str, f);
    }
}
