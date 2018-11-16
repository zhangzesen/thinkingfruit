package com.ysdevelop.shiro.core.helper;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import com.ysdevelop.shiro.entity.User;

public class PasswordHelper {

	private RandomNumberGenerator randomNumberGenerator =new SecureRandomNumberGenerator();
	
	private String algorithmName = "md5";
	
	private int hashIterations = 2;
	
	public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }

    public  void encryptPassword(User user) {

        user.setSalt(randomNumberGenerator.nextBytes().toHex());

        String newPassword = new SimpleHash(algorithmName, user.getPswd(), ByteSource.Util.bytes(user
                .getSalt()), hashIterations).toHex();

        user.setPswd(newPassword);
        System.out.println(user.getSalt()+"    "+user.getPswd());
    }
    
    public boolean checkPassword(User user,String password) {
        String newPassword = new SimpleHash(algorithmName, password, ByteSource.Util.bytes(user
                .getSalt()), hashIterations).toHex();
        return newPassword.equals(user.getPswd());
    }

    
    public static void main(String[] args) {
		User user = new User();
		user.setLoginName("老黄");
		user.setPswd("123456");
		new PasswordHelper().encryptPassword(user);
	}
	
	
}
