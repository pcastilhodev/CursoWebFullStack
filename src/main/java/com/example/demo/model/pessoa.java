package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = "SEQ_PESSOA", sequenceName = "SEQ_PESSOA", allocationSize = 1, initialValue = 1)
public abstract class pessoa implements GrantedAuthority{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PESSOA")
    public Long id;
    @OneToMany(mappedBy = "pessoa", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<endereco> enderecos = new ArrayList<endereco>();

    @Column (nullable = false)
    private String Nome;

    @Column (nullable = false)
    private String EMAIL;

    @Column (nullable = false)
    private String Telefone;

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        pessoa other = (pessoa) obj;
        return Objects.equals(id, other.id);
    }

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}


}