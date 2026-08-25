package com.transsion.moviedetail.fragment;

import java.util.HashSet;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a implements cm.g {
    @Override // cm.g
    public HashSet providerParams() {
        HashSet hashSet = new HashSet();
        hashSet.add("sa_for_you_request_count");
        hashSet.add("sa_detail_for_you_insert_posts");
        hashSet.add(SubjectListFragment.KEY_POST_EXPOSURE_PERCENT);
        hashSet.add("sa_restrict_tips");
        return hashSet;
    }
}
