package com.example.shlomo.takego.model.backend;

import com.example.shlomo.takego.model.entities.Geer;

/**
 * Created by Shlomo on 19/11/2017.
 */

public class CarRentelConst {
    public static class CarConst {
        public static final String ID = "_id";
        public static final String MILAGE = "milage";
        public static final String BRANCH_NUMBER = "branch_number";
        public static final String CAR_MODEL = "car_model";
    }
    public static class ClientConst {
        public static final String ID = "_id";
        public static final String FIRST_NAME = "first_name";
        public  static  final  String LAST_NAME="last_name";
        public static final String PHONE = "phone";
        public static final String EMAIL = "email";
        public static final String CREDIT_CARD = "credit_card";
    }
    public static class BranchConst {
        public static final String ID = "_id";
        public static final String PARKING_SPOTS = "parking_spots";
        public static final String CITY = "city";
        public static final String STREET = "street";
    }
    public static class CarModelConst {
        public static final String ID = "_id";
        public static final String MODEL_NAME = "model_name";
        public static final String COMPANY_NAME = "company_name";
        public static final String ENGINE_VOLUME = "engine_volume";
        public static final String GEER = "geer";
        public static final String SEAT_NUMBER = "seat_number";
    }
}
