package ru.yakimov.organization.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import ru.yakimov.organization.model.Organization;

import java.util.Optional;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, String> {
    @NonNull
    Optional<Organization> findById(@NonNull String organizationId);
}
