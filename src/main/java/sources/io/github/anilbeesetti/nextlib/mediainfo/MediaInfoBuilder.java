package io.github.anilbeesetti.nextlib.mediainfo;

import androidx.annotation.Keep;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import okhttp3.HttpUrl;
import vx.a;
import vx.b;
import vx.c;
import vx.d;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0005\u0010\u0003J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0003¢\u0006\u0004\b\n\u0010\u000bJi\u0010\u0019\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\bH\u0003¢\u0006\u0004\b\u0019\u0010\u001aJe\u0010\u001f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006H\u0003¢\u0006\u0004\b\u001f\u0010 J9\u0010!\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\fH\u0003¢\u0006\u0004\b!\u0010\"J1\u0010%\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\bH\u0003¢\u0006\u0004\b%\u0010&J\u0018\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\fH\u0083 ¢\u0006\u0004\b(\u0010)J\u0018\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0006H\u0083 ¢\u0006\u0004\b+\u0010,R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00106\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00104R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020<0;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020@0;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010>R\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020C0;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010>¨\u0006F"}, d2 = {"Lio/github/anilbeesetti/nextlib/mediainfo/MediaInfoBuilder;", HttpUrl.FRAGMENT_ENCODE_SET, "<init>", "()V", HttpUrl.FRAGMENT_ENCODE_SET, "onError", HttpUrl.FRAGMENT_ENCODE_SET, "fileFormatName", HttpUrl.FRAGMENT_ENCODE_SET, "duration", "onMediaInfoFound", "(Ljava/lang/String;J)V", HttpUrl.FRAGMENT_ENCODE_SET, "index", "title", "codecName", "language", "disposition", "bitRate", HttpUrl.FRAGMENT_ENCODE_SET, "frameRate", "frameWidth", "frameHeight", "rotation", "frameLoaderContext", "onVideoStreamFound", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IJDIIIJ)V", "sampleFormat", "sampleRate", "channels", "channelLayout", "onAudioStreamFound", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;IILjava/lang/String;)V", "onSubtitleStreamFound", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "start", "end", "onChapterFound", "(ILjava/lang/String;JJ)V", "fileDescriptor", "nativeCreateFromFD", "(I)V", "filePath", "nativeCreateFromPath", "(Ljava/lang/String;)V", HttpUrl.FRAGMENT_ENCODE_SET, "a", "Z", "hasError", "b", "Ljava/lang/String;", "c", "Ljava/lang/Long;", "d", "frameLoaderContextHandle", "Lvx/d;", "e", "Lvx/d;", "videoStream", HttpUrl.FRAGMENT_ENCODE_SET, "Lvx/a;", "f", "Ljava/util/List;", "audioStreams", "Lvx/c;", "g", "subtitleStreams", "Lvx/b;", "h", "chapters", "mediainfo_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class MediaInfoBuilder {

    /* renamed from: a, reason: from kotlin metadata */
    private boolean hasError;

    /* renamed from: b, reason: from kotlin metadata */
    private String fileFormatName;

    /* renamed from: c, reason: from kotlin metadata */
    private Long duration;

    /* renamed from: d, reason: from kotlin metadata */
    private Long frameLoaderContextHandle;

    /* renamed from: e, reason: from kotlin metadata */
    private d videoStream;

    /* renamed from: f, reason: from kotlin metadata */
    private final List audioStreams = new ArrayList();

    /* renamed from: g, reason: from kotlin metadata */
    private final List subtitleStreams = new ArrayList();

    /* renamed from: h, reason: from kotlin metadata */
    private final List chapters = new ArrayList();

    public MediaInfoBuilder() {
        System.loadLibrary("mediainfo");
    }

    @Keep
    private final native void nativeCreateFromFD(int fileDescriptor);

    @Keep
    private final native void nativeCreateFromPath(String filePath);

    @Keep
    private final void onAudioStreamFound(int index, String title, String codecName, String language, int disposition, long bitRate, String sampleFormat, int sampleRate, int channels, String channelLayout) {
        this.audioStreams.add(new a(index, title, codecName, language, disposition, bitRate, sampleFormat, sampleRate, channels, channelLayout));
    }

    @Keep
    private final void onChapterFound(int index, String title, long start, long end) {
        this.chapters.add(new b(index, start, end, title));
    }

    @Keep
    private final void onError() {
        this.hasError = true;
    }

    @Keep
    private final void onMediaInfoFound(String fileFormatName, long duration) {
        this.fileFormatName = fileFormatName;
        this.duration = Long.valueOf(duration);
    }

    @Keep
    private final void onSubtitleStreamFound(int index, String title, String codecName, String language, int disposition) {
        this.subtitleStreams.add(new c(index, title, codecName, language, disposition));
    }

    @Keep
    private final void onVideoStreamFound(int index, String title, String codecName, String language, int disposition, long bitRate, double frameRate, int frameWidth, int frameHeight, int rotation, long frameLoaderContext) {
        if (this.videoStream == null) {
            this.videoStream = new d(index, title, codecName, language, disposition, bitRate, frameRate, frameWidth, frameHeight, rotation);
            if (frameLoaderContext != -1) {
                this.frameLoaderContextHandle = Long.valueOf(frameLoaderContext);
            }
        }
    }
}
