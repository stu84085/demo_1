package com.example.collection;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Document(collection = "demotable")
public class DemoTable implements Serializable{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@Id
	    private String id;
	    @Field("name")
	    private String name;
	    @Field("email")
	    private String email;
	    @Field("count")
	    private Integer count;
		@Override
		public String toString() {
			return "DemoTable [id=" + id + ", name=" + name + ", email=" + email + ", count=" + count + "]";
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public Integer getCount() {
			return count;
		}
		public void setCount(Integer count) {
			this.count = count;
		}
	    
	    
}
