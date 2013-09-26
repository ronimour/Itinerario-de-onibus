package br.ufrn.model.dao;

public class CreateSchema extends GenericHibernateDAO<Object, Long>{
	public static void main(String[] args){
		new CreateSchema().createSchema();
	}
	
	
	public void createSchema(){
		getInstance().getTransaction().begin();
		getInstance().getTransaction().commit();
	}
}
