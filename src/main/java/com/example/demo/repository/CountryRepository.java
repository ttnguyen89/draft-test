package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Country;


@RepositoryRestResource(collectionResourceRel = "country", path = "country")

@Repository
public interface CountryRepository extends PagingAndSortingRepository<Country, String> {

	List<Country> findByCountryName(@Param("COUNTRY_NAME") String CountryName);

}