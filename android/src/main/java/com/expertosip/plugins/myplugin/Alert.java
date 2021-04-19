package com.expertosip.plugins.myplugin;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;

import com.expertosip.plugins.myplugin.capacitorpluginmyplugin.R;
import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.yarolegovich.lovelydialog.LovelyStandardDialog;

@NativePlugin
public class Alert extends Plugin {

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", value);
        Context ctx = this.bridge.getWebView().getContext();
        new LovelyStandardDialog(ctx, LovelyStandardDialog.ButtonLayout.VERTICAL)
                .setTopColorRes(R.color.indigo)
                .setButtonsColorRes(R.color.darkDeepOrange)
                .setIcon(R.mipmap.ic_star)
                .setTitle("Alert")
                .setMessage(value)
                .show();
        call.success(ret);
    }

    @PluginMethod
    public void sumar(PluginCall call) throws Exception {
        try {
            int value1 = call.getInt("value1");
            int value2 = call.getInt("value2");

            if (value1 > 0 && value2 > 0) {
                JSObject ret = new JSObject();
                ret.put("suma", value1 + value2);
                call.success(ret);
            } else {
                throw new Exception("Los numeros deben ser mayores que 0");
            }
        } catch (Exception e) {
            call.error(e.getMessage());
        }

    }
}
