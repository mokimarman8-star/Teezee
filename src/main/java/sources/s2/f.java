package s2;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.b1;
import androidx.media3.common.util.u;
import com.google.common.collect.ImmutableList;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import s2.c;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract class f {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f17738a = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f17739b = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f17740c = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    public static c a(String str) {
        try {
            return b(str);
        } catch (ParserException | NumberFormatException | XmlPullParserException unused) {
            u.h("MotionPhotoXmpParser", "Ignoring unexpected XMP metadata");
            return null;
        }
    }

    private static c b(String str) {
        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
        newPullParser.setInput(new StringReader(str));
        newPullParser.next();
        if (!b1.f(newPullParser, "x:xmpmeta")) {
            throw ParserException.createForMalformedContainer("Couldn't find xmp metadata", null);
        }
        ImmutableList of = ImmutableList.of();
        long j5 = -9223372036854775807L;
        do {
            newPullParser.next();
            if (b1.f(newPullParser, "rdf:Description")) {
                if (!d(newPullParser)) {
                    return null;
                }
                j5 = e(newPullParser);
                of = c(newPullParser);
            } else if (b1.f(newPullParser, "Container:Directory")) {
                of = f(newPullParser, "Container", "Item");
            } else if (b1.f(newPullParser, "GContainer:Directory")) {
                of = f(newPullParser, "GContainer", "GContainerItem");
            }
        } while (!b1.d(newPullParser, "x:xmpmeta"));
        if (of.isEmpty()) {
            return null;
        }
        return new c(j5, of);
    }

    private static ImmutableList c(XmlPullParser xmlPullParser) {
        for (String str : f17740c) {
            String a5 = b1.a(xmlPullParser, str);
            if (a5 != null) {
                return ImmutableList.of(new c.a("image/jpeg", "Primary", 0L, 0L), new c.a("video/mp4", "MotionPhoto", Long.parseLong(a5), 0L));
            }
        }
        return ImmutableList.of();
    }

    private static boolean d(XmlPullParser xmlPullParser) {
        for (String str : f17738a) {
            String a5 = b1.a(xmlPullParser, str);
            if (a5 != null) {
                return Integer.parseInt(a5) == 1;
            }
        }
        return false;
    }

    private static long e(XmlPullParser xmlPullParser) {
        for (String str : f17739b) {
            String a5 = b1.a(xmlPullParser, str);
            if (a5 != null) {
                long parseLong = Long.parseLong(a5);
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
            if (b1.f(xmlPullParser, str3)) {
                String a5 = b1.a(xmlPullParser, str2 + ":Mime");
                String a6 = b1.a(xmlPullParser, str2 + ":Semantic");
                String a7 = b1.a(xmlPullParser, str2 + ":Length");
                String a8 = b1.a(xmlPullParser, str2 + ":Padding");
                if (a5 == null || a6 == null) {
                    return ImmutableList.of();
                }
                builder.j(new c.a(a5, a6, a7 != null ? Long.parseLong(a7) : 0L, a8 != null ? Long.parseLong(a8) : 0L));
            }
        } while (!b1.d(xmlPullParser, str4));
        return builder.n();
    }
}
