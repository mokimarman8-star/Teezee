package com.aliyun.player.nativeclass;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class TrackInfo {
    public static final int AUTO_SELECT_INDEX = -1;
    public int audioChannels;
    public String audioLang;
    public int audioSampleFormat;
    public int audioSampleRate;
    public String description;
    public int index;
    public String subtitleLang;
    public int videoBitrate;
    public int videoHeight;
    public int videoWidth;
    public String vodDefinition;
    public long vodFileSize;
    public String vodFormat;
    public String vodPlayUrl;
    public String vodWaterMarkPlayUrl;
    public Type mType = Type.TYPE_VOD;
    public VideoHDRType videoHDRType = VideoHDRType.VideoHDRType_SDR;

    public enum Type {
        TYPE_VIDEO,
        TYPE_AUDIO,
        TYPE_SUBTITLE,
        TYPE_VOD
    }

    public enum VideoHDRType {
        VideoHDRType_SDR,
        VideoHDRType_HDR10
    }

    private int nGetType() {
        return this.mType.ordinal();
    }

    private void setType(int i) {
        Type type = Type.TYPE_VIDEO;
        if (i == type.ordinal()) {
            this.mType = type;
            return;
        }
        Type type2 = Type.TYPE_AUDIO;
        if (i == type2.ordinal()) {
            this.mType = type2;
            return;
        }
        Type type3 = Type.TYPE_SUBTITLE;
        if (i == type3.ordinal()) {
            this.mType = type3;
            return;
        }
        Type type4 = Type.TYPE_VOD;
        if (i == type4.ordinal()) {
            this.mType = type4;
        }
    }

    public int getAudioChannels() {
        return this.audioChannels;
    }

    public String getAudioLang() {
        return this.audioLang;
    }

    public int getAudioSampleFormat() {
        return this.audioSampleFormat;
    }

    public int getAudioSampleRate() {
        return this.audioSampleRate;
    }

    public String getDescription() {
        return this.description;
    }

    public int getIndex() {
        return this.index;
    }

    public String getSubtitleLang() {
        return this.subtitleLang;
    }

    public Type getType() {
        return this.mType;
    }

    public int getVideoBitrate() {
        return this.videoBitrate;
    }

    public int getVideoHDRType() {
        return this.videoHDRType.ordinal();
    }

    public int getVideoHeight() {
        return this.videoHeight;
    }

    public int getVideoWidth() {
        return this.videoWidth;
    }

    public String getVodDefinition() {
        return this.vodDefinition;
    }

    public long getVodFileSize() {
        return this.vodFileSize;
    }

    public String getVodFormat() {
        return this.vodFormat;
    }

    public String getVodPlayUrl() {
        return this.vodPlayUrl;
    }

    public String getVodWaterMarkPlayUrl() {
        return this.vodWaterMarkPlayUrl;
    }

    public void setVideoHDRType(int i) {
        VideoHDRType videoHDRType = VideoHDRType.VideoHDRType_SDR;
        if (i == videoHDRType.ordinal()) {
            this.videoHDRType = videoHDRType;
            return;
        }
        VideoHDRType videoHDRType2 = VideoHDRType.VideoHDRType_HDR10;
        if (i == videoHDRType2.ordinal()) {
            this.videoHDRType = videoHDRType2;
        }
    }
}
