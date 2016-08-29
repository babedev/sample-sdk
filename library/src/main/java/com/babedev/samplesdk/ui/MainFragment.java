package com.babedev.samplesdk.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.babedev.samplesdk.R;
import com.babedev.samplesdk.SampleApplicationInterface;
import com.babedev.samplesdk.SampleDataSource;

/**
 * @author BabeDev
 */
public class MainFragment extends Fragment {

    private SampleApplicationInterface mSampleApplicationInterface;
    private SampleDataSource mDataSource;

    public static MainFragment newInstance(SampleDataSource dataSource, SampleApplicationInterface sdkInterface) {
        MainFragment fragment = new MainFragment();
        fragment.setDataSource(dataSource);
        fragment.setSdkInterface(sdkInterface);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vRoot = inflater.inflate(R.layout.fragment_main, null);
        Button btnClick = (Button) vRoot.findViewById(R.id.btn_click);

        btnClick.setText(mDataSource.getButtonText());
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSampleApplicationInterface.showSuccess("Surprise!!!!");
            }
        });

        return vRoot;
    }

    public void setSdkInterface(SampleApplicationInterface sdkInterface) {
        mSampleApplicationInterface = sdkInterface;
    }

    public void setDataSource(SampleDataSource dataSource) {
        mDataSource = dataSource;
    }
}
