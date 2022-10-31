package com.company.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class BaseEntity {
    @Id
    protected long id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity baseEntity = (BaseEntity) o;
        return id == baseEntity.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
