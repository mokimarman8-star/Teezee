package com.transsion.edcation.list;

import android.os.Bundle;
import android.view.View;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.R;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.edcation.R$string;
import com.transsion.gslb.BuildConfig;
import ij.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/transsion/edcation/list/MyCourseListActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Leh/a;", "<init>", "()V", BuildConfig.FLAVOR, "e0", "d0", "()Leh/a;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "initView", BuildConfig.FLAVOR, "isTranslucent", "()Z", "isStatusDark", BuildConfig.FLAVOR, "getPageName", "()Ljava/lang/String;", "Education_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class MyCourseListActivity extends BaseActivity<eh.a> {
    private final void e0() {
        getSupportFragmentManager().p().s(R.id.container, new MyCourseListFragment()).k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void f0(MyCourseListActivity myCourseListActivity, View view) {
        Navigator.x(TheRouter.c("/edu/history"), myCourseListActivity, (mf.c) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(MyCourseListActivity myCourseListActivity, View view) {
        myCourseListActivity.finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public eh.a getViewBinding() {
        eh.a c = eh.a.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public String getPageName() {
        return "MyCourse List";
    }

    public void initView(Bundle savedInstanceState) {
        TitleLayout titleLayout = getMViewBinding().c;
        titleLayout.setRightView(com.transsion.baseui.R.drawable.ic_history, new View.OnClickListener() { // from class: com.transsion.edcation.list.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyCourseListActivity.f0(MyCourseListActivity.this, view);
            }
        });
        titleLayout.setLeftOnclick(new View.OnClickListener() { // from class: com.transsion.edcation.list.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyCourseListActivity.g0(MyCourseListActivity.this, view);
            }
        });
        titleLayout.setTitleText(R$string.course_list);
        titleLayout.setPadding(0, com.blankj.utilcode.util.d.c(), 0, 0);
        e0();
    }

    public boolean isStatusDark() {
        return !y.a.a();
    }

    public boolean isTranslucent() {
        return true;
    }

    protected void onCreate(Bundle savedInstanceState) {
        TheRouter.l(this);
        super.onCreate(savedInstanceState);
    }
}
