package n9;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.q0;
import com.google.android.exoplayer2.util.s;
import com.google.common.collect.ImmutableList;
import java.io.StringReader;
import n9.b;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
abstract class e {
    private static final String[] a = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};
    private static final String[] b = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};
    private static final String[] c = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    public static b a(String str) {
        try {
            return b(str);
        } catch (XmlPullParserException | ParserException | NumberFormatException unused) {
            s.i("MotionPhotoXmpParser", "Ignoring unexpected XMP metadata");
            return null;
        }
    }

    private static b b(String str) {
        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
        newPullParser.setInput(new StringReader(str));
        newPullParser.next();
        if (!q0.f(newPullParser, "x:xmpmeta")) {
            throw ParserException.createForMalformedContainer("Couldn't find xmp metadata", (Throwable) null);
        }
        ImmutableList of = ImmutableList.of();
        long j = -9223372036854775807L;
        do {
            newPullParser.next();
            if (q0.f(newPullParser, "rdf:Description")) {
                if (!d(newPullParser)) {
                    return null;
                }
                j = e(newPullParser);
                of = c(newPullParser);
            } else if (q0.f(newPullParser, "Container:Directory")) {
                of = f(newPullParser, "Container", "Item");
            } else if (q0.f(newPullParser, "GContainer:Directory")) {
                of = f(newPullParser, "GContainer", "GContainerItem");
            }
        } while (!q0.d(newPullParser, "x:xmpmeta"));
        if (of.isEmpty()) {
            return null;
        }
        return new b(j, of);
    }

    private static ImmutableList c(XmlPullParser xmlPullParser) {
        for (String str : c) {
            String a2 = q0.a(xmlPullParser, str);
            if (a2 != null) {
                return ImmutableList.of(new b.a("image/jpeg", "Primary", 0L, 0L), new b.a("video/mp4", "MotionPhoto", Long.parseLong(a2), 0L));
            }
        }
        return ImmutableList.of();
    }

    private static boolean d(XmlPullParser xmlPullParser) {
        for (String str : a) {
            String a2 = q0.a(xmlPullParser, str);
            if (a2 != null) {
                return Integer.parseInt(a2) == 1;
            }
        }
        return false;
    }

    private static long e(XmlPullParser xmlPullParser) {
        for (String str : b) {
            String a2 = q0.a(xmlPullParser, str);
            if (a2 != null) {
                long parseLong = Long.parseLong(a2);
                if (parseLong == -1) {
                    return -9223372036854775807L;
                }
                return parseLong;
            }
        }
        return -9223372036854775807L;
    }

    private static ImmutableList f(XmlPullParser xmlPullParser, String str, String str2) {
        ImmutableList.a builder = ImmutableList.builder();
        String str3 = str + ":Item";
        String str4 = str + ":Directory";
        do {
            xmlPullParser.next();
            if (q0.f(xmlPullParser, str3)) {
                String a2 = q0.a(xmlPullParser, str2 + ":Mime");
                String a3 = q0.a(xmlPullParser, str2 + ":Semantic");
                String a4 = q0.a(xmlPullParser, str2 + ":Length");
                String a5 = q0.a(xmlPullParser, str2 + ":Padding");
                if (a2 == null || a3 == null) {
                    return ImmutableList.of();
                }
                builder.j(new b.a(a2, a3, a4 != null ? Long.parseLong(a4) : 0L, a5 != null ? Long.parseLong(a5) : 0L));
            }
        } while (!q0.d(xmlPullParser, str4));
        return builder.n();
    }
}
