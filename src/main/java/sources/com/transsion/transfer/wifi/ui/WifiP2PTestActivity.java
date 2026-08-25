package com.transsion.transfer.wifi.ui;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.therouter.TheRouter;
import com.transsion.transfer.R$id;
import com.transsion.transfer.R$layout;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014¨\u0006\b"}, d2 = {"Lcom/transsion/transfer/wifi/ui/WifiP2PTestActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "onCreate", HttpUrl.FRAGMENT_ENCODE_SET, "savedInstanceState", "Landroid/os/Bundle;", "Transfer_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class WifiP2PTestActivity extends AppCompatActivity {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(WifiP2PTestActivity wifiP2PTestActivity, View view) {
        bu.a aVar = (bu.a) TheRouter.d(bu.a.class, new Object[0]);
        if (aVar != null) {
            aVar.a(wifiP2PTestActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(WifiP2PTestActivity wifiP2PTestActivity, View view) {
        bu.a aVar = (bu.a) TheRouter.d(bu.a.class, new Object[0]);
        if (aVar != null) {
            aVar.b(wifiP2PTestActivity);
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(savedInstanceState);
        setContentView(R$layout.activity_wifi_p2p_test);
        findViewById(R$id.btnWifiCreate).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.transfer.wifi.ui.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WifiP2PTestActivity.Q(WifiP2PTestActivity.this, view);
            }
        });
        findViewById(R$id.btnWifiConnect).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.transfer.wifi.ui.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WifiP2PTestActivity.R(WifiP2PTestActivity.this, view);
            }
        });
    }
}
