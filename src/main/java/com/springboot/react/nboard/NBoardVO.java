package com.springboot.react.nboard;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity									
@Table(name = "NBoardTABLE") // 테이블의 이름을 설정 (SPRINGBOOT_CRUD)
@Data								
public class NBoardVO {

	@Id	// PK 설정
	@GeneratedValue
	@Column(name = "BNum")	// @Column : 컬럼의 이름을 설정 (ARTICLE_ID)
	private int BNum;
	
	@Column(name = "Btitle")
	private String Btitle;
	
	@Column(name = "Btext")
	private String Btext;
	
	@CreationTimestamp
	@Column(columnDefinition = "date default sysdate", name = "BregDate")
    @Temporal(TemporalType.TIMESTAMP)
	private Date BregDate;
	
}