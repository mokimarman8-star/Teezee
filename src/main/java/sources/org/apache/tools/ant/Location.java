package org.apache.tools.ant;

import java.io.Serializable;
import org.xml.sax.Locator;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class Location implements Serializable {
    private int columnNumber;
    private String fileName;
    private int lineNumber;
    public static final Location UNKNOWN_LOCATION = new Location();
    private static final org.apache.tools.ant.util.d FILE_UTILS = org.apache.tools.ant.util.d.k();

    private Location() {
        this(null, 0, 0);
    }

    public Location(String str) {
        this(str, 0, 0);
    }

    public Location(String str, int i, int i2) {
        if (str == null || !str.startsWith("file:")) {
            this.fileName = str;
        } else {
            this.fileName = FILE_UTILS.i(str);
        }
        this.lineNumber = i;
        this.columnNumber = i2;
    }

    public Location(Locator locator) {
        this(locator.getSystemId(), locator.getLineNumber(), locator.getColumnNumber());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == getClass()) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    public int getColumnNumber() {
        return this.columnNumber;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String str = this.fileName;
        if (str != null) {
            stringBuffer.append(str);
            if (this.lineNumber != 0) {
                stringBuffer.append(":");
                stringBuffer.append(this.lineNumber);
            }
            stringBuffer.append(": ");
        }
        return stringBuffer.toString();
    }
}
