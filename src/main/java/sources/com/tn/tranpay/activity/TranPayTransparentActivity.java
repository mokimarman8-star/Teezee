package com.tn.tranpay.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import com.cloud.tmc.kernel.bridge.RenderCallContext;
import com.tn.tranpay.BillingParams;
import com.tn.tranpay.TranPayClient;
import com.tn.tranpay.c;
import com.tn.tranpay.d;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import lh.a;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\u0003¨\u0006\u000b"}, d2 = {"Lcom/tn/tranpay/activity/TranPayTransparentActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "a", "lib_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class TranPayTransparentActivity extends AppCompatActivity {

    /* renamed from: a, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map b = new LinkedHashMap();

    /* renamed from: com.tn.tranpay.activity.TranPayTransparentActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, BillingParams billingParams, d dVar) {
            Intrinsics.h(context, "context");
            Intrinsics.h(billingParams, "params");
            Intrinsics.h(dVar, RenderCallContext.TYPE_CALLBACK);
            long currentTimeMillis = System.currentTimeMillis();
            double random = Math.random();
            StringBuilder sb = new StringBuilder();
            sb.append(currentTimeMillis);
            sb.append(random);
            String sb2 = sb.toString();
            TranPayTransparentActivity.b.put(sb2, dVar);
            Intent intent = new Intent(context, (Class<?>) TranPayTransparentActivity.class);
            intent.putExtra("extra_billing_params", billingParams);
            intent.putExtra("extra_callback_id", sb2);
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public static final class b implements d {
        final /* synthetic */ d a;
        final /* synthetic */ TranPayTransparentActivity b;

        b(d dVar, TranPayTransparentActivity tranPayTransparentActivity) {
            this.a = dVar;
            this.b = tranPayTransparentActivity;
        }

        @Override // com.tn.tranpay.d
        public void a(com.tn.tranpay.b bVar, c cVar) {
            Intrinsics.h(bVar, "result");
            a aVar = a.a;
            a.g(aVar, "TranPayTransparentActivity: Payment callback received, code=" + bVar.b(), null, 2, null);
            this.a.a(bVar, cVar);
            a.g(aVar, "TranPayTransparentActivity: Payment completed, finishing activity", null, 2, null);
            this.b.finish();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(savedInstanceState);
        Window window = getWindow();
        if (window != null) {
            window.setStatusBarColor(0);
            window.setNavigationBarColor(0);
            window.setFlags(67108864, 67108864);
            window.addFlags(128);
        }
        a aVar = a.a;
        a.g(aVar, "TranPayTransparentActivity: onCreate, keeping activity alive", null, 2, null);
        BillingParams billingParams = (BillingParams) getIntent().getParcelableExtra("extra_billing_params");
        String stringExtra = getIntent().getStringExtra("extra_callback_id");
        d dVar = stringExtra != null ? (d) b.get(stringExtra) : null;
        if (billingParams == null || dVar == null) {
            a.e(aVar, "TranPayTransparentActivity: missing params or callback", null, 2, null);
            if (dVar != null) {
                dVar.a(new com.tn.tranpay.b(-1, ""), null);
            }
            finish();
            return;
        }
        a.g(aVar, "TranPayTransparentActivity: launching billing flow with txnId: " + billingParams.getTxnId(), null, 2, null);
        a.g(aVar, "TranPayTransparentActivity: Ready to launch payment, will keep activity alive until callback", null, 2, null);
        TranPayClient.a.c(this, billingParams, new b(dVar, this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDestroy() {
        super.onDestroy();
        a aVar = a.a;
        a.e(aVar, "TranPayTransparentActivity: onDestroy - This should only happen after payment callback!", null, 2, null);
        String stringExtra = getIntent().getStringExtra("extra_callback_id");
        if (stringExtra == null || ((d) b.remove(stringExtra)) == null) {
            return;
        }
        a.k(aVar, "TranPayTransparentActivity: Callback was removed due to activity destruction!", null, 2, null);
    }
}
