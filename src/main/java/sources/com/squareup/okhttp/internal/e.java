package com.squareup.okhttp.internal;

import com.squareup.okhttp.Protocol;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.net.ssl.SSLSocket;
import okio.Buffer;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class e {
    private static final e a = e();

    private static class a extends e {
        private final d b;
        private final d c;
        private final Method d;
        private final Method e;
        private final d f;
        private final d g;

        public a(d dVar, d dVar2, Method method, Method method2, d dVar3, d dVar4) {
            this.b = dVar;
            this.c = dVar2;
            this.d = method;
            this.e = method2;
            this.f = dVar3;
            this.g = dVar4;
        }

        @Override // com.squareup.okhttp.internal.e
        public void c(SSLSocket sSLSocket, String str, List list) {
            if (str != null) {
                this.b.e(sSLSocket, Boolean.TRUE);
                this.c.e(sSLSocket, str);
            }
            d dVar = this.g;
            if (dVar == null || !dVar.g(sSLSocket)) {
                return;
            }
            this.g.f(sSLSocket, e.b(list));
        }

        @Override // com.squareup.okhttp.internal.e
        public void d(Socket socket, InetSocketAddress inetSocketAddress, int i) {
            try {
                socket.connect(inetSocketAddress, i);
            } catch (AssertionError e) {
                if (!g.o(e)) {
                    throw e;
                }
                throw new IOException(e);
            } catch (SecurityException e2) {
                IOException iOException = new IOException("Exception in connect");
                iOException.initCause(e2);
                throw iOException;
            }
        }

        @Override // com.squareup.okhttp.internal.e
        public String h(SSLSocket sSLSocket) {
            byte[] bArr;
            d dVar = this.f;
            if (dVar == null || !dVar.g(sSLSocket) || (bArr = (byte[]) this.f.f(sSLSocket, new Object[0])) == null) {
                return null;
            }
            return new String(bArr, g.c);
        }
    }

    private static class b extends e {
        private final Method b;
        private final Method c;
        private final Method d;
        private final Class e;
        private final Class f;

        public b(Method method, Method method2, Method method3, Class cls, Class cls2) {
            this.b = method;
            this.c = method2;
            this.d = method3;
            this.e = cls;
            this.f = cls2;
        }

        @Override // com.squareup.okhttp.internal.e
        public void a(SSLSocket sSLSocket) {
            try {
                this.d.invoke(null, sSLSocket);
            } catch (IllegalAccessException | InvocationTargetException unused) {
                throw new AssertionError();
            }
        }

        @Override // com.squareup.okhttp.internal.e
        public void c(SSLSocket sSLSocket, String str, List list) {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Protocol protocol = (Protocol) list.get(i);
                if (protocol != Protocol.HTTP_1_0) {
                    arrayList.add(protocol.toString());
                }
            }
            try {
                this.b.invoke(null, sSLSocket, Proxy.newProxyInstance(e.class.getClassLoader(), new Class[]{this.e, this.f}, new c(arrayList)));
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new AssertionError(e);
            }
        }

        @Override // com.squareup.okhttp.internal.e
        public String h(SSLSocket sSLSocket) {
            try {
                c cVar = (c) Proxy.getInvocationHandler(this.c.invoke(null, sSLSocket));
                if (!cVar.b && cVar.c == null) {
                    com.squareup.okhttp.internal.c.logger.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
                    return null;
                }
                if (cVar.b) {
                    return null;
                }
                return cVar.c;
            } catch (IllegalAccessException | InvocationTargetException unused) {
                throw new AssertionError();
            }
        }
    }

    private static class c implements InvocationHandler {
        private final List a;
        private boolean b;
        private String c;

        public c(List list) {
            this.a = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = g.b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.b = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.a;
            }
            if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof List) {
                    List list = (List) obj2;
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        if (this.a.contains(list.get(i))) {
                            String str = (String) list.get(i);
                            this.c = str;
                            return str;
                        }
                    }
                    String str2 = (String) this.a.get(0);
                    this.c = str2;
                    return str2;
                }
            }
            if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                return method.invoke(this, objArr);
            }
            this.c = (String) objArr[0];
            return null;
        }
    }

    static byte[] b(List list) {
        Buffer buffer = new Buffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = (Protocol) list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                buffer.writeByte(protocol.toString().length());
                buffer.writeUtf8(protocol.toString());
            }
        }
        return buffer.readByteArray();
    }

    private static e e() {
        Method method;
        d dVar;
        Method method2;
        try {
            try {
                try {
                    Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl");
                } catch (ClassNotFoundException unused) {
                    Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
                    Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
                    return new b(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
                }
            } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                return new e();
            }
        } catch (ClassNotFoundException unused3) {
            Class.forName("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
        }
        d dVar2 = null;
        d dVar3 = new d(null, "setUseSessionTickets", Boolean.TYPE);
        d dVar4 = new d(null, "setHostname", String.class);
        try {
            Class<?> cls3 = Class.forName("android.net.TrafficStats");
            method2 = cls3.getMethod("tagSocket", Socket.class);
            try {
                method = cls3.getMethod("untagSocket", Socket.class);
                try {
                    Class.forName("android.net.Network");
                    dVar = new d(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                    try {
                        dVar2 = new d(null, "setAlpnProtocols", byte[].class);
                    } catch (ClassNotFoundException | NoSuchMethodException unused4) {
                    }
                } catch (ClassNotFoundException | NoSuchMethodException unused5) {
                    dVar = null;
                }
            } catch (ClassNotFoundException | NoSuchMethodException unused6) {
                method = null;
                dVar = null;
            }
        } catch (ClassNotFoundException | NoSuchMethodException unused7) {
            method = null;
            dVar = null;
            method2 = null;
        }
        return new a(dVar3, dVar4, method2, method, dVar, dVar2);
    }

    public static e f() {
        return a;
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void c(SSLSocket sSLSocket, String str, List list) {
    }

    public void d(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        socket.connect(inetSocketAddress, i);
    }

    public String g() {
        return "OkHttp";
    }

    public String h(SSLSocket sSLSocket) {
        return null;
    }

    public void i(String str) {
        System.out.println(str);
    }
}
