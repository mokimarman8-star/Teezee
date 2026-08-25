package com.vungle.ads.internal.network;

import java.io.IOException;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface a {
    void cancel();

    void enqueue(b bVar);

    e execute() throws IOException;

    boolean isCanceled();
}
