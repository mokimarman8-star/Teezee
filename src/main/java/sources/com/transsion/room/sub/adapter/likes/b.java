package com.transsion.room.sub.adapter.likes;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.transsion.moviedetail.fragment.SubjectListFragment;
import com.transsion.room.R$string;
import com.transsion.room.sub.fragment.likes.UgcLikesFragment;
import com.transsion.usercenter.profile.ProfileSubjectListViewModel;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b extends FragmentStateAdapter {
    private final List a;

    public static final class a {
        private final String a;
        private final Fragment b;

        public a(String str, Fragment fragment) {
            Intrinsics.h(str, "title");
            Intrinsics.h(fragment, "fragment");
            this.a = str;
            this.b = fragment;
        }

        public final Fragment a() {
            return this.b;
        }

        public final String b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.c(this.a, aVar.a) && Intrinsics.c(this.b, aVar.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "TabInfo(title=" + this.a + ", fragment=" + this.b + ")";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        Intrinsics.h(fragmentActivity, "activity");
        String string = fragmentActivity.getString(R$string.play_hub);
        Intrinsics.g(string, "getString(...)");
        a aVar = new a(string, new UgcLikesFragment());
        String string2 = fragmentActivity.getString(R$string.buzz_box);
        Intrinsics.g(string2, "getString(...)");
        this.a = CollectionsKt.o(new a[]{aVar, new a(string2, SubjectListFragment.INSTANCE.a(g(), ProfileSubjectListViewModel.class))});
    }

    private final Bundle g() {
        Bundle bundle = new Bundle();
        bundle.putInt("source", 1);
        return bundle;
    }

    public Fragment createFragment(int i) {
        return ((a) this.a.get(i)).a();
    }

    public int getItemCount() {
        return this.a.size();
    }

    public final String h(int i) {
        return ((a) this.a.get(i)).b();
    }
}
