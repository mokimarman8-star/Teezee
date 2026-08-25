package com.transsion.core.log;

import android.os.Environment;
import android.util.Log;
import com.transsion.core.utils.b;
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
public final class ObjectLogUtils {
    private static final char[] o = {'V', 'D', 'I', 'W', 'E', 'A'};
    private static final String p = System.getProperty("file.separator");
    private static final String q = System.getProperty("line.separator");
    private final int a;
    private final int b;
    private final int c;
    private ExecutorService d;
    private final String e;
    private final String f;
    private final String g;
    private final int h;
    private final Format i;
    private final String j;
    private final String k;
    private final String l;
    a m;
    private int n;

    private ObjectLogUtils(a aVar) {
        this.a = 16;
        this.b = 32;
        this.c = 48;
        this.e = "|---------------------------------------------------------------------------------------------------";
        this.f = "| ";
        this.g = "|---------------------------------------------------------------------------------------------------";
        this.h = 4000;
        this.i = new SimpleDateFormat("MM-dd HH:mm:ss.SSS ", Locale.getDefault());
        this.j = "Log with null object.";
        this.k = "null";
        this.l = "args";
        new a();
        this.n = 0;
        this.m = aVar;
    }

    private String d(String str) {
        if (!a.d(this.m)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : str.split(q)) {
            sb.append("| ");
            sb.append(str2);
            sb.append(q);
        }
        return sb.toString();
    }

    private static boolean e(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    private static boolean f(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.isFile();
        }
        if (!e(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static String k(String str) {
        try {
            if (str.startsWith("{")) {
                str = new JSONObject(str).toString(4);
            } else if (str.startsWith("[")) {
                str = new JSONArray(str).toString(4);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return str;
    }

    private String l(String str) {
        try {
            StreamSource streamSource = new StreamSource(new StringReader(str));
            StreamResult streamResult = new StreamResult(new StringWriter());
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("indent", "yes");
            newTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            newTransformer.transform(streamSource, streamResult);
            return streamResult.getWriter().toString().replaceFirst(">", ">" + q);
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean p(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private void r(int i, String str, Object... objArr) {
        try {
            if (!Log.isLoggable(str.length() > 23 ? str.substring(0, 23) : str, 3)) {
                if (!a.i(this.m)) {
                    return;
                }
                if (!a.j(this.m) && !a.k(this.m)) {
                    return;
                }
            }
            int i2 = i & 15;
            int i3 = i & 240;
            if (i2 >= a.l(this.m) || i2 >= a.a(this.m)) {
                String[] w = w(str);
                String v = v(i3, objArr);
                if (a.j(this.m) && i2 >= a.l(this.m)) {
                    t(i2, w[0], w[1], v);
                }
                if ((a.k(this.m) || i3 == 16) && i2 >= a.a(this.m)) {
                    u(i2, w[0], w[2] + v);
                }
            }
        } catch (Exception unused) {
        }
    }

    private static void s(int i, String str, String str2) {
        Log.println(i, str, str2);
    }

    private void t(int i, String str, String str2, String str3) {
        if (a.c(this.m)) {
            s(i, str, "\n" + str2);
        } else {
            s(i, str, " \n");
        }
        if (a.d(this.m)) {
            s(i, str, "|---------------------------------------------------------------------------------------------------");
            str3 = d(str3);
        }
        int length = str3.length();
        int i2 = length / 4000;
        if (i2 > 0) {
            int i3 = 4000;
            s(i, str, str3.substring(0, 4000));
            int i4 = 1;
            while (i4 < i2) {
                int i6 = i3 + 4000;
                String substring = str3.substring(i3, i6);
                if (a.d(this.m)) {
                    substring = "| " + substring;
                }
                s(i, str, substring);
                i4++;
                i3 = i6;
            }
            String substring2 = str3.substring(i3, length);
            if (a.d(this.m)) {
                substring2 = "| " + substring2;
            }
            s(i, str, substring2);
        } else {
            s(i, str, str3);
        }
        if (a.d(this.m)) {
            s(i, str, "|---------------------------------------------------------------------------------------------------");
        }
    }

    private void u(int i, String str, String str2) {
        String format = this.i.format(new Date(System.currentTimeMillis()));
        String substring = format.substring(0, 5);
        String substring2 = format.substring(6);
        if (a.e(this.m) == null) {
            if (!"mounted".equals(Environment.getExternalStorageState()) || b.a(a.a()) == null) {
                a aVar = this.m;
                StringBuilder sb = new StringBuilder();
                sb.append(a.a().getCacheDir());
                String str3 = p;
                sb.append(str3);
                sb.append("log");
                sb.append(str3);
                a.f(aVar, sb.toString());
            } else {
                a aVar2 = this.m;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(b.a(a.a()));
                String str4 = p;
                sb2.append(str4);
                sb2.append("log");
                sb2.append(str4);
                a.f(aVar2, sb2.toString());
            }
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(a.g(this.m) == null ? a.e(this.m) : a.g(this.m));
        sb3.append(substring);
        sb3.append(".txt");
        String sb4 = sb3.toString();
        if (!f(sb4)) {
            Log.e(str, "log to " + sb4 + " failed!");
            return;
        }
        String str5 = substring2 + o[i - 2] + "/" + str + str2 + q;
        if (this.d == null) {
            this.d = Executors.newSingleThreadExecutor();
        }
        this.d.execute(new 1(this, sb4, str5, str));
    }

    private String v(int i, Object... objArr) {
        if (objArr == null) {
            return "Log with null object.";
        }
        if (objArr.length == 1) {
            Object obj = objArr[0];
            String obj2 = obj != null ? obj.toString() : "null";
            return i == 32 ? k(obj2) : i == 48 ? l(obj2) : obj2;
        }
        StringBuilder sb = new StringBuilder();
        int length = objArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            Object obj3 = objArr[i2];
            sb.append("args");
            sb.append("[");
            sb.append(i2);
            sb.append("]");
            sb.append(" = ");
            sb.append(obj3 == null ? "null" : obj3.toString());
            sb.append(q);
        }
        return sb.toString();
    }

    private String[] w(String str) {
        if (a.b(this.m) || a.c(this.m)) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[this.n + 5];
            String className = stackTraceElement.getClassName();
            String[] split = className.split("\\.");
            if (split.length > 0) {
                className = split[split.length - 1];
            }
            if (className.contains("$")) {
                className = className.split("\\$")[0];
            }
            if (a.b(this.m) && p(str)) {
                str = className;
            }
            if (a.c(this.m)) {
                String formatter = new Formatter().format("%s, %s(%s.java:%d)", Thread.currentThread().getName(), stackTraceElement.getMethodName(), className, Integer.valueOf(stackTraceElement.getLineNumber())).toString();
                return new String[]{str, formatter + q, " [" + formatter + "]: "};
            }
        } else {
            str = a.h(this.m);
        }
        return new String[]{str, "", ": "};
    }

    public void A(String str, Object... objArr) {
        r(5, str, objArr);
    }

    public void g(Object obj) {
        r(3, a.h(this.m), obj);
    }

    public void h(String str, Object... objArr) {
        r(3, str, objArr);
    }

    public void i(Object obj) {
        r(6, a.h(this.m), obj);
    }

    public void j(String str, Object... objArr) {
        r(6, str, objArr);
    }

    public a m() {
        return this.m;
    }

    public void n(Object obj) {
        r(4, a.h(this.m), obj);
    }

    public void o(String str, Object... objArr) {
        r(4, str, objArr);
    }

    public void q(String str, String str2) {
        r(35, str, str2);
    }

    public void x(int i) {
        this.n = i;
    }

    public void y(String str, Object... objArr) {
        r(2, str, objArr);
    }

    public void z(Object obj) {
        r(5, a.h(this.m), obj);
    }
}
