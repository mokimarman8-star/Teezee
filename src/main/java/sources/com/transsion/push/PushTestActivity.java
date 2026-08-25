package com.transsion.push;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.v;
import com.blankj.utilcode.util.o;
import com.transsion.baselib.db.notification.MsgBean;
import com.transsion.baselib.db.notification.MsgConfig;
import com.transsion.gslb.BuildConfig;
import com.transsion.push.helper.e;
import com.transsion.push.utils.NotificationUtil;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/transsion/push/PushTestActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", BuildConfig.FLAVOR, "initView", BuildConfig.FLAVOR, "R", "()Ljava/lang/String;", "Q", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "push_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PushTestActivity extends AppCompatActivity {
    private final String Q() {
        return "{\n\"messageId\": \"61145106\",\n\"title\": \"Kedidir Kedi\",\n\"desc\": \"Kedidir Kedi\",\n\"source\": \"push\",\n\"type\": \"1\",\n\"style\": \"1\",\n\"deeplink\": \"oneroom://com.community.oneroom?type=/ab/detail&id=5904172458474619680&channel=push&msgId=%MSGID%&msg_type=9\",\n\"imageList\": \"https://pacdn.aoneroom.com/image/2024/11/01/209d0b40e1b24b81a4fbd9ea150165ec.jpeg\"\n}";
    }

    private final String R() {
        EditText editText = (EditText) findViewById(com.transsion.lib.push.R$id.edTitle);
        Editable text = editText != null ? editText.getText() : null;
        return (text == null || text.length() == 0) ? "Notification Title Test ------- Notification Title Test ------- Notification Title Test" : text.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(PushTestActivity pushTestActivity, View view) {
        MsgBean msgBean = (MsgBean) o.d(pushTestActivity.Q(), MsgBean.class);
        msgBean.setPermanent(true);
        msgBean.setMessageId("611451061");
        msgBean.setTitle(pushTestActivity.R());
        i.d(v.a(pushTestActivity), (CoroutineContext) null, (CoroutineStart) null, new PushTestActivity$initView$1$1(null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void U(PushTestActivity pushTestActivity, View view) {
        MsgBean msgBean = (MsgBean) o.d(pushTestActivity.Q(), MsgBean.class);
        msgBean.setTitle(pushTestActivity.R());
        msgBean.setMessageId(String.valueOf(System.currentTimeMillis()));
        msgBean.setFloat(true);
        e eVar = e.a;
        Intrinsics.e(msgBean);
        eVar.i(pushTestActivity, msgBean);
    }

    private final void initView() {
        findViewById(com.transsion.lib.push.R$id.show_permanent_notification).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.push.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushTestActivity.S(PushTestActivity.this, view);
            }
        });
        findViewById(com.transsion.lib.push.R$id.show_notification).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.push.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushTestActivity.U(PushTestActivity.this, view);
            }
        });
        MsgConfig G = NotificationUtil.a.G();
        StringBuilder sb = new StringBuilder();
        sb.append("config = ");
        sb.append(G);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(savedInstanceState);
        setContentView(com.transsion.lib.push.R$layout.activity_push_test);
        initView();
        NotificationUtil.a.u(this, (MsgConfig) null);
    }
}
