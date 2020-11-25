package com.paypal.bfs.test.employeeserv.utility;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.error.ErrorsHandler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
public class InputValidator {
    private static final String FIRST_NAME = "First Name";
    private static final String LAST_NAME = "Last Name";
    private static final String DATE_OF_BIRTH = "Date of Birth";
    private static final String ADDRESS_LINE_1 = "Address Line 1";
    private static final String ADDRESS_LINE_2 = "Address Line 2";
    private static final String CITY = "City";
    private static final String STATE = "State";
    private static final String COUNTRY = "Country";
    private static final String ZIP_CODE = "Zip Code";
    private static final int MAX_LENGTH = 255;
    private static final String REQUIRED = "This Field is required";

    public Optional<List<ErrorsHandler>> getErrors(Employee employeeReq){
        List<ErrorsHandler> errorsList = new ArrayList<>();
        checkRequiredFields(employeeReq, errorsList);
        checkLength(employeeReq, errorsList);
        return errorsList.size() > 0 ? Optional.of(errorsList): Optional.empty();
    }
    private void checkLength(Employee employeeReq, List<ErrorsHandler> errorsList){
        if(isMaxLength(employeeReq.getFirstName(), MAX_LENGTH)){
            errorsList.add(ErrorsHandler.builder().field(FIRST_NAME).errorMessages("Max length is "+MAX_LENGTH).build());
        }
        if(isMaxLength(employeeReq.getLastName(), MAX_LENGTH)){
            errorsList.add(ErrorsHandler.builder().field(LAST_NAME).errorMessages("Max length is "+MAX_LENGTH).build());
        }
        if(isMaxLength(employeeReq.getDateOfBirth(), MAX_LENGTH)){
            errorsList.add(ErrorsHandler.builder().field(DATE_OF_BIRTH).errorMessages("Max length is "+MAX_LENGTH).build());
        }
        if(isMaxLength(employeeReq.getAddressLine1(), MAX_LENGTH)){
            errorsList.add(ErrorsHandler.builder().field(ADDRESS_LINE_1).errorMessages("Max length is "+MAX_LENGTH).build());
        }
        if(isMaxLength(employeeReq.getAddressLine2(), MAX_LENGTH)){
            errorsList.add(ErrorsHandler.builder().field(ADDRESS_LINE_2).errorMessages("Max length is "+MAX_LENGTH).build());
        }
        if(isMaxLength(employeeReq.getCity(), MAX_LENGTH)){
            errorsList.add(ErrorsHandler.builder().field(CITY).errorMessages("Max length is "+MAX_LENGTH).build());
        }
        if(isMaxLength(employeeReq.getState(), MAX_LENGTH)){
            errorsList.add(ErrorsHandler.builder().field(STATE).errorMessages("Max length is "+MAX_LENGTH).build());
        }
        if(isMaxLength(employeeReq.getCountry(), MAX_LENGTH)){
            errorsList.add(ErrorsHandler.builder().field(COUNTRY).errorMessages("Max length is "+MAX_LENGTH).build());
        }
        if(isMaxLength(employeeReq.getZipCode(), 10)){
            errorsList.add(ErrorsHandler.builder().field(ZIP_CODE).errorMessages("Max length is "+10).build());
        }
    }
    private void checkRequiredFields(Employee employeeReq, List<ErrorsHandler> errorList){
        if(isEmpty(employeeReq.getFirstName())){
            errorList.add(ErrorsHandler.builder().field(FIRST_NAME).errorMessages(REQUIRED).build());
        }
        if(isEmpty(employeeReq.getLastName())){
            errorList.add(ErrorsHandler.builder().field(LAST_NAME).errorMessages(REQUIRED).build());
        }
        if(isEmpty(employeeReq.getDateOfBirth())){
            errorList.add(ErrorsHandler.builder().field(DATE_OF_BIRTH).errorMessages(REQUIRED).build());
        }
        if(isEmpty(employeeReq.getAddressLine1())){
            errorList.add(ErrorsHandler.builder().field(ADDRESS_LINE_1).errorMessages(REQUIRED).build());
        }
        if(isEmpty(employeeReq.getCity())){
            errorList.add(ErrorsHandler.builder().field(CITY).errorMessages(REQUIRED).build());
        }
        if(isEmpty(employeeReq.getState())){
            errorList.add(ErrorsHandler.builder().field(STATE).errorMessages(REQUIRED).build());
        }
        if(isEmpty(employeeReq.getCountry())){
            errorList.add(ErrorsHandler.builder().field(COUNTRY).errorMessages(REQUIRED).build());
        }
        if(isEmpty(employeeReq.getZipCode())){
            errorList.add(ErrorsHandler.builder().field(ZIP_CODE).errorMessages(REQUIRED).build());
        }
    }
    private boolean isMaxLength(String value, int maxLength){
        return !isEmpty(value) &&  value.length()>maxLength;
    }
    private boolean isEmpty(String value){
        return value == null;
    }



}
