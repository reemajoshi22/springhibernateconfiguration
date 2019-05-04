package springhibernateconfiguration;


import org.hibernate.SessionFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public class PhoneDao_spring {
	// HibernateTemplate hibernateTemplate;
	SessionFactory sessionFactory;
	PhoneDao_spring phoneDao_spring;
	HibernateTransactionManager hibernateTransactionManager;

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"HibernateSpringContext.xml");

		PhoneDao_spring phoneDao_spring = (PhoneDao_spring) context
				.getBean("phoneDao");
		phoneDao_spring.insertData();

	}

	private Phone updateData() {
		Phone phone = new Phone();
		phone.setPhone_id(400);// comment this line if we are using generaor
		// other than assigned cz this will be a detached entity
		phone.setSim_slots("8");
		phone.setPhone_model("nokia10");

		OS os = new OS();
		os.setOs_id(7);
		os.setOs_name("android");
		phone.setOs(os);

		Manufacturer manufacturer = new Manufacturer();
		manufacturer.setManufacturer_id(7);
		manufacturer.setManufacturername("nokia");
		manufacturer.setCountry("india");
		phone.setManufacturer(manufacturer);
		sessionFactory.getCurrentSession().update(phone);

		return phone;

	}

	private Phone insertData() {
		Phone phone = new Phone();
		phone.setPhone_id(404);// comment this line if we are using generaor
		// other than assigned cz this will be a detached entity
		phone.setSim_slots("5");
		phone.setPhone_model("nokia11");

		OS os = new OS();
		os.setOs_id(9);
		os.setOs_name("android");
		phone.setOs(os);

		Manufacturer manufacturer = new Manufacturer();
		manufacturer.setManufacturer_id(10);
		manufacturer.setManufacturername("nokia");
		manufacturer.setCountry("india");
		phone.setManufacturer(manufacturer);
		sessionFactory.getCurrentSession().save(phone);

		return phone;

	}

	/*
	 * public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	 * this.hibernateTemplate = hibernateTemplate; }
	 */public PhoneDao_spring getPhoneDao_spring() {
		return phoneDao_spring;
	}

	public void setPhoneDao_spring(PhoneDao_spring phoneDao_spring) {
		this.phoneDao_spring = phoneDao_spring;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void setHibernateTransactionManager(
			HibernateTransactionManager hibernateTransactionManager) {
		this.hibernateTransactionManager = hibernateTransactionManager;
	}

	public HibernateTransactionManager getHibernateTransactionManager() {
		return hibernateTransactionManager;
	}

}
