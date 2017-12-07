/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.jpa.sessions;

import co.edu.sena.adsi.jpa.entities.Carro;
import co.edu.sena.adsi.jpa.entities.Carro_;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author adsi1261718
 */
@Stateless
public class CarroFacade extends AbstractFacade<Carro> {

    @PersistenceContext(unitName = "co.edu.sena.adsi.jpa.entities_ParqueaderoAutos_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CarroFacade() {
        super(Carro.class);
    }
    
    public Carro findByPlaca(String placa) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Carro> cq = cb.createQuery(Carro.class);
        Root<Carro> tercero = cq.from(Carro.class);

        cq.where(cb.equal(tercero.get(Carro_.placa), placa));
        TypedQuery<Carro> tq = getEntityManager().createQuery(cq);

        try {
            return (Carro) tq.getSingleResult();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException e) {
            return null;
        }
    }
    
}
