package com.example.will.dialogproject.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.example.will.dialogproject.R;

/**
 * Created by will on 2017/11/6.
 */

public class LoginFragment extends DialogFragment {

    private EditText userName;
    private EditText userPwd;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.dialog_login_fragment, null);

        userName = (EditText) view.findViewById(R.id.id_txt_username);
        userPwd = (EditText) view.findViewById(R.id.id_txt_password);

        builder.setView(view)
                .setPositiveButton("Sign in", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (loginInputListener != null) {
                            loginInputListener.onLoginInputComplete(
                                    userName.getText().toString(), userPwd.getText().toString());
                        }
                    }
                })
                .setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        return builder.create();
    }

    public interface LoginInputListener {
        void onLoginInputComplete(String name, String pwd);
    }

    public void setLoginInputListener(LoginInputListener loginInputListener) {
        this.loginInputListener = loginInputListener;
    }

    public LoginInputListener loginInputListener;

}
