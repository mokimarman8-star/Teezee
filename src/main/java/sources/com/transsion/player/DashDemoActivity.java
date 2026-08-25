package com.transsion.player;

import android.os.Bundle;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.common.collect.r4;
import com.transsion.gslb.BuildConfig;
import com.transsion.player.DashDemoActivity;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.e;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import qn.b;
import qn.c;
import qn.d;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R$\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u001a\u0010+\u001a\u00020&8\u0006X\u0086D¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lcom/transsion/player/DashDemoActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/transsion/player/orplayer/e;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", BuildConfig.FLAVOR, "onCreate", "(Landroid/os/Bundle;)V", "Lqn/c;", "tracks", "onTracksChange", "(Lqn/c;)V", BuildConfig.FLAVOR, "width", "height", "onVideoSizeChanged", "(II)V", "Landroid/view/TextureView;", "a", "Landroid/view/TextureView;", "textureView", "Lin/e;", "b", "Lin/e;", "getPalyer", "()Lin/e;", "setPalyer", "(Lin/e;)V", "palyer", BuildConfig.FLAVOR, "c", "F", "speed", "d", "I", "trackIndex", BuildConfig.FLAVOR, "e", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "LibPlayer_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class DashDemoActivity extends AppCompatActivity implements e {

    /* renamed from: a, reason: from kotlin metadata */
    private TextureView textureView;

    /* renamed from: b, reason: from kotlin metadata */
    private in.e palyer;

    /* renamed from: c, reason: from kotlin metadata */
    private float speed;

    /* renamed from: d, reason: from kotlin metadata */
    private int trackIndex;

    /* renamed from: e, reason: from kotlin metadata */
    private final String TAG = "DashActivity";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(DashDemoActivity dashDemoActivity, TextView textView, View view) {
        Object obj;
        in.e eVar = dashDemoActivity.palyer;
        if (eVar != null) {
            Iterator it = eVar.getCurrentTracks().a().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (((d) obj).e() == 2) {
                        break;
                    }
                }
            }
            d dVar = (d) obj;
            if (dVar != null) {
                int d = dVar.d();
                int i = dashDemoActivity.trackIndex + 1;
                dashDemoActivity.trackIndex = i;
                int i2 = i % d;
                eVar.changeTrackSelection(dVar, i2);
                b bVar = dVar.b()[i2];
                textView.setText("codecs:" + bVar.b() + " peakBitrate:" + bVar.e() + "  " + bVar.f() + "*" + bVar.c());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(DashDemoActivity dashDemoActivity, View view) {
        in.e eVar = dashDemoActivity.palyer;
        if (eVar != null) {
            long currentPosition = eVar.getCurrentPosition();
            in.e eVar2 = dashDemoActivity.palyer;
            if (eVar2 != null) {
                eVar2.seekTo(currentPosition + 10000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(DashDemoActivity dashDemoActivity, View view) {
        float f = dashDemoActivity.speed + 0.25f;
        dashDemoActivity.speed = f;
        Log.e(dashDemoActivity.TAG, "speed:" + f);
        in.e eVar = dashDemoActivity.palyer;
        if (eVar != null) {
            eVar.setSpeed(dashDemoActivity.speed);
        }
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
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(savedInstanceState);
        setContentView(R$layout.activity_dash);
        this.textureView = (TextureView) findViewById(R$id.tv);
        String str = getFilesDir().getAbsolutePath() + "/test265/1.mpd";
        in.e eVar = new in.e(this, null, false, 6, null);
        TextureView textureView = this.textureView;
        if (textureView == null) {
            Intrinsics.y("textureView");
            textureView = null;
        }
        eVar.setTextureView(textureView);
        eVar.addPlayerListener(this);
        eVar.C(new gn.e("11", str, 0, null, null, 28, null));
        eVar.prepare();
        eVar.play();
        this.palyer = eVar;
        final TextView textView = (TextView) findViewById(R$id.tv_index);
        textView.setOnClickListener(new View.OnClickListener() { // from class: gn.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DashDemoActivity.R(DashDemoActivity.this, textView, view);
            }
        });
        findViewById(R$id.tv_seek).setOnClickListener(new View.OnClickListener() { // from class: gn.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DashDemoActivity.S(DashDemoActivity.this, view);
            }
        });
        findViewById(R$id.tv_speed).setOnClickListener(new View.OnClickListener() { // from class: gn.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DashDemoActivity.U(DashDemoActivity.this, view);
            }
        });
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

    @Override // com.transsion.player.orplayer.e
    public void onPlayError(PlayError playError, gn.e eVar) {
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
    }

    @Override // com.transsion.player.orplayer.e
    public void onRenderFirstFrame() {
        e.a.A(this);
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
    public void onTracksChange(c tracks) {
        Intrinsics.h(tracks, "tracks");
        Log.e(this.TAG, "onTracksChanged  tracks:" + tracks);
        r4 it = tracks.a().iterator();
        Intrinsics.g(it, "iterator(...)");
        while (it.hasNext()) {
            d dVar = (d) it.next();
            int e = dVar.e();
            boolean a = dVar.a();
            for (b bVar : dVar.b()) {
                Log.e(this.TAG, "onTracksChanged  trackInGroupIsSupported:" + a + " \ntrackFormat:" + bVar + " \n");
            }
            Log.e(this.TAG, "onTracksChanged  trackType:" + e + " \ntrackInGroupIsSupported:" + a + " \n");
        }
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
    public void onVideoSizeChanged(int width, int height) {
        Log.e(this.TAG, "onVideoSizeChanged  width:" + width + " height:" + height);
        if (width > 0 || height > 0) {
            TextureView textureView = this.textureView;
            TextureView textureView2 = null;
            if (textureView == null) {
                Intrinsics.y("textureView");
                textureView = null;
            }
            ConstraintLayout.b layoutParams = textureView.getLayoutParams();
            if (layoutParams != null) {
                ((ViewGroup.MarginLayoutParams) layoutParams).width = 720;
            }
            if (layoutParams != null) {
                ((ViewGroup.MarginLayoutParams) layoutParams).height = (height * 720) / width;
            }
            TextureView textureView3 = this.textureView;
            if (textureView3 == null) {
                Intrinsics.y("textureView");
            } else {
                textureView2 = textureView3;
            }
            textureView2.setLayoutParams(layoutParams);
        }
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
