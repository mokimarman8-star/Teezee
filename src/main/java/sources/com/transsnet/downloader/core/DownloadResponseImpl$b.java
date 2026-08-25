package com.transsnet.downloader.core;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.transsion.baselib.db.download.DownloadBean;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class DownloadResponseImpl$b extends Handler {
    final /* synthetic */ DownloadResponseImpl a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadResponseImpl$b(DownloadResponseImpl downloadResponseImpl, Looper looper) {
        super(looper);
        this.a = downloadResponseImpl;
    }

    @Override // android.os.Handler
    public void handleMessage(Message msg) {
        DownloadBean downloadBean;
        Intrinsics.h(msg, "msg");
        super.handleMessage(msg);
        Object obj = msg.obj;
        if (obj != null) {
            Intrinsics.f(obj, "null cannot be cast to non-null type com.transsion.baselib.db.download.DownloadBean");
            downloadBean = (DownloadBean) obj;
        } else {
            downloadBean = null;
        }
        if (downloadBean == null) {
            return;
        }
        DownloadResponseImpl.f(this.a, downloadBean, msg.what, msg.arg1 == 1);
    }
}
