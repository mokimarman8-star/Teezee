package androidx.media3.common;

import android.text.TextUtils;
import androidx.media3.common.util.a1;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class y {

    /* renamed from: a, reason: collision with root package name */
    private static final ArrayList f9235a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f9236b = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f9237a;

        /* renamed from: b, reason: collision with root package name */
        public final int f9238b;

        public a(int i5, int i6) {
            this.f9237a = i5;
            this.f9238b = i6;
        }

        public int a() {
            int i5 = this.f9238b;
            if (i5 == 2) {
                return 10;
            }
            if (i5 == 5) {
                return 11;
            }
            if (i5 == 29) {
                return 12;
            }
            if (i5 == 42) {
                return 16;
            }
            if (i5 != 22) {
                return i5 != 23 ? 0 : 15;
            }
            return 1073741824;
        }
    }

    public static boolean a(String str, String str2) {
        a i5;
        if (str == null) {
            return false;
        }
        switch (str) {
            case "audio/mp4a-latm":
                if (str2 != null && (i5 = i(str2)) != null) {
                    int a5 = i5.a();
                    if (a5 == 0 || a5 == 16) {
                        break;
                    }
                }
                break;
        }
        return false;
    }

    public static boolean b(String str, String str2) {
        return d(str, str2) != null;
    }

    public static String c(String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : a1.q1(str)) {
            String g5 = g(str2);
            if (g5 != null && o(g5)) {
                return g5;
            }
        }
        return null;
    }

    public static String d(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        String[] q12 = a1.q1(str);
        StringBuilder sb = new StringBuilder();
        for (String str3 : q12) {
            if (str2.equals(g(str3))) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str3);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    private static String e(String str) {
        ArrayList arrayList = f9235a;
        if (arrayList.size() <= 0) {
            return null;
        }
        android.support.v4.media.session.c.a(arrayList.get(0));
        throw null;
    }

    public static int f(String str, String str2) {
        a i5;
        str.hashCode();
        switch (str) {
            case "audio/eac3-joc":
                return 18;
            case "audio/vnd.dts.hd;profile=lbr":
                return 8;
            case "audio/vnd.dts":
                return 7;
            case "audio/mp4a-latm":
                if (str2 == null || (i5 = i(str2)) == null) {
                    return 0;
                }
                return i5.a();
            case "audio/ac3":
                return 5;
            case "audio/ac4":
                return 17;
            case "audio/vnd.dts.uhd;profile=p2":
                return 30;
            case "audio/eac3":
                return 6;
            case "audio/mpeg":
                return 9;
            case "audio/opus":
                return 20;
            case "audio/vnd.dts.hd":
                return 8;
            case "audio/true-hd":
                return 14;
            default:
                return 0;
        }
    }

    public static String g(String str) {
        a i5;
        String str2 = null;
        if (str == null) {
            return null;
        }
        String e5 = com.google.common.base.a.e(str.trim());
        if (e5.startsWith("avc1") || e5.startsWith("avc3")) {
            return "video/avc";
        }
        if (e5.startsWith("hev1") || e5.startsWith("hvc1")) {
            return "video/hevc";
        }
        if (e5.startsWith("dvav") || e5.startsWith("dva1") || e5.startsWith("dvhe") || e5.startsWith("dvh1")) {
            return "video/dolby-vision";
        }
        if (e5.startsWith("av01")) {
            return "video/av01";
        }
        if (e5.startsWith("vp9") || e5.startsWith("vp09")) {
            return "video/x-vnd.on2.vp9";
        }
        if (e5.startsWith("vp8") || e5.startsWith("vp08")) {
            return "video/x-vnd.on2.vp8";
        }
        if (!e5.startsWith("mp4a")) {
            return e5.startsWith("mha1") ? "audio/mha1" : e5.startsWith("mhm1") ? "audio/mhm1" : (e5.startsWith("ac-3") || e5.startsWith("dac3")) ? "audio/ac3" : (e5.startsWith("ec-3") || e5.startsWith("dec3")) ? "audio/eac3" : e5.startsWith("ec+3") ? "audio/eac3-joc" : (e5.startsWith("ac-4") || e5.startsWith("dac4")) ? "audio/ac4" : e5.startsWith("dtsc") ? "audio/vnd.dts" : e5.startsWith("dtse") ? "audio/vnd.dts.hd;profile=lbr" : (e5.startsWith("dtsh") || e5.startsWith("dtsl")) ? "audio/vnd.dts.hd" : e5.startsWith("dtsx") ? "audio/vnd.dts.uhd;profile=p2" : e5.startsWith("opus") ? "audio/opus" : e5.startsWith("vorbis") ? "audio/vorbis" : e5.startsWith("flac") ? "audio/flac" : e5.startsWith("stpp") ? "application/ttml+xml" : e5.startsWith("wvtt") ? "text/vtt" : e5.contains("cea708") ? "application/cea-708" : (e5.contains("eia608") || e5.contains("cea608")) ? "application/cea-608" : e(e5);
        }
        if (e5.startsWith("mp4a.") && (i5 = i(e5)) != null) {
            str2 = h(i5.f9237a);
        }
        return str2 == null ? "audio/mp4a-latm" : str2;
    }

    public static String h(int i5) {
        if (i5 == 32) {
            return "video/mp4v-es";
        }
        if (i5 == 33) {
            return "video/avc";
        }
        if (i5 == 35) {
            return "video/hevc";
        }
        if (i5 == 64) {
            return "audio/mp4a-latm";
        }
        if (i5 == 163) {
            return "video/wvc1";
        }
        if (i5 == 177) {
            return "video/x-vnd.on2.vp9";
        }
        if (i5 == 221) {
            return "audio/vorbis";
        }
        if (i5 == 165) {
            return "audio/ac3";
        }
        if (i5 == 166) {
            return "audio/eac3";
        }
        switch (i5) {
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
                return "video/mpeg2";
            case 102:
            case 103:
            case 104:
                return "audio/mp4a-latm";
            case 105:
            case 107:
                return "audio/mpeg";
            case 106:
                return "video/mpeg";
            case 108:
                return "image/jpeg";
            default:
                switch (i5) {
                    case 169:
                    case 172:
                        return "audio/vnd.dts";
                    case 170:
                    case 171:
                        return "audio/vnd.dts.hd";
                    case 173:
                        return "audio/opus";
                    case 174:
                        return "audio/ac4";
                    default:
                        return null;
                }
        }
    }

    static a i(String str) {
        Matcher matcher = f9236b.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String str2 = (String) androidx.media3.common.util.a.e(matcher.group(1));
        String group = matcher.group(2);
        try {
            return new a(Integer.parseInt(str2, 16), group != null ? Integer.parseInt(group) : 0);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static String j(String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, indexOf);
    }

    public static int k(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (o(str)) {
            return 1;
        }
        if (t(str)) {
            return 2;
        }
        if (s(str)) {
            return 3;
        }
        if (q(str)) {
            return 4;
        }
        if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-icy".equals(str) || "application/vnd.dvb.ait".equals(str)) {
            return 5;
        }
        if ("application/x-camera-motion".equals(str)) {
            return 6;
        }
        return l(str);
    }

    private static int l(String str) {
        ArrayList arrayList = f9235a;
        if (arrayList.size() <= 0) {
            return -1;
        }
        android.support.v4.media.session.c.a(arrayList.get(0));
        throw null;
    }

    public static int m(String str) {
        return k(g(str));
    }

    public static String n(String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : a1.q1(str)) {
            String g5 = g(str2);
            if (g5 != null && t(g5)) {
                return g5;
            }
        }
        return null;
    }

    public static boolean o(String str) {
        return "audio".equals(j(str));
    }

    public static boolean p(String str, String str2) {
        if (str == null) {
            return false;
        }
        if (str.startsWith("dvhe") || str.startsWith("dvh1")) {
            return true;
        }
        if (str2 == null) {
            return false;
        }
        return (str2.startsWith("dvhe") && str.startsWith("hev1")) || (str2.startsWith("dvh1") && str.startsWith("hvc1")) || ((str2.startsWith("dvav") && str.startsWith("avc3")) || ((str2.startsWith("dva1") && str.startsWith("avc1")) || (str2.startsWith("dav1") && str.startsWith("av01"))));
    }

    public static boolean q(String str) {
        return "image".equals(j(str)) || "application/x-image-uri".equals(str);
    }

    public static boolean r(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith("video/webm") || str.startsWith("audio/webm") || str.startsWith("application/webm") || str.startsWith("video/x-matroska") || str.startsWith("audio/x-matroska") || str.startsWith("application/x-matroska");
    }

    public static boolean s(String str) {
        return "text".equals(j(str)) || "application/x-media3-cues".equals(str) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str);
    }

    public static boolean t(String str) {
        return "video".equals(j(str));
    }

    public static String u(String str) {
        String e5;
        if (str == null) {
            return null;
        }
        e5 = com.google.common.base.a.e(str);
        e5.hashCode();
        switch (e5) {
            case "video/x-mvhevc":
                return "video/mv-hevc";
            case "audio/x-flac":
                return "audio/flac";
            case "application/x-mpegurl":
                return "application/x-mpegURL";
            case "audio/x-wav":
                return "audio/wav";
            case "audio/mpeg-l1":
                return "audio/mpeg-L1";
            case "audio/mpeg-l2":
                return "audio/mpeg-L2";
            case "audio/mp3":
                return "audio/mpeg";
            default:
                return e5;
        }
    }
}
