package kh.com.sbilhbank.integration.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Header {
    private Audit audit;
    private int page_start;
    private String page_token;
    private int total_size;
    private int page_size;
    private String status;
}