package com.transsion.core.log;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import yj.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class LogUtils {
    private static ExecutorService b;
    private static String c;
    private static String d;
    private static final char[] a = {'V', 'D', 'I', 'W', 'E', 'A'};
    private static boolean e = false;
    private static boolean f = true;
    private static String g = "TAG";
    private static boolean h = true;
    private static boolean i = true;
    private static boolean j = false;
    private static boolean k = true;
    private static int l = 2;
    private static int m = 2;
    private static final String n = System.getProperty("file.separator");
    private static final String o = System.getProperty("line.separator");
    private static final Format p = new SimpleDateFormat("MM-dd HH:mm:ss.SSS ", Locale.getDefault());

    private static String a(String str) {
        if (!k) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : str.split(o)) {
            sb.append("| ");
            sb.append(str2);
            sb.append(o);
        }
        return sb.toString();
    }

    private static boolean b(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    private static boolean c(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.isFile();
        }
        if (!b(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e3) {
            e3.printStackTrace();
            return false;
        }
    }

    public static void d(String str, Object... objArr) {
        j(3, str, objArr);
    }

    private static String e(String str) {
        try {
            if (str.startsWith("{")) {
                str = new JSONObject(str).toString(4);
            } else if (str.startsWith("[")) {
                str = new JSONArray(str).toString(4);
            }
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        return str;
    }

    private static String f(String str) {
        try {
            StreamSource streamSource = new StreamSource(new StringReader(str));
            StreamResult streamResult = new StreamResult(new StringWriter());
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("indent", "yes");
            newTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            newTransformer.transform(streamSource, streamResult);
            return streamResult.getWriter().toString().replaceFirst(">", ">" + o);
        } catch (Exception e3) {
            e3.printStackTrace();
            return str;
        }
    }

    public static void g(Object obj) {
        j(4, g, obj);
    }

    public static void h(String str, Object... objArr) {
        j(4, str, objArr);
    }

    private static boolean i(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isWhitespace(str.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    private static void j(int i2, String str, Object... objArr) {
        String substring = str.length() > 23 ? str.substring(0, 23) : str;
        if (!a.e() && !Log.isLoggable(substring, 3)) {
            if (!e) {
                return;
            }
            if (!f && !j) {
                return;
            }
        }
        int i3 = i2 & 15;
        int i4 = i2 & 240;
        if (i3 >= l || i3 >= m) {
            String[] o2 = o(str);
            String n2 = n(i4, objArr);
            if (f && i3 >= l) {
                l(i3, o2[0], o2[1], n2);
            }
            if ((j || i4 == 16) && i3 >= m) {
                m(i3, o2[0], o2[2] + n2);
            }
        }
    }

    private static void k(int i2, String str, String str2) {
        Log.println(i2, str, str2);
    }

    private static void l(int i2, String str, String str2, String str3) {
        if (i) {
            k(i2, str, "\n" + str2);
        } else {
            k(i2, str, " \n");
        }
        if (k) {
            k(i2, str, "|---------------------------------------------------------------------------------------------------");
            str3 = a(str3);
        }
        int length = str3.length();
        int i3 = length / 4000;
        if (i3 > 0) {
            int i4 = 4000;
            k(i2, str, str3.substring(0, 4000));
            int i6 = 1;
            while (i6 < i3) {
                int i7 = i4 + 4000;
                String substring = str3.substring(i4, i7);
                if (k) {
                    substring = "| " + substring;
                }
                k(i2, str, substring);
                i6++;
                i4 = i7;
            }
            String substring2 = str3.substring(i4, length);
            if (k) {
                substring2 = "| " + substring2;
            }
            k(i2, str, substring2);
        } else {
            k(i2, str, str3);
        }
        if (k) {
            k(i2, str, "|---------------------------------------------------------------------------------------------------");
        }
    }

    private static void m(int i2, String str, String str2) {
        String format = p.format(new Date(System.currentTimeMillis()));
        String substring = format.substring(0, 5);
        String substring2 = format.substring(6);
        StringBuilder sb = new StringBuilder();
        String str3 = d;
        if (str3 == null) {
            str3 = c;
        }
        sb.append(str3);
        sb.append(substring);
        sb.append(".txt");
        String sb2 = sb.toString();
        if (!c(sb2)) {
            Log.e(str, "log to " + sb2 + " failed!");
            return;
        }
        String str4 = substring2 + a[i2 - 2] + "/" + str + str2 + o;
        if (b == null) {
            b = Executors.newSingleThreadExecutor();
        }
        b.execute(new 1(sb2, str4, str));
    }

    private static String n(int i2, Object... objArr) {
        if (objArr == null) {
            return "Log with null object.";
        }
        if (objArr.length == 1) {
            Object obj = objArr[0];
            String obj2 = obj != null ? obj.toString() : "null";
            return i2 == 32 ? e(obj2) : i2 == 48 ? f(obj2) : obj2;
        }
        StringBuilder sb = new StringBuilder();
        int length = objArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            Object obj3 = objArr[i3];
            sb.append("args");
            sb.append("[");
            sb.append(i3);
            sb.append("]");
            sb.append(" = ");
            sb.append(obj3 == null ? "null" : obj3.toString());
            sb.append(o);
        }
        return sb.toString();
    }

    private static String[] o(String str) {
        if (h || i) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[5];
            String className = stackTraceElement.getClassName();
            String[] split = className.split("\\.");
            if (split.length > 0) {
                className = split[split.length - 1];
            }
            if (className.contains("$")) {
                className = className.split("\\$")[0];
            }
            if (h && i(str)) {
                str = className;
            }
            if (i) {
                String formatter = new Formatter().format("%s, %s(%s.java:%d)", Thread.currentThread().getName(), stackTraceElement.getMethodName(), className, Integer.valueOf(stackTraceElement.getLineNumber())).toString();
                return new String[]{str, formatter + o, " [" + formatter + "]: "};
            }
        } else {
            str = g;
        }
        return new String[]{str, "", ": "};
    }
}
