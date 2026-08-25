package g1;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class c extends a {

    /* renamed from: i, reason: collision with root package name */
    private int f15351i;

    /* renamed from: j, reason: collision with root package name */
    private int f15352j;

    /* renamed from: k, reason: collision with root package name */
    private LayoutInflater f15353k;

    public c(Context context, int i5, Cursor cursor, boolean z5) {
        super(context, cursor, z5);
        this.f15352j = i5;
        this.f15351i = i5;
        this.f15353k = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // g1.a
    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f15353k.inflate(this.f15352j, viewGroup, false);
    }

    @Override // g1.a
    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f15353k.inflate(this.f15351i, viewGroup, false);
    }
}
