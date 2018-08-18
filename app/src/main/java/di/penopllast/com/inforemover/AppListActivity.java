package di.penopllast.com.inforemover;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import di.penopllast.com.inforemover.entities.ApplicationAdapter;
import di.penopllast.com.inforemover.entities.ApplicationInfo;

public class AppListActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view) RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_list);
        ButterKnife.bind(this);

        List<ApplicationInfo> applicationInfoList = getApplicationIndoList();
        recyclerView.setAdapter(new ApplicationAdapter(applicationInfoList));
    }

    private List<ApplicationInfo> getApplicationIndoList() {
        List<ApplicationInfo> applicationInfoList = new ArrayList<>();
        PackageManager pm = getPackageManager();
        Intent i = new Intent(Intent.ACTION_MAIN);
        i.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> lst = pm.queryIntentActivities(i, 0);

        for (ResolveInfo resolveInfo : lst) {
            applicationInfoList.add(
                    new ApplicationInfo(resolveInfo.activityInfo.packageName,
                            resolveInfo.loadLabel(pm).toString(),
                            resolveInfo.loadIcon(pm)));
        }
        return applicationInfoList;
    }
}
