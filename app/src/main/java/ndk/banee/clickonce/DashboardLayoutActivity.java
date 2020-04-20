package ndk.banee.clickonce;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import ndk.utils_android1.TelephonyCallActivity;
import ndk.utils_android16.ToastUtils;

import static ndk.banee.clickonce.R.string.decline;

public class DashboardLayoutActivity extends TelephonyCallActivity {

    private static final String SERVICE_CONTACT_NUMBER = "9446827218";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_layout);

        Button buttonCall = findViewById(R.id.buttonCall);
        buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean callResult = callMobileNumber(activityContext, SERVICE_CONTACT_NUMBER);

                if (!callResult) {

                    ToastUtils.shortToast(activityContext, "Call Service is not available...");
                }
            }
        });
    }

    String service = "";

    public void buttonClick(View view) {

        switch (view.getId()) {

            case R.id.buttonS1D:
                service = getString(R.string.s1);
                break;

            case R.id.buttonS2D:
                service = getString(R.string.s2);
                break;

            case R.id.buttonS3D:
                service = getString(R.string.s3);
                break;

            case R.id.buttonS4D:
                service = getString(R.string.s4);
                break;

            case R.id.buttonS5D:
                service = getString(R.string.s5);
                break;

            case R.id.buttonS6D:
                service = getString(R.string.s6);
                break;

            case R.id.buttonS7D:
                service = getString(R.string.s7);
                break;

            case R.id.buttonS8D:
                service = getString(R.string.s8);
                break;

            case R.id.buttonS9D:
                service = getString(R.string.s9);
                break;

            case R.id.buttonS10D:
                service = getString(R.string.s10);
                break;

            case R.id.buttonS11D:
                service = getString(R.string.s11);
                break;

            case R.id.buttonS12D:
                service = getString(R.string.s12);
                break;
        }

        new MaterialAlertDialogBuilder(activityContext)
                .setMessage(service + " Need Our Service?")
                .setPositiveButton(decline, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                    }
                })
                .setNegativeButton(R.string.accept, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String mobileNumber = getIntent().getStringExtra("mobileNumber");
                        if (mobileNumber != null) {

                            boolean smsSendResult = ClickOnceTextLocalUtils.sendSMS(SERVICE_CONTACT_NUMBER, service + " requested on " + mobileNumber);
                            if (smsSendResult) {
                                ToastUtils.shortToast(activityContext, "Thanks...");
                                ClickOnceTextLocalUtils.sendSMS(mobileNumber, "Thank you for using ClickOnce Service, Our Representative Will Reach You Soon..");
                            } else {

                                ToastUtils.shortToast(activityContext, "Try Again...");
                            }

                        } else {

                            ToastUtils.shortToast(activityContext, "Data Error..");
                        }
                    }

                }).show();
    }
}
