package com.example.library.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "usertype")
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userId;
	@Column(name="usertype", insertable = false,updatable = false )
	private String usertype;
	private String username;
	private String password;
	private String pinCode;
	private String name;
	private String surname;
	private String email;
	private String phone;
	private LocalDate registeredDate = LocalDate.now();
	private int borrowedBookNum;
	@OneToMany(mappedBy="user")
	private List<Borrow> borrows;
	@OneToMany
	private List<Reservation> reservations;
	
	@OneToMany(mappedBy="user")
	private List<Reservation> reservations;
}
