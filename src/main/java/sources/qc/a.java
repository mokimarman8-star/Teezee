package qc;

import com.google.firebase.messaging.threads.ThreadPriority;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public interface a {
    ExecutorService a(ThreadFactory threadFactory, ThreadPriority threadPriority);
}
