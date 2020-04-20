package ndk.banee.clickonce;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import ndk.utils_android1.TelephonyCallActivity;
import ndk.utils_android16.ToastUtils;

public class DashboardRecyclerViewActivity extends TelephonyCallActivity {

    private static final String SERVICE_CONTACT_NUMBER = "9895204814";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_recyclerview);

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

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float dpHeight = displayMetrics.heightPixels / displayMetrics.density;
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        float recyclerViewHeight = dpHeight - 16 - 56 - 16 - 16 - 36 - 16 - 16;
        float recyclerViewWidth = dpWidth - 16 - 16;

        RecyclerView recyclerView = findViewById(R.id.recyclerViewServices);
        recyclerView.setAdapter(new ServicesRecyclerViewIndependentAdapter(ServiceList.serviceList, (int) recyclerViewHeight / 6, (int) recyclerViewWidth / 2));

    }
}
