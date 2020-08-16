package ru.yakimov.licenses.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yakimov.licenses.clients.OrganizationClient;
import ru.yakimov.licenses.config.ServiceConfig;
import ru.yakimov.licenses.domain.License;
import ru.yakimov.licenses.repository.LicenseRepository;

import java.util.List;
import java.util.UUID;


@Service
public class LicenseService {

    private final LicenseRepository licenseRepository;

    private final ServiceConfig config;

    private final OrganizationClient organizationClient;


    @Autowired
    public LicenseService(LicenseRepository licenseRepository, ServiceConfig config, OrganizationClient organizationClient) {
        this.licenseRepository = licenseRepository;
        this.config = config;
        this.organizationClient = organizationClient;
    }

    public License getLicense(String organizationId, String licenseId) {
        License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
        license.setComment(config.getExampleProperty());
        license.setOrganization(organizationClient.getOrganization(organizationId));
        return license;
    }

    public List<License> getLicensesByOrg(String organizationId){
        List<License> licenses = licenseRepository.findByOrganizationId( organizationId );
        licenses.forEach(license -> license.setOrganization(organizationClient.getOrganization(license.getOrganizationId())));
        return licenses;
    }

    public void saveLicense(License license){
        license.setLicenseId(UUID.randomUUID().toString());

        licenseRepository.save(license);

    }

    public void updateLicense(License license){
        licenseRepository.save(license);
    }

    public void deleteLicense(License license){
        licenseRepository.delete(license);
    }
}
