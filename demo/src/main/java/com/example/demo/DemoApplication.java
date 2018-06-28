package com.example.demo;

import java.util.Date;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import lombok.Data;

@SpringBootApplication
// @Transactional
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CmmnClCodeRepository cmmnClCodeRepository) {
		return (args -> {

			System.out.println("commandLineRunner");

			String id = "EFC";
			// String id = "AAA";
			Optional<CmmnClCode> findById = cmmnClCodeRepository.findById(id);
			CmmnClCode result = findById.orElse(new CmmnClCode());
			System.out.println("result=" + result);
			System.out.println("getClCode=" + result.getClCode());
			System.out.println("getClCodeNm=" + result.getClCodeNm());
			System.out.println("getFrstRegistPnttm=" + result.getFrstRegistPnttm());

		});
	}

	@Bean
	CommandLineRunner commandLineRunner2(CmmnClCodeRepository cmmnClCodeRepository) {
		return (args -> {

			System.out.println("commandLineRunner2");

			CmmnClCode entity = new CmmnClCode();
			entity.setClCode("AAA");
			entity.setClCodeNm("에이 에이 에이");
			entity.setClCodeDc("에이 에이 에이 설명");
			entity.setUseAt("Y");
			entity.setFrstRegistPnttm(new Date());
			entity.setFrstRegisterId("SYSTEM2");
			entity.setLastUpdtPnttm(new Date());
			entity.setLastUpdusrId("SYSTEM2");

			CmmnClCode save = cmmnClCodeRepository.save(entity);

			System.out.println("save=" + save);

		});
	}

	@Bean
	// @Transactional
	CommandLineRunner commandLineRunner3(CmmnClCodeRepository cmmnClCodeRepository) {
		return (args -> {

			System.out.println("commandLineRunner3");

			// String id = "EFC";
			String id = "AAA";
			Optional<CmmnClCode> findById = cmmnClCodeRepository.findById(id);
			CmmnClCode result = findById.orElse(new CmmnClCode());
			result.setLastUpdtPnttm(new Date());
			System.out.println("result=" + result);

		});
	}

	@Bean
	CommandLineRunner commandLineRunner4(CmmnClCodeService cmmnClCodeService) {
		return (args -> {

			System.out.println("commandLineRunner4");

			cmmnClCodeService.update();

		});
	}

}

@Entity
@Table(name = "comtccmmnclcode")
@Data
class CmmnClCode {

	@Id
	private String clCode;
	private String clCodeNm;
	private String clCodeDc;
	private String useAt;
	private Date frstRegistPnttm;
	private String frstRegisterId;
	private Date lastUpdtPnttm;
	private String lastUpdusrId;

}

interface CmmnClCodeRepository extends PagingAndSortingRepository<CmmnClCode, String> {
}

@Service
@Transactional
class CmmnClCodeService {

	@Autowired
	private CmmnClCodeRepository cmmnClCodeRepository;

	void update() {

		// String id = "EFC";
		String id = "AAA";
		Optional<CmmnClCode> findById = cmmnClCodeRepository.findById(id);
		CmmnClCode result = findById.orElse(new CmmnClCode());
		result.setLastUpdtPnttm(new Date());
		System.out.println("result=" + result);

	}

}
