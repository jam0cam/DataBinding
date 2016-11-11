package com.handy.databinding;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.user_name)
    TextInputEditText mUserName;

    @Bind(R.id.password)
    TextInputEditText mPassword;

    @Bind(R.id.password_field)
    TextInputLayout mPasswordField;

    @Bind(R.id.image_view)
    ImageView mImageView;

    @Bind(R.id.enable_password)
    Switch mSwitch;

    @Bind(R.id.result_name)
    TextView mResult;

    UserViewModel mUserViewModel  = new UserViewModel("jtse@handy.com", "12345678", null);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mUserName.setText(mUserViewModel.getUserName());
        mPassword.setText(mUserViewModel.getPassword());

        Picasso.with(this).load(mUserViewModel.getImageUrl()).into(mImageView);

    }

    @OnClick(R.id.button)
    public void showToast() {
        Toast.makeText(this, "hello world", Toast.LENGTH_SHORT).show();

        mUserViewModel.setUserName(mUserName.getText().toString());
        mResult.setText(mUserViewModel.getUserName());
    }

    @OnCheckedChanged(R.id.enable_password)
    public void togglePasswordVisibility() {
        mPasswordField.setVisibility(mSwitch.isChecked() ? View.VISIBLE : View.INVISIBLE);
    }
}
