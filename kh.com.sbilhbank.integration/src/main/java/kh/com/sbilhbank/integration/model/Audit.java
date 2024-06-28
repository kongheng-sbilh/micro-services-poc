package kh.com.sbilhbank.integration.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Audit {
    private int T24_time;
    private int responseParse_time;
    private int requestParse_time;
}
