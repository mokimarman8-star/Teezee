package com.tmc.network.strategy;

import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.Serializable;
import java.net.InetAddress;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 +2\u00020\u0001:\u0001,B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ#\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0005J\r\u0010\u0017\u001a\u00020\f¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0005R4\u0010!\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0 0\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R.\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020'0\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010\"\u001a\u0004\b)\u0010$\"\u0004\b*\u0010&¨\u0006-"}, d2 = {"Lcom/tmc/network/strategy/StrategyTable;", "Ljava/io/Serializable;", TtmlNode.ANONYMOUS_REGION_ID, "networkId", "<init>", "(Ljava/lang/String;)V", "host", TtmlNode.ANONYMOUS_REGION_ID, "Ljava/net/InetAddress;", "queryStrategyList", "(Ljava/lang/String;)Ljava/util/List;", "ips", TtmlNode.ANONYMOUS_REGION_ID, "addStrategyList", "(Ljava/lang/String;Ljava/util/List;)V", "address", "removeStrategy", "(Ljava/lang/String;Ljava/net/InetAddress;)V", "table", "convertTable", "(Lcom/tmc/network/strategy/StrategyTable;)Lcom/tmc/network/strategy/StrategyTable;", "toString", "()Ljava/lang/String;", "removeExpired", "()V", TtmlNode.ANONYMOUS_REGION_ID, "checkIsExpire", "(Ljava/lang/String;)Z", "Ljava/lang/String;", "getNetworkId", "setNetworkId", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "hostConnMap", "Ljava/util/concurrent/ConcurrentHashMap;", "getHostConnMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setHostConnMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", TtmlNode.ANONYMOUS_REGION_ID, "historyMap", "getHistoryMap", "setHistoryMap", "Companion", "a", "network_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class StrategyTable implements Serializable {
    private static final transient long MAX_VALID_TIME = 259200000;
    private static final long serialVersionUID = 1;
    private ConcurrentHashMap<String, Long> historyMap;
    private ConcurrentHashMap<String, CopyOnWriteArrayList<InetAddress>> hostConnMap;
    private String networkId;

    public StrategyTable(String str) {
        Intrinsics.h(str, "networkId");
        this.networkId = str;
        this.hostConnMap = new ConcurrentHashMap<>();
        this.historyMap = new ConcurrentHashMap<>();
    }

    public final void addStrategyList(String host, List<? extends InetAddress> ips) {
        Intrinsics.h(host, "host");
        Intrinsics.h(ips, "ips");
        this.hostConnMap.put(host, new CopyOnWriteArrayList<>(ips));
        this.historyMap.put(host, Long.valueOf(System.currentTimeMillis()));
    }

    public final boolean checkIsExpire(String host) {
        Intrinsics.h(host, "host");
        long currentTimeMillis = System.currentTimeMillis();
        Long l = this.historyMap.get(host);
        return l != null && Math.abs(currentTimeMillis - l.longValue()) >= MAX_VALID_TIME;
    }

    public final StrategyTable convertTable(StrategyTable table) {
        Intrinsics.h(table, "table");
        for (Map.Entry<String, CopyOnWriteArrayList<InetAddress>> entry : table.hostConnMap.entrySet()) {
            if (getHostConnMap().get(entry.getKey()) == null) {
                getHostConnMap().put(entry.getKey(), entry.getValue());
                Long l = table.getHistoryMap().get(entry.getKey());
                if (l == null) {
                    l = Long.valueOf(System.currentTimeMillis());
                }
                getHistoryMap().put(entry.getKey(), Long.valueOf(l.longValue()));
            }
        }
        return this;
    }

    public final ConcurrentHashMap<String, Long> getHistoryMap() {
        return this.historyMap;
    }

    public final ConcurrentHashMap<String, CopyOnWriteArrayList<InetAddress>> getHostConnMap() {
        return this.hostConnMap;
    }

    public final String getNetworkId() {
        return this.networkId;
    }

    public final List<InetAddress> queryStrategyList(String host) {
        Intrinsics.h(host, "host");
        CopyOnWriteArrayList<InetAddress> copyOnWriteArrayList = this.hostConnMap.get(host);
        return copyOnWriteArrayList == null ? CollectionsKt.l() : new CopyOnWriteArrayList(copyOnWriteArrayList);
    }

    public final void removeExpired() {
        long currentTimeMillis = System.currentTimeMillis();
        for (Map.Entry<String, Long> entry : this.historyMap.entrySet()) {
            if (Math.abs(currentTimeMillis - entry.getValue().longValue()) >= MAX_VALID_TIME) {
                getHostConnMap().remove(entry.getKey());
                getHistoryMap().remove(entry.getKey());
            }
        }
    }

    public final void removeStrategy(String host) {
        Intrinsics.h(host, "host");
        this.hostConnMap.remove(host);
        this.historyMap.remove(host);
    }

    public final void removeStrategy(String host, InetAddress address) {
        Intrinsics.h(host, "host");
        Intrinsics.h(address, "address");
        CopyOnWriteArrayList<InetAddress> copyOnWriteArrayList = this.hostConnMap.get(host);
        if (copyOnWriteArrayList == null) {
            return;
        }
        copyOnWriteArrayList.remove(address);
        if (copyOnWriteArrayList.isEmpty()) {
            this.hostConnMap.remove(host);
            this.historyMap.remove(host);
        }
    }

    public final void setHistoryMap(ConcurrentHashMap<String, Long> concurrentHashMap) {
        Intrinsics.h(concurrentHashMap, "<set-?>");
        this.historyMap = concurrentHashMap;
    }

    public final void setHostConnMap(ConcurrentHashMap<String, CopyOnWriteArrayList<InetAddress>> concurrentHashMap) {
        Intrinsics.h(concurrentHashMap, "<set-?>");
        this.hostConnMap = concurrentHashMap;
    }

    public final void setNetworkId(String str) {
        Intrinsics.h(str, "<set-?>");
        this.networkId = str;
    }

    public String toString() {
        return "StrategyTable(networkId='" + this.networkId + "', hostConnMap=" + this.hostConnMap + ", historyMap=" + this.historyMap + ')';
    }
}
