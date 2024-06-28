package kh.com.sbilhbank.integration.controller;

import kh.com.sbilhbank.integration.error.RestClientCustomException;
import kh.com.sbilhbank.integration.model.BeneficiaryAccountResponse;
import kh.com.sbilhbank.integration.model.BeneficiaryPrimaryAccountResponse;
import kh.com.sbilhbank.integration.service.BeneficiaryAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/integration/cbs/api/v1.0.0")
public class IntegrationServiceController {

    @Autowired
    private BeneficiaryAccountService beneficiaryAccountService;

    @GetMapping("/account/beneficiary/by-account/{accountNo}")
    public BeneficiaryAccountResponse getBeneficiaryAccountByAccountNo(@PathVariable String accountNo)
        throws RestClientCustomException {
        return beneficiaryAccountService.getBeneficiaryAccountByAccountNo(accountNo);
    }

    @GetMapping("/account/beneficiary/by-phone/{phoneNumber}")
    public BeneficiaryPrimaryAccountResponse getBeneficiaryPrimaryAccountByPhoneNumber(@PathVariable Long phoneNumber)
        throws RestClientCustomException {
        return beneficiaryAccountService.getBeneficiaryPrimaryAccountByPhoneNumber(phoneNumber);
    }
}
