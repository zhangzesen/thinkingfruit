package com.thinkingFruit.admin.helper;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import com.thinkingFruit.admin.entity.Member;

public class PasswordHelper {

	private static RandomNumberGenerator randomNumberGenerator =new SecureRandomNumberGenerator();
	
	private static String algorithmName = "md5";
	
	private static int hashIterations = 2;
	
	public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        PasswordHelper.randomNumberGenerator = randomNumberGenerator;
    }

    public void setAlgorithmName(String algorithmName) {
        PasswordHelper.algorithmName = algorithmName;
    }

    public void setHashIterations(int hashIterations) {
        PasswordHelper.hashIterations = hashIterations;
    }

    public static  void encryptPassword(Member member) {

        member.setSalt(randomNumberGenerator.nextBytes().toHex());

        String newPassword = new SimpleHash(algorithmName, member.getPswd(), ByteSource.Util.bytes(member
                .getSalt()), hashIterations).toHex();

        member.setPswd(newPassword);
        System.out.println(member.getSalt()+"    "+member.getPswd());
    }
    
    public boolean checkPassword(Member merber,String password) {
        String newPassword = new SimpleHash(algorithmName, password, ByteSource.Util.bytes(merber
                .getSalt()), hashIterations).toHex();
        return newPassword.equals(merber.getPswd());
    }
}
