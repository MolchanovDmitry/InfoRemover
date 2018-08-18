package di.penopllast.com.inforemover.entities;

import android.graphics.drawable.Drawable;

public class ApplicationInfo {
    private final String packageName;
    private final String name;
    private final Drawable icon;

    public ApplicationInfo(String packageName, String name, Drawable icon) {
        this.packageName = packageName;
        this.name = name;
        this.icon = icon;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getName() {
        return name;
    }

    public Drawable getIcon() {
        return icon;
    }
}
