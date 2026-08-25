package androidx.media3.common.audio;

import androidx.media3.common.audio.AudioProcessor;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final ImmutableList f8497a;

    /* renamed from: b, reason: collision with root package name */
    private final List f8498b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private ByteBuffer[] f8499c = new ByteBuffer[0];

    /* renamed from: d, reason: collision with root package name */
    private AudioProcessor.a f8500d;

    /* renamed from: e, reason: collision with root package name */
    private AudioProcessor.a f8501e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f8502f;

    public a(ImmutableList immutableList) {
        this.f8497a = immutableList;
        AudioProcessor.a aVar = AudioProcessor.a.f8492e;
        this.f8500d = aVar;
        this.f8501e = aVar;
        this.f8502f = false;
    }

    private int c() {
        return this.f8499c.length - 1;
    }

    private void g(ByteBuffer byteBuffer) {
        boolean z5;
        for (boolean z6 = true; z6; z6 = z5) {
            z5 = false;
            int i5 = 0;
            while (i5 <= c()) {
                if (!this.f8499c[i5].hasRemaining()) {
                    AudioProcessor audioProcessor = (AudioProcessor) this.f8498b.get(i5);
                    if (!audioProcessor.isEnded()) {
                        ByteBuffer byteBuffer2 = i5 > 0 ? this.f8499c[i5 - 1] : byteBuffer.hasRemaining() ? byteBuffer : AudioProcessor.f8491a;
                        long remaining = byteBuffer2.remaining();
                        audioProcessor.queueInput(byteBuffer2);
                        this.f8499c[i5] = audioProcessor.getOutput();
                        z5 |= remaining - ((long) byteBuffer2.remaining()) > 0 || this.f8499c[i5].hasRemaining();
                    } else if (!this.f8499c[i5].hasRemaining() && i5 < c()) {
                        ((AudioProcessor) this.f8498b.get(i5 + 1)).queueEndOfStream();
                    }
                }
                i5++;
            }
        }
    }

    public AudioProcessor.a a(AudioProcessor.a aVar) {
        if (aVar.equals(AudioProcessor.a.f8492e)) {
            throw new AudioProcessor.UnhandledAudioFormatException(aVar);
        }
        for (int i5 = 0; i5 < this.f8497a.size(); i5++) {
            AudioProcessor audioProcessor = (AudioProcessor) this.f8497a.get(i5);
            AudioProcessor.a a5 = audioProcessor.a(aVar);
            if (audioProcessor.isActive()) {
                androidx.media3.common.util.a.g(!a5.equals(AudioProcessor.a.f8492e));
                aVar = a5;
            }
        }
        this.f8501e = aVar;
        return aVar;
    }

    public void b() {
        this.f8498b.clear();
        this.f8500d = this.f8501e;
        this.f8502f = false;
        for (int i5 = 0; i5 < this.f8497a.size(); i5++) {
            AudioProcessor audioProcessor = (AudioProcessor) this.f8497a.get(i5);
            audioProcessor.flush();
            if (audioProcessor.isActive()) {
                this.f8498b.add(audioProcessor);
            }
        }
        this.f8499c = new ByteBuffer[this.f8498b.size()];
        for (int i6 = 0; i6 <= c(); i6++) {
            this.f8499c[i6] = ((AudioProcessor) this.f8498b.get(i6)).getOutput();
        }
    }

    public ByteBuffer d() {
        if (!f()) {
            return AudioProcessor.f8491a;
        }
        ByteBuffer byteBuffer = this.f8499c[c()];
        if (byteBuffer.hasRemaining()) {
            return byteBuffer;
        }
        g(AudioProcessor.f8491a);
        return this.f8499c[c()];
    }

    public boolean e() {
        return this.f8502f && ((AudioProcessor) this.f8498b.get(c())).isEnded() && !this.f8499c[c()].hasRemaining();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f8497a.size() != aVar.f8497a.size()) {
            return false;
        }
        for (int i5 = 0; i5 < this.f8497a.size(); i5++) {
            if (this.f8497a.get(i5) != aVar.f8497a.get(i5)) {
                return false;
            }
        }
        return true;
    }

    public boolean f() {
        return !this.f8498b.isEmpty();
    }

    public void h() {
        if (!f() || this.f8502f) {
            return;
        }
        this.f8502f = true;
        ((AudioProcessor) this.f8498b.get(0)).queueEndOfStream();
    }

    public int hashCode() {
        return this.f8497a.hashCode();
    }

    public void i(ByteBuffer byteBuffer) {
        if (!f() || this.f8502f) {
            return;
        }
        g(byteBuffer);
    }

    public void j() {
        for (int i5 = 0; i5 < this.f8497a.size(); i5++) {
            AudioProcessor audioProcessor = (AudioProcessor) this.f8497a.get(i5);
            audioProcessor.flush();
            audioProcessor.reset();
        }
        this.f8499c = new ByteBuffer[0];
        AudioProcessor.a aVar = AudioProcessor.a.f8492e;
        this.f8500d = aVar;
        this.f8501e = aVar;
        this.f8502f = false;
    }
}
