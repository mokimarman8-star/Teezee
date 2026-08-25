package com.bigkoo.pickerview.view;

import android.view.View;
import com.bigkoo.pickerview.R$id;
import com.bigkoo.pickerview.R$string;
import com.cloud.hisavana.abtestkit.db.ABContentProvider;
import com.contrarywind.view.WheelView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class b {
    public static DateFormat y = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private View a;
    private WheelView b;
    private WheelView c;
    private WheelView d;
    private WheelView e;
    private WheelView f;
    private WheelView g;
    private int h;
    private boolean[] i;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private float u;
    private WheelView.DividerType v;
    private s5.a x;
    private int j = 1900;
    private int k = 2100;
    private int l = 1;
    private int m = 12;
    private int n = 1;
    private int o = 31;
    private boolean w = false;

    class a implements p7.b {
        a() {
        }

        public void a(int i) {
            int h;
            int i2 = i + b.this.j;
            b.this.c.setAdapter(new p5.a(t5.a.d(i2)));
            if (t5.a.g(i2) == 0 || b.this.c.getCurrentItem() <= t5.a.g(i2) - 1) {
                b.this.c.setCurrentItem(b.this.c.getCurrentItem());
            } else {
                b.this.c.setCurrentItem(b.this.c.getCurrentItem() + 1);
            }
            if (t5.a.g(i2) == 0 || b.this.c.getCurrentItem() <= t5.a.g(i2) - 1) {
                b.this.d.setAdapter(new p5.a(t5.a.b(t5.a.h(i2, b.this.c.getCurrentItem() + 1))));
                h = t5.a.h(i2, b.this.c.getCurrentItem() + 1);
            } else if (b.this.c.getCurrentItem() == t5.a.g(i2) + 1) {
                b.this.d.setAdapter(new p5.a(t5.a.b(t5.a.f(i2))));
                h = t5.a.f(i2);
            } else {
                b.this.d.setAdapter(new p5.a(t5.a.b(t5.a.h(i2, b.this.c.getCurrentItem()))));
                h = t5.a.h(i2, b.this.c.getCurrentItem());
            }
            int i3 = h - 1;
            if (b.this.d.getCurrentItem() > i3) {
                b.this.d.setCurrentItem(i3);
            }
            if (b.this.x != null) {
                b.this.x.a();
            }
        }
    }

    /* renamed from: com.bigkoo.pickerview.view.b$b, reason: collision with other inner class name */
    class C0011b implements p7.b {
        C0011b() {
        }

        public void a(int i) {
            int h;
            int currentItem = b.this.b.getCurrentItem() + b.this.j;
            if (t5.a.g(currentItem) == 0 || i <= t5.a.g(currentItem) - 1) {
                int i2 = i + 1;
                b.this.d.setAdapter(new p5.a(t5.a.b(t5.a.h(currentItem, i2))));
                h = t5.a.h(currentItem, i2);
            } else if (b.this.c.getCurrentItem() == t5.a.g(currentItem) + 1) {
                b.this.d.setAdapter(new p5.a(t5.a.b(t5.a.f(currentItem))));
                h = t5.a.f(currentItem);
            } else {
                b.this.d.setAdapter(new p5.a(t5.a.b(t5.a.h(currentItem, i))));
                h = t5.a.h(currentItem, i);
            }
            int i3 = h - 1;
            if (b.this.d.getCurrentItem() > i3) {
                b.this.d.setCurrentItem(i3);
            }
            if (b.this.x != null) {
                b.this.x.a();
            }
        }
    }

    class c implements p7.b {
        final /* synthetic */ List a;
        final /* synthetic */ List b;

        c(List list, List list2) {
            this.a = list;
            this.b = list2;
        }

        public void a(int i) {
            int i2 = i + b.this.j;
            b.this.p = i2;
            int currentItem = b.this.c.getCurrentItem();
            if (b.this.j == b.this.k) {
                b.this.c.setAdapter(new p5.b(b.this.l, b.this.m));
                if (currentItem > b.this.c.getAdapter().a() - 1) {
                    currentItem = b.this.c.getAdapter().a() - 1;
                    b.this.c.setCurrentItem(currentItem);
                }
                int i3 = currentItem + b.this.l;
                if (b.this.l == b.this.m) {
                    b bVar = b.this;
                    bVar.F(i2, i3, bVar.n, b.this.o, this.a, this.b);
                } else if (i3 == b.this.l) {
                    b bVar2 = b.this;
                    bVar2.F(i2, i3, bVar2.n, 31, this.a, this.b);
                } else if (i3 == b.this.m) {
                    b bVar3 = b.this;
                    bVar3.F(i2, i3, 1, bVar3.o, this.a, this.b);
                } else {
                    b.this.F(i2, i3, 1, 31, this.a, this.b);
                }
            } else if (i2 == b.this.j) {
                b.this.c.setAdapter(new p5.b(b.this.l, 12));
                if (currentItem > b.this.c.getAdapter().a() - 1) {
                    currentItem = b.this.c.getAdapter().a() - 1;
                    b.this.c.setCurrentItem(currentItem);
                }
                int i4 = currentItem + b.this.l;
                if (i4 == b.this.l) {
                    b bVar4 = b.this;
                    bVar4.F(i2, i4, bVar4.n, 31, this.a, this.b);
                } else {
                    b.this.F(i2, i4, 1, 31, this.a, this.b);
                }
            } else if (i2 == b.this.k) {
                b.this.c.setAdapter(new p5.b(1, b.this.m));
                if (currentItem > b.this.c.getAdapter().a() - 1) {
                    currentItem = b.this.c.getAdapter().a() - 1;
                    b.this.c.setCurrentItem(currentItem);
                }
                int i8 = 1 + currentItem;
                if (i8 == b.this.m) {
                    b bVar5 = b.this;
                    bVar5.F(i2, i8, 1, bVar5.o, this.a, this.b);
                } else {
                    b.this.F(i2, i8, 1, 31, this.a, this.b);
                }
            } else {
                b.this.c.setAdapter(new p5.b(1, 12));
                b bVar6 = b.this;
                bVar6.F(i2, 1 + bVar6.c.getCurrentItem(), 1, 31, this.a, this.b);
            }
            if (b.this.x != null) {
                b.this.x.a();
            }
        }
    }

    class d implements p7.b {
        final /* synthetic */ List a;
        final /* synthetic */ List b;

        d(List list, List list2) {
            this.a = list;
            this.b = list2;
        }

        public void a(int i) {
            int i2 = i + 1;
            if (b.this.j == b.this.k) {
                int i3 = (i2 + b.this.l) - 1;
                if (b.this.l == b.this.m) {
                    b bVar = b.this;
                    bVar.F(bVar.p, i3, b.this.n, b.this.o, this.a, this.b);
                } else if (b.this.l == i3) {
                    b bVar2 = b.this;
                    bVar2.F(bVar2.p, i3, b.this.n, 31, this.a, this.b);
                } else if (b.this.m == i3) {
                    b bVar3 = b.this;
                    bVar3.F(bVar3.p, i3, 1, b.this.o, this.a, this.b);
                } else {
                    b bVar4 = b.this;
                    bVar4.F(bVar4.p, i3, 1, 31, this.a, this.b);
                }
            } else if (b.this.p == b.this.j) {
                int i4 = (i2 + b.this.l) - 1;
                if (i4 == b.this.l) {
                    b bVar5 = b.this;
                    bVar5.F(bVar5.p, i4, b.this.n, 31, this.a, this.b);
                } else {
                    b bVar6 = b.this;
                    bVar6.F(bVar6.p, i4, 1, 31, this.a, this.b);
                }
            } else if (b.this.p != b.this.k) {
                b bVar7 = b.this;
                bVar7.F(bVar7.p, i2, 1, 31, this.a, this.b);
            } else if (i2 == b.this.m) {
                b bVar8 = b.this;
                bVar8.F(bVar8.p, b.this.c.getCurrentItem() + 1, 1, b.this.o, this.a, this.b);
            } else {
                b bVar9 = b.this;
                bVar9.F(bVar9.p, b.this.c.getCurrentItem() + 1, 1, 31, this.a, this.b);
            }
            if (b.this.x != null) {
                b.this.x.a();
            }
        }
    }

    class e implements p7.b {
        e() {
        }

        public void a(int i) {
            b.this.x.a();
        }
    }

    public b(View view, boolean[] zArr, int i, int i2) {
        this.a = view;
        this.i = zArr;
        this.h = i;
        this.q = i2;
        N(view);
    }

    private void B(int i, int i2, int i3, boolean z, int i4, int i8, int i9) {
        WheelView findViewById = this.a.findViewById(R$id.year);
        this.b = findViewById;
        findViewById.setAdapter(new p5.a(t5.a.e(this.j, this.k)));
        this.b.setLabel("");
        this.b.setCurrentItem(i - this.j);
        this.b.setGravity(this.h);
        WheelView findViewById2 = this.a.findViewById(R$id.month);
        this.c = findViewById2;
        findViewById2.setAdapter(new p5.a(t5.a.d(i)));
        this.c.setLabel("");
        this.c.setConvertMonth(true);
        int g = t5.a.g(i);
        if (g == 0 || (i2 <= g - 1 && !z)) {
            this.c.setCurrentItem(i2);
        } else {
            this.c.setCurrentItem(i2 + 1);
        }
        this.c.setGravity(this.h);
        this.d = this.a.findViewById(R$id.day);
        if (t5.a.g(i) == 0) {
            this.d.setAdapter(new p5.a(t5.a.b(t5.a.h(i, i2))));
        } else {
            this.d.setAdapter(new p5.a(t5.a.b(t5.a.f(i))));
        }
        this.d.setLabel("");
        this.d.setCurrentItem(i3 - 1);
        this.d.setGravity(this.h);
        WheelView findViewById3 = this.a.findViewById(R$id.hour);
        this.e = findViewById3;
        findViewById3.setAdapter(new p5.b(0, 23));
        this.e.setCurrentItem(i4);
        this.e.setGravity(this.h);
        WheelView findViewById4 = this.a.findViewById(R$id.min);
        this.f = findViewById4;
        findViewById4.setAdapter(new p5.b(0, 59));
        this.f.setCurrentItem(i8);
        this.f.setGravity(this.h);
        WheelView findViewById5 = this.a.findViewById(R$id.second);
        this.g = findViewById5;
        findViewById5.setAdapter(new p5.b(0, 59));
        this.g.setCurrentItem(i8);
        this.g.setGravity(this.h);
        this.b.setOnItemSelectedListener(new a());
        this.c.setOnItemSelectedListener(new C0011b());
        q(this.d);
        q(this.e);
        q(this.f);
        q(this.g);
        boolean[] zArr = this.i;
        if (zArr.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.b.setVisibility(zArr[0] ? 0 : 8);
        this.c.setVisibility(this.i[1] ? 0 : 8);
        this.d.setVisibility(this.i[2] ? 0 : 8);
        this.e.setVisibility(this.i[3] ? 0 : 8);
        this.f.setVisibility(this.i[4] ? 0 : 8);
        this.g.setVisibility(this.i[5] ? 0 : 8);
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(int i, int i2, int i3, int i4, List list, List list2) {
        int currentItem = this.d.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.d.setAdapter(new p5.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.d.setAdapter(new p5.b(i3, i4));
        } else if ((i % 4 != 0 || i % 100 == 0) && i % ABContentProvider.LOCAL_AB_SUCCESS != 0) {
            if (i4 > 28) {
                i4 = 28;
            }
            this.d.setAdapter(new p5.b(i3, i4));
        } else {
            if (i4 > 29) {
                i4 = 29;
            }
            this.d.setAdapter(new p5.b(i3, i4));
        }
        if (currentItem > this.d.getAdapter().a() - 1) {
            this.d.setCurrentItem(this.d.getAdapter().a() - 1);
        }
    }

    private void G(int i, int i2, int i3, int i4, int i8, int i9) {
        int i10;
        int i11;
        List asList = Arrays.asList("1", "3", "5", "7", "8", "10", "12");
        List asList2 = Arrays.asList("4", "6", "9", "11");
        this.p = i;
        WheelView findViewById = this.a.findViewById(R$id.year);
        this.b = findViewById;
        findViewById.setAdapter(new p5.b(this.j, this.k));
        this.b.setCurrentItem(i - this.j);
        this.b.setGravity(this.h);
        WheelView findViewById2 = this.a.findViewById(R$id.month);
        this.c = findViewById2;
        findViewById2.setConvertMonth(true);
        int i12 = this.j;
        int i13 = this.k;
        if (i12 == i13) {
            this.c.setAdapter(new p5.b(this.l, this.m));
            this.c.setCurrentItem((i2 + 1) - this.l);
        } else if (i == i12) {
            this.c.setAdapter(new p5.b(this.l, 12));
            this.c.setCurrentItem((i2 + 1) - this.l);
        } else if (i == i13) {
            this.c.setAdapter(new p5.b(1, this.m));
            this.c.setCurrentItem(i2);
        } else {
            this.c.setAdapter(new p5.b(1, 12));
            this.c.setCurrentItem(i2);
        }
        this.c.setGravity(this.h);
        this.d = this.a.findViewById(R$id.day);
        int i14 = this.j;
        int i15 = this.k;
        if (i14 == i15 && this.l == this.m) {
            int i16 = i2 + 1;
            if (asList.contains(String.valueOf(i16))) {
                if (this.o > 31) {
                    this.o = 31;
                }
                this.d.setAdapter(new p5.b(this.n, this.o));
            } else if (asList2.contains(String.valueOf(i16))) {
                if (this.o > 30) {
                    this.o = 30;
                }
                this.d.setAdapter(new p5.b(this.n, this.o));
            } else if ((i % 4 != 0 || i % 100 == 0) && i % ABContentProvider.LOCAL_AB_SUCCESS != 0) {
                if (this.o > 28) {
                    this.o = 28;
                }
                this.d.setAdapter(new p5.b(this.n, this.o));
            } else {
                if (this.o > 29) {
                    this.o = 29;
                }
                this.d.setAdapter(new p5.b(this.n, this.o));
            }
            this.d.setCurrentItem(i3 - this.n);
        } else if (i == i14 && (i11 = i2 + 1) == this.l) {
            if (asList.contains(String.valueOf(i11))) {
                this.d.setAdapter(new p5.b(this.n, 31));
            } else if (asList2.contains(String.valueOf(i11))) {
                this.d.setAdapter(new p5.b(this.n, 30));
            } else if ((i % 4 != 0 || i % 100 == 0) && i % ABContentProvider.LOCAL_AB_SUCCESS != 0) {
                this.d.setAdapter(new p5.b(this.n, 28));
            } else {
                this.d.setAdapter(new p5.b(this.n, 29));
            }
            this.d.setCurrentItem(i3 - this.n);
        } else if (i == i15 && (i10 = i2 + 1) == this.m) {
            if (asList.contains(String.valueOf(i10))) {
                if (this.o > 31) {
                    this.o = 31;
                }
                this.d.setAdapter(new p5.b(1, this.o));
            } else if (asList2.contains(String.valueOf(i10))) {
                if (this.o > 30) {
                    this.o = 30;
                }
                this.d.setAdapter(new p5.b(1, this.o));
            } else if ((i % 4 != 0 || i % 100 == 0) && i % ABContentProvider.LOCAL_AB_SUCCESS != 0) {
                if (this.o > 28) {
                    this.o = 28;
                }
                this.d.setAdapter(new p5.b(1, this.o));
            } else {
                if (this.o > 29) {
                    this.o = 29;
                }
                this.d.setAdapter(new p5.b(1, this.o));
            }
            this.d.setCurrentItem(i3 - 1);
        } else {
            int i17 = i2 + 1;
            if (asList.contains(String.valueOf(i17))) {
                this.d.setAdapter(new p5.b(1, 31));
            } else if (asList2.contains(String.valueOf(i17))) {
                this.d.setAdapter(new p5.b(1, 30));
            } else if ((i % 4 != 0 || i % 100 == 0) && i % ABContentProvider.LOCAL_AB_SUCCESS != 0) {
                this.d.setAdapter(new p5.b(1, 28));
            } else {
                this.d.setAdapter(new p5.b(1, 29));
            }
            this.d.setCurrentItem(i3 - 1);
        }
        this.d.setGravity(this.h);
        WheelView findViewById3 = this.a.findViewById(R$id.hour);
        this.e = findViewById3;
        findViewById3.setAdapter(new p5.b(0, 23));
        this.e.setCurrentItem(i4);
        this.e.setGravity(this.h);
        WheelView findViewById4 = this.a.findViewById(R$id.min);
        this.f = findViewById4;
        findViewById4.setAdapter(new p5.b(0, 59));
        this.f.setCurrentItem(i8);
        this.f.setGravity(this.h);
        WheelView findViewById5 = this.a.findViewById(R$id.second);
        this.g = findViewById5;
        findViewById5.setAdapter(new p5.b(0, 59));
        this.g.setCurrentItem(i9);
        this.g.setGravity(this.h);
        this.b.setOnItemSelectedListener(new c(asList, asList2));
        this.c.setOnItemSelectedListener(new d(asList, asList2));
        q(this.d);
        q(this.e);
        q(this.f);
        q(this.g);
        boolean[] zArr = this.i;
        if (zArr.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.b.setVisibility(zArr[0] ? 0 : 8);
        this.c.setVisibility(this.i[1] ? 0 : 8);
        this.d.setVisibility(this.i[2] ? 0 : 8);
        this.e.setVisibility(this.i[3] ? 0 : 8);
        this.f.setVisibility(this.i[4] ? 0 : 8);
        this.g.setVisibility(this.i[5] ? 0 : 8);
        r();
    }

    private void I() {
        this.d.setTextColorCenter(this.s);
        this.c.setTextColorCenter(this.s);
        this.b.setTextColorCenter(this.s);
        this.e.setTextColorCenter(this.s);
        this.f.setTextColorCenter(this.s);
        this.g.setTextColorCenter(this.s);
    }

    private void K() {
        this.d.setTextColorOut(this.r);
        this.c.setTextColorOut(this.r);
        this.b.setTextColorOut(this.r);
        this.e.setTextColorOut(this.r);
        this.f.setTextColorOut(this.r);
        this.g.setTextColorOut(this.r);
    }

    private String n() {
        int currentItem;
        boolean z;
        int currentItem2;
        StringBuilder sb = new StringBuilder();
        int currentItem3 = this.b.getCurrentItem() + this.j;
        if (t5.a.g(currentItem3) == 0) {
            currentItem2 = this.c.getCurrentItem();
        } else {
            if ((this.c.getCurrentItem() + 1) - t5.a.g(currentItem3) > 0) {
                if ((this.c.getCurrentItem() + 1) - t5.a.g(currentItem3) == 1) {
                    currentItem = this.c.getCurrentItem();
                    z = true;
                    int[] b = t5.b.b(currentItem3, currentItem, this.d.getCurrentItem() + 1, z);
                    sb.append(b[0]);
                    sb.append("-");
                    sb.append(b[1]);
                    sb.append("-");
                    sb.append(b[2]);
                    sb.append(" ");
                    sb.append(this.e.getCurrentItem());
                    sb.append(":");
                    sb.append(this.f.getCurrentItem());
                    sb.append(":");
                    sb.append(this.g.getCurrentItem());
                    return sb.toString();
                }
                currentItem = this.c.getCurrentItem();
                z = false;
                int[] b2 = t5.b.b(currentItem3, currentItem, this.d.getCurrentItem() + 1, z);
                sb.append(b2[0]);
                sb.append("-");
                sb.append(b2[1]);
                sb.append("-");
                sb.append(b2[2]);
                sb.append(" ");
                sb.append(this.e.getCurrentItem());
                sb.append(":");
                sb.append(this.f.getCurrentItem());
                sb.append(":");
                sb.append(this.g.getCurrentItem());
                return sb.toString();
            }
            currentItem2 = this.c.getCurrentItem();
        }
        currentItem = currentItem2 + 1;
        z = false;
        int[] b22 = t5.b.b(currentItem3, currentItem, this.d.getCurrentItem() + 1, z);
        sb.append(b22[0]);
        sb.append("-");
        sb.append(b22[1]);
        sb.append("-");
        sb.append(b22[2]);
        sb.append(" ");
        sb.append(this.e.getCurrentItem());
        sb.append(":");
        sb.append(this.f.getCurrentItem());
        sb.append(":");
        sb.append(this.g.getCurrentItem());
        return sb.toString();
    }

    private void q(WheelView wheelView) {
        if (this.x != null) {
            wheelView.setOnItemSelectedListener(new e());
        }
    }

    private void r() {
        this.d.setTextSize(this.q);
        this.c.setTextSize(this.q);
        this.b.setTextSize(this.q);
        this.e.setTextSize(this.q);
        this.f.setTextSize(this.q);
        this.g.setTextSize(this.q);
    }

    private void t() {
        this.d.setDividerColor(this.t);
        this.c.setDividerColor(this.t);
        this.b.setDividerColor(this.t);
        this.e.setDividerColor(this.t);
        this.f.setDividerColor(this.t);
        this.g.setDividerColor(this.t);
    }

    private void v() {
        this.d.setDividerType(this.v);
        this.c.setDividerType(this.v);
        this.b.setDividerType(this.v);
        this.e.setDividerType(this.v);
        this.f.setDividerType(this.v);
        this.g.setDividerType(this.v);
    }

    private void z() {
        this.d.setLineSpacingMultiplier(this.u);
        this.c.setLineSpacingMultiplier(this.u);
        this.b.setLineSpacingMultiplier(this.u);
        this.e.setLineSpacingMultiplier(this.u);
        this.f.setLineSpacingMultiplier(this.u);
        this.g.setLineSpacingMultiplier(this.u);
    }

    public void A(float f) {
        this.u = f;
        z();
    }

    public void C(boolean z) {
        this.w = z;
    }

    public void D(int i, int i2, int i3, int i4, int i8, int i9) {
        if (!this.w) {
            G(i, i2, i3, i4, i8, i9);
        } else {
            int[] d2 = t5.b.d(i, i2 + 1, i3);
            B(d2[0], d2[1] - 1, d2[2], d2[3] == 1, i4, i8, i9);
        }
    }

    public void E(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            int i4 = this.j;
            if (i > i4) {
                this.k = i;
                this.m = i2;
                this.o = i3;
                return;
            } else {
                if (i == i4) {
                    int i8 = this.l;
                    if (i2 > i8) {
                        this.k = i;
                        this.m = i2;
                        this.o = i3;
                        return;
                    } else {
                        if (i2 != i8 || i3 <= this.n) {
                            return;
                        }
                        this.k = i;
                        this.m = i2;
                        this.o = i3;
                        return;
                    }
                }
                return;
            }
        }
        if (calendar == null || calendar2 != null) {
            if (calendar == null || calendar2 == null) {
                return;
            }
            this.j = calendar.get(1);
            this.k = calendar2.get(1);
            this.l = calendar.get(2) + 1;
            this.m = calendar2.get(2) + 1;
            this.n = calendar.get(5);
            this.o = calendar2.get(5);
            return;
        }
        int i9 = calendar.get(1);
        int i10 = calendar.get(2) + 1;
        int i11 = calendar.get(5);
        int i12 = this.k;
        if (i9 < i12) {
            this.l = i10;
            this.n = i11;
            this.j = i9;
        } else if (i9 == i12) {
            int i13 = this.m;
            if (i10 < i13) {
                this.l = i10;
                this.n = i11;
                this.j = i9;
            } else {
                if (i10 != i13 || i11 >= this.o) {
                    return;
                }
                this.l = i10;
                this.n = i11;
                this.j = i9;
            }
        }
    }

    public void H(int i) {
        this.j = i;
    }

    public void J(int i) {
        this.s = i;
        I();
    }

    public void L(int i) {
        this.r = i;
        K();
    }

    public void M(int i, int i2, int i3, int i4, int i8, int i9) {
        this.d.setTextXOffset(i);
        this.c.setTextXOffset(i2);
        this.b.setTextXOffset(i3);
        this.e.setTextXOffset(i4);
        this.f.setTextXOffset(i8);
        this.g.setTextXOffset(i9);
    }

    public void N(View view) {
        this.a = view;
    }

    public String o() {
        if (this.w) {
            return n();
        }
        StringBuilder sb = new StringBuilder();
        if (this.p == this.j) {
            int currentItem = this.c.getCurrentItem();
            int i = this.l;
            if (currentItem + i == i) {
                sb.append(this.b.getCurrentItem() + this.j);
                sb.append("-");
                sb.append(this.c.getCurrentItem() + this.l);
                sb.append("-");
                sb.append(this.d.getCurrentItem() + this.n);
                sb.append(" ");
                sb.append(this.e.getCurrentItem());
                sb.append(":");
                sb.append(this.f.getCurrentItem());
                sb.append(":");
                sb.append(this.g.getCurrentItem());
            } else {
                sb.append(this.b.getCurrentItem() + this.j);
                sb.append("-");
                sb.append(this.c.getCurrentItem() + this.l);
                sb.append("-");
                sb.append(this.d.getCurrentItem() + 1);
                sb.append(" ");
                sb.append(this.e.getCurrentItem());
                sb.append(":");
                sb.append(this.f.getCurrentItem());
                sb.append(":");
                sb.append(this.g.getCurrentItem());
            }
        } else {
            sb.append(this.b.getCurrentItem() + this.j);
            sb.append("-");
            sb.append(this.c.getCurrentItem() + 1);
            sb.append("-");
            sb.append(this.d.getCurrentItem() + 1);
            sb.append(" ");
            sb.append(this.e.getCurrentItem());
            sb.append(":");
            sb.append(this.f.getCurrentItem());
            sb.append(":");
            sb.append(this.g.getCurrentItem());
        }
        return sb.toString();
    }

    public void p(boolean z) {
        this.d.isCenterLabel(z);
        this.c.isCenterLabel(z);
        this.b.isCenterLabel(z);
        this.e.isCenterLabel(z);
        this.f.isCenterLabel(z);
        this.g.isCenterLabel(z);
    }

    public void s(boolean z) {
        this.b.setCyclic(z);
        this.c.setCyclic(z);
        this.d.setCyclic(z);
        this.e.setCyclic(z);
        this.f.setCyclic(z);
        this.g.setCyclic(z);
    }

    public void u(int i) {
        this.t = i;
        t();
    }

    public void w(WheelView.DividerType dividerType) {
        this.v = dividerType;
        v();
    }

    public void x(int i) {
        this.k = i;
    }

    public void y(String str, String str2, String str3, String str4, String str5, String str6) {
        if (this.w) {
            return;
        }
        if (str != null) {
            this.b.setLabel(str);
        } else {
            this.b.setLabel(this.a.getContext().getString(R$string.pickerview_year));
        }
        if (str2 != null) {
            this.c.setLabel(str2);
        } else {
            this.c.setLabel(this.a.getContext().getString(R$string.pickerview_month));
        }
        if (str3 != null) {
            this.d.setLabel(str3);
        } else {
            this.d.setLabel(this.a.getContext().getString(R$string.pickerview_day));
        }
        if (str4 != null) {
            this.e.setLabel(str4);
        } else {
            this.e.setLabel(this.a.getContext().getString(R$string.pickerview_hours));
        }
        if (str5 != null) {
            this.f.setLabel(str5);
        } else {
            this.f.setLabel(this.a.getContext().getString(R$string.pickerview_minutes));
        }
        if (str6 != null) {
            this.g.setLabel(str6);
        } else {
            this.g.setLabel(this.a.getContext().getString(R$string.pickerview_seconds));
        }
    }
}
