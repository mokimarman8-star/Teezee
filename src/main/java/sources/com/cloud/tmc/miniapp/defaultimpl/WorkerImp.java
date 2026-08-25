package com.cloud.tmc.miniapp.defaultimpl;

import com.cloud.tmc.kernel.framework.FrameworkConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.WorkerAnalyseType;
import com.cloud.tmc.kernel.proxy.worker.IWorkerFactory;
import com.cloud.tmc.kernel.proxy.worker.JSAheadParamsProxy;
import com.cloud.tmc.kernel.worker.IWorker;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.cloud.tmc.worker.debug.WebviewWorker;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class WorkerImp implements IWorkerFactory {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004a A[Catch: all -> 0x0053, TryCatch #0 {all -> 0x0053, blocks: (B:10:0x003e, B:12:0x004a, B:13:0x0056), top: B:9:0x003e }] */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.cloud.tmc.kernel.worker.IWorker] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [com.cloud.tmc.kernel.worker.IWorker] */
    /* JADX WARN: Type inference failed for: r1v9 */
    @Override // com.cloud.tmc.kernel.proxy.worker.IWorkerFactory
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public IWorker createWorker(String str, Node node) {
        ?? r1;
        try {
            int workerType = workerType();
            try {
                if (workerType == 2) {
                    ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record("", WorkerAnalyseType.CONSOLE, "worker from quickJS");
                } else if (workerType == 3) {
                    ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record("", WorkerAnalyseType.CONSOLE, "worker from webview");
                    r1 = new WebviewWorker(str, node, ByteAppManager.getSApplication(), null, 8, null);
                    ((JSAheadParamsProxy) TmcProxy.get(JSAheadParamsProxy.class)).setParams(MapsKt.f(TuplesKt.a(FrameworkConstants.GLOBAL_DATA_KEY_WORKER_TYPE, String.valueOf(r1 != 0 ? Integer.valueOf(r1.type()) : null))));
                    return r1;
                }
                ((JSAheadParamsProxy) TmcProxy.get(JSAheadParamsProxy.class)).setParams(MapsKt.f(TuplesKt.a(FrameworkConstants.GLOBAL_DATA_KEY_WORKER_TYPE, String.valueOf(r1 != 0 ? Integer.valueOf(r1.type()) : null))));
                return r1;
            } catch (Throwable th) {
                th = th;
                r0 = r1;
                TmcLogger.e(OfflineConstantsKt.OFFLINE_TYPE_MINIAPP, "create worker fail : " + th + " ; workerType = " + workerType());
                return r0;
            }
            r1 = 0;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.worker.IWorkerFactory
    public int workerType() {
        return 3;
    }
}
