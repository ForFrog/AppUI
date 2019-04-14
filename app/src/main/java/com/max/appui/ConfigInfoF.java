package com.max.appui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ConfigInfoF extends Fragment implements View.OnClickListener {


    private Activity mActivity;

    private EditText etName;
    private TextView tvSex;
    private Button btnConfirm;


    private OnConfigInfoFragmentListener listener;
    private String name;
    private String sex;
    private AlertDialog alertDialog;


    public static ConfigInfoF newInstance(Bundle b) {
        ConfigInfoF f = new ConfigInfoF();
        f.setArguments(b);   //设置参数
        return f;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
        Bundle arguments = getArguments();//获取参数
        name = arguments.getString("name");
        sex = arguments.getString("sex");

        if (context instanceof OnConfigInfoFragmentListener) {
            listener = (OnConfigInfoFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_config_info, container, false);
        init(view);
        return view;
    }


    private void init(View view) {
        etName = (EditText) view.findViewById(R.id.et_name);
        etName.setText(name);

        tvSex = (TextView) view.findViewById(R.id.tv_sex);
        tvSex.setText(sex);

        btnConfirm = (Button) view.findViewById(R.id.btn_confirm);
        btnConfirm.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        showTipDialog();
    }

    private void showTipDialog() {

        if (alertDialog == null) {
            alertDialog = new AlertDialog.Builder(getActivity()).setTitle("tip")
                    .setMessage("选择之后不能更改")
                    .setPositiveButton("sure", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            if (listener != null) {
                                listener.onPositiveClick();
                            }

                            alertDialog.dismiss();
                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            if (listener != null) {
                                listener.onNegativeClick();
                            }

                            alertDialog.dismiss();

                        }
                    }).create();
        }


        alertDialog.show();

    }


    public interface OnConfigInfoFragmentListener {

        void onPositiveClick();

        void onNegativeClick();
    }
}
