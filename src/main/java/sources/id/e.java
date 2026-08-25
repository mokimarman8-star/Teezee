package id;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.util.Log;
import com.google.zxing.client.android.R;
import java.io.IOException;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class e {
    private static final String d = "e";
    private final Context a;
    private boolean b = true;
    private boolean c = false;

    public e(Activity activity) {
        activity.setVolumeControlStream(3);
        this.a = activity.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(MediaPlayer mediaPlayer) {
        mediaPlayer.stop();
        mediaPlayer.reset();
        mediaPlayer.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean d(MediaPlayer mediaPlayer, int i, int i2) {
        Log.w(d, "Failed to beep " + i + ", " + i2);
        mediaPlayer.stop();
        mediaPlayer.reset();
        mediaPlayer.release();
        return true;
    }

    public MediaPlayer e() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setContentType(2).build());
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: id.c
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer2) {
                e.c(mediaPlayer2);
            }
        });
        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: id.d
            @Override // android.media.MediaPlayer.OnErrorListener
            public final boolean onError(MediaPlayer mediaPlayer2, int i, int i2) {
                boolean d2;
                d2 = e.d(mediaPlayer2, i, i2);
                return d2;
            }
        });
        try {
            AssetFileDescriptor openRawResourceFd = this.a.getResources().openRawResourceFd(R.raw.zxing_beep);
            try {
                mediaPlayer.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                openRawResourceFd.close();
                mediaPlayer.setVolume(0.1f, 0.1f);
                mediaPlayer.prepare();
                mediaPlayer.start();
                return mediaPlayer;
            } catch (Throwable th) {
                openRawResourceFd.close();
                throw th;
            }
        } catch (IOException e) {
            Log.w(d, e);
            mediaPlayer.reset();
            mediaPlayer.release();
            return null;
        }
    }

    public synchronized void f() {
        Vibrator vibrator;
        try {
            if (this.b) {
                e();
            }
            if (this.c && (vibrator = (Vibrator) this.a.getSystemService("vibrator")) != null) {
                vibrator.vibrate(200L);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void g(boolean z) {
        this.b = z;
    }
}
