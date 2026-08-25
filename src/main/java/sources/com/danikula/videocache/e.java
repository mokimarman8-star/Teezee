package com.danikula.videocache;

import android.text.TextUtils;
import com.cloud.tmc.kernel.constants.TmcConstants;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
class e extends m {
    private b i;
    private final a j;

    public e(a aVar) {
        super(aVar);
        this.j = aVar;
    }

    private String i(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    private String j(d dVar) {
        int i;
        String str;
        String z = this.j.z();
        boolean isEmpty = TextUtils.isEmpty(z);
        long A = this.j.A();
        long G = this.j.G();
        long j = dVar.b;
        boolean z2 = A >= 0;
        boolean z3 = dVar.c;
        long j2 = z3 ? A - j : A;
        boolean z4 = z2 && z3;
        q.e("header， offset = " + j + ", rangeEnd = " + G + ", totalSize = " + A + ", contentLength = " + j2 + " , contentType = " + z);
        StringBuilder sb = new StringBuilder();
        sb.append(dVar.c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb.append("Accept-Ranges: bytes\n");
        String str2 = "";
        sb.append(z2 ? i("Content-Length: %d\n", Long.valueOf(j2)) : "");
        if (z4) {
            i = 1;
            str = i("Content-Range: bytes %d-%d/%d\n", Long.valueOf(j), Long.valueOf(G), Long.valueOf(A));
        } else {
            i = 1;
            str = "";
        }
        sb.append(str);
        if (!isEmpty) {
            Object[] objArr = new Object[i];
            objArr[0] = z;
            str2 = i("Content-Type: %s\n", objArr);
        }
        sb.append(str2);
        sb.append("\n");
        return sb.toString();
    }

    private void m(OutputStream outputStream, long j, String str) {
        q.a("responseWithCache， offset = " + j);
        byte[] bArr = new byte[8192];
        while (true) {
            int d = d(bArr, j, 8192, str);
            if (d == -1 || this.e) {
                break;
            }
            outputStream.write(bArr, 0, d);
            j += d;
        }
        outputStream.flush();
        q.e("responseWithCache， --------------------end,offset = " + j + "， threadName = " + Thread.currentThread().getName());
    }

    public void k(d dVar, Socket socket) {
        long j = dVar.b;
        q.f("processRequest， offset = " + j + "， threadName = " + Thread.currentThread().getName());
        a(j);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(j(dVar).getBytes(TmcConstants.DEFAULT_ENCODING));
        m(bufferedOutputStream, j, n.b(dVar.a));
    }

    public void l(b bVar) {
        this.i = bVar;
    }
}
