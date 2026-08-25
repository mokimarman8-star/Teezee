package ho;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.y;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLTextView;
import com.transsion.baselib.report.k;
import com.transsion.baselib.report.k$a;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.e;
import com.transsion.player.p003enum.ScaleMode;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.video.PostFeedVideoView;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import on.e0;
import wf.a;
import wn.b0;
import yg.l;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e extends RecyclerView.r implements a, com.transsion.player.orplayer.e, k$a {
    private final Context a;
    private final Fragment b;
    private final RecyclerView c;
    private final com.transsion.postdetail.ui.adapter.f d;
    private final String e;
    private final String f;
    private final boolean g;
    private Boolean h;
    private final int i;
    private final int j;
    private com.transsion.player.orplayer.f k;
    private PostFeedVideoView l;
    private com.transsion.postdetail.layer.b m;
    private int n;
    private String o;
    private int p;
    private long q;
    private boolean r;
    private b0 s;
    private int t;
    private float u;

    public e(Context context, Fragment fragment, RecyclerView recyclerView, com.transsion.postdetail.ui.adapter.f fVar, String str, String str2, boolean z) {
        Intrinsics.h(context, "context");
        Intrinsics.h(fragment, "fragment");
        Intrinsics.h(str, "pageName");
        Intrinsics.h(str2, "subpageName");
        this.a = context;
        this.b = fragment;
        this.c = recyclerView;
        this.d = fVar;
        this.e = str;
        this.f = str2;
        this.g = z;
        this.i = lj.a.b(82);
        this.j = lj.a.b(56);
        this.n = -1;
        this.p = y.a();
        this.r = true;
        this.u = 1.0f;
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(this);
        }
        k.a.g(this);
        o();
        if (recyclerView != null) {
            recyclerView.postDelayed(new Runnable() { // from class: ho.b
                @Override // java.lang.Runnable
                public final void run() {
                    e.g(e.this);
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(e eVar) {
        eVar.h();
    }

    private final void h() {
        PostSubjectItem postSubjectItem;
        List data;
        RecyclerView recyclerView = this.c;
        RecyclerView.m layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null || !l.a.e()) {
            return;
        }
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        IntProgression o = this.t > 0 ? RangesKt.o(findLastVisibleItemPosition, findFirstVisibleItemPosition) : new IntRange(findFirstVisibleItemPosition, findLastVisibleItemPosition);
        int f = o.f();
        int i = o.i();
        int l = o.l();
        if ((l <= 0 || f > i) && (l >= 0 || i > f)) {
            return;
        }
        while (true) {
            View findViewByPosition = linearLayoutManager.findViewByPosition(f);
            if (findViewByPosition != null) {
                Rect rect = new Rect();
                findViewByPosition.getGlobalVisibleRect(rect);
                int height = findViewByPosition.getHeight();
                int e = RangesKt.e(rect.bottom - (height / 2), rect.top);
                int i2 = (this.p - this.i) / 2;
                int b = i2 - lj.a.b(200);
                int b2 = lj.a.b(250) + i2;
                com.transsion.postdetail.ui.adapter.f fVar = this.d;
                if (f >= ((fVar == null || (data = fVar.getData()) == null) ? 0 : data.size())) {
                    return;
                }
                com.transsion.postdetail.ui.adapter.f fVar2 = this.d;
                if (fVar2 != null && (postSubjectItem = (PostSubjectItem) fVar2.getItem(f)) != null) {
                    if (Intrinsics.c(this.o, postSubjectItem.getPostId())) {
                        a.a.f(wf.a.a, "PostFeedVideo", "triggerVideoPlay position:" + f + " same ~ return", false, 4, (Object) null);
                        return;
                    }
                    if (postSubjectItem.isVideo()) {
                        View p0 = this.d.p0(f, R$id.layout_content_video);
                        FrameLayout frameLayout = p0 instanceof FrameLayout ? (FrameLayout) p0 : null;
                        if (frameLayout == null) {
                            a.a.l(wf.a.a, "PostFeedVideo", "triggerVideoPlay itemVideoContainer is null", false, 4, (Object) null);
                        } else {
                            a.a.r(wf.a.a, "PostFeedVideo", new String[]{StringsKt.n("\n                checkActiveItemPosition position:" + f + ",  \n                    top:" + rect.top + ", bottom:" + rect.bottom + "\n                    screenCenterTop：" + b + "   screenCenterBottom：" + b2 + "\n                    itemHeight:" + height + " viewCenter:" + e + ", screenCenter:" + i2 + "\n            ")}, false, 4, (Object) null);
                            if (Math.abs(i2 - e) < lj.a.b(220)) {
                                p(f, postSubjectItem, frameLayout);
                                return;
                            }
                        }
                    }
                }
            }
            if (f == i) {
                return;
            } else {
                f += l;
            }
        }
    }

    private final void i(RecyclerView recyclerView) {
        int findFirstVisibleItemPosition;
        int findLastVisibleItemPosition;
        LinearLayoutManager layoutManager = recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? layoutManager : null;
        if (linearLayoutManager == null || (findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition()) > (findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition())) {
            return;
        }
        while (true) {
            View findViewByPosition = linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
            if (findViewByPosition != null) {
                findViewByPosition.getGlobalVisibleRect(new Rect());
                if (r3.bottom - r3.top <= findViewByPosition.getHeight() * 0.5f) {
                    m(findFirstVisibleItemPosition);
                }
            }
            if (findFirstVisibleItemPosition == findLastVisibleItemPosition) {
                return;
            } else {
                findFirstVisibleItemPosition++;
            }
        }
    }

    private final void j(Context context) {
        if (this.k == null) {
            PostFeedVideoView postFeedVideoView = new PostFeedVideoView(context);
            postFeedVideoView.updateMute(this.r);
            postFeedVideoView.setMuteClickCallback(new Function1() { // from class: ho.c
                public final Object invoke(Object obj) {
                    Unit k;
                    k = e.k(e.this, ((Boolean) obj).booleanValue());
                    return k;
                }
            });
            postFeedVideoView.setRemovePlayerCallback(new Function0() { // from class: ho.d
                public final Object invoke() {
                    Unit l;
                    l = e.l(e.this);
                    return l;
                }
            });
            this.l = postFeedVideoView;
            com.transsion.player.orplayer.f m = e0.a.m();
            a.a.f(wf.a.a, "PostFeedVideo", "createPlayer----", false, 4, (Object) null);
            m.addPlayerListener(this);
            PostFeedVideoView postFeedVideoView2 = this.l;
            m.setSurfaceView(postFeedVideoView2 != null ? postFeedVideoView2.getSurfaceView() : null);
            m.setScaleMode(ScaleMode.SCALE_ASPECT_FILL);
            this.k = m;
        }
        if (this.m == null) {
            com.transsion.postdetail.layer.b bVar = new com.transsion.postdetail.layer.b();
            com.transsion.player.orplayer.f fVar = this.k;
            Intrinsics.e(fVar);
            bVar.v(fVar);
            bVar.u(this.e);
            bVar.z(this.f);
            this.m = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(e eVar, boolean z) {
        a.a.f(wf.a.a, "PostFeedVideo", "volume click isMute:" + z, false, 4, (Object) null);
        eVar.r = z;
        com.transsion.player.orplayer.f fVar = eVar.k;
        if (fVar != null) {
            fVar.setVolume(z ? 0.0f : eVar.u);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(e eVar) {
        eVar.n();
        return Unit.a;
    }

    private final void m(int i) {
        List data;
        try {
            Result.Companion companion = Result.Companion;
            PostFeedVideoView postFeedVideoView = this.l;
            if ((postFeedVideoView != null ? postFeedVideoView.getParent() : null) != null && this.n == i) {
                com.transsion.postdetail.ui.adapter.f fVar = this.d;
                if (i >= ((fVar == null || (data = fVar.getData()) == null) ? 0 : data.size())) {
                    return;
                }
                com.transsion.postdetail.ui.adapter.f fVar2 = this.d;
                PostSubjectItem postSubjectItem = fVar2 != null ? (PostSubjectItem) fVar2.getItem(i) : null;
                if (postSubjectItem != null && postSubjectItem.isVideo()) {
                    a.a aVar = wf.a.a;
                    Group group = postSubjectItem.getGroup();
                    String name = group != null ? group.getName() : null;
                    a.a.f(aVar, "PostFeedVideo", "position：" + i + " --已隐藏超过50%, 移除播放器, " + name + ", " + postSubjectItem.getContent(), false, 4, (Object) null);
                    n();
                }
                Result.constructor-impl(Unit.a);
            }
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }

    private final void n() {
        AppCompatImageView appCompatImageView;
        BLTextView bLTextView;
        ShapeableImageView shapeableImageView;
        com.transsion.postdetail.layer.b bVar = this.m;
        if (bVar != null) {
            com.transsion.postdetail.layer.b.e(bVar, false, 1, null);
        }
        b0 b0Var = this.s;
        if (b0Var != null && (shapeableImageView = b0Var.d) != null) {
            uf.c.k(shapeableImageView);
        }
        b0 b0Var2 = this.s;
        if (b0Var2 != null && (bLTextView = b0Var2.f) != null) {
            uf.c.k(bLTextView);
        }
        b0 b0Var3 = this.s;
        if (b0Var3 != null && (appCompatImageView = b0Var3.e) != null) {
            uf.c.k(appCompatImageView);
        }
        this.s = null;
        PostFeedVideoView postFeedVideoView = this.l;
        ViewParent parent = postFeedVideoView != null ? postFeedVideoView.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this.l);
        }
        com.transsion.player.orplayer.f fVar = this.k;
        if (fVar != null) {
            fVar.stop();
        }
        com.transsion.player.orplayer.f fVar2 = this.k;
        if (fVar2 != null) {
            fVar2.reset();
        }
        com.transsion.player.orplayer.f fVar3 = this.k;
        if (fVar3 != null) {
            fVar3.clearScreen();
        }
        this.n = -1;
        this.o = null;
        io.d.a.a();
    }

    private final void o() {
        Boolean m1;
        Boolean bool;
        boolean z = true;
        if (!Intrinsics.c(this.h, Boolean.TRUE)) {
            ConfigBean c = cm.f.c.a().c("sa_post_video_auto_play", true);
            String value = c != null ? c.getValue() : null;
            if (value == null || value.length() == 0) {
                bool = Boolean.FALSE;
            } else {
                Boolean m12 = StringsKt.m1(value);
                bool = Boolean.valueOf(m12 != null ? m12.booleanValue() : false);
            }
            this.h = bool;
        }
        ConfigBean c2 = cm.f.c.a().c("room_home_video_play_mute", true);
        String value2 = c2 != null ? c2.getValue() : null;
        if (value2 != null && value2.length() != 0 && (m1 = StringsKt.m1(value2)) != null) {
            z = m1.booleanValue();
        }
        this.r = z;
        a.a.f(wf.a.a, "PostFeedVideo", "----------------initConfig, isOpen:" + this.h + "+------+isVideoMute:" + z, false, 4, (Object) null);
    }

    private final void p(int i, PostSubjectItem postSubjectItem, FrameLayout frameLayout) {
        List video;
        AppCompatImageView appCompatImageView;
        FrameLayout frameLayout2;
        a.a aVar = wf.a.a;
        Group group = postSubjectItem.getGroup();
        Object obj = null;
        String name = group != null ? group.getName() : null;
        a.a.r(aVar, "PostFeedVideo", new String[]{"-------> triggerVideoPlay 播放视频:" + i + ", roomName:" + name + ", " + postSubjectItem.getContent()}, false, 4, (Object) null);
        n();
        j(this.a);
        b0 a = b0.a(frameLayout);
        this.s = a;
        if (a != null && (frameLayout2 = a.b) != null) {
            frameLayout2.addView(this.l);
        }
        b0 b0Var = this.s;
        if (b0Var != null && (appCompatImageView = b0Var.e) != null) {
            uf.c.g(appCompatImageView);
        }
        this.n = i;
        this.o = postSubjectItem.getPostId();
        com.transsion.postdetail.layer.b bVar = this.m;
        if (bVar != null) {
            bVar.g();
        }
        com.transsion.postdetail.layer.b bVar2 = this.m;
        if (bVar2 != null) {
            bVar2.a(0, 0);
        }
        com.transsion.postdetail.layer.b bVar3 = this.m;
        if (bVar3 != null) {
            bVar3.x(postSubjectItem.getPostId(), postSubjectItem);
        }
        Media media = postSubjectItem.getMedia();
        if (media == null || (video = media.getVideo()) == null) {
            return;
        }
        Iterator it = video.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String url = ((Video) next).getUrl();
            if (!(url == null || url.length() == 0)) {
                obj = next;
                break;
            }
        }
        Video video2 = (Video) obj;
        if (video2 != null) {
            Integer duration = video2.getDuration();
            if (duration != null) {
                int intValue = duration.intValue();
                PostFeedVideoView postFeedVideoView = this.l;
                if (postFeedVideoView != null) {
                    postFeedVideoView.setDurationTime(intValue * 1000);
                }
            }
            a.a.f(wf.a.a, "PostFeedVideo", "triggerVideoPlay updateMute:" + this.r, false, 4, (Object) null);
            PostFeedVideoView postFeedVideoView2 = this.l;
            if (postFeedVideoView2 != null) {
                postFeedVideoView2.updateMute(this.r);
            }
            String url2 = video2.getUrl();
            if (url2 != null) {
                com.transsion.postdetail.layer.b bVar4 = this.m;
                if (bVar4 != null) {
                    bVar4.A(url2);
                }
                com.transsion.player.orplayer.f fVar = this.k;
                if (fVar != null) {
                    fVar.setDataSource(new gn.e(url2, url2, 0, null, null, 28, null));
                }
                com.transsion.player.orplayer.f fVar2 = this.k;
                if (fVar2 != null) {
                    fVar2.prepare();
                }
            }
        }
    }

    @Override // ho.a
    public void a() {
        a.a.f(wf.a.a, "PostFeedVideo", "onSetFirstData--checkActiveItemPosition", false, 4, (Object) null);
        h();
    }

    @Override // ho.a
    public void b() {
        com.transsion.player.orplayer.f fVar;
        a.a aVar = wf.a.a;
        a.a.f(aVar, "PostFeedVideo", "onPagePause--", false, 4, (Object) null);
        com.transsion.player.orplayer.f fVar2 = this.k;
        if (fVar2 != null) {
            fVar2.pause();
        }
        String str = this.o;
        if (str == null || (fVar = this.k) == null) {
            return;
        }
        long currentPosition = fVar.getCurrentPosition();
        if (currentPosition > 0) {
            a.a.v(aVar, "PostFeedVideo", "==feedvideo savePlayProgress:" + currentPosition, false, 4, (Object) null);
            io.d.a.c(str, currentPosition);
        }
    }

    @Override // ho.a
    public void c() {
        Long b;
        o();
        String str = this.o;
        if (str != null && (b = io.d.a.b(str)) != null) {
            long longValue = b.longValue();
            if (longValue > 0) {
                a.a.f(wf.a.a, "PostFeedVideo", "==onPageResume seekTo:" + longValue, false, 4, (Object) null);
                com.transsion.player.orplayer.f fVar = this.k;
                if (fVar != null) {
                    fVar.seekTo(longValue);
                }
            }
        }
        a.a.f(wf.a.a, "PostFeedVideo", "onPageResume play", false, 4, (Object) null);
        com.transsion.player.orplayer.f fVar2 = this.k;
        if (fVar2 != null) {
            fVar2.play();
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void canNonSubscriberPlay(boolean z, int i, int i2, qn.d dVar) {
        e.a.a(this, z, i, i2, dVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void initPlayer() {
        e.a.b(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onAliyunDecodeErrorChangeSoftwareDecoder(gn.e eVar) {
        e.a.c(this, eVar);
    }

    @Override // com.transsion.baselib.report.k$a
    public void onBackgroundStatusChange(boolean z) {
        com.transsion.postdetail.layer.b bVar;
        if (z && (bVar = this.m) != null) {
            bVar.d(true);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onBufferedPosition(long j, gn.e eVar) {
        e.a.d(this, j, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onCompletion(gn.e eVar) {
        e.a.e(this, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onFocusChange(boolean z) {
        e.a.g(this, z);
    }

    @Override // com.transsion.player.orplayer.e
    public void onIsPlayingChanged(boolean z) {
        e.a.h(this, z);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingBegin(gn.e eVar) {
        com.transsion.postdetail.layer.b bVar = this.m;
        if (bVar != null) {
            bVar.h();
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingEnd(gn.e eVar) {
        com.transsion.postdetail.layer.b bVar = this.m;
        if (bVar != null) {
            bVar.i();
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingProgress(int i, float f, gn.e eVar) {
        e.a.m(this, i, f, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoopingStart() {
        e.a.o(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onMediaItemTransition(String str) {
        e.a.p(this, str);
    }

    @Override // ho.a
    public void onPageDestroy() {
        a.a.f(wf.a.a, "PostFeedVideo", "onPageDestroy", false, 4, (Object) null);
        RecyclerView recyclerView = this.c;
        if (recyclerView != null) {
            recyclerView.removeOnScrollListener(this);
        }
        com.transsion.player.orplayer.f fVar = this.k;
        if (fVar != null) {
            fVar.removePlayerListener(this);
        }
        com.transsion.player.orplayer.f fVar2 = this.k;
        if (fVar2 != null) {
            fVar2.stop();
        }
        com.transsion.player.orplayer.f fVar3 = this.k;
        if (fVar3 != null) {
            fVar3.reset();
        }
        com.transsion.player.orplayer.f fVar4 = this.k;
        if (fVar4 != null) {
            fVar4.release();
        }
        this.k = null;
        PostFeedVideoView postFeedVideoView = this.l;
        ViewParent parent = postFeedVideoView != null ? postFeedVideoView.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this.l);
        }
        this.l = null;
        io.d.a.a();
        k.a.t(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayError(PlayError playError, gn.e eVar) {
        Intrinsics.h(playError, "errorInfo");
        com.transsion.postdetail.layer.b bVar = this.m;
        if (bVar != null) {
            bVar.k(playError);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerRelease(gn.e eVar) {
        e.a.t(this, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerReset() {
        e.a.v(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPrepare(gn.e eVar) {
        Float volume;
        a.a.v(wf.a.a, "PostFeedVideo", "----------onPrepare Position:" + this.n + "， isVideoMute：" + this.r, false, 4, (Object) null);
        com.transsion.player.orplayer.f fVar = this.k;
        if (fVar != null) {
            fVar.setLooping(true);
        }
        com.transsion.player.orplayer.f fVar2 = this.k;
        if (fVar2 != null) {
            fVar2.setScaleMode(ScaleMode.SCALE_ASPECT_FILL);
        }
        PostFeedVideoView postFeedVideoView = this.l;
        if (postFeedVideoView != null) {
            com.transsion.player.orplayer.f fVar3 = this.k;
            postFeedVideoView.setProgressMax(fVar3 != null ? (int) fVar3.getDuration() : 100);
        }
        if (!this.b.isResumed() || this.b.isHidden()) {
            com.transsion.player.orplayer.f fVar4 = this.k;
            if (fVar4 != null) {
                fVar4.pause();
            }
        } else {
            com.transsion.player.orplayer.f fVar5 = this.k;
            if (fVar5 != null) {
                fVar5.play();
            }
        }
        if (!this.r) {
            com.transsion.player.orplayer.f fVar6 = this.k;
            this.u = (fVar6 == null || (volume = fVar6.getVolume()) == null) ? 1.0f : volume.floatValue();
        }
        com.transsion.player.orplayer.f fVar7 = this.k;
        if (fVar7 != null) {
            fVar7.setVolume(this.r ? 0.0f : 1.0f);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onProgress(long j, gn.e eVar) {
        PostFeedVideoView postFeedVideoView = this.l;
        if (postFeedVideoView != null) {
            postFeedVideoView.setProgress((int) j);
        }
        com.transsion.postdetail.layer.b bVar = this.m;
        if (bVar != null) {
            bVar.l(j);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onRenderFirstFrame() {
        BLTextView bLTextView;
        ShapeableImageView shapeableImageView;
        a.a.f(wf.a.a, "PostFeedVideo", "-----onRenderFirstFrame Position:" + this.n, false, 4, (Object) null);
        com.transsion.postdetail.layer.b bVar = this.m;
        if (bVar != null) {
            bVar.m();
        }
        PostFeedVideoView postFeedVideoView = this.l;
        if (postFeedVideoView != null) {
            postFeedVideoView.setProgress(0);
        }
        b0 b0Var = this.s;
        if (b0Var != null && (shapeableImageView = b0Var.d) != null) {
            uf.c.g(shapeableImageView);
        }
        b0 b0Var2 = this.s;
        if (b0Var2 == null || (bLTextView = b0Var2.f) == null) {
            return;
        }
        uf.c.g(bLTextView);
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        Intrinsics.h(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, i);
        if (Intrinsics.c(this.h, Boolean.TRUE) && i == 0) {
            h();
        }
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.h(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        if (Intrinsics.c(this.h, Boolean.TRUE)) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.q < 100) {
                return;
            }
            this.q = currentTimeMillis;
            i(recyclerView);
            this.t = i2;
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onSetDataSource() {
        e.a.B(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksAudioBitrateChange(int i) {
        e.a.C(this, i);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksChange(qn.c cVar) {
        e.a.D(this, cVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksVideoBitrateChange(int i) {
        e.a.E(this, i);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoPause(gn.e eVar) {
        com.transsion.postdetail.layer.b bVar = this.m;
        if (bVar != null) {
            bVar.n();
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoSizeChanged(int i, int i2) {
        e.a.H(this, i, i2);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoStart(gn.e eVar) {
        a.a.f(wf.a.a, "PostFeedVideo", "-----onVideoStart Position:" + this.n, false, 4, (Object) null);
        com.transsion.postdetail.layer.b bVar = this.m;
        if (bVar != null) {
            bVar.o();
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void setOnSeekCompleteListener() {
        e.a.K(this);
    }
}
