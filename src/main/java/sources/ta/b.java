package ta;

import android.widget.CompoundButton;
import com.google.android.material.chip.Chip;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final /* synthetic */ class b implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ Chip a;

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        Chip.a(this.a, compoundButton, z);
    }
}
