package org.apache.tools.ant.util;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.apache.tools.ant.BuildException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class e {
    private static final d a = d.k();
    private static SAXParserFactory b = null;
    private static SAXParserFactory c = null;
    private static DocumentBuilderFactory d = null;

    private static BuildException a(SAXException sAXException) {
        Exception exception = sAXException.getException();
        return exception != null ? new BuildException(exception) : new BuildException(sAXException);
    }

    public static synchronized SAXParserFactory b() {
        SAXParserFactory sAXParserFactory;
        synchronized (e.class) {
            try {
                if (c == null) {
                    SAXParserFactory d2 = d();
                    c = d2;
                    d2.setNamespaceAware(true);
                }
                sAXParserFactory = c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sAXParserFactory;
    }

    public static XMLReader c() {
        try {
            return e(b()).getXMLReader();
        } catch (SAXException e) {
            throw a(e);
        }
    }

    public static SAXParserFactory d() {
        try {
            return SAXParserFactory.newInstance();
        } catch (FactoryConfigurationError e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("XML parser factory has not been configured correctly: ");
            stringBuffer.append(e.getMessage());
            throw new BuildException(stringBuffer.toString(), e);
        }
    }

    private static SAXParser e(SAXParserFactory sAXParserFactory) {
        try {
            return sAXParserFactory.newSAXParser();
        } catch (ParserConfigurationException e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Cannot create parser for the given configuration: ");
            stringBuffer.append(e.getMessage());
            throw new BuildException(stringBuffer.toString(), e);
        } catch (SAXException e2) {
            throw a(e2);
        }
    }
}
