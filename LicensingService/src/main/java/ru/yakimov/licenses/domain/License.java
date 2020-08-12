package ru.yakimov.licenses.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "with", builderClassName = "Builder")
public class License {
    private String id;
    private String productName;
    private String licenseType;
    private String organizationId;
}
