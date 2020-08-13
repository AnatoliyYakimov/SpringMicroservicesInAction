package ru.yakimov.licenses.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yakimov.licenses.config.ServiceConfig;
import ru.yakimov.licenses.domain.License;
import ru.yakimov.licenses.repository.LicenseRepository;

import java.util.UUID;
import java.util.List;


@Service
public class LicenseService {

    private final LicenseRepository licenseRepository;

    private final ServiceConfig config;

    @Autowired
    public LicenseService(LicenseRepository licenseRepository, ServiceConfig config) {
        this.licenseRepository = licenseRepository;
        this.config = config;
    }

    public License getLicense(String organizationId, String licenseId) {
        License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
        license.setComment(config.getExampleProperty());
        return license;
    }

    public List<License> getLicensesByOrg(String organizationId){
        return licenseRepository.findByOrganizationId( organizationId );
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
