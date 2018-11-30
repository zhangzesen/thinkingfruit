package com.thinkingFruit.client.helper;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import com.thinkingFruit.client.entity.Agent;


/**
 * @author zhangzesen
 *
 * @date 2018年11月30日
 *
 * @package com.thinkingFruit.client.helper
 *
 * @description 密码的加密
 */
public class PasswordAgentHelper {

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

    public  void encryptPassword(Agent agent) {

    	agent.setSalt(randomNumberGenerator.nextBytes().toHex());

        String newPassword = new SimpleHash(algorithmName, agent.getPswd(), ByteSource.Util.bytes(agent
                .getSalt()), hashIterations).toHex();

        agent.setPswd(newPassword);
        System.out.println(agent.getSalt()+"    "+agent.getPswd());
    }
    
    public boolean checkPassword(Agent agent,String password) {
        String newPassword = new SimpleHash(algorithmName, password, ByteSource.Util.bytes(agent
                .getSalt()), hashIterations).toHex();
        return newPassword.equals(agent.getPswd());
    }

    
    public static void main(String[] args) {
    	Agent agent = new Agent();
    	agent.setLoginName("老黄");
    	agent.setPswd("123456");
		new PasswordAgentHelper().encryptPassword(agent);
	}
	
	
}
