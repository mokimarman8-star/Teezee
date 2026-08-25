package org.apache.tools.zip;

import java.util.Hashtable;
import java.util.Vector;
import java.util.zip.ZipException;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class ExtraFieldUtils {
    private static final int WORD = 4;
    static /* synthetic */ Class class$org$apache$tools$zip$AsiExtraField;
    static /* synthetic */ Class class$org$apache$tools$zip$JarMarker;
    private static Hashtable implementations = new Hashtable();

    static {
        Class cls = class$org$apache$tools$zip$AsiExtraField;
        if (cls == null) {
            cls = class$("org.apache.tools.zip.AsiExtraField");
            class$org$apache$tools$zip$AsiExtraField = cls;
        }
        register(cls);
        Class cls2 = class$org$apache$tools$zip$JarMarker;
        if (cls2 == null) {
            cls2 = class$("org.apache.tools.zip.JarMarker");
            class$org$apache$tools$zip$JarMarker = cls2;
        }
        register(cls2);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public static ZipExtraField createExtraField(ZipShort zipShort) throws InstantiationException, IllegalAccessException {
        Class cls = (Class) implementations.get(zipShort);
        if (cls != null) {
            return (ZipExtraField) cls.newInstance();
        }
        UnrecognizedExtraField unrecognizedExtraField = new UnrecognizedExtraField();
        unrecognizedExtraField.setHeaderId(zipShort);
        return unrecognizedExtraField;
    }

    public static byte[] mergeCentralDirectoryData(ZipExtraField[] zipExtraFieldArr) {
        int length = zipExtraFieldArr.length * 4;
        for (ZipExtraField zipExtraField : zipExtraFieldArr) {
            length += zipExtraField.getCentralDirectoryLength().getValue();
        }
        byte[] bArr = new byte[length];
        int i = 0;
        for (int i2 = 0; i2 < zipExtraFieldArr.length; i2++) {
            System.arraycopy(zipExtraFieldArr[i2].getHeaderId().getBytes(), 0, bArr, i, 2);
            System.arraycopy(zipExtraFieldArr[i2].getCentralDirectoryLength().getBytes(), 0, bArr, i + 2, 2);
            byte[] centralDirectoryData = zipExtraFieldArr[i2].getCentralDirectoryData();
            System.arraycopy(centralDirectoryData, 0, bArr, i + 4, centralDirectoryData.length);
            i += centralDirectoryData.length + 4;
        }
        return bArr;
    }

    public static byte[] mergeLocalFileDataData(ZipExtraField[] zipExtraFieldArr) {
        int length = zipExtraFieldArr.length * 4;
        for (ZipExtraField zipExtraField : zipExtraFieldArr) {
            length += zipExtraField.getLocalFileDataLength().getValue();
        }
        byte[] bArr = new byte[length];
        int i = 0;
        for (int i2 = 0; i2 < zipExtraFieldArr.length; i2++) {
            System.arraycopy(zipExtraFieldArr[i2].getHeaderId().getBytes(), 0, bArr, i, 2);
            System.arraycopy(zipExtraFieldArr[i2].getLocalFileDataLength().getBytes(), 0, bArr, i + 2, 2);
            byte[] localFileDataData = zipExtraFieldArr[i2].getLocalFileDataData();
            System.arraycopy(localFileDataData, 0, bArr, i + 4, localFileDataData.length);
            i += localFileDataData.length + 4;
        }
        return bArr;
    }

    public static ZipExtraField[] parse(byte[] bArr) throws ZipException {
        Vector vector = new Vector();
        int i = 0;
        while (i <= bArr.length - 4) {
            ZipShort zipShort = new ZipShort(bArr, i);
            int value = new ZipShort(bArr, i + 2).getValue();
            int i2 = i + 4;
            if (i2 + value > bArr.length) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("data starting at ");
                stringBuffer.append(i);
                stringBuffer.append(" is in unknown format");
                throw new ZipException(stringBuffer.toString());
            }
            try {
                ZipExtraField createExtraField = createExtraField(zipShort);
                createExtraField.parseFromLocalFileData(bArr, i2, value);
                vector.addElement(createExtraField);
                i += value + 4;
            } catch (IllegalAccessException e) {
                throw new ZipException(e.getMessage());
            } catch (InstantiationException e2) {
                throw new ZipException(e2.getMessage());
            }
        }
        if (i == bArr.length) {
            ZipExtraField[] zipExtraFieldArr = new ZipExtraField[vector.size()];
            vector.copyInto(zipExtraFieldArr);
            return zipExtraFieldArr;
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("data starting at ");
        stringBuffer2.append(i);
        stringBuffer2.append(" is in unknown format");
        throw new ZipException(stringBuffer2.toString());
    }

    public static void register(Class cls) {
        try {
            implementations.put(((ZipExtraField) cls.newInstance()).getHeaderId(), cls);
        } catch (ClassCastException unused) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(cls);
            stringBuffer.append(" doesn't implement ZipExtraField");
            throw new RuntimeException(stringBuffer.toString());
        } catch (IllegalAccessException unused2) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(cls);
            stringBuffer2.append("'s no-arg constructor is not public");
            throw new RuntimeException(stringBuffer2.toString());
        } catch (InstantiationException unused3) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(cls);
            stringBuffer3.append(" is not a concrete class");
            throw new RuntimeException(stringBuffer3.toString());
        }
    }
}
