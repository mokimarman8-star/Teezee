package ka;

import android.text.Layout;
import com.cloud.tmc.kernel.bridge.extension.BridgeResponse;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.utils.NetworkUtil;
import com.cloud.tmc.offline.download.model.TaskResultKt;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.q0;
import com.google.android.exoplayer2.util.s;
import da.i;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class c extends da.h {
    private static final Pattern p = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final Pattern q = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final Pattern r = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    static final Pattern s = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");
    static final Pattern t = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    private static final Pattern u = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");
    private static final Pattern v = Pattern.compile("^(\\d+) (\\d+)$");
    private static final b w = new b(30.0f, 1, 1);
    private static final a x = new a(32, 15);
    private final XmlPullParserFactory o;

    private static final class a {
        final int a;
        final int b;

        a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    private static final class b {
        final float a;
        final int b;
        final int c;

        b(float f, int i, int i2) {
            this.a = f;
            this.b = i;
            this.c = i2;
        }
    }

    /* renamed from: ka.c$c, reason: collision with other inner class name */
    private static final class C0052c {
        final int a;
        final int b;

        C0052c(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    public c() {
        super("TtmlDecoder");
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            this.o = newInstance;
            newInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    private static a A(XmlPullParser xmlPullParser, a aVar) {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return aVar;
        }
        Matcher matcher = v.matcher(attributeValue);
        if (!matcher.matches()) {
            s.i("TtmlDecoder", "Ignoring malformed cell resolution: " + attributeValue);
            return aVar;
        }
        try {
            int parseInt = Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher.group(1)));
            int parseInt2 = Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher.group(2)));
            if (parseInt != 0 && parseInt2 != 0) {
                return new a(parseInt, parseInt2);
            }
            throw new SubtitleDecoderException("Invalid cell resolution " + parseInt + " " + parseInt2);
        } catch (NumberFormatException unused) {
            s.i("TtmlDecoder", "Ignoring malformed cell resolution: " + attributeValue);
            return aVar;
        }
    }

    private static void B(String str, g gVar) {
        Matcher matcher;
        String str2;
        String[] S0 = p0.S0(str, "\\s+");
        if (S0.length == 1) {
            matcher = r.matcher(str);
        } else {
            if (S0.length != 2) {
                throw new SubtitleDecoderException("Invalid number of entries for fontSize: " + S0.length + TmcConstants.EXTENSION_SEPARATOR);
            }
            matcher = r.matcher(S0[1]);
            s.i("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        }
        if (!matcher.matches()) {
            throw new SubtitleDecoderException("Invalid expression for fontSize: '" + str + "'.");
        }
        str2 = (String) com.google.android.exoplayer2.util.a.e(matcher.group(3));
        str2.hashCode();
        switch (str2) {
            case "%":
                gVar.z(3);
                break;
            case "em":
                gVar.z(2);
                break;
            case "px":
                gVar.z(1);
                break;
            default:
                throw new SubtitleDecoderException("Invalid unit for fontSize: '" + str2 + "'.");
        }
        gVar.y(Float.parseFloat((String) com.google.android.exoplayer2.util.a.e(matcher.group(1))));
    }

    private static b C(XmlPullParser xmlPullParser) {
        float f;
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int parseInt = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            if (p0.S0(attributeValue2, " ").length != 2) {
                throw new SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
            }
            f = Integer.parseInt(r2[0]) / Integer.parseInt(r2[1]);
        } else {
            f = 1.0f;
        }
        b bVar = w;
        int i = bVar.b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i = Integer.parseInt(attributeValue3);
        }
        int i2 = bVar.c;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i2 = Integer.parseInt(attributeValue4);
        }
        return new b(parseInt * f, i, i2);
    }

    private static Map D(XmlPullParser xmlPullParser, Map map, a aVar, C0052c c0052c, Map map2, Map map3) {
        do {
            xmlPullParser.next();
            if (q0.f(xmlPullParser, "style")) {
                String a2 = q0.a(xmlPullParser, "style");
                g I = I(xmlPullParser, new g());
                if (a2 != null) {
                    for (String str : J(a2)) {
                        I.a((g) map.get(str));
                    }
                }
                String g = I.g();
                if (g != null) {
                    map.put(g, I);
                }
            } else if (q0.f(xmlPullParser, "region")) {
                e G = G(xmlPullParser, aVar, c0052c);
                if (G != null) {
                    map2.put(G.a, G);
                }
            } else if (q0.f(xmlPullParser, "metadata")) {
                E(xmlPullParser, map3);
            }
        } while (!q0.d(xmlPullParser, "head"));
        return map;
    }

    private static void E(XmlPullParser xmlPullParser, Map map) {
        String a2;
        do {
            xmlPullParser.next();
            if (q0.f(xmlPullParser, "image") && (a2 = q0.a(xmlPullParser, "id")) != null) {
                map.put(a2, xmlPullParser.nextText());
            }
        } while (!q0.d(xmlPullParser, "metadata"));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static d F(XmlPullParser xmlPullParser, d dVar, Map map, b bVar) {
        long j;
        long j2;
        char c;
        int attributeCount = xmlPullParser.getAttributeCount();
        g I = I(xmlPullParser, null);
        String str = null;
        String str2 = "";
        long j3 = -9223372036854775807L;
        long j4 = -9223372036854775807L;
        long j5 = -9223372036854775807L;
        String[] strArr = null;
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            attributeName.hashCode();
            switch (attributeName.hashCode()) {
                case -934795532:
                    if (attributeName.equals("region")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 99841:
                    if (attributeName.equals("dur")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 100571:
                    if (attributeName.equals("end")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 93616297:
                    if (attributeName.equals("begin")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 109780401:
                    if (attributeName.equals("style")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 1292595405:
                    if (attributeName.equals("backgroundImage")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    if (!map.containsKey(attributeValue)) {
                        break;
                    } else {
                        str2 = attributeValue;
                        continue;
                    }
                case 1:
                    j5 = K(attributeValue, bVar);
                    break;
                case 2:
                    j4 = K(attributeValue, bVar);
                    break;
                case 3:
                    j3 = K(attributeValue, bVar);
                    break;
                case 4:
                    String[] J = J(attributeValue);
                    if (J.length > 0) {
                        strArr = J;
                        break;
                    }
                    break;
                case 5:
                    if (attributeValue.startsWith("#")) {
                        str = attributeValue.substring(1);
                        break;
                    }
                    break;
            }
        }
        if (dVar != null) {
            long j6 = dVar.d;
            j = -9223372036854775807L;
            if (j6 != -9223372036854775807L) {
                if (j3 != -9223372036854775807L) {
                    j3 += j6;
                }
                if (j4 != -9223372036854775807L) {
                    j4 += j6;
                }
            }
        } else {
            j = -9223372036854775807L;
        }
        long j7 = j3;
        if (j4 == j) {
            if (j5 != j) {
                j2 = j7 + j5;
            } else if (dVar != null) {
                long j10 = dVar.e;
                if (j10 != j) {
                    j2 = j10;
                }
            }
            return d.c(xmlPullParser.getName(), j7, j2, I, strArr, str2, str, dVar);
        }
        j2 = j4;
        return d.c(xmlPullParser.getName(), j7, j2, I, strArr, str2, str, dVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x01ac, code lost:
    
        if (r0.equals("tb") == false) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x017f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static e G(XmlPullParser xmlPullParser, a aVar, C0052c c0052c) {
        float parseFloat;
        float f;
        float parseFloat2;
        float parseFloat3;
        a aVar2;
        int i;
        String a2;
        int i2;
        boolean z = false;
        int i3 = 1;
        String a3 = q0.a(xmlPullParser, "id");
        if (a3 == null) {
            return null;
        }
        String a4 = q0.a(xmlPullParser, "origin");
        if (a4 == null) {
            s.i("TtmlDecoder", "Ignoring region without an origin");
            return null;
        }
        Pattern pattern = t;
        Matcher matcher = pattern.matcher(a4);
        Pattern pattern2 = u;
        Matcher matcher2 = pattern2.matcher(a4);
        if (matcher.matches()) {
            try {
                float parseFloat4 = Float.parseFloat((String) com.google.android.exoplayer2.util.a.e(matcher.group(1))) / 100.0f;
                parseFloat = Float.parseFloat((String) com.google.android.exoplayer2.util.a.e(matcher.group(2))) / 100.0f;
                f = parseFloat4;
            } catch (NumberFormatException unused) {
                s.i("TtmlDecoder", "Ignoring region with malformed origin: " + a4);
                return null;
            }
        } else {
            if (!matcher2.matches()) {
                s.i("TtmlDecoder", "Ignoring region with unsupported origin: " + a4);
                return null;
            }
            if (c0052c == null) {
                s.i("TtmlDecoder", "Ignoring region with missing tts:extent: " + a4);
                return null;
            }
            try {
                int parseInt = Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher2.group(1)));
                f = parseInt / c0052c.a;
                parseFloat = Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher2.group(2))) / c0052c.b;
            } catch (NumberFormatException unused2) {
                s.i("TtmlDecoder", "Ignoring region with malformed origin: " + a4);
                return null;
            }
        }
        String a5 = q0.a(xmlPullParser, "extent");
        if (a5 == null) {
            s.i("TtmlDecoder", "Ignoring region without an extent");
            return null;
        }
        Matcher matcher3 = pattern.matcher(a5);
        Matcher matcher4 = pattern2.matcher(a5);
        if (matcher3.matches()) {
            try {
                parseFloat2 = Float.parseFloat((String) com.google.android.exoplayer2.util.a.e(matcher3.group(1))) / 100.0f;
                parseFloat3 = Float.parseFloat((String) com.google.android.exoplayer2.util.a.e(matcher3.group(2))) / 100.0f;
            } catch (NumberFormatException unused3) {
                s.i("TtmlDecoder", "Ignoring region with malformed extent: " + a4);
                return null;
            }
        } else {
            if (!matcher4.matches()) {
                s.i("TtmlDecoder", "Ignoring region with unsupported extent: " + a4);
                return null;
            }
            if (c0052c == null) {
                s.i("TtmlDecoder", "Ignoring region with missing tts:extent: " + a4);
                return null;
            }
            try {
                int parseInt2 = Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher4.group(1)));
                parseFloat2 = parseInt2 / c0052c.a;
                parseFloat3 = Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher4.group(2))) / c0052c.b;
            } catch (NumberFormatException unused4) {
                s.i("TtmlDecoder", "Ignoring region with malformed extent: " + a4);
                return null;
            }
        }
        String a6 = q0.a(xmlPullParser, "displayAlign");
        if (a6 != null) {
            String e = com.google.common.base.a.e(a6);
            e.hashCode();
            if (e.equals("center")) {
                parseFloat += parseFloat3 / 2.0f;
                aVar2 = aVar;
                i = 1;
            } else if (e.equals("after")) {
                parseFloat += parseFloat3;
                aVar2 = aVar;
                i = 2;
            }
            float f2 = parseFloat;
            float f3 = 1.0f / aVar2.b;
            a2 = q0.a(xmlPullParser, "writingMode");
            if (a2 != null) {
                String e2 = com.google.common.base.a.e(a2);
                e2.hashCode();
                switch (e2.hashCode()) {
                    case 3694:
                        break;
                    case 3553396:
                        if (e2.equals("tblr")) {
                            z = true;
                            break;
                        }
                        z = -1;
                        break;
                    case 3553576:
                        if (e2.equals("tbrl")) {
                            z = 2;
                            break;
                        }
                        z = -1;
                        break;
                    default:
                        z = -1;
                        break;
                }
                switch (z) {
                    case false:
                    case true:
                        i2 = 2;
                        break;
                    case true:
                        i2 = i3;
                        break;
                }
                return new e(a3, f, f2, 0, i, parseFloat2, parseFloat3, 1, f3, i2);
            }
            i3 = Integer.MIN_VALUE;
            i2 = i3;
            return new e(a3, f, f2, 0, i, parseFloat2, parseFloat3, 1, f3, i2);
        }
        aVar2 = aVar;
        i = 0;
        float f22 = parseFloat;
        float f32 = 1.0f / aVar2.b;
        a2 = q0.a(xmlPullParser, "writingMode");
        if (a2 != null) {
        }
        i3 = Integer.MIN_VALUE;
        i2 = i3;
        return new e(a3, f, f22, 0, i, parseFloat2, parseFloat3, 1, f32, i2);
    }

    private static float H(String str) {
        Matcher matcher = s.matcher(str);
        if (!matcher.matches()) {
            s.i("TtmlDecoder", "Invalid value for shear: " + str);
            return Float.MAX_VALUE;
        }
        try {
            return Math.min(100.0f, Math.max(-100.0f, Float.parseFloat((String) com.google.android.exoplayer2.util.a.e(matcher.group(1)))));
        } catch (NumberFormatException e) {
            s.j("TtmlDecoder", "Failed to parse shear: " + str, e);
            return Float.MAX_VALUE;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static g I(XmlPullParser xmlPullParser, g gVar) {
        char c;
        boolean z;
        boolean z2;
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeValue = xmlPullParser.getAttributeValue(i);
            String attributeName = xmlPullParser.getAttributeName(i);
            attributeName.hashCode();
            switch (attributeName.hashCode()) {
                case -1550943582:
                    if (attributeName.equals("fontStyle")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -1224696685:
                    if (attributeName.equals("fontFamily")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -1065511464:
                    if (attributeName.equals("textAlign")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -879295043:
                    if (attributeName.equals("textDecoration")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -734428249:
                    if (attributeName.equals("fontWeight")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 3355:
                    if (attributeName.equals("id")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 3511770:
                    if (attributeName.equals("ruby")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 94842723:
                    if (attributeName.equals("color")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 109403361:
                    if (attributeName.equals("shear")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case 110138194:
                    if (attributeName.equals("textCombine")) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case 365601008:
                    if (attributeName.equals("fontSize")) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case 921125321:
                    if (attributeName.equals("textEmphasis")) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case 1115953443:
                    if (attributeName.equals("rubyPosition")) {
                        c = '\f';
                        break;
                    }
                    c = 65535;
                    break;
                case 1287124693:
                    if (attributeName.equals("backgroundColor")) {
                        c = '\r';
                        break;
                    }
                    c = 65535;
                    break;
                case 1754920356:
                    if (attributeName.equals("multiRowAlign")) {
                        c = 14;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    gVar = x(gVar).B("italic".equalsIgnoreCase(attributeValue));
                    break;
                case 1:
                    gVar = x(gVar).x(attributeValue);
                    break;
                case 2:
                    gVar = x(gVar).H(z(attributeValue));
                    break;
                case 3:
                    String e = com.google.common.base.a.e(attributeValue);
                    e.hashCode();
                    switch (e.hashCode()) {
                        case -1461280213:
                            if (e.equals("nounderline")) {
                                z = false;
                                break;
                            }
                            z = -1;
                            break;
                        case -1026963764:
                            if (e.equals("underline")) {
                                z = true;
                                break;
                            }
                            z = -1;
                            break;
                        case 913457136:
                            if (e.equals("nolinethrough")) {
                                z = 2;
                                break;
                            }
                            z = -1;
                            break;
                        case 1679736913:
                            if (e.equals("linethrough")) {
                                z = 3;
                                break;
                            }
                            z = -1;
                            break;
                        default:
                            z = -1;
                            break;
                    }
                    switch (z) {
                        case false:
                            gVar = x(gVar).K(false);
                            break;
                        case true:
                            gVar = x(gVar).K(true);
                            break;
                        case true:
                            gVar = x(gVar).C(false);
                            break;
                        case true:
                            gVar = x(gVar).C(true);
                            break;
                    }
                case 4:
                    gVar = x(gVar).v("bold".equalsIgnoreCase(attributeValue));
                    break;
                case 5:
                    if ("style".equals(xmlPullParser.getName())) {
                        gVar = x(gVar).A(attributeValue);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    String e2 = com.google.common.base.a.e(attributeValue);
                    e2.hashCode();
                    switch (e2.hashCode()) {
                        case -618561360:
                            if (e2.equals("baseContainer")) {
                                z2 = false;
                                break;
                            }
                            z2 = -1;
                            break;
                        case -410956671:
                            if (e2.equals("container")) {
                                z2 = true;
                                break;
                            }
                            z2 = -1;
                            break;
                        case -250518009:
                            if (e2.equals("delimiter")) {
                                z2 = 2;
                                break;
                            }
                            z2 = -1;
                            break;
                        case -136074796:
                            if (e2.equals("textContainer")) {
                                z2 = 3;
                                break;
                            }
                            z2 = -1;
                            break;
                        case 3016401:
                            if (e2.equals("base")) {
                                z2 = 4;
                                break;
                            }
                            z2 = -1;
                            break;
                        case 3556653:
                            if (e2.equals("text")) {
                                z2 = 5;
                                break;
                            }
                            z2 = -1;
                            break;
                        default:
                            z2 = -1;
                            break;
                    }
                    switch (z2) {
                        case false:
                        case true:
                            gVar = x(gVar).F(2);
                            break;
                        case true:
                            gVar = x(gVar).F(1);
                            break;
                        case true:
                            gVar = x(gVar).F(4);
                            break;
                        case true:
                        case true:
                            gVar = x(gVar).F(3);
                            break;
                    }
                case 7:
                    gVar = x(gVar);
                    try {
                        gVar.w(com.google.android.exoplayer2.util.g.c(attributeValue));
                        break;
                    } catch (IllegalArgumentException unused) {
                        s.i("TtmlDecoder", "Failed parsing color value: " + attributeValue);
                        break;
                    }
                case '\b':
                    gVar = x(gVar).G(H(attributeValue));
                    break;
                case '\t':
                    String e3 = com.google.common.base.a.e(attributeValue);
                    e3.hashCode();
                    if (e3.equals("all")) {
                        gVar = x(gVar).I(true);
                        break;
                    } else if (e3.equals(NetworkUtil.NETWORK_TYPE_NOT_REACHABLE)) {
                        gVar = x(gVar).I(false);
                        break;
                    } else {
                        break;
                    }
                case BridgeResponse.ERROR_CODE_UNAUTHORIZED_USERINFO /* 10 */:
                    try {
                        gVar = x(gVar);
                        B(attributeValue, gVar);
                        break;
                    } catch (SubtitleDecoderException unused2) {
                        s.i("TtmlDecoder", "Failed parsing fontSize value: " + attributeValue);
                        break;
                    }
                case 11:
                    gVar = x(gVar).J(ka.b.a(attributeValue));
                    break;
                case '\f':
                    String e4 = com.google.common.base.a.e(attributeValue);
                    e4.hashCode();
                    if (e4.equals("before")) {
                        gVar = x(gVar).E(1);
                        break;
                    } else if (e4.equals("after")) {
                        gVar = x(gVar).E(2);
                        break;
                    } else {
                        break;
                    }
                case '\r':
                    gVar = x(gVar);
                    try {
                        gVar.u(com.google.android.exoplayer2.util.g.c(attributeValue));
                        break;
                    } catch (IllegalArgumentException unused3) {
                        s.i("TtmlDecoder", "Failed parsing background value: " + attributeValue);
                        break;
                    }
                case 14:
                    gVar = x(gVar).D(z(attributeValue));
                    break;
            }
        }
        return gVar;
    }

    private static String[] J(String str) {
        String trim = str.trim();
        return trim.isEmpty() ? new String[0] : p0.S0(trim, "\\s+");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bb, code lost:
    
        if (r13.equals("ms") == false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long K(String str, b bVar) {
        double d;
        double d2;
        char c = 4;
        Matcher matcher = p.matcher(str);
        if (matcher.matches()) {
            double parseLong = (Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher.group(1))) * 3600) + (Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher.group(2))) * 60) + Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher.group(3)));
            String group = matcher.group(4);
            return (long) ((parseLong + (group != null ? Double.parseDouble(group) : 0.0d) + (matcher.group(5) != null ? Long.parseLong(r13) / bVar.a : 0.0d) + (matcher.group(6) != null ? (Long.parseLong(r13) / bVar.b) / bVar.a : 0.0d)) * 1000000.0d);
        }
        Matcher matcher2 = q.matcher(str);
        if (!matcher2.matches()) {
            throw new SubtitleDecoderException("Malformed time expression: " + str);
        }
        double parseDouble = Double.parseDouble((String) com.google.android.exoplayer2.util.a.e(matcher2.group(1)));
        String str2 = (String) com.google.android.exoplayer2.util.a.e(matcher2.group(2));
        str2.hashCode();
        switch (str2.hashCode()) {
            case 102:
                if (str2.equals("f")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 104:
                if (str2.equals("h")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case TaskResultKt.ERROR_LOAD_RESPONSE_ERROR_CODE /* 109 */:
                if (str2.equals("m")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 116:
                if (str2.equals("t")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 3494:
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                d = bVar.a;
                parseDouble /= d;
                break;
            case 1:
                d2 = 3600.0d;
                break;
            case 2:
                d2 = 60.0d;
                break;
            case 3:
                d = bVar.c;
                parseDouble /= d;
                break;
            case 4:
                d = 1000.0d;
                parseDouble /= d;
                break;
        }
        parseDouble *= d2;
        return (long) (parseDouble * 1000000.0d);
    }

    private static C0052c L(XmlPullParser xmlPullParser) {
        String a2 = q0.a(xmlPullParser, "extent");
        if (a2 == null) {
            return null;
        }
        Matcher matcher = u.matcher(a2);
        if (!matcher.matches()) {
            s.i("TtmlDecoder", "Ignoring non-pixel tts extent: " + a2);
            return null;
        }
        try {
            return new C0052c(Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher.group(1))), Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher.group(2))));
        } catch (NumberFormatException unused) {
            s.i("TtmlDecoder", "Ignoring malformed tts extent: " + a2);
            return null;
        }
    }

    private static g x(g gVar) {
        return gVar == null ? new g() : gVar;
    }

    private static boolean y(String str) {
        return str.equals("tt") || str.equals("head") || str.equals("body") || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals("style") || str.equals("styling") || str.equals("layout") || str.equals("region") || str.equals("metadata") || str.equals("image") || str.equals(TmcConstants.KEY_BRIDGE_RESULT_DATA) || str.equals("information");
    }

    private static Layout.Alignment z(String str) {
        String e = com.google.common.base.a.e(str);
        e.hashCode();
        switch (e) {
            case "center":
                return Layout.Alignment.ALIGN_CENTER;
            case "end":
            case "right":
                return Layout.Alignment.ALIGN_OPPOSITE;
            case "left":
            case "start":
                return Layout.Alignment.ALIGN_NORMAL;
            default:
                return null;
        }
    }

    @Override // da.h
    protected i w(byte[] bArr, int i, boolean z) {
        b bVar;
        try {
            XmlPullParser newPullParser = this.o.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            hashMap2.put("", new e(""));
            C0052c c0052c = null;
            newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i), null);
            ArrayDeque arrayDeque = new ArrayDeque();
            b bVar2 = w;
            a aVar = x;
            int i2 = 0;
            h hVar = null;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.getEventType()) {
                d dVar = (d) arrayDeque.peek();
                if (i2 == 0) {
                    String name = newPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            bVar2 = C(newPullParser);
                            aVar = A(newPullParser, x);
                            c0052c = L(newPullParser);
                        }
                        C0052c c0052c2 = c0052c;
                        b bVar3 = bVar2;
                        a aVar2 = aVar;
                        if (y(name)) {
                            if ("head".equals(name)) {
                                bVar = bVar3;
                                D(newPullParser, hashMap, aVar2, c0052c2, hashMap2, hashMap3);
                            } else {
                                bVar = bVar3;
                                try {
                                    d F = F(newPullParser, dVar, hashMap2, bVar);
                                    arrayDeque.push(F);
                                    if (dVar != null) {
                                        dVar.a(F);
                                    }
                                } catch (SubtitleDecoderException e) {
                                    s.j("TtmlDecoder", "Suppressing parser error", e);
                                    i2++;
                                }
                            }
                            bVar2 = bVar;
                        } else {
                            s.f("TtmlDecoder", "Ignoring unsupported tag: " + newPullParser.getName());
                            i2++;
                            bVar2 = bVar3;
                        }
                        c0052c = c0052c2;
                        aVar = aVar2;
                    } else if (eventType == 4) {
                        ((d) com.google.android.exoplayer2.util.a.e(dVar)).a(d.d(newPullParser.getText()));
                    } else if (eventType == 3) {
                        if (newPullParser.getName().equals("tt")) {
                            hVar = new h((d) com.google.android.exoplayer2.util.a.e((d) arrayDeque.peek()), hashMap, hashMap2, hashMap3);
                        }
                        arrayDeque.pop();
                    }
                } else if (eventType == 2) {
                    i2++;
                } else if (eventType == 3) {
                    i2--;
                }
                newPullParser.next();
            }
            if (hVar != null) {
                return hVar;
            }
            throw new SubtitleDecoderException("No TTML subtitles found");
        } catch (IOException e2) {
            throw new IllegalStateException("Unexpected error when reading input.", e2);
        } catch (XmlPullParserException e3) {
            throw new SubtitleDecoderException("Unable to decode source", e3);
        }
    }
}
