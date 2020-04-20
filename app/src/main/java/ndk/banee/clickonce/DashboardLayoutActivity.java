package ndk.banee.clickonce;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ndk.utils_android1.TelephonyCallActivity;
import ndk.utils_android16.ToastUtils;

public class DashboardLayoutActivity extends TelephonyCallActivity {

    private static final String SERVICE_CONTACT_NUMBER = "9895204814";

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

    public void buttonClick(View view) {

        switch (view.getId()) {

            case R.id.buttonS1D:
                break;

            case R.id.buttonS2D:
                break;

            case R.id.buttonS3D:
                break;

            case R.id.buttonS4D:
                break;

            case R.id.buttonS5D:
                break;

            case R.id.buttonS6D:
                break;

            case R.id.buttonS7D:
                break;

            case R.id.buttonS8D:
                break;

            case R.id.buttonS9D:
                break;

            case R.id.buttonS10D:
                break;

            case R.id.buttonS11D:
                break;

            case R.id.buttonS12D:
                break;
        }
    }
}
