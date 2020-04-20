package ndk.banee.clickonce;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ndk.utils_android1.TelephonyCallActivity;
import ndk.utils_android16.ToastUtils;

public class DashboardFragmentActivity extends TelephonyCallActivity implements ServicesFragment.ServiceFragmentInteractionListener {

    private static final String SERVICE_CONTACT_NUMBER = "9895204814";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_fragment);

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

    @Override
    public void onFragmentInteraction(ServiceList.ServiceItem serviceItem) {

    }
}
