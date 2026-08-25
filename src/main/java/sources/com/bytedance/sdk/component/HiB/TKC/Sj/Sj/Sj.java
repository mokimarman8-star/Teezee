package com.bytedance.sdk.component.HiB.TKC.Sj.Sj;

import android.util.Log;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.bytedance.sdk.component.utils.TEQ;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.regex.Pattern;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class Sj implements Closeable {
    static final Pattern Sj = Pattern.compile("[a-z0-9_-]{1,120}");
    public static final OutputStream TKC = new OutputStream() { // from class: com.bytedance.sdk.component.HiB.TKC.Sj.Sj.Sj.2
        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
        }
    };
    private final int Dq;
    private final File EjP;
    private final File HiB;
    private final File Jcg;
    private final int TEQ;
    private Writer aa;
    final ExecutorService sP;
    private int sef;
    private long uA;
    private final File vS;
    private long Ym = 0;
    private final LinkedHashMap<String, sP> Fmk = new LinkedHashMap<>(0, 0.75f, true);
    private long Zq = -1;
    private long uvD = 0;
    private final Callable<Void> dNu = new Callable<Void>() { // from class: com.bytedance.sdk.component.HiB.TKC.Sj.Sj.Sj.1
        @Override // java.util.concurrent.Callable
        /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            synchronized (Sj.this) {
                try {
                    if (Sj.this.aa == null) {
                        return null;
                    }
                    Sj.this.Dq();
                    if (Sj.this.vS()) {
                        Sj.this.HiB();
                        Sj.this.sef = 0;
                    }
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    };

    /* renamed from: com.bytedance.sdk.component.HiB.TKC.Sj.Sj.Sj$Sj, reason: collision with other inner class name */
    public final class C0038Sj {
        private boolean EjP;
        private boolean HiB;
        private final boolean[] TKC;
        private final sP sP;

        /* renamed from: com.bytedance.sdk.component.HiB.TKC.Sj.Sj.Sj$Sj$Sj, reason: collision with other inner class name */
        private class C0039Sj extends FilterOutputStream {
            private C0039Sj(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    C0038Sj.this.EjP = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    C0038Sj.this.EjP = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException unused) {
                    C0038Sj.this.EjP = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException unused) {
                    C0038Sj.this.EjP = true;
                }
            }
        }

        private C0038Sj(sP sPVar) {
            this.sP = sPVar;
            this.TKC = sPVar.EjP ? null : new boolean[Sj.this.TEQ];
        }

        public OutputStream Sj(int i) throws IOException {
            FileOutputStream fileOutputStream;
            C0039Sj c0039Sj;
            if (i < 0 || i >= Sj.this.TEQ) {
                throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + Sj.this.TEQ);
            }
            synchronized (Sj.this) {
                try {
                    if (this.sP.HiB != this) {
                        throw new IllegalStateException();
                    }
                    if (!this.sP.EjP) {
                        this.TKC[i] = true;
                    }
                    File sP = this.sP.sP(i);
                    try {
                        fileOutputStream = new FileOutputStream(sP);
                    } catch (FileNotFoundException unused) {
                        Sj.this.EjP.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(sP);
                        } catch (FileNotFoundException unused2) {
                            return Sj.TKC;
                        }
                    }
                    c0039Sj = new C0039Sj(fileOutputStream);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return c0039Sj;
        }

        public void Sj() throws IOException {
            if (this.EjP) {
                Sj.this.Sj(this, false);
                Sj.this.TKC(this.sP.sP);
            } else {
                Sj.this.Sj(this, true);
            }
            this.HiB = true;
        }

        public void sP() throws IOException {
            Sj.this.Sj(this, false);
        }
    }

    public final class TKC implements Closeable {
        private final InputStream[] EjP;
        private final long[] HiB;
        private final long TKC;
        private final String sP;

        private TKC(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.sP = str;
            this.TKC = j;
            this.EjP = inputStreamArr;
            this.HiB = jArr;
        }

        public InputStream Sj(int i) {
            return this.EjP[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.EjP) {
                TEQ.Sj(inputStream);
            }
        }
    }

    private final class sP {
        private boolean EjP;
        private C0038Sj HiB;
        private final long[] TKC;
        private final String sP;
        private long vS;

        private sP(String str) {
            this.sP = str;
            this.TKC = new long[Sj.this.TEQ];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Sj(String[] strArr) throws IOException {
            if (strArr.length != Sj.this.TEQ) {
                throw sP(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.TKC[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw sP(strArr);
                }
            }
        }

        private IOException sP(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File Sj(int i) {
            return new File(Sj.this.EjP, this.sP + InstructionFileId.DOT + i);
        }

        public String Sj() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j : this.TKC) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        public File sP(int i) {
            return new File(Sj.this.EjP, this.sP + InstructionFileId.DOT + i + ".tmp");
        }
    }

    private Sj(File file, int i, int i2, long j, ExecutorService executorService) {
        this.EjP = file;
        this.Dq = i;
        this.HiB = new File(file, "journal");
        this.vS = new File(file, "journal.tmp");
        this.Jcg = new File(file, "journal.bkp");
        this.TEQ = i2;
        this.uA = j;
        this.sP = executorService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dq() throws IOException {
        long j = this.uA;
        long j2 = this.Zq;
        if (j2 >= 0) {
            j = j2;
        }
        while (this.Ym > j) {
            TKC(this.Fmk.entrySet().iterator().next().getKey());
        }
        this.Zq = -1L;
    }

    private void EjP() throws IOException {
        Sj(this.vS);
        Iterator<sP> it = this.Fmk.values().iterator();
        while (it.hasNext()) {
            sP next = it.next();
            int i = 0;
            if (next.HiB == null) {
                while (i < this.TEQ) {
                    this.Ym += next.TKC[i];
                    i++;
                }
            } else {
                next.HiB = null;
                while (i < this.TEQ) {
                    Sj(next.Sj(i));
                    Sj(next.sP(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    private void EjP(String str) throws IOException {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            substring = str.substring(i);
            if (indexOf == 6 && str.startsWith("REMOVE")) {
                this.Fmk.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i, indexOf2);
        }
        sP sPVar = this.Fmk.get(substring);
        if (sPVar == null) {
            sPVar = new sP(substring);
            this.Fmk.put(substring, sPVar);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            sPVar.EjP = true;
            sPVar.HiB = null;
            sPVar.Sj(split);
            return;
        }
        if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
            sPVar.HiB = new C0038Sj(sPVar);
        } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void HiB() throws IOException {
        try {
            Writer writer = this.aa;
            if (writer != null) {
                writer.close();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.vS), EjP.Sj));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.Dq));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.TEQ));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (sP sPVar : this.Fmk.values()) {
                    if (sPVar.HiB != null) {
                        bufferedWriter.write("DIRTY " + sPVar.sP + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + sPVar.sP + sPVar.Sj() + '\n');
                    }
                }
                bufferedWriter.close();
                if (this.HiB.exists()) {
                    Sj(this.HiB, this.Jcg, true);
                }
                Sj(this.vS, this.HiB, false);
                this.Jcg.delete();
                this.aa = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.HiB, true), EjP.Sj));
            } catch (Throwable th) {
                bufferedWriter.close();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private void HiB(String str) {
        if (Sj.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    private void Jcg() {
        if (this.aa == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private synchronized C0038Sj Sj(String str, long j) throws IOException {
        Jcg();
        HiB(str);
        sP sPVar = this.Fmk.get(str);
        if (j != -1 && (sPVar == null || sPVar.vS != j)) {
            return null;
        }
        if (sPVar == null) {
            sPVar = new sP(str);
            this.Fmk.put(str, sPVar);
        } else if (sPVar.HiB != null) {
            return null;
        }
        C0038Sj c0038Sj = new C0038Sj(sPVar);
        sPVar.HiB = c0038Sj;
        this.aa.write("DIRTY " + str + '\n');
        this.aa.flush();
        return c0038Sj;
    }

    public static Sj Sj(File file, int i, int i2, long j, ExecutorService executorService) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                Sj(file2, file3, false);
            }
        }
        Sj sj = new Sj(file, i, i2, j, executorService);
        if (sj.HiB.exists()) {
            try {
                sj.TKC();
                sj.EjP();
                return sj;
            } catch (IOException e) {
                Log.w("DiskLruCache ", file + " is corrupt: " + e.getMessage() + ", removing");
                sj.sP();
            }
        }
        file.mkdirs();
        Sj sj2 = new Sj(file, i, i2, j, executorService);
        sj2.HiB();
        return sj2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Sj(C0038Sj c0038Sj, boolean z) throws IOException {
        sP sPVar = c0038Sj.sP;
        if (sPVar.HiB != c0038Sj) {
            throw new IllegalStateException();
        }
        if (z && !sPVar.EjP) {
            for (int i = 0; i < this.TEQ; i++) {
                if (!c0038Sj.TKC[i]) {
                    c0038Sj.sP();
                    throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i)));
                }
                if (!sPVar.sP(i).exists()) {
                    c0038Sj.sP();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.TEQ; i2++) {
            File sP2 = sPVar.sP(i2);
            if (!z) {
                Sj(sP2);
            } else if (sP2.exists()) {
                File Sj2 = sPVar.Sj(i2);
                sP2.renameTo(Sj2);
                long j = sPVar.TKC[i2];
                long length = Sj2.length();
                sPVar.TKC[i2] = length;
                this.Ym = (this.Ym - j) + length;
            }
        }
        this.sef++;
        sPVar.HiB = null;
        if (sPVar.EjP || z) {
            sPVar.EjP = true;
            this.aa.write("CLEAN " + sPVar.sP + sPVar.Sj() + '\n');
            if (z) {
                long j2 = this.uvD;
                this.uvD = 1 + j2;
                sPVar.vS = j2;
            }
        } else {
            this.Fmk.remove(sPVar.sP);
            this.aa.write("REMOVE " + sPVar.sP + '\n');
        }
        this.aa.flush();
        if (this.Ym > this.uA || vS()) {
            this.sP.submit(this.dNu);
        }
    }

    private static void Sj(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void Sj(File file, File file2, boolean z) throws IOException {
        if (z) {
            Sj(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    private void TKC() throws IOException {
        com.bytedance.sdk.component.HiB.TKC.Sj.Sj.TKC tkc = new com.bytedance.sdk.component.HiB.TKC.Sj.Sj.TKC(new FileInputStream(this.HiB), EjP.Sj);
        try {
            String Sj2 = tkc.Sj();
            String Sj3 = tkc.Sj();
            String Sj4 = tkc.Sj();
            String Sj5 = tkc.Sj();
            String Sj6 = tkc.Sj();
            if (!"libcore.io.DiskLruCache".equals(Sj2) || !"1".equals(Sj3) || !Integer.toString(this.Dq).equals(Sj4) || !Integer.toString(this.TEQ).equals(Sj5) || !"".equals(Sj6)) {
                throw new IOException("unexpected journal header: [" + Sj2 + ", " + Sj3 + ", " + Sj5 + ", " + Sj6 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    EjP(tkc.Sj());
                    i++;
                } catch (EOFException unused) {
                    this.sef = i - this.Fmk.size();
                    if (tkc.sP()) {
                        HiB();
                    } else {
                        this.aa = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.HiB, true), EjP.Sj));
                    }
                    TEQ.Sj(tkc);
                    return;
                }
            }
        } catch (Throwable th) {
            TEQ.Sj(tkc);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean vS() {
        int i = this.sef;
        return i >= 2000 && i >= this.Fmk.size();
    }

    public synchronized TKC Sj(String str) throws IOException {
        InputStream inputStream;
        Jcg();
        HiB(str);
        sP sPVar = this.Fmk.get(str);
        if (sPVar == null) {
            return null;
        }
        if (!sPVar.EjP) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.TEQ];
        for (int i = 0; i < this.TEQ; i++) {
            try {
                inputStreamArr[i] = new FileInputStream(sPVar.Sj(i));
            } catch (FileNotFoundException unused) {
                for (int i2 = 0; i2 < this.TEQ && (inputStream = inputStreamArr[i2]) != null; i2++) {
                    TEQ.Sj(inputStream);
                }
                return null;
            }
        }
        this.sef++;
        this.aa.append((CharSequence) ("READ " + str + '\n'));
        if (vS()) {
            this.sP.submit(this.dNu);
        }
        return new TKC(str, sPVar.vS, inputStreamArr, sPVar.TKC);
    }

    public synchronized void Sj() throws IOException {
        Jcg();
        Dq();
        this.aa.flush();
    }

    public synchronized boolean TKC(String str) throws IOException {
        try {
            Jcg();
            HiB(str);
            sP sPVar = this.Fmk.get(str);
            if (sPVar != null && sPVar.HiB == null) {
                for (int i = 0; i < this.TEQ; i++) {
                    File Sj2 = sPVar.Sj(i);
                    if (Sj2.exists() && !Sj2.delete()) {
                        throw new IOException("failed to delete ".concat(String.valueOf(Sj2)));
                    }
                    this.Ym -= sPVar.TKC[i];
                    sPVar.TKC[i] = 0;
                }
                this.sef++;
                this.aa.append((CharSequence) ("REMOVE " + str + '\n'));
                this.Fmk.remove(str);
                if (vS()) {
                    this.sP.submit(this.dNu);
                }
                return true;
            }
            return false;
        } finally {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        try {
            if (this.aa == null) {
                return;
            }
            Iterator it = new ArrayList(this.Fmk.values()).iterator();
            while (it.hasNext()) {
                sP sPVar = (sP) it.next();
                if (sPVar.HiB != null) {
                    sPVar.HiB.sP();
                }
            }
            Dq();
            this.aa.close();
            this.aa = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public C0038Sj sP(String str) throws IOException {
        return Sj(str, -1L);
    }

    public void sP() throws IOException {
        close();
        EjP.Sj(this.EjP);
    }
}
