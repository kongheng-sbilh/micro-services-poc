package kh.com.sbilhbank.integration.service;

import kh.com.sbilhbank.integration.error.RestClientCustomException;
import kh.com.sbilhbank.integration.model.BeneficiaryAccountResponse;
import kh.com.sbilhbank.integration.model.BeneficiaryPrimaryAccountResponse;

public interface BeneficiaryAccountService {

    BeneficiaryAccountResponse getBeneficiaryAccountByAccountNo(String accountNo) throws RestClientCustomException;

    BeneficiaryPrimaryAccountResponse getBeneficiaryPrimaryAccountByPhoneNumber(Long phoneNumber) throws RestClientCustomException;

}