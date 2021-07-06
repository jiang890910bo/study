package com.jiangbo.user;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * 重写类的hashcode和equals方法，放置list是否会去重。
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/02/19
 */
public class ClassEqualList {

	public static void main(String[] args) {
		Set<Person> list = new HashSet<>();

		Person person = new Person();
		person.setAge(1);
		person.setName("cjb");
		list.add(person);
		list.add(person);

		System.out.println(list.size());
	}

	@Data
	static class Person{
		private String name;

		private Integer age;

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof Person)) return false;
			Person person = (Person) o;
			return getName().equals(person.getName()) &&
					getAge().equals(person.getAge());
		}

		@Override
		public int hashCode() {
			return Objects.hash(getName(), getAge());
		}
	}
}
