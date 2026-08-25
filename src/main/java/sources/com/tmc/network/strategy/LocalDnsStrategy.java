package com.tmc.network.strategy;

import android.content.Context;
import com.tmc.network.NetworkConfig;
import com.tmc.network.NetworkMonitor;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okhttp3.Dns;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class LocalDnsStrategy implements Dns {
    public static final a c = new a(null);
    private static AtomicBoolean d = new AtomicBoolean(false);
    private ConcurrentHashMap a = new ConcurrentHashMap();
    private AtomicBoolean b = new AtomicBoolean(false);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LocalDnsStrategy a() {
            return b.a.a();
        }
    }

    private static final class b {
        public static final b a = new b();
        private static final LocalDnsStrategy b = new LocalDnsStrategy();

        private b() {
        }

        public final LocalDnsStrategy a() {
            return b;
        }
    }

    public final class c implements NetworkMonitor.INetworkChangeListener {
        final /* synthetic */ LocalDnsStrategy a;

        public c(LocalDnsStrategy localDnsStrategy) {
            Intrinsics.h(localDnsStrategy, "this$0");
            this.a = localDnsStrategy;
        }

        @Override // com.tmc.network.NetworkMonitor.INetworkChangeListener
        public void onNetworkChanged(NetworkMonitor.NetworkStatus networkStatus) {
            Intrinsics.h(networkStatus, "status");
            this.a.j();
        }
    }

    private final List f(final String str) {
        try {
            String networkId = NetworkMonitor.INSTANCE.getNetworkId();
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Object obj = this.a.get(networkId);
            objectRef.element = obj;
            if (obj == null) {
                StrategyTable strategyTable = new StrategyTable(networkId);
                objectRef.element = strategyTable;
                this.a.put(networkId, strategyTable);
            }
            List<InetAddress> queryStrategyList = ((StrategyTable) objectRef.element).queryStrategyList(str);
            List<InetAddress> list = queryStrategyList;
            if (list != null && !list.isEmpty()) {
                rf.c a2 = rf.c.c.a();
                if (a2 != null) {
                    a2.a(new Runnable() { // from class: com.tmc.network.strategy.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            LocalDnsStrategy.g(objectRef, str, this);
                        }
                    });
                }
                return queryStrategyList;
            }
            InetAddress[] allByName = InetAddress.getAllByName(str);
            if (allByName != null && allByName.length != 0) {
                StrategyTable strategyTable2 = (StrategyTable) objectRef.element;
                Intrinsics.g(allByName, "ips");
                strategyTable2.addStrategyList(str, ArraysKt.J0(allByName));
                l();
                return ArraysKt.G0(allByName);
            }
            return null;
        } catch (Throwable th) {
            rf.b.a.e(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Ref.ObjectRef objectRef, String str, LocalDnsStrategy localDnsStrategy) {
        Intrinsics.h(objectRef, "$table");
        Intrinsics.h(str, "$host");
        Intrinsics.h(localDnsStrategy, "this$0");
        try {
            if (((StrategyTable) objectRef.element).checkIsExpire(str)) {
                ((StrategyTable) objectRef.element).removeStrategy(str);
                InetAddress[] allByName = InetAddress.getAllByName(str);
                if (allByName != null && allByName.length != 0) {
                    StrategyTable strategyTable = (StrategyTable) objectRef.element;
                    Intrinsics.g(allByName, "ips");
                    strategyTable.addStrategyList(str, ArraysKt.J0(allByName));
                    localDnsStrategy.l();
                }
            }
        } catch (Throwable th) {
            rf.b.a.e(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        final String networkId = NetworkMonitor.INSTANCE.getNetworkId();
        if (this.a.get(networkId) != null) {
            rf.b.a.c("map already has this strategy.");
            return;
        }
        rf.c a2 = rf.c.c.a();
        if (a2 == null) {
            return;
        }
        a2.b(new Runnable() { // from class: com.tmc.network.strategy.b
            @Override // java.lang.Runnable
            public final void run() {
                LocalDnsStrategy.k(networkId, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(String str, LocalDnsStrategy localDnsStrategy) {
        Intrinsics.h(str, "$netId");
        Intrinsics.h(localDnsStrategy, "this$0");
        if (Intrinsics.c(str, "unknown")) {
            rf.b.a.c("network is invalid.");
            return;
        }
        qf.b bVar = qf.b.a;
        StrategyTable strategyTable = (StrategyTable) bVar.l(str);
        if (strategyTable == null) {
            return;
        }
        strategyTable.removeExpired();
        StrategyTable strategyTable2 = (StrategyTable) localDnsStrategy.a.get(str);
        if (strategyTable2 != null) {
            strategyTable.convertTable(strategyTable2);
        }
        localDnsStrategy.a.put(str, strategyTable);
        rf.b.a.c(Intrinsics.q("restore file ", strategyTable));
        bVar.j();
    }

    private final void l() {
        rf.c a2;
        if (!d.compareAndSet(false, true) || (a2 = rf.c.c.a()) == null) {
            return;
        }
        a2.d(new Runnable() { // from class: com.tmc.network.strategy.LocalDnsStrategy$updateLocalDnsStrategy$1
            @Override // java.lang.Runnable
            public void run() {
                AtomicBoolean atomicBoolean;
                ConcurrentHashMap concurrentHashMap;
                try {
                    atomicBoolean = LocalDnsStrategy.d;
                    atomicBoolean.set(false);
                    String networkId = NetworkMonitor.INSTANCE.getNetworkId();
                    concurrentHashMap = LocalDnsStrategy.this.a;
                    StrategyTable strategyTable = (StrategyTable) concurrentHashMap.get(networkId);
                    if (strategyTable == null) {
                        return;
                    }
                    rf.b.a.c(Intrinsics.q("updateLocalDnsStrategy  table = ", strategyTable));
                    qf.b.a.i(strategyTable, networkId);
                } catch (Throwable th) {
                    rf.b.a.e(th);
                }
            }
        }, 2000L, TimeUnit.MILLISECONDS);
    }

    public final void h(Context context) {
        Intrinsics.h(context, "context");
        try {
            if (this.b.compareAndSet(false, true)) {
                j();
                NetworkMonitor.INSTANCE.registerListener(new c(this));
            }
        } catch (Throwable th) {
            rf.b.a.e(th);
        }
    }

    public final void i(String str, InetAddress inetAddress) {
        Intrinsics.h(str, "host");
        Intrinsics.h(inetAddress, "address");
        try {
            StrategyTable strategyTable = (StrategyTable) this.a.get(NetworkMonitor.INSTANCE.getNetworkId());
            if (strategyTable == null) {
                return;
            }
            strategyTable.removeStrategy(str, inetAddress);
            l();
        } catch (Throwable th) {
            rf.b.a.e(th);
        }
    }

    public List lookup(String str) {
        Intrinsics.h(str, "hostname");
        if (this.b.get() && NetworkConfig.INSTANCE.isNetworkImproveEnable()) {
            List f = f(str);
            if (f != null) {
                return f;
            }
            throw new UnknownHostException(str);
        }
        try {
            return Dns.SYSTEM.lookup(str);
        } catch (Throwable th) {
            rf.b.a.d("LocalDnsStrategy", th.getMessage());
            throw new UnknownHostException(str);
        }
    }
}
