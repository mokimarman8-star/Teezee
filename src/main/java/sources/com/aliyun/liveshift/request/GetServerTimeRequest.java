package com.aliyun.liveshift.request;

import android.content.Context;
import android.text.TextUtils;
import com.aliyun.player.bean.ErrorCode;
import com.aliyun.utils.BaseRequest;
import com.aliyun.utils.HttpClientHelper;
import com.aliyun.utils.JsonUtil;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class GetServerTimeRequest extends BaseRequest {
    private static final String TAG = "GetServerTimeRequest";
    private HttpClientHelper httpClientHelper;
    private WeakReference<Context> mContextWeak;
    private String mHost;

    GetServerTimeRequest(Context context, String str, BaseRequest.OnRequestListener<Long> onRequestListener) {
        super(context, onRequestListener);
        this.httpClientHelper = null;
        this.mHost = str;
        this.mContextWeak = new WeakReference<>(context);
    }

    @Override // com.aliyun.utils.BaseRequest
    public void runInBackground() {
        String str = AgentPageJsBridge.HTTPS + this.mHost + "/openapi/getutc?lhs_start=1";
        if (this.wantStop) {
            sendFailResult(-1, "", "");
            return;
        }
        try {
            HttpClientHelper httpClientHelper = new HttpClientHelper(str);
            this.httpClientHelper = httpClientHelper;
            String doGet = httpClientHelper.doGet();
            if (TextUtils.isEmpty(doGet)) {
                sendFailResult(ErrorCode.ERROR_SERVER_LIVESHIFT_REQUEST_ERROR.getValue(), "request fail", "");
                return;
            }
            if (doGet.split("=").length != 2) {
                sendFailResult(ErrorCode.ERROR_SERVER_LIVESHIFT_REQUEST_ERROR.getValue(), "request fail", "");
                return;
            }
            long j = JsonUtil.getLong(new JSONObject(doGet), "GT");
            if (j == 0) {
                sendFailResult(ErrorCode.ERROR_SERVER_LIVESHIFT_REQUEST_ERROR.getValue(), "request fail", "");
            } else {
                sendSuccessResult(Long.valueOf(j), "");
            }
        } catch (JSONException unused) {
            sendFailResult(ErrorCode.ERROR_SERVER_LIVESHIFT_DATA_PARSER_ERROR.getValue(), "response not json", "");
        } catch (Exception unused2) {
            sendFailResult(ErrorCode.ERROR_SERVER_LIVESHIFT_UNKNOWN.getValue(), "unknow error", "");
        }
    }

    @Override // com.aliyun.utils.BaseRequest
    public void stopInner() {
        HttpClientHelper httpClientHelper = this.httpClientHelper;
        if (httpClientHelper != null) {
            httpClientHelper.stop();
        }
    }
}
