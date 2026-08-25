package com.transsion.publish.view.operation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.gslb.BuildConfig;
import com.transsion.publish.R$drawable;
import com.transsion.publish.R$id;
import com.transsion.publish.R$layout;
import com.transsion.push.PushConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import so.i;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u001a\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0017\u001a\u00020\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u000b¢\u0006\u0004\b\u0019\u0010\rJ\r\u0010\u001a\u001a\u00020\u000b¢\u0006\u0004\b\u001a\u0010\rJ\u0017\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0013\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b \u0010!J\u0013\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\"¢\u0006\u0004\b#\u0010!J\r\u0010$\u001a\u00020\u000b¢\u0006\u0004\b$\u0010\rJ\u0015\u0010&\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u0006¢\u0006\u0004\b&\u0010'J+\u0010)\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010(\u001a\u00020\u001d¢\u0006\u0004\b)\u0010*R\u0018\u0010-\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010.R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\"\u0010?\u001a\u0002088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010C\u001a\u0002088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010:\u001a\u0004\bA\u0010<\"\u0004\bB\u0010>R\"\u0010G\u001a\u0002088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010:\u001a\u0004\bE\u0010<\"\u0004\bF\u0010>R\"\u0010K\u001a\u0002088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010:\u001a\u0004\bI\u0010<\"\u0004\bJ\u0010>R\u001c\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00060\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u00107R\u001c\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00060\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u00107R\u001c\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00060\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u00107¨\u0006R"}, d2 = {"Lcom/transsion/publish/view/operation/OperationVerticalBarView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", BuildConfig.FLAVOR, "b", "()V", "Landroid/view/View;", "view", "a", "(Landroid/view/View;)V", BuildConfig.FLAVOR, "Lcom/transsion/publish/view/operation/OperationBean;", "list", "Lcom/transsion/publish/adapter/a;", "listener", "setData", "(Ljava/util/List;Lcom/transsion/publish/adapter/a;)V", PushConstants.PUSH_SERVICE_TYPE_SHOW, "hide", "Landroid/view/MotionEvent;", "event", BuildConfig.FLAVOR, "onTouchEvents", "(Landroid/view/MotionEvent;)Z", "getData", "()Ljava/util/List;", BuildConfig.FLAVOR, "getSelectItem", "resetItem", "item", "selectItem", "(I)V", "state", "setItemState", "(ILjava/util/List;Z)V", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "rv", "Landroid/content/Context;", "mContext", "c", "Lcom/transsion/publish/adapter/a;", "Lso/i;", "d", "Lso/i;", "adapter", "e", "Ljava/util/List;", BuildConfig.FLAVOR, "f", "F", "getX1", "()F", "setX1", "(F)V", "x1", "g", "getX2", "setX2", "x2", "h", "getY1", "setY1", "y1", "i", "getY2", "setY2", "y2", "j", "items", "k", "enables", "l", "disables", "Publish_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class OperationVerticalBarView extends FrameLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private RecyclerView rv;

    /* renamed from: b, reason: from kotlin metadata */
    private Context mContext;

    /* renamed from: c, reason: from kotlin metadata */
    private com.transsion.publish.adapter.a listener;

    /* renamed from: d, reason: from kotlin metadata */
    private i adapter;

    /* renamed from: e, reason: from kotlin metadata */
    private List list;

    /* renamed from: f, reason: from kotlin metadata */
    private float x1;

    /* renamed from: g, reason: from kotlin metadata */
    private float x2;

    /* renamed from: h, reason: from kotlin metadata */
    private float y1;

    /* renamed from: i, reason: from kotlin metadata */
    private float y2;

    /* renamed from: j, reason: from kotlin metadata */
    private List items;

    /* renamed from: k, reason: from kotlin metadata */
    private List enables;

    /* renamed from: l, reason: from kotlin metadata */
    private List disables;

    public static final class a implements so.b {
        final /* synthetic */ View b;

        a(View view) {
            this.b = view;
        }

        @Override // so.b
        public void a(OperationBean operationBean, int i) {
            com.transsion.publish.adapter.a aVar;
            Intrinsics.h(operationBean, "item");
            if (operationBean.getStatus() || i == 3) {
                int type = operationBean.getType();
                if (type == 0) {
                    com.transsion.publish.adapter.a aVar2 = OperationVerticalBarView.this.listener;
                    if (aVar2 != null) {
                        Context context = this.b.getContext();
                        Intrinsics.g(context, "getContext(...)");
                        aVar2.startPhoto(context);
                        return;
                    }
                    return;
                }
                if (type == 1) {
                    com.transsion.publish.adapter.a aVar3 = OperationVerticalBarView.this.listener;
                    if (aVar3 != null) {
                        Context context2 = this.b.getContext();
                        Intrinsics.g(context2, "getContext(...)");
                        aVar3.startVideo(context2);
                        return;
                    }
                    return;
                }
                if (type == 2) {
                    com.transsion.publish.adapter.a aVar4 = OperationVerticalBarView.this.listener;
                    if (aVar4 != null) {
                        Context context3 = this.b.getContext();
                        Intrinsics.g(context3, "getContext(...)");
                        aVar4.startAudio(context3);
                        return;
                    }
                    return;
                }
                if (type != 3) {
                    if (type == 4 && (aVar = OperationVerticalBarView.this.listener) != null) {
                        Context context4 = this.b.getContext();
                        Intrinsics.g(context4, "getContext(...)");
                        aVar.startLink(context4);
                        return;
                    }
                    return;
                }
                com.transsion.publish.adapter.a aVar5 = OperationVerticalBarView.this.listener;
                if (aVar5 != null) {
                    Context context5 = this.b.getContext();
                    Intrinsics.g(context5, "getContext(...)");
                    aVar5.startWork(context5);
                }
            }
        }
    }

    public static final class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return OperationVerticalBarView.this.onTouchEvents(motionEvent);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OperationVerticalBarView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OperationVerticalBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OperationVerticalBarView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OperationVerticalBarView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.h(context, "context");
        this.list = new ArrayList();
        this.items = CollectionsKt.q(new Integer[]{0, 1, 2, 3, 4});
        this.enables = CollectionsKt.q(new Integer[]{Integer.valueOf(R$drawable.ic_film_photos), Integer.valueOf(R$drawable.ic_film_videos), Integer.valueOf(R$drawable.ic_film_audio), Integer.valueOf(R$drawable.ic_film_work), Integer.valueOf(R$drawable.ic_film_link)});
        this.disables = CollectionsKt.q(new Integer[]{Integer.valueOf(R$drawable.ic_base_photos_disable), Integer.valueOf(R$drawable.ic_base_video_disable), Integer.valueOf(R$drawable.ic_base_audio_disable), Integer.valueOf(R$drawable.ic_film_work), Integer.valueOf(R$drawable.ic_base_link_disable)});
        this.mContext = context;
        LayoutInflater.from(context).inflate(R$layout.opertaion_vertical_layout, this);
        View rootView = getRootView();
        Intrinsics.g(rootView, "getRootView(...)");
        a(rootView);
    }

    public /* synthetic */ OperationVerticalBarView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    private final void a(View view) {
        this.rv = view.findViewById(R$id.rv);
        this.adapter = new i();
        RecyclerView recyclerView = this.rv;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), 1, false));
            recyclerView.setAdapter(this.adapter);
        }
        b();
        i iVar = this.adapter;
        if (iVar != null) {
            iVar.l(new a(view));
        }
    }

    private final void b() {
        RecyclerView recyclerView = this.rv;
        if (recyclerView != null) {
            recyclerView.setOnTouchListener(new b());
        }
    }

    public final List<OperationBean> getData() {
        List<OperationBean> h;
        i iVar = this.adapter;
        return (iVar == null || (h = iVar.h()) == null) ? new ArrayList() : h;
    }

    public final List<Integer> getSelectItem() {
        List<OperationBean> h;
        ArrayList arrayList = new ArrayList();
        i iVar = this.adapter;
        if (iVar != null && (h = iVar.h()) != null) {
            for (OperationBean operationBean : h) {
                if (operationBean.getStatus() && operationBean.getType() != 3) {
                    arrayList.add(Integer.valueOf(operationBean.getType()));
                }
            }
        }
        return arrayList;
    }

    public final float getX1() {
        return this.x1;
    }

    public final float getX2() {
        return this.x2;
    }

    public final float getY1() {
        return this.y1;
    }

    public final float getY2() {
        return this.y2;
    }

    public final void hide() {
        try {
            setVisibility(8);
            clearAnimation();
            postInvalidate();
        } catch (Exception unused) {
        }
    }

    public final boolean onTouchEvents(MotionEvent event) {
        int action = event != null ? event.getAction() : 0;
        if (action == 0) {
            Float valueOf = event != null ? Float.valueOf(event.getX()) : null;
            Intrinsics.e(valueOf);
            this.x1 = valueOf.floatValue();
            Float valueOf2 = event != null ? Float.valueOf(event.getY()) : null;
            Intrinsics.e(valueOf2);
            this.y1 = valueOf2.floatValue();
        }
        if (action == 1) {
            Float valueOf3 = event != null ? Float.valueOf(event.getX()) : null;
            Intrinsics.e(valueOf3);
            this.x2 = valueOf3.floatValue();
            float y = event.getY();
            this.y2 = y;
            float f = this.y1;
            if (f - y <= 50.0f && y - f > 50.0f) {
                hide();
            }
        }
        return false;
    }

    public final void resetItem() {
        List h;
        i iVar = this.adapter;
        if (iVar != null && (h = iVar.h()) != null) {
            Iterator it = h.iterator();
            while (it.hasNext()) {
                ((OperationBean) it.next()).setStatus(true);
            }
        }
        i iVar2 = this.adapter;
        if (iVar2 != null) {
            iVar2.notifyDataSetChanged();
        }
    }

    public final void selectItem(int item) {
        List<OperationBean> h;
        i iVar = this.adapter;
        if (iVar == null || (h = iVar.h()) == null || item >= h.size()) {
            return;
        }
        OperationBean operationBean = h.get(item);
        Integer valueOf = operationBean != null ? Integer.valueOf(operationBean.getType()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            setItemState(0, h, true);
            setItemState(1, h, false);
            setItemState(2, h, false);
        } else if (valueOf != null && valueOf.intValue() == 1) {
            setItemState(1, h, true);
            setItemState(0, h, false);
            setItemState(2, h, false);
        } else if (valueOf != null && valueOf.intValue() == 2) {
            setItemState(2, h, true);
            setItemState(1, h, false);
            setItemState(0, h, false);
            setItemState(4, h, false);
        } else if (valueOf != null && valueOf.intValue() == 4) {
            setItemState(4, h, true);
            setItemState(2, h, false);
            for (OperationBean operationBean2 : h) {
                if (operationBean2.getType() == 1 && operationBean2.getStatus()) {
                    setItemState(0, h, false);
                }
                if (operationBean2.getType() == 0 && operationBean2.getStatus()) {
                    setItemState(1, h, false);
                }
            }
        }
        i iVar2 = this.adapter;
        if (iVar2 != null) {
            iVar2.notifyDataSetChanged();
        }
    }

    public final void setData(List<OperationBean> list, com.transsion.publish.adapter.a listener) {
        Intrinsics.h(list, "list");
        this.list = list;
        this.listener = listener;
        i iVar = this.adapter;
        if (iVar != null) {
            iVar.setData(list);
        }
    }

    public final void setItemState(int item, List<OperationBean> list, boolean state) {
        Intrinsics.h(list, "list");
        for (OperationBean operationBean : list) {
            if (item == operationBean.getType()) {
                operationBean.setStatus(state);
            }
        }
    }

    public final void setX1(float f) {
        this.x1 = f;
    }

    public final void setX2(float f) {
        this.x2 = f;
    }

    public final void setY1(float f) {
        this.y1 = f;
    }

    public final void setY2(float f) {
        this.y2 = f;
    }

    public final void show() {
        b();
        i iVar = this.adapter;
        if (iVar != null) {
            iVar.notifyDataSetChanged();
        }
        setVisibility(0);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, getHeight(), 0.0f);
        translateAnimation.setDuration(200L);
        translateAnimation.setFillAfter(true);
        startAnimation(translateAnimation);
    }
}
