package com.bytedance.sdk.openadsdk.multipro;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.dx;
import com.bytedance.sdk.component.utils.sU;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class TKC {
    private static boolean Sj = true;
    private static final AtomicBoolean sP = new AtomicBoolean(false);

    public static void Sj() {
        Sj = false;
    }

    public static void Sj(Context context) {
        if (context != null && Sj && sP.compareAndSet(false, true)) {
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    if (dx.Sj(context)) {
                        sP(context);
                        return;
                    }
                    String sP2 = dx.sP(context);
                    try {
                        if (TextUtils.isEmpty(sP2)) {
                            sP2 = context.getPackageName() + Process.myPid();
                        }
                        WebView.setDataDirectorySuffix(sP2);
                    } catch (IllegalStateException unused) {
                        Sj(sP2);
                    } catch (Exception unused2) {
                    }
                }
            } catch (Throwable th) {
                sU.sP(th.getMessage(), new Object[0]);
            }
        }
    }

    private static void Sj(File file) {
        Sj(file, file.exists() ? file.delete() : false);
    }

    private static void Sj(File file, boolean z) {
        if (!z || file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            sU.sP("TTAD.TTMultiInitHelper", e.getMessage());
        }
    }

    private static void Sj(String str) {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            declaredMethod2.setAccessible(true);
            Class cls = (Class) declaredMethod.invoke(null, "android.webkit.WebViewFactory");
            Field field = (Field) declaredMethod2.invoke(cls, "sDataDirectorySuffix");
            field.setAccessible(true);
            if (TextUtils.isEmpty((String) field.get(cls))) {
                field.set(cls, str);
            }
        } catch (Throwable unused) {
        }
    }

    private static String sP() {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            declaredMethod2.setAccessible(true);
            Class cls = (Class) declaredMethod.invoke(null, "android.webkit.WebViewFactory");
            return (String) ((Field) declaredMethod2.invoke(cls, "sDataDirectorySuffix")).get(cls);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void sP(Context context) {
        RandomAccessFile randomAccessFile;
        FileChannel fileChannel;
        Throwable th;
        String sP2 = sP();
        File file = new File(context.getDir(TextUtils.isEmpty(sP2) ? "webview" : "webview_".concat(String.valueOf(sP2)), 0).getPath(), "webview_data.lock");
        file.getAbsolutePath();
        if (!file.exists()) {
            return;
        }
        FileChannel fileChannel2 = null;
        FileLock tryLock = null;
        fileChannel2 = null;
        fileChannel2 = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                try {
                    fileChannel = randomAccessFile.getChannel();
                    if (fileChannel != null) {
                        try {
                            tryLock = fileChannel.tryLock();
                        } catch (Exception unused) {
                            fileChannel2 = fileChannel;
                            Sj(file);
                            if (fileChannel2 != null) {
                                try {
                                    fileChannel2.close();
                                } catch (Throwable th2) {
                                    th2.getMessage();
                                }
                            }
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                    return;
                                } catch (Throwable th3) {
                                    th3.getMessage();
                                    return;
                                }
                            }
                            return;
                        } catch (Throwable th4) {
                            th = th4;
                            if (fileChannel != null) {
                            }
                            if (randomAccessFile == null) {
                            }
                        }
                    }
                    if (tryLock != null) {
                        tryLock.close();
                    } else {
                        Sj(file);
                    }
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (Throwable th5) {
                            th5.getMessage();
                        }
                    }
                    try {
                        randomAccessFile.close();
                    } catch (Throwable th6) {
                        th6.getMessage();
                    }
                } catch (Exception unused2) {
                }
            } catch (Throwable th7) {
                th = th7;
                fileChannel = fileChannel2;
                th = th;
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (Throwable th8) {
                        th8.getMessage();
                    }
                }
                if (randomAccessFile == null) {
                    throw th;
                }
                try {
                    randomAccessFile.close();
                    throw th;
                } catch (Throwable th9) {
                    th9.getMessage();
                    throw th;
                }
            }
        } catch (Exception unused3) {
            randomAccessFile = null;
        } catch (Throwable th10) {
            th = th10;
            randomAccessFile = null;
            fileChannel = null;
            th = th;
            if (fileChannel != null) {
            }
            if (randomAccessFile == null) {
            }
        }
    }
}
