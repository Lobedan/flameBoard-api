package de.flameboard.api.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by Sven on 08.11.2014.
 */
@MappedSuperclass
public class AbstractEntity {

  @Id
  @GeneratedValue
  protected Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long aId) {
    this.id = aId;
  }

  @JsonIgnore
  public Object getBusinessKey() {
    return getId();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    AbstractEntity that = (AbstractEntity) o;

    if (id != null ? !id.equals(that.id) : that.id != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .toString();
  }
}
