package androidx.media3.common.audio;

import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Objects;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface AudioProcessor {

    /* renamed from: a, reason: collision with root package name */
    public static final ByteBuffer f8491a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    public static final class UnhandledAudioFormatException extends Exception {
        public final a inputAudioFormat;

        public UnhandledAudioFormatException(a aVar) {
            this("Unhandled input format:", aVar);
        }

        public UnhandledAudioFormatException(String str, a aVar) {
            super(str + " " + aVar);
            this.inputAudioFormat = aVar;
        }
    }

    public static final class a {

        /* renamed from: e, reason: collision with root package name */
        public static final a f8492e = new a(-1, -1, -1);

        /* renamed from: a, reason: collision with root package name */
        public final int f8493a;

        /* renamed from: b, reason: collision with root package name */
        public final int f8494b;

        /* renamed from: c, reason: collision with root package name */
        public final int f8495c;

        /* renamed from: d, reason: collision with root package name */
        public final int f8496d;

        public a(int i5, int i6, int i7) {
            this.f8493a = i5;
            this.f8494b = i6;
            this.f8495c = i7;
            this.f8496d = a1.G0(i7) ? a1.k0(i7, i6) : -1;
        }

        public a(r rVar) {
            this(rVar.F, rVar.E, rVar.G);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f8493a == aVar.f8493a && this.f8494b == aVar.f8494b && this.f8495c == aVar.f8495c;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.f8493a), Integer.valueOf(this.f8494b), Integer.valueOf(this.f8495c));
        }

        public String toString() {
            return "AudioFormat[sampleRate=" + this.f8493a + ", channelCount=" + this.f8494b + ", encoding=" + this.f8495c + ']';
        }
    }

    a a(a aVar);

    void flush();

    ByteBuffer getOutput();

    boolean isActive();

    boolean isEnded();

    void queueEndOfStream();

    void queueInput(ByteBuffer byteBuffer);

    void reset();
}
