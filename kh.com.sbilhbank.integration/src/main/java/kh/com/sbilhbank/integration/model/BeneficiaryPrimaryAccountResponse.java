package kh.com.sbilhbank.integration.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BeneficiaryPrimaryAccountResponse {
    private Header header;
    private List<BeneficiaryPrimaryAccount> body;
}
