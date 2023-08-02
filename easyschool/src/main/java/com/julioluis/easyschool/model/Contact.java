package com.julioluis.easyschool.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@Entity
@Table(name = "contact_msg")
@SqlResultSetMappings({
        @SqlResultSetMapping(name = "SqlResultSetMapping.count", columns = @ColumnResult(name = "cnt"))
})
@NamedQueries({
        @NamedQuery(name = "Contact.findOpenMsgs",query = "SELECT c FROM Contact c WHERE c.status=:status")
})

@NamedNativeQueries({
        @NamedNativeQuery(name = "Contact.findOpenMsgsNative", query = "SELECT * FROM contact_msg c " +
                " where c.status=:status",resultClass = Contact.class),
        @NamedNativeQuery(name = "Contact.findOpenMsgsNative.count",query = "SELECT count(*) as cnt " +
                "FROM contact_msg c where c.status=:status ",
        resultSetMapping = "SqlResultSetMapping.count"),
        @NamedNativeQuery(name = "Contact.updateStatusNative",query = "UPDATE contact_msg c set c.status=?1 " +
                "WHERE c.contact_id=?2")
})
public class Contact extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "contact_id")
    private Integer id;
    @NotBlank(message = "Name must no be blank")
    private String name;
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNum;
    @Email(message = "Provide a valid email address")
    @NotBlank(message = "email must no be blank")
    private String email;
    private String subject;
    private String message;
    private String status;



}
