package io.github.anilbeesetti.nextlib.media3ext.ffdecoder;

import androidx.media3.common.u;
import androidx.media3.common.util.q;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class FfmpegLibrary {
    private static final q a;
    private static String b;
    private static int c;

    class a extends q {
        a(String... strArr) {
            super(strArr);
        }

        protected void b(String str) {
            System.loadLibrary(str);
        }
    }

    static {
        u.a("media3.decoder.ffmpeg");
        a = new a("media3ext");
        c = -1;
    }

    static String a(String str) {
        str.hashCode();
        switch (str) {
            case "audio/eac3-joc":
            case "audio/eac3":
                return "eac3";
            case "video/hevc":
                return "hevc";
            case "video/mpeg":
                return "mpegvideo";
            case "audio/amr-wb":
                return "amrwb";
            case "audio/vnd.dts":
            case "audio/vnd.dts.hd":
                return "dca";
            case "audio/vorbis":
                return "vorbis";
            case "audio/mpeg-L1":
            case "audio/mpeg-L2":
            case "audio/mpeg":
                return "mp3";
            case "audio/mp4a-latm":
                return "aac";
            case "video/mpeg2":
                return "mpeg2video";
            case "audio/ac3":
                return "ac3";
            case "video/avc":
                return "h264";
            case "audio/3gpp":
                return "amrnb";
            case "audio/alac":
                return "alac";
            case "audio/flac":
                return "flac";
            case "audio/opus":
                return "opus";
            case "audio/true-hd":
                return "truehd";
            case "video/x-vnd.on2.vp8":
                return "libvpx";
            case "video/x-vnd.on2.vp9":
                return "libvpx-vp9";
            case "audio/g711-alaw":
                return "pcm_alaw";
            case "audio/g711-mlaw":
                return "pcm_mulaw";
            default:
                return null;
        }
    }

    public static int b() {
        if (!d()) {
            return -1;
        }
        if (c == -1) {
            c = ffmpegGetInputBufferPaddingSize();
        }
        return c;
    }

    public static String c() {
        if (!d()) {
            return null;
        }
        if (b == null) {
            b = ffmpegGetVersion();
        }
        return b;
    }

    public static boolean d() {
        return a.a();
    }

    public static boolean e(String str) {
        String a2;
        if (!d() || (a2 = a(str)) == null) {
            return false;
        }
        if (ffmpegHasDecoder(a2)) {
            return true;
        }
        androidx.media3.common.util.u.h("FfmpegLibrary", "No " + a2 + " decoder available. Check the FFmpeg build configuration.");
        return false;
    }

    private static native int ffmpegGetInputBufferPaddingSize();

    private static native String ffmpegGetVersion();

    private static native boolean ffmpegHasDecoder(String str);
}
