package cordova.plugin.privacy.screen.blur;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaWebView;

import android.view.Window;
import android.view.WindowManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class PrivacyScreenBlur extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("updateSecureFlag")) {
            Boolean isEnableFlag = args.getBoolean(0);
            this.updateSecureFlag(isEnableFlag);
            return true;
        }
        return false;
    }

    private void updateSecureFlag(Boolean isEnableFlag) {
        Window window = this.cordova.getActivity().getWindow();
        if (isEnableFlag) {
            window.setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);
        } else {
            window.clearFlags(WindowManager.LayoutParams.FLAG_SECURE);
        }
    }
}
