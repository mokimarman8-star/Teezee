package com.transsion.audio.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.lifecycle.c0;
import androidx.lifecycle.u;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.integration.webp.decoder.WebpDrawable;
import com.bumptech.glide.integration.webp.decoder.WebpDrawableTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.cloud.hisavana.sdk.common.util.l;
import com.therouter.TheRouter;
import com.transsion.audio.R$id;
import com.transsion.audio.R$layout;
import com.transsion.audio.R$mipmap;
import com.transsion.audio.player.AudioPlayer;
import com.transsion.audio.viewmodel.HistoryListManager;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.report.k;
import com.transsion.flow.bean.MediaType;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.DownloadItem;
import com.transsnet.downloader.bean.DownloadListBean;
import com.transsnet.downloader.manager.p;
import java.util.ArrayList;
import java.util.List;
import zg.h;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class EnFloatingView extends FloatingMagnetView implements View.OnClickListener {
    private final ki.d h;
    private List i;
    private int j;
    private f k;
    String l;
    private Boolean m;
    DownloadListBean n;
    private final ui.a o;

    class a extends ui.a {
        a() {
        }

        @Override // ui.a, ui.m0
        public void e(DownloadBean downloadBean, String str) {
            if (downloadBean.isVideo()) {
                return;
            }
            AudioBean m = com.transsion.audio.view.d.k().m();
            if (TextUtils.equals(m.getResourceId(), downloadBean.getResourceId()) && m.getUrl() != null && downloadBean.getPath() != null && m.getUrl().startsWith("http")) {
                m.setUrl(downloadBean.getPath());
                m.setChangeToLocalPath(true);
                HistoryListManager.e.b().k(m);
            }
        }
    }

    class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            EnFloatingView.this.h.c.setVisibility(8);
            EnFloatingView.this.m = Boolean.FALSE;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            EnFloatingView.this.m = Boolean.TRUE;
        }
    }

    class c implements Animation.AnimationListener {
        c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            EnFloatingView.this.h.b.setVisibility(0);
            EnFloatingView enFloatingView = EnFloatingView.this;
            enFloatingView.setLayoutParams(enFloatingView.q(true));
        }
    }

    class d implements Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            EnFloatingView.this.h.c.setVisibility(0);
        }
    }

    class e implements Animation.AnimationListener {
        e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            EnFloatingView.this.h.b.setVisibility(8);
            EnFloatingView enFloatingView = EnFloatingView.this;
            enFloatingView.setLayoutParams(enFloatingView.q(false));
            EnFloatingView.this.m = Boolean.FALSE;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            EnFloatingView.this.m = Boolean.TRUE;
        }
    }

    interface f {
        void a(ViewGroup viewGroup);

        void b(ViewGroup viewGroup);
    }

    public EnFloatingView(@NonNull Context context) {
        this(context, R$layout.new_en_floating_view);
    }

    public EnFloatingView(@NonNull Context context, int i) {
        super(context, null);
        this.i = new ArrayList();
        this.j = 0;
        this.m = Boolean.FALSE;
        this.n = null;
        this.o = new a();
        View.inflate(context, i, this);
        this.h = ki.d.a(findViewById(R$id.clRoot));
        r();
        s();
        setLayoutParams(q(true));
    }

    private void A() {
        if (this.h == null) {
            return;
        }
        CenterInside centerInside = new CenterInside();
        Glide.with(getContext().getApplicationContext()).load(Integer.valueOf(R$mipmap.libui_audio_playing_2)).optionalTransform(centerInside).optionalTransform(WebpDrawable.class, new WebpDrawableTransformation(centerInside)).into(this.h.g);
        this.h.h.setImageResource(R$mipmap.ic_audio_ctl_play);
    }

    private void o() {
        if (this.h == null) {
            return;
        }
        AudioPlayer.a aVar = AudioPlayer.i;
        if (aVar.a().J()) {
            aVar.a().T();
            this.h.h.setImageResource(R$mipmap.ic_audio_ctl_pause);
            return;
        }
        AudioBean m = com.transsion.audio.view.d.k().m();
        if (m.isChangeToLocalPath()) {
            m.setChangeToLocalPath(false);
            aVar.a().L(m);
        } else {
            aVar.a().K();
        }
        this.h.h.setImageResource(R$mipmap.ic_audio_ctl_play);
    }

    private int p() {
        return (int) TypedValue.applyDimension(1, 80.0f, Resources.getSystem().getDisplayMetrics());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams q(boolean z) {
        FrameLayout.LayoutParams layoutParams = z ? new FrameLayout.LayoutParams(-1, -2) : new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 8388691;
        layoutParams.setMargins(0, layoutParams.topMargin, layoutParams.rightMargin, p());
        return layoutParams;
    }

    private void r() {
        HistoryListManager.e.b().r();
    }

    private void s() {
        ki.d dVar = this.h;
        if (dVar != null) {
            dVar.h.setOnClickListener(this);
            this.h.f.setOnClickListener(this);
            this.h.e.setOnClickListener(this);
            this.h.i.setOnClickListener(this);
            this.h.c.setOnClickListener(this);
        }
        p.a.a(Utils.a()).g(this.o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(List list) {
        if (list.isEmpty()) {
            return;
        }
        this.i = list;
        this.j = 0;
        this.h.f.setImageResource(list.size() + (-1) > this.j ? R$mipmap.ic_audio_next_enable : R$mipmap.ic_audio_next_disable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(DownloadListBean downloadListBean) {
        if (downloadListBean == null || downloadListBean.getItems() == null || downloadListBean.getItems().size() <= 0) {
            return;
        }
        this.n = downloadListBean;
    }

    private void v() {
        ki.d dVar = this.h;
        if (dVar == null) {
            return;
        }
        dVar.h.setImageResource(R$mipmap.ic_audio_ctl_pause);
        this.h.g.setImageResource(R$mipmap.ic_audio_right);
    }

    private void w() {
        DownloadListBean downloadListBean;
        AudioPlayer.i.a().T();
        AudioBean m = com.transsion.audio.view.d.k().m();
        if (m == null || TextUtils.isEmpty(m.getSubjectId()) || (downloadListBean = this.n) == null || downloadListBean.getItems().isEmpty()) {
            int size = this.i.size() - 1;
            int i = this.j;
            if (size > i) {
                List list = this.i;
                int i2 = i + 1;
                this.j = i2;
                AudioBean audioBean = (AudioBean) list.get(i2);
                if (audioBean != null) {
                    ((ep.a) TheRouter.d(ep.a.class, new Object[0])).d(audioBean, true);
                    return;
                }
                return;
            }
            return;
        }
        List items = this.n.getItems();
        int i3 = 0;
        while (true) {
            if (i3 >= items.size()) {
                i3 = -1;
                break;
            } else if (TextUtils.equals(m.getPostId(), ((DownloadItem) items.get(i3)).getPostId())) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 == -1 || i3 >= items.size() - 2) {
            return;
        }
        DownloadItem downloadItem = (DownloadItem) items.get(i3 + 1);
        String url = downloadItem.getUrl();
        String url2 = this.n.getCover().getUrl();
        if (TextUtils.isEmpty(url)) {
            url = BuildConfig.FLAVOR;
        }
        ((ep.a) TheRouter.d(ep.a.class, new Object[0])).d(new AudioBean(url, url2, 0L, downloadItem.getSize(), downloadItem.getUrl(), downloadItem.getName(), BuildConfig.FLAVOR, 0, 0L, 0L, BuildConfig.FLAVOR, BuildConfig.FLAVOR, downloadItem.getResourceId(), downloadItem.getPostId(), this.n.getSubjectId(), this.n.getGroupId(), 0, BuildConfig.FLAVOR, downloadItem.getSe(), downloadItem.getEp()), true);
    }

    private void x() {
        f fVar = this.k;
        if (fVar != null) {
            fVar.a(this);
        }
        AudioPlayer.i.a().q();
        p.a.a(Utils.a()).k(this.o);
    }

    private void y(boolean z) {
        String str;
        AudioBean m = com.transsion.audio.view.d.k().m();
        if (m == null || this.h == null) {
            return;
        }
        try {
            String title = m.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = m.getDesc();
            }
            this.h.k.setText(title);
            Long readProcess = m.getReadProcess();
            Long duration = m.getDuration();
            if (readProcess != null && duration != null) {
                if (z) {
                    str = "00:00/00:00";
                } else {
                    str = mi.a.a(readProcess.longValue()) + "/" + mi.a.a(duration.longValue());
                }
                this.h.l.setText(str);
            }
        } catch (Exception unused) {
        }
    }

    private void z() {
        f fVar = this.k;
        if (fVar != null) {
            fVar.b(this);
        }
    }

    @Override // com.transsion.audio.view.FloatingMagnetView
    public void attach(Context context) {
        if (this.h == null) {
            return;
        }
        HistoryListManager.a aVar = HistoryListManager.e;
        aVar.b().p().j((u) context, new c0() { // from class: com.transsion.audio.view.a
            public final void onChanged(Object obj) {
                EnFloatingView.this.t((List) obj);
            }
        });
        aVar.b().v().j(getContext(), new c0() { // from class: com.transsion.audio.view.b
            public final void onChanged(Object obj) {
                EnFloatingView.this.u((DownloadListBean) obj);
            }
        });
        aVar.b().r();
    }

    @Override // com.transsion.audio.view.FloatingMagnetView
    public void expanded() {
        ki.d dVar = this.h;
        if (dVar == null) {
            return;
        }
        dVar.c.setVisibility(8);
        this.h.b.setVisibility(0);
        setLayoutParams(q(true));
    }

    public void expandedAnimation() {
        if (this.h == null || this.m.booleanValue()) {
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setAnimationListener(new b());
        this.h.c.setAnimation(alphaAnimation);
        TranslateAnimation translateAnimation = new TranslateAnimation(-h.a.e(getContext()), 0.0f, 0.0f, 0.0f);
        translateAnimation.setAnimationListener(new c());
        translateAnimation.setDuration(300L);
        this.h.b.startAnimation(translateAnimation);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.startNow();
    }

    @Override // com.transsion.audio.view.FloatingMagnetView
    public boolean isPackUp() {
        ki.d dVar = this.h;
        return dVar != null && dVar.b.getVisibility() == 8;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R$id.iv_play) {
            o();
            return;
        }
        if (view.getId() == R$id.iv_next) {
            w();
            return;
        }
        if (view.getId() == R$id.iv_history) {
            z();
        } else if (view.getId() == R$id.iv_remove) {
            x();
        } else if (view.getId() == R$id.clPackUp) {
            expandedAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.transsion.audio.view.FloatingMagnetView
    public void onProgress(int i) {
        ki.d dVar = this.h;
        if (dVar == null) {
            return;
        }
        dVar.j.setProgress(i);
        y(false);
    }

    @Override // com.transsion.audio.view.FloatingMagnetView
    public void onSlideTheLeft() {
        packUpAnimation();
    }

    @Override // com.transsion.audio.view.FloatingMagnetView
    public void onStateChanged(int i) {
        if (i == 3) {
            A();
            return;
        }
        if (i == 4 || i == 5) {
            v();
        } else {
            if (i != 6) {
                return;
            }
            v();
            w();
        }
    }

    @Override // com.transsion.audio.view.FloatingMagnetView
    public void onViewClick() {
        AudioBean m;
        Activity o = k.a.o();
        if (o == null || o.getClass().getSimpleName().contains("PostDetailActivity") || (m = com.transsion.audio.view.d.k().m()) == null) {
            return;
        }
        if (TextUtils.isEmpty(m.getPostId())) {
            fh.b.a.e("This page is unavailable");
        } else {
            TheRouter.c("/post/detail").K("page_from", "audio_list").K("id", m.getPostId()).K("media_type", MediaType.AUDIO.getValue()).z("from_comment", false).r(getContext());
        }
    }

    @Override // com.transsion.audio.view.FloatingMagnetView
    public void packUp() {
        ki.d dVar = this.h;
        if (dVar == null) {
            return;
        }
        dVar.c.setVisibility(0);
        this.h.b.setVisibility(8);
        setLayoutParams(q(false));
    }

    @Override // com.transsion.audio.view.FloatingMagnetView
    public void packUpAnimation() {
        ki.d dVar = this.h;
        if (dVar == null || dVar.b.getVisibility() == 8 || this.m.booleanValue() || com.transsion.audio.view.d.k().o().booleanValue()) {
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setAnimationListener(new d());
        this.h.c.setAnimation(alphaAnimation);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, -h.a.e(getContext()), 0.0f, 0.0f);
        translateAnimation.setAnimationListener(new e());
        translateAnimation.setDuration(300L);
        this.h.b.startAnimation(translateAnimation);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.startNow();
    }

    @Override // com.transsion.audio.view.FloatingMagnetView
    public void prepare() {
        AudioBean m = com.transsion.audio.view.d.k().m();
        if (m == null || this.h == null) {
            return;
        }
        this.l = m.getCover();
        Long readProcess = m.getReadProcess();
        Long duration = m.getDuration();
        if (readProcess == null || duration == null) {
            return;
        }
        if (duration.longValue() <= 0) {
            duration = 1L;
        }
        this.h.j.setProgress(l.a((readProcess.longValue() / duration.longValue()) * 100));
        this.h.f.setImageResource(this.i.size() - 1 > this.j ? R$mipmap.ic_audio_next_enable : R$mipmap.ic_audio_next_disable);
        y(true);
    }

    @Override // com.transsion.audio.view.FloatingMagnetView
    public void setOnOptionListener(f fVar) {
        this.k = fVar;
    }
}
