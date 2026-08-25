package mh;

import android.os.ParcelFileDescriptor;
import android.util.Base64DataException;
import android.util.MalformedJsonException;
import com.cloud.tmc.miniutils.constant.MemoryConstants;
import java.io.CharConversionException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.SyncFailedException;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.FileLockInterruptionException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.UnmappableCharacterException;
import java.util.InvalidPropertiesFormatException;
import java.util.jar.JarException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import kotlin.io.FileSystemException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.StreamResetException;
import org.apache.http.conn.ConnectTimeoutException;
import org.chromium.net.NetworkException;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class a {
    public static final a a = new a();

    private a() {
    }

    public final int a(int i, IOException iOException) {
        if (i != 480) {
            return i;
        }
        if (iOException instanceof SocketTimeoutException) {
            return 1008;
        }
        if (iOException instanceof UnknownHostException) {
            return 1005;
        }
        if (iOException instanceof NoRouteToHostException) {
            return 1006;
        }
        if (iOException instanceof ProtocolException) {
            return 1007;
        }
        if (iOException instanceof SSLHandshakeException) {
            return 1009;
        }
        if (iOException instanceof ConnectException) {
            return 1011;
        }
        if (iOException instanceof BindException) {
            return 1045;
        }
        if (iOException instanceof PortUnreachableException) {
            return 1012;
        }
        if (iOException instanceof ConnectTimeoutException) {
            return 1013;
        }
        if (iOException instanceof SSLKeyException) {
            return 1014;
        }
        if (iOException instanceof SSLPeerUnverifiedException) {
            return 1015;
        }
        if (iOException instanceof SSLProtocolException) {
            return 1016;
        }
        if (iOException instanceof FileSystemException) {
            return 1017;
        }
        if (iOException instanceof ObjectStreamException) {
            return 1018;
        }
        if (iOException instanceof AsynchronousCloseException) {
            return 1019;
        }
        if (iOException instanceof MalformedInputException) {
            return 1043;
        }
        if (iOException instanceof UnmappableCharacterException) {
            return 1044;
        }
        if (iOException instanceof JarException) {
            return 1022;
        }
        if (iOException instanceof CharConversionException) {
            return 1023;
        }
        if (iOException instanceof Base64DataException) {
            return MemoryConstants.KB;
        }
        if (iOException instanceof ConnectionShutdownException) {
            return 1025;
        }
        if (iOException instanceof EOFException) {
            return 1027;
        }
        if (iOException instanceof ParcelFileDescriptor.FileDescriptorDetachedException) {
            return 1028;
        }
        if (iOException instanceof FileLockInterruptionException) {
            return 1029;
        }
        if (iOException instanceof FileNotFoundException) {
            return 1030;
        }
        if (iOException instanceof HttpRetryException) {
            return 1031;
        }
        if (iOException instanceof InvalidPropertiesFormatException) {
            return 1033;
        }
        if (iOException instanceof MalformedJsonException) {
            return 1034;
        }
        if (iOException instanceof MalformedURLException) {
            return 1035;
        }
        if (iOException instanceof StreamResetException) {
            return 1037;
        }
        if (iOException instanceof SyncFailedException) {
            return 1038;
        }
        if (iOException instanceof UTFDataFormatException) {
            return 1039;
        }
        if (iOException instanceof UnknownServiceException) {
            return 1040;
        }
        if (iOException instanceof UnsupportedEncodingException) {
            return 1042;
        }
        return Intrinsics.c(iOException != null ? iOException.getMessage() : null, "Canceled") ? 1050 : 480;
    }

    public final int b(int i, NetworkException networkException, boolean z) {
        if (i != 480) {
            return i;
        }
        Integer valueOf = networkException != null ? Integer.valueOf(networkException.getErrorCode()) : null;
        if (valueOf != null && valueOf.intValue() == 1) {
            return 1005;
        }
        if (valueOf != null && valueOf.intValue() == 2) {
            return 1020;
        }
        if (valueOf != null && valueOf.intValue() == 4) {
            return 1008;
        }
        if (valueOf != null && valueOf.intValue() == 6) {
            return 1013;
        }
        if (valueOf != null && valueOf.intValue() == 3) {
            return 1049;
        }
        if (valueOf != null && valueOf.intValue() == 5) {
            return 1046;
        }
        if (valueOf != null && valueOf.intValue() == 7) {
            return 1047;
        }
        if (valueOf != null && valueOf.intValue() == 8) {
            return 1048;
        }
        if (valueOf != null && valueOf.intValue() == 9) {
            return 1006;
        }
        if (valueOf != null && valueOf.intValue() == 10) {
            return 1007;
        }
        return z ? 1050 : 480;
    }
}
