package com.bykv.vk.openvk.Sj.Sj.sP.sP;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collections;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class b extends ProxySelector {
    private static final List d = Collections.singletonList(Proxy.NO_PROXY);
    private final ProxySelector a = ProxySelector.getDefault();
    private final String b;
    private final int c;

    private b(String str, int i) {
        this.b = str;
        this.c = i;
    }

    static void a(String str, int i) {
        ProxySelector.setDefault(new b(str, i));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.a.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List select(URI uri) {
        if (uri != null) {
            return (this.b.equalsIgnoreCase(uri.getHost()) && this.c == uri.getPort()) ? d : this.a.select(uri);
        }
        throw new IllegalArgumentException("URI can't be null");
    }
}
