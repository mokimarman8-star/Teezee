package com.bytedance.sdk.component;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Sj {
    private static ArrayMap<File, Sj> Fmk;
    protected static InterfaceC0042Sj Sj;
    private static ArrayMap<String, File> aa;
    private static boolean sP;
    private long Dq;
    private final Object EjP;
    private Properties HiB;
    private int Jcg;
    private final File TEQ;
    private final Object TKC;
    private final File Ym;
    private long uA;
    private volatile boolean vS;

    /* renamed from: com.bytedance.sdk.component.Sj$Sj, reason: collision with other inner class name */
    public interface InterfaceC0042Sj {
        ExecutorService getExecutorService();

        HandlerThread getSafeHandlerThread(String str, int i);
    }

    public class TKC implements SharedPreferences.Editor {
        private final Object sP = new Object();
        private final Map<String, Object> TKC = new HashMap();
        private boolean EjP = false;

        public TKC() {
        }

        private sP sP() {
            Properties properties;
            long j;
            Object obj;
            boolean z;
            synchronized (Sj.this.TKC) {
                try {
                    if (Sj.this.Jcg > 0) {
                        Properties properties2 = new Properties();
                        properties2.putAll(Sj.this.HiB);
                        Sj.this.HiB = properties2;
                    }
                    properties = Sj.this.HiB;
                    Sj.HiB(Sj.this);
                    synchronized (this.sP) {
                        try {
                            boolean z2 = false;
                            if (this.EjP) {
                                if (properties.isEmpty()) {
                                    z = false;
                                } else {
                                    properties.clear();
                                    z = true;
                                }
                                this.EjP = false;
                                z2 = z;
                            }
                            for (Map.Entry<String, Object> entry : this.TKC.entrySet()) {
                                String key = entry.getKey();
                                Object value = entry.getValue();
                                if (value != this && value != null) {
                                    if (!properties.containsKey(key) || (obj = properties.get(key)) == null || !obj.equals(String.valueOf(value))) {
                                        properties.put(key, String.valueOf(value));
                                        z2 = true;
                                    }
                                }
                                if (properties.containsKey(key)) {
                                    properties.remove(key);
                                    z2 = true;
                                }
                            }
                            this.TKC.clear();
                            if (z2) {
                                Sj.vS(Sj.this);
                            }
                            j = Sj.this.Dq;
                        } finally {
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return new sP(j, properties);
        }

        @Override // android.content.SharedPreferences.Editor
        /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
        public TKC clear() {
            synchronized (this.sP) {
                this.EjP = true;
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
        public TKC remove(String str) {
            synchronized (this.sP) {
                this.TKC.put(str, this);
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
        public TKC putFloat(String str, float f) {
            synchronized (this.sP) {
                this.TKC.put(str, Float.valueOf(f));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
        public TKC putInt(String str, int i) {
            synchronized (this.sP) {
                this.TKC.put(str, Integer.valueOf(i));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
        public TKC putLong(String str, long j) {
            synchronized (this.sP) {
                this.TKC.put(str, Long.valueOf(j));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
        public TKC putString(String str, String str2) {
            synchronized (this.sP) {
                this.TKC.put(str, str2);
            }
            return this;
        }

        public TKC Sj(String str, Set<String> set) {
            synchronized (this.sP) {
                this.TKC.put(str, set == null ? null : new HashSet(set));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
        public TKC putBoolean(String str, boolean z) {
            synchronized (this.sP) {
                this.TKC.put(str, Boolean.valueOf(z));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            Sj.this.Sj(sP(), false);
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            long currentTimeMillis = Sj.sP ? System.currentTimeMillis() : 0L;
            sP sP = sP();
            Sj.this.Sj(sP, true);
            try {
                sP.TKC.await();
                if (Sj.sP) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(Sj.this.TEQ.getName());
                    sb.append(":");
                    sb.append(sP.Sj);
                    sb.append(" committed after ");
                    sb.append(System.currentTimeMillis() - currentTimeMillis);
                    sb.append(" ms");
                }
                return sP.EjP;
            } catch (InterruptedException unused) {
                if (!Sj.sP) {
                    return false;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Sj.this.TEQ.getName());
                sb2.append(":");
                sb2.append(sP.Sj);
                sb2.append(" committed after ");
                sb2.append(System.currentTimeMillis() - currentTimeMillis);
                sb2.append(" ms");
                return false;
            } catch (Throwable th) {
                if (Sj.sP) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(Sj.this.TEQ.getName());
                    sb3.append(":");
                    sb3.append(sP.Sj);
                    sb3.append(" committed after ");
                    sb3.append(System.currentTimeMillis() - currentTimeMillis);
                    sb3.append(" ms");
                }
                throw th;
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public /* synthetic */ SharedPreferences.Editor putStringSet(String str, Set set) {
            return Sj(str, (Set<String>) set);
        }
    }

    private static class sP {
        volatile boolean EjP;
        boolean HiB;
        final long Sj;
        final CountDownLatch TKC;
        final Properties sP;

        private sP(long j, Properties properties) {
            this.TKC = new CountDownLatch(1);
            this.EjP = false;
            this.HiB = false;
            this.Sj = j;
            this.sP = properties;
        }

        void Sj(boolean z, boolean z2) {
            this.HiB = z;
            this.EjP = z2;
            this.TKC.countDown();
        }
    }

    private Sj(File file) {
        Object obj = new Object();
        this.TKC = obj;
        this.EjP = new Object();
        this.HiB = new Properties();
        this.vS = false;
        this.Jcg = 0;
        this.TEQ = file;
        this.Ym = Sj(file);
        synchronized (obj) {
            this.vS = false;
        }
        InterfaceC0042Sj interfaceC0042Sj = Sj;
        if (interfaceC0042Sj == null || interfaceC0042Sj.getExecutorService() == null) {
            new Thread("TTPropHelper") { // from class: com.bytedance.sdk.component.Sj.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Sj.this.Sj();
                }
            }.start();
        } else {
            Sj.getExecutorService().execute(new Runnable() { // from class: com.bytedance.sdk.component.Sj.2
                @Override // java.lang.Runnable
                public void run() {
                    Sj.this.Sj();
                }
            });
        }
    }

    private void EjP() {
        while (!this.vS) {
            try {
                this.TKC.wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    static /* synthetic */ int HiB(Sj sj) {
        int i = sj.Jcg;
        sj.Jcg = i + 1;
        return i;
    }

    public static Sj Sj(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_prop";
        }
        synchronized (Sj.class) {
            try {
                if (aa == null) {
                    aa = new ArrayMap<>();
                }
                File file = aa.get(str);
                if (file == null) {
                    file = new File(context.getFilesDir(), str);
                    aa.put(str, file);
                }
                if (Fmk == null) {
                    Fmk = new ArrayMap<>();
                }
                Sj sj = Fmk.get(file);
                if (sj != null) {
                    return sj;
                }
                Sj sj2 = new Sj(file);
                Fmk.put(file, sj2);
                return sj2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static File Sj(File file) {
        return new File(file.getPath() + ".bak");
    }

    public static void Sj(InterfaceC0042Sj interfaceC0042Sj) {
        Sj = interfaceC0042Sj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sj(final sP sPVar, final boolean z) {
        boolean z2;
        Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.Sj.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (Sj.this.EjP) {
                    try {
                        Sj.this.sP(sPVar, z);
                    } catch (OutOfMemoryError unused) {
                    }
                }
                synchronized (Sj.this.TKC) {
                    Sj.uA(Sj.this);
                }
            }
        };
        if (z) {
            synchronized (this.TKC) {
                z2 = this.Jcg == 1;
            }
            if (z2) {
                runnable.run();
                return;
            }
        }
        com.bytedance.sdk.component.sP.Sj(runnable, true ^ z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0118 A[Catch: all -> 0x011d, TryCatch #9 {all -> 0x011d, blocks: (B:38:0x0090, B:39:0x0092, B:56:0x0114, B:58:0x0118, B:59:0x0121, B:61:0x012a, B:62:0x0132, B:64:0x013e, B:107:0x0181, B:108:0x0182, B:54:0x00de, B:55:0x0113, B:73:0x00e4, B:83:0x010a, B:96:0x0180, B:95:0x0177), top: B:37:0x0090, inners: #2, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x012a A[Catch: all -> 0x011d, TryCatch #9 {all -> 0x011d, blocks: (B:38:0x0090, B:39:0x0092, B:56:0x0114, B:58:0x0118, B:59:0x0121, B:61:0x012a, B:62:0x0132, B:64:0x013e, B:107:0x0181, B:108:0x0182, B:54:0x00de, B:55:0x0113, B:73:0x00e4, B:83:0x010a, B:96:0x0180, B:95:0x0177), top: B:37:0x0090, inners: #2, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x013e A[Catch: all -> 0x011d, TRY_LEAVE, TryCatch #9 {all -> 0x011d, blocks: (B:38:0x0090, B:39:0x0092, B:56:0x0114, B:58:0x0118, B:59:0x0121, B:61:0x012a, B:62:0x0132, B:64:0x013e, B:107:0x0181, B:108:0x0182, B:54:0x00de, B:55:0x0113, B:73:0x00e4, B:83:0x010a, B:96:0x0180, B:95:0x0177), top: B:37:0x0090, inners: #2, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0104 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v15, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v21, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void sP(sP sPVar, boolean z) {
        long j;
        long j2;
        Throwable th;
        long j3;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        boolean z2;
        long currentTimeMillis = sP ? System.currentTimeMillis() : 0L;
        boolean exists = this.TEQ.exists();
        if (sP) {
            j = System.currentTimeMillis();
            j2 = j;
        } else {
            j = 0;
            j2 = 0;
        }
        if (exists) {
            if (this.uA >= sPVar.Sj) {
                z2 = false;
            } else if (z) {
                z2 = true;
            } else {
                synchronized (this.TKC) {
                    z2 = this.Dq == sPVar.Sj;
                }
            }
            if (!z2) {
                sPVar.Sj(false, true);
                return;
            }
            boolean exists2 = this.Ym.exists();
            if (sP) {
                j2 = System.currentTimeMillis();
            }
            if (exists2) {
                this.TEQ.delete();
            } else if (!this.TEQ.renameTo(this.Ym)) {
                Log.e("TTPropHelper", "Couldn't rename file " + this.TEQ + " to backup file " + this.Ym);
                sPVar.Sj(false, false);
                return;
            }
        }
        try {
            synchronized (this.EjP) {
                FileOutputStream fileOutputStream3 = null;
                FileOutputStream fileOutputStream4 = null;
                FileOutputStream fileOutputStream5 = null;
                try {
                    try {
                        FileOutputStream fileOutputStream6 = new FileOutputStream(this.TEQ);
                        try {
                            try {
                                j3 = sP ? System.currentTimeMillis() : 0L;
                                try {
                                    sPVar.sP.store(fileOutputStream6, (String) null);
                                    if (sP) {
                                        new StringBuilder("save: ").append(sPVar.sP);
                                        StringBuilder sb = new StringBuilder("saveToLocal: save to");
                                        sb.append(this.TEQ.getAbsolutePath());
                                        sb.append("success");
                                        fileOutputStream4 = "success";
                                    }
                                    try {
                                        fileOutputStream6.close();
                                        fileOutputStream3 = fileOutputStream4;
                                    } finally {
                                        ?? message = th.getMessage();
                                        Log.w("TTPropHelper", (String) message);
                                        fileOutputStream3 = message;
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    fileOutputStream2 = fileOutputStream6;
                                    Log.e("TTPropHelper", "saveToLocal: ", e);
                                    sPVar.Sj(false, false);
                                    fileOutputStream3 = fileOutputStream2;
                                    if (fileOutputStream2 != null) {
                                        try {
                                            fileOutputStream2.close();
                                            fileOutputStream3 = fileOutputStream2;
                                        } catch (Throwable th2) {
                                        }
                                    }
                                    if (sP) {
                                    }
                                    this.Ym.delete();
                                    if (sP) {
                                    }
                                    this.uA = sPVar.Sj;
                                    sPVar.Sj(true, true);
                                    if (sP) {
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                fileOutputStream = fileOutputStream6;
                                if (fileOutputStream == null) {
                                    throw th;
                                }
                                try {
                                    fileOutputStream.close();
                                    throw th;
                                } catch (Throwable th4) {
                                    Log.w("TTPropHelper", th4.getMessage());
                                    throw th;
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            fileOutputStream5 = fileOutputStream6;
                            j3 = 0;
                            fileOutputStream2 = fileOutputStream5;
                            Log.e("TTPropHelper", "saveToLocal: ", e);
                            sPVar.Sj(false, false);
                            fileOutputStream3 = fileOutputStream2;
                            if (fileOutputStream2 != null) {
                            }
                            if (sP) {
                            }
                            this.Ym.delete();
                            if (sP) {
                            }
                            this.uA = sPVar.Sj;
                            sPVar.Sj(true, true);
                            if (sP) {
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream = fileOutputStream3;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            }
            long currentTimeMillis2 = sP ? System.currentTimeMillis() : 0L;
            this.Ym.delete();
            long currentTimeMillis3 = sP ? System.currentTimeMillis() : 0L;
            this.uA = sPVar.Sj;
            sPVar.Sj(true, true);
            if (sP) {
                StringBuilder sb2 = new StringBuilder("write: ");
                sb2.append(j - currentTimeMillis);
                sb2.append("/");
                sb2.append(j2 - currentTimeMillis);
                sb2.append("/");
                sb2.append(j3 - currentTimeMillis);
                sb2.append("/");
                sb2.append(currentTimeMillis2 - currentTimeMillis);
                sb2.append("/");
                sb2.append(currentTimeMillis3 - currentTimeMillis);
            }
        } catch (Throwable th6) {
            Log.w("TTPropHelper", "writeToFile: Got exception:", th6);
            if (this.TEQ.exists() && !this.TEQ.delete()) {
                Log.e("TTPropHelper", "Couldn't clean up partially-written file " + this.TEQ);
            }
            sPVar.Sj(false, false);
        }
    }

    static /* synthetic */ int uA(Sj sj) {
        int i = sj.Jcg;
        sj.Jcg = i - 1;
        return i;
    }

    static /* synthetic */ long vS(Sj sj) {
        long j = sj.Dq;
        sj.Dq = 1 + j;
        return j;
    }

    public float Sj(String str, float f) {
        float parseFloat;
        if (TextUtils.isEmpty(str)) {
            return f;
        }
        synchronized (this.TKC) {
            try {
                try {
                    EjP();
                    parseFloat = Float.parseFloat(this.HiB.getProperty(str, String.valueOf(f)));
                } catch (NumberFormatException e) {
                    Log.e("TTPropHelper", e.getMessage());
                    return f;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return parseFloat;
    }

    public int Sj(String str, int i) {
        int parseInt;
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        synchronized (this.TKC) {
            try {
                try {
                    EjP();
                    parseInt = Integer.parseInt(this.HiB.getProperty(str, String.valueOf(i)));
                } catch (NumberFormatException e) {
                    Log.e("TTPropHelper", e.getMessage());
                    return i;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return parseInt;
    }

    public long Sj(String str, long j) {
        long parseLong;
        if (TextUtils.isEmpty(str)) {
            return j;
        }
        synchronized (this.TKC) {
            try {
                try {
                    EjP();
                    parseLong = Long.parseLong(this.HiB.getProperty(str, String.valueOf(j)));
                } catch (NumberFormatException e) {
                    Log.e("TTPropHelper", e.getMessage());
                    return j;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return parseLong;
    }

    public String Sj(String str, String str2) {
        String property;
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        synchronized (this.TKC) {
            EjP();
            property = this.HiB.getProperty(str, str2);
        }
        return property;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00b4  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0083 -> B:27:0x009d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Sj() {
        FileInputStream fileInputStream;
        Throwable th;
        synchronized (this.TKC) {
            try {
                if (this.vS) {
                    return;
                }
                if (this.Ym.exists()) {
                    this.TEQ.delete();
                    this.Ym.renameTo(this.TEQ);
                }
                if (sP) {
                    StringBuilder sb = new StringBuilder("reload: ");
                    sb.append(this.TEQ.getAbsolutePath());
                    sb.append(", exist? ");
                    sb.append(this.TEQ.exists());
                }
                Properties properties = null;
                if (this.TEQ.exists()) {
                    Properties properties2 = new Properties();
                    try {
                        try {
                            fileInputStream = new FileInputStream(this.TEQ);
                        } catch (Throwable th2) {
                            Log.w("TTPropHelper", th2.getMessage());
                        }
                        try {
                            properties2.load(fileInputStream);
                            if (sP) {
                                StringBuilder sb2 = new StringBuilder("reload: find ");
                                sb2.append(properties2.size());
                                sb2.append(" ,items from ");
                                sb2.append(this.TEQ.getAbsolutePath());
                            }
                            fileInputStream.close();
                        } catch (Throwable th3) {
                            th = th3;
                            try {
                                Log.e("TTPropHelper", "reload: ", th);
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                properties = properties2;
                                synchronized (this.TKC) {
                                }
                            } catch (Throwable th4) {
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Throwable th5) {
                                        Log.w("TTPropHelper", th5.getMessage());
                                    }
                                }
                                throw th4;
                            }
                        }
                    } catch (Throwable th6) {
                        fileInputStream = null;
                        th = th6;
                    }
                    properties = properties2;
                }
                synchronized (this.TKC) {
                    if (properties != null) {
                        try {
                            if (!properties.isEmpty()) {
                                this.HiB = properties;
                            }
                        } catch (Throwable th7) {
                            throw th7;
                        }
                    }
                    this.vS = true;
                    this.TKC.notifyAll();
                }
            } catch (Throwable th8) {
                throw th8;
            }
        }
    }

    public boolean Sj(String str) {
        boolean containsKey;
        synchronized (this.TKC) {
            try {
                try {
                    EjP();
                    containsKey = this.HiB.containsKey(str);
                } catch (NumberFormatException e) {
                    Log.e("TTPropHelper", e.getMessage());
                    return false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return containsKey;
    }

    public boolean Sj(String str, boolean z) {
        boolean parseBoolean;
        if (TextUtils.isEmpty(str)) {
            return z;
        }
        synchronized (this.TKC) {
            try {
                try {
                    EjP();
                    parseBoolean = Boolean.parseBoolean(this.HiB.getProperty(str, String.valueOf(z)));
                } catch (NumberFormatException e) {
                    Log.e("TTPropHelper", e.getMessage());
                    return z;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return parseBoolean;
    }

    public TKC sP() {
        return new TKC();
    }
}
