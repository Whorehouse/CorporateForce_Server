
package org.corporateforce.server.webservices.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.7.13
 * Sun Dec 28 17:51:58 BRT 2014
 * Generated source version: 2.7.13
 */

@XmlRootElement(name = "editUsers", namespace = "http://webservices.server.corporateforce.org/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "editUsers", namespace = "http://webservices.server.corporateforce.org/")

public class EditUsers {

    @XmlElement(name = "entity")
    private org.corporateforce.server.model.Users entity;

    public org.corporateforce.server.model.Users getEntity() {
        return this.entity;
    }

    public void setEntity(org.corporateforce.server.model.Users newEntity)  {
        this.entity = newEntity;
    }

}

