package br.inf.ufes.pp2016_01;




/**
 * Master.java
 */


import java.rmi.Remote;

public interface Master extends Remote, SlaveManager, Attacker {
	// o mestre é um SlaveManager e um Attacker
}
