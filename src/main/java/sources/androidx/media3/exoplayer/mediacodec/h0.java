package androidx.media3.exoplayer.mediacodec;

import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface h0 {

    /* renamed from: a, reason: collision with root package name */
    public static final h0 f10887a = new h0() { // from class: androidx.media3.exoplayer.mediacodec.e0
        @Override // androidx.media3.exoplayer.mediacodec.h0
        public final List a(String str, boolean z5, boolean z6) {
            return MediaCodecUtil.k(str, z5, z6);
        }
    };

    /* renamed from: b, reason: collision with root package name */
    public static final h0 f10888b = new h0() { // from class: androidx.media3.exoplayer.mediacodec.f0
        @Override // androidx.media3.exoplayer.mediacodec.h0
        public final List a(String str, boolean z5, boolean z6) {
            List o5;
            o5 = MediaCodecUtil.o(h0.f10887a.a(str, z5, z6));
            return o5;
        }
    };

    List a(String str, boolean z5, boolean z6);
}
