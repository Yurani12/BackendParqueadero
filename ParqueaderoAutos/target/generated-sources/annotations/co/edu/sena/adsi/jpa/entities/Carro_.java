package co.edu.sena.adsi.jpa.entities;

import co.edu.sena.adsi.jpa.entities.Puesto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-06T11:48:19")
@StaticMetamodel(Carro.class)
public class Carro_ { 

    public static volatile ListAttribute<Carro, Puesto> puestoList;
    public static volatile SingularAttribute<Carro, Date> horaLlegada;
    public static volatile SingularAttribute<Carro, Integer> id;
    public static volatile SingularAttribute<Carro, String> placa;

}