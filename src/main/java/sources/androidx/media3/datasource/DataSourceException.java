package androidx.media3.datasource;

import androidx.annotation.Nullable;
import java.io.IOException;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class DataSourceException extends IOException {

    @Deprecated
    public static final int POSITION_OUT_OF_RANGE = 2008;
    public final int reason;

    public DataSourceException(int i5) {
        this.reason = i5;
    }

    public DataSourceException(@Nullable String str, int i5) {
        super(str);
        this.reason = i5;
    }

    public DataSourceException(@Nullable String str, @Nullable Throwable th, int i5) {
        super(str, th);
        this.reason = i5;
    }

    public DataSourceException(@Nullable Throwable th, int i5) {
        super(th);
        this.reason = i5;
    }

    public static boolean isCausedByPositionOutOfRange(IOException iOException) {
        for (IOException iOException2 = iOException; iOException2 != null; iOException2 = iOException2.getCause()) {
            if ((iOException2 instanceof DataSourceException) && ((DataSourceException) iOException2).reason == 2008) {
                return true;
            }
        }
        return false;
    }
}
