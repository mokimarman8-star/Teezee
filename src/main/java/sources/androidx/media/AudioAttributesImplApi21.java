package androidx.media;

import android.media.AudioAttributes;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* renamed from: a, reason: collision with root package name */
    public AudioAttributes f8403a;

    /* renamed from: b, reason: collision with root package name */
    public int f8404b;

    public AudioAttributesImplApi21() {
        this.f8404b = -1;
    }

    AudioAttributesImplApi21(AudioAttributes audioAttributes) {
        this(audioAttributes, -1);
    }

    AudioAttributesImplApi21(AudioAttributes audioAttributes, int i5) {
        this.f8403a = audioAttributes;
        this.f8404b = i5;
    }

    public boolean equals(Object obj) {
        if (obj instanceof AudioAttributesImplApi21) {
            return this.f8403a.equals(((AudioAttributesImplApi21) obj).f8403a);
        }
        return false;
    }

    public int hashCode() {
        return this.f8403a.hashCode();
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f8403a;
    }
}
