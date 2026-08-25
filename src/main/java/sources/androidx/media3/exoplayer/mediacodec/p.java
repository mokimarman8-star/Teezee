package androidx.media3.exoplayer.mediacodec;

import android.media.LoudnessCodecController;
import android.media.MediaCodec;
import android.os.Bundle;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    private final HashSet f10914a;

    /* renamed from: b, reason: collision with root package name */
    private final b f10915b;

    /* renamed from: c, reason: collision with root package name */
    private LoudnessCodecController f10916c;

    class a implements LoudnessCodecController.OnLoudnessCodecUpdateListener {
        a() {
        }

        public Bundle onLoudnessCodecUpdate(MediaCodec mediaCodec, Bundle bundle) {
            return p.this.f10915b.a(bundle);
        }
    }

    public interface b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f10918a = new b() { // from class: androidx.media3.exoplayer.mediacodec.q
            @Override // androidx.media3.exoplayer.mediacodec.p.b
            public final Bundle a(Bundle bundle) {
                return r.a(bundle);
            }
        };

        Bundle a(Bundle bundle);
    }

    public p() {
        this(b.f10918a);
    }

    public p(b bVar) {
        this.f10914a = new HashSet();
        this.f10915b = bVar;
    }

    public void b(MediaCodec mediaCodec) {
        boolean addMediaCodec;
        LoudnessCodecController loudnessCodecController = this.f10916c;
        if (loudnessCodecController != null) {
            addMediaCodec = loudnessCodecController.addMediaCodec(mediaCodec);
            if (!addMediaCodec) {
                return;
            }
        }
        androidx.media3.common.util.a.g(this.f10914a.add(mediaCodec));
    }

    public void c() {
        this.f10914a.clear();
        LoudnessCodecController loudnessCodecController = this.f10916c;
        if (loudnessCodecController != null) {
            loudnessCodecController.close();
        }
    }

    public void d(MediaCodec mediaCodec) {
        LoudnessCodecController loudnessCodecController;
        if (!this.f10914a.remove(mediaCodec) || (loudnessCodecController = this.f10916c) == null) {
            return;
        }
        loudnessCodecController.removeMediaCodec(mediaCodec);
    }

    public void e(int i5) {
        LoudnessCodecController create;
        boolean addMediaCodec;
        LoudnessCodecController loudnessCodecController = this.f10916c;
        if (loudnessCodecController != null) {
            loudnessCodecController.close();
            this.f10916c = null;
        }
        create = LoudnessCodecController.create(i5, MoreExecutors.a(), new a());
        this.f10916c = create;
        Iterator it = this.f10914a.iterator();
        while (it.hasNext()) {
            addMediaCodec = create.addMediaCodec((MediaCodec) it.next());
            if (!addMediaCodec) {
                it.remove();
            }
        }
    }
}
