package de.miwoe;

import de.miwoe.model.Campaign;
import de.miwoe.model.Job;
import de.miwoe.model.JobStatus;
import static org.assertj.core.api.Assertions.*;

import de.miwoe.model.JobStatusBi;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class JpatesterApplicationTests {

	@Autowired
	EntityManager entityManager;

	Job job;
	JobStatus jobStatus;
	JobStatusBi jobStatusBi;
	Campaign campaign;
	@Before
	public void init() {
		job = new Job();
		job.setId(UUID.randomUUID().toString());
		job.setName("MyJob");

		jobStatus = new JobStatus();
		jobStatus.setId(UUID.randomUUID().toString());
		jobStatus.setStatusValue("New");
		job.setJobStatus(jobStatus);

		jobStatusBi = new JobStatusBi();
		jobStatusBi.setId(UUID.randomUUID().toString());
		jobStatusBi.setStatusValue("New");
		job.setJobStatusBi(jobStatusBi);

		campaign = new Campaign();
		campaign.setName("MyCampaign");
		campaign.setId(UUID.randomUUID().toString());
		job.setCampaign(campaign);
	}
	@Test
	public void contextLoads() {
	}

	@Test
	public void OneToOneTestCascadeSaveForward() {
		entityManager.persist(job);
		assertThat(entityManager.find(JobStatus.class, jobStatus.getId())).isNotNull();
	}

	@Test
	public void OneToOneTestCascadeSaveBackward() {
		entityManager.persist(jobStatus);
		assertThat(entityManager.find(Job.class, job.getId())).isNull();
	}

	@Test
	public void OneToOneBiTestCascadeSaveForward() {
		entityManager.persist(job);
		assertThat(entityManager.find(JobStatusBi.class, jobStatusBi.getId())).isNotNull();
	}

	@Test
	public void OneToOneBiTestCascadeSaveBackward() {
		entityManager.persist(jobStatusBi);
		assertThat(entityManager.find(Job.class, job.getId())).isNull();
	}

	@Test
	public void OneToOneBiTestCascadeSaveBackwardSetBackReference() {
		jobStatusBi.setJob(job);
		entityManager.persist(jobStatusBi);
		assertThat(entityManager.find(Job.class, job.getId())).isNotNull();
	}

	@Test
	public void OneToOneBiTestCascadeDeleteForward() {
		entityManager.persist(job);
		assertThat(entityManager.find(JobStatus.class, jobStatus.getId())).isNotNull();

		entityManager.remove(job);
		assertThat(entityManager.find(JobStatus.class, jobStatus.getId())).isNull();
	}

	@Test
	public void ManyToOneTestCascadeSave() {
		entityManager.persist(job);
		assertThat(entityManager.find(Campaign.class, campaign.getId())).isNotNull();
	}

	@Test
	public void ManyToOneTestCascadeDelete() {
		entityManager.persist(job);
		assertThat(entityManager.find(Campaign.class, campaign.getId())).isNotNull();

		entityManager.remove(job);
		assertThat(entityManager.find(Campaign.class, campaign.getId())).isNotNull();
	}
}
