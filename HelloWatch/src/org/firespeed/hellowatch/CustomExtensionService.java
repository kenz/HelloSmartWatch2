package org.firespeed.hellowatch;

import com.sonyericsson.extras.liveware.extension.util.ExtensionService;
import com.sonyericsson.extras.liveware.extension.util.control.ControlExtension;
import com.sonyericsson.extras.liveware.extension.util.registration.RegistrationInformation;

public class CustomExtensionService extends ExtensionService {

	public static final String EXTENSION_KEY = "org.firespeed.hellowatch.key";
	public static final String LOG_TAG = "HelloWatch";
	public CustomExtensionService() {
		super(EXTENSION_KEY);
	}

	@Override
	public void onCreate() {
		super.onCreate();
		
	}

	@Override
	protected RegistrationInformation getRegistrationInformation() {
		return new CustomRegistrationInformation(this);
	}

	@Override
	protected boolean keepRunningWhenConnected() {
		return false;
	}

	@Override
	public ControlExtension createControlExtension(String hostAppPackageName) {
		return new CustomControlExtension(hostAppPackageName, this);
	}
}