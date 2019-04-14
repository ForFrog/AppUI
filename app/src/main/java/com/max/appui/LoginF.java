package com.max.appui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class LoginF extends Fragment implements View.OnClickListener {


    private Activity mActivity;

    private Button btnFb;
    private Button btnGg;


    private OnLoginFragmentListener listener;

    public static LoginF newInstance(Bundle b) {
        LoginF f = new LoginF();
        f.setArguments(b);   //设置参数
        return f;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
        Bundle arguments = getArguments();//获取参数

        if (context instanceof OnLoginFragmentListener) {
            listener = (OnLoginFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        init(view);
        return view;
    }


    private void init(View view) {
        btnFb = (Button) view.findViewById(R.id.btn_fb);
        btnFb.setOnClickListener(this);
        btnGg = (Button) view.findViewById(R.id.btn_gg);

    }

    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.toConfigInfo();
        }

    }


    public interface OnLoginFragmentListener {
        void toConfigInfo();
    }
}
