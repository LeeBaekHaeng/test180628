package com.example.demo;

import java.util.Date;
import java.util.List;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import lombok.Data;

@SpringBootApplication
public class Demo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}

	// @Bean
	public CommandLineRunner runner(CmmnClCodeRepository cmmnClCodeRepository) {
		return args -> {
			System.out.println("runner");

			Pageable pageable = PageRequest.of(0, 20);

			Page<CmmnClCode> findAll = cmmnClCodeRepository.findAll(pageable);

			System.out.println("findAll=" + findAll);

			List<CmmnClCode> content = findAll.getContent();

			// for (CmmnClCode cmmnClCode : content) {
			// System.out.println("cmmnClCode=" + cmmnClCode);
			// System.out.println("getClCode=" + cmmnClCode.getClCode());
			// System.out.println("getClCodeNm=" + cmmnClCode.getClCodeNm());
			// }

			content.forEach(cmmnClCode -> {
				System.out.println("cmmnClCode=" + cmmnClCode);
				System.out.println("getClCode=" + cmmnClCode.getClCode());
				System.out.println("getClCodeNm=" + cmmnClCode.getClCodeNm());
			});
		};
	}

	@Bean
	public CommandLineRunner runner2(CmmnClCodeRepository cmmnClCodeRepository) {
		return args -> {
			System.out.println("runner2");

			CmmnClCode entity = new CmmnClCode();
			entity.setClCode("AAB");
			entity.setFrstRegistPnttm(new Date());

			System.out.println("entity=" + entity);

			CmmnClCode save = cmmnClCodeRepository.save(entity);

			System.out.println("save=" + save);

		};
	}

	// @Bean
	public CommandLineRunner runner3(CmmnClCodeRepository cmmnClCodeRepository) {
		return args -> {
			System.out.println("runner3");

			String id = "AAB";

			Optional<CmmnClCode> findById = cmmnClCodeRepository.findById(id);

			System.out.println("findById=" + findById);

			CmmnClCode result = findById.orElse(new CmmnClCode());

			System.out.println("getClCode=" + result.getClCode());
			System.out.println("getFrstRegistPnttm=" + result.getFrstRegistPnttm());

			result.setClCodeNm("에이에이비");
			result.setLastUpdtPnttm(new Date());

			cmmnClCodeRepository.save(result);
		};
	}

	// @Bean
	public CommandLineRunner runner4(CmmnClCodeService cmmnClCodeService) {
		return args -> {
			System.out.println("runner4");

			cmmnClCodeService.update();
		};
	}

	@Bean
	public CommandLineRunner runner5(CmmnClCodeRepository cmmnClCodeRepository) {
		return args -> {
			System.out.println("runner5");

			String id = "AAB";

			cmmnClCodeRepository.deleteById(id);
		};
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

	public void update() {
		String id = "AAB";

		Optional<CmmnClCode> findById = cmmnClCodeRepository.findById(id);

		System.out.println("findById=" + findById);

		CmmnClCode result = findById.orElse(new CmmnClCode());

		System.out.println("getClCode=" + result.getClCode());
		System.out.println("getFrstRegistPnttm=" + result.getFrstRegistPnttm());

		result.setClCodeNm("에이에이비2");
		result.setLastUpdtPnttm(new Date());
	}

}
