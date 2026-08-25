package com.facebook.biddingkit.logging;

import com.cloud.tmc.miniutils.constant.MemoryConstants;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
abstract class g {

    private static class b implements d {
        final Collection a;

        private b() {
            this.a = new ArrayList();
        }

        @Override // com.facebook.biddingkit.logging.g.d
        public void a(String str) {
            this.a.add(str);
        }

        @Override // com.facebook.biddingkit.logging.g.d
        public void flush() {
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                sb.append((String) it.next());
                sb.append('\n');
            }
            return sb.toString();
        }
    }

    private static class c implements d {
        final d a;
        int b;

        c(d dVar, int i) {
            this.a = dVar;
            this.b = i;
        }

        @Override // com.facebook.biddingkit.logging.g.d
        public void a(String str) {
            if (this.b > 0) {
                this.a.a(str);
                this.b--;
            }
        }

        @Override // com.facebook.biddingkit.logging.g.d
        public void flush() {
            this.a.flush();
        }
    }

    private interface d {
        void a(String str);

        void flush();
    }

    private static class e extends Writer {
        final d a;
        char[] b = new char[MemoryConstants.KB];
        int c;

        e(d dVar) {
            this.a = dVar;
        }

        private void d() {
            this.a.a(new String(this.b, 0, this.c));
            this.c = 0;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            flush();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            if (this.c > 0) {
                d();
            }
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            for (int i3 = i; i3 < i + i2; i3++) {
                char c = cArr[i3];
                if (c != '\n') {
                    int i4 = this.c;
                    char[] cArr2 = this.b;
                    if (i4 != cArr2.length) {
                        cArr2[i4] = c;
                        this.c = i4 + 1;
                    }
                }
                d();
            }
        }
    }

    public static String a(Throwable th) {
        return b(th, 100);
    }

    public static String b(Throwable th, int i) {
        if (th == null) {
            return "";
        }
        try {
            b bVar = new b();
            d cVar = i >= 0 ? new c(bVar, i) : bVar;
            th.printStackTrace(new PrintWriter(new e(cVar)));
            cVar.flush();
            return bVar.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
