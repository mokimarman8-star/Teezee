package ep;

import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.flow.bean.MediaType;
import com.transsion.home.p000enum.BottomTabType;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import io.b;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class k {
    public static final k a = new k();
    private static boolean b;
    private static boolean c;
    private static String d;
    private static String e;
    private static String f;
    private static boolean g;
    private static String h;

    private k() {
    }

    public static /* synthetic */ void i(k kVar, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        kVar.h(str, str2, str3, z);
    }

    public static /* synthetic */ void k(k kVar, PostSubjectItem postSubjectItem, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        kVar.j(postSubjectItem, str, str2, z);
    }

    public final boolean a() {
        return b;
    }

    public final boolean b() {
        return c;
    }

    public final String c() {
        return h;
    }

    public final String d() {
        return d;
    }

    public final String e() {
        return e;
    }

    public final boolean f() {
        return g;
    }

    public final String g() {
        return f;
    }

    public final void h(String str, String str2, String str3, boolean z) {
        d = str;
        e = str2;
        f = str3;
        if (!b || z) {
            ij.k.p(TheRouter.c("/room/home"));
        } else {
            ij.k.p(TheRouter.c("/main/tab").K("bottomTab", BottomTabType.TAB_CODE_COMMUNITY).K("topTab", "Community"));
        }
    }

    public final void j(PostSubjectItem postSubjectItem, String str, String str2, boolean z) {
        Intrinsics.h(postSubjectItem, "item");
        e = str;
        f = str2;
        Media media = postSubjectItem.getMedia();
        String mediaType = media != null ? media.getMediaType() : null;
        MediaType mediaType2 = MediaType.VIDEO;
        if (Intrinsics.c(mediaType, mediaType2.getValue())) {
            b bVar = (b) TheRouter.d(b.class, new Object[0]);
            if (bVar != null) {
                bVar.i(postSubjectItem);
            }
            Media media2 = postSubjectItem.getMedia();
            Navigator K = TheRouter.c(Intrinsics.c(media2 != null ? media2.getMediaType() : null, mediaType2.getValue()) ? "/post/detailVideo" : "/post/detail").K("page_from", str2).J("item_object", postSubjectItem).K("id", postSubjectItem.getPostId()).K("rec_ops", postSubjectItem.getOps()).K("item_type", postSubjectItem.getItemType());
            Media media3 = postSubjectItem.getMedia();
            ij.k.p(K.K("media_type", media3 != null ? media3.getMediaType() : null).z("is_build_in", postSubjectItem.getBuiltIn()));
            return;
        }
        Media media4 = postSubjectItem.getMedia();
        if (!Intrinsics.c(media4 != null ? media4.getMediaType() : null, MediaType.IMAGE.getValue())) {
            h(postSubjectItem.getPostId(), str, str2, z);
            return;
        }
        g = true;
        h = postSubjectItem.getPostId();
        if (!b || z) {
            ij.k.p(TheRouter.c("/room/home"));
        } else {
            ij.k.p(TheRouter.c("/main/tab").K("bottomTab", BottomTabType.TAB_CODE_COMMUNITY).K("topTab", "Community"));
        }
    }

    public final void l(boolean z) {
        b = z;
    }

    public final void m(boolean z) {
        c = z;
    }

    public final void n(String str) {
        h = str;
    }

    public final void o(String str) {
        d = str;
    }

    public final void p(String str) {
        e = str;
    }

    public final void q(boolean z) {
        g = z;
    }

    public final void r(String str) {
        f = str;
    }
}
