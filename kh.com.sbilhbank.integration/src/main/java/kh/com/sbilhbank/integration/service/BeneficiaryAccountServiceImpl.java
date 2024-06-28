package kh.com.sbilhbank.integration.service;

import kh.com.sbilhbank.integration.error.RestClientCustomException;
import kh.com.sbilhbank.integration.model.BeneficiaryAccountResponse;
import kh.com.sbilhbank.integration.model.BeneficiaryPrimaryAccount;
import kh.com.sbilhbank.integration.model.BeneficiaryPrimaryAccountResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class BeneficiaryAccountServiceImpl implements BeneficiaryAccountService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${ENDPOINT_URL.BENEFICIAL_ACCOUNT}")
    private String beneficialAccountEndpointUrl;

    @Value("${ENDPOINT_URL.BENEFICIAL_PRIMARY_ACCOUNT}")
    private String beneficialPrimaryAccountEndpointUrl;

    @Override
    public BeneficiaryAccountResponse getBeneficiaryAccountByAccountNo(String accountNo) throws RestClientCustomException {
        try {
            return restTemplate.getForObject(this.beneficialAccountEndpointUrl + accountNo, BeneficiaryAccountResponse.class);
        } catch (Exception exception) {
            log.error("error: getBeneficiaryAccountByAccountNo(); message: ", exception);
            throw new RestClientCustomException(exception);
        }
    }

    @Override
    public BeneficiaryPrimaryAccountResponse getBeneficiaryPrimaryAccountByPhoneNumber(Long phoneNumber) throws RestClientCustomException {
        try {
            BeneficiaryPrimaryAccountResponse response = restTemplate.getForObject(
                this.beneficialPrimaryAccountEndpointUrl + phoneNumber, BeneficiaryPrimaryAccountResponse.class);
                if (response != null) {
                    BeneficiaryPrimaryAccount beneficiaryPrimaryAccount = response.getBody().stream()
                        .filter(primaryAccount -> primaryAccount.getPrimaryAccount().equalsIgnoreCase("YES"))
                        .findFirst()
                        .orElse(null);
                    response.setBody(beneficiaryPrimaryAccount != null ? List.of(beneficiaryPrimaryAccount) : Collections.emptyList());
                }
                return response;
        } catch (RestClientException exception) {
            log.error("error: getBeneficiaryPrimaryAccountByPhoneNumber(); message: ", exception);
            throw new RestClientCustomException(exception);
        }
    }
}