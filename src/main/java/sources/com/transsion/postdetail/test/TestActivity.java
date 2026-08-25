package com.transsion.postdetail.test;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.flow.bean.CommentBean;
import com.transsion.flow.bean.MediaType;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.FirstFrame;
import com.transsion.moviedetailapi.bean.GifBean;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.Link;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Stat;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.player.config.RenderType;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.e;
import com.transsion.player.orplayer.f;
import com.transsion.player.p003enum.ScaleMode;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import qn.c;
import qn.d;
import tf.i;
import wf.a;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u0019\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u0010\u001a\n \r*\u0004\u0018\u00010\f0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\f8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\f8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001b\u0010\u000fR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/transsion/postdetail/test/TestActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", BuildConfig.FLAVOR, "R", "initPlayer", "S", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", BuildConfig.FLAVOR, "kotlin.jvm.PlatformType", "a", "Ljava/lang/String;", "TAG", "b", "json", "Landroidx/recyclerview/widget/RecyclerView;", "c", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/transsion/postdetail/test/a;", "d", "Lcom/transsion/postdetail/test/a;", "mAdapter", "e", "videoUrl", "Lcom/transsion/player/orplayer/f;", "f", "Lcom/transsion/player/orplayer/f;", "mPlayer", "Lwm/a;", "g", "Lwm/a;", "mItemChange", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class TestActivity extends AppCompatActivity {

    /* renamed from: c, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: d, reason: from kotlin metadata */
    private com.transsion.postdetail.test.a mAdapter;

    /* renamed from: f, reason: from kotlin metadata */
    private f mPlayer;

    /* renamed from: g, reason: from kotlin metadata */
    private wm.a mItemChange;

    /* renamed from: a, reason: from kotlin metadata */
    private final String TAG = TestActivity.class.getSimpleName();

    /* renamed from: b, reason: from kotlin metadata */
    private final String json = BuildConfig.FLAVOR;

    /* renamed from: e, reason: from kotlin metadata */
    private final String videoUrl = "https://test-acdn.aoneroom.com/media/video/2022/08/11/5970c1ffed2920c3b2d80da029fe3944-sd.mp4";

    public static final class a implements e {
        a() {
        }

        @Override // com.transsion.player.orplayer.e
        public void canNonSubscriberPlay(boolean z, int i, int i2, d dVar) {
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

        @Override // com.transsion.player.orplayer.e
        public void onBufferedPosition(long j, gn.e eVar) {
            e.a.d(this, j, eVar);
        }

        @Override // com.transsion.player.orplayer.e
        public void onCompletion(gn.e eVar) {
            e.a.e(this, eVar);
            wm.a aVar = TestActivity.this.mItemChange;
            if (aVar != null) {
                aVar.q();
            }
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
            e.a.i(this, eVar);
        }

        @Override // com.transsion.player.orplayer.e
        public void onLoadingEnd(gn.e eVar) {
            e.a.k(this, eVar);
        }

        @Override // com.transsion.player.orplayer.e
        public void onLoadingProgress(int i, float f, gn.e eVar) {
            e.a.m(this, i, f, eVar);
            a.a aVar = wf.a.a;
            String str = TestActivity.this.TAG;
            Intrinsics.g(str, "access$getTAG$p(...)");
            a.a.f(aVar, str, "percent=" + i, false, 4, (Object) null);
        }

        @Override // com.transsion.player.orplayer.e
        public void onLoopingStart() {
            e.a.o(this);
        }

        @Override // com.transsion.player.orplayer.e
        public void onMediaItemTransition(String str) {
            e.a.p(this, str);
        }

        @Override // com.transsion.player.orplayer.e
        public void onPlayError(PlayError playError, gn.e eVar) {
            Intrinsics.h(playError, "errorInfo");
            e.a.q(this, playError, eVar);
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
            e.a.w(this, eVar);
        }

        @Override // com.transsion.player.orplayer.e
        public void onProgress(long j, gn.e eVar) {
            e.a.y(this, j, eVar);
            a.a aVar = wf.a.a;
            String str = TestActivity.this.TAG;
            Intrinsics.g(str, "access$getTAG$p(...)");
            a.a.f(aVar, str, "process=" + j, false, 4, (Object) null);
        }

        @Override // com.transsion.player.orplayer.e
        public void onRenderFirstFrame() {
            a.a aVar = wf.a.a;
            String str = TestActivity.this.TAG;
            Intrinsics.g(str, "access$getTAG$p(...)");
            a.a.f(aVar, str, "onRenderFirstFrame", false, 4, (Object) null);
            wm.a aVar2 = TestActivity.this.mItemChange;
            if (aVar2 != null) {
                aVar2.p();
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
        public void onTracksChange(c cVar) {
            e.a.D(this, cVar);
        }

        @Override // com.transsion.player.orplayer.e
        public void onTracksVideoBitrateChange(int i) {
            e.a.E(this, i);
        }

        @Override // com.transsion.player.orplayer.e
        public void onVideoPause(gn.e eVar) {
            e.a.F(this, eVar);
        }

        @Override // com.transsion.player.orplayer.e
        public void onVideoSizeChanged(int i, int i2) {
            e.a.H(this, i, i2);
        }

        @Override // com.transsion.player.orplayer.e
        public void onVideoStart(gn.e eVar) {
            e.a.I(this, eVar);
            a.a aVar = wf.a.a;
            String str = TestActivity.this.TAG;
            Intrinsics.g(str, "access$getTAG$p(...)");
            a.a.f(aVar, str, "onVideoStart", false, 4, (Object) null);
        }

        @Override // com.transsion.player.orplayer.e
        public void setOnSeekCompleteListener() {
            e.a.K(this);
        }
    }

    public static final class b extends RecyclerView.r {
        private int a;
        private int b;

        b() {
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Intrinsics.h(recyclerView, "recyclerView");
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            com.transsion.postdetail.test.a aVar;
            List data;
            List data2;
            Intrinsics.h(recyclerView, "recyclerView");
            LinearLayoutManager layoutManager = recyclerView.getLayoutManager();
            if (!(layoutManager instanceof LinearLayoutManager)) {
                throw new RuntimeException("Unsupported layoutManager.");
            }
            LinearLayoutManager linearLayoutManager = layoutManager;
            this.a = linearLayoutManager.findLastCompletelyVisibleItemPosition();
            this.b = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            wm.a aVar2 = TestActivity.this.mItemChange;
            int b = aVar2 != null ? aVar2.b() : 0;
            boolean z = b < findFirstVisibleItemPosition || b > findLastVisibleItemPosition;
            if (linearLayoutManager.getChildCount() <= 0 || (aVar = TestActivity.this.mAdapter) == null || (data = aVar.getData()) == null || !(!data.isEmpty()) || !z) {
                return;
            }
            View childAt = linearLayoutManager.getChildAt(i2 < 0 ? linearLayoutManager.getChildCount() - 1 : 0);
            if (childAt != null) {
                int position = linearLayoutManager.getPosition(childAt);
                com.transsion.postdetail.test.a aVar3 = TestActivity.this.mAdapter;
                PostSubjectItem postSubjectItem = (aVar3 == null || (data2 = aVar3.getData()) == null) ? null : (PostSubjectItem) data2.get(position);
                wm.a aVar4 = TestActivity.this.mItemChange;
                if (aVar4 != null) {
                    aVar4.s(postSubjectItem, childAt, position);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void R() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 21; i++) {
            ArrayList arrayList2 = new ArrayList();
            Image image = new Image(200, 2000, "https://cdn.shalltry.com/tcmservice/tcmservice/111630622592760357.jpg", 200, (String) null, (String) null, new GifBean("https://test-acdn.aoneroom.com/image/2022/08/16/61e43091d911c7e773efd9189332fadb.webp", "https://test-acdn.aoneroom.com/media/video/2022/08/11/5970c1ffed2920c3b2d80da029fe3944-sd.mp4"), (String) null, (String) null, 0.0f, 0.0f, 0, 0, 0, 16256, (DefaultConstructorMarker) null);
            int i2 = i % 9;
            if (i2 >= 0) {
                while (true) {
                    arrayList2.add(image);
                    int i3 = i3 != i2 ? i3 + 1 : 0;
                }
            }
            arrayList.add(new PostSubjectItem((String) null, (String) null, (Group) null, (Boolean) null, (Boolean) null, (Link) null, new Media((List) null, (Cover) null, (FirstFrame) null, arrayList2, MediaType.IMAGE.getValue(), (List) null, (Video) null), (String) null, (Stat) null, (Integer) null, (Subject) null, (Integer) null, (String) null, (String) null, (User) null, (String) null, (String) null, (Integer) null, (String) null, false, (Float) null, (Float) null, (String) null, (String) null, false, (List) null, false, (BiddingNativeManager) null, false, false, false, false, (CommentBean) null, -524288, 1, (DefaultConstructorMarker) null));
        }
        this.mAdapter = new com.transsion.postdetail.test.a(arrayList);
        RecyclerView findViewById = findViewById(R$id.recycler_view);
        if (findViewById != null) {
            findViewById.setLayoutManager(new LinearLayoutManager(this));
            findViewById.addItemDecoration(new i(200, 0, 2, (DefaultConstructorMarker) null));
            findViewById.setAdapter(this.mAdapter);
        } else {
            findViewById = null;
        }
        this.recyclerView = findViewById;
    }

    private final void S() {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(new b());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initPlayer() {
        ORPlayerView oRPlayerView = new ORPlayerView(this, RenderType.TEXTURE_VIEW);
        f a2 = new f.a(this).a();
        a2.setTextureView(oRPlayerView.getTextureView());
        a2.setScaleMode(ScaleMode.SCALE_ASPECT_FILL);
        this.mItemChange = new wm.a(a2, oRPlayerView);
        a2.setPlayerListener(new a());
        this.mPlayer = a2;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(savedInstanceState);
        setContentView(R$layout.activity_test);
        R();
        initPlayer();
        S();
    }
}
