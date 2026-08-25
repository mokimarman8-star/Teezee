package kn;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.transsion.player.longvideo.constants.LongVodContentType;
import com.transsion.player.longvideo.constants.LongVodPageType;
import com.transsion.player.longvideo.ui.LongVodUiType;
import com.transsion.player.orplayer.f;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.videofloat.bean.FloatActionType;
import java.util.List;
import kotlin.collections.CollectionsKt;
import ln.c;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface a {

    /* renamed from: kn.a$a, reason: collision with other inner class name */
    public static final class C0081a {
        public static /* synthetic */ void a(a aVar, String str, LongVodPageType longVodPageType, String str2, FrameLayout frameLayout, ViewGroup viewGroup, List list, LongVodContentType longVodContentType, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: init");
            }
            aVar.init(str, longVodPageType, str2, frameLayout, viewGroup, (i & 32) != 0 ? CollectionsKt.l() : list, (i & 64) != 0 ? LongVodContentType.SUBJECT : longVodContentType);
        }
    }

    public interface b {
        void a();

        boolean b();

        boolean c(FloatActionType floatActionType);

        void d(LongVodUiType longVodUiType);

        View e();

        void f(boolean z);

        void g(ln.a aVar);

        void onCompletion();
    }

    long currentPosition();

    void exitFullScreen();

    f getPlayer();

    /* renamed from: getPlayerView */
    ORPlayerView getOrPlayerView();

    c getPlayingStream();

    SimpleSubtitleView getSubtitleView();

    ViewGroup getSubtitleViewGroup();

    void hasNextEpisode(boolean z);

    void hideBottomController(boolean z);

    void init(String str, LongVodPageType longVodPageType, String str2, FrameLayout frameLayout, ViewGroup viewGroup, List list, LongVodContentType longVodContentType);

    boolean onBackPressed();

    void onHandlePause();

    void onHandlePlay();

    void onPageDestroy();

    void onPipModeChanged(boolean z);

    void onSaveHistory();

    void onViewPause();

    void onViewResume();

    void release();

    void removeNoNetError();

    void replay();

    void reset();

    void setCallback(b bVar);

    void setDataSource(ln.a aVar);

    void setFloatIsShow(boolean z);

    void showNoNetError();

    void showReplay();

    void ugcAutoPause2PlayVideo();

    void updateReportId(String str, String str2, String str3);
}
