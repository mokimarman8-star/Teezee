package com.hisavana.common.interfacz;

import com.hisavana.common.bean.Network;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public interface QueryPriceListener {
    void onQueryPriceFailed();

    void onQueryPriceSuccess(List<Network> list);
}
