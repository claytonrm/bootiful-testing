package com.example.bootifultesting;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ReservationRespositoryTest {

    @Autowired
    private ReservationRepository repository;

    @Test
    public void findByName() {
        this.repository.save(new Reservation(null, "Jane"));

        final Collection<Reservation> reservations = this.repository.findByName("Jane");

        assertThat(reservations.size()).isEqualTo(1);
        assertThat(reservations.iterator().next().getId()).isGreaterThan(0);
        assertThat(reservations.iterator().next().getName()).isEqualTo("Jane");

    }
}
