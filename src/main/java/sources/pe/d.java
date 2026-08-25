package pe;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class d extends ContentObserver {
    private final Context a;
    private final AudioManager b;
    private final a c;
    private final c d;
    private float e;

    public d(Handler handler, Context context, a aVar, c cVar) {
        super(handler);
        this.a = context;
        this.b = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.c = aVar;
        this.d = cVar;
    }

    private float a() {
        return this.c.a(this.b.getStreamVolume(3), this.b.getStreamMaxVolume(3));
    }

    private boolean b(float f) {
        return f != this.e;
    }

    private void c() {
        this.d.a(this.e);
    }

    public void d() {
        this.e = a();
        c();
        this.a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public void e() {
        this.a.getContentResolver().unregisterContentObserver(this);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        super.onChange(z);
        float a = a();
        if (b(a)) {
            this.e = a;
            c();
        }
    }
}
