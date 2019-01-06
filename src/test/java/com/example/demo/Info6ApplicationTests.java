package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.demo.controller.JobController;
import com.example.demo.model.Job;
import com.example.demo.repository.JobRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Info6Application.class)
@WebAppConfiguration

public class Info6ApplicationTests {
	@Autowired
	JobController controller;
	
	@Autowired
	JobRepository repository;
	
	@Test
	public void testModifyJobTitle() { // test unitaire pour jobtitle
		
		String newName = "newJobName"; // nom pour le nouveau job
		Job job = repository.findAll().iterator().next();  // cherche dans la bdd un job, prend le 1 er trouvé
		job.setJobTitle(newName); // changer le titre du job
		
		controller.modifyJob(job.getJobId(), job); // sauvegarde le changement du titre 
		
		// verify in database le job mis à jour dans la bdd
		Optional<Job> updatedJob = repository.findById(job.getJobId());
		assertTrue(updatedJob.isPresent());
		assertEquals(newName, updatedJob.get().getJobTitle());
	}

}

