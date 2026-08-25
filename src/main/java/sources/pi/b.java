package pi;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.tencent.mmkv.MMKV;
import com.transsion.base.infras_config.model.ConfigInitData;
import com.transsion.base.infras_config.model.ConfigInitDataItem;
import com.transsion.base.infras_config.model.ConfigInitRspCode;
import com.transsion.base.infras_config.model.ConfigLocalState;
import com.transsion.base.infras_config.model.InfrasSourceType;
import com.transsion.gslb.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b {
    public static final b a = new b();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: pi.a
        public final Object invoke() {
            MMKV i;
            i = b.i();
            return i;
        }
    });

    private b() {
    }

    private final MMKV e() {
        return (MMKV) b.getValue();
    }

    private final String f(InfrasSourceType infrasSourceType) {
        return "source_" + infrasSourceType.name() + "_code";
    }

    private final String g(InfrasSourceType infrasSourceType) {
        return "source_" + infrasSourceType.name() + "_configs";
    }

    private final String h(InfrasSourceType infrasSourceType) {
        return "source_" + infrasSourceType.name() + "_version";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV i() {
        MMKV I = MMKV.I("infras_init_config");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    public final ConfigInitData b(List list) {
        Intrinsics.h(list, "sourceVersions");
        if (list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ConfigInitDataItem c = a.c(((ConfigLocalState) it.next()).getSourceType());
            if (c != null) {
                arrayList.add(c);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new ConfigInitData(e().getString("globalVersion", (String) null), arrayList, null);
    }

    public final ConfigInitDataItem c(InfrasSourceType infrasSourceType) {
        Object obj;
        Intrinsics.h(infrasSourceType, "sourceType");
        try {
            String string = e().getString(g(infrasSourceType), (String) null);
            if (string == null) {
                return null;
            }
            JsonElement parseString = JsonParser.parseString(string);
            Intrinsics.g(parseString, "parseString(...)");
            String string2 = e().getString(h(infrasSourceType), (String) null);
            String string3 = e().getString(f(infrasSourceType), (String) null);
            try {
                Result.Companion companion = Result.Companion;
                if (string3 == null) {
                    string3 = BuildConfig.FLAVOR;
                }
                obj = Result.constructor-impl(ConfigInitRspCode.valueOf(string3));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.a(th2));
            }
            if (Result.isFailure-impl(obj)) {
                obj = null;
            }
            return new ConfigInitDataItem(infrasSourceType, string2, parseString, (ConfigInitRspCode) obj);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final long d() {
        return e().getLong("lastInitTime", 0L);
    }

    public final void j(ConfigInitData configInitData, long j) {
        Intrinsics.h(configInitData, "data");
        k(j);
        String version = configInitData.getVersion();
        if (version != null) {
            a.e().putString("globalVersion", version);
        }
        new Gson();
        List<ConfigInitDataItem> items = configInitData.getItems();
        if (items != null) {
            for (ConfigInitDataItem configInitDataItem : items) {
                InfrasSourceType sourceType = configInitDataItem.getSourceType();
                if (sourceType != null) {
                    JsonElement configs = configInitDataItem.getConfigs();
                    if (configs != null) {
                        b bVar = a;
                        bVar.e().putString(bVar.g(sourceType), configs.toString());
                    }
                    String version2 = configInitDataItem.getVersion();
                    if (version2 != null) {
                        b bVar2 = a;
                        bVar2.e().putString(bVar2.h(sourceType), version2);
                    }
                    ConfigInitRspCode code = configInitDataItem.getCode();
                    if (code != null) {
                        b bVar3 = a;
                        bVar3.e().putString(bVar3.f(sourceType), code.name());
                    }
                }
            }
        }
    }

    public final void k(long j) {
        e().putLong("lastInitTime", j);
    }

    public final void l(List list) {
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            e().M("localStates");
        } else {
            e().putString("localStates", new Gson().toJsonTree(list).toString());
        }
    }
}
