package br.com.zup.orange.controller.validator;


import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.Assert;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueStateCountryNameValidator implements ConstraintValidator<UniqueStateCountryName, Object> {

	private String stateNameAttribute;
	private String countryIdAttribute;
    private Class<?> klass;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(UniqueStateCountryName params) {
        //These atributes are defined in the Interface UniqueStateCountryName
    	stateNameAttribute = params.stateName();
    	countryIdAttribute = params.countryId();
        klass = params.domainClass();
    }

    @Override
    @Transactional
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
   	
    	Query query = entityManager.createQuery(
                "SELECT s FROM " + klass.getName() + " s WHERE " + stateNameAttribute + "=:stateName AND s.country.id =:countryId");

        String stateName = (String) new BeanWrapperImpl(value).getPropertyValue(stateNameAttribute);
        query.setParameter("stateName", stateName);

        Long countryId = (Long) new BeanWrapperImpl(value).getPropertyValue(countryIdAttribute);
        query.setParameter("countryId", countryId);

        List<?> list = query.getResultList();

        if (list.isEmpty()) {
        	return true;    
        }
        
        throw new IllegalArgumentException("State name already exists for this country.");
        
    }


}