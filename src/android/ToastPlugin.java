package cordova.plugin.toastplugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.util.Log;

/**
 * This class echoes a string called from JavaScript.
 */
public class ToastPlugin extends CordovaPlugin {


      @Override
      public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        Log.d("Init","Plugin");
        // your init code here
    }
    @Override
    public void pluginInitialize(){
         Log.d("Init","Plugin Initi");
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("showToast")) {
            String message = args.getString(0);
            this.coolMethod(message, callbackContext);
            return true;
        }
        else if(action.equals("init")){
            this.addTwoInt("welcome",callbackContext);
            return true;
        }
        return false;
    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            Toast.makeText(cordova.getContext(),message,Toast.LENGTH_SHORT).show();
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }

     private void addTwoInt(String message,CallbackContext callbackContext){
        callbackContext.success("Suceessfully Init");
    }
}
