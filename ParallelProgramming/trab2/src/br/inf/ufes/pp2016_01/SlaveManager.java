package br.inf.ufes.pp2016_01;



/**
 * SlaveManager.java
 */
import java.rmi.Remote;

public interface SlaveManager extends Remote {

    /**
     * Registra escravo no mestre. Deve ser chamada a cada 30s por um escravo
     * para se re-registrar.
     *
     * @param s referência para o escravo
     * @param slavename identificador para o escravo
     * @return chave que identifica o escravo para posterior remoção
     * @throws java.rmi.RemoteException
     */
    public int addSlave(Slave s, String slavename)
            throws java.rmi.RemoteException;

    /**
     * Desegistra escravo no mestre.
     *
     * @param slaveKey chave que identifica o escravo
     * @throws java.rmi.RemoteException
     */
    public void removeSlave(int slaveKey)
            throws java.rmi.RemoteException;

    /**
     * Indica para o mestre que o escravo achou uma chave candidata.
     *
     * @param currentindex índice da chave candidata no dicionário
     * @param currentguess chute que inclui chave candidata e mensagem
     * decriptografada com a chave candidata
     * @throws java.rmi.RemoteException
     */
    public void foundGuess(long currentindex,
            Guess currentguess)
            throws java.rmi.RemoteException;

    /**
     * Chamado por cada escravo a cada 10s durante ataque para indicar progresso
     * no ataque, e ao final do ataque.
     *
     * @param currentindex índice da chave já verificada
     * @throws java.rmi.RemoteException
     */
    public void checkpoint(long currentindex)
            throws java.rmi.RemoteException;
}
