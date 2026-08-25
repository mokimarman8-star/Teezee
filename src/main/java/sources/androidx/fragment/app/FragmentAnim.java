package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.annotation.NonNull;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.R;
import androidx.fragment.R$animator;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract class FragmentAnim {

    static class EndViewTransitionAnimation extends AnimationSet implements Runnable {
        private boolean mAnimating;
        private final View mChild;
        private boolean mEnded;
        private final ViewGroup mParent;
        private boolean mTransitionEnded;

        EndViewTransitionAnimation(@NonNull Animation animation, @NonNull ViewGroup viewGroup, @NonNull View view) {
            super(false);
            this.mAnimating = true;
            this.mParent = viewGroup;
            this.mChild = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j5, @NonNull Transformation transformation) {
            this.mAnimating = true;
            if (this.mEnded) {
                return !this.mTransitionEnded;
            }
            if (!super.getTransformation(j5, transformation)) {
                this.mEnded = true;
                OneShotPreDrawListener.add(this.mParent, this);
            }
            return true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j5, @NonNull Transformation transformation, float f5) {
            this.mAnimating = true;
            if (this.mEnded) {
                return !this.mTransitionEnded;
            }
            if (!super.getTransformation(j5, transformation, f5)) {
                this.mEnded = true;
                OneShotPreDrawListener.add(this.mParent, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mEnded || !this.mAnimating) {
                this.mParent.endViewTransition(this.mChild);
                this.mTransitionEnded = true;
            } else {
                this.mAnimating = false;
                this.mParent.post(this);
            }
        }
    }

    static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Animation f8107a;

        /* renamed from: b, reason: collision with root package name */
        public final Animator f8108b;

        a(Animator animator) {
            this.f8107a = null;
            this.f8108b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }

        a(Animation animation) {
            this.f8107a = animation;
            this.f8108b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }
    }

    private static int a(Fragment fragment, boolean z5, boolean z6) {
        return z6 ? z5 ? fragment.getPopEnterAnim() : fragment.getPopExitAnim() : z5 ? fragment.getEnterAnim() : fragment.getExitAnim();
    }

    static a b(Context context, Fragment fragment, boolean z5, boolean z6) {
        int nextTransition = fragment.getNextTransition();
        int a5 = a(fragment, z5, z6);
        fragment.setAnimations(0, 0, 0, 0);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && viewGroup.getTag(R.id.visible_removing_fragment_view_tag) != null) {
            fragment.mContainer.setTag(R.id.visible_removing_fragment_view_tag, null);
        }
        ViewGroup viewGroup2 = fragment.mContainer;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation onCreateAnimation = fragment.onCreateAnimation(nextTransition, z5, a5);
        if (onCreateAnimation != null) {
            return new a(onCreateAnimation);
        }
        Animator onCreateAnimator = fragment.onCreateAnimator(nextTransition, z5, a5);
        if (onCreateAnimator != null) {
            return new a(onCreateAnimator);
        }
        if (a5 == 0 && nextTransition != 0) {
            a5 = d(context, nextTransition, z5);
        }
        if (a5 != 0) {
            boolean equals = "anim".equals(context.getResources().getResourceTypeName(a5));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(context, a5);
                    if (loadAnimation != null) {
                        return new a(loadAnimation);
                    }
                } catch (Resources.NotFoundException e5) {
                    throw e5;
                } catch (RuntimeException unused) {
                }
            }
            try {
                Animator loadAnimator = AnimatorInflater.loadAnimator(context, a5);
                if (loadAnimator != null) {
                    return new a(loadAnimator);
                }
            } catch (RuntimeException e6) {
                if (equals) {
                    throw e6;
                }
                Animation loadAnimation2 = AnimationUtils.loadAnimation(context, a5);
                if (loadAnimation2 != null) {
                    return new a(loadAnimation2);
                }
            }
        }
        return null;
    }

    private static int c(Context context, int i5) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(android.R.style.Animation.Activity, new int[]{i5});
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private static int d(Context context, int i5, boolean z5) {
        if (i5 == 4097) {
            return z5 ? R$animator.fragment_open_enter : R$animator.fragment_open_exit;
        }
        if (i5 == 8194) {
            return z5 ? R$animator.fragment_close_enter : R$animator.fragment_close_exit;
        }
        if (i5 == 8197) {
            return z5 ? c(context, android.R.attr.activityCloseEnterAnimation) : c(context, android.R.attr.activityCloseExitAnimation);
        }
        if (i5 == 4099) {
            return z5 ? R$animator.fragment_fade_enter : R$animator.fragment_fade_exit;
        }
        if (i5 != 4100) {
            return -1;
        }
        return z5 ? c(context, android.R.attr.activityOpenEnterAnimation) : c(context, android.R.attr.activityOpenExitAnimation);
    }
}
