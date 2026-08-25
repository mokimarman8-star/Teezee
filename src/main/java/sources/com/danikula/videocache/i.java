package com.danikula.videocache;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
class i extends ProxySelector {
    private static final List d = Arrays.asList(Proxy.NO_PROXY);
    private final ProxySelector a;
    private final String b;
    private final int c;

    i(ProxySelector proxySelector, String str, int i) {
        this.a = (ProxySelector) l.c(proxySelector);
        this.b = (String) l.c(str);
        this.c = i;
    }

    static void a(String str, int i) {
        ProxySelector.setDefault(new i(ProxySelector.getDefault(), str, i));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.a.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List select(URI uri) {
        if (this.b.equals(uri.getHost()) && this.c == uri.getPort()) {
            return d;
        }
        try {
            List<Proxy> select = this.a.select(uri);
            return select != null ? select : d;
        } catch (Throwable unused) {
            return d;
        }
    }
}
