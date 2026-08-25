package com.transsion.transfer.androidasync.http.server;

import com.transsion.transfer.androidasync.http.Headers;
import java.io.File;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface d extends com.transsion.transfer.androidasync.s, st.a {
    String A();

    int b();

    d c(int i);

    @Override // com.transsion.transfer.androidasync.s
    void d();

    Headers getHeaders();

    void q(File file, st.e eVar);

    void send(String str);

    void u();
}
