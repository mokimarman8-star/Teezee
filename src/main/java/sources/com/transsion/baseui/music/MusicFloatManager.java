package com.transsion.baseui.music;

import android.R;
import android.app.Activity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.g0;
import com.transsion.baseui.activity.BaseMusicFloatActivity;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import on.a0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class MusicFloatManager implements com.transsion.player.orplayer.e {
    public static final a h = new a(null);
    public static final int i = 8;
    private static final Lazy j = LazyKt.b(new Function0() { // from class: com.transsion.baseui.music.c
        public final Object invoke() {
            MusicFloatManager c;
            c = MusicFloatManager.c();
            return c;
        }
    });
    private MediaItem b;
    private String c;
    private com.transsion.player.orplayer.f e;
    private final Map g;
    private boolean a = true;
    private CopyOnWriteArrayList d = new CopyOnWriteArrayList();
    private List f = new ArrayList();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final MusicFloatManager a() {
            return (MusicFloatManager) MusicFloatManager.j.getValue();
        }

        public final MusicFloatManager b() {
            return a();
        }
    }

    public MusicFloatManager() {
        g0.i.a().getLifecycle().a(com.transsion.baseui.music.a.a);
        MusicReport.a.c();
        this.g = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MusicFloatManager c() {
        return new MusicFloatManager();
    }

    private final void j(long j2, long j3, int i2, int i3, gn.e eVar) {
        MediaItem h2;
        MediaItem h3;
        MediaItem h4;
        MediaItem h5;
        MediaItem h6;
        MediaItem h7;
        MediaItem h8;
        MediaItem h9;
        MediaItem h10;
        MediaItem h11;
        MediaItem h12;
        MediaItem h13;
        MediaItem h14;
        boolean z = false;
        if ((eVar == null || (h14 = eVar.h()) == null) ? false : Intrinsics.c(h14.isMusic(), Boolean.FALSE)) {
            return;
        }
        n nVar = (n) this.g.get((eVar == null || (h13 = eVar.h()) == null) ? null : h13.getMediaId());
        if (!TextUtils.equals((eVar == null || (h12 = eVar.h()) == null) ? null : h12.getPageName(), "music_float")) {
            if (!((eVar == null || (h11 = eVar.h()) == null) ? false : Intrinsics.c(h11.getInBackground(), Boolean.TRUE))) {
                if (nVar != null) {
                    MusicReport.a.d(nVar);
                    this.g.put((eVar == null || (h10 = eVar.h()) == null) ? null : h10.getMediaId(), null);
                    return;
                }
                return;
            }
        }
        if (nVar == null) {
            nVar = new n((eVar == null || (h9 = eVar.h()) == null) ? null : h9.getMediaId(), (eVar == null || (h8 = eVar.h()) == null) ? null : h8.getOps(), (eVar == null || (h7 = eVar.h()) == null) ? null : h7.getSubjectId(), 0L, 0L, j3, 0L, 0L, i2, i3);
        }
        long g = j2 - nVar.g();
        if (!(1 <= g && g < 2000)) {
            g = 0;
        }
        if (eVar != null && (h6 = eVar.h()) != null) {
            z = Intrinsics.c(h6.getInBackground(), Boolean.TRUE);
        }
        if (z) {
            nVar.m(nVar.c() + g);
        } else {
            nVar.l(nVar.b() + g);
        }
        nVar.n((eVar == null || (h5 = eVar.h()) == null) ? null : h5.getOps());
        nVar.r(j3);
        nVar.s(i2);
        nVar.k(i3);
        nVar.q((eVar == null || (h4 = eVar.h()) == null) ? null : h4.getSubjectId());
        nVar.p(j2);
        nVar.o(nVar.f() + g);
        this.g.put((eVar == null || (h3 = eVar.h()) == null) ? null : h3.getMediaId(), nVar);
        if (nVar.f() > 10000) {
            MusicReport.a.d(nVar);
            this.g.put((eVar == null || (h2 = eVar.h()) == null) ? null : h2.getMediaId(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m(MusicFloatManager musicFloatManager, Ref.ObjectRef objectRef, View view, MotionEvent motionEvent) {
        View view2 = (View) objectRef.element;
        Intrinsics.e(motionEvent);
        if (!musicFloatManager.y(view2, motionEvent)) {
            ((MusicFloatView) objectRef.element).setExpand(false);
        }
        return false;
    }

    private final FrameLayout o(AppCompatActivity appCompatActivity) {
        Object obj;
        Window window;
        View decorView;
        try {
            Result.Companion companion = Result.Companion;
            FrameLayout frameLayout = (appCompatActivity == null || (window = appCompatActivity.getWindow()) == null || (decorView = window.getDecorView()) == null) ? null : (FrameLayout) decorView.findViewById(R.id.content);
            if (!(frameLayout instanceof FrameLayout)) {
                frameLayout = null;
            }
            obj = Result.constructor-impl(frameLayout);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        return (FrameLayout) (Result.exceptionOrNull-impl(obj) == null ? obj : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String p() {
        String simpleName = MusicFloatManager.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final boolean y(View view, MotionEvent motionEvent) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (rawX <= iArr[0] || rawX >= r3 + view.getWidth()) {
            return false;
        }
        int i2 = iArr[1];
        return rawY > ((float) i2) && rawY < ((float) (i2 + view.getHeight()));
    }

    public final void A(boolean z) {
        this.a = z;
    }

    public final void B(MediaItem mediaItem) {
        com.transsion.player.mediasession.i.a.a(p() + " --> setMediaItem() --> musicFloatBean = " + mediaItem);
        if (!(mediaItem != null ? Intrinsics.c(mediaItem.isMusic(), Boolean.TRUE) : false)) {
            mediaItem = null;
        }
        this.b = mediaItem;
    }

    public final void C(String str) {
        this.c = str;
    }

    @Override // com.transsion.player.orplayer.e
    public void canNonSubscriberPlay(boolean z, int i2, int i3, qn.d dVar) {
        e.a.a(this, z, i2, i3, dVar);
    }

    public final void i(Activity activity, MotionEvent motionEvent) {
        Intrinsics.h(activity, "activity");
        Intrinsics.h(motionEvent, "event");
        MusicFloatView musicFloatView = (MusicFloatView) activity.findViewById(activity.hashCode());
        if (musicFloatView != null && musicFloatView.getVisibility() == 0 && this.a && !y(musicFloatView, motionEvent)) {
            musicFloatView.setExpand(false);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void initPlayer() {
        e.a.b(this);
    }

    public final void k(com.transsion.player.orplayer.e eVar) {
        Intrinsics.h(eVar, "listener");
        if (this.d.contains(eVar)) {
            return;
        }
        this.d.add(eVar);
    }

    public final void l(AppCompatActivity appCompatActivity, int i2) {
        if (appCompatActivity == null) {
            com.transsion.player.mediasession.i.a.a(p() + " --> attach() --> activity == null");
            return;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = appCompatActivity.findViewById(appCompatActivity.hashCode());
        if (q() == null) {
            MusicFloatView musicFloatView = (MusicFloatView) objectRef.element;
            if (musicFloatView != null) {
                musicFloatView.setVisibility(8);
                return;
            }
            return;
        }
        MusicFloatView musicFloatView2 = (MusicFloatView) objectRef.element;
        if (musicFloatView2 != null) {
            musicFloatView2.setVisibility(0);
        }
        if (objectRef.element == null) {
            MusicFloatView musicFloatView3 = new MusicFloatView(appCompatActivity);
            objectRef.element = musicFloatView3;
            musicFloatView3.setId(appCompatActivity.hashCode());
            FrameLayout o = o(appCompatActivity);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (o != null) {
                o.setOnTouchListener(new View.OnTouchListener() { // from class: com.transsion.baseui.music.b
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        boolean m;
                        m = MusicFloatManager.m(MusicFloatManager.this, objectRef, view, motionEvent);
                        return m;
                    }
                });
            }
            layoutParams.gravity = 8388691;
            layoutParams.bottomMargin = lj.a.b(124);
            if (o != null) {
                o.addView((View) objectRef.element, layoutParams);
            }
        }
        ((MusicFloatView) objectRef.element).refresh();
    }

    public final void n() {
        com.transsion.player.orplayer.f s = s();
        if (s != null) {
            s.stop();
        }
        if (s != null) {
            s.release();
        }
        h.b().B(null);
        com.transsion.player.mediasession.h.a.p();
    }

    @Override // com.transsion.player.orplayer.e
    public void onAliyunDecodeErrorChangeSoftwareDecoder(gn.e eVar) {
        e.a.c(this, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onBufferedPosition(long j2, gn.e eVar) {
        e.a.d(this, j2, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onCompletion(gn.e eVar) {
        e.a.e(this, eVar);
        MediaItem mediaItem = this.b;
        if (mediaItem != null) {
            mediaItem.setState(MediaItem.MUSIC_FLOAT_STATE_COMPLETION);
        }
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onCompletion(eVar);
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
    public void onLoadingProgress(int i2, float f, gn.e eVar) {
        e.a.m(this, i2, f, eVar);
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
        MediaItem h2;
        Intrinsics.h(playError, "errorInfo");
        e.a.q(this, playError, eVar);
        com.transsion.player.mediasession.i.a.a(p() + " --> onPlayError() --> subjectId = " + ((eVar == null || (h2 = eVar.h()) == null) ? null : h2.getSubjectId()));
        MediaItem mediaItem = this.b;
        if (mediaItem != null) {
            mediaItem.setState(MediaItem.MUSIC_FLOAT_STATE_ERROR);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerRelease(gn.e eVar) {
        e.a.t(this, eVar);
        kotlinx.coroutines.i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new MusicFloatManager$onPlayerRelease$1(this, eVar, null), 3, (Object) null);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerReset() {
        e.a.v(this);
        com.transsion.player.mediasession.i.a.a(p() + " --> onPlayerReset()");
    }

    @Override // com.transsion.player.orplayer.e
    public void onPrepare(gn.e eVar) {
        e.a.w(this, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onProgress(long j2, gn.e eVar) {
        e.a.y(this, j2, eVar);
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onProgress(j2, eVar);
        }
        com.transsion.player.orplayer.f s = s();
        long duration = s != null ? s.getDuration() : 0L;
        com.transsion.player.orplayer.f s2 = s();
        Pair bitrate = s2 != null ? s2.getBitrate() : null;
        j(j2, duration, bitrate != null ? ((Number) bitrate.getFirst()).intValue() : 0, bitrate != null ? ((Number) bitrate.getSecond()).intValue() : 0, eVar);
        MediaItem q = q();
        if (q != null) {
            q.setPosition(Long.valueOf(j2));
        }
        MediaItem q2 = q();
        if (q2 != null) {
            q2.setState(MediaItem.MUSIC_FLOAT_STATE_PLAY);
        }
        MediaItem q3 = q();
        if (q3 != null) {
            q3.setDuration(Long.valueOf(duration));
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onRenderFirstFrame() {
        e.a.A(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onSetDataSource() {
        e.a.B(this);
        com.transsion.player.mediasession.i.a.a(p() + " --> onSetDataSource()");
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksAudioBitrateChange(int i2) {
        e.a.C(this, i2);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksChange(qn.c cVar) {
        e.a.D(this, cVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksVideoBitrateChange(int i2) {
        e.a.E(this, i2);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoPause(gn.e eVar) {
        MediaItem h2;
        e.a.F(this, eVar);
        com.transsion.player.mediasession.i.a.a(p() + " --> onVideoPause() --> subjectId = " + ((eVar == null || (h2 = eVar.h()) == null) ? null : h2.getSubjectId()));
        MediaItem mediaItem = this.b;
        if (mediaItem != null) {
            mediaItem.setState(MediaItem.MUSIC_FLOAT_STATE_PAUSE);
        }
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onVideoPause(eVar);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoSizeChanged(int i2, int i3) {
        e.a.H(this, i2, i3);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoStart(gn.e eVar) {
        MediaItem h2;
        e.a.I(this, eVar);
        com.transsion.player.mediasession.i.a.a(p() + " --> onVideoStart() --> subjectId = " + ((eVar == null || (h2 = eVar.h()) == null) ? null : h2.getSubjectId()));
        MediaItem mediaItem = this.b;
        if (mediaItem != null) {
            mediaItem.setState(MediaItem.MUSIC_FLOAT_STATE_PLAY);
        }
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onVideoStart(eVar);
        }
    }

    public final MediaItem q() {
        return this.b;
    }

    public final String r() {
        return this.c;
    }

    public final com.transsion.player.orplayer.f s() {
        if (this.e == null) {
            a0 a0Var = new a0();
            a0Var.addPlayerListener(this);
            this.e = a0Var;
        }
        return this.e;
    }

    @Override // com.transsion.player.orplayer.e
    public void setOnSeekCompleteListener() {
        e.a.K(this);
    }

    public final String t(String str) {
        return str + "_" + o.a.a(6);
    }

    public final void u() {
        h.b().B(null);
        com.transsion.player.mediasession.h.a.p();
        List<AppCompatActivity> a2 = com.blankj.utilcode.util.a.a();
        if (a2 != null) {
            for (AppCompatActivity appCompatActivity : a2) {
                BaseMusicFloatActivity baseMusicFloatActivity = appCompatActivity instanceof BaseMusicFloatActivity ? (BaseMusicFloatActivity) appCompatActivity : null;
                if (baseMusicFloatActivity != null) {
                    MusicFloatView musicFloatView = (MusicFloatView) baseMusicFloatActivity.findViewById(baseMusicFloatActivity.hashCode());
                    if (musicFloatView != null) {
                        musicFloatView.setVisibility(8);
                    }
                    baseMusicFloatActivity.onCloseMusicFloating();
                }
            }
        }
    }

    public final boolean v() {
        return this.a;
    }

    public final List w() {
        return this.f;
    }

    public final boolean x(AppCompatActivity appCompatActivity) {
        MusicFloatView musicFloatView = appCompatActivity != null ? (MusicFloatView) appCompatActivity.findViewById(appCompatActivity.hashCode()) : null;
        return musicFloatView != null && musicFloatView.getVisibility() == 0;
    }

    public final void z(com.transsion.player.orplayer.e eVar) {
        Intrinsics.h(eVar, "listener");
        if (this.d.contains(eVar)) {
            this.d.remove(eVar);
        }
    }
}
