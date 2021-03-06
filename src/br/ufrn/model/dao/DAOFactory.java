package br.ufrn.model.dao;

public abstract class DAOFactory {

    /**
     * Creates a standalone DAOFactory that returns unmanaged DAO
     * beans for use in any environment Hibernate has been configured
     * for. Uses HibernateUtil/SessionFactory and Hibernate context
     * propagation (CurrentSessionContext), thread-bound or transaction-bound,
     * and transaction scoped.
     */
   // public static final Class HIBERNATE = org.hibernate.ce.auction.dao.hibernate.HibernateDAOFactory.class;
 
    /**
     * Factory method for instantiation of concrete factories.
     */
    public static DAOFactory instance(Class factory) {
        try {
            return (DAOFactory)factory.newInstance();
        } catch (Exception ex) {
            throw new RuntimeException("Couldn't create DAOFactory: " + factory);
        }
    }
 
    // Add your DAO interfaces here
    public abstract EmpresaDAO getEmpresaDAO();
    
    public abstract PontoOnibusDAO getPontoOnibusDAO();
    
    public abstract PontoReferenciaDAO getPontoReferenciaDAO();
    
    public abstract LinhaDAO getLinhaDAO();
}
