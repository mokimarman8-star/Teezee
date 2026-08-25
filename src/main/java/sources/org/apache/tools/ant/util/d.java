package org.apache.tools.ant.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Stack;
import java.util.StringTokenizer;
import okhttp3.HttpUrl;
import org.apache.tools.ant.BuildException;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class d {
    private static final d d = new d();
    private static Random e = new Random(System.currentTimeMillis() + Runtime.getRuntime().freeMemory());
    private static final boolean f = lz.a.a("netware");
    private static final boolean g = lz.a.a("dos");
    private static final boolean h = lz.a.a("win9x");
    private static final boolean i = lz.a.a("windows");
    static /* synthetic */ Class j;
    private Object a = new Object();
    private String b = null;
    private String c = null;

    protected d() {
    }

    static /* synthetic */ Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public static void b(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void c(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void d(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void e(Writer writer) {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void g(File file) {
        if (file != null) {
            file.delete();
        }
    }

    public static d k() {
        return d;
    }

    public static boolean l(String str) {
        int indexOf;
        int length = str.length();
        if (length == 0) {
            return false;
        }
        char c = File.separatorChar;
        String replace = str.replace('/', c).replace('\\', c);
        char charAt = replace.charAt(0);
        boolean z = g;
        if (!z && !f) {
            return charAt == c;
        }
        if (charAt == c) {
            return z && length > 4 && replace.charAt(1) == c && (indexOf = replace.indexOf(c, 2)) > 2 && indexOf + 1 < length;
        }
        int indexOf2 = replace.indexOf(58);
        return (Character.isLetter(charAt) && indexOf2 == 1 && replace.length() > 2 && replace.charAt(2) == c) || (f && indexOf2 > 0);
    }

    public static boolean m(String str) {
        if ((!g && !f) || str.length() == 0) {
            return false;
        }
        char c = File.separatorChar;
        String replace = str.replace('/', c).replace('\\', c);
        char charAt = replace.charAt(0);
        int length = replace.length();
        if (charAt != c || (length != 1 && replace.charAt(1) == c)) {
            if (!Character.isLetter(charAt) || length <= 1 || replace.indexOf(58) != 1) {
                return false;
            }
            if (length != 2 && replace.charAt(2) == c) {
                return false;
            }
        }
        return true;
    }

    public File f(String str, String str2, File file, boolean z, boolean z2) {
        File createTempFile;
        File file2;
        String property = file == null ? System.getProperty("java.io.tmpdir") : file.getPath();
        if (z2) {
            try {
                createTempFile = File.createTempFile(str, str2, new File(property));
            } catch (IOException e2) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Could not create tempfile in ");
                stringBuffer.append(property);
                throw new BuildException(stringBuffer.toString(), e2);
            }
        } else {
            DecimalFormat decimalFormat = new DecimalFormat("#####");
            synchronized (e) {
                do {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append(str);
                    stringBuffer2.append(decimalFormat.format(Math.abs(e.nextInt())));
                    stringBuffer2.append(str2);
                    file2 = new File(property, stringBuffer2.toString());
                } while (file2.exists());
            }
            createTempFile = file2;
        }
        if (z) {
            createTempFile.deleteOnExit();
        }
        return createTempFile;
    }

    public String[] h(String str) {
        String str2;
        String substring;
        char c = File.separatorChar;
        String replace = str.replace('/', c).replace('\\', c);
        if (!l(replace)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(replace);
            stringBuffer.append(" is not an absolute path");
            throw new BuildException(stringBuffer.toString());
        }
        int indexOf = replace.indexOf(58);
        if (indexOf > 0 && (g || f)) {
            int i2 = indexOf + 1;
            String substring2 = replace.substring(0, i2);
            char[] charArray = replace.toCharArray();
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(substring2);
            stringBuffer2.append(c);
            str2 = stringBuffer2.toString();
            if (charArray[i2] == c) {
                i2 = indexOf + 2;
            }
            StringBuffer stringBuffer3 = new StringBuffer();
            while (i2 < charArray.length) {
                char c2 = charArray[i2];
                if (c2 != c || charArray[i2 - 1] != c) {
                    stringBuffer3.append(c2);
                }
                i2++;
            }
            substring = stringBuffer3.toString();
        } else if (replace.length() <= 1 || replace.charAt(1) != c) {
            str2 = File.separator;
            substring = replace.substring(1);
        } else {
            int indexOf2 = replace.indexOf(c, replace.indexOf(c, 2) + 1);
            str2 = indexOf2 > 2 ? replace.substring(0, indexOf2 + 1) : replace;
            substring = replace.substring(str2.length());
        }
        return new String[]{str2, substring};
    }

    public String i(String str) {
        synchronized (this.a) {
            try {
                if (str.equals(this.b)) {
                    return this.c;
                }
                String c = kz.b.c(str);
                if (l(c)) {
                    c = o(c).getAbsolutePath();
                }
                this.b = str;
                this.c = c;
                return c;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public URL j(File file) {
        return new URL(r(file.getAbsolutePath()));
    }

    public boolean n(File file, File file2) {
        String absolutePath = o(file.getAbsolutePath()).getAbsolutePath();
        String absolutePath2 = o(file2.getAbsolutePath()).getAbsolutePath();
        if (absolutePath.equals(absolutePath2)) {
            return true;
        }
        String str = File.separator;
        if (!absolutePath.endsWith(str)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(absolutePath);
            stringBuffer.append(str);
            absolutePath = stringBuffer.toString();
        }
        return absolutePath2.startsWith(absolutePath);
    }

    public File o(String str) {
        Stack stack = new Stack();
        String[] h2 = h(str);
        stack.push(h2[0]);
        StringTokenizer stringTokenizer = new StringTokenizer(h2[1], File.separator);
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if (!".".equals(nextToken)) {
                if (!"..".equals(nextToken)) {
                    stack.push(nextToken);
                } else {
                    if (stack.size() < 2) {
                        return new File(str);
                    }
                    stack.pop();
                }
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < stack.size(); i2++) {
            if (i2 > 1) {
                stringBuffer.append(File.separatorChar);
            }
            stringBuffer.append(stack.elementAt(i2));
        }
        return new File(stringBuffer.toString());
    }

    public String p(File file, File file2) {
        String absolutePath = o(file.getAbsolutePath()).getAbsolutePath();
        String absolutePath2 = o(file2.getAbsolutePath()).getAbsolutePath();
        if (absolutePath.equals(absolutePath2)) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        String str = File.separator;
        if (!absolutePath.endsWith(str)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(absolutePath);
            stringBuffer.append(str);
            absolutePath = stringBuffer.toString();
        }
        return absolutePath2.startsWith(absolutePath) ? absolutePath2.substring(absolutePath.length()) : absolutePath2;
    }

    public File q(File file, String str) {
        if (!l(str)) {
            char c = File.separatorChar;
            String replace = str.replace('/', c).replace('\\', c);
            if (m(replace)) {
                String property = System.getProperty("user.dir");
                if (replace.charAt(0) == c && property.charAt(0) == c) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(h(property)[0]);
                    stringBuffer.append(replace.substring(1));
                    replace = stringBuffer.toString();
                }
                file = null;
            }
            str = new File(file, replace).getAbsolutePath();
        }
        return o(str);
    }

    public String r(String str) {
        Class<?> cls;
        try {
            cls = Class.forName("java.net.URI");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls != null) {
            try {
                File absoluteFile = new File(str).getAbsoluteFile();
                Class cls2 = j;
                if (cls2 == null) {
                    cls2 = a("java.io.File");
                    j = cls2;
                }
                return (String) cls.getMethod("toASCIIString", null).invoke(cls2.getMethod("toURI", null).invoke(absoluteFile, null), null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        boolean isDirectory = new File(str).isDirectory();
        StringBuffer stringBuffer = new StringBuffer("file:");
        String path = q(null, str).getPath();
        stringBuffer.append("//");
        if (!path.startsWith(File.separator)) {
            stringBuffer.append("/");
        }
        String replace = path.replace('\\', '/');
        try {
            stringBuffer.append(kz.b.b(replace));
            if (isDirectory && !replace.endsWith("/")) {
                stringBuffer.append('/');
            }
            return stringBuffer.toString();
        } catch (UnsupportedEncodingException e3) {
            throw new BuildException(e3);
        }
    }
}
