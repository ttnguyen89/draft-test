package com.example.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Job;



@RepositoryRestResource(collectionResourceRel = "job", path = "job")

@Repository
public interface JobRepository extends PagingAndSortingRepository<Job, String> {

}