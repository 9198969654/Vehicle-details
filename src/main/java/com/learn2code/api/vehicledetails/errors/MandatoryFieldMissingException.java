package com.learn2code.api.vehicledetails.errors;

public class MandatoryFieldMissingException extends Exception {

    public MandatoryFieldMissingException(String allErrors) {
        super(allErrors);
    }
}
