package com.cicada.player.utils.media;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.util.Range;
import com.cicada.player.utils.Logger;
import com.cloud.tmc.integration.athena.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class MediaCodecUtils {
    private static final String TAG = "MediaCodecUtils";
    private static List<MediaCodecInfo> allDecoders;

    public static synchronized List<MediaCodecInfo> getCodecInfos(String str, boolean z, MediaFormat mediaFormat) {
        ArrayList arrayList;
        String str2;
        boolean z2;
        synchronized (MediaCodecUtils.class) {
            try {
                if (allDecoders == null) {
                    allDecoders = getDeviceDecodecs();
                }
                arrayList = new ArrayList();
                for (MediaCodecInfo mediaCodecInfo : allDecoders) {
                    if (str.equals("audio/eac3")) {
                        str2 = getCodecMimeType(mediaCodecInfo, "audio/eac3-joc");
                        z2 = true;
                    } else {
                        str2 = null;
                        z2 = false;
                    }
                    if (str2 == null) {
                        str2 = getCodecMimeType(mediaCodecInfo, str);
                        z2 = false;
                    }
                    if (str2 != null) {
                        MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str2);
                        if (isSecureSupport(z, capabilitiesForType, str2) && isFormatSupport(mediaFormat, capabilitiesForType, str2)) {
                            if (z2) {
                                arrayList.add(0, mediaCodecInfo);
                            } else {
                                arrayList.add(mediaCodecInfo);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    private static String getCodecMimeType(MediaCodecInfo mediaCodecInfo, String str) {
        for (String str2 : mediaCodecInfo.getSupportedTypes()) {
            if (str2.equalsIgnoreCase(str)) {
                return str2;
            }
        }
        return null;
    }

    private static List<MediaCodecInfo> getDeviceDecodecs() {
        ArrayList arrayList = new ArrayList();
        for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(1).getCodecInfos()) {
            if (!mediaCodecInfo.isEncoder()) {
                arrayList.add(mediaCodecInfo);
            }
        }
        return arrayList;
    }

    private static int getFormatInteger(MediaFormat mediaFormat, String str, int i) {
        return mediaFormat.containsKey(str) ? mediaFormat.getInteger(str) : i;
    }

    public static synchronized boolean isDolbyAudioSupport() {
        boolean z;
        synchronized (MediaCodecUtils.class) {
            try {
                if (allDecoders == null) {
                    allDecoders = getDeviceDecodecs();
                }
                Iterator<MediaCodecInfo> it = allDecoders.iterator();
                boolean z2 = false;
                boolean z3 = false;
                while (it.hasNext()) {
                    for (String str : it.next().getSupportedTypes()) {
                        if (str.equals("audio/ac4")) {
                            z3 = true;
                        } else if (str.equals("audio/eac3")) {
                            z2 = true;
                        }
                    }
                }
                z = z2 || z3;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    private static boolean isFormatSupport(MediaFormat mediaFormat, MediaCodecInfo.CodecCapabilities codecCapabilities, String str) {
        boolean z;
        boolean startsWith = str.startsWith(Constants.VIDEO_TAG);
        boolean startsWith2 = str.startsWith("audio");
        if (!startsWith) {
            if (!startsWith2) {
                return false;
            }
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                Logger.e(TAG, "audio format not support! audioCapabilities == null");
                return false;
            }
            int formatInteger = getFormatInteger(mediaFormat, "sample-rate", -1);
            int formatInteger2 = getFormatInteger(mediaFormat, "channel-count", -1);
            boolean z2 = formatInteger == -1 || audioCapabilities.isSampleRateSupported(formatInteger);
            int maxInputChannelCount = audioCapabilities.getMaxInputChannelCount();
            z = z2 && (formatInteger2 == -1 || maxInputChannelCount >= formatInteger2);
            if (!z) {
                Logger.e(TAG, "audio format not support! sampleRate=" + formatInteger + ", supportedSampleRates=" + Arrays.toString(audioCapabilities.getSupportedSampleRates()) + ", channelCount=" + formatInteger2 + ", maxInputChannelCount=" + maxInputChannelCount);
            }
            return z;
        }
        int formatInteger3 = getFormatInteger(mediaFormat, "width", -1);
        int formatInteger4 = getFormatInteger(mediaFormat, "height", -1);
        if (formatInteger3 <= 0 || formatInteger4 <= 0) {
            return true;
        }
        int max = Math.max(formatInteger3, formatInteger4);
        int min = Math.min(formatInteger3, formatInteger4);
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            Logger.e(TAG, "video format not support! videoCapabilities == null");
            return false;
        }
        Range<Integer> supportedWidths = videoCapabilities.getSupportedWidths();
        Range<Integer> supportedHeights = videoCapabilities.getSupportedHeights();
        z = supportedWidths.contains((Range<Integer>) Integer.valueOf(max)) && supportedHeights.contains((Range<Integer>) Integer.valueOf(min));
        if (!z) {
            Logger.e(TAG, "video format not support! width[" + max + "] not in widthRange [" + supportedWidths.getLower() + ", " + supportedWidths.getUpper() + "] or height[" + min + "] not in heightRange[" + supportedHeights.getLower() + ", " + supportedHeights.getUpper() + "]");
        }
        return z;
    }

    private static boolean isSecureSupport(boolean z, MediaCodecInfo.CodecCapabilities codecCapabilities, String str) {
        boolean isFeatureSupported = codecCapabilities.isFeatureSupported("secure-playback");
        boolean isFeatureRequired = codecCapabilities.isFeatureRequired("secure-playback");
        if (z || !isFeatureRequired) {
            return !z || isFeatureSupported;
        }
        return false;
    }
}
