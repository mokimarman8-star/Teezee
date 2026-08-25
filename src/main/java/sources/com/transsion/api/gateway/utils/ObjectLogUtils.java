package com.transsion.api.gateway.utils;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Field;
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
import org.mvel2.ast.ASTNode;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class ObjectLogUtils {
    public static final int A = 7;
    public static final int D = 3;
    public static final int E = 6;
    public static final int I = 4;
    public static final int V = 2;
    public static final int W = 5;
    private final String ARGS;
    private final String BOTTOM_BORDER;
    private final int FILE;
    private final Format FORMAT;
    private final int JSON;
    private final String LEFT_BORDER;
    private final int MAX_LEN;
    private final String NULL;
    private final String NULL_TIPS;
    private final String TOP_BORDER;
    private final int XML;
    public Builder builder;
    private ExecutorService executor;
    private int invokeLayer;
    private static final char[] T = {'V', 'D', 'I', 'W', 'E', 'A'};
    private static final String FILE_SEP = System.getProperty("file.separator");
    private static final String LINE_SEP = System.getProperty("line.separator");

    public static class Builder {
        private String defaultDir;
        private String dir;
        private boolean sLogSwitch = false;
        private boolean sLog2ConsoleSwitch = true;
        private String sGlobalTag = null;
        private boolean sTagIsSpace = true;
        private boolean sLogHeadSwitch = true;
        private boolean sLog2FileSwitch = false;
        private boolean sLogBorderSwitch = true;
        private int sConsoleFilter = 2;
        private int sFileFilter = 2;

        public ObjectLogUtils create() {
            return new ObjectLogUtils(this);
        }

        public Builder setBorderSwitch(boolean z) {
            this.sLogBorderSwitch = z;
            return this;
        }

        public Builder setConsoleFilter(int i) {
            this.sConsoleFilter = i;
            return this;
        }

        public Builder setConsoleSwitch(boolean z) {
            this.sLog2ConsoleSwitch = z;
            return this;
        }

        public Builder setDir(File file) {
            String str;
            if (file == null) {
                str = null;
            } else {
                str = file.getAbsolutePath() + ObjectLogUtils.FILE_SEP;
            }
            this.dir = str;
            return this;
        }

        public Builder setDir(String str) {
            if (ObjectLogUtils.isSpace(str)) {
                this.dir = null;
            } else {
                if (!str.endsWith(ObjectLogUtils.FILE_SEP)) {
                    str = str + ObjectLogUtils.FILE_SEP;
                }
                this.dir = str;
            }
            return this;
        }

        public Builder setFileFilter(int i) {
            this.sFileFilter = i;
            return this;
        }

        public Builder setGlobalTag(String str) {
            if (ObjectLogUtils.isSpace(str)) {
                this.sGlobalTag = "";
                this.sTagIsSpace = true;
            } else {
                this.sGlobalTag = str;
                this.sTagIsSpace = false;
            }
            return this;
        }

        public Builder setLog2FileSwitch(boolean z) {
            this.sLog2FileSwitch = z;
            return this;
        }

        public Builder setLogHeadSwitch(boolean z) {
            this.sLogHeadSwitch = z;
            return this;
        }

        public Builder setLogSwitch(boolean z) {
            this.sLogSwitch = z;
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("switch: ");
            sb.append(this.sLogSwitch);
            sb.append(ObjectLogUtils.LINE_SEP);
            sb.append("console: ");
            sb.append(this.sLog2ConsoleSwitch);
            sb.append(ObjectLogUtils.LINE_SEP);
            sb.append("tag: ");
            sb.append(this.sTagIsSpace ? "null" : this.sGlobalTag);
            sb.append(ObjectLogUtils.LINE_SEP);
            sb.append("head: ");
            sb.append(this.sLogHeadSwitch);
            sb.append(ObjectLogUtils.LINE_SEP);
            sb.append("file: ");
            sb.append(this.sLog2FileSwitch);
            sb.append(ObjectLogUtils.LINE_SEP);
            sb.append("dir: ");
            String str = this.dir;
            if (str == null) {
                str = this.defaultDir;
            }
            sb.append(str);
            sb.append(ObjectLogUtils.LINE_SEP);
            sb.append("border: ");
            sb.append(this.sLogBorderSwitch);
            sb.append(ObjectLogUtils.LINE_SEP);
            sb.append("consoleFilter: ");
            sb.append(ObjectLogUtils.T[this.sConsoleFilter - 2]);
            sb.append(ObjectLogUtils.LINE_SEP);
            sb.append("fileFilter: ");
            sb.append(ObjectLogUtils.T[this.sFileFilter - 2]);
            return sb.toString();
        }
    }

    private ObjectLogUtils(Builder builder) {
        this.FILE = 16;
        this.JSON = 32;
        this.XML = 48;
        this.TOP_BORDER = "|---------------------------------------------------------------------------------------------------";
        this.LEFT_BORDER = "| ";
        this.BOTTOM_BORDER = "|---------------------------------------------------------------------------------------------------";
        this.MAX_LEN = 4000;
        this.FORMAT = new SimpleDateFormat("MM-dd HH:mm:ss.SSS ", Locale.getDefault());
        this.NULL_TIPS = "Log with null object.";
        this.NULL = "null";
        this.ARGS = "args";
        new Builder();
        this.invokeLayer = 0;
        this.builder = builder;
    }

    private String addLeftBorder(String str) {
        if (!this.builder.sLogBorderSwitch) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : str.split(LINE_SEP)) {
            sb.append("| ");
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
            byte[] bArr2 = new byte[ASTNode.BLOCK_IF];
            while (!deflater.finished()) {
                byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
            }
            deflater.end();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            deflater.end();
            throw th;
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

    private String formatXml(String str) {
        try {
            StreamSource streamSource = new StreamSource(new StringReader(str));
            StreamResult streamResult = new StreamResult(new StringWriter());
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("indent", "yes");
            newTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            newTransformer.transform(streamSource, streamResult);
            return streamResult.getWriter().toString().replaceFirst(">", ">" + LINE_SEP);
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static File getExternalCacheDir(Context context) {
        boolean z = true;
        try {
            Field declaredField = Environment.class.getDeclaredField("sUserRequired");
            declaredField.setAccessible(true);
            z = declaredField.getBoolean(new Environment());
        } catch (Exception unused) {
        }
        if (!z) {
            try {
                return context.getExternalCacheDir();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
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

    private void log(int i, String str, Object... objArr) {
        if (!Log.isLoggable(str.length() > 23 ? str.substring(0, 23) : str, 3)) {
            if (!this.builder.sLogSwitch) {
                return;
            }
            if (!this.builder.sLog2ConsoleSwitch && !this.builder.sLog2FileSwitch) {
                return;
            }
        }
        int i2 = i & 15;
        int i3 = i & 240;
        if (i2 >= this.builder.sConsoleFilter || i2 >= this.builder.sFileFilter) {
            String[] processTagAndHead = processTagAndHead(str);
            String processBody = processBody(i3, objArr);
            if (this.builder.sLog2ConsoleSwitch && i2 >= this.builder.sConsoleFilter) {
                print2Console(i2, processTagAndHead[0], processTagAndHead[1], processBody);
            }
            if ((this.builder.sLog2FileSwitch || i3 == 16) && i2 >= this.builder.sFileFilter) {
                print2File(i2, processTagAndHead[0], processTagAndHead[2] + processBody);
            }
        }
    }

    private static void print(int i, String str, String str2) {
        Log.println(i, str, str2);
    }

    private void print2Console(int i, String str, String str2, String str3) {
        if (this.builder.sLogHeadSwitch) {
            print(i, str, "\n" + str2);
        } else {
            print(i, str, " \n");
        }
        if (this.builder.sLogBorderSwitch) {
            print(i, str, "|---------------------------------------------------------------------------------------------------");
            str3 = addLeftBorder(str3);
        }
        int length = str3.length();
        int i2 = length / 4000;
        if (i2 > 0) {
            int i3 = 4000;
            print(i, str, str3.substring(0, 4000));
            int i4 = 1;
            while (i4 < i2) {
                int i6 = i3 + 4000;
                String substring = str3.substring(i3, i6);
                if (this.builder.sLogBorderSwitch) {
                    substring = "| " + substring;
                }
                print(i, str, substring);
                i4++;
                i3 = i6;
            }
            String substring2 = str3.substring(i3, length);
            if (this.builder.sLogBorderSwitch) {
                substring2 = "| " + substring2;
            }
            print(i, str, substring2);
        } else {
            print(i, str, str3);
        }
        if (this.builder.sLogBorderSwitch) {
            print(i, str, "|---------------------------------------------------------------------------------------------------");
        }
    }

    private void print2File(int i, String str, String str2) {
        String format = this.FORMAT.format(new Date(System.currentTimeMillis()));
        String substring = format.substring(0, 5);
        String substring2 = format.substring(6);
        if (this.builder.defaultDir == null) {
            if (!"mounted".equals(Environment.getExternalStorageState()) || getExternalCacheDir(ContextUtils.getContext()) == null) {
                Builder builder = this.builder;
                StringBuilder sb = new StringBuilder();
                sb.append(ContextUtils.getContext().getCacheDir());
                String str3 = FILE_SEP;
                sb.append(str3);
                sb.append("log");
                sb.append(str3);
                builder.defaultDir = sb.toString();
            } else {
                Builder builder2 = this.builder;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(getExternalCacheDir(ContextUtils.getContext()));
                String str4 = FILE_SEP;
                sb2.append(str4);
                sb2.append("log");
                sb2.append(str4);
                builder2.defaultDir = sb2.toString();
            }
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(this.builder.dir == null ? this.builder.defaultDir : this.builder.dir);
        sb3.append(substring);
        sb3.append(".txt");
        String sb4 = sb3.toString();
        if (!createOrExistsFile(sb4)) {
            Log.e(str, "log to " + sb4 + " failed!");
            return;
        }
        String str5 = substring2 + T[i - 2] + "/" + str + str2 + LINE_SEP;
        if (this.executor == null) {
            this.executor = Executors.newSingleThreadExecutor();
        }
        this.executor.execute(new 1(this, sb4, str5, str));
    }

    private String processBody(int i, Object... objArr) {
        if (objArr == null) {
            return "Log with null object.";
        }
        if (objArr.length == 1) {
            Object obj = objArr[0];
            String obj2 = obj != null ? obj.toString() : "null";
            return i == 32 ? formatJson(obj2) : i == 48 ? formatXml(obj2) : obj2;
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
            sb.append(LINE_SEP);
        }
        return sb.toString();
    }

    private String[] processTagAndHead(String str) {
        if (this.builder.sTagIsSpace || this.builder.sLogHeadSwitch) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[this.invokeLayer + 5];
            String className = stackTraceElement.getClassName();
            String[] split = className.split("\\.");
            if (split.length > 0) {
                className = split[split.length - 1];
            }
            if (className.contains("$")) {
                className = className.split("\\$")[0];
            }
            if (this.builder.sTagIsSpace && isSpace(str)) {
                str = className;
            }
            if (this.builder.sLogHeadSwitch) {
                String formatter = new Formatter().format("%s, %s(%s.java:%d)", Thread.currentThread().getName(), stackTraceElement.getMethodName(), className, Integer.valueOf(stackTraceElement.getLineNumber())).toString();
                return new String[]{str, formatter + LINE_SEP, " [" + formatter + "]: "};
            }
        } else {
            str = this.builder.sGlobalTag;
        }
        return new String[]{str, "", ": "};
    }

    public static byte[] uncompress(byte[] bArr) {
        int i;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Inflater inflater = new Inflater();
        try {
            inflater.setInput(bArr);
            byte[] bArr2 = new byte[ASTNode.BLOCK_IF];
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
        } catch (Throwable th) {
            inflater.end();
            throw th;
        }
    }

    public void a(Object obj) {
        log(7, this.builder.sGlobalTag, obj);
    }

    public void a(String str, Object... objArr) {
        log(7, str, objArr);
    }

    public void d(Object obj) {
        log(3, this.builder.sGlobalTag, obj);
    }

    public void d(String str, Object... objArr) {
        log(3, str, objArr);
    }

    public void e(Object obj) {
        log(6, this.builder.sGlobalTag, obj);
    }

    public void e(String str, Object... objArr) {
        log(6, str, objArr);
    }

    public void file(int i, Object obj) {
        log(i | 16, this.builder.sGlobalTag, obj);
    }

    public void file(int i, String str, Object obj) {
        log(i | 16, str, obj);
    }

    public void file(Object obj) {
        log(19, this.builder.sGlobalTag, obj);
    }

    public void file(String str, Object obj) {
        log(19, str, obj);
    }

    public Builder getBuilder() {
        return this.builder;
    }

    public void i(Object obj) {
        log(4, this.builder.sGlobalTag, obj);
    }

    public void i(String str, Object... objArr) {
        log(4, str, objArr);
    }

    public void json(int i, String str) {
        log(i | 32, this.builder.sGlobalTag, str);
    }

    public void json(int i, String str, String str2) {
        log(i | 32, str, str2);
    }

    public void json(String str) {
        log(35, this.builder.sGlobalTag, str);
    }

    public void json(String str, String str2) {
        log(35, str, str2);
    }

    public void setInvokeLayer(int i) {
        this.invokeLayer = i;
    }

    public void v(Object obj) {
        log(2, this.builder.sGlobalTag, obj);
    }

    public void v(String str, Object... objArr) {
        log(2, str, objArr);
    }

    public void w(Object obj) {
        log(5, this.builder.sGlobalTag, obj);
    }

    public void w(String str, Object... objArr) {
        log(5, str, objArr);
    }

    public void xml(int i, String str) {
        log(i | 48, this.builder.sGlobalTag, str);
    }

    public void xml(int i, String str, String str2) {
        log(i | 48, str, str2);
    }

    public void xml(String str) {
        log(51, this.builder.sGlobalTag, str);
    }

    public void xml(String str, String str2) {
        log(51, str, str2);
    }
}
