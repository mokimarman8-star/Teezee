package androidx.media3.common;

import android.net.Uri;
import java.util.List;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class o {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int a(String str) {
        char c5;
        if (str == null) {
            return -1;
        }
        String u5 = y.u(str);
        u5.hashCode();
        switch (u5.hashCode()) {
            case -2123537834:
                if (u5.equals("audio/eac3-joc")) {
                    c5 = 0;
                    break;
                }
                c5 = 65535;
                break;
            case -1662384011:
                if (u5.equals("video/mp2p")) {
                    c5 = 1;
                    break;
                }
                c5 = 65535;
                break;
            case -1662384007:
                if (u5.equals("video/mp2t")) {
                    c5 = 2;
                    break;
                }
                c5 = 65535;
                break;
            case -1662095187:
                if (u5.equals("video/webm")) {
                    c5 = 3;
                    break;
                }
                c5 = 65535;
                break;
            case -1606874997:
                if (u5.equals("audio/amr-wb")) {
                    c5 = 4;
                    break;
                }
                c5 = 65535;
                break;
            case -1487656890:
                if (u5.equals("image/avif")) {
                    c5 = 5;
                    break;
                }
                c5 = 65535;
                break;
            case -1487464693:
                if (u5.equals("image/heic")) {
                    c5 = 6;
                    break;
                }
                c5 = 65535;
                break;
            case -1487464690:
                if (u5.equals("image/heif")) {
                    c5 = 7;
                    break;
                }
                c5 = 65535;
                break;
            case -1487394660:
                if (u5.equals("image/jpeg")) {
                    c5 = '\b';
                    break;
                }
                c5 = 65535;
                break;
            case -1487018032:
                if (u5.equals("image/webp")) {
                    c5 = '\t';
                    break;
                }
                c5 = 65535;
                break;
            case -1248337486:
                if (u5.equals("application/mp4")) {
                    c5 = '\n';
                    break;
                }
                c5 = 65535;
                break;
            case -1079884372:
                if (u5.equals("video/x-msvideo")) {
                    c5 = 11;
                    break;
                }
                c5 = 65535;
                break;
            case -1004728940:
                if (u5.equals("text/vtt")) {
                    c5 = '\f';
                    break;
                }
                c5 = 65535;
                break;
            case -879272239:
                if (u5.equals("image/bmp")) {
                    c5 = '\r';
                    break;
                }
                c5 = 65535;
                break;
            case -879258763:
                if (u5.equals("image/png")) {
                    c5 = 14;
                    break;
                }
                c5 = 65535;
                break;
            case -387023398:
                if (u5.equals("audio/x-matroska")) {
                    c5 = 15;
                    break;
                }
                c5 = 65535;
                break;
            case -43467528:
                if (u5.equals("application/webm")) {
                    c5 = 16;
                    break;
                }
                c5 = 65535;
                break;
            case 13915911:
                if (u5.equals("video/x-flv")) {
                    c5 = 17;
                    break;
                }
                c5 = 65535;
                break;
            case 187078296:
                if (u5.equals("audio/ac3")) {
                    c5 = 18;
                    break;
                }
                c5 = 65535;
                break;
            case 187078297:
                if (u5.equals("audio/ac4")) {
                    c5 = 19;
                    break;
                }
                c5 = 65535;
                break;
            case 187078669:
                if (u5.equals("audio/amr")) {
                    c5 = 20;
                    break;
                }
                c5 = 65535;
                break;
            case 187090232:
                if (u5.equals("audio/mp4")) {
                    c5 = 21;
                    break;
                }
                c5 = 65535;
                break;
            case 187091926:
                if (u5.equals("audio/ogg")) {
                    c5 = 22;
                    break;
                }
                c5 = 65535;
                break;
            case 187099443:
                if (u5.equals("audio/wav")) {
                    c5 = 23;
                    break;
                }
                c5 = 65535;
                break;
            case 1331848029:
                if (u5.equals("video/mp4")) {
                    c5 = 24;
                    break;
                }
                c5 = 65535;
                break;
            case 1503095341:
                if (u5.equals("audio/3gpp")) {
                    c5 = 25;
                    break;
                }
                c5 = 65535;
                break;
            case 1504578661:
                if (u5.equals("audio/eac3")) {
                    c5 = 26;
                    break;
                }
                c5 = 65535;
                break;
            case 1504619009:
                if (u5.equals("audio/flac")) {
                    c5 = 27;
                    break;
                }
                c5 = 65535;
                break;
            case 1504824762:
                if (u5.equals("audio/midi")) {
                    c5 = 28;
                    break;
                }
                c5 = 65535;
                break;
            case 1504831518:
                if (u5.equals("audio/mpeg")) {
                    c5 = 29;
                    break;
                }
                c5 = 65535;
                break;
            case 1505118770:
                if (u5.equals("audio/webm")) {
                    c5 = 30;
                    break;
                }
                c5 = 65535;
                break;
            case 2039520277:
                if (u5.equals("video/x-matroska")) {
                    c5 = 31;
                    break;
                }
                c5 = 65535;
                break;
            default:
                c5 = 65535;
                break;
        }
        switch (c5) {
        }
        return -1;
    }

    public static int b(Map map) {
        List list = (List) map.get("Content-Type");
        return a((list == null || list.isEmpty()) ? null : (String) list.get(0));
    }

    public static int c(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return -1;
        }
        if (lastPathSegment.endsWith(".ac3") || lastPathSegment.endsWith(".ec3")) {
            return 0;
        }
        if (lastPathSegment.endsWith(".ac4")) {
            return 1;
        }
        if (lastPathSegment.endsWith(".adts") || lastPathSegment.endsWith(".aac")) {
            return 2;
        }
        if (lastPathSegment.endsWith(".amr")) {
            return 3;
        }
        if (lastPathSegment.endsWith(".flac")) {
            return 4;
        }
        if (lastPathSegment.endsWith(".flv")) {
            return 5;
        }
        if (lastPathSegment.endsWith(".mid") || lastPathSegment.endsWith(".midi") || lastPathSegment.endsWith(".smf")) {
            return 15;
        }
        if (lastPathSegment.startsWith(".mk", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".webm")) {
            return 6;
        }
        if (lastPathSegment.endsWith(".mp3")) {
            return 7;
        }
        if (lastPathSegment.endsWith(".mp4") || lastPathSegment.startsWith(".m4", lastPathSegment.length() - 4) || lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5) || lastPathSegment.startsWith(".cmf", lastPathSegment.length() - 5)) {
            return 8;
        }
        if (lastPathSegment.startsWith(".og", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".opus")) {
            return 9;
        }
        if (lastPathSegment.endsWith(".ps") || lastPathSegment.endsWith(".mpeg") || lastPathSegment.endsWith(".mpg") || lastPathSegment.endsWith(".m2p")) {
            return 10;
        }
        if (lastPathSegment.endsWith(".ts") || lastPathSegment.startsWith(".ts", lastPathSegment.length() - 4)) {
            return 11;
        }
        if (lastPathSegment.endsWith(".wav") || lastPathSegment.endsWith(".wave")) {
            return 12;
        }
        if (lastPathSegment.endsWith(".vtt") || lastPathSegment.endsWith(".webvtt")) {
            return 13;
        }
        if (lastPathSegment.endsWith(".jpg") || lastPathSegment.endsWith(".jpeg")) {
            return 14;
        }
        if (lastPathSegment.endsWith(".avi")) {
            return 16;
        }
        if (lastPathSegment.endsWith(".png")) {
            return 17;
        }
        if (lastPathSegment.endsWith(".webp")) {
            return 18;
        }
        if (lastPathSegment.endsWith(".bmp") || lastPathSegment.endsWith(".dib")) {
            return 19;
        }
        if (lastPathSegment.endsWith(".heic") || lastPathSegment.endsWith(".heif")) {
            return 20;
        }
        return lastPathSegment.endsWith(".avif") ? 21 : -1;
    }
}
