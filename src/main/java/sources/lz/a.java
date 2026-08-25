package lz;

import java.util.Locale;
import org.apache.tools.ant.BuildException;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class a {
    private static final String a;
    private static final String b;
    private static final String c;
    private static final String d;

    static {
        String property = System.getProperty("os.name");
        Locale locale = Locale.US;
        a = property.toLowerCase(locale);
        b = System.getProperty("os.arch").toLowerCase(locale);
        c = System.getProperty("os.version").toLowerCase(locale);
        d = System.getProperty("path.separator");
    }

    public static boolean a(String str) {
        return c(str, null, null, null);
    }

    public static boolean b(String str) {
        return c(null, str, null, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0057, code lost:
    
        if (r6 != false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0068, code lost:
    
        if (r7 != false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0078, code lost:
    
        if (r2.indexOf("os/2") > (-1)) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0088, code lost:
    
        if (r2.indexOf("netware") > (-1)) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a2, code lost:
    
        if (a("netware") == false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b2, code lost:
    
        if (r2.indexOf("mac") > (-1)) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c4, code lost:
    
        if (r2.indexOf("nonstop_kernel") > (-1)) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00ee, code lost:
    
        if (r2.endsWith("x") != false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0105, code lost:
    
        if (r2.indexOf("os/390") <= (-1)) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0114, code lost:
    
        if (r2.indexOf("os/400") > (-1)) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0121, code lost:
    
        if (r2.indexOf("openvms") > (-1)) goto L98;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x015e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean c(String str, String str2, String str3, String str4) {
        boolean z;
        boolean z2;
        boolean z3;
        if (str == null && str2 == null && str3 == null && str4 == null) {
            return false;
        }
        if (str != null) {
            String str5 = a;
            z = str5.indexOf("windows") > -1;
            if (z) {
                z2 = str5.indexOf("95") >= 0 || str5.indexOf("98") >= 0 || str5.indexOf("me") >= 0 || str5.indexOf("ce") >= 0;
                z3 = !z2;
            } else {
                z2 = false;
                z3 = false;
            }
            if (!str.equals("windows")) {
                if (str.equals("win9x")) {
                    if (z) {
                    }
                    z = false;
                } else if (str.equals("winnt")) {
                    if (z) {
                    }
                    z = false;
                } else if (!str.equals("os/2")) {
                    if (!str.equals("netware")) {
                        if (str.equals("dos")) {
                            if (d.equals(";")) {
                            }
                            z = false;
                        } else if (!str.equals("mac")) {
                            if (!str.equals("tandem")) {
                                if (str.equals("unix")) {
                                    if (d.equals(":")) {
                                        if (!a("openvms")) {
                                            if (a("mac")) {
                                            }
                                        }
                                    }
                                    z = false;
                                } else if (str.equals("z/os")) {
                                    if (str5.indexOf("z/os") <= -1) {
                                    }
                                } else if (!str.equals("os/400")) {
                                    if (!str.equals("openvms")) {
                                        StringBuffer stringBuffer = new StringBuffer();
                                        stringBuffer.append("Don't know how to detect os family \"");
                                        stringBuffer.append(str);
                                        stringBuffer.append("\"");
                                        throw new BuildException(stringBuffer.toString());
                                    }
                                }
                            }
                        }
                    }
                }
            }
            boolean equals = str2 == null ? str2.equals(a) : true;
            boolean equals2 = str3 == null ? str3.equals(b) : true;
            boolean equals3 = str4 == null ? str4.equals(c) : true;
            return !z ? false : false;
        }
        z = true;
        if (str2 == null) {
        }
        if (str3 == null) {
        }
        if (str4 == null) {
        }
        return !z ? false : false;
    }
}
