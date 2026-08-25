package com.mbridge.msdk.mbsignalcommon.mraid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.lang.ref.WeakReference;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class d {
    public static double f = -1.0d;
    private Context a;
    private AudioManager b;
    private boolean c = false;
    private b d;
    private a e;

    private static class a extends BroadcastReceiver {
        private WeakReference<d> a;

        public a(d dVar) {
            this.a = new WeakReference<>(dVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            d dVar;
            b b;
            if (!"android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) || intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) != 3 || (dVar = this.a.get()) == null || (b = dVar.b()) == null) {
                return;
            }
            double a = dVar.a();
            if (a >= 0.0d) {
                b.a(a);
            }
        }
    }

    public interface b {
        void a(double d);
    }

    public d(Context context) {
        this.a = context;
        this.b = (AudioManager) context.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
    }

    public double a() {
        AudioManager audioManager = this.b;
        double streamVolume = ((this.b != null ? r3.getStreamVolume(3) : -1) * 100.0d) / (audioManager != null ? audioManager.getStreamMaxVolume(3) : -1);
        f = streamVolume;
        return streamVolume;
    }

    public void a(b bVar) {
        this.d = bVar;
    }

    public b b() {
        return this.d;
    }

    public void c() {
        if (this.a != null) {
            this.e = new a(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            this.a.registerReceiver(this.e, intentFilter);
            this.c = true;
        }
    }

    public void d() {
        Context context;
        if (!this.c || (context = this.a) == null) {
            return;
        }
        try {
            context.unregisterReceiver(this.e);
            this.d = null;
            this.c = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
