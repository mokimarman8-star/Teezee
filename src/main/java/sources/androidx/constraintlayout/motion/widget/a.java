package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import android.view.View;
import java.nio.CharBuffer;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class a {
    public static String a() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName() + "()";
    }

    public static String b() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")";
    }

    public static String c(Context context, int i5) {
        if (i5 == -1) {
            return "UNKNOWN";
        }
        try {
            return context.getResources().getResourceEntryName(i5);
        } catch (Exception unused) {
            return "?" + i5;
        }
    }

    public static String d(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return "UNKNOWN";
        }
    }

    public static String e(MotionLayout motionLayout, int i5) {
        return f(motionLayout, i5, -1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String f(MotionLayout motionLayout, int i5, int i6) {
        int length;
        if (i5 == -1) {
            return "UNDEFINED";
        }
        String resourceEntryName = motionLayout.getContext().getResources().getResourceEntryName(i5);
        if (i6 == -1) {
            return resourceEntryName;
        }
        if (resourceEntryName.length() > i6) {
            resourceEntryName = resourceEntryName.replaceAll("([^_])[aeiou]+", "$1");
        }
        if (resourceEntryName.length() <= i6 || (length = resourceEntryName.replaceAll("[^_]", "").length()) <= 0) {
            return resourceEntryName;
        }
        return resourceEntryName.replaceAll(CharBuffer.allocate((resourceEntryName.length() - i6) / length).toString().replace((char) 0, '.') + "_", "_");
    }

    public static void g(String str, String str2, int i5) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int min = Math.min(i5, stackTrace.length - 1);
        String str3 = " ";
        for (int i6 = 1; i6 <= min; i6++) {
            StackTraceElement stackTraceElement = stackTrace[i6];
            str3 = str3 + " ";
            Log.v(str, str2 + str3 + (".(" + stackTrace[i6].getFileName() + ":" + stackTrace[i6].getLineNumber() + ") " + stackTrace[i6].getMethodName()) + str3);
        }
    }
}
