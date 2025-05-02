package com.msapp.accounts.service;

import com.msapp.accounts.dto.CustomerDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

public interface IAccountsService {
    /**
     *
     * @param customerDto - CustomerDto Object
     */
    void createAccount(CustomerDto customerDto);

    CustomerDto fetchAccount(@Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits") String mobileNumber);

    boolean updateAccount(@Valid CustomerDto customerDto);

    boolean deleteAccount(@Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits") String mobileNumber);
}
