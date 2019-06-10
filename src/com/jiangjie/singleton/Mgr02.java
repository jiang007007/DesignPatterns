package com.jiangjie.singleton;
/**
 * lazy loading
 *  synchronized ÀÁººÄ£Ê½
 * @author jiangjie
 *
 */
public class Mgr02 {
	private static Mgr02 INSTACE ;
	public  static synchronized Mgr02 getInstance() {
			if(INSTACE == null) { 
					INSTACE = new Mgr02();
			}
		return INSTACE;
	}
	private Mgr02() {}
	public static void main(String[] args) {
		for(int i =0; i< 100;i++) {
			new Thread(() ->{
				System.out.println(Mgr02.getInstance().hashCode());
			}).start();
		}
		
//		Person p1 = new Person("aaaa", 11);
//		Person p2 = new Person("aaaa", 11);
//		System.out.println(p1.name.equals(p2.name));
	}
	
}

class Person{
	int age;
	String name;
	public Person(String name, int age) {
		this.age = age;
		this.name = name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + "-" + age;
	}
}