package g1;

import android.database.Cursor;
import android.widget.Filter;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class b extends Filter {

    /* renamed from: a, reason: collision with root package name */
    a f15350a;

    interface a {
        void a(Cursor cursor);

        CharSequence b(Cursor cursor);

        Cursor c(CharSequence charSequence);

        Cursor d();
    }

    b(a aVar) {
        this.f15350a = aVar;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object obj) {
        return this.f15350a.b((Cursor) obj);
    }

    @Override // android.widget.Filter
    protected Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor c5 = this.f15350a.c(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (c5 != null) {
            filterResults.count = c5.getCount();
            filterResults.values = c5;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    @Override // android.widget.Filter
    protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor d5 = this.f15350a.d();
        Object obj = filterResults.values;
        if (obj == null || obj == d5) {
            return;
        }
        this.f15350a.a((Cursor) obj);
    }
}
