package ru.yakimov.organization.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.yakimov.organization.model.Organization;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, String> {
    Organization findById(String organizationId);
}
