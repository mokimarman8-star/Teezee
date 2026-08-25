package kotlin.concurrent;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000,\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aQ\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {HttpUrl.FRAGMENT_ENCODE_SET, "start", "isDaemon", "Ljava/lang/ClassLoader;", "contextClassLoader", HttpUrl.FRAGMENT_ENCODE_SET, "name", HttpUrl.FRAGMENT_ENCODE_SET, "priority", "Lkotlin/Function0;", HttpUrl.FRAGMENT_ENCODE_SET, "block", "Ljava/lang/Thread;", "a", "(ZZLjava/lang/ClassLoader;Ljava/lang/String;ILkotlin/jvm/functions/Function0;)Ljava/lang/Thread;", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@JvmName
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class ThreadsKt {
    public static final Thread a(boolean z, boolean z2, ClassLoader classLoader, String str, int i, final Function0 block) {
        Intrinsics.h(block, "block");
        Thread thread = new Thread() { // from class: kotlin.concurrent.ThreadsKt$thread$thread$1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                block.invoke();
            }
        };
        if (z2) {
            thread.setDaemon(true);
        }
        if (i > 0) {
            thread.setPriority(i);
        }
        if (str != null) {
            thread.setName(str);
        }
        if (classLoader != null) {
            thread.setContextClassLoader(classLoader);
        }
        if (z) {
            thread.start();
        }
        return thread;
    }

    public static /* synthetic */ Thread b(boolean z, boolean z2, ClassLoader classLoader, String str, int i, Function0 function0, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        boolean z3 = z;
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        boolean z4 = z2;
        ClassLoader classLoader2 = (i2 & 4) != 0 ? null : classLoader;
        String str2 = (i2 & 8) != 0 ? null : str;
        if ((i2 & 16) != 0) {
            i = -1;
        }
        return a(z3, z4, classLoader2, str2, i, function0);
    }
}
