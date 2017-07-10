package com.acme.a3csci3130;
import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines how the data will be stored in the
 * Firebase database. This is converted to a JSON format.
 * @author juleesaad
 */

public class Contact implements Serializable {

    public String uid;
    public String businessNumber;
    public String name;
    public String primaryBusiness;
    public String address;
    public String province;

    /**
     *  Default constructor required for calls to DataSnapshot.getValue
     */

    public Contact() {

    }

    /**
     *
     * @param uid unique id for positioning in db
     * @param businessNumber required 9-digit number
     * @param name business name required 2-48 characters
     * @param primaryBusiness required business role {Fisher, Distributor, Processor, Fish Monger}
     * @param address business address <50 characters
     * @param province abbreviation of province or territory name (Two characters)
     */

    public Contact(String uid, String businessNumber, String name, String primaryBusiness, String address, String province){
        this.uid = uid;
        this.businessNumber = businessNumber;
        this.name = name;
        this.primaryBusiness = primaryBusiness;
        this.address = address;
        this.province = province;
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("businessNumber", businessNumber);
        result.put("name", name);
        result.put("primaryBusiness", primaryBusiness);
        result.put("address", address);
        result.put("province", province);

        return result;
    }
}
