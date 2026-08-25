package com.transsion.publish.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.baseui.R;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.publish.R$drawable;
import com.transsion.publish.R$layout;
import com.transsion.publish.api.AudioEntity;
import com.transsion.publish.api.GroupBean;
import com.transsion.publish.api.LinkEntity;
import com.transsion.publish.ui.SelectLocationActivity;
import com.transsion.room.api.bean.LocationPlace;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class r extends RecyclerView.Adapter {
    private List a = new ArrayList();
    private qo.d b;

    private final void C(RecyclerView.a0 a0Var, int i, rm.a aVar) {
        Intrinsics.f(a0Var, "null cannot be cast to non-null type com.transsion.publish.adapter.SelectLinksHolder");
        y yVar = (y) a0Var;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Intrinsics.f(aVar, "null cannot be cast to non-null type com.transsion.publish.api.LinkEntity");
        LinkEntity linkEntity = (LinkEntity) aVar;
        objectRef.element = linkEntity;
        String url = linkEntity.getUrl();
        String S = url != null ? StringsKt.S(url, "https://www.", BuildConfig.FLAVOR, false, 4, (Object) null) : null;
        String S2 = S != null ? StringsKt.S(S, "http://www.", BuildConfig.FLAVOR, false, 4, (Object) null) : null;
        String S3 = S2 != null ? StringsKt.S(S2, "www.", BuildConfig.FLAVOR, false, 4, (Object) null) : null;
        String S4 = S3 != null ? StringsKt.S(S3, "https://", BuildConfig.FLAVOR, false, 4, (Object) null) : null;
        yVar.g().setText(S4 != null ? StringsKt.S(S4, "http://", BuildConfig.FLAVOR, false, 4, (Object) null) : null);
        yVar.f().setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r.D(r.this, objectRef, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(r rVar, Ref.ObjectRef objectRef, View view) {
        rVar.a.remove(objectRef.element);
        rVar.notifyDataSetChanged();
        List list = rVar.a;
        if (list == null || list.isEmpty()) {
            jo.b bVar = new jo.b();
            bVar.o(4);
            bVar.n(2);
            FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = jo.b.class.getName();
            Intrinsics.g(name, "getName(...)");
            applicationScopeViewModel.postEvent(name, bVar, 0L);
        }
    }

    private final void E(RecyclerView.a0 a0Var, int i, rm.a aVar) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Intrinsics.f(a0Var, "null cannot be cast to non-null type com.transsion.publish.adapter.SelectLocationHolder");
        objectRef.element = (z) a0Var;
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Intrinsics.f(aVar, "null cannot be cast to non-null type com.transsion.room.api.bean.LocationPlace");
        objectRef2.element = (LocationPlace) aVar;
        ((z) objectRef.element).g().setText(((LocationPlace) objectRef2.element).getName() + " " + ((LocationPlace) objectRef2.element).getDistance());
        ((RecyclerView.a0) ((z) objectRef.element)).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r.F(r.this, objectRef, view);
            }
        });
        ((z) objectRef.element).f().setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r.G(objectRef2, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(r rVar, Ref.ObjectRef objectRef, View view) {
        Context context = ((RecyclerView.a0) ((z) objectRef.element)).itemView.getContext();
        Intrinsics.g(context, "getContext(...)");
        rVar.L(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(Ref.ObjectRef objectRef, View view) {
        jo.b bVar = new jo.b();
        bVar.o(8);
        bVar.n(2);
        bVar.q((LocationPlace) objectRef.element);
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = jo.b.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.postEvent(name, bVar, 0L);
    }

    private final void K(Context context) {
        Navigator.x(TheRouter.c("/room/list").z("is_select_room", true).F("index", 1), context, (mf.c) null, 2, (Object) null);
    }

    private final void L(Context context) {
        if (cf.c.a.f(context, "android.permission.ACCESS_FINE_LOCATION")) {
            Intent intent = new Intent(context, (Class<?>) SelectLocationActivity.class);
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
    }

    private final void M(Context context) {
        gj.b bVar = (gj.b) gj.a.a.a(gj.b.class);
        if (bVar != null) {
            bVar.e(context);
        }
    }

    private final void N(RecyclerView.a0 a0Var, int i, rm.a aVar) {
        String str;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Intrinsics.f(a0Var, "null cannot be cast to non-null type com.transsion.publish.adapter.SelectWorkHolder");
        objectRef.element = (n0) a0Var;
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Intrinsics.f(aVar, "null cannot be cast to non-null type com.transsion.moviedetailapi.bean.Subject");
        Subject subject = (Subject) aVar;
        objectRef2.element = subject;
        ImageView f = ((n0) objectRef.element).f();
        int a = com.blankj.utilcode.util.a0.a(42.0f);
        f.a aVar2 = ni.f.a;
        Context context = f.getContext();
        Intrinsics.g(context, "getContext(...)");
        f.b m = aVar2.m(context);
        Cover cover = subject.getCover();
        if (cover == null || (str = cover.getUrl()) == null) {
            str = BuildConfig.FLAVOR;
        }
        m.g(str).i(R.mipmap.home_ic_default_res).m(a).c(a).d(f);
        ((n0) objectRef.element).i().setText(subject.getTitle());
        try {
            Result.Companion companion = Result.Companion;
            AppCompatTextView h = ((n0) objectRef.element).h();
            sm.e eVar = sm.e.a;
            CharSequence e = eVar.e(subject);
            if (e.length() == 0) {
                e = eVar.g(Integer.valueOf(subject.getType()));
            }
            h.setText(e);
            h.setCompoundDrawablesWithIntrinsicBounds(com.transsion.flow.h.a(subject.getSubjectType()), 0, 0, 0);
            Result.constructor-impl(h);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
        if (((Subject) objectRef2.element).getCorrelation()) {
            ((n0) objectRef.element).g().setVisibility(4);
        } else {
            ((n0) objectRef.element).g().setVisibility(0);
            ((n0) objectRef.element).g().setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    r.O(r.this, objectRef2, view);
                }
            });
        }
        ((RecyclerView.a0) ((n0) objectRef.element)).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r.P(r.this, objectRef, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(r rVar, Ref.ObjectRef objectRef, View view) {
        rVar.a.remove(objectRef.element);
        rVar.notifyDataSetChanged();
        if (rVar.a.isEmpty()) {
            jo.b bVar = new jo.b();
            bVar.o(3);
            bVar.n(2);
            FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = jo.b.class.getName();
            Intrinsics.g(name, "getName(...)");
            applicationScopeViewModel.postEvent(name, bVar, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(r rVar, Ref.ObjectRef objectRef, View view) {
        Context context = ((RecyclerView.a0) ((n0) objectRef.element)).itemView.getContext();
        Intrinsics.g(context, "getContext(...)");
        rVar.M(context);
    }

    private final void q(RecyclerView.a0 a0Var, int i, rm.a aVar) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Intrinsics.f(a0Var, "null cannot be cast to non-null type com.transsion.publish.adapter.SelectAudioHolder");
        objectRef.element = (b) a0Var;
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Intrinsics.f(aVar, "null cannot be cast to non-null type com.transsion.publish.api.AudioEntity");
        objectRef2.element = (AudioEntity) aVar;
        ((b) objectRef.element).i().setText(((AudioEntity) objectRef2.element).getImageTitle());
        TextView h = ((b) objectRef.element).h();
        Long duration = ((AudioEntity) objectRef2.element).getDuration();
        h.setText(duration != null ? TimeUtilKt.p(duration.longValue() / 1000) : null);
        qo.d dVar = this.b;
        if (dVar == null || !dVar.b()) {
            ((b) objectRef.element).f().setImageResource(R$drawable.ic_audio_play);
        } else {
            ((b) objectRef.element).f().setImageResource(R$drawable.ic_audio_pause);
        }
        ((RecyclerView.a0) ((b) objectRef.element)).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r.r(r.this, objectRef, objectRef2, view);
            }
        });
        ((b) objectRef.element).g().setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r.t(objectRef2, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(r rVar, final Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, View view) {
        qo.d dVar;
        try {
            if (rVar.b == null) {
                rVar.b = new qo.d();
            }
            qo.d dVar2 = rVar.b;
            if (dVar2 != null && dVar2.b()) {
                ((b) objectRef.element).f().setImageResource(R$drawable.ic_audio_pause);
                qo.d dVar3 = rVar.b;
                if (dVar3 != null) {
                    dVar3.c();
                    return;
                }
                return;
            }
            ((b) objectRef.element).f().setImageResource(R$drawable.ic_audio_play);
            String localPath = ((AudioEntity) objectRef2.element).getLocalPath();
            if (localPath != null && (dVar = rVar.b) != null) {
                Context context = ((RecyclerView.a0) ((b) objectRef.element)).itemView.getContext();
                Intrinsics.g(context, "getContext(...)");
                dVar.d(context, localPath, false, new MediaPlayer.OnCompletionListener() { // from class: com.transsion.publish.adapter.q
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public final void onCompletion(MediaPlayer mediaPlayer) {
                        r.s(objectRef, mediaPlayer);
                    }
                });
            }
            ((b) objectRef.element).f().setImageResource(R$drawable.ic_audio_pause);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(Ref.ObjectRef objectRef, MediaPlayer mediaPlayer) {
        ((b) objectRef.element).f().setImageResource(R$drawable.ic_audio_play);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(Ref.ObjectRef objectRef, View view) {
        jo.b bVar = new jo.b();
        bVar.o(2);
        bVar.n(2);
        bVar.k((AudioEntity) objectRef.element);
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = jo.b.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.postEvent(name, bVar, 0L);
    }

    private final void x(RecyclerView.a0 a0Var, int i, rm.a aVar) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Intrinsics.f(a0Var, "null cannot be cast to non-null type com.transsion.publish.adapter.SelectGroupHolder");
        objectRef.element = (w) a0Var;
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Intrinsics.f(aVar, "null cannot be cast to non-null type com.transsion.publish.api.GroupBean");
        objectRef2.element = (GroupBean) aVar;
        ((w) objectRef.element).g().setText(((GroupBean) objectRef2.element).getName());
        ((RecyclerView.a0) ((w) objectRef.element)).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r.y(r.this, objectRef, view);
            }
        });
        ((w) objectRef.element).f().setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r.z(objectRef2, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(r rVar, Ref.ObjectRef objectRef, View view) {
        Context context = ((RecyclerView.a0) ((w) objectRef.element)).itemView.getContext();
        Intrinsics.g(context, "getContext(...)");
        rVar.K(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(Ref.ObjectRef objectRef, View view) {
        jo.b bVar = new jo.b();
        bVar.o(6);
        bVar.n(2);
        bVar.m((GroupBean) objectRef.element);
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = jo.b.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.postEvent(name, bVar, 0L);
    }

    public final boolean A() {
        List list = this.a;
        return list == null || list.isEmpty();
    }

    public final boolean B() {
        List list = this.a;
        if (list == null || list.isEmpty()) {
            return false;
        }
        List list2 = this.a;
        if (list2 == null || list2.size() != 1 || ((rm.a) this.a.get(0)).getType() == 3) {
            return this.a.size() == 1 && ((rm.a) this.a.get(0)).getType() == 3;
        }
        return true;
    }

    public final void H() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            if (((rm.a) it.next()).getType() == 2) {
                qo.d dVar = this.b;
                if (dVar != null) {
                    dVar.c();
                }
                notifyDataSetChanged();
            }
        }
    }

    public final void I(rm.a aVar) {
        Intrinsics.h(aVar, "entity");
        this.a.remove(aVar);
        notifyDataSetChanged();
    }

    public final void J(rm.a aVar) {
        int i;
        if (aVar == null) {
            return;
        }
        int type = aVar.getType();
        int i2 = 0;
        if (type == 2) {
            i = -1;
            for (Object obj : this.a) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.u();
                }
                if (((rm.a) obj) instanceof AudioEntity) {
                    i = i2;
                }
                i2 = i3;
            }
            qo.d dVar = this.b;
            if (dVar != null) {
                dVar.f();
            }
            this.b = null;
        } else if (type == 3) {
            i = -1;
            for (Object obj2 : this.a) {
                int i4 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.u();
                }
                if (((rm.a) obj2) instanceof Subject) {
                    i = i2;
                }
                i2 = i4;
            }
        } else if (type == 4) {
            i = -1;
            for (Object obj3 : this.a) {
                int i5 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.u();
                }
                if (((rm.a) obj3) instanceof LinkEntity) {
                    i = i2;
                }
                i2 = i5;
            }
        } else if (type == 6) {
            i = -1;
            for (Object obj4 : this.a) {
                int i6 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.u();
                }
                if (((rm.a) obj4) instanceof GroupBean) {
                    i = i2;
                }
                i2 = i6;
            }
        } else if (type != 8) {
            i = -1;
        } else {
            i = -1;
            for (Object obj5 : this.a) {
                int i7 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.u();
                }
                if (((rm.a) obj5) instanceof LocationPlace) {
                    i = i2;
                }
                i2 = i7;
            }
        }
        if (i == -1) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(aVar);
            addData(arrayList);
        } else {
            this.a.set(i, aVar);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(this.a);
            setData(arrayList2);
        }
    }

    public final void addData(List list) {
        Intrinsics.h(list, "data");
        int size = this.a.size();
        this.a.addAll(list);
        notifyItemRangeInserted(size, list.size());
    }

    public int getItemCount() {
        return this.a.size();
    }

    public int getItemViewType(int i) {
        int type = ((rm.a) this.a.get(i)).getType();
        int i2 = 2;
        if (type != 2) {
            i2 = 3;
            if (type != 3) {
                i2 = 4;
                if (type != 4) {
                    i2 = 6;
                    if (type != 6) {
                        i2 = 8;
                        if (type != 8) {
                            return 0;
                        }
                    }
                }
            }
        }
        return i2;
    }

    public void onBindViewHolder(RecyclerView.a0 a0Var, int i) {
        Intrinsics.h(a0Var, "holder");
        rm.a aVar = (rm.a) this.a.get(i);
        int type = aVar.getType();
        if (type == 2) {
            q(a0Var, i, aVar);
            return;
        }
        if (type == 3) {
            N(a0Var, i, aVar);
            return;
        }
        if (type == 4) {
            C(a0Var, i, aVar);
        } else if (type == 6) {
            x(a0Var, i, aVar);
        } else {
            if (type != 8) {
                return;
            }
            E(a0Var, i, aVar);
        }
    }

    public RecyclerView.a0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.h(viewGroup, "parent");
        if (i == 2) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.item_publish_music, viewGroup, false);
            Intrinsics.e(inflate);
            return new b(inflate);
        }
        if (i == 3) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.item_publish_work, viewGroup, false);
            Intrinsics.e(inflate2);
            return new n0(inflate2);
        }
        if (i == 4) {
            View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.item_publish_link, viewGroup, false);
            Intrinsics.e(inflate3);
            return new y(inflate3);
        }
        if (i == 6) {
            View inflate4 = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.item_publish_group, viewGroup, false);
            Intrinsics.e(inflate4);
            return new w(inflate4);
        }
        if (i != 8) {
            return new c(null);
        }
        View inflate5 = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.item_publish_location, viewGroup, false);
        Intrinsics.e(inflate5);
        return new z(inflate5);
    }

    public final void setData(List list) {
        Intrinsics.h(list, "data");
        this.a.clear();
        this.a.addAll(list);
        notifyDataSetChanged();
    }

    public final void u() {
        qo.d dVar = this.b;
        if (dVar != null) {
            dVar.f();
        }
    }

    public final List v() {
        return this.a;
    }

    public final String w() {
        String str = BuildConfig.FLAVOR;
        for (Subject subject : this.a) {
            if (subject.getType() == 3) {
                Intrinsics.f(subject, "null cannot be cast to non-null type com.transsion.moviedetailapi.bean.Subject");
                str = String.valueOf(subject.getSubjectId());
            }
        }
        return str;
    }
}
