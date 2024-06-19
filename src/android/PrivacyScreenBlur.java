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
      if (args.get(0).toString() == "true") {
        cordova.getActivity().runOnUiThread(new Runnable() {
          @Override
          public void run() {
            cordova.getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
                    WindowManager.LayoutParams.FLAG_SECURE);
          }
        });
      } else {
        cordova.getActivity().runOnUiThread(new Runnable() {
          @Override
          public void run() {
            cordova.getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SECURE);
          }
        });
      }

      return true;
    }

    return false;
  }
}
