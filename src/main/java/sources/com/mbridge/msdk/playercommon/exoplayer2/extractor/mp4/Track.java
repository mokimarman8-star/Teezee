package com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class Track {
    public static final int TRANSFORMATION_CEA608_CDAT = 1;
    public static final int TRANSFORMATION_NONE = 0;
    public final long durationUs;

    @Nullable
    public final long[] editListDurations;

    @Nullable
    public final long[] editListMediaTimes;
    public final Format format;

    /* renamed from: id, reason: collision with root package name */
    public final int f8id;
    public final long movieTimescale;
    public final int nalUnitLengthFieldLength;

    @Nullable
    private final TrackEncryptionBox[] sampleDescriptionEncryptionBoxes;
    public final int sampleTransformation;
    public final long timescale;
    public final int type;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Transformation {
    }

    public Track(int i, int i2, long j, long j2, long j3, Format format, int i3, @Nullable TrackEncryptionBox[] trackEncryptionBoxArr, int i4, @Nullable long[] jArr, @Nullable long[] jArr2) {
        this.f8id = i;
        this.type = i2;
        this.timescale = j;
        this.movieTimescale = j2;
        this.durationUs = j3;
        this.format = format;
        this.sampleTransformation = i3;
        this.sampleDescriptionEncryptionBoxes = trackEncryptionBoxArr;
        this.nalUnitLengthFieldLength = i4;
        this.editListDurations = jArr;
        this.editListMediaTimes = jArr2;
    }

    public TrackEncryptionBox getSampleDescriptionEncryptionBox(int i) {
        TrackEncryptionBox[] trackEncryptionBoxArr = this.sampleDescriptionEncryptionBoxes;
        if (trackEncryptionBoxArr == null) {
            return null;
        }
        return trackEncryptionBoxArr[i];
    }
}
