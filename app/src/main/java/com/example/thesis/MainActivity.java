package com.example.thesis;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.content.pm.PackageInfo;
import android.content.pm.PermissionInfo;
import android.content.Context;
import com.example.thesis.ml.Model;
import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

public class MainActivity extends Activity {
    private TextView testView;
    List<String[]> data = new ArrayList<>();
    private Map<String, String> appNameToPackageNameMap;
    private List<String> extractedPermissions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initAppData();
        setupMainLayout();
    }

    private void initAppData() {
        data.add(new String[]{"transact","bindService","onServiceConnected","ServiceConnection","android.os.Binder","READ_SMS","attachInterface","WRITE_SMS","TelephonyManager.getSubscriberId","Ljava.lang.Class.getCanonicalName","Ljava.lang.Class.getMethods","android.intent.action.BOOT_COMPLETED","Ljava.lang.Class.getField","READ_PHONE_STATE","android.content.Context.unregisterReceiver","GET_ACCOUNTS","SEND_SMS","android.content.Context.registerReceiver","getBinder","Ljava.lang.Class.cast","chmod","createSubprocess","Ljava.net.URLDecoder","WRITE_APN_SETTINGS","TelephonyManager.getDeviceId","RECEIVE_SMS","Ljava.lang.Class.getDeclaredField","HttpGet.init","Ljava.lang.Class.getPackage","abortBroadcast","ClassLoader","TelephonyManager.getLine1Number","getCallingUid","USE_CREDENTIALS","MANAGE_ACCOUNTS","android.telephony.gsm.SmsManager",".system.bin","Ljava.lang.Class.getMethod","RESTART_PACKAGES","INSTALL_PACKAGES","Ljava.lang.Class.forName","TelephonyManager.getSimSerialNumber","CAMERA","CALL_PHONE","android.intent.action.SEND","onBind","android.content.pm.Signature","READ_SYNC_SETTINGS","AUTHENTICATE_ACCOUNTS","INTERNET","PackageInstaller","ACCESS_LOCATION_EXTRA_COMMANDS","HttpUriRequest","remount","android.telephony.SmsManager","RECEIVE_BOOT_COMPLETED","android.intent.action.ACTION_POWER_CONNECTED","findClass","WRITE_CONTACTS",".system.app","Ljava.lang.Class.getResource","WRITE_SYNC_SETTINGS","android.intent.action.TIME_SET","android.intent.action.SEND_MULTIPLE","ACCESS_WIFI_STATE","URLClassLoader","BLUETOOTH","WAKE_LOCK","SYSTEM_ALERT_WINDOW","TelephonyManager.getSimCountryIso","chown","NFC","READ_HISTORY_BOOKMARKS","HttpPost.init","TelephonyManager.getNetworkOperator","Ljava.lang.Class.getClasses","BIND_REMOTEVIEWS","READ_PROFILE","READ_CALENDAR","CHANGE_WIFI_STATE","READ_SYNC_STATS","WRITE_HISTORY_BOOKMARKS","DISABLE_KEYGUARD","READ_LOGS","RECORD_AUDIO","getCallingPid","MODIFY_AUDIO_SETTINGS","android.intent.action.PACKAGE_REPLACED","android.intent.action.TIMEZONE_CHANGED","BROADCAST_STICKY","Runtime.exec","android.intent.action.PACKAGE_ADDED","MOUNT_UNMOUNT_FILESYSTEMS","android.intent.action.ACTION_POWER_DISCONNECTED","Ljava.lang.Class.getDeclaredClasses","android.intent.action.PACKAGE_REMOVED","BLUETOOTH_ADMIN","android.os.IBinder","IBinder","WRITE_SECURE_SETTINGS","WRITE_SETTINGS","Ljavax.crypto.spec.SecretKeySpec","android.intent.action.BATTERY_OKAY","READ_CONTACTS","Binder","SUBSCRIBED_FEEDS_READ","READ_CALL_LOG","SUBSCRIBED_FEEDS_WRITE","BATTERY_STATS","RECEIVE_WAP_PUSH","PathClassLoader","KILL_BACKGROUND_PROCESSES","ACCESS_COARSE_LOCATION","android.intent.action.ACTION_SHUTDOWN","Runtime.load","android.intent.action.SENDTO","SET_WALLPAPER","android.intent.action.NEW_OUTGOING_CALL","CHANGE_NETWORK_STATE","REBOOT","DexClassLoader","WRITE_CALENDAR","PROCESS_OUTGOING_CALLS","BIND_DEVICE_ADMIN","CHANGE_WIFI_MULTICAST_STATE","MASTER_CLEAR","android.intent.action.PACKAGE_DATA_CLEARED","FLASHLIGHT","android.intent.action.BATTERY_LOW","SET_ALARM","RECEIVE_MMS","divideMessage","WRITE_CALL_LOG","WRITE_PROFILE","WRITE_USER_DICTIONARY","BIND_INPUT_METHOD","READ_SOCIAL_STREAM","REORDER_TASKS","defineClass","PERSISTENT_ACTIVITY","ProcessBuilder","android.intent.action.SCREEN_ON","READ_USER_DICTIONARY","WRITE_SOCIAL_STREAM","SET_TIME","mount","System.loadLibrary","CHANGE_COMPONENT_ENABLED_STATE","ACCESS_MOCK_LOCATION","DUMP","CALL_PRIVILEGED","DELETE_PACKAGES","READ_FRAME_BUFFER","WRITE_GSERVICES","ACCOUNT_MANAGER","KeySpec","sendDataMessage","android.intent.action.CALL","BIND_APPWIDGET","android.intent.action.SCREEN_OFF","intent.action.RUN","SecretKey","CLEAR_APP_CACHE","ACCESS_FINE_LOCATION","SET_WALLPAPER_HINTS","Context.bindService","MessengerService","ACCESS_NETWORK_STATE","android.content.pm.PackageInfo","BIND_ACCESSIBILITY_SERVICE","INTERNAL_SYSTEM_WINDOW","SET_TIME_ZONE","Process.start","MOUNT_FORMAT_FILESYSTEMS","CLEAR_APP_USER_DATA","UPDATE_DEVICE_STATS","IRemoteService","android.intent.action.SET_WALLPAPER","BROADCAST_WAP_PUSH","android.intent.action.CALL_BUTTON","INJECT_EVENTS","ACCESS_SURFACE_FLINGER","SET_PROCESS_LIMIT","ADD_VOICEMAIL","INSTALL_LOCATION_PROVIDER","SET_ACTIVITY_WATCHER","TelephonyManager.getCallState","VIBRATE","Runtime.getRuntime","CHANGE_CONFIGURATION","BROADCAST_SMS","BIND_WALLPAPER","BROADCAST_PACKAGE_REMOVED","TelephonyManager.isNetworkRoaming","TelephonyManager.getSimOperator","WRITE_EXTERNAL_STORAGE","android.intent.action.CAMERA_BUTTON","android.intent.action.REBOOT","sendMultipartTextMessage","BIND_VPN_SERVICE","STATUS_BAR","Ljavax.crypto.Cipher","MODIFY_PHONE_STATE","android.intent.action.PACKAGE_RESTARTED","READ_INPUT_STATE","READ_EXTERNAL_STORAGE","Ljava.lang.Object.getClass","SET_ORIENTATION","DEVICE_POWER","EXPAND_STATUS_BAR","GET_TASKS","GLOBAL_SEARCH","GET_PACKAGE_SIZE","SET_PREFERRED_APPLICATIONS","android.intent.action.PACKAGE_CHANGED"});
        data.add(new String[]{"0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0" });
        extractedPermissions = new ArrayList<>();
    }

    private void setupMainLayout() {
        testView = findViewById(R.id.testView);
        Button button = findViewById(R.id.circularButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToContentView();
            }
        });
    }

    private void switchToContentView() {
        setContentView(R.layout.content_view);
        ListView listView = findViewById(R.id.listView);
        List<String> packageNames = new ArrayList<>();
        appNameToPackageNameMap = new HashMap<>();

        PackageManager packageManager = getPackageManager();
        List<ApplicationInfo> packages = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);
        for (ApplicationInfo packageInfo : packages) {
            String appName = packageManager.getApplicationLabel(packageInfo).toString();
            String packageName = packageInfo.packageName;
            // Filter out packages with "com.android" and "com.google"
            if (!packageName.startsWith("com.android") && !packageName.startsWith("com.google") && hasSystemPermissions(packageManager, packageName)) {
                packageNames.add(appName);
                appNameToPackageNameMap.put(appName, packageName);
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, packageNames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                handleListItemClick(packageNames.get(position));
            }
        });
    }

    private boolean hasSystemPermissions(PackageManager packageManager, String packageName) {
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, PackageManager.GET_PERMISSIONS);
            if (packageInfo.requestedPermissions != null) {
                for (String permission : packageInfo.requestedPermissions) {
                    PermissionInfo permissionInfo = packageManager.getPermissionInfo(permission, 0);
                    if ((permissionInfo.protectionLevel & PermissionInfo.PROTECTION_SIGNATURE) != 0
                            || (permissionInfo.protectionLevel & PermissionInfo.PROTECTION_FLAG_SYSTEM) != 0) {
                        return true;
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void handleListItemClick(String appName) {
        String packageName = appNameToPackageNameMap.get(appName);
        String[] permissions = getAppPermissions(MainActivity.this, packageName);
        if (permissions != null) {
            StringBuilder message = new StringBuilder();
            extractedPermissions.clear();
            for (String permission : permissions) {
                String permissionName = permission.replace("android.permission.", "");
                message.append("Permission: ").append(permission).append("\n");
                extractedPermissions.add(permissionName);
            }
            updateDataWithPermissions();
            doInference(data);
            showToast("Success");
        } else {
            showToast("Permissions not found for " + appName);
        }
    }

    private void updateDataWithPermissions() {
        for (String extractedPermission : extractedPermissions) {
            for (int i = 0; i < data.get(0).length; i++) {
                if (data.get(0)[i].equals(extractedPermission)) {
                    data.get(1)[i] = "1";
                }
            }
        }
    }

    public void doInference(List<String[]> myArray) {
        try {
            Model model = Model.newInstance(getApplicationContext());
            TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 215}, DataType.FLOAT32);

            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4 * myArray.get(1).length);
            byteBuffer.order(ByteOrder.nativeOrder());

            for (int i = 0; i < myArray.get(1).length; i++) {
                byteBuffer.putFloat(Float.parseFloat(myArray.get(1)[i]));
            }

            inputFeature0.loadBuffer(byteBuffer);

            Model.Outputs outputs = model.process(inputFeature0);
            TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();

            float[] confidences = outputFeature0.getFloatArray();

            int maxPos = 0;
            float maxConfidence = 0;
            for (int i = 0; i < confidences.length; i++) {
                if (confidences[i] > maxConfidence) {
                    maxConfidence = confidences[i];
                    maxPos = i;
                }
            }
            String a = String.valueOf(maxConfidence);
            Log.e("TAG", a);
            String[] classes = {"Benign", "Suspicious"};
            String result = classes[maxPos];
            System.out.println(classes[maxPos]);

            runOnUiThread(() -> {
                setContentView(R.layout.activity_main); // Switch back to the main layout
                setupMainLayout(); // Reinitialize the main layout and listeners
                if (testView != null) {
                    testView.setText(result);
                } else {
                    Log.e("TAG", "testView is null");
                }
            });

            model.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] getAppPermissions(Context context, String packageName) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, PackageManager.GET_PERMISSIONS);
            return packageInfo.requestedPermissions;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
