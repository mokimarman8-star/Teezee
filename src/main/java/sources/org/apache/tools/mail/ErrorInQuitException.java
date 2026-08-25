package org.apache.tools.mail;

import java.io.IOException;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class ErrorInQuitException extends IOException {
    public ErrorInQuitException(IOException iOException) {
        super(iOException.getMessage());
    }
}
