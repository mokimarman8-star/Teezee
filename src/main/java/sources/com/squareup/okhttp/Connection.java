package com.squareup.okhttp;

import java.net.Socket;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public interface Connection {
    Handshake getHandshake();

    Protocol getProtocol();

    Route getRoute();

    Socket getSocket();
}
