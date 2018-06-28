package com.example.demo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import lombok.Data;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
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

// @RepositoryRestResource
interface CmmnClCodeRepository extends JpaRepository<CmmnClCode, String> {
}

@Entity
@Table(name = "comtccmmncode")
@Data
class CmmnCode {

	@Id
	private String codeId;
	private String codeIdNm;
	private String codeIdDc;
	private String useAt;
	private String clCode;
	private Date frstRegistPnttm;
	private String frstRegisterId;
	private Date lastUpdtPnttm;
	private String lastUpdusrId;

}

// @RepositoryRestResource
interface CmmnCodeRepository extends PagingAndSortingRepository<CmmnCode, String> {
}

// @id @embeddedid @idclass
// https://www.objectdb.com/java/jpa/entity/id

@SuppressWarnings("serial")
@Data
class CmmnDetailCodeId implements Serializable {
	private String codeId;
	private String code;
}

@Entity
@Table(name = "comtccmmndetailcode")
@IdClass(CmmnDetailCodeId.class)
@Data
class CmmnDetailCode {

	@Id
	private String codeId;
	@Id
	private String code;
	private String codeNm;
	private String codeDc;
	private String useAt;
	private String frstRegistPnttm;
	private String frstRegisterId;
	private String lastUpdtPnttm;
	private String lastUpdusrId;

}

@RepositoryRestResource
interface CmmnDetailCodeRepository extends PagingAndSortingRepository<CmmnDetailCode, CmmnDetailCodeId> {
}

// @RestController
// @RequestMapping("/cmmn-cl-codes")
// class CmmnClCodeRestController {
//
// @GetMapping
// public void get() {
// }
//
// @PostMapping
// public void update() {
// }
//
// }
