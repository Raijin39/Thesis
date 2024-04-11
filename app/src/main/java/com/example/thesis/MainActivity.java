package com.example.thesis;
import android.os.Environment;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.util.Log;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find your Views
        TextView titleTextView = findViewById(R.id.titleTextView);
        Button circularButton = findViewById(R.id.circularButton);
        Button deleteMalware = findViewById(R.id.DeleteMalware);
        TextView percentageResultText = findViewById(R.id.percentageResultText);
        TextView percentageResultText2 = findViewById(R.id.percentageResultText2);
        TextView testView = findViewById(R.id.testView);

        LinearLayout linearLayout = findViewById(R.id.linearLayout);

        // Find the bars
        View bar1 = findViewById(R.id.bar1);
        View bar2 = findViewById(R.id.bar2);

        // Set OnClickListener for Scan
        circularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Update Scan Result
                updateScanResult(bar1, bar2, 90f, 10f);

                // Change text
                percentageResultText.setText("90% Safe Files");
                percentageResultText2.setText("10% Malware");

                List<String[]> data = new ArrayList<>();
                data.add( new String[] { "transact","bindService","onServiceConnected","ServiceConnection","android.os.Binder","READ_SMS","attachInterface","WRITE_SMS",
                        "TelephonyManager.getSubscriberId","Ljava.lang.Class.getCanonicalName","Ljava.lang.Class.getMethods","android.intent.action.BOOT_COMPLETED",
                        "Ljava.lang.Class.getField","READ_PHONE_STATE","android.content.Context.unregisterReceiver","GET_ACCOUNTS","SEND_SMS","android.content.Context.registerReceiver",
                        "getBinder","Ljava.lang.Class.cast","chmod","createSubprocess","Ljava.net.URLDecoder","WRITE_APN_SETTINGS","TelephonyManager.getDeviceId","RECEIVE_SMS",
                        "Ljava.lang.Class.getDeclaredField","HttpGet.init","Ljava.lang.Class.getPackage","abortBroadcast","ClassLoader","TelephonyManager.getLine1Number",
                        "getCallingUid","USE_CREDENTIALS","MANAGE_ACCOUNTS","android.telephony.gsm.SmsManager",".system.bin","Ljava.lang.Class.getMethod","RESTART_PACKAGES",
                        "INSTALL_PACKAGES","Ljava.lang.Class.forName","TelephonyManager.getSimSerialNumber","CAMERA","CALL_PHONE","android.intent.action.SEND","onBind",
                        "android.content.pm.Signature","READ_SYNC_SETTINGS","AUTHENTICATE_ACCOUNTS","INTERNET","PackageInstaller","ACCESS_LOCATION_EXTRA_COMMANDS","HttpUriRequest",
                        "remount","android.telephony.SmsManager","RECEIVE_BOOT_COMPLETED","android.intent.action.ACTION_POWER_CONNECTED","findClass","WRITE_CONTACTS",".system.app",
                        "Ljava.lang.Class.getResource","WRITE_SYNC_SETTINGS","android.intent.action.TIME_SET","android.intent.action.SEND_MULTIPLE","ACCESS_WIFI_STATE","URLClassLoader",
                        "BLUETOOTH","WAKE_LOCK","SYSTEM_ALERT_WINDOW","TelephonyManager.getSimCountryIso","chown","NFC","READ_HISTORY_BOOKMARKS","HttpPost.init",
                        "TelephonyManager.getNetworkOperator","Ljava.lang.Class.getClasses","BIND_REMOTEVIEWS","READ_PROFILE","READ_CALENDAR","CHANGE_WIFI_STATE","READ_SYNC_STATS",
                        "WRITE_HISTORY_BOOKMARKS","DISABLE_KEYGUARD","READ_LOGS","RECORD_AUDIO","getCallingPid","MODIFY_AUDIO_SETTINGS","android.intent.action.PACKAGE_REPLACED",
                        "android.intent.action.TIMEZONE_CHANGED","BROADCAST_STICKY","Runtime.exec","android.intent.action.PACKAGE_ADDED","MOUNT_UNMOUNT_FILESYSTEMS",
                        "android.intent.action.ACTION_POWER_DISCONNECTED","Ljava.lang.Class.getDeclaredClasses","android.intent.action.PACKAGE_REMOVED","BLUETOOTH_ADMIN",
                        "android.os.IBinder","IBinder","WRITE_SECURE_SETTINGS","WRITE_SETTINGS","Ljavax.crypto.spec.SecretKeySpec","android.intent.action.BATTERY_OKAY",
                        "READ_CONTACTS","Binder","SUBSCRIBED_FEEDS_READ","READ_CALL_LOG","SUBSCRIBED_FEEDS_WRITE","BATTERY_STATS","RECEIVE_WAP_PUSH","PathClassLoader",
                        "KILL_BACKGROUND_PROCESSES","ACCESS_COARSE_LOCATION","android.intent.action.ACTION_SHUTDOWN","Runtime.load","android.intent.action.SENDTO","SET_WALLPAPER"
                        ,"android.intent.action.NEW_OUTGOING_CALL","CHANGE_NETWORK_STATE","REBOOT","DexClassLoader","WRITE_CALENDAR","PROCESS_OUTGOING_CALLS","BIND_DEVICE_ADMIN",
                        "CHANGE_WIFI_MULTICAST_STATE","MASTER_CLEAR","android.intent.action.PACKAGE_DATA_CLEARED","FLASHLIGHT","android.intent.action.BATTERY_LOW","SET_ALARM",
                        "RECEIVE_MMS","divideMessage","WRITE_CALL_LOG","WRITE_PROFILE","WRITE_USER_DICTIONARY","BIND_INPUT_METHOD","READ_SOCIAL_STREAM","REORDER_TASKS","defineClass",
                        "PERSISTENT_ACTIVITY","ProcessBuilder","android.intent.action.SCREEN_ON","READ_USER_DICTIONARY","WRITE_SOCIAL_STREAM","SET_TIME","mount","System.loadLibrary",
                        "CHANGE_COMPONENT_ENABLED_STATE","ACCESS_MOCK_LOCATION","DUMP","CALL_PRIVILEGED","DELETE_PACKAGES","READ_FRAME_BUFFER","WRITE_GSERVICES","ACCOUNT_MANAGER",
                        "KeySpec","sendDataMessage","android.intent.action.CALL","BIND_APPWIDGET","android.intent.action.SCREEN_OFF","intent.action.RUN","SecretKey","CLEAR_APP_CACHE",
                        "ACCESS_FINE_LOCATION","SET_WALLPAPER_HINTS","Context.bindService","MessengerService","ACCESS_NETWORK_STATE","android.content.pm.PackageInfo",
                        "BIND_ACCESSIBILITY_SERVICE","INTERNAL_SYSTEM_WINDOW","SET_TIME_ZONE","Process.start","MOUNT_FORMAT_FILESYSTEMS","CLEAR_APP_USER_DATA","UPDATE_DEVICE_STATS",
                        "IRemoteService","android.intent.action.SET_WALLPAPER","BROADCAST_WAP_PUSH","android.intent.action.CALL_BUTTON","INJECT_EVENTS","ACCESS_SURFACE_FLINGER",
                        "SET_PROCESS_LIMIT","ADD_VOICEMAIL","INSTALL_LOCATION_PROVIDER","SET_ACTIVITY_WATCHER","TelephonyManager.getCallState","VIBRATE","Runtime.getRuntime",
                        "CHANGE_CONFIGURATION","BROADCAST_SMS","BIND_WALLPAPER","BROADCAST_PACKAGE_REMOVED","TelephonyManager.isNetworkRoaming","TelephonyManager.getSimOperator",
                        "WRITE_EXTERNAL_STORAGE","android.intent.action.CAMERA_BUTTON","android.intent.action.REBOOT","sendMultipartTextMessage","BIND_VPN_SERVICE","STATUS_BAR",
                        "Ljavax.crypto.Cipher","MODIFY_PHONE_STATE","android.intent.action.PACKAGE_RESTARTED","READ_INPUT_STATE","READ_EXTERNAL_STORAGE","Ljava.lang.Object.getClass",
                        "SET_ORIENTATION","DEVICE_POWER","EXPAND_STATUS_BAR","GET_TASKS","GLOBAL_SEARCH","GET_PACKAGE_SIZE","SET_PREFERRED_APPLICATIONS",
                        "android.intent.action.PACKAGE_CHANGED"});
                data.add(new String[] {  "0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0",
                        "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0",
                        "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0",
                        "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0",
                        "0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0",
                        "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0",
                        "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0","0", "0", "0", "0", "0" });
                String csvFilePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/output.csv";

                Log.d("FilePath", "CSV File Path: " + csvFilePath);


                // create a list to store system permissions extracted by the script.
                List<String> extractedpermission = new ArrayList<>();

                // Get the Document Builder
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                try {
                    DocumentBuilder builder = factory.newDocumentBuilder();

                    // Get Document
                    Document document = builder.parse(getResources().getAssets().open("candycrush.xml"));
                    document.getDocumentElement().normalize();

                    // Get all the elements by the tag name
                    NodeList permissions = document.getElementsByTagName("uses-permission");

                    // Loop through each permission
                    for (int i = 0; i < permissions.getLength(); i++) {
                        Node permission = permissions.item(i);
                        if (permission.getNodeType() == Node.ELEMENT_NODE) {
                            Element permissionElement = (Element) permission;
                            String a = permissionElement.getAttribute("android:name");
                            String wordToRemove = "android.permission.";
                            String permissionName = a.replaceAll("\\b" + wordToRemove + "\\b", "");

                            // Add extracted permissions to ArrayList
                            extractedpermission.add(permissionName);

                            // Update the data list
                            for (int rowIndex = 0; rowIndex < data.size(); rowIndex++) {
                                String[] row = data.get(rowIndex);
                                for (int columnIndex = 0; columnIndex < row.length; columnIndex++) {
                                    if (row[columnIndex].equals(permissionName)) {
                                        data.get(rowIndex)[columnIndex] = "1";
                                    }
                                }
                            }
                        }
                    }

                    // Write data to CSV
                    try (FileWriter writer = new FileWriter(csvFilePath)) {
                        for (String[] rowData : data) {
                            writer.append(String.join(",", rowData));
                            writer.append("\n");
                        }
                        testView.setText("CSV file created successfully!");
                    } catch (IOException e) {
                        testView.setText("Error writing to CSV file: " + e.getMessage());
                    }

                } catch (ParserConfigurationException | SAXException | IOException e) {
                    testView.setText("Error: " + e.getMessage());
                }
            }
        });

        // Set OnClickListener for DeleteMalware
        deleteMalware.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Restore original state
                updateScanResult(bar1, bar2, 100f, 0f);

                // Reset text
                percentageResultText.setText("100% Safe Files");
                percentageResultText2.setText("0% Malware");
                testView.setText("None");

            }
        });
    }

    // Function to update the weights of bars
    private void updateScanResult(View bar1, View bar2, float weight1, float weight2) {
        LinearLayout.LayoutParams params1 = (LinearLayout.LayoutParams) bar1.getLayoutParams();
        params1.weight = weight1;
        bar1.setLayoutParams(params1);

        LinearLayout.LayoutParams params2 = (LinearLayout.LayoutParams) bar2.getLayoutParams();
        params2.weight = weight2;
        bar2.setLayoutParams(params2);
    }
}
