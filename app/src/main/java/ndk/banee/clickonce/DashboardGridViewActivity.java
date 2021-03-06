package ndk.banee.clickonce;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import ndk.utils_android1.TelephonyCallActivity;
import ndk.utils_android16.ToastUtils;

public class DashboardGridViewActivity extends TelephonyCallActivity {

    private static final String SERVICE_CONTACT_NUMBER = "9895204814";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_gridview);

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

        GridView gridview = findViewById(R.id.gridViewServices);
        gridview.setAdapter(new ButtonAdaptor(this));
    }
}
