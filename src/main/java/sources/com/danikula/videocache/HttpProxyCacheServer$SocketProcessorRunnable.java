package com.danikula.videocache;

import java.net.Socket;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class HttpProxyCacheServer$SocketProcessorRunnable implements Runnable {
    private final d request;
    private final Socket socket;
    final /* synthetic */ HttpProxyCacheServer this$0;

    public HttpProxyCacheServer$SocketProcessorRunnable(HttpProxyCacheServer httpProxyCacheServer, Socket socket, d dVar) {
        this.this$0 = httpProxyCacheServer;
        this.socket = socket;
        this.request = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        HttpProxyCacheServer.a(this.this$0, this.socket, this.request);
    }
}
