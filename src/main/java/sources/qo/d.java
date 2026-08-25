package qo;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.transsion.gslb.BuildConfig;
import java.io.IOException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d {
    public static final a e = new a(null);
    private MediaPlayer a;
    private Handler b;
    private String c = BuildConfig.FLAVOR;
    private boolean d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(d dVar, MediaPlayer mediaPlayer) {
        MediaPlayer mediaPlayer2 = dVar.a;
        if (mediaPlayer2 != null) {
            mediaPlayer2.start();
        }
    }

    public final boolean b() {
        try {
            MediaPlayer mediaPlayer = this.a;
            if (mediaPlayer != null) {
                return mediaPlayer.isPlaying();
            }
            return false;
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    public final void c() {
        try {
            this.d = true;
            MediaPlayer mediaPlayer = this.a;
            if (mediaPlayer != null) {
                mediaPlayer.pause();
            }
        } catch (Exception e2) {
            String message = e2.getMessage();
            if (message != null) {
                a.a.f(wf.a.a, "MediaPlayerHelper", message, false, 4, (Object) null);
            }
        }
    }

    public final void d(Context context, String str, boolean z, MediaPlayer.OnCompletionListener onCompletionListener) {
        MediaPlayer mediaPlayer;
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "path");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.d = false;
        if (this.a == null) {
            MediaPlayer mediaPlayer2 = new MediaPlayer();
            this.a = mediaPlayer2;
            mediaPlayer2.setLooping(z);
        }
        try {
            MediaPlayer mediaPlayer3 = this.a;
            if (mediaPlayer3 != null) {
                if (mediaPlayer3.isPlaying()) {
                    if (TextUtils.equals(this.c, str)) {
                        MediaPlayer mediaPlayer4 = this.a;
                        if (mediaPlayer4 != null) {
                            mediaPlayer4.pause();
                            return;
                        }
                        return;
                    }
                    MediaPlayer mediaPlayer5 = this.a;
                    if (mediaPlayer5 != null) {
                        mediaPlayer5.stop();
                    }
                    MediaPlayer mediaPlayer6 = this.a;
                    if (mediaPlayer6 != null) {
                        mediaPlayer6.reset();
                    }
                    MediaPlayer mediaPlayer7 = this.a;
                    if (mediaPlayer7 != null) {
                        mediaPlayer7.release();
                    }
                    this.a = null;
                    MediaPlayer mediaPlayer8 = new MediaPlayer();
                    this.a = mediaPlayer8;
                    mediaPlayer8.setLooping(true);
                }
            }
        } catch (IllegalStateException unused) {
            this.a = null;
            this.c = str;
            this.a = MediaPlayer.create(context, Uri.parse(str));
        }
        try {
            MediaPlayer mediaPlayer9 = this.a;
            if (mediaPlayer9 != null) {
                mediaPlayer9.reset();
            }
            this.c = str;
            MediaPlayer mediaPlayer10 = this.a;
            if (mediaPlayer10 != null) {
                mediaPlayer10.setDataSource(context, Uri.parse(str));
            }
            MediaPlayer mediaPlayer11 = this.a;
            if (mediaPlayer11 != null) {
                mediaPlayer11.prepareAsync();
            }
            MediaPlayer mediaPlayer12 = this.a;
            if (mediaPlayer12 != null) {
                mediaPlayer12.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: qo.c
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public final void onPrepared(MediaPlayer mediaPlayer13) {
                        d.e(d.this, mediaPlayer13);
                    }
                });
            }
            if (onCompletionListener == null || (mediaPlayer = this.a) == null) {
                return;
            }
            mediaPlayer.setOnCompletionListener(onCompletionListener);
        } catch (IOException e2) {
            String message = e2.getMessage();
            if (message != null) {
                a.a.f(wf.a.a, "MediaPlayerHelper", message, false, 4, (Object) null);
            }
        } catch (IllegalArgumentException e3) {
            String message2 = e3.getMessage();
            if (message2 != null) {
                a.a.f(wf.a.a, "MediaPlayerHelper", message2, false, 4, (Object) null);
            }
        } catch (IllegalStateException e4) {
            String message3 = e4.getMessage();
            if (message3 != null) {
                a.a.f(wf.a.a, "MediaPlayerHelper", message3, false, 4, (Object) null);
            }
        } catch (SecurityException e5) {
            String message4 = e5.getMessage();
            if (message4 != null) {
                a.a.f(wf.a.a, "MediaPlayerHelper", message4, false, 4, (Object) null);
            }
        }
    }

    public final void f() {
        try {
            MediaPlayer mediaPlayer = this.a;
            if (mediaPlayer != null) {
                Intrinsics.e(mediaPlayer);
                if (mediaPlayer.isPlaying()) {
                    MediaPlayer mediaPlayer2 = this.a;
                    Intrinsics.e(mediaPlayer2);
                    mediaPlayer2.stop();
                    MediaPlayer mediaPlayer3 = this.a;
                    Intrinsics.e(mediaPlayer3);
                    mediaPlayer3.release();
                    this.b = null;
                }
            }
        } catch (Exception unused) {
        }
    }
}
