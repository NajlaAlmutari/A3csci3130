package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * This class is to update contact info of one business
 * @author juleesaad
 */
public class DetailViewActivity extends Activity {

    private EditText  businessNumberField, nameField ,primaryBusinessField, addressField, provinceField;
    Contact receivedPersonInfo;
    private MyApplicationData appState;

    /**
     * This method is to pull data from DB to show it in the GUI
     * @param savedInstanceState
     */



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");
        appState = ((MyApplicationData) getApplicationContext());


        businessNumberField = (EditText) findViewById(R.id.businessNumber);
        nameField = (EditText) findViewById(R.id.name);
        primaryBusinessField = (EditText) findViewById(R.id.primaryBusiness);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);


        if(receivedPersonInfo != null){
            businessNumberField.setText(receivedPersonInfo.businessNumber);
            nameField.setText(receivedPersonInfo.name);
            primaryBusinessField.setText(receivedPersonInfo.primaryBusiness);
            addressField.setText(receivedPersonInfo.address);
            provinceField.setText(receivedPersonInfo.province);


        }
    }

    /**
     * This method is to update contact info of one business
     */

    public void updateContact(View v){
        String businessID = receivedPersonInfo.uid;
        String businessNumber = businessNumberField.getText().toString();
        String name = nameField.getText().toString();
        String primaryBusiness = primaryBusinessField.getText().toString();
        String address = addressField.getText().toString();
        String province = provinceField.getText().toString();

        Contact business = new Contact(businessID,businessNumber, name,primaryBusiness, address, province);

        appState.firebaseReference.child(businessID).setValue(business);
    }

    /**
     * This method is to erase the contact info of one business
     */

    public void eraseContact(View v)
    {
        appState.firebaseReference.child(receivedPersonInfo.uid).removeValue();

        finish();

    }
}
