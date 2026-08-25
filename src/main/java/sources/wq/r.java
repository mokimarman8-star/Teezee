package wq;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.transsion.shorttv._channel.model.ShortTvFilterVal;
import com.transsion.shorttv._channel.model.ShortTvItem;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import wq.r;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class r extends Dialog {
    private RecyclerView a;
    private TextView b;
    private ImageView c;
    private a d;
    private Function1 e;
    private ShortTvItem f;
    private String g;

    public final class a extends RecyclerView.Adapter {
        private final List a;
        private final String b;
        private final Function1 c;
        final /* synthetic */ r d;

        /* renamed from: wq.r$a$a, reason: collision with other inner class name */
        public final class C0100a extends RecyclerView.a0 {
            private final TextView a;
            final /* synthetic */ a b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0100a(a aVar, View view) {
                super(view);
                Intrinsics.h(view, "itemView");
                this.b = aVar;
                this.a = (TextView) view;
            }

            public final TextView f() {
                return this.a;
            }
        }

        public a(r rVar, List list, String str, Function1 function1) {
            Intrinsics.h(list, "data");
            Intrinsics.h(function1, "onItemClick");
            this.d = rVar;
            this.a = list;
            this.b = str;
            this.c = function1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(a aVar, ShortTvFilterVal shortTvFilterVal, View view) {
            aVar.c.invoke(shortTvFilterVal);
        }

        public int getItemCount() {
            return this.a.size();
        }

        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(C0100a c0100a, int i) {
            Intrinsics.h(c0100a, "holder");
            final ShortTvFilterVal shortTvFilterVal = (ShortTvFilterVal) this.a.get(i);
            c0100a.f().setText(shortTvFilterVal.getName());
            if (Intrinsics.c(shortTvFilterVal.getId(), this.b)) {
                c0100a.f().setTextColor(-1);
                c0100a.f().setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                c0100a.f().setTextColor(-1);
                c0100a.f().setTypeface(Typeface.DEFAULT);
            }
            ((RecyclerView.a0) c0100a).itemView.setOnClickListener(new View.OnClickListener() { // from class: wq.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    r.a.i(r.a.this, shortTvFilterVal, view);
                }
            });
        }

        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public C0100a onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.h(viewGroup, "parent");
            TextView textView = new TextView(viewGroup.getContext());
            textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            textView.setPadding(a0.a(16.0f), 0, a0.a(16.0f), a0.a(37.0f));
            textView.setGravity(8388627);
            textView.setTextSize(16.0f);
            textView.setTextColor(-1);
            return new C0100a(this, textView);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(Context context) {
        super(context, R.style.Theme.Black.NoTitleBar.Fullscreen);
        Intrinsics.h(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(r rVar, View view) {
        rVar.dismiss();
        Function1 function1 = rVar.e;
        if (function1 != null) {
            function1.invoke((Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(r rVar, ShortTvFilterVal shortTvFilterVal) {
        Intrinsics.h(shortTvFilterVal, "selected");
        rVar.dismiss();
        Function1 function1 = rVar.e;
        if (function1 != null) {
            function1.invoke(shortTvFilterVal.getId());
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(r rVar, View view) {
        rVar.dismiss();
        Function1 function1 = rVar.e;
        if (function1 != null) {
            function1.invoke((Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(r rVar, Function1 function1, ShortTvFilterVal shortTvFilterVal) {
        Intrinsics.h(shortTvFilterVal, "selected");
        rVar.dismiss();
        function1.invoke(shortTvFilterVal.getId());
        return Unit.a;
    }

    public final void j(ShortTvItem shortTvItem, String str, final Function1 function1) {
        Intrinsics.h(shortTvItem, "item");
        Intrinsics.h(function1, "callback");
        this.f = shortTvItem;
        this.g = str;
        this.e = function1;
        if (!isShowing()) {
            show();
            return;
        }
        TextView textView = this.b;
        RecyclerView recyclerView = null;
        if (textView == null) {
            Intrinsics.y("mTitleTv");
            textView = null;
        }
        textView.setText(shortTvItem.getTitle());
        this.d = new a(this, shortTvItem.getFilterValsV2(), str, new Function1() { // from class: wq.p
            public final Object invoke(Object obj) {
                Unit k;
                k = r.k(r.this, function1, (ShortTvFilterVal) obj);
                return k;
            }
        });
        RecyclerView recyclerView2 = this.a;
        if (recyclerView2 == null) {
            Intrinsics.y("mRecyclerView");
        } else {
            recyclerView = recyclerView2;
        }
        recyclerView.setAdapter(this.d);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setLayout(-1, -1);
        }
        Window window3 = getWindow();
        if (window3 != null) {
            window3.addFlags(Integer.MIN_VALUE);
        }
        Window window4 = getWindow();
        if (window4 != null) {
            window4.setStatusBarColor(getContext().getResources().getColor(com.transsion.shorttv.R.color.short_tv_black_90));
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(linearLayout.getContext().getResources().getColor(com.transsion.shorttv.R.color.short_tv_black_90));
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: wq.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r.f(r.this, view);
            }
        });
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        linearLayout2.setPadding(a0.a(16.0f), a0.a(12.0f), a0.a(16.0f), a0.a(12.0f));
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout2.setClickable(true);
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: wq.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r.h(view);
            }
        });
        TextView textView = new TextView(getContext());
        textView.setTextSize(18.0f);
        textView.setTextColor(-1);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        this.b = textView;
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(com.transsion.shorttv.R.drawable.short_tv_music_iv_close);
        imageView.setColorFilter(imageView.getContext().getResources().getColor(com.transsion.shorttv.R.color.short_tv_white));
        imageView.setLayoutParams(new LinearLayout.LayoutParams(a0.a(21.0f), a0.a(21.0f)));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: wq.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r.i(r.this, view);
            }
        });
        this.c = imageView;
        TextView textView2 = this.b;
        RecyclerView recyclerView = null;
        if (textView2 == null) {
            Intrinsics.y("mTitleTv");
            textView2 = null;
        }
        linearLayout2.addView(textView2);
        ImageView imageView2 = this.c;
        if (imageView2 == null) {
            Intrinsics.y("mCloseBtn");
            imageView2 = null;
        }
        linearLayout2.addView(imageView2);
        linearLayout.addView(linearLayout2);
        View view = new View(getContext());
        view.setBackgroundColor(view.getContext().getResources().getColor(com.transsion.shorttv.R.color.short_tv_white_10));
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, a0.a(1.0f)));
        linearLayout.addView(view);
        View recyclerView2 = new RecyclerView(getContext());
        recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext()));
        recyclerView2.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        recyclerView2.setPadding(0, a0.a(23.0f), 0, a0.a(40.0f));
        recyclerView2.setClipToPadding(false);
        recyclerView2.setClickable(true);
        this.a = recyclerView2;
        linearLayout.addView(recyclerView2);
        setContentView(linearLayout);
        ShortTvItem shortTvItem = this.f;
        if (shortTvItem != null) {
            TextView textView3 = this.b;
            if (textView3 == null) {
                Intrinsics.y("mTitleTv");
                textView3 = null;
            }
            textView3.setText(shortTvItem.getTitle());
            this.d = new a(this, shortTvItem.getFilterValsV2(), this.g, new Function1() { // from class: wq.o
                public final Object invoke(Object obj) {
                    Unit g;
                    g = r.g(r.this, (ShortTvFilterVal) obj);
                    return g;
                }
            });
            RecyclerView recyclerView3 = this.a;
            if (recyclerView3 == null) {
                Intrinsics.y("mRecyclerView");
            } else {
                recyclerView = recyclerView3;
            }
            recyclerView.setAdapter(this.d);
        }
    }
}
