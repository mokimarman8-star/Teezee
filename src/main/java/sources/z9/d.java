package z9;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import android.util.Xml;
import com.cloud.tmc.kernel.bridge.extension.BridgeResponse;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.upstream.b0;
import com.google.android.exoplayer2.util.n0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.q0;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.util.w;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;
import z9.k;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class d extends DefaultHandler implements b0.a {
    private static final Pattern b = Pattern.compile("(\\d+)(?:/(\\d+))?");
    private static final Pattern c = Pattern.compile("CC([1-4])=.*");
    private static final Pattern d = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");
    private static final int[] e = {-1, 1, 2, 3, 4, 5, 6, 8, 2, 3, 4, 7, 8, 24, 8, 12, 10, 12, 14, 12, 14};
    private final XmlPullParserFactory a;

    protected static final class a {
        public final p1 a;
        public final ImmutableList b;
        public final k c;
        public final String d;
        public final ArrayList e;
        public final ArrayList f;
        public final long g;
        public final List h;
        public final List i;

        public a(p1 p1Var, List list, k kVar, String str, ArrayList arrayList, ArrayList arrayList2, List list2, List list3, long j) {
            this.a = p1Var;
            this.b = ImmutableList.copyOf(list);
            this.c = kVar;
            this.d = str;
            this.e = arrayList;
            this.f = arrayList2;
            this.h = list2;
            this.i = list3;
            this.g = j;
        }
    }

    public d() {
        try {
            this.a = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    protected static int C(List list) {
        String str;
        for (int i = 0; i < list.size(); i++) {
            e eVar = (e) list.get(i);
            if ("urn:scte:dash:cc:cea-608:2015".equals(eVar.a) && (str = eVar.b) != null) {
                Matcher matcher = c.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                s.i("MpdParser", "Unable to parse CEA-608 channel number from: " + eVar.b);
            }
        }
        return -1;
    }

    protected static int D(List list) {
        String str;
        for (int i = 0; i < list.size(); i++) {
            e eVar = (e) list.get(i);
            if ("urn:scte:dash:cc:cea-708:2015".equals(eVar.a) && (str = eVar.b) != null) {
                Matcher matcher = d.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                s.i("MpdParser", "Unable to parse CEA-708 service block number from: " + eVar.b);
            }
        }
        return -1;
    }

    protected static long G(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j : p0.I0(attributeValue);
    }

    protected static e H(XmlPullParser xmlPullParser, String str) {
        String q0 = q0(xmlPullParser, "schemeIdUri", "");
        String q02 = q0(xmlPullParser, "value", null);
        String q03 = q0(xmlPullParser, "id", null);
        do {
            xmlPullParser.next();
        } while (!q0.d(xmlPullParser, str));
        return new e(q0, q02, q03);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected static int I(XmlPullParser xmlPullParser) {
        char c2;
        String attributeValue = xmlPullParser.getAttributeValue(null, "value");
        if (attributeValue == null) {
            return -1;
        }
        String e2 = com.google.common.base.a.e(attributeValue);
        e2.hashCode();
        switch (e2.hashCode()) {
            case 1596796:
                if (e2.equals("4000")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 2937391:
                if (e2.equals("a000")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 3094035:
                if (e2.equals("f801")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 3133436:
                if (e2.equals("fa01")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
        }
        return -1;
    }

    protected static int J(XmlPullParser xmlPullParser) {
        int T = T(xmlPullParser, "value", -1);
        if (T <= 0 || T >= 33) {
            return -1;
        }
        return T;
    }

    protected static int K(XmlPullParser xmlPullParser) {
        int bitCount;
        String attributeValue = xmlPullParser.getAttributeValue(null, "value");
        if (attributeValue == null || (bitCount = Integer.bitCount(Integer.parseInt(attributeValue, 16))) == 0) {
            return -1;
        }
        return bitCount;
    }

    protected static long L(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j : p0.J0(attributeValue);
    }

    protected static String M(List list) {
        for (int i = 0; i < list.size(); i++) {
            e eVar = (e) list.get(i);
            String str = eVar.a;
            if ("tag:dolby.com,2018:dash:EC3_ExtensionType:2018".equals(str) && "JOC".equals(eVar.b)) {
                return "audio/eac3-joc";
            }
            if ("tag:dolby.com,2014:dash:DolbyDigitalPlusExtensionType:2014".equals(str) && "ec+3".equals(eVar.b)) {
                return "audio/eac3-joc";
            }
        }
        return "audio/eac3";
    }

    protected static float Q(XmlPullParser xmlPullParser, String str, float f) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? f : Float.parseFloat(attributeValue);
    }

    protected static float R(XmlPullParser xmlPullParser, float f) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "frameRate");
        if (attributeValue == null) {
            return f;
        }
        Matcher matcher = b.matcher(attributeValue);
        if (!matcher.matches()) {
            return f;
        }
        int parseInt = Integer.parseInt(matcher.group(1));
        return !TextUtils.isEmpty(matcher.group(2)) ? parseInt / Integer.parseInt(r2) : parseInt;
    }

    protected static int T(XmlPullParser xmlPullParser, String str, int i) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? i : Integer.parseInt(attributeValue);
    }

    protected static long V(List list) {
        for (int i = 0; i < list.size(); i++) {
            e eVar = (e) list.get(i);
            if (com.google.common.base.a.a("http://dashif.org/guidelines/last-segment-number", eVar.a)) {
                return Long.parseLong(eVar.b);
            }
        }
        return -1L;
    }

    protected static long W(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j : Long.parseLong(attributeValue);
    }

    protected static int Y(XmlPullParser xmlPullParser) {
        int T = T(xmlPullParser, "value", -1);
        if (T < 0) {
            return -1;
        }
        int[] iArr = e;
        if (T < iArr.length) {
            return iArr[T];
        }
        return -1;
    }

    private long a(List list, long j, long j2, int i, long j3) {
        int m = i >= 0 ? i + 1 : (int) p0.m(j3 - j, j2);
        for (int i2 = 0; i2 < m; i2++) {
            list.add(l(j, j2));
            j += j2;
        }
        return j;
    }

    private static int o(int i, int i2) {
        if (i == -1) {
            return i2;
        }
        if (i2 == -1) {
            return i;
        }
        com.google.android.exoplayer2.util.a.g(i == i2);
        return i;
    }

    private static String p(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        com.google.android.exoplayer2.util.a.g(str.equals(str2));
        return str;
    }

    private static void q(ArrayList arrayList) {
        String str;
        int i = 0;
        while (true) {
            if (i >= arrayList.size()) {
                str = null;
                break;
            }
            DrmInitData.SchemeData schemeData = (DrmInitData.SchemeData) arrayList.get(i);
            if (com.google.android.exoplayer2.l.c.equals(schemeData.uuid) && (str = schemeData.licenseServerUrl) != null) {
                arrayList.remove(i);
                break;
            }
            i++;
        }
        if (str == null) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            DrmInitData.SchemeData schemeData2 = (DrmInitData.SchemeData) arrayList.get(i2);
            if (com.google.android.exoplayer2.l.b.equals(schemeData2.uuid) && schemeData2.licenseServerUrl == null) {
                arrayList.set(i2, new DrmInitData.SchemeData(com.google.android.exoplayer2.l.c, str, schemeData2.mimeType, schemeData2.data));
            }
        }
    }

    protected static String q0(XmlPullParser xmlPullParser, String str, String str2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? str2 : attributeValue;
    }

    private static void r(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            DrmInitData.SchemeData schemeData = (DrmInitData.SchemeData) arrayList.get(size);
            if (!schemeData.hasData()) {
                int i = 0;
                while (true) {
                    if (i >= arrayList.size()) {
                        break;
                    }
                    if (((DrmInitData.SchemeData) arrayList.get(i)).canReplace(schemeData)) {
                        arrayList.remove(size);
                        break;
                    }
                    i++;
                }
            }
        }
    }

    protected static String r0(XmlPullParser xmlPullParser, String str) {
        String str2 = "";
        do {
            xmlPullParser.next();
            if (xmlPullParser.getEventType() == 4) {
                str2 = xmlPullParser.getText();
            } else {
                v(xmlPullParser);
            }
        } while (!q0.d(xmlPullParser, str));
        return str2;
    }

    private static long s(long j, long j2) {
        if (j2 != -9223372036854775807L) {
            j = j2;
        }
        if (j == Long.MAX_VALUE) {
            return -9223372036854775807L;
        }
        return j;
    }

    private static String t(String str, String str2) {
        if (w.o(str)) {
            return w.c(str2);
        }
        if (w.s(str)) {
            return w.n(str2);
        }
        if (w.r(str) || w.p(str)) {
            return str;
        }
        if (!"application/mp4".equals(str)) {
            return null;
        }
        String g = w.g(str2);
        return "text/vtt".equals(g) ? "application/x-mp4-vtt" : g;
    }

    private boolean u(String[] strArr) {
        for (String str : strArr) {
            if (str.startsWith("urn:dvb:dash:profile:dvb-dash:")) {
                return true;
            }
        }
        return false;
    }

    public static void v(XmlPullParser xmlPullParser) {
        if (q0.e(xmlPullParser)) {
            int i = 1;
            while (i != 0) {
                xmlPullParser.next();
                if (q0.e(xmlPullParser)) {
                    i++;
                } else if (q0.c(xmlPullParser)) {
                    i--;
                }
            }
        }
    }

    protected long A(XmlPullParser xmlPullParser, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "availabilityTimeOffset");
        if (attributeValue == null) {
            return j;
        }
        if ("INF".equals(attributeValue)) {
            return Long.MAX_VALUE;
        }
        return (long) (Float.parseFloat(attributeValue) * 1000000.0f);
    }

    protected List B(XmlPullParser xmlPullParser, List list, boolean z) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "dvb:priority");
        int parseInt = attributeValue != null ? Integer.parseInt(attributeValue) : z ? 1 : Integer.MIN_VALUE;
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "dvb:weight");
        int parseInt2 = attributeValue2 != null ? Integer.parseInt(attributeValue2) : 1;
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "serviceLocation");
        String r0 = r0(xmlPullParser, "BaseURL");
        if (n0.b(r0)) {
            if (attributeValue3 == null) {
                attributeValue3 = r0;
            }
            return Lists.l(new b[]{new b(r0, attributeValue3, parseInt, parseInt2)});
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            b bVar = (b) list.get(i);
            String d2 = n0.d(bVar.a, r0);
            String str = attributeValue3 == null ? d2 : attributeValue3;
            if (z) {
                parseInt = bVar.c;
                parseInt2 = bVar.d;
                str = bVar.b;
            }
            arrayList.add(new b(d2, str, parseInt, parseInt2));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bc  */
    /* JADX WARN: Type inference failed for: r4v10, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected Pair E(XmlPullParser xmlPullParser) {
        UUID uuid;
        String str;
        String str2;
        String str3;
        ?? r4;
        String attributeValue = xmlPullParser.getAttributeValue(null, "schemeIdUri");
        if (attributeValue != null) {
            String e2 = com.google.common.base.a.e(attributeValue);
            e2.hashCode();
            switch (e2) {
                case "urn:uuid:e2719d58-a985-b3c9-781a-b030af78d30e":
                    uuid = com.google.android.exoplayer2.l.c;
                    str = null;
                    str2 = str;
                    str3 = str2;
                    r4 = str2;
                    break;
                case "urn:uuid:9a04f079-9840-4286-ab92-e65be0885f95":
                    uuid = com.google.android.exoplayer2.l.e;
                    str = null;
                    str2 = str;
                    str3 = str2;
                    r4 = str2;
                    break;
                case "urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed":
                    uuid = com.google.android.exoplayer2.l.d;
                    str = null;
                    str2 = str;
                    str3 = str2;
                    r4 = str2;
                    break;
                case "urn:mpeg:dash:mp4protection:2011":
                    str = xmlPullParser.getAttributeValue(null, "value");
                    String b2 = q0.b(xmlPullParser, "default_KID");
                    if (!TextUtils.isEmpty(b2) && !"00000000-0000-0000-0000-000000000000".equals(b2)) {
                        String[] split = b2.split("\\s+");
                        UUID[] uuidArr = new UUID[split.length];
                        for (int i = 0; i < split.length; i++) {
                            uuidArr[i] = UUID.fromString(split[i]);
                        }
                        uuid = com.google.android.exoplayer2.l.b;
                        byte[] b3 = q9.l.b(uuid, uuidArr, null);
                        str3 = null;
                        r4 = b3;
                        break;
                    } else {
                        uuid = null;
                        str2 = null;
                        str3 = str2;
                        r4 = str2;
                        break;
                    }
                    break;
            }
            do {
                xmlPullParser.next();
                if (!q0.f(xmlPullParser, "clearkey:Laurl") && xmlPullParser.next() == 4) {
                    str3 = xmlPullParser.getText();
                    r4 = r4;
                } else if (!q0.f(xmlPullParser, "ms:laurl")) {
                    str3 = xmlPullParser.getAttributeValue(null, "licenseUrl");
                    r4 = r4;
                } else if (r4 == 0 && q0.g(xmlPullParser, "pssh") && xmlPullParser.next() == 4) {
                    byte[] decode = Base64.decode(xmlPullParser.getText(), 0);
                    UUID f = q9.l.f(decode);
                    if (f == null) {
                        s.i("MpdParser", "Skipping malformed cenc:pssh data");
                        uuid = f;
                        r4 = 0;
                    } else {
                        r4 = decode;
                        uuid = f;
                    }
                } else {
                    if (r4 == 0) {
                        UUID uuid2 = com.google.android.exoplayer2.l.e;
                        if (uuid2.equals(uuid) && q0.f(xmlPullParser, "mspr:pro") && xmlPullParser.next() == 4) {
                            r4 = q9.l.a(uuid2, Base64.decode(xmlPullParser.getText(), 0));
                        }
                    }
                    v(xmlPullParser);
                    r4 = r4;
                }
            } while (!q0.d(xmlPullParser, "ContentProtection"));
            return Pair.create(str, uuid != null ? new DrmInitData.SchemeData(uuid, str3, "video/mp4", (byte[]) r4) : null);
        }
        uuid = null;
        str = null;
        str2 = str;
        str3 = str2;
        r4 = str2;
        do {
            xmlPullParser.next();
            if (!q0.f(xmlPullParser, "clearkey:Laurl")) {
            }
            if (!q0.f(xmlPullParser, "ms:laurl")) {
            }
        } while (!q0.d(xmlPullParser, "ContentProtection"));
        return Pair.create(str, uuid != null ? new DrmInitData.SchemeData(uuid, str3, "video/mp4", (byte[]) r4) : null);
    }

    protected int F(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "contentType");
        if (TextUtils.isEmpty(attributeValue)) {
            return -1;
        }
        if ("audio".equals(attributeValue)) {
            return 1;
        }
        if ("video".equals(attributeValue)) {
            return 2;
        }
        return "text".equals(attributeValue) ? 3 : -1;
    }

    protected Pair N(XmlPullParser xmlPullParser, String str, String str2, long j, ByteArrayOutputStream byteArrayOutputStream) {
        long W = W(xmlPullParser, "id", 0L);
        long W2 = W(xmlPullParser, "duration", -9223372036854775807L);
        long W3 = W(xmlPullParser, "presentationTime", 0L);
        long N0 = p0.N0(W2, 1000L, j);
        long N02 = p0.N0(W3, 1000000L, j);
        String q0 = q0(xmlPullParser, "messageData", null);
        byte[] O = O(xmlPullParser, byteArrayOutputStream);
        Long valueOf = Long.valueOf(N02);
        if (q0 != null) {
            O = p0.n0(q0);
        }
        return Pair.create(valueOf, c(str, str2, W, N0, O));
    }

    protected byte[] O(XmlPullParser xmlPullParser, ByteArrayOutputStream byteArrayOutputStream) {
        byteArrayOutputStream.reset();
        XmlSerializer newSerializer = Xml.newSerializer();
        newSerializer.setOutput(byteArrayOutputStream, com.google.common.base.c.c.name());
        xmlPullParser.nextToken();
        while (!q0.d(xmlPullParser, "Event")) {
            switch (xmlPullParser.getEventType()) {
                case 0:
                    newSerializer.startDocument(null, Boolean.FALSE);
                    break;
                case 1:
                    newSerializer.endDocument();
                    break;
                case 2:
                    newSerializer.startTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
                        newSerializer.attribute(xmlPullParser.getAttributeNamespace(i), xmlPullParser.getAttributeName(i), xmlPullParser.getAttributeValue(i));
                    }
                    break;
                case 3:
                    newSerializer.endTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    break;
                case 4:
                    newSerializer.text(xmlPullParser.getText());
                    break;
                case 5:
                    newSerializer.cdsect(xmlPullParser.getText());
                    break;
                case 6:
                    newSerializer.entityRef(xmlPullParser.getText());
                    break;
                case 7:
                    newSerializer.ignorableWhitespace(xmlPullParser.getText());
                    break;
                case 8:
                    newSerializer.processingInstruction(xmlPullParser.getText());
                    break;
                case 9:
                    newSerializer.comment(xmlPullParser.getText());
                    break;
                case BridgeResponse.ERROR_CODE_UNAUTHORIZED_USERINFO /* 10 */:
                    newSerializer.docdecl(xmlPullParser.getText());
                    break;
            }
            xmlPullParser.nextToken();
        }
        newSerializer.flush();
        return byteArrayOutputStream.toByteArray();
    }

    protected f P(XmlPullParser xmlPullParser) {
        String q0 = q0(xmlPullParser, "schemeIdUri", "");
        String q02 = q0(xmlPullParser, "value", "");
        long W = W(xmlPullParser, "timescale", 1L);
        ArrayList arrayList = new ArrayList();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        do {
            xmlPullParser.next();
            if (q0.f(xmlPullParser, "Event")) {
                arrayList.add(N(xmlPullParser, q0, q02, W, byteArrayOutputStream));
            } else {
                v(xmlPullParser);
            }
        } while (!q0.d(xmlPullParser, "EventStream"));
        long[] jArr = new long[arrayList.size()];
        EventMessage[] eventMessageArr = new EventMessage[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            Pair pair = (Pair) arrayList.get(i);
            jArr[i] = ((Long) pair.first).longValue();
            eventMessageArr[i] = (EventMessage) pair.second;
        }
        return d(q0, q02, W, jArr, eventMessageArr);
    }

    protected i S(XmlPullParser xmlPullParser) {
        return c0(xmlPullParser, "sourceURL", "range");
    }

    protected String U(XmlPullParser xmlPullParser) {
        return r0(xmlPullParser, "Label");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x01dc A[LOOP:0: B:18:0x00a0->B:26:0x01dc, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0197 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected c X(XmlPullParser xmlPullParser, Uri uri) {
        long j;
        ArrayList arrayList;
        ArrayList arrayList2;
        long j2;
        Throwable th;
        ArrayList arrayList3;
        long j3;
        long j4;
        d dVar = this;
        boolean z = true;
        boolean u = dVar.u(dVar.a0(xmlPullParser, "profiles", new String[0]));
        long j5 = -9223372036854775807L;
        long G = G(xmlPullParser, "availabilityStartTime", -9223372036854775807L);
        long L = L(xmlPullParser, "mediaPresentationDuration", -9223372036854775807L);
        long L2 = L(xmlPullParser, "minBufferTime", -9223372036854775807L);
        Throwable th2 = null;
        boolean equals = "dynamic".equals(xmlPullParser.getAttributeValue(null, NativeComponentConstants.KEY_COMPONENT_TYPE));
        long L3 = equals ? L(xmlPullParser, "minimumUpdatePeriod", -9223372036854775807L) : -9223372036854775807L;
        long L4 = equals ? L(xmlPullParser, "timeShiftBufferDepth", -9223372036854775807L) : -9223372036854775807L;
        long L5 = equals ? L(xmlPullParser, "suggestedPresentationDelay", -9223372036854775807L) : -9223372036854775807L;
        long G2 = G(xmlPullParser, "publishTime", -9223372036854775807L);
        long j6 = equals ? 0L : -9223372036854775807L;
        ArrayList l = Lists.l(new b[]{new b(uri.toString(), uri.toString(), u ? 1 : Integer.MIN_VALUE, 1)});
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        boolean z2 = false;
        boolean z3 = false;
        long j7 = equals ? -9223372036854775807L : 0L;
        h hVar = null;
        o oVar = null;
        Uri uri2 = null;
        l lVar = null;
        while (true) {
            xmlPullParser.next();
            if (q0.f(xmlPullParser, "BaseURL")) {
                if (!z2) {
                    j6 = dVar.A(xmlPullParser, j6);
                    z2 = z;
                }
                arrayList5.addAll(dVar.B(xmlPullParser, l, u));
            } else if (q0.f(xmlPullParser, "ProgramInformation")) {
                hVar = b0(xmlPullParser);
            } else if (q0.f(xmlPullParser, "UTCTiming")) {
                oVar = u0(xmlPullParser);
            } else if (q0.f(xmlPullParser, "Location")) {
                uri2 = n0.e(uri.toString(), xmlPullParser.nextText());
            } else if (q0.f(xmlPullParser, "ServiceDescription")) {
                lVar = p0(xmlPullParser);
            } else {
                if (!q0.f(xmlPullParser, "Period") || z3) {
                    j = j6;
                    arrayList = arrayList5;
                    arrayList2 = l;
                    j2 = j5;
                    th = th2;
                    arrayList3 = arrayList4;
                    v(xmlPullParser);
                } else {
                    j = j6;
                    arrayList = arrayList5;
                    arrayList2 = l;
                    ArrayList arrayList6 = arrayList4;
                    j2 = j5;
                    th = th2;
                    Pair Z = Z(xmlPullParser, !arrayList5.isEmpty() ? arrayList5 : l, j7, j, G, L4, u);
                    g gVar = (g) Z.first;
                    if (gVar.b != j2) {
                        long longValue = ((Long) Z.second).longValue();
                        if (longValue == j2) {
                            arrayList3 = arrayList6;
                            j3 = j2;
                        } else {
                            j3 = gVar.b + longValue;
                            arrayList3 = arrayList6;
                        }
                        arrayList3.add(gVar);
                        j7 = j3;
                    } else {
                        if (!equals) {
                            throw ParserException.createForMalformedManifest("Unable to determine start of period " + arrayList6.size(), th);
                        }
                        arrayList3 = arrayList6;
                        z3 = true;
                    }
                }
                j6 = j;
                if (q0.d(xmlPullParser, "MPD")) {
                    dVar = this;
                    arrayList4 = arrayList3;
                    th2 = th;
                    arrayList5 = arrayList;
                    l = arrayList2;
                    j5 = j2;
                    z = true;
                } else {
                    if (L == j2) {
                        if (j7 != j2) {
                            j4 = j7;
                            if (arrayList3.isEmpty()) {
                                return f(G, j4, L2, equals, L3, L4, L5, G2, hVar, oVar, lVar, uri2, arrayList3);
                            }
                            throw ParserException.createForMalformedManifest("No periods found.", th);
                        }
                        if (!equals) {
                            throw ParserException.createForMalformedManifest("Unable to determine duration of static manifest.", th);
                        }
                    }
                    j4 = L;
                    if (arrayList3.isEmpty()) {
                    }
                }
            }
            arrayList = arrayList5;
            arrayList2 = l;
            j2 = j5;
            th = th2;
            arrayList3 = arrayList4;
            if (q0.d(xmlPullParser, "MPD")) {
            }
        }
    }

    protected Pair Z(XmlPullParser xmlPullParser, List list, long j, long j2, long j3, long j4, boolean z) {
        long j5;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        Object obj;
        long j6;
        k k0;
        d dVar = this;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        Object obj2 = null;
        String attributeValue = xmlPullParser2.getAttributeValue(null, "id");
        long L = L(xmlPullParser2, "start", j);
        long j7 = -9223372036854775807L;
        long j10 = j3 != -9223372036854775807L ? j3 + L : -9223372036854775807L;
        long L2 = L(xmlPullParser2, "duration", -9223372036854775807L);
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        long j11 = j2;
        boolean z2 = false;
        long j12 = -9223372036854775807L;
        k kVar = null;
        e eVar = null;
        while (true) {
            xmlPullParser.next();
            if (q0.f(xmlPullParser2, "BaseURL")) {
                if (!z2) {
                    j11 = dVar.A(xmlPullParser2, j11);
                    z2 = true;
                }
                arrayList6.addAll(dVar.B(xmlPullParser2, list, z));
                arrayList3 = arrayList5;
                arrayList = arrayList6;
                j6 = j7;
                obj = obj2;
                arrayList2 = arrayList4;
            } else {
                if (q0.f(xmlPullParser2, "AdaptationSet")) {
                    j5 = j11;
                    arrayList = arrayList6;
                    arrayList2 = arrayList4;
                    arrayList2.add(x(xmlPullParser, !arrayList6.isEmpty() ? arrayList6 : list, kVar, L2, j11, j12, j10, j4, z));
                    xmlPullParser2 = xmlPullParser;
                    arrayList3 = arrayList5;
                } else {
                    j5 = j11;
                    ArrayList arrayList7 = arrayList5;
                    arrayList = arrayList6;
                    arrayList2 = arrayList4;
                    xmlPullParser2 = xmlPullParser;
                    if (q0.f(xmlPullParser2, "EventStream")) {
                        arrayList7.add(P(xmlPullParser));
                        arrayList3 = arrayList7;
                    } else if (q0.f(xmlPullParser2, "SegmentBase")) {
                        arrayList3 = arrayList7;
                        kVar = i0(xmlPullParser2, null);
                        obj = null;
                        j11 = j5;
                        j6 = -9223372036854775807L;
                    } else {
                        arrayList3 = arrayList7;
                        if (q0.f(xmlPullParser2, "SegmentList")) {
                            long A = A(xmlPullParser2, -9223372036854775807L);
                            obj = null;
                            k0 = j0(xmlPullParser, null, j10, L2, j5, A, j4);
                            j12 = A;
                            j11 = j5;
                            j6 = -9223372036854775807L;
                        } else {
                            obj = null;
                            if (q0.f(xmlPullParser2, "SegmentTemplate")) {
                                long A2 = A(xmlPullParser2, -9223372036854775807L);
                                j6 = -9223372036854775807L;
                                k0 = k0(xmlPullParser, null, ImmutableList.of(), j10, L2, j5, A2, j4);
                                j12 = A2;
                                j11 = j5;
                            } else {
                                j6 = -9223372036854775807L;
                                if (q0.f(xmlPullParser2, "AssetIdentifier")) {
                                    eVar = H(xmlPullParser2, "AssetIdentifier");
                                } else {
                                    v(xmlPullParser);
                                }
                                j11 = j5;
                            }
                        }
                        kVar = k0;
                    }
                }
                obj = null;
                j6 = -9223372036854775807L;
                j11 = j5;
            }
            if (q0.d(xmlPullParser2, "Period")) {
                return Pair.create(g(attributeValue, L, arrayList2, arrayList3, eVar), Long.valueOf(L2));
            }
            arrayList4 = arrayList2;
            arrayList6 = arrayList;
            obj2 = obj;
            arrayList5 = arrayList3;
            j7 = j6;
            dVar = this;
        }
    }

    protected String[] a0(XmlPullParser xmlPullParser, String str, String[] strArr) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? strArr : attributeValue.split(",");
    }

    protected z9.a b(int i, int i2, List list, List list2, List list3, List list4) {
        return new z9.a(i, i2, list, list2, list3, list4);
    }

    protected h b0(XmlPullParser xmlPullParser) {
        String str = null;
        String q0 = q0(xmlPullParser, "moreInformationURL", null);
        String q02 = q0(xmlPullParser, "lang", null);
        String str2 = null;
        String str3 = null;
        while (true) {
            xmlPullParser.next();
            if (q0.f(xmlPullParser, "Title")) {
                str = xmlPullParser.nextText();
            } else if (q0.f(xmlPullParser, "Source")) {
                str2 = xmlPullParser.nextText();
            } else if (q0.f(xmlPullParser, "Copyright")) {
                str3 = xmlPullParser.nextText();
            } else {
                v(xmlPullParser);
            }
            String str4 = str3;
            if (q0.d(xmlPullParser, "ProgramInformation")) {
                return new h(str, str2, str4, q0, q02);
            }
            str3 = str4;
        }
    }

    protected EventMessage c(String str, String str2, long j, long j2, byte[] bArr) {
        return new EventMessage(str, str2, j2, j, bArr);
    }

    protected i c0(XmlPullParser xmlPullParser, String str, String str2) {
        long j;
        long j2;
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, str2);
        if (attributeValue2 != null) {
            String[] split = attributeValue2.split("-");
            j = Long.parseLong(split[0]);
            if (split.length == 2) {
                j2 = (Long.parseLong(split[1]) - j) + 1;
                return h(attributeValue, j, j2);
            }
        } else {
            j = 0;
        }
        j2 = -1;
        return h(attributeValue, j, j2);
    }

    protected f d(String str, String str2, long j, long[] jArr, EventMessage[] eventMessageArr) {
        return new f(str, str2, j, jArr, eventMessageArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x01ee A[LOOP:0: B:2:0x006a->B:11:0x01ee, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0198 A[EDGE_INSN: B:12:0x0198->B:13:0x0198 BREAK  A[LOOP:0: B:2:0x006a->B:11:0x01ee], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected a d0(XmlPullParser xmlPullParser, List list, String str, String str2, int i, int i2, float f, int i3, int i4, String str3, List list2, List list3, List list4, List list5, k kVar, long j, long j2, long j3, long j4, long j5, boolean z) {
        long j6;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        int i5;
        long A;
        ArrayList arrayList7;
        k kVar2;
        ArrayList arrayList8;
        ArrayList arrayList9;
        ArrayList arrayList10;
        ArrayList arrayList11;
        d dVar = this;
        String attributeValue = xmlPullParser.getAttributeValue(null, "id");
        int T = T(xmlPullParser, "bandwidth", -1);
        String q0 = q0(xmlPullParser, "mimeType", str);
        String q02 = q0(xmlPullParser, "codecs", str2);
        int T2 = T(xmlPullParser, "width", i);
        int T3 = T(xmlPullParser, "height", i2);
        float R = R(xmlPullParser, f);
        int T4 = T(xmlPullParser, "audioSamplingRate", i4);
        ArrayList arrayList12 = new ArrayList();
        ArrayList arrayList13 = new ArrayList();
        ArrayList arrayList14 = new ArrayList(list4);
        ArrayList arrayList15 = new ArrayList(list5);
        ArrayList arrayList16 = new ArrayList();
        int i6 = i3;
        long j7 = j3;
        boolean z2 = false;
        String str4 = null;
        k kVar3 = kVar;
        long j10 = j4;
        while (true) {
            xmlPullParser.next();
            if (q0.f(xmlPullParser, "BaseURL")) {
                if (!z2) {
                    j7 = dVar.A(xmlPullParser, j7);
                    z2 = true;
                }
                arrayList16.addAll(dVar.B(xmlPullParser, list, z));
            } else if (q0.f(xmlPullParser, "AudioChannelConfiguration")) {
                kVar2 = kVar3;
                arrayList10 = arrayList16;
                arrayList4 = arrayList12;
                i5 = z(xmlPullParser);
                arrayList5 = arrayList13;
                arrayList6 = arrayList15;
                arrayList11 = arrayList10;
                if (q0.d(xmlPullParser, "Representation")) {
                    break;
                }
                arrayList15 = arrayList6;
                arrayList13 = arrayList5;
                arrayList12 = arrayList4;
                kVar3 = kVar2;
                dVar = this;
                i6 = i5;
                arrayList16 = arrayList11;
            } else if (q0.f(xmlPullParser, "SegmentBase")) {
                kVar3 = dVar.i0(xmlPullParser, (k.e) kVar3);
            } else {
                if (q0.f(xmlPullParser, "SegmentList")) {
                    A = dVar.A(xmlPullParser, j10);
                    j6 = j7;
                    arrayList9 = arrayList16;
                    arrayList = arrayList15;
                    arrayList2 = arrayList13;
                    arrayList3 = arrayList14;
                    kVar3 = j0(xmlPullParser, (k.b) kVar3, j, j2, j6, A, j5);
                    arrayList4 = arrayList12;
                } else {
                    j6 = j7;
                    ArrayList arrayList17 = arrayList16;
                    arrayList = arrayList15;
                    arrayList2 = arrayList13;
                    arrayList3 = arrayList14;
                    if (q0.f(xmlPullParser, "SegmentTemplate")) {
                        A = dVar.A(xmlPullParser, j10);
                        arrayList4 = arrayList12;
                        kVar3 = k0(xmlPullParser, (k.c) kVar3, list5, j, j2, j6, A, j5);
                        arrayList9 = arrayList17;
                    } else {
                        arrayList4 = arrayList12;
                        if (q0.f(xmlPullParser, "ContentProtection")) {
                            Pair E = E(xmlPullParser);
                            Object obj = E.first;
                            if (obj != null) {
                                str4 = (String) obj;
                            }
                            Object obj2 = E.second;
                            if (obj2 != null) {
                                arrayList4.add((DrmInitData.SchemeData) obj2);
                            }
                            i5 = i6;
                            arrayList8 = arrayList17;
                            j7 = j6;
                            arrayList6 = arrayList;
                            arrayList5 = arrayList2;
                            arrayList14 = arrayList3;
                            arrayList7 = arrayList8;
                            kVar2 = kVar3;
                            arrayList11 = arrayList7;
                            if (q0.d(xmlPullParser, "Representation")) {
                            }
                        } else {
                            if (q0.f(xmlPullParser, "InbandEventStream")) {
                                arrayList5 = arrayList2;
                                arrayList5.add(H(xmlPullParser, "InbandEventStream"));
                                arrayList6 = arrayList;
                                arrayList14 = arrayList3;
                            } else {
                                arrayList5 = arrayList2;
                                if (q0.f(xmlPullParser, "EssentialProperty")) {
                                    arrayList14 = arrayList3;
                                    arrayList14.add(H(xmlPullParser, "EssentialProperty"));
                                    arrayList6 = arrayList;
                                } else {
                                    arrayList14 = arrayList3;
                                    if (q0.f(xmlPullParser, "SupplementalProperty")) {
                                        arrayList6 = arrayList;
                                        arrayList6.add(H(xmlPullParser, "SupplementalProperty"));
                                    } else {
                                        arrayList6 = arrayList;
                                        v(xmlPullParser);
                                    }
                                }
                            }
                            i5 = i6;
                            j7 = j6;
                            arrayList7 = arrayList17;
                            kVar2 = kVar3;
                            arrayList11 = arrayList7;
                            if (q0.d(xmlPullParser, "Representation")) {
                            }
                        }
                    }
                }
                i5 = i6;
                j10 = A;
                arrayList8 = arrayList9;
                j7 = j6;
                arrayList6 = arrayList;
                arrayList5 = arrayList2;
                arrayList14 = arrayList3;
                arrayList7 = arrayList8;
                kVar2 = kVar3;
                arrayList11 = arrayList7;
                if (q0.d(xmlPullParser, "Representation")) {
                }
            }
            arrayList10 = arrayList16;
            arrayList4 = arrayList12;
            i5 = i6;
            kVar2 = kVar3;
            arrayList5 = arrayList13;
            arrayList6 = arrayList15;
            arrayList11 = arrayList10;
            if (q0.d(xmlPullParser, "Representation")) {
            }
        }
        ArrayList arrayList18 = arrayList6;
        ArrayList arrayList19 = arrayList14;
        ArrayList arrayList20 = arrayList5;
        p1 e2 = e(attributeValue, q0, T2, T3, R, i5, T4, T, str3, list2, list3, q02, arrayList19, arrayList18);
        if (kVar2 == null) {
            kVar2 = new k.e();
        }
        boolean isEmpty = arrayList11.isEmpty();
        List list6 = arrayList11;
        if (isEmpty) {
            list6 = list;
        }
        return new a(e2, list6, kVar2, str4, arrayList4, arrayList20, arrayList19, arrayList18, -1L);
    }

    protected p1 e(String str, String str2, int i, int i2, float f, int i3, int i4, int i5, String str3, List list, List list2, String str4, List list3, List list4) {
        String str5 = str4;
        String t = t(str2, str5);
        if ("audio/eac3".equals(t)) {
            t = M(list4);
            if ("audio/eac3-joc".equals(t)) {
                str5 = "ec+3";
            }
        }
        p1.b V = new p1.b().S(str).K(str2).e0(t).I(str5).Z(i5).g0(o0(list)).c0(h0(list) | e0(list2) | g0(list3) | g0(list4)).V(str3);
        if (w.s(t)) {
            V.j0(i).Q(i2).P(f);
        } else if (w.o(t)) {
            V.H(i3).f0(i4);
        } else if (w.r(t)) {
            V.F("application/cea-608".equals(t) ? C(list2) : "application/cea-708".equals(t) ? D(list2) : -1);
        } else if (w.p(t)) {
            V.j0(i).Q(i2);
        }
        return V.E();
    }

    protected int e0(List list) {
        int s0;
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            e eVar = (e) list.get(i2);
            if (com.google.common.base.a.a("urn:mpeg:dash:role:2011", eVar.a)) {
                s0 = f0(eVar.b);
            } else if (com.google.common.base.a.a("urn:tva:metadata:cs:AudioPurposeCS:2007", eVar.a)) {
                s0 = s0(eVar.b);
            }
            i |= s0;
        }
        return i;
    }

    protected c f(long j, long j2, long j3, boolean z, long j4, long j5, long j6, long j7, h hVar, o oVar, l lVar, Uri uri, List list) {
        return new c(j, j2, j3, z, j4, j5, j6, j7, hVar, oVar, lVar, uri, list);
    }

    protected int f0(String str) {
        if (str == null) {
            return 0;
        }
        switch (str) {
        }
        return 0;
    }

    protected g g(String str, long j, List list, List list2, e eVar) {
        return new g(str, j, list, list2, eVar);
    }

    protected int g0(List list) {
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (com.google.common.base.a.a("http://dashif.org/guidelines/trickmode", ((e) list.get(i2)).a)) {
                i = 16384;
            }
        }
        return i;
    }

    protected i h(String str, long j, long j2) {
        return new i(str, j, j2);
    }

    protected int h0(List list) {
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            e eVar = (e) list.get(i2);
            if (com.google.common.base.a.a("urn:mpeg:dash:role:2011", eVar.a)) {
                i |= f0(eVar.b);
            }
        }
        return i;
    }

    protected j i(a aVar, String str, String str2, ArrayList arrayList, ArrayList arrayList2) {
        p1.b b2 = aVar.a.b();
        if (str != null) {
            b2.U(str);
        }
        String str3 = aVar.d;
        if (str3 != null) {
            str2 = str3;
        }
        ArrayList arrayList3 = aVar.e;
        arrayList3.addAll(arrayList);
        if (!arrayList3.isEmpty()) {
            q(arrayList3);
            r(arrayList3);
            b2.M(new DrmInitData(str2, arrayList3));
        }
        ArrayList arrayList4 = aVar.f;
        arrayList4.addAll(arrayList2);
        return j.n(aVar.g, b2.E(), aVar.b, aVar.c, arrayList4, aVar.h, aVar.i, null);
    }

    protected k.e i0(XmlPullParser xmlPullParser, k.e eVar) {
        long j;
        long j2;
        long W = W(xmlPullParser, "timescale", eVar != null ? eVar.b : 1L);
        long W2 = W(xmlPullParser, "presentationTimeOffset", eVar != null ? eVar.c : 0L);
        long j3 = eVar != null ? eVar.d : 0L;
        long j4 = eVar != null ? eVar.e : 0L;
        String attributeValue = xmlPullParser.getAttributeValue(null, "indexRange");
        if (attributeValue != null) {
            String[] split = attributeValue.split("-");
            j2 = Long.parseLong(split[0]);
            j = (Long.parseLong(split[1]) - j2) + 1;
        } else {
            j = j4;
            j2 = j3;
        }
        i iVar = eVar != null ? eVar.a : null;
        do {
            xmlPullParser.next();
            if (q0.f(xmlPullParser, "Initialization")) {
                iVar = S(xmlPullParser);
            } else {
                v(xmlPullParser);
            }
        } while (!q0.d(xmlPullParser, "SegmentBase"));
        return m(iVar, W, W2, j2, j);
    }

    protected k.b j(i iVar, long j, long j2, long j3, long j4, List list, long j5, List list2, long j6, long j7) {
        return new k.b(iVar, j, j2, j3, j4, list, j5, list2, p0.B0(j6), p0.B0(j7));
    }

    protected k.b j0(XmlPullParser xmlPullParser, k.b bVar, long j, long j2, long j3, long j4, long j5) {
        long W = W(xmlPullParser, "timescale", bVar != null ? bVar.b : 1L);
        long W2 = W(xmlPullParser, "presentationTimeOffset", bVar != null ? bVar.c : 0L);
        long W3 = W(xmlPullParser, "duration", bVar != null ? bVar.e : -9223372036854775807L);
        long W4 = W(xmlPullParser, "startNumber", bVar != null ? bVar.d : 1L);
        long s = s(j3, j4);
        List list = null;
        List list2 = null;
        i iVar = null;
        do {
            xmlPullParser.next();
            if (q0.f(xmlPullParser, "Initialization")) {
                iVar = S(xmlPullParser);
            } else if (q0.f(xmlPullParser, "SegmentTimeline")) {
                list = l0(xmlPullParser, W, j2);
            } else if (q0.f(xmlPullParser, "SegmentURL")) {
                if (list2 == null) {
                    list2 = new ArrayList();
                }
                list2.add(m0(xmlPullParser));
            } else {
                v(xmlPullParser);
            }
        } while (!q0.d(xmlPullParser, "SegmentList"));
        if (bVar != null) {
            if (iVar == null) {
                iVar = bVar.a;
            }
            if (list == null) {
                list = bVar.f;
            }
            if (list2 == null) {
                list2 = bVar.j;
            }
        }
        return j(iVar, W, W2, W4, W3, list, s, list2, j5, j);
    }

    protected k.c k(i iVar, long j, long j2, long j3, long j4, long j5, List list, long j6, n nVar, n nVar2, long j7, long j10) {
        return new k.c(iVar, j, j2, j3, j4, j5, list, j6, nVar, nVar2, p0.B0(j7), p0.B0(j10));
    }

    protected k.c k0(XmlPullParser xmlPullParser, k.c cVar, List list, long j, long j2, long j3, long j4, long j5) {
        long W = W(xmlPullParser, "timescale", cVar != null ? cVar.b : 1L);
        long W2 = W(xmlPullParser, "presentationTimeOffset", cVar != null ? cVar.c : 0L);
        long W3 = W(xmlPullParser, "duration", cVar != null ? cVar.e : -9223372036854775807L);
        long W4 = W(xmlPullParser, "startNumber", cVar != null ? cVar.d : 1L);
        long V = V(list);
        long s = s(j3, j4);
        List list2 = null;
        n t0 = t0(xmlPullParser, "media", cVar != null ? cVar.k : null);
        n t02 = t0(xmlPullParser, "initialization", cVar != null ? cVar.j : null);
        i iVar = null;
        do {
            xmlPullParser.next();
            if (q0.f(xmlPullParser, "Initialization")) {
                iVar = S(xmlPullParser);
            } else if (q0.f(xmlPullParser, "SegmentTimeline")) {
                list2 = l0(xmlPullParser, W, j2);
            } else {
                v(xmlPullParser);
            }
        } while (!q0.d(xmlPullParser, "SegmentTemplate"));
        if (cVar != null) {
            if (iVar == null) {
                iVar = cVar.a;
            }
            if (list2 == null) {
                list2 = cVar.f;
            }
        }
        return k(iVar, W, W2, W4, V, W3, list2, s, t02, t0, j5, j);
    }

    protected k.d l(long j, long j2) {
        return new k.d(j, j2);
    }

    protected List l0(XmlPullParser xmlPullParser, long j, long j2) {
        ArrayList arrayList = new ArrayList();
        long j3 = 0;
        long j4 = -9223372036854775807L;
        boolean z = false;
        int i = 0;
        do {
            xmlPullParser.next();
            if (q0.f(xmlPullParser, "S")) {
                long W = W(xmlPullParser, "t", -9223372036854775807L);
                if (z) {
                    j3 = a(arrayList, j3, j4, i, W);
                }
                if (W == -9223372036854775807L) {
                    W = j3;
                }
                j4 = W(xmlPullParser, "d", -9223372036854775807L);
                i = T(xmlPullParser, "r", 0);
                z = true;
                j3 = W;
            } else {
                v(xmlPullParser);
            }
        } while (!q0.d(xmlPullParser, "SegmentTimeline"));
        if (z) {
            a(arrayList, j3, j4, i, p0.N0(j2, j, 1000L));
        }
        return arrayList;
    }

    protected k.e m(i iVar, long j, long j2, long j3, long j4) {
        return new k.e(iVar, j, j2, j3, j4);
    }

    protected i m0(XmlPullParser xmlPullParser) {
        return c0(xmlPullParser, "media", "mediaRange");
    }

    protected o n(String str, String str2) {
        return new o(str, str2);
    }

    protected int n0(String str) {
        if (str == null) {
            return 0;
        }
        return (str.equals("forced_subtitle") || str.equals("forced-subtitle")) ? 2 : 0;
    }

    protected int o0(List list) {
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            e eVar = (e) list.get(i2);
            if (com.google.common.base.a.a("urn:mpeg:dash:role:2011", eVar.a)) {
                i |= n0(eVar.b);
            }
        }
        return i;
    }

    protected l p0(XmlPullParser xmlPullParser) {
        long j = -9223372036854775807L;
        long j2 = -9223372036854775807L;
        long j3 = -9223372036854775807L;
        float f = -3.4028235E38f;
        float f2 = -3.4028235E38f;
        while (true) {
            xmlPullParser.next();
            if (q0.f(xmlPullParser, "Latency")) {
                j = W(xmlPullParser, TmcConstants.EXTRA_SHARE_TARGET, -9223372036854775807L);
                j2 = W(xmlPullParser, "min", -9223372036854775807L);
                j3 = W(xmlPullParser, "max", -9223372036854775807L);
            } else if (q0.f(xmlPullParser, "PlaybackRate")) {
                f = Q(xmlPullParser, "min", -3.4028235E38f);
                f2 = Q(xmlPullParser, "max", -3.4028235E38f);
            }
            long j4 = j;
            long j5 = j2;
            long j6 = j3;
            float f3 = f;
            float f4 = f2;
            if (q0.d(xmlPullParser, "ServiceDescription")) {
                return new l(j4, j5, j6, f3, f4);
            }
            j = j4;
            j2 = j5;
            j3 = j6;
            f = f3;
            f2 = f4;
        }
    }

    protected int s0(String str) {
        if (str == null) {
            return 0;
        }
        switch (str) {
        }
        return 0;
    }

    protected n t0(XmlPullParser xmlPullParser, String str, n nVar) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue != null ? n.b(attributeValue) : nVar;
    }

    protected o u0(XmlPullParser xmlPullParser) {
        return n(xmlPullParser.getAttributeValue(null, "schemeIdUri"), xmlPullParser.getAttributeValue(null, "value"));
    }

    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public c parse(Uri uri, InputStream inputStream) {
        try {
            XmlPullParser newPullParser = this.a.newPullParser();
            newPullParser.setInput(inputStream, null);
            if (newPullParser.next() == 2 && "MPD".equals(newPullParser.getName())) {
                return X(newPullParser, uri);
            }
            throw ParserException.createForMalformedManifest("inputStream does not contain a valid media presentation description", (Throwable) null);
        } catch (XmlPullParserException e2) {
            throw ParserException.createForMalformedManifest((String) null, e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x030e A[LOOP:0: B:2:0x007c->B:10:0x030e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x02ce A[EDGE_INSN: B:11:0x02ce->B:12:0x02ce BREAK  A[LOOP:0: B:2:0x007c->B:10:0x030e], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected z9.a x(XmlPullParser xmlPullParser, List list, k kVar, long j, long j2, long j3, long j4, long j5, boolean z) {
        long j6;
        ArrayList arrayList;
        Object obj;
        long j7;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        ArrayList arrayList7;
        String str;
        String str2;
        ArrayList arrayList8;
        int i;
        ArrayList arrayList9;
        long A;
        d dVar = this;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        int T = T(xmlPullParser2, "id", -1);
        int F = F(xmlPullParser);
        String attributeValue = xmlPullParser2.getAttributeValue(null, "mimeType");
        String attributeValue2 = xmlPullParser2.getAttributeValue(null, "codecs");
        int T2 = T(xmlPullParser2, "width", -1);
        int T3 = T(xmlPullParser2, "height", -1);
        float R = R(xmlPullParser2, -1.0f);
        int T4 = T(xmlPullParser2, "audioSamplingRate", -1);
        String str3 = "lang";
        String attributeValue3 = xmlPullParser2.getAttributeValue(null, "lang");
        String attributeValue4 = xmlPullParser2.getAttributeValue(null, "label");
        ArrayList arrayList10 = new ArrayList();
        ArrayList arrayList11 = new ArrayList();
        ArrayList arrayList12 = new ArrayList();
        ArrayList arrayList13 = new ArrayList();
        ArrayList arrayList14 = new ArrayList();
        ArrayList arrayList15 = new ArrayList();
        ArrayList arrayList16 = new ArrayList();
        ArrayList arrayList17 = new ArrayList();
        k kVar2 = kVar;
        int i2 = F;
        int i3 = -1;
        String str4 = attributeValue3;
        String str5 = attributeValue4;
        String str6 = null;
        boolean z2 = false;
        long j10 = j2;
        long j11 = j3;
        while (true) {
            xmlPullParser.next();
            if (q0.f(xmlPullParser2, "BaseURL")) {
                if (!z2) {
                    j10 = dVar.A(xmlPullParser2, j10);
                    z2 = true;
                }
                j6 = j11;
                arrayList = arrayList11;
                arrayList17.addAll(dVar.B(xmlPullParser2, list, z));
            } else {
                j6 = j11;
                arrayList = arrayList11;
                if (q0.f(xmlPullParser2, "ContentProtection")) {
                    Pair E = E(xmlPullParser);
                    Object obj2 = E.first;
                    if (obj2 != null) {
                        str6 = (String) obj2;
                    }
                    Object obj3 = E.second;
                    if (obj3 != null) {
                        arrayList10.add((DrmInitData.SchemeData) obj3);
                    }
                } else {
                    if (q0.f(xmlPullParser2, "ContentComponent")) {
                        String p = p(str4, xmlPullParser2.getAttributeValue(null, str3));
                        int o = o(i2, F(xmlPullParser));
                        str2 = p;
                        obj = null;
                        j7 = j10;
                        arrayList2 = arrayList17;
                        arrayList8 = arrayList16;
                        arrayList3 = arrayList15;
                        arrayList4 = arrayList14;
                        arrayList5 = arrayList13;
                        arrayList6 = arrayList12;
                        arrayList7 = arrayList10;
                        str = str3;
                        i = o;
                        arrayList9 = arrayList;
                    } else {
                        int i4 = i2;
                        String str7 = str4;
                        if (q0.f(xmlPullParser2, "Role")) {
                            arrayList13.add(H(xmlPullParser2, "Role"));
                        } else if (q0.f(xmlPullParser2, "AudioChannelConfiguration")) {
                            i3 = z(xmlPullParser);
                        } else if (q0.f(xmlPullParser2, "Accessibility")) {
                            arrayList12.add(H(xmlPullParser2, "Accessibility"));
                        } else if (q0.f(xmlPullParser2, "EssentialProperty")) {
                            arrayList14.add(H(xmlPullParser2, "EssentialProperty"));
                        } else if (q0.f(xmlPullParser2, "SupplementalProperty")) {
                            arrayList15.add(H(xmlPullParser2, "SupplementalProperty"));
                        } else if (q0.f(xmlPullParser2, "Representation")) {
                            j7 = j10;
                            arrayList2 = arrayList17;
                            arrayList3 = arrayList15;
                            arrayList4 = arrayList14;
                            arrayList5 = arrayList13;
                            arrayList6 = arrayList12;
                            arrayList7 = arrayList10;
                            str = str3;
                            obj = null;
                            str2 = str7;
                            a d0 = d0(xmlPullParser, !arrayList17.isEmpty() ? arrayList17 : list, attributeValue, attributeValue2, T2, T3, R, i3, T4, str7, arrayList5, arrayList6, arrayList4, arrayList3, kVar2, j4, j, j7, j6, j5, z);
                            int o2 = o(i4, w.k(d0.a.l));
                            arrayList8 = arrayList16;
                            arrayList8.add(d0);
                            xmlPullParser2 = xmlPullParser;
                            i = o2;
                            arrayList9 = arrayList;
                        } else {
                            obj = null;
                            j7 = j10;
                            arrayList2 = arrayList17;
                            arrayList3 = arrayList15;
                            arrayList4 = arrayList14;
                            arrayList5 = arrayList13;
                            arrayList6 = arrayList12;
                            arrayList7 = arrayList10;
                            str = str3;
                            str2 = str7;
                            arrayList8 = arrayList16;
                            if (q0.f(xmlPullParser, "SegmentBase")) {
                                kVar2 = i0(xmlPullParser, (k.e) kVar2);
                                i = i4;
                                arrayList9 = arrayList;
                                j11 = j6;
                                xmlPullParser2 = xmlPullParser;
                            } else {
                                if (q0.f(xmlPullParser, "SegmentList")) {
                                    A = A(xmlPullParser, j6);
                                    i = i4;
                                    kVar2 = j0(xmlPullParser, (k.b) kVar2, j4, j, j7, A, j5);
                                    xmlPullParser2 = xmlPullParser;
                                } else {
                                    j11 = j6;
                                    i = i4;
                                    if (q0.f(xmlPullParser, "SegmentTemplate")) {
                                        A = A(xmlPullParser, j11);
                                        xmlPullParser2 = xmlPullParser;
                                        kVar2 = k0(xmlPullParser, (k.c) kVar2, arrayList3, j4, j, j7, A, j5);
                                    } else {
                                        xmlPullParser2 = xmlPullParser;
                                        if (q0.f(xmlPullParser2, "InbandEventStream")) {
                                            arrayList9 = arrayList;
                                            arrayList9.add(H(xmlPullParser2, "InbandEventStream"));
                                        } else {
                                            arrayList9 = arrayList;
                                            if (q0.f(xmlPullParser2, "Label")) {
                                                str5 = U(xmlPullParser);
                                            } else if (q0.e(xmlPullParser)) {
                                                y(xmlPullParser);
                                            }
                                        }
                                    }
                                }
                                j11 = A;
                                arrayList9 = arrayList;
                            }
                            if (!q0.d(xmlPullParser2, "AdaptationSet")) {
                                break;
                            }
                            arrayList11 = arrayList9;
                            arrayList16 = arrayList8;
                            arrayList17 = arrayList2;
                            arrayList15 = arrayList3;
                            j10 = j7;
                            arrayList14 = arrayList4;
                            arrayList13 = arrayList5;
                            arrayList12 = arrayList6;
                            arrayList10 = arrayList7;
                            str3 = str;
                            i2 = i;
                            str4 = str2;
                            dVar = this;
                        }
                        obj = null;
                        j7 = j10;
                        arrayList2 = arrayList17;
                        arrayList3 = arrayList15;
                        arrayList4 = arrayList14;
                        arrayList5 = arrayList13;
                        arrayList6 = arrayList12;
                        arrayList7 = arrayList10;
                        str = str3;
                        i = i4;
                        str2 = str7;
                        arrayList9 = arrayList;
                        j11 = j6;
                        arrayList8 = arrayList16;
                        if (!q0.d(xmlPullParser2, "AdaptationSet")) {
                        }
                    }
                    j11 = j6;
                    if (!q0.d(xmlPullParser2, "AdaptationSet")) {
                    }
                }
            }
            j11 = j6;
            j7 = j10;
            arrayList8 = arrayList16;
            arrayList4 = arrayList14;
            arrayList5 = arrayList13;
            arrayList6 = arrayList12;
            arrayList7 = arrayList10;
            str = str3;
            arrayList9 = arrayList;
            i = i2;
            str2 = str4;
            obj = null;
            arrayList2 = arrayList17;
            arrayList3 = arrayList15;
            if (!q0.d(xmlPullParser2, "AdaptationSet")) {
            }
        }
        ArrayList arrayList18 = new ArrayList(arrayList8.size());
        for (int i5 = 0; i5 < arrayList8.size(); i5++) {
            arrayList18.add(i((a) arrayList8.get(i5), str5, str6, arrayList7, arrayList9));
        }
        return b(T, i, arrayList18, arrayList6, arrayList4, arrayList3);
    }

    protected void y(XmlPullParser xmlPullParser) {
        v(xmlPullParser);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected int z(XmlPullParser xmlPullParser) {
        char c2;
        String q0 = q0(xmlPullParser, "schemeIdUri", null);
        q0.hashCode();
        int i = -1;
        switch (q0.hashCode()) {
            case -2128649360:
                if (q0.equals("urn:dts:dash:audio_channel_configuration:2012")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -1352850286:
                if (q0.equals("urn:mpeg:dash:23003:3:audio_channel_configuration:2011")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case -1138141449:
                if (q0.equals("tag:dolby.com,2014:dash:audio_channel_configuration:2011")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -986633423:
                if (q0.equals("urn:mpeg:mpegB:cicp:ChannelConfiguration")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case -79006963:
                if (q0.equals("tag:dts.com,2014:dash:audio_channel_configuration:2012")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 312179081:
                if (q0.equals("tag:dts.com,2018:uhd:audio_channel_configuration")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case 2036691300:
                if (q0.equals("urn:dolby:dash:audio_channel_configuration:2011")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
            case 4:
                i = J(xmlPullParser);
                break;
            case 1:
                i = T(xmlPullParser, "value", -1);
                break;
            case 2:
            case 6:
                i = I(xmlPullParser);
                break;
            case 3:
                i = Y(xmlPullParser);
                break;
            case 5:
                i = K(xmlPullParser);
                break;
        }
        do {
            xmlPullParser.next();
        } while (!q0.d(xmlPullParser, "AudioChannelConfiguration"));
        return i;
    }
}
