package sm;

import android.content.Context;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ni.f;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class d {
    public static final void b(String str) {
        Intrinsics.h(str, "url");
        f.a aVar = ni.f.a;
        final String e = f.a.e(aVar, str, aVar.c(), false, true, 4, null);
        a.a.f(wf.a.a, "ImageHelper", "preload url=" + e, false, 4, (Object) null);
        final long currentTimeMillis = System.currentTimeMillis();
        aVar.i(e, str, aVar.c(), new Function1() { // from class: sm.c
            public final Object invoke(Object obj) {
                Unit c;
                c = d.c(currentTimeMillis, e, ((Boolean) obj).booleanValue());
                return c;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(long j, String str, boolean z) {
        if (z) {
            long currentTimeMillis = System.currentTimeMillis() - j;
            a.a.f(wf.a.a, "ImageHelper", "预加载成功 duration=" + currentTimeMillis + " url=" + str, false, 4, (Object) null);
        } else {
            a.a.f(wf.a.a, "ImageHelper", str + " 预加载失败", false, 4, (Object) null);
        }
        return Unit.a;
    }

    public static final void d(Context context, List list) {
        Cover cover;
        String url;
        List image;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                PostSubjectItem postSubjectItem = (PostSubjectItem) it.next();
                Media media = postSubjectItem.getMedia();
                if (media != null && (image = media.getImage()) != null) {
                    Iterator it2 = image.iterator();
                    while (it2.hasNext()) {
                        String url2 = ((Image) it2.next()).getUrl();
                        if (url2 != null && context != null) {
                            b(url2);
                        }
                    }
                }
                Media media2 = postSubjectItem.getMedia();
                if (media2 != null && (cover = media2.getCover()) != null && (url = cover.getUrl()) != null && context != null) {
                    b(url);
                }
            }
        }
    }
}
