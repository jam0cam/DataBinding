package com.handy.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.android.databinding.library.baseAdapters.BR;
import com.squareup.picasso.Picasso;

public class UserViewModel extends BaseObservable {

    private String mUserName;
    private String mPassword;
    private String mImageUrl = "http://cdn02.androidauthority.net/wp-content/uploads/2016/06/Android-Nougat-logo.jpg";

    private boolean mPasswordEnabled = true;

    View.OnClickListener mClickListener;

    public UserViewModel(String userName, String password, View.OnClickListener listener) {
        mUserName = userName;
        mPassword = password;
        mClickListener = listener;
    }


    public String getImageUrl() {
        return mImageUrl;
    }

    public boolean isPasswordEnabled() {
        return mPasswordEnabled;
    }

    public void setPasswordEnabled(final boolean passwordEnabled) {
        mPasswordEnabled = passwordEnabled;
    }

    @Bindable
    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
        notifyPropertyChanged(BR.userName);
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public void buttonClick(View view) {
        if (mClickListener != null) {
            mClickListener.onClick(view);
        }
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String url) {
        Picasso.with(view.getContext()).load(url).into(view);
    }
}
