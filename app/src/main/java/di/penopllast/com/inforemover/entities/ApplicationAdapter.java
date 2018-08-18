package di.penopllast.com.inforemover.entities;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import di.penopllast.com.inforemover.R;

public class ApplicationAdapter extends RecyclerView.Adapter {

    private final List<ApplicationInfo> appList;

    public ApplicationAdapter(List<ApplicationInfo> appList) {
        this.appList = appList;
        Log.i("test", "size = " + appList.size());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public final ImageView icon;
        public final TextView name;

        public ViewHolder(View view) {
            super(view);
            this.icon = view.findViewById(R.id.icon);
            this.name = view.findViewById(R.id.name);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_app, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.i("test", "position = " + position);
        ApplicationInfo appInfo = appList.get(position);
        ((ViewHolder) holder).name.setText(appInfo.getName());
        ((ViewHolder) holder).icon.setImageDrawable(appInfo.getIcon());
    }

    @Override
    public int getItemCount() {
        return appList.size();
    }
}
