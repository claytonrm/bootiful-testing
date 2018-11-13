package com.example.bootifultesting;

import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class ReservationTest {

    @Test
    public void creation() {
        final Reservation reservation = new Reservation(1L, "Jane");
        Assert.assertEquals(reservation.getId(), (Long) 1L);
        Assert.assertThat(reservation.getId(), Matchers.equalTo(1L));

        Assertions.assertThat(reservation.getName()).isNotBlank();
        Assertions.assertThat(reservation.getName()).isEqualTo("Jane");
    }

}
