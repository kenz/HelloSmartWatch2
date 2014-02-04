package org.firespeed.hellowatch;

import android.content.ContentValues;
import android.content.Context;

import com.sonyericsson.extras.liveware.aef.registration.Registration;
import com.sonyericsson.extras.liveware.extension.util.ExtensionUtils;
import com.sonyericsson.extras.liveware.extension.util.registration.RegistrationInformation;

public class CustomRegistrationInformation extends RegistrationInformation {
	private Context mContext;

	protected CustomRegistrationInformation(Context context) {
		if (context == null) {
			throw new IllegalArgumentException("context == null");
		}
		mContext = context;
	}

	@Override
	public ContentValues getExtensionRegistrationConfiguration() {
		String extensionIcon = ExtensionUtils.getUriString(mContext, R.drawable.icon_extension);
        String iconHostapp = ExtensionUtils.getUriString(mContext, R.drawable.ic_launcher);

        String configurationText = mContext.getString(R.string.app_name);
        String extensionName = mContext.getString(R.string.app_name);

        ContentValues values = new ContentValues();

        values.put(Registration.ExtensionColumns.CONFIGURATION_TEXT, configurationText);
        values.put(Registration.ExtensionColumns.EXTENSION_ICON_URI, extensionIcon);
        values.put(Registration.ExtensionColumns.EXTENSION_KEY, CustomExtensionService.EXTENSION_KEY);
        values.put(Registration.ExtensionColumns.HOST_APP_ICON_URI, iconHostapp);
        values.put(Registration.ExtensionColumns.NAME, extensionName);
        values.put(Registration.ExtensionColumns.NOTIFICATION_API_VERSION,
                getRequiredNotificationApiVersion());
        values.put(Registration.ExtensionColumns.PACKAGE_NAME, mContext.getPackageName());

        return values;
	}

	@Override
	public int getRequiredControlApiVersion() {
		return 1;
	}

	@Override
	public int getTargetControlApiVersion() {
		return 1;
	}

	@Override
	public int getRequiredSensorApiVersion() {
		return 0;
	}

	@Override
	public int getRequiredNotificationApiVersion() {
		return 0;
	}

	@Override
	public int getRequiredWidgetApiVersion() {
		return 0;
	}
    @Override
    public boolean isDisplaySizeSupported(int width, int height) {
        return ((width == CustomControlExtension.getSupportedControlWidth(mContext) && height ==CustomControlExtension .getSupportedControlHeight(mContext)));
    }
}
