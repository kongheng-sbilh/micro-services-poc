package kh.com.sbilhbank.integration.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class BeneficiaryAccountResponse {
    private Header header;
    private List<BeneficiaryAccount> body;
}