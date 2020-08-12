package ru.yakimov.licenses.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yakimov.licenses.domain.License;

@RestController
@RequestMapping("v1/organizations/{organizationId}/licenses")
public class LicenseServiceController {
    @GetMapping("/{licenseId}")
    public License getLicenses(@PathVariable("organizationId") String organizationId,
                               @PathVariable("licenseId") String licenseId) {
        return License.builder()
                .withId(licenseId)
                .withLicenseType("lifetime")
                .withOrganizationId(organizationId)
                .withProductName("Intellij IDEA")
                .build();
    }
}
