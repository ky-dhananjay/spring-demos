package com.msapp.accounts.service.impl;

import com.msapp.accounts.dto.AccountsDto;
import com.msapp.accounts.dto.CardsDto;
import com.msapp.accounts.dto.CustomerDetailsDto;
import com.msapp.accounts.dto.LoansDto;
import com.msapp.accounts.entity.Accounts;
import com.msapp.accounts.entity.Customer;
import com.msapp.accounts.exception.ResourceNotFoundException;
import com.msapp.accounts.mapper.AccountsMapper;
import com.msapp.accounts.mapper.CustomerMapper;
import com.msapp.accounts.repository.AccountsRepository;
import com.msapp.accounts.repository.CustomerRepository;
import com.msapp.accounts.service.ICustomersService;
import com.msapp.accounts.service.client.CardsFeignClient;
import com.msapp.accounts.service.client.LoansFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomersServiceImpl implements ICustomersService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;

    /**
     * @param mobileNumber - Input Mobile Number
     * @return Customer Details based on a given mobileNumber
     */
    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
            () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
            () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(mobileNumber);
        customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());

        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(mobileNumber);
        customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());

        return customerDetailsDto;

    }
}
