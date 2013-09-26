package br.ufrn.model.dao;

import org.hibernate.Session;

public class HibernateDAOFactory extends DAOFactory {

	
	private GenericHibernateDAO instantiateDAO(Class daoClass) {
        try {
            GenericHibernateDAO dao = (GenericHibernateDAO)daoClass.newInstance();
            //dao.setSession(getCurrentSession());
            return dao;
        } catch (Exception ex) {
            throw new RuntimeException("Can not instantiate DAO: " + daoClass, ex);
        }
    }
	
	@Override
	public EmpresaDAO getEmpresaDAO() {
		return (EmpresaDAO) instantiateDAO(EmpresaDAOHibernate.class);
	}
	
	@Override
	public PontoOnibusDAO getPontoOnibusDAO() {
		return (PontoOnibusDAO) instantiateDAO(PontoOnibusDaoHibernate.class);
	}

	@Override
	public PontoReferenciaDAO getPontoReferenciaDAO() {
		return (PontoReferenciaDAO) instantiateDAO(PontoRefernciaDaoHibernate.class);
	}

	@Override
	public LinhaDAO getLinhaDAO() {
		return (LinhaDAO) instantiateDAO(LinhaDAOHibernate.class);
		
	}
 
	/*
    // You could override this if you don't want HibernateUtil for lookup
    protected Session getCurrentSession() {
        //return HibernateUtil.getSessionFactory().getCurrentSession();
    	return HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
 	*/
    // Inline concrete DAO implementations with no business-related data access methods.
    // If we use public static nested classes, we can centralize all of them in one source file.
 
}
