package sm;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.y;
import com.transsion.flow.bean.MediaType;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.moviedetailapi.bean.FirstFrame;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.player.orplayer.ORPlayerPreloadManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ni.f;
import wf.a;
import yg.l;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b extends RecyclerView.r {
    public static final a e = new a(null);
    private static final Lazy f = LazyKt.b(new Function0() { // from class: sm.a
        public final Object invoke() {
            int j;
            j = b.j();
            return Integer.valueOf(j);
        }
    });
    private final float a;
    private final Function1 b;
    private final String c;
    private boolean d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return ((Number) b.f.getValue()).intValue();
        }
    }

    public b(float f2, Function1 function1) {
        String value;
        Boolean m1;
        Intrinsics.h(function1, "getItemCallback");
        this.a = f2;
        this.b = function1;
        this.c = "ListVideoPreload";
        boolean z = false;
        ConfigBean c = cm.f.c.a().c("feed_video_preload_switch", false);
        if (c != null && (value = c.getValue()) != null && (m1 = StringsKt.m1(value)) != null) {
            z = m1.booleanValue();
        }
        this.d = z;
    }

    private final float f(View view) {
        if (view == null) {
            return 0.0f;
        }
        int height = view.getHeight();
        if (view.getGlobalVisibleRect(new Rect())) {
            return (float) ((r2.height() * 1.0d) / height);
        }
        return 0.0f;
    }

    private final Video g(List list) {
        Object obj = null;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Video video = (Video) it.next();
                Integer definition = video.getDefinition();
                if (definition != null && definition.intValue() == 3) {
                    obj = video;
                }
            }
        }
        if (obj == null && list != null && (!list.isEmpty())) {
            obj = list.get(0);
        }
        return (Video) obj;
    }

    private final void h(PostSubjectItem postSubjectItem) {
        FirstFrame firstFrame;
        String url;
        Media media = postSubjectItem.getMedia();
        if (media == null || (firstFrame = media.getFirstFrame()) == null || (url = firstFrame.getUrl()) == null) {
            return;
        }
        f.a aVar = ni.f.a;
        a aVar2 = e;
        f.a.j(aVar, f.a.e(aVar, url, aVar2.a(), false, true, 4, null), url, aVar2.a(), null, 8, null);
    }

    private final void i(PostSubjectItem postSubjectItem) {
        String url;
        Media media = postSubjectItem.getMedia();
        Video g = g(media != null ? media.getVideo() : null);
        if (g == null || (url = g.getUrl()) == null) {
            return;
        }
        ORPlayerPreloadManager.i.a().i(url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int j() {
        return y.e();
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        int findFirstVisibleItemPosition;
        int findLastVisibleItemPosition;
        String str;
        Media media;
        Intrinsics.h(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, i);
        if (i != 0 || !this.d || !l.a.e()) {
            return;
        }
        LinearLayoutManager layoutManager = recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? layoutManager : null;
        if (linearLayoutManager == null || (findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition()) > (findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition())) {
            return;
        }
        int i2 = findFirstVisibleItemPosition;
        while (true) {
            a.a aVar = wf.a.a;
            a.a.f(aVar, this.c, "on scroll idle, firstPosition = " + findFirstVisibleItemPosition + ", lastPosition = " + findLastVisibleItemPosition + ", position = " + i2, false, 4, (Object) null);
            try {
                PostSubjectItem postSubjectItem = (PostSubjectItem) this.b.invoke(Integer.valueOf(i2));
                if (Intrinsics.c((postSubjectItem == null || (media = postSubjectItem.getMedia()) == null) ? null : media.getMediaType(), MediaType.VIDEO.getValue()) && !postSubjectItem.getBuiltIn()) {
                    View findViewByPosition = linearLayoutManager.findViewByPosition(i2);
                    float f2 = f(findViewByPosition);
                    float f3 = this.a;
                    if (f3 > 0.6f) {
                        f3 = 0.6f;
                    }
                    if (f2 >= f3) {
                        String str2 = this.c;
                        Subject subject = postSubjectItem.getSubject();
                        str = "tryPreloadVideo, position = ";
                        a.a.f(aVar, str2, "tryPreloadVideo, position = " + i2 + ", title = " + (subject != null ? subject.getTitle() : null), false, 4, (Object) null);
                        h(postSubjectItem);
                    } else {
                        str = "tryPreloadVideo, position = ";
                    }
                    if (f(findViewByPosition) >= this.a) {
                        String str3 = this.c;
                        Subject subject2 = postSubjectItem.getSubject();
                        a.a.f(aVar, str3, str + i2 + ", title = " + (subject2 != null ? subject2.getTitle() : null), false, 4, (Object) null);
                        i(postSubjectItem);
                    }
                }
            } catch (Throwable unused) {
            }
            if (i2 == findLastVisibleItemPosition) {
                return;
            } else {
                i2++;
            }
        }
    }
}
