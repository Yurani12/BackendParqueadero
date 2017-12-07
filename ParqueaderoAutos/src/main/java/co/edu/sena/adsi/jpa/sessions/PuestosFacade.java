/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.jpa.sessions;

import co.edu.sena.adsi.jpa.entities.Carro;
import co.edu.sena.adsi.jpa.entities.Puestos;
import co.edu.sena.adsi.jpa.entities.Puestos_;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

/**
 *
 * @author adsi1261718
 */
@Stateless
public class PuestosFacade extends AbstractFacade<Puestos> {

    @PersistenceContext(unitName = "co.edu.sena.adsi.jpa.entities_ParqueaderoAutos_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PuestosFacade() {
        super(Puestos.class);
    }

    public Long contarPuestosDisponibles() {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder(); //primero crear objeto criteria builder 'cb'
        CriteriaQuery<Long> cq = cb.createQuery(Long.class); //Segundo crear objeto criteria query 'cq'
        Root<Puestos> puesto = cq.from(Puestos.class); //Tercero crear objeto Root de la entidad a realizar la consulta 'cb'

        cq.select(cb.count(cq.from(Puestos.class)));
        //cq.where(puesto.get(Puestos_.idCarro)); //Cuarto Realizar la consulta 
        
        TypedQuery<Long> tq = em.createQuery(cq); // Quinto Crear un objeto TypedQuery 'tq' que obtiene la consulta y se retornara
        
        try {
            return tq.getSingleResult();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException e) {
            return null;
        }
    }
}
