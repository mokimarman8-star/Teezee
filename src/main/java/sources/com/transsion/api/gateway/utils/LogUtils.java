package com.transsion.api.gateway.utils;

import android.util.Log;
import com.transsion.gslb.BuildConfig;
import com.transsion.push.bean.MsgStyle;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class LogUtils {
    public static final int A = 7;
    private static final String ARGS = "args";
    private static final String BOTTOM_BORDER = "|---------------------------------------------------------------------------------------------------";
    public static final int D = 3;
    public static final int E = 6;
    private static final int FILE = 16;
    public static final int I = 4;
    private static final int JSON = 32;
    private static final String LEFT_BORDER = "| ";
    private static final int MAX_LEN = 4000;
    private static final String NULL = "null";
    private static final String NULL_TIPS = "Log with null object.";
    private static final String TOP_BORDER = "|---------------------------------------------------------------------------------------------------";
    public static final int V = 2;
    public static final int W = 5;
    private static final int XML = 48;
    private static String defaultDir = null;
    private static String dir = null;
    private static ExecutorService executor = null;
    private static int sConsoleFilter = 2;
    private static int sFileFilter = 2;
    private static String sGlobalTag = "TAG";
    private static boolean sLog2ConsoleSwitch = true;
    private static boolean sLog2FileSwitch = false;
    private static boolean sLogBorderSwitch = true;
    private static boolean sLogHeadSwitch = true;
    private static boolean sLogSwitch = false;
    private static boolean sTagIsSpace = true;
    private static final char[] T = {'V', 'D', 'I', 'W', 'E', 'A'};
    private static final String FILE_SEP = System.getProperty("file.separator");
    private static final String LINE_SEP = System.getProperty("line.separator");
    private static final Format FORMAT = new SimpleDateFormat("MM-dd HH:mm:ss.SSS ", Locale.getDefault());

    public static class Builder {
        public Builder setBorderSwitch(boolean z) {
            boolean unused = LogUtils.sLogBorderSwitch = z;
            return this;
        }

        public Builder setConsoleFilter(int i) {
            int unused = LogUtils.sConsoleFilter = i;
            return this;
        }

        public Builder setConsoleSwitch(boolean z) {
            boolean unused = LogUtils.sLog2ConsoleSwitch = z;
            return this;
        }

        public Builder setDir(File file) {
            String str;
            if (file == null) {
                str = null;
            } else {
                str = file.getAbsolutePath() + LogUtils.FILE_SEP;
            }
            String unused = LogUtils.dir = str;
            return this;
        }

        public Builder setDir(String str) {
            if (LogUtils.isSpace(str)) {
                String unused = LogUtils.dir = null;
            } else {
                if (!str.endsWith(LogUtils.FILE_SEP)) {
                    str = str + LogUtils.FILE_SEP;
                }
                String unused2 = LogUtils.dir = str;
            }
            return this;
        }

        public Builder setFileFilter(int i) {
            int unused = LogUtils.sFileFilter = i;
            return this;
        }

        public Builder setGlobalTag(String str) {
            if (LogUtils.isSpace(str)) {
                String unused = LogUtils.sGlobalTag = BuildConfig.FLAVOR;
                boolean unused2 = LogUtils.sTagIsSpace = true;
            } else {
                String unused3 = LogUtils.sGlobalTag = str;
                boolean unused4 = LogUtils.sTagIsSpace = false;
            }
            return this;
        }

        public Builder setLog2FileSwitch(boolean z) {
            boolean unused = LogUtils.sLog2FileSwitch = z;
            return this;
        }

        public Builder setLogHeadSwitch(boolean z) {
            boolean unused = LogUtils.sLogHeadSwitch = z;
            return this;
        }

        public Builder setLogSwitch(boolean z) {
            boolean unused = LogUtils.sLogSwitch = z;
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("switch: ");
            sb.append(LogUtils.sLogSwitch);
            sb.append(LogUtils.LINE_SEP);
            sb.append("console: ");
            sb.append(LogUtils.sLog2ConsoleSwitch);
            sb.append(LogUtils.LINE_SEP);
            sb.append("tag: ");
            sb.append(LogUtils.sTagIsSpace ? LogUtils.NULL : LogUtils.sGlobalTag);
            sb.append(LogUtils.LINE_SEP);
            sb.append("head: ");
            sb.append(LogUtils.sLogHeadSwitch);
            sb.append(LogUtils.LINE_SEP);
            sb.append("file: ");
            sb.append(LogUtils.sLog2FileSwitch);
            sb.append(LogUtils.LINE_SEP);
            sb.append("dir: ");
            sb.append(LogUtils.dir == null ? LogUtils.defaultDir : LogUtils.dir);
            sb.append(LogUtils.LINE_SEP);
            sb.append("border: ");
            sb.append(LogUtils.sLogBorderSwitch);
            sb.append(LogUtils.LINE_SEP);
            sb.append("consoleFilter: ");
            sb.append(LogUtils.T[LogUtils.sConsoleFilter - 2]);
            sb.append(LogUtils.LINE_SEP);
            sb.append("fileFilter: ");
            sb.append(LogUtils.T[LogUtils.sFileFilter - 2]);
            return sb.toString();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TYPE {
    }

    private LogUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void a(Object obj) {
        log(7, sGlobalTag, obj);
    }

    public static void a(String str, Object... objArr) {
        log(7, str, objArr);
    }

    private static String addLeftBorder(String str) {
        if (!sLogBorderSwitch) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : str.split(LINE_SEP)) {
            sb.append(LEFT_BORDER);
            sb.append(str2);
            sb.append(LINE_SEP);
        }
        return sb.toString();
    }

    public static byte[] compress(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Deflater deflater = new Deflater(1);
        try {
            deflater.setInput(bArr);
            deflater.finish();
            byte[] bArr2 = new byte[2048];
            while (!deflater.finished()) {
                byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
            }
            deflater.end();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            deflater.end();
            throw th2;
        }
    }

    private static boolean createOrExistsDir(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    private static boolean createOrExistsFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.isFile();
        }
        if (!createOrExistsDir(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void d(Object obj) {
        log(3, sGlobalTag, obj);
    }

    public static void d(String str, Object... objArr) {
        log(3, str, objArr);
    }

    public static void e(Object obj) {
        log(6, sGlobalTag, obj);
    }

    public static void e(String str, Object... objArr) {
        log(6, str, objArr);
    }

    public static void file(int i, Object obj) {
        log(i | 16, sGlobalTag, obj);
    }

    public static void file(int i, String str, Object obj) {
        log(i | 16, str, obj);
    }

    public static void file(Object obj) {
        log(19, sGlobalTag, obj);
    }

    public static void file(String str, Object obj) {
        log(19, str, obj);
    }

    private static String formatJson(String str) {
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

    private static String formatXml(String str) {
        try {
            StreamSource streamSource = new StreamSource(new StringReader(str));
            StreamResult streamResult = new StreamResult(new StringWriter());
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("indent", "yes");
            newTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", MsgStyle.CUSTOM_BUTTON);
            newTransformer.transform(streamSource, streamResult);
            return streamResult.getWriter().toString().replaceFirst(">", ">" + LINE_SEP);
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static void i(Object obj) {
        log(4, sGlobalTag, obj);
    }

    public static void i(String str, Object... objArr) {
        log(4, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isSpace(String str) {
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

    public static void json(int i, String str) {
        log(i | JSON, sGlobalTag, str);
    }

    public static void json(int i, String str, String str2) {
        log(i | JSON, str, str2);
    }

    public static void json(String str) {
        log(35, sGlobalTag, str);
    }

    public static void json(String str, String str2) {
        log(35, str, str2);
    }

    private static void log(int i, String str, Object... objArr) {
        if (!Log.isLoggable(str.length() > 23 ? str.substring(0, 23) : str, 3)) {
            if (!sLogSwitch) {
                return;
            }
            if (!sLog2ConsoleSwitch && !sLog2FileSwitch) {
                return;
            }
        }
        int i2 = i & 15;
        int i3 = i & 240;
        if (i2 >= sConsoleFilter || i2 >= sFileFilter) {
            String[] processTagAndHead = processTagAndHead(str);
            String processBody = processBody(i3, objArr);
            if (sLog2ConsoleSwitch && i2 >= sConsoleFilter) {
                print2Console(i2, processTagAndHead[0], processTagAndHead[1], processBody);
            }
            if ((sLog2FileSwitch || i3 == 16) && i2 >= sFileFilter) {
                print2File(i2, processTagAndHead[0], processTagAndHead[2] + processBody);
            }
        }
    }

    private static void print(int i, String str, String str2) {
        Log.println(i, str, str2);
    }

    private static void print2Console(int i, String str, String str2, String str3) {
        if (sLogHeadSwitch) {
            print(i, str, "\n" + str2);
        } else {
            print(i, str, " \n");
        }
        if (sLogBorderSwitch) {
            print(i, str, "|---------------------------------------------------------------------------------------------------");
            str3 = addLeftBorder(str3);
        }
        int length = str3.length();
        int i2 = length / MAX_LEN;
        if (i2 > 0) {
            int i3 = MAX_LEN;
            print(i, str, str3.substring(0, MAX_LEN));
            int i4 = 1;
            while (i4 < i2) {
                int i5 = i3 + MAX_LEN;
                String substring = str3.substring(i3, i5);
                if (sLogBorderSwitch) {
                    substring = LEFT_BORDER + substring;
                }
                print(i, str, substring);
                i4++;
                i3 = i5;
            }
            String substring2 = str3.substring(i3, length);
            if (sLogBorderSwitch) {
                substring2 = LEFT_BORDER + substring2;
            }
            print(i, str, substring2);
        } else {
            print(i, str, str3);
        }
        if (sLogBorderSwitch) {
            print(i, str, "|---------------------------------------------------------------------------------------------------");
        }
    }

    private static void print2File(int i, final String str, String str2) {
        String format = FORMAT.format(new Date(System.currentTimeMillis()));
        String substring = format.substring(0, 5);
        String substring2 = format.substring(6);
        StringBuilder sb = new StringBuilder();
        String str3 = dir;
        if (str3 == null) {
            str3 = defaultDir;
        }
        sb.append(str3);
        sb.append(substring);
        sb.append(".txt");
        final String sb2 = sb.toString();
        if (!createOrExistsFile(sb2)) {
            Log.e(str, "log to " + sb2 + " failed!");
            return;
        }
        final String str4 = substring2 + T[i - 2] + "/" + str + str2 + LINE_SEP;
        if (executor == null) {
            executor = Executors.newSingleThreadExecutor();
        }
        executor.execute(new Runnable() { // from class: com.transsion.api.gateway.utils.LogUtils.1
            /* JADX WARN: Removed duplicated region for block: B:22:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                BufferedWriter bufferedWriter;
                IOException e;
                BufferedWriter bufferedWriter2 = null;
                try {
                    try {
                        bufferedWriter = new BufferedWriter(new FileWriter(sb2, true));
                        try {
                            try {
                                bufferedWriter.write(str4);
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("log to ");
                                sb3.append(sb2);
                                sb3.append(" success!");
                                bufferedWriter.close();
                            } catch (IOException e2) {
                                e = e2;
                                e.printStackTrace();
                                Log.e(str, "log to " + sb2 + " failed!");
                                if (bufferedWriter != null) {
                                    bufferedWriter.close();
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedWriter2 = bufferedWriter;
                            if (bufferedWriter2 != null) {
                                try {
                                    bufferedWriter2.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                } catch (IOException e5) {
                    bufferedWriter = null;
                    e = e5;
                } catch (Throwable th3) {
                    th = th3;
                    if (bufferedWriter2 != null) {
                    }
                    throw th;
                }
            }
        });
    }

    private static String processBody(int i, Object... objArr) {
        if (objArr == null) {
            return NULL_TIPS;
        }
        int length = objArr.length;
        String str = NULL;
        if (length == 1) {
            Object obj = objArr[0];
            if (obj != null) {
                str = obj.toString();
            }
            return i == JSON ? formatJson(str) : i == XML ? formatXml(str) : str;
        }
        StringBuilder sb = new StringBuilder();
        int length2 = objArr.length;
        for (int i2 = 0; i2 < length2; i2++) {
            Object obj2 = objArr[i2];
            sb.append(ARGS);
            sb.append("[");
            sb.append(i2);
            sb.append("]");
            sb.append(" = ");
            sb.append(obj2 == null ? NULL : obj2.toString());
            sb.append(LINE_SEP);
        }
        return sb.toString();
    }

    private static String[] processTagAndHead(String str) {
        if (sTagIsSpace || sLogHeadSwitch) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[5];
            String className = stackTraceElement.getClassName();
            String[] split = className.split("\\.");
            if (split.length > 0) {
                className = split[split.length - 1];
            }
            if (className.contains("$")) {
                className = className.split("\\$")[0];
            }
            if (sTagIsSpace && isSpace(str)) {
                str = className;
            }
            if (sLogHeadSwitch) {
                String formatter = new Formatter().format("%s, %s(%s.java:%d)", Thread.currentThread().getName(), stackTraceElement.getMethodName(), className, Integer.valueOf(stackTraceElement.getLineNumber())).toString();
                return new String[]{str, formatter + LINE_SEP, " [" + formatter + "]: "};
            }
        } else {
            str = sGlobalTag;
        }
        return new String[]{str, BuildConfig.FLAVOR, ": "};
    }

    public static byte[] uncompress(byte[] bArr) {
        int i;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Inflater inflater = new Inflater();
        try {
            inflater.setInput(bArr);
            byte[] bArr2 = new byte[2048];
            while (!inflater.finished()) {
                try {
                    i = inflater.inflate(bArr2);
                } catch (DataFormatException e) {
                    e.printStackTrace();
                    i = 0;
                }
                byteArrayOutputStream.write(bArr2, 0, i);
            }
            inflater.end();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            inflater.end();
            throw th2;
        }
    }

    public static void v(Object obj) {
        log(2, sGlobalTag, obj);
    }

    public static void v(String str, Object... objArr) {
        log(2, str, objArr);
    }

    public static void w(Object obj) {
        log(5, sGlobalTag, obj);
    }

    public static void w(String str, Object... objArr) {
        log(5, str, objArr);
    }

    public static void xml(int i, String str) {
        log(i | XML, sGlobalTag, str);
    }

    public static void xml(int i, String str, String str2) {
        log(i | XML, str, str2);
    }

    public static void xml(String str) {
        log(51, sGlobalTag, str);
    }

    public static void xml(String str, String str2) {
        log(51, str, str2);
    }
}
