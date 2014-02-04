package org.firespeed.hellowatch;

import android.content.Context;
import com.sonyericsson.extras.liveware.extension.util.control.ControlExtension;

public class CustomControlExtension extends ControlExtension {
	public CustomControlExtension(String hostAppPackageName, final Context context ) {
		super(context, hostAppPackageName);
	}
    public static int getSupportedControlWidth(Context context) {
        return context.getResources().getDimensionPixelSize(R.dimen.smart_watch_control_width);
    }


    public static int getSupportedControlHeight(Context context) {
        return context.getResources().getDimensionPixelSize(R.dimen.smart_watch_control_height);
    }
	@Override
	public void onStart() {
		
	}
	
	@Override
	public void onResume() {
        showLayout(R.layout.custom_control_extension, null);
	}
}
