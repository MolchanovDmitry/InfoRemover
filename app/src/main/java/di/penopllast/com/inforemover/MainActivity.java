package di.penopllast.com.inforemover;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import di.penopllast.com.inforemover.entities.ApplicationInfo;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @BindView(R.id.app_list_button) Button appListButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        new Handler().postDelayed(appListButton::performClick, 100);
    }

    @OnClick(R.id.app_list_button)
    protected void appListButtonPressed() {
        startActivity(new Intent(this, AppListActivity.class));
    }
}
