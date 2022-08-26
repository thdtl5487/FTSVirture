package com.springboot.react.security.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.sun.istack.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@SequenceGenerator(
        name="IDX_SEQ_GEN",		// 시퀀스 생성기의 이름을 지정
        sequenceName="IDX_SEQ",	// 시퀀스의 이름을 지정 (IDX_SEQ)
        initialValue=1,			// 시퀀스의 초기값을 설정
        allocationSize=1		// 시퀀스의 증가량을 설정
        )


@Getter
@Setter
@Entity
@Table(name = "User_Table")

public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,	// 시퀀스 생성기를 통해 시퀀스를 만들고 ID에 자동으로 주입
	generator = "IDX_SEQ_GEN")
	private int num; 
	private String userid; 
	private String userpw;
	private String useremail;
	private String role;

	@CreationTimestamp
	private Timestamp createDate;
}
