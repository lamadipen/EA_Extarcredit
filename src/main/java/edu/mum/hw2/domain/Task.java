package edu.mum.hw2.domain;

import java.util.*;

import javax.persistence.*;

@Entity
public class Task {
		@Id @GeneratedValue
		private int task_id;
		private String name;
		private String duration;
		private String status;
		
		@ManyToOne
		@JoinColumn(name="user_id")
		private User user;
		
		public int getTask_id() {
			return task_id;
		}
		public void setTask_id(int task_id) {
			this.task_id = task_id;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDuration() {
			return duration;
		}
		public void setDuration(String duration) {
			this.duration = duration;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
}
