package ru.yakimov.licenses.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.yakimov.licenses.models.Organization;

@FeignClient("organizationservice")
public interface OrganizationClient {
    @RequestMapping(value = "/v1/organizations/{organizationId}",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    Organization getOrganization(@PathVariable("organizationId") String organizationId);
}
