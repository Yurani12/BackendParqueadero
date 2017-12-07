package co.edu.sena.adsi.jpa.entities;

import co.edu.sena.adsi.jpa.entities.Carro;
import co.edu.sena.adsi.jpa.entities.Parqueadero;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-07T06:08:47")
@StaticMetamodel(Puestos.class)
public class Puestos_ { 

    public static volatile SingularAttribute<Puestos, Parqueadero> idParqueadero;
    public static volatile SingularAttribute<Puestos, Boolean> estado;
    public static volatile SingularAttribute<Puestos, Carro> idCarro;
    public static volatile SingularAttribute<Puestos, String> numeroPuesto;
    public static volatile SingularAttribute<Puestos, Integer> id;

}