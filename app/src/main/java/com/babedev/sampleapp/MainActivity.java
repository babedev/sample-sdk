package com.babedev.sampleapp;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;

import com.babedev.samplesdk.SampleApplicationInterface;
import com.babedev.samplesdk.SampleDataSource;
import com.babedev.samplesdk.ui.MainFragment;

/**
 * @author BabeDev
 */
public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SampleDataSource dataSource = new SampleDataSource();
        dataSource.setButtonText("Click me");

        MainFragment fragment = MainFragment.newInstance(dataSource, new SampleApplicationInterface() {

            @Override
            public void showSuccess(String message) {
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
            }
        });

        final FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.root, fragment).commit();
    }
}
