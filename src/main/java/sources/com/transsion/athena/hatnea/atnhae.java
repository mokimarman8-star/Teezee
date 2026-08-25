package com.transsion.athena.hatnea;

import android.os.Handler;
import android.os.Message;
import com.transsion.baselib.db.download.DownloadException;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class atnhae extends anateh {
    private static final String[] c = {"https://time1.google.com", "https://time.cloudflare.com", "https://www.pool.ntp.org"};
    private int d;

    public atnhae(Handler handler) {
        super(handler);
        this.d = 0;
    }

    @Override // com.transsion.athena.hatnea.anateh
    protected void a() {
        Message obtainMessage = this.a.obtainMessage(DownloadException.EXCEPTION_IO_SOCKET_TIMEOUT);
        obtainMessage.obj = 0L;
        while (true) {
            int i = this.d;
            if (i >= 3) {
                break;
            }
            ehanat<Long> a = anehat.a(c[i]);
            if (a.a == 0) {
                obtainMessage.obj = a.b;
                break;
            }
            this.d++;
        }
        this.a.sendMessageAtFrontOfQueue(obtainMessage);
    }

    @Override // com.transsion.athena.hatnea.anateh
    protected String c() {
        return "Retrieve-Time";
    }
}
