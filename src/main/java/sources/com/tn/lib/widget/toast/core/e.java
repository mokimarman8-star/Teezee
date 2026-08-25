package com.tn.lib.widget.toast.core;

import android.R;
import android.app.Application;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class e extends Toast implements gh.a {
    private View a;
    private TextView b;

    public e(Application application) {
        super(application);
    }

    @Override // gh.a
    public boolean a() {
        return false;
    }

    @Override // gh.a
    public void b(View view) {
        setView(view);
    }

    @Override // gh.a
    public View c() {
        return this.a;
    }

    public TextView d(View view) {
        if (!(view instanceof TextView)) {
            if (view.findViewById(R.id.message) instanceof TextView) {
                return (TextView) view.findViewById(R.id.message);
            }
            throw new IllegalArgumentException("You must include a TextView with an ID value of android.R.id.message");
        }
        if (view.getId() == -1) {
            view.setId(R.id.message);
        } else if (view.getId() != 16908299) {
            throw new IllegalArgumentException("You must set the ID value of TextView to android.R.id.message");
        }
        return (TextView) view;
    }

    @Override // android.widget.Toast, gh.a
    public void setText(CharSequence charSequence) {
        try {
            super.setText(charSequence);
        } catch (Exception unused) {
        }
        TextView textView = this.b;
        if (textView == null) {
            return;
        }
        textView.setText(charSequence);
    }

    @Override // android.widget.Toast
    public void setView(View view) {
        try {
            super.setView(view);
        } catch (Exception unused) {
        }
        if (view == null) {
            this.b = null;
        } else {
            this.a = view;
            this.b = d(view);
        }
    }
}
