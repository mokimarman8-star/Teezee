package com.tmc.network;

import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import okhttp3.Call;
import okhttp3.Response;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/tmc/network/INetworkCallback;", TtmlNode.ANONYMOUS_REGION_ID, "onFailure", TtmlNode.ANONYMOUS_REGION_ID, "call", "Lokhttp3/Call;", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onResponse", "response", "Lokhttp3/Response;", "network_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public interface INetworkCallback {
    void onFailure(Call call, Exception e);

    void onResponse(Call call, Response response);
}
