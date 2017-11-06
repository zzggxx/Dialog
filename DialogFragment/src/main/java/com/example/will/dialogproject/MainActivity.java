package com.example.will.dialogproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.will.dialogproject.dialog.EditDialogFragment;
import com.example.will.dialogproject.dialog.LoginFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        findViewById(R.id.oncreate).setOnClickListener(this);
        findViewById(R.id.oncreatedialog).setOnClickListener(this);
    }

    private void showDialogLoginFragment() {
        LoginFragment loginFragment = new LoginFragment();
        loginFragment.show(getSupportFragmentManager(), "loginfragment");
        loginFragment.setLoginInputListener(new LoginFragment.LoginInputListener() {
            @Override
            public void onLoginInputComplete(String name, String pwd) {
                Toast.makeText(MainActivity.this, "name:" + name + "\n" + "pwd" + pwd, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showDialogFragment() {
        EditDialogFragment editDialogFragment = new EditDialogFragment();
//        make use v4 dialogfragment so support.
        editDialogFragment.show(getSupportFragmentManager(), "editdialogfragment");
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.oncreate:
                showDialogFragment();
                break;
            case R.id.oncreatedialog:
                showDialogLoginFragment();
                break;
            default:
                break;
        }
    }
}
