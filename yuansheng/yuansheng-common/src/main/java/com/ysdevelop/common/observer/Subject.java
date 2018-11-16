package com.ysdevelop.common.observer;

public interface Subject {

	void addObserver(Observer observer);
	
	void deleteObserver(Observer observer);
	
	void setChange();
	 
	void clearChange();
	
	void notifyObserver(Object arg);
	
	
}
