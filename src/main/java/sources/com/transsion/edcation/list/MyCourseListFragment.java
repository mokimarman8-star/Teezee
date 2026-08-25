package com.transsion.edcation.list;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.v;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.StateView;
import com.transsion.baseui.fragment.BaseListFragment;
import com.transsion.edcation.CourseManager;
import com.transsion.edcation.R$string;
import com.transsion.edcation.bean.CourseBean;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.p000enum.BottomTabType;
import com.transsion.push.bean.MsgStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\nJ\u000f\u0010\u0017\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/transsion/edcation/list/MyCourseListFragment;", "Lcom/transsion/baseui/fragment/BaseListFragment;", "Lcom/transsion/edcation/bean/CourseBean;", "<init>", "()V", BuildConfig.FLAVOR, "isShowPageStateLayoutTitle", "()Z", BuildConfig.FLAVOR, "s0", "()Ljava/lang/String;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "m0", "()Lcom/chad/library/adapter/base/BaseQuickAdapter;", BuildConfig.FLAVOR, "initViewData", "G0", "loadMore", "lazyLoadData", "initViewModel", "x0", "getPageStateLayoutTitle", "retryLoadData", "Landroid/view/View;", "q0", "()Landroid/view/View;", "b", "Ljava/lang/String;", "mPageNum", "Education_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class MyCourseListFragment extends BaseListFragment<CourseBean> {

    /* renamed from: b, reason: from kotlin metadata */
    private String mPageNum;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q0(MyCourseListFragment myCourseListFragment) {
        Navigator.x(TheRouter.c("/main/tab").K("bottomTab", BottomTabType.TAB_CODE_HOME).K("topTab", "Education"), myCourseListFragment.requireContext(), (mf.c) null, 2, (Object) null);
        return Unit.a;
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void G0() {
        I0(true);
        this.mPageNum = MsgStyle.CUSTOM_LEFT_PIC;
        lazyLoadData();
    }

    public String getPageStateLayoutTitle() {
        return BuildConfig.FLAVOR;
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void initViewData() {
        super.initViewData();
        showLoadingView();
    }

    public void initViewModel() {
        i.d(v.a(this), (CoroutineContext) null, (CoroutineStart) null, new MyCourseListFragment$initViewModel$1(this, null), 3, (Object) null);
        i.d(v.a(this), (CoroutineContext) null, (CoroutineStart) null, new MyCourseListFragment$initViewModel$2(this, null), 3, (Object) null);
    }

    public boolean isShowPageStateLayoutTitle() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
        CourseManager courseManager = CourseManager.a;
        String str = this.mPageNum;
        if (str == null) {
            str = MsgStyle.CUSTOM_LEFT_PIC;
        }
        CourseManager.r(courseManager, str, null, 2, null);
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void loadMore() {
        lazyLoadData();
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public BaseQuickAdapter m0() {
        return new CourseListAdapter(0, 1, null);
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public View q0() {
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        StateView stateView = new StateView(requireContext);
        String string = getString(R$string.course_list_empy);
        Intrinsics.g(string, "getString(...)");
        stateView.showData(4, 1, false, BuildConfig.FLAVOR, string);
        String string2 = getString(R$string.course_explore_now);
        Intrinsics.g(string2, "getString(...)");
        stateView.setReTryTxt(string2);
        stateView.retry(new Function0() { // from class: com.transsion.edcation.list.e
            public final Object invoke() {
                Unit Q0;
                Q0 = MyCourseListFragment.Q0(MyCourseListFragment.this);
                return Q0;
            }
        });
        return stateView;
    }

    public void retryLoadData() {
        CourseManager.r(CourseManager.a, null, null, 3, null);
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public String s0() {
        return BuildConfig.FLAVOR;
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void x0() {
        super.x0();
        jj.b bVar = (jj.b) getMViewBinding();
        if (bVar != null) {
            bVar.d.setPadding(0, 0, 0, a0.a(12.0f));
            u0();
            BaseListFragment.K0(this, null, 1, null);
        }
    }
}
