package com.transsion.payment.lib;

import com.tn.tranpay.logger.LogLevel;
import com.tn.tranpay.logger.LoggerPlugin;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/transsion/payment/lib/PayLoggerPlugin;", "Lcom/tn/tranpay/logger/LoggerPlugin;", "<init>", "()V", "log", BuildConfig.FLAVOR, "level", "Lcom/tn/tranpay/logger/LogLevel;", "tag", BuildConfig.FLAVOR, "message", "LibPayment_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PayLoggerPlugin implements LoggerPlugin {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[LogLevel.values().length];
            try {
                iArr[LogLevel.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LogLevel.INFO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LogLevel.WARNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LogLevel.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    public void log(LogLevel level, String tag, String message) {
        Intrinsics.h(level, "level");
        Intrinsics.h(tag, "tag");
        Intrinsics.h(message, "message");
        int i = a.a[level.ordinal()];
        if (i == 1) {
            a.a.f(wf.a.a, tag, message, false, 4, (Object) null);
            return;
        }
        if (i == 2) {
            d.a.a(message);
        } else if (i == 3) {
            d.a.c(message);
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            d.a.b(message);
        }
    }
}
