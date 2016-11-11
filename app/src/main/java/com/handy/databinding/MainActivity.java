package com.handy.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.handy.databinding.databinding.ActivityMainBinding;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    UserViewModel mUserViewModel  = new UserViewModel("jtse@handy.com", "12345678", null);
    ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setUser(mUserViewModel);

        Picasso.with(this).load(mUserViewModel.getImageUrl()).into(mBinding.imageView);

        mBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                showToast();
            }
        });
    }

    public void showToast() {
        Toast.makeText(this, "hello world", Toast.LENGTH_SHORT).show();
    }

    public void togglePasswordVisibility() {
        mBinding.passwordField.setVisibility(mBinding.enablePassword.isChecked() ? View.VISIBLE : View.INVISIBLE);
    }
}
