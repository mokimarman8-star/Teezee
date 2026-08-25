package com.amazonaws.retry;

import com.amazonaws.AbortedException;
import com.amazonaws.AmazonServiceException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class RetryUtils {
    public static boolean a(AmazonServiceException amazonServiceException) {
        if (amazonServiceException == null) {
            return false;
        }
        String errorCode = amazonServiceException.getErrorCode();
        return "RequestTimeTooSkewed".equals(errorCode) || "RequestExpired".equals(errorCode) || "InvalidSignatureException".equals(errorCode) || "SignatureDoesNotMatch".equals(errorCode);
    }

    public static boolean b(Throwable th) {
        if (th instanceof AbortedException) {
            return true;
        }
        if (th.getCause() == null) {
            return false;
        }
        Throwable cause = th.getCause();
        return (cause instanceof InterruptedException) || ((cause instanceof InterruptedIOException) && !(cause instanceof SocketTimeoutException));
    }

    public static boolean c(AmazonServiceException amazonServiceException) {
        if (amazonServiceException == null) {
            return false;
        }
        String errorCode = amazonServiceException.getErrorCode();
        return "Throttling".equals(errorCode) || "ThrottlingException".equals(errorCode) || "ProvisionedThroughputExceededException".equals(errorCode);
    }
}
