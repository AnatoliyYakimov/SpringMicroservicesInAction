package ru.yakimov.licenses.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.yakimov.licenses.models.Organization;

import javax.persistence.*;


@Data
@Entity
@AllArgsConstructor
@Table(name = "license")
@NoArgsConstructor(force = true)
@Builder(setterPrefix = "with", builderClassName = "Builder")
public class License {

    @Id
    @Column(name = "license_id", nullable = false)
    private String licenseId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "license_type", nullable = false)
    private String licenseType;

    @Column(name = "organization_id", nullable = false)
    private String organizationId;

    @Column(name = "license_max", nullable = false)
    private Integer licenseMax;

    @Column(name = "license_allocated", nullable = false)
    private Integer licenseAllocated;

    @Column(name = "comment")
    private String comment;

    @Transient
    private Organization organization;
}

