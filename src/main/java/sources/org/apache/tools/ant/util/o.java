package org.apache.tools.ant.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.tools.ant.types.t;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class o {
    private static final d a = d.k();
    private static final nz.c b = new nz.b(new nz.a());

    private static int a(t tVar, t tVar2) {
        BufferedInputStream bufferedInputStream;
        int read;
        int i;
        int read2;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            BufferedInputStream bufferedInputStream3 = new BufferedInputStream(tVar.e());
            try {
                bufferedInputStream = new BufferedInputStream(tVar2.e());
                do {
                    try {
                        read = bufferedInputStream3.read();
                        if (read == -1) {
                            i = bufferedInputStream.read() == -1 ? 0 : -1;
                            d.b(bufferedInputStream3);
                            d.b(bufferedInputStream);
                            return i;
                        }
                        read2 = bufferedInputStream.read();
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream2 = bufferedInputStream3;
                        d.b(bufferedInputStream2);
                        d.b(bufferedInputStream);
                        throw th;
                    }
                } while (read == read2);
                i = read > read2 ? 1 : -1;
                d.b(bufferedInputStream3);
                d.b(bufferedInputStream);
                return i;
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
        }
    }

    public static int b(t tVar, t tVar2, boolean z) {
        if (tVar.equals(tVar2)) {
            return 0;
        }
        boolean k = tVar.k();
        boolean k2 = tVar2.k();
        if (!k && !k2) {
            return 0;
        }
        if (k != k2) {
            return k ? 1 : -1;
        }
        boolean j = tVar.j();
        boolean j2 = tVar2.j();
        if (j && j2) {
            return 0;
        }
        return (j || j2) ? j ? -1 : 1 : z ? c(tVar, tVar2) : a(tVar, tVar2);
    }

    private static int c(t tVar, t tVar2) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3 = null;
        try {
            bufferedReader2 = new BufferedReader(new InputStreamReader(tVar.e()));
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(tVar2.e()));
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
        try {
            for (String readLine = bufferedReader2.readLine(); readLine != null; readLine = bufferedReader2.readLine()) {
                String readLine2 = bufferedReader.readLine();
                if (!readLine.equals(readLine2)) {
                    int compareTo = readLine.compareTo(readLine2);
                    d.d(bufferedReader2);
                    d.d(bufferedReader);
                    return compareTo;
                }
            }
            int i = bufferedReader.readLine() == null ? 0 : -1;
            d.d(bufferedReader2);
            d.d(bufferedReader);
            return i;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader3 = bufferedReader2;
            d.d(bufferedReader3);
            d.d(bufferedReader);
            throw th;
        }
    }
}
