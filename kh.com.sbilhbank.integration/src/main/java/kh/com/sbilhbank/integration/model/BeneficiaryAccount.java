package kh.com.sbilhbank.integration.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BeneficiaryAccount {
    private String branchId;
    private String accountName;
    private String categoryCode;
    private String primaryAccount;
    private String accountId;
    private String customerId;
    private String currency;
    private String depositType;
    private String status;
}
