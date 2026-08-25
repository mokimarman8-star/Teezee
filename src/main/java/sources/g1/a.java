package g1;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import g1.b;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class a extends BaseAdapter implements Filterable, b.a {

    /* renamed from: a, reason: collision with root package name */
    protected boolean f15340a;

    /* renamed from: b, reason: collision with root package name */
    protected boolean f15341b;

    /* renamed from: c, reason: collision with root package name */
    protected Cursor f15342c;

    /* renamed from: d, reason: collision with root package name */
    protected Context f15343d;

    /* renamed from: e, reason: collision with root package name */
    protected int f15344e;

    /* renamed from: f, reason: collision with root package name */
    protected C0143a f15345f;

    /* renamed from: g, reason: collision with root package name */
    protected DataSetObserver f15346g;

    /* renamed from: h, reason: collision with root package name */
    protected g1.b f15347h;

    /* renamed from: g1.a$a, reason: collision with other inner class name */
    private class C0143a extends ContentObserver {
        C0143a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z5) {
            a.this.i();
        }
    }

    private class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a aVar = a.this;
            aVar.f15340a = true;
            aVar.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            a aVar = a.this;
            aVar.f15340a = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public a(Context context, Cursor cursor, boolean z5) {
        f(context, cursor, z5 ? 1 : 2);
    }

    public void a(Cursor cursor) {
        Cursor j5 = j(cursor);
        if (j5 != null) {
            j5.close();
        }
    }

    public abstract CharSequence b(Cursor cursor);

    @Override // g1.b.a
    public Cursor d() {
        return this.f15342c;
    }

    public abstract void e(View view, Context context, Cursor cursor);

    void f(Context context, Cursor cursor, int i5) {
        if ((i5 & 1) == 1) {
            i5 |= 2;
            this.f15341b = true;
        } else {
            this.f15341b = false;
        }
        boolean z5 = cursor != null;
        this.f15342c = cursor;
        this.f15340a = z5;
        this.f15343d = context;
        this.f15344e = z5 ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i5 & 2) == 2) {
            this.f15345f = new C0143a();
            this.f15346g = new b();
        } else {
            this.f15345f = null;
            this.f15346g = null;
        }
        if (z5) {
            C0143a c0143a = this.f15345f;
            if (c0143a != null) {
                cursor.registerContentObserver(c0143a);
            }
            DataSetObserver dataSetObserver = this.f15346g;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract View g(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.f15340a || (cursor = this.f15342c) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i5, View view, ViewGroup viewGroup) {
        if (!this.f15340a) {
            return null;
        }
        this.f15342c.moveToPosition(i5);
        if (view == null) {
            view = g(this.f15343d, this.f15342c, viewGroup);
        }
        e(view, this.f15343d, this.f15342c);
        return view;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f15347h == null) {
            this.f15347h = new g1.b(this);
        }
        return this.f15347h;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i5) {
        Cursor cursor;
        if (!this.f15340a || (cursor = this.f15342c) == null) {
            return null;
        }
        cursor.moveToPosition(i5);
        return this.f15342c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i5) {
        Cursor cursor;
        if (this.f15340a && (cursor = this.f15342c) != null && cursor.moveToPosition(i5)) {
            return this.f15342c.getLong(this.f15344e);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i5, View view, ViewGroup viewGroup) {
        if (!this.f15340a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (this.f15342c.moveToPosition(i5)) {
            if (view == null) {
                view = h(this.f15343d, this.f15342c, viewGroup);
            }
            e(view, this.f15343d, this.f15342c);
            return view;
        }
        throw new IllegalStateException("couldn't move cursor to position " + i5);
    }

    public abstract View h(Context context, Cursor cursor, ViewGroup viewGroup);

    protected void i() {
        Cursor cursor;
        if (!this.f15341b || (cursor = this.f15342c) == null || cursor.isClosed()) {
            return;
        }
        this.f15340a = this.f15342c.requery();
    }

    public Cursor j(Cursor cursor) {
        Cursor cursor2 = this.f15342c;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0143a c0143a = this.f15345f;
            if (c0143a != null) {
                cursor2.unregisterContentObserver(c0143a);
            }
            DataSetObserver dataSetObserver = this.f15346g;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f15342c = cursor;
        if (cursor != null) {
            C0143a c0143a2 = this.f15345f;
            if (c0143a2 != null) {
                cursor.registerContentObserver(c0143a2);
            }
            DataSetObserver dataSetObserver2 = this.f15346g;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f15344e = cursor.getColumnIndexOrThrow("_id");
            this.f15340a = true;
            notifyDataSetChanged();
        } else {
            this.f15344e = -1;
            this.f15340a = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }
}
