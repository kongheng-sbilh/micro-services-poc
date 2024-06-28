package kh.com.sbilhbank.integration.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BeneficiaryPrimaryAccount {
    private String branchId;
    private String accountName;
    private String category;
    private String primaryAccount;
    private String accountId;
    private String currency;
    private String accountType;
    private String accountStatus;
}
