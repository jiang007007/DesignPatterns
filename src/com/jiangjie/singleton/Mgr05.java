package com.jiangjie.singleton;

/**
 *  枚举
 *    不仅解决线程同步  还可以防止返序列化
 * @author jiangjie
 *
 */
public enum Mgr05 {
	INSTANCE;
	public static void main(String[] args) {
		for(int i =0;i< 100; i++) {
			new Thread(
					()->{
						System.out.println(Mgr05.INSTANCE.hashCode());
					}
					).start();
		}
	}
}
