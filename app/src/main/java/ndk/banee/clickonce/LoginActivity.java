package ndk.banee.clickonce;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import ndk.utils_android1.ActivityUtils;
import ndk.utils_android1.ContextActivity;
import ndk.utils_android16.ValidationUtils;

public class LoginActivity extends ContextActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText editTextMobileNumber = findViewById(R.id.editTextMobileNumber);
//        editTextMobileNumber.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                return false;
//            }
//        });

        Button buttonContinue = findViewById(R.id.buttonContinue);
        buttonContinue.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

//                Stream<org.javatuples.Pair<EditText, String>> stream=Stream.of(org.javatuples.Pair.with(editTextMobileNumber, "Please Enter Your Mobile Number..."));

                ArrayList<org.javatuples.Pair<EditText, String>> editTextPairs = new ArrayList<>();
                editTextPairs.add(org.javatuples.Pair.with(editTextMobileNumber, "Please Enter Your Mobile Number..."));

                org.javatuples.Pair<Boolean, EditText> validationResult = ValidationUtils.nonEmptyCheckEditTextPairs(editTextPairs);

                if (validationResult.getValue0()) {

//                    Pair<Integer, EditText> secondValidationResult = ValidationUtils.indianMobileNumberCheckEditTextPairs(new Triplet[]{new Triplet<>(editTextMobileNumber, "Please Correct Your Mobile Number...", "Sorry, Currently Service is Not Available for Outside India...")}, activityContext);

                    editTextPairs.clear();
                    editTextPairs.add(org.javatuples.Pair.with(editTextMobileNumber, "Please Correct Your Mobile Number..."));
                    org.javatuples.Pair<Boolean, EditText> secondValidationResult = ValidationUtils.mobileNumberCheckEditTextPairs(editTextPairs);

                    if (secondValidationResult.getValue0()) {

                        ActivityUtils.startActivity(activityContext, DashboardFragmentActivity.class);

                    } else {

                        secondValidationResult.getValue1().requestFocus();
                    }

                } else {

                    validationResult.getValue1().requestFocus();
                }
            }
        });
    }
}
