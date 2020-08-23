package ru.yakimov.organization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yakimov.organization.model.Organization;
import ru.yakimov.organization.repository.OrganizationRepository;

import java.util.UUID;

@Service
public class OrganizationService {

    private final OrganizationRepository orgRepository;

    @Autowired
    public OrganizationService(OrganizationRepository orgRepository) {
        this.orgRepository = orgRepository;
    }

    public Organization getOrg(String organizationId) {
        return orgRepository.findById(organizationId).orElseThrow();
    }

    public void saveOrg(Organization org){
        org.setId( UUID.randomUUID().toString());

        orgRepository.save(org);

    }

    public void updateOrg(Organization org){
        orgRepository.save(org);
    }

    public void deleteOrg(Organization org){
        orgRepository.delete(org);
    }
}