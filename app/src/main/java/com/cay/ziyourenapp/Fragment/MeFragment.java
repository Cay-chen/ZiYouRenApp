package com.cay.ziyourenapp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.cay.ziyourenapp.Activity.SpaceActivity;
import com.cay.ziyourenapp.Activity.TuLingActivity;
import com.cay.ziyourenapp.R;

/**
 * Created by Administrator on 2016/7/6.
 */
public class MeFragment extends Fragment {
    private LinearLayout mSpaceLl;
    private LinearLayout mJiQiRen;
    private Button mButtonTuiChu;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fargment_me, null);
        mSpaceLl = (LinearLayout) view.findViewById(R.id.me_ziyouquan);
        mJiQiRen = (LinearLayout) view.findViewById(R.id.me_jiqiren);
        mButtonTuiChu = (Button) view.findViewById(R.id.me_btn_tuichu);

        mSpaceLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SpaceActivity.class);
                startActivity(intent);
            }
        });
        mJiQiRen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), TuLingActivity.class);
                startActivity(intent);
            }
        });
        mButtonTuiChu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });

        return view;
    }
}
