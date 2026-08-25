package com.amazonaws.regions;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Deprecated
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class RegionMetadataParser {
    @Deprecated
    public RegionMetadataParser() {
    }

    private static void a(Region region, Element element, boolean z) {
        String b = b("ServiceName", element);
        String b2 = b("Hostname", element);
        String b3 = b("Http", element);
        String b4 = b("Https", element);
        if (!z || f(b2)) {
            region.h().put(b, b2);
            region.b().put(b, Boolean.valueOf("true".equals(b3)));
            region.c().put(b, Boolean.valueOf("true".equals(b4)));
        } else {
            throw new IllegalStateException("Invalid service endpoint (" + b2 + ") is detected.");
        }
    }

    private static String b(String str, Element element) {
        Node item = element.getElementsByTagName(str).item(0);
        if (item == null) {
            return null;
        }
        return item.getChildNodes().item(0).getNodeValue();
    }

    private static List c(InputStream inputStream, boolean z) {
        try {
            try {
                NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream).getElementsByTagName("Region");
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < elementsByTagName.getLength(); i++) {
                    Node item = elementsByTagName.item(i);
                    if (item.getNodeType() == 1) {
                        arrayList.add(d((Element) item, z));
                    }
                }
                return arrayList;
            } finally {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
        } catch (IOException e) {
            throw e;
        } catch (Exception e2) {
            throw new IOException("Unable to parse region metadata file: " + e2.getMessage(), e2);
        }
    }

    private static Region d(Element element, boolean z) {
        Region region = new Region(b("Name", element), b("Domain", element));
        NodeList elementsByTagName = element.getElementsByTagName("Endpoint");
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            a(region, (Element) elementsByTagName.item(i), z);
        }
        return region;
    }

    private static boolean f(String str) {
        return str.endsWith(".amazonaws.com");
    }

    public List e(InputStream inputStream) {
        return c(inputStream, false);
    }
}
