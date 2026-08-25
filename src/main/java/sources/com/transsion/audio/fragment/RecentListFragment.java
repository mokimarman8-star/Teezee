package com.transsion.audio.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.c0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.therouter.TheRouter;
import com.transsion.audio.adapter.c;
import com.transsion.audio.player.AudioPlayer;
import com.transsion.audio.viewmodel.HistoryListManager;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.flow.bean.MediaType;
import com.transsion.gslb.BuildConfig;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.e;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 >2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001-B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u001b\u0010\u000b\u001a\u00020\u0006*\u00020\b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u0005J\u001f\u0010\u0011\u001a\u00020\u00062\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\u0005J\u000f\u0010\u001e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001e\u0010\u0005J\u000f\u0010\u001f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001f\u0010\u0005J\u0019\u0010\"\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b\"\u0010#J!\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b&\u0010'J!\u0010*\u001a\u00020\u00062\u0006\u0010)\u001a\u00020(2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b*\u0010+J\u0019\u0010,\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b,\u0010#R\u0016\u0010/\u001a\u00020\b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b-\u0010.R\u001d\u00105\u001a\u0004\u0018\u0001008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006?"}, d2 = {"Lcom/transsion/audio/fragment/RecentListFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lki/b;", "Lcom/transsion/player/orplayer/e;", "<init>", "()V", BuildConfig.FLAVOR, "j0", "Lcom/transsion/audio/adapter/c;", "Lcom/transsion/baselib/db/audio/AudioBean;", "item", "f0", "(Lcom/transsion/audio/adapter/c;Lcom/transsion/baselib/db/audio/AudioBean;)V", "h0", "loadData", BuildConfig.FLAVOR, "list", "l0", "(Ljava/util/List;)V", "Landroid/view/LayoutInflater;", "inflater", "g0", "(Landroid/view/LayoutInflater;)Lki/b;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "lazyLoadData", "onResume", "onPause", "Lgn/e;", "mediaSource", "onPrepare", "(Lgn/e;)V", BuildConfig.FLAVOR, "progress", "onProgress", "(JLgn/e;)V", "Lcom/transsion/player/orplayer/PlayError;", "errorInfo", "onPlayError", "(Lcom/transsion/player/orplayer/PlayError;Lgn/e;)V", "onCompletion", "a", "Lcom/transsion/audio/adapter/c;", "mAdapter", "Lep/a;", "b", "Lkotlin/Lazy;", "getMAudioApi", "()Lep/a;", "mAudioApi", BuildConfig.FLAVOR, "c", "Ljava/lang/String;", "previousUrl", "Ljava/util/concurrent/atomic/AtomicBoolean;", "d", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mIsStop", "e", "Audio_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class RecentListFragment extends BaseFragment<ki.b> implements com.transsion.player.orplayer.e {

    /* renamed from: a, reason: from kotlin metadata */
    private com.transsion.audio.adapter.c mAdapter;

    /* renamed from: b, reason: from kotlin metadata */
    private final Lazy mAudioApi = LazyKt.b(new Function0() { // from class: com.transsion.audio.fragment.e
        public final Object invoke() {
            ep.a mAudioApi_delegate$lambda$0;
            mAudioApi_delegate$lambda$0 = RecentListFragment.mAudioApi_delegate$lambda$0();
            return mAudioApi_delegate$lambda$0;
        }
    });

    /* renamed from: c, reason: from kotlin metadata */
    private String previousUrl = BuildConfig.FLAVOR;

    /* renamed from: d, reason: from kotlin metadata */
    private AtomicBoolean mIsStop = new AtomicBoolean(false);

    public static final class b implements c.a {
        final /* synthetic */ com.transsion.audio.adapter.c b;

        b(com.transsion.audio.adapter.c cVar) {
            this.b = cVar;
        }

        @Override // com.transsion.audio.adapter.c.a
        public void a(AudioBean audioBean) {
            Intrinsics.h(audioBean, "item");
            RecentListFragment.this.f0(this.b, audioBean);
        }

        @Override // com.transsion.audio.adapter.c.a
        public void b(AudioBean audioBean) {
            Intrinsics.h(audioBean, "item");
            if (!AudioPlayer.i.a().y(audioBean)) {
                Long readProcess = audioBean.getReadProcess();
                long longValue = readProcess != null ? readProcess.longValue() : 0L;
                Long duration = audioBean.getDuration();
                boolean z = longValue >= (duration != null ? duration.longValue() : -500L);
                if (audioBean.getStatus() == 6 || z) {
                    audioBean.setReadProcess(0L);
                }
                RecentListFragment.this.mIsStop.set(false);
                audioBean.setStatus(3);
                ep.a aVar = (ep.a) TheRouter.d(ep.a.class, new Object[0]);
                if (aVar != null) {
                    aVar.d(audioBean, false);
                }
            } else if (audioBean.getStatus() == 3) {
                RecentListFragment.this.mIsStop.set(true);
                audioBean.setStatus(4);
                ep.a aVar2 = (ep.a) TheRouter.d(ep.a.class, new Object[0]);
                if (aVar2 != null) {
                    aVar2.stop();
                }
            } else {
                RecentListFragment.this.mIsStop.set(false);
                audioBean.setStatus(3);
                ep.a aVar3 = (ep.a) TheRouter.d(ep.a.class, new Object[0]);
                if (aVar3 != null) {
                    aVar3.prepare();
                }
            }
            RecentListFragment recentListFragment = RecentListFragment.this;
            Long readProcess2 = audioBean.getReadProcess();
            recentListFragment.onProgress(readProcess2 != null ? readProcess2.longValue() : 0L, new gn.e(audioBean.getAudioUrl(), audioBean.getAudioUrl(), 0, null, null, 28, null));
        }
    }

    static final class c implements c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        c(Function1 function1) {
            Intrinsics.h(function1, "function");
            this.a = function1;
        }

        public final Function a() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0(com.transsion.audio.adapter.c cVar, AudioBean audioBean) {
        if (audioBean.getStatus() == 3) {
            AudioPlayer.i.a().T();
        }
        RecyclerView.Adapter adapter = this.mAdapter;
        if (adapter == null) {
            Intrinsics.y("mAdapter");
            adapter = null;
        }
        adapter.notifyItemRemoved(cVar.g0(audioBean));
        cVar.getData().remove(audioBean);
        HistoryListManager.e.b().o(audioBean);
    }

    private final ep.a getMAudioApi() {
        return (ep.a) this.mAudioApi.getValue();
    }

    private final void h0() {
        HistoryListManager.e.b().p().j(this, new c(new Function1() { // from class: com.transsion.audio.fragment.f
            public final Object invoke(Object obj) {
                Unit i0;
                i0 = RecentListFragment.i0(RecentListFragment.this, (List) obj);
                return i0;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i0(RecentListFragment recentListFragment, List list) {
        recentListFragment.l0(list);
        return Unit.a;
    }

    private final void j0() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        ViewGroup.LayoutParams layoutParams;
        AudioBottomSheetFragment parentFragment = getParentFragment();
        Intrinsics.f(parentFragment, "null cannot be cast to non-null type com.transsion.audio.fragment.AudioBottomSheetFragment");
        AudioBottomSheetFragment audioBottomSheetFragment = parentFragment;
        ki.b bVar = (ki.b) getMViewBinding();
        if (bVar != null && (recyclerView3 = bVar.b) != null && (layoutParams = recyclerView3.getLayoutParams()) != null) {
            layoutParams.height = audioBottomSheetFragment.D0() - a0.a(48.0f);
        }
        ki.b bVar2 = (ki.b) getMViewBinding();
        if (bVar2 != null && (recyclerView2 = bVar2.b) != null) {
            recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        com.transsion.audio.adapter.c cVar = new com.transsion.audio.adapter.c(new ArrayList());
        cVar.w1(new r6.d() { // from class: com.transsion.audio.fragment.g
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                RecentListFragment.k0(baseQuickAdapter, view, i);
            }
        });
        cVar.I1(new b(cVar));
        this.mAdapter = cVar;
        ki.b bVar3 = (ki.b) getMViewBinding();
        if (bVar3 == null || (recyclerView = bVar3.b) == null) {
            return;
        }
        RecyclerView.Adapter adapter = this.mAdapter;
        if (adapter == null) {
            Intrinsics.y("mAdapter");
            adapter = null;
        }
        recyclerView.setAdapter(adapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "view");
        Object item = baseQuickAdapter.getItem(i);
        if (item instanceof AudioBean) {
            AudioBean audioBean = (AudioBean) item;
            if (TextUtils.isEmpty(audioBean.getPostId())) {
                fh.b.a.e("This page is unavailable");
            } else {
                ij.k.p(TheRouter.c("/post/detail").K("page_from", "audio_list").K("id", audioBean.getPostId()).K("media_type", MediaType.AUDIO.getValue()).z("video_load_more", true));
            }
        }
    }

    private final void l0(List list) {
        com.transsion.audio.adapter.c cVar = null;
        if (list == null || list.isEmpty()) {
            com.transsion.audio.adapter.c cVar2 = this.mAdapter;
            if (cVar2 == null) {
                Intrinsics.y("mAdapter");
                cVar2 = null;
            }
            t6.f.u(cVar2.h0(), false, 1, (Object) null);
            return;
        }
        com.transsion.audio.adapter.c cVar3 = this.mAdapter;
        if (cVar3 == null) {
            Intrinsics.y("mAdapter");
        } else {
            cVar = cVar3;
        }
        cVar.n1(list);
    }

    private final void loadData() {
        HistoryListManager.e.b().r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ep.a mAudioApi_delegate$lambda$0() {
        return (ep.a) TheRouter.d(ep.a.class, new Object[0]);
    }

    @Override // com.transsion.player.orplayer.e
    public void canNonSubscriberPlay(boolean z, int i, int i2, qn.d dVar) {
        e.a.a(this, z, i, i2, dVar);
    }

    /* renamed from: g0, reason: merged with bridge method [inline-methods] */
    public ki.b getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        ki.b c2 = ki.b.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }

    @Override // com.transsion.player.orplayer.e
    public void initPlayer() {
        e.a.b(this);
    }

    public void initView(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        j0();
        h0();
    }

    public void lazyLoadData() {
        loadData();
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
    public void onCompletion(gn.e mediaSource) {
        e.a.e(this, mediaSource);
        com.transsion.audio.adapter.c cVar = this.mAdapter;
        if (cVar == null) {
            Intrinsics.y("mAdapter");
            cVar = null;
        }
        int i = 0;
        for (Object obj : cVar.getData()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.u();
            }
            AudioBean audioBean = (AudioBean) obj;
            if (TextUtils.equals(mediaSource != null ? mediaSource.j() : null, audioBean.getAudioUrl())) {
                audioBean.setStatus(6);
                RecyclerView.Adapter adapter = this.mAdapter;
                if (adapter == null) {
                    Intrinsics.y("mAdapter");
                    adapter = null;
                }
                adapter.notifyItemChanged(i, audioBean);
                this.previousUrl = mediaSource != null ? mediaSource.j() : null;
            }
            i = i2;
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
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoopingStart() {
        e.a.o(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onMediaItemTransition(String str) {
        e.a.p(this, str);
    }

    public void onPause() {
        super.onPause();
        ep.a mAudioApi = getMAudioApi();
        if (mAudioApi != null) {
            mAudioApi.removePlayerListener(this);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayError(PlayError errorInfo, gn.e mediaSource) {
        Intrinsics.h(errorInfo, "errorInfo");
        e.a.q(this, errorInfo, mediaSource);
        fh.b.a.e(String.valueOf(errorInfo.getErrorMessage()));
        com.transsion.audio.adapter.c cVar = this.mAdapter;
        if (cVar == null) {
            Intrinsics.y("mAdapter");
            cVar = null;
        }
        int i = 0;
        for (Object obj : cVar.getData()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.u();
            }
            AudioBean audioBean = (AudioBean) obj;
            if (audioBean.getStatus() == 3) {
                audioBean.setStatus(7);
                RecyclerView.Adapter adapter = this.mAdapter;
                if (adapter == null) {
                    Intrinsics.y("mAdapter");
                    adapter = null;
                }
                adapter.notifyItemChanged(i, audioBean);
            }
            i = i2;
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
    public void onPrepare(gn.e mediaSource) {
        e.a.w(this, mediaSource);
        if (TextUtils.equals(this.previousUrl, mediaSource != null ? mediaSource.j() : null)) {
            return;
        }
        com.transsion.audio.adapter.c cVar = this.mAdapter;
        if (cVar == null) {
            Intrinsics.y("mAdapter");
            cVar = null;
        }
        int i = 0;
        for (Object obj : cVar.getData()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.u();
            }
            AudioBean audioBean = (AudioBean) obj;
            if (TextUtils.equals(this.previousUrl, audioBean.getAudioUrl())) {
                audioBean.setStatus(4);
                RecyclerView.Adapter adapter = this.mAdapter;
                if (adapter == null) {
                    Intrinsics.y("mAdapter");
                    adapter = null;
                }
                adapter.notifyItemChanged(i, audioBean);
                this.previousUrl = mediaSource != null ? mediaSource.j() : null;
            }
            i = i2;
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onProgress(long progress, gn.e mediaSource) {
        e.a.y(this, progress, mediaSource);
        com.transsion.audio.adapter.c cVar = this.mAdapter;
        if (cVar == null) {
            Intrinsics.y("mAdapter");
            cVar = null;
        }
        int i = 0;
        for (Object obj : cVar.getData()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.u();
            }
            AudioBean audioBean = (AudioBean) obj;
            if (TextUtils.isEmpty(this.previousUrl)) {
                this.previousUrl = mediaSource != null ? mediaSource.j() : null;
            }
            if (!TextUtils.equals(this.previousUrl, mediaSource != null ? mediaSource.j() : null) && TextUtils.equals(this.previousUrl, audioBean.getAudioUrl())) {
                audioBean.setStatus(4);
                RecyclerView.Adapter adapter = this.mAdapter;
                if (adapter == null) {
                    Intrinsics.y("mAdapter");
                    adapter = null;
                }
                adapter.notifyItemChanged(i, audioBean);
                this.previousUrl = mediaSource != null ? mediaSource.j() : null;
            }
            if (TextUtils.equals(mediaSource != null ? mediaSource.j() : null, audioBean.getAudioUrl()) && !this.mIsStop.get()) {
                audioBean.setReadProcess(Long.valueOf(progress));
                audioBean.setStatus(3);
                RecyclerView.Adapter adapter2 = this.mAdapter;
                if (adapter2 == null) {
                    Intrinsics.y("mAdapter");
                    adapter2 = null;
                }
                adapter2.notifyItemChanged(i, audioBean);
            }
            i = i2;
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onRenderFirstFrame() {
        e.a.A(this);
    }

    public void onResume() {
        super.onResume();
        ep.a mAudioApi = getMAudioApi();
        if (mAudioApi != null) {
            mAudioApi.addPlayerListener(this);
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
        e.a.F(this, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoSizeChanged(int i, int i2) {
        e.a.H(this, i, i2);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoStart(gn.e eVar) {
        e.a.I(this, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void setOnSeekCompleteListener() {
        e.a.K(this);
    }
}
