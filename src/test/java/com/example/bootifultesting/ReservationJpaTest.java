package com.example.bootifultesting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ReservationJpaTest {

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void mapping() {
        final Reservation jane = this.entityManager.persistAndFlush(new Reservation(null, "Jane"));

        assertThat(jane.getId()).isNotNull();
        assertThat(jane.getId()).isGreaterThan(0);
        assertThat(jane.getName()).isEqualTo("Jane");
    }

}
